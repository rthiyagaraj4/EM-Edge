package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __taskforresprelnresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/TaskForRespRelnResult.jsp", 1730877029436L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n<title> ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script language=\'javascript\' src=\'../js/TaskForResp.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<script>\n\t\t\tif(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' <= 0){\n\t\t\tvar msg = getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\");\t\n\t\tparent.parent.messageFrame.location.href=\"../../eCommon/jsp/MstCodeError.jsp?err_num=\"+msg;\n\t\t}\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<body onLoad=\"\" class=\'CONTENT\' OnMouseDown=\'CodeArrest()\'  onKeyDown = \'lockKey()\'>\n<form name=\'formTaskRespRelnResult\' id=\'formTaskRespRelnResult\'>\n\t<table cellpadding=\'3\' cellspacing=\'0\' border=\'0\' width=\'85%\' align=\'center\'>\n<tr  width=\'10%\'>\n<td class=\'white\' width=\'89%\'></td>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\n\t\t<td width=\'6%\' class=\'label\'>\n\t\t<A class=\'gridLink\' HREF=\'javascript:onClick=checkVal(\"Previous\");\' text-decoration=\'none\' >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</A>\n\t\t</td>\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t<td width=\'6%\' class = \'label\'><A class=\'gridLink\' HREF=\'javascript:onClick=checkVal(\"Next\");\' text-decoration=\'none\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n</tr>\n</table> \n<div style=\"display: flex; justify-content: center;\">\n<table class=\'grid\' width=\'90%\' align=\'center\'>\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t<td class=\'COLUMNHEADERCENTER\' width=\'30%\' >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n<td class=\'COLUMNHEADERCENTER\' width=\'50%\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n<td class=\'COLUMNHEADERCENTER\' width=\'25%\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n<td class=\'COLUMNHEADERCENTER\' width=\'25%\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t<!-- <td class=\'COLUMNHEADERCENTER\' width=\'25%\'></td> -->\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t<tr id=\'\'>\n\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n          <td class=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' >\n\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'><input type = \"hidden\"  name=\"description";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" id=\"description";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" value =\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' ><select name=\"select_yn";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" id=\"select_yn";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" onChange=\'return checkNoteTypeForRes(this,\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\",\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\");\'>\n\t\t\t<option value=\'\'>--";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" -- </option>\n\t\t\t<option value=\"A\" ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" >";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</option>\n\t\t\t<option value=\"X\" ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</option>\n\t\t\t</select>\n\t\t\t</td>\n\t\t\t<!--Below code added by channaveer B for crf MO-CRF-33 -->\n\t\t\t<!--IN061903 start-->\n\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t<!--IN061903 end-->\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\"><select name=\"access_rights";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" id=\"access_rights";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" style=\"width:150px\" ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="disabled";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =">\n\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t<option value=\'ALL\' ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =">";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</option>\n\t\t\t<option value=\'MO\' ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</option>\n\t\t\t<option value=\'MS\' ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</option>\n\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t<option  value=\'\' >";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t</select>\n\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'></td>\n\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t<!-- ENDS HERE -->\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t<td>\n\t</td>\n\t</table>\n\t\t</div>\n\t<input type=\"hidden\" name=\"dispMode\" id=\"dispMode\" value=";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =" > \n\t<input type=\"hidden\" name=\"from\" id=\"from\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n\t<input type=\"hidden\" name=\"to\" id=\"to\" value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n\t<input type=\'hidden\' name=\'row_count\' id=\'row_count\' value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n\t<input type=\'hidden\' name=\'fm_disp\' id=\'fm_disp\' value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n\t<input type=\'hidden\' name=\'to_disp\' id=\'to_disp\' value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n\t<input type=\"hidden\" name=\"group_by\" id=\"group_by\" value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n\t<input type=\"hidden\" name=\"grp_by_code\" id=\"grp_by_code\" value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n\t<input type=\"hidden\" name=\"dtl_grp_by_code\" id=\"dtl_grp_by_code\" value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n\t<input type=\"hidden\" name=\"amend_order\" id=\"amend_order\" value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n\t<input type=\"hidden\" name=\"cancel_order\" id=\"cancel_order\" value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n\t<input type=\"hidden\" name=\"discontinue\" id=\"discontinue\" value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n\t<input type=\"hidden\" name=\"hold\" id=\"hold\" value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n\t<input type=\"hidden\" name=\"not_done\" id=\"not_done\" value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\"><!--IN061903-->\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );
	
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

