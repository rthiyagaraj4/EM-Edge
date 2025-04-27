package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eST.RequestStatusBean;
import eST.AuthorizeAtIssueStoreBean;
import webbeans.eCommon.*;
import java.sql.*;
import java.lang.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.text.NumberFormat;
import eCommon.Common.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __requeststatuslist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/RequestStatusList.jsp", 1709122158026L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonBean.jsp", 1710760607421L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="<!--added for ML-MMOH-SCF-1013  -->\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<html>\n\t<head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' type=\'text/css\' ></link>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eST/js/StCommon.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eST/js/RequestStatus.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t<title>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</title>\n\t</head>\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t<body >\n\t<form name=\'formRequestStatusList\' id=\'formRequestStatusList\'>\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t<table cellpadding=0 cellspacing=0 width=\"100%\" align=\"center\">\n\t\t\t<tr>\n\t\t\t\t<td width=\"80%\" class=\"white\">&nbsp;</td>\n\t\t\t\t<td width=\"20%\" class=\"white\">&nbsp;\n\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" id=\'tb1\'>\n\t\t\t\t<tr>\n\t\t\t\t    <th width=\'135\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="/";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</th> \n\t\t\t\t\t<th width=\'10%\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</th>\n\t\t\t\t\t<th width=\'25%\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</th>\n\t\t\t\t\t<th width=\'10%\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</th>\n\t\t\t\t\t<th width=\'5%\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</th>\n\t\t\t\t\t<th width=\'125\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" Qty</th>\n\t\t\t\t\t<th width=\'125\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" Qty</th>\n\t\t\t\t\t<!--<th width=\'125\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</th> -->\n\t\t\t\t\t<th width=\'125\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</th>\n\t\t\t\t\t<!-- //Added by rabbani #inc no:45231 on 28-NOV-2013 -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t<th>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</th>\n\t\t\t\t\t<th>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</th>\n\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t<th width=\'25%\'>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</th>\n\t\t\t\t</tr>\t\t\n\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t<tr >\n\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t  ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t  <td class=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" align=\"left\" ><font size=1>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</font></td>\n \t\t\t\t\t\t \n \t\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t  <td class=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</font></td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t <td class=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</font></td>\n\t\t\t\t\t\t \n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" align=\"left\" style=\'WORD-BREAK:BREAK-ALL;\'><font size=1>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</font></td>\n\t\t\t\t\t\t <td class=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</font></td>\n\t\t\t\t\t\t ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =" <!-- commented for ml-mmoh-scf-0979 -->\n\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" align=\"right\"><font size=1>";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</font></td><!-- added for ml-mmoh-scf-0979 -->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</font></td>\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" >";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t<!-- //Added by rabbani #inc no:45231 on 28-NOV-2013 -->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t\t\t<td class=\"NODISPLAY\"><input type=\"hidden\">&nbsp;</td>\n\t\t\t\t\t\t\t<td class=\"NODISPLAY\"><input type=\"hidden\">&nbsp;</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" ><font size=1>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</font></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="<!-- MO-CRF-20174 END  -->\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t</tr>\n\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t</table>\n\n\n\t\t\n\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t<script>\n\t\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));\n\t\t\t\t//document.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\t//history.go(-1);\n\t\t\t\twindow.close();\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t</form>\n\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n</body>\n</html>\n\t\n\n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );
	
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
 ------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
