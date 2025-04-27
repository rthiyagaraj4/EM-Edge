package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import eOR.*;
import java.io.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __resultvieworderdetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ResultViewOrderDetail.jsp", 1742363988000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n\n\t\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n \t<script language=\"JavaScript\" src=\"../js/ResultOrder.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCA/js/CAOpenExternalApplication.js\"></script>\n\t<script language=\'javascript\' src=\'../../eXH/js/ExternalApplication.js\' ></script> <!-- added for IN047024 -->\n\t<Script src=\"../../eCommon/js/jquery-3.6.3.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n <!-- added for IN048253 -->\n \t<STYLE>\n\t\tPRE.RESULTTEXTAREAEVEN\n\t\t{\n\t\t\tfont-size: 10pt ;\n\t\t\t/* IN043895 Start.*/\n\t\t\t/*Font-Family : Courier New;*/\n\t\t\t\t/*IN049424 Start.*/\t\t\t\n\t\t\t\t/*Font-Family : \"Charis SIL\", \"Doulos SIL\", Gentium,\"Arial Unicode MS\";*/\n\t\t\t\tFONT-FAMILY: Verdana ;\n\t\t\t\t/*IN049424 End.*/\n\t\t\t/* IN043895 End.*/\n\t\t\tBACKGROUND-COLOR: #F0F0F2;\n\t\t\tBORDER-STYLE: none;\n\t\t\tfontWeight : bold;\n\t\t\ttext-align: left;\n\t\t\twhite-space: normal;\n\t\t\tword-wrap: break-word;\n\t\t}\t\n\t\t\n\t\tPRE.RESULTTEXTAREAODD\n\t\t{\n\t\t\tfont-size: 10pt ;\n\t\t\t/* IN043895 Start.*/\n\t\t\t/*Font-Family : Courier New;*/\n\t\t\t\t/*IN049424 Start.*/\t\t\t\n\t\t\t\t/*Font-Family : \"Charis SIL\", \"Doulos SIL\", Gentium,\"Arial Unicode MS\";*/\n\t\t\t\tFONT-FAMILY: Verdana ;\n\t\t\t\t/*IN049424 End.*/\n\t\t\t/* IN043895 End.*/\n\t\t\tBACKGROUND-COLOR: #E2E3F0;\n\t\t\tBORDER-STYLE: none;\n\t\t\tfontWeight : bold;\n\t\t\ttext-align: left;\n\t\t\twhite-space: normal;\n\t\t\tword-wrap: break-word;\n\t\t}\t\n\t\tPRE\n\t\t{\n\t\t\tfont-size: 10pt ;\n\t\t\t/* IN043895 Start.*/\n\t\t\t/*Font-Family : Courier New;*/\n\t\t\t\t/*IN049424 Start.*/\t\t\t\n\t\t\t\t/*Font-Family : \"Charis SIL\", \"Doulos SIL\", Gentium,\"Arial Unicode MS\";*/\n\t\t\t\tFONT-FAMILY: Verdana ;\n\t\t\t\t/*IN049424 End.*/\n\t\t\t/* IN043895 End.*/\n\t\t\tBACKGROUND-COLOR: #E2E3F0;\n\t\t\tBORDER-STYLE: none;\n\t\t\tfontWeight : bold;\n\t\t\ttext-align: left;\n\t\t\twhite-space: normal;\n\t\t\tword-wrap: break-word;\t\t\t\n\t\t}\t\n\t\t/* IN043895 Start.*/\n\t\t\t/* IN049424 Start.*/\n\t\t\t\t/*ADDRESS\t{ \n\t\t\t\t\tFONT-FAMILY: \"Charis SIL\", \"Doulos SIL\", Gentium,\"Arial Unicode MS\" ;\n\t\t\t\t\tFONT-SIZE: 10pt ; \n\t\t\t\t\tFONT-STYLE: NORMAL; \n\t\t\t\t\tCOLOR: BLACK; \n\t\t\t\t}*/\n\t\t\t\tADDRESS\t{ FONT-FAMILY: Verdana ;FONT-SIZE: 10pt ; FONT-STYLE: NORMAL; COLOR: BLACK; }\n\t\t\t/* IN049424 End.*/\t\t\t\n\t\t/* IN043895 End.*/\n\t</STYLE>\t\n</head>\n<body OnMouseDown=\"CodeArrest()\"; onKeyDown=\"lockKey()\">\n<form name=\"view_order\" id=\"view_order\">\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<PRE CLASS=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" style=\"word-wrap:break-word;\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</PRE>\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\t\n\t\t\t\t\t\t\t\t\t\t\t\t<textarea rows=\"4\" cols=\"90\"  CLASS = \"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" READONLY>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</textarea>\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t\t\t\t<PRE CLASS=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</PRE>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<!--<PRE CLASS=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</PRE>-->\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t<PRE CLASS=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</PRE>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t\t\t\t<textarea rows=\"5\" cols=\"90\"  CLASS = \"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" READONLY title = \"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" ondblclick=\"viewClobData(\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\')\">";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</textarea>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t\t\t\t<a class=\"gridLink\" href=\"javascript:viewResultComment(escape(\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'))\">C</a>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t\t\t\t<a class=\"gridLink\"  href=\"javascript:getExtLink(\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\',\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\')\"><img src=\'../../eCommon/images/ExternalDocument.PNG\' title=\'External Link\' width=\'16\' height=\'16\' border=0 alt=\'Result\'></a>  <!-- IN47847 Added title to img tag --> <!-- IN049589 Passing peforming facility_id[perfFacilityId] instead of login facility_id[facility_id] -->\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t\t\t\t <a class=\"gridLink\"><img src=\'../../eCA/images/";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =".gif\'  width=\'16\' height=\'16\' border=0 ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =" alt=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'></a>  <!--[IN033152] -->\n\t\t\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t\t\t\t<a class=\"gridLink\"  href=\"javascript:getFile(\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\')\"><img src=\'../../eCA/images/";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =".gif\' width=\'16\' height=\'16\' border=0 alt=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'></a>  <!--7902-->\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t\t\t\t\t <a class=\"gridLink\"  href=\"javascript:getFile(\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'></a>  <!--7902--> \n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t\t\t<!-- IN063813 changes Starts -->\n\t\t\t\t\t\t\t\t</td><td  title = \'\' class=\'gridData\' style=\'vertical-align=top\'><font size=1>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t\t\t<!-- IN063813 changes Ends -->\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="<!--Modified Colspan for IN063813-->\n\n\t\t\t<Input name=\"ord_typ_code\" id=\"ord_typ_code\" type=\"hidden\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n\t\t\t<Input name=\"patient_class\" id=\"patient_class\" type=\"hidden\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t\t\t<Input name=\"priority\" id=\"priority\" type=\"hidden\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\t\t\t<Input name=\"ord_id\" id=\"ord_id\" type=\"hidden\" value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n\t\t\t<Input name=\"source_type\" id=\"source_type\" type=\"hidden\" value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n\t\t\t<Input name=\"location_code\" id=\"location_code\" type=\"hidden\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n\t\t\t<Input name=\"order_status\" id=\"order_status\" type=\"hidden\" value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n\t\t\t<Input name=\"report_srl_no\" id=\"report_srl_no\" type=\"hidden\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n\t\t\t<Input name=\"order_category\" id=\"order_category\" type=\"hidden\" value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\"><!-- IN039857-->\n\t\t\t<Input name=\"ord_typ_desc\" id=\"ord_typ_desc\" type=\"hidden\" value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\"><!-- IN039857-->\n\t\t\t<Input name=\"cont_order_ind\" id=\"cont_order_ind\" type=\"hidden\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\"><!-- IN053439-->\n\t\t\t<Input name=\"performing_facility_id\" id=\"performing_facility_id\" type=\"hidden\" value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\"><!-- IN054720 -->\n\t\t\t</table>\n\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n<Input name=\"bean_id\" id=\"bean_id\" type=\"hidden\" value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n<Input name=\"view_bean_id\" id=\"view_bean_id\" type=\"hidden\" value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n<Input name=\"view_bean_name\" id=\"view_bean_name\" type=\"hidden\" value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n<Input name=\"patient_id\" id=\"patient_id\" type=\"hidden\" value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n<Input name=\"orderId\" id=\"orderId\" type=\"hidden\" value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n<Input name=\"facility_id\" id=\"facility_id\" type=\"hidden\" value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n<Input type=\'hidden\' name=\'querystring\' id=\'querystring\' value=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\'>\n<Input type=\'hidden\' name=\'order_catalog_code\' id=\'order_catalog_code\' value=\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\'><!-- IN061961 -->\n<Input type=\'hidden\' name=\'view_by\' id=\'view_by\' value=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\'><!-- IN061961 -->\n<input type=\"hidden\" name=\"includeESignature\" id=\"includeESignature\" value=\"\" > <!-- 25671 -->\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


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

