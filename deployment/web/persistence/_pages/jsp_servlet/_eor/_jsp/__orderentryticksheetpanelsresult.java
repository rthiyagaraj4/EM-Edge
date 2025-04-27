package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOR.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import eOR.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __orderentryticksheetpanelsresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/OrderEntryTickSheetPanelsResult.jsp", 1736401032000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t\t<title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/></link>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<!--<script language=\"javascript\" src=\"../../eCommon/js/messages.js\"></script>-->\n\t\t<script language=\"javascript\" src=\"../../eOR/js/OrderEntrySearch.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eOR/js/OrderEntry.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eOR/js/OrderEntryToolTip.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onload = \'\'>\n\t\t<form name=\"tickSheetItemsForm\" id=\"tickSheetItemsForm\" method=\"POST\" action=\"OrderEntryTickSheetPanelsResult.jsp\">\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t<table cellpadding=0 cellspacing=0 width=\"100%\" align=\"center\">\n\t\t\t\t\t\t<tr>\t\t\t\t\n\t\t\t\t\t\t\t<td width=\"80%\" class=\"white\">&nbsp;</td>\n\t\t\t\t\t\t\t<td width=\"20%\" class=\"white\">&nbsp;\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\">\n\t\t\t\t\t<tr>\n\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t\t<td class=\"LABEL\" align=\"RIGHT\" width=\"20%\" onClick=\'parent.displayToolTip(escape(\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"),escape(\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"),\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\",\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\",\"tickSheetItemsForm\",\"\",\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\")\' onMouseOver=\'showToolTip(\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\",\"tickSheetItemsForm\")\' onMouseOut=\"hideToolTip()\"> <font size=1 color=\"BLUE\">\n\t\t\t\t\t\t\t\t<a class=\'gridLink\' href=\'javascript:;\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</a>\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t\t\t\t<td class=\"LABEL\" align=\"left\" width=\"20%\" onMouseOver=\'showToolTip(\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\",\"tickSheetItemsForm\")\' onMouseOut=\"hideToolTip()\"><font size=1>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\t\t\t\t\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"catalog_desc";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" id=\"catalog_desc";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t\t\t\t\t\t\t</font></td>\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t\t<td class=\"LABEL\" align=\"center\" width=\"5%\" >\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t\t\t<!-- IN064543 start -->\n\t\t\t\t\t\t\t\t<!--IN069027 checkDiagnosis method added-->\n\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"ck";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" id=\"ck";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" value=\"Y\" onClick=\'checkDiagnosis(\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\",this);parent.setCheckBoxVal(this,escape(\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\"),\"tickSheetItemsForm\", \"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\", \"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\");";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="showEditor(this,\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="displayToolTipForInstructions(this,escape(\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\",\"tickSheetItemsForm\",\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =" ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =" >\n\t\t\t\t\t\t\t\t<!-- IN064543 end --> \n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"h1";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" id=\"h1";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"h2";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" id=\"h2";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"prompt_desc";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" id=\"prompt_desc";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\"> ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"explanatory_text";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" id=\"explanatory_text";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td class=\"LABEL\" align=\"left\" width=\"3%\" nowrap>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t&nbsp;<img id=\'authorization\"+i+\"\' src=\"../../eOR/images/Authorization.gif\" align=\"center\" title=\"Authorization\"></img>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<img id=\'special_approval\"+i+\"\' src=\"../../eOR/images/SpecialApproval.gif\" align=\"center\" title=\"Special Approval\"></img>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t\t\t&nbsp;</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t\t\t</TR><TR>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\n\n\t\t\t\t</table>\n\t\t\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"order_category\" id=\"order_category\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"check_box_val\" id=\"check_box_val\" value=\"N\">\n\t\t\t\t<input type=\"hidden\" name=\"care_set_check_box_val\" id=\"care_set_check_box_val\" value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"function_from\" id=\"function_from\" value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\" value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"admission_date\" id=\"admission_date\" value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"discharge_date_time\" id=\"discharge_date_time\" value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"priv_applicability_yn\" id=\"priv_applicability_yn\" value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"localeName\" id=\"localeName\" value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"tick_sheet_id\" id=\"tick_sheet_id\" value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"section_code\" id=\"section_code\" value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"order_catalog_nature\" id=\"order_catalog_nature\" value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"order_nature\" id=\"order_nature\" value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"order_dispaly_verticalYN\" id=\"order_dispaly_verticalYN\" value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\"> <!--  IN038787 -->\n\t\t\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t\t<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:20%; visibility:hidden;\' bgcolor=\'blue\'>\n\t\t\t\t\t<table id=\'tooltiptable\' cellpadding=3 cellspacing=0 border=\'0\'  width=\'100%\' height=\'100%\' align=\'center\'>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td width=\'100%\' id=\'t\'></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t</div>\n\t\t</form>\n\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t<!-- IN038787 Start.  -->\n\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\t\t<script>\t\t\t\t\t\t\n\t\t\t\t\t\tcheckFrameMembersTickSheet(\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\', \'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\');\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tcheckFrameMembersTickSheet(\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\n\t\t\t<!-- IN038787 End Here -->\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );
	
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
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      Name        			R.Date		R.Name				Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
01/12/2013	IN038787		Ramesh G			Bru-HIMS-CRF-358
13/03/2014	IN047581		Chowminya	Reduce space between Tick Sheet Section and Order Catalog
24/03/2014	IN047583		Nijitha S	SKR-SCF-0948
17/07/2018	IN064543		Kamalakannan		 17/07/2018		Ramesh G		ML-MMOH-CRF-0776
28/02/2019  IN068370    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0014
28/02/2019  IN068373    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0015
27/05/2019	IN069027	Ramesh G								MMS-DM-CRF-0150
05/02/2020	IN068314	Nijitha S	05/02/2020	Ramesh G	ML-MMOH-CRF-1229
-----------------------------------------------------------------------
*/ 

            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            eCommon.Common.CommonBean CommonBean= null;{
                CommonBean=(eCommon.Common.CommonBean)pageContext.getAttribute("CommonBean");
                if(CommonBean==null){
                    CommonBean=new eCommon.Common.CommonBean();
                    pageContext.setAttribute("CommonBean",CommonBean);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);

			String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			String bean_id 		= request.getParameter("bean_id");
			String bean_name 	= request.getParameter("bean_name");
			CommonBean.setLanguageId(localeName);
			String  order_dispaly_verticalYN			= request.getParameter("order_dispaly_verticalYN")==null?"N":(String)request.getParameter("order_dispaly_verticalYN");  //IN038787
			/* Mandatory checks end */

			/* Initialize Function specific start */
				//OrderEntryBean bean = (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
				OrderEntryBean bean = (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
				bean.setLanguageId(localeName);
				Boolean is_ss_order_catlg_fac_wise = bean.isSiteSpecific("ORDER_CATALOG_FAC_WISE");//IN068370,IN068373
				String ss_order_catlg_fac_wise_yn =  is_ss_order_catlg_fac_wise?"Y":"N";//IN068370,IN068373
				eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) bean.getOrderEntryRecordBean();
			// If it is a new patient set it, other wise get the patient id
			//orderEntryRecordBean.getPatient(bean.getPatientId());
			/* Initialize Function specific end */
			
			String order_type 			= bean.checkForNull(request.getParameter("order_type"),"");
			String activity_type 		= bean.checkForNull(request.getParameter("activity_type"),"");
			String order_category 		= bean.checkForNull(request.getParameter("order_category"),"");
			String tick_sheet_id 		= bean.checkForNull(request.getParameter("tick_sheet_id"),"");
			String section_code 		= bean.checkForNull(request.getParameter("section_code"),"");
			String function_from		= bean.checkForNull(request.getParameter("function_from"),"");
			String order_catalog_nature	= bean.checkForNull(request.getParameter("order_catalog_nature"),"");
			String priv_applicability_yn 		= bean.checkForNull(request.getParameter("priv_applicability_yn"),"");
			
			String prev_group_title		= "";
			String checkedAttribute 	= "";
			String disabled				= "";
			String care_set_order		= "";
			String order_catalog_category = "";
			String entryValue			= "";	
			int display_records = 44;
			
			String key					= (bean.getPatientId()+bean.getEncounterId());
			if(!order_type.equals(""))	order_type = order_type.trim();
			if(!order_category.equals(""))	order_category = order_category.trim();
			if(!tick_sheet_id.equals(""))	tick_sheet_id = tick_sheet_id.trim();
			if(!section_code.equals(""))	section_code = section_code.trim();
			int i=0;int count = 0; // counters for loop
			
			String amend_key			= "";
			HashMap previousValues		= null;
			HashMap amendPreviousValues = null;
			Set setValues 				= null;
			Iterator iterator			= null;
			//ArrayList Panels			= null;
			StringTokenizer stBillMsg	= null;
			//String bill_warn_message	= null;
			//String bill_warn_err_message= null;
			//String bill_error_message	= null;
			String measure_id			= "" , contr_msr_panel_id = "";
			String category				= "";
			String group_title="";
			String p_pract_type = ""; //IN064543
			
			String order_nature = request.getParameter("order_nature");
			String from_obj = null;
			if("S".equals(order_nature)){
				from_obj = "resultHdrFrame";
			}else if("P".equals(order_nature)){
				from_obj = "resultListFrame";
			}else if("A".equals(order_nature)){
				from_obj = "resultDtlFrame";
			}
			
			String sqlQuery				= "";
			String str					= "";
			String orderSetVal = "";
			String panelVal = "";
			String individualVal  = "";
			String frm1 = "" , frm2 = "" , frm3 = "";
			ArrayList records			= null;
			Boolean isfppapplicable = bean.getIsfppapplicable();//IN068314
			String fpp_patient_yn = bean.getFpp_patient_yn();//IN068314
			//sqlQuery 			="SELECT  a.order_catalog_code order_catalog_code, OR_GET_DESC.OR_CATALOG_SYNONYM_LANG(a.ORDER_CATALOG_CODE,or_get_synonym_type (?, a.order_catalog_code),?,'1') catalog_synonym, b.order_category order_category, a.tick_sheet_id, a.section_code, b.order_type_code order_type_code,  b.order_catalog_nature order_catalog_nature, or_performing_facility_id(?,b.order_category, b.order_type_code,b.order_catalog_code,?,?) performing_facility, b.prompt_alert_yn  prompt_alert_yn, b.prompt_alert_msg  prompt_alert_msg,b.security_level security_level,b.consent_reqd_yn consent_reqd_yn,b.consent_form_id  consent_form_id,b.qty_reqd_yn qty_reqd_yn,b.qty_uom qty_uom,b.split_dose_yn split_dose_yn,b.taper_dose_yn taper_dose_yn,b.freq_applicable_yn freq_applicable_yn,b.soft_stop_yn soft_stop_yn,b.cont_order_yn cont_order_yn,b.refill_cont_order_yn refill_cont_order_yn,b.continuous_freq_order continuous_freq_order,b.comment_format_id comment_format_id,b.chk_for_dupl_yn chk_for_dupl_yn,b.ord_auth_level ord_auth_level,b.ord_cosign_level ord_cosign_level,b.ord_spl_appr_level ord_spl_appr_level,b.appt_reqd_yn appt_reqd_yn,b.appt_time appt_time,b.pat_instrn_age_sex_yn pat_instrn_age_sex_yn,b.dept_only_yn dept_only_yn,b.complete_on_order_yn complete_on_order_yn,b.bill_yn bill_yn,b.result_auth_reqd_yn result_auth_reqd_yn,c.ord_auth_reqd_yn ord_auth_reqd_yn,c.ord_cosign_reqd_yn ord_cosign_reqd_yn,c.ord_spl_appr_reqd_yn ord_spl_appr_reqd_yn,b.result_auth_reqd_yn result_auth_reqd_yn,b.chart_result_type chart_result_type,b.discr_msr_panel_id discr_msr_panel_id,b.contr_mod_id contr_mod_id, b.contr_msr_panel_id contr_msr_panel_id, ##FILTERPRIV## b.explanatory_text  FROM (select order_catalog_code,tick_sheet_seq_num,section_code,tick_sheet_id from or_tick_sheet_item where tick_sheet_id = ? and section_code = ? ) a, or_order_catalog b, or_order_catalog_by_ptcl c,or_order_catalog_by_ptcl d WHERE   a.order_catalog_code = b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code and b.order_catalog_nature ='"+order_nature+"' and c.patient_class = NVL ((SELECT patient_class FROM or_order_catalog_by_ptcl WHERE order_catalog_code = a.order_catalog_code AND patient_class = ? AND review_applicablity = 'A'),'*A') AND d.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND SETTING_APPLICABILITY = 'A'),'*A') AND  (D.AGE_GROUP_CODE IS NULL OR  EXISTS (SELECT 1 FROM  AM_AGE_GROUP  WHERE AGE_GROUP_CODE=D.AGE_GROUP_CODE AND NVL(GENDER,'M')=? AND TRUNC(SYSDATE)-to_date(?,'DD/MM/YYYY') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE 		     AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE AND EFF_STATUS='E') ) AND D.SETTING_APPLICABILITY = 'A' AND B.ORDER_CATEGORY in ( select order_category from or_order_category ia where 'Y' =  OR_GET_ACCESS_RULE(?,?,ia.order_category,?,?,?,'','','','','','',a.order_catalog_code,?) and  ia.order_category = nvl(?,ia.order_category)) AND b.eff_Status ='E'   and nvl(activity_type,'!') = nvl(?,nvl(activity_type,'!')) AND b.order_type_code = NVL (?, b.order_type_code)  ##FILTERCAT## ORDER BY b.order_catalog_nature DESC, a.tick_sheet_seq_num";//IN042045//commented for IN064543
	 		//IN068370,IN068373 Start.
			//sqlQuery 			="SELECT  a.order_catalog_code order_catalog_code, OR_GET_DESC.OR_CATALOG_SYNONYM_LANG(a.ORDER_CATALOG_CODE,or_get_synonym_type (?, a.order_catalog_code),?,'1') catalog_synonym, b.order_category order_category, a.tick_sheet_id, a.section_code, b.order_type_code order_type_code,  b.order_catalog_nature order_catalog_nature, or_performing_facility_id(?,b.order_category, b.order_type_code,b.order_catalog_code,?,?) performing_facility, b.prompt_alert_yn  prompt_alert_yn, b.prompt_alert_msg  prompt_alert_msg,b.security_level security_level,b.consent_reqd_yn consent_reqd_yn,b.consent_form_id  consent_form_id,b.qty_reqd_yn qty_reqd_yn,b.qty_uom qty_uom,b.split_dose_yn split_dose_yn,b.taper_dose_yn taper_dose_yn,b.freq_applicable_yn freq_applicable_yn,b.soft_stop_yn soft_stop_yn,b.cont_order_yn cont_order_yn,b.refill_cont_order_yn refill_cont_order_yn,b.continuous_freq_order continuous_freq_order,b.comment_format_id comment_format_id,b.chk_for_dupl_yn chk_for_dupl_yn,b.ord_auth_level ord_auth_level,b.ord_cosign_level ord_cosign_level,b.ord_spl_appr_level ord_spl_appr_level,b.appt_reqd_yn appt_reqd_yn,b.appt_time appt_time,b.pat_instrn_age_sex_yn pat_instrn_age_sex_yn,b.dept_only_yn dept_only_yn,b.complete_on_order_yn complete_on_order_yn,b.bill_yn bill_yn,b.result_auth_reqd_yn result_auth_reqd_yn,c.ord_auth_reqd_yn ord_auth_reqd_yn,c.ord_cosign_reqd_yn ord_cosign_reqd_yn,c.ord_spl_appr_reqd_yn ord_spl_appr_reqd_yn,b.result_auth_reqd_yn result_auth_reqd_yn,b.chart_result_type chart_result_type,b.discr_msr_panel_id discr_msr_panel_id,b.contr_mod_id contr_mod_id,NVL(b.INVOKE_INSTRN_WINDOW_YN,'N')INVOKE_INSTRN_WINDOW_YN,NVL(b.instrn_content_type,'T')instrn_content_type, b.contr_msr_panel_id contr_msr_panel_id, ##FILTERPRIV## b.explanatory_text FROM (select order_catalog_code,tick_sheet_seq_num,section_code,tick_sheet_id from or_tick_sheet_item where tick_sheet_id = ? and section_code = ? ) a, or_order_catalog b, or_order_catalog_by_ptcl c,or_order_catalog_by_ptcl d WHERE   a.order_catalog_code = b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code and b.order_catalog_nature ='"+order_nature+"' and c.patient_class = NVL ((SELECT patient_class FROM or_order_catalog_by_ptcl WHERE order_catalog_code = a.order_catalog_code AND patient_class = ? AND review_applicablity = 'A'),'*A') AND d.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND SETTING_APPLICABILITY = 'A'),'*A') AND  (D.AGE_GROUP_CODE IS NULL OR  EXISTS (SELECT 1 FROM  AM_AGE_GROUP  WHERE AGE_GROUP_CODE=D.AGE_GROUP_CODE AND NVL(GENDER,'M')=? AND TRUNC(SYSDATE)-to_date(?,'DD/MM/YYYY') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE 		     AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE AND EFF_STATUS='E') ) AND D.SETTING_APPLICABILITY = 'A' AND B.ORDER_CATEGORY in ( select order_category from or_order_category ia where 'Y' =  OR_GET_ACCESS_RULE(?,?,ia.order_category,?,?,?,'','','','','','',a.order_catalog_code,?) and  ia.order_category = nvl(?,ia.order_category)) AND b.eff_Status ='E'   and nvl(activity_type,'!') = nvl(?,nvl(activity_type,'!')) AND b.order_type_code = NVL (?, b.order_type_code)  ##FILTERCAT## ORDER BY b.order_catalog_nature DESC, a.tick_sheet_seq_num";//IN064543";
	 		//sqlQuery 			="SELECT  a.order_catalog_code order_catalog_code, OR_GET_DESC.OR_CATALOG_SYNONYM_LANG(a.ORDER_CATALOG_CODE,or_get_synonym_type (?, a.order_catalog_code),?,'1') catalog_synonym, b.order_category order_category, a.tick_sheet_id, a.section_code, b.order_type_code order_type_code,  b.order_catalog_nature order_catalog_nature, or_performing_facility_id(?,b.order_category, b.order_type_code,b.order_catalog_code,?,?) performing_facility, b.prompt_alert_yn  prompt_alert_yn, b.prompt_alert_msg  prompt_alert_msg,b.security_level security_level,b.consent_reqd_yn consent_reqd_yn,b.consent_form_id  consent_form_id,b.qty_reqd_yn qty_reqd_yn,b.qty_uom qty_uom,b.split_dose_yn split_dose_yn,b.taper_dose_yn taper_dose_yn,b.freq_applicable_yn freq_applicable_yn,b.soft_stop_yn soft_stop_yn,b.cont_order_yn cont_order_yn,b.refill_cont_order_yn refill_cont_order_yn,b.continuous_freq_order continuous_freq_order,b.comment_format_id comment_format_id,b.chk_for_dupl_yn chk_for_dupl_yn,b.ord_auth_level ord_auth_level,b.ord_cosign_level ord_cosign_level,b.ord_spl_appr_level ord_spl_appr_level,b.appt_reqd_yn appt_reqd_yn,b.appt_time appt_time,b.pat_instrn_age_sex_yn pat_instrn_age_sex_yn,b.dept_only_yn dept_only_yn,b.complete_on_order_yn complete_on_order_yn,b.bill_yn bill_yn,b.result_auth_reqd_yn result_auth_reqd_yn,c.ord_auth_reqd_yn ord_auth_reqd_yn,c.ord_cosign_reqd_yn ord_cosign_reqd_yn,c.ord_spl_appr_reqd_yn ord_spl_appr_reqd_yn,b.result_auth_reqd_yn result_auth_reqd_yn,b.chart_result_type chart_result_type,b.discr_msr_panel_id discr_msr_panel_id,b.contr_mod_id contr_mod_id,NVL(b.INVOKE_INSTRN_WINDOW_YN,'N')INVOKE_INSTRN_WINDOW_YN,NVL(b.instrn_content_type,'T')instrn_content_type, b.contr_msr_panel_id contr_msr_panel_id, ##FILTERPRIV## b.explanatory_text FROM (select order_catalog_code,tick_sheet_seq_num,section_code,tick_sheet_id from or_tick_sheet_item where tick_sheet_id = ? and section_code = ? ) a, or_order_catalog b, or_order_catalog_by_ptcl c,or_order_catalog_by_ptcl d WHERE   a.order_catalog_code = b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code ##GLOBALANDLOCAL## and b.order_catalog_nature ='"+order_nature+"' and c.patient_class = NVL ((SELECT patient_class FROM or_order_catalog_by_ptcl WHERE order_catalog_code = a.order_catalog_code AND patient_class = ? AND review_applicablity = 'A'),'*A') AND d.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND SETTING_APPLICABILITY = 'A'),'*A') AND  (D.AGE_GROUP_CODE IS NULL OR  EXISTS (SELECT 1 FROM  AM_AGE_GROUP  WHERE AGE_GROUP_CODE=D.AGE_GROUP_CODE AND NVL(GENDER,'M')=? AND TRUNC(SYSDATE)-to_date(?,'DD/MM/YYYY') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE 		     AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE AND EFF_STATUS='E') ) AND D.SETTING_APPLICABILITY = 'A' AND B.ORDER_CATEGORY in ( select order_category from or_order_category ia where 'Y' =  OR_GET_ACCESS_RULE(?,?,ia.order_category,?,?,?,'','','','','','',a.order_catalog_code,?) and  ia.order_category = nvl(?,ia.order_category)) AND b.eff_Status ='E'   and nvl(activity_type,'!') = nvl(?,nvl(activity_type,'!')) AND b.order_type_code = NVL (?, b.order_type_code)  ##FILTERCAT## ORDER BY b.order_catalog_nature DESC, a.tick_sheet_seq_num";//IN064543";IN068314
	 		//Ramesh Start.
			//sqlQuery 			="SELECT  a.order_catalog_code order_catalog_code, OR_GET_DESC.OR_CATALOG_SYNONYM_LANG(a.ORDER_CATALOG_CODE,or_get_synonym_type (?, a.order_catalog_code),?,'1') catalog_synonym, b.order_category order_category, a.tick_sheet_id, a.section_code, b.order_type_code order_type_code,  b.order_catalog_nature order_catalog_nature, or_performing_facility_id(?,b.order_category, b.order_type_code,b.order_catalog_code,?,?) performing_facility, b.prompt_alert_yn  prompt_alert_yn, b.prompt_alert_msg  prompt_alert_msg,b.security_level security_level,b.consent_reqd_yn consent_reqd_yn,b.consent_form_id  consent_form_id,b.qty_reqd_yn qty_reqd_yn,b.qty_uom qty_uom,b.split_dose_yn split_dose_yn,b.taper_dose_yn taper_dose_yn,b.freq_applicable_yn freq_applicable_yn,b.soft_stop_yn soft_stop_yn,b.cont_order_yn cont_order_yn,b.refill_cont_order_yn refill_cont_order_yn,b.continuous_freq_order continuous_freq_order,b.comment_format_id comment_format_id,b.chk_for_dupl_yn chk_for_dupl_yn,b.ord_auth_level ord_auth_level,b.ord_cosign_level ord_cosign_level,b.ord_spl_appr_level ord_spl_appr_level,b.appt_reqd_yn appt_reqd_yn,b.appt_time appt_time,b.pat_instrn_age_sex_yn pat_instrn_age_sex_yn,b.dept_only_yn dept_only_yn,b.complete_on_order_yn complete_on_order_yn,b.bill_yn bill_yn,b.result_auth_reqd_yn result_auth_reqd_yn,c.ord_auth_reqd_yn ord_auth_reqd_yn,c.ord_cosign_reqd_yn ord_cosign_reqd_yn,c.ord_spl_appr_reqd_yn ord_spl_appr_reqd_yn,b.result_auth_reqd_yn result_auth_reqd_yn,b.chart_result_type chart_result_type,b.discr_msr_panel_id discr_msr_panel_id,b.contr_mod_id contr_mod_id,NVL(b.INVOKE_INSTRN_WINDOW_YN,'N')INVOKE_INSTRN_WINDOW_YN,NVL(b.instrn_content_type,'T')instrn_content_type, b.contr_msr_panel_id contr_msr_panel_id, ##FILTERPRIV## b.explanatory_text FROM (select order_catalog_code,tick_sheet_seq_num,section_code,tick_sheet_id from or_tick_sheet_item where tick_sheet_id = ? and section_code = ? ) a, or_order_catalog b, or_order_catalog_by_ptcl c,or_order_catalog_by_ptcl d WHERE   a.order_catalog_code = b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code ##GLOBALANDLOCAL## and b.order_catalog_nature ='"+order_nature+"' and c.patient_class = NVL ((SELECT patient_class FROM or_order_catalog_by_ptcl WHERE order_catalog_code = a.order_catalog_code AND patient_class = ? AND review_applicablity = 'A'),'*A') AND d.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND SETTING_APPLICABILITY = 'A'),'*A') AND  (D.AGE_GROUP_CODE IS NULL OR  EXISTS (SELECT 1 FROM  AM_AGE_GROUP  WHERE AGE_GROUP_CODE=D.AGE_GROUP_CODE AND NVL(GENDER,'M')=? AND TRUNC(SYSDATE)-to_date(?,'DD/MM/YYYY') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE 		     AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE AND EFF_STATUS='E') ) AND D.SETTING_APPLICABILITY = 'A' AND B.ORDER_CATEGORY in ( select order_category from or_order_category ia where 'Y' =  OR_GET_ACCESS_RULE(?,?,ia.order_category,?,?,?,'','','','','','',a.order_catalog_code,?) and  ia.order_category = nvl(?,ia.order_category)) AND b.eff_Status ='E'   and nvl(activity_type,'!') = nvl(?,nvl(activity_type,'!')) AND b.order_type_code = NVL (?, b.order_type_code)  ##FILTERCAT## ##FILTERFPP## ORDER BY b.order_catalog_nature DESC, a.tick_sheet_seq_num";
	 		
			sqlQuery 			="SELECT  a.order_catalog_code order_catalog_code, OR_GET_DESC.OR_CATALOG_SYNONYM_LANG(a.ORDER_CATALOG_CODE,or_get_synonym_type (?, a.order_catalog_code),?,'1') catalog_synonym, b.order_category order_category, a.tick_sheet_id, a.section_code, b.order_type_code order_type_code,  b.order_catalog_nature order_catalog_nature, or_performing_facility_id(?,b.order_category, b.order_type_code,b.order_catalog_code,?,?) performing_facility, b.prompt_alert_yn  prompt_alert_yn, b.prompt_alert_msg  prompt_alert_msg,b.security_level security_level,b.consent_reqd_yn consent_reqd_yn,b.consent_form_id  consent_form_id,b.qty_reqd_yn qty_reqd_yn,b.qty_uom qty_uom,b.split_dose_yn split_dose_yn,b.taper_dose_yn taper_dose_yn,b.freq_applicable_yn freq_applicable_yn,b.soft_stop_yn soft_stop_yn,b.cont_order_yn cont_order_yn,b.refill_cont_order_yn refill_cont_order_yn,b.continuous_freq_order continuous_freq_order,b.comment_format_id comment_format_id,b.chk_for_dupl_yn chk_for_dupl_yn,b.ord_auth_level ord_auth_level,b.ord_cosign_level ord_cosign_level,b.ord_spl_appr_level ord_spl_appr_level,b.appt_reqd_yn appt_reqd_yn,b.appt_time appt_time,b.pat_instrn_age_sex_yn pat_instrn_age_sex_yn,b.dept_only_yn dept_only_yn,b.complete_on_order_yn complete_on_order_yn,b.bill_yn bill_yn,b.result_auth_reqd_yn result_auth_reqd_yn,c.ord_auth_reqd_yn ord_auth_reqd_yn,c.ord_cosign_reqd_yn ord_cosign_reqd_yn,c.ord_spl_appr_reqd_yn ord_spl_appr_reqd_yn,b.result_auth_reqd_yn result_auth_reqd_yn,b.chart_result_type chart_result_type,b.discr_msr_panel_id discr_msr_panel_id,b.contr_mod_id contr_mod_id,NVL(b.INVOKE_INSTRN_WINDOW_YN,'N')INVOKE_INSTRN_WINDOW_YN,NVL(b.instrn_content_type,'T')instrn_content_type, b.contr_msr_panel_id contr_msr_panel_id, ##FILTERPRIV## b.explanatory_text FROM (select order_catalog_code,tick_sheet_seq_num,section_code,tick_sheet_id from or_tick_sheet_item where tick_sheet_id = ? and section_code = ? ) a, or_order_catalog b, or_order_catalog_by_ptcl c,or_order_catalog_by_ptcl d WHERE   a.order_catalog_code = b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code ##GLOBALANDLOCAL## and b.order_catalog_nature ='"+order_nature+"' and c.patient_class = NVL ((SELECT patient_class FROM or_order_catalog_by_ptcl WHERE order_catalog_code = a.order_catalog_code AND patient_class = ? AND review_applicablity = 'A'),'*A') AND d.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND SETTING_APPLICABILITY = 'A'),'*A') AND  (D.AGE_GROUP_CODE IS NULL OR  EXISTS (SELECT 1 FROM  AM_AGE_GROUP  WHERE AGE_GROUP_CODE=D.AGE_GROUP_CODE AND  (1= ( CASE WHEN GENDER IS NULL THEN 1 WHEN GENDER = ? THEN 1 ELSE 0 END ))  AND TRUNC(SYSDATE)-to_date(?,'DD/MM/YYYY') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE 		     AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE AND EFF_STATUS='E') ) AND D.SETTING_APPLICABILITY = 'A' AND B.ORDER_CATEGORY in ( select order_category from or_order_category ia where 'Y' =  OR_GET_ACCESS_RULE(?,?,ia.order_category,?,?,?,'','','','','','',a.order_catalog_code,?) and  ia.order_category = nvl(?,ia.order_category)) AND b.eff_Status ='E'   and nvl(activity_type,'!') = nvl(?,nvl(activity_type,'!')) AND b.order_type_code = NVL (?, b.order_type_code)  ##FILTERCAT## ##FILTERFPP## ORDER BY b.order_catalog_nature DESC, a.tick_sheet_seq_num";
			//Ramesh End.
			//IN068370,IN068373 End.
	 		
	 		if(priv_applicability_yn.equalsIgnoreCase("Y")){				
				sqlQuery = sqlQuery.replace("##FILTERCAT##"," and 'Y' = OR_GET_PRIV_APPL_YN(?,?,'OR',a.order_catalog_code,?)");
				sqlQuery = sqlQuery.replace("##FILTERPRIV##"," OR_GET_PRIV_APPL_YN(?,?,'OR',a.order_catalog_code,?) priv_yn,");				
			}else if(priv_applicability_yn.equalsIgnoreCase("N")){
				sqlQuery = sqlQuery.replace("##FILTERCAT##","");
				sqlQuery = sqlQuery.replace("##FILTERPRIV##","  OR_GET_PRIV_APPL_YN(?,?,'OR',a.order_catalog_code,?) priv_yn,");				
			}else{
				sqlQuery = sqlQuery.replace("##FILTERCAT##","");
				sqlQuery = sqlQuery.replace("##FILTERPRIV##"," 'Y' priv_yn, ");
			}
	 		//IN068370,IN068373 Start.
			if("Y".equals(ss_order_catlg_fac_wise_yn)){
				sqlQuery = sqlQuery.replace("##GLOBALANDLOCAL##"," AND  EXISTS (SELECT 1 FROM OR_ORDER_CATALOG_BY_FACILITY e WHERE e.ORDER_CATALOG_CODE=b.ORDER_CATALOG_CODE AND e.APPLICABLE_FACILITY_ID = ?) ");
			}else{
				sqlQuery = sqlQuery.replace("##GLOBALANDLOCAL##"," ");				
			}
			//IN068370,IN068373 End.
			
			if(isfppapplicable){
			if("Y".equals(fpp_patient_yn)){
				//sqlQuery = sqlQuery.replace("##FILTERFPP##","");
				sqlQuery = sqlQuery.replace("##FILTERFPP##"," AND b.FPP_YN = 'Y' ");
			}
			else{
				sqlQuery = sqlQuery.replace("##FILTERFPP##"," AND (b.FPP_YN IS NULL OR b.FPP_YN = 'N') ");
			}
			}
			else{
				sqlQuery = sqlQuery.replace("##FILTERFPP##","");
			}
			try
			{
				//Common parameters.
				HashMap sqlMap = new HashMap();
					//Include all the common parameters.
				sqlMap.put( "sqlData",sqlQuery);
				
				//Function Parameters
				HashMap funcMap = new HashMap();
					//Display Fields
				
				ArrayList displayFields = new ArrayList();
					displayFields.add( "order_catalog_code" );
					displayFields.add( "catalog_synonym" );
					displayFields.add( "order_catalog_nature" );
					displayFields.add( "discr_msr_panel_id" );  //3
					displayFields.add( "prompt_alert_yn" );
					displayFields.add( "prompt_alert_msg" );
					displayFields.add( "order_category" );
					displayFields.add( "order_type_code" );
					displayFields.add( "ord_auth_reqd_yn" );//8
					displayFields.add( "contr_msr_panel_id" );
					displayFields.add( "ord_spl_appr_reqd_yn" );//10
					displayFields.add( "priv_yn" ); //11
					displayFields.add( "explanatory_text");//12
					displayFields.add( "invoke_instrn_window_yn");//13//IN064543
					displayFields.add( "INSTRN_CONTENT_TYPE");//14//IN064543
				//Where condition put in order
				ArrayList chkFields = new ArrayList();

				chkFields.add( bean.getPractitionerType() );
				chkFields.add( bean.getLanguageId() );
				chkFields.add( bean.getLoginFacilityId() );
				chkFields.add( bean.getLocationType() );

				chkFields.add( bean.getLocationCode() );
				
				if((priv_applicability_yn.equalsIgnoreCase("Y"))||(priv_applicability_yn.equalsIgnoreCase("N"))){
					chkFields.add( bean.getPractitionerId() );
					chkFields.add( bean.getResponsibilityId() );
					chkFields.add( bean.getAuthorisationOrOrderingYn("ORD") );						
				}
				
				chkFields.add( bean.checkForNull(tick_sheet_id.trim(),"") );
				chkFields.add( bean.checkForNull(section_code,"") );
				//IN068370,IN068373 Start.
				if("Y".equals(ss_order_catlg_fac_wise_yn))
					chkFields.add( bean.getLoginFacilityId());					
				//IN068370,IN068373 End.
				chkFields.add( bean.getPatientClass() );
				chkFields.add( bean.getPatientClass() );
				chkFields.add( bean.checkForNull(bean.getSex(),"") );
				chkFields.add( bean.checkForNull(bean.getDob(),"") );
				chkFields.add( bean.getLoginFacilityId() );
				chkFields.add( bean.checkForNull(bean.getEncounterId(),"") );
				chkFields.add( bean.getPatientClass() );
				chkFields.add( bean.getVisitAdmDate() );
				chkFields.add( bean.checkForNull(bean.getDischargeDateTime(),"") );
				chkFields.add( bean.getPractitionerType() );

				if((bean.checkForNull(order_category.trim(),"")).equals("*A")){
					//chkFields.add(null);//IN047583
					chkFields.add("");//IN047583					
				}else{
					chkFields.add( bean.checkForNull(order_category.trim(),""));					
				}
				chkFields.add( bean.checkForNull(activity_type,"") );
				chkFields.add( bean.checkForNull(order_type,"") );
				if(priv_applicability_yn.equalsIgnoreCase("Y")){
					chkFields.add( bean.getPractitionerId() );
					chkFields.add( bean.getResponsibilityId() );
					chkFields.add( bean.getPrivilegeApplicability() );					
				}
				// Adding function related array list into the HashMap
				funcMap.put( "displayFields", displayFields );
				funcMap.put( "chkFields", chkFields );
				//Calling the Result from Common Adapter as an arraylist.
				ArrayList TickSheetItems=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,display_records);
				
            _bw.write(_wl_block9Bytes, _wl_block9);

				// IN047581 Start.
				//if((TickSheetItems.size()>=3) && ( !( ((String) TickSheetItems.get(0)).equals("0")))){
				if((TickSheetItems.size()>=3) && ( !( ((String) TickSheetItems.get(0)).equals("0")) ) && (!(((String)TickSheetItems.get(1)).equals("")))){
				// IN047581 End.
				
            _bw.write(_wl_block10Bytes, _wl_block10);

								// To display the previous/next link
								out.println(TickSheetItems.get(1));
							
            _bw.write(_wl_block11Bytes, _wl_block11);

				}
				
            _bw.write(_wl_block12Bytes, _wl_block12);
		
						// Since at the maximum there will be 100 or 150 records no need for next/previous
						//ArrayList TickSheetItems = bean.getTickSheetItems(order_category,tick_sheet_id,section_code,order_type, activity_type,priv_applicability_yn,l_order_nature);
						records	 =new ArrayList();
						//for(i=0; i<TickSheetItems.size(); i++)
						for(int recCount=2; recCount<TickSheetItems.size(); recCount++)
						{
							checkedAttribute = "";disabled= "";
							//records = (String[])TickSheetItems.get(recCount);
							records=(ArrayList) TickSheetItems.get( recCount );
							
							if(((String)records.get(2)).equalsIgnoreCase("P"))
							{	
								group_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Panel.label","common_labels");
								panelVal = "P";
							}else if(((String)records.get(2)).equalsIgnoreCase("S"))
							{
								group_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderSet.label","or_labels");
								orderSetVal = "S";
							}
							else if(((String)records.get(2)).equalsIgnoreCase("A"))
							{
									group_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Individual.label","common_labels");
									individualVal  = "A";
							}
							if(!prev_group_title.equals(((String)records.get(2))))
							{
								//IN038787 Start.
								/*if( count%4 > 0)
								{
									 for (int u=0;u<4-count%4;u++)
										out.println("<td width=\"20%\"  colspan=\"3\"  align=\"left\">&nbsp;&nbsp;</td>" );
									out.println("</tr>");
								}
								count =0 ;
								out.println("<tr>");
								*/
								if("N".equals(order_dispaly_verticalYN)){
									out.println("<td colspan=\"12\" align=\"center\" class=\"CAGROUP\">"+group_title+" </td>");
									out.println("</tr><tr>");	
								}else if("Y".equals(order_dispaly_verticalYN)){									
									out.println("<td colspan=\"4\" align=\"center\" class=\"CAGROUP\">"+group_title+" </td>");
									out.println("</tr><tr>");
									out.println("<TD width='25%' valign='top'>");
									out.println("<table border='0' cellpadding='0' cellspacing='0' width='100%'  align='center'>");	
								}
								//IN038787 End.
							}
			
							if(((String)records.get(2)).equals("P") || ((String)records.get(2)).equals("S"))
							{
								contr_msr_panel_id 	= (String)records.get(9);
								category     		= (String)records.get(6);
								if(((String)records.get(2)).equals("P")) // Pass the discrete_measure_id & contr_msr_panel_id
								{
									measure_id 		= (String)records.get(3); // discrete_measure_id
								}
								else if(((String)records.get(2)).equals("S")) // Pass the catalog_code
								{
									measure_id 		= (String)records.get(0); // Catalog Code
								}
							} // End of If
			
							if(!((String)records.get(2)).equals("") && (((String)records.get(2)).equalsIgnoreCase("P")) || ((String)records.get(2)).equalsIgnoreCase("S"))
							{
								//IN038787 Start.
								if("Y".equals(order_dispaly_verticalYN)){
								
            _bw.write(_wl_block13Bytes, _wl_block13);

								} //IN038787 End.
							
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(measure_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(contr_msr_panel_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf((String)records.get(2)));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(category));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf((String)records.get(0)));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(from_obj));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf((String)records.get(0)));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf((String)records.get(1)));
            _bw.write(_wl_block21Bytes, _wl_block21);

							}
							else
							{     
								//IN038787 Start.
								if("Y".equals(order_dispaly_verticalYN)){
								
            _bw.write(_wl_block13Bytes, _wl_block13);

								} //IN038787 End.
							
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf((String)records.get(0)));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf((String)records.get(1)));
            _bw.write(_wl_block24Bytes, _wl_block24);

							}  
							
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf((String)records.get(0)));
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf((String)records.get(0)));
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get(1)));
            _bw.write(_wl_block28Bytes, _wl_block28);

							previousValues = (HashMap)orderEntryRecordBean.getCheckedEntries(key);
							if(previousValues!=null)
							{
								setValues 	 = previousValues.keySet();
								iterator 	 = setValues.iterator();
								
								for(int prev_count=0;prev_count<previousValues.size();prev_count++)
								{
									entryValue = ((String)iterator.next()) ;
									if(!care_set_order.equalsIgnoreCase("Y")) // For the First Time, it will be "N"
									{
										// For the Care Sets, to set the Order Category, there will be only one record for Care Sets at a time
										care_set_order = (String)previousValues.get(entryValue) ;
										if(care_set_order.equalsIgnoreCase("CS")) // Only if it is CS
										{
											//Added By Jyothi to fix IN020673 on 14/04/2010
											bean.setTempValues("OrderSetChecked","1");
											care_set_order = "Y";
										}
									}
									// For the checkboxes
									if(entryValue.equalsIgnoreCase("ck"+(String)records.get(0)))
									{
										checkedAttribute	= "CHECKED";
										break;
									}
									else
									   checkedAttribute 	= "";
								} // End of For
							}
							// For Amend of Review Order
							if(bean.getAmendOrder().equalsIgnoreCase("existing_order"))
							{
								amend_key			= (bean.getPatientId()+bean.getEncounterId()+bean.getOrderId());  // Unique key (For Existing Orders) to keep the Value in the Bean
								amendPreviousValues	= (HashMap)orderEntryRecordBean.getCheckedEntries(amend_key);
								if(amendPreviousValues!=null)
								{
									setValues 	 = amendPreviousValues.keySet();
									iterator 	 = setValues.iterator();
									for(int prev_count=0;prev_count<amendPreviousValues.size();prev_count++)
									{
										entryValue = ((String)iterator.next()) ;
										if(entryValue.equalsIgnoreCase("ck"+(String)records.get(0)))
										{
											checkedAttribute = "CHECKED";
											disabled		 = "DISABLED";
											break;
										}
									}
								}
							}
							if(((String)records.get(2)).equals("S")) // For Care Sets
							{
							   order_catalog_category 	= "CS";
							   order_category	  		= "CS";
							}
							else
							   order_catalog_category 	= ((String)records.get(6));
							/*Added by Uma on 8/22/2009 for PMG20089-CRF 641*/
							if((records.get(11))!=null && (((String)records.get(11)).equalsIgnoreCase("Y"))) // To enable or disable the checkbox depending upon the privilege applicability of the Ordering Practitioner
								disabled		 = "";
							else
								disabled		 = "disabled";
							/*End Here*/

							// Billing Informations Retrieved
							/*if(((String)records.get(12))!=null)
							{
								stBillMsg	= new StringTokenizer(((String)records.get(12)),"|");
								while(stBillMsg.hasMoreTokens())
								{
									  bill_warn_message		= stBillMsg.nextToken();
									  bill_warn_err_message	= stBillMsg.nextToken();
									  bill_error_message	= stBillMsg.nextToken();
									  if(bill_warn_message.equals("*")) bill_warn_message 	= "";
									  if(bill_warn_err_message.equals("*")) bill_warn_err_message = "";
									  if(bill_error_message.equals("*")) bill_error_message 	= "";
								}
							}*/
							//String prompt_msg = bean.checkForNull((String)records.get(6),"");
							//prompt_msg = java.net.URLEncoder.encode(prompt_msg);
							
            _bw.write(_wl_block29Bytes, _wl_block29);
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf((String)records.get(0)));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf((String)records.get(0)));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf((String)records.get(6)));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf((String)records.get(4)));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf((String)records.get(0)));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(order_catalog_category));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(from_obj));
            _bw.write(_wl_block36Bytes, _wl_block36);

								if(order_nature.equalsIgnoreCase("A")&& ((String)records.get(13)).equals("Y"))
								{ 
								
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf((String)records.get(0)));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(order_nature));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(order_catalog_category));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(measure_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf((String)records.get(14)));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf((String)records.get(1)));
            _bw.write(_wl_block36Bytes, _wl_block36);

								}else if(order_nature.equalsIgnoreCase("S")||order_nature.equalsIgnoreCase("P")){
								
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(measure_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(contr_msr_panel_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(order_nature));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(order_catalog_category));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf((String)records.get(0)));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(p_pract_type));
            _bw.write(_wl_block36Bytes, _wl_block36);

								}
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(checkedAttribute));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf((String)records.get(0)));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf((String)records.get(0)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(order_catalog_category));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf((String)records.get(0)));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf((String)records.get(0)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((String)records.get(7)));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf((String)records.get(0)));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf((String)records.get(0)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(bean.checkForNull((String)records.get(5),"")));
            _bw.write(_wl_block48Bytes, _wl_block48);
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf((String)records.get(0)));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf((String)records.get(0)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(bean.checkForNull((String)records.get(12),"") ));
            _bw.write(_wl_block48Bytes, _wl_block48);
            _bw.write(_wl_block51Bytes, _wl_block51);
				
								if(((String)records.get(8)).equalsIgnoreCase("Y")) // For Authorization Required
								{
								
            _bw.write(_wl_block52Bytes, _wl_block52);

								}
								
            _bw.write(_wl_block53Bytes, _wl_block53);
 
								if(((String)records.get(10)).equalsIgnoreCase("Y")) // For Special Approval Required
								{
								
            _bw.write(_wl_block54Bytes, _wl_block54);
				
								}	
								
            _bw.write(_wl_block55Bytes, _wl_block55);

							//IN038787 Start.
							if("Y".equals(order_dispaly_verticalYN)){
            _bw.write(_wl_block56Bytes, _wl_block56);
}
							//IN038787 End.
							
            _bw.write(_wl_block24Bytes, _wl_block24);

								i++;
								//IN038787 Start.
								//count++;
								//if( count % 4 == 0)							
								if("N".equals(order_dispaly_verticalYN)){
								//IN038787 End.
									if( i % 4 == 0)
									  out.println("</tr><tr>");
								//IN038787 Start.
								}else if("Y".equals(order_dispaly_verticalYN)){
									if(i==11||i==22||i==33){						
										out.println("</TABLE>");
										out.println("</TD>");
										out.println("<TD width='25%' valign='top'>");
										out.println("<table border='0' cellpadding='0' cellspacing='0' width='100%'  align='center'>");						
									}else if(i==44){
										out.println("</TABLE>");
										out.println("</TD>");
										out.println("</TR>");
									}
								}
								//IN038787 End.
								prev_group_title = (String)records.get(2);
						} // End of for
						//IN038787 Start.
						/*if( count % 4 > 0)
						{
							for (int u=0;u<4-count%4;u++)
								out.println("<td width=\"20%\" colspan=\"3\" align=\"left\">&nbsp;&nbsp;</td>");
								out.println("</tr>");
						}*/
						if("N".equals(order_dispaly_verticalYN)){  
							if( i % 4 > 0)
							{
								for (int u=0;u<4-i%4;u++)
									out.println("<td width=\"20%\" colspan=\"3\" align=\"left\">&nbsp;&nbsp;</td>");
								out.println("</tr>");
							}
							
						}else if("Y".equals(order_dispaly_verticalYN)){
							if( i % 11 > 0)
							{
								for (int u=0;u<10-i%11;u++)
									out.println("<tr><td width=\"20%\" colspan=\"3\" align=\"left\">&nbsp;&nbsp;</td></tr>");
								out.println("</TABLE>");
								out.println("</TD>");
								if(i<11){
									out.println("<TD width='25%' valign='top'>&nbsp;</TD>");
									out.println("<TD width='25%' valign='top'>&nbsp;</TD>");
									out.println("<TD width='25%' valign='top'>&nbsp;</TD>");
								}
								out.println("</TR>");
							}
						}
						//IN038787 End.
						
						if(TickSheetItems.size()==0)
						{
							out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script> ");
						}

						// Nullifying the objects
						previousValues		= null;			amendPreviousValues = null;
						stBillMsg			= null;
						setValues			= null;			iterator			= null;
						TickSheetItems		= null;			records				= null;
						
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(care_set_order));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(bean.getEncounterId()));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(bean.getPatientClass()));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(bean.getVisitAdmDate()));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(bean.getDischargeDateTime()));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(priv_applicability_yn));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(tick_sheet_id));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(section_code));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(order_catalog_nature));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(order_nature));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(order_dispaly_verticalYN));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(CommonBean.setFormTransaction(request)));
            _bw.write(_wl_block74Bytes, _wl_block74);

				// No need to set, no setting it back in the back set it back persistence
				putObjectInBean(bean_id,bean,request);
			}catch(Exception e) {
				  //out.print("Exception @ Result JSP :"+e.toString());//common-icn-0181
		                    e.printStackTrace();//COMMON-ICN-0181
			}
		
            _bw.write(_wl_block75Bytes, _wl_block75);
 	
				Integer pageVist = (Integer) session.getAttribute("pageVist")==null?0: (Integer)session.getAttribute("pageVist");
				int cnt = pageVist.intValue()+1;				
				if(!orderSetVal.equals(""))
				{
					session.setAttribute("orderSetVal", orderSetVal);					
				}

				if(!panelVal.equals(""))
				{
					session.setAttribute("panelVal", panelVal);					
				}

				if(!individualVal.equals(""))
				{
					session.setAttribute("individualVal", individualVal);					
				}			
				session.setAttribute("pageVist", new Integer(cnt));
				frm1 =(String) session.getAttribute("orderSetVal")==null?"": (String)session.getAttribute("orderSetVal");
				frm2 = (String)session.getAttribute("panelVal")==null?"": (String)session.getAttribute("panelVal");
				frm3 = (String)session.getAttribute("individualVal")==null?"": (String)session.getAttribute("individualVal");
				
				if(cnt == 3)
				{	
				
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(frm1));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(frm2));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(frm3));
            _bw.write(_wl_block78Bytes, _wl_block78);

				}
				else if(!order_catalog_nature.equals(""))
				{
				
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(frm1));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(frm2));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(frm3));
            _bw.write(_wl_block78Bytes, _wl_block78);

				}
				
            _bw.write(_wl_block80Bytes, _wl_block80);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.OrderEntryTickSheetItems.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
