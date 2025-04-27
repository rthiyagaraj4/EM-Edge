package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eST.StockStatusByItemBean;
import eST.Common.*;
import java.util.HashMap;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ArrayList;
import java.text.DecimalFormat;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import eCommon.Common.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __stockstatusbyitemqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/StockStatusByItemQueryResult.jsp", 1709122217884L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n\t<head>\n\t\t<title></title>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' ></link>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/rowcolor.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eST/js/StCommon.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eST/js/StockStatusByItem.js\">\n\t\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<table cellpadding=0 cellspacing=0 width=\"100%\" align=\"center\">\n\t\t<tr>\n\t\t<td width=\"80%\" class=\"white\">&nbsp;</td>\n\t\t\n\t\t<td width=\"20%\" class=\"white\">&nbsp;";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t</tr>\n\t\t</table>\n\t\t<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" id=\'tb1\'>\n\t\t<th width=100 align=\"center\" >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n\t\t<th width=100 align=\"center\" >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n\t\t <th width=100 align=\"center\" >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th> \n\t\t<!-- <th width=100 align=\"center\" >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th> -->\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t<th   width=100>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</th>\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t<th width=80 align=\"center\" >";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</th>\n\t\t<th width=130 align=\"center\" >";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</th>\n\t</tr>\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t<tr>\n\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t <!--\n\t\t* @Name - Priya\n\t\t* @Date - 01/02/2010\n\t\t* @Inc# - 15496 (SRR20056-CRF-0537.2)\n\t\t* @Desc - Modified by priya as if the value of \'Quantity on Hand\' & \'Available Quantity\' is equal to zero and no_of_decimals is 4 then it should be displayed as 0 only & not as \'0.000\' & so used the common method\n\t\t-->\n\t\t<tr>\n\t\t<td  class=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" align=left width=100><font size=1><A HREF=\"#\" onClick=\"callBatchSearchScreen (\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\',\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\');\" title = \'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' >";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</A></font></td>\n\t\t\t\t\t<!-- \t\t\t\t\t\n\t\t\t\t\t\t* @Name - Priya\n\t\t\t\t\t\t* @Date - 19/02/2010\n\t\t\t\t\t\t* @Inc# - IN019466\n\t\t\t\t\t\t* @Desc - To right align Quantity On Hand, Available Qty, Cost Value, RO Level.\t\t\t\t\n\t\t\t\t\t-->\n\t\t<td  class=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" style=\"TEXT-ALIGN:right\"><font size=1>\n\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</font>&nbsp;</td>\n\t\t<td  class=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"  style=\"TEXT-ALIGN:right\"><font size=1>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</font>&nbsp;</td>\n\t\t<!-- <td  class=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" align=right width=100><font size=1>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</font></td>\n\t -->\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t<!--<td  class=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</font>&nbsp;</td>-->\n\t\t<td  class=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</font>&nbsp;</td>\n\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t<td  class=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\"  >\n\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t<image src=\'../../eCommon/images/enabled.gif\'>\n\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t<image src=\'../../eCommon/images/disabled.gif\'>\n\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t</td>\n\t\t\n\t\t<td  class=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" align=left width=150><font size=1>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</font></td>\n\t\t<td  class=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</font>&nbsp;</td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t</table>\n\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t<script>\n\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));\n\t\tdocument.location.href=\"../../eCommon/html/blank.html\";\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );
	
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
            _bw.write(_wl_block6Bytes, _wl_block6);

		request.setCharacterEncoding("UTF-8");
		String locale				=		(String)session.getAttribute("LOCALE");
		String sStyle				=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	
	String store_code_from			 =			request.getParameter( "store_code_from" )==null?"":request.getParameter( "store_code_from" );
	String store_code_to			 =			request.getParameter( "store_code_to" )==null?"":request.getParameter( "store_code_to" );
	String stock_level				 =			request.getParameter( "stock_level" )==null?"A":request.getParameter( "stock_level" );
	String item_code				 =			request.getParameter( "item_code" )==null?"":request.getParameter( "item_code" );
	 //Added by Rabbani #Inc no :39203 on  18/04/2013
	String dflt_facility_id	        =			request.getParameter( "dflt_facility_id" )==null?"":request.getParameter( "dflt_facility_id" );
	dflt_facility_id				=			CommonBean.checkForNull(dflt_facility_id,"%");
	String facility_name			=			"";  
	item_code						=			CommonBean.checkForNull(item_code,"%");
	String store_desc				=			"";
	String qty_on_hand				=			"";
	String item_value				=			"";
	String reorder_level			=			"";
	String bin_desc					=			"";
	String stock_yn					=			"";
	String store_code				=			"";
	String aval_qty					=			"";
	String bean_id					=			"StockStatusByItemBean";
	String bean_name				=			"eST.StockStatusByItemBean";
	StockStatusByItemBean bean		=			(StockStatusByItemBean) getBeanObject( bean_id, bean_name,request );
	bean.setLanguageId(locale);
	String item_value_new			=			"";
	String restrictInReportYN		= ""; //MOHE-ICN-0015

	boolean searched				=			(request.getParameter("searched") == null) ?false:true;
	//Added by Rabbani #30069(BRU-HIMS-CRF-110) on 23-APR-2013
	String includeSuspendedBatches	 =			request.getParameter( "includeSuspendedBatches" )==null?"N":request.getParameter( "includeSuspendedBatches" );
	
	// Added By Rams 12/15/2009 For the Decimal CRF 537.1 Begins
	/* @Name - Rams
 * @Date - 12/15/2009
 * @Inc# - CRF 537.1
 * @Desc - For the Decimal related display
 */
	 /** @Name - Priya
	* @Date - 01/02/2010
	* @Inc# - 15496 (SRR20056-CRF-0537.2)
	* @Desc - To use common method, the previous coding has been removed
	*/
		int no_of_decimals=bean.getNoOfDecimals();
	//END
	/* Query Changed By rams
       Incident No : 18097
	   Format Masking in the query is removed As It is Not Giving Right Values for the Avl.Qty and Qty_on_Hand
	   Date 1/11/2010
	*/
	
	
	
	try{
		HashMap sqlMap				=			new HashMap();
		HashMap funcMap				=			new HashMap();
		ArrayList displayFields		=			new ArrayList();
		ArrayList chkFields			=			new ArrayList();
		//String user_name			=			(String) session.getValue( "login_user" ) ;


		//MOHE-ICN-0015
		String restrict_view_stk_status =		bean.checkForNull((String)bean.fetchRecord("select  restrict_view_stk_status  from  ST_ACC_ENTITY_PARAM where ACC_ENTITY_ID= 'ZZ'").get("RESTRICT_VIEW_STK_STATUS"),"N");
		//sqlMap.put("sqlData", eST.Common.StRepository.getStKeyValue("SQL_ST_STOCK_STATUS_BY_ITEM_STORE_LEVEL"));
		//sqlMap.put("sqlData", " SELECT   A.ITEM_CODE ITEM_CODE, A.STORE_CODE STORE_CODE,B.SHORT_DESC STORE_DESC, DECODE (TRIM (TO_CHAR (SUM (NVL (H.QTY_ON_HAND, 0)), '999,999,999,999,999,999,999') ), '.00', '0', TRIM (TO_CHAR (SUM (NVL (H.QTY_ON_HAND, 0)), '999,999,999,999,999,999,999') ) ) QTY_ON_HAND,A.STOCK_ITEM_YN STOCK_ITEM_YN, A.BIN_LOCATION_CODE,C.SHORT_DESC BIN_DESC,DECODE (TRIM (TO_CHAR ( NVL (A.REORDER_LEVEL, '0'),'999,999,999,999,999,999,999')),'0', '',TRIM (TO_CHAR ( NVL (A.REORDER_LEVEL, '0'),'999,999,999,999,999,999,999'))) REORDER_LEVEL,DECODE (TRIM (TO_CHAR (A.ITEM_VALUE,'999,999,999,999,999,999,999.99')),'.00', '0.00',TRIM (TO_CHAR (A.ITEM_VALUE,'999,999,999,999,999,999,999.99'))) ITEM_VALUE,DECODE (TRIM (TO_CHAR ( SUM (NVL (H.QTY_ON_HAND, 0) - NVL (H.COMMITTED_QTY, 0)),'999,999,999,999,999,999,999')),'.00', '0',TRIM (TO_CHAR ( SUM (NVL (H.QTY_ON_HAND, 0) - NVL (H.COMMITTED_QTY, 0)),'999,999,999,999,999,999,999')))  AVAILABLE_QTY,G.SHORT_DESC STOCK_UOM_DESC FROM ST_ITEM_STORE A,MM_STORE_LANG_VW B,MM_BIN_LOCATION_LANG_VW C /*,ST_USER_ACCESS_FOR_STORE D */,ST_STORE E,MM_ITEM_LANG_VW F,AM_UOM G,ST_ITEM_BATCH H WHERE A.STORE_CODE = B.STORE_CODE AND A.STORE_CODE = C.STORE_CODE(+) AND A.BIN_LOCATION_CODE = C.BIN_LOCATION_CODE(+) AND A.ITEM_CODE = ? /* AND D.USER_ID = ? AND D.STORE_CODE = B.STORE_CODE */ AND B.STORE_CODE = E.STORE_CODE AND E.STORE_TYPE_FLAG != 'N' AND B.LANGUAGE_ID = C.LANGUAGE_ID AND B.LANGUAGE_ID = ? AND B.LANGUAGE_ID = F.LANGUAGE_ID AND A.ITEM_CODE = F.ITEM_CODE AND A.DEF_ISSUE_UOM = G.UOM_CODE AND B.FACILITY_ID = ? AND E.STORE_CODE BETWEEN NVL (UPPER (?), '!') AND NVL (UPPER (?), '~') AND (   (? = 'Z' AND A.QTY_ON_HAND = 0) OR (? = 'S' AND A.QTY_ON_HAND > 0) OR (? = 'B' AND A.QTY_ON_HAND < NVL (A.REORDER_LEVEL, '0')) OR ? = 'A' ) AND A.STORE_CODE = H.STORE_CODE(+) AND A.ITEM_CODE = H.ITEM_CODE(+) GROUP BY A.ITEM_CODE, A.STORE_CODE, B.SHORT_DESC, A.QTY_ON_HAND, A.STOCK_ITEM_YN, A.BIN_LOCATION_CODE, C.SHORT_DESC, REORDER_LEVEL, A.ITEM_VALUE, G.SHORT_DESC ORDER BY STORE_DESC, QTY_ON_HAND, ITEM_VALUE ");
		/**
			* @Name - Priya
			* @Date - 29/04/2010
			* @Inc# - 20990
			* @Desc - h.expiry_date_or_receipt_date column is included in the select distinct sub query 
			*/
		//sqlMap.put("sqlData", "SELECT   item_code, store_code, store_desc, SUM (NVL (qty_on_hand, 0)) qty_on_hand, stock_item_yn, bin_location_code, bin_desc, DECODE (TRIM (TO_CHAR (NVL (reorder_level, '0'), '999,999,999,999,999,999,999' ) ), '0', '', TRIM (TO_CHAR (NVL (reorder_level, '0'), '999,999,999,999,999,999,999' ))) reorder_level, DECODE (TRIM (TO_CHAR (item_value, '999,999,999,999,999,999,999.99')), '.00', '0.00', TRIM (TO_CHAR (item_value, '999,999,999,999,999,999,999.99')) ) item_value, SUM (  NVL (qty_on_hand, 0)  - NVL (committed_qty, 0)),SUM (  NVL (qty_on_hand, 0) - NVL (committed_qty, 0)) available_qty, stock_uom_desc FROM (SELECT distinct h.batch_id, a.item_code item_code, a.store_code store_code, b.short_desc store_desc, h.qty_on_hand, a.stock_item_yn stock_item_yn, a.bin_location_code, c.short_desc bin_desc, a.reorder_level, a.item_value, h.committed_qty, g.short_desc stock_uom_desc,h.expiry_date_or_receipt_date FROM st_item_store a, mm_store_lang_vw b, mm_bin_location_lang_vw c, st_user_access_for_store d, st_store e, mm_item_lang_vw f, am_uom g, st_item_batch h, st_acc_entity_param i WHERE a.store_code = b.store_code AND a.store_code = c.store_code(+) AND a.bin_location_code = c.bin_location_code(+) AND a.item_code = ? AND b.store_code = e.store_code AND e.store_type_flag != 'N' AND c.language_id(+) = ? AND b.language_id = ? AND b.language_id = f.language_id AND a.item_code = f.item_code AND a.def_issue_uom = g.uom_code AND b.facility_id = ? AND e.store_code BETWEEN NVL (UPPER (?), '!') AND NVL (UPPER (?), '~') AND (   (? = 'Z' AND a.qty_on_hand = 0) OR (? = 'S' AND a.qty_on_hand > 0) OR (? = 'B' AND a.qty_on_hand < NVL (a.reorder_level, '0') ) OR ? = 'A' ) AND a.store_code = h.store_code(+) AND a.item_code = h.item_code(+) AND d.user_id LIKE DECODE (i.restrict_view_stk_status, 'ALL', '%', ? ) AND a.store_code = d.store_code) GROUP BY item_code, store_code, store_desc, stock_item_yn, bin_location_code, bin_desc, reorder_level, item_value, stock_uom_desc ORDER BY store_desc, qty_on_hand, item_value");
		/**
		 * @Name - Priya
		 * @Date - 07/06/2010
		 * @Inc# - 
		 * @Desc -  To get item_value with out ',' format the above query is modified 
		 */
		 //Commented by Rabbani #Inc no :39203 on  18-APR-2013
		//sqlMap.put("sqlData", "SELECT   item_code, store_code, store_desc, SUM (NVL (qty_on_hand, 0)) qty_on_hand, stock_item_yn, bin_location_code, bin_desc, DECODE (TRIM (TO_CHAR (NVL (reorder_level, '0'), '999,999,999,999,999,999,999' ) ), '0', '', TRIM (TO_CHAR (NVL (reorder_level, '0'), '999,999,999,999,999,999,999' ))) reorder_level, item_value, SUM (  NVL (qty_on_hand, 0)  - NVL (committed_qty, 0)),SUM (  NVL (qty_on_hand, 0) - NVL (committed_qty, 0)) available_qty, stock_uom_desc FROM (SELECT distinct h.batch_id, a.item_code item_code, a.store_code store_code, b.short_desc store_desc, h.qty_on_hand, a.stock_item_yn stock_item_yn, a.bin_location_code, c.short_desc bin_desc, a.reorder_level, a.item_value, h.committed_qty, g.short_desc stock_uom_desc,h.expiry_date_or_receipt_date FROM st_item_store a, mm_store_lang_vw b, mm_bin_location_lang_vw c, st_user_access_for_store d, st_store e, mm_item_lang_vw f, am_uom g, st_item_batch h, st_acc_entity_param i, st_item j WHERE a.store_code = b.store_code AND a.store_code = c.store_code(+) AND a.bin_location_code = c.bin_location_code(+) AND a.item_code = ? AND b.store_code = e.store_code AND e.store_type_flag != 'N' AND c.language_id(+) = ? AND b.language_id = ? AND b.language_id = f.language_id AND a.item_code = f.item_code AND a.def_issue_uom = g.uom_code AND b.facility_id = ? AND e.store_code BETWEEN NVL (UPPER (?), '!') AND NVL (UPPER (?), '~') AND (   (? = 'Z' AND a.qty_on_hand = 0) OR (? = 'S' AND a.qty_on_hand > 0) OR (? = 'B' AND a.qty_on_hand < NVL (a.reorder_level, '0') ) OR ? = 'A' ) AND a.store_code = h.store_code(+) AND a.item_code = h.item_code(+) AND d.user_id LIKE DECODE (i.restrict_view_stk_status, 'ALL', '%', ? ) AND a.store_code = d.store_code AND j.item_code = a.item_code AND (   expiry_yn = 'N'    OR (    expiry_yn = 'Y' AND (   (    /* use_after_expiry_yn = 'Y' AND */ ('Y' = 'Y') ) OR decode(a.qty_on_hand,0,sysdate,expiry_date_or_receipt_date) >= TRUNC (NVL (TO_DATE ('', 'dd/mm/yyyy'), SYSDATE ) ) )))) GROUP BY item_code, store_code, store_desc, stock_item_yn, bin_location_code, bin_desc, reorder_level, item_value, stock_uom_desc ORDER BY store_desc, qty_on_hand, item_value");
		
		//Added by Rabbani #Inc no :39203 on  18-APR-2013
		//Commented by Rabbani #30069(BRU-HIMS-CRF-110) on 23-APR-2013
		//sqlMap.put("sqlData", "SELECT   item_code, store_code, store_desc, SUM (NVL (qty_on_hand, 0)) qty_on_hand, stock_item_yn, bin_location_code, bin_desc, DECODE (TRIM (TO_CHAR (NVL (reorder_level, '0'), '999,999,999,999,999,999,999' ) ), '0', '', TRIM (TO_CHAR (NVL (reorder_level, '0'), '999,999,999,999,999,999,999' ))) reorder_level, item_value, SUM (  NVL (qty_on_hand, 0)  - NVL (committed_qty, 0)),SUM (  NVL (qty_on_hand, 0) - NVL (committed_qty, 0)) available_qty, stock_uom_desc FROM (SELECT distinct h.batch_id, a.item_code item_code, a.store_code store_code, b.short_desc store_desc, h.qty_on_hand, a.stock_item_yn stock_item_yn, a.bin_location_code, c.short_desc bin_desc, a.reorder_level, a.item_value, h.committed_qty, g.short_desc stock_uom_desc,h.expiry_date_or_receipt_date FROM st_item_store a, mm_store_lang_vw b, mm_bin_location_lang_vw c, st_user_access_for_store d, st_store e, mm_item_lang_vw f, am_uom g, st_item_batch h, st_acc_entity_param i, st_item j WHERE a.store_code = b.store_code AND a.store_code = c.store_code(+) AND a.bin_location_code = c.bin_location_code(+) AND a.item_code = ? AND b.store_code = e.store_code AND e.store_type_flag != 'N' AND c.language_id(+) = ? AND b.language_id = ? AND b.language_id = f.language_id AND a.item_code = f.item_code AND a.def_issue_uom = g.uom_code AND b.facility_id LIKE ? AND e.store_code BETWEEN NVL (UPPER (?), '!') AND NVL (UPPER (?), '~') AND (   (? = 'Z' AND a.qty_on_hand = 0) OR (? = 'S' AND a.qty_on_hand > 0) OR (? = 'B' AND a.qty_on_hand < NVL (a.reorder_level, '0') ) OR ? = 'A' ) AND a.store_code = h.store_code(+) AND a.item_code = h.item_code(+) AND d.user_id LIKE DECODE (i.restrict_view_stk_status, 'ALL', '%', ? ) AND a.store_code = d.store_code AND j.item_code = a.item_code AND (   expiry_yn = 'N'    OR (    expiry_yn = 'Y' AND (   (    /* use_after_expiry_yn = 'Y' AND */ ('Y' = 'Y') ) OR decode(a.qty_on_hand,0,sysdate,expiry_date_or_receipt_date) >= TRUNC (NVL (TO_DATE ('', 'dd/mm/yyyy'), SYSDATE ) ) )))) GROUP BY item_code, store_code, store_desc, stock_item_yn, bin_location_code, bin_desc, reorder_level, item_value, stock_uom_desc ORDER BY store_desc, qty_on_hand, item_value");
		
		//Added by Rabbani #30069(BRU-HIMS-CRF-110) on 23-APR-2013
		//sqlMap.put("sqlData", "SELECT   item_code, store_code, store_desc, SUM (NVL (qty_on_hand, 0)) qty_on_hand, stock_item_yn, bin_location_code, bin_desc, DECODE (TRIM (TO_CHAR (NVL (reorder_level, '0'), '999,999,999,999,999,999,999' ) ), '0', '', TRIM (TO_CHAR (NVL (reorder_level, '0'), '999,999,999,999,999,999,999' ))) reorder_level, item_value, SUM (  NVL (qty_on_hand, 0)  - NVL (committed_qty, 0)),DECODE (?,'Y', SUM (NVL (qty_on_hand, 0) - NVL (committed_qty, 0)), SUM (DECODE (suspended_yn, 'N', qty_on_hand, 0)) - SUM (DECODE (suspended_yn, 'N', committed_qty, 0))) available_qty, stock_uom_desc,facility_id ,facility_name FROM (SELECT distinct h.batch_id, a.item_code item_code, a.store_code store_code, b.short_desc store_desc, h.qty_on_hand, a.stock_item_yn stock_item_yn, a.bin_location_code, c.short_desc bin_desc, a.reorder_level, a.item_value, h.committed_qty, g.short_desc stock_uom_desc,h.expiry_date_or_receipt_date ,h.SUSPENDED_YN,b.facility_id facility_id,(SELECT facility_name FROM sm_facility_param_lang_vw vw  WHERE vw.facility_id = b.facility_id AND language_id = ?) facility_name FROM st_item_store a, mm_store_lang_vw b, mm_bin_location_lang_vw c, st_user_access_for_store d, st_store e, mm_item_lang_vw f, am_uom g, st_item_batch h, st_acc_entity_param i, st_item j WHERE a.store_code = b.store_code AND a.store_code = c.store_code(+) AND a.bin_location_code = c.bin_location_code(+) AND a.item_code = ? AND b.store_code = e.store_code AND e.store_type_flag != 'N' AND c.language_id(+) = ? AND b.language_id = ? AND b.language_id = f.language_id AND a.item_code = f.item_code AND a.def_issue_uom = g.uom_code AND b.facility_id LIKE ? AND e.store_code BETWEEN NVL (UPPER (?), '!') AND NVL (UPPER (?), '~') AND (   (? = 'Z' AND a.qty_on_hand = 0) OR (? = 'S' AND a.qty_on_hand > 0) OR (? = 'B' AND a.qty_on_hand < NVL (a.reorder_level, '0') ) OR ? = 'A' ) AND a.store_code = h.store_code(+) AND a.item_code = h.item_code(+) AND d.user_id LIKE DECODE (i.restrict_view_stk_status, 'ALL', '%', ? ) AND a.store_code = d.store_code AND j.item_code = a.item_code AND (   expiry_yn = 'N'    OR (    expiry_yn = 'Y' AND (   (    /* use_after_expiry_yn = 'Y' AND */ ('Y' = 'Y') ) OR decode(a.qty_on_hand,0,sysdate,expiry_date_or_receipt_date) >= TRUNC (NVL (TO_DATE ('', 'dd/mm/yyyy'), SYSDATE ) ) )))) GROUP BY item_code, store_code, store_desc, stock_item_yn, bin_location_code, bin_desc, reorder_level, item_value, stock_uom_desc ,facility_id ,facility_name ORDER BY store_desc, qty_on_hand, item_value");

		//Added by Sakti against TTM-SCF-0106 to get (base uom unit_cost*qty)item_value_new
		//sqlMap.put("sqlData", "SELECT   item_code, store_code, store_desc, SUM (NVL (qty_on_hand, 0)) qty_on_hand, stock_item_yn, bin_location_code, bin_desc, DECODE (TRIM (TO_CHAR (NVL (reorder_level, '0'), '999,999,999,999,999,999,999' ) ), '0', '', TRIM (TO_CHAR (NVL (reorder_level, '0'), '999,999,999,999,999,999,999' ))) reorder_level, item_value,sum(item_value_new) item_value_new, SUM (  NVL (qty_on_hand, 0)  - NVL (committed_qty, 0)),DECODE (?,'Y', SUM (NVL (qty_on_hand, 0) - NVL (committed_qty, 0)), SUM (DECODE (suspended_yn, 'N', qty_on_hand, 0)) - SUM (DECODE (suspended_yn, 'N', committed_qty, 0))) available_qty, stock_uom_desc,facility_id ,facility_name FROM (SELECT distinct h.batch_id, a.item_code item_code, a.store_code store_code, b.short_desc store_desc, h.qty_on_hand, a.stock_item_yn stock_item_yn, a.bin_location_code, c.short_desc bin_desc, a.reorder_level, a.item_value,(h.qty_on_hand*ST_DISPLAY_UNIT_COST(a.item_code))item_value_new, h.committed_qty, g.short_desc stock_uom_desc,h.expiry_date_or_receipt_date ,h.SUSPENDED_YN,b.facility_id facility_id,(SELECT facility_name FROM sm_facility_param_lang_vw vw  WHERE vw.facility_id = b.facility_id AND language_id = ?) facility_name FROM st_item_store a, mm_store_lang_vw b, mm_bin_location_lang_vw c, st_user_access_for_store d, st_store e, mm_item_lang_vw f, am_uom g, st_item_batch h, st_acc_entity_param i, st_item j WHERE a.store_code = b.store_code AND a.store_code = c.store_code(+) AND a.bin_location_code = c.bin_location_code(+) AND a.item_code = ? AND b.store_code = e.store_code AND e.store_type_flag != 'N' AND c.language_id(+) = ? AND b.language_id = ? AND b.language_id = f.language_id AND a.item_code = f.item_code AND a.def_issue_uom = g.uom_code AND b.facility_id LIKE ? AND e.store_code BETWEEN NVL (UPPER (?), '!') AND NVL (UPPER (?), '~') AND (   (? = 'Z' AND a.qty_on_hand = 0) OR (? = 'S' AND a.qty_on_hand > 0) OR (? = 'B' AND a.qty_on_hand < NVL (a.reorder_level, '0') ) OR ? = 'A' ) AND a.store_code = h.store_code(+) AND a.item_code = h.item_code(+) AND d.user_id LIKE DECODE (i.restrict_view_stk_status, 'ALL', '%', ? ) AND a.store_code = d.store_code AND j.item_code = a.item_code AND (   expiry_yn = 'N'    OR (    expiry_yn = 'Y' AND (   (    /* use_after_expiry_yn = 'Y' AND */ ('Y' = 'Y') ) OR decode(a.qty_on_hand,0,sysdate,expiry_date_or_receipt_date) >= TRUNC (NVL (TO_DATE ('', 'dd/mm/yyyy'), SYSDATE ) ) )))) GROUP BY item_code, store_code, store_desc, stock_item_yn, bin_location_code, bin_desc, reorder_level, item_value, stock_uom_desc ,facility_id ,facility_name ORDER BY store_desc, qty_on_hand, item_value");
		//Modified by suresh.r on 12-11-2014 against Inc 52256
		//sqlMap.put("sqlData", "SELECT   item_code, store_code, store_desc, SUM (NVL (qty_on_hand, 0)) qty_on_hand, stock_item_yn, bin_location_code, bin_desc, DECODE (TRIM (TO_CHAR (NVL (reorder_level, '0'), '999,999,999,999,999,999,999' ) ), '0', '', TRIM (TO_CHAR (NVL (reorder_level, '0'), '999,999,999,999,999,999,999' ))) reorder_level, item_value,sum(item_value_new) item_value_new, SUM (  NVL (qty_on_hand, 0)  - NVL (committed_qty, 0)),DECODE (?,'Y', SUM (NVL (qty_on_hand, 0) - NVL (committed_qty, 0)), SUM (DECODE (suspended_yn, 'N', qty_on_hand, 0)) - SUM (DECODE (suspended_yn, 'N', committed_qty, 0))) available_qty, stock_uom_desc,facility_id ,facility_name FROM (SELECT distinct h.batch_id, a.item_code item_code, a.store_code store_code, b.short_desc store_desc, h.qty_on_hand, a.stock_item_yn stock_item_yn, a.bin_location_code, c.short_desc bin_desc, a.reorder_level, a.item_value,(h.qty_on_hand*ST_DISPLAY_UNIT_COST(a.item_code,sysdate,'CURRENT_STOCK'))item_value_new, h.committed_qty, g.short_desc stock_uom_desc,h.expiry_date_or_receipt_date ,h.SUSPENDED_YN,b.facility_id facility_id,(SELECT facility_name FROM sm_facility_param_lang_vw vw  WHERE vw.facility_id = b.facility_id AND language_id = ?) facility_name FROM st_item_store a, mm_store_lang_vw b, mm_bin_location_lang_vw c, st_user_access_for_store d, st_store e, mm_item_lang_vw f, am_uom g, st_item_batch h, st_acc_entity_param i, st_item j WHERE a.store_code = b.store_code AND a.store_code = c.store_code(+) AND a.bin_location_code = c.bin_location_code(+) AND a.item_code = ? AND b.store_code = e.store_code AND e.store_type_flag != 'N' AND c.language_id(+) = ? AND b.language_id = ? AND b.language_id = f.language_id AND a.item_code = f.item_code AND a.def_issue_uom = g.uom_code AND b.facility_id LIKE ? AND e.store_code BETWEEN NVL (UPPER (?), '!') AND NVL (UPPER (?), '~') AND (   (? = 'Z' AND a.qty_on_hand = 0) OR (? = 'S' AND a.qty_on_hand > 0) OR (? = 'B' AND a.qty_on_hand < NVL (a.reorder_level, '0') ) OR ? = 'A' ) AND a.store_code = h.store_code(+) AND a.item_code = h.item_code(+) AND d.user_id LIKE DECODE (i.restrict_view_stk_status, 'ALL', '%', ? ) AND a.store_code = d.store_code AND j.item_code = a.item_code AND (   expiry_yn = 'N'    OR (    expiry_yn = 'Y' AND (   (    /* use_after_expiry_yn = 'Y' AND */ ('Y' = 'Y') ) OR decode(a.qty_on_hand,0,sysdate,expiry_date_or_receipt_date) >= TRUNC (NVL (TO_DATE ('', 'dd/mm/yyyy'), SYSDATE ) ) )))) GROUP BY item_code, store_code, store_desc, stock_item_yn, bin_location_code, bin_desc, reorder_level, item_value, stock_uom_desc ,facility_id ,facility_name ORDER BY store_desc, qty_on_hand, item_value");
		//Modified by suresh.r on 04-05-2015 against Inc 53228
		sqlMap.put("sqlData", eST.Common.StRepository.getStKeyValue("SQL_ST_STOCK_STATUS_BY_ITEM_QUERY"));

System.err.println("==MOHE-ICN-0015-==="+eST.Common.StRepository.getStKeyValue("SQL_ST_STOCK_STATUS_BY_ITEM_QUERY"));
		
		displayFields.add("STORE_DESC");	
		displayFields.add("QTY_ON_HAND");	
		displayFields.add("ITEM_VALUE");
		displayFields.add("STOCK_ITEM_YN");
		displayFields.add("BIN_DESC");
		displayFields.add("REORDER_LEVEL");
		displayFields.add("STORE_CODE");
		displayFields.add("STOCK_UOM_DESC");
		displayFields.add("AVAILABLE_QTY");
		displayFields.add("FACILITY_NAME"); //Added by Rabbani #INC no : 39203  on 18-04-2013
		displayFields.add("ITEM_VALUE_NEW");
    
	    chkFields.add(includeSuspendedBatches); //Added by Rabbani #30069(BRU-HIMS-CRF-110) on 23-APR-2013
		chkFields.add(locale);                  //Added by Rabbani #INC no : 39203  on 18-04-2013
		chkFields.add(item_code);
		chkFields.add(locale);
		chkFields.add(locale);
		//chkFields.add(bean.getLoginFacilityId());
		chkFields.add(dflt_facility_id); //Added by Rabbani #INC no : 39203  on 18-04-2013
		chkFields.add(store_code_from);
		chkFields.add(store_code_to);
		chkFields.add(stock_level);
		chkFields.add(stock_level);
		chkFields.add(stock_level);
		chkFields.add(stock_level);
		//chkFields.add(bean.getLoginById());
		// MOHE-ICN-0015
System.err.println("==RESTRICT_VIEW_STK_STATUS -  MOHE-ICN-0015"+restrict_view_stk_status);
		if(restrict_view_stk_status!=null && restrict_view_stk_status.equals("ALL")) 
			chkFields.add("");  // pass "" as it wil check for NVL to take user id ....restrict access
		else 
		    chkFields.add(bean.getLoginById());  // restrict access - MOHE-ICN-0015
		
		funcMap.put("displayFields", displayFields);
		funcMap.put("chkFields", chkFields);
		//System.out.println("chkFields=>"+ chkFields);

		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
	 

		if((result.size()>=3) && (!(((String) result.get(0)).equals("0"))))
		{
		
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(result.get(1)));
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
            _bw.write(_wl_block14Bytes, _wl_block14);
if(((String)bean.getAccessCostDetails()).equals("Y")){
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
}
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
		
		ArrayList records			=		new ArrayList();

		for(int recCount=2,k = 0; recCount<result.size(); recCount++,k++) {
		String className			=		(recCount % 2 == 0)?"QRYEVEN":"QRYODD";
		records						=		(ArrayList) result.get(recCount);
		 
		
            _bw.write(_wl_block20Bytes, _wl_block20);

		store_desc					=		CommonBean.checkForNull((String)records.get(0),"&nbsp;");
		//Added by Rabbani #INC no : 39203  on 18-APR-2013
		facility_name				=		CommonBean.checkForNull((String)records.get(9),"");  
		qty_on_hand					=		bean.setNumberFormat(bean.checkForNull((String)records.get(1),"0"),no_of_decimals);
		/**
		 * @Name - Priya
		 * @Date - 07/06/2010
		 * @Inc# - 
		 * @Desc -  To get no of decimals for cost 
		 */
		int noOfDecimalsForCost=Integer.parseInt(CommonBean.checkForNull(bean.getNoOfDecimalsCost(),"3"));
		item_value					=		bean.setNumberFormat((String)CommonBean.checkForNull((String)records.get(2),"0"),noOfDecimalsForCost);
		item_value_new					=		bean.setNumberFormat((String)CommonBean.checkForNull((String)records.get(10),"0"),noOfDecimalsForCost);
		//System.out.println("noOfDecimalsForCost"+ noOfDecimalsForCost);
		//System.out.println("no_of_decimals"+ no_of_decimals);
		
		/*if (item_value.indexOf(".") != -1)
			{
		item_value					=		item_value + "0";

		item_value					=		item_value.substring(0,item_value.indexOf(".")+3);
			}*/
		
		stock_yn					=		CommonBean.checkForNull((String)records.get(3),"&nbsp;");
		bin_desc					=		CommonBean.checkForNull((String)records.get(4),"&nbsp;");
		reorder_level				=		CommonBean.checkForNull((String)records.get(5),"&nbsp;");
		store_code					=		CommonBean.checkForNull((String)records.get(6),"&nbsp;");
		aval_qty					=		bean.setNumberFormat(bean.checkForNull((String)records.get(8),"0"),no_of_decimals); 	
		//System.out.println("aval_qty"+ aval_qty);
		
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(className));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(includeSuspendedBatches));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(facility_name));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(store_desc));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(className));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(qty_on_hand));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(className));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(aval_qty));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(className));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf((String)records.get(7)));
            _bw.write(_wl_block32Bytes, _wl_block32);
