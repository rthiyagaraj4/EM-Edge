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
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import eCommon.Common.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __issuereturndocnosearchresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/IssueReturnDocNoSearchResult.jsp", 1709122059449L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' ></link>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\'javascript\' src=\'../../eST/js/StCommon.js\'></script>\n\t\t<script language=\"javascript\" src=\"../../eST/js/IssueReturn.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\t</head>\n\t<body>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<table cellpadding=0 cellspacing=0 width=\"100%\" align=center>\n\t\t\t<tr>\n\t\t\t\t<td width=\"80%\" class=\"white\">&nbsp;</td>\n\t\t\t\t<td width=\"20%\" class=\"white\">&nbsp;\n\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<div  style=\'height:80%\'>\n\t\t\t<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=center>\n\t\t\t\t<tr>\n\t\t\t\t\t\n\t\t\t\t\t<th width=\'125\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" / Seq No</th>\n\t\t\t\t\t<th width=\'125\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th> <!--Added by Sakti against HSA-CRF-0171 Inc# 48543 -->\n\t\t\t\t\t<th width=\'125\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\t\t\t\t\t<th width=\'125\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n\n\t\t\t\t\t\n                </tr>\t\t\n   \t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t<tr  >\n\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" onmouseover=\"changeCursor(this);\"  onClick=\"Modify_doc(\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\',\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\');\" ><font class=\'HYPERLINK\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="/";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" </font></td>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" onclick=\"disableClick(event);\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td> <!--Added by Sakti against HSA-CRF-0171 Inc# 48543 -->\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t<tr>\n\t\t<td ></td>\n\t\t<td ></td>\n\t\t<td ></td>\n\t\t</tr>\n\t\t</table>\n\t\t</div>\n\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" height=\"10%\">\n\t\t<tr>\n\n\t\t<td align=\"right\"><input type=reset name=\'cancel\' id=\'cancel\'align=\'right\' nowrap value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' onClick=\'parent.window.close()\' class=\'Button\'>\n\t\t</td>\n\t\t</tr>\n\t\t</table>\n\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t<script>\n\t\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));\n\t\t\t\tdocument.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );
	
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

27/10/2014				HSA-CRF-0171			Sakti Sankar		48543											In Issue Return,Remove the validation 
																													of Issue Doc.Type.Users just need to 
																													find the Issue Doc No. Once user select item 
																													to be returned in the list, system should 
																													auto default the value of Issue Doc. Type