08/05/2018		IN067386			Shazana 										  	ML-MMOH-SCF-0979 - Conversion factor live issue 
22/05/2018		67677				Shazana												ML-MMOH-SCF-1003 
10/07/2018		IN067830			Shazana												ML-MMOH-SCF-1013
19/06/2019              70724                           B Haribabu                                                               NMC-JD-SCF-0016
-------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block3Bytes, _wl_block3);
            eCommon.Common.CommonBean CommonBean= null;{
                CommonBean=(eCommon.Common.CommonBean)pageContext.getAttribute("CommonBean");
                if(CommonBean==null){
                    CommonBean=new eCommon.Common.CommonBean();
                    pageContext.setAttribute("CommonBean",CommonBean);

                }
            }
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);

    CommonBean.setProperties( (Properties) session.getValue( "jdbc" ) ) ;
	CommonBean.setLoginById( (String) session.getValue( "login_user" ) ) ;
	CommonBean.setLoginAtWsNo( CommonBean.getProperties().getProperty( "client_ip_address" ) ) ;
	CommonBean.setLoginFacilityId( (String) session.getValue( "facility_id" ) ) ;

            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block5Bytes, _wl_block5);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);

		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

	try{
		String doc_type_code				=		request.getParameter("doc_type_code")==null?"":request.getParameter( "doc_type_code" ) ;
		String doc_no						=		request.getParameter("doc_no")==null?"":request.getParameter( "doc_no" ) ;
		boolean searched					=		(request.getParameter("searched") == null) ?false:true;
		String classvalue					=		"";
		RequestStatusBean bean				=		(RequestStatusBean) getBeanObject("RequestStatusBean","eST.RequestStatusBean", request);  
		AuthorizeAtIssueStoreBean bean_id				=		(AuthorizeAtIssueStoreBean) getBeanObject("AuthorizeAtIssueStoreBean","eST.AuthorizeAtIssueStoreBean", request);  
		bean.setLanguageId(locale);
		bean_id.setLanguageId(locale);
		
		//Added for ML-MMOH-SCF-1013 starts 
 		/*Connection con				= null;
 		con						= ConnectionManager.getConnection(request);
 		boolean site_main = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_CREATE_REQUEST_DEF_UOM");
		bean.setSite_spec_yn(site_main);
 		System.out.println("site_main for WCH: "+site_main); 
		//Added for ML-MMOH-SCF-1013 ends
		
	   	/**
			* @Name - Priya
			* @Date - 11/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - To display the no of digits after decimal point as given in entity parameter function
		*/
		int no_of_decimals=bean.getNoOfDecimals();
		//Added by rabbani #inc no:45231 on 28-NOV-2013
		String AckForReqyn				=		"";
		AckForReqyn						=		bean.getAckForReqyn(); 
		String req_store_code		    =		request.getParameter("store_code")==null?"":request.getParameter( "store_code" ) ;
		boolean blnIssAckReqd = bean.getIssAckReqd(req_store_code);		 
		
	
            _bw.write(_wl_block12Bytes, _wl_block12);

	try{
			HashMap sqlMap					=		new HashMap();
			//sqlMap.put("sqlData", eST.Common.StRepository.getStKeyValue("SQL_ST_REQUEST_STATUS_DTL_SELECT"));
			//commented by Rabbani #Bru-HIMS-CRF-118 on 26-JULY-2013
			//sqlMap.put("sqlData", "SELECT   hdr.req_on_store_code,hdr.req_by_store_code store_code,dtl.doc_no, dtl.doc_srl_no, dtl.item_code, itm.short_desc item_desc,dtl.req_item_qty, nvl(st.iss_item_qty,0) iss_item_qty,NVL (dtl.pending_item_qty, 0) pending_item_qty, gen_uom_code,am.short_desc gen_short_desc, nvl(st.authorized_item_qty,0) authorized_item_qty,DECODE (request_status, 'L', (SELECT remarks_desc FROM mm_trn_remarks_lang_vw WHERE trn_remarks_code = hdr.cancelled_remarks  AND language_id = ?),(select remarks_desc from mm_trn_remarks_lang_vw where dtl.auth_trn_remarks_code = trn_remarks_code and language_id = ?)) remarks FROM st_request_hdr hdr,st_request_dtl dtl,mm_item_lang_vw itm,am_uom_lang_vw am,st_issue_dtl st WHERE hdr.doc_type_code = ? AND hdr.doc_no = ? and hdr.doc_type_code = dtl.doc_type_code and hdr.doc_no= dtl.doc_no AND dtl.item_code = itm.item_code AND itm.language_id = ? AND itm.language_id =  am.language_id AND itm.gen_uom_code = am.uom_code  AND dtl.doc_type_code = st.doc_type_code(+) AND dtl.doc_no = st.doc_no(+) AND dtl.doc_srl_no = st.doc_srl_no(+) AND dtl.item_code = st.item_code(+) ORDER BY st.seq_no,dtl.doc_srl_no");
			
			//sqlMap.put("sqlData", "SELECT   hdr.req_on_store_code,hdr.req_by_store_code store_code,dtl.doc_no, dtl.doc_srl_no, dtl.item_code, itm.short_desc item_desc,dtl.req_item_qty, nvl(st.iss_item_qty,0) iss_item_qty,NVL (dtl.pending_item_qty, 0) pending_item_qty, gen_uom_code,am.short_desc gen_short_desc, nvl(st.authorized_item_qty,0) authorized_item_qty,DECODE(request_status, 'L', DECODE(DTL.CANCEL_REMARKS_DESC,'',(SELECT remarks_desc FROM mm_trn_remarks_lang_vw WHERE trn_remarks_code = hdr.cancelled_remarks  AND language_id = ?),DTL.CANCEL_REMARKS_DESC),DECODE(DTL.CANCEL_REMARKS_DESC,'',(select remarks_desc from mm_trn_remarks_lang_vw where dtl.auth_trn_remarks_code = trn_remarks_code and language_id = ?),DTL.CANCEL_REMARKS_DESC)) remarks FROM st_request_hdr hdr,st_request_dtl dtl,mm_item_lang_vw itm,am_uom_lang_vw am,st_issue_dtl st WHERE hdr.doc_type_code = ? AND hdr.doc_no = ? and hdr.doc_type_code = dtl.doc_type_code and hdr.doc_no= dtl.doc_no AND dtl.item_code = itm.item_code AND itm.language_id = ? AND itm.language_id =  am.language_id AND itm.gen_uom_code = am.uom_code  AND dtl.doc_type_code = st.doc_type_code(+) AND dtl.doc_no = st.doc_no(+) AND dtl.doc_srl_no = st.doc_srl_no(+) AND dtl.item_code = st.item_code(+) ORDER BY st.seq_no,dtl.doc_srl_no");
			
			//Addded by Rabbani #Inc no :44011 (ML-BRU-SCF-1071) on 22-OCT-2013
			//sqlMap.put("sqlData", "SELECT   hdr.req_on_store_code,hdr.req_by_store_code store_code,dtl.doc_no, dtl.doc_srl_no, dtl.item_code, itm.short_desc item_desc,dtl.req_item_qty, nvl(st.iss_item_qty,0) iss_item_qty,NVL (dtl.pending_item_qty, 0) pending_item_qty, gen_uom_code,am.short_desc gen_short_desc, nvl(st.authorized_item_qty,0) authorized_item_qty,DECODE(request_status, 'L', DECODE(DTL.CANCEL_REMARKS_DESC,'',(SELECT remarks_desc FROM mm_trn_remarks_lang_vw WHERE trn_remarks_code = hdr.cancelled_remarks  AND language_id = ?),DTL.CANCEL_REMARKS_DESC),DECODE(DTL.CANCEL_REMARKS_DESC,'',(select remarks_desc from mm_trn_remarks_lang_vw where dtl.auth_trn_remarks_code = trn_remarks_code and language_id = ?),DTL.CANCEL_REMARKS_DESC)) remarks,st.seq_no FROM st_request_hdr hdr,st_request_dtl dtl,mm_item_lang_vw itm,am_uom_lang_vw am,st_issue_dtl st WHERE hdr.doc_type_code = ? AND hdr.doc_no = ? and hdr.doc_type_code = dtl.doc_type_code and hdr.doc_no= dtl.doc_no AND dtl.item_code = itm.item_code AND itm.language_id = ? AND itm.language_id =  am.language_id AND itm.gen_uom_code = am.uom_code  AND dtl.doc_type_code = st.doc_type_code(+) AND dtl.doc_no = st.doc_no(+) AND dtl.doc_srl_no = st.doc_srl_no(+) AND dtl.item_code = st.item_code(+) ORDER BY st.seq_no,dtl.doc_srl_no");
			
			//added by Rabbani #inc no:41756(JD-CRF-0186) on 18-NOV-2013
			//sqlMap.put("sqlData", "SELECT   hdr.req_on_store_code,hdr.req_by_store_code store_code,dtl.doc_no, dtl.doc_srl_no, dtl.item_code, itm.short_desc item_desc,dtl.req_item_qty, nvl(st.iss_item_qty,0) iss_item_qty,(decode ((select max(seq_no) from st_issue_dtl a where dtl.doc_type_code = st.doc_type_code AND a.doc_no = st.doc_no AND a.doc_srl_no = st.doc_srl_no AND a.item_code = st.item_code ),st.seq_no,(NVL (dtl.PENDING_ITEM_QTY, 0)),'')) pending_item_qty, gen_uom_code,am.short_desc gen_short_desc, nvl(st.authorized_item_qty,0) authorized_item_qty,DECODE(request_status, 'L', DECODE(DTL.CANCEL_REMARKS_DESC,'',(SELECT remarks_desc FROM mm_trn_remarks_lang_vw WHERE trn_remarks_code = hdr.cancelled_remarks  AND language_id = ?),DTL.CANCEL_REMARKS_DESC),DECODE(DTL.CANCEL_REMARKS_DESC,'',(select remarks_desc from mm_trn_remarks_lang_vw where dtl.auth_trn_remarks_code = trn_remarks_code and language_id = ?),DTL.CANCEL_REMARKS_DESC)) remarks,st.seq_no FROM st_request_hdr hdr,st_request_dtl dtl,mm_item_lang_vw itm,am_uom_lang_vw am,st_issue_dtl st WHERE hdr.doc_type_code = ? AND hdr.doc_no = ? and hdr.doc_type_code = dtl.doc_type_code and hdr.doc_no= dtl.doc_no AND dtl.item_code = itm.item_code AND itm.language_id = ? AND itm.language_id =  am.language_id AND itm.gen_uom_code = am.uom_code  AND dtl.doc_type_code = st.doc_type_code(+) AND dtl.doc_no = st.doc_no(+) AND dtl.doc_srl_no = st.doc_srl_no(+) AND dtl.item_code = st.item_code(+) ORDER BY st.item_code, st.seq_no,dtl.doc_srl_no");
			
			//sqlMap.put("sqlData", "SELECT   hdr.req_on_store_code,hdr.req_by_store_code store_code,dtl.doc_no, dtl.doc_srl_no, dtl.item_code, itm.short_desc item_desc,dtl.req_item_qty, nvl(st.iss_item_qty,0) iss_item_qty,(decode ((select max(seq_no) from st_issue_dtl a where dtl.doc_type_code = st.doc_type_code AND a.doc_no = st.doc_no AND a.doc_srl_no = st.doc_srl_no AND a.item_code = st.item_code ),st.seq_no,(NVL (dtl.PENDING_ITEM_QTY, 0)),'')) pending_item_qty, gen_uom_code,am.short_desc gen_short_desc, nvl(st.authorized_item_qty,0) authorized_item_qty,DECODE(dtl.cancel_remarks_desc,'',(SELECT remarks_desc   FROM mm_trn_remarks_lang_vw WHERE   st.REMARKS = trn_remarks_code  AND language_id = ?), dtl.cancel_remarks_desc) remarks,st.seq_no FROM st_request_hdr hdr,st_request_dtl dtl,mm_item_lang_vw itm,am_uom_lang_vw am,st_issue_dtl st WHERE hdr.doc_type_code = ? AND hdr.doc_no = ? and hdr.doc_type_code = dtl.doc_type_code and hdr.doc_no= dtl.doc_no AND dtl.item_code = itm.item_code AND itm.language_id = ? AND itm.language_id =  am.language_id AND itm.gen_uom_code = am.uom_code  AND dtl.doc_type_code = st.doc_type_code(+) AND dtl.doc_no = st.doc_no(+) AND dtl.doc_srl_no = st.doc_srl_no(+) AND dtl.item_code = st.item_code(+) ORDER BY st.item_code, st.seq_no,dtl.doc_srl_no");
			//Added by rabbani #inc no:45231 on 28-NOV-2013
			//sqlMap.put("sqlData", "SELECT   hdr.req_on_store_code,hdr.req_by_store_code store_code,dtl.doc_no, dtl.doc_srl_no, dtl.item_code, itm.short_desc item_desc,dtl.req_item_qty, nvl(st.iss_item_qty,0) iss_item_qty,(decode ((select max(seq_no) from st_issue_dtl a where dtl.doc_type_code = st.doc_type_code AND a.doc_no = st.doc_no AND a.doc_srl_no = st.doc_srl_no AND a.item_code = st.item_code ),st.seq_no,(NVL (dtl.PENDING_ITEM_QTY, 0)),'')) pending_item_qty, gen_uom_code, st.ISSUE_UOM ,am.short_desc gen_short_desc, nvl(st.authorized_item_qty,0) authorized_item_qty,DECODE(dtl.cancel_remarks_desc,'',(SELECT remarks_desc   FROM mm_trn_remarks_lang_vw WHERE   st.REMARKS = trn_remarks_code  AND language_id = ?), dtl.cancel_remarks_desc) remarks,st.seq_no,(SELECT SUM (NVL(ack.RECEIVED_QTY,0)) FROM st_acknowledge_trn_dtl ack WHERE st.doc_type_code = ack.doc_type_code(+)  AND st.doc_no = ack.doc_no(+) AND st.doc_srl_no = ack.doc_srl_no(+) AND st.item_code = ack.item_code(+) and ST.FACILITY_ID = ACK.FACILITY_ID(+) and ST.SEQ_NO = ack.seq_no(+)) RECEIVED_QTY,(SELECT SUM (NVL(ack.REJECTED_QTY,0)) FROM st_acknowledge_trn_dtl ack WHERE st.doc_type_code = ack.doc_type_code(+)  AND st.doc_no = ack.doc_no(+) AND st.doc_srl_no = ack.doc_srl_no(+) AND st.item_code = ack.item_code(+) and ST.FACILITY_ID = ACK.FACILITY_ID(+) and ST.SEQ_NO = ack.seq_no(+)) REJECTED_QTY, DTL.REQUEST_UOM_CONV , DTL.REQUEST_UOM_QTY , dtl.REQUEST_UOM, DTL.REJECT_REMARKS_DESC FROM st_request_hdr hdr,st_request_dtl dtl,mm_item_lang_vw itm,am_uom_lang_vw am,st_issue_dtl st WHERE hdr.doc_type_code = ? AND hdr.doc_no = ? and hdr.doc_type_code = dtl.doc_type_code and hdr.doc_no= dtl.doc_no AND dtl.item_code = itm.item_code AND itm.language_id = ? AND itm.language_id =  am.language_id AND itm.gen_uom_code = am.uom_code  AND dtl.doc_type_code = st.doc_type_code(+) AND dtl.doc_no = st.doc_no(+) AND dtl.doc_srl_no = st.doc_srl_no(+) AND dtl.item_code = st.item_code(+) ORDER BY st.item_code, st.seq_no,dtl.doc_srl_no");//ADDED FOR ML-MMOH-SCF-1003,MO-CRF-20174 
			sqlMap.put("sqlData", "SELECT   hdr.req_on_store_code,hdr.req_by_store_code store_code,dtl.doc_no, dtl.doc_srl_no, dtl.item_code, itm.short_desc item_desc,dtl.req_item_qty, nvl(dtl.iss_item_qty,0) iss_item_qty,(decode ((select max(seq_no) from st_issue_dtl a where dtl.doc_type_code = st.doc_type_code AND a.doc_no = st.doc_no AND a.doc_srl_no = st.doc_srl_no AND a.item_code = st.item_code ),st.seq_no,(NVL (dtl.PENDING_ITEM_QTY, 0)),'')) pending_item_qty, gen_uom_code, st.ISSUE_UOM ,am.short_desc gen_short_desc, nvl(dtl.committed_item_qty,0) authorized_item_qty,DECODE(dtl.cancel_remarks_desc,'',(SELECT remarks_desc   FROM mm_trn_remarks_lang_vw WHERE   st.REMARKS = trn_remarks_code  AND language_id = ?), dtl.cancel_remarks_desc) remarks,st.seq_no,(SELECT SUM (NVL(ack.RECEIVED_QTY,0)) FROM st_acknowledge_trn_dtl ack WHERE st.doc_type_code = ack.doc_type_code(+)  AND st.doc_no = ack.doc_no(+) AND st.doc_srl_no = ack.doc_srl_no(+) AND st.item_code = ack.item_code(+) and ST.FACILITY_ID = ACK.FACILITY_ID(+) and ST.SEQ_NO = ack.seq_no(+)) RECEIVED_QTY,(SELECT SUM (NVL(ack.REJECTED_QTY,0)) FROM st_acknowledge_trn_dtl ack WHERE st.doc_type_code = ack.doc_type_code(+)  AND st.doc_no = ack.doc_no(+) AND st.doc_srl_no = ack.doc_srl_no(+) AND st.item_code = ack.item_code(+) and ST.FACILITY_ID = ACK.FACILITY_ID(+) and ST.SEQ_NO = ack.seq_no(+)) REJECTED_QTY, DTL.REQUEST_UOM_CONV , DTL.REQUEST_UOM_QTY , dtl.REQUEST_UOM, DTL.REJECT_REMARKS_DESC FROM st_request_hdr hdr,st_request_dtl dtl,mm_item_lang_vw itm,am_uom_lang_vw am,st_issue_dtl st WHERE hdr.doc_type_code = ? AND hdr.doc_no = ? and hdr.doc_type_code = dtl.doc_type_code and hdr.doc_no= dtl.doc_no AND dtl.item_code = itm.item_code AND itm.language_id = ? AND itm.language_id =  am.language_id AND itm.gen_uom_code = am.uom_code  AND dtl.doc_type_code = st.doc_type_code(+) AND dtl.doc_no = st.doc_no(+) AND dtl.doc_srl_no = st.doc_srl_no(+) AND dtl.item_code = st.item_code(+) ORDER BY st.item_code, st.seq_no,dtl.doc_srl_no");//Modified for ML-BRU-SCF-2230
			
			
		
			HashMap funcMap					=		new HashMap();
			ArrayList displayFields			=		new ArrayList();
            
			//displayFields.add("store_code");
			displayFields.add("doc_no");
			displayFields.add("doc_srl_no");
			displayFields.add("item_desc");
			displayFields.add("req_item_qty");
			displayFields.add("iss_item_qty");
			displayFields.add("pending_item_qty");
			displayFields.add("item_code");
			displayFields.add("gen_short_desc");
			displayFields.add("authorized_item_qty");
			displayFields.add("remarks");
			displayFields.add("store_code");
			displayFields.add("req_on_store_code");
			displayFields.add("seq_no"); //Addded by Rabbani #Inc no :44011 (ML-BRU-SCF-1071) on 22-OCT-2013
			displayFields.add("RECEIVED_QTY"); //Added by rabbani #inc no:45231 on 28-NOV-2013
			displayFields.add("REJECTED_QTY"); //Added by rabbani #inc no:45231 on 28-NOV-2013
			displayFields.add("ISSUE_UOM");//added for ML-MMOH-SCF-0979
			displayFields.add("gen_uom_code");//added for ML-MMOH-SCF-0979
			
			/*ADDED FOR ML-MMOH-SCF-1003 START*/
			displayFields.add("REQUEST_UOM_CONV"); 
			displayFields.add("REQUEST_UOM_QTY"); 
			displayFields.add("REQUEST_UOM");
			displayFields.add("REJECT_REMARKS_DESC");//MO-CRF-20174  
			/*ADDED FOR ML-MMOH-SCF-1003 END*/

			ArrayList chkFields				=		new ArrayList();
			//chkFields.add(locale); //17/08/12
			chkFields.add(locale);
			chkFields.add(doc_type_code);
			chkFields.add(doc_no);
			chkFields.add(locale);

			funcMap.put("displayFields", displayFields);
			funcMap.put("chkFields", chkFields);

			ArrayList result				=		(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
			int recCount=0;//,i = 0;
			double recQty = 0.0;//added for ml-mmoh-0979
			double requested_uom= 0.0;//added for ml-mmoh-scf-1003
			double requested_uom_qty = 0.0; //added for ml-mmoh-scf-1003
			String strReqQty = "0"; //added for ml-mmoh-0979
			if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){
	
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(result.get(1)));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
if(blnIssAckReqd && AckForReqyn.equals("Y") ){
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
}
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

			ArrayList records	=	new ArrayList();
			for(recCount=2;recCount<result.size(); recCount++) {
				if (recCount % 2 == 0)
					classvalue  = "OAQRYEVEN" ;
				else
					classvalue  = "OAQRYODD" ;
		
            _bw.write(_wl_block30Bytes, _wl_block30);

	//pmd 29/01/05
		//				String link_columns =	 "1";
						records				=	(ArrayList) result.get(recCount);
						 String pending_chk =  bean.checkForNull((String)records.get(5),"");//added by Rabbani #inc no:41756(JD-CRF-0186) on 18-NOV-2013
						 /*ADDED FOR ML-MMOH-SCF-1003 START*/
						 String issue_uom= bean.checkForNull((String)records.get(15),"");
						 String generic_uom= bean.checkForNull((String)records.get(16),"");
						 double requested_uom_pending =  Double.parseDouble(bean.checkForNull((String)records.get(17),"1"));
						 String req_uom= CommonBean.checkForNull((String)records.get(19),"");
						 /*ADDED FOR ML-MMOH-SCF-1003 END*/
						 
						 
						double pending_qty = Double.parseDouble(bean.checkForNull((String)records.get(5),"0"));
						double conv_factor = bean_id.getConvFactTemp((String)records.get(6),(String)records.get(10));
						
						
						//MODIFIED FOR ML-MMOH-SCF-1003 START
						double on_store_conv_factor = bean_id.getConvFactTemp((String)records.get(6),(String)records.get(11)); //Modified for 70724 
						 
		                  /*if(!(req_uom.equals(generic_uom))){
		                	  pending_qty = pending_qty * Double.parseDouble(bean.checkForNull((String)records.get(17)));  //added for ml-mmoh-scf-1013
		                  }else{
		                	  pending_qty = pending_qty;
		                  }*/ //commented for ML-MMOH-CRF-1200
		                  
		                //MODIFIED FOR ML-MMOH-SCF-1003 END 
		                 
						  String iss_seq_no = CommonBean.checkForNull((String)records.get(12),"");
						 
						  
						  double recv_qty = Double.parseDouble(bean.checkForNull((String)records.get(13),"0"));
						  double rej_qty = Double.parseDouble(bean.checkForNull((String)records.get(14),"0"));
						   
 						
            _bw.write(_wl_block31Bytes, _wl_block31);
 if(iss_seq_no.equals("")) { 
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(CommonBean.checkForNull((String)records.get(0),"&nbsp;")));
            _bw.write(_wl_block34Bytes, _wl_block34);
 }else{ 
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(CommonBean.checkForNull((String)records.get(0),"&nbsp;")));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(iss_seq_no));
            _bw.write(_wl_block36Bytes, _wl_block36);
} 
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(CommonBean.checkForNull((String)records.get(6),"&nbsp;")));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(records.get(2)));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(CommonBean.checkForNull((String)records.get(7),"&nbsp;")));
            _bw.write(_wl_block41Bytes, _wl_block41);
  
						 					 				
						 String issue_uom1= bean.checkForNull((String)records.get(15),"");
						 String generic_uom2= bean.checkForNull((String)records.get(16),"");
						 requested_uom_qty =  Double.parseDouble(bean.checkForNull((String)records.get(18),"0"));
						 requested_uom =  Double.parseDouble(bean.checkForNull((String)records.get(17),"0"));
						 System.err.println("issue_uom@@@=="+issue_uom1+" generic_uom@@@=="+generic_uom2+" req_uom: "+req_uom);
						 
						 /*added for ML-MMOH-SCF-1013 start */	
						 strReqQty =  bean.checkForNull((String)records.get(3),"0");
				System.err.println("strReqQty@@@==="+strReqQty);
					/*
							 if(!req_uom.equalsIgnoreCase(generic_uom)){
								 double req_Qty =  Double.parseDouble(bean.checkForNull((String)records.get(3),"0")) * Double.parseDouble(bean.checkForNull((String)records.get(17),"0")); 
								 int reqQty= (int)req_Qty;
								 strReqQty = String.valueOf(reqQty); 
							 }*/ //commented for ML-MMOH-CRF-1200
						  /*added for ML-MMOH-SCF-1013 end */	
						 
						 
						 
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(strReqQty));
            _bw.write(_wl_block44Bytes, _wl_block44);

							
							//double au_qty = Double.parseDouble(bean.checkForNull((String)records.get(8),"0"))*(conv_factor);//Added for ML-MMOH-SCF-1003
							double au_qty = Double.parseDouble(bean.checkForNull((String)records.get(8),"0"))*(on_store_conv_factor);//Added for ML-MMOH-SCF-1003
									
							
							double iss_qty = Double.parseDouble(bean.checkForNull((String)records.get(4),"0"))*(on_store_conv_factor);
						
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(bean.setNumber(Double.toString(au_qty),no_of_decimals)));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(bean.setNumber(Double.toString(iss_qty),no_of_decimals)));
            _bw.write(_wl_block36Bytes, _wl_block36);
