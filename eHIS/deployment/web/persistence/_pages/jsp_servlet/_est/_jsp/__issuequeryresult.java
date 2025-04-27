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
import webbeans.eCommon.*;
import java.sql.*;
import java.lang.*;
import eST.IssueBean;
import eCommon.XSSRequestWrapper;
import eCommon.Common.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __issuequeryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/IssueQueryResult.jsp", 1709122057636L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="  \n ";
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

    private final static java.lang.String  _wl_block7 ="\n\n<html>\n\t<head>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\' ></link>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\'javascript\' src=\'../../eST/js/StCommon.js\'></script>\n\t\t<script language=\"javascript\" src=\"../../eST/js/Issue.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\t</head>\n\t<body>\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<table cellpadding=0 cellspacing=0 width=\"100%\" >\n\t\t\t<tr>\n\t\t\t\t<td width=\"80%\" class=\"white\">&nbsp;</td>\n\t\t\t\t<td width=\"20%\" class=\"white\">&nbsp;\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=center>\n\t\t\t\t<tr>\n\t\t\t\t\t<th width=\'260\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n\t\t\t\t\t<th width=\'125\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n \t\t\t\t\t<th width=\'400\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th> \n \t\t\t\t\t ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" \n\t\t\t\t\t<th width=\'260\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</th>\n\t\t\t\t\t<th width=\'260\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</th>\n\t\t\t\t\t<th width=\'500\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</th>\n\t\t\t\t</tr>\t\t\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t<tr onClick=\"Modify(this,\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\',\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\');\" >\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" onmouseover=\"changeCursor(this);\" nowrap><font class=\'HYPERLINK\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</font></td>\n\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" onclick=\"disableClick(event);\">";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n \t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" \n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td> \n \t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" \n \t\t\t\t<td class=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td> \n\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" \n\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td>\t\t\t\t\t\t\t\t\t\t \n\t\t\t\t<td class=\'NODISPLAY\'>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</td>\n\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t</table>\n\t\t<div  id=\'readOnlyDiv\'  style=\"visibility:hidden;z-index:3;position:absolute;top:0px;width:1007px;height:500px;background-color:#CCCFFF;filter:alpha(opacity=80);\" >\n\t\t<table border=\"0\" align=\"center\" width=\"100%\" height=\"100%\">\n\t\t<tr><td align=\"center\">\n\t\t\t\n\t\t\t</td></tr>\n\t\t</table>\n\t\t</div>\n\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t<script>\n\t\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));\n\t\t\t\tdocument.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );
	
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
21/01/2019		IN067798			B Haribabu						AMRI-CRF-0382 - New filter Authorized date

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
            _bw.write(_wl_block4Bytes, _wl_block4);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block7Bytes, _wl_block7);

