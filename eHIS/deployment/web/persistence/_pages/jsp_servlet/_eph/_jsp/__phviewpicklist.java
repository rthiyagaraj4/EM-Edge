package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.*;
import ePH.Common.*;
import eCommon.Common.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __phviewpicklist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/PHViewPickList.jsp", 1742386701742L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--This file is saved on 07/11/2005-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n ";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<HTML>\n<HEAD>\n\t<!-- <LINK REL=\"stylesheet\" TYPE=\"text/css\" HREF=\"../../eCommon/html/IeStyle.css\"></LINK> -->\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\n\t<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/CommonLookup.js\"></SCRIPT>\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/ValidateControl.js\"></SCRIPT>\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/common.js\"></SCRIPT>\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../ePH/js/PHReports.js\"></SCRIPT>\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../ePH/js/IPFill.js\"></SCRIPT><!-- this js is used for some purpose making change in this will impact ipfill also -->\n\n</HEAD>\n<title>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" </title>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<BODY onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onload=\"checkAll_patientsandorders(formPHViewFillList)\">\n<FORM name=\"formPHViewFillList\" id=\"formPHViewFillList\"  TARGET=\"messageFrame\" >\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<TABLE  ALIGN=\"center\" CELLPADDING=\"0\" CELLSPACING=\"0\" BORDER=\"0\" width=\"100%\">\n<tr>\n<td class=\"BODYCOLORFILLED\" ALIGN=\"right\"><input type=\"checkbox\" name=\"select_all\" id=\"select_all\" onclick=\"checkAll_patientsandorders(this);\" value=\"Y\" checked></td>\n</tr>\n<table>\n<TABLE  ALIGN=\"center\" CELLPADDING=\"0\" CELLSPACING=\"0\" BORDER=\"0\" width=\"100%\">\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<TR>\n\t\t<th COLSPAN=\"9\" align=\"left\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" </th>\n\t\t</TR>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t<TR>\n\t\t\t<th height=\"1\" COLSPAN=\"9\" align=\"right\"><input  type=\"checkbox\"  name=\"select_patients";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"  id=\"select_patients";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"   onclick=\"checkAll_patientsorder(this,\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\');\" value=\"Y\" checked></th>\n\t\t\t<input type=\"hidden\" name=\"patient_id_check";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" id=\"patient_id_check";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t\t\t</TR>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t<input type=\"hidden\"   name=\"order_id_";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"  id=\"order_id_";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" value=\"\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'\">\n\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t<TR>\n\t   <TD class=\"BODYCOLORFILLED\" style=\"BORDER-STYLE: none solid none none\" ALIGN=\"left\" width = \"27%\">\n\t\t<font size=\"1\" style=\"cursor:pointer;color:blue\" title=\"Drug Profile\"      onclick=\"showDrugProfile(\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\');\">";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&nbsp;</TD>\n\t\t<TD class=\"BODYCOLORFILLED\" ALIGN=\"left\" width = \"22%\" ><font size=\"1\" style=\"cursor:pointer;color:blue\" title=\"View Order\"onClick=\"callMenuFunctions(\'View\',\'Pharmacy\',\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\',\'\',\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\')\">&nbsp;\n\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</TD>\n\t\t\n\t\t\n\t\t<TD class=\"BODYCOLORFILLED\" width=\"3%\" ALIGN=\"right\"><font size=\"1\">";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&nbsp;</TD>\n\t\t<TD class=\"BODYCOLORFILLED\" width=\"4%\" style=\"BORDER-STYLE: none solid none none\" ALIGN=\"left\"><font size=\"1\">";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&nbsp;&nbsp;</TD>\n\n\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t<TD class=\"BODYCOLORFILLED\" >&nbsp;&nbsp;</TD>\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t<TD class=\"BODYCOLORFILLED\" >&nbsp;&nbsp;</TD>\n    ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t<input type=\"hidden\" name=\"drug_code_";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n\t\t<input type=\"hidden\" name=\"ord_drug_code_";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\n\n\t\t<input type=\"hidden\" name=\"end_date_time_";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t\t<TD class=\"BODYCOLORFILLED\" ALIGN=\"left\" width = \"18%\"  ><font size=\"1\" color=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n\t\t<label id=\"disp_drug_id_";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" name=\"disp_drug_name_";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" >";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</label></TD>\n\t\t<TD class=\"BODYCOLORFILLED\" style=\"BORDER-STYLE: none solid none none\" ALIGN=\"center\" nowrap><font size=\"1\">";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</TD>\n\t\t<TD class=\"BODYCOLORFILLED\" style=\"BORDER-STYLE: none solid none none\" ALIGN=\"left\" nowrap><font size=\"1\"  ><label id=\"disp_qty_id_";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" name=\"disp_qty_";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</label>\n\t\t&nbsp;<label id=\"disp_qty_uom_id_";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" name=\"disp_qty_uom_";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</label>\n\t\t<input type=\"hidden\" name=\"disp_batch_dtl_";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t\t</TD>\n\t\t<input type=\"hidden\" name=\"disp_uom_id_";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t\t<TD class=\"BODYCOLORFILLED\" ALIGN=\"right\"><input type=\"hidden\"  name=\"ip_fill_chk_";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="  onclick=\"checkOne(this)\"></TD>\n\t\t\n\t\t</TR>\n\t\t\n\t\t<input type=\"hidden\"  name=\"order_id_";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'\">\n\t\t\n\t\t\n\t\t\n\t\t<input type=\"hidden\" name=\"Patient_id_";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'\">\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t<TR>\n\t\t<th height=\"1\" COLSPAN=\"9\" align=\"left\"></th>\n\t\t</TR>\n</TABLE>\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t<script>\n\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));\n\t\twindow.close();\n\t\t</script>\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\n<INPUT TYPE=\"hidden\" name=\"bean_id\" id=\"bean_id\"\t\tVALUE=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n<INPUT TYPE=\"hidden\" name=\"bean_name\" id=\"bean_name\"\tVALUE=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n<INPUT TYPE=\"hidden\" name=\"total_drugs\" id=\"total_drugs\"\tVALUE=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n<INPUT TYPE=\"hidden\" name=\"store_code\" id=\"store_code\"\tVALUE=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n<INPUT TYPE=\"hidden\" name=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\"> \n<INPUT TYPE=\"hidden\" name=\"total_patients\" id=\"total_patients\"\tVALUE=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n<INPUT TYPE=\"hidden\" name=\"Nursing_Unit_From_Code_grn\" id=\"Nursing_Unit_From_Code_grn\"\tVALUE=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n<INPUT TYPE=\"hidden\" name=\"fill_int_start_date_time_grn\" id=\"fill_int_start_date_time_grn\"\t VALUE=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n<INPUT TYPE=\"hidden\" name=\"fill_int_end_date_time_grn\" id=\"fill_int_end_date_time_grn\"\tVALUE=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n\n</FORM>\n <FORM name=\"formPHGenerateFillList\" id=\"formPHGenerateFillList\"  TARGET=\"messageFrame\" >\n<br>\n<br>\n<INPUT TYPE=\"hidden\" name=\"mode\" id=\"mode\"\t\tVALUE=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n<INPUT TYPE=\"hidden\" name=\"function_id\" id=\"function_id\" VALUE=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n<INPUT TYPE=\"hidden\" name=\"facility_id\" id=\"facility_id\" VALUE=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n<INPUT TYPE=\"hidden\" name=\"nursing_unit_query\" id=\"nursing_unit_query\" VALUE=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n<INPUT TYPE=\"hidden\" name=\"Nursing_Unit_From_Code\" id=\"Nursing_Unit_From_Code\">\n<INPUT TYPE=\"hidden\" name=\"Nursing_Unit_To_Code\" id=\"Nursing_Unit_To_Code\" >\n<INPUT TYPE=\"hidden\" name=\"Default_Fill_Period\" id=\"Default_Fill_Period\" >\n<INPUT TYPE=\"hidden\" name=\"Schedule_Start_Time_Routine\" id=\"Schedule_Start_Time_Routine\" >\n<INPUT TYPE=\"hidden\" name=\"Exclude_Hrs\" id=\"Exclude_Hrs\" >\n<INPUT TYPE=\"hidden\" name=\"Disp_Locn\" id=\"Disp_Locn\" >\n<INPUT TYPE=\"hidden\" name=\"cDate\" id=\"cDate\" >\n<INPUT TYPE=\"hidden\" name=\"cMonth\" id=\"cMonth\">\n<INPUT TYPE=\"hidden\" name=\"cYear\" id=\"cYear\" >\n<INPUT TYPE=\"hidden\" name=\"cHours\" id=\"cHours\">\n<INPUT TYPE=\"hidden\" name=\"cMinutes\" id=\"cMinutes\">\n<INPUT TYPE=\"hidden\" name=\"currHours\" id=\"currHours\">\n<INPUT TYPE=\"hidden\" name=\"currMinutes\" id=\"currMinutes\">\n<INPUT TYPE=\"hidden\" name=\"Fill_Period_Unit\" id=\"Fill_Period_Unit\">\n<INPUT TYPE=\"hidden\" name=\"cut_off_limit_for_new_ord\" id=\"cut_off_limit_for_new_ord\">\n<INPUT TYPE=\"hidden\" name=\"routinefillalreadyinvoked\" id=\"routinefillalreadyinvoked\">\n<INPUT TYPE=\"hidden\" name=\"incstarttime\" id=\"incstarttime\">\n<INPUT TYPE=\"hidden\" name=\"incendtime\" id=\"incendtime\">\n<INPUT TYPE=\"hidden\" name=\"fill_int_start_date_time\" id=\"fill_int_start_date_time\" value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\"> \n\n\n</FORM> \n<!--<script>disableAll(true)</script>-->\n";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n</BODY>\n</HTML>\n \n\n";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String locale			= (String)session.getAttribute("LOCALE");


            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

