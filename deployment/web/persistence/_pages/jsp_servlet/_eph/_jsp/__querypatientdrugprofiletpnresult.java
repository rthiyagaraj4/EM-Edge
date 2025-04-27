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
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import eCommon.Common.*;
import java.util.*;

public final class __querypatientdrugprofiletpnresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/QueryPatientDrugProfileTPNResult.jsp", 1709121356315L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonBean.jsp", 1710760607421L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--This file is saved on 28/10/2005-->\n";
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

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n\t<head>\n\t\t<title></title>\n\t\t<!-- <link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></link> -->\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/QueryPatientDrugProfile.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../ePH/js/PhCommon.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n\n<script type=\"text/javascript\">\n\t\t\tfunction initScroll() {\n\t\t\t\tvar rightDivSize = document.body.offsetWidth-300;//ML-MMOH-SCF-2005 slight changed\n\t\t\t\tvar leftDiv = document.getElementById(\'table_container_left\');\n\t\t\t\tvar rightDiv = document.getElementById(\'table_container_right\');\n\t\t\t\tif(rightDiv!=undefined && leftDiv!=undefined){\n\t\t\t\t\trightDiv.style.width=rightDivSize+\'px\';\n\t\t\t\t\trightDiv.onscroll = function() {\n\t\t\t\t\t\tleftDiv.scrollTop = this.scrollTop;\n\t\t\t\t\t\tleftDiv.scrollTop = this.scrollTop;\n\t\t\t\t\t};\n\t\t\t\t}\n\t\t\t}\n\t\t</script>\n</head>\n\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onLoad=\"initScroll();\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<script>\n\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));\n\t\t</script>\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<table cellpadding=0 cellspacing=0 align=\"center\">\n\t\t<tr>\n\t\t<td width=\"80%\" class=\"white\">&nbsp;</td>\n\t\t<td width=\"20%\" class=\"white\">&nbsp;\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t</td></tr>\n\t\t</table>\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<!-- <div id=\'table_container_left\' style=\'overflow:hidden;width:250px;height:358px;position:relative;float:left;\'>\n\t\t<table   border=\"1\" width=\" 100%\" cellpadding=\"0\" cellspacing=\"0\" align=\"left\" style=\'border-collapse:collapse; position:absolute;\'>\n\n\t\t\n\t\t<th colspan=\"3\" >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th> -->\n\n\n           <div id=\'table_container_left\' style=\'overflow:hidden;width:250px;height:342px;position:relative;float:left;\'>\n\t\t\t<table   border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"left\" style=\'border-collapse:collapse; position:absolute;\'>\n\t\t\t\t<tr style=\'height:30px;\'>\n\t\t\t   <td class=\'COLUMNHEADER\' style=\"border:none\">&nbsp;</td>\n\t\t\t <td class=\'COLUMNHEADER\' style=\"border:none\">&nbsp;</td>\n\t\t\t\t\t<td class=\'COLUMNHEADER\' colspan=\"2\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t\t</tr>\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\t\t\n\t\t<tr style=\'height:27px;\'>\n\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="          \n\t\t\t\n\t<td style=\"cursor:pointer;font-size:9;color:blue;background-color:";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"  title=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" colspan=\"2\"  onClick=\"showTPNDetails(\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\',\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\');\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t<td style=\"font-size:10;color:";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" class=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" title=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" nowrap>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t<img  src=\'../../ePH/images/AddedIngredient.gif\' style=\"cursor:pointer\" height=\'15\' width=\'15\' onclick=\"openPPNDisplay(\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\')\"></img>\t\n\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\n\t</td>\n\n\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t</tr>\t\n\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\n\t\n\t\t</table>\n\t\t\t\t</div>\n\t\t<div id=\'table_container_right\' style=\'overflow:scroll;height:358px;position:relative;float:left;\'>\n\t\t<table   border=\"1\" cellpadding=\"0\" cellspacing=\"0\" align=\"left\" valign=\"top\" style=\'border-collapse:collapse; position:absolute;\'>\n\n\t\t<tr style=\'height:30px;\'>\n\t\t\t\t\t\t\t\n\t\n\t\t<td class=\'COLUMNHEADER\' nowrap style=\'border-left:0\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n\t\t<!--  added status label by chandrashekar raju for the incident no.SRR20056-SCF-7782 [IN:028179]-->\n\t\t<td class=\'COLUMNHEADER\' >";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td> \n\t\n\t\t<td class=\'COLUMNHEADER\' >";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td>\n\t\t<td class=\'COLUMNHEADER\' nowrap>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td>\n\t\t<td class=\'COLUMNHEADER\' >";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</td>\n\t</tr>\t\n\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\t\t\n\t\t<tr style=\'height:48px;\'>\n\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" style=\'width:0px;border-left:0\' title=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n                     <!-- if else condition end  -->\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\t\t\t\n\t\t\t\t\n\t<td class=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" nowrap> ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</td>\n\t\n\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t<td class=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</td>\n\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\t\n\t\n\t\n\t<td class=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" align=\"center\" title=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n\t\n\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\n\t\t\t\t<font >&nbsp;</font>\t\t\t\t\n\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\t\t\n\t\t \n\t <font class=\"HYPERLINK\" style=\"cursor:pointer\" onClick=\"showRemarks(\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\')\">\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =" </font>\n\n\t ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\n\t </td>\t\t\t\n\t\t<td class=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =" </td>\t\t\t\n\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="&nbsp;";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</td><!-- modfied FOR ML-MMOH-SCF-1303 -->\n\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</td><!-- modified FOR ML-MMOH-SCF-1303 -->\n\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="<!-- modified FOR ML-MMOH-SCF-1303 -->\n\t\t\t\t\t\t</td>\t\t\n\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" style=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" onMouseOver=\"showDiscCancelLink(this,\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\')\" id=\"disc_cancel_id\" onMouseOut=\"hideDiscCancelLink(this)\" onClick=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" id=\"disc_cancel_id\">";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t</td>\n\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\n\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t\t\n\t<td class=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" nowrap\t>";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t\t\t\t<br><br></td>\n\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t\t\t\n\t\n\t<td class=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t</tr>\n\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t</table>\n\t\t</div>\n\t\t<div name=\"tooltiplayer\" id=\"tooltiplayer\" style=\"position:absolute; width:20%; visibility:hidden;\" bgcolor=\"blue\">\n<table id=\"tooltiptable\" cellpadding=0 cellspacing=0 border=\"0\" width=\"auto\" height=\"100%\" align=\"center\">\n\t<tr><td width=\"100%\" id=\"t\"></td></tr>\n</table>\n</div>\n\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t<script language=\"javascript\">\n\t\tparent.parent.f_query_status.location.href=\"../../ePH/jsp/QueryTPNPatientDrugProfileStatus.jsp\";\n\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t<script>\n\t\tparent.parent.f_query_status.location.href=\"../../eCommon/html/blank.html\";\n\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));\n\t</script>\n\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n</body>\n";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n</html>\n\n";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );
	
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
        response.setHeader("Content-Type", "text/html;charset=UTF-8 ");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=UTF-8 ");
            _bw.write(_wl_block0Bytes, _wl_block0);

