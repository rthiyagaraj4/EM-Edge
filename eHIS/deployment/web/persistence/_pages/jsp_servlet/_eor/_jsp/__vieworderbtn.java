package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.net.*;
import java.text.*;
import eOR.ViewOrder;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __vieworderbtn extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ViewOrderBtn.jsp", 1738757112000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n<!-- IN065844 starts -->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<!--IN065844 ends -->\n<html>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\n\t<script language=\"JavaScript\" src=\"../../eOR/js/ViewOrder.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n<script type=\"text/javascript\">\n\tfunction closew(){\n\t\tconst dialogTag = parent.parent.document.getElementById(\"dialog_tag\");\n\t\tdialogTag.close();\n\t}\n</script>\n\n</head>\n<body OnMouseDown=\"CodeArrest()\"; onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<form name=\'view_order_btn\' id=\'view_order_btn\' target=\'messageFrame\' >\n<table cellpadding=0 cellspacing=0 border=0 width=\"98%\" align=center class=\"gridComponentHolder\">\n\t\n\t<tr>\n\t\t<td  width=\'48%\' class=\'label\' width=\"\" style=\"vertical-align:middle\">&nbsp;\n\t\t\t<table cellpadding=0 cellspacing=0 border=0 width=\"100%\" align=center id=\"bill_dtl\" style=\"display:none\">\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\'40%\' class=\"gridData\" width=\"60%\" style=\'border-width: 1;text-align: right;font-size: 3%\'><font class=\'label\' size=\"10\"><B>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =":</B></font></td>\n\t\t\t\t\t<td width=\'18%\' class=\"gridData\" style=\'border-width: 1;text-align: right;\'><font class=\'label\' size=\"2\" size=\"1\"><B><span id=\'actual_\'>0.0</span>&nbsp;</B></font></td>\n\t\t\t\t\t<td width=\'18%\' class=\"gridData\" style=\'border-width: 1;text-align: right;\'><font class=\'label\' size=\"2\" size=\"1\"><B><span id=\'payable_\'>0.0</span>&nbsp;&nbsp;&nbsp;</B></font></td>\n\t\t\t\t\t<td width=\'18%\' class=\"gridData\" style=\'border-width: 1;text-align: right;\' id=\"pat_paid_\" style=\"visibility:hidden\"><font class=\'label\' size=\"2\" size=\"1\"><B><span id=\'pat_payable_\'>0.0</span>&nbsp;&nbsp;</B></font></td>\n\t\t\t\t\t<td width=\'6%\' class=\"gridData\" style=\'border-width: 0;text-align: right;\'>&nbsp;</td>\n\t\t\t\t\t\n\t\t</tr>\n\n\t\t</table>\n\t\n\t</td>\n<!--IN065844 Starts   -->\n\t<td width=\'28%\' class=\'button\'>\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\n\t\t\t<INPUT TYPE=\"button\" id=\"viewAmendOrder\" value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' class=\'button\' onClick=\"viewAmend(\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\',\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\')\"  >\n\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\n\t</td>\n\t\n<!-- IN065844 ends -->\n\t\t<td  width=\'40%\' class=\'button\' align=\"right\">\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t <INPUT TYPE=\"button\" id=\"showhistory\" value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' class=\'button\' onClick=\"showHistory(\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\')\" disabled>\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\t\t\t\t\n\t\t<INPUT TYPE=\"button\" id=\"orderFormatAuditTrail\" value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' class=\'button\' onClick=\"orderFormatAuditTrails(\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\')\">\t\n\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t<INPUT TYPE=\"button\" id=\"close\" value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' class=\'button\' onClick=\"toCloseTopShowModal();\">\n\t\t</td>\n\t</tr>\n\n</table>\n<input type=\"hidden\" name=\"order_cat_code\" id=\"ord_cat_code\" value=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="><!--IN061961 -->\n<input type=\"hidden\" name=\"order_catalog_code\" id=\"order_catalog_code\" value=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="><!--IN061961 -->\n<input type=\"hidden\" name=\"order_line_num\"  id=\"order_line_num\" value=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="><!--IN061961 -->\n<input type=\"hidden\" name=\"view_by\"  id=\"view_by\" value=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="><!--IN061961 -->\n<input type=\"hidden\" name=\"order_category\" id=\"order_category\" value=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="><!--IN061961 -->\n\n</form>\n\n</body>\n</html>\n\n";
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
/*
---------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
---------------------------------------------------------------------------------------------------------------------------------------------------------
	?			?				?			?				?					?
06/08/2014  IN049419		Ramesh G										An Audit Trail for Additional Information Amendment of Order	 
15/01/2018  IN065844       Sharanraj                       Ramesh G         ML-MMOH-CRF-1000
13/03/2018  IN066974		Sharanraj   				   Ramesh G 		OR-ML-MMOH-CRF-1000/03
18/07/2018   IN061961		sivabagyam M    18/07/2018		Ramesh G		GHL-CRF-0433
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	
//IN065844 starts
	String bean_id1 = "Or_ViewOrder" ;
	String bean_name1 = "eOR.ViewOrder";
//IN065844 ends

 	String function_from = request.getParameter( "colval" ) ;
	String accssion_num = request.getParameter("accssion_num")==null?"":request.getParameter("accssion_num");
	//String orderId = request.getParameter( "orderId" ) ; //IN049419
	String orderId = request.getParameter("orderId")==null?"":request.getParameter("orderId");//IN065844
	String lineId = request.getParameter("lineId")==null?"":request.getParameter("lineId" ) ; //IN049419
	String orderFormatAuditTrailYN = request.getParameter("orderFormatAuditTrailYN")==null?"":request.getParameter("orderFormatAuditTrailYN" ) ;//IN049419
	String order_line_num = request.getParameter("order_line_num")==null?"":request.getParameter("order_line_num");//IN061961
	String catalog_code = request.getParameter("catalog_code")==null?"":request.getParameter("catalog_code");//IN061961
	String view_by = (request.getParameter("view_by")==null||request.getParameter("view_by").equals("null"))?"":request.getParameter("view_by");//IN061961
	String category_code = request.getParameter("ord_cat_code")==null?"":request.getParameter("ord_cat_code");//IN061961
	String order_category = request.getParameter("val1")==null?"":request.getParameter("val1");//IN061961
	int i=0;
	Connection conn  = null;
	PreparedStatement pstmt;
	ResultSet rs = null;
	String tempTable = "OR_ORDER_FIELD_VALUES_ACTION";
	if(!"".equals(lineId)){
		tempTable = "OR_ORDER_LINE_FLD_VAL_ACTION";
	}
//IN065844 Starts	
	ViewOrder bean1=(ViewOrder)getBeanObject( bean_id1, bean_name1, request ) ;
	String orgid="N";

	bean1.setLanguageId(localeName);
	orgid=bean1.orgordid(orderId);
	if("N".equals(orgid))
	{
		orgid=bean1.checkAmendOrder(orderId);
	}
//IN065844 ends
	
	String strsql1="SELECT COUNT(*) FROM OR_ORDER_AMEND_REASON A, "+tempTable+" B WHERE A.ORDER_ID=? AND A.ACTION_SEQ_NUM = B.ACTION_SEQ_NUM AND A.ORDER_ID = B.ORDER_ID";
	try
	{
		conn 	= ConnectionManager.getConnection(request);
		pstmt	= conn.prepareStatement(strsql1,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		pstmt.setString(1,orderId);
		rs		= pstmt.executeQuery();		
		
		if(rs.next())
		{
 			i = rs.getInt(1);
		}
		if(pstmt!=null)pstmt.close();
		if(rs!=null)rs.close();
	}catch(Exception e){
		//out.println("Exception : "+e.getMessage());//COMMON-ICN-0181
		e.printStackTrace();	
	}finally{
		if (conn != null) 
			ConnectionManager.returnConnection(conn,request);
	}
	
 
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
 
	if(!orgid.equals("") && !orgid.equals("N") && function_from!=null && function_from.equals("View") ) //IN066974
		{
			
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ViewAmndReason.label","or_labels")));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(orderId));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(orgid));
            _bw.write(_wl_block15Bytes, _wl_block15);
	
		}
	
		
            _bw.write(_wl_block16Bytes, _wl_block16);

		
		//out.println("<script>alert('"+function_from+"');</script>");
		
		if(function_from!=null && function_from.equals("View")) 
		{ 
		
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ViewAuditTrail.label","or_labels")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(accssion_num));
            _bw.write(_wl_block19Bytes, _wl_block19);
 
		}
		//IN049419 Start.
		if("Y".equals(orderFormatAuditTrailYN) && i>0) 
		{
		
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ViewAuditTrail.label","or_labels")));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(orderId ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(lineId ));
            _bw.write(_wl_block22Bytes, _wl_block22);

		}
		//IN049419 End.
		
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(category_code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(catalog_code));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(view_by));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(order_category));
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Charge.label", java.lang.String .class,"key"));
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
}
