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

public final class __sterilizationcostaddmodify extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ess/jsp/SterilizationCostAddModify.jsp", 1709121882039L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t\t<title> </title>\n\t\t<meta name=\"Generator\" content=\"EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.\">\n\t\t<meta name=\"Author\" content=\"Sudha Krishnadasar\">\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eSS/js/SterilizationCost.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eSS/js/SsCommon.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\t</head>\n\n\t<body onMouseDown=\'CodeArrest();\'>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<form name=\"formSterilizationCost\" id=\"formSterilizationCost\"  >\n\t<table cellpadding=\'0\' cellspacing=\'0\' border=\'0\' width=\'90%\' align=\'center\'>\n\t<tr align=\'right\' width=\'10%\'>\n\t\t<td class=\'WHITE\'>\n\t\t\t<p align=\"right\">\n\t\t\t<a href=\"javascript:goPrev(\'select\');\" id=\"prev\"  style=\"visibility:hidden\" >";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</a>&nbsp;&nbsp;<a href=\"javascript:goNext(\'select\');\" id=\"next\" style=\"visibility:hidden\" >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</a>\n\t\t\t</p>\n\t\t</td>\n\t</tr>\n\t</table>\n\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<table cellpadding=\"0\" cellspacing=\"0\" border=\"1\" width=\"100%\" align=\"center\">\n\t\t<th>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n\t\t<th>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th><th>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t<tr>\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" >\n\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t<font color=#FF5400 style=\"font-weight:500\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</font>\n\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t<input type=\"hidden\" name=\"sterile_desc";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" id=\"sterile_desc";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"></input>\n\t\t\t<input type=\"hidden\" name=\"sterile_type";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" id=\"sterile_type";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"></input></td>\n\t\t\t\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" align=\"center\" width=\"10%\">\n\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\t\n\t\t<input type=\"hidden\"  align=\"center\" name=\"process";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" id=\"process";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\"></input>\n\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t<input type=\"checkbox\"  align=\"center\" name=\"process";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" onclick=\"assignValue(this);makeEnable(this,\'sterile_cost";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\')\"  ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="  ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" ></input>\n\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\t\n\t\t\n\t\t</td>\n\t\t<td class=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" align=\"center\" width=\"10%\" ><input type=\"text\" size=\'16\' maxlength=\'16\' ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="  name=\"sterile_cost";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\"  onKeyPress=\"return isValidNumber(this,event,";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =");\" maxLength=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' size=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'    class=\"NUMBER\" onBlur=\"checkDoubleFormat(this);\" ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="  ></input></td>\n\t\t<td class=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" align=\"center\" width=\"10%\" ><input type=\"checkbox\"  align=\"center\" name=\"delete_row";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" id=\"delete_row";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" onclick=\"assignValue1(this);\"   ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" ></input></td>\n\t\t</tr>\n\t\n\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t<script>alert(getMessage( \"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\" ));</script>\n\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n</table>\n\n\n\t\t<input type=\"hidden\" name=\"mode\" id=\"mode\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t\t<input type=\"hidden\" name=\"group_code\" id=\"group_code\"\t\tvalue=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n\t\t<input type=\"hidden\" name=\"start\" id=\"start\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n\t\t<input type=\"hidden\" name=\"count\" id=\"count\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t\t<input type=\"hidden\" name=\"displaySize\" id=\"displaySize\"\t\tvalue=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\t\n\t\t<input type=\"hidden\" name=\"totalRecords\" id=\"totalRecords\"\tvalue=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n\t\t<input type=\"hidden\" name=\"end\" id=\"end\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n\t\t<input type=\"hidden\" name=\"choosen_link\" id=\"choosen_link\"\tvalue=\"select\" >\n\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\"\t\tvalue=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n\t\t<input type=\"hidden\" name=\"function_id\" id=\"function_id\"\t\tvalue=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n\t\t<input type=\"hidden\" name=\"initString\" id=\"initString\"\t\tvalue=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n\t\t<input type=\"hidden\" name=\"SQL_SS_GROUP_LOOKUP\" id=\"SQL_SS_GROUP_LOOKUP\" value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n\t\t<input type=\"hidden\" name=\"locale\" id=\"locale\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n\n\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t<script>\n\tmaxRec\t\t\t= ";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 =" ;\n\tdisplaySize\t\t= ";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =" ;\n\tend\t\t\t\t= displaySize ;\n\tactiveLink();\n\t</script>\n";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 =" ;\n\tend\t\t\t\t= ";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 =" ;\n\tstart\t\t\t=";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 =";\n\tactiveLink();\n\t</script>\n";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t</form>\t\n</body>\n";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n</html>\n\n";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String codeDisabled				=		"";
	String mode						=		"";
	ArrayList result				=		new ArrayList();

	String bean_id					=		"sterilizationCostBean" ;
	String bean_name				=		"eSS.SterilizationCostBean";

	String group_code				=		request.getParameter( "group_code" ) ==null?"":request.getParameter( "group_code" );
	String sterile_type				=		request.getParameter( "sterile_type" ) ==null?"":request.getParameter( "sterile_type" );
	SterilizationCostBean bean		=		(SterilizationCostBean)getBeanObject( bean_id, bean_name, request ) ;
	int maxRec						=		0; 
	String dispMode					=		request.getParameter( "dispMode" ) ;
	boolean database_rec			=		false;
	String initString				=		"";
	if(dispMode==null) dispMode		=		"";
	int start						=		0;
	int end							=		0;
	int displaySize					=		0;
	int count						=		0;
	String classvalue				=		"";
	String classvalueChange			=		"";	

	String from						=		request.getParameter( "from" )==null?"":request.getParameter( "from" ) ;
	String to						=		request.getParameter( "to" )==null?"":request.getParameter( "to" ) ;
	String Cost						=		"";
	count							=		start;

	String deleteCheck				=		"";
	String deleteCheckVal			=		"N";
	String costDisable				=		"";
	String dbval					=		"";
	HashMap dataList				=		null;
