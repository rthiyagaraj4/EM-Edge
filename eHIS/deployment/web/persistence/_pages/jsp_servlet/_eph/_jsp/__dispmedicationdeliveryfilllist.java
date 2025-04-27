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

public final class __dispmedicationdeliveryfilllist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/DispMedicationDeliveryFillList.jsp", 1741325650070L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t\t<SCRIPT LANGUAGE=\"JavaScript\" SRC=\"../../eCommon/js/common.js\"></SCRIPT> \n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/DispMedication.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/DispMedicationAllStages.js\"></script>\n\t</head>\n\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" topmargin=\"0\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<form name=\"frmDispMedicationDeliveryFillList\" id=\"frmDispMedicationDeliveryFillList\" >\n\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"1\" >\n\t\t\t\t<tr >\n\t\t\t\t\t<td class= \"COLUMNHEADER\"  width=\"20%\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</th>\n\t\t\t\t\t<td class= \"COLUMNHEADER\"  width=\"40%\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th>\n\t\t\t\t\t<td class= \"COLUMNHEADER\"  width=\"8%\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" </th>\n\t\t\t\t\t<td class= \"COLUMNHEADER\"  width=\"8%\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&nbsp;</th>\n\t\t\t\t\t<!-- <td class= \"COLUMNHEADER\"  width=\"8%\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th> -->\n\t\t\t\t\t<td class= \"COLUMNHEADER\"  width=\"8%\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t<tr id=\"tr_";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" style=\"display:inline\">\n\t\t\t\n\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" style=\"font-size:11;font:bold;\" >&nbsp;&nbsp;<label style=\"cursor:pointer;color:blue;font-size:13\" onClick=\'callProcess(\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\",\"P\")\' id=\"patsym_";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">+</label>&nbsp;";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="(";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =")&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n\t\t\n\t\t\t\t\t\t\t<td class =\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" style=\"font-size:11;font:bold;\" ><label> ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&nbsp;,";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =",&nbsp;";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" : ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" &nbsp;Location  :";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</label>\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t\t<font style=\"font-size:9;\" id=\'discharge_label\' >&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</font>\n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\tXX1=new blinkText(\"XX1\",\'discharge_label\',500,500,\'darkred\',\'#ff0000\');\n\t\t\t\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t\t\t&nbsp;<b><a  style =\'font-size:9\' href=\"javascript:callMedicalItemdetails(\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\',\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\')\">";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" </a></b>\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" ><input type=\"checkbox\" name=\'PAT";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' id=\'PAT";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' checked value=\"\" onClick=\"chkPatientRecords(\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\');setValue(this)\">\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t\t\t\t<tr style=\"display:none\" id=\"PAT_";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="_";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" style=\"font-size:9\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" style=\"font-size:9\" >&nbsp;&nbsp;&nbsp;<b>";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</b>\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t\t\t\t\t\t<img style=\"cursor:pointer;filter:Chroma(Color=#FFFFFF)\" src=\"../../ePH/images/info.gif\" height=\'20\'  width=\'20\' onClick=\"showDrugInfo(\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\')\"></img>\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<br><label style=\"color:";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 =" </label>\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<img style=\"cursor:pointer;filter:Chroma(Color=#FFFFFF)\" src=\"../../ePH/images/info.gif\" height=\'20\'  width=\'20\' onClick=\"showDrugInfo(\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" style=\"font-size:9\" >";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</td>\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" style=\"font-size:9\" >&nbsp;</td>\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" style=\"font-size:9\" >\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<br> <label style=\"color:";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</td> <!--  patient_orderline_dtls.get(\"ALLOC_QTY\") changed to allocated_qty-->\n";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" style=\"font-size:9\" title=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'><img src=\'../../eCommon/images/disabled.gif\' ></td>\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' ><img src=\'../../eCommon/images/disabled.gif\' ></td>   \n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="  \n\t\t\t\t\t   \n\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" style=\"font-size:9\" ><input type=\"checkbox\" name=\'PAT";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\' ";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 =" ";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 =" value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" onclick = \"setValue(this);";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type =\"hidden\" name=\'drugCode_PAT";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\' id=\'drugCode_PAT";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\' value =\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n\n\t\t\t\t\t\t\t\t\t\t<input type = \"hidden\" name=\'stock_";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\' id=\'stock_";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\' value= \"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t\t<script language=\"javascript\">\n\t\t\t\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\'Common\'));\n\t\t\t\t\t\t//parent.parent.parent.parent.messageFrame.location.href = \"../../eCommon/jsp/error.jsp?err_num=\"+ getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"); //added for [IN:037465]\n\t\t\t\t\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t</table>\n\t\t\t<input type=\"hidden\" name=\"tot_rec\" id=\"tot_rec\" value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\"> \n\t\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\">\n\t\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\n\t\t\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">\n\t\t\t<input type=\"hidden\" name=\"disp_stage\" id=\"disp_stage\" value = \"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\">\n\t\t</form>\n\t</body>\n\t<script>\n\t\tcheckStockUnavailable();\n\t\tcallDeliverLegendsFrame(\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\',\'D\',\'\',\'\',\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\');\n\t</script>\n</html>\n";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

	    request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String login_user	=	(String)session.getValue("login_user");
	    
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

		String bean_id						= "DispMedicationBean" ;
		String bean_name					= "ePH.DispMedicationBean";
		DispMedicationBean bean				= (DispMedicationBean)getBeanObject( bean_id, bean_name, request ) ;
		bean.setLanguageId(locale);

		String	bean_id1				    =	"DispMedicationAllStages" ;
		String	bean_name1			        =	"ePH.DispMedicationAllStages";
		
		DispMedicationAllStages bean1        = (DispMedicationAllStages)getBeanObject( bean_id1, bean_name1,request);
		bean.setObject(bean1);
		
		String facility_id					= (String) session.getValue("facility_id");
		String param_bean_id				= "@DrugInterfaceControlBean";
		String param_bean_name				= "ePH.DrugInterfaceControlBean";
		DrugInterfaceControlBean param_bean	= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );

		String drug_db_interface_yn			= param_bean.getDrugDBInterface_yn(facility_id); 
		param_bean.clear();
		String nursing_unit                 =(String)bean.getNursingUnit();
		//String nursing_unit                 ="";
		ArrayList	patient_dtl				= new ArrayList();
		if(!nursing_unit.equals("")){
			patient_dtl				= (ArrayList)bean.getDeliveryPatientFillListDtls();
		}

		ArrayList	alternate_drugs			= new ArrayList();	
		String disp_stage					= bean.getDispStage();
		bean.setMode(CommonRepository.getCommonKeyValue( "MODE_MODIFY" ));
		String patient_id					= "";
		String checked						= "checked";
		String val							= "Y";
		String disabled						= "";
		String tot_disp_qty					= "";
		String drug_color					= "";
		String classvalue_2					= "";
		String external_prod_id				= "";
		String alternate_external_prod_id	= "";
		String discharge_label				= "";
		String allow_disp_record_lock_yn	= "";
		String lock_status              	= "";
		String Unlock_all_records_yn        = "";
		String user_id                      = "";
		String locked_date_time             = "";
		String disp_locn_code				= bean.getDispLocnCode();
		String sDisableChildCheckBoxes		= "";
		String sEnableDisableFunction		= "";
		HashMap AccessRightMap				= new HashMap();
		String sDispDrugAuthYN				= "N";
		//code added for medical item
		StringBuffer orderIDS_trxRefIDS		= new StringBuffer();
		String  store_desc					=  bean.getStoreDesc(disp_locn_code);	
		String  sysdate						=  bean.getTodaysDate();
		String billing_interface_yn			=  bean1.getBLInterfaceYN();//checkforbillinginterface();
		ArrayList  trn_rx_id				=	new ArrayList();
		HashMap  trn_rx_ids_patientwise	    =	new HashMap();
		String alt_drug_remarks_ind = bean.getAltDrugRemarksInd();//added for  Bru-HIMS-CRF-082 [IN:029948]
        String alt_drug_remarks_disp = ""; //added for  Bru-HIMS-CRF-082 [IN:029948]
		String allocated_qty = "";  // added for IN 28256
		ArrayList	colors	=	new ArrayList();
		ArrayList patient_order_line_dtls = null;
		HashMap patient_orderline_dtls = null;
		colors.add("#FF0000");
		colors.add("#669900");
		colors.add("#FF9966");
		colors.add("#6699CC");
		colors.add("#FF0000");
		colors.add("#669900");
		colors.add("#FF9966");
		colors.add("#6699CC");
		colors.add("#FF0000");
		colors.add("#669900");
		colors.add("#FF9966");
		colors.add("#6699CC");

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

				int recCount = 0;
				String sex, patient_name ,encounter_id, bl_patient_class, classvalue="";
				if(patient_dtl.size() > 0){
					for(int i=0;i<patient_dtl.size();i++){
						orderIDS_trxRefIDS   =  new StringBuffer();//code added for medical item
						trn_rx_id			 =	new ArrayList();
						HashMap patient_dtls = (HashMap)patient_dtl.get(i);
						if(recCount%2==0){
							classvalue = "QRYODD";
						}
						else{
							classvalue = "QRYEVEN";
						}
						sex              =(String) patient_dtls.get("SEX");
						patient_id              =(String) patient_dtls.get("PATIENT_ID");
						patient_name     =(String) patient_dtls.get("PATIENT_NAME");
						encounter_id     =(String) patient_dtls.get("ENCOUNTER_ID");
						bl_patient_class =(String) patient_dtls.get("ENC_PATIENT_CLASS");
						//String  patient_id=(String)result.get(i);
						// String patient_name=(String)result.get(i+1);	   

						if(sex.equalsIgnoreCase("female"))
							sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
						else if(sex.equalsIgnoreCase("male"))
							sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
						else if(sex.equalsIgnoreCase("unknown"))
							sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

						if(patient_dtls.get("ADT_STATUS").equals("08"))
							discharge_label =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.discharged.label","common_labels");
						else
							discharge_label ="";

						ArrayList patient_order_dtl =(ArrayList) bean.getDeliveryPatientOrderDtls((String)patient_dtls.get("PATIENT_ID"));
						//code added for medical items	
						if(patient_order_dtl.size() > 0){
							for(int j=0;j<patient_order_dtl.size();j++){
								HashMap patient_order_dtls = (HashMap)patient_order_dtl.get(j);
								if(!((String) patient_order_dtls.get("DISP_TRN_SEQ_NO")).equals("") ) {
									orderIDS_trxRefIDS.append((String) patient_order_dtls.get("ORDER_ID")).append("::").append((String) patient_order_dtls.get("DISP_TRN_SEQ_NO")).append("::");
									trn_rx_id.add(patient_order_dtls.get("DISP_TRN_SEQ_NO"));
								}
							}
						}
						//ends here

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf((String)patient_dtls.get("PATIENT_ID")));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf((String)patient_dtls.get("PATIENT_ID")));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf((String)patient_dtls.get("ORDERS")));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf((String)patient_dtls.get("PATIENT_NAME")));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf((String)patient_dtls.get("AGE")));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf((String)patient_dtls.get("BED_NO")));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf((String)patient_dtls.get("NURSING_UNIT")));
            _bw.write(_wl_block27Bytes, _wl_block27);
 
							if(!discharge_label.equals("")){

            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(discharge_label));
            _bw.write(_wl_block29Bytes, _wl_block29);

							}
							if(orderIDS_trxRefIDS.length()>0){			  

            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(billing_interface_yn));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(disp_locn_code));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(bl_patient_class));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(orderIDS_trxRefIDS.toString()));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(sysdate));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(java.net.URLEncoder.encode(store_desc)));
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

							}

            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf((String)patient_dtls.get("PATIENT_ID")));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf((String)patient_dtls.get("PATIENT_ID")));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf((String)patient_dtls.get("PATIENT_ID")));
            _bw.write(_wl_block38Bytes, _wl_block38);

						recCount++;
						//ArrayList patient_order_dtl =(ArrayList) bean.getDeliveryPatientOrderDtls((String)patient_dtls.get("PATIENT_ID"));
						if(patient_order_dtl.size() > 0){          

							for(int j=0;j<patient_order_dtl.size();j++){
								HashMap patient_order_dtls = (HashMap)patient_order_dtl.get(j);
								classvalue_2	  =	"";
							 
								if(j%2==0)
									classvalue_2 = "QRYODD";
								else
									classvalue_2 = "QRYEVEN";

								patient_order_line_dtls = (ArrayList)bean.getDeliveryPatOrderLineDtls((String)patient_dtls.get("PATIENT_ID"),(String)patient_order_dtls.get("ORDER_ID"));

								if(patient_order_line_dtls.size() > 0){
									ArrayList patient_order_line_dtl = (ArrayList)patient_order_line_dtls.get(0);
				
								for(int k=0;k<patient_order_line_dtl.size();k++){
									patient_orderline_dtls = (HashMap)patient_order_line_dtl.get(k);
									external_prod_id =(String)patient_orderline_dtls.get("EXTERNAL_PRODUCT_ID");
									int iOrderLineNo = Integer.parseInt(patient_orderline_dtls.get("ORDER_LINE_NUM").toString());
									alternate_drugs=null;
									alt_drug_remarks_disp="";
									if(patient_order_line_dtls.get(1) != null)
										alternate_drugs=(ArrayList)patient_order_line_dtls.get(1);
									if(alternate_drugs!=null && alternate_drugs.size() > 0){// if condition added for  Bru-HIMS-CRF-082 [IN:029948]
										if(alt_drug_remarks_ind.equals("M") || alt_drug_remarks_ind.equals("O")){
											alt_drug_remarks_disp = "&nbsp;<a href=\"javascript:openAltDrugRemarks('"+(String)patient_order_dtls.get("ORDER_ID")+"','"+(String)patient_orderline_dtls.get("ORDER_LINE_NUM") +"','"+ alt_drug_remarks_ind+"','LINK');\" id='altDrugRmkLbl' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.remarks.label", "common_labels")+"</a>";
											if(alt_drug_remarks_ind.equals("M"))
												alt_drug_remarks_disp=alt_drug_remarks_disp+" <img  id='altDrugRmkMand' src='../../eCommon/images/mandatory.gif'></img>";
										}
									}

            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf((String)patient_dtls.get("PATIENT_ID")));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(j));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(iOrderLineNo));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classvalue_2));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf((String)patient_order_dtls.get("ORDER_ID")));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(classvalue_2));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(patient_orderline_dtls.get("DRUG_DESC")));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(alt_drug_remarks_disp));
            _bw.write(_wl_block46Bytes, _wl_block46);

										if(external_prod_id!=null && !(external_prod_id.equals("")) && drug_db_interface_yn.equals("Y")){

            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(external_prod_id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(patient_orderline_dtls.get("DRUG_DESC")));
            _bw.write(_wl_block48Bytes, _wl_block48);

										}

										if(alternate_drugs!=null && alternate_drugs.size()>0){
											int m=0;
											for(int l=0;l<alternate_drugs.size();l=l+8){
												drug_color					=(String)colors.get(m);
												alternate_external_prod_id  =(String)alternate_drugs.get(l+7);

            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(drug_color));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(alternate_drugs.get(l+1)));
            _bw.write(_wl_block51Bytes, _wl_block51);

												if(!alternate_external_prod_id.equals("")&& alternate_external_prod_id!=null && drug_db_interface_yn.equals("Y")){

            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(alternate_external_prod_id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(java.net.URLEncoder.encode(((String)alternate_drugs.get(l+1)),"UTF-8")));
            _bw.write(_wl_block48Bytes, _wl_block48);

												}
												m++;
											}
										}

            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(classvalue_2));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(patient_orderline_dtls.get("ORDER_QTY")));
            _bw.write(_wl_block55Bytes, _wl_block55);

										tot_disp_qty =bean.getTotalDispQty((String)patient_order_dtls.get("ORDER_ID"));
										if(tot_disp_qty.equals("")){

            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(classvalue_2));
            _bw.write(_wl_block57Bytes, _wl_block57);

										}
										else{

            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(classvalue_2));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(tot_disp_qty));
            _bw.write(_wl_block55Bytes, _wl_block55);

										}
										if(alternate_drugs.size()>0){

            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(classvalue_2));
            _bw.write(_wl_block58Bytes, _wl_block58);
  
											if(patient_orderline_dtls.containsKey("AlterDrugDtls")){
												if(alternate_drugs.size()>0&&alternate_drugs!=null){
													int m=0;

													for(int l=0;l<alternate_drugs.size();l=l+8){
														drug_color =(String)colors.get(m);

            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(drug_color));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(alternate_drugs.get(l+5)));
            out.print( String.valueOf(bean.getUomDisplay(facility_id,(String)alternate_drugs.get(l+6))));
            _bw.write(_wl_block27Bytes, _wl_block27);
	
														m++;
													}							   
												}
											}

            _bw.write(_wl_block60Bytes, _wl_block60);

										}
										else{
											/* added for IN 28256 -start*/
											allocated_qty=(String)patient_orderline_dtls.get("ALLOC_QTY");
											if(allocated_qty == null || allocated_qty.equals(""))
												allocated_qty = "&nbsp;";
											/* added for IN 28256 -end*/

            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(classvalue_2));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(allocated_qty));
            _bw.write(_wl_block61Bytes, _wl_block61);

										}
										if(patient_orderline_dtls.get("STKAVAILABLE").equals("N") && alternate_drugs.size()==0 && patient_orderline_dtls.get("FILLED_BATCH_COUNT").equals("0")){
											checked ="";
											val     ="N";
											disabled="disabled";

            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(classvalue_2));
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);

										}
										else if(patient_orderline_dtls.get("FILLED_BATCH_COUNT").equals("0")){
											checked ="";
											val     ="N";
											disabled="disabled";

            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(classvalue_2));
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);

										}
										else{
											checked ="checked";
											val     ="Y";
											disabled="";

            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(classvalue_2));
            _bw.write(_wl_block57Bytes, _wl_block57);

										}
										if(iOrderLineNo > 1){
											sDisableChildCheckBoxes = "disabled";
											sEnableDisableFunction	= "";
										}
										else{
											sDisableChildCheckBoxes = "";
											sEnableDisableFunction	= "checkUncheckChildChkBoxs('"+(String)patient_dtls.get("PATIENT_ID")+"','"+(String)patient_order_dtls.get("ORDER_ID")+"','"+j+"','"+disabled+"',this)";
										}

            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(classvalue_2));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf((String)patient_dtls.get("PATIENT_ID")+"_"+(String)patient_order_dtls.get("ORDER_ID")));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(j));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(iOrderLineNo));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf((String)patient_dtls.get("PATIENT_ID")+"_"+(String)patient_order_dtls.get("ORDER_ID")));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(j));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(iOrderLineNo));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(checked));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(sDisableChildCheckBoxes));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(val));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(sEnableDisableFunction));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf((String)patient_dtls.get("PATIENT_ID")+"_"+(String)patient_order_dtls.get("ORDER_ID")));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(j));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(iOrderLineNo));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf((String)patient_dtls.get("PATIENT_ID")+"_"+(String)patient_order_dtls.get("ORDER_ID")));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(j));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(iOrderLineNo));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf((String)patient_orderline_dtls.get("DRUG_CODE")));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf((String)patient_dtls.get("PATIENT_ID")+"_"+(String)patient_order_dtls.get("ORDER_ID")));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(j));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(iOrderLineNo));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf((String)patient_dtls.get("PATIENT_ID")+"_"+(String)patient_order_dtls.get("ORDER_ID")));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(j));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(iOrderLineNo));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block77Bytes, _wl_block77);

									recCount++;
								}	//end of line detail for loop
							}  // end of line detail if loop
						} // end of order detail for loop
					}
					if(trn_rx_id.size()>0){
						trn_rx_ids_patientwise.put(patient_id,trn_rx_id);
					}
				} //end of patient detail for loop
			}// end of if loop
			else{ 
				if(!nursing_unit.equals("")){

            _bw.write(_wl_block78Bytes, _wl_block78);

				}
			}
			bean.setTrn_rx_ids_patientwise(trn_rx_ids_patientwise);

            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(CommonRepository.getCommonKeyValue( "MODE_MODIFY" )));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(disp_stage));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(sDispDrugAuthYN));
            _bw.write(_wl_block86Bytes, _wl_block86);

putObjectInBean(param_bean_id,param_bean,request);
putObjectInBean(bean_id,bean,request);

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PatientID/OrderId.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PatientDetail/Drug.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OrderQuantity.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DispensedQty.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AllocatedQuantity.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Stock.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DispensedQty.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DeliverStatus.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedno.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MedicalItems.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.NoStock.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.NotAllocated.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
