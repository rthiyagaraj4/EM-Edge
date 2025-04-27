package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import webbeans.eCommon.ConnectionManager;

public final class __populatesmartcard extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/populateSmartCard.jsp", 1742365919873L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!-- Latest Modified Date : 10/1/2005 4:36 PM -->\n";
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

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\'javascript\' src=\'../../eMP/js/checkNationality.js\'></script>\n   \n  \n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t<script>\n\t\t\t\tvar Calledfrom=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\';\n\t\t\t\tvar inst=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\';\n\t\t\t\tvar function_name=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\';\n\t\t\t\tvar modal_yn=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\';\n\t\t\t\tvar caller_form=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\';\n\t\t\t\tvar from_OA=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\';\n\t\t\t\tvar father_yn=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\';\n\t\t\t\tvar mother_yn=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\';\n\t\t\t\tvar father_relation_desc=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\';\n\t\t\t\tvar mother_relation_desc=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\';\n\t\t\t\tvar birth_cert_no=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\';\n\n\t\t\t\tif(caller_form==\'00\'){\n\n\t\t\t\t\tif(inst==\'NC\'){\n\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].nationality_desc.value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\";\n\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].nationality_code.value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\";\t\t\t\t\t\n\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].race_desc.value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\";\n\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].race_code.value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\";\t\n\t\t\t\t\t\t\n\t\t\t\t\t\tif(Calledfrom ==\'P\' || Calledfrom==\'R\'){\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].r_country_desc.value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\";\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].r_country_code.value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\";\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\tif(inst==\'IC\'){\n\t\t\t\t\t\tif(function_name==\'REFERRAL\' ){\n\t\t\t\t\t\t\tparent.frames[1].frames[0].document.forms[0].nationality_desc.value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\";\n\t\t\t\t\t\t\tparent.frames[1].frames[0].document.forms[0].nationality_desc1.value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\";\n\t\t\t\t\t\t\tparent.frames[1].frames[0].document.forms[0].nationality_code1.value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\";\t\t\t\t\t\n\t\t\t\t\t\t\tparent.frames[1].frames[0].document.forms[0].race_desc.value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\";\n\t\t\t\t\t\t\tparent.frames[1].frames[0].document.forms[0].race_code.value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\";\n\t\t\t\t\t\t}\n\t\t\t\t\t\tif(function_name==\'BOOK_APPT\'){\n\n\t\t\t\t\t\t\tparent.parent.frames[0].document.forms[0].nationality_desc.value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\";\n\t\t\t\t\t\t\tparent.parent.frames[0].document.forms[0].nationality_desc1.value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\";\n\t\t\t\t\t\t\tparent.parent.frames[0].document.forms[0].nationality_code1.value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\";\t\t\t\t\t\n\t\t\t\t\t\t\tparent.parent.frames[0].document.forms[0].race_desc.value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\";\n\t\t\t\t\t\t\tparent.parent.frames[0].document.forms[0].race_code.value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\";\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\tif( function_name==\'WAIT_LIST\'){\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].nationality_desc.value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\";\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].nationality_desc1.value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\";\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].nationality_code1.value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\";\t\t\t\t\t\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].race_desc.value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\";\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].race_code.value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\";\n\t\t\t\t\t\t}\n\t\t\t\t\t\t\n\t\t\t\t\t}\n\n\t\t\t\t\tif(inst==\'SR\'){\n\t\t\t\t\t\tif(function_name==\'INV\' ){\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].nationality_desc.value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\";\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].nationality_id.value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\";\t\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t}\n\t\t\t\t\t\tif(function_name==\'APP\' ){\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].nationality_iddesc.value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\";\t\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\tif(function_name==\'MGWLST\' ){\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].nationality_desc.value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\";\n\t\t\t\t\t\t\t//parent.frames[1].document.forms[0].nationality_id.value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\";\t\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t}\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t}\n\n\t\t\t\t\tif(inst==\'PS\'){\n\t\t\t\t\t\tparent.parent.Pat_Search_Criteria_Frame.document.forms[0].nationality_desc.value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\";\n\t\t\t\t\t\tparent.parent.Pat_Search_Criteria_Frame.document.forms[0].nationality_desc_hid.value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\";\n\t\t\t\t\t\tparent.parent.Pat_Search_Criteria_Frame.document.forms[0].Nationality_hid.value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\";\t\t\t\t\t\n\t\t\t\t\t\tparent.parent.Pat_Search_Criteria_Frame.document.forms[0].ethnic_group_desc.value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\";\n\t\t\t\t\t\tparent.parent.Pat_Search_Criteria_Frame.document.forms[0].ethnic_group_desc_hid.value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\";\n\t\t\t\t\t\tparent.parent.Pat_Search_Criteria_Frame.document.forms[0].ethnic_group_hid.value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\";\t\n\t\t\t\t\t}\n\n\t\t\t\t\t\n\t\t\t\t\tif(function_name==\'BOOK_APPT\'){\n\t\t\t\t\t\tparent.parent.frames[3].location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t}else if(function_name==\'MGWLST\'){\n\t\t\t\t\t\t\n\t\t\t\t\t\tparent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t}else if(function_name==\'PS\'){\n\t\t\t\t\t\tparent.frames[6].location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t}else{\t\n\t\t\t\t\t\tif(function_name==\"WAIT_LIST\" && modal_yn==\"Y\"){\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tparent.frames[2].location.href=\"../../eCommon/jsp/Dummy.jsp\";\n\t\t\t\t\t\t}else{\t\t\t\t\t\t\n\t\t\t\t\t\t\tparent.frames[2].location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}else if (caller_form==\'01\'){\n\t\t\t\t\tif(inst==\'NC\'){\n\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].nationality_desc.value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\";\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\tif(Calledfrom ==\'P\' || Calledfrom==\'R\'){\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].r_country_desc.value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\";\n\t\t\t\t\t\t}\n\t\t\t\t\t\tparent.frames[2].location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t}else if(inst==\'PS\'){\n\t\t\t\t\t\tparent.parent.Pat_Search_Criteria_Frame.document.forms[0].nationality_desc.value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\";\n\t\t\t\t\t\tparent.parent.frames[5].location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t}\t\n\t\t\t\t\tif(function_name==\'BOOK_APPT\'){\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].nationality_desc.value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\";\n\t\t\t\t\t\t}\n\t\t\t\t\t\tparent.frames[2].location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t}\n\t\t\t\t\t\n\n\t\t\t\t}else if (caller_form==\'02\'){\n\n\t\t\t\t\tif(function_name==\'PAT_REGN\'){\n\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].race_desc.value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\";\n\t\t\t\t\t\t\n\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].relgn_desc.value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\";\n\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].relgn_code.value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\";\n\n\t\t\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].r_town_code){\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].r_town_code.value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\";\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].r_town.value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\";\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].r_area_code){\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].r_area_code.value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\";\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].r_area.value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\";\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].r_region_code){\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].r_region_code.value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\";\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].r_region.value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\";\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].r_postal_code1){\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].r_postal_code1.value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\";\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].r_postal_code.value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\";\n\t\t\t\t\t\t}\n\t\t\t\t\t\t\n\t\t\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].place_of_birth_desc){\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].place_of_birth_desc.value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\";\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].place_of_birth_code.value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\";\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\tif(mother_yn==\'03\'){\n\t\t\t\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].next_contact_relation_desc){\n\t\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].next_contact_relation_desc.value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\";\n\t\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].next_contact_relation.value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}else{   // Added 11-Apr-2019- for HSA\n\t\t\t\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].Photo_upload_yn){\n\t\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].Photo_upload_yn.value=\"Y\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\tparent.parent.frames[2].frames[2].location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t}\n\n\t\t\t\t\tif(function_name==\'CHANGEPAT\'){\n\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].race_desc.value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\tparent.parent.frames[2].frames[2].location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t}\n\n\t\t\t\t\t\n\n\n\t\t\t\t\tif(function_name==\'BOOK_APPT\'){\n\t\t\t\t\t\t\t\t\t\t\n\n\t\t\t\t\t\tparent.parent.frames[0].document.forms[0].race_desc.value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\";\n\t\t\t\t\t\tparent.parent.frames[0].document.forms[0].race_code.value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\";\t\t\t\n\t\t\t\t\t\t\n\n\t\t\t\t\t\tparent.parent.frames[0].document.forms[0].birth_place.value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\";\n\t\t\t\t\t\tparent.parent.frames[0].document.forms[0].place_of_birth.value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\";\n\n\t\t\t\t\t\tparent.parent.frames[0].document.forms[0].res_town_desc.value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\";\n\t\t\t\t\t\tparent.parent.frames[0].document.forms[0].res_town_code.value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\";\n\n\t\t\t\t\t\tparent.parent.frames[0].document.forms[0].res_area_desc.value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\";\n\t\t\t\t\t\tparent.parent.frames[0].document.forms[0].res_area_code.value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\";\n\n\t\t\t\t\t\tparent.parent.frames[0].document.forms[0].region_desc.value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\";\n\t\t\t\t\t\tparent.parent.frames[0].document.forms[0].region_code.value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\";\n\n\t\t\t\t\t\tparent.parent.frames[0].document.forms[0].postal_code.value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\";\n\t\t\t\t\t\tparent.parent.frames[0].document.forms[0].r_postal_code_desc.value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\";\n\n\n\t\t\t\t\t\tparent.parent.frames[4].location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t}\n\n\t\t\t\t\tif(function_name==\'PAT_SEARCH\'){\n\t\t\t\t\t\t\t\t\t\t\n\n\t\t\t\t\t\tparent.parent.Pat_Search_Criteria_Frame.document.forms[0].ethnic_group_desc.value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\";\n\t\t\t\t\t\tparent.parent.Pat_Search_Criteria_Frame.document.forms[0].ethnic_group.value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\";\t\n\t\t\t\t\t\tparent.parent.Pat_Search_Criteria_Frame.document.forms[0].ethnic_group_desc_hid.value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\";\t\n\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\tparent.parent.parent.frames[6].location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t}\n\t\t\t\t\t\n\n\t\t\t\t\tif(function_name==\'VSTREG\'){\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].r_town_code){\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].r_town_code.value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\";\n\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].r_area_code.value=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\";\n\t \n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].r_region_code.value=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\";\n\t\t\t\t\t\t}\n\t\t\t\t\t\t\n\t\t\t\t\t\tparent.frames[2].location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t}\n\n\t\t\t\t\tif(function_name==\'REGREF\'){\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\tif(from_OA==\'N\'){\t\t\n\t\t\t\t\t\t\tparent.parent.frames[2].frames[1].frames[0].document.forms[0].race_desc.value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\";\n\t\t\t\t\t\t\tparent.parent.frames[2].frames[1].frames[0].document.forms[0].race_code.value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\";\t\t\t\n\t\t\t\t\t\t\t\n\n\t\t\t\t\t\t\tparent.parent.frames[2].frames[1].frames[0].document.forms[0].birth_place.value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\";\n\t\t\t\t\t\t\tparent.parent.frames[2].frames[1].frames[0].document.forms[0].Birth_place_code.value=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\";\n\n\t\t\t\t\t\t\tparent.parent.frames[2].frames[1].frames[0].document.forms[0].res_town_desc.value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\";\n\t\t\t\t\t\t\tparent.parent.frames[2].frames[1].frames[0].document.forms[0].res_town_code.value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\";\n\n\t\t\t\t\t\t\tparent.parent.frames[2].frames[1].frames[0].document.forms[0].res_area_desc.value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\";\n\t\t\t\t\t\t\tparent.parent.frames[2].frames[1].frames[0].document.forms[0].res_area_code.value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\";\n\n\t\t\t\t\t\t\tparent.parent.frames[2].frames[1].frames[0].document.forms[0].region_desc.value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\";\n\t\t\t\t\t\t\tparent.parent.frames[2].frames[1].frames[0].document.forms[0].region_code.value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\";\n\n\t\t\t\t\t\t\tparent.parent.frames[2].frames[1].frames[0].document.forms[0].postal_code.value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\";\n\t\t\t\t\t\t\tparent.parent.frames[2].frames[1].frames[0].document.forms[0].r_postal_code_desc.value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\";\n\n\n\t\t\t\t\t\t\tparent.parent.frames[2].frames[3].location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\n\t\t\t\t\t\t}else{\n\n\t\t\t\t\t\t\tparent.frames[1].frames[0].document.forms[0].race_desc.value=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\";\t\t\t\n\t\t\t\t\t\t\t\n\n\t\t\t\t\t\t\tparent.frames[1].frames[0].document.forms[0].birth_place.value=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\";\n\t\t\t\t\t\t\tparent.frames[1].frames[0].document.forms[0].Birth_place_code.value=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\";\n\n\t\t\t\t\t\t\tparent.frames[1].frames[0].document.forms[0].res_town_desc.value=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\";\n\t\t\t\t\t\t\tparent.frames[1].frames[0].document.forms[0].res_town_code.value=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\";\n\n\t\t\t\t\t\t\tparent.frames[1].frames[0].document.forms[0].res_area_desc.value=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\";\n\t\t\t\t\t\t\tparent.frames[1].frames[0].document.forms[0].res_area_code.value=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\";\n\n\t\t\t\t\t\t\tparent.frames[1].frames[0].document.forms[0].region_desc.value=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\";\n\t\t\t\t\t\t\tparent.frames[1].frames[0].document.forms[0].region_code.value=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\";\n\n\t\t\t\t\t\t\tparent.frames[1].frames[0].document.forms[0].postal_code.value=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\";\n\t\t\t\t\t\t\tparent.frames[1].frames[0].document.forms[0].r_postal_code_desc.value=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\";\n\n\n\t\t\t\t\t\t\tparent.frames[3].location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\tif(function_name==\'WTLST\'){\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\tparent.frames[1].document.forms[0].race_desc.value=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\";\n\t\t\t\t\t\tparent.frames[1].document.forms[0].race_code.value=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\";\t\t\t\n\t\t\t\t\t\t\n\n\t\t\t\t\t\tparent.frames[1].document.forms[0].birth_place.value=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\";\n\t\t\t\t\t\tparent.frames[1].document.forms[0].Birth_place_code.value=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\";\n\n\t\t\t\t\t\tparent.frames[1].document.forms[0].res_town_desc.value=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\";\n\t\t\t\t\t\tparent.frames[1].document.forms[0].res_town_code.value=\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\";\n\n\t\t\t\t\t\tparent.frames[1].document.forms[0].res_area_desc.value=\"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\";\n\t\t\t\t\t\tparent.frames[1].document.forms[0].res_area_code.value=\"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\";\n\n\t\t\t\t\t\tparent.frames[1].document.forms[0].region_desc.value=\"";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\";\n\t\t\t\t\t\tparent.frames[1].document.forms[0].region_code.value=\"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\";\n\n\t\t\t\t\t\tparent.frames[1].document.forms[0].postal_code.value=\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\";\n\t\t\t\t\t\tparent.frames[1].document.forms[0].r_postal_code_desc.value=\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\";\n\n\n\t\t\t\t\t\tparent.frames[3].location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t}\n\n\t\t\t\t\tif(function_name==\'WTMGMT\'){\n\t\t\t\t\t\tif(parent.frames[1].document.forms[0].r_town_code){\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].r_town_code.value=\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\";\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].r_town.value=\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\";\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\tif(parent.frames[1].document.forms[0].r_area_code){\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].r_area_code.value=\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\";\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].r_area.value=\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\";\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\tif(parent.frames[1].document.forms[0].r_region_code){\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].r_region_code.value=\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\";\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].r_region.value=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\";\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\tparent.frames[5].location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t}\n\n\n\t\t\t\t\tif(function_name==\'IPBOOKING\'){\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\tparent.frames[1].document.forms[0].race_desc.value=\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\";\n\n\n\t\t\t\t\t\tparent.frames[2].location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t}\n\t\t\t\t}else if (caller_form==\'03\'){\n\n\t\t\t\t\tif(function_name==\'PAT_REGN\'){\n\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].race_desc.value=\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\";\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\t/*if(parent.frames[1].frames[1].document.forms[0].r_area_code){\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].r_area_code.value=\"";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\";\n\t\t\t\t\t\t}*/\n\n\t\t\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].r_region_code){\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].r_region_code.value=\"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\";\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\tif(Calledfrom ==\'P\' || Calledfrom==\'R\'){\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].r_country_desc.value=parent.frames[1].frames[1].document.forms[0].nationality_desc.value;\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].r_country_code.value=parent.frames[1].frames[1].document.forms[0].nationality_code.value;\n\t\t\t\t\t\t}\n\t\t\t\t\t\t\n\t\t\t\t\t\t/*if(father_yn==\'N\' &&  mother_yn==\'N\'){\n\t\t\t\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].place_of_birth_desc){\n\t\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].place_of_birth_desc.value=\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\";\n\t\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].place_of_birth_code.value=\"";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}*/\n\t\t\t\t\t\t\n\t\t\t\t\t\tif(mother_yn==\'03\'){\n\t\t\t\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].next_contact_relation_desc){\n\t\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].next_contact_relation_desc.value=\"";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].Photo_upload_yn.value=\"Y\";\n\t\t\t\t\t\t}\n\t\t\t\t\t\t\n\t\t\t\t\t\tif(father_yn==\'04\'){\n\t\t\t\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].first_contact_relation_desc){\n\t\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].first_contact_relation_desc.value=\"";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\";\n\t\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].first_contact_relation.value=\"";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].Photo_upload_yn.value=\"Y\";\n\t\t\t\t\t\t}\n\t\t\t\t\t\t\n\n\t\t\t\t\t\tparent.parent.frames[2].frames[2].location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t}\n\n\t\t\t\t\tif(function_name==\'CHANGEPAT\'){\n\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].race_desc.value=\"";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\";\n\t\t\t\t\t\t}\n \n\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].r_country_desc.value=parent.frames[1].frames[1].document.forms[0].nationality_desc.value;\n\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].r_country_code.value=parent.frames[1].frames[1].document.forms[0].nationality_code.value;\n\t\t\t\t\t\t\n\t\t\t\t\t\t/*if(parent.frames[1].frames[1].document.forms[0].place_of_birth_desc){\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].place_of_birth_desc.value=\"";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\";\n\t\t\t\t\t\t}*/\n\n\t\t\t\t\t\tif(mother_yn==\'03\'){\n\t\t\t\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].next_contact_relation_desc){\n\t\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].next_contact_relation_desc.value=\"";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\t\n\t\t\t\t\t\tif(father_yn==\'04\'){\n\t\t\t\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].first_contact_relation_desc){\n\t\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].first_contact_relation_desc.value=\"";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\";\n\n\t\t\t\t\t\t/*parent.parent.frames[0].document.forms[0].res_area_desc.value=\"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\";\n\t\t\t\t\t\t*/\n\n\t\t\t\t\t\tparent.parent.frames[0].document.forms[0].region_desc.value=\"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\";\n\n\t\t\t\t\t\t\t/*parent.frames[1].frames[1].document.forms[0].r_area_code.value=\"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\";\n\t\t\t\t\t\t\t*/\n\t \n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].r_region_code.value=\"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\";\n\t\t\t\t\t\t}\n\t\t\t\t\t\t\n\t\t\t\t\t\tparent.frames[2].location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t}\n\n\t\t\t\t\tif(function_name==\'REGREF\'){\n\n\t\t\t\t\t\tif(from_OA==\'N\'){\t\n\t\t\t\t\t\t\tif(parent.parent.frames[1].name==\"f_query_add_mod\"){\n\t\t\t\t\t\t\t\tparent.parent.frames[1].frames[0].document.forms[0].race_desc.value=\"";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\";\n\t\t\t\t\t\t\t\tparent.parent.frames[1].frames[0].document.forms[0].race_code.value=\"";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\";\t\t\t\n\t\t\t\t\t\t\t\t\n\n\t\t\t\t\t\t\t\tparent.parent.frames[1].frames[0].document.forms[0].birth_place.value=\"";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\";\n\t\t\t\t\t\t\t\tparent.parent.frames[1].frames[0].document.forms[0].Birth_place_code.value=\"";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\";\n\n\t\t\t\t\t\t\t\tparent.parent.frames[1].frames[0].document.forms[0].res_town_desc.value=\"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\";\n\t\t\t\t\t\t\t\tparent.parent.frames[1].frames[0].document.forms[0].res_town_code.value=\"";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\";\n\n\t\t\t\t\t\t\t\t/*parent.parent.frames[1].frames[0].document.forms[0].res_area_desc.value=\"";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\";\n\t\t\t\t\t\t\t\tparent.parent.frames[1].frames[0].document.forms[0].res_area_code.value=\"";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\";\n\t\t\t\t\t\t\t\t*/\n\t\t\t\t\t\t\t\tparent.parent.frames[1].frames[0].document.forms[0].region_desc.value=\"";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\";\n\t\t\t\t\t\t\t\tparent.parent.frames[1].frames[0].document.forms[0].region_code.value=\"";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\";\n\n\t\t\t\t\t\t\t\tparent.parent.frames[1].frames[0].document.forms[0].postal_code.value=\"";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\";\n\t\t\t\t\t\t\t\tparent.parent.frames[1].frames[0].document.forms[0].r_postal_code_desc.value=\"";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\";\n\n\n\t\t\t\t\t\t\t\tparent.parent.frames[2].location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t}else{\n\n\t\t\t\t\t\t\t\tparent.parent.frames[2].frames[1].frames[0].document.forms[0].race_desc.value=\"";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\";\n\t\t\t\t\t\t\t\tparent.parent.frames[2].frames[1].frames[0].document.forms[0].race_code.value=\"";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\";\t\t\t\n\t\t\t\t\t\t\t\t\n\n\t\t\t\t\t\t\t\tparent.parent.frames[2].frames[1].frames[0].document.forms[0].birth_place.value=\"";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\";\n\t\t\t\t\t\t\t\tparent.parent.frames[2].frames[1].frames[0].document.forms[0].Birth_place_code.value=\"";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\";\n\n\t\t\t\t\t\t\t\tparent.parent.frames[2].frames[1].frames[0].document.forms[0].res_town_desc.value=\"";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\";\n\t\t\t\t\t\t\t\tparent.parent.frames[2].frames[1].frames[0].document.forms[0].res_town_code.value=\"";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\";\n\n\t\t\t\t\t\t\t\t/*parent.parent.frames[2].frames[1].frames[0].document.forms[0].res_area_desc.value=\"";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\";\n\t\t\t\t\t\t\t\tparent.parent.frames[2].frames[1].frames[0].document.forms[0].res_area_code.value=\"";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\";\n\t\t\t\t\t\t\t\t*/\n\t\t\t\t\t\t\t\tparent.parent.frames[2].frames[1].frames[0].document.forms[0].region_desc.value=\"";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\";\n\t\t\t\t\t\t\t\tparent.parent.frames[2].frames[1].frames[0].document.forms[0].region_code.value=\"";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\";\n\n\t\t\t\t\t\t\t\tparent.parent.frames[2].frames[1].frames[0].document.forms[0].postal_code.value=\"";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\";\n\t\t\t\t\t\t\t\tparent.parent.frames[2].frames[1].frames[0].document.forms[0].r_postal_code_desc.value=\"";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\";\n\n\n\t\t\t\t\t\t\t\tparent.parent.frames[2].frames[3].location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t\t\t}\n\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t}else{\n\n\t\t\t\t\t\t\tparent.frames[1].frames[0].document.forms[0].race_desc.value=\"";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\";\n\n\t\t\t\t\t\t\t/*parent.frames[1].frames[0].document.forms[0].res_area_desc.value=\"";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\";\n\t\t\t\t\t\t\t*/\n\t\t\t\t\t\t\tparent.frames[1].frames[0].document.forms[0].region_desc.value=\"";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\";\n\n\t\t\t\t\t\t/*parent.frames[1].document.forms[0].res_area_desc.value=\"";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\";\n\t\t\t\t\t\t*/\n\t\t\t\t\t\tparent.frames[1].document.forms[0].region_desc.value=\"";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\";\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\t/*if(parent.frames[1].document.forms[0].r_area_code){\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].r_area_code.value=\"";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\";\n\t\t\t\t\t\t}*/\n\n\t\t\t\t\t\tif(parent.frames[1].document.forms[0].r_region_code){\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].r_region_code.value=\"";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\";\n\n\n\t\t\t\t\t\tparent.frames[2].location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t}\n\t\t\t\t\n\t\t\t\t}else if (caller_form==\'04\'){\n\n\t\t\t\t\tif(function_name==\'PAT_REGN\'){\n\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].race_desc.value=\"";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\";\n\n\t\t\t\t\t\t/*if(parent.frames[1].frames[1].document.forms[0].r_town_code){\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].r_town_code.value=\"";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\";\n\t\t\t\t\t\t}*/\n\t\t\t\t\t\t\n\t\t\t\t\t\t//alert(\'-->\'+birth_cert_no+\'<--\')\n\t\t\t\t\t\tif(birth_cert_no!=\'\' ){\t\t\t\t\n\t\t\t\t\t\t\tif( parent.frames[1].frames[1].document.forms[0].other_alt_id){\n\t\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].other_alt_id.value=\'07\';\n\t\t\t\t\t\t\t}\n\n\t\t\t\t\t\t\tif( parent.frames[1].frames[1].document.forms[0].other_alt_Id_text){\n\t\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].other_alt_Id_text.value=birth_cert_no;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\t\n\t\t\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].r_area_code){\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].r_area_code.value=\"";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\";\n\n\t\t\t\t\t\t\n\t\t\t\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].r_area_code.value==\'\'){\n\t\t\t\t\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].r_addr_line4){\n\t\t\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].r_addr_line4.value=\"";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\";\t\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].r_region_code){\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].r_region_code.value=\"";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\";\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\tif(Calledfrom ==\'P\' || Calledfrom==\'R\'){\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].r_country_desc.value=parent.frames[1].frames[1].document.forms[0].nationality_desc.value;\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].r_country_code.value=parent.frames[1].frames[1].document.forms[0].nationality_code.value;\n\t\t\t\t\t\t}\n\t\t\t\t\t\t\n\t\t\t\t\t\tif(father_yn==\'N\' &&  mother_yn==\'N\'){\n\t\t\t\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].place_of_birth_desc){\n\t\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].place_of_birth_desc.value=\"";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\tparent.parent.frames[0].document.forms[0].place_of_birth.value=\"";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\";\n\t\t\t\t\t\tif(mother_yn==\'95\'){\n\t\t\t\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].next_contact_relation_desc){\n\t\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].next_contact_relation_desc.value=\"";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].Photo_upload_yn){\n\t\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].Photo_upload_yn.value=\"Y\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\t\n\t\t\t\t\t\tif(father_yn==\'94\'){\n\t\t\t\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].first_contact_relation_desc){\n\t\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].first_contact_relation_desc.value=\"";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].Photo_upload_yn){\n\t\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].Photo_upload_yn.value=\"Y\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\t\n\n\t\t\t\t\t\tparent.parent.frames[2].frames[2].location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t}\n\n\t\t\t\t\tif(function_name==\'CHANGEPAT\'){\n\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].race_desc.value=\"";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\";\n\n\t\t\t\t\t\tif(birth_cert_no!=\'\' ){\t\t\t\t\n\t\t\t\t\t\t\tif( parent.frames[1].frames[1].document.forms[0].other_alt_id){\n\t\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].other_alt_id.value=\'07\';\n\t\t\t\t\t\t\t}\n\n\t\t\t\t\t\t\tif( parent.frames[1].frames[1].document.forms[0].other_alt_Id_text){\n\t\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].other_alt_Id_text.value=birth_cert_no;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\t/*if(parent.frames[1].frames[1].document.forms[0].r_town_code){\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].r_town_code.value=\"";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\";\n\t\t\t\t\t\t}*/\n\n\t\t\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].r_area_code){\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].r_area_code.value=\"";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\";\n\n\t\t\t\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].r_area_code.value==\'\'){\n\t\t\t\t\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].r_addr_line4){\n\t\t\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].r_addr_line4.value=\"";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\";\t\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\t\t\t\t\t\n\n\t\t\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].r_region_code){\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].r_region_code.value=\"";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\";\n\t\t\t\t\t\t}\n \n\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].r_country_desc.value=parent.frames[1].frames[1].document.forms[0].nationality_desc.value;\n\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].r_country_code.value=parent.frames[1].frames[1].document.forms[0].nationality_code.value;\n\t\t\t\t\t\t\n\t\t\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].place_of_birth_desc){\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].place_of_birth_desc.value=\"";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\";\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\tif(mother_yn==\'95\'){\n\t\t\t\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].next_contact_relation_desc){\n\t\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].next_contact_relation_desc.value=\"";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\t\n\t\t\t\t\t\tif(father_yn==\'94\'){\n\t\t\t\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].first_contact_relation_desc){\n\t\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].first_contact_relation_desc.value=\"";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\";\n\t\t\t\t\t\tparent.parent.frames[0].document.forms[0].birth_place.blur();\n\t\t\t\t\t\tparent.parent.frames[0].document.forms[0].place_of_birth.value=\"";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\";\n\n\t\t\t\t\t\t/*\n\t\t\t\t\t\tparent.parent.frames[0].document.forms[0].res_town_desc.value=\"";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\";\n\t\t\t\t\t\t*/\n\n\t\t\t\t\t\tparent.parent.frames[0].document.forms[0].res_area_desc.value=\"";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\";\n\t\t\t\t\t\t\n\n\t\t\t\t\t\tparent.parent.frames[0].document.forms[0].region_desc.value=\"";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\";\t\n\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\tparent.parent.parent.frames[6].location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t}\n\t\t\t\t\t\n\n\t\t\t\t\tif(function_name==\'VSTREG\'){\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].r_area_code){\n\t\t\t\t\t\t\t/*parent.frames[1].frames[1].document.forms[0].r_town_code.value=\"";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\";\n\t\t\t\t\t\t\t*/\n\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].r_area_code.value=\"";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\";\n\t\t\t\t\t\t\t\n\t \n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].r_region_code.value=\"";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\";\n\n\t\t\t\t\t\t\t\t/*parent.parent.frames[1].frames[0].document.forms[0].res_town_desc.value=\"";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\";\n\t\t\t\t\t\t\t\t*/\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tparent.parent.frames[1].frames[0].document.forms[0].res_area_desc.value=\"";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\";\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tparent.parent.frames[1].frames[0].document.forms[0].region_desc.value=\"";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\";\n\n\t\t\t\t\t\t\t\t/*parent.parent.frames[2].frames[1].frames[0].document.forms[0].res_town_desc.value=\"";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\";\n\t\t\t\t\t\t\t\t*/\n\t\t\t\t\t\t\t\tparent.parent.frames[2].frames[1].frames[0].document.forms[0].res_area_desc.value=\"";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\";\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tparent.parent.frames[2].frames[1].frames[0].document.forms[0].region_desc.value=\"";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\";\n\n\t\t\t\t\t\t\t/*parent.frames[1].frames[0].document.forms[0].res_town_desc.value=\"";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\";\n\t\t\t\t\t\t\t*/\n\t\t\t\t\t\t\tparent.frames[1].frames[0].document.forms[0].res_area_desc.value=\"";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\";\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tparent.frames[1].frames[0].document.forms[0].region_desc.value=\"";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\";\n\n\t\t\t\t\t\t/*parent.frames[1].document.forms[0].res_town_desc.value=\"";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\";\n\t\t\t\t\t\t*/\n\t\t\t\t\t\tparent.frames[1].document.forms[0].res_area_desc.value=\"";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\";\n\t\t\t\t\t\t\n\t\t\t\t\t\tparent.frames[1].document.forms[0].region_desc.value=\"";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\";\n\n\n\t\t\t\t\t\tparent.frames[3].location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t}\n\n\t\t\t\t\tif(function_name==\'WTMGMT\'){\n\t\t\t\t\t\t/*if(parent.frames[1].document.forms[0].r_town_code){\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].r_town_code.value=\"";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\";\n\t\t\t\t\t\t}\n\t\t\t\t\t\t*/\n\t\t\t\t\t\tif(parent.frames[1].document.forms[0].r_area_code){\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].r_area_code.value=\"";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\";\n\n\n\t\t\t\t\t\tparent.frames[2].location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t}\n\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse if (caller_form==\'05\'){ //Related to Taiba\n\t\t\t\t\tif(function_name==\'PAT_REGN\' ||function_name==\'CHANGEPAT\'){\n\t\t\t\t\tif(inst==\'NC\' || inst==\'CP\'){\n\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].nationality_desc.value=\"";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\";\t\n\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].blood_group.value=\"";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\";\n\t\t\t\t\t\tparent.frames[2].location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\t/*else if(inst==\'PS\'){\n\t\t\t\t\t\tparent.parent.Pat_Search_Criteria_Frame.document.forms[0].nationality_desc.value=\"";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\";\n\t\t\t\t\t\tparent.parent.frames[5].location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t}\t*/\n\t\t\t\t\t\n\n\t\t\t\t}\n\t\t\t\telse if (caller_form==\'06\'){ // Maheshwaran k added for ML-MMOH-CRF-1908 - related to Serdang\n\t\t\t\t\tif(function_name==\'PAT_REGN\'){\n\t\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].other_alt_id)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].other_alt_id.value=\"";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].notify_oth_alt_id_type)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].notify_oth_alt_id_type.value=\"";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\";\n\t\t\t\t\t\t\t}\t\t\n\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].race_desc.value=\"";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\";\n\n\t\t\t\t\t/*\tif(parent.frames[1].frames[1].document.forms[0].r_town_code){\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].r_town_code.value=\"";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\";\n\t\t\t\t\t\t}\n\t\t\t\t\t\t\n\n\t\t\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].r_postal_code1){\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].r_postal_code1.value=\"";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\";\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\tif(Calledfrom ==\'P\' || Calledfrom==\'R\'){\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].r_country_desc.value=\"";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\";\n\t\t\t\t\t\t}\n\t\n\t\t\t\t\t\tif(father_yn==\'RE07\' ||  mother_yn==\'RE01\'){\n\t\t\t\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].place_of_birth_desc){\n\t\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].place_of_birth_desc.value=\"";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t//\tparent.frames[1].frames[1].document.forms[0].other_alt_id.value=\"";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\";\n\t\t\t\t\t\n\t\t\t\t\t\t//document.forms[0].other_alt_id\n\t\t\t\t\t\tif(mother_yn==\'RE01\'){\n\t\t\t\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].next_contact_relation_desc){\n\t\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].next_contact_relation_desc.value=\"";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].next_contact_relation){\n\t\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].next_contact_relation.value=\"";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\t//\tparent.frames[1].frames[1].document.forms[0].Photo_upload_yn.value=\"Y\";\n\t\t\t\t\t\t}\n\t\t\t\t\t\tif(father_yn==\'RE07\'){\n\t\t\t\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].first_contact_relation_desc){\n\t\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].first_contact_relation_desc.value=\"";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\t//\tparent.frames[1].frames[1].document.forms[0].Photo_upload_yn.value=\"Y\";\n\t\t\t\t\t\t}\n\t\t\t\t\t\t\n\n\t\t\t\t\t\tparent.parent.frames[2].frames[2].location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t}\n\n\t\t\t\t\tif(function_name==\'CHANGEPAT\'){\n\t\t\t\t\t\t//alert(function_name)\n\t\t\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].other_alt_id)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].other_alt_id.value=\"";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\";\n\t\t\t\t\t\t}\n \n\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].r_country_desc.value=\"";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\";\n\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].r_country_code.value=\"";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\";\n\t\t\t\t\t\t\n\t\t\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].place_of_birth_desc){\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].place_of_birth_desc.value=\"";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\";\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\tif(mother_yn==\'RE01\'){\n\t\t\t\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].next_contact_relation_desc){\n\t\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].next_contact_relation_desc.value=\"";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\t\n\t\t\t\t\t\tif(father_yn==\'RE07\'){\n\t\t\t\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].first_contact_relation_desc){\n\t\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].first_contact_relation_desc.value=\"";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\tif(father_yn==\'RE07\' ||  mother_yn==\'RE01\'){\n\t\t\t\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].place_of_birth_desc){\n\t\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].place_of_birth_desc.value=\"";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\tparent.parent.frames[2].frames[2].location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t}\n\n\t\t\t\t\t\n\n\n\t\t\t\t\tif(function_name==\'BOOK_APPT\'){\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\tparent.parent.frames[0].document.forms[0].race_desc.value=\"";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\";\t\t\t\n\t\t\t\t\t\t\n\t\n\t\t\t\t\t/*\tparent.frames[0].document.forms[0].res_town_desc.value=\"";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\";\n\t\t\t\t\t\tparent.frames[0].document.forms[0].res_town_code.value=\"";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\";*/\n\t\t\t\t\n\t\t\t\t\t\tparent.parent.frames[0].document.forms[0].birth_place.value=\"";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\";\n\t\n\t\t\t\t\t\tparent.parent.frames[0].document.forms[0].place_of_birth.value=\"";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\";\n\t\t\t\t\t//\tparent.parent.frames[0].document.forms[0].place_of_birth.value=\"";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="\"; //Added newly\n\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\tparent.parent.frames[0].document.forms[0].res_area_desc.value=\"";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\";\n\n\t\t\t\t\t\tparent.parent.frames[0].document.forms[0].r_country_desc.value=\"";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\";\n\t\t\t\t\t\tparent.parent.frames[0].document.forms[0].r_country_code.value=\"";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\";\n\t\t\t\t\t\t\n\t\t\t\t\t\tparent.parent.frames[4].location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t}\n\n\t\t\t\t\tif(function_name==\'PAT_SEARCH\'){\n\t\t\t\t\t/*\tparent.parent.Pat_Search_Criteria_Frame.document.forms[0].ethnic_group_desc.value=\"";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\";\t\n*/\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\tparent.parent.parent.frames[6].location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t}\n\t\t\t\t\t\n\n\t\t\t\t\tif(function_name==\'VSTREG\'){\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].r_area_code){\n\t\t\t\t\t\t//\tparent.frames[1].frames[1].document.forms[0].r_town_code.value=\"";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\";\n\t\t\t\t\t\t//\tparent.frames[1].frames[1].document.forms[0].r_town.value=\"";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\";\n\t\t\t\t\t\t}\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].country1_code.value=\"";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\";\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].country1_desc.value=\"";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="\";\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].r_postal_code.value=\"";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="\";\n\t\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].r_postal_desc.value=\"";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\";\n\t\t\t\t\t\tparent.frames[2].location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t}\n\n\t\t\t\t\tif(function_name==\'REGREF\'){\n\n\t\t\t\t\t\tif(from_OA==\'N\'){\t\n\t\t\t\t\t\t\tif(parent.parent.frames[1].name==\"f_query_add_mod\"){\n\t\t\t\t\t\t\t\tparent.parent.frames[1].frames[0].document.forms[0].race_desc.value=\"";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="\";\n\n\t\t\t\t\t\t\t//\tparent.parent.frames[1].frames[0].document.forms[0].res_town_desc.value=\"";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="\";\n\t\t\t\t\t\t\t//\tparent.parent.frames[1].frames[0].document.forms[0].res_town_code.value=\"";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="\";\n\n\t\t\t\t\t\t\t\tparent.parent.frames[1].frames[0].document.forms[0].res_area_desc.value=\"";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="\";\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tparent.parent.frames[1].frames[0].document.forms[0].country1_code.value=\"";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\";\n\t\t\t\t\t\t\t\tparent.parent.frames[1].frames[0].document.forms[0].country1_desc.value=\"";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="\";\n\n\t\t\t\t\t\t\t\tparent.parent.frames[2].location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t}else{\n\n\t\t\t\t\t\t\t\tparent.parent.frames[2].frames[1].frames[0].document.forms[0].race_desc.value=\"";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="\";\n\n\t\t\t\t\t\t\t//\tparent.parent.frames[2].frames[1].frames[0].document.forms[0].res_town_desc.value=\"";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="\";\n\t\t\t\t\t\t\t//\tparent.parent.frames[2].frames[1].frames[0].document.forms[0].res_town_code.value=\"";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\";\n\n\t\t\t\t\t\t\t\tparent.parent.frames[2].frames[1].frames[0].document.forms[0].res_area_desc.value=\"";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="\";\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tparent.parent.frames[2].frames[1].frames[0].document.forms[0].country1_code.value=\"";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="\";\n\t\t\t\t\t\t\t\tparent.parent.frames[2].frames[1].frames[0].document.forms[0].country1_desc.value=\"";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="\";\n\n\t\t\t\t\t\t//\tparent.frames[1].frames[0].document.forms[0].res_town_desc.value=\"";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="\";\n\t\t\t\t\t\t//\tparent.frames[1].frames[0].document.forms[0].res_town_code.value=\"";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="\";\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tparent.frames[1].frames[0].document.forms[0].r_country_code.value=\"";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="\";\n\t\t\t\t\t\t\tparent.frames[1].frames[0].document.forms[0].r_country_desc.value=\"";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="\";\n\n\t\t\t\t\t//\tparent.frames[1].document.forms[0].res_town_desc.value=\"";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\";\n\t\t\t\t\t//\tparent.frames[1].document.forms[0].res_town_code.value=\"";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="\";\n\t\t\t\t\t\t\n\t\t\t\t\t\tparent.frames[1].document.forms[0].r_country_code.value=\"";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="\";\n\t\t\t\t\t\tparent.frames[1].document.forms[0].r_country_desc.value=\"";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="\";\n\t\t\t\t\t\t}\n\t\t\t\t\t\t\n\t\t\t\t\t\tparent.frames[1].document.forms[0].postal_code.value=\"";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="\";\n\n\t\t\t\t\t\tparent.frames[5].location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t}\n\n\n\t\t\t\t\tif(function_name==\'IPBOOKING\'){\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\tparent.frames[1].document.forms[0].race_desc.value=\"";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 ="\";\n\n\t\t\t\t//\t\tparent.frames[1].document.forms[0].res_town_desc.value=\"";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 ="\";\n\t\t\t\t//\t\tparent.frames[1].document.forms[0].res_town_code.value=\"";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 ="\";\n\t\t\t\t\t\tparent.frames[1].document.forms[0].r_country_code.value=\"";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 ="\";\n\n\n\t\t\t\t\t\tparent.frames[2].location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t\t\t}\n\t\t\t\t\n\t\t\t\t}\n\t\t\t\ttry{\n\t\t\t\t\tif(parent.frames[1].frames[1].document.forms[0].txtSmartcard_succ){\n\t\t\t\t\t\tparent.frames[1].frames[1].document.forms[0].txtSmartcard_succ.value=\'Y\';\n\t\t\t\t\t}\n\t\t\t\t}catch(exception){\n\n\t\t\t\t}\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 ="\n\t\t\n\t\t";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );
	
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
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

		String inst = checkForNull(request.getParameter("inst"));
		String Calledfrom = checkForNull(request.getParameter("Calledfrom"));
		String function_name = checkForNull(request.getParameter("function_name"));
		String modal_yn= checkForNull(request.getParameter("modal_yn"),"N");
		String from_OA= checkForNull(request.getParameter("from_OA"),"N");
		String caller_form="00";
		caller_form=checkForNull(request.getParameter("caller_form"),"00");
		request.setCharacterEncoding("UTF-8");
		Connection conn			= null;
		java.sql.PreparedStatement prpstmt = null;
     	String locale			= (String)session.getAttribute("LOCALE");

		ResultSet rs			= null;
		try
		{
			conn	= ConnectionManager.getConnection(request);
			
			String sql ;
			String nationality_code="";
			String race_desc = checkForNull(request.getParameter("race_desc"));
			String country_desc = checkForNull(request.getParameter("country_desc"));
			String nationality_desc = checkForNull(request.getParameter("nationality_desc"));
			nationality_code = checkForNull(request.getParameter("nationality_code"));
			String blood_group_code = checkForNull(request.getParameter("blood_group_code"));
		//	System.err.println("nationality_code : "+nationality_code);
		//	System.err.println("blood_group_code : "+blood_group_code);
			String city_desc = checkForNull(request.getParameter("city_desc"));
			String state_desc = checkForNull(request.getParameter("state_desc"));
			String post_code_desc = checkForNull(request.getParameter("post_code"));
			String birth_place_desc = checkForNull(request.getParameter("b_place"));
			String religion_desc = checkForNull(request.getParameter("religion_desc"));
			String mother_yn = checkForNull(request.getParameter("mother_yn"),"N");
			String father_yn = checkForNull(request.getParameter("father_yn"),"N");
			String birth_cert_no = checkForNull(request.getParameter("birth_cert_no"),"N");
			//Maheshwaran added for ML-MMOH-CRF-1908
			String alt_id_type_desc = checkForNull(request.getParameter("alt_id_type_desc"));
			String father_doc_type_desc = checkForNull(request.getParameter("father_doc_type_desc"));
			String alt_id_type_code="";
			String alt_id_type_desc1="";
			String father_doc_type_code="";
			String father_doc_type_desc1="";
		//	System.err.println("alt_id_type_desc in JSP : "+alt_id_type_desc);
			
			String race_code="";
		
			String country_code="";
			String city_code="";
			String state_code="";
			String post_code="";
			String birth_place_code="";
			String religion_code="";
			String area_code = "";
			String area_desc ="";
			String mother_relation_desc ="";
			String father_relation_desc ="";
			String blood_grp_code="";
			String blood_grp_desc="";



		
			if(caller_form.equals("00")){

				prpstmt = conn.prepareStatement("select nvl(race_code,'') race_code ,nvl(long_desc,'') long_desc  from MP_RACE_lang_vw where upper(long_desc)=upper(?) and  EFF_STATUS='E' and language_id='"+locale+"'");

				prpstmt.setString(1,race_desc);
				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					race_code=checkForNull(rs.getString("race_code"));
					race_desc=checkForNull(rs.getString("long_desc"));
				}else{
					race_code="";
					race_desc="";
				}

				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();

				prpstmt = conn.prepareStatement("select nvl(country_code,'') country_code  , nvl(long_desc,'') long_desc from mp_country_lang_vw where upper(long_desc)=upper(?) and  EFF_STATUS='E'  and language_id='"+locale+"'");
				prpstmt.setString(1,nationality_desc);

				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					nationality_code=checkForNull(rs.getString("country_code"));
					nationality_desc=checkForNull(rs.getString("long_desc"));
				}else{
					nationality_code="";
					nationality_desc="";
				}
			}else if(caller_form.equals("01")){

				prpstmt = conn.prepareStatement("select nvl(country_code,'') country_code,nvl(long_desc,'') long_desc from mp_country_lang_vw where EFF_STATUS='E'  and language_id='"+locale+"' and country_code in (?,?)");
				prpstmt.setString(1,country_desc);
				prpstmt.setString(2,nationality_desc);

				rs = prpstmt.executeQuery();

				HashMap country_map=new HashMap();

				while (rs.next()){
					country_map.put(checkForNull(rs.getString("country_code")),checkForNull(rs.getString("long_desc")));
				}
				
				nationality_code=nationality_desc;
				nationality_desc=checkForNull((String)country_map.get(nationality_code));
				country_code=country_desc;
				country_desc=checkForNull((String)country_map.get(country_code));

				
			}else if(caller_form.equals("02")){

				prpstmt = conn.prepareStatement("select nvl(race_code,'') race_code ,nvl(long_desc,'') long_desc  from MP_RACE_lang_vw where upper(long_desc)=upper(?) and  EFF_STATUS='E' and language_id='"+locale+"' order by 1");



				prpstmt.setString(1,race_desc);
				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					race_code=checkForNull(rs.getString("race_code"));
					race_desc=checkForNull(rs.getString("long_desc"));
				}else{
					race_code="";
					race_desc="";
				}
				
				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();

				prpstmt = conn.prepareStatement("select nvl(RES_TOWN_CODE,'') RES_TOWN_CODE  , nvl(long_desc,'') long_desc,RES_AREA_CODE from mp_res_town_lang_vw  where upper(long_desc)=upper(?) and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");
				prpstmt.setString(1,city_desc);

				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					city_code=checkForNull(rs.getString("RES_TOWN_CODE"));
					city_desc=checkForNull(rs.getString("long_desc"));
					area_code=checkForNull(rs.getString("RES_AREA_CODE"));
				}else{
					city_code="";
					city_desc="";
					area_code="";
				}
				
				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();

				prpstmt = conn.prepareStatement("select nvl(RES_AREA_CODE,'') RES_AREA_CODE  , nvl(long_desc,'') long_desc from mp_res_area_lang_vw  where upper(RES_AREA_CODE)=upper(?) and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");
				prpstmt.setString(1,area_code);

				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					area_code=checkForNull(rs.getString("RES_AREA_CODE"));
					area_desc=checkForNull(rs.getString("long_desc"));
				}else{
					area_code="";
					area_desc="";
				}

				

				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();


				prpstmt = conn.prepareStatement("select nvl(REGION_CODE,'') REGION_CODE  , nvl(long_desc,'') long_desc from mp_region_lang_vw   where upper(long_desc)=upper(?) and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");
				prpstmt.setString(1,state_desc);


				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					state_code=checkForNull(rs.getString("REGION_CODE"));
					state_desc=checkForNull(rs.getString("long_desc"));
				}else{
					state_code="";
					state_desc="";
				}

				
				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();

				prpstmt = conn.prepareStatement("select nvl(POSTAL_CODE,'') POSTAL_CODE  , nvl(long_desc,'') long_desc from mp_postal_code_lang_vw   where upper(long_desc)=upper(?) and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");
				prpstmt.setString(1,post_code_desc);



				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					post_code=checkForNull(rs.getString("POSTAL_CODE"));
					post_code_desc=checkForNull(rs.getString("long_desc"));
				}else{
					post_code="";
					post_code_desc="";
				}


				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();

				prpstmt = conn.prepareStatement("select nvl(BIRTH_PLACE_CODE,'') BIRTH_PLACE_CODE  , nvl(long_desc,'') long_desc from mp_birth_place_lang_vw   where upper(long_desc)=upper(?) and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");
				prpstmt.setString(1,birth_place_desc);


				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					birth_place_code=checkForNull(rs.getString("BIRTH_PLACE_CODE"));
					birth_place_desc=checkForNull(rs.getString("long_desc"));
				}else{
					birth_place_code="";
					birth_place_desc="";
				}

				
				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();

				prpstmt = conn.prepareStatement("select nvl(RELGN_CODE,'') RELGN_CODE  , nvl(long_desc,'') long_desc from mp_religion_lang_vw   where upper(long_desc)=upper(?) and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");
				prpstmt.setString(1,religion_desc);


				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					religion_code=checkForNull(rs.getString("RELGN_CODE"));
					religion_desc=checkForNull(rs.getString("long_desc"));
				}else{
					religion_code="";
					religion_desc="";
				}

				
				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();


				if(mother_yn.equals("Y")){

					prpstmt = conn.prepareStatement("select nvl(RELATIONSHIP_CODE,'') RELATIONSHIP_CODE  , nvl(long_desc,'') long_desc from mp_relationship_lang_vw   where RELATIONSHIP_CODE = '03' and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");

					rs = prpstmt.executeQuery();
					
					if(rs != null && rs.next()){
											
						if(checkForNull(rs.getString("RELATIONSHIP_CODE")).equals("03") ){
							mother_relation_desc=checkForNull(rs.getString("long_desc"));
							mother_yn="03";
						}

						/*if(checkForNull(rs.getString("RELATIONSHIP_CODE")).equals("04") ){
							father_relation_desc=checkForNull(rs.getString("long_desc"));
							father_yn="04";
						}					
						*/					
						
					}
				

					if(rs!=null) rs.close();
					if(prpstmt!=null) prpstmt.close();		

				}


			}else if(caller_form.equals("03")){

				prpstmt = conn.prepareStatement("select nvl(race_code,'') race_code ,nvl(long_desc,'') long_desc  from MP_RACE_lang_vw where upper(long_desc)=upper(?) and  EFF_STATUS='E' and language_id='"+locale+"' order by 1");



				prpstmt.setString(1,race_desc);
				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					race_code=checkForNull(rs.getString("race_code"));
					race_desc=checkForNull(rs.getString("long_desc"));
				}else{
					race_code="";
					race_desc="";
				}
				
				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();

				prpstmt = conn.prepareStatement("select nvl(RES_TOWN_CODE,'') RES_TOWN_CODE  , nvl(long_desc,'') long_desc,RES_AREA_CODE from mp_res_town_lang_vw  where upper(long_desc)=upper(?) and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");
				prpstmt.setString(1,city_desc);

				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					city_code=checkForNull(rs.getString("RES_TOWN_CODE"));
					city_desc=checkForNull(rs.getString("long_desc"));
					area_code=checkForNull(rs.getString("RES_AREA_CODE"));
				}else{
					city_code="";
					city_desc="";
					area_code="";
				}
				
				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();

				prpstmt = conn.prepareStatement("select nvl(RES_AREA_CODE,'') RES_AREA_CODE  , nvl(long_desc,'') long_desc from mp_res_area_lang_vw  where upper(RES_AREA_CODE)=upper(?) and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");
				prpstmt.setString(1,area_code);

				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					area_code=checkForNull(rs.getString("RES_AREA_CODE"));
					area_desc=checkForNull(rs.getString("long_desc"));
				}else{
					area_code="";
					area_desc="";
				}

				

				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();


				prpstmt = conn.prepareStatement("select nvl(REGION_CODE,'') REGION_CODE  , nvl(long_desc,'') long_desc from mp_region_lang_vw   where upper(long_desc)=upper(?) and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");
				prpstmt.setString(1,state_desc);


				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					state_code=checkForNull(rs.getString("REGION_CODE"));
					state_desc=checkForNull(rs.getString("long_desc"));
				}else{
					state_code="";
					state_desc="";
				}

				
				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();

				prpstmt = conn.prepareStatement("select nvl(POSTAL_CODE,'') POSTAL_CODE  , nvl(long_desc,'') long_desc from mp_postal_code_lang_vw   where upper(long_desc)=upper(?) and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");
				prpstmt.setString(1,post_code_desc);



				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					post_code=checkForNull(rs.getString("POSTAL_CODE"));
					post_code_desc=checkForNull(rs.getString("long_desc"));
				}else{
					post_code="";
					post_code_desc="";
				}


				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();

				prpstmt = conn.prepareStatement("select nvl(BIRTH_PLACE_CODE,'') BIRTH_PLACE_CODE  , nvl(long_desc,'') long_desc from mp_birth_place_lang_vw   where upper(long_desc)=upper(?) and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");
				prpstmt.setString(1,birth_place_desc);


				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					birth_place_code=checkForNull(rs.getString("BIRTH_PLACE_CODE"));
					birth_place_desc=checkForNull(rs.getString("long_desc"));
				}else{
					birth_place_code="";
					birth_place_desc="";
				}

				
				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();

				prpstmt = conn.prepareStatement("select nvl(RELGN_CODE,'') RELGN_CODE  , nvl(long_desc,'') long_desc from mp_religion_lang_vw   where upper(long_desc)=upper(?) and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");
				prpstmt.setString(1,religion_desc);


				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					religion_code=checkForNull(rs.getString("RELGN_CODE"));
					religion_desc=checkForNull(rs.getString("long_desc"));
				}else{
					religion_code="";
					religion_desc="";
				}

				
				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();

				
				if(father_yn.equals("Y") || mother_yn.equals("Y")){

					prpstmt = conn.prepareStatement("select nvl(RELATIONSHIP_CODE,'') RELATIONSHIP_CODE  , nvl(long_desc,'') long_desc from mp_relationship_lang_vw   where RELATIONSHIP_CODE in ('03','04') and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");

					rs = prpstmt.executeQuery();
					
					if(rs != null){
						while (rs.next()){ 
					
						if(checkForNull(rs.getString("RELATIONSHIP_CODE")).equals("03") ){
							mother_relation_desc=checkForNull(rs.getString("long_desc"));
							mother_yn="03";
						}

						if(checkForNull(rs.getString("RELATIONSHIP_CODE")).equals("04") ){
							father_relation_desc=checkForNull(rs.getString("long_desc"));
							father_yn="04";
						}					
											
						}
					}
				}

				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();		

			}else if(caller_form.equals("04")){

				prpstmt = conn.prepareStatement("select nvl(race_code,'') race_code ,nvl(long_desc,'') long_desc  from MP_RACE_lang_vw where upper(short_desc)=upper(?) and  EFF_STATUS='E' and language_id='"+locale+"' order by 1");

				System.out.println("race_desc-->"+race_desc);

				prpstmt.setString(1,race_desc);
				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					race_code=checkForNull(rs.getString("race_code"));
					race_desc=checkForNull(rs.getString("long_desc"));
				}else{
					race_code="";
					race_desc="";
				}
				
				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();

				/*prpstmt = conn.prepareStatement("select nvl(RES_TOWN_CODE,'') RES_TOWN_CODE  , nvl(long_desc,'') long_desc,RES_AREA_CODE from mp_res_town_lang_vw  where upper(long_desc)=upper(?) and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");

				System.out.println("city_desc-->"+city_desc);
				prpstmt.setString(1,city_desc);

				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					city_code=checkForNull(rs.getString("RES_TOWN_CODE"));
					city_desc=checkForNull(rs.getString("long_desc"));
					area_code=checkForNull(rs.getString("RES_AREA_CODE"));
				}else{
					city_code="";
					city_desc="";
					area_code="";
				}
				
				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();
				*/

				prpstmt = conn.prepareStatement("select nvl(RES_AREA_CODE,'') RES_AREA_CODE  , nvl(long_desc,'') long_desc from mp_res_area_lang_vw  where upper(long_desc)=upper(?) and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");

				
				prpstmt.setString(1,city_desc);

				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					area_code=checkForNull(rs.getString("RES_AREA_CODE"));
					area_desc=checkForNull(rs.getString("long_desc"));
				}else{
					area_code="";
					area_desc="";
				}

				

				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();


				prpstmt = conn.prepareStatement("select nvl(REGION_CODE,'') REGION_CODE  , nvl(long_desc,'') long_desc from mp_region_lang_vw   where upper(short_desc)=substr(upper(?),0,15) and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");

				System.out.println("state_desc-->"+state_desc);
				prpstmt.setString(1,state_desc);


				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					state_code=checkForNull(rs.getString("REGION_CODE"));
					state_desc=checkForNull(rs.getString("long_desc"));
				}else{
					state_code="";
					state_desc="";
				}

				
				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();

				prpstmt = conn.prepareStatement("select nvl(POSTAL_CODE,'') POSTAL_CODE  , nvl(long_desc,'') long_desc from mp_postal_code_lang_vw   where upper(long_desc)=upper(?) and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");
				prpstmt.setString(1,post_code_desc);

																

				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					post_code=checkForNull(rs.getString("POSTAL_CODE"));
					post_code_desc=checkForNull(rs.getString("long_desc"));
				}else{
					post_code="";
					post_code_desc="";
				}


				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();

				prpstmt = conn.prepareStatement("select nvl(BIRTH_PLACE_CODE,'') BIRTH_PLACE_CODE  , nvl(long_desc,'') long_desc from mp_birth_place_lang_vw   where upper(long_desc)=upper(?) and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");
				prpstmt.setString(1,birth_place_desc);
																System.out.println("birth_place_desc-->"+birth_place_desc);

				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					birth_place_code=checkForNull(rs.getString("BIRTH_PLACE_CODE"));
					birth_place_desc=checkForNull(rs.getString("long_desc"));
				}else{
					birth_place_code="";
					birth_place_desc="";
				}

				
				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();

				prpstmt = conn.prepareStatement("select nvl(RELGN_CODE,'') RELGN_CODE  , nvl(long_desc,'') long_desc from mp_religion_lang_vw   where upper(short_desc)=upper(?) and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");
				prpstmt.setString(1,religion_desc);
																System.out.println("religion_desc-->"+religion_desc);

				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					religion_code=checkForNull(rs.getString("RELGN_CODE"));
					religion_desc=checkForNull(rs.getString("long_desc"));
				}else{
					religion_code="";
					religion_desc="";
				}

				
				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();

				
				if(father_yn.equals("Y") || mother_yn.equals("Y")){

					prpstmt = conn.prepareStatement("select nvl(RELATIONSHIP_CODE,'') RELATIONSHIP_CODE  , nvl(long_desc,'') long_desc from mp_relationship_lang_vw   where RELATIONSHIP_CODE in ('95','94') and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");

					rs = prpstmt.executeQuery();
					
					if(rs != null){
						while (rs.next()){ 
					
						if(checkForNull(rs.getString("RELATIONSHIP_CODE")).equals("95") ){
							mother_relation_desc=checkForNull(rs.getString("long_desc"));
							mother_yn="95";
						}

						if(checkForNull(rs.getString("RELATIONSHIP_CODE")).equals("94") ){
							father_relation_desc=checkForNull(rs.getString("long_desc"));
							father_yn="94";
						}					
											
						}
					}
				}

				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();		

				System.out.println("594 area_code-->"+area_code);
				System.out.println("595 area_desc-->"+area_desc);
				System.out.println("596 city_desc-->"+city_desc);
			}
			else if(caller_form.equals("05")){ // Related to Taiba

				prpstmt = conn.prepareStatement("select nvl(country_code,'') country_code,nvl(long_desc,'') long_desc from mp_country_lang_vw where EFF_STATUS='E'  and language_id='"+locale+"' and upper(country_code)=upper(?)");
				prpstmt.setString(1,nationality_code);
				rs = prpstmt.executeQuery();
				if(rs!= null && rs.next()){
					nationality_code=checkForNull(rs.getString("country_code"));
					nationality_desc=checkForNull(rs.getString("long_desc"));
				}else{
					nationality_code="";
					nationality_desc="";
				}
				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();		
				
				prpstmt = conn.prepareStatement(" select nvl(blood_grp,'') blood_grp , nvl(long_desc,'') long_desc   from mr_blood_grp_lang_vw where EFF_STATUS='E'  and language_id='"+locale+"' and upper(blood_grp)=upper(?) ");
				prpstmt.setString(1,blood_group_code);
				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					blood_grp_code=checkForNull(rs.getString("blood_grp"));
					blood_grp_desc=checkForNull(rs.getString("long_desc"));
				}else{
					blood_grp_code="";
					blood_grp_desc="";
				}

				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();	
			}
			else if(caller_form.equals("06")){ // Related to Serdang
				String pat_photo = checkForNull(request.getParameter("pat_photo"));

				session.setAttribute("pat_photo",pat_photo);
				prpstmt = conn.prepareStatement("select nvl(country_code,'') country_code  , nvl(long_name,'') long_desc from mp_country_lang_vw where upper(long_name)=upper(?) and  EFF_STATUS='E'  and language_id='"+locale+"'");
				prpstmt.setString(1,nationality_desc);

				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					nationality_code=checkForNull(rs.getString("country_code"));
					nationality_desc=checkForNull(rs.getString("long_desc"));
				}else{
					nationality_code="";
					nationality_desc="";
				}
				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();		
			
			prpstmt = conn.prepareStatement("select nvl(BIRTH_PLACE_CODE,'') BIRTH_PLACE_CODE  , nvl(long_desc,'') long_desc from mp_birth_place_lang_vw   where upper(long_desc)=upper(?) and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");
				prpstmt.setString(1,birth_place_desc);
			//System.out.println("birth_place_desc-->"+birth_place_desc);

				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					birth_place_code=checkForNull(rs.getString("BIRTH_PLACE_CODE"));
					birth_place_desc=checkForNull(rs.getString("long_desc"));
				}else{
					birth_place_code="";
					birth_place_desc="";
				}
	prpstmt = conn.prepareStatement("select nvl(REGION_CODE,'') REGION_CODE  , nvl(long_desc,'') long_desc from mp_region_lang_vw   where upper(short_desc)=substr(upper(?),0,15) and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");
				prpstmt.setString(1,state_desc);
				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					state_code=checkForNull(rs.getString("REGION_CODE"));
					state_desc=checkForNull(rs.getString("long_desc"));
				}else{
					state_code="";
					state_desc="";
				}
				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();
			/*	prpstmt = conn.prepareStatement("select nvl(RES_TOWN_CODE,'') RES_TOWN_CODE  , nvl(long_desc,'') long_desc,RES_AREA_CODE from mp_res_town_lang_vw  where upper(long_desc)=upper(?) and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");
				prpstmt.setString(1,city_desc);
				rs = prpstmt.executeQuery();
				if(rs!= null && rs.next()){
					city_code=checkForNull(rs.getString("RES_TOWN_CODE"));
					city_desc=checkForNull(rs.getString("long_desc"));
					area_code=checkForNull(rs.getString("RES_AREA_CODE"));
				}else{
					city_code="";
					city_desc="";
					area_code="";
				}				
				*/
				
				prpstmt = conn.prepareStatement("select nvl(RES_AREA_CODE,'') RES_AREA_CODE  , nvl(long_desc,'') long_desc from mp_res_area_lang_vw  where upper(long_desc)=upper(?) and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");
				prpstmt.setString(1,city_desc);

				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					city_code=checkForNull(rs.getString("RES_AREA_CODE"));
					city_desc=checkForNull(rs.getString("long_desc"));
				}else{
					city_code="";
					city_desc="";
				}
				
				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();	
				prpstmt = conn.prepareStatement("select nvl(POSTAL_CODE,'') POSTAL_CODE  , nvl(long_desc,'') long_desc from mp_postal_code_lang_vw   where upper(long_desc)=upper(?) and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");
				prpstmt.setString(1,post_code_desc);												
				rs = prpstmt.executeQuery();
				if(rs!= null && rs.next()){
					post_code=checkForNull(rs.getString("POSTAL_CODE"));
					post_code_desc=checkForNull(rs.getString("long_desc"));
				}else{
					post_code="";
					post_code_desc="";
				}
				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();
				prpstmt = conn.prepareStatement("select nvl(race_code,'') race_code ,nvl(long_desc,'') long_desc  from MP_RACE_lang_vw where upper(short_desc)=upper(?) and  EFF_STATUS='E' and language_id='"+locale+"' order by 1");
				prpstmt.setString(1,race_desc);
				rs = prpstmt.executeQuery();

				if(rs!= null && rs.next()){
					race_code=checkForNull(rs.getString("race_code"));
					race_desc=checkForNull(rs.getString("long_desc"));
				}else{
					race_code="";
					race_desc="";
				}				
				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();
				prpstmt = conn.prepareStatement("select nvl(RELGN_CODE,'') RELGN_CODE  , nvl(long_desc,'') long_desc from mp_religion_lang_vw   where upper(short_desc)=upper(?) and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");
				prpstmt.setString(1,religion_desc);
				rs = prpstmt.executeQuery();
				if(rs!= null && rs.next()){
					religion_code=checkForNull(rs.getString("RELGN_CODE"));
					religion_desc=checkForNull(rs.getString("long_desc"));
				}else{
					religion_code="";
					religion_desc="";
				}
	
				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();		
				
				prpstmt = conn.prepareStatement("select nvl(alt_id_type,'') alt_id_type  , nvl(long_desc,'') long_desc from mp_alternate_id_type_lang_vw   where upper(long_desc)=upper(?) and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");
				prpstmt.setString(1,alt_id_type_desc);
				rs = prpstmt.executeQuery();
				if(rs!= null && rs.next()){
					alt_id_type_code=checkForNull(rs.getString("alt_id_type"));
					alt_id_type_desc1=checkForNull(rs.getString("long_desc"));
				}else{
					alt_id_type_code="";
					alt_id_type_desc1="";
				}	
				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();		
				}	
				if(father_doc_type_desc!=null){
				prpstmt = conn.prepareStatement("select nvl(alt_id_type,'') alt_id_type  , nvl(long_desc,'') long_desc from mp_alternate_id_type_lang_vw   where upper(long_desc)=upper(?) and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");
				prpstmt.setString(1,father_doc_type_desc);
				rs = prpstmt.executeQuery();
				if(rs!= null && rs.next()){
					father_doc_type_code=checkForNull(rs.getString("alt_id_type"));
					father_doc_type_desc1=checkForNull(rs.getString("long_desc"));
				}else{
					father_doc_type_code="";
					father_doc_type_desc1="";
				}	
				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();		
				}
				
				if(mother_yn.equals("Y")){

					prpstmt = conn.prepareStatement("select nvl(RELATIONSHIP_CODE,'') RELATIONSHIP_CODE  , nvl(short_desc,'') short_desc from mp_relationship_lang_vw   where RELATIONSHIP_CODE = 'RE01' and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");

					rs = prpstmt.executeQuery();
					
					if(rs != null && rs.next()){
											
						if(checkForNull(rs.getString("RELATIONSHIP_CODE")).equals("RE01") ){
							mother_relation_desc=checkForNull(rs.getString("short_desc"));
							mother_yn="RE01";
						
						}
						
					}
				

					if(rs!=null) rs.close();
					if(prpstmt!=null) prpstmt.close();		

				}
				if(father_yn.equals("Y")){

					prpstmt = conn.prepareStatement("select nvl(RELATIONSHIP_CODE,'') RELATIONSHIP_CODE  , nvl(short_desc,'') short_desc from mp_relationship_lang_vw   where RELATIONSHIP_CODE = 'RE07' and  EFF_STATUS='E'  and language_id='"+locale+"' order by 1");

					rs = prpstmt.executeQuery();
					
					if(rs != null && rs.next()){
				 

						if(checkForNull(rs.getString("RELATIONSHIP_CODE")).equals("RE07") ){
							father_relation_desc=checkForNull(rs.getString("short_desc"));
							father_yn="RE07";
						}					
									
						
					}
				

					if(rs!=null) rs.close();
					if(prpstmt!=null) prpstmt.close();		

				}

			
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(Calledfrom));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(inst));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(function_name));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(caller_form));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(from_OA));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(father_yn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(mother_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(father_relation_desc));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(mother_relation_desc));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(birth_cert_no));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(nationality_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(nationality_code));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(race_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(nationality_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(nationality_code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(nationality_desc));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(nationality_desc));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(nationality_code));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(race_code));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(nationality_desc));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(nationality_desc));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(nationality_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(race_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(nationality_desc));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(nationality_desc));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(nationality_code));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(race_code));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(nationality_desc));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(nationality_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(nationality_desc));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(nationality_code));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(nationality_desc));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(nationality_code));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(nationality_desc));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(nationality_desc));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(nationality_code));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(race_code));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(nationality_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(nationality_code));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(country_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(country_code));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(nationality_desc));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(nationality_desc));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(nationality_code));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(nationality_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(nationality_code));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(country_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(country_code));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(race_code));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(religion_desc));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(religion_code));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(city_desc));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(city_code));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(area_desc));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(area_code));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(state_desc));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(state_code));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(post_code_desc));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(birth_place_desc));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(birth_place_code));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(mother_relation_desc));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(mother_yn));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(race_code));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(religion_desc));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(religion_code));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(city_desc));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(city_code));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(area_desc));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(area_code));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(state_desc));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(state_code));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(post_code_desc));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(birth_place_desc));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(birth_place_code));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(mother_relation_desc));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(mother_yn));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(race_code));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(birth_place_desc));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(birth_place_code));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(city_desc));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(city_code));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(area_desc));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(area_code));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(state_desc));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(state_code));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(race_code));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(race_code));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(city_desc));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(city_code));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(area_desc));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(area_code));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(state_desc));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(state_code));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(race_code));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(birth_place_desc));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(birth_place_code));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(city_desc));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(city_code));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(area_desc));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(area_code));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(state_desc));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(state_code));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(race_code));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(birth_place_desc));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(birth_place_code));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(city_desc));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(city_code));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(area_desc));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(area_code));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(state_desc));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(state_code));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(race_code));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(birth_place_desc));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(birth_place_code));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(city_desc));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(city_code));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(area_desc));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(area_code));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(state_desc));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(state_code));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(city_desc));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(city_code));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(area_desc));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(area_code));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(state_desc));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(state_code));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(race_code));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(birth_place_desc));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(birth_place_code));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(city_desc));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(city_code));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(area_desc));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(area_code));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(state_desc));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(state_code));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(race_code));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(religion_desc));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(religion_code));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(city_desc));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(city_code));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(area_desc));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(area_code));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(state_desc));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(state_code));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(post_code_desc));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(birth_place_desc));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(birth_place_code));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(mother_relation_desc));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(mother_yn));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(father_relation_desc));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(father_yn));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(race_code));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(religion_desc));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(religion_code));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(city_desc));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(city_code));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(area_desc));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(area_code));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(state_desc));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(state_code));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(post_code_desc));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(birth_place_desc));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(birth_place_code));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(mother_relation_desc));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(mother_yn));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(father_relation_desc));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(father_yn));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(race_code));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(birth_place_desc));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(birth_place_code));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(city_desc));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(city_code));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(area_desc));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(area_code));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(state_desc));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(state_code));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(race_code));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(race_code));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(city_desc));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(city_code));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(area_desc));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(area_code));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(state_desc));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(state_code));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(race_code));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(birth_place_desc));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(birth_place_code));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(city_desc));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(city_code));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(area_desc));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(area_code));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(state_desc));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(state_code));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(race_code));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(birth_place_desc));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(birth_place_code));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(city_desc));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(city_code));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(area_desc));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(area_code));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(state_desc));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(state_code));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(race_code));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(birth_place_desc));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(birth_place_code));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(city_desc));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(city_code));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(area_desc));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(area_code));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(state_desc));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(state_code));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(race_code));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(birth_place_desc));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(birth_place_code));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(city_desc));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(city_code));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(area_desc));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(area_code));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(state_desc));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(state_code));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(city_desc));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(city_code));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(area_desc));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(area_code));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(state_desc));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(state_code));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(race_code));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(birth_place_desc));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(birth_place_code));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(city_desc));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(city_code));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(area_desc));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(area_code));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(state_desc));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(state_code));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(race_code));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(religion_desc));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(religion_code));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(city_desc));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(city_code));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(area_desc));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(area_code));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(city_desc));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(state_desc));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(state_code));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(post_code_desc));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(birth_place_desc));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(birth_place_code));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(birth_place_code));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(mother_relation_desc));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(mother_yn));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(father_relation_desc));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(father_yn));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(race_code));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(religion_desc));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(religion_code));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(city_desc));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(city_code));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(area_desc));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(area_code));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(city_desc));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(state_desc));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(state_code));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(post_code_desc));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(birth_place_desc));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(birth_place_code));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(mother_relation_desc));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(mother_yn));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(father_relation_desc));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(father_yn));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(race_code));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(birth_place_desc));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(birth_place_code));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(city_desc));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(city_code));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(area_desc));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(area_code));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(state_desc));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(state_code));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(race_code));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(race_code));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(city_desc));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(city_code));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(area_desc));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(area_code));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(state_desc));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(state_code));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(race_code));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(birth_place_desc));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(birth_place_code));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(city_desc));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(city_code));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(area_desc));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(area_code));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(state_desc));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(state_code));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(race_code));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(birth_place_desc));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(birth_place_code));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(city_desc));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(city_code));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(area_desc));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(area_code));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(state_desc));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(state_code));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(race_code));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(birth_place_desc));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(birth_place_code));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(city_desc));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(city_code));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(area_desc));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(area_code));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(state_desc));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(state_code));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(race_code));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(birth_place_desc));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(birth_place_code));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(city_desc));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(city_code));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(area_desc));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(area_code));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(state_desc));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(state_code));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(city_desc));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(city_code));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(area_desc));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(area_code));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(state_desc));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(state_code));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(race_code));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(birth_place_desc));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(birth_place_code));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(city_desc));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(city_code));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(area_desc));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(area_code));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(state_desc));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(state_code));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(nationality_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(nationality_code));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(blood_grp_code));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(nationality_desc));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(nationality_desc));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(nationality_code));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(alt_id_type_code));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(father_doc_type_code));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(race_code));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(religion_desc));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(religion_code));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(city_desc));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(city_code));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(city_desc));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(city_code));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(state_desc));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(state_code));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(post_code_desc));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(nationality_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(nationality_code));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(birth_place_desc));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(birth_place_code));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(alt_id_type_desc1));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(mother_relation_desc));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(mother_yn));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(mother_yn));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(father_relation_desc));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(father_yn));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(alt_id_type_code));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(father_doc_type_code));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(race_code));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(religion_desc));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(religion_code));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(city_desc));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(city_code));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(city_desc));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(city_code));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(state_desc));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(state_code));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(post_code_desc));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(nationality_desc));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(nationality_code));
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(birth_place_desc));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(birth_place_code));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(mother_relation_desc));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(mother_yn));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(mother_yn));
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(father_relation_desc));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(father_yn));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(birth_place_desc));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(birth_place_code));
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(race_code));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(city_code));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(city_code));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(birth_place_desc));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(birth_place_code));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(birth_place_desc));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(city_desc));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(city_code));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(state_desc));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(state_code));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(nationality_desc));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(nationality_code));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(race_code));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(race_code));
            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(city_desc));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(city_code));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(city_code));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(city_desc));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(state_desc));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(state_code));
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(nationality_code));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(nationality_desc));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(race_code));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(birth_place_desc));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(birth_place_code));
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(city_desc));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(city_code));
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(city_desc));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(city_code));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(state_desc));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(state_code));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(nationality_code));
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(nationality_desc));
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(race_code));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(birth_place_desc));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(birth_place_code));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(city_desc));
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(city_code));
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(city_desc));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(city_code));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(state_desc));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(state_code));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(nationality_code));
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(nationality_desc));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(race_code));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(birth_place_desc));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(birth_place_code));
            _bw.write(_wl_block265Bytes, _wl_block265);
            out.print( String.valueOf(city_desc));
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(city_code));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(city_desc));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(city_code));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(state_desc));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(state_code));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(nationality_code));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(nationality_desc));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(race_code));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(birth_place_desc));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(birth_place_code));
            _bw.write(_wl_block269Bytes, _wl_block269);
            out.print( String.valueOf(city_desc));
            _bw.write(_wl_block270Bytes, _wl_block270);
            out.print( String.valueOf(city_code));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(city_desc));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(city_code));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(state_desc));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(state_code));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(nationality_code));
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(nationality_desc));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(city_desc));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(city_code));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(city_desc));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(city_code));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(state_desc));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(state_code));
            _bw.write(_wl_block273Bytes, _wl_block273);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(nationality_code));
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(nationality_desc));
            _bw.write(_wl_block274Bytes, _wl_block274);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(race_code));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(birth_place_desc));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(birth_place_code));
            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(city_desc));
            _bw.write(_wl_block276Bytes, _wl_block276);
            out.print( String.valueOf(city_code));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(city_desc));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(city_code));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(state_desc));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(state_code));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(post_code));
            _bw.write(_wl_block277Bytes, _wl_block277);
            out.print( String.valueOf(nationality_code));
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(nationality_desc));
            _bw.write(_wl_block278Bytes, _wl_block278);

			
		}catch(Exception e)	{ 
				System.out.println("Exception-->"+e.toString());
				e.printStackTrace();
		}finally{
				if(rs!=null) rs.close();
				if(prpstmt!=null) prpstmt.close();
				 ConnectionManager.returnConnection(conn,request);
		}
		
            _bw.write(_wl_block279Bytes, _wl_block279);
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