if(pending_chk.equals("")){ 
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(bean.checkForNull(pending_chk,"&nbsp;")));
            _bw.write(_wl_block48Bytes, _wl_block48);
}else{ 
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(bean.setNumber(Double.toString(pending_qty),no_of_decimals)));
            _bw.write(_wl_block36Bytes, _wl_block36);
} 
            _bw.write(_wl_block49Bytes, _wl_block49);
if(blnIssAckReqd && AckForReqyn.equals("Y")){
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(bean.setNumber(Double.toString(recv_qty),no_of_decimals)));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(bean.setNumber(Double.toString(rej_qty),no_of_decimals)));
            _bw.write(_wl_block36Bytes, _wl_block36);
}else {
            _bw.write(_wl_block50Bytes, _wl_block50);
}
						String cancelled_remarks = (String)records.get(9);//MO-CRF-20174
						String rejection_remarks = (String)records.get(20);
						System.out.println("cancelled_remarks "+cancelled_remarks+"---rejection_remarks: "+rejection_remarks); 
						
            _bw.write(_wl_block51Bytes, _wl_block51);
 if(cancelled_remarks!=null){ 
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(bean.checkForNull((String)records.get(9),"&nbsp;")));
            _bw.write(_wl_block54Bytes, _wl_block54);
} 
            _bw.write(_wl_block55Bytes, _wl_block55);
 if(rejection_remarks!=null){ 
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(bean.checkForNull((String)records.get(20),"&nbsp;")));
            _bw.write(_wl_block54Bytes, _wl_block54);
} 
            _bw.write(_wl_block56Bytes, _wl_block56);

			}
		
            _bw.write(_wl_block57Bytes, _wl_block57);

			out.flush();
		} 
		else{
		
            _bw.write(_wl_block58Bytes, _wl_block58);

		}
		out.println(CommonBean.setForm (request ,"../../eST/jsp/RequestStatusList.jsp", searched));
	
	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}

            _bw.write(_wl_block59Bytes, _wl_block59);

				out.println(CommonBean.setForm (request ,"../../eST/jsp/RequestStatusList.jsp", searched));
}catch (Exception e){
	e.printStackTrace();
}

            _bw.write(_wl_block60Bytes, _wl_block60);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.ItemDetails.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DocNo.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.SeqNo.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.item.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.uom.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.ReqQty.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Authorized.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Issue.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.IssueQuantity.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PendingQty.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.ReceivedQty.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.RejectedQty.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
}