--------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block6Bytes, _wl_block6);

			request.setCharacterEncoding("UTF-8");
			String locale				=		(String)session.getAttribute("LOCALE");
		
			String sStyle				=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

		String doc_type_code		=		request.getParameter("doc_type_code");
		String doc_no				=		request.getParameter("doc_no");
		String frm_doc_date			=		request.getParameter("frm_doc_date");
		frm_doc_date				=		com.ehis.util.DateUtils.convertDate(frm_doc_date,"DMY",locale,"en");
		String to_doc_date			=		request.getParameter("to_doc_date");
		to_doc_date					=		com.ehis.util.DateUtils.convertDate(to_doc_date,"DMY",locale,"en");
		String fm_store				=		request.getParameter("frm_store_code");
		String to_store				=		request.getParameter("to_store_code");
		String item_code = request.getParameter("item_code");
		String classvalue			=		"";
		boolean searched			=		(request.getParameter("searched") == null) ?false:true;
		HashMap sqlMap				=		new HashMap();
		HashMap funcMap				=		new HashMap();
		ArrayList displayFields		=		new ArrayList();
		ArrayList chkFields			=		new ArrayList();
		ArrayList result			=		new ArrayList();
		ArrayList records			=		new ArrayList();

		IssueReturnBean bean		=		(IssueReturnBean) getBeanObject("issueReturnBean", "eST.IssueReturnBean", request);  
		bean.setLanguageId(locale);
		//ArrayList alParam           =	new ArrayList();
		//alParam.add(bean.getLoginFacilityId());
		//alParam.add(doc_type_code);

		String batch_id        =  CommonBean.checkForNull(request.getParameter("batch_id"),"");
		String expiry_date     =  CommonBean.checkForNull(request.getParameter("expiry_date"),"");	
		String trade_id        =  CommonBean.checkForNull(request.getParameter("trade_id"),"");	
		String binlocation     =  CommonBean.checkForNull(request.getParameter("binlocation"),"");	
		String barcode_yn     =	  CommonBean.checkForNull(bean.getBarcodeApplicable(),"N");
	
		try{
			CommonBean.setLoginFacilityId((String) session.getValue("facility_id"));
			//doc_type_code				   =		CommonBean.checkForNull(doc_type_code); //Comented by Sakti against HSA-CRF-0171 Inc# 48543
			doc_type_code				   =		CommonBean.checkForNull(doc_type_code,"%"); //Added by Sakti against HSA-CRF-0171 if null to get % value Inc# 48543
			doc_no						   =		CommonBean.checkForNull(doc_no,"%");
			frm_doc_date				   =		CommonBean.checkForNull(frm_doc_date);
			to_doc_date					   =		CommonBean.checkForNull(to_doc_date);
			fm_store					   =		CommonBean.checkForNull(fm_store);
			to_store					   =		CommonBean.checkForNull(to_store);
			item_code					   =		CommonBean.checkForNull(item_code,"%");


				/* IN020780 */
		//sqlMap.put("sqlData","SELECT HDR.DOC_NO ISSUE_DOC_NO,HDR.SEQ_NO SEQ_NO, MM.SHORT_DESC ITEM_DESC,TO_CHAR (HDR.DOC_DATE, 'DD/MM/YYYY') DOC_DATE,DECODE (REQUEST_STATUS,'', 'Urgent Issue','E', 'Request Entered','W', 'Authorized at req by store','A', 'authorized at issue store','P', 'Partially Issued','C', 'Fully Issued','L','Closed Upon Issue') REQUEST_STATUS FROM ST_ISSUE_HDR HDR,ST_ISSUE_DTL DTL,MM_ITEM_LANG_VW MM,ST_REQUEST_HDR RHDR,ST_ISSUE_DTL_EXP DTL_EXP,ST_ACKNOWLEDGE_TRN_DTL ACK,ST_ACKNOWLEDGE_TRN_DTL ACK1,ST_ISSUE_RET_DTL_EXP RETEXP,ST_ACC_ENTITY_PARAM STP WHERE HDR.DOC_TYPE_CODE = ? AND HDR.FM_STORE_CODE = ? AND HDR.TO_STORE_CODE = ? AND HDR.FINALIZED_YN = 'Y' AND HDR.FACILITY_ID LIKE  DECODE(STP.TRN_ACROSS_FACILITY_YN,'Y','%',?) AND (HDR.DOC_DATE BETWEEN TO_DATE (NVL (?, '01/01/1901'), 'DD/MM/YYYY') AND TO_DATE (NVL (?,TO_CHAR (SYSDATE, 'DD/MM/YYYY')),'DD/MM/YYYY')) AND TO_CHAR (HDR.DOC_NO) LIKE ? AND MM.ITEM_CODE = DTL.ITEM_CODE AND DTL.ITEM_CODE LIKE ? AND ('URG' = (SELECT TRN_TYPE FROM ST_TRN_DOC_TYPE DOC WHERE DOC.DOC_TYPE_CODE = HDR.DOC_TYPE_CODE AND DOC.FACILITY_ID = HDR.FACILITY_ID) OR REQUEST_STATUS IN ('P', 'C','L')) AND HDR.DOC_NO = DTL.DOC_NO AND HDR.SEQ_NO = DTL.SEQ_NO AND HDR.DOC_TYPE_CODE = DTL.DOC_TYPE_CODE AND HDR.FACILITY_ID = DTL.FACILITY_ID AND HDR.DOC_NO = RHDR.DOC_NO(+) AND HDR.DOC_TYPE_CODE = RHDR.DOC_TYPE_CODE(+) AND HDR.FACILITY_ID = RHDR.FACILITY_ID(+) AND DTL.FACILITY_ID = DTL_EXP.FACILITY_ID AND DTL.DOC_NO = DTL_EXP.DOC_NO AND DTL.DOC_TYPE_CODE = DTL_EXP.DOC_TYPE_CODE AND DTL.SEQ_NO = DTL_EXP.SEQ_NO AND DTL.DOC_SRL_NO = DTL_EXP.DOC_SRL_NO AND DTL.ITEM_CODE = DTL_EXP.ITEM_CODE AND DTL_EXP.FACILITY_ID = ACK.FACILITY_ID(+) AND DTL_EXP.DOC_NO = ACK.DOC_NO(+) AND DTL_EXP.DOC_TYPE_CODE = ACK.DOC_TYPE_CODE(+) AND DTL_EXP.DOC_SRL_NO = ACK.DOC_SRL_NO(+) AND DTL_EXP.ITEM_CODE = ACK.ITEM_CODE(+) AND DTL_EXP.SEQ_NO = ACK.SEQ_NO(+) AND DTL_EXP.BATCH_ID = ACK.BATCH_ID(+) AND DTL_EXP.TRADE_ID = ACK.TRADE_ID(+) AND DTL_EXP.EXPIRY_DATE_OR_RECEIPT_DATE = ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) AND RETEXP.ORG_DOC_NO(+) = DTL_EXP.DOC_NO AND RETEXP.ORG_SEQ_NO(+) = DTL_EXP.SEQ_NO AND RETEXP.ITEM_CODE(+)=DTL_EXP.ITEM_CODE AND RETEXP.BATCH_ID(+)=DTL_EXP.BATCH_ID AND RETEXP.ORG_DOC_TYPE_CODE(+) = DTL_EXP.DOC_TYPE_CODE AND RETEXP.FACILITY_ID = ACK1.FACILITY_ID(+) AND RETEXP.DOC_NO = ACK1.DOC_NO(+) AND RETEXP.DOC_TYPE_CODE = ACK1.DOC_TYPE_CODE(+) AND RETEXP.BATCH_ID = ACK1.BATCH_ID(+) AND RETEXP.ITEM_CODE = ACK1.ITEM_CODE(+) AND LANGUAGE_ID = ? AND STP.ACC_ENTITY_ID = ? HAVING SUM (  NVL (ACK.RECEIVED_QTY, DTL_EXP.ISS_ITEM_QTY)- NVL (ACK1.RECEIVED_QTY, DTL_EXP.RET_ITEM_QTY)) > 0 GROUP BY HDR.DOC_NO, MM.SHORT_DESC, HDR.DOC_DATE, REQUEST_STATUS,HDR.SEQ_NO ORDER BY HDR.DOC_NO,SEQ_NO");
    	//sqlMap.put("sqlData","SELECT  HDR.DOC_NO ISSUE_DOC_NO, HDR.SEQ_NO SEQ_NO, MM.SHORT_DESC ITEM_DESC, TO_CHAR (HDR.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, DECODE (REQUEST_STATUS, '', 'URGENT ISSUE', 'E', 'REQUEST ENTERED', 'W', 'AUTHORIZED AT REQ BY STORE', 'A', 'AUTHORIZED AT ISSUE STORE', 'P', 'PARTIALLY ISSUED', 'C', 'FULLY ISSUED', 'L', 'CLOSED UPON ISSUE' ) REQUEST_STATUS FROM ST_ISSUE_HDR HDR, ST_ISSUE_DTL DTL, MM_ITEM_LANG_VW MM, ST_REQUEST_HDR RHDR, ST_ISSUE_DTL_EXP DTL_EXP, ST_ACKNOWLEDGE_TRN_DTL ACK, ST_ACKNOWLEDGE_TRN_DTL ACK1, ST_ISSUE_RET_DTL_EXP RETEXP, ST_ACC_ENTITY_PARAM STP, ST_ITEM_BATCH BATCH WHERE HDR.DOC_TYPE_CODE = ? AND HDR.FM_STORE_CODE = ? AND HDR.TO_STORE_CODE = ? AND HDR.FINALIZED_YN = 'Y' AND HDR.FACILITY_ID LIKE DECODE (STP.TRN_ACROSS_FACILITY_YN, 'Y', '%', ? ) AND (HDR.DOC_DATE BETWEEN TO_DATE (NVL (?, '01/01/1901'), 'DD/MM/YYYY') AND TO_DATE (NVL (?, TO_CHAR (SYSDATE, 'DD/MM/YYYY') ), 'DD/MM/YYYY' ) ) AND TO_CHAR (HDR.DOC_NO) LIKE ? AND MM.ITEM_CODE = DTL.ITEM_CODE AND DTL.ITEM_CODE LIKE ? AND (   'URG' = (SELECT TRN_TYPE FROM ST_TRN_DOC_TYPE DOC WHERE DOC.DOC_TYPE_CODE = HDR.DOC_TYPE_CODE AND DOC.FACILITY_ID = HDR.FACILITY_ID) OR REQUEST_STATUS IN ('P', 'C', 'L') OR (REQUEST_STATUS = 'A' AND  DTL.ISS_ITEM_QTY IS NOT NULL AND HDR.FINALIZED_YN = 'Y' ) ) AND HDR.DOC_NO = DTL.DOC_NO AND HDR.SEQ_NO = DTL.SEQ_NO AND HDR.DOC_TYPE_CODE = DTL.DOC_TYPE_CODE AND HDR.FACILITY_ID = DTL.FACILITY_ID AND HDR.DOC_NO = RHDR.DOC_NO(+) AND HDR.DOC_TYPE_CODE = RHDR.DOC_TYPE_CODE(+) AND HDR.FACILITY_ID = RHDR.FACILITY_ID(+) AND DTL.FACILITY_ID = DTL_EXP.FACILITY_ID AND DTL.DOC_NO = DTL_EXP.DOC_NO AND DTL.DOC_TYPE_CODE = DTL_EXP.DOC_TYPE_CODE AND DTL.SEQ_NO = DTL_EXP.SEQ_NO AND DTL.DOC_SRL_NO = DTL_EXP.DOC_SRL_NO AND DTL.ITEM_CODE = DTL_EXP.ITEM_CODE AND DTL_EXP.FACILITY_ID = ACK.FACILITY_ID(+) AND DTL_EXP.DOC_NO = ACK.DOC_NO(+) AND DTL_EXP.DOC_TYPE_CODE = ACK.DOC_TYPE_CODE(+) AND DTL_EXP.DOC_SRL_NO = ACK.DOC_SRL_NO(+) AND DTL_EXP.ITEM_CODE = ACK.ITEM_CODE(+) AND DTL_EXP.SEQ_NO = ACK.SEQ_NO(+) AND DTL_EXP.BATCH_ID = ACK.BATCH_ID(+) AND DTL_EXP.TRADE_ID = ACK.TRADE_ID(+) AND DTL_EXP.EXPIRY_DATE_OR_RECEIPT_DATE = ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) AND RETEXP.ORG_DOC_NO(+) = DTL_EXP.DOC_NO AND RETEXP.ORG_SEQ_NO(+) = DTL_EXP.SEQ_NO AND RETEXP.ITEM_CODE(+) = DTL_EXP.ITEM_CODE AND RETEXP.BATCH_ID(+) = DTL_EXP.BATCH_ID AND RETEXP.ORG_DOC_TYPE_CODE(+) = DTL_EXP.DOC_TYPE_CODE AND RETEXP.FACILITY_ID = ACK1.FACILITY_ID(+) AND RETEXP.DOC_NO = ACK1.DOC_NO(+) AND RETEXP.DOC_TYPE_CODE = ACK1.DOC_TYPE_CODE(+) AND RETEXP.BATCH_ID = ACK1.BATCH_ID(+) AND RETEXP.ITEM_CODE = ACK1.ITEM_CODE(+) AND LANGUAGE_ID = ? AND STP.ACC_ENTITY_ID = ? AND BATCH.STORE_CODE = HDR.TO_STORE_CODE AND BATCH.ITEM_CODE = DTL_EXP.ITEM_CODE AND BATCH.BATCH_ID = DTL_EXP.BATCH_ID AND TRUNC (BATCH.EXPIRY_DATE_OR_RECEIPT_DATE) = TRUNC (DTL_EXP.EXPIRY_DATE_OR_RECEIPT_DATE) AND BATCH.TRADE_ID = DTL_EXP.TRADE_ID AND BATCH.QTY_ON_HAND - BATCH.COMMITTED_QTY > 0   HAVING SUM (  NVL (ACK.RECEIVED_QTY, (CASE WHEN NVL (DTL_EXP.ISS_ITEM_QTY, 0) > NVL (BATCH.QTY_ON_HAND, 0) - NVL(BATCH.COMMITTED_QTY,0) THEN NVL (BATCH.QTY_ON_HAND, 0)- NVL(BATCH.COMMITTED_QTY,0) ELSE NVL (DTL_EXP.ISS_ITEM_QTY, 0) END ) ) - NVL (ACK1.RECEIVED_QTY, DTL_EXP.RET_ITEM_QTY)  ) > 0 GROUP BY HDR.DOC_NO, MM.SHORT_DESC, HDR.DOC_DATE, REQUEST_STATUS,  HDR.SEQ_NO,BATCH.QTY_ON_HAND ORDER BY HDR.DOC_NO, SEQ_NO");
		//sqlMap.put("sqlData","SELECT  HDR.DOC_NO ISSUE_DOC_NO, HDR.SEQ_NO SEQ_NO, MM.SHORT_DESC ITEM_DESC,TO_CHAR (HDR.DOC_DATE, 'DD/MM/YYYY') DOC_DATE,(CASE WHEN (    REQUEST_STATUS IN ('A','P','L') AND (DTL.ISS_ITEM_QTY >= DTL.AUTHORIZED_ITEM_QTY) AND RHDR.ISSUE_SEQ_NO!=HDR.SEQ_NO ) THEN 'FULLY ISSUED' WHEN (    REQUEST_STATUS IN( 'A','P','L') AND (DTL.AUTHORIZED_ITEM_QTY - DTL.ISS_ITEM_QTY > 0) and RHDR.ISSUE_SEQ_NO!=HDR.SEQ_NO) THEN 'PARTIALLY ISSUED' WHEN REQUEST_STATUS IN ('', 'E', 'W', 'A', 'P', 'C', 'L') THEN DECODE (REQUEST_STATUS, '', 'URGENT ISSUE', 'E', 'REQUEST ENTERED', 'W', 'AUTHORIZED AT REQ BY STORE', 'A', 'AUTHORIZED AT ISSUE STORE', 'P', 'PARTIALLY ISSUED', 'C', 'FULLY ISSUED', 'L', 'CLOSED UPON ISSUE' ) END ) REQUEST_STATUS,HDR.FACILITY_ID FACILITY_ID FROM ST_ISSUE_HDR HDR, ST_ISSUE_DTL DTL, MM_ITEM_LANG_VW MM, ST_REQUEST_HDR RHDR, ST_ISSUE_DTL_EXP DTL_EXP, ST_ACKNOWLEDGE_TRN_DTL ACK, ST_ACKNOWLEDGE_TRN_DTL ACK1, ST_ISSUE_RET_DTL_EXP RETEXP, ST_ACC_ENTITY_PARAM STP, ST_ITEM_BATCH BATCH, ST_FACILITY_PARAM ST WHERE HDR.DOC_TYPE_CODE = ? AND HDR.FM_STORE_CODE = ? AND HDR.TO_STORE_CODE = ? AND HDR.FINALIZED_YN = 'Y' AND HDR.FACILITY_ID LIKE DECODE (STP.TRN_ACROSS_FACILITY_YN, 'Y', '%', ? ) AND (HDR.DOC_DATE BETWEEN TO_DATE (NVL (?, '01/01/1901'), 'DD/MM/YYYY' ) AND TO_DATE (NVL (?, TO_CHAR (SYSDATE, 'DD/MM/YYYY')  ), 'DD/MM/YYYY' ) ) AND TO_CHAR (HDR.DOC_NO) LIKE ? AND MM.ITEM_CODE = DTL.ITEM_CODE AND DTL.ITEM_CODE LIKE ? AND (   'URG' = (SELECT TRN_TYPE FROM ST_TRN_DOC_TYPE DOC WHERE DOC.DOC_TYPE_CODE = HDR.DOC_TYPE_CODE AND DOC.FACILITY_ID = HDR.FACILITY_ID) OR REQUEST_STATUS IN ('P', 'C', 'L') OR (   DTL.ISS_ITEM_QTY IS NOT NULL AND HDR.FINALIZED_YN = 'Y' ) ) AND HDR.DOC_NO = DTL.DOC_NO AND HDR.SEQ_NO = DTL.SEQ_NO AND HDR.DOC_TYPE_CODE = DTL.DOC_TYPE_CODE AND HDR.FACILITY_ID = DTL.FACILITY_ID AND HDR.DOC_NO = RHDR.DOC_NO(+) AND HDR.DOC_TYPE_CODE = RHDR.DOC_TYPE_CODE(+) AND HDR.FACILITY_ID = RHDR.FACILITY_ID(+) AND DTL.FACILITY_ID = DTL_EXP.FACILITY_ID AND DTL.DOC_NO = DTL_EXP.DOC_NO AND DTL.DOC_TYPE_CODE = DTL_EXP.DOC_TYPE_CODE AND DTL.SEQ_NO = DTL_EXP.SEQ_NO AND DTL.DOC_SRL_NO = DTL_EXP.DOC_SRL_NO AND DTL.ITEM_CODE = DTL_EXP.ITEM_CODE AND DTL_EXP.FACILITY_ID = ACK.FACILITY_ID(+) AND DTL_EXP.DOC_NO = ACK.DOC_NO(+) AND DTL_EXP.DOC_TYPE_CODE = ACK.DOC_TYPE_CODE(+) AND DTL_EXP.DOC_SRL_NO = ACK.DOC_SRL_NO(+)      AND DTL_EXP.ITEM_CODE = ACK.ITEM_CODE(+) AND DTL_EXP.SEQ_NO = ACK.SEQ_NO(+) AND DTL_EXP.BATCH_ID = ACK.BATCH_ID(+) AND DTL_EXP.TRADE_ID = ACK.TRADE_ID(+) AND DTL_EXP.EXPIRY_DATE_OR_RECEIPT_DATE = ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) AND RETEXP.ORG_DOC_NO(+) = DTL_EXP.DOC_NO AND RETEXP.ORG_SEQ_NO(+) = DTL_EXP.SEQ_NO AND RETEXP.ITEM_CODE(+) = DTL_EXP.ITEM_CODE AND RETEXP.BATCH_ID(+) = DTL_EXP.BATCH_ID AND RETEXP.ORG_DOC_TYPE_CODE(+) = DTL_EXP.DOC_TYPE_CODE AND RETEXP.FACILITY_ID = ACK1.FACILITY_ID(+) AND RETEXP.DOC_NO = ACK1.DOC_NO(+) AND RETEXP.DOC_TYPE_CODE = ACK1.DOC_TYPE_CODE(+) AND RETEXP.BATCH_ID = ACK1.BATCH_ID(+) AND RETEXP.ITEM_CODE = ACK1.ITEM_CODE(+) AND LANGUAGE_ID = ? AND STP.ACC_ENTITY_ID = ? AND BATCH.STORE_CODE = HDR.TO_STORE_CODE AND BATCH.ITEM_CODE = DTL_EXP.ITEM_CODE AND BATCH.BATCH_ID = DTL_EXP.BATCH_ID AND TRUNC (BATCH.EXPIRY_DATE_OR_RECEIPT_DATE) = TRUNC (DTL_EXP.EXPIRY_DATE_OR_RECEIPT_DATE) AND BATCH.bin_location_code = DTL_EXP.to_bin_location_code    AND BATCH.TRADE_ID = DTL_EXP.TRADE_ID AND BATCH.QTY_ON_HAND - BATCH.COMMITTED_QTY > 0 HAVING SUM (  NVL (ACK.RECEIVED_QTY, (CASE WHEN NVL (DTL_EXP.ISS_ITEM_QTY, 0) > NVL (BATCH.QTY_ON_HAND, 0) - NVL (BATCH.COMMITTED_QTY, 0) THEN   NVL (BATCH.QTY_ON_HAND, 0) - NVL (BATCH.COMMITTED_QTY, 0) ELSE NVL (DTL_EXP.ISS_ITEM_QTY, 0) END ) ) - NVL (ACK1.RECEIVED_QTY, DTL_EXP.RET_ITEM_QTY) ) > 0 GROUP BY HDR.DOC_NO, MM.SHORT_DESC, HDR.DOC_DATE, REQUEST_STATUS, HDR.SEQ_NO, BATCH.QTY_ON_HAND, DTL.ISS_ITEM_QTY, DTL.AUTHORIZED_ITEM_QTY, RHDR.ISSUE_SEQ_NO,HDR.FACILITY_ID ORDER BY HDR.DOC_NO, SEQ_NO  ");
		//sqlMap.put("sqlData","SELECT  HDR.DOC_NO ISSUE_DOC_NO, HDR.SEQ_NO SEQ_NO, MM.SHORT_DESC ITEM_DESC,TO_CHAR (HDR.DOC_DATE, 'DD/MM/YYYY') DOC_DATE,(CASE WHEN (    REQUEST_STATUS IN ('A','P','L') AND (DTL.ISS_ITEM_QTY >= DTL.AUTHORIZED_ITEM_QTY) AND RHDR.ISSUE_SEQ_NO!=HDR.SEQ_NO ) THEN 'FULLY ISSUED' WHEN (    REQUEST_STATUS IN( 'A','P','L') AND (DTL.AUTHORIZED_ITEM_QTY - DTL.ISS_ITEM_QTY > 0) and RHDR.ISSUE_SEQ_NO!=HDR.SEQ_NO) THEN 'PARTIALLY ISSUED' WHEN REQUEST_STATUS IN ('', 'E', 'W', 'A', 'P', 'C', 'L') THEN DECODE (REQUEST_STATUS, '', 'URGENT ISSUE', 'E', 'REQUEST ENTERED', 'W', 'AUTHORIZED AT REQ BY STORE', 'A', 'AUTHORIZED AT ISSUE STORE', 'P', 'PARTIALLY ISSUED', 'C', 'FULLY ISSUED', 'L', 'CLOSED UPON ISSUE' ) END ) REQUEST_STATUS,HDR.FACILITY_ID FACILITY_ID FROM ST_ISSUE_HDR HDR, ST_ISSUE_DTL DTL, MM_ITEM_LANG_VW MM, ST_REQUEST_HDR RHDR, ST_ISSUE_DTL_EXP DTL_EXP, ST_ACKNOWLEDGE_TRN_DTL ACK, ST_ACKNOWLEDGE_TRN_DTL ACK1, ST_ISSUE_RET_DTL_EXP RETEXP, ST_ACC_ENTITY_PARAM STP, ST_ITEM_BATCH BATCH, ST_FACILITY_PARAM ST WHERE HDR.DOC_TYPE_CODE = ? AND HDR.FM_STORE_CODE = ? AND HDR.TO_STORE_CODE = ? AND HDR.FINALIZED_YN = 'Y' AND HDR.FACILITY_ID LIKE DECODE (STP.TRN_ACROSS_FACILITY_YN, 'Y', '%', ? ) AND (HDR.DOC_DATE BETWEEN TO_DATE (NVL (?, '01/01/1901'), 'DD/MM/YYYY' ) AND TO_DATE (NVL (?, TO_CHAR (SYSDATE, 'DD/MM/YYYY')  ), 'DD/MM/YYYY' ) ) AND TO_CHAR (HDR.DOC_NO) LIKE ? AND MM.ITEM_CODE = DTL.ITEM_CODE AND DTL.ITEM_CODE LIKE ? AND (   'URG' = (SELECT TRN_TYPE FROM ST_TRN_DOC_TYPE DOC WHERE DOC.DOC_TYPE_CODE = HDR.DOC_TYPE_CODE AND DOC.FACILITY_ID = HDR.FACILITY_ID) OR REQUEST_STATUS IN ('P', 'C', 'L') OR (   DTL.ISS_ITEM_QTY IS NOT NULL AND HDR.FINALIZED_YN = 'Y' ) ) AND HDR.DOC_NO = DTL.DOC_NO AND HDR.SEQ_NO = DTL.SEQ_NO AND HDR.DOC_TYPE_CODE = DTL.DOC_TYPE_CODE AND HDR.FACILITY_ID = DTL.FACILITY_ID AND HDR.DOC_NO = RHDR.DOC_NO(+) AND HDR.DOC_TYPE_CODE = RHDR.DOC_TYPE_CODE(+) AND HDR.FACILITY_ID = RHDR.FACILITY_ID(+) AND DTL.FACILITY_ID = DTL_EXP.FACILITY_ID AND DTL.DOC_NO = DTL_EXP.DOC_NO AND DTL.DOC_TYPE_CODE = DTL_EXP.DOC_TYPE_CODE AND DTL.SEQ_NO = DTL_EXP.SEQ_NO AND DTL.DOC_SRL_NO = DTL_EXP.DOC_SRL_NO AND DTL.ITEM_CODE = DTL_EXP.ITEM_CODE AND DTL_EXP.FACILITY_ID = ACK.FACILITY_ID(+) AND DTL_EXP.DOC_NO = ACK.DOC_NO(+) AND DTL_EXP.DOC_TYPE_CODE = ACK.DOC_TYPE_CODE(+) AND DTL_EXP.DOC_SRL_NO = ACK.DOC_SRL_NO(+)      AND DTL_EXP.ITEM_CODE = ACK.ITEM_CODE(+) AND DTL_EXP.SEQ_NO = ACK.SEQ_NO(+) AND DTL_EXP.BATCH_ID = ACK.BATCH_ID(+) AND DTL_EXP.TRADE_ID = ACK.TRADE_ID(+) AND DTL_EXP.EXPIRY_DATE_OR_RECEIPT_DATE = ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) AND RETEXP.ORG_DOC_NO(+) = DTL_EXP.DOC_NO AND RETEXP.ORG_SEQ_NO(+) = DTL_EXP.SEQ_NO AND RETEXP.ITEM_CODE(+) = DTL_EXP.ITEM_CODE AND RETEXP.BATCH_ID(+) = DTL_EXP.BATCH_ID AND RETEXP.ORG_DOC_TYPE_CODE(+) = DTL_EXP.DOC_TYPE_CODE AND RETEXP.FACILITY_ID = ACK1.FACILITY_ID(+) AND RETEXP.DOC_NO = ACK1.DOC_NO(+) AND RETEXP.DOC_TYPE_CODE = ACK1.DOC_TYPE_CODE(+) AND RETEXP.BATCH_ID = ACK1.BATCH_ID(+) AND RETEXP.ITEM_CODE = ACK1.ITEM_CODE(+) AND LANGUAGE_ID = ? AND STP.ACC_ENTITY_ID = ? AND BATCH.STORE_CODE = HDR.TO_STORE_CODE AND BATCH.ITEM_CODE = DTL_EXP.ITEM_CODE AND BATCH.BATCH_ID = DTL_EXP.BATCH_ID AND TRUNC (BATCH.EXPIRY_DATE_OR_RECEIPT_DATE) = TRUNC (DTL_EXP.EXPIRY_DATE_OR_RECEIPT_DATE) AND BATCH.bin_location_code = DTL_EXP.to_bin_location_code    AND BATCH.TRADE_ID = DTL_EXP.TRADE_ID AND BATCH.QTY_ON_HAND - BATCH.COMMITTED_QTY > 0 HAVING SUM (  NVL (ACK.RECEIVED_QTY, (CASE WHEN NVL (DTL_EXP.ISS_ITEM_QTY, 0) > NVL (BATCH.QTY_ON_HAND, 0) - NVL (BATCH.COMMITTED_QTY, 0) THEN   NVL (BATCH.QTY_ON_HAND, 0) - NVL (BATCH.COMMITTED_QTY, 0)  ELSE NVL (dtl_exp.iss_item_qty, 0) - NVL (ack1.received_qty, dtl_exp.ret_item_qty) END ) )-  (CASE WHEN NVL(ack.received_qty,0) = 0 THEN 0 ELSE NVL (ack1.received_qty, dtl_exp.ret_item_qty) END)) > 0 GROUP BY HDR.DOC_NO, MM.SHORT_DESC, HDR.DOC_DATE, REQUEST_STATUS, HDR.SEQ_NO, BATCH.QTY_ON_HAND, DTL.ISS_ITEM_QTY, DTL.AUTHORIZED_ITEM_QTY, RHDR.ISSUE_SEQ_NO,HDR.FACILITY_ID ORDER BY HDR.DOC_NO, SEQ_NO  ");

		//sqlMap.put("sqlData","SELECT  HDR.DOC_NO ISSUE_DOC_NO, HDR.SEQ_NO SEQ_NO, MM.SHORT_DESC ITEM_DESC,TO_CHAR (HDR.DOC_DATE, 'DD/MM/YYYY') DOC_DATE,(CASE WHEN (    REQUEST_STATUS IN ('A','P','L') AND (DTL.ISS_ITEM_QTY >= DTL.AUTHORIZED_ITEM_QTY) AND RHDR.ISSUE_SEQ_NO!=HDR.SEQ_NO ) THEN 'FULLY ISSUED' WHEN (    REQUEST_STATUS IN( 'A','P','L') AND (DTL.AUTHORIZED_ITEM_QTY - DTL.ISS_ITEM_QTY > 0) and RHDR.ISSUE_SEQ_NO!=HDR.SEQ_NO) THEN 'PARTIALLY ISSUED' WHEN REQUEST_STATUS IN ('', 'E', 'W', 'A', 'P', 'C', 'L') THEN DECODE (REQUEST_STATUS, '', 'URGENT ISSUE', 'E', 'REQUEST ENTERED', 'W', 'AUTHORIZED AT REQ BY STORE', 'A', 'AUTHORIZED AT ISSUE STORE', 'P', 'PARTIALLY ISSUED', 'C', 'FULLY ISSUED', 'L', 'CLOSED UPON ISSUE' ) END ) REQUEST_STATUS,HDR.FACILITY_ID FACILITY_ID FROM ST_ISSUE_HDR HDR, ST_ISSUE_DTL DTL, MM_ITEM_LANG_VW MM, ST_REQUEST_HDR RHDR, ST_ISSUE_DTL_EXP DTL_EXP, ST_ACKNOWLEDGE_TRN_DTL ACK, ST_ACKNOWLEDGE_TRN_DTL ACK1, ST_ISSUE_RET_DTL_EXP RETEXP, ST_ACC_ENTITY_PARAM STP, ST_ITEM_BATCH BATCH, ST_FACILITY_PARAM ST WHERE HDR.DOC_TYPE_CODE = ? AND HDR.FM_STORE_CODE = ? AND HDR.TO_STORE_CODE = ? AND HDR.FINALIZED_YN = 'Y' AND HDR.FACILITY_ID LIKE DECODE (STP.TRN_ACROSS_FACILITY_YN, 'Y', '%', ? ) AND (HDR.DOC_DATE BETWEEN TO_DATE (NVL (?, '01/01/1901'), 'DD/MM/YYYY' ) AND TO_DATE (NVL (?, TO_CHAR (SYSDATE, 'DD/MM/YYYY')  ), 'DD/MM/YYYY' ) ) AND TO_CHAR (HDR.DOC_NO) LIKE ? AND MM.ITEM_CODE = DTL.ITEM_CODE AND DTL.ITEM_CODE LIKE ? AND (   'URG' = (SELECT TRN_TYPE FROM ST_TRN_DOC_TYPE DOC WHERE DOC.DOC_TYPE_CODE = HDR.DOC_TYPE_CODE AND DOC.FACILITY_ID = HDR.FACILITY_ID) OR REQUEST_STATUS IN ('P', 'C', 'L') OR (   DTL.ISS_ITEM_QTY IS NOT NULL AND HDR.FINALIZED_YN = 'Y' ) ) AND HDR.DOC_NO = DTL.DOC_NO AND HDR.SEQ_NO = DTL.SEQ_NO AND HDR.DOC_TYPE_CODE = DTL.DOC_TYPE_CODE AND HDR.FACILITY_ID = DTL.FACILITY_ID AND HDR.DOC_NO = RHDR.DOC_NO(+) AND HDR.DOC_TYPE_CODE = RHDR.DOC_TYPE_CODE(+) AND HDR.FACILITY_ID = RHDR.FACILITY_ID(+) AND DTL.FACILITY_ID = DTL_EXP.FACILITY_ID AND DTL.DOC_NO = DTL_EXP.DOC_NO AND DTL.DOC_TYPE_CODE = DTL_EXP.DOC_TYPE_CODE AND DTL.SEQ_NO = DTL_EXP.SEQ_NO AND DTL.DOC_SRL_NO = DTL_EXP.DOC_SRL_NO AND DTL.ITEM_CODE = DTL_EXP.ITEM_CODE AND DTL_EXP.FACILITY_ID = ACK.FACILITY_ID(+) AND DTL_EXP.DOC_NO = ACK.DOC_NO(+) AND DTL_EXP.DOC_TYPE_CODE = ACK.DOC_TYPE_CODE(+) AND DTL_EXP.DOC_SRL_NO = ACK.DOC_SRL_NO(+)      AND DTL_EXP.ITEM_CODE = ACK.ITEM_CODE(+) AND DTL_EXP.SEQ_NO = ACK.SEQ_NO(+) AND DTL_EXP.BATCH_ID = ACK.BATCH_ID(+) AND DTL_EXP.TRADE_ID = ACK.TRADE_ID(+) AND DTL_EXP.EXPIRY_DATE_OR_RECEIPT_DATE = ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) AND RETEXP.ORG_DOC_NO(+) = DTL_EXP.DOC_NO AND RETEXP.ORG_SEQ_NO(+) = DTL_EXP.SEQ_NO AND RETEXP.ITEM_CODE(+) = DTL_EXP.ITEM_CODE AND RETEXP.BATCH_ID(+) = DTL_EXP.BATCH_ID AND RETEXP.ORG_DOC_TYPE_CODE(+) = DTL_EXP.DOC_TYPE_CODE AND RETEXP.FACILITY_ID = ACK1.FACILITY_ID(+) AND RETEXP.DOC_NO = ACK1.DOC_NO(+) AND RETEXP.DOC_TYPE_CODE = ACK1.DOC_TYPE_CODE(+) AND RETEXP.BATCH_ID = ACK1.BATCH_ID(+) AND RETEXP.ITEM_CODE = ACK1.ITEM_CODE(+) AND LANGUAGE_ID = ? AND STP.ACC_ENTITY_ID = ? AND BATCH.STORE_CODE = HDR.TO_STORE_CODE AND BATCH.ITEM_CODE = DTL_EXP.ITEM_CODE AND BATCH.BATCH_ID = DTL_EXP.BATCH_ID AND TRUNC (BATCH.EXPIRY_DATE_OR_RECEIPT_DATE) = TRUNC (DTL_EXP.EXPIRY_DATE_OR_RECEIPT_DATE) AND BATCH.bin_location_code = DTL_EXP.to_bin_location_code    AND BATCH.TRADE_ID = DTL_EXP.TRADE_ID AND BATCH.QTY_ON_HAND - BATCH.COMMITTED_QTY > 0  and nvl(dtl_exp.iss_item_qty,0) - nvl(dtl_exp.ret_item_qty,0) > 0 HAVING SUM (  NVL (ACK.RECEIVED_QTY, (CASE WHEN NVL (DTL_EXP.ISS_ITEM_QTY, 0) > NVL (BATCH.QTY_ON_HAND, 0) - NVL (BATCH.COMMITTED_QTY, 0) THEN   NVL (BATCH.QTY_ON_HAND, 0) - NVL (BATCH.COMMITTED_QTY, 0)  ELSE NVL (dtl_exp.iss_item_qty, 0) - NVL (ack1.received_qty, dtl_exp.ret_item_qty) END ) )-  (CASE WHEN NVL(ack.received_qty,0) = 0 THEN 0 ELSE NVL (ack1.received_qty, dtl_exp.ret_item_qty) END)) > 0 GROUP BY HDR.DOC_NO, MM.SHORT_DESC, HDR.DOC_DATE, REQUEST_STATUS, HDR.SEQ_NO, BATCH.QTY_ON_HAND, DTL.ISS_ITEM_QTY, DTL.AUTHORIZED_ITEM_QTY, RHDR.ISSUE_SEQ_NO,HDR.FACILITY_ID ORDER BY HDR.DOC_NO, SEQ_NO  ");

		//sqlMap.put("sqlData","SELECT  HDR.DOC_NO ISSUE_DOC_NO, HDR.SEQ_NO SEQ_NO, MM.SHORT_DESC ITEM_DESC,TO_CHAR (HDR.DOC_DATE, 'DD/MM/YYYY') DOC_DATE,(CASE WHEN (    REQUEST_STATUS IN ('A','P','L') AND (DTL.ISS_ITEM_QTY >= DTL.AUTHORIZED_ITEM_QTY) AND RHDR.ISSUE_SEQ_NO!=HDR.SEQ_NO ) THEN 'FULLY ISSUED' WHEN (    REQUEST_STATUS IN( 'A','P','L') AND (DTL.AUTHORIZED_ITEM_QTY - DTL.ISS_ITEM_QTY > 0) and RHDR.ISSUE_SEQ_NO!=HDR.SEQ_NO) THEN 'PARTIALLY ISSUED' WHEN REQUEST_STATUS IN ('', 'E', 'W', 'A', 'P', 'C', 'L') THEN DECODE (REQUEST_STATUS, '', 'URGENT ISSUE', 'E', 'REQUEST ENTERED', 'W', 'AUTHORIZED AT REQ BY STORE', 'A', 'AUTHORIZED AT ISSUE STORE', 'P', 'PARTIALLY ISSUED', 'C', 'FULLY ISSUED', 'L', 'CLOSED UPON ISSUE' ) END ) REQUEST_STATUS,HDR.FACILITY_ID FACILITY_ID FROM ST_ISSUE_HDR HDR, ST_ISSUE_DTL DTL, MM_ITEM_LANG_VW MM, ST_REQUEST_HDR RHDR, ST_ISSUE_DTL_EXP DTL_EXP, ST_ACKNOWLEDGE_TRN_DTL ACK, ST_ACKNOWLEDGE_TRN_DTL ACK1, ST_ISSUE_RET_DTL_EXP RETEXP, ST_ACC_ENTITY_PARAM STP, ST_ITEM_BATCH BATCH, ST_FACILITY_PARAM ST WHERE HDR.DOC_TYPE_CODE = ? AND HDR.FM_STORE_CODE = ? AND HDR.TO_STORE_CODE = ? AND HDR.FINALIZED_YN = 'Y' AND HDR.FACILITY_ID LIKE DECODE (STP.TRN_ACROSS_FACILITY_YN, 'Y', '%', ? ) AND (HDR.DOC_DATE BETWEEN TO_DATE (NVL (?, '01/01/1901'), 'DD/MM/YYYY' ) AND TO_DATE (NVL (?, TO_CHAR (SYSDATE, 'DD/MM/YYYY')  ), 'DD/MM/YYYY' ) ) AND TO_CHAR (HDR.DOC_NO) LIKE ? AND MM.ITEM_CODE = DTL.ITEM_CODE AND DTL.ITEM_CODE LIKE ? AND (   'URG' = (SELECT TRN_TYPE FROM ST_TRN_DOC_TYPE DOC WHERE DOC.DOC_TYPE_CODE = HDR.DOC_TYPE_CODE AND DOC.FACILITY_ID = HDR.FACILITY_ID) OR REQUEST_STATUS IN ('P', 'C', 'L') OR (   DTL.ISS_ITEM_QTY IS NOT NULL AND HDR.FINALIZED_YN = 'Y' ) ) AND HDR.DOC_NO = DTL.DOC_NO AND HDR.SEQ_NO = DTL.SEQ_NO AND HDR.DOC_TYPE_CODE = DTL.DOC_TYPE_CODE AND HDR.FACILITY_ID = DTL.FACILITY_ID AND HDR.DOC_NO = RHDR.DOC_NO(+) AND HDR.DOC_TYPE_CODE = RHDR.DOC_TYPE_CODE(+) AND HDR.FACILITY_ID = RHDR.FACILITY_ID(+) AND DTL.FACILITY_ID = DTL_EXP.FACILITY_ID AND DTL.DOC_NO = DTL_EXP.DOC_NO AND DTL.DOC_TYPE_CODE = DTL_EXP.DOC_TYPE_CODE AND DTL.SEQ_NO = DTL_EXP.SEQ_NO AND DTL.DOC_SRL_NO = DTL_EXP.DOC_SRL_NO AND DTL.ITEM_CODE = DTL_EXP.ITEM_CODE AND DTL_EXP.FACILITY_ID = ACK.FACILITY_ID(+) AND DTL_EXP.DOC_NO = ACK.DOC_NO(+) AND DTL_EXP.DOC_TYPE_CODE = ACK.DOC_TYPE_CODE(+) AND DTL_EXP.DOC_SRL_NO = ACK.DOC_SRL_NO(+)      AND DTL_EXP.ITEM_CODE = ACK.ITEM_CODE(+) AND DTL_EXP.SEQ_NO = ACK.SEQ_NO(+) AND DTL_EXP.BATCH_ID = ACK.BATCH_ID(+) AND DTL_EXP.TRADE_ID = ACK.TRADE_ID(+) AND DTL_EXP.EXPIRY_DATE_OR_RECEIPT_DATE = ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) AND RETEXP.ORG_DOC_NO(+) = DTL_EXP.DOC_NO AND RETEXP.ORG_SEQ_NO(+) = DTL_EXP.SEQ_NO AND RETEXP.ITEM_CODE(+) = DTL_EXP.ITEM_CODE AND RETEXP.BATCH_ID(+) = DTL_EXP.BATCH_ID AND RETEXP.ORG_DOC_TYPE_CODE(+) = DTL_EXP.DOC_TYPE_CODE AND RETEXP.FACILITY_ID = ACK1.FACILITY_ID(+) AND RETEXP.DOC_NO = ACK1.DOC_NO(+) AND RETEXP.DOC_TYPE_CODE = ACK1.DOC_TYPE_CODE(+) AND RETEXP.BATCH_ID = ACK1.BATCH_ID(+) AND RETEXP.ITEM_CODE = ACK1.ITEM_CODE(+) AND LANGUAGE_ID = ? AND STP.ACC_ENTITY_ID = ? AND BATCH.STORE_CODE = HDR.TO_STORE_CODE AND BATCH.ITEM_CODE = DTL_EXP.ITEM_CODE AND BATCH.BATCH_ID = DTL_EXP.BATCH_ID AND TRUNC (BATCH.EXPIRY_DATE_OR_RECEIPT_DATE) = TRUNC (DTL_EXP.EXPIRY_DATE_OR_RECEIPT_DATE) AND BATCH.bin_location_code = DTL_EXP.to_bin_location_code    AND BATCH.TRADE_ID = DTL_EXP.TRADE_ID AND BATCH.QTY_ON_HAND - BATCH.COMMITTED_QTY > 0  and nvl(dtl_exp.iss_item_qty,0) - nvl(dtl_exp.ret_item_qty,0) > 0 HAVING SUM (  NVL (ACK.RECEIVED_QTY, (CASE WHEN NVL (DTL_EXP.ISS_ITEM_QTY, 0) > NVL (BATCH.QTY_ON_HAND, 0) - NVL (BATCH.COMMITTED_QTY, 0) THEN   NVL (BATCH.QTY_ON_HAND, 0) - NVL (BATCH.COMMITTED_QTY, 0)  ELSE NVL (dtl_exp.iss_item_qty, 0) - NVL (ack1.received_qty, dtl_exp.ret_item_qty) END ) )-  (CASE WHEN NVL(ack.received_qty,0) = 0 THEN 0 ELSE NVL (ack1.received_qty, dtl_exp.ret_item_qty) END)) > 0 GROUP BY HDR.DOC_NO, MM.SHORT_DESC, HDR.DOC_DATE, REQUEST_STATUS, HDR.SEQ_NO, BATCH.QTY_ON_HAND, DTL.ISS_ITEM_QTY, DTL.AUTHORIZED_ITEM_QTY, RHDR.ISSUE_SEQ_NO,HDR.FACILITY_ID  UNION SELECT ihr.doc_no issue_doc_no,ihr.seq_no seq_no, mmitm.short_desc item_desc, TO_CHAR (ihr.doc_date, 'DD/MM/YYYY') doc_date, (CASE  WHEN (    request_status IN ('A', 'P', 'L')  AND (idtl.iss_item_qty >= idtl.authorized_item_qty)  AND rhdr.issue_seq_no != ihr.seq_no )  THEN 'FULLY ISSUED'  WHEN (    request_status IN ('A', 'P', 'L')  AND (idtl.authorized_item_qty - idtl.iss_item_qty > 0)  AND rhdr.issue_seq_no != ihr.seq_no)  THEN 'PARTIALLY ISSUED'  WHEN request_status IN ('', 'E', 'W', 'A', 'P', 'C', 'L')  THEN DECODE (request_status,'', 'URGENT ISSUE','E', 'REQUEST ENTERED','W', 'AUTHORIZED AT REQ BY STORE','A', 'AUTHORIZED AT ISSUE STORE','P', 'PARTIALLY ISSUED', 'C', 'FULLY ISSUED', 'L', 'CLOSED UPON ISSUE')  END)  request_status, ihr.facility_id facility_id   FROM st_issue_dtl_exp ide, st_issue_hdr ihr, mm_bin_location mmb, st_issue_dtl idtl, mm_item mmitm, am_trade_name amtrade,st_request_hdr rhdr WHERE ide.facility_id = ?  AND idtl.item_code = mmitm.item_code   AND ide.trade_id = amtrade.trade_id(+)  AND (    ide.facility_id = ihr.facility_id  AND ide.doc_type_code = ihr.doc_type_code  AND ide.doc_no = ihr.doc_no  AND ide.seq_no = ihr.seq_no )  AND ihr.finalized_yn = 'Y'  AND ihr.fm_store_code = ?  AND ihr.to_store_code = ?  AND (ide.iss_item_qty - NVL (ide.ret_item_qty, 0)) >= 0  AND (    ihr.fm_store_code = mmb.store_code  AND ide.bin_location_code = mmb.bin_location_code )  AND idtl.facility_id = ide.facility_id  AND idtl.doc_type_code = ide.doc_type_code  AND idtl.doc_no = ide.doc_no  AND idtl.seq_no = ihr.seq_no   AND idtl.item_code = ide.item_code  AND ihr.doc_no = rhdr.doc_no(+)  AND ihr.doc_type_code = rhdr.doc_type_code(+)  AND ihr.facility_id = rhdr.facility_id(+)  AND ide.item_code like ?  AND IDTL.STOCK_ITEM_YN ='N'  AND ihr.doc_no like ? AND ihr.doc_type_code = ?   AND ihr.doc_date BETWEEN TO_DATE (NVL (?, '01/01/1901'), 'DD/MM/YYYY')  AND TO_DATE (NVL (?,TO_CHAR (SYSDATE, 'DD/MM/YYYY')),'DD/MM/YYYY') AND NVL (ide.iss_item_qty, 0) - NVL (ide.ret_item_qty, 0) > 0 ORDER BY issue_doc_no, seq_no  ");

	//Comented by Sakti against HSA-CRF-0171 query changed below Inc# 48543
		//String sql = "SELECT  HDR.DOC_NO ISSUE_DOC_NO, HDR.SEQ_NO SEQ_NO, MM.SHORT_DESC ITEM_DESC,TO_CHAR (HDR.DOC_DATE, 'DD/MM/YYYY') DOC_DATE,(CASE WHEN (    REQUEST_STATUS IN ('A','P','L') AND (DTL.ISS_ITEM_QTY >= DTL.AUTHORIZED_ITEM_QTY) AND RHDR.ISSUE_SEQ_NO!=HDR.SEQ_NO ) THEN 'FULLY ISSUED' WHEN (    REQUEST_STATUS IN( 'A','P','L') AND (DTL.AUTHORIZED_ITEM_QTY - DTL.ISS_ITEM_QTY > 0) and RHDR.ISSUE_SEQ_NO!=HDR.SEQ_NO) THEN 'PARTIALLY ISSUED' WHEN REQUEST_STATUS IN ('', 'E', 'W', 'A', 'P', 'C', 'L') THEN DECODE (REQUEST_STATUS, '', 'URGENT ISSUE', 'E', 'REQUEST ENTERED', 'W', 'AUTHORIZED AT REQ BY STORE', 'A', 'AUTHORIZED AT ISSUE STORE', 'P', 'PARTIALLY ISSUED', 'C', 'FULLY ISSUED', 'L', 'CLOSED UPON ISSUE' ) END ) REQUEST_STATUS,HDR.FACILITY_ID FACILITY_ID FROM ST_ISSUE_HDR HDR, ST_ISSUE_DTL DTL, MM_ITEM_LANG_VW MM, ST_REQUEST_HDR RHDR, ST_ISSUE_DTL_EXP DTL_EXP, ST_ACKNOWLEDGE_TRN_DTL ACK, ST_ACKNOWLEDGE_TRN_DTL ACK1, ST_ISSUE_RET_DTL_EXP RETEXP, ST_ACC_ENTITY_PARAM STP, ST_ITEM_BATCH BATCH, ST_FACILITY_PARAM ST WHERE HDR.DOC_TYPE_CODE = ? AND HDR.FM_STORE_CODE = ? AND HDR.TO_STORE_CODE = ? AND HDR.FINALIZED_YN = 'Y' AND HDR.FACILITY_ID LIKE DECODE (STP.TRN_ACROSS_FACILITY_YN, 'Y', '%', ? ) AND (HDR.DOC_DATE BETWEEN TO_DATE (NVL (?, '01/01/1901'), 'DD/MM/YYYY' ) AND TO_DATE (NVL (?, TO_CHAR (SYSDATE, 'DD/MM/YYYY')  ), 'DD/MM/YYYY' ) ) AND MM.ITEM_CODE = DTL.ITEM_CODE  AND (   'URG' = (SELECT TRN_TYPE FROM ST_TRN_DOC_TYPE DOC WHERE DOC.DOC_TYPE_CODE = HDR.DOC_TYPE_CODE AND DOC.FACILITY_ID = HDR.FACILITY_ID) OR REQUEST_STATUS IN ('P', 'C', 'L') OR (   DTL.ISS_ITEM_QTY IS NOT NULL AND HDR.FINALIZED_YN = 'Y' ) ) AND HDR.DOC_NO = DTL.DOC_NO AND HDR.SEQ_NO = DTL.SEQ_NO AND HDR.DOC_TYPE_CODE = DTL.DOC_TYPE_CODE AND HDR.FACILITY_ID = DTL.FACILITY_ID AND HDR.DOC_NO = RHDR.DOC_NO(+) AND HDR.DOC_TYPE_CODE = RHDR.DOC_TYPE_CODE(+) AND HDR.FACILITY_ID = RHDR.FACILITY_ID(+) AND DTL.FACILITY_ID = DTL_EXP.FACILITY_ID AND DTL.DOC_NO = DTL_EXP.DOC_NO AND DTL.DOC_TYPE_CODE = DTL_EXP.DOC_TYPE_CODE AND DTL.SEQ_NO = DTL_EXP.SEQ_NO AND DTL.DOC_SRL_NO = DTL_EXP.DOC_SRL_NO AND DTL.ITEM_CODE = DTL_EXP.ITEM_CODE AND DTL_EXP.FACILITY_ID = ACK.FACILITY_ID(+) AND DTL_EXP.DOC_NO = ACK.DOC_NO(+) AND DTL_EXP.DOC_TYPE_CODE = ACK.DOC_TYPE_CODE(+) AND DTL_EXP.DOC_SRL_NO = ACK.DOC_SRL_NO(+)      AND DTL_EXP.ITEM_CODE = ACK.ITEM_CODE(+) AND DTL_EXP.SEQ_NO = ACK.SEQ_NO(+) AND DTL_EXP.BATCH_ID = ACK.BATCH_ID(+) AND DTL_EXP.TRADE_ID = ACK.TRADE_ID(+) AND DTL_EXP.EXPIRY_DATE_OR_RECEIPT_DATE = ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) AND RETEXP.ORG_DOC_NO(+) = DTL_EXP.DOC_NO AND RETEXP.ORG_SEQ_NO(+) = DTL_EXP.SEQ_NO AND RETEXP.ITEM_CODE(+) = DTL_EXP.ITEM_CODE AND RETEXP.BATCH_ID(+) = DTL_EXP.BATCH_ID AND RETEXP.ORG_DOC_TYPE_CODE(+) = DTL_EXP.DOC_TYPE_CODE AND RETEXP.FACILITY_ID = ACK1.FACILITY_ID(+) AND RETEXP.DOC_NO = ACK1.DOC_NO(+) AND RETEXP.DOC_TYPE_CODE = ACK1.DOC_TYPE_CODE(+) AND RETEXP.BATCH_ID = ACK1.BATCH_ID(+) AND RETEXP.ITEM_CODE = ACK1.ITEM_CODE(+) AND LANGUAGE_ID = ? AND STP.ACC_ENTITY_ID = ? AND BATCH.STORE_CODE = HDR.TO_STORE_CODE AND BATCH.ITEM_CODE = DTL_EXP.ITEM_CODE AND BATCH.BATCH_ID = DTL_EXP.BATCH_ID AND TRUNC (BATCH.EXPIRY_DATE_OR_RECEIPT_DATE) = TRUNC (DTL_EXP.EXPIRY_DATE_OR_RECEIPT_DATE) AND BATCH.bin_location_code = DTL_EXP.to_bin_location_code    AND BATCH.TRADE_ID = DTL_EXP.TRADE_ID AND BATCH.QTY_ON_HAND - BATCH.COMMITTED_QTY > 0  and nvl(dtl_exp.iss_item_qty,0) - nvl(dtl_exp.ret_item_qty,0) > 0 ";

		//Added by Sakti against HSA-CRF-0171 query changed to get doc_type_code and description doc_type_code parameter comented to pass the same dynamically Inc# 48543
		String sql = "SELECT  HDR.DOC_NO ISSUE_DOC_NO, HDR.SEQ_NO SEQ_NO, MM.SHORT_DESC ITEM_DESC,hdr.doc_type_code issue_doc_type,(select  short_desc from  SY_DOC_TYPE_MASTER_lang_vw where DOC_TYPE_CODE=hdr.doc_type_code and language_id=? )doc_type_desc,TO_CHAR (HDR.DOC_DATE, 'DD/MM/YYYY') DOC_DATE,(CASE WHEN (    REQUEST_STATUS IN ('A','P','L') AND (DTL.ISS_ITEM_QTY >= DTL.AUTHORIZED_ITEM_QTY) AND RHDR.ISSUE_SEQ_NO!=HDR.SEQ_NO ) THEN 'FULLY ISSUED' WHEN (    REQUEST_STATUS IN( 'A','P','L') AND (DTL.AUTHORIZED_ITEM_QTY - DTL.ISS_ITEM_QTY > 0) and RHDR.ISSUE_SEQ_NO!=HDR.SEQ_NO) THEN 'PARTIALLY ISSUED' WHEN REQUEST_STATUS IN ('', 'E', 'W', 'A', 'P', 'C', 'L') THEN DECODE (REQUEST_STATUS, '', 'URGENT ISSUE', 'E', 'REQUEST ENTERED', 'W', 'AUTHORIZED AT REQ BY STORE', 'A', 'AUTHORIZED AT ISSUE STORE', 'P', 'PARTIALLY ISSUED', 'C', 'FULLY ISSUED', 'L', 'CLOSED UPON ISSUE' ) END ) REQUEST_STATUS,HDR.FACILITY_ID FACILITY_ID FROM ST_ISSUE_HDR HDR, ST_ISSUE_DTL DTL, MM_ITEM_LANG_VW MM, ST_REQUEST_HDR RHDR, ST_ISSUE_DTL_EXP DTL_EXP, ST_ACKNOWLEDGE_TRN_DTL ACK, ST_ACKNOWLEDGE_TRN_DTL ACK1, ST_ISSUE_RET_DTL_EXP RETEXP, ST_ACC_ENTITY_PARAM STP, ST_ITEM_BATCH BATCH, ST_FACILITY_PARAM ST WHERE /*HDR.DOC_TYPE_CODE = ? AND*/ HDR.FM_STORE_CODE = ? AND HDR.TO_STORE_CODE = ? AND HDR.FINALIZED_YN = 'Y' AND HDR.FACILITY_ID LIKE DECODE (STP.TRN_ACROSS_FACILITY_YN, 'Y', '%', ? ) AND (HDR.DOC_DATE BETWEEN TO_DATE (NVL (?, '01/01/1901'), 'DD/MM/YYYY' ) AND TO_DATE (NVL (?, TO_CHAR (SYSDATE, 'DD/MM/YYYY')  ), 'DD/MM/YYYY' ) ) AND MM.ITEM_CODE = DTL.ITEM_CODE  AND (   'URG' = (SELECT TRN_TYPE FROM ST_TRN_DOC_TYPE DOC WHERE DOC.DOC_TYPE_CODE = HDR.DOC_TYPE_CODE AND DOC.FACILITY_ID = HDR.FACILITY_ID) OR REQUEST_STATUS IN ('P', 'C', 'L') OR (   DTL.ISS_ITEM_QTY IS NOT NULL AND HDR.FINALIZED_YN = 'Y' ) ) AND HDR.DOC_NO = DTL.DOC_NO AND HDR.SEQ_NO = DTL.SEQ_NO AND HDR.DOC_TYPE_CODE = DTL.DOC_TYPE_CODE AND HDR.FACILITY_ID = DTL.FACILITY_ID AND HDR.DOC_NO = RHDR.DOC_NO(+) AND HDR.DOC_TYPE_CODE = RHDR.DOC_TYPE_CODE(+) AND HDR.FACILITY_ID = RHDR.FACILITY_ID(+) AND DTL.FACILITY_ID = DTL_EXP.FACILITY_ID AND DTL.DOC_NO = DTL_EXP.DOC_NO AND DTL.DOC_TYPE_CODE = DTL_EXP.DOC_TYPE_CODE AND DTL.SEQ_NO = DTL_EXP.SEQ_NO AND DTL.DOC_SRL_NO = DTL_EXP.DOC_SRL_NO AND DTL.ITEM_CODE = DTL_EXP.ITEM_CODE AND DTL_EXP.FACILITY_ID = ACK.FACILITY_ID(+) AND DTL_EXP.DOC_NO = ACK.DOC_NO(+) AND DTL_EXP.DOC_TYPE_CODE = ACK.DOC_TYPE_CODE(+) AND DTL_EXP.DOC_SRL_NO = ACK.DOC_SRL_NO(+)      AND DTL_EXP.ITEM_CODE = ACK.ITEM_CODE(+) AND DTL_EXP.SEQ_NO = ACK.SEQ_NO(+) AND DTL_EXP.BATCH_ID = ACK.BATCH_ID(+) AND DTL_EXP.TRADE_ID = ACK.TRADE_ID(+) AND DTL_EXP.EXPIRY_DATE_OR_RECEIPT_DATE = ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) AND RETEXP.ORG_DOC_NO(+) = DTL_EXP.DOC_NO AND RETEXP.ORG_SEQ_NO(+) = DTL_EXP.SEQ_NO AND RETEXP.ITEM_CODE(+) = DTL_EXP.ITEM_CODE AND RETEXP.BATCH_ID(+) = DTL_EXP.BATCH_ID AND RETEXP.ORG_DOC_TYPE_CODE(+) = DTL_EXP.DOC_TYPE_CODE AND RETEXP.FACILITY_ID = ACK1.FACILITY_ID(+) AND RETEXP.DOC_NO = ACK1.DOC_NO(+) AND RETEXP.DOC_TYPE_CODE = ACK1.DOC_TYPE_CODE(+) AND RETEXP.BATCH_ID = ACK1.BATCH_ID(+) AND RETEXP.ITEM_CODE = ACK1.ITEM_CODE(+) AND LANGUAGE_ID = ? AND STP.ACC_ENTITY_ID = ? AND BATCH.STORE_CODE = HDR.TO_STORE_CODE AND BATCH.ITEM_CODE = DTL_EXP.ITEM_CODE AND BATCH.BATCH_ID = DTL_EXP.BATCH_ID AND TRUNC (BATCH.EXPIRY_DATE_OR_RECEIPT_DATE) = TRUNC (DTL_EXP.EXPIRY_DATE_OR_RECEIPT_DATE) AND BATCH.bin_location_code = DTL_EXP.to_bin_location_code    AND BATCH.TRADE_ID = DTL_EXP.TRADE_ID AND BATCH.QTY_ON_HAND - BATCH.COMMITTED_QTY > 0  and nvl(dtl_exp.iss_item_qty,0) - nvl(dtl_exp.ret_item_qty,0) > 0 ";
		
		if(doc_no != "%")
		{	
		sql = sql + " and HDR.doc_no = " + "'"+doc_no+"'" ;
		}
		if(item_code != "%")
		{	
		sql = sql + " and DTL.item_code = " + "'"+item_code+"'" ;
		}
		//Added by Sakti against HSA-CRF-0171 to pass the below parameter dynamically based on availability Inc# 48543
		if(doc_type_code != "%")
		{	
		sql = sql + " and hdr.doc_type_code = " + "'"+doc_type_code+"'" ;
		}
		//Added ends
		if(barcode_yn.equals("Y") && item_code != "%"){ 
		if(batch_id != "")
		{	
		sql = sql + " and dtl_exp.batch_id = " + "'"+batch_id+"'" ;
		}
		if(expiry_date != "")
		{	
		sql = sql + " and to_char(dtl_exp.expiry_date_or_receipt_date,'dd/mm/yyyy') = "+"'"+expiry_date+"'";
		}
		if(trade_id != "")
		{	
		sql = sql + " and dtl_exp.trade_id = " + "'"+trade_id+"'" ;
		}
		if(binlocation != "")
		{	
		sql = sql + " and dtl_exp.bin_location_code = " + "'"+binlocation+"'" ;
		}
		}

		//Comented by Sakti against HSA-CRF-0171 query changed below Inc# 48543
		//sql = sql + " HAVING SUM (  NVL (ACK.RECEIVED_QTY, (CASE WHEN NVL (DTL_EXP.ISS_ITEM_QTY, 0) > NVL (BATCH.QTY_ON_HAND, 0) - NVL (BATCH.COMMITTED_QTY, 0) THEN   NVL (BATCH.QTY_ON_HAND, 0) - NVL (BATCH.COMMITTED_QTY, 0)  ELSE NVL (dtl_exp.iss_item_qty, 0) - NVL (ack1.received_qty, dtl_exp.ret_item_qty) END ) )-  (CASE WHEN NVL(ack.received_qty,0) = 0 THEN 0 ELSE NVL (ack1.received_qty, dtl_exp.ret_item_qty) END)) > 0 GROUP BY HDR.DOC_NO, MM.SHORT_DESC, HDR.DOC_DATE, REQUEST_STATUS, HDR.SEQ_NO, BATCH.QTY_ON_HAND, DTL.ISS_ITEM_QTY, DTL.AUTHORIZED_ITEM_QTY, RHDR.ISSUE_SEQ_NO,HDR.FACILITY_ID  UNION  SELECT ihr.doc_no issue_doc_no,ihr.seq_no seq_no, mmitm.short_desc item_desc, TO_CHAR (ihr.doc_date, 'DD/MM/YYYY') doc_date, (CASE  WHEN (    request_status IN ('A', 'P', 'L')  AND (idtl.iss_item_qty >= idtl.authorized_item_qty)  AND rhdr.issue_seq_no != ihr.seq_no )  THEN 'FULLY ISSUED'  WHEN (    request_status IN ('A', 'P', 'L')  AND (idtl.authorized_item_qty - idtl.iss_item_qty > 0)  AND rhdr.issue_seq_no != ihr.seq_no)  THEN 'PARTIALLY ISSUED'  WHEN request_status IN ('', 'E', 'W', 'A', 'P', 'C', 'L')  THEN DECODE (request_status,'', 'URGENT ISSUE','E', 'REQUEST ENTERED','W', 'AUTHORIZED AT REQ BY STORE','A', 'AUTHORIZED AT ISSUE STORE','P', 'PARTIALLY ISSUED', 'C', 'FULLY ISSUED', 'L', 'CLOSED UPON ISSUE')  END)  request_status, ihr.facility_id facility_id   FROM st_issue_dtl_exp ide, st_issue_hdr ihr, mm_bin_location mmb, st_issue_dtl idtl, mm_item mmitm, am_trade_name amtrade,st_request_hdr rhdr WHERE ide.facility_id = ?  AND idtl.item_code = mmitm.item_code   AND ide.trade_id = amtrade.trade_id(+)  AND (    ide.facility_id = ihr.facility_id  AND ide.doc_type_code = ihr.doc_type_code  AND ide.doc_no = ihr.doc_no  AND ide.seq_no = ihr.seq_no )  AND ihr.finalized_yn = 'Y'  AND ihr.fm_store_code = ?  AND ihr.to_store_code = ?  AND (ide.iss_item_qty - NVL (ide.ret_item_qty, 0)) >= 0  AND (    ihr.fm_store_code = mmb.store_code  AND ide.bin_location_code = mmb.bin_location_code )  AND idtl.facility_id = ide.facility_id  AND idtl.doc_type_code = ide.doc_type_code  AND idtl.doc_no = ide.doc_no  AND idtl.seq_no = ihr.seq_no   AND idtl.item_code = ide.item_code  AND ihr.doc_no = rhdr.doc_no(+)  AND ihr.doc_type_code = rhdr.doc_type_code(+)  AND ihr.facility_id = rhdr.facility_id(+)  AND IDTL.STOCK_ITEM_YN ='N'  AND ihr.doc_type_code = ?  AND ihr.doc_date BETWEEN TO_DATE (NVL (?, '01/01/1901'), 'DD/MM/YYYY')  AND TO_DATE (NVL (?,TO_CHAR (SYSDATE, 'DD/MM/YYYY')),'DD/MM/YYYY') AND NVL (ide.iss_item_qty, 0) - NVL (ide.ret_item_qty, 0) > 0 " ;

		//Added by Sakti against HSA-CRF-0171 query changed to get doc_type_code and description doc_type_code parameter comented to pass the same dynamically Inc# 48543
		sql = sql + " HAVING SUM (  NVL (ACK.RECEIVED_QTY, (CASE WHEN NVL (DTL_EXP.ISS_ITEM_QTY, 0) > NVL (BATCH.QTY_ON_HAND, 0) - NVL (BATCH.COMMITTED_QTY, 0) THEN   NVL (BATCH.QTY_ON_HAND, 0) - NVL (BATCH.COMMITTED_QTY, 0)  ELSE NVL (dtl_exp.iss_item_qty, 0) - NVL (ack1.received_qty, dtl_exp.ret_item_qty) END ) )-  (CASE WHEN NVL(ack.received_qty,0) = 0 THEN 0 ELSE NVL (ack1.received_qty, dtl_exp.ret_item_qty) END)) > 0 GROUP BY HDR.DOC_NO, MM.SHORT_DESC, HDR.DOC_DATE, REQUEST_STATUS, HDR.SEQ_NO, BATCH.QTY_ON_HAND, DTL.ISS_ITEM_QTY, DTL.AUTHORIZED_ITEM_QTY, RHDR.ISSUE_SEQ_NO,HDR.FACILITY_ID,hdr.doc_type_code  UNION  SELECT ihr.doc_no issue_doc_no,ihr.seq_no seq_no, mmitm.short_desc item_desc,IHR.DOC_TYPE_CODE iss_doc_type_code,(select  short_desc from  SY_DOC_TYPE_MASTER_lang_vw where DOC_TYPE_CODE=ihr.doc_type_code and language_id=? )doc_type_desc, TO_CHAR (ihr.doc_date, 'DD/MM/YYYY') doc_date, (CASE  WHEN (    request_status IN ('A', 'P', 'L')  AND (idtl.iss_item_qty >= idtl.authorized_item_qty)  AND rhdr.issue_seq_no != ihr.seq_no )  THEN 'FULLY ISSUED'  WHEN (    request_status IN ('A', 'P', 'L')  AND (idtl.authorized_item_qty - idtl.iss_item_qty > 0)  AND rhdr.issue_seq_no != ihr.seq_no)  THEN 'PARTIALLY ISSUED'  WHEN request_status IN ('', 'E', 'W', 'A', 'P', 'C', 'L')  THEN DECODE (request_status,'', 'URGENT ISSUE','E', 'REQUEST ENTERED','W', 'AUTHORIZED AT REQ BY STORE','A', 'AUTHORIZED AT ISSUE STORE','P', 'PARTIALLY ISSUED', 'C', 'FULLY ISSUED', 'L', 'CLOSED UPON ISSUE')  END)  request_status, ihr.facility_id facility_id   FROM st_issue_dtl_exp ide, st_issue_hdr ihr, mm_bin_location mmb, st_issue_dtl idtl, mm_item mmitm, am_trade_name amtrade,st_request_hdr rhdr WHERE ide.facility_id = ?  AND idtl.item_code = mmitm.item_code   AND ide.trade_id = amtrade.trade_id(+)  AND (    ide.facility_id = ihr.facility_id  AND ide.doc_type_code = ihr.doc_type_code  AND ide.doc_no = ihr.doc_no  AND ide.seq_no = ihr.seq_no )  AND ihr.finalized_yn = 'Y'  AND ihr.fm_store_code = ?  AND ihr.to_store_code = ?  AND (ide.iss_item_qty - NVL (ide.ret_item_qty, 0)) >= 0  AND (    ihr.fm_store_code = mmb.store_code  AND ide.bin_location_code = mmb.bin_location_code )  AND idtl.facility_id = ide.facility_id  AND idtl.doc_type_code = ide.doc_type_code  AND idtl.doc_no = ide.doc_no  AND idtl.seq_no = ihr.seq_no   AND idtl.item_code = ide.item_code  AND ihr.doc_no = rhdr.doc_no(+)  AND ihr.doc_type_code = rhdr.doc_type_code(+)  AND ihr.facility_id = rhdr.facility_id(+)  AND IDTL.STOCK_ITEM_YN ='N'  /*AND ihr.doc_type_code = ?*/  AND ihr.doc_date BETWEEN TO_DATE (NVL (?, '01/01/1901'), 'DD/MM/YYYY')  AND TO_DATE (NVL (?,TO_CHAR (SYSDATE, 'DD/MM/YYYY')),'DD/MM/YYYY') AND NVL (ide.iss_item_qty, 0) - NVL (ide.ret_item_qty, 0) > 0 ";

		if(doc_no != "%")
		{	
		sql = sql + " and ihr.doc_no = " + "'"+doc_no+"'" ;
		}
		if(item_code != "%")
		{	
		sql = sql + " and ide.item_code = " + "'"+item_code+"'" ;
		}
		//Added by Sakti against HSA-CRF-0171 to pass the below parameter dynamically based on availability Inc# 48543
		if(doc_type_code != "%")
		{	
		sql = sql + " and ihr.doc_type_code = " + "'"+doc_type_code+"'" ;
		}
		//Added ends
		

		if(barcode_yn.equals("Y") && item_code != "%"){ 
		if(batch_id != "")
		{	
		sql = sql + " and ide.batch_id = " + "'"+batch_id+"'" ;
		}
		if(expiry_date != "")
		{	
		sql = sql + " and to_char(ide.expiry_date_or_receipt_date,'dd/mm/yyyy') = "+"'"+expiry_date+"'";
		}
		if(trade_id != "")
		{	
		sql = sql + " and ide.trade_id = " + "'"+trade_id+"'" ;
		}
		if(binlocation != "")
		{	
		sql = sql + " and ide.bin_location_code = " + "'"+binlocation+"'" ;
		}
		}
		sql = sql + "  ORDER BY issue_doc_no, seq_no ";

		System.out.println("sql==>"+sql);

		

		sqlMap.put("sqlData",sql);
		
			
			displayFields.add("ISSUE_DOC_NO");
			displayFields.add("ITEM_DESC");
			displayFields.add("DOC_DATE");
			displayFields.add("REQUEST_STATUS");
			displayFields.add("SEQ_NO");
			displayFields.add("FACILITY_ID");
			displayFields.add("ISSUE_DOC_TYPE"); //Added by Sakti against HSA-CRF-0171 to get ISSUE_DOC_TYPE_CODE Inc# 48543
			displayFields.add("DOC_TYPE_DESC");	 //Added by Sakti against HSA-CRF-0171 to get DOC_TYPE_DESC Inc# 48543
	

			//chkFields.add(doc_type_code); //Comented by Sakti against HSA-CRF-0171 Inc# 48543
			chkFields.add(locale);
			chkFields.add(to_store);
			chkFields.add(fm_store);
			chkFields.add(CommonBean.getLoginFacilityId());
 			chkFields.add(frm_doc_date);
 			chkFields.add(to_doc_date);
 			//chkFields.add(doc_no);
 			//chkFields.add(item_code);
 			chkFields.add(locale); //Added by Sakti against HSA-CRF-0171 Inc# 48543
 			chkFields.add((String)session.getAttribute("ACC_ENTITY_ID"));
			chkFields.add(locale); //Added by Sakti against HSA-CRF-0171 Inc# 48543
			chkFields.add(CommonBean.getLoginFacilityId());	
			chkFields.add(to_store);
			chkFields.add(fm_store);
			//chkFields.add(item_code);
			//chkFields.add(doc_no);
			//chkFields.add(doc_type_code); //comented by Sakti against HSA-CRF-0171 Inc# 48543
			chkFields.add(frm_doc_date);
 			chkFields.add(to_doc_date);

			
			funcMap.put("displayFields", displayFields);
			funcMap.put("chkFields", chkFields);
			result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
		
			if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){
	
            _bw.write(_wl_block9Bytes, _wl_block9);

					out.println(result.get(1));
				
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

			for(int recCount=2; recCount<result.size(); recCount++) {
				if (recCount % 2 == 0)
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;
		
            _bw.write(_wl_block15Bytes, _wl_block15);

				records=(ArrayList) result.get(recCount);
		
		
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf((String)records.get(0)));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf((String)records.get(4)));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf((String)records.get(5)));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf((String)records.get(6)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf((String)records.get(0)));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf((String)records.get(4)));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(records.get(7)));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate((String)records.get(2),"DMY","en",locale)));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(records.get(1)));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(CommonBean.checkForNull((String)records.get(3),"Fully Issued")));
            _bw.write(_wl_block25Bytes, _wl_block25);
	}		
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

			out.flush();
		} 
		else{
		
            _bw.write(_wl_block28Bytes, _wl_block28);

		}
		out.println(CommonBean.setForm (request ,"../../eST/jsp/IssueReturnDocNoSearchResult.jsp", searched));
	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}finally{
			sqlMap.clear();	
			funcMap.clear();
			displayFields.clear();
			chkFields.clear();		
			result.clear();		
			records.clear();		
	}

            _bw.write(_wl_block29Bytes, _wl_block29);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DocNo.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.ReqStatus.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
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