request.setCharacterEncoding("UTF-8");

//ends

	String facility_id				 = (String) session.getValue( "facility_id" );
	
	String disp_locn_code			 = request.getParameter("disp_locn_code");
	String OrderingFacility_code	 = request.getParameter("OrderingFacility_code");
	String compound_drug_ind		 = request.getParameter("compound_drug_ind");
	String nursing_unit_or_locn		 = request.getParameter("nursing_unit_or_locn");
	String Nursing_Unit_From		 = request.getParameter("Nursing_Unit_From");
	String patient_id_1			 = request.getParameter("patient_id")==null ? "" : request.getParameter("patient_id");
	String Nursing_Unit_To			 = request.getParameter("Nursing_Unit_To")==null ? "" : request.getParameter("Nursing_Unit_To");
	String Proc_Type				 = request.getParameter("Proc_Type")==null ? "R" : request.getParameter("Proc_Type");
//		   if(Proc_Type.equals("R")){Proc_Type = "Routine";}else if(Proc_Type.equals("I")){Proc_Type="Incremental";}
	String schedule_start			 = request.getParameter("schedule_start");
	String Ip_Fill_Prd_Ahead		 = request.getParameter("Ip_Fill_Prd_Ahead");
	//int Ip_Fill_Prd_Ahead_inDays     = Integer.parseInt(Ip_Fill_Prd_Ahead)/24;    Himanshu
	String Ip_Fill_Prd_Ahead_inDays     = "";
	String fill_int_start_date_time  = request.getParameter("fill_int_start_date_time");
	String fill_int_end_date_time	 = request.getParameter("fill_int_end_date_time");
	String order_by_for_list		 = request.getParameter("order_by_for_list");
	String Building_Code			 = request.getParameter("Building_Code");
	String Floor_Code				 = request.getParameter("Floor_Code");
	String Nursing_Unit_From_Code				 = request.getParameter("Nursing_Unit_From_Code");
		if(Building_Code ==  null){Building_Code = "";}
		if(Floor_Code ==  null){Floor_Code = "";}
	String intermittent				 = "N";

	String iv_drug_ind				 = request.getParameter("iv_drug_ind");	
	String ip_excl_intermittent_fill = request.getParameter("ip_excl_intermittent_fill");
	String ip_fill_prd_unit			 = request.getParameter("ip_fill_prd_unit");
	String ip_fill_excl_prd_behind   = request.getParameter("ip_fill_excl_prd_behind")==null ? "0" : request.getParameter("ip_fill_excl_prd_behind");
	String cut_off_limit_for_new_ord = request.getParameter("cut_off_limit_for_new_ord");

	String mode	= CommonRepository.getCommonKeyValue("MODE_INSERT");

	HashMap fill_list_dtl = new HashMap();
	
	fill_list_dtl.put("iv_drug_ind",iv_drug_ind);
	fill_list_dtl.put("compound_drug_ind",compound_drug_ind);
	fill_list_dtl.put("ip_excl_intermittent_fill",ip_excl_intermittent_fill);
	fill_list_dtl.put("nursing_unit_or_locn",nursing_unit_or_locn);
	fill_list_dtl.put("Nursing_Unit_From_Code",Nursing_Unit_From);
	fill_list_dtl.put("Nursing_Unit_To_Code",Nursing_Unit_To);
	fill_list_dtl.put("Building_Code",Building_Code);
	fill_list_dtl.put("Floor_Code",Floor_Code);
	fill_list_dtl.put("Proc_Type",Proc_Type);
	fill_list_dtl.put("schedule_start",schedule_start);
	fill_list_dtl.put("Ip_Fill_Prd_Ahead",Ip_Fill_Prd_Ahead_inDays+"");
	fill_list_dtl.put("Fill_Period_Unit",ip_fill_prd_unit);
	fill_list_dtl.put("ip_fill_excl_prd_behind",ip_fill_excl_prd_behind);	
	fill_list_dtl.put("order_by_for_list",order_by_for_list);
	fill_list_dtl.put("disp_locn_code",disp_locn_code);
	fill_list_dtl.put("fill_int_start_date_time",fill_int_start_date_time);
	fill_list_dtl.put("fill_int_end_date_time",fill_int_end_date_time);
	fill_list_dtl.put("cut_off_limit_for_new_ord",cut_off_limit_for_new_ord);
	fill_list_dtl.put("locale",locale);
	fill_list_dtl.put("patient_id",patient_id_1);
	fill_list_dtl.put("language_id",locale);

	String bean_id = "PHPickListBean" ;
	String bean_name = "ePH.PHPickListBean";
	/* Initialize Function specific start */
	PHPickListBean bean = (PHPickListBean)getBeanObject(bean_id, bean_name, request ) ;