int row_count=0;

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
------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History      		Name        		Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------------------------------
10/07/2017	IN061903			Krishna Gowtham J 	10/07/2017		Ramesh G		ML-MMOH-CRF-0555		
------------------------------------------------------------------------------------------------------------------------------------------------------
*/

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	webbeans.eCommon.RecordSet respRelnRecSet = (webbeans.eCommon.RecordSet)getObjectFromBean("respRelnRecSet","webbeans.eCommon.RecordSet",session);

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);
request.setCharacterEncoding("UTF-8"); 
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

            _bw.write(_wl_block1Bytes, _wl_block1);

	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

Connection con			= null;
PreparedStatement pstmt = null,pstmt1=null;
ResultSet rs			= null,rs1=null;
HashMap hMapRecords		= null; 

int row_disp=14;
int start = 0 ;
int end = 0 ;
int fm_disp=0, to_disp=0;

String title_desc="",title_desc1="",  sql_query="", code="", desc="", classValue="";
String update_val ="", valid="", associate="";
String function_id="",function_name="";
String insUpd="",  srl_no="", privilege_status="",selectOption1 ="";
String selectOption2 ="", privilege_status_value = "";
String prevVal = "" ;
String access_rigths_appl ="",access="",accessOption1="",accessOption2="",accessOption3=""; //removed access_for_all,access_applicable for checkstyle
String amend_order="",cancel_order="",discontinue="",hold="";
String not_done = ""; //IN061903

String dispMode		=	request.getParameter("dispMode")==null?"": request.getParameter("dispMode");
String from			=	request.getParameter( "from" )==null?"1": request.getParameter( "from" );
String to				=	request.getParameter( "to" )==null?String.valueOf(row_disp): request.getParameter( "to" );
String group_by = request.getParameter("group_by")==null?"":request.getParameter("group_by");
String grp_by_code = request.getParameter("grp_by_code")==null?"":request.getParameter("grp_by_code");
String dtl_grp_by_code = request.getParameter("dtl_grp_by_code")==null?"":request.getParameter("dtl_grp_by_code");
//HashMap<String,String> accessMap = new HashMap<String,String>(); //commented for checkstyle
start = Integer.parseInt( from ) ;
end = Integer.parseInt( to ) ;

