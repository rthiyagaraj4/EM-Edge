package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eST.*;
import eST.Common.*;
import eCommon.Common.*;
import java.util.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.lang.*;
import eST.IssueReturnBean;
import java.util.HashMap;
import java.util.ArrayList;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __issuereturnheader extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/IssueReturnHeader.jsp", 1720593026924L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' ></link>\n\t\t<script language=\"JavaScript\" src=\"../../eST/js/StCommon.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eST/js/StDuoHeader.js\"></script>\n        <script language=\"JavaScript\" src=\"../../eST/js/IssueReturn.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\t</head>\n<body>\n<form name=\"formIssueReturnHeader\" id=\"formIssueReturnHeader\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" \n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n       ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" \n\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t\t<input type=\"hidden\" name=\"item_class_desc1\" id=\"item_class_desc1\"\t\tvalue=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t\t<input type=\"hidden\" name=\"item_class_code1\" id=\"item_class_code1\"\t\tvalue=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t\t<input type=\"hidden\" name=\"mode\" id=\"mode\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" >\n\t\t<input type=\"hidden\" name=\"records_to_delete\" id=\"records_to_delete\"\t\tvalue=\"\" >\n\t\t<input type=\"hidden\" name=\"finalize_allowed_yn\" id=\"finalize_allowed_yn\"\tvalue=\"N\">\n\t\t<input type=\"hidden\" name=\"finalized_yn\" id=\"finalized_yn\"\t\t\tvalue=\"N\">\n\t\t<input type=\"hidden\" name=\"ret_delete_yn\" id=\"ret_delete_yn\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t\t<input type=\"hidden\" name=\"trn_type\" id=\"trn_type\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"> \n        <input type=\"hidden\"  name=\"locale\" id=\"locale\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n        <input type=\"hidden\"  name=\"iss_ret_based_on\" id=\"iss_ret_based_on\"\t\tvalue=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"> <!-- Added by suresh.r on 23-01-2014 against AMS-CRF-0054 -->   \t\t\n<!--Added against GHL-CRF-0413 starts-->\n        <input type=\"hidden\"    name=\"site\" id=\"site\"\t value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n        <input type=\"hidden\"    name=\"barcode_applicable1\" id=\"barcode_applicable1\"\t\t\tvalue=\"\" >\n\t<input type=\"hidden\"    name=\"defaultqty_appl1\" id=\"defaultqty_appl1\"\t\t\t\tvalue=\"\" >\n\t<input type=\"hidden\"\tname=\"defaultqty_value1\" id=\"defaultqty_value1\"\t\t\tvalue=\"\">\n\t<input type=\"hidden\"    name=\"editqty_appl1\" id=\"editqty_appl1\"\t\t\t\tvalue=\"\" >\n<!--Added against GHL-CRF-0413 ends-->\n\t\t<table border=\'0\' cellpadding=0 cellspacing=0  width=\'100%\' align=center>\n\t\t<tr>\n\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t<td class=\"label\" align=\"left\" id=\"docno_ret_based\">Issue Doc.Type &nbsp;&nbsp;&nbsp;\n\t\t\t\t<select name=\"issue_doc_type\" id=\"issue_doc_type\" onchange=\"LoadDocNo(this);\" onkeydown=\"return isNumberKey(event);\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t    </select>\n\t\t\t&nbsp;&nbsp;&nbsp;Issue Doc.No&nbsp;&nbsp;&nbsp;\n\t\t\t<!-- Inc# 48543\tComented by Sakti against HSA-CRF-0171 to remove disabled to issue_doc_no_search button Inc# 48543\n\t\t\t<input type=text name=\"issue_doc_no\" id=\"issue_doc_no\" size=8 maxlength=8 readonly><input type=button name=\"issue_doc_no_search\" id=\"issue_doc_no_search\" class=\"button\" onClick=\"IssueDocSearch(issue_doc_type);\"  value=\'?\'disabled>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="  -->\n\t\t\t<input type=text name=\"issue_doc_no\" id=\"issue_doc_no\" size=8 maxlength=8 readonly onkeydown=\"return isNumberKey(event);\"><input type=button name=\"issue_doc_no_search\" id=\"issue_doc_no_search\" class=\"button\" onClick=\"IssueDocSearch(issue_doc_type);\"  value=\'?\' onkeydown=\"return isNumberKey(event);\">";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\n\t\t\t</TD>\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t<td class=\"label\" id=\"docno_ret_based\">Issue Doc.Type &nbsp;&nbsp;&nbsp;\n\t\t\t\t<select name=\"issue_doc_type\" id=\"issue_doc_type\" disabled>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t    </select>\n\t\t\t&nbsp;&nbsp;&nbsp;Issue Doc.No&nbsp;&nbsp;&nbsp;\n\t\t\t\t<input type=text name=\"issue_doc_no\" id=\"issue_doc_no\" size=8 maxlength=8 readonly value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" onkeydown=\"return isNumberKey(event);\"><input type=button name=\"issue_doc_no_search\" id=\"issue_doc_no_search\" class=\"button\" value=\'?\' disabled>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t</TD>\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\n\t\t\t<td class=\'fields\'><input type=button name=\"preview\" id=\"preview\" value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' class=button style=\'width:53\' style=\'height:14pt\'  onclick=\"previewDetails();\" ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" onkeydown=\"return isNumberKey(event);\"></td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\"label\" colspan=3>&nbsp;</td>\n\t\t</tr>\n\t\t</table>\n</form>\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n</body>\n</html>\n<!-- Added by suresh.r on 23-01-2014 against AMS-CRF-0054 beg-->\n<script type=\"text/javascript\">\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\tdocument.getElementById(\"docno_ret_based\").style.visibility=\"visible\";\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\tdocument.getElementById(\"docno_ret_based\").style.visibility=\"hidden\";\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\ncallBarCodeApplicable(\'RET\',\'formIssueReturnHeader\',\'issueReturnBean\',\'eST.IssueReturnBean\');//Added against GHL-CRF-0413 \n</script>\n<!-- Added by suresh.r on 23-01-2014 against AMS-CRF-054 end-->\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );
	
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
-------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name			INC Number       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------------------------
27/02/2014				42063			        Suresh R						27/02/2014           Suresh R       AMS-CRF-0054(Added Item Based IssueReturn)