//	bean.clear() ;
//	bean.setMode( mode ) ;
//	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	

	bean.setFillListDtl(fill_list_dtl);

	ArrayList ip_fill_list = (ArrayList)bean.getIpPickList(fill_int_start_date_time,fill_int_end_date_time,Proc_Type,intermittent,disp_locn_code,nursing_unit_or_locn,compound_drug_ind,Building_Code,Floor_Code,Nursing_Unit_From,Nursing_Unit_To,order_by_for_list,locale,OrderingFacility_code,ip_fill_excl_prd_behind,patient_id_1);

	HashMap ip_fill_order		= new HashMap();
	String logged_fcy = bean.getLoggedInFacility();
	String prvs_nursing_unit_code = "";
	String nursing_unit_code = "";
	String nursing_unit_desc = "";
	StringTokenizer disp_qty_dtl  = new StringTokenizer("S");
//	StringTokenizer disp_qty_btch = new StringTokenizer("S");
	String disp_qty		= "";
	String disp_qty_uom	= "";
	String disp_qty_uom_desc="";
	String disp_btch = "";
	String disp_drug_code = "";
	String disp_drug_desc = "";
	String drug_choice	  = "";
	String patient_id	  = "";
	String patient_details= "";
	String drug_color	  = "";
	String order_id		  = "";
	String chk_dsbl		  = "";
	String ord_drug_code  = "";
	String ord_drug_name  = "";
	String ord_drug_qty	  = "";
	String ord_drug_uom   = "";
	String total_drugs	  = "";
	int total_patients	  = 0;
	String ip_fill_chk_value = "N";
	String ip_fill_chked	 = "checked";
	String line_flag  	  = "N";
	String sex  	  = "";
	String date_of_birth  	  = "";
	String patient_Name  	  = "";
	String gender  	  = "";

            _bw.write(_wl_block10Bytes, _wl_block10);
 
	if(ip_fill_list != null && ip_fill_list.size()>0){

            _bw.write(_wl_block11Bytes, _wl_block11);
										
		total_drugs	  = ip_fill_list.size()+"";
		for(int i = 0; i<ip_fill_list.size();i++){
			ip_fill_order = (HashMap)ip_fill_list.get(i);
			if(!patient_id.equals((String)ip_fill_order.get("PATIENT_ID"))){
				patient_id		= (String)ip_fill_order.get("PATIENT_ID");
				patient_details	= (String)ip_fill_order.get("Patient_Details");	
	patient_details=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedno.label","common_labels")+":"+patient_details;
				sex	= (String)ip_fill_order.get("sex");
				if(sex.equals("M")){
				 gender	=			com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
				 gender=gender+",";
				}else if(sex.equals("F")){
				  gender	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
				   gender=gender+",";
				}else if(sex.equals("Unknown"))
				{
				 gender	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
				 gender=gender+",";

				}
				date_of_birth	= (String)ip_fill_order.get("date_of_birth");
				date_of_birth   = date_of_birth+",";
				patient_Name	= (String)ip_fill_order.get("patient_Name");	
				line_flag       = "Y";
			}else{
				patient_details	= "";
				line_flag       = "N";
				date_of_birth   = "";
				gender   = "";
				patient_Name   = "";
			}
			

			order_id		  = (String)ip_fill_order.get("ORDER_ID"); 
			ord_drug_code	  = (String)ip_fill_order.get("Drug_Code"); 	
			ord_drug_name	  =	(String)ip_fill_order.get("Drug_Name");
			ord_drug_qty	  =	(String)ip_fill_order.get("ORDER_QTY");
			ord_drug_uom	  =	(String)ip_fill_order.get("ORDER_UOM");
			nursing_unit_code = (String)ip_fill_order.get("SOURCE_CODE"); 
			nursing_unit_desc = (String)ip_fill_order.get("NURSING_UNIT_DESC"); 
            
					
			disp_qty_dtl = new StringTokenizer((String)ip_fill_order.get("Disp_qty"),"|");

			int count=disp_qty_dtl.countTokens();

			if(count==5){
			while(disp_qty_dtl.hasMoreTokens()){
				disp_qty		= disp_qty_dtl.nextToken();
				disp_qty_uom	= disp_qty_dtl.nextToken();
				disp_qty_uom =bean.getUomDisplay(facility_id,disp_qty_uom);
				bean.setLanguageId(locale);
				drug_choice		= disp_qty_dtl.nextToken();
				disp_drug_code  = disp_qty_dtl.nextToken();
				disp_drug_desc  = disp_qty_dtl.nextToken();
				if ( disp_drug_desc == null || disp_drug_desc.equals(" ") )
				{
				  disp_drug_desc= ord_drug_name;
				  ord_drug_code=ord_drug_code;
				  drug_choice="#990033";
				  
				 // ip_fill_chked	 = "checked";
				  if(disp_qty.equals("0")) {
				  ip_fill_chked	 = "";
				  ip_fill_chk_value = "N";
				  }else {
				  ip_fill_chked	 = "checked";
				  ip_fill_chk_value = "Y";
				  }
				  chk_dsbl = "";
				  
			    }
				 disp_btch		=" ^ ^ ^ ^";
			    }				
			}else if(count==6) {
				
				while(disp_qty_dtl.hasMoreTokens()){
				disp_qty		= disp_qty_dtl.nextToken();
				disp_qty_uom	= disp_qty_dtl.nextToken();
				
				drug_choice		= disp_qty_dtl.nextToken();
				disp_drug_code  = disp_qty_dtl.nextToken();
				disp_drug_desc  = disp_qty_dtl.nextToken();
				disp_btch		= disp_qty_dtl.nextToken();
				disp_qty_uom =bean.getUomDisplay(facility_id,disp_qty_uom);
				bean.setLanguageId(locale);
				if ( (disp_drug_desc == null || disp_drug_desc.equals(" ")&&(!drug_choice.equals("C"))) )
				{
				  disp_drug_desc= ord_drug_name;
				  ord_drug_code=ord_drug_code;
				  drug_choice="#990033";
				  if(disp_qty.equals("0")){
				  ip_fill_chked	 = "";
				  ip_fill_chk_value = "N";
				  }else{
				  ip_fill_chked	 = "checked";
				  ip_fill_chk_value = "Y";
				  }
				  chk_dsbl = "";
				 }
			   }//end while
		    }//end else
		if(drug_choice.equals("S")){
				drug_color = "";			
				chk_dsbl = "enabled";
				
				//ip_fill_chked	 = "checked";
				 if(disp_qty.equals("0")){
				  ip_fill_chked	 = "";
				 ip_fill_chk_value="N";
				 }else{
				  ip_fill_chked	 = "checked";
				  ip_fill_chk_value = "Y";
				  }

			}else if(drug_choice.equals("A")){
				drug_color = "#CC6600";			
				chk_dsbl = "";
				//ip_fill_chked	 = "checked";
				 if(disp_qty.equals("0")){
				  ip_fill_chked	 = "";
				  ip_fill_chk_value = "N"; 
				 }else{
				  ip_fill_chked	 = "checked";
				  ip_fill_chk_value = "Y"; 
				  }
			}else if(drug_choice.equals("M")){
				drug_color = "#CC00CC";
				chk_dsbl = "disabled";
				ip_fill_chk_value = "N";
				ip_fill_chked	 = "";
			}else if(drug_choice.equals("N")){
				drug_color = "";
				disp_drug_desc = "<img src='../../eCommon/images/disabled.gif' align='center' title='"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.NoStock.label","ph_labels")+"'>";
				chk_dsbl = "disabled";
				ip_fill_chk_value = "N";
				ip_fill_chked	 = "";
			}else if(drug_choice.equals("C")){
				drug_color = "red";
				disp_drug_desc = "<img src='../../eCommon/images/disabled.gif' align='center' title='"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ITEMSTORECOMBINOTFOUND.label","ph_labels")+"'>";
				chk_dsbl = "disabled";
				ip_fill_chk_value = "N";
				ip_fill_chked	 = "";
			}

			if(disp_qty.equals("0")){
				drug_color = "";
				chk_dsbl = "";
				ip_fill_chk_value = "N";
				//ip_fill_chked	 = "checked";
				ip_fill_chked	 = "";
			}

	if(!prvs_nursing_unit_code.equals(nursing_unit_code)){
		prvs_nursing_unit_code = nursing_unit_code;

            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(nursing_unit_desc));
            _bw.write(_wl_block13Bytes, _wl_block13);
}	
		if(!line_flag.equals("N")){

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(total_patients));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(total_patients));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(patient_id ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf( total_patients));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf( total_patients));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block20Bytes, _wl_block20);

		total_patients++;
		}

            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block24Bytes, _wl_block24);

		System.out.println("order_id==> "+order_id);
		
		
		
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(patient_Name));
            out.print( String.valueOf(date_of_birth));
            out.print( String.valueOf(gender));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(patient_details));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(ord_drug_name));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(ord_drug_qty));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(ord_drug_uom));
            _bw.write(_wl_block33Bytes, _wl_block33);
