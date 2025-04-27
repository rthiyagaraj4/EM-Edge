package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.ArrayList;
import eST.*;
import eST.Common.*;
import eCommon.Common.*;
import java.text.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __itemforstorequerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/ItemForStoreQueryCriteria.jsp", 1719470667932L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\' ></link> \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);

		request.setCharacterEncoding("UTF-8");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

		ArrayList components					=		new ArrayList();
		ArrayList firstItem						=		new ArrayList();
		ArrayList firstItem_1					=		new ArrayList();
		ArrayList secondItem					=		new ArrayList();
		ArrayList secondItem_2					=		new ArrayList();
		ArrayList thirdItem						=		new ArrayList();
		ArrayList fourthItem					=		new ArrayList();
		ArrayList fifthItem						=		new ArrayList();
		ArrayList sixthItem						=		new ArrayList();
		ArrayList items							=		new ArrayList();
	try {
		ecis.utils.CommonQueryPage queryPage	=		new ecis.utils.CommonQueryPage();
		StringBuffer htmlTag					=		new StringBuffer();
		String function_id						=		request.getParameter( "function_id" );

		String Store_Code						=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.StoreCode.label","common_labels");
		firstItem.add("Text");
		firstItem.add(Store_Code);
		firstItem.add("store_code");
		firstItem.add("6");
		firstItem.add("6");
		components.add(firstItem);

		String Store_Desc						=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.StoreDescription.label","common_labels");
		firstItem_1.add("Text");
		firstItem_1.add(Store_Desc);
		firstItem_1.add("store_desc");
		firstItem_1.add("40");
		firstItem_1.add("40");
		components.add(firstItem_1);

		String Item_Code						=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ItemCode.label","common_labels");
		secondItem.add("Text");
		secondItem.add(Item_Code);
		secondItem.add("item_code");
		secondItem.add("20");
		secondItem.add("20");
		components.add(secondItem);

		String Item_Desc						=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ItemDescription.label","common_labels");
		secondItem_2.add("Text");
		secondItem_2.add(Item_Desc);
		secondItem_2.add("item_desc");
		secondItem_2.add("60");
		secondItem_2.add("60");
		components.add(secondItem_2);

		String StoreType						=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.StoreType.label","common_labels");
		String all_legend						=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");
		String main_legend						=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.main.label","common_labels");
		String NonStock_legend					=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.NonStock.label","st_labels");
		String SubStore_legend					=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.SubStore.label","st_labels");
		String pharmacy_legend					=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.pharmacy.label","common_labels");

		String Store_type_list					=		"%,"+all_legend+",M,"+main_legend+",S,"+SubStore_legend+",P,"+pharmacy_legend+",N,"+NonStock_legend;
		thirdItem.add("List");
		thirdItem.add(StoreType);
		thirdItem.add("store_type_code");
		thirdItem.add(Store_type_list);
		thirdItem.add("1");
		thirdItem.add("1");	
		components.add(thirdItem);

		String Stock_Item						=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.StockItem.label","st_labels");
		String Yes_legend						=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels");
		String No_legend						=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels");
		String Stock_Item_Option				=		"%,"+all_legend+",Y,"+Yes_legend+",N,"+No_legend;

		fourthItem.add("List");
		fourthItem.add(Stock_Item);
		fourthItem.add("stock_item_yn");
		fourthItem.add(Stock_Item_Option);
		fourthItem.add("1");
		fourthItem.add("1");	
		components.add(fourthItem);

		String Item_Class						=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ItemClass.label","common_labels");
		fifthItem.add("List");
		fifthItem.add(Item_Class);
		fifthItem.add("item_class_code");
		fifthItem.add(eST.Common.StRepository.getStKeyValue("SQL_MM_ITEM_CLASS_ST_SELECT_LIST"));
		components.add(fifthItem);
	
		
		String Nature							=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
		String Both_legend						=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
		String Enabled_legend					=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
		String Disabled_legend					=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
		String Nature_List						=		"%,"+Both_legend+",E,"+Enabled_legend+",D,"+Disabled_legend;

		sixthItem.add("List");
		sixthItem.add(Nature);
		sixthItem.add("eff_status");
		sixthItem.add(Nature_List);
		sixthItem.add("1");
		sixthItem.add("1");	
		components.add(sixthItem); 

		items.add("Hidden");
		items.add("function_id");
		items.add(function_id);
		components.add(items);

		String[] headers						=		new String[4];
		headers[0] = Store_Code;
		headers[1] = Store_Desc;
		headers[2] = Item_Code;
		headers[3] = Item_Desc;

		String[] values							=		new String[4];
		values[0]="store_code";
		values[1]="store_desc";
		values[2]="item_code";
		values[3]="item_desc";

		String Sort_order						=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
		String defaultSelect					=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
		String orderBy							=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
		String ItemforStore						=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMM.ItemforStore.label","mm_labels");
		String QueryCriteria					=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
		String ExecuteQuery						=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

		htmlTag									=		queryPage.getQueryPage((java.util.Properties)session.getAttribute("jdbc"),components,ItemforStore ,"ItemForStoreQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect ,orderBy,headers, values,ExecuteQuery,true);
		out.println(htmlTag);
	}
	catch (java.lang.Exception exception) 	{
		out.println(exception.toString());
	}finally{
		components.clear();	
		firstItem.clear();		
		firstItem_1.clear();	
		secondItem.clear();	
		secondItem_2.clear();
		thirdItem.clear();
		fourthItem.clear();
		fifthItem.clear();
		sixthItem.clear();
		items.clear();
	}

            _bw.write(_wl_block0Bytes, _wl_block0);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
