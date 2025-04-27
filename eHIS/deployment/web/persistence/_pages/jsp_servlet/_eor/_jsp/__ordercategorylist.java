package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eOR.*;
import eOR.Common.*;
import eCommon.Common.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __ordercategorylist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/OrderCategoryList.jsp", 1737622530000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 =" <!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<!--\n--------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        Description\n--------------------------------------------------------------------------------------------------------------\n?             100            ?           created\n20/07/2012    IN033471      NijithaS    System does not filter the Order Categories in One Day and Continue Order.      \n28/02/2022    IN27707      Suji Keerthi G    SKR-CRF-0052     \n28/06/2022\t  32825\t\t\tRamesh G \t\t\tSKR-SCF-1681 \t\t  \n-----------------------------------------------------------------------\n--> \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n \n\n<html>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t\n \t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/dchk.js\"></script><!-- used for date validation-->\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n \t<script language=\"JavaScript\" src=\"../../eOR/js/ExistingSingleOrder.js\"></script>\n \t<script language=\"JavaScript\" src=\"../../eOR/js/OrCommonFunction.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\nfunction colorchange(obj,category_size)\n{\n\n\tdocument.getElementById(\'ALL\').style.backgroundColor  = \"#5D8691\";\n\tdocument.getElementById(\'cust_cat\').style.backgroundColor  = \"#5D8691\";\n\tfor(var i=1;i<=category_size.value;i++)\n\t{\n\t\tvar temp_cat = \"cat\"+i;\n\t\tdocument.getElementById(temp_cat).style.backgroundColor  = \"#5D8691\";\n\t}\n\tobj.style.backgroundColor  = \"#B8CFD5\";\n}\nfunction populateCategoryValues(orderCat,catType)\n{\n\tparams = \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t//params=params+\"&order_category=\"+orderCat+\"&called_from=CategoryList&category_type=\"+catType;\n\tparams=params+\"&ordercate_for_filter=\"+orderCat+\"&called_from=CategoryList&category_type=\"+catType;//IN033471\n\t\n\tparent.ExistingOrderResult.location.href = \"../../eOR/jsp/ExistingSingleOrderResults.jsp?\"+params;\n}\nasync function callCusCategory()\n{\n\tvar retVal \t\t\t= \tnew String();\n\tvar dialogHeight \t= \"43vh\" ;\n\tvar dialogWidth  \t= \"34vw\" ;\n\tvar dialogTop    \t= \"100\";\n\tvar dialogLeft    \t= \"90\";\n\tvar status \t\t\t= \"no\";\n\tvar features\t\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; dialogTop:\"+dialogTop+\"; scroll=auto; status:no\";\n\tretVal = await top.window.showModalDialog(\"../../eOR/jsp/CustomCategory.jsp?module_id=OR&function_id=ORMS_CUSTOM_CATEGORY&function_name=Custom%20Category&function_type=F&access=NYNNN\",arguments,features);\n\t//window.location.reload();\n\t//window.OrderCategoryList.document.location = \"../../eOR/jsp/OrderCategoryList.jsp?mode=CUST_CAT\"\n}\n</script>\n</head>\n<Body>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<form name=\'OrderCategoryList\' id=\'OrderCategoryList\'>\n<table style=\'width:100%\'>\n<tr>\n<td colspan=\'2\' id = \'ALL\' name=\'ALL\' ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="bgcolor=\"#B8CFD5\" ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" bgcolor=\"#5D8691\" ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" style=\'height:20; color:#FFFFFF\' onclick=\'populateCategoryValues(\"\",\"I\");colorchange(this,category_size)\' onMouseOver=\"this.style.fontWeight = \'bold\';this.style.cursor=\'pointer\';\" onMouseOut=\"this.style.fontWeight = \'normal\';this.style.cursor=\'none\';\" selected>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td><!--IN27707-->\n</tr>\n<tr>\n<td id = \'cust_cat\' name=\'cust_cat\' bgcolor=\"#5D8691\" style=\'height:20; color:#FFFFFF;width=200\' onclick=\'populateCategoryValues(\"\",\"C\"); colorchange(this,category_size)\' onMouseOver=\"this.style.fontWeight = \'bold\';this.style.cursor=\'pointer\';\" onMouseOut=\"this.style.fontWeight = \'normal\';this.style.cursor=\'none\';\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" <a href=\"#\" name=\'RightStripQL\'></td><td bgcolor=\"#5D8691\" style=\'height:20; color:#FFFFFF;\'>&nbsp;&nbsp;<img src=\"../../eCA/images/customize.gif\" alt=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' name=\"RightStrip1\"  border=\"0\" id=\"RightStrip1\" onclick=\'callCusCategory();\'/></a></td>\n</tr>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\n\t\t\t    <tr><td colspan =\'2\' id =\'cat";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' name=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" bgcolor=\"#B8CFD5\" ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="style=\'height:22; color:#FFFFFF;width=200\' onclick=\'populateCategoryValues(\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\",\"I\");colorchange(this,category_size)\' onMouseOver=\"this.style.fontWeight = \'bold\';this.style.cursor=\'pointer\';\" onMouseOut=\"this.style.fontWeight = \'normal\';this.style.cursor=\'none\';\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td></tr><!--IN27707-->\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t<input name =\'category_size\' id =\'category_size\' type=\'hidden\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\n</table>\n<input type=\'hidden\' name=\'queryString\' id=\'queryString\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n<input type=\'hidden\' name=\'order_category\' id=\'order_category\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n\t\t<input type=\'hidden\' name=\'call_from\' id=\'call_from\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'> <!-- 32825 -->\n\n</form>\n</Body>\n</html>\n\n";
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
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
            eOR.ExistingOrder bean= null;{
                bean=(eOR.ExistingOrder)pageContext.getAttribute("bean");
                if(bean==null){
                    bean=new eOR.ExistingOrder();
                    pageContext.setAttribute("bean",bean);

                }
            }
            _bw.write(_wl_block6Bytes, _wl_block6);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block9Bytes, _wl_block9);

