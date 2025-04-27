package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Properties;
import eST.*;
import java.text.*;
import webbeans.eCommon.*;
import java.lang.*;
import java.util.*;
import java.sql.*;
import eCommon.Common.*;
import java.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __blockedbatchesqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/BlockedBatchesQueryResult.jsp", 1709122007324L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonBean.jsp", 1710760607421L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n \n ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<html>\n\t<head>\n\t\n ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t <link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\' ></link>\n\t\t <script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t <script language=\"javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n\t\t <script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t <script language=\'javascript\' src=\'../../eST/js/StCommon.js\'></script>\n\t\t <script language=\'javascript\' src=\'../../eST/js/BlockedBatches.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t<body>\n\t<form name=\"formBlockedBatchesQueryResult\" id=\"formBlockedBatchesQueryResult\">\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<table cellpadding=0 cellspacing=0 width=\"100%\" align=\"center\">\n\t\t\t<tr>\n\t\t\t\t<td width=\"80%\" class=\"white\">&nbsp;</td>\n\t\t\t\t<td width=\"20%\" class=\"white\">&nbsp;";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" id=\'tb1\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<!-- Added by suresh.r on 29-09-2014 against Inc 51460 beg-->\n\t\t\t\t\t ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t<th>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t<!-- Added by suresh.r on 29-09-2014 against Inc 51460 end-->\n\t\t\t\t\t<th>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th>\n\t\t\t\t\t<th>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</th> \n\t\t\t\t\t<th>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</th>\n                    ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</th> \n                   <th>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =".</th>\n\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</th>\n\t\t\t\t\t\n\n\t\t\t\t</tr>\t\t\n\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t<tr>\n\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t<!--Added by suresh.r on 29-09-2014 against Inc 51460 beg-->\n\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" onclick=\"disableClick(event);\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t<!--Added by suresh.r on 29-09-2014 against Inc 51460 end-->\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" onclick=\"disableClick(event);\" align=\"right\">";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" onclick=\"disableClick(event);\" align=\'center\'>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" \n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n                    ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td>\n                     <td class=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n                    ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td>\n                    <td class=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n                  <td class=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n\t   \n\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" onclick=\"disableClick(event);\" nowrap style=\"TEXT-ALIGN:right\">  \n\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="&nbsp;\t\t\n\t\t\t\t </td>\n\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" onclick=\"disableClick(event);\" align=\'right\'>";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</td>\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</td>\n\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t<!-- \t\t\t\t\t\n\t\t\t\t\t\t* @Name - Priya\n\t\t\t\t\t\t* @Date - 19/02/2010\n\t\t\t\t\t\t* @Inc# - IN019466\n\t\t\t\t\t\t* @Desc - To right align Transaction Qty.\t\t\t\t\n\t\t\t\t\t-->\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" onclick=\"disableClick(event);\" style=\"TEXT-ALIGN:right\">";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="&nbsp;</td>\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" onclick=\"disableClick(event);\" align=\'right\' nowrap> ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</td>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</td>\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t</table>\n\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n\t</form>\n\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t<script>\n\t\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));\n\t\t\t\tdocument.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n</body>\n</html>\n\n";
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
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
10/8/2021		TFS-22402			Shazana										ST-MOHE-CRF-0084.1-US013/06 - Unposted Transactions
---------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
            eCommon.Common.CommonBean CommonBean= null;{
                CommonBean=(eCommon.Common.CommonBean)pageContext.getAttribute("CommonBean");
                if(CommonBean==null){
                    CommonBean=new eCommon.Common.CommonBean();
                    pageContext.setAttribute("CommonBean",CommonBean);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

    CommonBean.setProperties( (Properties) session.getValue( "jdbc" ) ) ;
	CommonBean.setLoginById( (String) session.getValue( "login_user" ) ) ;
	CommonBean.setLoginAtWsNo( CommonBean.getProperties().getProperty( "client_ip_address" ) ) ;
	CommonBean.setLoginFacilityId( (String) session.getValue( "facility_id" ) ) ;

            _bw.write(_wl_block4Bytes, _wl_block4);
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
            _bw.write(_wl_block4Bytes, _wl_block4);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);

		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

		String bean_id				=		"blockedBatchesBean";
		String bean_name			=		"eST.BlockedBatchesBean";

		eST.BlockedBatchesBean bean =		(eST.BlockedBatchesBean) getBeanObject(bean_id,bean_name,request);  
		bean.setLanguageId(locale);
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
		String user_name  =  (String) session.getValue( "login_user" ) ;//MOHE-CRF-0084.1 

		boolean restrict_stores_user_access_yn =false;
	    	String strFacilityParam = "";
		String restrictInReportYN = "";
		Connection con				= null; 
		 try{
				con						= ConnectionManager.getConnection(request);
			    restrict_stores_user_access_yn = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_RESTRICT_USER_ACCESS_STORES");
		    }
		 catch (Exception exp){
			 exp.printStackTrace();
		
		 }
		    finally{ 
		    	if(con != null)
		    		ConnectionManager.returnConnection(con,request); 
		    }
		 strFacilityParam = bean.getRestrictUserAccessStore();
		
			if(strFacilityParam== null || strFacilityParam.equals(""))
				strFacilityParam = "N"; 
			if(restrict_stores_user_access_yn){
				if(strFacilityParam.equals("Y")){
					restrictInReportYN = "Y";
				}else{
					restrictInReportYN = "N"; 
				}
			}//END 

		String trn_type				=		bean.checkForNull(request.getParameter("trn_type")); //,"%")
		String doc_type_code		=		bean.checkForNull(request.getParameter("doc_type_code"));//,"%")
		String doc_no				=		bean.checkForNull(request.getParameter("doc_no"));//,"%")
		String store_code			=		bean.checkForNull(request.getParameter("store_code"));//,"%")
		String item_code			=		bean.checkForNull(request.getParameter("item_code"));//,"%")
		String batch_id				=		bean.checkForNull(request.getParameter("batch_id"));//+"%";
		String from_doc_date		=		bean.checkForNull(request.getParameter("from_doc_date"));
		String to_doc_date			=		bean.checkForNull(request.getParameter("to_doc_date"));
		String module_id			=		bean.checkForNull(request.getParameter("module_id"));//Added by suresh.r on 29-09-2014 against Inc 51460
		String disp_module_id;//Added by suresh.r on 28-04-2015 against Inc 55191
		//Date conversion is done by Archana Dhal on 11/26/2010 related to incident no. IN024566.
		from_doc_date				=		com.ehis.util.DateUtils.convertDate(from_doc_date,"DMY",locale,"en");
		to_doc_date					=		com.ehis.util.DateUtils.convertDate(to_doc_date,"DMY",locale,"en");
		//System.out.println("from_doc_date" +from_doc_date+"to_doc_date===="+to_doc_date);
		String iss_ack_req_yn       =       bean.checkForNull(request.getParameter("ISS_ACK_REQ_YN"),"N");
	    String ret_ack_req_yn       =       bean.checkForNull(request.getParameter("RET_ACK_REQ_YN"),"N");
	    String tfr_ack_req_yn       =       bean.checkForNull(request.getParameter("TFR_ACK_REQ_YN"),"N");
        String enabled = "<img align='center' src=\'../../eCommon/images/enabled.gif\'></img>";
		String space	= "&nbsp;";
		String sql		= "";
		/**
				* @Name - Krishna Kiran 
				* @Date - 19/01/2010
				* @Inc# - 15496 (SRR20056-CRF-0537.2)
				* @Desc - No of Decimal is brought here in order to pass a value to setNumber Function and isValidNumber Function.
				*/
			int no_of_decimals = bean.getNoOfDecimals();
		//	NumberFormat nf_qty = NumberFormat.getInstance(new Locale(locale));
			/**END**/

		 ArrayList chkFields		=		new ArrayList();
		boolean searched			=		(request.getParameter("searched") == null) ?false:true;

		String classvalue			=		"";
		try{
			CommonBean.setLoginFacilityId((String) session.getValue("facility_id"));
 
			HashMap sqlMap			=		new HashMap();
			iss_ack_req_yn = "N";
			if(iss_ack_req_yn.equals("N") || ret_ack_req_yn.equals("N") || tfr_ack_req_yn.equals("N"))
			{
			//sqlMap.put("sqlData", eST.Common.StRepository.getStKeyValue("SQL_ST_BLOCKED_BATCHES_VIEW_QUERY_RESULT"));
				if(restrict_stores_user_access_yn){//modified for MOHE-CRF-0084.1 
					sql = "SELECT STBV.DOC_TYPE_CODE, STBV.DOC_NO, STBV.SEQ_NO, STBV.TRN_TYPE, STBV.DOC_SRL_NO, STBV.STORE_CODE, STBV.ITEM_CODE, STBV.BATCH_ID, STBV.BIN_LOCATION_CODE, TO_CHAR (STBV.EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_DATE_OR_RECEIPT_DATE, STBV.BLOCKED_QTY, STBV.DOC_TYPE_DESC, STBV.STORE_DESC, STBV.ITEM_DESC, STBV.TRN_TYPE_DESC, STBV.BIN_DESC, TO_CHAR (STBV.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, AM.SHORT_DESC GEN_UOM_DESC,'ST' MODULE_ID  FROM ST_BLOCKED_BATCHES_LANG_VIEW STBV,MM_ITEM_LANG_VW MM, AM_UOM AM, st_acc_entity_param acc WHERE STBV.FACILITY_ID = ? ";
			}else{
			sql = "SELECT STBV.DOC_TYPE_CODE, STBV.DOC_NO, STBV.SEQ_NO, STBV.TRN_TYPE, STBV.DOC_SRL_NO, STBV.STORE_CODE, STBV.ITEM_CODE, STBV.BATCH_ID, STBV.BIN_LOCATION_CODE, TO_CHAR (STBV.EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_DATE_OR_RECEIPT_DATE, STBV.BLOCKED_QTY, STBV.DOC_TYPE_DESC, STBV.STORE_DESC, STBV.ITEM_DESC, STBV.TRN_TYPE_DESC, STBV.BIN_DESC, TO_CHAR (STBV.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, AM.SHORT_DESC GEN_UOM_DESC,'ST' MODULE_ID  FROM ST_BLOCKED_BATCHES_LANG_VIEW STBV,MM_ITEM_LANG_VW MM, AM_UOM AM WHERE STBV.FACILITY_ID = ? ";
				}


			if(!trn_type.equals(""))
					sql = sql + " AND STBV.TRN_TYPE = " + " '"+trn_type+"' " ;			
			if(!doc_type_code.equals(""))
				sql = sql + " AND STBV.DOC_TYPE_CODE = " + " '"+doc_type_code+"' " ;	
			if(!doc_no.equals(""))
				sql = sql + " AND STBV.DOC_NO = " + " '"+doc_no+"' " ;	
			if(!store_code.equals(""))
				sql = sql + " AND STBV.STORE_CODE = " + " '"+store_code+"' " ;	
			if(!item_code.equals(""))
				sql = sql + " AND STBV.ITEM_CODE = " + " '"+item_code+"' " ;	
			if(!batch_id.equals(""))
				sql = sql + " AND STBV.BATCH_ID = " + " '"+batch_id+"' " ;	
			if(!from_doc_date.equals("") && !to_doc_date.equals(""))
				sql = sql + " AND STBV.DOC_DATE BETWEEN TO_DATE ("+"'"+from_doc_date+"'"+", 'DD/MM/YYYY') AND TO_DATE ("+"'"+to_doc_date+"'"+ ", 'DD/MM/YYYY')" ;
			else if(!from_doc_date.equals("") && to_doc_date.equals(""))
				sql = sql + " AND STBV.DOC_DATE BETWEEN TO_DATE ("+"'"+from_doc_date+"'"+", 'DD/MM/YYYY') AND TO_DATE (NVL ("+"'"+to_doc_date+"'"+ ", TO_CHAR(sysdate,'DD/MM/YYYY')), 'DD/MM/YYYY')";


			sql = sql + " AND STBV.LANGUAGE_ID = ? AND STBV.LANGUAGE_ID = MM.LANGUAGE_ID AND STBV.ITEM_CODE = MM.ITEM_CODE AND MM.GEN_UOM_CODE = AM.UOM_CODE ";
			//Modified for MOHE-CRF-0084.1 
			if(restrict_stores_user_access_yn){//MOHE-CRF-0084.1 START
				if(strFacilityParam.equals("Y")){
					sql = sql + " AND stbv.store_code IN (SELECT STORE_CODE FROM ST_USER_ACCESS_FOR_STORE WHERE USER_ID = " + " '"+user_name+"' ) and stbv.facility_id like decode (TRN_ACROSS_FACILITY_YN, 'Y',stbv.facility_id, ? )";	
					}else if (strFacilityParam.equals("N")){
						sql = sql + " AND stbv.facility_id like decode (TRN_ACROSS_FACILITY_YN, 'Y',stbv.facility_id, ? )";
					}
			}//END 
				
			sqlMap.put("sqlData", sql);

			chkFields		=		new ArrayList();

			chkFields.add(bean.getLoginFacilityId());
			
			/*chkFields.add(trn_type);
			chkFields.add(doc_type_code);
			chkFields.add(doc_no);
			chkFields.add(store_code);
			chkFields.add(item_code);
			chkFields.add(batch_id);
			chkFields.add(from_doc_date);
			chkFields.add(to_doc_date);*/
			chkFields.add(locale);
			if(restrict_stores_user_access_yn){//MOHE-CRF-0084.1 
			chkFields.add(bean.getLoginFacilityId());
			}
			}
			if(iss_ack_req_yn.equals("Y") || ret_ack_req_yn.equals("Y") || tfr_ack_req_yn.equals("Y"))
			{
				/*if(!(trn_type.equals("ACK")))
				{*/
			//Commented by Rabbani on 20/11/2012 to avoid performance issue in Query
			//sql = "SELECT STBV.DOC_TYPE_CODE, STBV.DOC_NO, STBV.SEQ_NO, STBV.TRN_TYPE,STBV.DOC_SRL_NO, STBV.STORE_CODE, STBV.ITEM_CODE, STBV.BATCH_ID,STBV.BIN_LOCATION_CODE,TO_CHAR (STBV.EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_DATE_OR_RECEIPT_DATE,(CASE WHEN ACK.TMP_REJECTED_QTY_2 IS NULL THEN STBV.BLOCKED_QTY ELSE (NVL(ACK.TMP_RECEIVED_QTY_2,0) + NVL(ACK.TMP_REJECTED_QTY_2,0)) END ) BLOCKED_QTY,STBV.DOC_TYPE_DESC, STBV.STORE_DESC, (CASE WHEN STBV.PROCESS_FOR_ACKNOWLEDGE = 'Y' THEN 'PA' ELSE 'NA' END) ACK_STATUS,(CASE WHEN (NVL  (ACK.TMP_REJECTED_QTY_2, 0)) > 0 THEN 'CP' ELSE 'NA' END ) ACK_STATUS2, STBV.ITEM_DESC, STBV.TRN_TYPE_DESC, STBV.BIN_DESC, TO_CHAR (STBV.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, AM.SHORT_DESC GEN_UOM_DESC FROM (SELECT * FROM (SELECT A.PROCESS_FOR_ACKNOWLEDGE,DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',D.FACILITY_ID,A.FACILITY_ID) FACILITY_ID, A.DOC_TYPE_CODE, A.DOC_NO, A.SEQ_NO, A.TRN_TYPE,B.DOC_SRL_NO, DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',A.TO_STORE_CODE,B.STORE_CODE) STORE_CODE, B.ITEM_CODE, B.BATCH_ID,DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',B.TO_BIN_LOCATION_CODE,B.BIN_LOCATION_CODE) BIN_LOCATION_CODE, B.EXPIRY_DATE_OR_RECEIPT_DATE,B.ISS_ITEM_QTY BLOCKED_QTY, C.SHORT_DESC DOC_TYPE_DESC,D.SHORT_DESC STORE_DESC, E.SHORT_DESC ITEM_DESC,F.SHORT_DESC TRN_TYPE_DESC, G.SHORT_DESC BIN_DESC, A.DOC_DATE,C.LANGUAGE_ID FROM ST_ISSUE_HDR A, ST_ISSUE_DTL_EXP B, SY_DOC_TYPE_MASTER_LANG_VW C, MM_STORE_LANG_VW D, MM_ITEM_LANG_VW E, ST_TRN_TYPE_LANG_VW F, MM_BIN_LOCATION_LANG_VW G WHERE A.FACILITY_ID = B.FACILITY_ID AND A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND A.DOC_NO = B.DOC_NO AND A.SEQ_NO = B.SEQ_NO AND A.FINALIZED_YN = 'N' AND A.DOC_TYPE_CODE = C.DOC_TYPE_CODE AND DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',A.TO_STORE_CODE,B.STORE_CODE) = D.STORE_CODE AND B.ITEM_CODE = E.ITEM_CODE AND A.TRN_TYPE = F.TRN_TYPE AND DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',A.TO_STORE_CODE,B.STORE_CODE) = G.STORE_CODE AND DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',B.TO_BIN_LOCATION_CODE,B.BIN_LOCATION_CODE) = G.BIN_LOCATION_CODE AND C.LANGUAGE_ID = D.LANGUAGE_ID AND C.LANGUAGE_ID = E.LANGUAGE_ID AND C.LANGUAGE_ID = F.LANGUAGE_ID AND C.LANGUAGE_ID = G.LANGUAGE_ID UNION SELECT A.PROCESS_FOR_ACKNOWLEDGE,DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',D.FACILITY_ID,A.FACILITY_ID) FACILITY_ID, A.DOC_TYPE_CODE, A.DOC_NO, 0 SEQ_NO, A.TRN_TYPE, B.DOC_SRL_NO, DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',A.TO_STORE_CODE,B.STORE_CODE) STORE_CODE, B.ITEM_CODE, B.BATCH_ID,DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',B.TO_BIN_LOCATION_CODE,B.BIN_LOCATION_CODE) BIN_LOCATION_CODE, B.EXPIRY_DATE_OR_RECEIPT_DATE,B.ITEM_QTY BLOCKED_QTY, C.SHORT_DESC DOC_TYPE_DESC,D.SHORT_DESC STORE_DESC, E.SHORT_DESC ITEM_DESC,F.SHORT_DESC TRN_TYPE_DESC, G.SHORT_DESC BIN_DESC, A.DOC_DATE,C.LANGUAGE_ID FROM ST_ISSUE_RET_HDR A,ST_ISSUE_RET_DTL_EXP B, SY_DOC_TYPE_MASTER_LANG_VW C, MM_STORE_LANG_VW D, MM_ITEM_LANG_VW E,ST_TRN_TYPE_LANG_VW F,MM_BIN_LOCATION_LANG_VW G WHERE A.FACILITY_ID = B.FACILITY_ID AND A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND A.DOC_NO = B.DOC_NO AND A.FINALIZED_YN = 'N' AND A.DOC_TYPE_CODE = C.DOC_TYPE_CODE AND DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',A.TO_STORE_CODE,B.STORE_CODE) = D.STORE_CODE AND B.ITEM_CODE = E.ITEM_CODE AND A.TRN_TYPE = F.TRN_TYPE AND DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',A.TO_STORE_CODE,B.STORE_CODE) = G.STORE_CODE AND DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',B.TO_BIN_LOCATION_CODE,B.BIN_LOCATION_CODE) = G.BIN_LOCATION_CODE AND C.LANGUAGE_ID = D.LANGUAGE_ID AND C.LANGUAGE_ID = E.LANGUAGE_ID AND C.LANGUAGE_ID = F.LANGUAGE_ID AND C.LANGUAGE_ID = G.LANGUAGE_ID UNION SELECT A.PROCESS_FOR_ACKNOWLEDGE,DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',D.FACILITY_ID,A.FACILITY_ID) FACILITY_ID, A.DOC_TYPE_CODE, A.DOC_NO, 0 SEQ_NO, A.TRN_TYPE, B.DOC_SRL_NO, DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',A.TO_STORE_CODE,B.STORE_CODE) STORE_CODE, B.ITEM_CODE, B.BATCH_ID,DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',B.TO_BIN_LOCATION_CODE,B.BIN_LOCATION_CODE) BIN_LOCATION_CODE, B.EXPIRY_DATE_OR_RECEIPT_DATE,B.ITEM_QTY BLOCKED_QTY, C.SHORT_DESC DOC_TYPE_DESC,D.SHORT_DESC STORE_DESC, E.SHORT_DESC ITEM_DESC,F.SHORT_DESC TRN_TYPE_DESC, G.SHORT_DESC BIN_DESC, A.DOC_DATE,C.LANGUAGE_ID FROM ST_TRANSFER_HDR A,ST_TRANSFER_DTL_EXP B, SY_DOC_TYPE_MASTER_LANG_VW C,MM_STORE_LANG_VW D,MM_ITEM_LANG_VW E,ST_TRN_TYPE_LANG_VW F,MM_BIN_LOCATION_LANG_VW G WHERE A.FACILITY_ID = B.FACILITY_ID AND A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND A.DOC_NO = B.DOC_NO AND A.FINALIZED_YN = 'N' AND A.DOC_TYPE_CODE = C.DOC_TYPE_CODE AND DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',A.TO_STORE_CODE,B.STORE_CODE) = D.STORE_CODE AND B.ITEM_CODE = E.ITEM_CODE AND A.TRN_TYPE = F.TRN_TYPE AND DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',A.TO_STORE_CODE,B.STORE_CODE) = G.STORE_CODE AND DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',B.TO_BIN_LOCATION_CODE,B.BIN_LOCATION_CODE) = G.BIN_LOCATION_CODE AND C.LANGUAGE_ID = D.LANGUAGE_ID AND C.LANGUAGE_ID = E.LANGUAGE_ID AND C.LANGUAGE_ID = F.LANGUAGE_ID AND C.LANGUAGE_ID = G.LANGUAGE_ID UNION SELECT 'N' PROCESS_FOR_ACKNOWLEDGE,A.FACILITY_ID, A.DOC_TYPE_CODE, A.DOC_NO, 0 SEQ_NO, A.TRN_TYPE,B.DOC_SRL_NO, B.STORE_CODE, B.ITEM_CODE, B.BATCH_ID, B.BIN_LOCATION_CODE, B.EXPIRY_DATE_OR_RECEIPT_DATE,B.ITEM_QTY BLOCKED_QTY, C.SHORT_DESC DOC_TYPE_DESC,D.SHORT_DESC STORE_DESC, E.SHORT_DESC ITEM_DESC,F.SHORT_DESC TRN_TYPE_DESC, G.SHORT_DESC BIN_DESC, A.DOC_DATE,C.LANGUAGE_ID FROM ST_ADJ_HDR A,ST_ADJ_DTL_EXP B,SY_DOC_TYPE_MASTER_LANG_VW C,MM_STORE_LANG_VW D,MM_ITEM_LANG_VW E,ST_TRN_TYPE_LANG_VW F,MM_BIN_LOCATION_LANG_VW G WHERE A.FACILITY_ID = B.FACILITY_ID AND A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND A.DOC_NO = B.DOC_NO AND A.FINALIZED_YN = 'N' AND A.DOC_TYPE_CODE = C.DOC_TYPE_CODE AND B.STORE_CODE = D.STORE_CODE AND B.ITEM_CODE = E.ITEM_CODE AND A.TRN_TYPE = F.TRN_TYPE AND B.STORE_CODE =  G.STORE_CODE AND B.BIN_LOCATION_CODE = G.BIN_LOCATION_CODE AND C.LANGUAGE_ID = D.LANGUAGE_ID AND C.LANGUAGE_ID = E.LANGUAGE_ID AND C.LANGUAGE_ID = F.LANGUAGE_ID AND C.LANGUAGE_ID = G.LANGUAGE_ID UNION SELECT 'N' PROCESS_FOR_ACKNOWLEDGE,A.FACILITY_ID, A.DOC_TYPE_CODE, A.DOC_NO, 0 SEQ_NO, A.TRN_TYPE, B.DOC_SRL_NO, B.STORE_CODE, B.ITEM_CODE, B.BATCH_ID,B.BIN_LOCATION_CODE, B.EXPIRY_DATE_OR_RECEIPT_DATE,B.ITEM_QTY BLOCKED_QTY, C.SHORT_DESC DOC_TYPE_DESC,D.SHORT_DESC STORE_DESC, E.SHORT_DESC ITEM_DESC,F.SHORT_DESC TRN_TYPE_DESC, G.SHORT_DESC BIN_DESC, A.DOC_DATE,C.LANGUAGE_ID FROM ST_RTV_HDR A, ST_RTV_DTL_EXP B, SY_DOC_TYPE_MASTER_LANG_VW C, MM_STORE_LANG_VW D, MM_ITEM_LANG_VW E, ST_TRN_TYPE_LANG_VW F, MM_BIN_LOCATION_LANG_VW G  WHERE A.FACILITY_ID = B.FACILITY_ID AND A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND A.DOC_NO = B.DOC_NO AND A.FINALIZED_YN = 'N' AND A.DOC_TYPE_CODE = C.DOC_TYPE_CODE AND B.STORE_CODE = D.STORE_CODE AND B.ITEM_CODE = E.ITEM_CODE AND A.TRN_TYPE = F.TRN_TYPE AND B.STORE_CODE = G.STORE_CODE AND B.BIN_LOCATION_CODE = G.BIN_LOCATION_CODE AND C.LANGUAGE_ID = D.LANGUAGE_ID AND C.LANGUAGE_ID = E.LANGUAGE_ID AND C.LANGUAGE_ID = F.LANGUAGE_ID AND C.LANGUAGE_ID = G.LANGUAGE_ID UNION SELECT 'N' PROCESS_FOR_ACKNOWLEDGE,A.FACILITY_ID, A.DOC_TYPE_CODE, A.DOC_NO, 0 SEQ_NO, A.TRN_TYPE,B.DOC_SRL_NO, B.STORE_CODE, B.ITEM_CODE, B.BATCH_ID,B.BIN_LOCATION_CODE, B.EXPIRY_DATE_OR_RECEIPT_DATE,B.SAL_ITEM_QTY BLOCKED_QTY, C.SHORT_DESC DOC_TYPE_DESC,D.SHORT_DESC STORE_DESC, E.SHORT_DESC ITEM_DESC,F.SHORT_DESC TRN_TYPE_DESC, G.SHORT_DESC BIN_DESC, A.DOC_DATE,C.LANGUAGE_ID FROM ST_SAL_HDR A,ST_SAL_DTL_EXP B,SY_DOC_TYPE_MASTER_LANG_VW C,MM_STORE_LANG_VW D,MM_ITEM_LANG_VW E,ST_TRN_TYPE_LANG_VW F,MM_BIN_LOCATION_LANG_VW G WHERE A.FACILITY_ID = B.FACILITY_ID AND A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND A.DOC_NO = B.DOC_NO AND A.FINALIZED_YN = 'N' AND A.DOC_TYPE_CODE = C.DOC_TYPE_CODE AND B.STORE_CODE = D.STORE_CODE AND B.ITEM_CODE = E.ITEM_CODE AND A.TRN_TYPE = F.TRN_TYPE AND B.STORE_CODE = G.STORE_CODE AND B.BIN_LOCATION_CODE = G.BIN_LOCATION_CODE AND C.LANGUAGE_ID = D.LANGUAGE_ID AND C.LANGUAGE_ID = E.LANGUAGE_ID AND C.LANGUAGE_ID = F.LANGUAGE_ID AND C.LANGUAGE_ID = G.LANGUAGE_ID UNION SELECT 'N' PROCESS_FOR_ACKNOWLEDGE,A.FACILITY_ID, A.DOC_TYPE_CODE, A.DOC_NO, 0 SEQ_NO, A.TRN_TYPE,B.DOC_SRL_NO, B.STORE_CODE, B.ITEM_CODE, B.BATCH_ID, B.BIN_LOCATION_CODE, B.EXPIRY_DATE_OR_RECEIPT_DATE,B.ITEM_QTY BLOCKED_QTY, C.SHORT_DESC DOC_TYPE_DESC,D.SHORT_DESC STORE_DESC, E.SHORT_DESC ITEM_DESC,F.SHORT_DESC TRN_TYPE_DESC, G.SHORT_DESC BIN_DESC, A.DOC_DATE,C.LANGUAGE_ID FROM ST_MFG_HDR A, ST_MFG_DTL_EXP B,SY_DOC_TYPE_MASTER_LANG_VW C,MM_STORE_LANG_VW D,MM_ITEM_LANG_VW E, ST_TRN_TYPE_LANG_VW F, MM_BIN_LOCATION_LANG_VW G WHERE A.FACILITY_ID = B.FACILITY_ID AND A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND A.DOC_NO = B.DOC_NO AND A.FINALIZED_YN = 'N' AND A.DOC_TYPE_CODE = C.DOC_TYPE_CODE AND B.STORE_CODE = D.STORE_CODE AND B.ITEM_CODE = E.ITEM_CODE AND A.TRN_TYPE = F.TRN_TYPE AND B.STORE_CODE = G.STORE_CODE AND B.BIN_LOCATION_CODE = G.BIN_LOCATION_CODE AND C.LANGUAGE_ID = D.LANGUAGE_ID AND C.LANGUAGE_ID = E.LANGUAGE_ID AND C.LANGUAGE_ID = F.LANGUAGE_ID AND C.LANGUAGE_ID = G.LANGUAGE_ID UNION SELECT 'N' PROCESS_FOR_ACKNOWLEDGE,A.FACILITY_ID, A.DOC_TYPE_CODE, A.DOC_NO, 0 SEQ_NO, A.TRN_TYPE, B.DOC_SRL_NO, B.STORE_CODE, B.ITEM_CODE, B.BATCH_ID,B.BIN_LOCATION_CODE, B.EXPIRY_DATE_OR_RECEIPT_DATE, B.GRN_ITEM_QTY BLOCKED_QTY, C.SHORT_DESC DOC_TYPE_DESC, D.SHORT_DESC STORE_DESC, E.SHORT_DESC ITEM_DESC, F.SHORT_DESC TRN_TYPE_DESC, G.SHORT_DESC BIN_DESC, A.DOC_DATE, C.LANGUAGE_ID FROM ST_GRN_HDR A, ST_GRN_DTL_EXP B, SY_DOC_TYPE_MASTER_LANG_VW C,MM_STORE_LANG_VW D, MM_ITEM_LANG_VW E, ST_TRN_TYPE_LANG_VW F, MM_BIN_LOCATION_LANG_VW G WHERE A.FACILITY_ID = B.FACILITY_ID AND A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND A.DOC_NO = B.DOC_NO AND A.FINALIZED_YN = 'N' AND A.DOC_TYPE_CODE = C.DOC_TYPE_CODE AND B.STORE_CODE = D.STORE_CODE AND B.ITEM_CODE = E.ITEM_CODE AND A.TRN_TYPE = F.TRN_TYPE AND B.STORE_CODE = G.STORE_CODE AND B.BIN_LOCATION_CODE = G.BIN_LOCATION_CODE AND C.LANGUAGE_ID = D.LANGUAGE_ID AND C.LANGUAGE_ID = E.LANGUAGE_ID AND C.LANGUAGE_ID = F.LANGUAGE_ID AND C.LANGUAGE_ID = G.LANGUAGE_ID UNION SELECT 'N' PROCESS_FOR_ACKNOWLEDGE,A.FACILITY_ID, A.DOC_TYPE_CODE, A.DOC_NO, 0 SEQ_NO, A.TRN_TYPE,B.DOC_SRL_NO, B.STORE_CODE, B.ITEM_CODE, B.BATCH_ID,B.BIN_LOCATION_CODE, B.EXPIRY_DATE_OR_RECEIPT_DATE,B.ITEM_QTY BLOCKED_QTY, C.SHORT_DESC DOC_TYPE_DESC,D.SHORT_DESC STORE_DESC, E.SHORT_DESC ITEM_DESC,F.SHORT_DESC TRN_TYPE_DESC, G.SHORT_DESC BIN_DESC, A.DOC_DATE,C.LANGUAGE_ID FROM ST_SAL_RET_HDR A,ST_SAL_RET_DTL_EXP B, SY_DOC_TYPE_MASTER_LANG_VW C,MM_STORE_LANG_VW D,MM_ITEM_LANG_VW E,ST_TRN_TYPE_LANG_VW F,MM_BIN_LOCATION_LANG_VW G WHERE A.FACILITY_ID = B.FACILITY_ID AND A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND A.DOC_NO = B.DOC_NO AND A.FINALIZED_YN = 'N' AND A.DOC_TYPE_CODE = C.DOC_TYPE_CODE AND B.STORE_CODE = D.STORE_CODE AND B.ITEM_CODE = E.ITEM_CODE AND A.TRN_TYPE = F.TRN_TYPE AND B.STORE_CODE = G.STORE_CODE AND B.BIN_LOCATION_CODE = G.BIN_LOCATION_CODE AND C.LANGUAGE_ID = D.LANGUAGE_ID AND C.LANGUAGE_ID = E.LANGUAGE_ID AND C.LANGUAGE_ID = F.LANGUAGE_ID AND C.LANGUAGE_ID = G.LANGUAGE_ID) WHERE LANGUAGE_ID = ? ) STBV, MM_ITEM_LANG_VW MM,AM_UOM_lang_vw AM,ST_ACKNOWLEDGE_TRN_DTL ACK WHERE STBV.FACILITY_ID = ? AND STBV.TRN_TYPE LIKE ? AND STBV.DOC_TYPE_CODE LIKE ? AND STBV.DOC_NO LIKE ? AND STBV.STORE_CODE LIKE UPPER (?) AND STBV.ITEM_CODE LIKE UPPER (?) AND STBV.BATCH_ID LIKE UPPER (?) AND (STBV.DOC_DATE BETWEEN TO_DATE (NVL (?, '01/01/1901'), 'DD/MM/YYYY') AND TO_DATE (NVL (?, '31/12/3012'), 'DD/MM/YYYY')) AND STBV.LANGUAGE_ID = ? AND STBV.LANGUAGE_ID = MM.LANGUAGE_ID and mm.language_id = am.language_id AND STBV.ITEM_CODE = MM.ITEM_CODE AND MM.GEN_UOM_CODE = AM.UOM_CODE AND STBV.DOC_NO = ACK.DOC_NO(+) AND STBV.DOC_TYPE_CODE = ACK.DOC_TYPE_CODE(+) AND STBV.BATCH_ID = ACK.BATCH_ID(+) AND STBV.EXPIRY_DATE_OR_RECEIPT_DATE = ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) AND STBV.SEQ_NO = ACK.SEQ_NO(+) AND STBV.ITEM_CODE = ACK.ITEM_CODE(+) AND (STBV.DOC_TYPE_CODE,STBV.DOC_NO) NOT IN(SELECT DOC_TYPE_CODE,DOC_NO FROM ST_ACKNOWLEDGE_TRN_DTL) UNION ALL SELECT A.DOC_TYPE_CODE, A.DOC_NO, A.SEQ_NO, A.TRN_TYPE, B.DOC_SRL_NO,A.RECEIVING_STORE, B.ITEM_CODE, B.BATCH_ID,B.NEW_BIN_LOCATION_CODE BIN_LOCATION_CODE,TO_CHAR(B.EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_DATE_OR_RECEIPT_DATE,(  B.ISSUE_QTY- (  B.RECEIVED_QTY+ B.REJECTED_QTY+ NVL(B.TMP_RECEIVED_QTY_2,0)+ NVL(B.TMP_REJECTED_QTY_2,0))) BLOCKED_QTY,C.SHORT_DESC DOC_TYPE_DESC, D.SHORT_DESC STORE_DESC,(CASE WHEN (  B.ISSUE_QTY - (  B.RECEIVED_QTY + B.REJECTED_QTY + NVL (B.TMP_RECEIVED_QTY_2, 0) ) > 0 ) THEN 'PA' ELSE 'NA' END ) ACK_STATUS, (CASE WHEN (NVL (B.TMP_REJECTED_QTY_2, 0)) > 0 THEN 'NA' ELSE 'NA' END ) ACK_STATUS2, E.SHORT_DESC ITEM_DESC, F.SHORT_DESC TRN_TYPE_DESC, G.SHORT_DESC BIN_DESC, TO_CHAR (A.DOC_DATE, 'DD/MM/YYYY') DOC_DATE,  AM.SHORT_DESC GEN_UOM_DESC FROM ST_ACKNOWLEDGE_TRN_HDR A, ST_ACKNOWLEDGE_TRN_DTL B, SY_DOC_TYPE_MASTER_LANG_VW C,  MM_STORE_LANG_VW D, MM_ITEM_LANG_VW E, ST_TRN_TYPE_LANG_VW F, MM_BIN_LOCATION_LANG_VW G, AM_UOM_lang_vw AM WHERE A.FACILITY_ID = ?  AND A.TRN_TYPE LIKE ? AND A.DOC_TYPE_CODE LIKE ? AND A.DOC_NO LIKE ? AND A.RECEIVING_STORE LIKE UPPER (?) AND B.ITEM_CODE LIKE UPPER (?) AND B.BATCH_ID LIKE UPPER (?) AND (A.DOC_DATE BETWEEN TO_DATE (NVL (?, '01/01/1901'), 'DD/MM/YYYY' ) AND TO_DATE (NVL (?, '31/12/3012'), 'DD/MM/YYYY' ) ) AND A.FACILITY_ID = B.FACILITY_ID AND A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND A.DOC_NO = B.DOC_NO AND A.SEQ_NO = B.SEQ_NO AND A.DOC_TYPE_CODE = C.DOC_TYPE_CODE AND A.RECEIVING_STORE = D.STORE_CODE AND B.ITEM_CODE = E.ITEM_CODE AND A.TRN_TYPE = F.TRN_TYPE AND B.NEW_BIN_LOCATION_CODE = G.BIN_LOCATION_CODE AND (B.ISSUE_QTY - (B.RECEIVED_QTY + B.REJECTED_QTY+B.TMP_RECEIVED_QTY_2+B.TMP_REJECTED_QTY_2)) > 0 AND D.STORE_CODE = G.STORE_CODE AND E.GEN_UOM_CODE = AM.UOM_CODE AND C.LANGUAGE_ID = ? AND D.LANGUAGE_ID = C.LANGUAGE_ID and d.language_id =am.language_id AND E.LANGUAGE_ID = C.LANGUAGE_ID AND F.LANGUAGE_ID = C.LANGUAGE_ID AND G.LANGUAGE_ID = C.LANGUAGE_ID UNION SELECT STBV.DOC_TYPE_CODE, STBV.DOC_NO, STBV.SEQ_NO, STBV.TRN_TYPE, STBV.DOC_SRL_NO, STBV.STORE_CODE, STBV.ITEM_CODE, STBV.BATCH_ID, STBV.BIN_LOCATION_CODE, TO_CHAR (STBV.EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY' ) EXPIRY_DATE_OR_RECEIPT_DATE, NVL(ACK.TMP_RECEIVED_QTY_2,0) + NVL(ACK.TMP_REJECTED_QTY_2,0) BLOCKED_QTY,  STBV.DOC_TYPE_DESC, STBV.STORE_DESC,'NA' ACK_STATUS,'CP' ACK_STATUS2, STBV.ITEM_DESC, STBV.TRN_TYPE_DESC, STBV.BIN_DESC,TO_CHAR (STBV.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, AM.SHORT_DESC GEN_UOM_DESC FROM ST_BLOCKED_BATCHES_LANG_VIEW STBV, MM_ITEM_LANG_VW MM, AM_UOM_lang_vw AM,ST_ACKNOWLEDGE_TRN_DTL ACK WHERE STBV.FACILITY_ID = ? AND STBV.TRN_TYPE LIKE ? AND STBV.DOC_TYPE_CODE LIKE ? AND STBV.DOC_NO LIKE ? AND STBV.STORE_CODE LIKE UPPER (?) AND STBV.ITEM_CODE LIKE UPPER (?) AND STBV.BATCH_ID LIKE UPPER (?) AND (STBV.DOC_DATE BETWEEN TO_DATE (NVL (?, '01/01/1901'), 'DD/MM/YYYY') AND TO_DATE (NVL (?, '31/12/3012'), 'DD/MM/YYYY') ) AND STBV.LANGUAGE_ID = ? AND STBV.LANGUAGE_ID = MM.LANGUAGE_ID and am.language_id=mm.language_id AND STBV.ITEM_CODE = MM.ITEM_CODE AND MM.GEN_UOM_CODE = AM.UOM_CODE AND STBV.DOC_NO = ACK.DOC_NO AND STBV.DOC_TYPE_CODE = ACK.DOC_TYPE_CODE AND STBV.BATCH_ID = ACK.BATCH_ID AND STBV.EXPIRY_DATE_OR_RECEIPT_DATE = ACK.EXPIRY_DATE_OR_RECEIPT_DATE AND (STBV.SEQ_NO = ACK.SEQ_NO OR STBV.SEQ_NO =0) AND STBV.ITEM_CODE = ACK.ITEM_CODE AND (NVL (ACK.TMP_REJECTED_QTY_2, 0) > 0 OR NVL (ACK.TMP_RECEIVED_QTY_2, 0) > 0)";
			
			//Added by Rabbani on 20/11/2012 to avoid performance issue in Query
			/*sql = "SELECT STBV.DOC_TYPE_CODE, STBV.DOC_NO, STBV.SEQ_NO, STBV.TRN_TYPE,STBV.DOC_SRL_NO, STBV.STORE_CODE, STBV.ITEM_CODE, STBV.BATCH_ID,STBV.BIN_LOCATION_CODE,TO_CHAR (STBV.EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_DATE_OR_RECEIPT_DATE,(CASE WHEN ACK.TMP_REJECTED_QTY_2 IS NULL THEN STBV.BLOCKED_QTY ELSE (NVL(ACK.TMP_RECEIVED_QTY_2,0) + NVL(ACK.TMP_REJECTED_QTY_2,0)) END ) BLOCKED_QTY,STBV.DOC_TYPE_DESC, STBV.STORE_DESC, (CASE WHEN STBV.PROCESS_FOR_ACKNOWLEDGE = 'Y' THEN 'PA' ELSE 'NA' END) ACK_STATUS,(CASE WHEN (NVL  (ACK.TMP_REJECTED_QTY_2, 0)) > 0 THEN 'CP' ELSE 'NA' END ) ACK_STATUS2, STBV.ITEM_DESC, STBV.TRN_TYPE_DESC, STBV.BIN_DESC, TO_CHAR (STBV.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, AM.SHORT_DESC GEN_UOM_DESC FROM (SELECT * FROM (SELECT A.PROCESS_FOR_ACKNOWLEDGE,DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',D.FACILITY_ID,A.FACILITY_ID) FACILITY_ID, A.DOC_TYPE_CODE, A.DOC_NO, A.SEQ_NO, A.TRN_TYPE,B.DOC_SRL_NO, DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',A.TO_STORE_CODE,B.STORE_CODE) STORE_CODE, B.ITEM_CODE, B.BATCH_ID,DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',B.TO_BIN_LOCATION_CODE,B.BIN_LOCATION_CODE) BIN_LOCATION_CODE, B.EXPIRY_DATE_OR_RECEIPT_DATE,B.ISS_ITEM_QTY BLOCKED_QTY, C.SHORT_DESC DOC_TYPE_DESC,D.SHORT_DESC STORE_DESC, E.SHORT_DESC ITEM_DESC,F.SHORT_DESC TRN_TYPE_DESC, G.SHORT_DESC BIN_DESC, A.DOC_DATE,C.LANGUAGE_ID FROM ST_ISSUE_HDR A, ST_ISSUE_DTL_EXP B, SY_DOC_TYPE_MASTER_LANG_VW C, MM_STORE_LANG_VW D, MM_ITEM_LANG_VW E, ST_TRN_TYPE_LANG_VW F, MM_BIN_LOCATION_LANG_VW G WHERE A.FACILITY_ID = B.FACILITY_ID AND A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND A.DOC_NO = B.DOC_NO AND A.SEQ_NO = B.SEQ_NO AND A.FINALIZED_YN = 'N' AND A.DOC_TYPE_CODE = C.DOC_TYPE_CODE AND DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',A.TO_STORE_CODE,B.STORE_CODE) = D.STORE_CODE AND B.ITEM_CODE = E.ITEM_CODE AND A.TRN_TYPE = F.TRN_TYPE AND DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',A.TO_STORE_CODE,B.STORE_CODE) = G.STORE_CODE AND DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',B.TO_BIN_LOCATION_CODE,B.BIN_LOCATION_CODE) = G.BIN_LOCATION_CODE AND C.LANGUAGE_ID = D.LANGUAGE_ID AND C.LANGUAGE_ID = E.LANGUAGE_ID AND C.LANGUAGE_ID = F.LANGUAGE_ID AND C.LANGUAGE_ID = G.LANGUAGE_ID UNION SELECT A.PROCESS_FOR_ACKNOWLEDGE,DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',D.FACILITY_ID,A.FACILITY_ID) FACILITY_ID, A.DOC_TYPE_CODE, A.DOC_NO, 0 SEQ_NO, A.TRN_TYPE, B.DOC_SRL_NO, DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',A.TO_STORE_CODE,B.STORE_CODE) STORE_CODE, B.ITEM_CODE, B.BATCH_ID,DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',B.TO_BIN_LOCATION_CODE,B.BIN_LOCATION_CODE) BIN_LOCATION_CODE, B.EXPIRY_DATE_OR_RECEIPT_DATE,B.ITEM_QTY BLOCKED_QTY, C.SHORT_DESC DOC_TYPE_DESC,D.SHORT_DESC STORE_DESC, E.SHORT_DESC ITEM_DESC,F.SHORT_DESC TRN_TYPE_DESC, G.SHORT_DESC BIN_DESC, A.DOC_DATE,C.LANGUAGE_ID FROM ST_ISSUE_RET_HDR A,ST_ISSUE_RET_DTL_EXP B, SY_DOC_TYPE_MASTER_LANG_VW C, MM_STORE_LANG_VW D, MM_ITEM_LANG_VW E,ST_TRN_TYPE_LANG_VW F,MM_BIN_LOCATION_LANG_VW G WHERE A.FACILITY_ID = B.FACILITY_ID AND A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND A.DOC_NO = B.DOC_NO AND A.FINALIZED_YN = 'N' AND A.DOC_TYPE_CODE = C.DOC_TYPE_CODE AND DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',A.TO_STORE_CODE,B.STORE_CODE) = D.STORE_CODE AND B.ITEM_CODE = E.ITEM_CODE AND A.TRN_TYPE = F.TRN_TYPE AND DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',A.TO_STORE_CODE,B.STORE_CODE) = G.STORE_CODE AND DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',B.TO_BIN_LOCATION_CODE,B.BIN_LOCATION_CODE) = G.BIN_LOCATION_CODE AND C.LANGUAGE_ID = D.LANGUAGE_ID AND C.LANGUAGE_ID = E.LANGUAGE_ID AND C.LANGUAGE_ID = F.LANGUAGE_ID AND C.LANGUAGE_ID = G.LANGUAGE_ID UNION SELECT A.PROCESS_FOR_ACKNOWLEDGE,DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',D.FACILITY_ID,A.FACILITY_ID) FACILITY_ID, A.DOC_TYPE_CODE, A.DOC_NO, 0 SEQ_NO, A.TRN_TYPE, B.DOC_SRL_NO, DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',A.TO_STORE_CODE,B.STORE_CODE) STORE_CODE, B.ITEM_CODE, B.BATCH_ID,DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',B.TO_BIN_LOCATION_CODE,B.BIN_LOCATION_CODE) BIN_LOCATION_CODE, B.EXPIRY_DATE_OR_RECEIPT_DATE,B.ITEM_QTY BLOCKED_QTY, C.SHORT_DESC DOC_TYPE_DESC,D.SHORT_DESC STORE_DESC, E.SHORT_DESC ITEM_DESC,F.SHORT_DESC TRN_TYPE_DESC, G.SHORT_DESC BIN_DESC, A.DOC_DATE,C.LANGUAGE_ID FROM ST_TRANSFER_HDR A,ST_TRANSFER_DTL_EXP B, SY_DOC_TYPE_MASTER_LANG_VW C,MM_STORE_LANG_VW D,MM_ITEM_LANG_VW E,ST_TRN_TYPE_LANG_VW F,MM_BIN_LOCATION_LANG_VW G WHERE A.FACILITY_ID = B.FACILITY_ID AND A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND A.DOC_NO = B.DOC_NO AND A.FINALIZED_YN = 'N' AND A.DOC_TYPE_CODE = C.DOC_TYPE_CODE AND DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',A.TO_STORE_CODE,B.STORE_CODE) = D.STORE_CODE AND B.ITEM_CODE = E.ITEM_CODE AND A.TRN_TYPE = F.TRN_TYPE AND DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',A.TO_STORE_CODE,B.STORE_CODE) = G.STORE_CODE AND DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',B.TO_BIN_LOCATION_CODE,B.BIN_LOCATION_CODE) = G.BIN_LOCATION_CODE AND C.LANGUAGE_ID = D.LANGUAGE_ID AND C.LANGUAGE_ID = E.LANGUAGE_ID AND C.LANGUAGE_ID = F.LANGUAGE_ID AND C.LANGUAGE_ID = G.LANGUAGE_ID UNION SELECT 'N' PROCESS_FOR_ACKNOWLEDGE,A.FACILITY_ID, A.DOC_TYPE_CODE, A.DOC_NO, 0 SEQ_NO, A.TRN_TYPE,B.DOC_SRL_NO, B.STORE_CODE, B.ITEM_CODE, B.BATCH_ID, B.BIN_LOCATION_CODE, B.EXPIRY_DATE_OR_RECEIPT_DATE,B.ITEM_QTY BLOCKED_QTY, C.SHORT_DESC DOC_TYPE_DESC,D.SHORT_DESC STORE_DESC, E.SHORT_DESC ITEM_DESC,F.SHORT_DESC TRN_TYPE_DESC, G.SHORT_DESC BIN_DESC, A.DOC_DATE,C.LANGUAGE_ID FROM ST_ADJ_HDR A,ST_ADJ_DTL_EXP B,SY_DOC_TYPE_MASTER_LANG_VW C,MM_STORE_LANG_VW D,MM_ITEM_LANG_VW E,ST_TRN_TYPE_LANG_VW F,MM_BIN_LOCATION_LANG_VW G WHERE A.FACILITY_ID = B.FACILITY_ID AND A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND A.DOC_NO = B.DOC_NO AND A.FINALIZED_YN = 'N' AND A.DOC_TYPE_CODE = C.DOC_TYPE_CODE AND B.STORE_CODE = D.STORE_CODE AND B.ITEM_CODE = E.ITEM_CODE AND A.TRN_TYPE = F.TRN_TYPE AND B.STORE_CODE =  G.STORE_CODE AND B.BIN_LOCATION_CODE = G.BIN_LOCATION_CODE AND C.LANGUAGE_ID = D.LANGUAGE_ID AND C.LANGUAGE_ID = E.LANGUAGE_ID AND C.LANGUAGE_ID = F.LANGUAGE_ID AND C.LANGUAGE_ID = G.LANGUAGE_ID UNION SELECT 'N' PROCESS_FOR_ACKNOWLEDGE,A.FACILITY_ID, A.DOC_TYPE_CODE, A.DOC_NO, 0 SEQ_NO, A.TRN_TYPE, B.DOC_SRL_NO, B.STORE_CODE, B.ITEM_CODE, B.BATCH_ID,B.BIN_LOCATION_CODE, B.EXPIRY_DATE_OR_RECEIPT_DATE,B.ITEM_QTY BLOCKED_QTY, C.SHORT_DESC DOC_TYPE_DESC,D.SHORT_DESC STORE_DESC, E.SHORT_DESC ITEM_DESC,F.SHORT_DESC TRN_TYPE_DESC, G.SHORT_DESC BIN_DESC, A.DOC_DATE,C.LANGUAGE_ID FROM ST_RTV_HDR A, ST_RTV_DTL_EXP B, SY_DOC_TYPE_MASTER_LANG_VW C, MM_STORE_LANG_VW D, MM_ITEM_LANG_VW E, ST_TRN_TYPE_LANG_VW F, MM_BIN_LOCATION_LANG_VW G  WHERE A.FACILITY_ID = B.FACILITY_ID AND A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND A.DOC_NO = B.DOC_NO AND A.FINALIZED_YN = 'N' AND A.DOC_TYPE_CODE = C.DOC_TYPE_CODE AND B.STORE_CODE = D.STORE_CODE AND B.ITEM_CODE = E.ITEM_CODE AND A.TRN_TYPE = F.TRN_TYPE AND B.STORE_CODE = G.STORE_CODE AND B.BIN_LOCATION_CODE = G.BIN_LOCATION_CODE AND C.LANGUAGE_ID = D.LANGUAGE_ID AND C.LANGUAGE_ID = E.LANGUAGE_ID AND C.LANGUAGE_ID = F.LANGUAGE_ID AND C.LANGUAGE_ID = G.LANGUAGE_ID UNION SELECT 'N' PROCESS_FOR_ACKNOWLEDGE,A.FACILITY_ID, A.DOC_TYPE_CODE, A.DOC_NO, 0 SEQ_NO, A.TRN_TYPE,B.DOC_SRL_NO, B.STORE_CODE, B.ITEM_CODE, B.BATCH_ID,B.BIN_LOCATION_CODE, B.EXPIRY_DATE_OR_RECEIPT_DATE,B.SAL_ITEM_QTY BLOCKED_QTY, C.SHORT_DESC DOC_TYPE_DESC,D.SHORT_DESC STORE_DESC, E.SHORT_DESC ITEM_DESC,F.SHORT_DESC TRN_TYPE_DESC, G.SHORT_DESC BIN_DESC, A.DOC_DATE,C.LANGUAGE_ID FROM ST_SAL_HDR A,ST_SAL_DTL_EXP B,SY_DOC_TYPE_MASTER_LANG_VW C,MM_STORE_LANG_VW D,MM_ITEM_LANG_VW E,ST_TRN_TYPE_LANG_VW F,MM_BIN_LOCATION_LANG_VW G WHERE A.FACILITY_ID = B.FACILITY_ID AND A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND A.DOC_NO = B.DOC_NO AND A.FINALIZED_YN = 'N' AND A.DOC_TYPE_CODE = C.DOC_TYPE_CODE AND B.STORE_CODE = D.STORE_CODE AND B.ITEM_CODE = E.ITEM_CODE AND A.TRN_TYPE = F.TRN_TYPE AND B.STORE_CODE = G.STORE_CODE AND B.BIN_LOCATION_CODE = G.BIN_LOCATION_CODE AND C.LANGUAGE_ID = D.LANGUAGE_ID AND C.LANGUAGE_ID = E.LANGUAGE_ID AND C.LANGUAGE_ID = F.LANGUAGE_ID AND C.LANGUAGE_ID = G.LANGUAGE_ID UNION SELECT 'N' PROCESS_FOR_ACKNOWLEDGE,A.FACILITY_ID, A.DOC_TYPE_CODE, A.DOC_NO, 0 SEQ_NO, A.TRN_TYPE,B.DOC_SRL_NO, B.STORE_CODE, B.ITEM_CODE, B.BATCH_ID, B.BIN_LOCATION_CODE, B.EXPIRY_DATE_OR_RECEIPT_DATE,B.ITEM_QTY BLOCKED_QTY, C.SHORT_DESC DOC_TYPE_DESC,D.SHORT_DESC STORE_DESC, E.SHORT_DESC ITEM_DESC,F.SHORT_DESC TRN_TYPE_DESC, G.SHORT_DESC BIN_DESC, A.DOC_DATE,C.LANGUAGE_ID FROM ST_MFG_HDR A, ST_MFG_DTL_EXP B,SY_DOC_TYPE_MASTER_LANG_VW C,MM_STORE_LANG_VW D,MM_ITEM_LANG_VW E, ST_TRN_TYPE_LANG_VW F, MM_BIN_LOCATION_LANG_VW G WHERE A.FACILITY_ID = B.FACILITY_ID AND A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND A.DOC_NO = B.DOC_NO AND A.FINALIZED_YN = 'N' AND A.DOC_TYPE_CODE = C.DOC_TYPE_CODE AND B.STORE_CODE = D.STORE_CODE AND B.ITEM_CODE = E.ITEM_CODE AND A.TRN_TYPE = F.TRN_TYPE AND B.STORE_CODE = G.STORE_CODE AND B.BIN_LOCATION_CODE = G.BIN_LOCATION_CODE AND C.LANGUAGE_ID = D.LANGUAGE_ID AND C.LANGUAGE_ID = E.LANGUAGE_ID AND C.LANGUAGE_ID = F.LANGUAGE_ID AND C.LANGUAGE_ID = G.LANGUAGE_ID UNION SELECT 'N' PROCESS_FOR_ACKNOWLEDGE,A.FACILITY_ID, A.DOC_TYPE_CODE, A.DOC_NO, 0 SEQ_NO, A.TRN_TYPE, B.DOC_SRL_NO, B.STORE_CODE, B.ITEM_CODE, B.BATCH_ID,B.BIN_LOCATION_CODE, B.EXPIRY_DATE_OR_RECEIPT_DATE, B.GRN_ITEM_QTY BLOCKED_QTY, C.SHORT_DESC DOC_TYPE_DESC, D.SHORT_DESC STORE_DESC, E.SHORT_DESC ITEM_DESC, F.SHORT_DESC TRN_TYPE_DESC, G.SHORT_DESC BIN_DESC, A.DOC_DATE, C.LANGUAGE_ID FROM ST_GRN_HDR A, ST_GRN_DTL_EXP B, SY_DOC_TYPE_MASTER_LANG_VW C,MM_STORE_LANG_VW D, MM_ITEM_LANG_VW E, ST_TRN_TYPE_LANG_VW F, MM_BIN_LOCATION_LANG_VW G WHERE A.FACILITY_ID = B.FACILITY_ID AND A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND A.DOC_NO = B.DOC_NO AND A.FINALIZED_YN = 'N' AND A.DOC_TYPE_CODE = C.DOC_TYPE_CODE AND B.STORE_CODE = D.STORE_CODE AND B.ITEM_CODE = E.ITEM_CODE AND A.TRN_TYPE = F.TRN_TYPE AND B.STORE_CODE = G.STORE_CODE AND B.BIN_LOCATION_CODE = G.BIN_LOCATION_CODE AND C.LANGUAGE_ID = D.LANGUAGE_ID AND C.LANGUAGE_ID = E.LANGUAGE_ID AND C.LANGUAGE_ID = F.LANGUAGE_ID AND C.LANGUAGE_ID = G.LANGUAGE_ID UNION SELECT 'N' PROCESS_FOR_ACKNOWLEDGE,A.FACILITY_ID, A.DOC_TYPE_CODE, A.DOC_NO, 0 SEQ_NO, A.TRN_TYPE,B.DOC_SRL_NO, B.STORE_CODE, B.ITEM_CODE, B.BATCH_ID,B.BIN_LOCATION_CODE, B.EXPIRY_DATE_OR_RECEIPT_DATE,B.ITEM_QTY BLOCKED_QTY, C.SHORT_DESC DOC_TYPE_DESC,D.SHORT_DESC STORE_DESC, E.SHORT_DESC ITEM_DESC,F.SHORT_DESC TRN_TYPE_DESC, G.SHORT_DESC BIN_DESC, A.DOC_DATE,C.LANGUAGE_ID FROM ST_SAL_RET_HDR A,ST_SAL_RET_DTL_EXP B, SY_DOC_TYPE_MASTER_LANG_VW C,MM_STORE_LANG_VW D,MM_ITEM_LANG_VW E,ST_TRN_TYPE_LANG_VW F,MM_BIN_LOCATION_LANG_VW G WHERE A.FACILITY_ID = B.FACILITY_ID AND A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND A.DOC_NO = B.DOC_NO AND A.FINALIZED_YN = 'N' AND A.DOC_TYPE_CODE = C.DOC_TYPE_CODE AND B.STORE_CODE = D.STORE_CODE AND B.ITEM_CODE = E.ITEM_CODE AND A.TRN_TYPE = F.TRN_TYPE AND B.STORE_CODE = G.STORE_CODE AND B.BIN_LOCATION_CODE = G.BIN_LOCATION_CODE AND C.LANGUAGE_ID = D.LANGUAGE_ID AND C.LANGUAGE_ID = E.LANGUAGE_ID AND C.LANGUAGE_ID = F.LANGUAGE_ID AND C.LANGUAGE_ID = G.LANGUAGE_ID) WHERE LANGUAGE_ID = ? ) STBV, MM_ITEM_LANG_VW MM,AM_UOM_lang_vw AM,ST_ACKNOWLEDGE_TRN_DTL ACK WHERE STBV.FACILITY_ID = ? AND STBV.TRN_TYPE LIKE ? AND STBV.DOC_TYPE_CODE LIKE ? AND STBV.DOC_NO LIKE ? AND STBV.STORE_CODE LIKE UPPER (?) AND STBV.ITEM_CODE LIKE UPPER (?) AND STBV.BATCH_ID LIKE UPPER (?) AND (STBV.DOC_DATE BETWEEN TO_DATE (NVL (?, '01/01/1901'), 'DD/MM/YYYY') AND TO_DATE (NVL (?, TO_CHAR(sysdate,'DD/MM/YYYY')), 'DD/MM/YYYY')) AND STBV.LANGUAGE_ID = ? AND STBV.LANGUAGE_ID = MM.LANGUAGE_ID and mm.language_id = am.language_id AND STBV.ITEM_CODE = MM.ITEM_CODE AND MM.GEN_UOM_CODE = AM.UOM_CODE AND STBV.DOC_NO = ACK.DOC_NO(+) AND STBV.DOC_TYPE_CODE = ACK.DOC_TYPE_CODE(+) AND STBV.BATCH_ID = ACK.BATCH_ID(+) AND STBV.EXPIRY_DATE_OR_RECEIPT_DATE = ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) AND STBV.SEQ_NO = ACK.SEQ_NO(+) AND STBV.ITEM_CODE = ACK.ITEM_CODE(+) AND (STBV.DOC_TYPE_CODE,STBV.DOC_NO) NOT IN(SELECT DOC_TYPE_CODE,DOC_NO FROM ST_ACKNOWLEDGE_TRN_DTL) UNION ALL SELECT A.DOC_TYPE_CODE, A.DOC_NO, A.SEQ_NO, A.TRN_TYPE, B.DOC_SRL_NO,A.RECEIVING_STORE, B.ITEM_CODE, B.BATCH_ID,B.NEW_BIN_LOCATION_CODE BIN_LOCATION_CODE,TO_CHAR(B.EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_DATE_OR_RECEIPT_DATE,(  B.ISSUE_QTY- (  B.RECEIVED_QTY+ B.REJECTED_QTY+ NVL(B.TMP_RECEIVED_QTY_2,0)+ NVL(B.TMP_REJECTED_QTY_2,0))) BLOCKED_QTY,C.SHORT_DESC DOC_TYPE_DESC, D.SHORT_DESC STORE_DESC,(CASE WHEN (  B.ISSUE_QTY - (  B.RECEIVED_QTY + B.REJECTED_QTY + NVL (B.TMP_RECEIVED_QTY_2, 0) ) > 0 ) THEN 'PA' ELSE 'NA' END ) ACK_STATUS, (CASE WHEN (NVL (B.TMP_REJECTED_QTY_2, 0)) > 0 THEN 'NA' ELSE 'NA' END ) ACK_STATUS2, E.SHORT_DESC ITEM_DESC, F.SHORT_DESC TRN_TYPE_DESC, G.SHORT_DESC BIN_DESC, TO_CHAR (A.DOC_DATE, 'DD/MM/YYYY') DOC_DATE,  AM.SHORT_DESC GEN_UOM_DESC FROM ST_ACKNOWLEDGE_TRN_HDR A, ST_ACKNOWLEDGE_TRN_DTL B, SY_DOC_TYPE_MASTER_LANG_VW C,  MM_STORE_LANG_VW D, MM_ITEM_LANG_VW E, ST_TRN_TYPE_LANG_VW F, MM_BIN_LOCATION_LANG_VW G, AM_UOM_lang_vw AM WHERE A.FACILITY_ID = ?  AND A.TRN_TYPE LIKE ? AND A.DOC_TYPE_CODE LIKE ? AND A.DOC_NO LIKE ? AND A.RECEIVING_STORE LIKE UPPER (?) AND B.ITEM_CODE LIKE UPPER (?) AND B.BATCH_ID LIKE UPPER (?) AND (A.DOC_DATE BETWEEN TO_DATE (NVL (?, '01/01/1901'), 'DD/MM/YYYY' ) AND TO_DATE (NVL (?,TO_CHAR(sysdate,'DD/MM/YYYY')), 'DD/MM/YYYY' ) ) AND A.FACILITY_ID = B.FACILITY_ID AND A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND A.DOC_NO = B.DOC_NO AND A.SEQ_NO = B.SEQ_NO AND A.DOC_TYPE_CODE = C.DOC_TYPE_CODE AND A.RECEIVING_STORE = D.STORE_CODE AND B.ITEM_CODE = E.ITEM_CODE AND A.TRN_TYPE = F.TRN_TYPE AND B.NEW_BIN_LOCATION_CODE = G.BIN_LOCATION_CODE AND (B.ISSUE_QTY - (B.RECEIVED_QTY + B.REJECTED_QTY+B.TMP_RECEIVED_QTY_2+B.TMP_REJECTED_QTY_2)) > 0 AND D.STORE_CODE = G.STORE_CODE AND E.GEN_UOM_CODE = AM.UOM_CODE AND C.LANGUAGE_ID = ? AND D.LANGUAGE_ID = C.LANGUAGE_ID and d.language_id =am.language_id AND E.LANGUAGE_ID = C.LANGUAGE_ID AND F.LANGUAGE_ID = C.LANGUAGE_ID AND G.LANGUAGE_ID = C.LANGUAGE_ID UNION SELECT STBV.DOC_TYPE_CODE, STBV.DOC_NO, STBV.SEQ_NO, STBV.TRN_TYPE, STBV.DOC_SRL_NO, STBV.STORE_CODE, STBV.ITEM_CODE, STBV.BATCH_ID, STBV.BIN_LOCATION_CODE, TO_CHAR (STBV.EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY' ) EXPIRY_DATE_OR_RECEIPT_DATE, NVL(ACK.TMP_RECEIVED_QTY_2,0) + NVL(ACK.TMP_REJECTED_QTY_2,0) BLOCKED_QTY,  STBV.DOC_TYPE_DESC, STBV.STORE_DESC,'NA' ACK_STATUS,'CP' ACK_STATUS2, STBV.ITEM_DESC, STBV.TRN_TYPE_DESC, STBV.BIN_DESC,TO_CHAR (STBV.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, AM.SHORT_DESC GEN_UOM_DESC FROM ST_BLOCKED_BATCHES_LANG_VIEW STBV, MM_ITEM_LANG_VW MM, AM_UOM_lang_vw AM,ST_ACKNOWLEDGE_TRN_DTL ACK WHERE STBV.FACILITY_ID = ? AND STBV.TRN_TYPE LIKE ? AND STBV.DOC_TYPE_CODE LIKE ? AND STBV.DOC_NO LIKE ? AND STBV.STORE_CODE LIKE UPPER (?) AND STBV.ITEM_CODE LIKE UPPER (?) AND STBV.BATCH_ID LIKE UPPER (?) AND (STBV.DOC_DATE BETWEEN TO_DATE (NVL (?, '01/01/1901'), 'DD/MM/YYYY') AND TO_DATE (NVL (?, TO_CHAR(sysdate,'DD/MM/YYYY')), 'DD/MM/YYYY') ) AND STBV.LANGUAGE_ID = ? AND STBV.LANGUAGE_ID = MM.LANGUAGE_ID and am.language_id=mm.language_id AND STBV.ITEM_CODE = MM.ITEM_CODE AND MM.GEN_UOM_CODE = AM.UOM_CODE AND STBV.DOC_NO = ACK.DOC_NO AND STBV.DOC_TYPE_CODE = ACK.DOC_TYPE_CODE AND STBV.BATCH_ID = ACK.BATCH_ID AND STBV.EXPIRY_DATE_OR_RECEIPT_DATE = ACK.EXPIRY_DATE_OR_RECEIPT_DATE AND (STBV.SEQ_NO = ACK.SEQ_NO OR STBV.SEQ_NO =0) AND STBV.ITEM_CODE = ACK.ITEM_CODE AND (NVL (ACK.TMP_REJECTED_QTY_2, 0) > 0 OR NVL (ACK.TMP_RECEIVED_QTY_2, 0) > 0)";
			if(trn_type.equals("ACK")){
				sql = sql.replace("TRN_TYPE LIKE ?","TRN_TYPE IN ('URG','ISS','TFR','RET')");
			}*/
			//Above code is commented by Ganga on Friday, March 08, 2013 for Medicity

            //commented by Rabbani #inc no:44104(ML-BRU-SCF-1084) on 11-OCT-2013
			//sql = "SELECT STBV.DOC_TYPE_CODE, STBV.DOC_NO, STBV.SEQ_NO, STBV.TRN_TYPE,STBV.DOC_SRL_NO, STBV.STORE_CODE, STBV.ITEM_CODE, STBV.BATCH_ID,STBV.BIN_LOCATION_CODE,TO_CHAR (STBV.EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_DATE_OR_RECEIPT_DATE,(CASE WHEN ACK.TMP_REJECTED_QTY_2 IS NULL THEN STBV.BLOCKED_QTY ELSE (NVL(ACK.TMP_RECEIVED_QTY_2,0) + NVL(ACK.TMP_REJECTED_QTY_2,0)) END ) BLOCKED_QTY,STBV.DOC_TYPE_DESC, STBV.STORE_DESC, (CASE WHEN STBV.PROCESS_FOR_ACKNOWLEDGE = 'Y' THEN 'PA' ELSE 'NA' END) ACK_STATUS,(CASE WHEN (NVL  (ACK.TMP_REJECTED_QTY_2, 0)) > 0 THEN 'CP' ELSE 'NA' END ) ACK_STATUS2, STBV.ITEM_DESC, STBV.TRN_TYPE_DESC, STBV.BIN_DESC, TO_CHAR (STBV.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, AM.SHORT_DESC GEN_UOM_DESC FROM (SELECT * FROM (SELECT A.PROCESS_FOR_ACKNOWLEDGE,DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',D.FACILITY_ID,A.FACILITY_ID) FACILITY_ID, A.DOC_TYPE_CODE, A.DOC_NO, A.SEQ_NO, A.TRN_TYPE,B.DOC_SRL_NO, DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',A.TO_STORE_CODE,B.STORE_CODE) STORE_CODE, B.ITEM_CODE, B.BATCH_ID,DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',B.TO_BIN_LOCATION_CODE,B.BIN_LOCATION_CODE) BIN_LOCATION_CODE, B.EXPIRY_DATE_OR_RECEIPT_DATE,B.ISS_ITEM_QTY BLOCKED_QTY, C.SHORT_DESC DOC_TYPE_DESC,D.SHORT_DESC STORE_DESC, E.SHORT_DESC ITEM_DESC,F.SHORT_DESC TRN_TYPE_DESC, G.SHORT_DESC BIN_DESC, A.DOC_DATE,C.LANGUAGE_ID FROM ST_ISSUE_HDR A, ST_ISSUE_DTL_EXP B, SY_DOC_TYPE_MASTER_LANG_VW C, MM_STORE_LANG_VW D, MM_ITEM_LANG_VW E, ST_TRN_TYPE_LANG_VW F, MM_BIN_LOCATION_LANG_VW G WHERE A.FACILITY_ID = B.FACILITY_ID AND A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND A.DOC_NO = B.DOC_NO AND A.SEQ_NO = B.SEQ_NO AND A.FINALIZED_YN = 'N' AND A.DOC_TYPE_CODE = C.DOC_TYPE_CODE AND DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',A.TO_STORE_CODE,B.STORE_CODE) = D.STORE_CODE AND B.ITEM_CODE = E.ITEM_CODE AND A.TRN_TYPE = F.TRN_TYPE AND DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',A.TO_STORE_CODE,B.STORE_CODE) = G.STORE_CODE AND DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',B.TO_BIN_LOCATION_CODE,B.BIN_LOCATION_CODE) = G.BIN_LOCATION_CODE AND C.LANGUAGE_ID = D.LANGUAGE_ID AND C.LANGUAGE_ID = E.LANGUAGE_ID AND C.LANGUAGE_ID = F.LANGUAGE_ID AND C.LANGUAGE_ID = G.LANGUAGE_ID UNION SELECT A.PROCESS_FOR_ACKNOWLEDGE,DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',D.FACILITY_ID,A.FACILITY_ID) FACILITY_ID, A.DOC_TYPE_CODE, A.DOC_NO, 0 SEQ_NO, A.TRN_TYPE, B.DOC_SRL_NO, DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',A.TO_STORE_CODE,B.STORE_CODE) STORE_CODE, B.ITEM_CODE, B.BATCH_ID,DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',B.TO_BIN_LOCATION_CODE,B.BIN_LOCATION_CODE) BIN_LOCATION_CODE, B.EXPIRY_DATE_OR_RECEIPT_DATE,B.ITEM_QTY BLOCKED_QTY, C.SHORT_DESC DOC_TYPE_DESC,D.SHORT_DESC STORE_DESC, E.SHORT_DESC ITEM_DESC,F.SHORT_DESC TRN_TYPE_DESC, G.SHORT_DESC BIN_DESC, A.DOC_DATE,C.LANGUAGE_ID FROM ST_ISSUE_RET_HDR A,ST_ISSUE_RET_DTL_EXP B, SY_DOC_TYPE_MASTER_LANG_VW C, MM_STORE_LANG_VW D, MM_ITEM_LANG_VW E,ST_TRN_TYPE_LANG_VW F,MM_BIN_LOCATION_LANG_VW G WHERE A.FACILITY_ID = B.FACILITY_ID AND A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND A.DOC_NO = B.DOC_NO AND A.FINALIZED_YN = 'N' AND A.DOC_TYPE_CODE = C.DOC_TYPE_CODE AND DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',A.TO_STORE_CODE,B.STORE_CODE) = D.STORE_CODE AND B.ITEM_CODE = E.ITEM_CODE AND A.TRN_TYPE = F.TRN_TYPE AND DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',A.TO_STORE_CODE,B.STORE_CODE) = G.STORE_CODE AND DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',B.TO_BIN_LOCATION_CODE,B.BIN_LOCATION_CODE) = G.BIN_LOCATION_CODE AND C.LANGUAGE_ID = D.LANGUAGE_ID AND C.LANGUAGE_ID = E.LANGUAGE_ID AND C.LANGUAGE_ID = F.LANGUAGE_ID AND C.LANGUAGE_ID = G.LANGUAGE_ID UNION SELECT A.PROCESS_FOR_ACKNOWLEDGE,DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',D.FACILITY_ID,A.FACILITY_ID) FACILITY_ID, A.DOC_TYPE_CODE, A.DOC_NO, 0 SEQ_NO, A.TRN_TYPE, B.DOC_SRL_NO, DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',A.TO_STORE_CODE,B.STORE_CODE) STORE_CODE, B.ITEM_CODE, B.BATCH_ID,DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',B.TO_BIN_LOCATION_CODE,B.BIN_LOCATION_CODE) BIN_LOCATION_CODE, B.EXPIRY_DATE_OR_RECEIPT_DATE,B.ITEM_QTY BLOCKED_QTY, C.SHORT_DESC DOC_TYPE_DESC,D.SHORT_DESC STORE_DESC, E.SHORT_DESC ITEM_DESC,F.SHORT_DESC TRN_TYPE_DESC, G.SHORT_DESC BIN_DESC, A.DOC_DATE,C.LANGUAGE_ID FROM ST_TRANSFER_HDR A,ST_TRANSFER_DTL_EXP B, SY_DOC_TYPE_MASTER_LANG_VW C,MM_STORE_LANG_VW D,MM_ITEM_LANG_VW E,ST_TRN_TYPE_LANG_VW F,MM_BIN_LOCATION_LANG_VW G WHERE A.FACILITY_ID = B.FACILITY_ID AND A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND A.DOC_NO = B.DOC_NO AND A.FINALIZED_YN = 'N' AND A.DOC_TYPE_CODE = C.DOC_TYPE_CODE AND DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',A.TO_STORE_CODE,B.STORE_CODE) = D.STORE_CODE AND B.ITEM_CODE = E.ITEM_CODE AND A.TRN_TYPE = F.TRN_TYPE AND DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',A.TO_STORE_CODE,B.STORE_CODE) = G.STORE_CODE AND DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',B.TO_BIN_LOCATION_CODE,B.BIN_LOCATION_CODE) = G.BIN_LOCATION_CODE AND C.LANGUAGE_ID = D.LANGUAGE_ID AND C.LANGUAGE_ID = E.LANGUAGE_ID AND C.LANGUAGE_ID = F.LANGUAGE_ID AND C.LANGUAGE_ID = G.LANGUAGE_ID UNION SELECT 'N' PROCESS_FOR_ACKNOWLEDGE,A.FACILITY_ID, A.DOC_TYPE_CODE, A.DOC_NO, 0 SEQ_NO, A.TRN_TYPE,B.DOC_SRL_NO, B.STORE_CODE, B.ITEM_CODE, B.BATCH_ID, B.BIN_LOCATION_CODE, B.EXPIRY_DATE_OR_RECEIPT_DATE,B.ITEM_QTY BLOCKED_QTY, C.SHORT_DESC DOC_TYPE_DESC,D.SHORT_DESC STORE_DESC, E.SHORT_DESC ITEM_DESC,F.SHORT_DESC TRN_TYPE_DESC, G.SHORT_DESC BIN_DESC, A.DOC_DATE,C.LANGUAGE_ID FROM ST_ADJ_HDR A,ST_ADJ_DTL_EXP B,SY_DOC_TYPE_MASTER_LANG_VW C,MM_STORE_LANG_VW D,MM_ITEM_LANG_VW E,ST_TRN_TYPE_LANG_VW F,MM_BIN_LOCATION_LANG_VW G WHERE A.FACILITY_ID = B.FACILITY_ID AND A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND A.DOC_NO = B.DOC_NO AND A.FINALIZED_YN = 'N' AND A.DOC_TYPE_CODE = C.DOC_TYPE_CODE AND B.STORE_CODE = D.STORE_CODE AND B.ITEM_CODE = E.ITEM_CODE AND A.TRN_TYPE = F.TRN_TYPE AND B.STORE_CODE =  G.STORE_CODE AND B.BIN_LOCATION_CODE = G.BIN_LOCATION_CODE AND C.LANGUAGE_ID = D.LANGUAGE_ID AND C.LANGUAGE_ID = E.LANGUAGE_ID AND C.LANGUAGE_ID = F.LANGUAGE_ID AND C.LANGUAGE_ID = G.LANGUAGE_ID UNION SELECT 'N' PROCESS_FOR_ACKNOWLEDGE,A.FACILITY_ID, A.DOC_TYPE_CODE, A.DOC_NO, 0 SEQ_NO, A.TRN_TYPE, B.DOC_SRL_NO, B.STORE_CODE, B.ITEM_CODE, B.BATCH_ID,B.BIN_LOCATION_CODE, B.EXPIRY_DATE_OR_RECEIPT_DATE,B.ITEM_QTY BLOCKED_QTY, C.SHORT_DESC DOC_TYPE_DESC,D.SHORT_DESC STORE_DESC, E.SHORT_DESC ITEM_DESC,F.SHORT_DESC TRN_TYPE_DESC, G.SHORT_DESC BIN_DESC, A.DOC_DATE,C.LANGUAGE_ID FROM ST_RTV_HDR A, ST_RTV_DTL_EXP B, SY_DOC_TYPE_MASTER_LANG_VW C, MM_STORE_LANG_VW D, MM_ITEM_LANG_VW E, ST_TRN_TYPE_LANG_VW F, MM_BIN_LOCATION_LANG_VW G  WHERE A.FACILITY_ID = B.FACILITY_ID AND A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND A.DOC_NO = B.DOC_NO AND A.FINALIZED_YN = 'N' AND A.DOC_TYPE_CODE = C.DOC_TYPE_CODE AND B.STORE_CODE = D.STORE_CODE AND B.ITEM_CODE = E.ITEM_CODE AND A.TRN_TYPE = F.TRN_TYPE AND B.STORE_CODE = G.STORE_CODE AND B.BIN_LOCATION_CODE = G.BIN_LOCATION_CODE AND C.LANGUAGE_ID = D.LANGUAGE_ID AND C.LANGUAGE_ID = E.LANGUAGE_ID AND C.LANGUAGE_ID = F.LANGUAGE_ID AND C.LANGUAGE_ID = G.LANGUAGE_ID UNION SELECT 'N' PROCESS_FOR_ACKNOWLEDGE,A.FACILITY_ID, A.DOC_TYPE_CODE, A.DOC_NO, 0 SEQ_NO, A.TRN_TYPE,B.DOC_SRL_NO, B.STORE_CODE, B.ITEM_CODE, B.BATCH_ID,B.BIN_LOCATION_CODE, B.EXPIRY_DATE_OR_RECEIPT_DATE,B.SAL_ITEM_QTY BLOCKED_QTY, C.SHORT_DESC DOC_TYPE_DESC,D.SHORT_DESC STORE_DESC, E.SHORT_DESC ITEM_DESC,F.SHORT_DESC TRN_TYPE_DESC, G.SHORT_DESC BIN_DESC, A.DOC_DATE,C.LANGUAGE_ID FROM ST_SAL_HDR A,ST_SAL_DTL_EXP B,SY_DOC_TYPE_MASTER_LANG_VW C,MM_STORE_LANG_VW D,MM_ITEM_LANG_VW E,ST_TRN_TYPE_LANG_VW F,MM_BIN_LOCATION_LANG_VW G WHERE A.FACILITY_ID = B.FACILITY_ID AND A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND A.DOC_NO = B.DOC_NO AND A.FINALIZED_YN = 'N' AND A.DOC_TYPE_CODE = C.DOC_TYPE_CODE AND B.STORE_CODE = D.STORE_CODE AND B.ITEM_CODE = E.ITEM_CODE AND A.TRN_TYPE = F.TRN_TYPE AND B.STORE_CODE = G.STORE_CODE AND B.BIN_LOCATION_CODE = G.BIN_LOCATION_CODE AND C.LANGUAGE_ID = D.LANGUAGE_ID AND C.LANGUAGE_ID = E.LANGUAGE_ID AND C.LANGUAGE_ID = F.LANGUAGE_ID AND C.LANGUAGE_ID = G.LANGUAGE_ID UNION SELECT 'N' PROCESS_FOR_ACKNOWLEDGE,A.FACILITY_ID, A.DOC_TYPE_CODE, A.DOC_NO, 0 SEQ_NO, A.TRN_TYPE,B.DOC_SRL_NO, B.STORE_CODE, B.ITEM_CODE, B.BATCH_ID, B.BIN_LOCATION_CODE, B.EXPIRY_DATE_OR_RECEIPT_DATE,B.ITEM_QTY BLOCKED_QTY, C.SHORT_DESC DOC_TYPE_DESC,D.SHORT_DESC STORE_DESC, E.SHORT_DESC ITEM_DESC,F.SHORT_DESC TRN_TYPE_DESC, G.SHORT_DESC BIN_DESC, A.DOC_DATE,C.LANGUAGE_ID FROM ST_MFG_HDR A, ST_MFG_DTL_EXP B,SY_DOC_TYPE_MASTER_LANG_VW C,MM_STORE_LANG_VW D,MM_ITEM_LANG_VW E, ST_TRN_TYPE_LANG_VW F, MM_BIN_LOCATION_LANG_VW G WHERE A.FACILITY_ID = B.FACILITY_ID AND A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND A.DOC_NO = B.DOC_NO AND A.FINALIZED_YN = 'N' AND A.DOC_TYPE_CODE = C.DOC_TYPE_CODE AND B.STORE_CODE = D.STORE_CODE AND B.ITEM_CODE = E.ITEM_CODE AND A.TRN_TYPE = F.TRN_TYPE AND B.STORE_CODE = G.STORE_CODE AND B.BIN_LOCATION_CODE = G.BIN_LOCATION_CODE AND C.LANGUAGE_ID = D.LANGUAGE_ID AND C.LANGUAGE_ID = E.LANGUAGE_ID AND C.LANGUAGE_ID = F.LANGUAGE_ID AND C.LANGUAGE_ID = G.LANGUAGE_ID UNION SELECT 'N' PROCESS_FOR_ACKNOWLEDGE,A.FACILITY_ID, A.DOC_TYPE_CODE, A.DOC_NO, 0 SEQ_NO, A.TRN_TYPE, B.DOC_SRL_NO, B.STORE_CODE, B.ITEM_CODE, B.BATCH_ID,B.BIN_LOCATION_CODE, B.EXPIRY_DATE_OR_RECEIPT_DATE, B.GRN_ITEM_QTY BLOCKED_QTY, C.SHORT_DESC DOC_TYPE_DESC, D.SHORT_DESC STORE_DESC, E.SHORT_DESC ITEM_DESC, F.SHORT_DESC TRN_TYPE_DESC, G.SHORT_DESC BIN_DESC, A.DOC_DATE, C.LANGUAGE_ID FROM ST_GRN_HDR A, ST_GRN_DTL_EXP B, SY_DOC_TYPE_MASTER_LANG_VW C,MM_STORE_LANG_VW D, MM_ITEM_LANG_VW E, ST_TRN_TYPE_LANG_VW F, MM_BIN_LOCATION_LANG_VW G WHERE A.FACILITY_ID = B.FACILITY_ID AND A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND A.DOC_NO = B.DOC_NO AND A.FINALIZED_YN = 'N' AND A.DOC_TYPE_CODE = C.DOC_TYPE_CODE AND B.STORE_CODE = D.STORE_CODE AND B.ITEM_CODE = E.ITEM_CODE AND A.TRN_TYPE = F.TRN_TYPE AND B.STORE_CODE = G.STORE_CODE AND B.BIN_LOCATION_CODE = G.BIN_LOCATION_CODE AND C.LANGUAGE_ID = D.LANGUAGE_ID AND C.LANGUAGE_ID = E.LANGUAGE_ID AND C.LANGUAGE_ID = F.LANGUAGE_ID AND C.LANGUAGE_ID = G.LANGUAGE_ID UNION SELECT 'N' PROCESS_FOR_ACKNOWLEDGE,A.FACILITY_ID, A.DOC_TYPE_CODE, A.DOC_NO, 0 SEQ_NO, A.TRN_TYPE,B.DOC_SRL_NO, B.STORE_CODE, B.ITEM_CODE, B.BATCH_ID,B.BIN_LOCATION_CODE, B.EXPIRY_DATE_OR_RECEIPT_DATE,B.ITEM_QTY BLOCKED_QTY, C.SHORT_DESC DOC_TYPE_DESC,D.SHORT_DESC STORE_DESC, E.SHORT_DESC ITEM_DESC,F.SHORT_DESC TRN_TYPE_DESC, G.SHORT_DESC BIN_DESC, A.DOC_DATE,C.LANGUAGE_ID FROM ST_SAL_RET_HDR A,ST_SAL_RET_DTL_EXP B, SY_DOC_TYPE_MASTER_LANG_VW C,MM_STORE_LANG_VW D,MM_ITEM_LANG_VW E,ST_TRN_TYPE_LANG_VW F,MM_BIN_LOCATION_LANG_VW G WHERE A.FACILITY_ID = B.FACILITY_ID AND A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND A.DOC_NO = B.DOC_NO AND A.FINALIZED_YN = 'N' AND A.DOC_TYPE_CODE = C.DOC_TYPE_CODE AND B.STORE_CODE = D.STORE_CODE AND B.ITEM_CODE = E.ITEM_CODE AND A.TRN_TYPE = F.TRN_TYPE AND B.STORE_CODE = G.STORE_CODE AND B.BIN_LOCATION_CODE = G.BIN_LOCATION_CODE AND C.LANGUAGE_ID = D.LANGUAGE_ID AND C.LANGUAGE_ID = E.LANGUAGE_ID AND C.LANGUAGE_ID = F.LANGUAGE_ID AND C.LANGUAGE_ID = G.LANGUAGE_ID) WHERE LANGUAGE_ID = ? ) STBV, MM_ITEM_LANG_VW MM,AM_UOM_lang_vw AM,ST_ACKNOWLEDGE_TRN_DTL ACK WHERE STBV.FACILITY_ID = ? ";
			
			//Added by Rabbani #inc no:44104(ML-BRU-SCF-1084) on 11-OCT-2013
			//sql = "SELECT STBV.DOC_TYPE_CODE, STBV.DOC_NO, STBV.SEQ_NO, STBV.TRN_TYPE,STBV.DOC_SRL_NO, STBV.STORE_CODE, STBV.ITEM_CODE, STBV.BATCH_ID,STBV.BIN_LOCATION_CODE,TO_CHAR (STBV.EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_DATE_OR_RECEIPT_DATE,(CASE WHEN ACK.TMP_REJECTED_QTY_2 IS NULL THEN STBV.BLOCKED_QTY ELSE (NVL(ACK.TMP_RECEIVED_QTY_2,0) + NVL(ACK.TMP_REJECTED_QTY_2,0)) END ) BLOCKED_QTY,STBV.DOC_TYPE_DESC, STBV.STORE_DESC, (CASE WHEN STBV.PROCESS_FOR_ACKNOWLEDGE = 'Y' THEN 'PA' ELSE 'NA' END) ACK_STATUS,(CASE WHEN (NVL  (ACK.TMP_REJECTED_QTY_2, 0)) > 0 THEN 'CP' ELSE 'NA' END ) ACK_STATUS2, STBV.ITEM_DESC, STBV.TRN_TYPE_DESC, STBV.BIN_DESC, TO_CHAR (STBV.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, AM.SHORT_DESC GEN_UOM_DESC,to_facility_id, fm_facility_id  FROM (SELECT * FROM (SELECT A.PROCESS_FOR_ACKNOWLEDGE,DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',D.FACILITY_ID,A.FACILITY_ID) FACILITY_ID, A.DOC_TYPE_CODE, A.DOC_NO, A.SEQ_NO, A.TRN_TYPE,B.DOC_SRL_NO, DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',A.TO_STORE_CODE,B.STORE_CODE) STORE_CODE, B.ITEM_CODE, B.BATCH_ID,DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',B.TO_BIN_LOCATION_CODE,B.BIN_LOCATION_CODE) BIN_LOCATION_CODE, B.EXPIRY_DATE_OR_RECEIPT_DATE,B.ISS_ITEM_QTY BLOCKED_QTY, C.SHORT_DESC DOC_TYPE_DESC,D.SHORT_DESC STORE_DESC, E.SHORT_DESC ITEM_DESC,F.SHORT_DESC TRN_TYPE_DESC, G.SHORT_DESC BIN_DESC, A.DOC_DATE,C.LANGUAGE_ID,(Select facility_id  from mm_store where store_code = a.to_store_code)to_facility_id, (Select facility_id  from mm_store where store_code = a.fm_store_code)fm_facility_id FROM ST_ISSUE_HDR A, ST_ISSUE_DTL_EXP B, SY_DOC_TYPE_MASTER_LANG_VW C, MM_STORE_LANG_VW D, MM_ITEM_LANG_VW E, ST_TRN_TYPE_LANG_VW F, MM_BIN_LOCATION_LANG_VW G WHERE A.FACILITY_ID = B.FACILITY_ID AND A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND A.DOC_NO = B.DOC_NO AND A.SEQ_NO = B.SEQ_NO AND A.FINALIZED_YN = 'N' AND A.DOC_TYPE_CODE = C.DOC_TYPE_CODE AND DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',A.TO_STORE_CODE,B.STORE_CODE) = D.STORE_CODE AND B.ITEM_CODE = E.ITEM_CODE AND A.TRN_TYPE = F.TRN_TYPE AND DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',A.TO_STORE_CODE,B.STORE_CODE) = G.STORE_CODE AND DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',B.TO_BIN_LOCATION_CODE,B.BIN_LOCATION_CODE) = G.BIN_LOCATION_CODE AND C.LANGUAGE_ID = D.LANGUAGE_ID AND C.LANGUAGE_ID = E.LANGUAGE_ID AND C.LANGUAGE_ID = F.LANGUAGE_ID AND C.LANGUAGE_ID = G.LANGUAGE_ID UNION SELECT A.PROCESS_FOR_ACKNOWLEDGE,DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',D.FACILITY_ID,A.FACILITY_ID) FACILITY_ID, A.DOC_TYPE_CODE, A.DOC_NO, NVL((SELECT MAX(seq_no) FROM st_acknowledge_trn_dtl where facility_id = a.facility_id and doc_no = a.doc_no and doc_type_code = a.doc_type_code),0) SEQ_NO, A.TRN_TYPE, B.DOC_SRL_NO, DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',A.TO_STORE_CODE,B.STORE_CODE) STORE_CODE, B.ITEM_CODE, B.BATCH_ID,DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',B.TO_BIN_LOCATION_CODE,B.BIN_LOCATION_CODE) BIN_LOCATION_CODE, B.EXPIRY_DATE_OR_RECEIPT_DATE,B.ITEM_QTY BLOCKED_QTY, C.SHORT_DESC DOC_TYPE_DESC,D.SHORT_DESC STORE_DESC, E.SHORT_DESC ITEM_DESC,F.SHORT_DESC TRN_TYPE_DESC, G.SHORT_DESC BIN_DESC, A.DOC_DATE,C.LANGUAGE_ID ,(Select facility_id  from mm_store where store_code = a.to_store_code)to_facility_id, (Select facility_id  from mm_store where store_code = a.fm_store_code)fm_facility_id FROM ST_ISSUE_RET_HDR A,ST_ISSUE_RET_DTL_EXP B, SY_DOC_TYPE_MASTER_LANG_VW C, MM_STORE_LANG_VW D, MM_ITEM_LANG_VW E,ST_TRN_TYPE_LANG_VW F,MM_BIN_LOCATION_LANG_VW G WHERE A.FACILITY_ID = B.FACILITY_ID AND A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND A.DOC_NO = B.DOC_NO AND A.FINALIZED_YN = 'N' AND A.DOC_TYPE_CODE = C.DOC_TYPE_CODE AND DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',A.TO_STORE_CODE,B.STORE_CODE) = D.STORE_CODE AND B.ITEM_CODE = E.ITEM_CODE AND A.TRN_TYPE = F.TRN_TYPE AND DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',A.TO_STORE_CODE,B.STORE_CODE) = G.STORE_CODE AND DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',B.TO_BIN_LOCATION_CODE,B.BIN_LOCATION_CODE) = G.BIN_LOCATION_CODE AND C.LANGUAGE_ID = D.LANGUAGE_ID AND C.LANGUAGE_ID = E.LANGUAGE_ID AND C.LANGUAGE_ID = F.LANGUAGE_ID AND C.LANGUAGE_ID = G.LANGUAGE_ID UNION SELECT A.PROCESS_FOR_ACKNOWLEDGE,DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',D.FACILITY_ID,A.FACILITY_ID) FACILITY_ID, A.DOC_TYPE_CODE, A.DOC_NO, NVL((SELECT MAX(seq_no) FROM st_acknowledge_trn_dtl where facility_id = a.facility_id and doc_no = a.doc_no and doc_type_code = a.doc_type_code),0) SEQ_NO, A.TRN_TYPE, B.DOC_SRL_NO, DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',A.TO_STORE_CODE,B.STORE_CODE) STORE_CODE, B.ITEM_CODE, B.BATCH_ID,DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',B.TO_BIN_LOCATION_CODE,B.BIN_LOCATION_CODE) BIN_LOCATION_CODE, B.EXPIRY_DATE_OR_RECEIPT_DATE,B.ITEM_QTY BLOCKED_QTY, C.SHORT_DESC DOC_TYPE_DESC,D.SHORT_DESC STORE_DESC, E.SHORT_DESC ITEM_DESC,F.SHORT_DESC TRN_TYPE_DESC, G.SHORT_DESC BIN_DESC, A.DOC_DATE,C.LANGUAGE_ID,(Select facility_id  from mm_store where store_code = a.to_store_code)to_facility_id, (Select facility_id  from mm_store where store_code = a.fm_store_code)fm_facility_id FROM ST_TRANSFER_HDR A,ST_TRANSFER_DTL_EXP B, SY_DOC_TYPE_MASTER_LANG_VW C,MM_STORE_LANG_VW D,MM_ITEM_LANG_VW E,ST_TRN_TYPE_LANG_VW F,MM_BIN_LOCATION_LANG_VW G WHERE A.FACILITY_ID = B.FACILITY_ID AND A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND A.DOC_NO = B.DOC_NO AND A.FINALIZED_YN = 'N' AND A.DOC_TYPE_CODE = C.DOC_TYPE_CODE AND DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',A.TO_STORE_CODE,B.STORE_CODE) = D.STORE_CODE AND B.ITEM_CODE = E.ITEM_CODE AND A.TRN_TYPE = F.TRN_TYPE AND DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',A.TO_STORE_CODE,B.STORE_CODE) = G.STORE_CODE AND DECODE(A.PROCESS_FOR_ACKNOWLEDGE , 'Y',B.TO_BIN_LOCATION_CODE,B.BIN_LOCATION_CODE) = G.BIN_LOCATION_CODE AND C.LANGUAGE_ID = D.LANGUAGE_ID AND C.LANGUAGE_ID = E.LANGUAGE_ID AND C.LANGUAGE_ID = F.LANGUAGE_ID AND C.LANGUAGE_ID = G.LANGUAGE_ID UNION SELECT 'N' PROCESS_FOR_ACKNOWLEDGE,A.FACILITY_ID, A.DOC_TYPE_CODE, A.DOC_NO, 0 SEQ_NO, A.TRN_TYPE,B.DOC_SRL_NO, B.STORE_CODE, B.ITEM_CODE, B.BATCH_ID, B.BIN_LOCATION_CODE, B.EXPIRY_DATE_OR_RECEIPT_DATE,B.ITEM_QTY BLOCKED_QTY, C.SHORT_DESC DOC_TYPE_DESC,D.SHORT_DESC STORE_DESC, E.SHORT_DESC ITEM_DESC,F.SHORT_DESC TRN_TYPE_DESC, G.SHORT_DESC BIN_DESC, A.DOC_DATE,C.LANGUAGE_ID,A.facility_id fm_facility_id,A.facility_id to_facility_id FROM ST_ADJ_HDR A,ST_ADJ_DTL_EXP B,SY_DOC_TYPE_MASTER_LANG_VW C,MM_STORE_LANG_VW D,MM_ITEM_LANG_VW E,ST_TRN_TYPE_LANG_VW F,MM_BIN_LOCATION_LANG_VW G WHERE A.FACILITY_ID = B.FACILITY_ID AND A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND A.DOC_NO = B.DOC_NO AND A.FINALIZED_YN = 'N' AND A.DOC_TYPE_CODE = C.DOC_TYPE_CODE AND B.STORE_CODE = D.STORE_CODE AND B.ITEM_CODE = E.ITEM_CODE AND A.TRN_TYPE = F.TRN_TYPE AND B.STORE_CODE =  G.STORE_CODE AND B.BIN_LOCATION_CODE = G.BIN_LOCATION_CODE AND C.LANGUAGE_ID = D.LANGUAGE_ID AND C.LANGUAGE_ID = E.LANGUAGE_ID AND C.LANGUAGE_ID = F.LANGUAGE_ID AND C.LANGUAGE_ID = G.LANGUAGE_ID UNION SELECT 'N' PROCESS_FOR_ACKNOWLEDGE,A.FACILITY_ID, A.DOC_TYPE_CODE, A.DOC_NO, 0 SEQ_NO, A.TRN_TYPE, B.DOC_SRL_NO, B.STORE_CODE, B.ITEM_CODE, B.BATCH_ID,B.BIN_LOCATION_CODE, B.EXPIRY_DATE_OR_RECEIPT_DATE,B.ITEM_QTY BLOCKED_QTY, C.SHORT_DESC DOC_TYPE_DESC,D.SHORT_DESC STORE_DESC, E.SHORT_DESC ITEM_DESC,F.SHORT_DESC TRN_TYPE_DESC, G.SHORT_DESC BIN_DESC, A.DOC_DATE,C.LANGUAGE_ID,A.facility_id fm_facility_id,A.facility_id to_facility_id FROM ST_RTV_HDR A, ST_RTV_DTL_EXP B, SY_DOC_TYPE_MASTER_LANG_VW C, MM_STORE_LANG_VW D, MM_ITEM_LANG_VW E, ST_TRN_TYPE_LANG_VW F, MM_BIN_LOCATION_LANG_VW G  WHERE A.FACILITY_ID = B.FACILITY_ID AND A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND A.DOC_NO = B.DOC_NO AND A.FINALIZED_YN = 'N' AND A.DOC_TYPE_CODE = C.DOC_TYPE_CODE AND B.STORE_CODE = D.STORE_CODE AND B.ITEM_CODE = E.ITEM_CODE AND A.TRN_TYPE = F.TRN_TYPE AND B.STORE_CODE = G.STORE_CODE AND B.BIN_LOCATION_CODE = G.BIN_LOCATION_CODE AND C.LANGUAGE_ID = D.LANGUAGE_ID AND C.LANGUAGE_ID = E.LANGUAGE_ID AND C.LANGUAGE_ID = F.LANGUAGE_ID AND C.LANGUAGE_ID = G.LANGUAGE_ID UNION SELECT 'N' PROCESS_FOR_ACKNOWLEDGE,A.FACILITY_ID, A.DOC_TYPE_CODE, A.DOC_NO, 0 SEQ_NO, A.TRN_TYPE,B.DOC_SRL_NO, B.STORE_CODE, B.ITEM_CODE, B.BATCH_ID,B.BIN_LOCATION_CODE, B.EXPIRY_DATE_OR_RECEIPT_DATE,B.SAL_ITEM_QTY BLOCKED_QTY, C.SHORT_DESC DOC_TYPE_DESC,D.SHORT_DESC STORE_DESC, E.SHORT_DESC ITEM_DESC,F.SHORT_DESC TRN_TYPE_DESC, G.SHORT_DESC BIN_DESC, A.DOC_DATE,C.LANGUAGE_ID ,A.facility_id fm_facility_id,A.facility_id to_facility_id FROM ST_SAL_HDR A,ST_SAL_DTL_EXP B,SY_DOC_TYPE_MASTER_LANG_VW C,MM_STORE_LANG_VW D,MM_ITEM_LANG_VW E,ST_TRN_TYPE_LANG_VW F,MM_BIN_LOCATION_LANG_VW G WHERE A.FACILITY_ID = B.FACILITY_ID AND A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND A.DOC_NO = B.DOC_NO AND A.FINALIZED_YN = 'N' AND A.DOC_TYPE_CODE = C.DOC_TYPE_CODE AND B.STORE_CODE = D.STORE_CODE AND B.ITEM_CODE = E.ITEM_CODE AND A.TRN_TYPE = F.TRN_TYPE AND B.STORE_CODE = G.STORE_CODE AND B.BIN_LOCATION_CODE = G.BIN_LOCATION_CODE AND C.LANGUAGE_ID = D.LANGUAGE_ID AND C.LANGUAGE_ID = E.LANGUAGE_ID AND C.LANGUAGE_ID = F.LANGUAGE_ID AND C.LANGUAGE_ID = G.LANGUAGE_ID UNION SELECT 'N' PROCESS_FOR_ACKNOWLEDGE,A.FACILITY_ID, A.DOC_TYPE_CODE, A.DOC_NO, 0 SEQ_NO, A.TRN_TYPE,B.DOC_SRL_NO, B.STORE_CODE, B.ITEM_CODE, B.BATCH_ID, B.BIN_LOCATION_CODE, B.EXPIRY_DATE_OR_RECEIPT_DATE,B.ITEM_QTY BLOCKED_QTY, C.SHORT_DESC DOC_TYPE_DESC,D.SHORT_DESC STORE_DESC, E.SHORT_DESC ITEM_DESC,F.SHORT_DESC TRN_TYPE_DESC, G.SHORT_DESC BIN_DESC, A.DOC_DATE,C.LANGUAGE_ID,A.facility_id fm_facility_id,A.facility_id to_facility_id  FROM ST_MFG_HDR A, ST_MFG_DTL_EXP B,SY_DOC_TYPE_MASTER_LANG_VW C,MM_STORE_LANG_VW D,MM_ITEM_LANG_VW E, ST_TRN_TYPE_LANG_VW F, MM_BIN_LOCATION_LANG_VW G WHERE A.FACILITY_ID = B.FACILITY_ID AND A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND A.DOC_NO = B.DOC_NO AND A.FINALIZED_YN = 'N' AND A.DOC_TYPE_CODE = C.DOC_TYPE_CODE AND B.STORE_CODE = D.STORE_CODE AND B.ITEM_CODE = E.ITEM_CODE AND A.TRN_TYPE = F.TRN_TYPE AND B.STORE_CODE = G.STORE_CODE AND B.BIN_LOCATION_CODE = G.BIN_LOCATION_CODE AND C.LANGUAGE_ID = D.LANGUAGE_ID AND C.LANGUAGE_ID = E.LANGUAGE_ID AND C.LANGUAGE_ID = F.LANGUAGE_ID AND C.LANGUAGE_ID = G.LANGUAGE_ID UNION SELECT 'N' PROCESS_FOR_ACKNOWLEDGE,A.FACILITY_ID, A.DOC_TYPE_CODE, A.DOC_NO, 0 SEQ_NO, A.TRN_TYPE, B.DOC_SRL_NO, B.STORE_CODE, B.ITEM_CODE, B.BATCH_ID,B.BIN_LOCATION_CODE, B.EXPIRY_DATE_OR_RECEIPT_DATE, B.GRN_ITEM_QTY BLOCKED_QTY, C.SHORT_DESC DOC_TYPE_DESC, D.SHORT_DESC STORE_DESC, E.SHORT_DESC ITEM_DESC, F.SHORT_DESC TRN_TYPE_DESC, G.SHORT_DESC BIN_DESC, A.DOC_DATE, C.LANGUAGE_ID ,A.facility_id fm_facility_id,A.facility_id to_facility_id  FROM ST_GRN_HDR A, ST_GRN_DTL_EXP B, SY_DOC_TYPE_MASTER_LANG_VW C,MM_STORE_LANG_VW D, MM_ITEM_LANG_VW E, ST_TRN_TYPE_LANG_VW F, MM_BIN_LOCATION_LANG_VW G WHERE A.FACILITY_ID = B.FACILITY_ID AND A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND A.DOC_NO = B.DOC_NO AND A.FINALIZED_YN = 'N' AND A.DOC_TYPE_CODE = C.DOC_TYPE_CODE AND B.STORE_CODE = D.STORE_CODE AND B.ITEM_CODE = E.ITEM_CODE AND A.TRN_TYPE = F.TRN_TYPE AND B.STORE_CODE = G.STORE_CODE AND B.BIN_LOCATION_CODE = G.BIN_LOCATION_CODE AND C.LANGUAGE_ID = D.LANGUAGE_ID AND C.LANGUAGE_ID = E.LANGUAGE_ID AND C.LANGUAGE_ID = F.LANGUAGE_ID AND C.LANGUAGE_ID = G.LANGUAGE_ID UNION SELECT 'N' PROCESS_FOR_ACKNOWLEDGE,A.FACILITY_ID, A.DOC_TYPE_CODE, A.DOC_NO, 0 SEQ_NO, A.TRN_TYPE,B.DOC_SRL_NO, B.STORE_CODE, B.ITEM_CODE, B.BATCH_ID,B.BIN_LOCATION_CODE, B.EXPIRY_DATE_OR_RECEIPT_DATE,B.ITEM_QTY BLOCKED_QTY, C.SHORT_DESC DOC_TYPE_DESC,D.SHORT_DESC STORE_DESC, E.SHORT_DESC ITEM_DESC,F.SHORT_DESC TRN_TYPE_DESC, G.SHORT_DESC BIN_DESC, A.DOC_DATE,C.LANGUAGE_ID  ,A.facility_id fm_facility_id,A.facility_id to_facility_id FROM ST_SAL_RET_HDR A,ST_SAL_RET_DTL_EXP B, SY_DOC_TYPE_MASTER_LANG_VW C,MM_STORE_LANG_VW D,MM_ITEM_LANG_VW E,ST_TRN_TYPE_LANG_VW F,MM_BIN_LOCATION_LANG_VW G WHERE A.FACILITY_ID = B.FACILITY_ID AND A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND A.DOC_NO = B.DOC_NO AND A.FINALIZED_YN = 'N' AND A.DOC_TYPE_CODE = C.DOC_TYPE_CODE AND B.STORE_CODE = D.STORE_CODE AND B.ITEM_CODE = E.ITEM_CODE AND A.TRN_TYPE = F.TRN_TYPE AND B.STORE_CODE = G.STORE_CODE AND B.BIN_LOCATION_CODE = G.BIN_LOCATION_CODE AND C.LANGUAGE_ID = D.LANGUAGE_ID AND C.LANGUAGE_ID = E.LANGUAGE_ID AND C.LANGUAGE_ID = F.LANGUAGE_ID AND C.LANGUAGE_ID = G.LANGUAGE_ID) WHERE LANGUAGE_ID = ? ) STBV, MM_ITEM_LANG_VW MM,AM_UOM_lang_vw AM,ST_ACKNOWLEDGE_TRN_DTL ACK WHERE  (to_facility_id = ? OR fm_facility_id = ?) ";
			//Added the query into StRepository by suresh.r on 16-09-2014 against Perf tuning Inc 51157
			if(restrict_stores_user_access_yn){//Modified for MOHE-CRF-0084.1 START
				sql =eST.Common.StRepository.getStKeyValue("SQL_ST_BLOCKED_BATCHES_QUERY_RESTRICT_USER_ACCESS");
			}else{
				sql =eST.Common.StRepository.getStKeyValue("SQL_ST_BLOCKED_BATCHES_QUERY");
			}
			//END 
			
			if(!trn_type.equals("")){
				if(trn_type.equals("ACK")){
					sql = sql + " AND STBV.TRN_TYPE IN ('URG','ISS','TFR','RET') ";
				}else{
					sql = sql + " AND STBV.TRN_TYPE = " + " '"+trn_type+"' " ;	
				}
			}
			//Added by suresh.r on 29-09-2014 against Inc 51460 beg
			if(!module_id.equals("ALL") && (trn_type.equals("SAL") || trn_type.equals("SRT")))
				sql = sql + " AND STBV.MODULE_ID = " + " '"+module_id+"' " ;
			//Added by suresh.r on 29-09-2014 against Inc 51460 end
			if(!doc_type_code.equals(""))
				sql = sql + " AND STBV.DOC_TYPE_CODE = " + " '"+doc_type_code+"' " ;	
			if(!doc_no.equals(""))
				sql = sql + " AND STBV.DOC_NO = " + " '"+doc_no+"' " ;	
			if(!store_code.equals(""))
				sql = sql + " AND STBV.STORE_CODE = " + " '"+store_code+"' " ;	
			if(!item_code.equals(""))
				sql = sql + " AND STBV.ITEM_CODE = " + " '"+item_code+"' " ;	
			if(!batch_id.equals(""))
				sql = sql + " AND STBV.BATCH_ID = " + " '"+batch_id+"' " ;	
			if(!from_doc_date.equals("") && !to_doc_date.equals(""))
				sql = sql + " AND STBV.DOC_DATE BETWEEN TO_DATE ("+"'"+from_doc_date+"'"+", 'DD/MM/YYYY') AND TO_DATE ("+"'"+to_doc_date+"'"+", 'DD/MM/YYYY')"; 
			else if(!from_doc_date.equals("") && to_doc_date.equals(""))
				sql = sql + " AND STBV.DOC_DATE BETWEEN TO_DATE ("+"'"+from_doc_date+"'"+", 'DD/MM/YYYY') AND TO_DATE (NVL ("+"'"+to_doc_date+"'"+", TO_CHAR(sysdate,'DD/MM/YYYY')), 'DD/MM/YYYY')";

            //commented by Rabbani #inc no:44104(ML-BRU-SCF-1084) on 11-OCT-2013
			//sql = sql + "	AND STBV.LANGUAGE_ID = ? AND STBV.LANGUAGE_ID = MM.LANGUAGE_ID and mm.language_id = am.language_id AND STBV.ITEM_CODE = MM.ITEM_CODE AND MM.GEN_UOM_CODE = AM.UOM_CODE AND STBV.DOC_NO = ACK.DOC_NO(+) AND STBV.DOC_TYPE_CODE = ACK.DOC_TYPE_CODE(+) AND STBV.BATCH_ID = ACK.BATCH_ID(+) AND STBV.EXPIRY_DATE_OR_RECEIPT_DATE = ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) AND STBV.SEQ_NO = ACK.SEQ_NO(+) AND STBV.ITEM_CODE = ACK.ITEM_CODE(+) AND (STBV.DOC_TYPE_CODE,STBV.DOC_NO) NOT IN(SELECT DOC_TYPE_CODE,DOC_NO FROM ST_ACKNOWLEDGE_TRN_DTL)  UNION ALL  SELECT A.DOC_TYPE_CODE, A.DOC_NO, A.SEQ_NO, A.TRN_TYPE, B.DOC_SRL_NO,A.RECEIVING_STORE, B.ITEM_CODE, B.BATCH_ID,B.NEW_BIN_LOCATION_CODE BIN_LOCATION_CODE,TO_CHAR(B.EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_DATE_OR_RECEIPT_DATE,(  B.ISSUE_QTY- (  B.RECEIVED_QTY+ B.REJECTED_QTY+ NVL(B.TMP_RECEIVED_QTY_2,0)+ NVL(B.TMP_REJECTED_QTY_2,0))) BLOCKED_QTY,C.SHORT_DESC DOC_TYPE_DESC, D.SHORT_DESC STORE_DESC,(CASE WHEN (  B.ISSUE_QTY - (  B.RECEIVED_QTY + B.REJECTED_QTY + NVL (B.TMP_RECEIVED_QTY_2, 0) ) > 0 ) THEN 'PA' ELSE 'NA' END ) ACK_STATUS, (CASE WHEN (NVL (B.TMP_REJECTED_QTY_2, 0)) > 0 THEN 'NA' ELSE 'NA' END ) ACK_STATUS2, E.SHORT_DESC ITEM_DESC, F.SHORT_DESC TRN_TYPE_DESC, G.SHORT_DESC BIN_DESC, TO_CHAR (A.DOC_DATE, 'DD/MM/YYYY') DOC_DATE,  AM.SHORT_DESC GEN_UOM_DESC FROM ST_ACKNOWLEDGE_TRN_HDR A, ST_ACKNOWLEDGE_TRN_DTL B, SY_DOC_TYPE_MASTER_LANG_VW C,  MM_STORE_LANG_VW D, MM_ITEM_LANG_VW E, ST_TRN_TYPE_LANG_VW F, MM_BIN_LOCATION_LANG_VW G, AM_UOM_lang_vw AM WHERE A.FACILITY_ID = ?  ";
			
			//Added by Rabbani #inc no:44104(ML-BRU-SCF-1084) on 11-OCT-2013
			//sql = sql + "	AND STBV.LANGUAGE_ID = ? AND STBV.LANGUAGE_ID = MM.LANGUAGE_ID and mm.language_id = am.language_id AND STBV.ITEM_CODE = MM.ITEM_CODE AND MM.GEN_UOM_CODE = AM.UOM_CODE AND STBV.DOC_NO = ACK.DOC_NO(+) AND STBV.DOC_TYPE_CODE = ACK.DOC_TYPE_CODE(+) AND STBV.BATCH_ID = ACK.BATCH_ID(+) AND STBV.EXPIRY_DATE_OR_RECEIPT_DATE = ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) AND STBV.SEQ_NO = ACK.SEQ_NO(+) AND STBV.ITEM_CODE = ACK.ITEM_CODE(+) AND (STBV.DOC_TYPE_CODE,STBV.DOC_NO,STBV.SEQ_NO) NOT IN(SELECT DOC_TYPE_CODE,DOC_NO,SEQ_NO FROM ST_ACKNOWLEDGE_TRN_DTL)  UNION ALL  SELECT A.DOC_TYPE_CODE, A.DOC_NO, A.SEQ_NO, A.TRN_TYPE, B.DOC_SRL_NO,A.RECEIVING_STORE, B.ITEM_CODE, B.BATCH_ID,B.NEW_BIN_LOCATION_CODE BIN_LOCATION_CODE,TO_CHAR(B.EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_DATE_OR_RECEIPT_DATE,(  B.ISSUE_QTY- (  B.RECEIVED_QTY+ B.REJECTED_QTY+ NVL(B.TMP_RECEIVED_QTY_2,0)+ NVL(B.TMP_REJECTED_QTY_2,0))) BLOCKED_QTY,C.SHORT_DESC DOC_TYPE_DESC, D.SHORT_DESC STORE_DESC,(CASE WHEN (  B.ISSUE_QTY - (  B.RECEIVED_QTY + B.REJECTED_QTY + NVL (B.TMP_RECEIVED_QTY_2, 0) ) > 0 ) THEN 'PA' ELSE 'NA' END ) ACK_STATUS, (CASE WHEN (NVL (B.TMP_REJECTED_QTY_2, 0)) > 0 THEN 'NA' ELSE 'NA' END ) ACK_STATUS2, E.SHORT_DESC ITEM_DESC, F.SHORT_DESC TRN_TYPE_DESC, G.SHORT_DESC BIN_DESC, TO_CHAR (A.DOC_DATE, 'DD/MM/YYYY') DOC_DATE,  AM.SHORT_DESC GEN_UOM_DESC  ,(SELECT facility_id FROM mm_store WHERE store_code = a.RECEIVING_STORE) to_facility_id,(SELECT facility_id    FROM mm_store  WHERE store_code = a.ISSUING_STORE) fm_facility_id FROM ST_ACKNOWLEDGE_TRN_HDR A, ST_ACKNOWLEDGE_TRN_DTL B, SY_DOC_TYPE_MASTER_LANG_VW C,  MM_STORE_LANG_VW D, MM_ITEM_LANG_VW E, ST_TRN_TYPE_LANG_VW F, MM_BIN_LOCATION_LANG_VW G, AM_UOM_lang_vw AM WHERE (a.facility_id = ? OR A.ADDED_FACILITY_ID = ? )  ";
			//Modified by suresh.r on 29-09-2014 against Inc 51460
			
			if(restrict_stores_user_access_yn){//MOHE-CRF-0084.1
			if(strFacilityParam.equals("Y")){
				sql = sql + "	AND STBV.LANGUAGE_ID = ? AND STBV.LANGUAGE_ID = MM.LANGUAGE_ID and mm.language_id = am.language_id AND STBV.ITEM_CODE = MM.ITEM_CODE AND MM.GEN_UOM_CODE = AM.UOM_CODE AND STBV.DOC_NO = ACK.DOC_NO(+) AND STBV.DOC_TYPE_CODE = ACK.DOC_TYPE_CODE(+) AND STBV.BATCH_ID = ACK.BATCH_ID(+) AND STBV.EXPIRY_DATE_OR_RECEIPT_DATE = ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) AND STBV.SEQ_NO = ACK.SEQ_NO(+) AND STBV.ITEM_CODE = ACK.ITEM_CODE(+) AND (STBV.DOC_TYPE_CODE,STBV.DOC_NO,STBV.SEQ_NO) NOT IN(SELECT DOC_TYPE_CODE,DOC_NO,SEQ_NO FROM ST_ACKNOWLEDGE_TRN_DTL) and stbv.store_code in (select store_code from st_user_access_for_store where user_id = ? ) and stbv.facility_id like  decode(TRN_ACROSS_FACILITY_YN, 'Y',stbv.facility_id, ? ) UNION ALL  SELECT A.DOC_TYPE_CODE, A.DOC_NO, A.SEQ_NO, A.TRN_TYPE, B.DOC_SRL_NO,A.RECEIVING_STORE, B.ITEM_CODE, B.BATCH_ID,B.NEW_BIN_LOCATION_CODE BIN_LOCATION_CODE,TO_CHAR(B.EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_DATE_OR_RECEIPT_DATE,(  B.ISSUE_QTY- (  B.RECEIVED_QTY+ B.REJECTED_QTY+ NVL(B.TMP_RECEIVED_QTY_2,0)+ NVL(B.TMP_REJECTED_QTY_2,0))) BLOCKED_QTY,C.SHORT_DESC DOC_TYPE_DESC, D.SHORT_DESC STORE_DESC,(CASE WHEN (  B.ISSUE_QTY - (  B.RECEIVED_QTY + B.REJECTED_QTY + NVL (B.TMP_RECEIVED_QTY_2, 0) ) > 0 ) THEN 'PA' ELSE 'NA' END ) ACK_STATUS, (CASE WHEN (NVL (B.TMP_REJECTED_QTY_2, 0)) > 0 THEN 'NA' ELSE 'NA' END ) ACK_STATUS2, E.SHORT_DESC ITEM_DESC, F.SHORT_DESC TRN_TYPE_DESC, G.SHORT_DESC BIN_DESC, TO_CHAR (A.DOC_DATE, 'DD/MM/YYYY') DOC_DATE,  AM.SHORT_DESC GEN_UOM_DESC  ,(SELECT facility_id FROM mm_store WHERE store_code = a.RECEIVING_STORE) to_facility_id,(SELECT facility_id    FROM mm_store  WHERE store_code = a.ISSUING_STORE) fm_facility_id,'ST' MODULE_ID FROM ST_ACKNOWLEDGE_TRN_HDR A, ST_ACKNOWLEDGE_TRN_DTL B, SY_DOC_TYPE_MASTER_LANG_VW C,  MM_STORE_LANG_VW D, MM_ITEM_LANG_VW E, ST_TRN_TYPE_LANG_VW F, MM_BIN_LOCATION_LANG_VW G, AM_UOM_lang_vw AM, st_acc_entity_param acc WHERE (a.facility_id = ? OR A.ADDED_FACILITY_ID = ? )  ";
			}
			else if (strFacilityParam.equals("N")){
				sql = sql + "	AND STBV.LANGUAGE_ID = ? AND STBV.LANGUAGE_ID = MM.LANGUAGE_ID and mm.language_id = am.language_id AND STBV.ITEM_CODE = MM.ITEM_CODE AND MM.GEN_UOM_CODE = AM.UOM_CODE AND STBV.DOC_NO = ACK.DOC_NO(+) AND STBV.DOC_TYPE_CODE = ACK.DOC_TYPE_CODE(+) AND STBV.BATCH_ID = ACK.BATCH_ID(+) AND STBV.EXPIRY_DATE_OR_RECEIPT_DATE = ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) AND STBV.SEQ_NO = ACK.SEQ_NO(+) AND STBV.ITEM_CODE = ACK.ITEM_CODE(+) AND (STBV.DOC_TYPE_CODE,STBV.DOC_NO,STBV.SEQ_NO) NOT IN(SELECT DOC_TYPE_CODE,DOC_NO,SEQ_NO FROM ST_ACKNOWLEDGE_TRN_DTL) and stbv.facility_id like  decode(TRN_ACROSS_FACILITY_YN, 'Y',stbv.facility_id, ? ) UNION ALL  SELECT A.DOC_TYPE_CODE, A.DOC_NO, A.SEQ_NO, A.TRN_TYPE, B.DOC_SRL_NO,A.RECEIVING_STORE, B.ITEM_CODE, B.BATCH_ID,B.NEW_BIN_LOCATION_CODE BIN_LOCATION_CODE,TO_CHAR(B.EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_DATE_OR_RECEIPT_DATE,(  B.ISSUE_QTY- (  B.RECEIVED_QTY+ B.REJECTED_QTY+ NVL(B.TMP_RECEIVED_QTY_2,0)+ NVL(B.TMP_REJECTED_QTY_2,0))) BLOCKED_QTY,C.SHORT_DESC DOC_TYPE_DESC, D.SHORT_DESC STORE_DESC,(CASE WHEN (  B.ISSUE_QTY - (  B.RECEIVED_QTY + B.REJECTED_QTY + NVL (B.TMP_RECEIVED_QTY_2, 0) ) > 0 ) THEN 'PA' ELSE 'NA' END ) ACK_STATUS, (CASE WHEN (NVL (B.TMP_REJECTED_QTY_2, 0)) > 0 THEN 'NA' ELSE 'NA' END ) ACK_STATUS2, E.SHORT_DESC ITEM_DESC, F.SHORT_DESC TRN_TYPE_DESC, G.SHORT_DESC BIN_DESC, TO_CHAR (A.DOC_DATE, 'DD/MM/YYYY') DOC_DATE,  AM.SHORT_DESC GEN_UOM_DESC  ,(SELECT facility_id FROM mm_store WHERE store_code = a.RECEIVING_STORE) to_facility_id,(SELECT facility_id    FROM mm_store  WHERE store_code = a.ISSUING_STORE) fm_facility_id,'ST' MODULE_ID FROM ST_ACKNOWLEDGE_TRN_HDR A, ST_ACKNOWLEDGE_TRN_DTL B, SY_DOC_TYPE_MASTER_LANG_VW C,  MM_STORE_LANG_VW D, MM_ITEM_LANG_VW E, ST_TRN_TYPE_LANG_VW F, MM_BIN_LOCATION_LANG_VW G, AM_UOM_lang_vw AM, st_acc_entity_param acc WHERE (a.facility_id = ? OR A.ADDED_FACILITY_ID = ? )  ";
			}
			}else{
				sql = sql + "	AND STBV.LANGUAGE_ID = ? AND STBV.LANGUAGE_ID = MM.LANGUAGE_ID and mm.language_id = am.language_id AND STBV.ITEM_CODE = MM.ITEM_CODE AND MM.GEN_UOM_CODE = AM.UOM_CODE AND STBV.DOC_NO = ACK.DOC_NO(+) AND STBV.DOC_TYPE_CODE = ACK.DOC_TYPE_CODE(+) AND STBV.BATCH_ID = ACK.BATCH_ID(+) AND STBV.EXPIRY_DATE_OR_RECEIPT_DATE = ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) AND STBV.SEQ_NO = ACK.SEQ_NO(+) AND STBV.ITEM_CODE = ACK.ITEM_CODE(+) AND (STBV.DOC_TYPE_CODE,STBV.DOC_NO,STBV.SEQ_NO) NOT IN(SELECT DOC_TYPE_CODE,DOC_NO,SEQ_NO FROM ST_ACKNOWLEDGE_TRN_DTL)  UNION ALL  SELECT A.DOC_TYPE_CODE, A.DOC_NO, A.SEQ_NO, A.TRN_TYPE, B.DOC_SRL_NO,A.RECEIVING_STORE, B.ITEM_CODE, B.BATCH_ID,B.NEW_BIN_LOCATION_CODE BIN_LOCATION_CODE,TO_CHAR(B.EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_DATE_OR_RECEIPT_DATE,(  B.ISSUE_QTY- (  B.RECEIVED_QTY+ B.REJECTED_QTY+ NVL(B.TMP_RECEIVED_QTY_2,0)+ NVL(B.TMP_REJECTED_QTY_2,0))) BLOCKED_QTY,C.SHORT_DESC DOC_TYPE_DESC, D.SHORT_DESC STORE_DESC,(CASE WHEN (  B.ISSUE_QTY - (  B.RECEIVED_QTY + B.REJECTED_QTY + NVL (B.TMP_RECEIVED_QTY_2, 0) ) > 0 ) THEN 'PA' ELSE 'NA' END ) ACK_STATUS, (CASE WHEN (NVL (B.TMP_REJECTED_QTY_2, 0)) > 0 THEN 'NA' ELSE 'NA' END ) ACK_STATUS2, E.SHORT_DESC ITEM_DESC, F.SHORT_DESC TRN_TYPE_DESC, G.SHORT_DESC BIN_DESC, TO_CHAR (A.DOC_DATE, 'DD/MM/YYYY') DOC_DATE,  AM.SHORT_DESC GEN_UOM_DESC  ,(SELECT facility_id FROM mm_store WHERE store_code = a.RECEIVING_STORE) to_facility_id,(SELECT facility_id    FROM mm_store  WHERE store_code = a.ISSUING_STORE) fm_facility_id,'ST' MODULE_ID FROM ST_ACKNOWLEDGE_TRN_HDR A, ST_ACKNOWLEDGE_TRN_DTL B, SY_DOC_TYPE_MASTER_LANG_VW C,  MM_STORE_LANG_VW D, MM_ITEM_LANG_VW E, ST_TRN_TYPE_LANG_VW F, MM_BIN_LOCATION_LANG_VW G, AM_UOM_lang_vw AM WHERE (a.facility_id = ? OR A.ADDED_FACILITY_ID = ? )  ";
			}//END

			if(!trn_type.equals("")){
				if(trn_type.equals("ACK")){
					sql = sql + " AND A.TRN_TYPE IN ('URG','ISS','TFR','RET') ";
				}else{
					sql = sql + " AND A.TRN_TYPE = " + " '"+trn_type+"' " ;	
				}
			}
			if(!doc_type_code.equals(""))
				sql = sql + " AND A.DOC_TYPE_CODE = " + " '"+doc_type_code+"' " ;	
			if(!doc_no.equals(""))
				sql = sql + " AND A.DOC_NO = " + " '"+doc_no+"' " ;	
			if(!store_code.equals(""))
				sql = sql + " AND A.RECEIVING_STORE = " + " '"+store_code+"' " ;	
			if(!item_code.equals(""))
				sql = sql + " AND B.ITEM_CODE = " + " '"+item_code+"' " ;	
			if(!batch_id.equals(""))
				sql = sql + " AND B.BATCH_ID = " + " '"+batch_id+"' " ;	
			if(!from_doc_date.equals("") && !to_doc_date.equals(""))
				sql = sql + " AND A.DOC_DATE BETWEEN TO_DATE ("+"'"+from_doc_date+"'"+", 'DD/MM/YYYY') AND TO_DATE ("+"'"+to_doc_date+"'"+ ", 'DD/MM/YYYY')" ;
			else if(!from_doc_date.equals("") && to_doc_date.equals(""))
				sql = sql + " AND A.DOC_DATE BETWEEN TO_DATE ("+"'"+from_doc_date+"'"+", 'DD/MM/YYYY') AND TO_DATE (NVL ("+"'"+to_doc_date+"'"+ ", TO_CHAR(sysdate,'DD/MM/YYYY')), 'DD/MM/YYYY')";
	
			//Commented by Rabbani #inc no:44104(ML-BRU-SCF-1084) on 11-OCT-2013
			//sql = sql + "  AND A.FACILITY_ID = B.FACILITY_ID AND A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND A.DOC_NO = B.DOC_NO AND A.SEQ_NO = B.SEQ_NO AND A.DOC_TYPE_CODE = C.DOC_TYPE_CODE AND A.RECEIVING_STORE = D.STORE_CODE AND B.ITEM_CODE = E.ITEM_CODE AND A.TRN_TYPE = F.TRN_TYPE AND B.NEW_BIN_LOCATION_CODE = G.BIN_LOCATION_CODE AND (B.ISSUE_QTY - (B.RECEIVED_QTY + B.REJECTED_QTY+B.TMP_RECEIVED_QTY_2+B.TMP_REJECTED_QTY_2)) > 0 AND D.STORE_CODE = G.STORE_CODE AND E.GEN_UOM_CODE = AM.UOM_CODE AND C.LANGUAGE_ID = ? AND D.LANGUAGE_ID = C.LANGUAGE_ID and d.language_id =am.language_id AND E.LANGUAGE_ID = C.LANGUAGE_ID AND F.LANGUAGE_ID = C.LANGUAGE_ID AND G.LANGUAGE_ID = C.LANGUAGE_ID  UNION  SELECT STBV.DOC_TYPE_CODE, STBV.DOC_NO, STBV.SEQ_NO, STBV.TRN_TYPE, STBV.DOC_SRL_NO, STBV.STORE_CODE, STBV.ITEM_CODE, STBV.BATCH_ID, STBV.BIN_LOCATION_CODE, TO_CHAR (STBV.EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY' ) EXPIRY_DATE_OR_RECEIPT_DATE, NVL(ACK.TMP_RECEIVED_QTY_2,0) + NVL(ACK.TMP_REJECTED_QTY_2,0) BLOCKED_QTY,  STBV.DOC_TYPE_DESC, STBV.STORE_DESC,'NA' ACK_STATUS,'CP' ACK_STATUS2, STBV.ITEM_DESC, STBV.TRN_TYPE_DESC, STBV.BIN_DESC,TO_CHAR (STBV.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, AM.SHORT_DESC GEN_UOM_DESC FROM ST_BLOCKED_BATCHES_LANG_VIEW STBV, MM_ITEM_LANG_VW MM, AM_UOM_lang_vw AM,ST_ACKNOWLEDGE_TRN_DTL ACK WHERE STBV.FACILITY_ID = ? ";
			
			//Added by Rabbani #inc no:44104(ML-BRU-SCF-1084) on 11-OCT-2013
			//sql = sql + "  AND A.FACILITY_ID = B.FACILITY_ID AND A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND A.DOC_NO = B.DOC_NO AND A.SEQ_NO = B.SEQ_NO AND A.DOC_TYPE_CODE = C.DOC_TYPE_CODE AND A.RECEIVING_STORE = D.STORE_CODE AND B.ITEM_CODE = E.ITEM_CODE AND A.TRN_TYPE = F.TRN_TYPE AND B.NEW_BIN_LOCATION_CODE = G.BIN_LOCATION_CODE AND (B.ISSUE_QTY - (B.RECEIVED_QTY + B.REJECTED_QTY+B.TMP_RECEIVED_QTY_2+B.TMP_REJECTED_QTY_2)) > 0 AND D.STORE_CODE = G.STORE_CODE AND E.GEN_UOM_CODE = AM.UOM_CODE AND C.LANGUAGE_ID = ? AND D.LANGUAGE_ID = C.LANGUAGE_ID and d.language_id =am.language_id AND E.LANGUAGE_ID = C.LANGUAGE_ID AND F.LANGUAGE_ID = C.LANGUAGE_ID AND G.LANGUAGE_ID = C.LANGUAGE_ID  UNION  SELECT STBV.DOC_TYPE_CODE, STBV.DOC_NO, STBV.SEQ_NO, STBV.TRN_TYPE, STBV.DOC_SRL_NO, STBV.STORE_CODE, STBV.ITEM_CODE, STBV.BATCH_ID, STBV.BIN_LOCATION_CODE, TO_CHAR (STBV.EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY' ) EXPIRY_DATE_OR_RECEIPT_DATE, NVL(ACK.TMP_RECEIVED_QTY_2,0) + NVL(ACK.TMP_REJECTED_QTY_2,0) BLOCKED_QTY,  STBV.DOC_TYPE_DESC, STBV.STORE_DESC,'NA' ACK_STATUS,'CP' ACK_STATUS2, STBV.ITEM_DESC, STBV.TRN_TYPE_DESC, STBV.BIN_DESC,TO_CHAR (STBV.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, AM.SHORT_DESC GEN_UOM_DESC ,stbv.facility_id to_facility_id,stbv.facility_id fm_facility_id FROM ST_BLOCKED_BATCHES_LANG_VIEW STBV, MM_ITEM_LANG_VW MM, AM_UOM_lang_vw AM,ST_ACKNOWLEDGE_TRN_DTL ACK WHERE (stbv.facility_id = ? OR ACK.ADDED_FACILITY_ID = ?)"; 
			//Modified by suresh.r on 29-09-2014 against Inc 51460
			 
			if(restrict_stores_user_access_yn){ //MOHE-CRF-0084.1
				if(strFacilityParam.equals("Y")){
					sql = sql + "  AND A.FACILITY_ID = B.FACILITY_ID AND A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND A.DOC_NO = B.DOC_NO AND A.SEQ_NO = B.SEQ_NO AND A.DOC_TYPE_CODE = C.DOC_TYPE_CODE AND A.RECEIVING_STORE = D.STORE_CODE AND B.ITEM_CODE = E.ITEM_CODE AND A.TRN_TYPE = F.TRN_TYPE AND B.NEW_BIN_LOCATION_CODE = G.BIN_LOCATION_CODE AND (B.ISSUE_QTY - (B.RECEIVED_QTY + B.REJECTED_QTY+B.TMP_RECEIVED_QTY_2+B.TMP_REJECTED_QTY_2)) > 0 AND D.STORE_CODE = G.STORE_CODE AND E.GEN_UOM_CODE = AM.UOM_CODE AND C.LANGUAGE_ID = ? AND D.LANGUAGE_ID = C.LANGUAGE_ID and d.language_id =am.language_id AND E.LANGUAGE_ID = C.LANGUAGE_ID AND F.LANGUAGE_ID = C.LANGUAGE_ID AND G.LANGUAGE_ID = C.LANGUAGE_ID and d.store_code in (select store_code from st_user_access_for_store where user_id = ?) and d.facility_id like  decode(TRN_ACROSS_FACILITY_YN, 'Y',d.facility_id, ? )  UNION  SELECT STBV.DOC_TYPE_CODE, STBV.DOC_NO, STBV.SEQ_NO, STBV.TRN_TYPE, STBV.DOC_SRL_NO, STBV.STORE_CODE, STBV.ITEM_CODE, STBV.BATCH_ID, STBV.BIN_LOCATION_CODE, TO_CHAR (STBV.EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY' ) EXPIRY_DATE_OR_RECEIPT_DATE, NVL(ACK.TMP_RECEIVED_QTY_2,0) + NVL(ACK.TMP_REJECTED_QTY_2,0) BLOCKED_QTY,  STBV.DOC_TYPE_DESC, STBV.STORE_DESC,'NA' ACK_STATUS,'CP' ACK_STATUS2, STBV.ITEM_DESC, STBV.TRN_TYPE_DESC, STBV.BIN_DESC,TO_CHAR (STBV.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, AM.SHORT_DESC GEN_UOM_DESC ,stbv.facility_id to_facility_id,stbv.facility_id fm_facility_id,'ST' MODULE_ID FROM ST_BLOCKED_BATCHES_LANG_VIEW STBV, MM_ITEM_LANG_VW MM, AM_UOM_lang_vw AM,ST_ACKNOWLEDGE_TRN_DTL ACK, st_acc_entity_param  acc WHERE (stbv.facility_id = ? OR ACK.ADDED_FACILITY_ID = ?)";
				}else if(strFacilityParam.equals("N")){
					sql = sql + "  AND A.FACILITY_ID = B.FACILITY_ID AND A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND A.DOC_NO = B.DOC_NO AND A.SEQ_NO = B.SEQ_NO AND A.DOC_TYPE_CODE = C.DOC_TYPE_CODE AND A.RECEIVING_STORE = D.STORE_CODE AND B.ITEM_CODE = E.ITEM_CODE AND A.TRN_TYPE = F.TRN_TYPE AND B.NEW_BIN_LOCATION_CODE = G.BIN_LOCATION_CODE AND (B.ISSUE_QTY - (B.RECEIVED_QTY + B.REJECTED_QTY+B.TMP_RECEIVED_QTY_2+B.TMP_REJECTED_QTY_2)) > 0 AND D.STORE_CODE = G.STORE_CODE AND E.GEN_UOM_CODE = AM.UOM_CODE AND C.LANGUAGE_ID = ? AND D.LANGUAGE_ID = C.LANGUAGE_ID and d.language_id =am.language_id AND E.LANGUAGE_ID = C.LANGUAGE_ID AND F.LANGUAGE_ID = C.LANGUAGE_ID AND G.LANGUAGE_ID = C.LANGUAGE_ID  and d.facility_id like  decode(TRN_ACROSS_FACILITY_YN, 'Y',d.facility_id, ? )  UNION  SELECT STBV.DOC_TYPE_CODE, STBV.DOC_NO, STBV.SEQ_NO, STBV.TRN_TYPE, STBV.DOC_SRL_NO, STBV.STORE_CODE, STBV.ITEM_CODE, STBV.BATCH_ID, STBV.BIN_LOCATION_CODE, TO_CHAR (STBV.EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY' ) EXPIRY_DATE_OR_RECEIPT_DATE, NVL(ACK.TMP_RECEIVED_QTY_2,0) + NVL(ACK.TMP_REJECTED_QTY_2,0) BLOCKED_QTY,  STBV.DOC_TYPE_DESC, STBV.STORE_DESC,'NA' ACK_STATUS,'CP' ACK_STATUS2, STBV.ITEM_DESC, STBV.TRN_TYPE_DESC, STBV.BIN_DESC,TO_CHAR (STBV.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, AM.SHORT_DESC GEN_UOM_DESC ,stbv.facility_id to_facility_id,stbv.facility_id fm_facility_id,'ST' MODULE_ID FROM ST_BLOCKED_BATCHES_LANG_VIEW STBV, MM_ITEM_LANG_VW MM, AM_UOM_lang_vw AM,ST_ACKNOWLEDGE_TRN_DTL ACK, st_acc_entity_param  acc WHERE (stbv.facility_id = ? OR ACK.ADDED_FACILITY_ID = ?)";
				}
				
			}else{
				sql = sql + "  AND A.FACILITY_ID = B.FACILITY_ID AND A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND A.DOC_NO = B.DOC_NO AND A.SEQ_NO = B.SEQ_NO AND A.DOC_TYPE_CODE = C.DOC_TYPE_CODE AND A.RECEIVING_STORE = D.STORE_CODE AND B.ITEM_CODE = E.ITEM_CODE AND A.TRN_TYPE = F.TRN_TYPE AND B.NEW_BIN_LOCATION_CODE = G.BIN_LOCATION_CODE AND (B.ISSUE_QTY - (B.RECEIVED_QTY + B.REJECTED_QTY+B.TMP_RECEIVED_QTY_2+B.TMP_REJECTED_QTY_2)) > 0 AND D.STORE_CODE = G.STORE_CODE AND E.GEN_UOM_CODE = AM.UOM_CODE AND C.LANGUAGE_ID = ? AND D.LANGUAGE_ID = C.LANGUAGE_ID and d.language_id =am.language_id AND E.LANGUAGE_ID = C.LANGUAGE_ID AND F.LANGUAGE_ID = C.LANGUAGE_ID AND G.LANGUAGE_ID = C.LANGUAGE_ID  UNION  SELECT STBV.DOC_TYPE_CODE, STBV.DOC_NO, STBV.SEQ_NO, STBV.TRN_TYPE, STBV.DOC_SRL_NO, STBV.STORE_CODE, STBV.ITEM_CODE, STBV.BATCH_ID, STBV.BIN_LOCATION_CODE, TO_CHAR (STBV.EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY' ) EXPIRY_DATE_OR_RECEIPT_DATE, NVL(ACK.TMP_RECEIVED_QTY_2,0) + NVL(ACK.TMP_REJECTED_QTY_2,0) BLOCKED_QTY,  STBV.DOC_TYPE_DESC, STBV.STORE_DESC,'NA' ACK_STATUS,'CP' ACK_STATUS2, STBV.ITEM_DESC, STBV.TRN_TYPE_DESC, STBV.BIN_DESC,TO_CHAR (STBV.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, AM.SHORT_DESC GEN_UOM_DESC ,stbv.facility_id to_facility_id,stbv.facility_id fm_facility_id,'ST' MODULE_ID FROM ST_BLOCKED_BATCHES_LANG_VIEW STBV, MM_ITEM_LANG_VW MM, AM_UOM_lang_vw AM,ST_ACKNOWLEDGE_TRN_DTL ACK WHERE (stbv.facility_id = ? OR ACK.ADDED_FACILITY_ID = ?)";
			}//END
			
			if(!trn_type.equals("")){
				if(trn_type.equals("ACK")){
					sql = sql + " AND STBV.TRN_TYPE IN ('URG','ISS','TFR','RET') ";
				}else{
					sql = sql + " AND STBV.TRN_TYPE = " + " '"+trn_type+"' " ;	
				}				
			}
			if(!doc_type_code.equals(""))
				sql = sql + " AND STBV.DOC_TYPE_CODE = " + " '"+doc_type_code+"' " ;	
			if(!doc_no.equals(""))
				sql = sql + " AND STBV.DOC_NO = " + " '"+doc_no+"' " ;	
			if(!store_code.equals(""))
				sql = sql + " AND STBV.STORE_CODE = " + " '"+store_code+"' " ;	
			if(!item_code.equals(""))
				sql = sql + " AND STBV.ITEM_CODE = " + " '"+item_code+"' " ;	
			if(!batch_id.equals(""))
				sql = sql + " AND STBV.BATCH_ID = " + " '"+batch_id+"' " ;	
			if(!from_doc_date.equals("") && !to_doc_date.equals(""))
				sql = sql + " AND STBV.DOC_DATE BETWEEN TO_DATE ("+"'"+from_doc_date+"'"+", 'DD/MM/YYYY') AND TO_DATE ("+"'"+to_doc_date+"'"+ ", 'DD/MM/YYYY')" ;
			else if(!from_doc_date.equals("") && to_doc_date.equals(""))
				sql = sql + " AND STBV.DOC_DATE BETWEEN TO_DATE ("+"'"+from_doc_date+"'"+", 'DD/MM/YYYY') AND TO_DATE (NVL ("+"'"+to_doc_date+"'"+ ", TO_CHAR(sysdate,'DD/MM/YYYY')), 'DD/MM/YYYY')";


			sql = sql + "	AND STBV.LANGUAGE_ID = ? AND STBV.LANGUAGE_ID = MM.LANGUAGE_ID and am.language_id=mm.language_id AND STBV.ITEM_CODE = MM.ITEM_CODE AND MM.GEN_UOM_CODE = AM.UOM_CODE AND STBV.DOC_NO = ACK.DOC_NO AND STBV.DOC_TYPE_CODE = ACK.DOC_TYPE_CODE AND STBV.BATCH_ID = ACK.BATCH_ID AND STBV.EXPIRY_DATE_OR_RECEIPT_DATE = ACK.EXPIRY_DATE_OR_RECEIPT_DATE AND (STBV.SEQ_NO = ACK.SEQ_NO OR STBV.SEQ_NO =0) AND STBV.ITEM_CODE = ACK.ITEM_CODE AND (NVL (ACK.TMP_REJECTED_QTY_2, 0) > 0 OR NVL (ACK.TMP_RECEIVED_QTY_2, 0) > 0)";

			if(restrict_stores_user_access_yn){ //MOHE-CRF-0084.1
				if(strFacilityParam.equals("Y")){
					sql = sql + " and stbv.store_code in (select store_code from st_user_access_for_store where user_id= " + " '"+user_name+"') and stbv.facility_id like decode(TRN_ACROSS_FACILITY_YN, 'Y',stbv.facility_id, ? ) ";
				}else if(strFacilityParam.equals("N")){
					sql = sql + "and stbv.facility_id like decode(TRN_ACROSS_FACILITY_YN, 'Y',stbv.facility_id, ? ) ";
				} 
				}
			sqlMap.put("sqlData",sql); 
			chkFields		=		new ArrayList();
			chkFields.add(locale);
			chkFields.add(bean.getLoginFacilityId());
			chkFields.add(bean.getLoginFacilityId());//Added by Rabbani #inc no:44104(ML-BRU-SCF-1084) on 08-OCT-2013

			/*
			if(!trn_type.equals("ACK")){
				chkFields.add(trn_type);
			}
			chkFields.add(doc_type_code);
			chkFields.add(doc_no);
			chkFields.add(store_code);
			chkFields.add(item_code);
			chkFields.add(batch_id);
			chkFields.add(from_doc_date);
			chkFields.add(to_doc_date);*/

			chkFields.add(locale);
			if(restrict_stores_user_access_yn){//MOHE-CRF-0084.1
				if(strFacilityParam.equals("Y")){
					chkFields.add(user_name);
					chkFields.add(bean.getLoginFacilityId());  
				}else if (strFacilityParam.equals("N")){
					chkFields.add(bean.getLoginFacilityId());  
				}
			}//END 
			
			chkFields.add(bean.getLoginFacilityId());
			chkFields.add(bean.getLoginFacilityId());
			/*
			if(!trn_type.equals("ACK")){
				chkFields.add(trn_type);
			}
			chkFields.add(doc_type_code);
			chkFields.add(doc_no);
			chkFields.add(store_code);
			chkFields.add(item_code);
			chkFields.add(batch_id);
			chkFields.add(from_doc_date);
			chkFields.add(to_doc_date);
			*/
			chkFields.add(locale);
			if(restrict_stores_user_access_yn){//MOHE-CRF-0084.1
				if(strFacilityParam.equals("Y")){
					chkFields.add(user_name);
					chkFields.add(bean.getLoginFacilityId());  
				}else if (strFacilityParam.equals("N")){
					chkFields.add(bean.getLoginFacilityId());  
				}
			}//END 
			chkFields.add(bean.getLoginFacilityId());
			chkFields.add(bean.getLoginFacilityId());

			/*
			if(!trn_type.equals("ACK")){
				chkFields.add(trn_type);
			}
			chkFields.add(doc_type_code);
			chkFields.add(doc_no);
			chkFields.add(store_code);
			chkFields.add(item_code);
			chkFields.add(batch_id);
			chkFields.add(from_doc_date);
			chkFields.add(to_doc_date);
			*/
			chkFields.add(locale);
			if(restrict_stores_user_access_yn){//MOHE-CRF-0084.1 
				chkFields.add(bean.getLoginFacilityId());
			}
			
				} 
				/*if(trn_type.equals("ACK"))
				{
				sqlMap.put("sqlData", "SELECT DISTINCT a.doc_type_code, a.doc_no, a.seq_no, a.trn_type, b.doc_srl_no, a.receiving_store, b.item_code, b.batch_id, b.bin_location_code,  TO_CHAR  (b.expiry_date_or_receipt_date, 'DD/MM/YYYY') expiry_date_or_receipt_date, (b.issue_qty - (b.received_qty + b.rejected_qty)) blocked_qty, c.short_desc doc_type_desc, d.short_desc store_desc, (CASE WHEN (  b.issue_qty - (  b.received_qty + b.rejected_qty + NVL (b.tmp_received_qty_2, 0)) > 0)  THEN 'PA'  ELSE 'NA' END) ack_status, (CASE  WHEN (NVL (b.tmp_rejected_qty_2, 0)) > 0 THEN 'CP'  ELSE 'NA' END) ack_status2, e.short_desc item_desc, f.short_desc trn_type_desc, g.short_desc bin_desc, TO_CHAR (a.doc_date, 'DD/MM/YYYY') doc_date, am.short_desc gen_uom_desc FROM ST_ACKNOWLEDGE_TRN_HDR a,  ST_ACKNOWLEDGE_TRN_DTL b,  sy_doc_type_master_lang_vw c,   mm_store_lang_vw d,                mm_item_lang_vw e,    st_trn_type_lang_vw f, mm_bin_location_lang_vw g,   am_uom am  WHERE a.facility_id =?    AND a.trn_type LIKE ?    AND a.doc_type_code LIKE ? AND a.doc_no LIKE ? AND a.receiving_store LIKE UPPER (?)   AND b.item_code LIKE UPPER (?)  AND b.batch_id LIKE UPPER (?)  AND (a.doc_date BETWEEN TO_DATE (NVL (?, '01/01/1901'),'DD/MM/YYYY') AND TO_DATE (NVL (?, '31/12/3012'),'DD/MM/YYYY'))  AND a.facility_id = b.facility_id AND a.doc_type_code = b.doc_type_code AND a.doc_no = b.doc_no AND a.seq_no = b.seq_no AND a.doc_type_code = c.doc_type_code AND a.receiving_store = d.store_code AND b.item_code = e.item_code   AND a.trn_type = f.trn_type           AND b.new_bin_location_code = g.bin_location_code AND (b.issue_qty - (b.received_qty + b.rejected_qty)) > 0            AND d.store_code = g.store_code  AND e.gen_uom_code = am.uom_code    AND c.language_id = ?   AND d.language_id = c.language_id   AND e.language_id = c.language_id            AND f.language_id = c.language_id AND g.language_id = c.language_id");
				chkFields		=		new ArrayList();
				chkFields.add(bean.getLoginFacilityId());
			 chkFields.add("%");
			chkFields.add(doc_type_code);
			chkFields.add(doc_no);
			chkFields.add(store_code);
			chkFields.add(item_code);
			chkFields.add(batch_id);
			chkFields.add(from_doc_date);
			chkFields.add(to_doc_date);
			chkFields.add(locale);
				}*/
			//}
       

			HashMap funcMap			=		new HashMap();
			ArrayList displayFields =		new ArrayList();

			displayFields.add("DOC_TYPE_DESC");
			displayFields.add("DOC_NO");
			displayFields.add("SEQ_NO");
			displayFields.add("STORE_DESC");
			 if(iss_ack_req_yn.equals("Y") || ret_ack_req_yn.equals("Y") || tfr_ack_req_yn.equals("Y"))
			         {
			displayFields.add("ACK_STATUS");
			displayFields.add("ACK_STATUS2"); 
					 }
			displayFields.add("ITEM_CODE");
			displayFields.add("ITEM_DESC");
			displayFields.add("BLOCKED_QTY");
			displayFields.add("BATCH_ID");
			displayFields.add("BIN_DESC");
			displayFields.add("EXPIRY_DATE_OR_RECEIPT_DATE");
			displayFields.add("DOC_DATE");
			displayFields.add("GEN_UOM_DESC");
			displayFields.add("MODULE_ID");//Added by suresh.r on 29-09-2014 against Inc 51460


			
		// Adding function related array list into the HashMap
			funcMap.put("displayFields", displayFields);
			funcMap.put("chkFields", chkFields);
			
			System.err.println("sqlMap===="+sqlMap);
			
			ArrayList result		=		(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
			
			int recCount=0,i = 0;
			if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){
	
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(result.get(1)));
            _bw.write(_wl_block11Bytes, _wl_block11);
 if(trn_type.equals("SAL") || trn_type.equals("SRT")){
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
} 
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
 if(iss_ack_req_yn.equals("Y") || ret_ack_req_yn.equals("Y") || tfr_ack_req_yn.equals("Y"))
			         {
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
}
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

			ArrayList records=null;
			for(recCount=2,i=0; recCount<result.size(); recCount++,i++){
				if (recCount % 2 == 0)
					classvalue = "QRYODD" ;
				else
					classvalue = "QRYEVEN" ;
		
            _bw.write(_wl_block21Bytes, _wl_block21);

				records=(ArrayList) result.get(recCount);
		    String ack_status = bean.checkForNull((String)records.get(4),"NA");
		    String ack_status2 = bean.checkForNull((String)records.get(5),"NA");
		 		if (ack_status.equals(" "))
				{
			     ack_status = "NA";
				}
				if (ack_status2.equals(" "))
				{
			     ack_status2 = "NA";
				}
				if((trn_type.equals("ACK"))&&(ack_status.equals("NA"))&&(ack_status2.equals("NA"))){
					//continue;  //commented by Ganga , Results are not displaying if NA
				}
		//out.println("@@@@@@@@"+records);
		
            _bw.write(_wl_block22Bytes, _wl_block22);
 if(trn_type.equals("SAL") || trn_type.equals("SRT")){
							//Added by suresh.r on 28-04-2015 against Inc 55191 beg
							if(iss_ack_req_yn.equals("Y") || ret_ack_req_yn.equals("Y") || tfr_ack_req_yn.equals("Y")){
								disp_module_id=(String)records.get(14);
							}else{
								disp_module_id=(String)records.get(12);
							}
							//if(((String)records.get(14)).equals("ST")){
							if(disp_module_id.equals("ST")){ //Added by suresh.r on 28-04-2015 against Inc 55191 end
								module_id="Inventory";
							}else{
								module_id="Pharmacy";
							}
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
} 
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(records.get(0)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(records.get(1)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bean.checkForNull((String)records.get(2)).equals("0")?"&nbsp;":records.get(2)));
            _bw.write(_wl_block29Bytes, _wl_block29);

			         if(iss_ack_req_yn.equals("Y") || ret_ack_req_yn.equals("Y") || tfr_ack_req_yn.equals("Y"))
			         {
			         
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate((String)records.get(12),"DMY","en",locale)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(records.get(3)));
            _bw.write(_wl_block31Bytes, _wl_block31);
 if(ack_status.equals("NA") && ack_status2.equals("NA")) {
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(space));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(space));
            _bw.write(_wl_block33Bytes, _wl_block33);
 }
            _bw.write(_wl_block34Bytes, _wl_block34);
 if(ack_status.equals("PA") && ack_status2.equals("CP")) { 
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(enabled));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(enabled));
            _bw.write(_wl_block29Bytes, _wl_block29);
 }
            _bw.write(_wl_block36Bytes, _wl_block36);
 if(ack_status2.equals("CP") && ack_status.equals("NA")) { 
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(space));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(enabled));
            _bw.write(_wl_block29Bytes, _wl_block29);
 }
            _bw.write(_wl_block34Bytes, _wl_block34);
 if(ack_status.equals("PA") && ack_status2.equals("NA") ) {
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(enabled));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(space));
            _bw.write(_wl_block29Bytes, _wl_block29);
 }
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(records.get(6)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(records.get(7)));
            _bw.write(_wl_block33Bytes, _wl_block33);

						 //String batch_id=(String)records.get(5);
					boolean value=com.ehis.util.DateUtils.validDate((String)records.get(8),"DMY",locale);
					if(value)
				{
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate((String)records.get(8),"DMY","en",locale)));
            _bw.write(_wl_block40Bytes, _wl_block40);
}else
				{
				/**
				* @Name - Krishna Kiran 
				* @Date - 19/01/2010
				* @Inc# - 15496 (SRR20056-CRF-0537.2)
				* @Desc - added bean.setNumber() function to records.get(8)to handle the decimal values
				*/	
				
				
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(bean.setNumber(records.get(8).toString(),no_of_decimals)));
            _bw.write(_wl_block43Bytes, _wl_block43);
}
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(records.get(13)));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(records.get(9)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(records.get(10)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate((String)records.get(11),"DMY","en",locale)));
            _bw.write(_wl_block45Bytes, _wl_block45);
} else {
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate((String)records.get(10),"DMY","en",locale)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(records.get(3)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(records.get(4)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(records.get(5)));
            _bw.write(_wl_block47Bytes, _wl_block47);
/**
				* @Name - Krishna Kiran 
				* @Date - 01/02/2010
				* @Inc# - 15496 (SRR20056-CRF-0537.2)
				* @Desc - added bean.setNumber() function to records.get(6)to handle the decimal values
				*/	
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(bean.setNumber(records.get(6).toString(),no_of_decimals)));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(records.get(11)));
            _bw.write(_wl_block29Bytes, _wl_block29);

						 //String batch_id=(String)records.get(5);
					boolean value=com.ehis.util.DateUtils.validDate((String)records.get(7),"DMY",locale);
                    if(value)
				{
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate((String)records.get(7),"DMY","en",locale)));
            _bw.write(_wl_block40Bytes, _wl_block40);
}else
				{
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(records.get(7)));
            _bw.write(_wl_block47Bytes, _wl_block47);
}
				
				
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(records.get(8).toString()));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate((String)records.get(9),"DMY","en",locale)));
            _bw.write(_wl_block54Bytes, _wl_block54);
}
            _bw.write(_wl_block55Bytes, _wl_block55);

					 }
		
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf( bean_name));
            _bw.write(_wl_block58Bytes, _wl_block58);

			out.flush();
		} 
		else{
		
            _bw.write(_wl_block59Bytes, _wl_block59);

		}
		out.println(CommonBean.setForm (request ,"../../eST/jsp/BlockedBatchesQueryResult.jsp", searched));
	
	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}

            _bw.write(_wl_block2Bytes, _wl_block2);

putObjectInBean(bean_id,bean,request);

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Module.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DocType.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DocNo.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.SeqNo.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DocDate.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Store.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.PendingAck.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.PendingConf.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ItemCode.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ItemDescription.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.TransQty.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.uom.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BatchID.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BinLocation.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.expiryDate.label", java.lang.String .class,"key"));
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
}