if(drug_choice.equals("N")){
            _bw.write(_wl_block34Bytes, _wl_block34);
}else{
            _bw.write(_wl_block35Bytes, _wl_block35);
}
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(disp_drug_code));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(ord_drug_code));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(fill_int_end_date_time));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(drug_color));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(disp_drug_desc));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf((String)ip_fill_order.get("Tot_Disp_Qty")));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(disp_qty));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(disp_qty_uom));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(disp_btch));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(disp_qty_uom));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(ip_fill_chk_value));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(chk_dsbl));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf( i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf( i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block55Bytes, _wl_block55);

		}

            _bw.write(_wl_block56Bytes, _wl_block56);

	}else{

            _bw.write(_wl_block57Bytes, _wl_block57);
}
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf( bean_id ));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf( total_drugs ));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(disp_locn_code));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(OrderingFacility_code));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf( total_patients ));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf( Nursing_Unit_From_Code ));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf( fill_int_start_date_time ));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf( fill_int_end_date_time ));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf( mode ));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf( bean.getFunctionId() ));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf( logged_fcy ));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf( PhRepository.getPhKeyValue( "SQL_PH_NURSINGUNIT_LOOKUP" ) ));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(fill_int_start_date_time));
            _bw.write(_wl_block72Bytes, _wl_block72);
 putObjectInBean(bean_id,bean,request); 
            _bw.write(_wl_block73Bytes, _wl_block73);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.FillList.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
