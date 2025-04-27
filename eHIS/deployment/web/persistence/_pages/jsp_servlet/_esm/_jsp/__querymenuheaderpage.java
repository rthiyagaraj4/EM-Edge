package jsp_servlet._esm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __querymenuheaderpage extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/esm/jsp/queryMenuHeaderPage.jsp", 1710830433824L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n      <html><head><link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link></head><html>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

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

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

    request.setCharacterEncoding("UTF-8");
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff;
	Connection con=null ;
	java.sql.Statement stmt=null;
	ResultSet rset=null ;
	ArrayList finAr = new ArrayList();
	ArrayList firstItem = new ArrayList();
	ArrayList secondItem = new ArrayList();
	ArrayList thirdItem = new ArrayList();
	ArrayList fourthItem = new ArrayList();
	ArrayList fifthItem = new ArrayList();
	try {
		
		
		con = ConnectionManager.getConnection(request);
		String Log_user= (String) session.getValue("login_user");
		int Medadmin=0;
		stmt=con.createStatement();
		String sql="select count(*)  from sm_menu_admin where menu_admin_id='"+Log_user+"' 	and to_char(sysdate,'dd/mm/yyyy')>= nvl(to_char(eff_date_from,'dd/mm/yyyy'),sysdate-1) and to_char(sysdate,'dd/mm/yyyy')<=nvl(to_char(eff_date_to,'dd/mm/yyyy'),sysdate+1) ";	
		rset=stmt.executeQuery(sql);
		
		if (rset !=null){
			while (rset.next()){
				Medadmin=Integer.parseInt(rset.getString(1));
			}
		}
		
		
       String menu_id=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.MenuID.label","common_labels");
		
		firstItem.add("Text");  		 //Type of item
		firstItem.add(menu_id);	  // label
		firstItem.add("menu_id");	//name of field
		firstItem.add("30");	// SIZE
		firstItem.add("30");	//LENGTH
		finAr.add(firstItem);//add to ArrayList obj finAr

         String menu_name=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.MenuName.label","sm_labels");
		
		secondItem.add("Text");  		 //Type of item
		secondItem.add(menu_name);	  // label
		secondItem.add("menuname");	//name of field
		secondItem.add("30");	// SIZE
		secondItem.add("60");	//LENGTH

		finAr.add(secondItem);//add to ArrayList obj finAr

		
		thirdItem.add("List");  		 //Type of item
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.ResponsibilityGroup.label","sm_labels"));	  // label
		thirdItem.add("resp_group_id");	//name of field
		
		if (Medadmin >0 )
			thirdItem.add("select resp_group_id,resp_group_name from sm_resp_grp  where eff_status='E' and  RESP_GROUP_ID  in  ( select  RESP_GROUP_ID from sm_menu_Admin where menu_admin_id='"+Log_user+"') order by resp_group_name ");
		else
			thirdItem.add("select resp_group_id,resp_group_name from sm_resp_grp  where eff_status='E' order by resp_group_name  ");


		finAr.add(thirdItem);
		
		
		fourthItem.add("List");  		 //Type of item
		fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RootMenu.label","common_labels"));	  // label
		fourthItem.add("root_menu_yn");	//name of field
		fourthItem.add("B," +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y," +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N," +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");	// SIZE
		fourthItem.add("5");	//LENGTH

		finAr.add(fourthItem);//add to ArrayList obj finAr

		String tool_used=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.ToolUsed.label","sm_labels");
		fifthItem.add("List");  		 //Type of item
		fifthItem.add(tool_used);	  // label
		fifthItem.add("dev_tool");	//name of field
		fifthItem.add("''," +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+",F," +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.Forms.label","sm_labels")+",J,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.Java.label","sm_labels")+"");	// SIZE
		fifthItem.add("5");	//LENGTH

		finAr.add(fifthItem);//add to ArrayList obj finAr
		String orderByCols[] = new String[3];
		String orderByColVals[] = new String[3];
		orderByCols[0] = menu_id;
		orderByCols[1] = menu_name;
		orderByCols[2] = tool_used;

		orderByColVals[0] = "menu_id";
		orderByColVals[1] = "menu_name";
		orderByColVals[2] = "dev_tool";

		strbuff = qrypg.getQueryPage(con,finAr,"Find Facility ","../../eSM/jsp/queryMenuHeader.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");

		out.println(strbuff.toString());
		strbuff.setLength(0);

		finAr.clear();
        firstItem.clear();
		secondItem.clear();
		thirdItem.clear();
		fourthItem.clear();
		fifthItem.clear();
		
		//closing resultsets and statements
		
		if(stmt != null) stmt.close();
		if(rset!=null) rset.close();
		
		
		} catch (Exception e) {}
		
		finally {
			ConnectionManager.returnConnection(con,request);
		}

            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
