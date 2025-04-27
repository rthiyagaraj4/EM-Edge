package jsp_servlet._eoh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eOH.*;
import eOH.Common.*;
import eCommon.Common.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __resultentryprocedurelink extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoh/jsp/ResultEntryProcedureLink.jsp", 1709119370508L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="\n ";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n ";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<html>\n<title>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</title>\n<head>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' type=\'text/css\'/>\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/grid.css\' type=\'text/css\'/>\n \t<script language=\"JavaScript\" src=\"../js/ResultEntry.js\"></script>\n\n \t<script language=\"JavaScript\" src=\"../js/OrCommonFunction.js\"></script>\n \t<script language=\"JavaScript\" src=\"../../eCommon/js/dchk.js\"></script>\n \t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n \t<!--<script language=\"JavaScript\" src=\"../../eCommon/js/messages.js\"></script>-->\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" >\n<form name=result_entry_proclink>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<table cellpadding=3 cellspacing=0 border=1 width=\"100%\" align=center class=\"grid\">\n<tr>\n\t\t\t\t\t<td class=columnheader width=\'\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t\t\t\t<td class=columnheader width=\'\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t\t\t<td class=columnheader width=\'\'></td>\n\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t<tr>\n\t\t\t\t\t<td colspan=\'4\' width=\'\' class=\'CAHIGHERLEVELCOLOR\'><font size=1>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</font>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t<img src=\"../../eCommon/images/mandatory.gif\" align=\'ABSMIDDLE\'></img>\t\n\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\n\t\t\t\t</tr>\n\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t<!-- Result -->\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t<tr>\n\t\t\t\t\t<!-- <td colspan=\'\' width=\'\' class=\'CAHIGHERLEVELCOLOR\'>&nbsp;</td> -->\n\t\t\t\t\t<td colspan=\'4\' width=\'\' class=\'CAHIGHERLEVELCOLOR\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t  ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="<font size=1>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t<img src=\"../../eCommon/images/mandatory.gif\" align=\'ABSMIDDLE\'></img>\n\t\t\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\n\t\t\t\t</TR>\n\t\t\t\t<!-- <tr>\n\t\t\t\t\t<th width=\'\'>Term Set</th>\n\t\t\t\t\t<th width=\'\'>Term Code</th>\n\t\t\t\t\t<th width=\'\'>Description</th>\n\t\t\t\t\t<th width=\'\'>&nbsp;</th>\n\t\t\t\t</tr> -->\n\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t <input type=hidden name=\'grp_cnt";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' id=\'grp_cnt";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t<tr>\n\n\t\t\t<td width=\'40%\' class=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'><font size=1>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</font></td>\n\t\t\t<td width=\'16%\' class=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</font></td>\n\t\t\t<td width=\'40%\' id=\'desc\' class=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</font></td>\n\n\t\t\t<td width=\'4%\' class=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n\t\t\t\t<input type=\"checkbox\" name=\"proc_chk";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" id=\"proc_chk";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="  ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =">&nbsp;\n\t\t\t\n\t\t\t</td>\n\n\t\t<input type=\'hidden\' name=\'proc_link_resulting_option";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' id=\'proc_link_resulting_option";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n\t\t<input type=\'hidden\' name=\'default_yn";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' id=\'default_yn";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n\t\t<input type=\'hidden\' name=\'proc_code";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' id=\'proc_code";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n\t\t<input type=\'hidden\' name=\'proc_scheme";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' id=\'proc_scheme";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'>\n\t\t<input type=\'hidden\' name=\'line_srl_num";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' id=\'line_srl_num";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n\t\t<input type=\'hidden\' name=\'parent_srl_no";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' id=\'parent_srl_no";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\n\t\t<input type=\'hidden\' name=\'long_desc";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' id=\'long_desc";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'>\n \t\t\t\n\t\t</tr>\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n <input type=hidden name=\'grp_cnt";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'>\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n<input type=hidden name=\'cnt\' id=\'cnt\' value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'>\n<input type=hidden name=\'mode\' id=\'mode\' value=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'>\t<!-- data required for bean -->\n<input type=hidden name=\'function_id\' id=\'function_id\' value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'>\t<!-- data required for bean -->\n<input type=hidden name=\'bean_id\' id=\'bean_id\' value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\'>\t\t<!-- data required for bean -->\n<input type=hidden name=\'bean_name\' id=\'bean_name\' value=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\'>\t\t<!-- data required for bean -->\n<input type=hidden name=\'totalRecs\' id=\'totalRecs\' value=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\'>\t\t<!-- data required for bean -->\n<input type=hidden name=\'proc_link_resulting_option_result\' id=\'proc_link_resulting_option_result\' value=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'>\t\t\n<input type=hidden name=\'chk_val\' id=\'chk_val\' value=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\'>\n<input type=hidden name=\'proc_scheme_code\' id=\'proc_scheme_code\' value=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\'>\n<input type=hidden name=\'order_type_code\' id=\'order_type_code\' value=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\'>\n<input type=hidden name=\'order_id\' id=\'order_id\' value=\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\'>\n<input type=hidden name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\'>\n<input type=hidden name=\'encounter_id\' id=\'encounter_id\' value=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\'>\n<input type=hidden name=\'patient_class\' id=\'patient_class\' value=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\'>\n\n</table>\n";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

	request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);

	
	/* Mandatory checks start */
	String mode	   = "1";//request.getParameter( "mode" ) ;
	String bean_id = "Oh_ResultEntry" ;
	String bean_name = "eOH.ResultEntryBean";
	//String task_type=request.getParameter("task_type");
	String orderId = request.getParameter("orderId")==null?"":request.getParameter("orderId");
	String proc_link_resulting_option_result = request.getParameter("proc_link_resulting_option_result")==null?"":request.getParameter("proc_link_resulting_option_result");
	String order_type_code = request.getParameter("order_type_code")==null?"":request.getParameter("order_type_code");
	String chk_val = request.getParameter("chk_val")==null?"": request.getParameter("chk_val");
	String proc_scheme_code = request.getParameter("proc_scheme_code")==null?"": request.getParameter("proc_scheme_code");
	String called_from = request.getParameter("called_from")==null?"":request.getParameter("called_from");
	String win_close = request.getParameter("win_close")==null?"":request.getParameter("win_close");
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String patient_class = request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
	String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	ArrayList allValues = new ArrayList();