request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String sStyle		=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale					=		(String)session.getAttribute("LOCALE");

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

	    String flag ="false"; //Added for AMRI-CRF-0382
	    String doc_type_code		=		request.getParameter("doc_type_code");
	//Added for AMRI-CRF-0382 starts 
			
		String auth_date_filt_yn = request.getParameter("siteid");
		//String bean_id			=		 "issueBean";
		//String bean_name		=		"eST.IssueBean";
		//IssueBean bean			=		(IssueBean) getBeanObject(bean_id,  bean_name,request);
		IssueBean bean = (IssueBean) getBeanObject("issueBean",  "eST.IssueBean", request ) ;  
		ArrayList urg_doctype_codes=null;
		urg_doctype_codes=bean.getAllUrgDocType();
	     if(urg_doctype_codes.contains(doc_type_code))
	     {
	    	 flag = "true";
	     }
	      
		
			//Added for  AMRI-CRF-0382 ends
	
		//String doc_type_code		=		request.getParameter("doc_type_code");
		//System.out.println("doc_type_code IN RESULT.JSP: "+doc_type_code);
		String doc_no				=		request.getParameter("doc_no");
		//String doc_date				=		CommonBean.checkForNull(request.getParameter("doc_date"),"");
		String fm_store				=		request.getParameter("fm_store");
		String to_store				=		request.getParameter("to_store");
		String item_class_code		=		request.getParameter("item_class_code");
		String language_id			=		request.getParameter("language_id");
		String facility_check		=		"";

		String from_doc_date		=		CommonBean.checkForNull(request.getParameter("from_doc_date"));
		String to_doc_date			=		CommonBean.checkForNull(request.getParameter("to_doc_date"));
		String from_auth_date		= "";   //Added for AMRI-CRF-0382 
		String to_auth_date		 = "";      //Added for AMRI-CRF-0382 
		String doc_type  ="";               //Added for AMRI-CRF-0382 

		if(!from_doc_date.equals(""))
			from_doc_date				=		com.ehis.util.DateUtils.convertDate(from_doc_date,"DMY",locale,"en");
		
		if(!to_doc_date.equals(""))
			to_doc_date					=		com.ehis.util.DateUtils.convertDate(to_doc_date,"DMY",locale,"en"); 
		//Added for AMRI-CRF-0382 start
		if(auth_date_filt_yn.equals("true") && flag.equals("false") )
		{
		 from_auth_date		=		CommonBean.checkForNull(request.getParameter("from_authorize_date"));
		 to_auth_date			=		CommonBean.checkForNull(request.getParameter("to_authorize_date"));

		if(!from_auth_date.equals(""))
			from_auth_date				=		com.ehis.util.DateUtils.convertDate(from_auth_date,"DMY",locale,"en");
		
		if(!to_auth_date.equals(""))
			to_auth_date					=		com.ehis.util.DateUtils.convertDate(to_auth_date,"DMY",locale,"en"); 
		}
		//Added for AMRI-CRF-0382 end
		HashMap sqlMap				=		new HashMap();
		HashMap funcMap				=		new HashMap();
		ArrayList displayFields		=		new ArrayList();
		ArrayList chkFields			=		new ArrayList();
		ArrayList result			=		new ArrayList();
		ArrayList records			=		new ArrayList();
		
		
		boolean searched					=		(request.getParameter("searched") == null) ?false:true;
		String classvalue					=		"";
		try{
			
			CommonBean.setLoginFacilityId((String) session.getValue("facility_id"));
			doc_type_code					=		CommonBean.checkForNull(doc_type_code,"%");
			doc_no							=		CommonBean.checkForNull(doc_no,"%");
		 /*if(doc_date!= "")
		 doc_date = com.ehis.util.DateUtils.convertDate((String)doc_date,"DMY",locale,"en");
         else
	      doc_date	= CommonBean.checkForNull(doc_date,"%");*/
		  
			fm_store						=		CommonBean.checkForNull(fm_store,"%");
			to_store						=		CommonBean.checkForNull(to_store,"%");
			item_class_code					=		CommonBean.checkForNull(item_class_code,"%");

			//sqlMap.put("sqlData", eST.Common.StRepository.getStKeyValue("SQL_ST_ISSUE_REQ_URG_HDR_QUERY_RESULT"));
              //Commented by Rabbani #inc no:28266 on 22/09/11
			//sqlMap.put("sqlData", "SELECT hdr.trn_type,HDR.DOC_TYPE_CODE, SY.SHORT_DESC DOC_TYPE_DESC, HDR.DOC_NO, HDR.SEQ_NO,TO_CHAR (HDR.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, HDR.FM_STORE_CODE,FMS.SHORT_DESC FM_STORE_DESC, HDR.TO_STORE_CODE,TOS.SHORT_DESC TO_STORE_DESC, HDR.ITEM_CLASS_CODE,ITM.SHORT_DESC ITEM_CLASS_DESC, HDR.CLOSE_REQ_AFTER_ISSUE_YN,NVL(REQ.FACILITY_ID,HDR.FACILITY_ID) REQ_STR_FACILITY_ID,SM.FACILITY_NAME REQ_STR_FACILITY_NAME FROM ST_ISSUE_HDR HDR,MM_STORE_LANG_VW FMS,MM_STORE_LANG_VW TOS,MM_ITEM_CLASS_LANG_VW ITM,SY_DOC_TYPE_MASTER_LANG_VW SY, /*ST_USER_ACCESS_FOR_STORE UACA,*/ST_USER_ACCESS_FOR_STORE UACB,ST_ACC_ENTITY_PARAM STP,SM_FACILITY_PARAM_LANG_VW SM, /*, ST_ACC_ENTITY_PARAM PA */ST_FACILITY_PARAM ST,ST_REQUEST_HDR REQ WHERE HDR.DOC_TYPE_CODE = SY.DOC_TYPE_CODE AND HDR.FM_STORE_CODE = FMS.STORE_CODE AND HDR.TO_STORE_CODE = TOS.STORE_CODE AND HDR.ITEM_CLASS_CODE = ITM.ITEM_CLASS_CODE(+)  AND /*UACA.STORE_CODE = HDR.TO_STORE_CODE AND*/ HDR.FINALIZED_YN = 'N' AND DECODE (ST.ISS_ACK_REQ_YN, 'Y', HDR.PROCESS_FOR_ACKNOWLEDGE,'XX') = DECODE (ST.ISS_ACK_REQ_YN, 'Y', 'N', 'XX') AND /*UACB.USER_ID = UACA.USER_ID AND*/ UACB.STORE_CODE = HDR.FM_STORE_CODE AND HDR.DOC_TYPE_CODE LIKE ? AND TO_CHAR (HDR.DOC_NO) LIKE ? AND TO_CHAR (HDR.DOC_DATE, 'DD/MM/YYYY') LIKE ? AND HDR.FM_STORE_CODE LIKE ? AND HDR.TO_STORE_CODE LIKE ? AND NVL (HDR.ITEM_CLASS_CODE, 'X') LIKE ? AND UACB.USER_ID = ? AND (    FMS.FACILITY_ID = ? AND HDR.FACILITY_ID LIKE DECODE (TRN_ACROSS_FACILITY_YN, 'Y', '%', ? )) /*AND REQ.FACILITY_ID(+) = HDR.FACILITY_ID*/ AND FMS.LANGUAGE_ID = TOS.LANGUAGE_ID AND FMS.LANGUAGE_ID = SY.LANGUAGE_ID AND FMS.LANGUAGE_ID = SM.LANGUAGE_ID AND FMS.LANGUAGE_ID = ? AND ITM.LANGUAGE_ID(+) = ? AND ST.FACILITY_ID = HDR.FACILITY_ID AND HDR.DOC_TYPE_CODE = REQ.DOC_TYPE_CODE(+) AND HDR.DOC_NO = REQ.DOC_NO(+) AND SM.FACILITY_ID = NVL(REQ.FACILITY_ID,HDR.FACILITY_ID) AND (HDR.TRN_TYPE = DECODE(UACB.URG_ALLOWED_YN,'Y','URG','XXX' ) OR HDR.TRN_TYPE = DECODE(UACB.ISS_ALLOWED_YN,'Y','ISS','XXX' ))");
			//Added BY Rabbani inc no:28266 on 22/09/11
			//Added for AMRI-CRF-0382 start
			if(auth_date_filt_yn.equals("true") && flag.equals("false")){
			sqlMap.put("sqlData", "SELECT hdr.trn_type, hdr.doc_type_code, sy.short_desc doc_type_desc,hdr.doc_no, hdr.seq_no,TO_CHAR (hdr.doc_date, 'DD/MM/YYYY') doc_date,hdr.fm_store_code,fms.short_desc fm_store_desc, hdr.to_store_code,tos.short_desc to_store_desc, hdr.item_class_code,itm.short_desc item_class_desc, hdr.close_req_after_issue_yn,NVL (req.facility_id, hdr.facility_id) req_str_facility_id,sm.facility_name req_str_facility_name, apn.appl_user_name,TO_CHAR (hdr.added_date, 'DD/MM/YYYY HH24:MI:SS') added_date FROM st_issue_hdr hdr,sm_appl_user_vw apn,mm_store_lang_vw fms,mm_store_lang_vw tos,mm_item_class_lang_vw itm,sy_doc_type_master_lang_vw sy,st_user_access_for_store uacb,st_acc_entity_param stp,sm_facility_param_lang_vw sm,st_facility_param st,st_request_hdr req  WHERE hdr.doc_type_code = sy.doc_type_code AND hdr.fm_store_code = fms.store_code AND hdr.to_store_code = tos.store_code AND hdr.item_class_code = itm.item_class_code(+) AND apn.appl_user_id = DECODE (hdr.trn_type,'URG', hdr.added_by_id,req.added_by_id) AND hdr.finalized_yn = 'N'    AND DECODE (st.iss_ack_req_yn, 'Y', hdr.process_for_acknowledge, 'XX') = DECODE (st.iss_ack_req_yn,'Y', 'N','XX') AND uacb.store_code = hdr.fm_store_code AND hdr.doc_type_code LIKE ? AND TO_CHAR (hdr.doc_no) LIKE ? AND TO_DATE (TO_CHAR(hdr.doc_date,'dd/mm/yyyy'),'dd/mm/yyyy')BETWEEN TO_DATE (NVL(?, '01/01/1472'),'dd/mm/yyyy') AND TO_DATE(NVL(?,'31/12/5000'),'dd/mm/yyyy')AND TO_DATE(TO_CHAR(hdr.doc_date,'dd/mm/yyyy' ),'dd/mm/yyyy')BETWEEN TO_DATE (NVL(?,'01/01/1472'),'dd/mm/yyyy') AND TO_DATE(NVL(?,'31/12/5000'),'dd/mm/yyyy') AND hdr.fm_store_code LIKE ?  AND hdr.to_store_code LIKE ? AND NVL (hdr.item_class_code, 'X') LIKE ?    AND uacb.user_id = ? AND ( fms.facility_id = ? AND hdr.facility_id LIKE DECODE (trn_across_facility_yn, 'Y', '%', ?)) AND fms.language_id = tos.language_id AND fms.language_id = sy.language_id AND fms.language_id = sm.language_id AND fms.language_id = ? AND itm.language_id(+) = ? AND st.facility_id = hdr.facility_id AND hdr.doc_type_code = req.doc_type_code(+) AND hdr.doc_no = req.doc_no(+) AND sm.facility_id = NVL (req.facility_id, hdr.facility_id) AND (hdr.trn_type = DECODE (uacb.urg_allowed_yn, 'Y', 'URG', 'XXX') OR hdr.trn_type = DECODE (uacb.iss_allowed_yn, 'Y', 'ISS', 'XXX'))  AND ( req.request_status  IS NULL OR  req.request_status NOT IN ('W', 'C'))");	//added for  AND ( req.request_status  IS NULL OR  req.request_status NOT IN ('W', 'C')) MO-GN-5575
			}//Added for AMRI-CRF-0382 end
			else{
			sqlMap.put("sqlData", "SELECT hdr.trn_type,HDR.DOC_TYPE_CODE, SY.SHORT_DESC DOC_TYPE_DESC, HDR.DOC_NO, HDR.SEQ_NO,TO_CHAR (HDR.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, HDR.FM_STORE_CODE,FMS.SHORT_DESC FM_STORE_DESC, HDR.TO_STORE_CODE,TOS.SHORT_DESC TO_STORE_DESC, HDR.ITEM_CLASS_CODE,ITM.SHORT_DESC ITEM_CLASS_DESC, HDR.CLOSE_REQ_AFTER_ISSUE_YN,NVL(REQ.FACILITY_ID,HDR.FACILITY_ID) REQ_STR_FACILITY_ID,SM.FACILITY_NAME REQ_STR_FACILITY_NAME,APN.APPL_USER_NAME,TO_CHAR (HDR.ADDED_DATE, 'DD/MM/YYYY HH24:MI:SS') ADDED_DATE FROM ST_ISSUE_HDR HDR,SM_APPL_USER_VW APN,  MM_STORE_LANG_VW FMS,MM_STORE_LANG_VW TOS,MM_ITEM_CLASS_LANG_VW ITM,SY_DOC_TYPE_MASTER_LANG_VW SY, /*ST_USER_ACCESS_FOR_STORE UACA,*/ST_USER_ACCESS_FOR_STORE UACB,ST_ACC_ENTITY_PARAM STP,SM_FACILITY_PARAM_LANG_VW SM, /*, ST_ACC_ENTITY_PARAM PA */ST_FACILITY_PARAM ST,ST_REQUEST_HDR REQ WHERE HDR.DOC_TYPE_CODE = SY.DOC_TYPE_CODE AND HDR.FM_STORE_CODE = FMS.STORE_CODE AND HDR.TO_STORE_CODE = TOS.STORE_CODE AND HDR.ITEM_CLASS_CODE = ITM.ITEM_CLASS_CODE(+)AND APN.APPL_USER_ID = DECODE(HDR.trn_type, 'URG', HDR.ADDED_BY_ID,REQ.ADDED_BY_ID)  AND		/*UACA.STORE_CODE = HDR.TO_STORE_CODE AND*/ HDR.FINALIZED_YN = 'N' AND DECODE (ST.ISS_ACK_REQ_YN, 'Y', HDR.PROCESS_FOR_ACKNOWLEDGE,'XX') = DECODE (ST.ISS_ACK_REQ_YN, 'Y', 'N', 'XX') AND /*UACB.USER_ID = UACA.USER_ID AND*/ UACB.STORE_CODE = HDR.FM_STORE_CODE AND HDR.DOC_TYPE_CODE LIKE ? AND TO_CHAR (HDR.DOC_NO) LIKE ? AND /*TO_CHAR (HDR.DOC_DATE, 'DD/MM/YYYY') LIKE ?*/ TO_DATE (TO_CHAR (hdr.doc_date, 'dd/mm/yyyy'), 'dd/mm/yyyy')  BETWEEN TO_DATE (NVL (?, '01/01/1472'), 'dd/mm/yyyy')AND TO_DATE (NVL (?, '31/12/5000'), 'dd/mm/yyyy') AND HDR.FM_STORE_CODE LIKE ? AND HDR.TO_STORE_CODE LIKE ? AND NVL (HDR.ITEM_CLASS_CODE, 'X') LIKE ? AND UACB.USER_ID = ? AND (    FMS.FACILITY_ID = ? AND HDR.FACILITY_ID LIKE DECODE (TRN_ACROSS_FACILITY_YN, 'Y', '%', ? )) /*AND REQ.FACILITY_ID(+) = HDR.FACILITY_ID*/ AND FMS.LANGUAGE_ID = TOS.LANGUAGE_ID AND FMS.LANGUAGE_ID = SY.LANGUAGE_ID AND FMS.LANGUAGE_ID = SM.LANGUAGE_ID AND FMS.LANGUAGE_ID = ? AND ITM.LANGUAGE_ID(+) = ? AND ST.FACILITY_ID = HDR.FACILITY_ID AND HDR.DOC_TYPE_CODE = REQ.DOC_TYPE_CODE(+) AND HDR.DOC_NO = REQ.DOC_NO(+) AND SM.FACILITY_ID = NVL(REQ.FACILITY_ID,HDR.FACILITY_ID) AND (HDR.TRN_TYPE = DECODE(UACB.URG_ALLOWED_YN,'Y','URG','XXX' ) OR HDR.TRN_TYPE = DECODE(UACB.ISS_ALLOWED_YN,'Y','ISS','XXX' ))  AND ( req.request_status  IS NULL OR  req.request_status NOT IN ('W', 'C')) ");//modified FOR MO-GN-5575
			}
			
			displayFields.add("DOC_TYPE_DESC");
			displayFields.add("DOC_NO");
			displayFields.add("SEQ_NO");
			displayFields.add("DOC_DATE");
			displayFields.add("FM_STORE_DESC");
			displayFields.add("TO_STORE_DESC");
			displayFields.add("ITEM_CLASS_DESC");
			displayFields.add("DOC_TYPE_CODE");
			displayFields.add("FM_STORE_CODE");
			displayFields.add("TO_STORE_CODE");
			displayFields.add("ITEM_CLASS_CODE");
			displayFields.add("CLOSE_REQ_AFTER_ISSUE_YN");
			displayFields.add("REQ_STR_FACILITY_ID");
			displayFields.add("REQ_STR_FACILITY_NAME");
			displayFields.add("APPL_USER_NAME");
			displayFields.add("ADDED_DATE");
			displayFields.add("trn_type");
			
			chkFields.add(doc_type_code);
			chkFields.add(doc_no);
			//chkFields.add(doc_date);
			chkFields.add(from_doc_date);
			chkFields.add(to_doc_date);
			//Added for AMRI-CRF-0382 start
			if(auth_date_filt_yn.equals("true") && flag.equals("false"))
			{
				chkFields.add(from_auth_date);
				chkFields.add(to_auth_date);
			}
			//Added for AMRI-CRF-0382 end
			chkFields.add(fm_store);
			chkFields.add(to_store);
			chkFields.add(item_class_code);
			chkFields.add(CommonBean.getLoginById());
			chkFields.add(CommonBean.getLoginFacilityId());
			chkFields.add(CommonBean.getLoginFacilityId());
			chkFields.add(language_id);
			chkFields.add(language_id);

			funcMap.put("displayFields", displayFields);
			funcMap.put("chkFields", chkFields);
			//System.out.println("sqlMap"+sqlMap);
			//System.out.println("chkFields"+chkFields);
			result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
			if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){
	
            _bw.write(_wl_block10Bytes, _wl_block10);

					out.println(result.get(1));
				
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
if(auth_date_filt_yn.equals("true") && flag.equals("false")){ 
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
} 
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

			for(int recCount=2; recCount<result.size(); recCount++) {
				if (recCount % 2 == 0)
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;

				records=(ArrayList) result.get(recCount);	
				
				if ( ! (facility_check.equals(records.get(12))) )
				 {
					facility_check= (String)records.get(12); 
					out.println("<tr><td class='ITEMSELECT' align='left' colspan='10'><b> Facility Name : "+(String)records.get(13)+"</b></td></tr>");
				
				 } 
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf((String)((ArrayList)(result.get(recCount))).get(11)));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(facility_check));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(auth_date_filt_yn ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(flag ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf((String)records.get(0)));
            _bw.write(_wl_block24Bytes, _wl_block24);
doc_type=(String)records.get(16);  //Added for AMRI-CRF-0382
				
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(records.get(1)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(records.get(2)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate((String)records.get(3),"DMY","en",locale)));
            _bw.write(_wl_block28Bytes, _wl_block28);
if(auth_date_filt_yn.equals("true") && flag.equals("false")){//Added for AMRI-CRF-0382 start 
            _bw.write(_wl_block29Bytes, _wl_block29);
 if(!doc_type.equals("URG")){ 
					
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate((String)records.get(15),"DMYHMS","en",locale)));
            _bw.write(_wl_block31Bytes, _wl_block31);
}else{ 
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf("&nbsp;"));
            _bw.write(_wl_block33Bytes, _wl_block33);
} 
            _bw.write(_wl_block34Bytes, _wl_block34);
}//Added for AMRI-CRF-0382 end
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(records.get(4)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(CommonBean.checkForNull((String)records.get(5),"&nbsp;")));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(CommonBean.checkForNull((String)records.get(6),"&nbsp;")));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(records.get(7)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf((String)records.get(14)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate((String)records.get(15),"DMYHMS","en",locale)));
            _bw.write(_wl_block36Bytes, _wl_block36);

			}
		
            _bw.write(_wl_block37Bytes, _wl_block37);

			out.flush();
		} 
		else{
		
            _bw.write(_wl_block38Bytes, _wl_block38);

		}
		out.println(CommonBean.setForm (request ,"../../eST/jsp/IssueQueryResult.jsp", searched));
	}
	catch(Exception ex) {		
		ex.printStackTrace();
	}finally{
			sqlMap.clear();	
			funcMap.clear();
			displayFields.clear();
			chkFields.clear();		
			result.clear();		
			records.clear();		
	}

            _bw.write(_wl_block39Bytes, _wl_block39);
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SequenceNo.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DocDate.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.AuthorizeDate.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.FromStore.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ToStore.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ItemClass.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Createdby.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.createddate.label", java.lang.String .class,"key"));
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
}