try{
	/* Mandatory checks start */
	mode							=		request.getParameter( "mode" )==null?"":  request.getParameter( "mode" );
	
	if ( mode == null || mode.equals("") ) 
		return ;
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;

	/* Mandatory checks end */
	
	/* Initialize Function specific start */
	
	bean.clear() ;
	bean.setMode( mode ) ;
	bean.setGroup_code(group_code) ;
	bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));	
	/* Initialize Function specific end */

	if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {
		codeDisabled	= "disabled";
		if (null == group_code || sterile_type==null)
			return;		
	}
	
	displaySize = Integer.parseInt( (String) CommonRepository.getCommonKeyValue("QUERY_RESULT_SIZE"));
	
	
	result=bean.getDataList();
	
	maxRec=  result.size();
	displaySize =  Integer.parseInt( (String) SsRepository.getSsKeyValue("QUERY_RESULT"));


	if ( from == null || from =="" )
		start = 0 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null || to ==""){
		end = displaySize ;
	}
	else{
		end = Integer.parseInt( to ) ;	
	}
	
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

	if(result.size() > 0 ){
	
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

	
	count	= start;
	int chkCount = 0;
	initString = "";
	String str_service_code = "";
	String str_short_desc	= "";
	String str_process		= "";
	String eff_status		= "";

	while ( count < maxRec && count < end)
	{
			dataList = (HashMap)result.get(count);
			if ( count % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;

		eff_status		 = (String)dataList.get("EFF_STATUS");
		str_service_code = (String)dataList.get("STERILE_TYPE");
		str_short_desc	 = (String)dataList.get("SHORT_DESC");
		Cost	         = ((String)dataList.get("STERILE_COST")).equals("0")?"":((String)dataList.get("STERILE_COST"));
		str_process		 = (String)dataList.get("PROCESS");
		dbval		     = (String)dataList.get("DBVAL");

		String disp_effstatus	= "";
		String associate_yn		= "";
		String disabled			= "";
		
		if(str_process.equals("Y")){
			associate_yn		=	"checked";
			costDisable			=	"";
		}
		else
		{
			associate_yn		=	"";
			disabled			=	"";
			costDisable			=	"disabled";
			database_rec		=	false;
		}
		if(dbval.equals("Y")){
			database_rec		=	true;
			disabled			=	"disabled";
			deleteCheck			=	"";
		}
		else{
			database_rec		=	false;
			disabled			=	"";
			deleteCheck			=	"disabled";
		}
	
	if( chkCount==0 )
	{
	  initString=eff_status+"|"+str_process+"|"+str_service_code+"|"+str_short_desc+"|"+Cost+"|"+dbval;
	}
	else
	{
	  initString=initString+"~"+eff_status+"|"+str_process+"|"+str_service_code+"|"+str_short_desc+"|"+Cost+"|"+dbval;
	}

	
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block16Bytes, _wl_block16);

			if(database_rec){
			
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf( str_short_desc ));
            _bw.write(_wl_block18Bytes, _wl_block18);

			}else{
			
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf( str_short_desc ));
            _bw.write(_wl_block20Bytes, _wl_block20);

			}
			
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(count));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(count));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(str_short_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(count));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(count));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(str_service_code));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block27Bytes, _wl_block27);
 
		if(database_rec){
	
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(count));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(count));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(str_process));
            _bw.write(_wl_block30Bytes, _wl_block30);

		}else{
	
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(count));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(count));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(str_process));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(count));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(associate_yn));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block35Bytes, _wl_block35);

		}
	
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(classvalueChange));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(disp_effstatus));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(count));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(Cost));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(bean.getCurrencyFormat()));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(bean.getCurrencySize()));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bean.getCurrencySize()));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(costDisable));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(count));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(count));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(deleteCheckVal));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(deleteCheck));
            _bw.write(_wl_block47Bytes, _wl_block47);

		count++;
		chkCount++;
	}
	}
	else{
	
            _bw.write(_wl_block48Bytes, _wl_block48);

	
	}
	}
	catch(Exception e){
	// out.println(es);
	e.printStackTrace(); // COMMON-ICN-0185
	}

            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(group_code));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(start));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(count));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(displaySize));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(result.size()));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(end));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(bean.getFunctionId()));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(java.net.URLEncoder.encode(initString)));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf( bean.getSsRepositoryValue("SQL_SS_GROUP_LOOKUP")));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(locale ));
            _bw.write(_wl_block62Bytes, _wl_block62);

		if(dispMode.equals("")){

            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(maxRec));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(displaySize));
            _bw.write(_wl_block65Bytes, _wl_block65);

}
	else{
	
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(maxRec));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(displaySize));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(end));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(start));
            _bw.write(_wl_block68Bytes, _wl_block68);

	
	}

            _bw.write(_wl_block69Bytes, _wl_block69);
 putObjectInBean(bean_id,bean,request);
            _bw.write(_wl_block70Bytes, _wl_block70);
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSS.SterileType.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ss_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSS.SterileCost.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ss_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.delete.label", java.lang.String .class,"key"));
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
}
