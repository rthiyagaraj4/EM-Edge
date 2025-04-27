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
import eOR.Common.*;
import eOR.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __directdispprevieworderdrugdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/DirectDispPreviewOrderDrugDetails.jsp", 1736503455350L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<html>\n\t\t\t<head>\n    <!-- <link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></link> -->\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\t<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n    <script language=\"JavaScript\" src=\"../../js/Prescription.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n </head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\n<form name=\"prescription_form_preview_order\" id=\"prescription_form_preview_order\" >\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<table border=\"0\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" id=\"prescription_table\">\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<tr><td class=\"data\" colspan=\"7\" >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td></tr>\n\t\t<tr><td width=\"10%\">&nbsp;</td>\n\t\t\t<!-- <td class=\"data\" WRAP colspan=\"3\"  width=\"50%\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&nbsp;&nbsp;";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&nbsp;";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" &nbsp;&nbsp;";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&nbsp;&nbsp;</td> commented on 8/10/09-->\n\t\t\t<td class=\"data\" WRAP colspan=\"3\"  width=\"50%\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&nbsp;&nbsp;</td>\n\t\t<td class=\"data\" wrap >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t<td class=\"data\" wrap  width=\"15%\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&nbsp;&nbsp;</td>\n\t\t<td class=\"data\" wrap  width=\"15%\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&nbsp;&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\n\t\t\t<td width=\"10%\">&nbsp;</td>\n\t\t\t<td class=\"label\" wrap  colspan=\"3\">&nbsp;&nbsp;";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&nbsp;<font style=\'color:";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =";background-color:";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =";\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</font></td>\n\t\t\t<td class=\"label\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\t\t<td class=\"label\" wrap >";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t</tr>\n\t\t\n\t\t<tr>\t<td width=\"10%\">&nbsp;</td>\n\t\t\t\t <td colspan=\"6\" class=\"label\"> \n\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t</td> \t\t\t\t\n\t\t</tr>\n\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t<tr>\t\n\t\t\t<td width=\"10%\">&nbsp;</td>\n\t\t\t<td colspan=\"6\" class=\"label\"><b>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =":&nbsp;&nbsp;</b>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\t\n\t\t</tr>\n\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t<tr><td class=\"data\" colspan=\"7\">&nbsp;</td></tr>\n\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t<tr>\n\t\t\t\t<td width=\"10%\" class=\"data\">";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n\t\t\t\t<!-- Modified for IN:069886 start-->\n\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\t\n\t\t\t\t<td class=\"label\" wrap colspan=\"4\">&nbsp;&nbsp;";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td>\n\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t<td class=\"label\" wrap colspan=\"4\">&nbsp;&nbsp;";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t<!-- Modified for IN:069886 end-->\n\t\t\t\t<td class=\"label\" wrap >";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td>\n\t\t\t\t<td class=\"label\" wrap >";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td>\n\t\t\t</tr>\n\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t<tr><td class=\"data\" colspan=\"7\">&nbsp;</td></tr>\n\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td></tr>\n\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t<tr>\n\t\t\t<td width=\"10%\" class=\"data\">";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</td>\n\t\t\t<td class=\"label\" wrap  colspan=\"3\">&nbsp;&nbsp;";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</td>\n\t\t    <td class=\"label\">";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</td>\n\t\t</tr>\n\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t<tr>\t<td width=\"10%\">&nbsp;</td>\n\t\t\t\t<td colspan=\"6\" class=\"label\">&nbsp;&nbsp;";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t<tr>\t\n\t\t\t\t\t<td width=\"10%\">&nbsp;</td>\n\t\t\t\t\t<td colspan=\"6\" class=\"label\"><b>";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</td>\n\t\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t  <tr>\t\n\t\t\t\t <td width=\"10%\">&nbsp;</td>\n\t\t\t\t <td colspan=\"6\" class=\"label\"><b>";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</td>\t\n\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t<tr>\t\n\t\t\t\t\t<td width=\"5%\" class=label>&nbsp;</td>\n\t\t\t\t\t<td class=label width=\"17%\" valign=\'TOP\'><U><b>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</b></U></td>\n\n\t\t\t\t\t</tr><br><br>\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t    <tr>\t\n\t\t\t\t<td width=\"10%\">&nbsp;</td>\n\t\t\t\t<td colspan=\"6\" class=\"label\"><b>";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</td><!-- modified for MMS-KH-CRF-0029[IN070606]-->\n\t\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t  <tr>\t\n\t\t\t  <td width=\"10%\">&nbsp;</td>\n\t\t\t   <td colspan=\"6\" class=\"label\"><b>";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</td>\n\t\t\t   </tr>\n\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t <tr>\t\n\t\t\t  <td width=\"10%\">&nbsp;</td>\n\t\t\t   <td colspan=\"6\" class=\"label\"><b>";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =":</b>";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t<tr>\t\n\t\t\t\t\t<td width=\"5%\" class=label>&nbsp;</td>\n\t\t\t\t\t<td class=label width=\"17%\" valign=\'TOP\' nowrap><b>";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="&nbsp;:</b></td>  \n\t\t\t\t\t<td class=label colspan=\'7\'  id=\'interaction_remarks";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\'>";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</td>\n\t\t\t\t</tr>  \n\t\t\t \n";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="&nbsp;:</b></td>\n\t\t\t\t\t<td class=label colspan=\'7\'  id=\'interaction_remarks";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</td>\n\t\t\t\t</tr>\n\t\t\t\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</td>\n\t\t\t\t</tr> <!-- added for MMS-KH-CRF-0029[IN070606] end-->\n\t\t\t\n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\t\t\t\t\t\t\t<tr>\t\n\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"5%\" class=label>&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=label width=\"17%\" valign=\'TOP\' nowrap><b>";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="&nbsp;:</b></td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=label colspan=\'7\'  id=\'interaction_remarks";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</td>\n\t\t\t\t\t\t\t\t\t\t\t</tr> \n";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t<tr><td class=\"white\"></td></tr><tr><td class=\"white\"></td></tr>\t\n\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t<tr>\n\t\t\t<td class=\"white\"></td></tr><tr><td class=\"white\"></td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\"white\"></td></tr><tr><td class=\"white\"></td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"10%\" colspan=\"2\" class=\"data\">";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 =":&nbsp;&nbsp;</td>\n\t\t\t<td colspan=\"5\" class=\"label\">&nbsp;&nbsp;";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t</table>\n";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n<table border=\"0\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" id=\"prescription_table\">\n";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t<tr><td class=\"data\" colspan=\"7\" >";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\n\t<tr><td width=\"10%\">&nbsp;</td>\n<td class=\"data\" WRAP colspan=\"3\"  width=\"50%\">";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\t<td class=\"label\">";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</td>\n\t\t\t\t</TR>\n\t\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n</form>\n</body>\n\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n</html>\n\n\n";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );
	
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
 
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------

