package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eST.ItemMovementShowItemBean;
import eST.Common.*;
import eCommon.Common.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.text.NumberFormat;
import java.text.DecimalFormat;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;
import eCommon.Common.*;
import java.util.*;

public final class __itemmovementqueryresultdetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/ItemMovementQueryResultDetail.jsp", 1709122073214L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n\t\t<title></title>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' ></link> \n\t\t<script language=\"javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/rowcolor.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eST/js/StCommon.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eST/js/ItemMovement.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n<body>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<table cellpadding=0 cellspacing=0 width=\"780\" align=center>\n\t\t<tr>\n\t\t<td width=\"80%\" class=\"white\">&nbsp;</td>\n\t\t<td width=\"20%\" class=\"white\">&nbsp;";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t</tr>\n\t\t</table>\n\t\t<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"200%\"  id=\'tb1\'>\n\t\t<th>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n\t\t<th>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t<th>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t<tr>\n\t<td colspan=3 class=\'ECMENUHIGHERLEVELCOLOR\'></td>\n\t<td class=\'ECMENUHIGHERLEVELCOLOR\'><font size=1><b>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" :</font></td>\n\t<td class=\'ECMENUHIGHERLEVELCOLOR\' style=\"TEXT-ALIGN:right\" >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&nbsp;</td>\n\t<td colspan=9 class=\'ECMENUHIGHERLEVELCOLOR\'></td>\n\t</tr>\n\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t<tr id=\'tr";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'onClick=\"changeRowColor(tr";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =");\">\n\t\t<td  class=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" ><font size=1>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</font></td>\n\t\t<td  class=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"  ><font size=1>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"   style=\"TEXT-ALIGN:right\"><font size=1>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</font>&nbsp;</td>\n\t\t<td  class=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</font></td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t<tr>\n\t<td colspan=3 class=\'ECMENUHIGHERLEVELCOLOR\'></td>\n\t<td class=\'ECMENUHIGHERLEVELCOLOR\'><font size=1><b>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" :</font></td>\n<!-- \t<td class=\'ECMENUHIGHERLEVELCOLOR\'>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&nbsp;&nbsp;&nbsp;&nbsp;</td>\n -->\t<td class=\'ECMENUHIGHERLEVELCOLOR\' style=\"TEXT-ALIGN:right\">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&nbsp;</td>\n\t<td colspan=9 class=\'ECMENUHIGHERLEVELCOLOR\'></td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t</table>\n\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t<script>\n\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));\n\t\tdocument.location.href=\"../../eCommon/html/blank.html\";\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );
	
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
		String locale		=		(String)session.getAttribute("LOCALE");
		String sStyle		=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

		
		String item_code			=		request.getParameter( "item_code" )==null?"":request.getParameter( "item_code" );
		String store_code			=		request.getParameter( "store_code")==null?"":request.getParameter( "store_code");
		//String stock_level		=		request.getParameter("query_type")==null?"":request.getParameter("query_type");
		String stock_item			=		request.getParameter("stock_item").trim( )==null?"":request.getParameter("stock_item");
		String trn_code				=		request.getParameter("trn_code")==null?"":request.getParameter("trn_code");
		String from					=		request.getParameter("from1")==null?"":request.getParameter("from1");
		String to					=		request.getParameter("to1")==null?"":request.getParameter("to1");

		if(locale.equals("th"))
		{
			if(!from.equals("0"))
			{
				from = Integer.toString((Integer.parseInt(from)-54300)) ;
			}
			if(!to.equals("0"))
			{
				to = Integer.toString((Integer.parseInt(to)-54300)) ;
			}

		}

		String stock_inflow_outflow					=		request.getParameter("stock_inflow_outflow")==null?"":request.getParameter("stock_inflow_outflow");
		boolean searched			=		(request.getParameter("searched") == null) ?false:true;
	
	
		
	try{
		HashMap sqlMap				=		new HashMap();
		HashMap funcMap				=		new HashMap();
		ArrayList displayFields		=		new ArrayList();
		ArrayList chkFields			=		new ArrayList();

		int iIndexNext				=		-1;

		//sqlMap.put("sqlData", eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_MOVEMENT_DETAIL"));
		//sqlMap.put("sqlData", "SELECT   a.item_code,a.store_code,b.short_desc trn_type, a.doc_type_code doc_type, a.doc_no doc_no,TO_CHAR (a.doc_date, 'DD/MM/YYYY') doc_date,a.posted_date orderbycolumn, (  NVL (a.item_qty_normal, 0)+ NVL (a.item_qty_bonus, 0)+ NVL (a.item_qty_sample, 0))  item_qty,TO_CHAR (a.expiry_date, 'DD/MM/YYYY') expiry_date,c.short_desc other_store_desc, a.batch_id batch_id,NVL (d.short_name, a.trade_id) trade_id, e.short_desc bin_location,a.po_no po_no,DECODE (a.sal_trn_type,'I', 'Inpatient','O', 'Outpatient','R', 'Referral','C', 'Consumption') sale_type,a.supp_code supp_type, SUM (item_qty_normal) OVER (PARTITION BY a.item_code, a.store_code ORDER BY a.posted_date,-1* (  NVL (a.item_qty_normal, 0)+ NVL (a.item_qty_bonus, 0)+ NVL (a.item_qty_sample, 0)),a.bin_location_code,a.batch_id, a.trade_id,a.expiry_date)  balance FROM st_item_trn_dtl a,st_trn_type b,mm_store c,am_trade_name d,mm_bin_location e WHERE    SUBSTR (st_get_post_mth_yr (a.doc_date), 3) || SUBSTR (st_get_post_mth_yr (a.doc_date), 1, 2) BETWEEN ? AND ? AND item_code = ? AND a.store_code = ? AND (? IS NULL OR a.trn_type = ?) AND (? = 'B' OR stock_item_yn = ?) AND a.trn_type = b.trn_type AND c.store_code(+) = a.other_store_code AND a.trade_id = d.trade_id(+) AND e.store_code(+) = a.store_code AND e.bin_location_code(+) = a.bin_location_code  AND ((? = 'O' AND (  NVL (a.item_qty_normal, 0) + NVL (a.item_qty_bonus, 0) + NVL (a.item_qty_sample, 0))<0) OR (? = 'I' AND ((  NVL (a.item_qty_normal, 0)+ NVL (a.item_qty_bonus, 0)+ NVL (a.item_qty_sample, 0))>=0) OR (?='B' AND 1=1)))  ORDER BY orderbycolumn");
		//the above query is modified from doc_Date to posted_Date  by Ganga Tuesday, August 14, 2012 for Medicity

		//sqlMap.put("sqlData", "SELECT   a.item_code,a.store_code,b.short_desc trn_type, a.doc_type_code doc_type, a.doc_no doc_no,TO_CHAR (a.added_date, 'DD/MM/YYYY') doc_date,a.added_date orderbycolumn, (  NVL (a.item_qty_normal, 0)+ NVL (a.item_qty_bonus, 0)+ NVL (a.item_qty_sample, 0))  item_qty,TO_CHAR (a.expiry_date, 'DD/MM/YYYY') expiry_date,c.short_desc other_store_desc, a.batch_id batch_id,NVL (d.short_name, a.trade_id) trade_id, e.short_desc bin_location,a.po_no po_no,DECODE (a.sal_trn_type,'I', 'Inpatient','O', 'Outpatient','R', 'Referral','C', 'Consumption') sale_type,a.supp_code supp_type, SUM (item_qty_normal) OVER (PARTITION BY a.item_code, a.store_code ORDER BY a.added_date,-1* (  NVL (a.item_qty_normal, 0)+ NVL (a.item_qty_bonus, 0)+ NVL (a.item_qty_sample, 0)),a.bin_location_code,a.batch_id, a.trade_id,a.expiry_date)  balance FROM st_item_trn_dtl a,st_trn_type b,mm_store c,am_trade_name d,mm_bin_location e WHERE    SUBSTR (st_get_post_mth_yr (a.added_date), 3) || SUBSTR (st_get_post_mth_yr (a.added_date), 1, 2) BETWEEN ? AND ? AND item_code = ? AND a.store_code = ? AND (? IS NULL OR a.trn_type = ?) AND (? = 'B' OR stock_item_yn = ?) AND a.trn_type = b.trn_type AND c.store_code(+) = a.other_store_code AND a.trade_id = d.trade_id(+) AND e.store_code(+) = a.store_code AND e.bin_location_code(+) = a.bin_location_code  AND ((? = 'O' AND (  NVL (a.item_qty_normal, 0) + NVL (a.item_qty_bonus, 0) + NVL (a.item_qty_sample, 0))<0) OR (? = 'I' AND ((  NVL (a.item_qty_normal, 0)+ NVL (a.item_qty_bonus, 0)+ NVL (a.item_qty_sample, 0))>=0) OR (?='B' AND 1=1)))  ORDER BY orderbycolumn");//Commented against ML-MMOH-SCF-0403 by Badmavathi.B 05/08/2016
		//sqlMap.put("sqlData", "SELECT   a.item_code,a.store_code,b.short_desc trn_type, a.doc_type_code doc_type, a.doc_no doc_no,TO_CHAR (a.added_date, 'DD/MM/YYYY') doc_date,a.added_date orderbycolumn, (  NVL (a.item_qty_normal, 0)+ NVL (a.item_qty_bonus, 0)+ NVL (a.item_qty_sample, 0))  item_qty,TO_CHAR (a.expiry_date, 'DD/MM/YYYY') expiry_date,c.short_desc other_store_desc, a.batch_id batch_id,NVL (d.short_name, a.trade_id) trade_id, e.short_desc bin_location,a.po_no po_no,DECODE (a.sal_trn_type,'I', 'Inpatient','O', 'Outpatient','R', 'Referral','C', 'Consumption') sale_type,/*a.supp_code supp_type,*/(select short_name from ap_supplier where supp_code = a.supp_code)supp_type, SUM (item_qty_normal) OVER (PARTITION BY a.item_code, a.store_code ORDER BY a.added_date,-1* (  NVL (a.item_qty_normal, 0)+ NVL (a.item_qty_bonus, 0)+ NVL (a.item_qty_sample, 0)),a.bin_location_code,a.batch_id, a.trade_id,a.expiry_date)  balance FROM st_item_trn_dtl a,st_trn_type b,mm_store c,am_trade_name d,mm_bin_location e WHERE    SUBSTR (st_get_post_mth_yr (a.added_date), 3) || SUBSTR (st_get_post_mth_yr (a.added_date), 1, 2) BETWEEN ? AND ? AND item_code = ? AND a.store_code = ? AND (? IS NULL OR a.trn_type = ?) AND (? = 'B' OR stock_item_yn = ?) AND a.trn_type = b.trn_type AND c.store_code(+) = a.other_store_code AND a.trade_id = d.trade_id(+) AND e.store_code(+) = a.store_code AND e.bin_location_code(+) = a.bin_location_code  AND ((? = 'O' AND (  NVL (a.item_qty_normal, 0) + NVL (a.item_qty_bonus, 0) + NVL (a.item_qty_sample, 0))<0) OR (? = 'I' AND ((  NVL (a.item_qty_normal, 0)+ NVL (a.item_qty_bonus, 0)+ NVL (a.item_qty_sample, 0))>=0) OR (?='B' AND 1=1)))  ORDER BY orderbycolumn"); //Commented by Badmavathi.B 13/10/2016 added a.doc_no for Balance
		sqlMap.put("sqlData", "SELECT   a.item_code,a.store_code,b.short_desc trn_type, a.doc_type_code doc_type, a.doc_no doc_no,TO_CHAR (a.added_date, 'DD/MM/YYYY') doc_date,a.added_date orderbycolumn, (  NVL (a.item_qty_normal, 0)+ NVL (a.item_qty_bonus, 0)+ NVL (a.item_qty_sample, 0))  item_qty,TO_CHAR (a.expiry_date, 'DD/MM/YYYY') expiry_date,c.short_desc other_store_desc, a.batch_id batch_id,NVL (d.short_name, a.trade_id) trade_id, e.short_desc bin_location,a.po_no po_no,DECODE (a.sal_trn_type,'I', 'Inpatient','O', 'Outpatient','R', 'Referral','C', 'Consumption') sale_type,/*a.supp_code supp_type,*/(select short_name from ap_supplier where supp_code = a.supp_code)supp_type, SUM (item_qty_normal) OVER (PARTITION BY a.item_code, a.store_code ORDER BY a.added_date,-1* (  NVL (a.item_qty_normal, 0)+ NVL (a.item_qty_bonus, 0)+ NVL (a.item_qty_sample, 0)),a.bin_location_code,a.batch_id, a.trade_id,a.expiry_date, a.doc_no)  balance FROM st_item_trn_dtl a,st_trn_type b,mm_store c,am_trade_name d,mm_bin_location e WHERE    SUBSTR (st_get_post_mth_yr (a.added_date), 3) || SUBSTR (st_get_post_mth_yr (a.added_date), 1, 2) BETWEEN ? AND ? AND item_code = ? AND a.store_code = ? AND (? IS NULL OR a.trn_type = ?) AND (? = 'B' OR stock_item_yn = ?) AND a.trn_type = b.trn_type AND c.store_code(+) = a.other_store_code AND a.trade_id = d.trade_id(+) AND e.store_code(+) = a.store_code AND e.bin_location_code(+) = a.bin_location_code  AND ((? = 'O' AND (  NVL (a.item_qty_normal, 0) + NVL (a.item_qty_bonus, 0) + NVL (a.item_qty_sample, 0))<0) OR (? = 'I' AND ((  NVL (a.item_qty_normal, 0)+ NVL (a.item_qty_bonus, 0)+ NVL (a.item_qty_sample, 0))>=0) OR (?='B' AND 1=1)))  ORDER BY orderbycolumn"); 
		displayFields.add("TRN_TYPE");	
		displayFields.add("DOC_TYPE");	
		displayFields.add("DOC_NO");
		displayFields.add("DOC_DATE");
		displayFields.add("ITEM_QTY");
		displayFields.add("EXPIRY_DATE");
		displayFields.add("OTHER_STORE_DESC");
		displayFields.add("BATCH_ID");
		displayFields.add("TRADE_ID");
		displayFields.add("BIN_LOCATION");
		displayFields.add("PO_NO");
		displayFields.add("SALE_TYPE");
		displayFields.add("SUPP_TYPE");
		displayFields.add("BALANCE");
		if(from.equals("0") && to.equals("0"))
		{
				from = "190001";
				to = "999912";
		}
		if(from.equals("0"))
		{
				from = "190001";
		}
		if(to.equals("0"))
		{
				to = "999912";
		}
		chkFields.add(from);
		chkFields.add(to);
		chkFields.add(item_code);
		chkFields.add(store_code);
		chkFields.add(trn_code);
		chkFields.add(trn_code);
		chkFields.add(stock_item);
		chkFields.add(stock_item);
		chkFields.add(stock_inflow_outflow);
		chkFields.add(stock_inflow_outflow);
		chkFields.add(stock_inflow_outflow);
		funcMap.put("displayFields", displayFields);
		funcMap.put("chkFields", chkFields);
		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
		if((result.size()>=3) && (!(((String) result.get(0)).equals("0"))))
		{
		
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(result.get(1)));
            _bw.write(_wl_block10Bytes, _wl_block10);
iIndexNext=((String)result.get(1)).indexOf("Next");
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
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

//	java.util.HashMap defaultParameter = null;
	String bean_id						=		"ItemMovementShowItemBean";
	String bean_name					=		"eST.ItemMovementShowItemBean";

	ItemMovementShowItemBean bean		=		(ItemMovementShowItemBean)getBeanObject(bean_id,bean_name,request);
	bean.setLanguageId(locale);
	bean.clear();
	bean.setQuery_type(request.getParameter("query_type")==null?"":request.getParameter("query_type"));
	bean.setStore_code(request.getParameter("store_code")==null?"":request.getParameter("store_code"));
	bean.setStock_item(request.getParameter("stock_item")==null?"":request.getParameter("stock_item"));
	bean.setItem_code(request.getParameter("item_code")==null?"":request.getParameter("item_code"));
	bean.setTrn_code(request.getParameter("trn_code")==null?"":request.getParameter("trn_code"));
	//bean.setFrom(request.getParameter("from1")==null?"":request.getParameter("from1"));
	
	bean.setFrom(from);
	//bean.setTo(request.getParameter("to1")==null?"":request.getParameter("to1"));
	bean.setTo(to);
	/**
			* @Name - krishna
			* @Date - 24/12/2009
			* @Inc# - CRF537.1
			* @Desc - No of decimal positions when u r find fmt
	 */
	int no_of_decimals=Integer.parseInt(bean.checkForNull((String)bean.fetchRecord("SELECT NO_OF_DECIMALS FROM ST_ACC_ENTITY_PARAM WHERE ACC_ENTITY_ID='ZZ'").get("NO_OF_DECIMALS"),"0"));
	//String fmt = "0";
		char [] c={'0','0','0','0'};
       StringBuffer strFormat = new StringBuffer();
	  /**
		* @Name - Priya
		* @Date - 02/02/2010
		* @Inc# - 15496 (SRR20056-CRF-0537.2)
		* @Desc - Modified by priya as if the value of 'Item Quantity' , 'Balance', 'Opening Balance' and Closing Balance' is equal to zero and no_of_decimals is 4 then it should be displayed as 0 only & not as '0.000' & so removed 'strFormat_zero' codings and made it to zero
		*/
	  String strFormat_zero = "0";
	
	if(no_of_decimals==0){
	strFormat.append("###,###");
	//strFormat_zero.append("0");
	}else 
		   {
         strFormat.append( "###,###.");
		 //strFormat_zero.append("0.");
           /* for(int i =0;i<no_of_decm;i++)
                       {
                        strFormat.append("0");
                           }*/
	   
	   strFormat.append(c,0,no_of_decimals);
	   //strFormat_zero.append(c,0,no_of_decimals);
	   }

	DecimalFormat dfTest = new DecimalFormat(strFormat.toString());
	/* Commented By rams
       Incident No : 18094
	   This Existing Commented Codes Adds Extra Decimals to the Existing Value 
	   Date 1/11/2010
	*/
	
	
	/*for(int i=0;i<no_of_decimals;i++){
		if(i==0)
		fmt+=".";
		fmt+="0";
		}*/

	
	
	String str_trn_code				=		bean.checkForNull(bean.getTrn_code(),"no_trn");
	String str_from					=		bean.getFrom();
	String str_to					=		bean.getTo();



	if(!str_from.equals(""))
	{
	bean.load_month_opening_qty();
	}
	if(!str_to.equals(""))
	{
	bean.load_month_closing_qty();
	}
		if(str_trn_code.equals("no_trn"))
			{
			String opening_bal=bean.checkForNull(bean.getMonth_opening_qty());
			if(opening_bal.equals(".00")){
			opening_bal="0.00";

			}
		
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf((Double.parseDouble(bean.checkForNull(bean.getMonth_opening_qty(),"0.0").replaceAll(",",""))==0.0)? strFormat_zero.toString():dfTest.format(Double.parseDouble(bean.checkForNull(bean.getMonth_opening_qty(),"0").replaceAll(",","")))));
            _bw.write(_wl_block17Bytes, _wl_block17);

			}
		ArrayList records			=		new ArrayList();
		String stTEMP_BALANCE		=		"0";
		for(int recCount=2,k = 0; recCount<result.size(); recCount++,k++) {
		String className			=		(recCount % 2 == 0)?"QRYEVEN":"QRYODD";

		records						=		(ArrayList) result.get(recCount);
		String TRN_TYPE				=		CommonBean.checkForNull((String)records.get(0),"&nbsp;");
		String DOC_TYPE				=		CommonBean.checkForNull((String)records.get(1),"&nbsp;");
		String DOC_NO				=		CommonBean.checkForNull((String)records.get(2),"&nbsp;");
		String DOC_DATE				=		CommonBean.checkForNull((String)records.get(3),"&nbsp;");
		String ITEM_QTY				=		CommonBean.checkForNull((String)records.get(4),"&nbsp;");
		String EXPIRY_DATE			=		CommonBean.checkForNull((String)records.get(5),"&nbsp;");
		String OTHER_STORE_DESC		=		CommonBean.checkForNull((String)records.get(6),"&nbsp;");
		String BATCH_ID				=		CommonBean.checkForNull((String)records.get(7),"&nbsp;");
		String TRADE_ID				=		CommonBean.checkForNull((String)records.get(8),"&nbsp;");
		String BIN_LOCATION			=		CommonBean.checkForNull((String)records.get(9),"&nbsp;");
		String PO_NO				=		CommonBean.checkForNull((String)records.get(10),"&nbsp;");
		String SALE_TYPE			=		CommonBean.checkForNull((String)records.get(11),"&nbsp;");
		String SUPP_TYPE			=		CommonBean.checkForNull((String)records.get(12),"&nbsp;");
		String BALANCE				=		CommonBean.checkForNull((String)records.get(13),"&nbsp;");
        String stTempOpeningBal		=		CommonBean.checkForNull(bean.getMonth_opening_qty()) ; 
        stTempOpeningBal			=		stTempOpeningBal.equals("")?"0":stTempOpeningBal ;
       stTEMP_BALANCE 		=		String.valueOf(Double.parseDouble(bean.checkForNull(BALANCE,"0").replaceAll(",","")) + Double.parseDouble(stTempOpeningBal.replaceAll(",",""))) ;
	  // Added By Rams 1/19/2010 For the Decimal CRF 537.1 Begins
			/* @Name - Rams
		 * @Date - 1/19/2010
		 * @Inc# - 18094
		 * @Desc - For the Decimal related display if the Value is Less than Zero
		 */
		/*
	   String temp = dfTest.format(Double.parseDouble(bean.checkForNull(ITEM_QTY,"0").replaceAll(",","")));
						if(Double.parseDouble((temp.replaceAll(",","")))<1 && Double.parseDouble((temp.replaceAll(",","")))>0 )
			{
						temp = "0"+temp;
			}
			if(Double.parseDouble((temp.replaceAll(",","")))<0)
			{
			      
              if(temp.substring(0,temp.indexOf(".")).equals("-"))
				  temp ="-"+"0"+temp.substring(temp.indexOf("."),temp.length());
							
			} */
		/* @Name - Priya
		 * @Date - 22/03/2010
		 * @Inc# - 20186
		 * @Desc - As the above commented coding causes String Index out of bounds exception in some scenarios, It is done with common function as below.
		 */
			String temp = bean.setNumberFormat((bean.checkForNull(ITEM_QTY,"0").replaceAll(",","")),no_of_decimals);
	        DOC_DATE = com.ehis.util.DateUtils.convertDate(DOC_DATE,"DMY","en",locale);
	        EXPIRY_DATE = com.ehis.util.DateUtils.convertDate(EXPIRY_DATE,"DMY","en",locale);


            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(k));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(k));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(className));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(TRN_TYPE));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(className));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(DOC_TYPE));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(className));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(DOC_NO));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(className));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(DOC_DATE));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(className));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf((Double.parseDouble(bean.checkForNull(ITEM_QTY,"0").replaceAll(",",""))==0.0)? strFormat_zero.toString():temp));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(className));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf((Double.parseDouble(bean.checkForNull(stTEMP_BALANCE,"0").replaceAll(",",""))==0.0)? strFormat_zero.toString():dfTest.format(Double.parseDouble(bean.checkForNull(stTEMP_BALANCE,"0").replaceAll(",","")))));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(className));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(EXPIRY_DATE));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(className));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(BATCH_ID));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(className));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(PO_NO));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(className));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(SUPP_TYPE));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(className));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(OTHER_STORE_DESC));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(className));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(TRADE_ID));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(className));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(BIN_LOCATION));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(className));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(SALE_TYPE));
            _bw.write(_wl_block26Bytes, _wl_block26);

		}
		if(str_trn_code.equals("no_trn"))
			{
		if (iIndexNext==-1) {

			

		
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bean.checkForZero(bean.getMonth_closing_qty())));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf((Double.parseDouble(bean.checkForNull(stTEMP_BALANCE,"0").replaceAll(",",""))==0.0)? strFormat_zero.toString():dfTest.format(Double.parseDouble(bean.checkForNull(stTEMP_BALANCE,"0").replaceAll(",","")))));
            _bw.write(_wl_block30Bytes, _wl_block30);

		}
			}
		
            _bw.write(_wl_block31Bytes, _wl_block31);

		putObjectInBean(bean_id,bean,request);

		}
		else{
		
            _bw.write(_wl_block32Bytes, _wl_block32);

		}
		out.flush();
		out.println(CommonBean.setForm(request,"../../eST/jsp/ItemMovementQueryResultDetail.jsp",searched));
		
	
		}catch(Exception e) {
			e.printStackTrace();
		out.print("Exception @ Result JSP :"+e.toString());
		}
	
            _bw.write(_wl_block33Bytes, _wl_block33);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.transactiontype.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DocTypeCode.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DocumentDate.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.ItemQuantity.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Balance.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.expiryDate.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BatchID.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.PONo.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Supplier.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.OtherStore.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TradeName.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BinLocation.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.SalesType.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OpeningBalance.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag15(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag15 = null ;
        int __result__tag15 = 0 ;

        if (__tag15 == null ){
            __tag15 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag15);
        }
        __tag15.setPageContext(pageContext);
        __tag15.setParent(null);
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.ClosingBalance.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag15;
        __result__tag15 = __tag15.doStartTag();

        if (__result__tag15!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag15== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag15.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag15);
            return true;
        }
        _activeTag=__tag15.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag15);
        __tag15.release();
        return false;
    }
}
