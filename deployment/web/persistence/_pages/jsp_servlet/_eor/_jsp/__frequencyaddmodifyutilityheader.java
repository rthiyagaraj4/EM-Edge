package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eOR.*;
import eOR.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __frequencyaddmodifyutilityheader extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/FrequencyAddModifyUtilityHeader.jsp", 1721044652000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!-- Created by Uma on 11/26/2009 for  IN003477-->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntrySearch.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntry.js\"></script>\n\t<script language=\'javascript\' src=\'../../eOR/js/ScheduleFrquency.js\'></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\n<body  OnMouseDown=\"CodeArrest()\"; onKeyDown=\"lockKey()\">\n<form name=\"scheduleFreqencyAddModHeader\" id=\"scheduleFreqencyAddModHeader\" action=\"\" method=\"post\" >\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<table border=\"0\" id=\"frequencyHeader\" cellpadding=0 cellspacing=0 width=\"100%\" class=\"grid\">\n\t<tr>\n\t\t<td width=\"25%\" class=\"gridHeader\"  style=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" nowrap>\n\t\t\t<B>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</B>\n\t\t</td>\n\t\t<td width=\"25%\" class=\"gridHeader\"  style=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t\t\t<select name=\"hdr_duration_type\" id=\"hdr_duration_type\" onchange=\"chkDurationType(this,\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\')\">\n\t\t\t\t<option value=\"D\" ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</option>\n\t\t\t\t<option value=\"W\"  ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</option>\n\t\t\t\t<option value=\"L\" ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</option>\n\t\t\t</select>\n\t\t</td>\n\t\t<td width=\"25%\" class=\"gridHeader\"  style=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t\t\t<B>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t\t\t<select name=\"hdr_frequency_code\" id=\"hdr_frequency_code\" onChange=\"setFrequency(this,";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =",\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\',\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\',\'onChange\');\">\n\t\t\t<option value=\"\">---";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="---</option>\n\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t<option value=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" SELECTED>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</option>\t\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</option>\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t</select>\n\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t<input type=\"hidden\" name=\"hdr_frequency_val\" id=\"hdr_frequency_val\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t\t\t<input type=\"hidden\" name=\"hdr_repeat_value\" id=\"hdr_repeat_value\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"hdr_start_date_time\" id=\"hdr_start_date_time\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t\t\t<input type=\"hidden\" name=\"order_category\" id=\"order_category\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t<td width=\"25%\" class=\"gridHeader\"  style=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</B>\n\t\t</td>\n\t\t<td  colspan =\"3\" class=\"gridHeader\"  style=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t<input type=\"text\"  class=\"NUMBER\" name=\"hdr_duration_value\" id=\"hdr_duration_value\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" size=\"2\" maxLength=\"3\" onKeyPress=\"return(ChkNumberInput(this,event,\'0\'))\" onBlur=\'checkMaxValue(this,\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\",\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\",escape(\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\"),\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\");\'>\n\t\t\t<input type=\"hidden\" class=\"NUMBER\" name=\"hdr_duration_def_value\" id=\"hdr_duration_def_value\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n\t\t\t<select name=\"hdr_duration_code\" id=\"hdr_duration_code\" onchange=\"populateDetail(this)\">\n\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\t\t\n\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" selected>";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\n\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</option>\n\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\t\n\t\t\t</select>\n\t\t<td>\n\t</tr>\n</table>\n<input type=\"hidden\" name=\"mode\" id=\"mode\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n<input type=\"hidden\" name=\"durationType\" id=\"durationType\"\tvalue=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n<input type=\"hidden\" name=\"qry_str\" id=\"qry_str\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n<input type=\"hidden\" name=\"code\" id=\"code\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n<INPUT TYPE=\"hidden\" name=\"bean_id_caller\" id=\"bean_id_caller\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n<INPUT TYPE=\"hidden\" name=\"bean_name_caller\" id=\"bean_name_caller\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n<INPUT TYPE=\"hidden\" name=\"hdr_freq_code\" id=\"hdr_freq_code\" value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n\n<!-- For PH Only -->\n<INPUT TYPE=\"hidden\" name=\"max_qty\" id=\"max_qty\" value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n<INPUT TYPE=\"hidden\" name=\"chk_max\" id=\"chk_max\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n<INPUT TYPE=\"hidden\" name=\"unit_qty\" id=\"unit_qty\" value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n<INPUT TYPE=\"hidden\" name=\"chk_unit\" id=\"chk_unit\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n<INPUT TYPE=\"hidden\" name=\"split_dose_yn\" id=\"split_dose_yn\" value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n<INPUT TYPE=\"hidden\" name=\"split_qty\" id=\"split_qty\" value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n\n\n <!-- For Order Entry Only -->\n<INPUT TYPE=\"hidden\" name=\"visit_adm_date\" id=\"visit_adm_date\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n<INPUT TYPE=\"hidden\" name=\"future_order_date\" id=\"future_order_date\" value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n<INPUT TYPE=\"hidden\" name=\"past_order_date\" id=\"past_order_date\" value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n\n<!-- Start Time Param passed by order entry function -->\n<INPUT TYPE=\"hidden\" name=\"start_day_param\" id=\"start_day_param\" value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n<INPUT TYPE=\"hidden\" name=\"start_time_param\" id=\"start_time_param\" value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n\n\n<INPUT TYPE=\"hidden\" name=\"module_id\" id=\"module_id\" value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n<INPUT TYPE=\"hidden\" name=\"row_value\" id=\"row_value\" value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n<INPUT TYPE=\"hidden\" name=\"loadFlag\" id=\"loadFlag\"  value=\"YES\">\n<INPUT TYPE=\"hidden\" name=\"dummmyDate\" id=\"dummmyDate\"  value=\"\">\n<input type=\"hidden\" name=\"start_day_assign\" id=\"start_day_assign\" value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n<input type=\"hidden\" name=\"pr_duration\" id=\"pr_duration\" value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n<input type=\"hidden\" name=\"pr_duration_type\" id=\"pr_duration_type\" value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n<input type=\"hidden\" name=\"isSchdApplicable\" id=\"isSchdApplicable\" value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\n<input type=\"hidden\" name=\"hdr_freq_nature\" id=\"hdr_freq_nature\" value=\"F\" >\n<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" >\n<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" >\n\n";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\n\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\n";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\n\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n</form>\n";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n</body>\n\n</html>\n\n\n\n\n\n";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );
	
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