20/10/2020      IN:069886         Haribabu                       Manickam            MO-CRF-20151
--------------------------------------------------------------------------------------------------------------
*/
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");

	try{
		String patient_id			=	request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String encounter_id			=	request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		String locn_code			=	request.getParameter("locn_code")==null?"":request.getParameter("locn_code");
		String actual_patient_class	=	request.getParameter("actual_patient_class")==null?"":request.getParameter("actual_patient_class");
		String bean_id				=	"DirectDispensingBean";
		String bean_name			= "ePH.DirectDispensingBean";
		String facility_id					= (String) session.getValue("facility_id");

		DirectDispensingBean bean   = (DirectDispensingBean)getBeanObject( bean_id,bean_name,request) ;
		ArrayList prescriptionDetails = bean.getpresDetails();
		ArrayList consumableDetails = bean.getConsumableDetails();

		String drug_code		=	null;
		String srl_no			=	null;
		String taper_yn			=	null;
		String split_dose_yn	=	null;
		String qty_value		=	null;
		String qty_desc			=	null;
		String or_qty_desc		=	null;
		String freq_nature		=	null;
		String freq_desc		=	null;
		String durn_value		=	null;
		String tmp_durn_value	=	null;
		String or_durn_desc		=	null;
		String or_durn_desc1	=	null;
		String strength_uom		=	null;
		String dosage_type		=	null;
		String strength_value	=	null;
		//String rowVal			=	null;
		String no_refill		=	null;
		String end_date			=	null;
		String repeat_durn_type	=	null;
		String	prn_dose		= 	"";
		String fract_dose		=   "N";
		String act_strength_value=  "";
		//String freq_str1 ="";
		//String freq_str2 ="";
		//String freq_str3 ="";
		//String freq_str4 ="";
		HashMap RefillDetail	=	null;
		//Code Added For ICN 29927	RUT-CRF-0034 -Start
		String route_color                 ="";
		String addRouteDesc                 =""; 
		String route_desc                 =""; 
		String fntColor                 ="";
		String backgrndColor= "";// added for CRF RUT-CRF-0034.1[IN:037389]
		String route_code                 =""; 
		//Code Added For ICN 29927	RUT-CRF-0034 -End
		/* Code Added for SKR-SCF-0647[Inc:35263]-Start */
		String drugindication_remarks	  ="";
		String override_remarks			  ="";
		String allergy_remarks			  ="";
		String dosage_remarks			  ="";
		HashMap PRN_remarks				  =	new HashMap();
		String PRN_remarks_code			  =	"";
		String PRN_remarks_dtl		  	  =	"";
	//MMS-KH-CRF-0029 [IN070606] - start
		String interaction_exists	=  "";
		String interaction_remarks	=  "";
		String food_interaction_remarks =  ""; 
		String lab_interaction_remarks  =  ""; 
		String disease_interaction_remarks ="";//Added for MMS-DM-CRF-0229
	//MMS-KH-CRF-0029 [IN070606] - end
		/* Code Added for SKR-SCF-0647[Inc:35263]-End */

            _bw.write(_wl_block6Bytes, _wl_block6);

				String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);


	if(prescriptionDetails.size()>0){ 

            _bw.write(_wl_block9Bytes, _wl_block9);

		ArrayList grp			=	(ArrayList) bean.sortList();		
		int k					=	0;
		HashMap drugDetails		=	null;
		String absol_qty		=	"";
		String pres_base_uom	=	"";
			
			for(int i=0;i<grp.size();i++){
				ArrayList displayList=(ArrayList) bean.getDisplayList((String)grp.get(i));
				
				for(int j=0;j<displayList.size();j++){
				drugDetails			= (HashMap) displayList.get(j);
											
				 drug_code			= (String)drugDetails.get("DRUG_CODE");
				 srl_no				= (String)drugDetails.get("SRL_NO");
				 taper_yn			= (String)drugDetails.get("TAPER_DOSE_YN");
				 split_dose_yn		= ((String)drugDetails.get("SPLIT_DOSE_YN_VAL"))==null?"N":(String)drugDetails.get("SPLIT_DOSE_YN_VAL");
				 qty_value			= (String)drugDetails.get("QTY_VALUE");
				 qty_desc			= (String)drugDetails.get("QTY_DESC");
				 or_qty_desc		= (String)drugDetails.get("OR_QTY_DESC");
				 	freq_nature		            =	((String)drugDetails.get("FREQ_NATURE"))==null?"":(String)drugDetails.get("FREQ_NATURE");
			
			//	 freq_nature		= (String)drugDetails.get("FREQ_NATURE");
				 freq_desc			= java.net.URLDecoder.decode((String)drugDetails.get("FREQ_DESC"));
				 durn_value			= (String)drugDetails.get("DURN_VALUE");
				 tmp_durn_value		= (String)drugDetails.get("TMP_DURN_VALUE");
				 or_durn_desc		= (String)drugDetails.get("DURN_DESC");
				 or_durn_desc1		= (String)drugDetails.get("DURN_DESC");
				 

				 strength_uom		= (String)drugDetails.get("STRENGTH_UOM");
				 dosage_type		= (String)drugDetails.get("DOSAGE_TYPE");
				 strength_value		= (String)drugDetails.get("STRENGTH_VALUE");
				// rowVal				= (String)drugDetails.get("rowVal");
				no_refill			= (String)drugDetails.get("NO_REFILL");
				end_date			= (String)drugDetails.get("END_DATE");	
				repeat_durn_type	= (String)drugDetails.get("REPEAT_DURN_TYPE");	
				absol_qty			= (String)drugDetails.get("ABSOL_QTY");
				pres_base_uom		= (String)drugDetails.get("PRES_BASE_UOM");
				prn_dose			= (String)drugDetails.get("PRN_DOSES_PRES_PRD_FILL");
			    fract_dose			= (String)drugDetails.get("FRACT_DOSE_ROUND_UP_YN");
				act_strength_value	= (String)drugDetails.get("ACT_STRENGTH_VALUE");
				//MMS-KH-CRF-0029 [IN070606] - start
				interaction_exists 	= (String)drugDetails.get("INTERACTION_EXISTS")==null?"":(String)drugDetails.get("INTERACTION_EXISTS");
				interaction_remarks	= (String)drugDetails.get("INTERACTION_REMARKS")==null?"":	(String)drugDetails.get("INTERACTION_REMARKS");
				food_interaction_remarks=	  (String)drugDetails.get("FOOD_INTERACTION_REMARKS")==null?"":	(String)drugDetails.get("FOOD_INTERACTION_REMARKS"); //MMS-KH-CRF-0029 [IN070606]
				lab_interaction_remarks=	  (String)drugDetails.get("LAB_INTERACTION_REMARKS")==null?"":	(String)drugDetails.get("LAB_INTERACTION_REMARKS");//MMS-KH-CRF-0029 [IN070606]
				disease_interaction_remarks=	  (String)drugDetails.get("DISEASE_INTERACTION_REMARKS")==null?"":	(String)drugDetails.get("DISEASE_INTERACTION_REMARKS");//Added for MMS-DM-CRF-0229
				interaction_remarks=interaction_remarks.replaceAll(" ","%20");
				interaction_remarks = java.net.URLEncoder.encode(interaction_remarks,"UTF-8");
				interaction_remarks = java.net.URLDecoder.decode(interaction_remarks,"UTF-8");
				interaction_remarks=interaction_remarks.replaceAll("%2520"," ");
				interaction_remarks=interaction_remarks.replaceAll("%20"," ");
				food_interaction_remarks=food_interaction_remarks.replaceAll(" ","%20");
				food_interaction_remarks = java.net.URLEncoder.encode(food_interaction_remarks,"UTF-8");
				food_interaction_remarks = java.net.URLDecoder.decode(food_interaction_remarks,"UTF-8");
				food_interaction_remarks=food_interaction_remarks.replaceAll("%2520"," ");
				food_interaction_remarks=food_interaction_remarks.replaceAll("%20"," ");
				lab_interaction_remarks=lab_interaction_remarks.replaceAll(" ","%20");
				lab_interaction_remarks = java.net.URLEncoder.encode(lab_interaction_remarks,"UTF-8");
				lab_interaction_remarks = java.net.URLDecoder.decode(lab_interaction_remarks,"UTF-8");
				lab_interaction_remarks=lab_interaction_remarks.replaceAll("%2520"," ");
				lab_interaction_remarks=lab_interaction_remarks.replaceAll("%20"," ");
				 //Adding start for MMS-DM-CRF-0229
				disease_interaction_remarks=disease_interaction_remarks.replaceAll(" ","%20");
				disease_interaction_remarks = java.net.URLEncoder.encode(disease_interaction_remarks,"UTF-8");
				disease_interaction_remarks = java.net.URLDecoder.decode(disease_interaction_remarks,"UTF-8");
				disease_interaction_remarks=disease_interaction_remarks.replaceAll("%2520"," ");
				disease_interaction_remarks=disease_interaction_remarks.replaceAll("%20"," ");//Adding end MMS-DM-CRF-0229
				//MMS-KH-CRF-0029 [IN070606] - end
				 /* Code Added for SKR-SCF-0647[Inc:35263]-Start */
				drugindication_remarks=(String)drugDetails.get("DRUG_INDICATION");
				/*drugindication_remarks=drugindication_remarks.replaceAll(" ","%20");
				drugindication_remarks = java.net.URLEncoder.encode(drugindication_remarks,"UTF-8");
				drugindication_remarks = java.net.URLDecoder.decode(drugindication_remarks,"UTF-8");
				drugindication_remarks=drugindication_remarks.replaceAll("%2520"," ");
				drugindication_remarks=drugindication_remarks.replaceAll("%20"," ");*/

				override_remarks   =drugDetails.get("CURRENTRX_REMARKS")==null?"":(String)drugDetails.get("CURRENTRX_REMARKS");
				/*override_remarks=override_remarks.replaceAll(" ","%20");
				override_remarks   =java.net.URLEncoder.encode(override_remarks);
				override_remarks   =java.net.URLDecoder.decode(override_remarks);
				override_remarks=override_remarks.replaceAll("%2520"," ");
				override_remarks=override_remarks.replaceAll("%20"," ");*/

				allergy_remarks   =drugDetails.get("ALLERGY_REMARKS")==null?"":(String)drugDetails.get("ALLERGY_REMARKS");
				/*allergy_remarks=allergy_remarks.replaceAll(" ","%20");
				allergy_remarks   =java.net.URLEncoder.encode(allergy_remarks);
				allergy_remarks   =java.net.URLDecoder.decode(allergy_remarks);
				allergy_remarks=allergy_remarks.replaceAll("%2520"," ");
				allergy_remarks=allergy_remarks.replaceAll("%20"," ");*/

				dosage_remarks   =drugDetails.get("DOSE_REMARKS")==null?"":(String)drugDetails.get("DOSE_REMARKS");
				//dosage_remarks		=java.net.URLDecoder.decode((String)drugDetails.get("DOSE_REMARKS"));
				PRN_remarks			=  bean.getPRNRemarks(drug_code);
				if(PRN_remarks != null){
					PRN_remarks_code = PRN_remarks.get("remarks_code")==null?"":(String)PRN_remarks.get("remarks_code");
					PRN_remarks_dtl = PRN_remarks.get("remarks_dtl")==null?"":(String)PRN_remarks.get("remarks_dtl");
				}//Code Added for SKR-SCF-0647[Inc:35263]-End
				 if(repeat_durn_type.equals(or_durn_desc))
					 or_durn_desc		= bean.getDurationType(repeat_durn_type);
				 else{
					 if(or_durn_desc.equals("M"))
						or_durn_desc="Minute(s)";
					 else if(or_durn_desc.equals("H"))
						or_durn_desc="Hour(s)";
					 else if(or_durn_desc.equals("W"))
						or_durn_desc="Week(s)";
					 else if(or_durn_desc.equals("D"))
						or_durn_desc="Day(s)";
					 else if(or_durn_desc.equals("L"))
						or_durn_desc="Month(s)";
					 else if(or_durn_desc.equals("Y"))
						or_durn_desc="Year(s)";
				 }
 				 

				if(prn_dose==null || prn_dose.equals("") || prn_dose.equals("0")) {
						prn_dose	=	"1";
				}

				RefillDetail= (HashMap) bean.getRefillDetail(srl_no);//Modified for IN:069886
				//RefillDetail= (HashMap) bean.populateRefillDetail(end_date,durn_value, repeat_durn_type,no_refill);
					

				if(strength_value!=null && !strength_value.equals("") && Float.parseFloat(strength_value) <1)
					strength_value = Float.parseFloat(strength_value) +"" ;

				if(strength_value.equals("0")) {
					strength_value		=	"";
					strength_uom		=	"";
				}				
				String tooltip			= "";
				String freq_str			= "";
				String pres_remarks		= "";
				ArrayList schedule		= null;
				String last_refill_durn_value=(String)RefillDetail.get("last_refill_durn_value")==null?durn_value:(String)RefillDetail.get("last_refill_durn_value");//Added for IN:069886
				//Hashtable template		= null;
			
				//ArrayList seq_num	=	(ArrayList)orderEntryRecordBean.getOrderFormats((drug_code+srl_no),(drug_code+srl_no)+"_0");

				
				/*if(seq_num==null)
					seq_num			=	new ArrayList();

				for(int p=0; p<seq_num.size(); p++) {
					
						template	=	(Hashtable)orderEntryRecordBean.getOrderFormats((drug_code+srl_no),((drug_code+srl_no)+((Integer.parseInt((String)seq_num.get(p))) ) ));
 						if(((String) template.get("field_mnemonic")).equals("PRES_REMARKS")) {
							pres_remarks += bean.getPrescriptionRemarks((String) template.get("field_values"))+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
						} else {
							pres_remarks += (String) template.get("field_values") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
						} 
				
				}*/
				//out.println("remarks"+pres_remarks);
				

				
				 schedule	=	(ArrayList)bean.getScheduleFrequencyStr(drug_code+srl_no,"0");
			

				 boolean split_chk	=	bean.checkSplit(schedule);

				  /*for(int n=0; n<schedule.size(); n++) {
					 HashMap detail	=	(HashMap)schedule.get(n);
					freq_str += detail.get("admin_time")+"-";
					freq_str += detail.get("admin_qty")+" "+qty_desc;
						if(n==(schedule.size()-1))
							freq_str +=" ";
						else
							freq_str +=", ";
				 }	*/
				 freq_str= (String)bean.getTooltipStringFrFreq(schedule,"prvwString"+bean.getUomDisplay(facility_id,qty_desc));
				if(dosage_type.equals("A"))
					tooltip			= "  "+qty_value+" "+or_qty_desc+" "+freq_desc+" for "+durn_value+" "+or_durn_desc;
				else if(schedule.size() > 0 && split_chk) {
					tooltip			= "  "+qty_value+" "+or_qty_desc+" <label style='color:red'>(Divided)</label> for "+durn_value+" "+or_durn_desc;
				} else if(schedule.size() > 0) {
					tooltip			= "  "+qty_value+" "+or_qty_desc+" "+freq_desc+" <label style='color:red'></label> for "+durn_value+" "+or_durn_desc;
				} else {
					tooltip			= "  "+qty_value+" "+or_qty_desc+" "+freq_desc+" for "+durn_value+" "+or_durn_desc;
				}
				//Added for IN:069886 start
				String tooltipnew			= "";
				if(dosage_type.equals("A"))
					tooltipnew			= "  "+qty_value+" "+or_qty_desc+" "+freq_desc+" for "+last_refill_durn_value+" "+or_durn_desc;
				else if(schedule.size() > 0 && split_chk) {
					tooltipnew			= "  "+qty_value+" "+or_qty_desc+" <label style='color:red'>(Divided)</label> for "+last_refill_durn_value+" "+or_durn_desc;
				} else if(schedule.size() > 0) {
					tooltipnew		= "  "+qty_value+" "+or_qty_desc+" "+freq_desc+" <label style='color:red'></label> for "+last_refill_durn_value+" "+or_durn_desc;
				} else {
					tooltipnew			= "  "+qty_value+" "+or_qty_desc+" "+freq_desc+" for "+last_refill_durn_value+" "+or_durn_desc;
				}
				//Added for IN:069886 end	
				// calculate the dosage qty
				String sch_size			=	"";
				String conv_factor		=	"";
				float    tot_qty_value    =0; 
				
				if(schedule.size() > 0 && (split_dose_yn.equals("N"))) {
						 //HashMap detail	=	(HashMap)schedule.get(0);
						 ArrayList dose_list		= (ArrayList)schedule.get(4);
						 if(fract_dose.equals("N")){
						   //qty_value		=	(String)detail.get("admin_qty");
						   if(dose_list.size()>0)								
						   {
						      qty_value		=	(String)dose_list.get(0);
						      if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
									 qty_value="1";
						   }
						   else
						   {
							  if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
									 qty_value="1";
						   }

						  }else{
                            if(dosage_type.equals("S")){								
                               //qty_value		=	(String)detail.get("admin_qty");
							    if(dose_list.size()>0)								
								{
									qty_value		=	(String)dose_list.get(0);	
									if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
										qty_value="1";
								}
								else
								{
									  if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
											 qty_value="1";
								}
							   qty_value        =   (Math.ceil(Float.parseFloat(qty_value)/Float.parseFloat(act_strength_value)))+"";
						     }else if(dosage_type.equals("Q")){
								//qty_value		=	(String)detail.get("admin_qty");
								if(dose_list.size()>0)								
								{
									qty_value		=	(String)dose_list.get(0);
									if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
										 qty_value="1";
								}
								else
								{
									if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
										 qty_value="1";
								}
                               	qty_value		=   (Math.ceil(Float.parseFloat(qty_value)))+"";
							 }  
						// qty_value        =   (Math.ceil(Float.parseFloat(qty_value)*schedule.size()))+"";

						 }

						 sch_size		=	""+dose_list.size();
						
					
				} else {
						//sch_size		=	repeat_value;
					
					if(split_dose_yn.equals("Y")){
						if(fract_dose.equals("N")){
							//for(int n=0; n<schedule.size(); n++) {
							if(schedule.size()>0) {
								sch_size		=	"1";
								//HashMap  detail	=  (HashMap)schedule.get(n);
								String final_qty="";
								ArrayList dose_list		= (ArrayList)schedule.get(4);
								for(int n=0; n<dose_list.size(); n++) {
								 //tot_qty_value    =  tot_qty_value+Float.parseFloat((String)detail.get("admin_qty"));
								final_qty	=	(String)dose_list.get(n);
								if(!(final_qty.equals("")||final_qty.equals("0")||final_qty==null))
									tot_qty_value    =  tot_qty_value+Float.parseFloat((String)dose_list.get(n));
								else
									tot_qty_value	+=1.0f;
								}
							}
						}else{
                          // for(int n=0; n<schedule.size(); n++) {
							if(schedule.size()>0) {
							  sch_size		=	"1";
							  //HashMap  detail	=  (HashMap)schedule.get(n);
							  ArrayList dose_list		= (ArrayList)schedule.get(4);
							  for(int n=0; n<dose_list.size(); n++) {
								if(dosage_type.equals("S")){
									//qty_value		=	(String)detail.get("admin_qty");
									qty_value		=	(String)dose_list.get(n);
									if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
										qty_value="1";
									qty_value        =   (Math.ceil(Float.parseFloat(qty_value)/Float.parseFloat(act_strength_value)))+"";
								}else if(dosage_type.equals("Q")){
									//qty_value		=	(String)detail.get("admin_qty");
									qty_value		=	(String)dose_list.get(n);
									if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
										qty_value="1";
                               		qty_value		=   (Math.ceil(Float.parseFloat(qty_value)))+"";
								}  
								tot_qty_value    =  tot_qty_value+Float.parseFloat(qty_value);
							  }

							}
						}

			            qty_value       =tot_qty_value+"";
					}
					else
					{
						if(freq_nature.equals("O"))
						{
							if(fract_dose.equals("Y") && dosage_type.equals("S"))
							{
								 qty_value   =   (Math.ceil(Float.parseFloat(qty_value)/Float.parseFloat(act_strength_value)))+"";
							}
						}
					}
				}
				

				if(freq_nature.equals("P") && absol_qty==null) {
					absol_qty		=	prn_dose;	
				}

				if(absol_qty==null || absol_qty.equals("0"))
					absol_qty		=	"1";



				if(dosage_type.equals("A") || freq_nature.equals("P")) {
										qty_value		=	absol_qty;
										dosage_type		=	"A";
				}

				if(dosage_type.equals("Q"))
					conv_factor = (String) bean.getConvFactor(qty_desc,pres_base_uom);
			 if(sch_size.equals("")){
					 sch_size ="1";
			 }	
			 //out.println("==sch_size=="+sch_size+",durn_value=="+durn_value+",dosage_type=="+dosage_type);
			if(!repeat_durn_type.equals(or_durn_desc1))
			{
				if(tmp_durn_value!=null && tmp_durn_value!="" && tmp_durn_value!="0")
					durn_value=tmp_durn_value;
			}
					//Code Added For ICN 29927	RUT-CRF-0034 Start
					route_code=(String)drugDetails.get("ROUTE_CODE")==null?"":	(String)drugDetails.get("ROUTE_CODE");  
					fntColor="000000";
					ArrayList routes				=	bean.getRoutes((String)drugDetails.get("FORM_CODE")); 
					for(int l=0; l<routes.size(); l+=3) { 
						if(route_code.equals(routes.get(l))){
							route_desc = (String)routes.get(l+1);
							route_color = (String)routes.get(l+2);
							break;
						}
					}
					if(route_color!= null && !route_color.equals("") && route_color.length()==12){
						fntColor= route_color.substring(0, 6);
						backgrndColor= route_color.substring(6, 12);// added for CRF RUT-CRF-0034.1[IN:037389]
					}
					addRouteDesc="("+route_desc+")"; 	// removed font for CRF RUT-CRF-0034.1[IN:037389]
					//Code Added For ICN 29927	RUT-CRF-0034 End
			
			
			String order_qty	=	bean.getOrderQty(drugDetails,qty_value,sch_size,durn_value,dosage_type,conv_factor,split_chk,"","","Preview");
			//out.println("order qty="+order_qty);
			order_qty			=	new Float(Math.ceil(Float.parseFloat(order_qty))).intValue()+"";
			
			String order_uom	=	bean.getOrderUnit(dosage_type,order_qty,drug_code);
			boolean override_flag=false; //MMS-KH-CRF-0029
		if(j==0 || !taper_yn.equals("Y")) {					

	
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((String)drugDetails.get("DRUG_DESC")));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strength_value));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(strength_uom));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf((String)drugDetails.get("FORM_CODE")));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf((String)drugDetails.get("DRUG_DESC")));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strength_value));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(CommonBean.checkForNull(bean.getUomDisplay(facility_id,strength_uom))));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf((String)drugDetails.get("FORM_CODE")));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(fntColor));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(backgrndColor));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(addRouteDesc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(order_qty));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(order_uom));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf((String)drugDetails.get("START_DATE")));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf((String)drugDetails.get("END_DATE")));
            _bw.write(_wl_block25Bytes, _wl_block25);

				if(!freq_str.equals("")) { 
					//out.println("freq_str--386--->" +freq_str);	
					freq_str=freq_str.trim();
					/*StringTokenizer st =new StringTokenizer(freq_str, ";");
					int countTokens = st.countTokens();
					//out.println("countTokens--393--->" +countTokens);		
					while (st.hasMoreTokens()){
						String ssssexa=st.nextToken();
						StringTokenizer st1 =new StringTokenizer(ssssexa, " ");
				
						while (st1.hasMoreTokens()){
								if(st1.hasMoreTokens())
									freq_str1=st1.nextToken();
								if(st1.hasMoreTokens())
									freq_str2=st1.nextToken();
								if(st1.hasMoreTokens())
									freq_str3=st1.nextToken();
								if(st1.hasMoreTokens())
									freq_str4=st1.nextToken();
						}
				out.println(freq_str1+" "+freq_str2+" "+freq_str3+" "+bean.getUomDisplay(facility_id,freq_str4)+";" );
				}*/
				out.println(freq_str);
		
            _bw.write(_wl_block26Bytes, _wl_block26);
	}	
		if(!pres_remarks.equals("")) {
	
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(pres_remarks));
            _bw.write(_wl_block29Bytes, _wl_block29);
	}		

		if(no_refill!=null && (!no_refill.equals(""))) {	
            _bw.write(_wl_block30Bytes, _wl_block30);

			if(!RefillDetail.isEmpty()){for(int p=0; p<((ArrayList)RefillDetail.get("refill_start_date")).size(); p++) { //if condtion added for regration issue		
			
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
if(p==(((ArrayList)RefillDetail.get("refill_start_date")).size()-1)){
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(tooltipnew));
            _bw.write(_wl_block34Bytes, _wl_block34);
}else{ 
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block34Bytes, _wl_block34);
} 
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(((ArrayList)RefillDetail.get("refill_start_date")).get(p)));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(((ArrayList)RefillDetail.get("refill_end_date")).get(p)));
            _bw.write(_wl_block38Bytes, _wl_block38);
			} 
		}
		}
		
		} else	{	
            _bw.write(_wl_block39Bytes, _wl_block39);

				if(freq_nature.equals("O") || freq_nature.equals("P")) {
	
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
		} else  { 
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(order_qty));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(order_uom));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf((String)drugDetails.get("START_DATE")));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf((String)drugDetails.get("END_DATE")));
            _bw.write(_wl_block44Bytes, _wl_block44);
 			}
		if(!freq_str.equals("")) { 
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(freq_str));
            _bw.write(_wl_block29Bytes, _wl_block29);
	}
		if(!pres_remarks.equals("")) {
	
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(pres_remarks));
            _bw.write(_wl_block29Bytes, _wl_block29);
	}	
	
		}		   
		k++;
		 //Code Added for SKR-SCF-0647[Inc:35263]-Start
		 if(!PRN_remarks_dtl.equals("")&&(freq_nature.equals("P"))){
	    
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(PRN_remarks_dtl));
            _bw.write(_wl_block47Bytes, _wl_block47);
	  
			   }
		      if(!drugindication_remarks.equals("")) {
		
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(drugindication_remarks));
            _bw.write(_wl_block49Bytes, _wl_block49);

				} //MMS-KH-CRF-0029 - start
				if((!override_remarks.equals("") && ((String)drugDetails.get("CURRENT_RX")).equals("Y")) || ( !allergy_remarks.equals("") && ((String)drugDetails.get("ALLERGY_YN")).equals("Y")) || ( ((String)drugDetails.get("LIMIT_IND")).equals("N")) || ((interaction_exists.equals("Y") && !interaction_remarks.equals("")) || !food_interaction_remarks.equals("") || !lab_interaction_remarks.equals(""))) //modified for MMS-KH-CRF-0029
				{  
				override_flag = true; 

            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);
				} //MMS-KH-CRF-0029 - end

		    if(!override_remarks.equals("")) {
		
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(override_remarks));
            _bw.write(_wl_block53Bytes, _wl_block53);

			}
		  if(!allergy_remarks.equals("")){
	    
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(allergy_remarks));
            _bw.write(_wl_block55Bytes, _wl_block55);
	
			}
		  if(!dosage_remarks.equals("")){
		
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(dosage_remarks));
            _bw.write(_wl_block55Bytes, _wl_block55);

		}//Code Added for SKR-SCF-0647[Inc:35263]-End
		//MMS-KH-CRF-0029 [IN070606] - start
			ArrayList hmDrugIntList=(ArrayList) drugDetails.get("INTERACTION_DTL");
			String interaction_desc = "";
			String interaction_type = "";
			ArrayList intrType = new ArrayList();
			HashMap DrugInteractionDtl=  null;
			if(hmDrugIntList!=null && hmDrugIntList.size()> 0){
				for(int count=0 ; count<(hmDrugIntList.size()-2) ; count++){
					DrugInteractionDtl =(HashMap) hmDrugIntList.get(count);
				  interaction_desc = (String)DrugInteractionDtl.get("interaction_desc");
				  interaction_type = (String)DrugInteractionDtl.get("INTR_TYPE2");
					intrType.add(interaction_type);
				}
			}
			String drug_drug_display = "none";
			String drug_food_display = "none";
			String drug_lab_display = "none";
			String drug_disease_display = "none";//MMS-DM-CRF-0229
			String drug_food_remarks ="";
			String drug_lab_remarks ="";
			String drug_disease_remarks ="";//MMS-DM-CRF-0229

			if(intrType!=null && intrType.size()>0){
			if(intrType.contains("D") || intrType.contains("G")){
				drug_drug_display = "inline";
			}
			if(intrType.contains("F")){
				drug_food_display = "inline";
			}
			if(intrType.contains("L")){
				drug_lab_display = "inline"; 
			}
			if(intrType.contains("I")){//MMS-DM-CRF-0229
    			drug_disease_display = "inline"; 
			}
			drug_food_remarks = food_interaction_remarks;
			drug_lab_remarks = lab_interaction_remarks;
			drug_disease_remarks = disease_interaction_remarks;//MMS-DM-CRF-0229

			} 
			if(interaction_exists.equals("Y") && !interaction_remarks.equals("") && drug_drug_display.equals("inline")){

            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(j));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(interaction_remarks));
            _bw.write(_wl_block61Bytes, _wl_block61);
		
			}
			if(drug_food_display.equals("inline") && override_flag ){ 

            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(j));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(drug_food_remarks));
            _bw.write(_wl_block63Bytes, _wl_block63);
		
			}
			if(drug_lab_display.equals("inline") && override_flag){ 

            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(j));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(drug_lab_remarks));
            _bw.write(_wl_block64Bytes, _wl_block64);
		
			}
             if(drug_disease_display.equals("inline") && override_flag){ //modified for MMS-DM-CRF-0229

            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(j));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(drug_disease_remarks));
            _bw.write(_wl_block67Bytes, _wl_block67);
		
										}
		
	  }
			if( (i!=(grp.size())-1))
			
            _bw.write(_wl_block68Bytes, _wl_block68);

			}
	
            _bw.write(_wl_block69Bytes, _wl_block69);
    String clinical_comments	=	bean.getPresRemarks();
		   if(clinical_comments!=null && !clinical_comments.equals("")) {
	
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(clinical_comments));
            _bw.write(_wl_block29Bytes, _wl_block29);
	   }
	
            _bw.write(_wl_block72Bytes, _wl_block72);

	}
