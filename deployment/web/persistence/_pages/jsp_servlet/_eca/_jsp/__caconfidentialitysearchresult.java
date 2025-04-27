package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eCommon.Common.*;
import java.net.URLEncoder;
import eCA.*;
import eOR.Common.*;
import eOR.*;
import java.util.*;
import com.ehis.util.*;
import eCommon.Common.*;
import java.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __caconfidentialitysearchresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CAConfidentialitySearchResult.jsp", 1709115501810L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonBean.jsp", 1710760607421L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \n--------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        Description\n--------------------------------------------------------------------------------------------------------\n?             100            ?           created\n12/12/2013\t  IN042552\t\t Karthi L\t To maintain Patient\'s event confidentiality at Practitioner, Speciality and Responsibility level (Bru-HIMS-CRF-391)\n--------------------------------------------------------------------------------------------------------\n-->\n";
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n    <head>\n        <title></title>\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n        <script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/common.js\"></script>\n        <script language=\"Javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n        <script language=\"Javascript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n        <script language=\'javascript\' src=\'../../eCA/js/ConfidentialitySetUpHeader.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body onKeyDown = \'lockKey()\' OnMouseDown=\'CodeArrest()\' >\n<form name=\'confidentiality_search_result\' id=\'confidentiality_search_result\'  method=\'post\' >\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t        <table cellpadding=0 cellspacing=0 width=\"100%\" align=\"center\">\n\t            <tr>\n\t\t            <td width=\"20%\" class=\"white\">&nbsp;</td>  \n\t\t            <td width=\"30%\" class=\"white\">&nbsp;</td>    \n\t\t            <td width=\"30%\" class=\"white\">&nbsp;</td>    \n\t\t            <td width=\"20%\" class=\"white\">&nbsp;</td> \n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t         \t</tr>\n\t        </table>\n\t\n\t        <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" align=\"center\" id=\"ResultTab\">\n\t\t\t\t\n\t\t\t<th width = \'22%\'> ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th> ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" <th width = \'38%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th> <th width = \'25%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" <th width = \'30%\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th><th width = \'19%\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</th> <th width = \'16%\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</th>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" <th width = \'50%\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="<th width = \'15%\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</th>\n\t        \t\t\n\t        \t\t<input type=\"hidden\" name =\"confidnt_type\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t\t\t\t\t<input type=\"hidden\" name = \"selectedDataCount\" value=\"\">\n\t        \t\t<input type=\"hidden\" name =\"callingFromSearchResult\" value=\"search_result\">\n\t        \t\t<input type=\"hidden\" name =\"conf_hashmap_data\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t        \t\t\n\t        ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t            <tr>  \n\t        ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\t\t\t\t<input type=\"hidden\" name = \"result_data_code_";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"  value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t        \t\t\t\t\n\t\t\t\t\t\t\t\t<td name = \'reslut_data_desc_";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'  class=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" >";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" </td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" \n\t\t                        <td style = \'color:black;font-size:9pt;font-weight:normal;text-align:center;border-bottom:1px;border-style:solid;border-color:#EEEEEE;border-top:0px;border-left:0px;border-right:0px;\' >\n\t\t                         \t<select name=\'view_list_data_";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' id=\'view_list_data_";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'  onchange = \'changeSelectedData(this,";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =")\'>\n\t\t\t\t\t\t\t\t\t\t<option value = \"M\" ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" >";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</option>\n\t\t\t\t\t\t\t\t\t\t<option value = \"Z\" ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</option>\n\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t</td>\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t\t\t<td style = \'color:black;font-size:9pt;font-weight:normal;text-align:center;border-bottom:1px;border-style:solid;border-color:#EEEEEE;border-top:0px;border-left:0px;border-right:0px;\'  >\n\t\t                         \t<select name=\'based_on_data_";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' id=\'based_on_data_";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =")\'>\n\t\t\t\t\t\t\t\t\t\t<option value = \"E\" ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</option>\n\t\t\t\t\t\t\t\t\t\t<option value = \"A\" ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</option>\n\t\t\t\t\t\t\t\t\t\t<option value = \"B\" ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</option>\n\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td   name=\'view_by_data_";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' style = \'color:black;font-size:9pt;font-weight:normal;text-align:center;border-bottom:1px;border-style:solid;border-color:#EEEEEE;border-top:0px;border-left:0px;border-right:0px;\' >\n\t\t                         \t<select name=\'view_by_data_";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' id=\'view_by_data_";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' onchange = \'changeSelectedData(this,";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =")\' >\n\t\t\t\t\t\t\t\t\t\t<option value = \"P\" ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</option>\n\t\t\t\t\t\t\t\t\t\t<option value = \"S\" ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</option>\n\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t</td> \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t                        <td style = \'color:black;font-size:9pt;font-weight:normal;text-align:center;border-bottom:1px;border-style:solid;border-color:#EEEEEE;border-top:0px;border-left:0px;border-right:0px;\'  >\n\t                        \t<input type=\'checkbox\' name=\'ctrlChkBox";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' id=\'ctrlChkBox";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' id = =\'ctrlChkBox";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'  onClick=\"ctrlChkBox(this,";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =")\" ";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="></td>\n\t                   \n\t        ";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =" \n\t        \t\t\t\t\n\t        \t\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t                       \t\t<td class=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" name = \'result_data_";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' >";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</td> \n\t        ";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 =" \n\t                    ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\t\t<input type=\"hidden\" name =\"hd_";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n\t\t\t        </tr>\n\t        ";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t            </table>\n\t       ";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t            <script>\n\t            \talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));\n\t            </script>\n\t           \n\t    ";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\n </form>\n</body>\n</html>\n    \n    \n\n";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
    String callFrom        = CommonBean.checkForNull(request.getParameter( "callFrom" ) ) ;

            _bw.write(_wl_block6Bytes, _wl_block6);

			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

    try{
		//Search Criteria's from Query Criteria page
		String sqlData         	= CommonBean.checkForNull(request.getParameter( "sqlData" ) );
		String searchCriteria  	= CommonBean.checkForNull(request.getParameter( "sc" ) ) ;
		String linkFields      	= CommonBean.checkForNull(request.getParameter( "linkFields" ) ) ;
		String displayOrder    	= CommonBean.checkForNull(request.getParameter( "displayOrder" ) ) ;
		String searchCode	   	= request.getParameter("search_code")==null?"":request.getParameter("search_code");
		String confidnt_type	= request.getParameter("confidnt_type")==null?"":request.getParameter("confidnt_type");
		String radioval			= request.getParameter("radioval")==null?"":request.getParameter("radioval");
		String l_hist_rec_type 	= request.getParameter("p_hist_rec_type")==null?"":request.getParameter("p_hist_rec_type");
		String l_search_by 		= request.getParameter("p_search_by")==null?"":request.getParameter("p_search_by");
		String l_search_value	= request.getParameter("p_search_txt")==null?"":request.getParameter("p_search_txt");
		String l_filter_		= request.getParameter("p_filter_")==null?"":request.getParameter("p_filter_");	
		if(searchCode == null || searchCode.equals("")){
			searchCode = confidnt_type;
		}
		
		String callingFromSearchResult	   	= request.getParameter("callingFromSearchResult")==null?"":request.getParameter("callingFromSearchResult");
		
		String l_bean_id		= "Ca_confidentialitySetUpBean";
		String l_bean_name		= "eCA.CAConfidentialitySetUpBean";
		String based_on_title =  null;
		String code_desc	= null;
		String view_list_title	= null;
		String view_by_title		= null;
		String desc_desc	= null;
		String from= "", to ="";
		int row_disp=14;
		String confdntKey = "";
		CAConfidentialitySetUpBean beanObj = (CAConfidentialitySetUpBean)getBeanObject(l_bean_id, l_bean_name, request);
		
		HashMap confdntHashMap = beanObj.getConfidentialityMapData();
		
		int selectedDataCount = 0;
		String selectedRecordCount = "";
		
		if(confdntHashMap != null){
			selectedDataCount = confdntHashMap.size();
			selectedRecordCount = String.valueOf(selectedDataCount);
		}
		
		
		if(searchCode.equals("P")){
			//code_desc	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
			code_desc	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
			desc_desc	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
			view_list_title	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ViewList.label","ca_labels");
		}
		else if(searchCode.equals("S")){
			//code_desc	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Specialty.label","common_labels");
			code_desc	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
			desc_desc	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
			based_on_title	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.basedon.label","ca_labels");
			view_by_title	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ViewBy.label","ca_labels");
		}
		else if(searchCode.equals("R")){
			//code_desc	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.responsibility.label","common_labels");
			code_desc	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
			desc_desc	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
			view_list_title	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ViewList.label","ca_labels");
		}
		else {
			code_desc	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
			desc_desc	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
		}
		
		String select_code	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Select.label","common_labels");
		Enumeration paramnames = request.getParameterNames() ;

		int count = 0;
		String str = "";
		while( paramnames.hasMoreElements() ) {
			str = (String)paramnames.nextElement() ;
			if( str.equals( "from" ) || str.equals( "to" ) || str.equals( "searched" ) || str.equals( "sc" ) || str.equals( "linkFields" ) || str.equals( "displayOrder" ) || str.equals( "callFrom" ) )
				continue;
			count ++;
		}
		boolean searched    = request.getParameter( "searched" ) == null ? false : true  ;
		
		int start = 0 ;
		int end = 0 ;
		int fm_disp=0, to_disp=0;
		int start_int;
		int to_int;

		from			=	request.getParameter( "from" ) ;
		to				=	request.getParameter( "to" ) ;

		if ( from == null || from=="null" || from.equals("null") )
			start = 1 ;
		else
			start = Integer.parseInt( from ) ;

		if ( to == null || to =="null" || to.equals("null") )
			end = row_disp;//7 ;
		else
			end = Integer.parseInt( to ) ;
		
		String classvalue           = "" ;
	    HashMap sqlMap = new HashMap();
	    //include all the common parameters.
	    sqlMap.put( "sqlData", sqlData );
	    //Function Parameters
	    HashMap funcMap = new HashMap();
	    //The fields are going to be display
	    ArrayList displayFields = new ArrayList();

	    if( displayOrder.equals("CODE_DESC") ) {
	        displayFields.add( "code" );
	        displayFields.add( "description" );
	    } else {
	        displayFields.add( "description" );
	        displayFields.add( "code" );
	    }
	    ArrayList chkFields = new ArrayList();
	  
		String val_param1 = "";
		String val_param = "";
		
		if(radioval.equals("C"))
		{	
			val_param1 = "%";
			if(l_search_by.equals("S"))
			{
				val_param = l_search_value + "%";
			}
			else if(l_search_by.equals("C")){
				val_param = "%"+l_search_value+"%";
			}
			else if(l_search_by.equals("E")){
				val_param = "%"+l_search_value;
			}
		}	
		else if(radioval.equals("D"))
		{	
			val_param = "%";
			if(l_search_by.equals("S"))
			{
				val_param1 = l_search_value + "%";
			}
			else if(l_search_by.equals("C")){
				val_param1 = "%"+l_search_value+"%";
			}
			else if(l_search_by.equals("E")){
				val_param1 = "%"+l_search_value;
			}
		}
		
		chkFields.add(val_param);
		chkFields.add(val_param1);

		/*
		if(l_hist_rec_type.equals("LBIN") && !l_filter_.equals("E"))
		{
			chkFields.add(val_param);
			chkFields.add(val_param1);
		}
		*/
		// Adding function related array list into the HashMap
	    funcMap.put( "displayFields", displayFields );
	    funcMap.put( "chkFields", chkFields );
	    funcMap.put( "searchCriteria", searchCriteria );
		
		//Calling the Result from Common Adaptor as a arraylist.

		ArrayList result = (ArrayList) beanObj.getQueryResultPage(pageContext,sqlMap, funcMap, request, true,Integer.parseInt( (String)CommonRepository.getCommonKeyValue("QUERY_RESULT_SIZE") ) );
	    
		if( (result.size()>=2) && ( !( ((String) result.get(0)).equals("0")) )){

            _bw.write(_wl_block9Bytes, _wl_block9);

					// For display the previous/next link
					out.println(result.get(1));

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(code_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
 if(searchCode.equals("P") || searchCode.equals("R")) {
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(desc_desc));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(view_list_title));
            _bw.write(_wl_block11Bytes, _wl_block11);
}else if(searchCode.equals("S")) {
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(desc_desc));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(based_on_title));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(view_by_title));
            _bw.write(_wl_block17Bytes, _wl_block17);
} else { 
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf( desc_desc ));
            _bw.write(_wl_block11Bytes, _wl_block11);
 } 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(select_code ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(searchCode));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(confdntHashMap));
            _bw.write(_wl_block22Bytes, _wl_block22);

	           	 	//Retriving the records from result arraylist
	            	ArrayList records=new ArrayList();
					String link_columns = null;
					ArrayList privilegeList = null;
					Object objectList  = null;
					String retval="";
					String priviliege_type1 = "";
					String priviliege_type2 = "";
					String priviliege_type3 = "";
					String priviliege_type4 = "";
					String priviliege_type5 = "";
					String priviliege_type6 = "";
					String priviliege_type7 = "";
					String priviliege_type8 = "";
					String checkBoxStatus	= "";

	            	for(int recCount=2; recCount<result.size(); recCount++) {
		                if ( recCount % 2 == 0 )
		                    classvalue = "gridData" ;
		                else
		                    classvalue = "gridData" ;
	        
            _bw.write(_wl_block23Bytes, _wl_block23);

					link_columns = linkFields ;
					records=(ArrayList) result.get( recCount );
					retval="";
					priviliege_type1 = "";
					priviliege_type2 = "";
					priviliege_type3 = "";
					priviliege_type4 = "";
					priviliege_type5 = "";
					priviliege_type6 = "";
					priviliege_type7 = "";
					priviliege_type8 = "";
					checkBoxStatus	= "";
	    			
	                for(int colCount=0; colCount<records.size(); colCount++){
	                    if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
	                    	confdntKey = (String)records.get( colCount -1);
	                    	privilegeList = new ArrayList();
	                    	if(confdntHashMap != null){ 
	                    		if(confdntHashMap.containsKey(confdntKey)) {
	                    			objectList = (Object)confdntHashMap.get(confdntKey);
	                    			privilegeList = (ArrayList)objectList;
	                    			for(int p=0; p<privilegeList.size();p++ ){
	                    				if(privilegeList.get(p).equals("M")){
	                    					priviliege_type1 = "SELECTED";	
	                    				} else if(privilegeList.get(p).equals("Z")){
	                    					priviliege_type2 = "SELECTED";	
	                    				} else if(privilegeList.get(p).equals("E")){
	                    					priviliege_type3 = "SELECTED";	
	                    				} else if(privilegeList.get(p).equals("A")){
	                    					priviliege_type4 = "SELECTED";	
	                    				} else if(privilegeList.get(p).equals("B") || privilegeList.get(p).equals("LB")){
	                    					priviliege_type5 = "SELECTED";	
	                    				} else if(privilegeList.get(p).equals("P")){
	                    					priviliege_type6 = "SELECTED";	
	                    				} else if(privilegeList.get(p).equals("S")){
	                    					priviliege_type7 = "SELECTED";	
	                    				} else if(privilegeList.get(p).equals("B") || privilegeList.get(p).equals("BB")){
	                    					priviliege_type8 = "SELECTED";	
	                    				}
	                    			}
	                    			checkBoxStatus = "checked";
	                    		}
	                    	}
	        
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(start));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf((String)records.get( colCount -1)));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(start));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf((String)records.get( colCount )));
            _bw.write(_wl_block29Bytes, _wl_block29);
 if(searchCode.equals("P") || searchCode.equals("R")) {
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(start));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(start));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(start ));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(priviliege_type1));
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(priviliege_type2));
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
} else if(searchCode.equals("S")) {
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(start));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(start));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(start ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(priviliege_type3));
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(priviliege_type4));
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(priviliege_type5));
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(start));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(start));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(start ));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(priviliege_type6));
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(priviliege_type7));
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(priviliege_type8));
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);
 } else {
            _bw.write(_wl_block49Bytes, _wl_block49);
 } 
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(start));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(start));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(start));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(start ));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf( checkBoxStatus  ));
            _bw.write(_wl_block55Bytes, _wl_block55);
  		
	        			}else{  
            _bw.write(_wl_block56Bytes, _wl_block56);
 //if(searchCode.equals("E")) {
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(start));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf((String)records.get( colCount )));
            _bw.write(_wl_block60Bytes, _wl_block60);
				//} 
	                    } 
	                    
            _bw.write(_wl_block61Bytes, _wl_block61);

	    				retval=retval+"~"+(String)records.get( colCount );
	                    
	                } start++;
	        
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(retval));
            _bw.write(_wl_block64Bytes, _wl_block64);
		
	            }
	        
            _bw.write(_wl_block65Bytes, _wl_block65);

	            out.flush();
	        } else {	
	        
            _bw.write(_wl_block66Bytes, _wl_block66);

	    }           
	    out.println(beanObj.setForm ( request ,"CAConfidentialitySearchResult.jsp", searched) );	
	    sqlMap.clear();
		funcMap.clear();
		displayFields.clear();
		chkFields.clear();
		result.clear();
  
} catch(Exception e) {
  //  out.print("Exception @ Result JSP :"+e.toString());//COMMON-ICN-0181
	System.out.println("CAConfidentialitySearchResult.jsp,341,message=>"+e.getMessage());
	e.printStackTrace();
}


            _bw.write(_wl_block67Bytes, _wl_block67);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.SelfRelated.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.AllPatients.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounter.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.authorizedorordered.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Both.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.primaryspeciality.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.secondaryspeciality.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Both.label", java.lang.String .class,"key"));
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
}