request.setCharacterEncoding("UTF-8"); //IN27707
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String login_user	= (String)session.getValue("login_user");
    //IN27707 Starts
	String bean_id 		= "@existingorderbean";
 	String bean_name = "eOR.ExistingOrder";
	String facility_id = (String)session.getValue("facility_id");
	String practitioner_type  	= (String) session.getValue("practitioner_type");
	ExistingOrder beanObj = (ExistingOrder)getBeanObject( bean_id, bean_name, request ) ;
	String practBasedOrderCat =beanObj.getPractBasedOrderCategory(facility_id,practitioner_type);
		String call_from = request.getParameter("call_from") == null ? "" : request.getParameter("call_from");
	if(call_from.equals("undefined")) call_from = "";
	//IN27707 Ends
	String slClassValue = "";
	slClassValue="gridData";
	Connection connection 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 			= null;
	
	ArrayList OrderCat = new ArrayList() ;
	String[] record = new String[2];
	
	int i=0;
	int size =0; 
	String mode = "";
	mode = request.getParameter("mode");	
	if(mode==null) mode= "";
	String sql = "";

	//IN27707 Starts
	boolean isDfltOrderSts = false;
	try {	
		connection				= ConnectionManager.getConnection(request);
		isDfltOrderSts = eCommon.Common.CommonBean.isSiteSpecific(connection, "OR","DEFAULT_ORDER_STATUS");
				
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	finally{ 	
		if(connection != null)
			ConnectionManager.returnConnection(connection,request);	
	}
	//IN27707 Ends
	

            _bw.write(_wl_block10Bytes, _wl_block10);
if((!isDfltOrderSts) || (practBasedOrderCat.equals("ALL")) || (call_from.equals("SEARCH"))) {
            _bw.write(_wl_block11Bytes, _wl_block11);
}else{
            _bw.write(_wl_block12Bytes, _wl_block12);
}
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

	
	try 
	{
		connection = ConnectionManager.getConnection() ;
		//IN27707 Starts
		if(isDfltOrderSts){
			pstmt = connection.prepareStatement("select order_category,short_desc from or_order_category order by order_category") ;
			resultSet = pstmt.executeQuery() ;
		}else{
			pstmt = connection.prepareStatement("SELECT  short_desc,order_category FROM or_order_category_lang_vw  WHERE language_id=? AND order_category NOT IN('CS','CN') ORDER BY short_desc") ;
			pstmt.setString( 1, locale);
		resultSet = pstmt.executeQuery() ;
		}
		//IN27707 Ends
		while ( resultSet != null && resultSet.next() ) 
		{
			i++;
			record[0] = resultSet.getString( "order_category" )  ;
			record[1] = resultSet.getString( "short_desc" )  ;
			
			size = resultSet.getRow();
			
				
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(record[0]));
            _bw.write(_wl_block19Bytes, _wl_block19);
if((isDfltOrderSts) && (record[0].equals(practBasedOrderCat)) && (!call_from.equals("SEARCH"))) {
            _bw.write(_wl_block20Bytes, _wl_block20);
}else{
            _bw.write(_wl_block12Bytes, _wl_block12);
}
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(record[0]));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block23Bytes, _wl_block23);

			 
		}
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(size));
            _bw.write(_wl_block25Bytes, _wl_block25);

		
	} 
	catch ( Exception e )	
	{
		e.printStackTrace() ;
		throw e ; 
	} 
	finally 
	{
		if(resultSet!=null)	resultSet.close();
		if(pstmt!=null)	pstmt.close();
		if(connection!=null)	connection.close();
	}			

            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(record[0]));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(call_from));
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.all.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.CustCat.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.CustCat.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