/*
---------------------------------------------------------------------------------------------------------------------------------	
	Date		Edit History	Name		Rev.Date   	Rev.By 		Description
--------------------------------------------------------------------------------------------------------------------------------

22/11/2019      IN070800        PRATHYUSHA                          ML-MMOH-SCF-1303
-------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            eCommon.Common.CommonBean CommonBean= null;{
                CommonBean=(eCommon.Common.CommonBean)pageContext.getAttribute("CommonBean");
                if(CommonBean==null){
                    CommonBean=new eCommon.Common.CommonBean();
                    pageContext.setAttribute("CommonBean",CommonBean);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

    CommonBean.setProperties( (Properties) session.getValue( "jdbc" ) ) ;
	CommonBean.setLoginById( (String) session.getValue( "login_user" ) ) ;
	CommonBean.setLoginAtWsNo( CommonBean.getProperties().getProperty( "client_ip_address" ) ) ;
	CommonBean.setLoginFacilityId( (String) session.getValue( "facility_id" ) ) ;

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

		request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
		request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
		response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
		response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		//ends
	String locale			= (String)session.getAttribute("LOCALE");
	String facility_id					= (String) session.getValue("facility_id");//added for ml-mmoh-scf-1303
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	//Search Criteria's from Query Criteria page
	String patient_id	= request.getParameter("patient_id");
	String dt_from		= request.getParameter("dt_from");
	String dt_to		= request.getParameter("dt_to");
	//String drug_name	= request.getParameter("drug_name");
	String drug_code	= request.getParameter("drug_code");
	String pat_class	= request.getParameter("pat_class");
	String status		=	request.getParameter("status");
	String called_frm  = request.getParameter("called_frm");
	String disp_locn_code = request.getParameter("disp_locn_code");

	String	bean_id			=	"QueryPatientDrugProfileBean" ;
	String	bean_name		=	"ePH.QueryPatientDrugProfileBean";

	QueryPatientDrugProfileBean bean = (QueryPatientDrugProfileBean)getBeanObject( bean_id,bean_name, request) ;

	String bean_id_2		= "@PrescriptionBean_1"+patient_id;
	String bean_name_2		= "ePH.PrescriptionBean_1";

	PrescriptionBean_1 bean_2	= (PrescriptionBean_1)getBeanObject( bean_id_2,bean_name_2,request);	

	HashMap disc_cancel         = new HashMap();

	String discontinued_link_yn = "N";
	String cancel_link_yn       = "N";
	String disc_cancel_style	= "";
	String on_click				= "";

	String ord[]		= request.getParameterValues("orderbycolumns");
	boolean searched	= request.getParameter( "searched" ) == null ? false : true  ;


	try{
		String classvalue			=	"";
		//String details				=	"";
		//String strength				=	"";
		//int count					=	0;
		patient_id	 = CommonBean.checkForNull( patient_id );
		dt_from		 = CommonBean.checkForNull( dt_from);
		dt_to		 = CommonBean.checkForNull( dt_to );
		drug_code	 = CommonBean.checkForNull( drug_code );
		pat_class	 = CommonBean.checkForNull( pat_class );
	
		
	String sql_append	=	"";
	
	
	HashMap sqlMap = new HashMap();

	int index = 2;
	
	if((pat_class.equals("IP") || pat_class.equals("DC")) && status.equals("A")) {
		sql_append	=	" AND SYSDATE BETWEEN A.START_DATE AND A.END_DATE AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL AND O.ORDER_LINE_STATUS NOT IN ('PO','PS','CN','HD','HC','DC')";
	} else if((pat_class.equals("OP") || pat_class.equals("EM") || pat_class.equals("XT")) && status.equals("A")) {
		sql_append	=	" AND SYSDATE BETWEEN A.START_DATE AND A.END_DATE AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL AND (NVL(A.TOT_ISSUED_QTY,0)-NVL(A.RETURNED_QTY,0))!=0 AND O.ORDER_LINE_STATUS NOT IN ('PO','PS','OS','RG','VF','HC','HD','CN','DC','AL')";
	} else if(status.equals("A")) {
		sql_append	=	" AND (A.PATIENT_CLASS = NVL('IP',A.PATIENT_CLASS) AND SYSDATE BETWEEN A.START_DATE AND A.END_DATE AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL AND (NVL(A.TOT_ISSUED_QTY,0)-NVL(A.RETURNED_QTY,0))>=0 AND O.ORDER_LINE_STATUS NOT IN ('PO','PS','CN','HD','HC','DC') OR A.PATIENT_CLASS = NVL('OP',A.PATIENT_CLASS) AND SYSDATE BETWEEN A.START_DATE AND A.END_DATE AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL AND (NVL(A.TOT_ISSUED_QTY,0)-NVL(A.RETURNED_QTY,0))>=0 AND O.ORDER_LINE_STATUS NOT IN ('PO','PS','OS','RG','VF','HC','HD','CN','DC','AL'))";

	} else if(status.equals("F")) {
		sql_append	=	" AND A.START_DATE > SYSDATE AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL ";
	} else if(status.equals("C")) {
		sql_append	=	" AND SYSDATE >= A.END_DATE AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL ";

	} else	if(status.equals("DC")) {
		sql_append	=	" AND O.DISC_DATE_TIME IS NOT NULL AND A.CANCEL_YN='N'";
		index = 3;
	} else if(status.equals("HD") || status.equals("HC")) {
		sql_append	=	" AND O.HOLD_DATE_TIME IS NOT NULL AND A.CANCEL_YN='N' AND O.ORDER_LINE_STATUS IN ('HD','HC')";
		index = 3;
	} else if(status.equals("R")) {
		sql_append	=	" AND A.RETURNED_QTY IS NOT NULL ";
		index = 3;
	} else if(status.equals("CN")) {
		sql_append	=	" AND A.CANCEL_YN='Y' ";
		index = 3;
	} 	else {
			index = 3;
	}

/*
	if (!sql_append.equals("")){
		sqlMap.put( "sqlData", PhRepository.getPhKeyValue("SQL_PH_DRUG_PROFILE_QUERY_SELECT2C") +  sql_append + " ORDER BY A.END_DATE DESC,A.ORIG_ORDER_ID,A.ORIG_ORDER_LINE_NO");		
	}else{
		sqlMap.put( "sqlData", PhRepository.getPhKeyValue("SQL_PH_DRUG_PROFILE_QUERY_SELECT2C")+" ORDER BY A.END_DATE DESC,A.ORIG_ORDER_ID,A.ORIG_ORDER_LINE_NO");
	}
*/

    // T.SHORT_DESC LINE_STATUS_DESC added to below query by chandrashekar raju for the incident no.SRR20056-SCF-7782 [IN:028179]

	String s1="SELECT distinct A.ORIG_ORDER_ID ORIG_ORDER_ID, A.ORIG_ORDER_LINE_NO ORIG_ORDER_LINE_NO, A.SRL_NO, Q.IV_PREP_YN IV_PREP_YN, Q.DISCHARGE_IND, O.ORDER_LINE_STATUS, O.CHILD_ORDER_YN, A.INFUSE_OVER, A.TRN_TYPE_IND, A.DRUG_CODE, C.LONG_NAME,  A.DOSAGE || CHR (13) || DECODE (A.SPLIT_YN, 'N', NULL, H.FREQ_DESC || ' , ') || CHR (13) || DURATION || ' ' || I.DURN_DESC DOSAGE_DETAILS, TO_CHAR (A.START_DATE, 'DD/MM/YYYY HH24:MI') START_DATE,TO_CHAR(A.END_DATE, 'DD/MM/YYYY HH24:MI')  END_DATE, A.PATIENT_CLASS, D.PATIENT_NAME, E.PRACTITIONER_NAME, J.FACILITY_NAME, DECODE (P.ASSIGN_CARE_LOCN_TYPE, 'N', L.SHORT_DESC, 'C', K.SHORT_DESC ) LOCATION, (CASE WHEN Q.CAN_REASON IS NOT NULL THEN 'HOLD' WHEN O.CAN_DATE_TIME IS NOT NULL  THEN 'CANCEL'  WHEN O.HOLD_DATE_TIME IS NOT NULL THEN 'HOLD' WHEN O.DISC_DATE_TIME IS NOT NULL  THEN 'DIS-CONTINUED' WHEN SYSDATE BETWEEN A.START_DATE AND A.END_DATE AND (NVL (A.TOT_ISSUED_QTY, 0) - NVL (A.RETURNED_QTY, 0)) != 0  THEN 'ACTIVE' ELSE 'INACTIVE'  END ) STATUS, C.PRES_BASE_UNIT, A.HEIGHT, A.HEIGHT_UOM, A.WEIGHT, A.WEIGHT_UOM, A.BSA, A.BMI, A.PRESCRIBED_QTY, A.TOT_ISSUED_QTY, A.TOT_ADMINISTERED_QTY, A.DOSAGE_UOM_CODE, O.ORDER_UOM, R.ROUTE_CODE, R.ROUTE_DESC ,A.END_DATE ENDING_DATE,T.SHORT_DESC LINE_STATUS_DESC FROM PH_PATIENT_DRUG_PROFILE A, PH_TPN_REGIMEN_LANG_VW C, MP_PATIENT D, AM_PRACTITIONER_LANG_VW E, AM_FREQUENCY_LANG_VW H, AM_DURATION_TYPE_LANG_VW I, SM_FACILITY_PARAM_LANG_VW J, OP_CLINIC_LANG_VW K, IP_NURSING_UNIT_LANG_VW L, OR_ORDER_LINE O, PR_ENCOUNTER P, OR_ORDER Q, PH_ROUTE_LANG_VW R, PH_PARAM_LANG_VW S,OR_ORDER_STATUS_CODE_LANG_VW T WHERE Q.ORDER_ID = O.ORDER_ID AND A.PATIENT_ID = ? AND A.PATIENT_CLASS BETWEEN NVL (?, '!') AND NVL (?, '~') AND A.START_DATE BETWEEN TO_DATE( NVL(?,'01/01/1472') , 'DD/MM/YYYY') AND TO_DATE( NVL (?,'31/12/5000') , 'DD/MM/YYYY') + 0.99999 AND A.DRUG_CODE BETWEEN NVL (?, '!') AND NVL (?, '~') AND D.PATIENT_ID = A.PATIENT_ID AND A.DRUG_CODE = C.TPN_REGIMEN_CODE AND E.PRACTITIONER_ID = A.PRES_PRACTITIONER_ID AND H.FREQ_CODE = A.FREQ_CODE AND I.DURN_TYPE = A.DURN_TYPE AND J.FACILITY_ID = A.ORIG_FACILITY_ID AND K.FACILITY_ID(+) = A.ORIG_FACILITY_ID AND K.CLINIC_CODE(+) = A.LOCN_CODE AND L.FACILITY_ID(+) = A.ORIG_FACILITY_ID AND L.NURSING_UNIT_CODE(+) = A.LOCN_CODE AND A.ORIG_ORDER_ID = O.ORDER_ID AND A.ORIG_ORDER_LINE_NO = O.ORDER_LINE_NUM  AND P.ENCOUNTER_ID = A.ENCOUNTER_ID AND P.FACILITY_ID = A.ORIG_FACILITY_ID AND R.ROUTE_CODE = S.DFLT_IV_ROUTE_CODE AND Q.IV_PREP_YN IN ('7', '8') AND O.ORDER_LINE_STATUS = T.ORDER_STATUS_CODE AND C.LANGUAGE_ID = E.LANGUAGE_ID  AND C.LANGUAGE_ID = H.LANGUAGE_ID AND C.LANGUAGE_ID = I.LANGUAGE_ID AND C.LANGUAGE_ID = J.LANGUAGE_ID AND C.LANGUAGE_ID = R.LANGUAGE_ID AND C.LANGUAGE_ID = S.LANGUAGE_ID  AND C.LANGUAGE_ID = ? AND K.LANGUAGE_ID(+) = ? AND L.LANGUAGE_ID(+) = ?    ";
	
	if (!sql_append.equals("")){
		sqlMap.put( "sqlData", s1+  sql_append + " ORDER BY ENDING_DATE DESC ,ORIG_ORDER_ID,ORIG_ORDER_LINE_NO");		

	}else{
		sqlMap.put( "sqlData", s1+" ORDER BY ENDING_DATE DESC ,ORIG_ORDER_ID,ORIG_ORDER_LINE_NO");
	}


	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	
	displayFields.add("DRUG_CODE");  //0
	displayFields.add("LONG_NAME");
	displayFields.add("ROUTE_CODE");
	displayFields.add("ROUTE_DESC");
	displayFields.add("DOSAGE_DETAILS");
	displayFields.add("START_DATE");    //5
	displayFields.add("END_DATE");
	displayFields.add("PATIENT_CLASS");
	displayFields.add("PRESCRIBED_QTY");
	displayFields.add("TOT_ISSUED_QTY");
	displayFields.add("TOT_ADMINISTERED_QTY");//10
	displayFields.add("PRACTITIONER_NAME");
	displayFields.add("LOCATION");
	displayFields.add("FACILITY_NAME");

	displayFields.add("INFUSE_OVER");
	displayFields.add("TRN_TYPE_IND");  //15
	displayFields.add("STATUS");
	displayFields.add("ORIG_ORDER_ID");
	displayFields.add("ORIG_ORDER_LINE_NO");
	displayFields.add("SRL_NO");
	displayFields.add("HEIGHT");  //20
	displayFields.add("HEIGHT_UOM");
	displayFields.add("WEIGHT");
	displayFields.add("WEIGHT_UOM");
	displayFields.add("BSA");
	displayFields.add("BMI");  //25
	displayFields.add("DISCHARGE_IND");
	displayFields.add("IV_PREP_YN");  
	displayFields.add("ORDER_UOM");
	displayFields.add("ORDER_LINE_STATUS");
	displayFields.add("CHILD_ORDER_YN");    //30
	displayFields.add("DOSAGE_UOM_CODE");
	displayFields.add("LINE_STATUS_DESC");//added  by chandrashekar raju for the incident no.SRR20056-SCF-7782 [IN:028179]
 
	ArrayList chkFields = new ArrayList();

	chkFields.add( patient_id.trim() );
	chkFields.add( pat_class.trim() );
	chkFields.add( pat_class.trim() );
	chkFields.add( dt_from.trim() );
	chkFields.add( dt_to.trim() );
	chkFields.add( drug_code.trim() );
	chkFields.add( drug_code.trim() );
	
	chkFields.add(locale);
	chkFields.add(locale);
	chkFields.add(locale);

	
	


