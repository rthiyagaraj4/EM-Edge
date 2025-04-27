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
import java.lang.*;
import eCommon.XSSRequestWrapper;
import eCommon.Common.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __requisitionissueauthorizequeryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/RequisitionIssueAuthorizeQueryResult.jsp", 1729677609900L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' ></link>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\'javascript\' src=\'../../eST/js/StCommon.js\'></script>\n\t\t<script language=\'javascript\' src=\'../../eST/js/AuthorizeAtIssueStore.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t<body>\n\t<form name=\"formRIAuthorizeQueryResult\" id=\"formRIAuthorizeQueryResult\">\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<table cellpadding=0 cellspacing=0 width=\"100%\" align=\"center\" >\n\t\t\t<tr>\n\t\t\t\t<td width=\"80%\" class=\"white\">&nbsp;</td>\n\t\t\t\t<td width=\"20%\" class=\"white\">&nbsp;\n\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"  id=\'tb1\' align=\"center\">\n\t\t\t\t<tr>\n\t\t\t\t    <th>&nbsp;</th>\n\t\t\t\t\t<th width=\'260\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n\t\t\t\t\t<th width=\'125\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n\t\t\t\t\t<th width=\'260\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\t\t\t\t</tr>\t\n\t\t\t\t\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t<tr id=\"tr_";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t\t\t\t <td class=\"STLIGHTCREAM\" bgcolor=\"#FFC6AA\" onClick=\"displayRequestDocument(\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\',\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\');\" onmouseover=\"changeCursor(this);\"  ><font class=\'HYPERLINK\'>+</font>\n\t\t\t\t</td>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" onClick=\"loadRequestDetail(tr_";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =",\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\');\" onmouseover=\"changeCursor(this);\" nowrap><font class=\'HYPERLINK\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</font></td>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" onclick=\"disableClick(event);\" >";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" onclick=\"disableClick(event);\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t\t\t<td class=\'NODISPLAY\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n<!-- \t\t\t\t<td class=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' nowrap>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n -->\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t</table>\n\t\t<input type=\"hidden\" name=\"checkedIndices\" id=\"checkedIndices\"\t\t\tvalue=\"\" %>\n\t\t<input type=\"hidden\" name=\"total_check_boxes\" id=\"total_check_boxes\"\t\tvalue=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t</form>\n\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t<script>\n\t\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));\n\t\t\t\tdocument.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\t//history.go(-1);\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );
	
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
Date       		Edit History      	Name       	Rev.Date   		Rev.By    	Description
--------------------------------------------------------------------------------------------------------------
21/04/2016		56060			B.Badmavathi					 	PMG2015-CRF-INT-ST-0001	Authorize at Issue Store Privilges
---------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	
				String locale			=	(String)session.getAttribute("LOCALE");
				String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

		String bean_id				=		"authorizeAtIssueStoreBean";
		String bean_name			=		"eST.AuthorizeAtIssueStoreBean";
		AuthorizeAtIssueStoreBean bean  =	(AuthorizeAtIssueStoreBean) getBeanObject(bean_id, bean_name,request); 
		String doc_type_code		=		request.getParameter("doc_type_code");
		String doc_no				=		request.getParameter("doc_no");
		String from_doc_date		=		request.getParameter("from_doc_date");
		//from_doc_date				=		com.ehis.util.DateUtils.convertDate(from_doc_date,"DMY",locale,"en");
		
		String to_doc_date			=		request.getParameter("to_doc_date");
		//to_doc_date					=		com.ehis.util.DateUtils.convertDate(to_doc_date,"DMY",locale,"en");
		

		String request_by_store		=		request.getParameter("request_by_store");
		String request_on_store		=		request.getParameter("request_on_store");
		String item_class_code		=		request.getParameter("item_class_code");
		String request_type			=		request.getParameter("request_type");
		String request_status		=		request.getParameter("request_status");
		String req_status			=		"";
		String language_id			=		request.getParameter("language_id");
		String facility_check		=		"";
		//String request_status		=		request.getParameter("request_status");
	    String item_code = request.getParameter("item_code");
		boolean searched			=		(request.getParameter("searched") == null) ?false:true;
		String classvalue			=		"";
		HashMap sqlMap				=		new HashMap();
		HashMap funcMap				=		new HashMap();
		ArrayList displayFields		=		new ArrayList();
		ArrayList chkFields			=		new ArrayList();
		ArrayList result			=		new ArrayList();
		ArrayList records			=		new ArrayList();
		
		try{
		   //Added by Rabbani #inc no :29579 on 20/01/12
	   if(from_doc_date!= "") 
	   from_doc_date = com.ehis.util.DateUtils.convertDate(from_doc_date,"DMY",locale,"en");
       else
	      from_doc_date		=	"";
		   
	       if(to_doc_date!= "") 
	      to_doc_date = com.ehis.util.DateUtils.convertDate(to_doc_date,"DMY",locale,"en");
		  else 
	         to_doc_date		=	"";
 
			CommonBean.setLoginFacilityId((String) session.getValue("facility_id"));
			doc_no					=		CommonBean.checkForNull(doc_no,"%");
			doc_type_code			=		CommonBean.checkForNull(doc_type_code,"%");
			//from_doc_date			=		CommonBean.checkForNull(from_doc_date,"");
			//to_doc_date				=		CommonBean.checkForNull(to_doc_date,"");
			request_by_store		=		CommonBean.checkForNull(request_by_store,"%");
			request_on_store		=		CommonBean.checkForNull(request_on_store,"%");
			item_class_code			=		CommonBean.checkForNull(item_class_code,"%");
			request_type			=		CommonBean.checkForNull(request_type,"%");
			item_code               =       CommonBean.checkForNull(item_code,"%");
			request_status          =       CommonBean.checkForNull(request_status,"%").trim();
           
			//sqlMap.put("sqlData", "SELECT HDR.DOC_TYPE_CODE, SY.SHORT_DESC DOC_TYPE_DESC,HDR.DOC_NO, TO_CHAR(HDR.DOC_DATE,'DD/MM/YYYY') DOC_DATE, HDR.REQ_BY_STORE_CODE,  RBYS.SHORT_DESC REQ_BY_STORE_DESC,HDR.REQ_ON_STORE_CODE, RONS.SHORT_DESC REQ_ON_STORE_DESC, HDR.ITEM_CLASS_CODE, ITM.SHORT_DESC ITEM_CLASS_DESC,DECODE ((ST_REQ_STATUS_CHK(HDR.FACILITY_ID,                    HDR.DOC_TYPE_CODE, HDR.DOC_NO )),'PAI','Partially Authorised/Issued At Issue Store','PA', 'Partially Authorised At Issue Store','FAPI','Fully Authorised/Partially Issued At Issue Store', 'FA','FULLY Authorised At Issue Store','C','Issue Canceled', 'L','Issue Closed', 'A','Authorised At Issue Store','W','Authorised At Request By Store') REQUEST_STATUS, HDR.FACILITY_ID REQ_STORE_FACILITY_ID, SM.FACILITY_NAME REQ_STORE_FACILITY_NAME FROM ST_REQUEST_HDR HDR, MM_STORE_LANG_VW RBYS,MM_STORE_LANG_VW RONS, MM_ITEM_CLASS_LANG_VW ITM, SY_DOC_TYPE_MASTER_LANG_VW SY, ST_USER_ACCESS_FOR_STORE UACA, ST_STORE UACB, ST_ACC_ENTITY_PARAM STP  , SM_FACILITY_PARAM_LANG_VW SM, ST_REQUEST_DTL DTL, MM_ITEM_LANG_VW MMVW WHERE HDR.DOC_TYPE_CODE = SY.DOC_TYPE_CODE  AND HDR.REQ_BY_STORE_CODE=  RBYS.STORE_CODE AND  HDR.REQ_ON_STORE_CODE = RONS.STORE_CODE  AND HDR.ITEM_CLASS_CODE = ITM.ITEM_CLASS_CODE(+) AND HDR.CANCELLED_BY_ID IS NULL  AND HDR.REQ_AUTHORIZED_BY_ID IS NOT NULL AND HDR.DOC_TYPE_CODE LIKE ? AND TO_CHAR(HDR.DOC_NO) LIKE  ?  AND (HDR.DOC_DATE BETWEEN TO_DATE(NVL(?,'01/01/1901'),'DD/MM/YYYY') AND TO_DATE(NVL(?,'31/12/3012'),'DD/MM/YYYY'))  AND HDR.REQ_BY_STORE_CODE LIKE ? AND HDR.REQ_ON_STORE_CODE LIKE ? AND  NVL(HDR.ITEM_CLASS_CODE,'X') LIKE ?  AND UACA.USER_ID = ? AND UACA.STORE_CODE = HDR.REQ_ON_STORE_CODE AND UACA.ISS_ALLOWED_YN = 'Y'  AND DOC_SRL_NO = (SELECT MIN(DOC_SRL_NO)  FROM ST_REQUEST_DTL WHERE FACILITY_ID = DTL.FACILITY_ID AND   DOC_TYPE_CODE = DTL.DOC_TYPE_CODE AND   DOC_NO = DTL.DOC_NO)/*AND UACB.USER_ID = UACA.USER_ID*/ AND UACB.STORE_CODE = HDR.REQ_BY_STORE_CODE AND UACB.REQ_ALLOWED_YN = 'Y'  AND ST_REQ_ISSUE_CHK(HDR.FACILITY_ID, HDR.DOC_TYPE_CODE, HDR.DOC_NO)<>'2'  AND RBYS.EXTERNAL_YN LIKE DECODE(?,'Y','Y','N','N','%') AND HDR.TRN_TYPE = 'ISS' AND ST_REQ_STATUS_CHK (HDR.FACILITY_ID, HDR.DOC_TYPE_CODE, HDR.DOC_NO) LIKE ? AND  ST_REQ_STATUS_CHK (HDR.FACILITY_ID, HDR.DOC_TYPE_CODE, HDR.DOC_NO) <> 'FA' AND HDR.REQUEST_STATUS NOT IN('C','L','E') AND RONS.FACILITY_ID = ? /*(HDR.FACILITY_ID LIKE DECODE(TRN_ACROSS_FACILITY_YN,'Y','%',?))*/ AND HDR.FACILITY_ID = SM.FACILITY_ID  AND RBYS.LANGUAGE_ID = RONS.LANGUAGE_ID AND RBYS.LANGUAGE_ID = SY.LANGUAGE_ID AND RBYS.LANGUAGE_ID = SM.LANGUAGE_ID AND RBYS.LANGUAGE_ID = ? AND ITM.LANGUAGE_ID(+) = ? AND STP.ACC_ENTITY_ID = 'ZZ' AND RBYS.FACILITY_ID LIKE DECODE (TRN_ACROSS_FACILITY_YN,'Y', '%', ?) AND HDR.DOC_NO = DTL.DOC_NO AND HDR.DOC_TYPE_CODE = DTL.DOC_TYPE_CODE AND HDR.FACILITY_ID = DTL.FACILITY_ID AND DTL.ITEM_CODE = MMVW.ITEM_CODE  AND MMVW.LANGUAGE_ID = RBYS.LANGUAGE_ID  AND  DTL.COMMITTED_ITEM_QTY = 0 AND DTL.ITEM_CODE LIKE ? AND DTL.ITEM_CODE NOT IN (SELECT DISTINCT ITEM_CODE FROM ST_ISSUE_DTL IDTL, ST_ISSUE_HDR IHDR WHERE IHDR.DOC_NO = IDTL.DOC_NO AND IHDR.DOC_TYPE_CODE = IDTL.DOC_TYPE_CODE AND IHDR.FACILITY_ID = IDTL.FACILITY_ID AND IHDR.SEQ_NO = IDTL.SEQ_NO AND IHDR.DOC_NO = HDR.DOC_NO AND IHDR.FINALIZED_YN = 'D' AND IHDR.FACILITY_ID = ?)");
			//sqlMap.put("sqlData", "SELECT HDR.DOC_TYPE_CODE, SY.SHORT_DESC DOC_TYPE_DESC,HDR.DOC_NO, TO_CHAR(HDR.DOC_DATE,'DD/MM/YYYY') DOC_DATE, HDR.REQ_BY_STORE_CODE,  RBYS.SHORT_DESC REQ_BY_STORE_DESC,HDR.REQ_ON_STORE_CODE, RONS.SHORT_DESC REQ_ON_STORE_DESC, HDR.ITEM_CLASS_CODE, ITM.SHORT_DESC ITEM_CLASS_DESC,ST_REQ_STATUS_CHK(HDR.FACILITY_ID,HDR.DOC_TYPE_CODE, HDR.DOC_NO) REQUEST_STATUS, HDR.FACILITY_ID REQ_STORE_FACILITY_ID, SM.FACILITY_NAME REQ_STORE_FACILITY_NAME  FROM ST_REQUEST_HDR HDR, MM_STORE_LANG_VW RBYS,MM_STORE_LANG_VW RONS, MM_ITEM_CLASS_LANG_VW ITM, SY_DOC_TYPE_MASTER_LANG_VW SY, ST_USER_ACCESS_FOR_STORE UACA, ST_STORE UACB, ST_ACC_ENTITY_PARAM STP  , SM_FACILITY_PARAM_LANG_VW SM, ST_REQUEST_DTL DTL, MM_ITEM_LANG_VW MMVW WHERE    (HDR.DOC_DATE BETWEEN TO_DATE (NVL (?, '01/01/1901'), 'DD/MM/YYYY') AND TO_DATE (NVL (?, '31/12/3012'), 'DD/MM/YYYY')) AND HDR.DOC_TYPE_CODE LIKE ?   AND HDR.REQ_BY_STORE_CODE LIKE ? AND  TO_CHAR (HDR.DOC_NO) LIKE ?  AND HDR.DOC_TYPE_CODE = SY.DOC_TYPE_CODE   AND HDR.REQ_BY_STORE_CODE = RBYS.STORE_CODE   AND HDR.REQ_ON_STORE_CODE = RONS.STORE_CODE   AND HDR.ITEM_CLASS_CODE = ITM.ITEM_CLASS_CODE(+)   AND HDR.CANCELLED_BY_ID IS NULL   AND HDR.REQ_AUTHORIZED_BY_ID IS NOT NULL     AND HDR.REQ_ON_STORE_CODE LIKE ?   AND NVL (HDR.ITEM_CLASS_CODE, 'X') LIKE ?   AND UACA.USER_ID = ?   AND UACA.STORE_CODE = HDR.REQ_ON_STORE_CODE   AND UACA.ISS_ALLOWED_YN = 'Y'   AND DOC_SRL_NO = (SELECT MIN (DOC_SRL_NO) FROM ST_REQUEST_DTL            WHERE FACILITY_ID = DTL.FACILITY_ID AND DOC_NO = DTL.DOC_NO  AND DOC_TYPE_CODE = DTL.DOC_TYPE_CODE) /*AND UACB.USER_ID = UACA.USER_ID*/  AND UACB.STORE_CODE = HDR.REQ_BY_STORE_CODE  AND UACB.REQ_ALLOWED_YN = 'Y'   AND ST_REQ_ISSUE_CHK (HDR.FACILITY_ID, HDR.DOC_TYPE_CODE, HDR.DOC_NO) <> '2'   AND RBYS.EXTERNAL_YN LIKE DECODE( ?, 'Y', 'Y', 'N', 'N', '%')   AND HDR.TRN_TYPE = 'ISS'   AND HDR.REQUEST_STATUS NOT IN ('C', 'L', 'E')   AND RONS.FACILITY_ID =          ?/*(HDR.FACILITY_ID LIKE DECODE(stp.trn_across_facility_yn,'Y','%',''))*/   AND HDR.FACILITY_ID = SM.FACILITY_ID   AND RBYS.LANGUAGE_ID = RONS.LANGUAGE_ID   AND RBYS.LANGUAGE_ID = SY.LANGUAGE_ID   AND RBYS.LANGUAGE_ID = SM.LANGUAGE_ID   AND RBYS.LANGUAGE_ID =?   AND ITM.LANGUAGE_ID(+) =?   AND STP.ACC_ENTITY_ID = 'ZZ'   AND RBYS.FACILITY_ID LIKE DECODE (TRN_ACROSS_FACILITY_YN, 'Y', '%', ?)  AND HDR.DOC_NO = DTL.DOC_NO   AND HDR.DOC_TYPE_CODE = DTL.DOC_TYPE_CODE   AND HDR.FACILITY_ID = DTL.FACILITY_ID   AND DTL.ITEM_CODE = MMVW.ITEM_CODE   AND MMVW.LANGUAGE_ID = RBYS.LANGUAGE_ID   AND DTL.COMMITTED_ITEM_QTY = 0   AND DTL.ITEM_CODE LIKE ?   AND NOT EXISTS (  SELECT 'X' FROM ST_ISSUE_DTL IDTL, ST_ISSUE_HDR IHDR           WHERE IHDR.FACILITY_ID = IDTL.FACILITY_ID  AND IHDR.DOC_NO = IDTL.DOC_NO AND IHDR.DOC_TYPE_CODE = IDTL.DOC_TYPE_CODE             AND IHDR.DOC_NO = HDR.DOC_NO AND IHDR.SEQ_NO = IDTL.SEQ_NO             AND IDTL.ITEM_CODE = DTL.ITEM_CODE AND IHDR.FINALIZED_YN = 'D' AND IHDR.FACILITY_ID = ?)");
			//out.println("AuthorizeQuery");
			//this is commented for authorization restriction at two different facility by gangadharan and sakti on 15/06/2011 against INC27786 
			//sqlMap.put("sqlData","SELECT distinct hdr.doc_type_code, 	   (SELECT short_desc FROM sy_doc_type_master_lang_vw WHERE hdr.doc_type_code = doc_type_code AND language_id = ?)doc_type_desc, 	   hdr.doc_no,        TO_CHAR (hdr.doc_date, 'DD/MM/YYYY') doc_date, 	   hdr.req_by_store_code,        rbys.short_desc req_by_store_desc, 	   hdr.req_on_store_code,        (SELECT short_desc FROM mm_store_lang_vw WHERE hdr.req_on_store_code = store_code AND language_id = ?)req_on_store_desc, 	   hdr.item_class_code,        (SELECT short_desc FROM mm_item_class_lang_vw WHERE hdr.item_class_code = item_class_code AND language_id =?)  item_class_desc,        st_req_status_chk (hdr.facility_id,                           hdr.doc_type_code,                           hdr.doc_no                          ) request_status,        hdr.facility_id req_store_facility_id,        (SELECT facility_name FROM sm_facility_param_lang_vw WHERE hdr.facility_id = facility_id AND language_id = ? )req_store_facility_name   FROM st_request_hdr hdr,        mm_store_lang_vw rbys,        st_user_access_for_store uaca,        st_store uacb,        st_acc_entity_param stp,        st_request_dtl dtl  WHERE (hdr.doc_date BETWEEN TO_DATE (NVL (?, '01/01/1901'), 'DD/MM/YYYY')                          AND TO_DATE (NVL (?, '31/12/3012'), 'DD/MM/YYYY')        )    AND hdr.doc_type_code LIKE ?    AND hdr.req_by_store_code LIKE ?    AND TO_CHAR (hdr.doc_no) LIKE ?    AND hdr.req_by_store_code = rbys.store_code    AND hdr.cancelled_by_id IS NULL    AND hdr.req_authorized_by_id IS NOT NULL    AND hdr.req_on_store_code LIKE ?    AND NVL (hdr.item_class_code, 'X') LIKE ?    AND uaca.user_id = ?    AND uaca.store_code = hdr.req_on_store_code    AND uaca.iss_allowed_yn = 'Y'   /* AND doc_srl_no =           (SELECT MIN (doc_srl_no)              FROM st_request_dtl             WHERE facility_id = dtl.facility_id               AND doc_no = dtl.doc_no               AND doc_type_code = dtl.doc_type_code) */   AND uacb.store_code = hdr.req_by_store_code    AND uacb.req_allowed_yn = 'Y'    AND st_req_issue_chk (hdr.facility_id, hdr.doc_type_code, hdr.doc_no) <>                                                                            '2'    AND rbys.external_yn LIKE DECODE (?, 'Y', 'Y', 'N', 'N', '%')    AND hdr.trn_type = 'ISS'    AND hdr.request_status NOT IN ('C', 'L', 'E')    AND rbys.language_id =?    AND stp.acc_entity_id ='ZZ'    AND rbys.facility_id LIKE DECODE (trn_across_facility_yn, 'Y', '%',?)    AND hdr.doc_no = dtl.doc_no    AND hdr.doc_type_code = dtl.doc_type_code    AND hdr.facility_id = dtl.facility_id    AND dtl.committed_item_qty = 0    AND dtl.item_code LIKE ?    AND NOT EXISTS (           SELECT 'X'             FROM st_issue_dtl idtl, st_issue_hdr ihdr            WHERE ihdr.facility_id = idtl.facility_id              AND ihdr.doc_no = idtl.doc_no              AND ihdr.doc_type_code = idtl.doc_type_code              AND ihdr.doc_no = hdr.doc_no              AND ihdr.seq_no = idtl.seq_no             /* AND idtl.item_code = dtl.item_code*/              AND ihdr.finalized_yn = 'D'              AND ihdr.facility_id = ? )");
			//Commented By Rabbani against inc no: 30966 on 16/03/2012
			//sqlMap.put("sqlData","SELECT distinct hdr.doc_type_code, 	   (SELECT short_desc FROM sy_doc_type_master_lang_vw WHERE hdr.doc_type_code = doc_type_code AND language_id = ?)doc_type_desc, 	   hdr.doc_no,        TO_CHAR (hdr.doc_date, 'DD/MM/YYYY') doc_date, 	   hdr.req_by_store_code,        rbys.short_desc req_by_store_desc, 	   hdr.req_on_store_code,        (SELECT short_desc FROM mm_store_lang_vw WHERE hdr.req_on_store_code = store_code AND language_id = ?)req_on_store_desc, 	   hdr.item_class_code,        (SELECT short_desc FROM mm_item_class_lang_vw WHERE hdr.item_class_code = item_class_code AND language_id =?)  item_class_desc,        st_req_status_chk (hdr.facility_id,                           hdr.doc_type_code,                           hdr.doc_no                          ) request_status,        hdr.facility_id req_store_facility_id,        (SELECT facility_name FROM sm_facility_param_lang_vw WHERE hdr.facility_id = facility_id AND language_id = ? )req_store_facility_name   FROM st_request_hdr hdr,        mm_store_lang_vw rbys,        st_user_access_for_store uaca,        st_store uacb,        st_acc_entity_param stp,        st_request_dtl dtl  WHERE (hdr.doc_date BETWEEN TO_DATE (NVL (?, '01/01/1901'), 'DD/MM/YYYY')                          AND TO_DATE (NVL (?, '31/12/3012'), 'DD/MM/YYYY')        )    AND hdr.doc_type_code LIKE ?    AND hdr.req_by_store_code LIKE ?    AND TO_CHAR (hdr.doc_no) LIKE ?    AND hdr.req_by_store_code = rbys.store_code    AND hdr.cancelled_by_id IS NULL    AND hdr.req_authorized_by_id IS NOT NULL    AND hdr.req_on_store_code LIKE ?    AND NVL (hdr.item_class_code, 'X') LIKE ?    AND uaca.user_id = ?    AND uaca.store_code = hdr.req_on_store_code    AND uaca.iss_allowed_yn = 'Y'   /* AND doc_srl_no =           (SELECT MIN (doc_srl_no)              FROM st_request_dtl             WHERE facility_id = dtl.facility_id               AND doc_no = dtl.doc_no               AND doc_type_code = dtl.doc_type_code) */   AND uacb.store_code = hdr.req_by_store_code    AND uacb.req_allowed_yn = 'Y'    AND st_req_issue_chk (hdr.facility_id, hdr.doc_type_code, hdr.doc_no) <>                                                                            '2'    AND rbys.external_yn LIKE DECODE (?, 'Y', 'Y', 'N', 'N', '%')    AND hdr.trn_type = 'ISS'    AND hdr.request_status NOT IN ('C', 'L', 'E')    AND rbys.language_id =?    AND stp.acc_entity_id ='ZZ'    AND rbys.facility_id LIKE DECODE (trn_across_facility_yn, 'Y', '%',?)    AND hdr.doc_no = dtl.doc_no    AND hdr.doc_type_code = dtl.doc_type_code    AND hdr.facility_id = dtl.facility_id    AND dtl.committed_item_qty = 0    AND dtl.item_code LIKE ?    AND NOT EXISTS (           SELECT 'X'             FROM st_issue_dtl idtl, st_issue_hdr ihdr            WHERE ihdr.facility_id = idtl.facility_id              AND ihdr.doc_no = idtl.doc_no              AND ihdr.doc_type_code = idtl.doc_type_code              AND ihdr.doc_no = hdr.doc_no              AND ihdr.seq_no = idtl.seq_no             /* AND idtl.item_code = dtl.item_code*/              AND ihdr.finalized_yn = 'D'              AND ihdr.facility_id = ? )  	and exists ( select facility_id from mm_store where store_code = hdr.req_on_store_code    and facility_id = ?) ");
			
			
			//Added  By Rabbani against inc no: 30966 on 16/03/2012
			//commented by Rabbani on 19-MAR-2013 for Performance issue
			//sqlMap.put("sqlData","SELECT distinct hdr.doc_type_code, 	   (SELECT short_desc FROM sy_doc_type_master_lang_vw WHERE hdr.doc_type_code = doc_type_code AND language_id = ?)doc_type_desc, 	   hdr.doc_no,        TO_CHAR (hdr.doc_date, 'DD/MM/YYYY') doc_date, 	   hdr.req_by_store_code,        rbys.short_desc req_by_store_desc, 	   hdr.req_on_store_code,        (SELECT short_desc FROM mm_store_lang_vw WHERE hdr.req_on_store_code = store_code AND language_id = ?)req_on_store_desc, 	   hdr.item_class_code,        (SELECT short_desc FROM mm_item_class_lang_vw WHERE hdr.item_class_code = item_class_code AND language_id =?)  item_class_desc,        st_req_status_chk (hdr.facility_id,                           hdr.doc_type_code,                           hdr.doc_no                          ) request_status,        hdr.facility_id req_store_facility_id,        (SELECT facility_name FROM sm_facility_param_lang_vw WHERE hdr.facility_id = facility_id AND language_id = ? )req_store_facility_name   FROM st_request_hdr hdr,        mm_store_lang_vw rbys,        st_user_access_for_store uaca,        st_store uacb,        st_acc_entity_param stp,        st_request_dtl dtl  WHERE (hdr.doc_date BETWEEN TO_DATE (NVL (?, '01/01/1901'), 'DD/MM/YYYY')                          AND TO_DATE (NVL (?, '31/12/3012'), 'DD/MM/YYYY')        )    AND hdr.doc_type_code LIKE ?    AND hdr.req_by_store_code LIKE ?    AND TO_CHAR (hdr.doc_no) LIKE ?    AND hdr.req_by_store_code = rbys.store_code    AND hdr.cancelled_by_id IS NULL    AND hdr.req_authorized_by_id IS NOT NULL    AND hdr.req_on_store_code LIKE ?    AND NVL (hdr.item_class_code, 'X') LIKE ?    AND uaca.user_id = ?    AND uaca.store_code = hdr.req_on_store_code    AND uaca.iss_allowed_yn = 'Y'   /* AND doc_srl_no =           (SELECT MIN (doc_srl_no)              FROM st_request_dtl             WHERE facility_id = dtl.facility_id               AND doc_no = dtl.doc_no               AND doc_type_code = dtl.doc_type_code) */   AND uacb.store_code = hdr.req_by_store_code    AND uacb.req_allowed_yn = 'Y'    AND st_req_issue_chk (hdr.facility_id, hdr.doc_type_code, hdr.doc_no) <>                                                                            '2'    AND rbys.external_yn LIKE DECODE (?, 'Y', 'Y', 'N', 'N', '%')    AND hdr.trn_type = 'ISS'    AND hdr.request_status NOT IN ('C', 'L', 'E')    AND rbys.language_id =?    AND stp.acc_entity_id ='ZZ'    AND rbys.facility_id LIKE DECODE (trn_across_facility_yn, 'Y', '%',?)    AND hdr.doc_no = dtl.doc_no    AND hdr.doc_type_code = dtl.doc_type_code    AND hdr.facility_id = dtl.facility_id    AND dtl.committed_item_qty = 0    AND dtl.item_code LIKE ?    AND NOT EXISTS (           SELECT 'X'             FROM st_issue_dtl idtl, st_issue_hdr ihdr            WHERE ihdr.facility_id = idtl.facility_id              AND ihdr.doc_no = idtl.doc_no              AND ihdr.doc_type_code = idtl.doc_type_code              AND ihdr.doc_no = hdr.doc_no              AND ihdr.seq_no = idtl.seq_no             /* AND idtl.item_code = dtl.item_code*/              AND ihdr.finalized_yn = 'D'              AND ihdr.facility_id = ? )  	and exists ( select facility_id from mm_store where store_code = hdr.req_on_store_code    and facility_id = ?)  AND (st_req_status_chk (hdr.facility_id,hdr.doc_type_code,hdr.doc_no )) LIKE ? ");
			
			//Added by Rabbani on 19-MAR-2013 For Performance issue Starts
			String  sql  = " SELECT distinct hdr.doc_type_code,(SELECT short_desc FROM sy_doc_type_master_lang_vw WHERE hdr.doc_type_code = doc_type_code AND language_id = ?)doc_type_desc,  hdr.doc_no,  TO_CHAR (hdr.doc_date, 'DD/MM/YYYY') doc_date, 	   hdr.req_by_store_code, rbys.short_desc req_by_store_desc, 	   hdr.req_on_store_code, (SELECT short_desc FROM mm_store_lang_vw WHERE hdr.req_on_store_code = store_code AND language_id = ?)req_on_store_desc, hdr.item_class_code,  (SELECT short_desc FROM mm_item_class_lang_vw WHERE hdr.item_class_code = item_class_code AND language_id =?)  item_class_desc,  st_req_status_chk (hdr.facility_id,  hdr.doc_type_code, hdr.doc_no) request_status, hdr.facility_id req_store_facility_id, (SELECT facility_name FROM sm_facility_param_lang_vw WHERE hdr.facility_id = facility_id AND language_id = ? )req_store_facility_name   FROM st_request_hdr hdr, mm_store_lang_vw rbys, st_user_access_for_store uaca, st_store uacb,        st_acc_entity_param stp,  st_request_dtl dtl  WHERE   hdr.trn_type = 'ISS' ";
			
			chkFields.add(language_id);
		    chkFields.add(language_id);
		    chkFields.add(language_id);
		    chkFields.add(language_id);
			if(!(from_doc_date.equals("")) && !(to_doc_date.equals(""))){
			sql = sql +"  AND (hdr.doc_date BETWEEN TO_DATE (?, 'DD/MM/YYYY')  AND TO_DATE (?, 'DD/MM/YYYY'))";
			chkFields.add(from_doc_date);
			chkFields.add(to_doc_date);
			}
			else if(from_doc_date.equals("") && !(to_doc_date.equals("") )){
			sql = sql +" AND (hdr.doc_date BETWEEN TO_DATE ('01/01/1901', 'DD/MM/YYYY')  AND TO_DATE (?, 'DD/MM/YYYY'))";
			chkFields.add(to_doc_date);
			}
			else if(!(from_doc_date.equals("")) && (to_doc_date.equals("") )){
			sql = sql +" AND (hdr.doc_date BETWEEN TO_DATE (?, 'DD/MM/YYYY')  AND SYSDATE)";
			chkFields.add(from_doc_date);
			}

			if(!(doc_type_code.equals("%"))){
			 sql = sql + " and hdr.doc_type_code = ? " ;
			 chkFields.add(doc_type_code);
			}
			if(!(request_by_store.equals("%"))){
			sql = sql + " and hdr.req_by_store_code = ? " ;
			chkFields.add(request_by_store);
			}
			if(!(doc_no.equals("%"))){
			sql = sql + " and TO_CHAR (hdr.doc_no) = ? " ;
			chkFields.add(doc_no);
			}
			sql = sql + " and hdr.req_by_store_code = rbys.store_code    AND hdr.cancelled_by_id IS NULL    AND hdr.req_authorized_by_id IS NOT NULL";
			if(!(request_on_store.equals("%"))){
			sql = sql + " and hdr.req_on_store_code = ? " ;
			chkFields.add(request_on_store);
			}
			if(!(item_class_code.equals("%"))){
			sql = sql + " and NVL (hdr.item_class_code, 'X') = ? " ;
			chkFields.add(item_class_code);
			}
			//Modified by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001 starts
			if(bean.getAllow_Auth_Issue_store().equals("N")){
				sql = sql + " AND uaca.user_id = ?    AND uaca.store_code = hdr.req_on_store_code    AND uaca.iss_allowed_yn = 'Y'    AND uacb.store_code = hdr.req_by_store_code    AND uacb.req_allowed_yn = 'Y'    AND st_req_issue_chk (hdr.facility_id, hdr.doc_type_code, hdr.doc_no) <>  '2' ";
			}else{ 
				sql = sql + " AND uaca.user_id = ?    AND uaca.store_code = hdr.req_on_store_code    AND uacb.store_code = hdr.req_by_store_code    AND uacb.req_allowed_yn = 'Y'   and UACA.AUTHORIZE_AT_ISSUE_ALLOWED_YN ='Y'  AND st_req_issue_chk (hdr.facility_id, hdr.doc_type_code, hdr.doc_no) <>  '2' ";
			}
			//Modified by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001 ends
 		        chkFields.add(CommonBean.getLoginById());
			
			if((request_type.equals("N")))
			sql = sql + " AND rbys.external_yn = 'N' " ;
			else if((request_type.equals("Y")))
			sql = sql + " AND rbys.external_yn = 'Y' " ;
			
			sql = sql + "  AND hdr.request_status NOT IN ('C', 'L', 'E')    AND rbys.language_id =?  ";   
			chkFields.add(language_id);
			
			String trn_across_facility_yn =		bean.checkForNull((String)bean.fetchRecord("select  trn_across_facility_yn  from  ST_ACC_ENTITY_PARAM where ACC_ENTITY_ID= 'ZZ'").get("TRN_ACROSS_FACILITY_YN"),"N");
			
			if(trn_across_facility_yn.equals("N")){
            sql = sql + "  AND rbys.facility_id =  ? ";
		    chkFields.add(CommonBean.getLoginFacilityId());
            }			
			sql = sql + "   AND hdr.doc_no = dtl.doc_no    AND hdr.doc_type_code = dtl.doc_type_code    AND hdr.facility_id = dtl.facility_id  AND  dtl.committed_item_qty = 0   ";//Removed hdr.CANCEL_AUTHORIZED_BY_ID is not null mo-gn-scf-5575
		  
			if(!(item_code.equals("%"))){
			sql = sql + " and dtl.item_code = ? " ;
			chkFields.add(item_code);
			}  //commented by Rabbani #Inc no:44011 (ML-BRU-SCF-1071) on 23-OCT-2013
			sql = sql + " /*AND NOT EXISTS (SELECT 'X'  FROM st_issue_dtl idtl, st_issue_hdr ihdr  WHERE ihdr.facility_id = idtl.facility_id AND ihdr.doc_no = idtl.doc_no  AND ihdr.doc_type_code = idtl.doc_type_code  AND ihdr.doc_type_code = hdr.doc_type_code  AND ihdr.doc_no = hdr.doc_no  AND ihdr.seq_no = idtl.seq_no  AND ihdr.finalized_yn = 'D'  AND ihdr.facility_id = ? )  */	and exists ( select facility_id from mm_store where store_code = hdr.req_on_store_code  and facility_id = ?  ) AND DTL.PENDING_ITEM_QTY >  0"; //and facility_id = ? reverted for mo-gn-scf-
			System.out.println(CommonBean.getLoginFacilityId());
	        //chkFields.add(CommonBean.getLoginFacilityId());
			chkFields.add(CommonBean.getLoginFacilityId());  
			
			if(!(request_status.equals("%"))){
			sql = sql + " AND (st_req_status_chk (hdr.facility_id,hdr.doc_type_code,hdr.doc_no )) = ? " ;
			chkFields.add(request_status);  
			} 
			displayFields.add("DOC_TYPE_DESC");
			displayFields.add("DOC_NO");
			displayFields.add("DOC_DATE");
			displayFields.add("REQ_BY_STORE_DESC");
			displayFields.add("REQ_ON_STORE_DESC");
			displayFields.add("ITEM_CLASS_CODE");
			displayFields.add("DOC_TYPE_CODE");
			displayFields.add("REQ_BY_STORE_CODE");
			displayFields.add("REQ_ON_STORE_CODE");
			displayFields.add("ITEM_CLASS_DESC");
			displayFields.add("REQUEST_STATUS");
			displayFields.add("REQ_STORE_FACILITY_ID");
			displayFields.add("REQ_STORE_FACILITY_NAME");
			displayFields.add("DOC_TYPE_CODE");
			
			  
		    /*chkFields.add(language_id);
		    chkFields.add(language_id);
		    chkFields.add(language_id);
		    chkFields.add(language_id);
			chkFields.add(from_doc_date);
			chkFields.add(to_doc_date);
			chkFields.add(doc_type_code);
            chkFields.add(request_by_store);
			chkFields.add(doc_no);
			chkFields.add(request_on_store);
			chkFields.add(item_class_code);
			chkFields.add(CommonBean.getLoginById());			
			chkFields.add(request_type);			
			chkFields.add(language_id);
		    chkFields.add(CommonBean.getLoginFacilityId());
   			chkFields.add(item_code);
	        chkFields.add(CommonBean.getLoginFacilityId());*/
			//chkFields.add(CommonBean.getLoginFacilityId()); //added by gangadharan and Sakti 15/06/2011  against INC27786 
			//chkFields.add(request_status); //Added  By Rabbani against inc no: 30966 on 16/03/2012 

		   //out.println("sqlMap = > "+sqlMap);
		    sqlMap.put("sqlData",sql);
			// Adding function related array list into the HashMap
			funcMap.put("displayFields", displayFields);
			funcMap.put("chkFields", chkFields);
            result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
			
			int recCount=0,i = 0;
			//Commented  By Rabbani against inc no: 30966 on 16/03/2012
			/*for(recCount=2,i = 0; recCount<result.size(); recCount++,i++) {
				records=(ArrayList) result.get(recCount);
				if(((String)records.get(10)).equals("FA")){
					result.remove(recCount);
					continue;
				}
				if(!(request_status.equals("%")) && !((String)records.get(10)).equals(request_status)){
					result.remove(recCount);
					continue;
				}
			} */
			if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){
	
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(result.get(1)));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

			for(recCount=2,i = 0; recCount<result.size(); recCount++,i++) {
				if (recCount % 2 == 0)
					classvalue = "OAQRYEVEN" ;
				else
					classvalue = "OAQRYODD" ;
				
			

				records=(ArrayList) result.get(recCount);
				if ( ! (facility_check.equals(records.get(11))) )
				 {
					facility_check= (String)records.get(11); 
					out.println("<tr><td class='ITEMSELECT' align='left' colspan='8'><b> Facility Name : "+(String)records.get(12)+"</b></td></tr>");
				 } 
				 //'PAI','Partially Authorised/Issued At Issue Store','PA', 'Partially Authorised At Issue Store','FAPI','Fully Authorised/Partially Issued At Issue Store', 'FA','FULLY Authorised At Issue Store','C','Issue Canceled', 'L','Issue Closed', 'A','Authorised At Issue Store','W','Authorised At Request By Store'
				 if(((String)records.get(10)).equals("PAI")){
					 req_status = "Partially Authorised/Issued At Issue Store";
				 }else if(((String)records.get(10)).equals("PA")){
					 req_status = "Partially Authorised At Issue Store";
				 }else if(((String)records.get(10)).equals("FAPI")){
					 req_status = "Fully Authorised/Partially Issued At Issue Store";
				 }else if(((String)records.get(10)).equals("FA")){
					 req_status = "Fully Authorised At Issue Store";
				 }else if(((String)records.get(10)).equals("C")){
					 req_status = "Issue Canceled";
				 }else if(((String)records.get(10)).equals("L")){
					 req_status = "Issue Closed";
				 }else if(((String)records.get(10)).equals("A")){
					 req_status = "Authorised At Issue Store";
				 }else if(((String)records.get(10)).equals("W")){
					 req_status = "Authorised At Request By Store";
				 }
				 
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(i));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(records.get(1)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(records.get(13)));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(facility_check));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf((String)records.get(0)));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(records.get(1)));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate((String)records.get(2),"DMY","en",locale)));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(records.get(4)));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(records.get(3)));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(CommonBean.checkForNull((String)records.get(9),"&nbsp;")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(records.get(6)));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(records.get(5)));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(records.get(10)));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(req_status));
            _bw.write(_wl_block29Bytes, _wl_block29);

			}
		
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf( bean_name));
            _bw.write(_wl_block33Bytes, _wl_block33);

			out.flush();
		} 
		else{
		
            _bw.write(_wl_block34Bytes, _wl_block34);

		}
		out.println(CommonBean.setForm (request ,"../../eST/jsp/RequisitionIssueAuthorizeQueryResult.jsp", searched));
	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
		e.printStackTrace();
	}finally{
		sqlMap.clear();	
		funcMap.clear();
		displayFields.clear();
		chkFields.clear();		
		result.clear();		
		records.clear();		
	}

            _bw.write(_wl_block35Bytes, _wl_block35);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DocType.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DocDate.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReqOnStore.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReqByStore.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ItemClass.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.ReqStatus.label", java.lang.String .class,"key"));
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
}