if((bean.checkForNull((String)bean.getAccessCostDetails(),"N")).equals("Y")){
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(className));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(item_value));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(className));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(item_value_new));
            _bw.write(_wl_block35Bytes, _wl_block35);
}
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(className));
            _bw.write(_wl_block37Bytes, _wl_block37);

		if(stock_yn.equals("Y")) {
		
            _bw.write(_wl_block38Bytes, _wl_block38);

			}
		else {
		
            _bw.write(_wl_block39Bytes, _wl_block39);

		}
		
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(className));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bin_desc));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(className));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(reorder_level));
            _bw.write(_wl_block43Bytes, _wl_block43);

		}
		
            _bw.write(_wl_block44Bytes, _wl_block44);

		}
		else{
		
            _bw.write(_wl_block45Bytes, _wl_block45);

		}
		out.flush();
		out.println(CommonBean.setForm(request,"../../eST/jsp/StockStatusByItemQueryResult.jsp",searched));
		}
		catch(Exception e) {
			e.printStackTrace();
		//out.print("Exception @ Result JSP :"+e.toString());
		}
	
            _bw.write(_wl_block46Bytes, _wl_block46);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Store.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.QuantityOnHand.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.AvailableQty.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StockUOM.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.CostValue.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.StockItem.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.MasterBinLocation.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.ROLevel.label", java.lang.String .class,"key"));
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
}