/* Mandatory checks end */

	/* Initialize Function specific start */
	ResultEntryBean bean = (ResultEntryBean)getBeanObject( bean_id,bean_name ,request) ;
	bean.setLanguageId(localeName);
	//out.println("<script>alert('"+request.getQueryString()+","+request.getParameter("func_type")+","+bean.getFunc_type()+"')</script>");
	
	//allValues = bean.getProcedureDetails("RDOP00000005686");
	int count=bean.getRecordedProcedureCount(orderId);
	allValues = bean.getProcedureDetails(orderId,count);
	//String[] procScheme=bean.getProcScheme();

	String temp_chk="";String tmp_dsr_id="";
	//chk_val="N~Y~Y~";//chk_val="";
	int j=0,k=0;
	
	java.util.StringTokenizer stoken = new StringTokenizer(chk_val,"~");

            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

	String[] record = null;
	String classValue=""; String tmp_ord_cd="",disabled="";
	String checked="";boolean chk_flag= false;
	for(int i=0; i<allValues.size(); i++){
	//for(int i=0; i<2; i++){
		record = (String [])allValues.get(i);
		
		
		/*if(i % 2 == 0){
			classValue = "QRYEVEN";
		}else{
			classValue = "QRYODD";
		}*/
		classValue="gridData";
		if(record[0] == null) record[0] = "";
		if(record[1] == null) record[1] = "";
		if(record[2] == null) record[2] = "";
		if(record[3] == null) record[3] = "";
		if(record[4] == null) record[4] = "";
		if(record[5] == null) record[5] = "";
		if(record[6] == null) record[6] = "";
		if(record[7] == null) record[7] = "";
		if(record[8] == null) record[8] = "";
		if(record[9] == null) record[9] = "";
		if(record[10] == null) record[10] = "";
		if(record[11] == null) record[11] = "";
		if(record[12] == null) record[12] = "";
		if(record[13] == null) record[13] = "";
		if(record[14] == null) record[14] = "";
		if(called_from.equals("Coding") && record[14].equalsIgnoreCase("Y"))
			disabled="disabled";
		else
			disabled="";

		if(stoken.hasMoreTokens()) {
			temp_chk = stoken.nextToken();
			//out.println("<script>alert('---"+temp_chk+"--"+i+"-')</script>");
		}
		if(record[9].equals("Y")&& temp_chk.equals(""))
			checked ="checked";
		else if((!temp_chk.equals("")) && temp_chk.equals("Y"))
			checked ="checked";
		else
			checked ="";
		//out.println("<script>alert('---"+checked+"--"+i+"-')</script>");
		/*
        	
        	while (stoken.hasMoreTokens()) {
        		if ((stoken.nextToken()).equals(record[1])) {
        			showedGroup = true;
        			break;
        		}
        	}
        	strPanels = strPanels + "," + record[1];*/
        
            _bw.write(_wl_block14Bytes, _wl_block14);
if(!tmp_ord_cd.equals(record[5]) && !record[3].equals(record[4]) ){
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(record[3]));
//=record[4]
            _bw.write(_wl_block16Bytes, _wl_block16);
if(record[6].equals("R")&&record[7].equals("M")){
            _bw.write(_wl_block17Bytes, _wl_block17);
}
            _bw.write(_wl_block18Bytes, _wl_block18);
	tmp_ord_cd = record[5];chk_flag = true;
			}
            _bw.write(_wl_block19Bytes, _wl_block19);

				if(!tmp_dsr_id.equals(record[0])){
				//out.println("<script>alert('chk_flag===="+chk_flag+"===');</script>");
            _bw.write(_wl_block20Bytes, _wl_block20);
if(chk_flag){
						//out.println("\t");
            _bw.write(_wl_block21Bytes, _wl_block21);
}
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(record[4]));
            _bw.write(_wl_block16Bytes, _wl_block16);
