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
import eST.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __dispmedicationstockdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/DispMedicationStockDetails.jsp", 1709120744285L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<HTML>\n\t<HEAD>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/DispMedicationAllStages.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</HEAD>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<body onMouseDown=\"\" onKeyDown=\"lockKey()\">\n\t\t\t<form name=\"DispMedicationStockDetails\" id=\"DispMedicationStockDetails\">\n\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"1\">\n\t\t\t\t\t<td  class=\"COLUMNHEADER\" colspan=\"2\" class=\"label\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td  class=\"QRYEVENSMALL\" width=\"30%\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&nbsp;</td>\n\t\t\t\t\t\t<td  class=\"QRYEVENSMALL\" width=\"70%\">&nbsp;&nbsp;<b>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</b></td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td colspan=\"2\" class=\"QRYODDSMALL\" wrap>&nbsp;</td></tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td  class=\"QRYEVENSMALL\" width=\"30%\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&nbsp;</td>\n\t\t\t\t\t\t<td  width=\"70%\" CLASS=\"QRYEVENSMALL\">&nbsp;&nbsp;\n\t\t\t\t\t\t\t<select onChange=\"displayDescription(this,document.DispMedicationStockDetails,\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\')\" name=\"item_select\">\n\t\t\t\t\t\t\t\t<option value=\"\">&nbsp;&nbsp;---";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="---&nbsp;&nbsp;</option>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" selected>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</option>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t\t</select><img src=\"../../eCommon/images/mandatory.gif\">\n\t\t\t\t\t\t\t</td> \n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td colspan=\"2\" class=\"QRYODDSMALL\">&nbsp;</td></tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td  class=\"QRYEVENSMALL\" width=\"30%\" >";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&nbsp;</td>\n\t\t\t\t\t\t\t<td  class=\"QRYEVENSMALL\" width=\"70%\">&nbsp;&nbsp;<label id=\"item_desc_1\" style=\"font-weight:bold\"></label></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td  class=\"QRYEVENSMALL\" width=\"30%\" >&nbsp;</td>\n\t\t\t\t\t\t\t<td  CLASS=\"QRYEVENSMALL\" width=\"70%\">&nbsp;&nbsp;<label id=\"item_desc_2\" style=\"font-weight:bold\"></label></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td align=\"right\" class=\"QRYEVENSMALL\" width=\"30%\" >&nbsp;</td>\n\t\t\t\t\t\t\t<td align=\"left\" CLASS=\"QRYEVENSMALL\" width=\"70%\">&nbsp;&nbsp;<label id=\"item_desc_3\" style=\"font-weight:bold\"></label></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td colspan=\"2\" class=\"QRYODDSMALL\">&nbsp;</td></tr>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t<tr style=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n\t\t\t\t\t\t\t<td align=\"right\" class=\"QRYEVENSMALL\" width=\"30%\" style=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&nbsp;</td>\n\t\t\t\t\t\t\t<td align=\"left\" CLASS=\"QRYEVENSMALL\" width=\"70%\" style=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>&nbsp;\n\t\t\t\t\t\t\t\t<select onChange=\"issueUOM(this,\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\');setIssueUom(this,\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\');\" name=\"issue_uom_select\"><!--setIssueUom added for AAKH-SCF-0338 -->\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="_";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t\t</select>&nbsp;\n\t\t\t\t\t\t\t<label id=\"item_desc_3\" style=\"font-weight:bold\"></label>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"base_to_disp_uom_equl_val\" id=\"base_to_disp_uom_equl_val\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"base_to_def_uom_equl_val\" id=\"base_to_def_uom_equl_val\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"base_to_disp_uom_equl\" id=\"base_to_disp_uom_equl\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\"> <!--  Added for AAKH-SCF-0113 [IN:048937] -->\n\t\t\t\t\t\t<input type=\"hidden\" name=\"base_to_def_uom_equl\" id=\"base_to_def_uom_equl\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\t <!--  Added for AAKH-SCF-0113 [IN:048937] -->\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td colspan=\"2\" class=\"QRYODDSMALL\">&nbsp;</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr><td colspan=\"2\" class=\"white\"></td>&nbsp;</tr>\n\t\t\t\t\t</table>\n\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"1\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td colspan=\"2\" CLASS=\"white\" ><input type=\"button\" class=\"button\" style=\'visibility:hidden\'value=\"Charges\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" onClick=\"viewCharges(\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\',\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\')\">\n\n\t\t\t\t\t\t<input type=\"button\" class=\"button\" name=\"stockavail\" id=\"stockavail\" value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' onClick=\"callBatchSearch(\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\')\"></td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t\t<input type=\"hidden\" name =\"stk_qty\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t\t\t</form>\n\t\t</body>\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t<script>\n\t\t\t\tfor(var i=0;i<document.DispMedicationStockDetails.issue_uom_select.length;i++){\n\t\t\t\t\ttry{\n\t\t\t\t\t\tif(document.DispMedicationStockDetails.issue_uom_select.options[i].value.indexOf(\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\') != -1)\n\t\t\t\t\t\t\tdocument.DispMedicationStockDetails.issue_uom_select.selectedIndex = i;\n\t\t\t\t\t}\n\t\t\t\t\tcatch(e){}\n\t\t\t\t}\n\t\t\t</script>\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t<script>\n\t\t\tif(document.DispMedicationStockDetails.item_select.length==2) {\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\t\t\t\n\t\t\t\t\tdocument.DispMedicationStockDetails.item_select.selectedIndex = 1;\n\t\t\t\t\tdisplayDescription(document.DispMedicationStockDetails.item_select,document.DispMedicationStockDetails,\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\');//bean_1.getBarcode_Scan_YN() parameter added for KDAH-CRF-0231 [IN-034551] \n\t\t\t\t\tdocument.DispMedicationStockDetails.item_select.disabled\t=\ttrue;\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\talert(getMessage(\"ITEM_IS_NOT_ASSIGNED\",\"PH\"));\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t\talert(getMessage(\"PH_ITEM_UOM_DEF_NOT_FOUND\",\"PH\"));\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\tdocument.DispMedicationStockDetails.item_select.disabled\t    =\ttrue;\n\t\t\t\t\tdocument.DispMedicationStockDetails.issue_uom_select.disabled\t=\ttrue;\n\t\t\t\t\tclearItemDetail();\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t} \n\t\t\telse {\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t\tdisplayDescription(document.DispMedicationStockDetails.item_select,document.DispMedicationStockDetails,\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\');<!--//bean_1.getBarcode_Scan_YN() parameter added for KDAH-CRF-0231 [IN-034551] -->\n";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\t\t\t\t\n\t\t\t\t\t\t\talert(getMessage(\"ITEM_IS_NOT_ASSIGNED\",\"PH\"));\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t\t\talert(getMessage(\"PH_ITEM_UOM_DEF_NOT_FOUND\",\"PH\"));\n";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t\t document.DispMedicationStockDetails.item_select.disabled\t    =\ttrue;\n\t\t\t\t\t\t document.DispMedicationStockDetails.issue_uom_select.disabled\t=\ttrue;\n\t\t\t\t\t\t clearItemDetail();\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\tclearItemDetail();\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t}\n\t\t</script>\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t</html>\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block5Bytes, _wl_block5);