27/10/2014				HSA-CRF-0171			Sakti Sankar		48543											In Issue Return,Remove the validation 
																													of Issue Doc.Type.Users just need to 
																													find the Issue Doc No. Once user select item 
																													to be returned in the list, system should 
																													auto default the value of Issue Doc. Type
--------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
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

			request.setCharacterEncoding("UTF-8");
			String locale				=		 (String)session.getAttribute("LOCALE");
		
			String sStyle				=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

try {	
		String mode						=		 request.getParameter("mode");
		String	item_class_desc			=		(request.getParameter( "item_class_desc" )!=null ? (request.getParameter("item_class_desc").trim()):"" );
		String	item_class_code			=		(request.getParameter( "item_class_code" )!=null ? (request.getParameter("item_class_code").trim()):"" );

		if(item_class_desc==null)
		{
			item_class_desc				=		"";
		}
		String trn_type					=		"RET";
		String bean_id					=		"issueReturnBean";
		String bean_name				=		"eST.IssueReturnBean";
		String sql_from_store			=		"SQL_ST_ISSUE_RET_FROM_STORE";
		String sql_to_store				=		"SQL_ST_ISSUE_RET_TO_STORE";
		String Modal_Window_Open		=		"Yes";
		String preview_disabled			=		 "disabled" ;
		eST.IssueReturnBean bean		=		(eST.IssueReturnBean) getBeanObject( bean_id , bean_name,request );
		bean.setLanguageId(locale);
		bean.setItem_class_code(item_class_code);
		String iss_ret_based_on=bean.getIssueRetBasedOn(); //Added by suresh.r on 23-01-2014 against AMS-CRF-0054
		if (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
			Modal_Window_Open			=		"No";
			preview_disabled			=		"";
		}
String ret_delete_yn="";
		//Added for GHL-CRF-0413 starts
		Connection con				= null;
		con						= ConnectionManager.getConnection(request);
		boolean site_main = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_BARCODE_INT_EXT");
		bean.setSite_spec_yn(site_main);
		//Added for GHL-CRF-0413 ends


            _bw.write(_wl_block9Bytes, _wl_block9);
            {java.lang.String __page ="../../eST/jsp/StDuoHeader.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("mode"), weblogic.utils.StringUtils.valueOf(mode
                        )},{ weblogic.utils.StringUtils.valueOf("doc_type_code"), weblogic.utils.StringUtils.valueOf(bean.checkForNull(bean.getDoc_type_code())
                        )},{ weblogic.utils.StringUtils.valueOf("doc_no"), weblogic.utils.StringUtils.valueOf(bean.checkForNull(bean.getDoc_no())
                        )},{ weblogic.utils.StringUtils.valueOf("doc_date"), weblogic.utils.StringUtils.valueOf(bean.checkForNull(bean.getDoc_date())
                        )},{ weblogic.utils.StringUtils.valueOf("doc_ref"), weblogic.utils.StringUtils.valueOf(bean.checkForNull(bean.getDoc_ref())
                        )},{ weblogic.utils.StringUtils.valueOf("from_store_code"), weblogic.utils.StringUtils.valueOf(bean.checkForNull(bean.getFrom_store_code())
                        )},{ weblogic.utils.StringUtils.valueOf("to_store_code"), weblogic.utils.StringUtils.valueOf(bean.checkForNull(bean.getTo_store_code())
                        )},{ weblogic.utils.StringUtils.valueOf("item_class_code"), weblogic.utils.StringUtils.valueOf(bean.checkForNull(bean.getItem_class_code())
                        )},{ weblogic.utils.StringUtils.valueOf("trn_type"), weblogic.utils.StringUtils.valueOf(trn_type
                        )},{ weblogic.utils.StringUtils.valueOf("sql_from_store"), weblogic.utils.StringUtils.valueOf(sql_from_store
                        )},{ weblogic.utils.StringUtils.valueOf("sql_to_store"), weblogic.utils.StringUtils.valueOf(sql_to_store
                        )},{ weblogic.utils.StringUtils.valueOf("Modal_Window_Open"), weblogic.utils.StringUtils.valueOf(Modal_Window_Open
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block11Bytes, _wl_block11);
            _bw.write(_wl_block12Bytes, _wl_block12);



ret_delete_yn =		bean.checkForNull((String)bean.fetchRecord("select  ret_delete_yn  from  ST_USER_ACCESS_FOR_STORE where store_code=? and user_id=?",new String[]{bean.checkForNull(bean.getFrom_store_code()),(String) session.getValue( "login_user" )}).get("RET_DELETE_YN"),"N");

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(item_class_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(item_class_code));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(ret_delete_yn));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(trn_type));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(iss_ret_based_on));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(site_main));
            _bw.write(_wl_block23Bytes, _wl_block23);
if (!mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {

            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(bean.getIssueDocType()));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(bean.getImage("M")));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(bean.getImage("M")));
            _bw.write(_wl_block27Bytes, _wl_block27);
}else{
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bean.getIssueDocTypeList()));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(bean.getIssueDocNo()));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(bean.getImage("M")));
            _bw.write(_wl_block31Bytes, _wl_block31);
}
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(preview_disabled));
            _bw.write(_wl_block34Bytes, _wl_block34);

	putObjectInBean(bean_id,bean,request);

            _bw.write(_wl_block35Bytes, _wl_block35);
if(iss_ret_based_on.equals("D")){ 
            _bw.write(_wl_block36Bytes, _wl_block36);
}else{ 
            _bw.write(_wl_block37Bytes, _wl_block37);
} 
            _bw.write(_wl_block38Bytes, _wl_block38);

//Added for GHL-CRF-0413 starts
	if(con != null)
		ConnectionManager.returnConnection(con,request);
//Added for GHL-CRF-0413 ends

            _bw.write(_wl_block2Bytes, _wl_block2);

}
catch (Exception ex) {
	ex.printStackTrace();
}

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Preview.label", java.lang.String .class,"key"));
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
}