private String decodeLocal(String objVal,PageContext pageContext)
{
	String returntext="";
	if(objVal.trim().equalsIgnoreCase(""))
	{
		return	"";
	}

	//Duration Type
	if(objVal.trim().equalsIgnoreCase("M"))		
	{
		returntext=(String)com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Minute(s).label","common_labels");
		return	returntext;
	}
	if(objVal.trim().equalsIgnoreCase("H"))
	{
		returntext=(String)com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Hour(s).label","common_labels");
		return	returntext;
	}
	if(objVal.trim().equalsIgnoreCase("D"))
	{
		returntext=(String)com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Day(s).label","or_labels");
		return	returntext;
	}
	if(objVal.trim().equalsIgnoreCase("W"))
	{
		returntext=(String)com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Week(s).label","or_labels");
		return	returntext;
		
	}
	if(objVal.trim().equalsIgnoreCase("L"))
	{
		returntext=(String)com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Month(s).label","or_labels");
		return	returntext;
		
	}
	if(objVal.trim().equalsIgnoreCase("Y"))
	{
		returntext=(String)com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Year(s).label","or_labels");
		return	returntext;
		
	}
	else
	return "";
}


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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block7Bytes, _wl_block7);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);


/* Mandatory checks start */
	String bean_id	= "OrScheduleFreq" ;
	String bean_name= "eOR.ScheduleFrequencyCompBean";
	OrderEntryBean beanEntry				= (OrderEntryBean)getBeanObject( "orderentrybean", "eOR.OrderEntryBean", request ) ;
	
	String bean_id1= beanEntry.checkForNull(request.getParameter("bean_id"));
	String bean_name1= beanEntry.checkForNull(request.getParameter("bean_name"));
	String catalog_code= beanEntry.checkForNull(request.getParameter("catalog_code"));
	String org_drug_code= beanEntry.checkForNull(request.getParameter("org_drug_code"));
	if((org_drug_code==null)||(org_drug_code.equals("null"))) org_drug_code="";
	String patient_id= beanEntry.checkForNull(request.getParameter("patient_id"));
	String encounter_id= beanEntry.checkForNull(request.getParameter("encounter_id"));
	String mode		=  "1" ;
	//String uom_code		=  "" ;
	//String strDose = "";
	String[] frequencyRecords	   = null;
	String[] recordDefault			= null;
	ArrayList Default				= null;
	ArrayList PlaceOrderFrequency	= null;
	String duration_value					   = "";
	String max_durn_value				   ="";
	String chk_for_max_durn_action  ="";
	String prompt_msg						="";
	String comments							="";
	String softStopYN						="";
	String freqLegendStyle		= "display:inline";
	int i=0;
	boolean isSchdApplicable = true;
	//HashMap schdMap = null;


	if ( !(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) )
		return ;

	String qtyDisabled		    =  ""; //Disable in modify mode