// Adding function related array list into the HashMap

	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );
	
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap,request);




	if( (result.size()>=index) && ( !( ((String) result.get(0)).equals("0")) )){

		result = bean.getAllDisplayedRecords(result);

		
		if (result.size()<index){
	
            _bw.write(_wl_block9Bytes, _wl_block9);

		return;
		}
	
            _bw.write(_wl_block10Bytes, _wl_block10);

		// For display the previous/next link
		out.println(result.get(1));

	
            _bw.write(_wl_block11Bytes, _wl_block11);

					//Retriving the records from result arraylist
		ArrayList records	=new ArrayList();

		String ht_wt_title	=	"";
		String order_line_no	=	"";
		String line_iv_prep_yn	=	"";
		String dtls				=	"";
		String discharge_med	=	"";
		String pres_qty			=	"";
		String disp_qty			=	"";
		String qty_uom			=	"";
		String disp_uom			=	"";
		//String ret_uom			=	"";
		String tot_admin_qty	=	"";
		String admin_uom		=	"";
		String ret_diff			=	"";
		String line_status		=	"";
		String child_order		=	"";		
		String classVal			=	"";
		String pres_uom			=	"";
		String patient_class	=	"";
		String line_status_text			= "";//SRR20056-SCF-7782 [IN:028179]
		//String reissue_uom		=	"";
		//String strength_per_pres_uom = "";
		//String content_in_pres_base_uom = "";
		//String reissue_date_time = "";
		//String dosage_details = "";
		String Rx = "Rx";
        String font_color="";
		int	   PPNIOrderValues  = 0;
		
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

		for(int recCount=2; recCount<result.size(); recCount++) {

			if ( recCount % 2 == 0 )
				classvalue = "QRYODDSMALL" ;
			else
				classvalue = "QRYEVENSMALL" ;

			records=(ArrayList) result.get(recCount);

			ht_wt_title		=	"";

			
			if(records.get(20)!=null)
				
			{
				ht_wt_title	=	"Height:"+CommonBean.checkForNull((String)records.get(20));
				ht_wt_title	+=	";  Weight:"+CommonBean.checkForNull((String)records.get(22));
				ht_wt_title	+=	";  BSA:"+CommonBean.checkForNull((String)records.get(24));
				ht_wt_title	+=	";  BMI:"+CommonBean.checkForNull((String)records.get(25));
			}	

		//	dosage_details =  CommonBean.checkForNull((String)records.get(4));
			patient_class	= CommonBean.checkForNull((String)records.get(7));
			order_line_no   = CommonBean.checkForNull((String)records.get(18));
			line_iv_prep_yn = CommonBean.checkForNull((String)records.get(27));
			discharge_med	= CommonBean.checkForNull((String)records.get(26));
			pres_qty		= CommonBean.checkForNull((String)records.get(8));
			disp_qty		= CommonBean.checkForNull((String)records.get(9));

			qty_uom			= CommonBean.checkForNull((String)records.get(28));
			admin_uom		= CommonBean.checkForNull((String)records.get(31));
			tot_admin_qty	= CommonBean.checkForNull((String)records.get(10));
			line_status		= CommonBean.checkForNull((String)records.get(29));
			child_order		= CommonBean.checkForNull((String)records.get(30));
			line_status_text= CommonBean.checkForNull((String)records.get(32));//added  by chandrashekar raju for the incident no.SRR20056-SCF-7782 [IN:028179]

			disp_uom		=	qty_uom;
		//	ret_uom			=	qty_uom+"  - ";
			admin_uom		=	qty_uom;
		//	reissue_uom		=	disp_uom+"  - ";
			pres_uom    = qty_uom;

			if(pres_qty.equals("0")){pres_qty =""; pres_uom="";}
			if(disp_qty.equals("")) {
				disp_uom	=	"";
			}
			if(line_status.equals("IP")) {
				//disp_qty	="ALLOCATED";
				disp_qty	="";
				disp_uom	="";
			}

			if(tot_admin_qty.equals("")) {
				admin_uom	=	"";
			}

			if(line_iv_prep_yn.equals("N") || line_iv_prep_yn.equals("I")){
				if(order_line_no.equals("1")){
					classVal="STANDARD";
				}else{
					classVal="NONSTANDARD";
				}
			}
			else if(discharge_med.equals("D")){
				classVal="DISCHARGEMED1";
			}
		
            _bw.write(_wl_block15Bytes, _wl_block15);

			
			String drug_status = "";
			String order_id    = "";	
			String order_line_num	= "";
			String sr_no			= "";
			String future_yn		=	"";
			String expiry_yn		=	"";

			
			for(int colCount=0; colCount<records.size(); colCount++){
				/*
					 0	--->    
					 1	--->	LONG_NAME
					 2	--->	ROUTE_CODE
					 3	--->	ROUTE_DESC
					 4	--->	START_DATE
					 6	--->	END_DATE
					 11	--->	PREACTITIONER NAME
				*/
				if (colCount>13)
				{ 
					continue;

				}
				if (colCount ==0 ){
					drug_status = "";

					disc_cancel = bean.isCancelDiscontinuedApplicable((String)records.get( 17 ),(String)records.get( 18 ));	
					
					cancel_link_yn       = (String)disc_cancel.get("CANCEL");

					future_yn	=	bean.compareDate((String)records.get(5));
					expiry_yn	=	bean.compareDate((String)records.get(6));
					
	
					 if (line_status.equals("CN")){
							
						drug_status = "#990000";
						if(expiry_yn.equals("N")){
							classVal	= "EXPIRED_MEDICATION";
						}else{
							classVal	= "CANCEL";
						}
						
					}else if (line_status.equals("DC")){
						drug_status = "#C40062";
						if(expiry_yn.equals("N")){
							classVal	= "EXPIRED_MEDICATION";
						}else{
							classVal	= "DIS-CONTINUED";
						}
					}else if( ((((String)records.get( 16 )).trim()).equals("ACTIVE")) || ((patient_class.equals("IP") || patient_class.equals("DC")) && (line_status.equals("OS") || line_status.equals("RG") || line_status.equals("IP") || line_status.equals("VF") || line_status.equals("DF")) ) || ((patient_class.equals("OP") || patient_class.equals("EM")) && (line_status.equals("DP") || line_status.equals("DF") ) )){
						if(future_yn.equals("Y")) { 
							drug_status = "#99FFCC";
							classVal	= "FUTURE_Rx";
						}else{
							drug_status = "#FF5E5E";
							if(expiry_yn.equals("N")){
								classVal	= "EXPIRED_MEDICATION";
							}else {
								classVal	= "ACTIVE";
							}
						}
					}else if(child_order.equals("Y")){
						drug_status = "#B6BC8B";
						if(future_yn.equals("Y")) { 
							classVal	= "FUTURE_Rx";
						}else{
							classVal	= "Refill_Rx";
						}
		       		}else if(future_yn.equals("Y")) { 
						drug_status = "#99FFCC";
						classVal	= "FUTURE_Rx";						
					} else if(cancel_link_yn.equals("Y") || (line_status.equals("IP") || line_status.equals("PO") || line_status.equals("PS") || line_status.equals("AL") || line_status.equals("VF")) || (disp_qty.equals("") && !tot_admin_qty.equals("")) )  {
						drug_status = "#8204FF";
						if(expiry_yn.equals("N")){
							classVal	= "EXPIRED_MEDICATION";
						}else{
							classVal	= "YET_TO_BE_DISPENSED";
						}
					}else if (line_status.equals("HD") || line_status.equals("HC")){
						if(expiry_yn.equals("N")){
							drug_status = "#D9B86C";
						}else{
							drug_status = "#F0F000";
						}
						classVal	= "HOLD";
					
					} else if(expiry_yn.equals("N")){
						drug_status = "#D9B86C";
						classVal	= "EXPIRED_MEDICATION";
					}else {
						drug_status = "";
						classVal	= classvalue;
					}

				if(line_status.equals("PO") || line_status.equals("PS")){
					ht_wt_title	+= " / Pending for Approval";
				}

				if(line_iv_prep_yn.equals("1") || line_iv_prep_yn.equals("2") || line_iv_prep_yn.equals("3") || line_iv_prep_yn.equals("4") || line_iv_prep_yn.equals("5")){
						if(order_line_no.equals("1")){
							drug_status="#478F8F";
						}else{
							drug_status="#92C9C9";
						}
				}

				if((status.equals("C") || status.equals("*A")) && ((patient_class.equals("OP") || patient_class.equals("EM")) && (line_status.equals("DP") || line_status.equals("DF")) ) && expiry_yn.equals("N")){
					drug_status="#D9B86C";
					classVal	= "EXPIRED_MEDICATION";
				}

				if(status.equals("C") && ((patient_class.equals("OP") || patient_class.equals("EM")) && line_status.equals("OS") ) && child_order.equals("Y")){
					drug_status="#D9B86C";
				}

	 order_id=(String)records.get( 17 );
	if(line_iv_prep_yn.equals("7")){Rx = "";drug_status="#478F8F";}else {Rx = "Rx"; drug_status="#92C9C9";}			
	
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(drug_status));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(ht_wt_title));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf((String)records.get(0)));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(Rx));
            _bw.write(_wl_block21Bytes, _wl_block21);
   }else if(colCount==1){
			PPNIOrderValues=0;
			if(line_iv_prep_yn.equals("7")){
				PPNIOrderValues  = bean.getPPNIOrderValues(order_id,patient_id);
			}
		if(classVal.equals("CANCEL")){font_color="white";}else{font_color="none";}
		
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(font_color));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classVal));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(ht_wt_title));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf((String)records.get(colCount)));
            _bw.write(_wl_block26Bytes, _wl_block26);

			//out.println(PPNIOrderValues);
			if(PPNIOrderValues >0){
	
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(disp_locn_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(discharge_med));
            _bw.write(_wl_block28Bytes, _wl_block28);

		   }
		
		
            _bw.write(_wl_block29Bytes, _wl_block29);


	}
			}
			
            _bw.write(_wl_block30Bytes, _wl_block30);

	}
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

	
		  
		for(int recCount=2; recCount<result.size(); recCount++) {

			if ( recCount % 2 == 0 )
				classvalue = "QRYODDSMALL" ;
			else
				classvalue = "QRYEVENSMALL" ;

			records=(ArrayList) result.get(recCount);

			ht_wt_title		=	"";

			
			if(records.get(20)!=null)
				
			{
				ht_wt_title	=	"Height:"+CommonBean.checkForNull((String)records.get(20));
				ht_wt_title	+=	";  Weight:"+CommonBean.checkForNull((String)records.get(22));
				ht_wt_title	+=	";  BSA:"+CommonBean.checkForNull((String)records.get(24));
				ht_wt_title	+=	";  BMI:"+CommonBean.checkForNull((String)records.get(25));
			}	

		//	dosage_details =  CommonBean.checkForNull((String)records.get(4));
			patient_class	= CommonBean.checkForNull((String)records.get(7));
			order_line_no   = CommonBean.checkForNull((String)records.get(18));
			line_iv_prep_yn = CommonBean.checkForNull((String)records.get(27));
			discharge_med	= CommonBean.checkForNull((String)records.get(26));
			pres_qty		= CommonBean.checkForNull((String)records.get(8));
			disp_qty		= CommonBean.checkForNull((String)records.get(9));

			qty_uom			= CommonBean.checkForNull((String)records.get(28));
			admin_uom		= CommonBean.checkForNull((String)records.get(31));
			tot_admin_qty	= CommonBean.checkForNull((String)records.get(10));
			line_status		= CommonBean.checkForNull((String)records.get(29));
			child_order		= CommonBean.checkForNull((String)records.get(30));
			line_status_text= CommonBean.checkForNull((String)records.get(32));//added  by chandrashekar raju for the incident no.SRR20056-SCF-7782 [IN:028179]

			disp_uom		=	qty_uom;
		//	ret_uom			=	qty_uom+"  - ";
			admin_uom		=	qty_uom;
		//	reissue_uom		=	disp_uom+"  - ";
			pres_uom    = qty_uom;

			if(pres_qty.equals("0")){pres_qty =""; pres_uom="";}
			if(disp_qty.equals("")) {
				disp_uom	=	"";
			}
			if(line_status.equals("IP")) {
				//disp_qty	="ALLOCATED";
				disp_qty	="";
				disp_uom	="";
			}

			if(tot_admin_qty.equals("")) {
				admin_uom	=	"";
			}

			if(line_iv_prep_yn.equals("N") || line_iv_prep_yn.equals("I")){
				if(order_line_no.equals("1")){
					classVal="STANDARD";
				}else{
					classVal="NONSTANDARD";
				}
			}
			else if(discharge_med.equals("D")){
				classVal="DISCHARGEMED1";
			}
		
            _bw.write(_wl_block37Bytes, _wl_block37);

			
			String drug_status = "";
			String order_id    = "";	
			String order_line_num	= "";
			String sr_no			= "";
			String future_yn		=	"";
			String expiry_yn		=	"";

			
			for(int colCount=3; colCount<records.size(); colCount++){
				/*
					 0	--->    DRUG_CODE
					 1	--->	LONG_NAME
					 2	--->	ROUTE_CODE
					 3	--->	ROUTE_DESC
					 4	--->	START_DATE
					 6	--->	END_DATE
					 11	--->	PREACTITIONER NAME
				*/
				if (colCount>13)
				{ 
					continue;

				}
				if (colCount ==0 ){
					drug_status = "";

					disc_cancel = bean.isCancelDiscontinuedApplicable((String)records.get( 17 ),(String)records.get( 18 ));	
					
					cancel_link_yn       = (String)disc_cancel.get("CANCEL");

					future_yn	=	bean.compareDate((String)records.get(5));
					expiry_yn	=	bean.compareDate((String)records.get(6));
					
	
					 if (line_status.equals("CN")){
							
						drug_status = "#990000";
						if(expiry_yn.equals("N")){
							classVal	= "EXPIRED_MEDICATION";
						}else{
							classVal	= "CANCEL";
						}
						
					}else if (line_status.equals("DC")){
						drug_status = "#C40062";
						if(expiry_yn.equals("N")){
							classVal	= "EXPIRED_MEDICATION";
						}else{
							classVal	= "DIS-CONTINUED";
						}
					}else if( ((((String)records.get( 16 )).trim()).equals("ACTIVE")) || ((patient_class.equals("IP") || patient_class.equals("DC")) && (line_status.equals("OS") || line_status.equals("RG") || line_status.equals("IP") || line_status.equals("VF") || line_status.equals("DF")) ) || ((patient_class.equals("OP") || patient_class.equals("EM")) && (line_status.equals("DP") || line_status.equals("DF") ) )){
						if(future_yn.equals("Y")) { 
							drug_status = "#99FFCC";
							classVal	= "FUTURE_Rx";
						}else{
							drug_status = "#FF5E5E";
							if(expiry_yn.equals("N")){
								classVal	= "EXPIRED_MEDICATION";
							}else {
								classVal	= "ACTIVE";
							}
						}
					}else if(child_order.equals("Y")){
						drug_status = "#B6BC8B";
						if(future_yn.equals("Y")) { 
							classVal	= "FUTURE_Rx";
						}else{
							classVal	= "Refill_Rx";
						}
		       		}else if(future_yn.equals("Y")) { 
						drug_status = "#99FFCC";
						classVal	= "FUTURE_Rx";						
					} else if(cancel_link_yn.equals("Y") || (line_status.equals("IP") || line_status.equals("PO") || line_status.equals("PS") || line_status.equals("AL") || line_status.equals("VF")) || (disp_qty.equals("") && !tot_admin_qty.equals("")) )  {
						drug_status = "#8204FF";
						if(expiry_yn.equals("N")){
							classVal	= "EXPIRED_MEDICATION";
						}else{
							classVal	= "YET_TO_BE_DISPENSED";
						}
					}else if (line_status.equals("HD") || line_status.equals("HC")){
						if(expiry_yn.equals("N")){
							drug_status = "#D9B86C";
						}else{
							drug_status = "#F0F000";
						}
						classVal	= "HOLD";
					
					} else if(expiry_yn.equals("N")){
						drug_status = "#D9B86C";
						classVal	= "EXPIRED_MEDICATION";
					}else {
						drug_status = "";
						classVal	= classvalue;
					}

				if(line_status.equals("PO") || line_status.equals("PS")){
					ht_wt_title	+= " / Pending for Approval";
				}

				if(line_iv_prep_yn.equals("1") || line_iv_prep_yn.equals("2") || line_iv_prep_yn.equals("3") || line_iv_prep_yn.equals("4") || line_iv_prep_yn.equals("5")){
						if(order_line_no.equals("1")){
							drug_status="#478F8F";
						}else{
							drug_status="#92C9C9";
						}
				}

				if((status.equals("C") || status.equals("*A")) && ((patient_class.equals("OP") || patient_class.equals("EM")) && (line_status.equals("DP") || line_status.equals("DF")) ) && expiry_yn.equals("N")){
					drug_status="#D9B86C";
					classVal	= "EXPIRED_MEDICATION";
				}

				if(status.equals("C") && ((patient_class.equals("OP") || patient_class.equals("EM")) && line_status.equals("OS") ) && child_order.equals("Y")){
					drug_status="#D9B86C";
				}

	 order_id=(String)records.get( 17 );
	if(line_iv_prep_yn.equals("7")){Rx = "";drug_status="#478F8F";}else {Rx = "Rx"; drug_status="#92C9C9";}			
	
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(drug_status));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(ht_wt_title));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf((String)records.get(0)));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(Rx));
            _bw.write(_wl_block21Bytes, _wl_block21);
   }//added below if else condition by chandrashekar raju for the incident no.SRR20056-SCF-7782 [IN:028179]
				else if (colCount==3){
					dtls = CommonBean.checkForNull((String)records.get( colCount ));
					if(line_iv_prep_yn.equals("N") || line_iv_prep_yn.equals("I")){
						if(!order_line_no.equals("1")){
							dtls = "&nbsp;";  
						}
					}

            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(ht_wt_title));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(line_status_text));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(ht_wt_title));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(dtls));
            _bw.write(_wl_block41Bytes, _wl_block41);

				}else if (colCount==4){	
	
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(ht_wt_title));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf((String)records.get(colCount)));
            _bw.write(_wl_block44Bytes, _wl_block44);

	}else if (colCount==5){
	
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(ht_wt_title));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf((String)records.get(colCount)));
            _bw.write(_wl_block46Bytes, _wl_block46);


	}else if (colCount==6){
	
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(ht_wt_title));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf((String)(records.get(colCount))));
            _bw.write(_wl_block46Bytes, _wl_block46);


	}else if (colCount==7 ){
					order_id=(String)records.get( 17 );
					order_line_num=(String)records.get( 18 );
					sr_no         =(String)records.get( 19 );

	
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(ht_wt_title));
            _bw.write(_wl_block49Bytes, _wl_block49);

					
			if ( !(((String)records.get(16)).trim()).equals("CANCEL") && !(((String)records.get(16)).trim()).equals("HOLD"))	{
	
            _bw.write(_wl_block50Bytes, _wl_block50);
	
		}
				
		 else  {	
	
	 
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(sr_no));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(line_status));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);

		 }
	 
	 
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(ht_wt_title));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf((String)records.get( colCount) 
	 ));
            _bw.write(_wl_block56Bytes, _wl_block56);
 
		}else if (colCount==8){
	
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(ht_wt_title));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(pres_qty));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(CommonBean.checkForNull(bean.getUomDisplay(facility_id,pres_uom))));
            _bw.write(_wl_block58Bytes, _wl_block58);


	}else if (colCount==9){
	
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(ht_wt_title));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(disp_qty));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(CommonBean.checkForNull(bean.getUomDisplay(facility_id,disp_uom))));
            _bw.write(_wl_block59Bytes, _wl_block59);


	}else if (colCount==10){
	
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(ht_wt_title));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(tot_admin_qty));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(CommonBean.checkForNull(bean.getUomDisplay(facility_id,admin_uom))));
            _bw.write(_wl_block60Bytes, _wl_block60);


	}else if(colCount==15){  
		 dtls = CommonBean.checkForNull((String)records.get( colCount ));
					disc_cancel = bean.isCancelDiscontinuedApplicable((String)records.get( 12 ),(String)records.get( 13 ));	
					 
					discontinued_link_yn = (String)disc_cancel.get("DISCONTINUE");
					cancel_link_yn       = (String)disc_cancel.get("CANCEL");

					if(disp_locn_code==null || disp_locn_code.equals("null"))
						disp_locn_code	=	"";

					if(discontinued_link_yn!=null && discontinued_link_yn.equals("Y")){
						disc_cancel_style = "cursor:pointer;color:blue";
					}else if(cancel_link_yn!=null && cancel_link_yn.equals("Y")){
						disc_cancel_style = "cursor:pointer;color:blue";
					}else{
						disc_cancel_style = "";
					}
					if(discontinued_link_yn!=null && discontinued_link_yn.equals("Y")){
						on_click = "discontinueTheDrug('"+(String)records.get( 12 )+"','"+(String)records.get( 13 )+"','"+called_frm+"')";
					}else if(cancel_link_yn!=null && cancel_link_yn.equals("Y")){
						on_click = "cancelTheDrug('"+(String)records.get( 12 )+"','"+(String)records.get( 13 )+"','"+called_frm+"')";
					}else{
						on_click = "";
					}
					if(called_frm==null)called_frm="";
					if(called_frm!=null && called_frm.equals("Dispense")){						
						if( ( ( (bean.isDiscontinuedAllowed(disp_locn_code)).equals("Y") || disp_locn_code.equals(""))  && discontinued_link_yn.equals("Y") && ret_diff.equals("0")) || (  cancel_link_yn.equals("Y")) ) {
	
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(ht_wt_title));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(disc_cancel_style));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(discontinued_link_yn));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(cancel_link_yn));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf((String)records.get( 12 )));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf((String)records.get( 13 )));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(on_click));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(dtls));
            _bw.write(_wl_block46Bytes, _wl_block46);

						}else{
	
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(ht_wt_title));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(dtls));
            _bw.write(_wl_block46Bytes, _wl_block46);

						}
					}else if(called_frm!=null && !called_frm.equals("QUERY")){
						if( (discontinued_link_yn.equals("Y") && ret_diff.equals("0")) || ( cancel_link_yn.equals("Y")) ) {
	
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(ht_wt_title));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(disc_cancel_style));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(discontinued_link_yn));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(cancel_link_yn));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf((String)records.get( 12 )));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf((String)records.get( 13)));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(on_click));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(dtls));
            _bw.write(_wl_block46Bytes, _wl_block46);
					} else {	

	
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(ht_wt_title));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(dtls));
            _bw.write(_wl_block46Bytes, _wl_block46);
					}
					}else{
	
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(ht_wt_title));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(dtls));
            _bw.write(_wl_block66Bytes, _wl_block66);

					}
				}else{
					dtls = CommonBean.checkForNull((String)records.get( colCount ));
					if(line_iv_prep_yn.equals("N") || line_iv_prep_yn.equals("I")){
						if(!order_line_no.equals("1")){
							if(colCount==3 || colCount==11 || colCount==12 || colCount==13 )
								dtls = "&nbsp;";  
						}
					}
				
	
            _bw.write(_wl_block67Bytes, _wl_block67);
 if(colCount==11){ 
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(ht_wt_title));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf((String)records.get(colCount)));
            _bw.write(_wl_block46Bytes, _wl_block46);
}else if(colCount==12){
		
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(ht_wt_title));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf((String)records.get(colCount)));
            _bw.write(_wl_block71Bytes, _wl_block71);
}else {
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(ht_wt_title));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(dtls));
            _bw.write(_wl_block26Bytes, _wl_block26);
           
							}	
				}
			}
			
	
            _bw.write(_wl_block73Bytes, _wl_block73);

		}
	
            _bw.write(_wl_block74Bytes, _wl_block74);

		out.flush();
	
            _bw.write(_wl_block75Bytes, _wl_block75);

	} else{
	
            _bw.write(_wl_block76Bytes, _wl_block76);

	}
	out.println(CommonBean.setForm ( request ,"../../ePH/jsp/QueryPatientDrugProfileTPNResult.jsp", searched) );
} catch(Exception e) {
	out.print("Exception @ Result JSP :"+e.toString());
	e.printStackTrace();
}

            _bw.write(_wl_block77Bytes, _wl_block77);
 
	putObjectInBean(bean_id,bean,request);
	putObjectInBean(bean_id_2,bean_2,request); 

            _bw.write(_wl_block78Bytes, _wl_block78);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Regimen.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Regimen.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Route.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Drug/DosageDetail.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StartDate.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enddate.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientclass.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PrescribedQuantity.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DispenseQuantity.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdminQuantity.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PrescribedBy.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderingLocation.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.facility.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
}