if(consumableDetails.size()>0){
            _bw.write(_wl_block73Bytes, _wl_block73);

	
            _bw.write(_wl_block74Bytes, _wl_block74);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

for(int i=0;i<consumableDetails.size();i++)
	{

	HashMap  cons_dtl      =  new HashMap(); 
	cons_dtl =(HashMap)consumableDetails.get(i);
	
	HashMap batchDetails   =  new HashMap(); 
	
		 if(cons_dtl.get("SELECTED_YN").equals("Y")&& !cons_dtl.get("ALLOC_QTY").equals(""))
			 {   
			
				batchDetails = (HashMap)cons_dtl.get("BATCH_DET");
						
				
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf((String)batchDetails.get("ITEM_NAME")));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf((String)cons_dtl.get("ALLOC_QTY")));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf((String)cons_dtl.get("ORDER_UOM")));
            _bw.write(_wl_block77Bytes, _wl_block77);
  }
	}

}


            _bw.write(_wl_block78Bytes, _wl_block78);

	putObjectInBean(bean_id,bean,request);
	//putObjectInBean(or_bean_id,orbean,request);
	}
catch(Exception e){
	//out.println(e.toString());
	e.printStackTrace();
	
	}
            _bw.write(_wl_block79Bytes, _wl_block79);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.CurrentRx.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Qty.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.from.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.to.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugRemarks.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Refill.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.CurrentRx.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Taper.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugRemarks.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PRNRemarks.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugIndications.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OverrideReason.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DuplicateRemarks.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AllergyRemarks.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OverDoseRemarks.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Drug_DrugInteractionRemarks.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Drug_FoodInteractionRemarks.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Drug_LabInteractionRemarks.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Drug-DiseaseInteractionRemarks.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PrescriptionRemarks.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MedicalItems.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