try {
	con = ConnectionManager.getConnection(request);
	//IN061903 start
	//sql_query = "select APPL_TASK_ID ,ACCESS_RIGTHS_APPL from CA_APPL_TASK where APPL_TASK_ID IN ('AMEND_ORDER','CANCEL_ORDER','DISCONTINUE','HOLD')";
	sql_query = "select APPL_TASK_ID ,ACCESS_RIGTHS_APPL from CA_APPL_TASK where APPL_TASK_ID IN ('AMEND_ORDER','CANCEL_ORDER','DISCONTINUE','HOLD','NOTDONE')";
	//IN061903 ends
	pstmt = con.prepareStatement(sql_query);
	rs = pstmt.executeQuery();
		while(rs.next()){
			if(rs.getString("APPL_TASK_ID").equals("AMEND_ORDER"))
				amend_order=rs.getString("ACCESS_RIGTHS_APPL")==null?"NA":rs.getString("ACCESS_RIGTHS_APPL");
			else if(rs.getString("APPL_TASK_ID").equals("CANCEL_ORDER"))
				cancel_order=rs.getString("ACCESS_RIGTHS_APPL")==null?"NA":rs.getString("ACCESS_RIGTHS_APPL");
			else if(rs.getString("APPL_TASK_ID").equals("DISCONTINUE"))
				discontinue=rs.getString("ACCESS_RIGTHS_APPL")==null?"NA":rs.getString("ACCESS_RIGTHS_APPL");
			else if(rs.getString("APPL_TASK_ID").equals("HOLD"))
				hold=rs.getString("ACCESS_RIGTHS_APPL")==null?"NA":rs.getString("ACCESS_RIGTHS_APPL");
			//IN061903 start
			else if(rs.getString("APPL_TASK_ID").equals("NOTDONE"))
				not_done=rs.getString("ACCESS_RIGTHS_APPL")==null?"NA":rs.getString("ACCESS_RIGTHS_APPL");
			//IN061903 ends

			//accessMap.put( rs.getString("APPL_TASK_ID"), rs.getString("ACCESS_RIGTHS_APPL"));			
		}
		
	if(rs!=null) rs.close();	
	if(pstmt!=null) pstmt.close();
if(group_by.equals("TS")){
	if(dtl_grp_by_code.equals("DRS")){
		title_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.responsibility.label","common_labels");

		sql_query = "select a.resp_name description, a.resp_id code, (select privilege_status from ca_appl_task_for_resp_reln b where b.resp_id = a.resp_id and b.appl_task_id=? and rownum=1)privilege_status, (select srl_no from ca_appl_task_for_resp_reln b where b.resp_id = a.resp_id and b.appl_task_id=? and rownum=1) srl_no, (select (case when privilege_status is not null then 'Y' else 'N' end) from ca_appl_task_for_resp_reln b where b.resp_id = a.resp_id and b.appl_task_id=? and rownum=1)valid,(select ACCESS_RIGTHS_APPL from ca_appl_task_for_resp_reln b where b.resp_id = a.resp_id and b.appl_task_id=? and rownum=1)ACCESS_RIGTHS_APPL from  sm_resp a where a.eff_status='E' order by upper(a.resp_name)";
	}
	else if(dtl_grp_by_code.equals("DRL")){
		title_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.relationship.label","common_labels");

		sql_query = "select a.pract_reln_name description, a.pract_reln_id code, (select privilege_status from ca_appl_task_for_resp_reln b where b.pract_reln_id = a.pract_reln_id and 	b.appl_task_id=?)privilege_status, (select srl_no from ca_appl_task_for_resp_reln b where b.pract_reln_id = a.pract_reln_id and b.appl_task_id=?) srl_no, (select (case when privilege_status is not null then 'Y' else 'N' end) from ca_appl_task_for_resp_reln b where b.pract_reln_id = a.pract_reln_id and b.appl_task_id=?)valid,(select ACCESS_RIGTHS_APPL from ca_appl_task_for_resp_reln b where b.pract_reln_id = a.pract_reln_id and b.appl_task_id=? and rownum=1)ACCESS_RIGTHS_APPL from  ca_pract_reln a order by upper(a.pract_reln_name)";
	}
}// TS
else if(group_by.equals("RS") )
{
	title_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Task.label","common_labels");
	title_desc1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Function.label","common_labels");

	if(dtl_grp_by_code.equals("DT"))
	{
		title_desc1="";
        sql_query="select a.appl_task_desc description, a.appl_task_id code, (select privilege_status from ca_appl_task_for_resp_reln b where b.appl_task_id = a.appl_task_id and b.RESP_ID=? and rownum=1)privilege_status, (select srl_no from ca_appl_task_for_resp_reln b where b.appl_task_id = a.appl_task_id and b.resp_id =? and rownum=1) srl_no, (select (case when privilege_status is not null then 'Y' else 'N' end) from ca_appl_task_for_resp_reln b where b.appl_task_id = a.appl_task_id and b.resp_id = ? and rownum=1)valid,(select ACCESS_RIGTHS_APPL from ca_appl_task_for_resp_reln b where b.appl_task_id = a.appl_task_id and b.RESP_ID=? and rownum=1)ACCESS_RIGTHS_APPL from ca_appl_task a where a.splty_spec_yn = 'N' order by upper(a.appl_task_desc)";  
		
	}// DT
	else if(dtl_grp_by_code.equals("DFN"))
		{
		   title_desc1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Function.label","common_labels");

		   sql_query ="select nvl(a.OPTION_ID,'*NONE') function_id, nvl(a.SHORT_DESc,'NOT FUNC SPEC') function_name, c.APPL_TASK_ID code,c.APPL_TASK_DESC description,(select privilege_status from ca_appl_task_for_resp_reln b where b.appl_task_id = c.appl_task_id and b.resp_id=? and rownum=1)privilege_status,(select srl_no from ca_appl_task_for_resp_reln b where b.appl_task_id = c.appl_task_id and b.resp_id=? and rownum=1)srl_no,(select (case when privilege_status is not null then 'Y' else 'N' end) from ca_appl_task_for_resp_reln b where b.appl_task_id = c.appl_task_id and b.resp_id=? and rownum=1)valid,(select ACCESS_RIGTHS_APPL from ca_appl_task_for_resp_reln b where b.appl_task_id = c.appl_task_id and b.resp_id=? and rownum=1)ACCESS_RIGTHS_APPL from ca_option a,ca_appl_task c where a.option_id(+)= c.option_id order by function_name,c.APPL_TASK_DESC ";
		   
 
		}//DFN
}// RS
else if(group_by.equals("RL")){
	title_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Task.label","common_labels");
	title_desc1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Function.label","common_labels");
if(dtl_grp_by_code.equals("DT"))
	{
		title_desc1="";
	sql_query = "select a.appl_task_desc description, a.appl_task_id code, (select privilege_status from ca_appl_task_for_resp_reln b where b.appl_task_id = a.appl_task_id and b.pract_reln_id=?)privilege_status, (select srl_no from ca_appl_task_for_resp_reln b where b.appl_task_id = a.appl_task_id and b.pract_reln_id=?) srl_no, (select (case when privilege_status is not null then 'Y' else 'N' end) from ca_appl_task_for_resp_reln b where b.appl_task_id = a.appl_task_id and b.pract_reln_id = ?)valid,(select ACCESS_RIGTHS_APPL from ca_appl_task_for_resp_reln b where b.appl_task_id = a.appl_task_id and b.pract_reln_id=?) ACCESS_RIGTHS_APPL from ca_appl_task a where a.splty_spec_yn = 'N'  order by upper(a.appl_task_desc)";
	}
	else if(dtl_grp_by_code.equals("DFN"))
		{
		   title_desc1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Function.label","common_labels");

sql_query ="select nvl(a.OPTION_ID,'*NONE') function_id, nvl(a.SHORT_DESc,'NOT FUNC SPEC')function_name, c.APPL_TASK_ID code,c.APPL_TASK_DESC description,(select privilege_status from ca_appl_task_for_resp_reln b where b.appl_task_id = c.appl_task_id and b.pract_reln_id=? and rownum=1) privilege_status,(select srl_no from ca_appl_task_for_resp_reln b where b.appl_task_id  = c.appl_task_id and b.pract_reln_id=? and rownum=1)srl_no,(select (case when privilege_status is not null then 'Y' else 'N' end) from ca_appl_task_for_resp_reln b where b.appl_task_id = c.appl_task_id and  b.pract_reln_id=? and rownum=1)valid,(select ACCESS_RIGTHS_APPL from ca_appl_task_for_resp_reln b where b.appl_task_id = c.appl_task_id and b.pract_reln_id=? and rownum=1)ACCESS_RIGTHS_APPL from ca_option a,ca_appl_task c  where a.option_id(+)= c.option_id order by function_name,c.APPL_TASK_DESC ";
}

}else{
	title_desc = "";
}

try{

	if(dispMode.equals("")){
		respRelnRecSet.clearAll();
		pstmt = con.prepareStatement(sql_query);
		pstmt.setString(1,grp_by_code);
		pstmt.setString(2,grp_by_code);
		pstmt.setString(3,grp_by_code);
		pstmt.setString(4,grp_by_code);
		rs = pstmt.executeQuery();
		while(rs.next()){
			code				= rs.getString("code");
			desc				= rs.getString("description");
			privilege_status	= rs.getString("privilege_status");
			valid				= rs.getString("valid");
			srl_no				= rs.getString("srl_no");
			access_rigths_appl	= rs.getString("ACCESS_RIGTHS_APPL");//This line added by Channaveer B for for crf MO-CRF-33
	if((group_by.equals("RS") && dtl_grp_by_code.equals("DFN"))||(group_by.equals("RL") && dtl_grp_by_code.equals("DFN")))
			{
				function_id=rs.getString("function_id");
				function_name=rs.getString("function_name");
			}
			if(code == null || code.equals("null"))code="";
			if(desc == null || desc.equals("null"))desc="";
			if(privilege_status == null|| privilege_status.equals("null"))privilege_status="";
			if(valid == null || valid.equals("") || valid.equals("null"))valid="N";
			if(srl_no == null || srl_no.equals("") || srl_no.equals("null"))srl_no="";
			HashMap hMapRecs = new HashMap();
			hMapRecs.put("code"				, code);
			hMapRecs.put("desc"				, desc);
			hMapRecs.put("privilege_status"	, privilege_status);
			hMapRecs.put("associate"		, "N");
			hMapRecs.put("valid"			, valid);
			hMapRecs.put("srl_no"			, srl_no);
			hMapRecs.put("insUpd"			, "");
			hMapRecs.put("ACCESS_RIGTHS_APPL" , access_rigths_appl);/*This line added by Channaveer B for crf MO-CRF-33*/
		

	if((group_by.equals("RS") && dtl_grp_by_code.equals("DFN"))||(group_by.equals("RL") && dtl_grp_by_code.equals("DFN")))
			{
				hMapRecs.put("function_id",function_id);
				hMapRecs.put("function_name",function_name);
			}
		respRelnRecSet.putObject(hMapRecs);
		}

		row_count	=	respRelnRecSet.getSize();
		fm_disp	=	0;
		to_disp	=	(row_disp-1);
		if(to_disp > (row_count-1))
		to_disp=(row_count-1);

		from = ""+(start - 1);
		to   = ""+(end - 1);
		
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block10Bytes, _wl_block10);

	}// if dispmode
		else{
		int from_val	= (Integer.parseInt(from));
		int to_val		= (Integer.parseInt(to));
		if(dispMode.equals("Next")){
			dispMode	="Next";
			from		= ""+(start + row_disp);
			to			= ""+(end + row_disp);
			title_desc	= title_desc;
			
		}else if(dispMode.equals("Previous")){

			dispMode	="Previous";
			from		= ""+(start - row_disp);
			to			= ""+(end - row_disp);
			title_desc	= title_desc;
		}
		
		if(to_val > (row_count-1))
			to_val=(row_count-1);

		String valid_rec = "";
		for(int j=from_val; j<=to_val; j++){
			update_val = request.getParameter("select_yn"+j)==null?"":request.getParameter("select_yn"+j);
			access = request.getParameter("access_rights"+j)==null?"":request.getParameter("access_rights"+j);/*this line added by Channaveer B for crf MO-CRF-33*/
			HashMap hMapAlter = (java.util.HashMap)respRelnRecSet.getObject(j);
			valid_rec = (String)hMapAlter.get("valid");
			if(valid_rec.equals("Y")) insUpd = "U" ;
				else if(valid_rec.equals("N")) insUpd = "I";
			if(valid_rec.equals("Y")){
				hMapAlter.put("privilege_status", update_val);
				hMapAlter.put("associate"	  , "Y");
				hMapAlter.put("insUpd"		  , insUpd);
				hMapAlter.put("ACCESS_RIGTHS_APPL" , access);//this line added by Channaveer B for crf MO-CRF-33
				respRelnRecSet.setObject(j, hMapAlter);
			}else if(valid_rec.equals("N")){
				if(!update_val.equals("")) {
					hMapAlter.put("privilege_status", update_val);
					hMapAlter.put("associate"	  , "Y");
					hMapAlter.put("insUpd"		  , insUpd);
					hMapAlter.put("ACCESS_RIGTHS_APPL"  , access);/*this line added by Channaveer B for crf MO-CRF-33 */
					respRelnRecSet.setObject(j, hMapAlter);
				}else{
					if(update_val.equals("")){
						hMapAlter.put("privilege_status", update_val);
						hMapAlter.put("associate"	  , "N");
						hMapAlter.put("insUpd"		  , "");
						hMapAlter.put("ACCESS_RIGTHS_APPL" , access);/*this line added by Channaveer B for crf MO-CRF-33 */
						respRelnRecSet.setObject(j, hMapAlter);
					}
				}
			}
		}

		fm_disp = Integer.parseInt(from);
		to_disp	= Integer.parseInt(to);

		if(to_disp > (row_count-1))
		to_disp=(row_count-1);

		start	= Integer.parseInt(from);
		end     = Integer.parseInt(to);
	}

	putObjectInBean("respRelnRecSet",respRelnRecSet,session);

            _bw.write(_wl_block11Bytes, _wl_block11);

	if ( (!(start <= 1)) && (start < row_count)){
	
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
	
	}
	if ( !( (start+row_disp) >= row_count ) ){
	
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

	}

            _bw.write(_wl_block15Bytes, _wl_block15);
 if(title_desc1.equals(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Function.label","common_labels")))
	{
	
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(title_desc1));
            _bw.write(_wl_block17Bytes, _wl_block17);
 } 
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(title_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

//IN061903 start
//if((group_by.equals("TS")&& (grp_by_code.equals("AMEND_ORDER")|| grp_by_code.equals("CANCEL_ORDER") || grp_by_code.equals("HOLD") || grp_by_code.equals("DISCONTINUE")))|| group_by.equals("RS") || group_by.equals("RL")){
if((group_by.equals("TS")&& (grp_by_code.equals("AMEND_ORDER")|| grp_by_code.equals("CANCEL_ORDER") || grp_by_code.equals("HOLD") || grp_by_code.equals("DISCONTINUE") || grp_by_code.equals("NOTDONE")))|| group_by.equals("RS") || group_by.equals("RL")){
//IN061903 ends	

            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
}else{
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block1Bytes, _wl_block1);

	for(int i=fm_disp; i<=to_disp; i++){
		classValue		=	( (i%2)==0 )? "gridData" : "gridData";
		 hMapRecords   = (java.util.HashMap)respRelnRecSet.getObject(i);
		code				=	(String)	hMapRecords.get("code");
		//out.println("code"+code);
		desc				=	(String)	hMapRecords.get("desc");
		privilege_status	=	(String)	hMapRecords.get("privilege_status");
		associate			=	(String)	hMapRecords.get("associate");
		access			=	hMapRecords.get("ACCESS_RIGTHS_APPL")==null?"":(String)	hMapRecords.get("ACCESS_RIGTHS_APPL");/*this line added by Channaveer B for crf MO-CRF-33*/
		function_id=(String)hMapRecords.get("function_id");
		function_name=(String)hMapRecords.get("function_name");
		if(function_id == null || function_id.equals("")) function_id="";
		if(function_name == null || function_name.equals("")) function_name="";
		/*if(code.equals("BY_LOCATION"))
			{
				out.println("Priv Sts="+privilege_status);
				out.println("Valid="+valid);
			}*/
		 //boolean sts=false;
		if(prevVal.equals(function_name.trim()))
		{
           //sts=true;
		   function_name="&nbsp;";
		}
		else{
         prevVal=function_name;
		 //sts=false;
		}
		/*out.println("function_name="+function_name);
		out.println("prevVal="+prevVal);
		out.println("status="+sts);*/
		
		if(associate == null || associate.equals(""))associate="N";
		if(associate.equals("Y")) //checkValue = "checked"; else checkValue = "";
		if(privilege_status.equals("")||privilege_status.equals("null"))
			privilege_status_value = "0";
		else
			privilege_status_value = privilege_status;
		if(privilege_status.equals("A")){
			selectOption1 = "selected";
			selectOption2 = "";
		}else if(privilege_status.equals("X")){
			selectOption1 = "";
			selectOption2 = "selected";
		}else{
			selectOption1 = "";
			selectOption2 = "";
		}
		/*Below code added by Channaveer B for crf MO-CRF-33 */
		if(access.equals("ALL")){
			accessOption1="selected";
			accessOption2="";
			accessOption3="";
		}else if(access.equals("MO")){
            accessOption1="";
			accessOption2="selected";
			accessOption3="";
		}else if(access.equals("MS")){
			accessOption1="";
			accessOption2="";
			accessOption3="selected";
		}else
		{
			accessOption1="";
			accessOption2="";
			accessOption3="";			
		}
		/*ENDS HERE */
		
            _bw.write(_wl_block23Bytes, _wl_block23);

			if(dtl_grp_by_code.equals("DFN"))
			{
			  
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(function_name));
            _bw.write(_wl_block26Bytes, _wl_block26);

			}
			
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(code));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(((equals(""))?"&nbsp;":desc)));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(code));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(privilege_status_value));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(selectOption1));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(selectOption2));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
//if((group_by.equals("TS") && (grp_by_code.equals("AMEND_ORDER")|| grp_by_code.equals("CANCEL_ORDER") || grp_by_code.equals("HOLD") || grp_by_code.equals("DISCONTINUE")))  || ((group_by.equals("RS") || group_by.equals("RL")) && (code.equals("AMEND_ORDER")|| code.equals("CANCEL_ORDER") || code.equals("HOLD") || code.equals("DISCONTINUE")))){
			if((group_by.equals("TS") && (grp_by_code.equals("AMEND_ORDER")|| grp_by_code.equals("CANCEL_ORDER") || grp_by_code.equals("HOLD") || grp_by_code.equals("DISCONTINUE") || grp_by_code.equals("NOTDONE")))  || ((group_by.equals("RS") || group_by.equals("RL")) && (code.equals("AMEND_ORDER")|| code.equals("CANCEL_ORDER") || code.equals("HOLD") || code.equals("DISCONTINUE") || code.equals("NOTDONE")))){
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
if(!privilege_status.equals("A")){
            _bw.write(_wl_block46Bytes, _wl_block46);
}
            _bw.write(_wl_block47Bytes, _wl_block47);
if(privilege_status.equals("A")){
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(accessOption1));
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(accessOption2));
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(accessOption3));
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);
}else{
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);
}
            _bw.write(_wl_block54Bytes, _wl_block54);
}else if(group_by.equals("RS") || group_by.equals("RL")){
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block56Bytes, _wl_block56);
}
            _bw.write(_wl_block57Bytes, _wl_block57);

				
		if(rs!=null) rs.close();
		if(rs1!=null) rs1.close();
		if(pstmt!=null) pstmt.close();
		if(pstmt1!=null) pstmt1.close();
        
		}//for
	}
	catch(Exception ee)
	{
			ee.printStackTrace();
	}
}catch(Exception e)
{
		e.printStackTrace();
}
finally
{		
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
}	

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(dispMode));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(from));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(to));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(fm_disp));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(to_disp));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(group_by));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(grp_by_code));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(dtl_grp_by_code));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(amend_order));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(cancel_order));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(discontinue));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(hold));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(not_done));
            _bw.write(_wl_block72Bytes, _wl_block72);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.TaskForResponsibilityRelationship.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Applicable.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.AccessRestriction.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Applicable.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.notapplicable.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.all.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.SelfOrder.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.SelfSpltyOrders.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.notapplicable.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
