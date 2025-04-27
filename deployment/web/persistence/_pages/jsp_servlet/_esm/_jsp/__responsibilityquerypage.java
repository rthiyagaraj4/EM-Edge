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

public final class __responsibilityquerypage extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/esm/jsp/ResponsibilityQueryPage.jsp", 1709117463821L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block7 ="\'></link></head></html>\n";
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
	Connection con=null;
	Statement stmt=null;
try {
	con = ConnectionManager.getConnection(request);
	String Log_user= (String) session.getValue("login_user");
	ResultSet rset=null ;
	int Medadmin=0;
	stmt=con.createStatement();
	String sql="select count(*)  from sm_menu_admin where menu_admin_id='"+Log_user+"' 	and to_char(sysdate,'dd/mm/yyyy')>= nvl(to_char(eff_date_from,'dd/mm/yyyy'),sysdate-1) and to_char(sysdate,'dd/mm/yyyy')<=nvl(to_char(eff_date_to,'dd/mm/yyyy'),sysdate+1) ";	

	rset=stmt.executeQuery(sql);
	if (rset !=null){
		while (rset.next()){
					Medadmin=Integer.parseInt(rset.getString(1));
		}
	}
	if(rset!=null)rset.close();
	if(stmt!=null)stmt.close();
	if (Medadmin >0 )  {}
	
	else			 {}

	ArrayList finAr = new ArrayList();

	ArrayList firstItem = new ArrayList();
	String resp_id=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ResponsibilityID.label","common_labels");
	firstItem.add("Text");  		 //Type of item
	firstItem.add(resp_id);	  // label
	firstItem.add("resp_id");	//name of field
	firstItem.add("20");	// SIZE
	firstItem.add("20");	//LENGTH

	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();
    String resp_name=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ResponsibilityName.label","common_labels");
	secondItem.add("Text");  		 //Type of item
	secondItem.add(resp_name);	  // label
	secondItem.add("resp_name");	//name of field
	secondItem.add("30");	// SIZE
	secondItem.add("60");	//LENGTH
	
	finAr.add(secondItem);//add to ArrayList obj finAr

	ArrayList fifthItem = new ArrayList();
	String menu_id=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.MenuID.label","common_labels");
	fifthItem.add("Text");  		 //Type of item
	fifthItem.add(menu_id);	  // label
	fifthItem.add("menu_id");	//name of field
	fifthItem.add("30");	// SIZE
	fifthItem.add("30");	//LENGTH
	finAr.add(fifthItem);//add to ArrayList obj finAr


	ArrayList sixthItem = new ArrayList();
    String menu_name=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.MenuName.label","sm_labels");
	sixthItem.add("Text");  		 //Type of item
	sixthItem.add(menu_name);	  // label
	sixthItem.add("menu_name");	//name of field
	sixthItem.add("60");	// SIZE
	sixthItem.add("60");	//LENGTH

	finAr.add(sixthItem);//add to ArrayList obj finAr

	ArrayList thirdItem = new ArrayList();

    String resp_grp_id=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.ResponsibilityGroupID.label","sm_labels");
	thirdItem.add("Text");
	thirdItem.add(resp_grp_id);	  // label
	thirdItem.add("resp_group_id");	//name of field
	thirdItem.add("4");	// SIZE
	thirdItem.add("4");	//LENGTH


	finAr.add(thirdItem);

	ArrayList fourthItem = new ArrayList();
    String resp_grp_name=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.ResponsibilityGroupName.label","sm_labels");
	fourthItem.add("Text");  		 //Type of item
	fourthItem.add(resp_grp_name);	  // label
	fourthItem.add("resp_grp_name");	//name of field
	fourthItem.add("30");	// SIZE
	fourthItem.add("30");	//LENGTH

	finAr.add(fourthItem);//add to ArrayList obj finAr


 ArrayList ninenthItem = new ArrayList();
 String desktop_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.user.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.Desktop.label","sm_labels");
	ninenthItem.add("Text");  		 //Type of item
  ninenthItem.add(desktop_code);	  // label
	ninenthItem.add("desktop_code");	//name of field

	ninenthItem.add("30 ");	// SIZE
	ninenthItem.add("30 ");	// LENGTH
	finAr.add(ninenthItem);//add to ArrayList obj finAr



	ArrayList seventhItem = new ArrayList();

	seventhItem.add("List");  		 //Type of item
	seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Role.label","common_labels"));	  // label
	seventhItem.add("role_id");	//name of field
	seventhItem.add("select  ORA_ROLE_ID,  ORA_ROLE_ID ora_role from sm_ora_role where ora_role_id not in ('MEDSTARTUP','MEDADMIN')");	// SIZE
//fifthItem.add("30");	//LENGTH

	finAr.add(seventhItem);//add to ArrayList obj finAr


	ArrayList eigthItem = new ArrayList();
	eigthItem.add("List");   //Type of item
	eigthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
	eigthItem.add("eff_status");//name
	eigthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));//static values that need to be displayed as option.Send it along with the value that is inserted.
	finAr.add(eigthItem); //add to ArrayList obj finAr


	String orderByCols[] = new String[7];
	String orderByColVals[] = new String[7];


	orderByCols[0] = resp_id;
	orderByCols[1] = resp_name;
	orderByCols[2] = menu_id;
	orderByCols[3] = menu_name;
	orderByCols[4] = resp_grp_id;
	orderByCols[5] = resp_grp_name;
	orderByCols[6] = desktop_code;

	orderByColVals[0] = "a.resp_id";
	orderByColVals[1] = "a.resp_name";
	orderByColVals[2] = "b.menu_id";
	orderByColVals[3]="b.menu_name";
	orderByColVals[4]="a.resp_group_id";
	orderByColVals[5]="c.RESP_GROUP_NAME";
	orderByColVals[6]="a.desktop_code";

	strbuff = qrypg.getQueryPage(con,finAr,"Find Responsibility ","../jsp/ResponsibilityQuery.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");
	out.println(strbuff.toString());
	finAr.clear();
	firstItem.clear();
	secondItem.clear();
	thirdItem.clear();
	fourthItem.clear();
	fifthItem.clear();
	sixthItem.clear();
	seventhItem.clear();
	eigthItem.clear();
	ninenthItem.clear();

	if(stmt!=null) stmt.close();
	} catch (Exception e) {}
	finally
	{
		
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