/*
-----------------------------------------------------------------------
Date       	  	Edit History  Name        	Description
-----------------------------------------------------------------------
?             	100         	?           	created
19/01/2012    	IN029928    Ramesh      	Order reporting d/t changes for MEDICITY
27/01/2012	  	INO30714	Menaka V		THAI screen>View Clinical Event History>View>In the Recorded
											Clinical Note the name is not displayed in THAI
08/02/2012	  	IN030996	Menaka V	 	CA>Patient Chart>Clinical event history>When the already recorded details
											are accessed we get Java Lang null pointer exception Script Error. 
14/05/2012    	IN032119	Ramesh G	 	System display order catalog in header of any result value (duplicate display).
26/06/2012    	IN032816	Chowminya G	 	Existing order, system was displayed new result but old picture file	
05/07/2012    	IN032246    Chowminya G	 	Three Scenarios for result view screen from exiting order 		
29/08/2012    	IN033152    Chowminya G	  	mouse over on the icon, system display balloon box "X-ray". It should display "Result"
03/10/2012	  	IN034973	Ramesh G		Laboratory result is not showing in a proper format from Clinical Event History and order tracking. 
12/11/2012	  	EMG			Chowminya G	   PACS LIVE
14/12/2012	  	IN031684	Ramesh G		Group test name is not showing in from Order management function.
07/01/2012	  	IN032246	Ramesh G 		Result view from Existing Orders, doesn't show the similar format as it's shows on the Print Preview 
											and LIS (View/Print Draft Copy).
09/04/2013    	IN039067    Ramesh G        RD result aligment  	
07/05/2013    	IN0EMG      Chowminya G     Exeception handling - unclosed connection		
20/05/2013	  	IN037793	Karthi L        To be able to view the Specimen image attachment in 'Existing Orders' function and 'Clinical Event History' function in OR and CA.		
30/05/2013	  	IN040237	Karthi L	    Clicking on the icon, system is displaying error message.	
12/06/2013    	IN040745	Chowminya G     Resulted Values are not displaying in Result - Laboratory Order Webpage 	
17/06/2013		IN040866	Karthi L		System is not displaying the Image in CA  			
22/06/2013  	IN040416	Nijitha S  		CRF-OR-Bru-HIMS-CRF-052.1/02-System is not displaying 'View' hyperlink for the Laboratory Panel Order.
03/07/2013    	IN039857	Chowminya G   	Print Button from result view page for LB order
18/12/2013		IN042552	Ramesh G	Bru-HIMS-CRF-391 --- Notes Confidentiality	
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
18/02/2014	IN043895		Ramesh G		20/2/2014	    Chowminya		Clinical Notes is not correct for some of the Symbols which are loaded. 
27/03/2014	IN047204		Karthi L		07/03/2014		Ramesh 			Order result screen for Radiology to provide a link to the DMS URL where the scanned radiology result document is uploaded to. 
19/03/2014	IN47847			Nijitha S										Order result screen for Radiology to provide a link to the DMS URL where the scanned radiology result document is uploaded to 
01/04/2014	IN048253		Karthi L		01/04/2014		Akbar			Getting Script error when click on External Application link icon.
04/06/2014	IN049424		Ramesh G 		04/06/2014		Akbar S			IN043895 Changes Reverted.
09/06/2014	IN049578[IN047205]		Karthi L										Changes to clinical event history and chart summary view - to provide link to the scanned document in clinical views
11/06/2014	IN049589[IN047205]		Karthi L								Document Uploaded cannot be viewed in another facility		
08/09/2014  IN050936		ChowminyaG										None of the order retrieving any image from RIS/PACS but already having order image in PACS
01/12/2014	IN052367		ChowminyaG 										Signature not published in Result linked clinical notes
25/02/2015	IN053439		 Vijayakumar K									MMS-QF-SCF-0486 [IN:053439] - Not able to 
20/03/2015	IN054648		Ramesh G		20/03/2015		Akbar S			RESULTED REPORT RANGE COMMENTS ARE DISPLAYING IN OR.NOTE: REPORT RANGE COMMENT SETUP IS <REPORT RANGE COMMENT>
26/05/2015	IN054720		 Vijayakumar K									ML-BRU-SCF-1580 [IN:054720]
01/02/2016  IN058413		Manoj Kumar KV                                  ML-BRU-SCF-1652   If a radiologist reports the exam and marked as "Abnormal" or "Critical Abnormal", the "Abnormal" indication is not showing in the Order Tracking and Existing Order when clinicians viewing the report
03/11/2016	IN061489		Karthi L										ML-MMOH-SCF-0491 - Reporting practitioner was not appear after user released the result.
22/12/2016	IN062669		Vijayakumar K									ML-MMOH-CRF-0728 [IN:062669]
26/12/2016	IN062978		Karthi L										Event description displayed with null in Existing orders and Order tracking
10/05/2017	IN064215		Krishna Gowtham J	10/05/2017		Ramesh G	PMG2017-SH-CRF-0001		
22/09/2017	IN063813		Raja S				10/10/2017		Ramesh G	AAKH-CRF-0095
07/11/2017	IN064132		Raja S				07/11/2017		Ramesh G	ML-MMOH-CRF-0831
07/02/2018	IN065970		Vijayakumar K		07/02/2018		RameshGo	ML-BRU-SCF-1611.1 [IN:065970]
07/03/2018	IN065970		Vijayakumar K	07/03/2018		RameshGo		ML-BRU-SCF-1611.1 [IN:065970] reopen
26/02/2018	IN066119		Raja S			26/02/2018		Ramesh G		ML-MMOH-CRF-1024
18/07/2018  IN061961		sivabagyam M    18/07/2018		Ramesh G		GHL-CRF-0433
08/02/2019  IN068650		Prakash C    	08/02/2019		Ramesh G		ML-MMOH-SCF-1078
30/07/2019	IN070610		Dinesh T		30/07/2019		Ramesh G		TBMC-CRF-0011.1
06/09/2019	IN071127		Sivabagyam M	06/09/2019		Ramesh G		Alpha-RL-Unable to attach images for Interval test...
20/09/2019	IN071404		Sivabagyam M	20/09/2019		Ramesh G		Regression-Automation-CA-Notes-HTML Error
06/01/2020	IN072011		Sivabagyam		06/01/2020		Ramesh G		Common-ICN-0015
15/12/2020	7902		Sivabagyam M		15/12/2020		Ramesh G	MMS-DM-CRF-0180.1
24/02/2022	25671			Ramesh G										NMC-JD-CRF-0091.2
16/08/2022	29803			Ramesh G 										ML-BRU-CRF-0635
--------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	
            _bw.write(_wl_block7Bytes, _wl_block7);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String mode	   = "1";//request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_ViewOrder" ;
	String bean_name = "eOR.ViewOrder";
	String reporting_practitioner = "";
	HashMap orParamFac = new HashMap();//IN066119
	String hideReportPrac = "N";//IN066119
	String hideSpecimenType = "N";//IN066119
	String event_code1=request.getParameter("event_code"); //IN061961
	String orderId = request.getParameter("orderId");
	String order_catalog_code = request.getParameter("order_catalog_code");//IN061961
	String order_line_num = request.getParameter("order_line_num");
	String cont_order_ind = request.getParameter("cont_order_ind");
	String patient_id = request.getParameter("patient_id");
	String ord_cat = request.getParameter("ord_cat");
	String order_status = request.getParameter("order_status");
	String pract_reln_id = request.getParameter("pract_reln_id");
	//String ord_practitioner_id = request.getParameter("practitioner_id");
	String facility_id = (String)session.getValue("facility_id");
	String resp_id		= (String)session.getValue("responsibility_id");
	int image_count=0;//IN071127
	//String toolTipTextArea = "Double Click to Zoom"; //Commented for Checkstyle
	if(resp_id== null)	resp_id = "";
	String cols = request.getParameter("cols");	
	if(cols == null || cols.equals(""))
		cols = "300";
	//String chart_result_type="";
	//int exists=0;
	String status = "";
	//String acc_num    = "";//--[IN032816] 
	
	if(order_line_num == null || order_line_num.equals(""))
		order_line_num = "";

	if(order_status == null) 
		order_status = "";

	ArrayList allValues = new ArrayList();
	//ArrayList allValue = new ArrayList();
	//ArrayList allOrders= new ArrayList();
	
	PreparedStatement pstmtImgView = null; // added for Bru-HIMS-CRF-052.1 [IN037793]
	ResultSet resImgView = null; // added for Bru-HIMS-CRF-052.1 [IN037793]
	PreparedStatement pstmtImgCount = null; // [IN037793]
	ResultSet rsetImgCount = null; // added for Bru-HIMS-CRF-052.1 [IN037793]
	PreparedStatement pstmtPerFacId = null; // IN040866
	ResultSet rsetPerFacId = null;  // IN040866
	int recCount = 0; // added for Bru-HIMS-CRF-052.1 [IN037793]
	String ext_image_upld_id = ""; //Bru-HIMS-CRF-052.1 [IN037793]
	String ext_img_file_locn = ""; //Bru-HIMS-CRF-052.1 [IN037793]
	eCA.CAExternalLinkDataDTO externalDataDTO = null; //Bru-HIMS-CRF-195.3 - IN047205
	eCA.CAEncounterList oEncounterList = new eCA.CAEncounterList();  //Bru-HIMS-CRF-195.3 - IN047205
	ViewOrder bean = (ViewOrder)getBeanObject( bean_id, bean_name,request ) ;
	bean.setLanguageId(localeName);

	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	bean.clear() ;
	bean.setMode( mode ) ;
	//IN070610, starts
	bean.setSiteSpecific("UPLOAD_TR_CATEGORY_ORDERS");
	Boolean uploadFuncTrOrders = bean.isSiteSpecific("UPLOAD_TR_CATEGORY_ORDERS");
	//IN070610, ends

	//String result_data[] = (String[])bean.getAbnormalCondition(); //Commented for Checkstyle
	ArrayList repPractList = null;
	String tempPractChk = "";
	//INO30714 Starts
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String login_at_ws_no		= p.getProperty("client_ip_address")== null ?"":p.getProperty("client_ip_address");	// IN047204
	String locale = (String) p.getProperty("LOCALE");
	String		performed_by_id	=	"" ;
	String		patient_class		=	"";
	String default_pat_name ="";
	String encounter_id1 = "";
	String Sex = "";
	String		encounter_id	=	request.getParameter("encounter_id");
	String		facility_name	=	"" ;
	String		visit_adm_date	=	"" ;
	String		attending_practitioner	=	"" ;
	String		admitting_practitioner	=	"" ;
	String		bed_number	=	"" ;
	String		performing_phy_name	=	"" ;
	String		age	=	"" ;
	String		gender	=	"" ;
	String		patient_name	=	"" ;
	String		speciality_name	=	"" ;
	String		printDateTime	=	"" ;
	String		site_name	=	"" ;
	String doc_ref_id = "";
	String last_amended_by="";
	String authorized_by="";
	String pract_sign = "";
	String		query_privilege_type	=	"" ;
	Connection			con			=	null;
	PreparedStatement	pstmt2			=	null;
	ResultSet			rs2				=	null;
	PreparedStatement	pstmt			=	null;
	ResultSet			rs				=	null;
	String  url1					=	"";
	String  url						=	"";
	String footer_code = null;
	String report_header_code = null;
	Hashtable htParameter=new Hashtable();
	eCA.HeaderDomParser parser = new eCA.HeaderDomParser();
	webbeans.eCA.XMLtoHTML converter=new webbeans.eCA.XMLtoHTML();
	StringBuffer sectionContentUpdatedXML=new StringBuffer();
	//url   = HttpUtils.getRequestURL(request).toString();//COMMENTED FOR COMMON-ICN-0015
	//url = url.substring(0,url.indexOf("jsp/"));
	//url = url.substring(0,url.indexOf("eOR/"));//COMMENTED FOR COMMON-ICN-0015
	
	url	= application.getRealPath("eOR/"); //COMMENTED FOR COMMON-ICN-0015
	url = url.substring(0,url.indexOf("eOR")); //COMMENTED FOR COMMON-ICN-0015
	url1 = url + "eCA/html/RecClinicalNotesTemplateDispayView.xsl";
	url =url+"eCA/html/RecClinicalNotesTemplateSentenceView.xsl";
	java.sql.Clob			clob_notes_content	= null;
	java.io.Reader			content_reader		= null;
	java.io.BufferedReader	bf_content_reader	= null;
	String	section_content			=	"";
	String	section_content_rpt		=	"";
	String	section_content_ftr		=	"";
	String	login_user_id		=	(String)session.getValue("login_user");
	String  sect_template_query		=	"";
	String	episode_type	=	"" ;
	String	discharge_date		=	"", med_service 	=	"", location_code 	=	"";
	//  IN047204 - Start
	String 	dmsExternalLinkYN		=	bean.getExternalDmsLinkYN(facility_id); 
	String	op_episode_visit_num	=	""; 
	String	attend_practitioner_id	=	""; 
	String	assign_care_locn_type	=	""; 
	String	assign_care_locn_code	=	""; 
	String perfFacilityId = "";
	String ext_encounter_id = "";
	String ord_type_code = "";
	String ord_category = "";
	String epis_type = "";
	//  IN047204 - End
	//Bru-HIMS-CRF-195.3 - IN049578[IN047205] - Start
	String ext_image_appli_id = "";
	String ext_image_obj_id_intf = "";
	String ext_image_source = "";
	String ext_srce_doc_ref_no = "";
	String ext_srce_doc_ref_line_no = "";
	ArrayList externalList = null;
	//Bru-HIMS-CRF-195.3 - IN049578[IN047205] - End
	String acc_for_notefooter = "";//IN052367
	boolean isSiteSpecific = false; // IN062669
	//IN064132 changes starts
	String resulted_practitioner = "";
	boolean isPracSiteSpecific = false;
	//IN064132 changes ends
	String confPrevYN = "";//IN064215
	//String view_by = request.getParameter("view_by");//IN064215 //commented for Checkstyle
	String view_by = request.getParameter("view_by");//	IN061961
	String fac_id = "";//IN065970
	String out_event_code="",eventCode="";//IN071127
	HashMap<String,String> paramMap = null;
	PreparedStatement pstmtImgView1 = null; //7902
	ResultSet resImgView1 = null;//7902
	String study_id="",ext_img_disable="",param_def_str="",ext_img_display="";//7902
	//Included to avoid Exception - start IN0EMG	
	try
	{	
		con	= ConnectionManager.getConnection();
		isSiteSpecific = eCommon.Common.CommonBean.isSiteSpecific(con, "OR","WCH_OR_RESULT_VIEWED"); // IN062669
		isPracSiteSpecific = eCommon.Common.CommonBean.isSiteSpecific(con, "OR","RESULTED_PRACTITIONER"); //Added for IN064132
	try
	{
	
		//sect_template_query = "select TEMPLATE_FORMAT from CA_SECTION_HDG where  SEC_HDG_CODE =? " ;
		if(	episode_type.equals("O") ){				
			query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,AM_GET_DESC.AM_PRACTITIONER(?,?,'2') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'2') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?) site_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner,ASSIGN_BED_NUM bed_number,  a.op_episode_visit_num, a.attend_practitioner_id, a.assign_care_locn_type, a.assign_care_locn_code FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE A.FACILITY_ID=? AND A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ?";//a.op_episode_visit_num, a.attend_practitioner_id, 	a.assign_care_locn_type, a.assign_care_locn_code columns added for IN0IN047204 
		}else{ 
			query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,AM_GET_DESC.AM_PRACTITIONER(?,?,'2') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'2') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?) site_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner,ASSIGN_BED_NUM bed_number,  a.op_episode_visit_num, a.attend_practitioner_id, a.assign_care_locn_type, a.assign_care_locn_code FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE A.FACILITY_ID=? AND A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ? "; //a.op_episode_visit_num, a.attend_practitioner_id, 	a.assign_care_locn_type, a.assign_care_locn_code columns added for IN0IN047204
		}
		pstmt	=	con.prepareStatement(query_privilege_type);
		pstmt.setString	(	1,	locale	);
		pstmt.setString	(	2,	locale	);
		pstmt.setString	(	3,	locale	);
		pstmt.setString	(	4,	locale	);
		pstmt.setString	(	5,	performed_by_id	);
		pstmt.setString	(	6,	locale	);
		pstmt.setString	(	7,	locale	);			
		pstmt.setString	(	8,	locale	);			
		pstmt.setString	(	9,	locale	);			
		pstmt.setString	(	10,	locale	);			
		pstmt.setString	(	11,	facility_id	);
		pstmt.setString	(	12,	encounter_id);

		rs		=	pstmt.executeQuery();

		if(rs.next())
		{
			patient_class			=	rs.getString("patient_class") == null ? "" : rs.getString("patient_class");
			facility_name			=	rs.getString("facility_name") == null ? "" : rs.getString("facility_name");
			visit_adm_date			=	rs.getString("visit_adm_date")==null?"":rs.getString("visit_adm_date");
			med_service				=	rs.getString("service_name")==null?"":rs.getString("service_name");
			discharge_date			=	rs.getString("DISCHARGE_DATE_TIME")==null?"":rs.getString("DISCHARGE_DATE_TIME");
			attending_practitioner	=	rs.getString("attending_practitioner")==null?"":rs.getString("attending_practitioner");
			admitting_practitioner	=	rs.getString("admitting_practitioner")==null?"":rs.getString("admitting_practitioner");
			bed_number	=	rs.getString("bed_number")==null?"":rs.getString("bed_number");	  //--[IN:029839]--
			performing_phy_name		=	rs.getString("performed_by_name")==null?"":rs.getString("performed_by_name");
			age						=	rs.getString("AGE")==null?"":rs.getString("AGE");
			gender					=	rs.getString("gender")==null?"":rs.getString("gender");
			//locationDesc			=	rs.getString("location");
			location_code			=	rs.getString("location_code")==null?"":rs.getString("location_code");
			patient_name			=	rs.getString("patient_name")==null?"":rs.getString("patient_name");
			speciality_name			=	rs.getString("specialty_name")==null?"":rs.getString("specialty_name");
			printDateTime			=	rs.getString("print_date_time")==null?"":rs.getString("print_date_time");
			site_name				=	rs.getString("site_name")==null?"":rs.getString("site_name");
			//performed_by_desc		=	rs.getString("performed_by_desc);
			// added for IN047204 - Start
			op_episode_visit_num	=	rs.getString("op_episode_visit_num")==null?"":rs.getString("op_episode_visit_num");
			attend_practitioner_id	=	rs.getString("attend_practitioner_id")==null?"":rs.getString("attend_practitioner_id");
			assign_care_locn_type	=	rs.getString("assign_care_locn_type")==null?"":rs.getString("assign_care_locn_type");
			assign_care_locn_code	=	rs.getString("assign_care_locn_code")==null?"":rs.getString("assign_care_locn_code");
			epis_type				= 	rs.getString("patient_class") == null ? "" : rs.getString("patient_class");
			// added for IN047204 - End
		}
		orParamFac=bean.orParamFacility(con, facility_id);
		hideReportPrac = (String)orParamFac.get("HIDE_REPORTINGPRAC");//IN066119
		hideSpecimenType = (String)orParamFac.get("HIDE_SPECIMENTYPE");//IN066119

		if(gender.equals("M"))
				Sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
		else if (gender.equals("F"))
				Sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
		else 
				Sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

		if(discharge_date==null)
		{
			discharge_date="";
		}
		if(patient_class.equals("OP"))
			patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
		else if(patient_class.equals("IP"))
			patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
		else if(patient_class.equals("EM"))
			patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
		else if(patient_class.equals("DC"))
			patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");
				
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		if(rs!=null)	rs.close();
		if(pstmt!=null)	pstmt.close();
	}
			
	//INO30714 ends

	try
	{
		repPractList = (ArrayList) bean.getRepPractCnt(orderId,order_line_num,patient_id,resp_id,facility_id,ord_cat,order_status,cont_order_ind);
		
		if(repPractList.size() > 0)
			tempPractChk = (String) repPractList.get(0);
		else
			tempPractChk = "";
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
//Commented for check style starts
	//String crit_str			= result_data[3];
	//String crit_high_str	= result_data[4];
	//String crit_low_str		= result_data[5];
//Commented for check style Ends
 	String slClassValue = "", textClassValue = "";
	//String[] Records 			= null;
	//ArrayList orderlineno=new ArrayList();
	//int chart=0;
	//int order_line=0;

	//IN042552 Start.
	String clinician_id			= (String)session.getValue("ca_practitioner_id") == null ? "" : (String) session.getValue("ca_practitioner_id");
	//allValues = bean.viewResultDetail(orderId,order_line_num,cont_order_ind,patient_id,ord_cat,facility_id,resp_id,order_status,pract_reln_id);
	//allValues = bean.viewResultDetail(orderId,order_line_num,cont_order_ind,patient_id,ord_cat,facility_id,resp_id,order_status,pract_reln_id,clinician_id);
	allValues = bean.viewResultDetail(orderId,order_line_num,cont_order_ind,patient_id,ord_cat,facility_id,resp_id,order_status,pract_reln_id,clinician_id,event_code1,view_by);//	IN061961
	
	// IN042552 End.
	
	TreeMap first_map = null;
	ArrayList panels = bean.panels ;
	ArrayList discrete = bean.discrete ;
	
		if(allValues.size() == 0){
			//out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common')); window.close()</script>");
			//IN064215 start
			confPrevYN = bean.confAccessPrevYN(orderId,order_line_num,cont_order_ind,patient_id,ord_cat,facility_id,resp_id,order_status,pract_reln_id,clinician_id);
			
			if(confPrevYN == "Y")
			{
				out.println("<script>alert(getMessage('NOT_AUTHORIZED_TO_VIEW_CONFIDENTIAL_RESULT','OR')); window.close()</script>");
			}
			else
			{
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common')); window.close()</script>");
			}
			//IN064215 ends
		}else{
			if(allValues.size() > 0)
			{
				//IN062669 starts
				if(isSiteSpecific)
					bean.insertResultViewer(orderId,order_line_num,login_user_id,login_at_ws_no,facility_id);
				//IN062669 ends
				String [] print_details = {"","","","","","","",""};//IN039857
				print_details = (String[])bean.getOrderDetails(orderId);

				String report_srl_no	= "";
				//print_details			= bean.getPrintDetails(orderId);
				print_details	= (String[])bean.getOrderDetails(orderId);
					
				first_map		= (TreeMap)bean.traverseList(1,allValues,first_map);
				TreeMap second_map			= (TreeMap)bean.traverseList(2,allValues,first_map);
				TreeMap third_map			= (TreeMap)bean.traverseList(9,allValues,second_map);
				TreeMap all_times			= (TreeMap)bean.getAllTimes(9,allValues);
				HashMap key_value_map1 = (HashMap)bean.getKeyValueData1();
				HashMap key_value_map2 = (HashMap)bean.getKeyValueData2();
					
				Set all_times_set = (Set)all_times.keySet();
				Iterator itr_times = (Iterator)all_times_set.iterator() ;
				Iterator itr        = (Iterator)all_times_set.iterator() ; // For the Hdg loop

				out.println("<table cellpadding=3 cellspacing=0 border=1 width='100%'>");
				out.println("<tr><td class='columnheader' width='25%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.EventDescription.label","common_labels")+"</td>");

				if (Integer.parseInt(request.getParameter("timeHeader")) != 1)
				{
					if(itr.hasNext())
					{
						itr.next();
						//IN063813 changes starts
						//out.println("<td class='columnheader' width='70%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Results.label","or_labels")+"</td>");//Commented for IN063813
						out.println("<td class='columnheader' width='60%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Results.label","or_labels")+"</td>");
						out.println("<td class='columnheader' width='15%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.RefRange.label","or_labels")+"</td>");
						//IN063813 changes Ends
					}
					out.println("</tr>");
					/*out.println("<tr><th width='30%' nowrap>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>");
					String time_val = "";
					if(itr_times.hasNext()){
					time_val = (String)itr_times.next();
					out.println("<th width='30%' nowrap>"+time_val+"</th>");
					}
					out.println("</tr>");*/
				}
				else
				{
					out.println("<td class='columnheader'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Results.label","or_labels")+"</td>");
					out.println("<td class='columnheader'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.RefRange.label","or_labels")+"</td>");//Added for IN063813
				}

				int i=1;
				String temp_hdr_time = "";
				String temp_panel_key="";  //[32119]
				// panel Iteration
				for(int K = 0 ; K < panels.size() ; K++)
				{
					String ext_image_obj_id			= "";
					String ext_image_appl_id		= "";
					String hist_rec_type			= "";
					String contr_sys_id				= "";
					String contr_sys_event_code		= "";
					String accession_num			= "";
					String panel_key 				= (String)panels.get(K);	
					TreeMap dscr_map 				= (TreeMap)third_map.get(panel_key);
					itr_times = (Iterator)all_times_set.iterator() ;
					


					//Iterate Time values of header
					while(itr_times.hasNext())
					{
						String hdr_time = (String)itr_times.next();
						//out.println("<tr><td colspan='"+(all_times.size()+1)+"' class='OR_QRYEVENBORDER'></td></tr>");//Modified colspan for IN063813
						out.println("<tr><td colspan='"+(all_times.size()+2)+"' class='OR_QRYEVENBORDER'></td></tr>");//Modified colspan for IN063813
						//---[IN029928]/Start---
						/*
						out.println("<tr><td class='columnheader' width='30%' nowrap></td>");
						if(!hdr_time.equalsIgnoreCase(temp_hdr_time))
						{
							out.println("<td class='columnheader' width='70%' nowrap>"+com.ehis.util.DateUtils.convertDate(hdr_time,"DMYHM","en",localeName)+"</td></tr>");
							temp_hdr_time = hdr_time;
						}
						if(dscr_map.size() > 1) // this is in the case of existance of more than one descr msr panel id's
							out.println("<tr><td class='CAHIGHERLEVELCOLOR' colspan='"+(all_times.size()+1)+"'><b><font size='2'>"+(key_value_map1.get(panel_key)==null?"":(String)key_value_map1.get(panel_key))+"</font></b></td></tr>");
						*/
						//---[IN029928]/Ends-----
				
						// descr iteration
						for(int l = 0; l < discrete.size(); l++)
						{ 
							//Added by Siva Kumar on 10/9/2003
							String color = "";
							String toolTipText = "";
							//End of Addition

							//i++;

							if(i % 2 == 0)
							{
								//slClassValue = "QRYEVEN";
								slClassValue = "gridData";
								textClassValue = "RESULTTEXTAREAEVEN";
							}
							else
							{
								//slClassValue = "QRYODD";
								slClassValue = "gridData";
								textClassValue = "RESULTTEXTAREAODD";
							}

							//String dscr_key = (String)dscr_itr.next();
							String dscr_key =  (String)discrete.get(l);

							if(!dscr_map.containsKey(dscr_key.trim()))
								continue ;
							//Added by Siva Kumar on 10/9/2003
							TreeMap time_val_map = (TreeMap)dscr_map.get(dscr_key);
							//itr_times = (Iterator)all_times_set.iterator() ;
					
						
							Object obj = time_val_map.get(hdr_time);
							if(obj != null)
							{
								//---[IN029928]/Start---
														
								if(!hdr_time.equalsIgnoreCase(temp_hdr_time))
								{
									out.println("<tr><td class='columnheader' width='30%' nowrap>&nbsp;</td>");	
									//IN063813 changes starts
									//out.println("<td class='columnheader' width='70%' nowrap>"+com.ehis.util.DateUtils.convertDate(hdr_time,"DMYHM","en",localeName)+"</td></tr>");
									out.println("<td class='columnheader' width='60%' nowrap>"+com.ehis.util.DateUtils.convertDate(hdr_time,"DMYHM","en",localeName)+"</td>");
									out.println("<td class='columnheader' width='15%' nowrap>&nbsp;</td></tr>");	
									//IN063813 changes ends
									temp_hdr_time = hdr_time;					
									temp_panel_key = "";
								}
								//[32119] Start
								/*if(dscr_map.size() > 1) // this is in the case of existance of more than one descr msr panel id's
								{
								out.println("<tr><td class='CAHIGHERLEVELCOLOR' colspan='"+(all_times.size()+1)+"'><b><font size='2'>"+(key_value_map1.get(panel_key)==null?"":(String)key_value_map1.get(panel_key))+"</font></b></td></tr>");
								} */
								
								String panel_value = (key_value_map1.get(panel_key)==null?"":(String)key_value_map1.get(panel_key));
								if(!panel_value.equalsIgnoreCase(temp_panel_key)){
									//[IN031684]if(dscr_map.size() > 1) // this is in the case of existance of more than one descr msr panel id's
									//[IN031684]{
										//out.println("<tr><td class='CAHIGHERLEVELCOLOR' colspan='"+(all_times.size()+1)+"'><b><font size='2'>"+(key_value_map1.get(panel_key)==null?"":(String)key_value_map1.get(panel_key))+"</font></b></td></tr>");//Modified Colspan for IN063813
										out.println("<tr><td class='CAHIGHERLEVELCOLOR' colspan='"+(all_times.size()+2)+"'><b><font size='2'>"+(key_value_map1.get(panel_key)==null?"":(String)key_value_map1.get(panel_key))+"</font></b></td></tr>");//Modified Colspan for IN063813
										temp_panel_key = panel_value;
									//[IN031684]}							
								}
								//[32119] End
								//---[IN029928]/Ends-----
								String value_arr[] = (String[]) obj;
	 
            _bw.write(_wl_block10Bytes, _wl_block10);
            _bw.write(_wl_block11Bytes, _wl_block11);

								//if(value_arr.length == 33)  Ramesh
								//if(value_arr.length == 34)
								//IN064132 changed array length from 35 to 36
								//if(value_arr.length == 36) // modified for  Bru-HIMS-CRF-052.1
								//if(value_arr.length == 37) //IN065970//IN071404
								//if(value_arr.length == 38) //IN071404
								if(value_arr.length == 39) //29803
								{
									if (value_arr[22] != null && (!(value_arr[22]).equals("")))
									{
										if (value_arr[22].equals("*LB_REFLEX_REG*"))
										{
											color = "LIGHTYELLOW";
											textClassValue = "RESULTTEXTAREAYELLOW";
											toolTipText = "This test is ordered at the time of Registration";
										}
										else if (value_arr[22].equals("*LB_REFLEX_RES*"))
										{
											color = "TAN";
											textClassValue = "RESULTTEXTAREATAN";
											toolTipText = "This test is ordered at the time of Resulting based on Reflex Test";
										}
										else if (!value_arr[22].equals(request.getParameter("practitioner_id")))
										{
											color = "Gray";
											textClassValue = "RESULTTEXTAREAGRAY";
											toolTipText = "ordered by : " + value_arr[22];
										}
									}
									ext_image_obj_id	= (value_arr[23]==null)?"":value_arr[23];
									
									ext_image_appl_id	= (value_arr[24]==null)?"":value_arr[24];
									reporting_practitioner  = value_arr[25];
									if(reporting_practitioner == null){ //IN062978
										reporting_practitioner = "";
									} // IN062978
									// ML-MMOH-SCF-0491 [IN061489] - Start
									/*
									if(reporting_practitioner != null && !reporting_practitioner.equals(""))
									{
										if(!tempPractChk.equals(reporting_practitioner) && !reporting_practitioner.equals(""))
											reporting_practitioner = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ReportingPractitioner.label","or_labels")+ " : "+bean.getRepPractName(reporting_practitioner,localeName);
										else
											reporting_practitioner = "";
									}
									else
									{		
										reporting_practitioner = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ReportingPractitioner.label","or_labels")+ " :"; //"<B>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.repPractNotSpc.label","or_labels")+"</B>";
									}
									*/
									//IN064132 changes starts
									/*
									if(reporting_practitioner != null && !reporting_practitioner.equals(""))
									{
										reporting_practitioner = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ReportingPractitioner.label","or_labels")+ " : "+bean.getRepPractName(reporting_practitioner,localeName);
									}
									*/
									hist_rec_type			= (value_arr[26]==null)?"":value_arr[26];//IN064132
									if(isPracSiteSpecific && "LBIN".equals(hist_rec_type))
									{
										resulted_practitioner = (value_arr[35]==null)?"":value_arr[35];
										if(resulted_practitioner != null && !resulted_practitioner.equals(""))
										{
											reporting_practitioner = "<BR>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ReportingPractitioner.label","or_labels")+ " :<BR> "+bean.getRepPractName(resulted_practitioner,localeName);
										}
									}
									else{
										if(reporting_practitioner != null && !reporting_practitioner.equals(""))
										{
											reporting_practitioner = "<BR>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ReportingPractitioner.label","or_labels")+ " :<BR> "+bean.getRepPractName(reporting_practitioner,localeName);
										}
										
									}
									//IN064132 changes ends
									// ML-MMOH-SCF-0491 [IN061489] - End
									//hist_rec_type			= (value_arr[26]==null)?"":value_arr[26];//IN064132
									contr_sys_id			= (value_arr[27]==null)?"":value_arr[27];
									accession_num			= (value_arr[28]==null)?"":value_arr[28];
									contr_sys_event_code	= (value_arr[29]==null)?"":value_arr[29];
									ext_image_upld_id 		= (value_arr[34]==null)?"":value_arr[34]; // added for  Bru-HIMS-CRF-052.1 [IN037793]
									fac_id				= (value_arr[36]==null)?"":value_arr[36]; //IN065970 reopen
									eventCode			=(value_arr[37]==null)?"":value_arr[37];//IN071127
								}
								//else if (value_arr.length == 32)  Ramesh
								//IN064132 changed array length from 33 to 34
								//else if (value_arr.length == 34)//IN065970
								//else if (value_arr.length == 35) //IN065970//IN070610
								//else if (value_arr.length == 36) //IN065970//IN070610
								else if (value_arr.length == 37) //29803
								{
									//INO30714 Starts
									accession_num			= (value_arr[27]==null)?"":value_arr[27];
									try
									{
										
										//String head_foot_qry ="select a.FOOTER_CODE,a.REPORT_HEADER_CODE from ca_note_type a where  a.NOTE_TYPE=?";
										String head_foot_qry ="select a.FOOTER_CODE,a.REPORT_HEADER_CODE from ca_note_type a where  a.NOTE_TYPE_DESC=?";
										pstmt2	= con.prepareStatement(head_foot_qry);
										
										//pstmt2.setString(1,"2345");
										pstmt2.setString(1,(String)key_value_map2.get(dscr_key));
										rs2 = pstmt2.executeQuery();

										while(rs2.next())
										{
											//note_header_code = rs2.getString("NOTE_HEADER_CODE")==null?"":rs2.getString("NOTE_HEADER_CODE");
											footer_code = rs2.getString("FOOTER_CODE")==null?"":rs2.getString("FOOTER_CODE");
											report_header_code = rs2.getString("REPORT_HEADER_CODE")==null?"":rs2.getString("REPORT_HEADER_CODE");
										}

				
									}
									catch(Exception ee)
									{
										//out.println("Exceptionin ResultViewOrderDetail.jsp @ head_foot_qry : "+ee.toString());//COMMON-ICN-0181
										ee.printStackTrace();
									}
									finally
									{
										if(rs2 != null) rs2.close();
										if(pstmt2 != null) pstmt2.close();
										//if(con!=null) con.close();
									}
									
									try
									{
										sect_template_query = "select TEMPLATE_FORMAT from CA_SECTION_HDG where  SEC_HDG_CODE =? " ;
										pstmt2	= con.prepareStatement(sect_template_query);
										pstmt2.setString(1,report_header_code);
										rs2 = pstmt2.executeQuery();


										if(rs2.next())
										{
											clob_notes_content			=	(java.sql.Clob) rs2.getObject("TEMPLATE_FORMAT");
											
											if(clob_notes_content!=null)
											{
												try
												{
													//content_reader		= ((oracle.sql.CLOB) clob_notes_content).getCharacterStream();
													content_reader		= ((java.sql.Clob) clob_notes_content).getCharacterStream();
													bf_content_reader	= new java.io.BufferedReader(content_reader);
													char[] arr_notes_content = new char[(int)clob_notes_content.length()];
													bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
													section_content = new String(arr_notes_content);
													bf_content_reader.close();
													if(section_content == null)
														section_content = "";
												}
												catch(Exception e)
												{
													//out.println("Exception@1-readCLOB : "+e);//COMMON-ICN-0181
													e.printStackTrace();
												}


											}
										}
									}

									catch(Exception eee)
									{
										//out.println("Exceptionin ResultViewOrderDetail.jsp getting section content : "+eee.toString());//COMMON-ICN-0181
										eee.printStackTrace();

									}
									finally
									{
										if(rs2 != null) rs2.close();
										if(pstmt2 != null) pstmt2.close();
										//if(con!=null) con.close();
									}
								if(!accession_num.equals(""))
								{
									ext_image_obj_id		= (value_arr[22]==null)?"":value_arr[22];//IN052367
									try
									{
										String athorise_by_qry ="select AM_GET_DESC.AM_PRACTITIONER(a.AUTHORIZED_BY_ID,?,'1') AUTHORIZED_BY_ID,AM_GET_DESC.AM_PRACTITIONER(a.LAST_AMENDED_BY_ID,?,'1') LAST_AMENDED_BY_ID,a.DOC_REF_ID,AM_GET_DESC.AM_PRACTITIONER(a.PERFORMED_BY_ID,?,'1') performed_by_name,AM_GET_DESC.AM_SERVICE(a.SERVICE_CODE,?,'2') service_name from CA_ENCNTR_NOTE a where a.ACCESSION_NUM = ? and a.PATIENT_ID = ? " ;

										pstmt2	= con.prepareStatement(athorise_by_qry);
										pstmt2.setString(1,locale);
										pstmt2.setString(2,locale);
										pstmt2.setString(3,locale);
										pstmt2.setString(4,locale);
										//IN052367 - Start
										if(accession_num.contains("!"))
											acc_for_notefooter = ext_image_obj_id;
										else
											acc_for_notefooter = accession_num;
											
										pstmt2.setString(5,acc_for_notefooter);
										//pstmt2.setString(5,accession_num);
										//IN052367 - End
										pstmt2.setString(6,patient_id);
										rs2 = pstmt2.executeQuery();
										while(rs2.next())
										{
											//authorized_by		=	checkForNull( rs2.getString("AUTHORIZED_BY_ID") );
											//last_amended_by		=	checkForNull( rs2.getString("LAST_AMENDED_BY_ID") );
											//doc_ref_id		=	checkForNull( rs2.getString("DOC_REF_ID") );
											//authorized_by		=	rs2.getString("AUTHORIZED_BY_ID") ;
											//last_amended_by		=	rs2.getString("LAST_AMENDED_BY_ID");
											//doc_ref_id		=	 rs2.getString("DOC_REF_ID") ;
											authorized_by		=	rs2.getString("AUTHORIZED_BY_ID")==null?"":rs2.getString("AUTHORIZED_BY_ID") ;//IN030996
											last_amended_by		=	rs2.getString("LAST_AMENDED_BY_ID")==null?"":rs2.getString("LAST_AMENDED_BY_ID");//IN030996
											doc_ref_id		=	 rs2.getString("DOC_REF_ID")==null?"":rs2.getString("DOC_REF_ID") ;//IN030996
										}
									}
									catch (Exception roro )

									{
										//out.println("Exceptionin ResultViewOrderDetail.jsp getting section content : "+roro.toString());//COMMON-ICN-0181
										roro.printStackTrace();

									}
									finally 
									{
										if(rs2 != null) rs2.close();
										if(pstmt2 != null) pstmt2.close();
										//if(con!=null) con.close();
									}
								}
								encounter_id1 = encounter_id ;
								if(encounter_id.equals("0"))
								{
									encounter_id1 ="";
								}
					
								if(!visit_adm_date.equals(""))
								{
									visit_adm_date					=	com.ehis.util.DateUtils.convertDate(visit_adm_date,"DMYHM","en",locale);
								}
					
								if(!discharge_date.equals(""))
								{
									discharge_date					=	com.ehis.util.DateUtils.convertDate(discharge_date,"DMYHM","en",locale);
								}



								//out.println("RecClinicalNotesPrint.jsp:patient_name:"+patient_name);
								htParameter.put("V$ATT_PRACT", attending_practitioner);
								htParameter.put("V$ADM_PRACT", admitting_practitioner);
								htParameter.put("V$BED_NUM", bed_number);	//---[IN:029839]---
								htParameter.put("V$PT_SPLTY", speciality_name);
								//--[IN029296]  - Start
								if(patient_name.trim().equals(""))
									htParameter.put("V$PT_NAME", default_pat_name);
								else
									htParameter.put("V$PT_NAME", patient_name);
								//--[IN029296]  - End
								htParameter.put("V$PT_ID", patient_id);
								htParameter.put("V$SEX", Sex);
								htParameter.put("V$AGE", age);
								htParameter.put("V$ENC_ID", encounter_id1);
								htParameter.put("V$ADM_DT", visit_adm_date); //visit_adm_date
								htParameter.put("V$DIS_DT", discharge_date); //discharge_date
								htParameter.put("V$MED_SERV", med_service);
								htParameter.put("V$DOC_REF_H", doc_ref_id);
								htParameter.put("V$PT_LOCN", location_code); //patient_loc
								htParameter.put("V$PT_CLASS", patient_class);//patient_class
					
								//sectionContentUpdatedXML = new StringBuffer();
								StringBuffer section_content_new = new StringBuffer(section_content);
					
								if (! locale.equals("en") )
								{
									if(!section_content_new.toString().equals(""))
									{
										paramMap = new HashMap<String,String>();
										paramMap.put("CURR_SEC_HDG_CODE",report_header_code);
										paramMap.put("LOCALE",locale);						
										paramMap.put("RANGE_PASER_YN","N");
										eCA.TemplateLangRepParser tempLangParse = new eCA.TemplateLangRepParser(con,paramMap,section_content_new);
										section_content_new = tempLangParse.getLangReplacedXML();
										tempLangParse = null;
									}


								}
					
								if(!section_content_new.toString().equals(""))
								{
									sectionContentUpdatedXML = parser.updateXMLContentValues(section_content_new,htParameter,locale);
								}

								if(!(sectionContentUpdatedXML.toString().equals("")))
								{								
									section_content_rpt=converter.buildHTMLFromXML(sectionContentUpdatedXML.toString(),url1);
									//section_content_rpt=converter.buildHTMLFromXML(sectionContentUpdatedXML.toString(),"eCA/html/RecClinicalNotesTemplateDispayView.xsl");
									
								}
							//Report Header Ends
							
							// changes notes footer starts
							section_content= "";

							try
							{
				
								//String footer_sect_query = "select TEMPLATE_FORMAT from CA_SECTION_HDG where  SEC_HDG_CODE =? " ;
								pstmt2	= con.prepareStatement(sect_template_query);
								pstmt2.setString(1,footer_code);
								rs2 = pstmt2.executeQuery();


								if(rs2.next())
								{
					
									clob_notes_content			=	(java.sql.Clob) rs2.getObject("TEMPLATE_FORMAT");
									if(clob_notes_content!=null)
									{
										try
										{
											//content_reader		= ((oracle.sql.CLOB) clob_notes_content).getCharacterStream();
											content_reader		= ((java.sql.Clob) clob_notes_content).getCharacterStream();
											bf_content_reader	= new java.io.BufferedReader(content_reader);
											char[] arr_notes_content = new char[(int)clob_notes_content.length()];
											bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
											section_content = new String(arr_notes_content);
											bf_content_reader.close();
										
											if(section_content == null)
											section_content = "";
										}
										catch(Exception e)
										{
											//out.println("Exception@1-readCLOB : "+e);//COMMON-ICN-0181
											e.printStackTrace();
										}


									}
								}
							}

							catch(Exception eee)
							{
								//out.println("Exceptionin ResultViewOrderDetail.jsp getting section content : "+eee.toString());//COMMON-ICN-0181
								eee.printStackTrace();

							}
							finally
							{
								if(rs2 != null) rs2.close();
								if(pstmt2 != null) pstmt2.close();
							}

							if(!printDateTime.equals(""))
							{
								printDateTime					=	com.ehis.util.DateUtils.convertDate(printDateTime,"DMYHM","en",locale);
							}

							htParameter=new Hashtable();
							htParameter.put("V$CUR_USR", login_user_id);
							htParameter.put("V$AT_PRACT", authorized_by);
							htParameter.put("V$LT_MODI_USR", last_amended_by);
							htParameter.put("V$PRN_DTTIME", printDateTime);//printDateTime
							htParameter.put("V$DOC_REF_F", doc_ref_id);
							htParameter.put("V$LT_PT_P_C_D", pract_sign);

							section_content_new = new StringBuffer(section_content);
							sectionContentUpdatedXML = new StringBuffer();
							
							if (! locale.equals("en") )
							{
								if(!section_content_new.toString().equals(""))
								{
									paramMap = new HashMap<String,String>();
									paramMap.put("CURR_SEC_HDG_CODE",footer_code);
									paramMap.put("LOCALE",locale);						
									paramMap.put("RANGE_PASER_YN","N");
									eCA.TemplateLangRepParser tempLangParse = new eCA.TemplateLangRepParser(con,paramMap,section_content_new);
									section_content_new = tempLangParse.getLangReplacedXML();
									tempLangParse = null;
								}

							}
							
					
							if(!section_content_new.toString().equals(""))
							{
								sectionContentUpdatedXML = parser.updateXMLContentValues(section_content_new,htParameter,locale);
							}

					
							if(!(sectionContentUpdatedXML.toString().equals("")))
							{								
							
								section_content_ftr=converter.buildHTMLFromXML(sectionContentUpdatedXML.toString(),url1);

							}
							//Footer Ends
						//INO30714 Ends
						
						ext_image_obj_id	= (value_arr[22]==null)?"":value_arr[22];
						ext_image_appl_id	= (value_arr[23]==null)?"":value_arr[23];
						reporting_practitioner = value_arr[24]==null?"&nbsp;":value_arr[24];
						fac_id				= (value_arr[34]==null)?"":value_arr[34]; //IN065970 reopen
						if(reporting_practitioner == null){ //IN062978
							reporting_practitioner = "";
						} // IN062978
							//  ML-MMOH-SCF-0491 [IN061489] - Start
							/*if(reporting_practitioner != null && !reporting_practitioner.equals(""))
							{
								if(!tempPractChk.equals(reporting_practitioner))
									reporting_practitioner = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ReportingPractitioner.label","or_labels")+ " : "+bean.getRepPractName(reporting_practitioner,localeName);
								else
									reporting_practitioner = "";
							}
							else
							{
								reporting_practitioner = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ReportingPractitioner.label","or_labels")+ " :"; //"<B>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.repPractNotSpc.label","or_labels")+"</B>";
							}*/
							//IN064132 Changes starts
							/*
							if(reporting_practitioner != null && !reporting_practitioner.equals(""))
							{
								reporting_practitioner = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ReportingPractitioner.label","or_labels")+ " : "+bean.getRepPractName(reporting_practitioner,localeName);
							}
							*/
							hist_rec_type			= (value_arr[25]==null)?"":value_arr[25];
							if(isPracSiteSpecific && "LBIN".equals(hist_rec_type))
							{
								resulted_practitioner = (value_arr[33]==null)?"":value_arr[33];
								if(resulted_practitioner != null && !resulted_practitioner.equals(""))
								{
									reporting_practitioner = "<BR>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ReportingPractitioner.label","or_labels")+ " :<BR>  "+bean.getRepPractName(resulted_practitioner,localeName);
								}
							}
							else{
								if(reporting_practitioner != null && !reporting_practitioner.equals(""))
								{
									reporting_practitioner = "<BR>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ReportingPractitioner.label","or_labels")+ " :<BR> "+bean.getRepPractName(reporting_practitioner,localeName);
								}
								
							}
							//IN064132 Changes ends
							//  ML-MMOH-SCF-0491 [IN061489] - End
							//hist_rec_type			= (value_arr[25]==null)?"":value_arr[25];//IN064132
							contr_sys_id			= (value_arr[26]==null)?"":value_arr[26];
							//accession_num			= (value_arr[27]==null)?"":value_arr[27];//INO30714
							contr_sys_event_code	= (value_arr[28]==null)?"":value_arr[28];
						}
						//reporting_date 	= value_arr[9];
						report_srl_no	= value_arr[0];
							}
							if (!color.equals(""))
								slClassValue = color;
							//End of Addition

							if(obj != null) 					//[IN029928]
							{						//[IN029928]
							
							if(dscr_map.size()>1)
							{
								//IN066119 changes starts
								//out.println("<tr VALIGN='TOP' ><td width='30%' nowrap title = '"+toolTipText+"' class = '"+slClassValue+"' >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+(String)key_value_map2.get(dscr_key)+" <br> "+reporting_practitioner+" </td>");
								if("Y".equals(hideReportPrac))
								out.println("<tr VALIGN='TOP' ><td width='30%' nowrap title = '"+toolTipText+"' class = '"+slClassValue+"' >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+(String)key_value_map2.get(dscr_key)+"</td>");
								else
								out.println("<tr VALIGN='TOP' ><td width='30%' nowrap title = '"+toolTipText+"' class = '"+slClassValue+"' >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+(String)key_value_map2.get(dscr_key)+" <br> "+reporting_practitioner+" </td>");
								//IN066119 changes ends
								i++;
							}
							else
							{
								//IN066119changes starts
								//out.println("<tr VALIGN='TOP' ><td width='30%' nowrap title = '"+toolTipText+"'  class = '"+slClassValue+"' ><b>"+(String)key_value_map2.get(dscr_key)+" <br> "+reporting_practitioner+" </b></td>");
								if("Y".equals(hideReportPrac))
								out.println("<tr VALIGN='TOP' ><td width='30%' nowrap title = '"+toolTipText+"'  class = '"+slClassValue+"' ><b>"+(String)key_value_map2.get(dscr_key)+"</b></td>");
								else
								out.println("<tr VALIGN='TOP' ><td width='30%' nowrap title = '"+toolTipText+"'  class = '"+slClassValue+"' ><b>"+(String)key_value_map2.get(dscr_key)+" <br> "+reporting_practitioner+" </b></td>");
								//IN066119 changed ends
								i++;
							}						
								
								String value_arr[] = (String[]) obj;
								String abnorm_result[] = new String[2];
								String normalcy_ind = value_arr[15];
								String normalcy_ind_disp = "";
								
								abnorm_result = bean.getAbnormalLegend(normalcy_ind);

								if(!(CommonBean.checkForNull(abnorm_result[1])).equals(""))
								{
									if(abnorm_result[0].equals("S"))
										normalcy_ind_disp = "<font  style='background-image:url(\"../../eCA/images/"+abnorm_result[1]+"\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>";
									else
										normalcy_ind_disp = "<font style='background-color:"+abnorm_result[1]+";size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>";
								}
								else if(!(CommonBean.checkForNull(value_arr[11]).trim()).equals("") && !(CommonBean.checkForNull(value_arr[12]).trim()).equals(""))
								{
									if(!(CommonBean.checkForNull(value_arr[5]).trim()).equals(""))
									{
										if(Float.parseFloat(value_arr[5]) > 0)
										{
											if((Float.parseFloat(value_arr[5]) >= Float.parseFloat(value_arr[11])) && (Float.parseFloat(value_arr[5]) <= Float.parseFloat(value_arr[12])))
											{
												if(abnorm_result[0].equals("S"))
													normalcy_ind_disp = "<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>";
												else
													normalcy_ind_disp = "<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>";
											}
										}
									}
								}
								else if(normalcy_ind != null) //Added by Jyothi to fix IN023229
								{
									if(normalcy_ind.equals("."))
									{
										if(abnorm_result[0].equals("S"))
											normalcy_ind_disp = "<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>";
										else
											normalcy_ind_disp = "<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>";
									}
								}
								
								String result_str = value_arr[7];
								if(result_str == null) result_str = "";
								//IN054648 Start.
								result_str  = result_str.replaceAll("<","&lt;");
								result_str  = result_str.replaceAll(">","&gt;");
								//IN054648 End.
								if(result_str.contains("/"))
								{
									if(result_str.matches("^[0-9]{1,2}/[0-9]{1,2}/[0-9]{4} [0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2}"))
									{
										if(com.ehis.util.DateUtils.validDate(result_str,"DMYHMS",localeName))
										{
											result_str = com.ehis.util.DateUtils.convertDate(result_str,"DMYHMS","en",localeName);
										}
									}
									else if(result_str.matches("^[0-9]{1,2}/[0-9]{1,2}/[0-9]{4} [0-9]{1,2}:[0-9]{1,2}"))
									{
										if(com.ehis.util.DateUtils.validDate(result_str,"DMYHM",localeName))
										{
											result_str = com.ehis.util.DateUtils.convertDate(result_str,"DMYHM","en",localeName);
										}
									}
									else if(result_str.matches("^[0-9]{1,2}/[0-9]{1,2}/[0-9]{4}"))
									{
										if(com.ehis.util.DateUtils.validDate(result_str,"DMY",localeName))
										{
											result_str = com.ehis.util.DateUtils.convertDate(result_str,"DMY","en",localeName);
										}
									}
								}
								out.println("<td title = '"+toolTipText+"' class = '"+slClassValue+"'><font size=1><table><tr>");
								out.println("<td>");
								//IN040745 changed array length from 34 to 35
								//IN064132 changed array length from 35 to 36
								//if(value_arr.length == 36){ //IN065970
								//if(value_arr.length == 37){ //IN065970
								//if(value_arr.length == 38){ //IN071404
								if(value_arr.length == 39){ //29803
									if(!(CommonBean.checkForNull(value_arr[33],"").trim()).equals("") && (CommonBean.checkForNull(value_arr[33],"").trim()).equals("Y") && !(CommonBean.checkForNull(value_arr[5],"").trim()).equals("")){
										out.println("<table><tr><td>");
										if(!normalcy_ind_disp.equals(""))
											out.println("&nbsp;"+normalcy_ind_disp);
										out.println("&nbsp;"+CommonBean.checkForNull(value_arr[30]));
										out.println("&nbsp;"+CommonBean.checkForNull(value_arr[5]));			
										if(!CommonBean.checkForNull(value_arr[6]).equals(""))
										{   
										   out.println("&nbsp;"+value_arr[6]);				
										}
										/*
										if(!((CommonBean.checkForNull(value_arr[11]).trim()).equals("") || (CommonBean.checkForNull(value_arr[12]).trim()).equals("") ))
										{									
											out.println("&nbsp;("+CommonBean.checkForNull(value_arr[11])+" - "+ CommonBean.checkForNull(value_arr[12])+")"); 
										}
										*/ //Commented for IN063813
										out.println("</td></tr></table>");
									}
									//ML-BRU-SCF-1652 [IN058413] Start.
									else{
										out.println("<table><tr><td>");
											if(!normalcy_ind_disp.equals(""))
												out.println("&nbsp;"+normalcy_ind_disp);
										out.println("</td></tr></table>");
									}
									//ML-BRU-SCF-1652 [IN058413] End.
									//IN064132 changed array length from 33 to 34
								//}else if(value_arr.length == 34){ //IN065970
								//}else if(value_arr.length == 35){ //IN065970//IN070610
								//}else if(value_arr.length == 36){ //IN065970//IN070610
								}else if(value_arr.length == 37){ //29803
									if(!(CommonBean.checkForNull(value_arr[32],"").trim()).equals("") && (CommonBean.checkForNull(value_arr[32],"").trim()).equals("Y") && !(CommonBean.checkForNull(value_arr[5],"").trim()).equals("")){
										out.println("<table><tr><td>");
										if(!normalcy_ind_disp.equals(""))
											out.println("&nbsp;"+normalcy_ind_disp);
										out.println("&nbsp;"+CommonBean.checkForNull(value_arr[29]));
										out.println("&nbsp;"+CommonBean.checkForNull(value_arr[5]));			
										if(!CommonBean.checkForNull(value_arr[6]).equals(""))
										{   
										   out.println("&nbsp;"+value_arr[6]);				
										}
										/*
										if(!((CommonBean.checkForNull(value_arr[11]).trim()).equals("") || (CommonBean.checkForNull(value_arr[12]).trim()).equals("") ))
										{									
											out.println("&nbsp;("+CommonBean.checkForNull(value_arr[11])+" - "+ CommonBean.checkForNull(value_arr[12])+")"); 
										}
										*/ //Commented for IN063813
										out.println("</td></tr></table>");
									}
									//ML-BRU-SCF-1652 [IN058413] Start.
									else{
										out.println("<table><tr><td>");
											if(!normalcy_ind_disp.equals(""))
												out.println("&nbsp;"+normalcy_ind_disp);
										out.println("</td></tr></table>");
									}
									//ML-BRU-SCF-1652 [IN058413] End.
								}								
								if(!("Y".equals(hideSpecimenType)&& "LBIN".equals(hist_rec_type))){//IN066119
									if((CommonBean.checkForNull(value_arr[20],"").trim()).equals("NUM") || (CommonBean.checkForNull(value_arr[20],"").trim()).equals("TXT") || (CommonBean.checkForNull(value_arr[20],"").trim()).equals("HTM")){
															
										if(result_str!=null && !result_str.equals(""))
										{
											out.println("<table><tr><td>");
											//[IN032246] Start.
												
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(textClassValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(CommonBean.checkForNull(result_str)));
            _bw.write(_wl_block14Bytes, _wl_block14);

												/*if(result_str.length() > 40)
												{
												
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(textClassValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(result_str));
            _bw.write(_wl_block17Bytes, _wl_block17);

												}else{
												
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(textClassValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(CommonBean.checkForNull(result_str)));
            _bw.write(_wl_block14Bytes, _wl_block14);

												}*/
											//[IN032246] End.
											out.println("</td></tr></table>");
										}
									}else if((CommonBean.checkForNull(value_arr[20],"").trim()).equals("STR")){
										if(result_str!=null && !result_str.equals(""))
										{
											out.println("<table><tr><td>");
											//[IN032246] Start.
												
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(textClassValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(CommonBean.checkForNull(result_str)));
            _bw.write(_wl_block14Bytes, _wl_block14);

												/*if(result_str.length() > 40)
												{
												
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(textClassValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(result_str));
            _bw.write(_wl_block17Bytes, _wl_block17);

												}else{
												
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(textClassValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(CommonBean.checkForNull(result_str)));
            _bw.write(_wl_block14Bytes, _wl_block14);

												}	*/	
											//[IN032246] End.
												//IN040745 changed array length from 34 to 35
												//IN064132 changed array length from 35 to 36
												//if(value_arr.length == 36 && value_arr[31]!=null) //IN065970
												//if(value_arr.length == 37 && value_arr[31]!=null) //IN065970//IN071404
												//if(value_arr.length == 38 && value_arr[32]!=null) //IN065970
												if(value_arr.length == 39 && value_arr[32]!=null) //29803
												{ 
												out.println("<font color=blue>( Normal Value : "+value_arr[32]+" )</font>"); 
												}
												//IN064132 changed array length from 33 to 34
												//else if(value_arr.length == 34 && value_arr[30]!=null) //IN065970
												//else if(value_arr.length == 35 && value_arr[30]!=null) //IN065970
												//else if(value_arr.length == 36 && value_arr[31]!=null) //IN065970//IN070610
												else if(value_arr.length == 37 && value_arr[31]!=null) //29803
												{
												out.println("<font color=blue>( Normal Value : "+value_arr[31]+" )</font>");
												}
											out.println("</td></tr></table>");
										}							
									}
								}
								
								if((CommonBean.checkForNull(value_arr[20],"").trim()).equals("HTM") || (CommonBean.checkForNull(value_arr[20],"").trim()).equals("STR"))
								{	
									String txt= CommonBean.checkForNull(value_arr[8]);
									if(txt.indexOf("</ADDRESS></table>") != -1)
										txt = txt.replaceAll("</ADDRESS></table>","</ADDRESS>");
									txt = txt.replaceAll("</TD></TR><tr><td>&nbsp;</td></tr></table></BODY></HTML>","");
									txt = txt.replaceAll("<HTML><BODY>","");
									txt = txt.replaceAll("</BODY></HTML>","");
									txt = txt.replaceAll("font-family:Courier New;FONT-SIZE:9pt","font-family:Courier New;FONT-SIZE:8pt");//IN039067
									txt = txt.replaceAll("<TR><TD colspan=","<TR><TD style='word-wrap:break-word;width:40em;' colspan=");//IN039067
									txt = txt.replaceAll("<TR><TD> ","<TR><TD style='word-wrap:break-word;width:40em;'> "); //IN039067
									out.println("<table width='100%'><tr><td>");//IN039067
									//[IN032246] Start
									//out.println(txt);
									//IN039067 Start
									
									
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(textClassValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(txt));
            _bw.write(_wl_block19Bytes, _wl_block19);

									
									/*if(txt.indexOf("<TR>") != -1){
									
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(textClassValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(txt));
            _bw.write(_wl_block19Bytes, _wl_block19);

									}else{	
										String tempsplit[] = txt.split("\n");							
										int indicate=0;
										int indicator=0;
										for(int n = 0; n < tempsplit.length; n++){
											String tempRow=tempsplit[n];
											if(n>0 && n < (tempsplit.length -1) && indicate==0){
												if(((tempsplit[n-1]).contains("-"))&&((tempsplit[n+1]).contains("-")))
												{
													indicate=indicate++;
													indicator=n;
												}
											}
											if(!(tempRow.length()>90)){	//[IN029203] Start.									
												
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(textClassValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(tempRow));
            _bw.write(_wl_block14Bytes, _wl_block14);

												//[IN029203] End.
												if(tempRow.length()>0 && !tempRow.contains("-") && indicator!=n )
												out.println("\n");	
											}else{
												StringBuffer br = new StringBuffer(tempRow);
												StringBuffer tempStr = new StringBuffer();
												int k = 0;
												for(int q = 0; q < br.length(); q++)
												{
													if( q == (k+90))
													{
														String st = br.substring(k,q);
														//[IN029203] Start.
														//out.println("<PRE>"+st+"</PRE>");
														tempStr.append(st);
														tempStr.append("\n");
														
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(textClassValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(st));
            _bw.write(_wl_block21Bytes, _wl_block21);

														//[IN029203] End.
														k += 90;
													}
												}	
												//[IN029203] Start.
												//out.println("<PRE >"+br.substring(k, br.length())+"</PRE>");
												
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(textClassValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(tempStr));
            out.print( String.valueOf(br.substring(k, br.length())));
            _bw.write(_wl_block14Bytes, _wl_block14);

												//[IN029203] End.
												if(tempRow.length()>0 && !tempRow.contains("-") && indicator!=n)
													out.println("\n");
											}
										}
									}*/
									//IN039067 End.
									
									out.println("</td></tr></table>");								
									//out.println("<table border='2'cellpadding='0' cellspacing='2' width='100%'><tr><td>"+section_content_ftr+"</td></tr></table></td>");
									out.println("<table border='2'cellpadding='0' cellspacing='2' width='100%'><tr><td>");
									
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(textClassValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(section_content_ftr));
            _bw.write(_wl_block19Bytes, _wl_block19);

									//[IN032246] End.
									out.println("</td></tr></table></td>");	
								}else
								{		
									
									if(value_arr[8] != null && (!(value_arr[8].equals(""))) && !"".equals(CommonBean.checkForNull(value_arr[20],"").trim()))
									{
										out.println("<table><tr><td>");
										bean.setClobData(value_arr[8], value_arr[21]);
										
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(textClassValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(value_arr[8]));
            _bw.write(_wl_block23Bytes, _wl_block23);

										/*if(value_arr[8].length() > 40)
										{
										
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(textClassValue));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(toolTipTextArea));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(value_arr[21]));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(value_arr[8]));
            _bw.write(_wl_block28Bytes, _wl_block28);
								 
										}else{
										
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(value_arr[8]));
            _bw.write(_wl_block30Bytes, _wl_block30);

										} */
										out.println("</td></tr></table>");
										out.println("</td>");
									} 
								}							
								if(value_arr[16] != null)
								{
								
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(value_arr[16]));
            _bw.write(_wl_block32Bytes, _wl_block32);

								}							
							out.println("</tr></table>");
							// added for IN047204 - Start
							
							if(!orderId.equals(null) && !orderId.equals("")) {
								pstmtPerFacId = con.prepareStatement("select PERFORMING_FACILITY_ID, ENCOUNTER_ID, ORDER_TYPE_CODE, ORDER_CATEGORY	 from or_order where ORDER_ID = ?"); 
								pstmtPerFacId.setString(1,orderId);								
								rsetPerFacId = pstmtPerFacId.executeQuery();
								if(rsetPerFacId.next()){
									perfFacilityId = rsetPerFacId.getString("PERFORMING_FACILITY_ID") == null ? "":  rsetPerFacId.getString("PERFORMING_FACILITY_ID");
									ext_encounter_id = rsetPerFacId.getString("ENCOUNTER_ID") == null ? "":  rsetPerFacId.getString("ENCOUNTER_ID");
									ord_type_code = rsetPerFacId.getString("ORDER_TYPE_CODE") == null ? "":  rsetPerFacId.getString("ORDER_TYPE_CODE");
									ord_category = rsetPerFacId.getString("ORDER_CATEGORY") == null ? "":  rsetPerFacId.getString("ORDER_CATEGORY");
								}
								if(rsetPerFacId  != null) rsetPerFacId.close();
								if(pstmtPerFacId  != null) pstmtPerFacId.close();
							}
							if(("Y").equals(dmsExternalLinkYN) && ("RD").equals(ord_category))
							{	
								//Bru-HIMS-CRF-195.3 - IN049578[IN047205]
								externalList = oEncounterList.getExternalLinkdata(hist_rec_type, contr_sys_id, accession_num, contr_sys_event_code); 
								Iterator iter = externalList.iterator();
								while(iter.hasNext()){
									externalDataDTO = (eCA.CAExternalLinkDataDTO)iter.next();
									ext_image_appli_id = externalDataDTO.getExt_image_appl_id();
									ext_image_obj_id_intf = externalDataDTO.getExt_image_obj_id();
									ext_image_source = externalDataDTO.getExt_image_source();
									ext_srce_doc_ref_no = externalDataDTO.getSrce_doc_ref_no();
									ext_srce_doc_ref_line_no = externalDataDTO.getSrce_doc_ref_line_no();
								//Bru-HIMS-CRF-195.3 - IN049578[IN047205] - End	
								
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(ext_encounter_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(orderId));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(perfFacilityId));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(login_user_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(resp_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(login_at_ws_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(ord_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(op_episode_visit_num));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(attend_practitioner_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(assign_care_locn_type));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(assign_care_locn_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(visit_adm_date));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(epis_type));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(ext_image_appli_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(ext_image_obj_id_intf));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(ext_image_source));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(ext_srce_doc_ref_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(ext_srce_doc_ref_line_no));
            _bw.write(_wl_block35Bytes, _wl_block35);

								}	//Bru-HIMS-CRF-195.3 -  IN049578[IN047205]
							}
							// added for IN047204 - End
							//7902 STARTS
				if(!ext_image_appl_id.equals("")&& ext_image_appl_id.equals("CPACS"))
				{
				
					ext_img_disable="disabled";
					pstmtImgView1 = con.prepareStatement("SELECT PARAM_DEF_STR  FROM CA_EXT_IMAGE_APPL_LANG_VW WHERE  EXT_IMAGE_APPL_ID=?"); 
					pstmtImgView1.setString(1,ext_image_appl_id);
					resImgView1 = pstmtImgView1.executeQuery();
					
					while(resImgView1.next())
					{
						param_def_str = resImgView1.getString("PARAM_DEF_STR") == null ? "" : resImgView1.getString("PARAM_DEF_STR");
					}
					if(pstmtImgView1!=null) pstmtImgView1.close();
					if(resImgView1!=null) resImgView1.close();
					
					if(!param_def_str.equals("") && param_def_str.contains("~STUDY_ID`")){
						
						pstmtImgView = con.prepareStatement("SELECT A.study_id  FROM or_order_line a, cr_encounter_detail b WHERE B.EXT_IMAGE_APPL_ID =? AND to_char(a.ext_appl_accession_num) = b.ext_image_obj_id AND b.ext_image_obj_id=?"); 
						pstmtImgView.setString(1,ext_image_appl_id);
						pstmtImgView.setString(2,ext_image_obj_id);
						resImgView = pstmtImgView.executeQuery();
						
						while(resImgView.next())
						{
							study_id = resImgView.getString("STUDY_ID") == null ? "" : resImgView.getString("STUDY_ID");
						}
						
						if(pstmtImgView!=null) pstmtImgView.close();
						if(resImgView!=null) resImgView.close();
					
					}
					
					
				}
				if(study_id.equals("null"))
					study_id="";
				if(!study_id.equals("") && param_def_str.contains("~STUDY_ID`"))
				{
					ext_img_disable="";
					ext_img_display="Result";
				} 
				else if(!study_id.equals("") && !param_def_str.contains("~STUDY_ID`"))
				{
					ext_img_disable="";
					ext_img_display="Result";
				} 
				else if(study_id.equals("") && param_def_str.contains("~STUDY_ID`") && ext_image_appl_id.equals("CPACS") )
				{
					ext_img_disable="disabled";
					ext_img_display="Study ID not available, we cannot Proceed";
				}
				else if(study_id.equals("") && !param_def_str.contains("~STUDY_ID`"))
				{
					ext_img_disable="";
					ext_img_display="Result";
				}	//7902 ENDS
							
								//Added docul condition for EMG
							if ( (ext_image_appl_id != null && (!ext_image_appl_id.equals("")))) 
							{
								if(!("DOCUL").equals(ext_image_appl_id) && (ext_image_upld_id.equals(null) || ext_image_upld_id.equals("")))  // modified for IN040237 - START
								//if(!("DOCUL").equals(ext_image_appl_id)) //Condition added for EMG // modified for IN040237
								{
									//IN050936 included patient_id
								
            _bw.write(_wl_block36Bytes, _wl_block36);
            _bw.write(_wl_block37Bytes, _wl_block37);
if(ext_img_disable.equals("disabled")) {
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(ext_image_appl_id));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(ext_img_disable));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(ext_img_display));
            _bw.write(_wl_block41Bytes, _wl_block41);
}else{ 
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(hist_rec_type));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(contr_sys_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(ext_image_obj_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(contr_sys_event_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(ext_image_appl_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(ext_image_appl_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(ext_img_display));
            _bw.write(_wl_block45Bytes, _wl_block45);
		
								 		}
								}
								else if (ext_image_upld_id.equals(null) || ext_image_upld_id.equals(""))
								{
								//acc_num  = bean.getRltNoteSts(orderId); 								
								//IN050936 included patient_id
								
            _bw.write(_wl_block46Bytes, _wl_block46);
            _bw.write(_wl_block47Bytes, _wl_block47);
if(ext_img_disable.equals("disabled")) {
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(ext_image_appl_id));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(ext_img_disable));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(ext_img_display));
            _bw.write(_wl_block41Bytes, _wl_block41);
}else{ 
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(hist_rec_type));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(contr_sys_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(contr_sys_event_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(ext_image_appl_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(ext_image_appl_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(ext_img_display));
            _bw.write(_wl_block49Bytes, _wl_block49);

									}
								}
							// added for Bru-HIMS-CRF-052.1 [IN037793]
								else if(!ext_image_upld_id.equals(null) && !ext_image_upld_id.equals("")) {
								
									StringTokenizer st2 = new StringTokenizer(panel_key, "`~");//IN040416
									String event_code = (String)st2.nextElement(); //Changing the contr_sys_event_code to event_code to handle panel issue//IN040416
									pstmtImgView = con.prepareStatement("select EXT_IMAGE_FILE_LOCN_PARAM from CR_EXT_IMAGE_UPLD where EXT_IMAGE_UPLD_ID = ?"); 
									pstmtImgView.setString(1,ext_image_upld_id);
									resImgView = pstmtImgView.executeQuery();
									String recCountInt = "";
									while(resImgView.next())
									{
										ext_img_file_locn = resImgView.getString("EXT_IMAGE_FILE_LOCN_PARAM") == null ? "" : resImgView.getString("EXT_IMAGE_FILE_LOCN_PARAM");
									}
									/* 
									// Code moved to top for IN047204
									//IN040866 - Start 
									String perfFacilityId = "";
									if(!orderId.equals(null) && !orderId.equals("")) {
										pstmtPerFacId = con.prepareStatement("select PERFORMING_FACILITY_ID from or_order where ORDER_ID = ?"); 
										pstmtPerFacId.setString(1,orderId);
										rsetPerFacId = pstmtPerFacId.executeQuery();
										if(rsetPerFacId.next()){
											perfFacilityId = rsetPerFacId.getString("PERFORMING_FACILITY_ID") == null ? "":  rsetPerFacId.getString("PERFORMING_FACILITY_ID");
										}
									}
									//IN040866 - End
									*/
									//IN065970 starts
									//pstmtImgCount = con.prepareStatement("select count(*) from rl_specimen_image_dtls where OPERATING_FACILITY_ID = ? and SPECIMEN_NO = ? and TEST_CODE = ?");
									//pstmtImgCount.setString(1,facility_id); //commented for IN040866
									//pstmtImgCount.setString(1,perfFacilityId);// modified for IN040866
									//IN071127 starts
									//pstmtImgCount = con.prepareStatement("select count(*) from rl_specimen_image_dtls where SPECIMEN_NO = ? and TEST_CODE = ?");
									//pstmtImgCount.setString(1,ext_image_obj_id);
									//pstmtImgCount.setString(3,contr_sys_event_code); //IN040416
									//pstmtImgCount.setString(2,event_code); //IN040416//IN068560 [commented this line and below line uncommented
									//pstmtImgCount.setString(2,contr_sys_event_code); //IN040416//IN068560 for Testing Radiology issue [line is commented in existing from 2013]
									//IN065970 ends
									//rsetImgCount = pstmtImgCount.executeQuery();
									//if(rsetImgCount.next()) 
									{
									//	recCount = rsetImgCount.getInt(1);
									}
									//recCountInt = String.valueOf(recCount);
									CallableStatement cs = con.prepareCall( "{ call rl_image_count(?,?,?,?,?,?)}" );
										cs.setString(1,contr_sys_event_code);
										cs.setString(2,report_srl_no);
										cs.setString(3,eventCode);
										cs.setString(4,patient_id);
										cs.registerOutParameter( 5,  java.sql.Types.VARCHAR ) ;
										cs.registerOutParameter( 6,  java.sql.Types.INTEGER ) ;
										cs.execute() ;
										 out_event_code	= cs.getString( 5 ) ;
										 image_count	= cs.getInt( 6 ) ;
										 //IN071127 ends
									//ext_img_file_locn = ext_img_file_locn.replace("~specNum#",ext_image_obj_id).replace("~test#",contr_sys_event_code).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",facility_id).replace("~user_id#",login_user_id).replace("~language_id#",locale); //commented for IN040866
									//ext_img_file_locn = ext_img_file_locn.replace("~specNum#",ext_image_obj_id).replace("~test#",contr_sys_event_code).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",perfFacilityId).replace("~user_id#",login_user_id).replace("~language_id#",locale);// modified for IN040866
									//IN065970 reopen starts
									//ext_img_file_locn = ext_img_file_locn.replace("~specNum#",ext_image_obj_id).replace("~test#",event_code).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",perfFacilityId).replace("~user_id#",login_user_id).replace("~language_id#",locale);// modified for IN040416
									//ext_img_file_locn = ext_img_file_locn.replace("~specNum#",ext_image_obj_id).replace("~test#",event_code).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",fac_id).replace("~user_id#",login_user_id).replace("~language_id#",locale);// IN065970 reopen ends
									//ext_img_file_locn = ext_img_file_locn.replace("~specNum#",ext_image_obj_id).replace("~test#",contr_sys_event_code).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",fac_id).replace("~user_id#",login_user_id).replace("~language_id#",locale);// IN068560 reopen//IN071127
									ext_img_file_locn = ext_img_file_locn.replace("~specNum#",ext_image_obj_id).replace("~test#",out_event_code).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",fac_id).replace("~user_id#",login_user_id).replace("~language_id#",locale);//IN071127
									//if(recCount > 0) ////IN071127
									if(image_count > 0) {//IN071127
										out.println("<a style='cursor:pointer;color:blue' onClick=\"viewUploadedImg('"+ext_img_file_locn+"')\"> View Image </a>");
									}
									if(resImgView  != null) resImgView.close();
									if(pstmtImgView != null) pstmtImgView.close();

									if(rsetImgCount  != null)  rsetImgCount.close();
									if(pstmtImgCount  != null) pstmtImgCount.close();
									//Commented for IN047204
									/* 
										if(rsetPerFacId  != null) rsetPerFacId.close();
										if(pstmtPerFacId  != null) pstmtPerFacId.close();
									*/	
								}	
							}
							
							//IN070610, starts
							String l_upload_view = "N";
							Integer l_rec_cnt = 0;
							String result_status="";//29803
							//IN070610, ends
							//if(value_arr.length == 34)// commented for BRU-HIMS-52.1 [IN037793]
							//IN064132 changed array length from 35 to 36		
							//if(value_arr.length == 36) // modified for BRU-HIMS-52.1 [IN037793] IN065970
							//if(value_arr.length == 37) //IN065970
							//if(value_arr.length == 38) //IN065970//IN071404
							if(value_arr.length == 39) //29803
							{
								status = CommonBean.checkForNull(value_arr[31]);
								result_status = CommonBean.checkForNull(value_arr[38]); //29803
								System.out.println("ResultViewOrderDetail.jsp=========1644=============>"+result_status);
							//IN064132 changed array length from 33 to 34
							//}else if(value_arr.length == 34) //IN065970
							}
							//else if(value_arr.length == 35) //IN065970//IN070610
							//else if(value_arr.length == 36) //IN065970//IN070610
							else if(value_arr.length == 37) //29803
							{
								status = CommonBean.checkForNull(value_arr[30]);
								result_status = CommonBean.checkForNull(value_arr[36]); //29803
								System.out.println("ResultViewOrderDetail.jsp=======1654===============>"+result_status);
								l_rec_cnt = Integer.parseInt(CommonBean.checkForNull(value_arr[35]));//IN070610
							}
							System.out.println("ResultViewOrderDetail.jsp======================>"+result_status);	
							//IN070610, starts
							if("TR".equals(ord_category) && l_rec_cnt > 0 && uploadFuncTrOrders)
							{
								l_upload_view = "Y";
							}							
							
							if("Y".equals(l_upload_view))								
								out.println("<a style='cursor:pointer;color:blue' onClick=\"uploadedDocuments('"+accession_num+"','"+contr_sys_event_code+"')\"><img src='../../eOR/images/DOCUL.gif' width='16' height='16' border=0 alt='Uploaded Documents'/></a>");
							//IN070610, ends
							
							if(status.equals("P") || result_status.equals("4"))
								out.println("<font color='red'>(Preliminary)</font>");
							
            _bw.write(_wl_block50Bytes, _wl_block50);
	
								if(!((CommonBean.checkForNull(value_arr[11]).trim()).equals("") || (CommonBean.checkForNull(value_arr[12]).trim()).equals("") ))
										{	
											out.println("<table><tr><td>");
											out.println("&nbsp;("+CommonBean.checkForNull(value_arr[11])+" - "+ CommonBean.checkForNull(value_arr[12])+")"); 
											out.println("</td></tr></table>");
										}
							
            _bw.write(_wl_block51Bytes, _wl_block51);

							}						
						}//end of dscr_itr.hasNext()
					}//end of itr_times.hasNext()
				}//end of if dscr_map.size() > 1
			
			//out.println("<tr><td colspan='"+(panels.size()+1)+"' class='OR_QRYEVENBORDER'>&nbsp;</td></tr>");//Modified Colspan for IN063813
			out.println("<tr><td colspan='"+(panels.size()+2)+"' class='OR_QRYEVENBORDER'>&nbsp;</td></tr>");
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(print_details[0]));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(print_details[1]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(print_details[2]));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(print_details[3]));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(print_details[4]));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(print_details[5]));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(print_details[6]));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(report_srl_no));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(ord_cat));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(print_details[7]));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(perfFacilityId));
            _bw.write(_wl_block64Bytes, _wl_block64);

			}
			
		}	
	}catch(Exception eee)
	{
		//out.println("Exceptionin ResultViewOrderDetail.jsp : "+eee.toString());//COMMON-ICN-0181
		eee.printStackTrace();

	}
	finally
	{
		if(con!=null) 
			ConnectionManager.returnConnection(con,request);

	}
	//Included to avoid Exception - End IN0EMG	

            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(orderId));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(view_by));
            _bw.write(_wl_block74Bytes, _wl_block74);

	putObjectInBean(bean_id,bean,request);

            _bw.write(_wl_block3Bytes, _wl_block3);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
