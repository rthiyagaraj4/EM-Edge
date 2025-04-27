package jsp_servlet._ess._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eSS.Common.*;
import eSS.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;
import eCommon.Common.*;
import java.util.*;

public final class __groupforstoredetailsbygroup extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ess/jsp/GroupForStoreDetailsbyGroup.jsp", 1733386788267L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonBean.jsp", 1710760607421L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<!-- ";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" -->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<html>\n<head>\n<!-- \t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></link> -->\n     ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' type=\'text/css\'></link>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../js/SsCommon.js\"></script>\n<!-- \t<script language=\"JavaScript\" src=\"../js/SsMessages.js\"></script> -->\n\t<script language=\"JavaScript\" src=\"../js/GroupForStoreByGroup.js\"></script>\n<!-- \t<script language=\"JavaScript\" src=\"../../eCommon/js/messages.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n -->\n<script>\n\n</script>\n</head>\n<body onMouseDown=\"CodeArrest();\">\n<form name=\"groupforstore_dtls\" id=\"groupforstore_dtls\">\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t<table cellpadding=\'0\' cellspacing=\'0\' border=\'0\' width=\'90%\' align=\'center\'>\n\t<tr align=\'right\' width=\'10%\'>\n\t\t<td class=\'WHITE\'>\n\t\t\t<p align=\"right\">\n\t\t\t<a href=\"javascript:goPrev(\'select\');\" id=\"prev\"  style=\"visibility:hidden\" >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</a>&nbsp;&nbsp;<a href=\"javascript:goNext(\'select\');\" id=\"next\" style=\"visibility:hidden\" >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</a>\n\t\t\t</p>\n\t\t</td>\n\t</tr>\n\t</table>\n\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t<table cellpadding=\"0\" cellspacing=\"0\" border=\"1\" width=\"100%\" align=\"center\">\n\t\t<tr style=\"position: sticky; top: 0; background-color: white; z-index: 1;\">\n\t\t\t<th>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th>\n\t\t\t<th>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</th>\n\t\t<!--\t<th>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</th>  -->\n\t\t\t<th>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</th>\n\t\t</tr>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t<tr>\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" align=\"center\" width=\"20%\" >\n\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t<font color=#FF5400 style=\"font-weight:500\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</font>\n\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t<input type=\"hidden\" name=\"store_desc";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" id=\"store_desc";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"></input><input type=\"hidden\" name=\"store_code";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" id=\"store_code";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\"></input></td>\n\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" align=\"center\" width=\"8%\" onMouseOver=\"displayToolTipDataChange(\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\',\'Record has been Modified\');\" onMouseOut=\"disasbleToolTipDataChange(\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\');\" ><input type=\"checkbox\" ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="  name=\"eff_status";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" onclick=\"assignEffStatus(this); enableqty(\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\');\" ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" ></input></td>\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" align=\"center\" width=\"8%\">\n\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\t\n\t\t<input type=\"hidden\"  align=\"center\" name=\"process";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" id=\"process";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\"></input>\n\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t<input type=\"checkbox\"  align=\"center\" name=\"process";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" onclick=\"assignValue(this);enableqty(\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\');\"  ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="  ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =" ></input>\n\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\t\n\t\t\t\n\t\t\t</td>\n\t\t\n\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" align=\"center\" width=\"5%\"  ><input type=\"hidden\"  name=\"min_qty";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" id=\"min_qty";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" ></input>\n\t\t\t<center>";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</center></td>\n\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" align=\"center\" width=\"5%\"  ><div id=\"qty_";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" style=\"float: right;text-align: right;visibility:visible;\" valign=\"middle\"><input type=\"text\" size=\"25\" maxlength=\"8\" class=\'NUMBER\' name=\"min_qty";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" onKeyPress=\"return isValidInteger();\" onBlur=\"validate_reorder_qty(\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\');\" onclick=\"\" ></input></td>\n\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\t\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" style=\"float: right;text-align: right;visibility:hidden;\" valign=\"middle\"><input type=\"text\" size=\"25\" maxlength=\"8\" class=\'NUMBER\' name=\"min_qty";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" value=\"\" onKeyPress=\"return isValidInteger();\" onBlur=\"validate_reorder_qty(\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\');\" onclick=\"\" ></input></div></td>\n\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\n\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" align=\"center\" width=\"5%\"  ><input type=\"hidden\"  name=\"reorder_qty";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" id=\"reorder_qty";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" align=\"center\" width=\"5%\"  ><div id=\"reorder_qty_";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" style=\"float: right;text-align: right;visibility:visible;\" valign=\"middle\"><input type=\"text\" size=\"25\" maxlength=\"8\" class=\'NUMBER\' name=\"reorder_qty";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" style=\"float: right;text-align: right;visibility:hidden;\" valign=\"middle\"><input type=\"text\" size=\"25\" maxlength=\"8\" class=\'NUMBER\' name=\"reorder_qty";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\n\t\t</tr>\n\t\n\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t<script>alert(getMessage( \"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));</script>\n\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n</table>\n<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n<input type=\"hidden\" name=\"initString\" id=\"initString\" value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\n\n";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t<script>\n\tmaxRec = ";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 =" ;\n\tdisplaySize = ";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 =" ;\n\tend = displaySize ;\n\tactiveLink();\n\t</script>\n";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 =" ;\n\tend = ";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 =" ;\n\tstart=";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 =";\n\tactiveLink();\n\t</script>\n";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" name=\"end\">\n<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" name=\"start\">\n<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\" name=\"count\">\n<input type=\"hidden\" value=\"select\" name=\"choosen_link\" id=\"choosen_link\">\n<input type=\"hidden\" name=\"location_ref\" id=\"location_ref\" value=\"bygroup\">\n<input type=\"hidden\" name=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\">\n<div name=\"tooltiplayer\" id=\"tooltiplayer\" style=\"position:absolute; width:20%; visibility:hidden;\" bgcolor=\"blue\">\n<table id=\"tooltiptable\" cellpadding=0 cellspacing=0 border=\"0\" width=\"auto\" height=\"100%\" align=\"center\">\n\t<tr><td width=\"100%\" id=\"t\"></td></tr>\n</table>\n</div>\t \n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );
	
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

 
	int maxRec=0; 


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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
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
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block3Bytes, _wl_block3);
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

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block8Bytes, _wl_block8);

	 request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
			String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);

	
	//set mode always as INSERT.
	String mode=CommonRepository.getCommonKeyValue("MODE_INSERT");
	String from			= request.getParameter( "from" ) ;
	String to			= request.getParameter( "to" ) ;
	String dispMode     = request.getParameter( "dispMode" ) ;
	boolean database_rec=false;
	String initString	= "";
	if(dispMode==null) dispMode="";
	int start = 0;
	int end  = 0;
	int displaySize = 0;
	int count = 0;
	String classvalue	= "";
	String classvalueChange="";	
	String bean_id		= "groupforstore" ;
	String bean_name	= "eSS.GroupForStoreBean";
	HashMap dataList	= null;
		GroupForStoreBean bean = (GroupForStoreBean)getBeanObject( bean_id,bean_name,request ) ;

	try{
	
	/* Initialize Function specific start */
	bean.setLoginFacilId((String)session.getValue( "facility_id" ));
	bean.setMode( mode ) ;
	bean.setLanguageId(locale);
	displaySize = Integer.parseInt( (String) CommonRepository.getCommonKeyValue("QUERY_RESULT_SIZE"));
	ArrayList result=new ArrayList();
	//Clear the Duplicates in DB
	bean.emptyDupRecords();
//	out.println("dispMode = "+dispMode);
	if(dispMode.equals("")){

		result=bean.getGroupCodeResultPagebyGroup();
		//System.out.println("getGroupCodeResultPagebyGroup"+bean.getGroupCodeResultPagebyGroup());
	}
	else{
		result=bean.getBeanRecords();
		//System.out.println("getBeanRecords"+bean.getBeanRecords());
	}
	
	maxRec=  result.size();
	
	displaySize = Integer.parseInt( (String) CommonRepository.getCommonKeyValue("QUERY_RESULT_SIZE"));

	if ( from == null )
		start = 0 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null ){
		end = displaySize ;
	}
	else{
		end = Integer.parseInt( to ) ;	
	}

	
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

	if(result.size() > 0 ){
	
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

	
	count	= start;
	int chkCount = 0;
	initString = "";
	String str_service_code = "";
	String str_short_desc	= "";
	String str_process		= "";
	String eff_status		= "";
	String min_qty			= "";
	String readonly			= "";
	String visible			= "";
	String reorder_qty			= "";
	
	while ( count < maxRec && count < end)
	{
	dataList =(HashMap) result.get(count);
			if ( count % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;
		eff_status		 = (String)dataList.get("EFF_STATUS");
		str_service_code = (String)dataList.get("STORE_CODE");
		str_short_desc	 = (String)dataList.get("SHORT_DESC");
		str_process		 = (String)dataList.get("PROCESS");
		
		String disp_effstatus	= "";
		String associate_yn		= "";
		String disabled			= "";
		
		ArrayList key=bean.chkGroupCodeDBbyGroup((String)dataList.get( "STORE_CODE" ));
	
		if( key.size()==5 ){

	//	out.println("key :"+key.get(0));
	//	out.println("eff :"+key.get(1));
	//	out.println("source :"+key.get(2));
	
			min_qty = (String)key.get(3)==null?"":(String)key.get(3);
			reorder_qty = (String)key.get(4)==null?"":(String)key.get(4);
		
		if( ((String)key.get(2)).equals("FB") ){
			classvalueChange=classvalue;
			disabled = "";
			database_rec=false;
				if( !key.get(0).equals("DN") ){
					associate_yn = "checked";
					str_process  = "Y";
				}
				else{
					associate_yn = "";
				}
				if( ((String)key.get(1)).equals("E") ){
					disp_effstatus = "checked";	
				}
				else{
					disp_effstatus = "";
					eff_status = "D";
				}
		}
		else{
			database_rec=true;
			readonly = "readonly";
		//	 min_qty = (String)key.get(3)==null?"":(String)key.get(3);
		//	System.out.println("min_qty = "+min_qty);
			
			if(key.get(0).equals("U")){
			classvalueChange="DATACHANGE";
			}
			else{
			classvalueChange=classvalue;
			}
			

			disabled = "";
			associate_yn = "checked";
				if( ((String)key.get(1)).equals("E") ){
					disp_effstatus = "checked";	
				}
				else{
					disp_effstatus ="";
					eff_status     ="D";
				}
		}
	}
	else{
			classvalueChange=classvalue;
			database_rec=false;
			if(((String)dataList.get( "EFF_STATUS" )).equals( "D" )){
			disp_effstatus = "";
			}
			else{
			disp_effstatus = "checked";	
			}

			if(((String)dataList.get( "PROCESS" )).equals( "Y" )){
			associate_yn= "checked" ;
			}
			else{
			associate_yn = "";	
			}
		
	}
	/*System.out.println("associate_yn"+associate_yn);
	if(associate_yn.equals("checked")){
		visible="visible";
	}else{
		visible="";
	}*/

	if( chkCount==0 ){
//		initString=eff_status+"|"+str_process+"|"+str_service_code+"|"+str_short_desc;
	//initString=eff_status+"|"+str_process+"|"+str_service_code+"|"+str_short_desc+"|"+min_qty;
	initString=eff_status+"|"+str_process+"|"+str_service_code+"|"+str_short_desc+"|"+min_qty+"|"+reorder_qty;
	
	}else{
//	initString=initString+"~"+eff_status+"|"+str_process+"|"+str_service_code+"|"+str_short_desc;
	//initString=initString+"~"+eff_status+"|"+str_process+"|"+str_service_code+"|"+str_short_desc+"|"+min_qty;
	initString=initString+"~"+eff_status+"|"+str_process+"|"+str_service_code+"|"+str_short_desc+"|"+min_qty+"|"+reorder_qty;
	
	}
	
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block20Bytes, _wl_block20);

			if(database_rec){
			
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf( str_short_desc ));
            _bw.write(_wl_block22Bytes, _wl_block22);

			}else{
			
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf( str_short_desc ));
            _bw.write(_wl_block24Bytes, _wl_block24);

			}
			
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(count));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(count));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf( str_short_desc));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(count));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(count));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf( str_service_code));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classvalueChange));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(classvalueChange));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(classvalueChange));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(disp_effstatus));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(count));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(eff_status));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(count));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block38Bytes, _wl_block38);
 
		if(database_rec){
	
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(count));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(count));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(str_process));
            _bw.write(_wl_block41Bytes, _wl_block41);

		}else{
	
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(count));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(count));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(str_process));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(count));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(associate_yn));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block46Bytes, _wl_block46);

		}
	
            _bw.write(_wl_block47Bytes, _wl_block47);
 if(database_rec) { 	
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(count));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(count));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(min_qty));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(CommonBean.checkForNull(min_qty,"&nbsp;")));
            _bw.write(_wl_block52Bytes, _wl_block52);
 } else if(associate_yn.equals("checked")){ 
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(count));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(count));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(count));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(min_qty));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(count));
            _bw.write(_wl_block56Bytes, _wl_block56);
 } else { 
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(count));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(count));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(count));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(count));
            _bw.write(_wl_block60Bytes, _wl_block60);
 } 
            _bw.write(_wl_block61Bytes, _wl_block61);
 if(database_rec) { 
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(count));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(count));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(reorder_qty));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(CommonBean.checkForNull(reorder_qty,"&nbsp;")));
            _bw.write(_wl_block52Bytes, _wl_block52);
 } else if(associate_yn.equals("checked")){ 
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(count));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(count));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(count));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(reorder_qty));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(count));
            _bw.write(_wl_block56Bytes, _wl_block56);
 } else {  
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(count));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(count));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(count));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(count));
            _bw.write(_wl_block60Bytes, _wl_block60);
 } 
            _bw.write(_wl_block67Bytes, _wl_block67);

		count++;
		chkCount++;
	}
	
	}else{
	
            _bw.write(_wl_block68Bytes, _wl_block68);

	
	}
	}
	catch(Exception es){
	// out.println(es);
	es.printStackTrace(); // COMMON-ICN-0185
	}

            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(java.net.URLEncoder.encode(initString)));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block73Bytes, _wl_block73);

if(dispMode.equals("")){

            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(maxRec));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(displaySize));
            _bw.write(_wl_block76Bytes, _wl_block76);

}
	else{
	
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(maxRec));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(displaySize));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(end));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(start));
            _bw.write(_wl_block79Bytes, _wl_block79);

	
	}

            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(end));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(start));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(count));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block84Bytes, _wl_block84);

	putObjectInBean( bean_id,bean,request);

            _bw.write(_wl_block3Bytes, _wl_block3);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Store.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enabled.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSS.MinQty.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ss_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSS.ReorderLevel.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ss_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSS.ReorderQuantity.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ss_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