if(record[6].equals("R") && !chk_flag && record[7].equals("M")){
            _bw.write(_wl_block23Bytes, _wl_block23);
	
				}
            _bw.write(_wl_block24Bytes, _wl_block24);
	tmp_dsr_id = record[0];if(k!=0){
				//out.println("<script>alert('=j=="+j+"==k=="+k+"===');</script>");
				
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(j));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(j));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(k));
            _bw.write(_wl_block28Bytes, _wl_block28);
	j++;}k=0;
			}
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(record[13]));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(record[10]));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(record[8]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j));
            out.print( String.valueOf(k));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(j));
            out.print( String.valueOf(k));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(checked));
            _bw.write(_wl_block37Bytes, _wl_block37);
//=eHISFormatter.ChkBoxChecked("Y",record[9])
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(j));
            out.print( String.valueOf(k));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(j));
            out.print( String.valueOf(k));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(record[7]));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(j));
            out.print( String.valueOf(k));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(j));
            out.print( String.valueOf(k));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(record[7]));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(j));
            out.print( String.valueOf(k));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(j));
            out.print( String.valueOf(k));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(record[10]));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(j));
            out.print( String.valueOf(k));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(j));
            out.print( String.valueOf(k));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(record[12]));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(j));
            out.print( String.valueOf(k));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(j));
            out.print( String.valueOf(k));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(j));
            out.print( String.valueOf(k));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(j));
            out.print( String.valueOf(k));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(record[2]));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(j));
            out.print( String.valueOf(k));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(j));
            out.print( String.valueOf(k));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(record[11]));
            _bw.write(_wl_block53Bytes, _wl_block53);
	k++;}
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(j));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(j));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(k));
            _bw.write(_wl_block55Bytes, _wl_block55);
//out.println("<script>alert('=j=="+j+"==k=="+k+"===');</script>");
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(j));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block58Bytes, _wl_block58);
//=function_id
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(allValues.size()));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(proc_link_resulting_option_result));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(chk_val));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(proc_scheme_code));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(order_type_code));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(orderId));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block70Bytes, _wl_block70);

	if(allValues.size() == 0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common')); location.href='../../eCommon/html/blank.html';window.close();</script>");
		
	}else if(allValues.size() == 1)
	{
		out.println("<script>if(eval('document.result_entry_proclink.proc_chk00').checked && eval('document.result_entry_proclink.proc_chk00').disabled){parent.proc_btn.document.result_entry_proc_btn.record.style.visibility='hidden';}</script>");
		
	}
	
	if(win_close.equals("Y")){
		out.println("<script>callRetainStatus('')</script>");
	}
	if(called_from.equals("Coding")){
		out.println("<script>callDisable()</script>");
	}

            _bw.write(_wl_block71Bytes, _wl_block71);

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ProcedureLink.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TermSet.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TermCode.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
}