/* Mandatory checks end */

	/* Initialize Function specific start */	
	if(bean_name1.equals("eOR.OrderEntryBean"))
	{
		beanEntry				= (OrderEntryBean)getBeanObject( bean_id1, bean_name1, request ) ;
		beanEntry.setLanguageId(localeName);
		 qtyDisabled		=  "disabled";
	}

	ScheduleFrequencyCompBean bean = (ScheduleFrequencyCompBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.clear() ;
	bean.setMode(mode) ;
	/* Initialize Function specific end */

	/******Caller Bean name and id*******/
	String bean_id_P			= bean.checkForNull(request.getParameter("bean_id"));
	String bean_name_P			= bean.checkForNull(request.getParameter("bean_name"));	
	
	/**************/
try
{

	/*Parameters Passed*/
	String freq_code			=bean.checkForNull( request.getParameter("freq_code"));
	//String facility_id			=bean.checkForNull( request.getParameter("facility_id"));
	String durationType_P		= bean.checkForNull(request.getParameter("interval_durn_type"));
	String pr_duration_type		= bean.checkForNull(request.getParameter("pr_duration_type")); 	
	String pr_duration		=  bean.checkForNull(request.getParameter("pr_duration"));
	String pr_duration_display		=  bean.checkForNull(request.getParameter("pr_duration"));
	if(pr_duration_display == null)
		pr_duration_display = "";
	
	if(pr_duration == null || pr_duration.equals(""))
		pr_duration = "0";
	
	
	String code					= bean.checkForNull(request.getParameter("code"));
	mode						= bean.checkForNull(request.getParameter( "mode" ),"1");
	if(mode.equalsIgnoreCase("2"))
	{
		if(catalog_code.equals(""))
		{
			catalog_code = code.substring(13);
		}
	}

	String row_value			=bean.checkForNull( request.getParameter("row_value"));	
	String module_id			= bean.checkForNull(request.getParameter("module_id"));	
 	String order_category		= bean.checkForNull(request.getParameter("order_category"));
	if(order_category.equals("")) order_category = module_id;
	String visit_adm_date		= bean.checkForNull(request.getParameter("visit_adm_date")); 	
	String future_order_date	= bean.checkForNull(request.getParameter("future_order_date"));	
 	String past_order_date		= bean.checkForNull(request.getParameter("past_order_date"));
	
	int	   indxTime				= 0;
    String start_day_param		= "";
    String start_time_param		= "";

	//Taking values for start day and time
	String start_time_day_param	= bean.checkForNull(request.getParameter("start_time_day_param"));

	if(start_time_day_param!=null && !start_time_day_param.trim().equals(""))
	{
	    indxTime				= start_time_day_param.indexOf(" ");
	    start_day_param			= start_time_day_param.substring(0,indxTime);
	    start_time_param		= start_time_day_param.substring(indxTime+1);			
	}
	
	//For Ph

	String max_qty				= bean.checkForNull(request.getParameter("max_qty"));
	String chk_max				= bean.checkForNull(request.getParameter("chk_max"));

	String unit_qty				= bean.checkForNull(request.getParameter("unit_qty"));
	String chk_unit				= bean.checkForNull(request.getParameter("chk_unit"));

	String split_dose_yn		= bean.checkForNull(request.getParameter("split_dose_yn"));
	String split_qty			= bean.checkForNull(request.getParameter("split_qty"));


	//String uom_desc				= bean.checkForNull(request.getParameter("uom_desc"));
   	//String fract_value_yn				= bean.checkForNull(request.getParameter("fract_value_yn"));
   	//String sliding_scale_yn				= bean.checkForNull(request.getParameter("sliding_scale_yn"));
	
	 
	 String daysSelected ="";
	 String weeksSelected ="";
	 String monthsSelected ="";
	 String hoursSelected ="";
	 String minutesSelected ="";
	 String yearsSelected ="";
	 String duration_opt_value ="";

	softStopYN = bean.checkForNull(bean.getSoftStopYN(catalog_code));	

	/*********BEAN OF CALLER FUNCTION IS INSTANTIATED AND VALUES FOR FREQ LOADED ****/
	Default =beanEntry.getPlaceOrderDefault(catalog_code);
	if(Default!=null)
	{
		for(int j=0;j<Default.size();j++)
		{
			recordDefault	 = ((String[])Default.get(j));
			if(recordDefault[1]==null || recordDefault[1].equals("0")) recordDefault[1] = "";
		}
	}

	if(bean_name1.equals("eOR.OrderEntryBean"))
	{
		if(durationType_P==null)durationType_P="";
		if(durationType_P.equals(""))
		{
			durationType_P = (String)beanEntry.getDurationType(freq_code);
		}
	}
	if(durationType_P!=null && durationType_P.equalsIgnoreCase("D"))
		daysSelected = "selected";
	if(durationType_P!=null && durationType_P.equalsIgnoreCase("W"))
		weeksSelected = "selected";
	if(durationType_P!=null && durationType_P.equalsIgnoreCase("L"))
		monthsSelected = "selected";	
	if(durationType_P!=null && durationType_P.equalsIgnoreCase("H"))
		hoursSelected = "selected";	
	if(durationType_P!=null && durationType_P.equalsIgnoreCase("M"))
		minutesSelected = "selected";	
	if(durationType_P!=null && durationType_P.equalsIgnoreCase("Y"))
		yearsSelected = "selected";	
	if(bean_name1.equals("eOR.OrderEntryBean"))
	{
		PlaceOrderFrequency = bean.getPlaceOrderFrequency(catalog_code,"header",durationType_P,order_category,"",""); // Pass the order_category and catalog_code		
		org_drug_code=catalog_code;
	}
	else
	{
		PlaceOrderFrequency = bean.getPlaceOrderFrequency(org_drug_code,"header",durationType_P,order_category,"",""); // Pass the order_category and catalog_code		
	}

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(freqLegendStyle));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(freqLegendStyle));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(org_drug_code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(daysSelected));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(weeksSelected));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(monthsSelected));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(freqLegendStyle));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(freqLegendStyle));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(row_value));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(org_drug_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(beanEntry.getLoginFacilityId()));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

				
				for(int j=0; j<PlaceOrderFrequency.size(); j++)
				{
					frequencyRecords = (String[]) PlaceOrderFrequency.get(j);
					if(freq_code!=null && freq_code.equalsIgnoreCase(frequencyRecords[2]))
					{
					
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(frequencyRecords[0]));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(frequencyRecords[1]));
            _bw.write(_wl_block27Bytes, _wl_block27);

					}
					else
					{
					
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(frequencyRecords[0]));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(frequencyRecords[1]));
            _bw.write(_wl_block28Bytes, _wl_block28);

					}
				}						
				
            _bw.write(_wl_block29Bytes, _wl_block29);
 
					//if(recordDefault!=null) frequency_val = recordDefault[0]; else frequency_val="";	
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(freq_code));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(start_time_day_param));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(freqLegendStyle));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(freqLegendStyle));
            _bw.write(_wl_block35Bytes, _wl_block35);

			if(durationType_P==null)durationType_P="D";
			if(recordDefault!=null) duration_value = recordDefault[1]; else duration_value="";
			if((duration_value==null) || (duration_value=="undefined"))duration_value = "";
			if(recordDefault!=null) max_durn_value = recordDefault[3]; else max_durn_value="";
			if(recordDefault!=null) chk_for_max_durn_action = recordDefault[5]; else chk_for_max_durn_action ="";
			if(recordDefault!=null) prompt_msg 		= recordDefault[6]; else prompt_msg="";
			if(recordDefault!=null) comments 		= bean.checkForNull(recordDefault[7],""); else comments="";
			ArrayList durationTypes = new ArrayList();
			ArrayList durationAppl = new ArrayList();
			ArrayList durationDesc = new ArrayList();
			durationTypes.add("M");
			durationTypes.add("H");
			durationTypes.add("D");
			durationTypes.add("W");
			durationTypes.add("L");
			durationTypes.add("Y");
			
			
			for(int d=durationTypes.indexOf(durationType_P);d<durationTypes.size();d++)
			{
				durationAppl.add(durationTypes.get(d));
				durationDesc.add(decodeLocal(((String)durationTypes.get(d)),pageContext));
			}
			
			//DurationDesc.put("M","
		
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(pr_duration_display));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(max_durn_value));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(chk_for_max_durn_action));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(prompt_msg));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(softStopYN));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(org_drug_code));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(duration_value));
            _bw.write(_wl_block42Bytes, _wl_block42);

				for(int dt=0; dt<durationAppl.size(); dt++)
				{
					duration_opt_value = (String) durationAppl.get(dt);
					if(pr_duration_type!=null && pr_duration_type.equalsIgnoreCase(duration_opt_value))
					{
					
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(duration_opt_value));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf( (String) durationDesc.get(dt)));
            _bw.write(_wl_block45Bytes, _wl_block45);

					}
					else
					{
					
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(duration_opt_value));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf( (String) durationDesc.get(dt)));
            _bw.write(_wl_block48Bytes, _wl_block48);

					}					
				}
				
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(durationType_P));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(request.getParameter("code")));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(bean_id_P));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(bean_name_P));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(freq_code));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(max_qty));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(chk_max));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(unit_qty));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(chk_unit));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(split_dose_yn));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(split_qty));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(visit_adm_date));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(future_order_date));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(past_order_date));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(start_day_param));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(start_time_param));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(request.getParameter("row_value")));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(start_day_param));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(pr_duration));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(pr_duration_type));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(isSchdApplicable));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block75Bytes, _wl_block75);

	if(bean_name1.equals("eOR.OrderEntryBean"))
	{
	
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(bean_id1));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(bean_name1));
            _bw.write(_wl_block78Bytes, _wl_block78);

	}
	else if(bean_name1.equals("ePH.PrescriptionBean_1"))
	{
		bean_id1 = bean_id1.replace("@PrescriptionBean_1","@orderentrybean");
	
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(bean_id1));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(bean_name1));
            _bw.write(_wl_block79Bytes, _wl_block79);

	}
	else if(bean_name1.equals("ePH.DirectDispensingBean"))
	{
	
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(bean_id1));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(bean_name1));
            _bw.write(_wl_block79Bytes, _wl_block79);

	}
}
catch(Exception e)
{
	 e.printStackTrace();
}

            _bw.write(_wl_block80Bytes, _wl_block80);

 	putObjectInBean(bean_id,bean,request);

            _bw.write(_wl_block81Bytes, _wl_block81);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.DurationType.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.Day(s).label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.Week(s).label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.Month(s).label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.Frequency.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.Duration.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
