package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eST.StockStatusByStoreBean;
import eST.StockStatusByItemBean;
import java.util.HashMap;
import webbeans.eCommon.*;
import java.util.ArrayList;
import java.text.NumberFormat;
import java.util.Locale;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import eCommon.Common.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __stockstatusbyitemlist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/StockStatusByItemList.jsp", 1732987893840L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\n<html>\n\t<head>\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' ></link>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eST/js/StCommon.js\"></script>\n\t\t<!-- \t<script language=\"javascript\" src=\"../../eST/js/StockStatusByStoreDetailBean.js\"></script>-->\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t<title>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</title>\n\t</head>\n\t\n\t<BODY onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" > \n\t<form name=\"StockStatusByItemList\" id=\"StockStatusByItemList\">\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<table CELLPADDING=0 CELLSPACING=0 WIDTH=\"100%\" ALIGN=\"center\">\n\t\t\n\t\t\t<tr>\n\t\t\t\t<td width=\"80%\" class=\"white\">&nbsp;</td>\n\t\t\t\t<td width=\"20%\" class=\"white\" align=\"right\">&nbsp;";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t</tr>\n\t\t\n\t\t\t</table>\n\t\t\t<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"99%\" align=\"center\" id=\'tb1\'>\n\t\t\t<tr>\n\t\t\t\t<th>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n\t\t\t\t<th>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t<th>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&nbsp;";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t</tr>\t\n\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t<!--\n\t\t\t\t* @Name - Priya\n\t\t\t\t* @Date - 01/02/2010\n\t\t\t\t* @Inc# - 15496 (SRR20056-CRF-0537.2)\n\t\t\t\t* @Desc - Modified by priya as if the value of \'IssueQuantity\' & \'SaleQuantity\' is equal to zero and no_of_decimals is 4 then it should be displayed as 0 only & not as \'0.000\' & so used the common function st_display_decimals has been used in the query\n\t\t\t\t-->\n\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" align=\"left\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" style=\"TEXT-ALIGN:right\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t</table>\n\t\t\n\t\t</form>\n\t\t\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
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

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);


		boolean searched			=		(request.getParameter("searched") == null) ?false:true;
		String item_code			=		request.getParameter("item_code")==null?"":request.getParameter( "item_code" );
		String move_year			=		request.getParameter("move_year")==null?"":request.getParameter( "move_year" );
		String move_month			=		request.getParameter("move_month")==null?"":request.getParameter( "move_month" );
		String store_code_from			=			request.getParameter( "store_code_from" )==null?"":request.getParameter( "store_code_from" );
		String store_code_to			=			request.getParameter( "store_code_to" )==null?"":request.getParameter( "store_code_to" );
		String strCostAccess			=			request.getParameter( "cost_access" )==null?"":request.getParameter( "cost_access" );
		String bean_id				=			"StockStatusByItemBean";
	String bean_name			=			"eST.StockStatusByItemBean";
	StockStatusByItemBean bean =			(StockStatusByItemBean) getBeanObject( bean_id, bean_name,request );
	bean.setLanguageId(locale);
	//	String ACC_ENTITY_ID				=		(String)session.getAttribute("ACC_ENTITY_ID");
		
	
		String user_name			=		(String) session.getValue( "login_user" ) ;
	try{
		HashMap sqlMap				=		new HashMap();
		HashMap funcMap				=		new HashMap();
		ArrayList displayFields		=		new ArrayList();
		ArrayList chkFields			=		new ArrayList();
		/**
		 * @Name - Priya
		 * @Date - 07/06/2010
		 * @Inc# - 
		 * @Desc -  To get no of decimals for cost 
		 */
		 int noOfDecimalsForCost=Integer.parseInt(bean.getNoOfDecimalsCost());

		/** @Name - Priya
		* @Date - 01/02/2010
		* @Inc# - 15496 (SRR20056-CRF-0537.2)
		* @Desc - To use common method, the previous coding has been removed & to get the values based on no_of_decimals 	st_display_decimals function is used in the query
		*/
		//sqlMap.put("sqlData","SELECT   B.SHORT_DESC STORE,DECODE (TRIM (TO_CHAR ( -1 * (SUM (NVL (A.CONS_QTY, 0))),'999,999,999,999,999,999,999')),'.00', '0',TRIM (TO_CHAR ( -1 * (SUM (NVL (A.CONS_QTY, 0))),'999,999,999,999,999,999,999')))  ISSUE,DECODE (TRIM (TO_CHAR (-1 * (SUM (NVL (A.CONS_COST, 0))),'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (-1 * (SUM (NVL (A.CONS_COST, 0))),'999,999,999,999,999,999,999.99'))) ISSUE_COST,DECODE (TRIM (TO_CHAR ( -1 * (SUM (NVL (A.SAL_QTY, 0) + NVL (A.SRT_QTY, 0))),'999,999,999,999,999,999,999')),'.00', '0',TRIM (TO_CHAR ( -1 * (SUM (NVL (A.SAL_QTY, 0) + NVL (A.SRT_QTY, 0))),'999,999,999,999,999,999,999'))) SALESPATIENT,DECODE (TRIM (TO_CHAR (-1 * (SUM (NVL (A.SAL_COST, 0) + NVL (A.SRT_COST, 0))),'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (-1 * (SUM (NVL (A.SAL_COST, 0) + NVL (A.SRT_COST, 0))),'999,999,999,999,999,999,999.99')))  SALESPATIENT_VALUE FROM ST_ITEM_MOVE_SUMM A, MM_STORE_LANG_VW B   WHERE A.STORE_CODE = B.STORE_CODE AND A.ITEM_CODE = ? AND A.MOVE_YEAR = ? AND A.MOVE_MONTH = ? AND B.LANGUAGE_ID = ? AND A.FACILITY_ID = ? AND A.STORE_CODE BETWEEN NVL(UPPER(?),'!') AND NVL(UPPER(?),'~') GROUP BY B.SHORT_DESC HAVING -1 * (SUM (NVL (A.CONS_QTY, 0))) != 0 OR -1 * (SUM (NVL (A.CONS_COST, 0))) != 0 OR -1 * (SUM (NVL (A.SAL_QTY, 0) + NVL (A.SRT_QTY, 0))) != 0 OR -1 * (SUM (NVL (A.SAL_COST, 0) + NVL (A.SRT_COST, 0))) != 0 ");

		/** @Name - Priya
		* @Date - 22/04/2010
		* @Desc - To include the param 'N' for the function ST_DISPLAY_DECIMALS
		*/
		//sqlMap.put("sqlData","SELECT STORE, ST_DISPLAY_DECIMALS((-1 * (SUM (NVL (cons_qty, 0)))),'N') issue, DECODE (TRIM (TO_CHAR (-1 * (SUM (NVL (cons_cost, 0))), '999,999,999,999,999,999,999.99' ) ), '.00', '0.00', TRIM (TO_CHAR (-1 * (SUM (NVL (cons_cost, 0))), '999,999,999,999,999,999,999.99' ) ) ) issue_cost, ST_DISPLAY_DECIMALS((  -1 * (SUM (NVL (sal_qty, 0) + NVL (srt_qty, 0)) )),'N') salespatient, DECODE (TRIM (TO_CHAR (  -1 * (SUM (NVL (sal_cost, 0) + NVL (srt_cost, 0)) ), '999,999,999,999,999,999,999.99' ) ), '.00', '0.00', TRIM (TO_CHAR (  -1 * (SUM (NVL (sal_cost, 0) + NVL (srt_cost, 0)) ), '999,999,999,999,999,999,999.99' ) ) ) salespatient_value     FROM ( select distinct b.short_desc STORE,a.cons_qty cons_qty, a.sal_qty sal_qty, a.srt_qty srt_qty, a.cons_cost cons_cost, a.sal_cost sal_cost, a.srt_cost srt_cost from st_item_move_summ a, mm_store_lang_vw b,st_acc_entity_param c, st_user_access_for_store d    WHERE a.store_code = b.store_code AND a.item_code = ? AND a.move_year = ? AND a.move_month = ? AND b.language_id = ? AND a.facility_id = ? AND a.store_code BETWEEN NVL (UPPER (?), '!') AND NVL (UPPER (?), '~') AND d.user_id LIKE DECODE (c.restrict_view_stk_status, 'ALL', '%', ? ) AND a.store_code = d.store_code) GROUP BY STORE   HAVING -1 * (SUM (NVL (cons_qty, 0))) != 0 OR -1 * (SUM (NVL (cons_cost, 0))) != 0 OR -1 * (SUM (NVL (sal_qty, 0) + NVL (srt_qty, 0))) != 0       OR -1 * (SUM (NVL (sal_cost, 0) + NVL (srt_cost, 0))) != 0");
		/**
		 * @Name - Priya
		 * @Date - 07/06/2010
		 * @Inc# - 
		 * @Desc -  To get consumption_cost with out ',' format the above query is modified 
		 */
		//sqlMap.put("sqlData","SELECT STORE, ST_DISPLAY_DECIMALS((-1 * (SUM (NVL (cons_qty, 0)))),'N') issue, DECODE ((-1 * (SUM (NVL (cons_cost, 0)))), '.00', '0.00', (-1 * (SUM (NVL (cons_cost, 0))) ) ) issue_cost, ST_DISPLAY_DECIMALS((  -1 * (SUM (NVL (sal_qty, 0) + NVL (srt_qty, 0)) )),'N') salespatient, DECODE ((  -1 * (SUM (NVL (sal_cost, 0) + NVL (srt_cost, 0)) ) ), '.00', '0.00',(  -1 * (SUM (NVL (sal_cost, 0) + NVL (srt_cost, 0)) ) ) ) salespatient_value     FROM ( select distinct b.short_desc STORE,a.cons_qty cons_qty, a.sal_qty sal_qty, a.srt_qty srt_qty, a.cons_cost cons_cost, a.sal_cost sal_cost, a.srt_cost srt_cost from st_item_move_summ a, mm_store_lang_vw b,st_acc_entity_param c, st_user_access_for_store d    WHERE a.store_code = b.store_code AND a.item_code = ? AND a.move_year = ? AND a.move_month = ? AND b.language_id = ? AND a.facility_id = ? AND a.store_code BETWEEN NVL (UPPER (?), '!') AND NVL (UPPER (?), '~') AND d.user_id LIKE DECODE (c.restrict_view_stk_status, 'ALL', '%', ? ) AND a.store_code = d.store_code) GROUP BY STORE   HAVING -1 * (SUM (NVL (cons_qty, 0))) != 0 OR -1 * (SUM (NVL (cons_cost, 0))) != 0 OR -1 * (SUM (NVL (sal_qty, 0) + NVL (srt_qty, 0))) != 0       OR -1 * (SUM (NVL (sal_cost, 0) + NVL (srt_cost, 0))) != 0");

		/*
					 * @Name - Sakti
					 * @Date - 24/07/2014
					 * @Inc# -  SKR-SCF-1023 [IN:050330]
					 * @Desc - to calculate cost, quantity*st_display_unit_cost() added
		*/

		//sqlMap.put("sqlData","SELECT STORE, ST_DISPLAY_DECIMALS((-1 * (SUM (NVL (cons_qty, 0)))),'N') issue, /*DECODE ((-1 * (SUM (NVL (cons_cost, 0)))), '.00', '0.00', (-1 * (SUM (NVL (cons_cost, 0))) ) ) issue_cost*/ ( st_display_decimals ((-1 * (SUM (NVL (cons_qty, 0)))), 'N')*st_display_unit_cost(?))issue_cost, ST_DISPLAY_DECIMALS((  -1 * (SUM (NVL (sal_qty, 0) + NVL (srt_qty, 0)) )),'N') salespatient, /*DECODE ((  -1 * (SUM (NVL (sal_cost, 0) + NVL (srt_cost, 0)) ) ), '.00', '0.00',(  -1 * (SUM (NVL (sal_cost, 0) + NVL (srt_cost, 0)) ) ) ) salespatient_value*/ (st_display_decimals ((-1 * (SUM (NVL (sal_qty, 0) + NVL (srt_qty, 0)))), 'N')*st_display_unit_cost(?))salespatient_value     FROM ( select distinct b.short_desc STORE,a.cons_qty cons_qty, a.sal_qty sal_qty, a.srt_qty srt_qty, a.cons_cost cons_cost, a.sal_cost sal_cost, a.srt_cost srt_cost from st_item_move_summ a, mm_store_lang_vw b,st_acc_entity_param c, st_user_access_for_store d    WHERE a.store_code = b.store_code AND a.item_code = ? AND a.move_year = ? AND a.move_month = ? AND b.language_id = ? AND a.facility_id = ? AND a.store_code BETWEEN NVL (UPPER (?), '!') AND NVL (UPPER (?), '~') AND d.user_id LIKE DECODE (c.restrict_view_stk_status, 'ALL', '%', ? ) AND a.store_code = d.store_code) GROUP BY STORE   HAVING -1 * (SUM (NVL (cons_qty, 0))) != 0 OR -1 * (SUM (NVL (cons_cost, 0))) != 0 OR -1 * (SUM (NVL (sal_qty, 0) + NVL (srt_qty, 0))) != 0       OR -1 * (SUM (NVL (sal_cost, 0) + NVL (srt_cost, 0))) != 0");
		//Modified by suresh.r on 24-11-2014 against Inc 52256
		sqlMap.put("sqlData","SELECT STORE, ST_DISPLAY_DECIMALS((-1 * (SUM (NVL (cons_qty, 0)))),'N') issue, /*DECODE ((-1 * (SUM (NVL (cons_cost, 0)))), '.00', '0.00', (-1 * (SUM (NVL (cons_cost, 0))) ) ) issue_cost*/ ( st_display_decimals ((-1 * (SUM (NVL (cons_qty, 0)))), 'N')*st_display_unit_cost(?,LAST_DAY (TO_DATE (move_month || '/' || move_year, 'mm/yyyy')),'CURRENT_STOCK'))issue_cost, ST_DISPLAY_DECIMALS((  -1 * (SUM (NVL (sal_qty, 0) + NVL (srt_qty, 0)) )),'N') salespatient, /*DECODE ((  -1 * (SUM (NVL (sal_cost, 0) + NVL (srt_cost, 0)) ) ), '.00', '0.00',(  -1 * (SUM (NVL (sal_cost, 0) + NVL (srt_cost, 0)) ) ) ) salespatient_value*/ (st_display_decimals ((-1 * (SUM (NVL (sal_qty, 0) + NVL (srt_qty, 0)))), 'N')*st_display_unit_cost(?,LAST_DAY (TO_DATE (move_month || '/' || move_year, 'mm/yyyy')),'CURRENT_STOCK'))salespatient_value     FROM ( select distinct b.short_desc STORE,a.cons_qty cons_qty, a.sal_qty sal_qty, a.srt_qty srt_qty, a.cons_cost cons_cost, a.sal_cost sal_cost, a.srt_cost srt_cost,a.move_month move_month,a.move_year move_year from st_item_move_summ a, mm_store_lang_vw b,st_acc_entity_param c, st_user_access_for_store d    WHERE a.store_code = b.store_code AND a.item_code = ? AND a.move_year = ? AND a.move_month = ? AND b.language_id = ? AND a.facility_id = ? AND a.store_code BETWEEN NVL (UPPER (?), '!') AND NVL (UPPER (?), '~') AND d.user_id LIKE DECODE (c.restrict_view_stk_status, 'ALL', '%', ? ) AND a.store_code = d.store_code) GROUP BY STORE,move_month,move_year   HAVING -1 * (SUM (NVL (cons_qty, 0))) != 0 OR -1 * (SUM (NVL (cons_cost, 0))) != 0 OR -1 * (SUM (NVL (sal_qty, 0) + NVL (srt_qty, 0))) != 0       OR -1 * (SUM (NVL (sal_cost, 0) + NVL (srt_cost, 0))) != 0");

		//Line In repo 914			
		displayFields.add("STORE");	
		displayFields.add("issue");	
		displayFields.add("issue_cost");
		displayFields.add("salespatient");
		displayFields.add("salespatient_value");
	
		//chkFields.add( store_code);
		chkFields.add( item_code);
		chkFields.add( item_code);
		chkFields.add( item_code);
		chkFields.add( move_year);
		chkFields.add( move_month);
		chkFields.add(locale);
		chkFields.add((String)session.getValue("facility_id"));
		chkFields.add(store_code_from);
		chkFields.add(store_code_to);
		chkFields.add(user_name);

		funcMap.put("displayFields", displayFields);
		funcMap.put("chkFields", chkFields);
		ArrayList result			=		(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
	 
		if((result.size()>=3)){
 
		//	{
		
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(result.get(1)));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
if(strCostAccess.equals("Y")){
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
}
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
if(strCostAccess.equals("Y")){
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
}
            _bw.write(_wl_block16Bytes, _wl_block16);

				ArrayList data = new ArrayList();
				for (int i=2; i<result.size(); i++) {
					String className = (i % 2 == 0)?"QRYEVEN":"QRYODD";
					data = (ArrayList)result.get(i);	
	System.err.println("===data"+data	);		
				
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(className));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf((String)data.get(0)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(className));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(data.get(1)));
            _bw.write(_wl_block21Bytes, _wl_block21);
if(strCostAccess.equals("Y")){
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(className));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(bean.setNumberFormat((String)data.get(2),noOfDecimalsForCost)));
            _bw.write(_wl_block21Bytes, _wl_block21);
}
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(className));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(data.get(3)));
            _bw.write(_wl_block21Bytes, _wl_block21);
if(strCostAccess.equals("Y")){
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(className));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(bean.setNumberFormat((String)data.get(4),noOfDecimalsForCost)));
            _bw.write(_wl_block21Bytes, _wl_block21);
}
            _bw.write(_wl_block23Bytes, _wl_block23);

				}
			
            _bw.write(_wl_block24Bytes, _wl_block24);
	
	out.flush();
	}
	out.println(CommonBean.setForm (request ,"../../eST/jsp/StockStatusByItemList.jsp", searched));
	}
				catch(Exception e) {
					e.printStackTrace();
				}

            _bw.write(_wl_block25Bytes, _wl_block25);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.StorewiseConsumption.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Store.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.IssueQuantity.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.IssuesCost.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SaleQuantity.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Sale.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Cost.label", java.lang.String .class,"key"));
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
}
