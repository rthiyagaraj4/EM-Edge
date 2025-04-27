package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eST.StockStatusByItemBean;
import eST.Common.*;
import eCommon.Common.*;
import java.util.HashMap;
import java.util.ArrayList;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;
import eCommon.Common.*;
import java.util.*;

public final class __stockstatusbyitemconsumption extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/StockStatusByItemConsumption.jsp", 1709122216712L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonBean.jsp", 1710760607421L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- Tuesday, June 28, 2004 -->\n";
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

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n\t<head>\n\t\t<title></title>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' ></link>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eST/js/StCommon.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eST/js/StockStatusByItem.js\">\n\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<script>\n\tvar cost_access=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\t\n\t</script>\n\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<table border=\"0\" cellpadding=0 cellspacing=0 width=\"10%\" align=\"center\">\n\t\t\t<tr>\n\t\t\t\t<td width=100 class=\"white\">&nbsp;</td>\n\t\t\t\t<td width=100 class=\"white\">&nbsp;";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t\t</tr>\n\t\t</table>\n\t\t<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"55%\" align=\"left\" id=\'tb1\'>\n\t\t\t<tr>\n\t\t\t\t<th  align=\"center\" >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\t\t\t\t<th  align=\"Right\" >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t<th align=\"Right\" >";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\t\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td  id=\"period_";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" onClick=\"displayPending(\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\',\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\');\" style=\"color:blue;cursor:pointer \"> ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" / ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t\t\t\t\t<td  id=\"qty_";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" align=\"Right\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t<td  id=\"cost_";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\t\n\t\t\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t</table>\n\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t<script>\n\t\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));\n\t\t\t\thistory.go(-1);\n\t\t\t\tdocument.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\n</body>\n</html>\n\n";
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block6Bytes, _wl_block6);

		request.setCharacterEncoding("UTF-8");
		String locale			=		(String)session.getAttribute("LOCALE");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	String item_code			=			request.getParameter( "item_code" )==null?"":request.getParameter( "item_code" );
	String store_code_from			=			request.getParameter( "store_code_from" )==null?"":request.getParameter( "store_code_from" );
	String store_code_to			=			request.getParameter( "store_code_to" )==null?"":request.getParameter( "store_code_to" );
	String bean_id				=			"StockStatusByItemBean";
	String bean_name			=			"eST.StockStatusByItemBean";
	StockStatusByItemBean bean =			(StockStatusByItemBean) getBeanObject( bean_id, bean_name,request );
	bean.setLanguageId(locale);
	boolean searched			=			(request.getParameter("searched") == null) ?false:true;
	//Added by Rabbani #Inc no :39203 on  18/04/2013
	String dflt_facility_id			=			request.getParameter( "dflt_facility_id" )==null?"":request.getParameter( "dflt_facility_id" );
	
	 
	try{
		HashMap sqlMap			=			new HashMap();
		HashMap funcMap			=			new HashMap();
		ArrayList displayFields =			new ArrayList();
		ArrayList chkFields		=			new ArrayList();
		 /** @Name - Priya
		* @Date - 01/02/2010
		* @Inc# - 15496 (SRR20056-CRF-0537.2)
		* @Desc - To use common method, the previous coding has been removed & to get the values based on no_of_decimals 	st_display_decimals function is used in the query
		*/
		//sqlMap.put("sqlData", "SELECT   MOVE_MONTH, MOVE_YEAR, DECODE (TRIM (TO_CHAR (   -1 * (SUM (NVL (CONS_QTY, 0) + NVL (SAL_QTY, 0) + NVL (SRT_QTY, 0))),'999,999,999,999,999,999,999')),'.00', '0',TRIM (TO_CHAR (   -1* (SUM (NVL (CONS_QTY, 0) + NVL (SAL_QTY, 0) + NVL (SRT_QTY, 0))),'999,999,999,999,999,999,999'))) CONSUMPTION_QTY,DECODE (TRIM (TO_CHAR (  -1* (SUM (NVL (CONS_COST, 0) + NVL (SAL_COST, 0) + NVL (SRT_COST, 0))),'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (  -1* (SUM (NVL (CONS_COST, 0) + NVL (SAL_COST, 0) + NVL (SRT_COST, 0))),'999,999,999,999,999,999,999.99')))CONSUMPTION_COST FROM ST_ITEM_MOVE_SUMM   WHERE ITEM_CODE = ? AND FACILITY_ID = ? AND   STORE_CODE BETWEEN NVL(UPPER(?),'!') AND NVL(UPPER(?),'~')  GROUP BY MOVE_YEAR, MOVE_MONTH HAVING (SUM (NVL (CONS_QTY, 0) + NVL (SAL_QTY, 0) + NVL (SRT_QTY, 0))) != 0 OR (SUM (NVL (CONS_COST, 0) + NVL (SAL_COST, 0) + NVL (SRT_COST, 0))) !=0 ORDER BY MOVE_YEAR || '/' || MOVE_MONTH DESC ");
		/** @Name - Priya
		* @Date - 22/04/2010
		* @Desc - To include the param 'N' for the function ST_DISPLAY_DECIMALS
		*/
		//sqlMap.put("sqlData", "SELECT   move_month, move_year,  ST_DISPLAY_DECIMALS((-1 * (SUM (  NVL (cons_qty, 0) + NVL (sal_qty, 0) + NVL (srt_qty, 0) ) )),'N') consumption_qty, DECODE (TRIM (TO_CHAR (  -1 * (SUM (  NVL (cons_cost, 0) + NVL (sal_cost, 0) + NVL (srt_cost, 0) ) ), '999,999,999,999,999,999,999.99' ) ), '.00', '0.00', TRIM (TO_CHAR (  -1 * (SUM (  NVL (cons_cost, 0) + NVL (sal_cost, 0) + NVL (srt_cost, 0) ) ), '999,999,999,999,999,999,999.99' ) ) ) consumption_cost FROM (SELECT distinct a.move_month move_month, a.move_year move_year, a.cons_qty cons_qty, a.sal_qty sal_qty, a.srt_qty srt_qty, a.cons_cost cons_cost, a.sal_cost sal_cost, a.srt_cost srt_cost from st_item_move_summ a, st_acc_entity_param b, st_user_access_for_store c WHERE a.item_code = ? AND a.facility_id = ? AND a.store_code BETWEEN NVL (UPPER (?), '!') AND NVL (UPPER (?), '~') AND c.user_id LIKE DECODE (b.restrict_view_stk_status, 'ALL', '%', ? ) AND a.store_code = c.store_code) GROUP BY move_year, move_month   HAVING (SUM (NVL (cons_qty, 0) + NVL (sal_qty, 0) + NVL (srt_qty, 0))) != 0 OR (SUM (NVL (cons_cost, 0) + NVL (sal_cost, 0) + NVL (srt_cost, 0))) != 0 ORDER BY move_year || '/' || move_month DESC ");	
		/**
		 * @Name - Priya
		 * @Date - 07/06/2010
		 * @Inc# - 
		 * @Desc -  To get consumption_cost with out ',' format the above query is modified 
		 */
		//sqlMap.put("sqlData", "SELECT   move_month, move_year,  ST_DISPLAY_DECIMALS((-1 * (SUM (  NVL (cons_qty, 0) + NVL (sal_qty, 0) + NVL (srt_qty, 0) ) )),'N') consumption_qty, DECODE ((  -1 * (SUM (  NVL (cons_cost, 0) + NVL (sal_cost, 0) + NVL (srt_cost, 0) ) )), '.00', '0.00', (  -1 * (SUM (  NVL (cons_cost, 0) + NVL (sal_cost, 0) + NVL (srt_cost, 0) ) ) ) ) consumption_cost FROM (SELECT distinct a.move_month move_month, a.move_year move_year, a.cons_qty cons_qty, a.sal_qty sal_qty, a.srt_qty srt_qty, a.cons_cost cons_cost, a.sal_cost sal_cost, a.srt_cost srt_cost from st_item_move_summ a, st_acc_entity_param b, st_user_access_for_store c WHERE a.item_code = ? AND a.facility_id = ? AND a.store_code BETWEEN NVL (UPPER (?), '!') AND NVL (UPPER (?), '~') AND c.user_id LIKE DECODE (b.restrict_view_stk_status, 'ALL', '%', ? ) AND a.store_code = c.store_code) GROUP BY move_year, move_month   HAVING (SUM (NVL (cons_qty, 0) + NVL (sal_qty, 0) + NVL (srt_qty, 0))) != 0 OR (SUM (NVL (cons_cost, 0) + NVL (sal_cost, 0) + NVL (srt_cost, 0))) != 0 ORDER BY move_year || '/' || move_month DESC ");
		
		//Added by Rabbani #Inc no :39203 on  18/04/2013
		//sqlMap.put("sqlData", "SELECT   move_month, move_year,  ST_DISPLAY_DECIMALS((-1 * (SUM (  NVL (cons_qty, 0) + NVL (sal_qty, 0) + NVL (srt_qty, 0) ) )),'N') consumption_qty, DECODE ((  -1 * (SUM (  NVL (cons_cost, 0) + NVL (sal_cost, 0) + NVL (srt_cost, 0) ) )), '.00', '0.00', (  -1 * (SUM (  NVL (cons_cost, 0) + NVL (sal_cost, 0) + NVL (srt_cost, 0) ) ) ) ) consumption_cost FROM (SELECT distinct a.move_month move_month, a.move_year move_year, a.cons_qty cons_qty, a.sal_qty sal_qty, a.srt_qty srt_qty, a.cons_cost cons_cost, a.sal_cost sal_cost, a.srt_cost srt_cost from st_item_move_summ a, st_acc_entity_param b, st_user_access_for_store c WHERE a.item_code = ? AND a.facility_id LIKE ? AND a.store_code BETWEEN NVL (UPPER (?), '!') AND NVL (UPPER (?), '~') AND c.user_id LIKE DECODE (b.restrict_view_stk_status, 'ALL', '%', ? ) AND a.store_code = c.store_code) GROUP BY move_year, move_month   HAVING (SUM (NVL (cons_qty, 0) + NVL (sal_qty, 0) + NVL (srt_qty, 0))) != 0 OR (SUM (NVL (cons_cost, 0) + NVL (sal_cost, 0) + NVL (srt_cost, 0))) != 0 ORDER BY move_year || '/' || move_month DESC ");

		
		//Modified by suresh.r on 24-11-2014 against Inc 52256
		//sqlMap.put("sqlData", "SELECT   move_month, move_year,  ST_DISPLAY_DECIMALS((-1 * (SUM (  NVL (cons_qty, 0) + NVL (sal_qty, 0) + NVL (srt_qty, 0) ) )),'N') consumption_qty, /*DECODE ((  -1 * (SUM (  NVL (cons_cost, 0) + NVL (sal_cost, 0) + NVL (srt_cost, 0) ) )), '.00', '0.00', (  -1 * (SUM (  NVL (cons_cost, 0) + NVL (sal_cost, 0) + NVL (srt_cost, 0) ) ) ) ) consumption_cost*/ (st_display_decimals ((  -1 * (SUM (  NVL (cons_qty, 0) + NVL (sal_qty, 0) + NVL (srt_qty, 0)))),'N')*st_display_unit_cost(?,LAST_DAY (TO_DATE (move_month || '/' || move_year, 'mm/yyyy')),'CURRENT_STOCK'))consumption_cost FROM (SELECT distinct a.move_month move_month, a.move_year move_year, a.cons_qty cons_qty, a.sal_qty sal_qty, a.srt_qty srt_qty, a.cons_cost cons_cost, a.sal_cost sal_cost, a.srt_cost srt_cost from st_item_move_summ a, st_acc_entity_param b, st_user_access_for_store c WHERE a.item_code = ? AND a.facility_id LIKE ? AND a.store_code BETWEEN NVL (UPPER (?), '!') AND NVL (UPPER (?), '~') AND c.user_id LIKE DECODE (b.restrict_view_stk_status, 'ALL', '%', ? ) AND a.store_code = c.store_code) GROUP BY move_year, move_month   HAVING (SUM (NVL (cons_qty, 0) + NVL (sal_qty, 0) + NVL (srt_qty, 0))) != 0 OR (SUM (NVL (cons_cost, 0) + NVL (sal_cost, 0) + NVL (srt_cost, 0))) != 0 ORDER BY move_year || '/' || move_month DESC ");
		//Modified by suresh.r on 04-05-2015 against Inc 53214
		sqlMap.put("sqlData", eST.Common.StRepository.getStKeyValue("SQL_ST_STOCK_STATUS_BY_ITEM_CONS_QUERY"));
		
		displayFields.add("move_month");	 		
		displayFields.add("move_year");	
		displayFields.add("consumption_qty");
		displayFields.add("consumption_cost");
		//chkFields.add(CommonBean.checkForNull(item_code,"%"));
		chkFields.add(CommonBean.checkForNull(item_code,"%"));//Added by suresh.r on 24-11-2014 against Inc 52256
		chkFields.add(CommonBean.checkForNull(item_code,"%"));
		//Added by Rabbani #Inc no :39203 on  18/04/2013
		chkFields.add(CommonBean.checkForNull(dflt_facility_id,"%"));
		//chkFields.add(bean.getLoginFacilityId());
		chkFields.add(store_code_from);
		chkFields.add(store_code_to);
		chkFields.add(bean.getLoginById());

		funcMap.put("displayFields", displayFields);
		funcMap.put("chkFields", chkFields);
		ArrayList result		=			(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
		/**
		 * @Name - Priya
		 * @Date - 07/06/2010
		 * @Inc# - 
		 * @Desc -  To get no of decimals for cost 
		 */
		 int noOfDecimalsForCost=Integer.parseInt(bean.getNoOfDecimalsCost());
	
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(bean.getAccessCostDetails()));
            _bw.write(_wl_block10Bytes, _wl_block10);
	if((result.size()>=3)&&(!(((String) result.get(0)).equals("0")))){
		
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(result.get(1)));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
if(((String)bean.getAccessCostDetails()).equals("Y")){
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
}
            _bw.write(_wl_block16Bytes, _wl_block16);

			     String strYear = "";
				int intCount			=		0;
				ArrayList data = new ArrayList();
				for (int i=2; i<result.size(); i++) {
					++intCount;
				//	String className	=		(i % 2 == 0)?"QRYEVEN":"QRYODD";
					data				=		(ArrayList)result.get(i);
					int  intmonth		=		Integer.parseInt((String)data.get(0));
					String strMonth		=		"";
					if (intmonth <10) {
						strMonth		=		"0"+intmonth;
					}else{
						strMonth		=		""+intmonth;
					}  			
					strYear = com.ehis.util.DateUtils.convertDate((String)data.get(1),"YY","en",locale);
					
					

			
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(intCount));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(strMonth));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(strYear));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf((String)data.get(1)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(intCount));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(store_code_from));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(store_code_to));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(strMonth));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(strYear));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(intCount));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(data.get(2)));
            _bw.write(_wl_block24Bytes, _wl_block24);
if(((String)bean.getAccessCostDetails()).equals("Y")){
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(intCount));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(bean.setNumberFormat((String)data.get(3),noOfDecimalsForCost)));
            _bw.write(_wl_block24Bytes, _wl_block24);
}
            _bw.write(_wl_block26Bytes, _wl_block26);

				}
			
            _bw.write(_wl_block27Bytes, _wl_block27);

			out.flush();
		} 
		else{
		
            _bw.write(_wl_block28Bytes, _wl_block28);

		}
		out.println(CommonBean.setForm (request ,"../../eST/jsp/StockStatusByItemConsumption.jsp", searched));
	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Period.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.ConsumptionQty.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.ConsumptionCost.label", java.lang.String .class,"key"));
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
}