request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String bean_id		= "DispMedicationAllStages" ;
	String bean_name	= "ePH.DispMedicationAllStages";
	DispMedicationAllStages bean = (DispMedicationAllStages)getBeanObject( bean_id, bean_name,request) ;
	
	String	bean_id_1		=	"DispMedicationBean" ;
	String	bean_name_1		=	"ePH.DispMedicationBean";
	
	DispMedicationBean bean_1	= (DispMedicationBean)getBeanObject( bean_id_1, bean_name_1, request);
	try{
		//bean_1.setLanguageId(locale);
		 //this parameter is used to check trade change is allowed for user or not based on dispensing rights
		String allowchangetradenameyn	=	bean_1.getDispChangeTradeNameYN();
		String allowmultitradeyn	    =	bean_1.getDispAllowMultiTradesYN();
		String allow_short_expiry_drugs_yn =bean_1.getAllow_short_expiry_drugs_yn();
		HashMap stockdtl= new HashMap();
		
		String facility_id								=  	request.getParameter("facility_id");
		stockdtl.put("facility_id", facility_id);
		String disp_locn_code							=  	request.getParameter("disp_locn_code");
		stockdtl.put("disp_locn_code", disp_locn_code);
		String drug_code								=	request.getParameter("drug_code")==null?"":request.getParameter("drug_code");
		String patient_id								=	request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String order_id									=	request.getParameter("order_id")==null?"":request.getParameter("order_id");
		String order_line_no							=	request.getParameter("order_line_no")==null?"":request.getParameter("order_line_no");
		String qty										=	request.getParameter("qty");
		String uom										=	request.getParameter("qty_uom")==null?"":request.getParameter("qty_uom");
		String uom_code									=	request.getParameter("uom_code")==null?"":request.getParameter("uom_code");
		String source									=	request.getParameter("source")==null?"":request.getParameter("source");
		String recno									=	request.getParameter("no")==null?"":request.getParameter("no");
		String end_date									=	request.getParameter("end_date")==null?"":request.getParameter("end_date");
		String drug_strength							=	request.getParameter("drug_strength")==null?"":request.getParameter("drug_strength");
		String alt_drug_strength						=	request.getParameter("alt_drug_strength")==null?"":request.getParameter("alt_drug_strength");
		String drug_class								=	request.getParameter("drug_class")==null?"":request.getParameter("drug_class");
		String stk_qty									=	request.getParameter("stk_qty")==null?"":request.getParameter("stk_qty");
		String min_end_date								=	request.getParameter("min_end_date")==null?"":request.getParameter("min_end_date");
		String main_strength_per_value_pres_uom			=	request.getParameter("main_strength_per_value_pres_uom")==null?"":request.getParameter("main_strength_per_value_pres_uom");
		String sPRNOrAbsOrder							=  	request.getParameter("PrnAbs")==null?"":request.getParameter("PrnAbs");
		String alt_drg_no								=  	request.getParameter("alt_drg_no")==null?"":request.getParameter("alt_drg_no");
		String alt_strength_uom							=  	request.getParameter("alt_strength_uom")==null?"":request.getParameter("alt_strength_uom");
		String drug_color								=	request.getParameter("drug_color")==null?"":request.getParameter("drug_color");
		String alt_drug_code							=	request.getParameter("alt_drug_code")==null?"":request.getParameter("alt_drug_code");
		String called_from								=	request.getParameter("called_from")==null?"":request.getParameter("called_from");
		String bms_strength								=	request.getParameter("bms_strength")==null?"":request.getParameter("bms_strength");
		String oper_mode								=	request.getParameter("oper_mode")==null?"":request.getParameter("oper_mode");
		String drug_desc								=	request.getParameter("drug_desc")==null?"":request.getParameter("drug_desc");
		String prescribed_strength						=  	request.getParameter("prescribed_strength")==null?"":request.getParameter("prescribed_strength");
		String barcode_id								=  	request.getParameter("barcode_id")==null?"":request.getParameter("barcode_id");
		String drg_code = request.getParameter("drg_code")==null?"":request.getParameter("drg_code"); //ML-MMOH-SCF-1829
		if(!alt_drug_code.equals("")) //ML-MMOH-SCF-1829
			drug_code = drg_code ;
		String currentdateplusFillPeriod				=  	"";		//added by Ganga for ML-BRU-SCF-0905 [IN:041285]
		boolean	endDateIsbeforeFilldate					= 	false;//added by Ganga for ML-BRU-SCF-0905 [IN:041285]

		bean_1.setBarcode_id(barcode_id);
		if(bean_1.getStockDtl()!=null && !bean_1.getStockDtl().isEmpty() ){
			stockdtl=bean_1.getStockDtl();
		}
		 
		bean_1.getBarCodeflg(facility_id,disp_locn_code);
		stockdtl.put("barcode_yn", bean_1.getBarcode_Scan_YN());
		String barCodeScanYN = bean_1.getBarcode_Scan_YN();
		if(!barcode_id.equals("")){
			bean_1.setBarcode_Scan_YN("N"); 
			//bean_1.getBatch_val().clear();//Added for KDAH-CRF-0231 [IN-034551].
		}
		if(barCodeScanYN.equals("Y") &&  !barcode_id.equals("") || !barcode_id.equals("")){
			stockdtl.put("barcode_id", barcode_id);
			if(drug_code.equals(""))
				drug_code =	stockdtl.get("drug_code").toString();
			
			if(patient_id.equals(""))
				patient_id =	stockdtl.get("patient_id").toString();
			
			if(order_id.equals(""))
				order_id =	stockdtl.get("order_id").toString();

			if(order_line_no.equals(""))
				order_line_no =	stockdtl.get("order_line_no").toString();
			
			if(qty==null || qty.equals(""))
				qty  =	stockdtl.get("bms_qty").toString();

			if(uom.equals(""))
				uom  =	stockdtl.get("strength_uom").toString();

			if(uom_code.equals(""))
				uom_code =	stockdtl.get("uom_code").toString();

			if(source.equals(""))
				source 	=	stockdtl.get("source").toString();

			if(recno.equals(""))
				recno 	=	stockdtl.get("recCount").toString();

			if(end_date.equals(""))
				end_date =	stockdtl.get("end_date").toString();

			if(drug_strength.equals(""))
				drug_strength	 =	stockdtl.get("strength_value").toString();

			if(alt_drug_strength.equals(""))
				alt_drug_strength 	=	stockdtl.get("alt_strength_value").toString();

			if(drug_class.equals(""))
				drug_class =	stockdtl.get("drug_class").toString();

			if(stk_qty.equals(""))
				stk_qty 	=	stockdtl.get("stk_qty").toString();

			if(min_end_date.equals(""))
				min_end_date =	stockdtl.get("min_end_date").toString();

			if(main_strength_per_value_pres_uom.equals(""))
				main_strength_per_value_pres_uom	=	stockdtl.get("main_strength_per_value_pres_uom").toString();

			if(sPRNOrAbsOrder.equals(""))
				sPRNOrAbsOrder	=	stockdtl.get("sPRNOrAbsOrder").toString();

			if(alt_drg_no.equals(""))
				alt_drg_no =	stockdtl.get("alt_drg_no").toString();

			if(alt_strength_uom.equals(""))
				alt_strength_uom	=	stockdtl.get("alt_strength_uom").toString();
		}
		
		stockdtl.put("drug_code", drug_code);
		stockdtl.put("patient_id", patient_id);
		stockdtl.put("order_id", order_id);     
		stockdtl.put("order_line_no", order_line_no);
		stockdtl.put("bms_qty", qty);
		stockdtl.put("strength_uom", uom);
		stockdtl.put("uom_code", uom_code);
		stockdtl.put("source", source);
		stockdtl.put("recCount", recno);
		stockdtl.put("end_date", end_date);
		stockdtl.put("strength_value", drug_strength);
		stockdtl.put("alt_strength_value", alt_drug_strength);
		stockdtl.put("drug_class", drug_class);
		stockdtl.put("stk_qty", stk_qty);
		stockdtl.put("min_end_date", min_end_date);
		stockdtl.put("main_strength_per_value_pres_uom", main_strength_per_value_pres_uom);
		stockdtl.put("sPRNOrAbsOrder", sPRNOrAbsOrder);
		stockdtl.put("alt_drg_no", alt_drg_no);
		stockdtl.put("alt_strength_uom", alt_strength_uom);
		currentdateplusFillPeriod		=  	com.ehis.util.DateUtils.plusDate(bean_1.getTodaysDate(),"DMY",locale,Integer.parseInt(bean_1.getFillPeriod()),"d").toString();  // added for ML-BRU-SCF-0905 [IN:041285] -start
		endDateIsbeforeFilldate			=  	com.ehis.util.DateUtils.isBefore(end_date,currentdateplusFillPeriod,"DMY",locale);
		if(!endDateIsbeforeFilldate){
			end_date = currentdateplusFillPeriod;
			min_end_date = currentdateplusFillPeriod;
		}//ML-BRU-SCF-0905 [IN:041285] added ends

		boolean bPRNOrAbsOrder		=  false;
		String disable				=  "enabled";
		bean_1.setStockDtl(stockdtl);

		//Added for  KDAH-CRF-0231 [IN-034551] - end

		if(sPRNOrAbsOrder != null && sPRNOrAbsOrder.equals("T"))
			bPRNOrAbsOrder			= true;

		bean.setBPRNOrAbsOrder(bPRNOrAbsOrder);

		// To reset the Quantity value in the DispMedicationAllocateDrugsWithStk.jsp page
		String strResetQty = request.getParameter("resetQty");
		bean_1.setStrResetQty(strResetQty);

		//code added for handling special char 
		String drug_name			=	"";
		String trade_code   =  (String)bean_1.gettrade_codes(order_id,order_line_no,drug_code);	

		if(drug_desc!=null){
			 drug_name		=  drug_desc; 
		}
		
		if(drug_name!=null && !drug_name.equals("")){
			drug_name	=drug_name.replaceAll(" ","%20");
			drug_name	=java.net.URLEncoder.encode(drug_name,"UTF-8");
			drug_name	=drug_name.replaceAll("%2520","%20");
		}

		String alt_drug_desc		=	request.getParameter("alt_drug_desc")==null?"":request.getParameter("alt_drug_desc");
		String altdrug_name		=  "";
		if((!alt_drug_desc.equals(""))&& (alt_drug_desc!=null))
			 altdrug_name			=  alt_drug_desc; 			
		if((!altdrug_name.equals(""))&&(altdrug_name!=null)){
			/*altdrug_name=altdrug_name.replaceAll(" ","%20");
			altdrug_name=java.net.URLEncoder.encode(altdrug_name,"UTF-8");  
			altdrug_name=altdrug_name.replaceAll("%2520","%20"); Commented By sandhya for 25007 incident*/
		}

		//	code added for sriraj demo for showing billing details 4/22/2006
		String encounter_id		=	bean_1.getEncounterID();
		String patient_class	=	bean.getEncounterPatientClass(encounter_id, patient_id);  // patient_id  added for [IN:035667] 
		String showcharge_yn	=	bean.getBLInterfaceYN();//checkforbillinginterface();

		String dis="";
		if(showcharge_yn.trim().equals("Y")){
			 dis="Style=Display:inline";
		}
		else{
			 dis="Style=Display:none";
		}
		boolean entered			=	false;
		if(drug_code==null)			
			drug_code	=	"";
		if(alt_drug_code==null)		
			alt_drug_code	=	"";

		String params			= "";

		if(!alt_drug_code.equals("")){
//			params				=	request.getQueryString().replace(drug_code,alt_drug_code);
			params				=	request.getQueryString(); //removed replace for ML-MMOH-SCF-1829

			drug_code			=	alt_drug_code;
		}
		else{ 
			 if(!(barcode_id==null || barcode_id.equals(""))){//if block to send stockdtl values on request string added for KDAH-CRF-0231 [IN-034551]
				params= "&order_id="+bean_1.getStockDtl().get("order_id").toString()+"&order_line_no="+bean_1.getStockDtl().get("order_line_no").toString()+"&drug_code="+stockdtl.get("drug_code").toString()+"&qty="+bean_1.getStockDtl().get("bms_qty").toString()+"&stk_qty="+bean_1.getStockDtl().get("stk_qty").toString()+"&end_date="+bean_1.getStockDtl().get("end_date").toString()+"&source="+bean_1.getStockDtl().get("source").toString()+"&no="+bean_1.getStockDtl().get("recCount").toString()+"&uom_code="+bean_1.getStockDtl().get("uom_code").toString();//source,no is added for incident Alpha-PH- Barcode getting script error [IN040736]
			 }
			 else{ 
				params				=	request.getQueryString();
			}
		}

		String item_code		=	"";
		String item_desc		=	"";
		String store_code		=	"";
		String store_desc		=	"";
		String stk_unit_code	=	"";
		String stk_unit_desc	=	"";
		String stk_equval_value	=	"";
		String dflt_issue_uom   =   "";
		String orig_dflt_issue_uom   =   "";
		String act_stk_equval_value  =   "";

		String base_uom			=	"";
		String display_list		=	"";
		HashMap IssueUOMAndBaseUOM =new HashMap();
		String base_to_disp_uom_equl_val ="1";
		String base_to_def_uom_equl_val  ="1";
		boolean flag            =   false;
		//boolean flag_1          =   false;
		ArrayList	stk_units	=	new ArrayList();
		String uom_desc	= "";//Added for AAKH-SCF-0338

		if(drug_code==null)
			drug_code	=	""; 
		ArrayList items		=	bean.loadItems(drug_code);
		store_code			=	bean_1.getStoreCode();
		params				+=	"&store_code="+store_code;
		store_desc			=	bean.getStoreDesc(store_code);
		ArrayList	st_items	=	new ArrayList();
		if(alt_drug_code.equals(""))
			st_items			= bean.getStockItems(drug_code);
		stk_units				= bean.loadStockUnit(drug_code);	
		HashMap issue_uom_qty_hm =  bean.getIssueUomQty();
		if(issue_uom_qty_hm.size()>0){
			if(issue_uom_qty_hm.containsKey(order_id+order_line_no+drug_code+"_uom")){
				dflt_issue_uom = (String)issue_uom_qty_hm.get(order_id+order_line_no+drug_code+"_uom");
			}
		}
		IssueUOMAndBaseUOM		=(HashMap)bean.getStoreDfltIssueUOMAndBaseUOM(store_code,drug_code);

		orig_dflt_issue_uom =	(String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM")==null?"":(String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM");
		if(dflt_issue_uom.equals("")){
			dflt_issue_uom =	(String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM")==null?"":(String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM"); //orig_dflt_issue_uom changed to dflt_issue_uom for  [IN:046372]
		}
		//added for AAKH-SCF-0338 - start
		if(stk_units!=null && stk_units.size()>0){
			if(!stk_units.contains(orig_dflt_issue_uom)){
				uom_desc = bean.getUOMDesc(orig_dflt_issue_uom);
				stk_units.add(orig_dflt_issue_uom);
				stk_units.add(uom_desc);
				stk_units.add("1");
				stk_units.add("1");
			}
		}
		//added for AAKH-SCF-0338 - end

		
		base_uom            =	(String)IssueUOMAndBaseUOM.get("BASE_UOM")==null?"":(String)IssueUOMAndBaseUOM.get("BASE_UOM");
		double base_to_disp_uom_equl    =  bean.getEqulValue ( drug_code, base_uom, uom_code);
		double base_to_def_uom_equl	    =  bean.getEqulValue ( drug_code, base_uom, orig_dflt_issue_uom);

		if(base_to_disp_uom_equl!=0 && base_to_def_uom_equl!=0){
			flag =true;
		}
		if(orig_dflt_issue_uom.equals(base_uom))
			bean.setIssueUomQty(order_id+order_line_no+drug_code+"_base_to_def_uom_equl","1");

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(store_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(params));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
 
								for(int i=0; i<items.size(); i+=2) { 
									item_code	=	(String)items.get(i);
									item_desc	=	(String)items.get(i+1);

									int stock_qty	=	bean.getTotalStockQty(patient_id,order_id,order_line_no);
									if(st_items.size()!=0 && st_items.contains(item_code)) {
										if(	stock_qty != 0 ) {
											entered	=	true;

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(item_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block17Bytes, _wl_block17);
		
										}
										else{	

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(item_desc));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block17Bytes, _wl_block17);
	
										}
									}
									else if(!alt_drug_code.equals("")) {
										if(	stock_qty != 0 ) {
										entered	=	true;

            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(item_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block17Bytes, _wl_block17);

									}
									else{	

            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(item_desc));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block17Bytes, _wl_block17);
	
									}
								}
								else{

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(item_desc));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block17Bytes, _wl_block17);

								}
							}	

            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

						if(bean_1.getIssueByUOM().equals("D")){
							 display_list ="display:none" ;
						}

            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(display_list));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(display_list));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(display_list));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(order_id+order_line_no+drug_code+"_uom"));
            _bw.write(_wl_block29Bytes, _wl_block29);
 
								boolean bSelected = false;
								if(stk_units.size()<1){
									flag = false;
								}
								else{
									for(int i=0; i<stk_units.size(); i+=4) { 
										stk_unit_code			=	(String)stk_units.get(i);
										stk_unit_desc			=	(String)stk_units.get(i+1);
										stk_equval_value		=	(String)stk_units.get(i+2);
										act_stk_equval_value	=	(String)stk_units.get(i+3);
										if(uom_code.equals(stk_unit_code)){
											base_to_disp_uom_equl_val = stk_equval_value; 
											bean.setIssueUomQty(order_id+order_line_no+drug_code+"_base_to_disp_uom_equl",stk_equval_value);
											/*bean.setIssueUomQty(order_id+order_line_no+drug_code+"_base_to_def_uom_equl",act_stk_equval_value);
											base_to_def_uom_equl_val =  act_stk_equval_value;*/
											if(!orig_dflt_issue_uom.equals(stk_unit_code)){
												bean.setIssueUomQty(order_id+order_line_no+drug_code+"_base_to_def_uom_equl",stk_equval_value);
												base_to_def_uom_equl_val =  stk_equval_value;
											}
										}
										else{
											//base_to_def_uom_equl_val = act_stk_equval_value;//added for MMS-MD-SCF-0204  
											bean.setIssueUomQty(order_id+order_line_no+drug_code+"_base_to_disp_uom_equl",base_to_disp_uom_equl+""); //Added for  MMS-SCF-0040 [IN:041888]
											bean.setIssueUomQty(order_id+order_line_no+drug_code+"_base_to_disp_uom_equl",base_to_disp_uom_equl+""); //Added for  MMS-SCF-0040 [IN:041888]
										}

										/*if(!orig_dflt_issue_uom.equals(stk_unit_code)){
											bean.setIssueUomQty(order_id+order_line_no+drug_code+"_base_to_def_uom_equl",stk_equval_value);
											base_to_def_uom_equl_val =  stk_equval_value;
										}*/
									if(issue_uom_qty_hm.containsKey(order_id+order_line_no+drug_code+"_equl")){
										if(dflt_issue_uom.equals(stk_unit_code))
										stk_equval_value	= (String)issue_uom_qty_hm.get(order_id+order_line_no+drug_code+"_equl");
									}

										if(dflt_issue_uom.equals(stk_unit_code)){
											bSelected = true;
										

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(stk_unit_code));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(stk_equval_value));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(stk_unit_desc));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(act_stk_equval_value));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(stk_unit_desc));
            _bw.write(_wl_block17Bytes, _wl_block17);

										}
										else{

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(stk_unit_code));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(stk_equval_value));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(stk_unit_desc));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(act_stk_equval_value));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(stk_unit_desc));
            _bw.write(_wl_block17Bytes, _wl_block17);

										}
									}
								}
 
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(base_to_disp_uom_equl_val));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(base_to_def_uom_equl_val));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(base_to_disp_uom_equl));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(base_to_def_uom_equl));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(params));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(end_date));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(trade_code));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(allowchangetradenameyn));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(allowmultitradeyn));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(allow_short_expiry_drugs_yn));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(stk_qty));
            _bw.write(_wl_block41Bytes, _wl_block41);

		if (!bSelected){

            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(uom_code));
            _bw.write(_wl_block43Bytes, _wl_block43);

		}

            _bw.write(_wl_block44Bytes, _wl_block44);

				if(flag){

            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(drug_color));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(alt_drug_code));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(uom));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(uom_code));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(source));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(recno));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(end_date));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(drug_strength));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(alt_drug_strength));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(bms_strength));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(oper_mode));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(drug_class));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(stk_qty));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(min_end_date));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(drug_name));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(altdrug_name));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(main_strength_per_value_pres_uom));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(alt_drg_no));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(alt_strength_uom));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(prescribed_strength));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(bean_1.getBarcode_Scan_YN()));
            _bw.write(_wl_block46Bytes, _wl_block46);

				}
				else{
					if(orig_dflt_issue_uom.equals("")){

            _bw.write(_wl_block47Bytes, _wl_block47);
  
					}
					else{

            _bw.write(_wl_block48Bytes, _wl_block48);

					}

            _bw.write(_wl_block49Bytes, _wl_block49);

				}

            _bw.write(_wl_block50Bytes, _wl_block50);

				if(entered)	{
					if(flag){				

            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(drug_color));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(alt_drug_code));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(qty));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(uom));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(uom_code));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(source));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(recno));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(end_date));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(drug_strength));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(alt_drug_strength));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(bms_strength));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(oper_mode));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(drug_class));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(stk_qty));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(min_end_date));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(drug_name));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(altdrug_name));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(main_strength_per_value_pres_uom));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(alt_drg_no));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(alt_strength_uom));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(prescribed_strength));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(bean_1.getBarcode_Scan_YN()));
            _bw.write(_wl_block52Bytes, _wl_block52);
	   
					}
					else{
						if(orig_dflt_issue_uom.equals("")){

            _bw.write(_wl_block53Bytes, _wl_block53);
			
						}
						else{

            _bw.write(_wl_block54Bytes, _wl_block54);
		
						}

            _bw.write(_wl_block55Bytes, _wl_block55);

					}
				}
				else{

            _bw.write(_wl_block56Bytes, _wl_block56);
	
				}	

            _bw.write(_wl_block57Bytes, _wl_block57);

	}
	catch(Exception e){
		e.printStackTrace();
	}

            _bw.write(_wl_block58Bytes, _wl_block58);

//putObjectInBean(bean_id,bean,request);
putObjectInBean(bean_id_1,bean_1,request);

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Store/ItemDetails.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Store.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ItemCode.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ItemDesc.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ISSUEUOM.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.StockAvailability.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
