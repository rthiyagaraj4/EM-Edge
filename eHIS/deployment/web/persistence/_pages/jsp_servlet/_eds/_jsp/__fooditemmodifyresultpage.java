package jsp_servlet._eds._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __fooditemmodifyresultpage extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eds/jsp/FoodItemModifyResultPage.jsp", 1709116730000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- Newly Created for KDAH-CRF-0359.1-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<head>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n\t<Script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\n\t<script src=\"../../eCommon/js/CommonCalendar.js\" language=\"javascript\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eDS/js/json.js\"></script>\n\t<script language=\'javascript\' src=\'../../eDS/js/FooditemModify.js\'></script>\t\n\n<body OnMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<form name=\'QueryResult\' id=\'QueryResult\'>\n\n<table align=\'right\'>\n<tr><td>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<A HREF=\"../../eDS/jsp/FoodItemModifyResultPage.jsp?from=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&to=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&whereclause=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&ExistingFoodItem=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&NewFoodItem=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&DietType=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&MealType=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"  onclick=\"\" text-decoration=\'none\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</A> \n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</A>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n</td></tr>\n</table>\n<br><br>\n<!--<table border=\"1\" cellpadding=\"1\" cellspacing=\"0\" width=\"100%\" align=\"center\" id=\"result\" >-->\n<table border=\"1\" cellpadding=\"1\" cellspacing=\"0\" width=\"50%\" align=\"left\" id=\"result\" >\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t<tr>\n\t\t<th>\n\t\t\t<input type=\"checkbox\" id=\"chkAll\" name=\"chkAll1\" id=\"chkAll1\" onClick=\"MenuSelectAll1(this,";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =",";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =")\" />\n\t\t</th>\n\t\t<th>\n\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t</th>\n\t\t<th>\n\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\t\t\t\t\t\t\n\t\t</th>\t\t\t\t\n\t</tr>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\n\t\t<tr>\n\t\t\t<!--ICN-64263-->\n\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' width=\'12%\' nowrap><input type=\"checkbox\" name=\"check_";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" id=\"check_";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" id=\"chk_";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" onClick=\"addRemoveMenu1(this,\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\',\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\')\"/></td>\n\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\t\t\t\t\t\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' width=\'12%\' nowrap><input type=\"hidden\" id=\"menu_code_";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"/> ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td>\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' width=\'12%\' nowrap><input type=\"hidden\" id=\"menu_desc_";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</td>\t\t</tr>\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n</table>\n\n\n<table border=\"1\" cellpadding=\"1\" cellspacing=\"0\" width=\"50%\" align=\"float:left\" id=\"result\" >\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t<tr>\n\t\t<th>\n\t\t\t<input type=\"checkbox\" name=\"chkAll2\" id=\"chkAll2\" onClick=\"MenuSelectAll2(this,";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\t\t\t\t\t\t\n\t\t</th>\t\t\n\t</tr>\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" onClick=\"addRemoveMenu2(this,\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</td>\t</tr>\n\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\t\t\n\t\t\t\t\n\t\t\t\n</table>\n<input type=\"hidden\" id=\"start\" value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n<input type=\"hidden\" id=\"end\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n<input type=\"hidden\" id=\"maxRecord\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\"><!--ICN-64263-->\n\n </form>\n <script>\n\t\tvar selMenus = parent.parent.FoodItemModifyCriteria.document.getElementById(\'selectedMenus\').value;\n\t\tvar removedMenus = parent.parent.FoodItemModifyCriteria.document.getElementById(\'removedMenus\').value;\n\t\tvar start=document.getElementById(\"start\").value;\n\t\tvar end=document.getElementById(\"end\").value;\n\t\tvar maxRecord=document.getElementById(\"maxRecord\").value;\n\t\tvar mod=maxRecord%28;\n\t\tvar diff=(28-mod)\n\t\tif((mod != 0))\n\t\t\tend=parseInt(maxRecord)+parseInt(diff);\n\t\tif(selMenus != undefined ||  selMenus != \'\')\n\t\t{\n\t\t\tvar selMenus_Arr=selMenus.split(\',\');\n\t\tfor(var i=0;i<selMenus_Arr.length;i++) \n\t\t{\n\t\t\tfor(var m=start;m<=end;m++)\n\t\t\t{\n\t\t\t\tif(document.getElementById(\"menu_code_\"+m))\n\t\t\t\t{\n\t\t\t\tvar menuCode=document.getElementById(\"menu_code_\"+m).value;\n\n\t\t\t\tif(menuCode == selMenus_Arr[i])\n\t\t\t\t{\n\t\t\t\t\tif(document.getElementById(\"chk_\"+m))\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.getElementById(\"chk_\"+m).checked=true;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\t}\n\t\tif(removedMenus != undefined ||  removedMenus != \'\')\n\t\t{\n\t\t\tvar removedMenus_Arr=removedMenus.split(\',\');\t\n\t\tfor(var h=0;i<removedMenus_Arr.length;h++)\n\t\t{\t\n\t\t\tfor(var n=start;n<=end;n++)\n\t\t\t{\n\t\t\t\tif(document.getElementById(\"menu_code_\"+n))//Create Error\n\t\t\t\t{\n\t\t\t\t\tvar menuCode1=document.getElementById(\"menu_code_\"+n).value;\n\t\t\t\t\tif(menuCode1 == removedMenus_Arr[h])\n\t\t\t\t\t{\n\t\t\t\t\tif(document.getElementById(\"chk_\"+n))\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.getElementById(\"chk_\"+n).checked=false;\n\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\t}\n</script>\n</body>\n\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.trim()!="" && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return (checkForNull(inputString).intern()!="") ? inputString:defaultValue;
	}

public HashMap CToHashMap( Hashtable table ) {
		if( table == null ) return null;
		return new HashMap(table);
}


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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

	String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "")) ?
	(String) session.getAttribute("PREFERRED_STYLE"):"IeStyle.css" ;
	if(sStyle==null)sStyle="IeStyle.css";
	session.removeAttribute("ALLMENUITEMSMAP"); 
	String param = request.getQueryString();

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String whereClause = checkForNull(request.getParameter("whereclause"));
	if(whereClause==null) whereClause="";
	String sql = "";
	int maxRecord = 0;

	PreparedStatement pstmt=null,pstmt1 = null,pstmt2=null,pstmt3=null,pstmt4=null,pstmt5=null,pstmt6=null,pstmt7=null,pstmt_KitchenCode = null,pstmt8=null,pstmt9=null;
	ResultSet rst=null,rst1 = null,rst2=null,rst3=null,rst4=null,rst5=null,rst6=null,rst7=null,rst_KitchenCode=null,rst8=null,rst9=null;

	Connection conn = null;
	conn = ConnectionManager.getConnection(request);

	String ExistingFoodItem = request.getParameter("ExistingFoodItem");
	String NewFoodItem = request.getParameter("NewFoodItem"); //Added against ICN-64263
	String DietType = request.getParameter("DietType");
	String MealType = request.getParameter("MealType");
	String from = checkForNull(request.getParameter("from"));
	String to = checkForNull(request.getParameter( "to" ));
	int start = (from.equals(""))?1:Integer.parseInt(from);
	int end = (to.equals(""))?28:Integer.parseInt(to);	
	int wherecheck=0;

	//Modified against ICN-64263
	String strsql = "SELECT DISTINCT menu_code, short_desc menu_desc FROM ds_menu WHERE menu_code IN (SELECT menu_code       FROM ds_menu_item WHERE item_code = '"+ExistingFoodItem+"') AND menu_code NOT IN (SELECT menu_code FROM ds_menu_item WHERE item_code = '"+NewFoodItem+"') AND diet_type IS NOT NULL AND meal_type IS NOT NULL ";

	if ( !(DietType == null || DietType.equals("")) ){    				
		sql = sql + "AND diet_type IN ("+DietType+") ";
		wherecheck=1;
	}

	if ( !(MealType == null || MealType.equals("")) ){    				
		sql = sql + "AND meal_type IN ("+MealType+")";
		wherecheck=1;
	}

	if(wherecheck==1) strsql=strsql+sql;

	try{
		String menu_code = "";
		String menu_desc = "";
		String language_id = (String)session.getAttribute("LOCALE");

		pstmt = conn.prepareStatement(strsql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE) ;
		rst	= pstmt.executeQuery();
		//getting maximum record
		rst.last();	maxRecord = rst.getRow();
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
		}
		//again move the resultset pointer to initial position
		rst.beforeFirst();			

            _bw.write(_wl_block8Bytes, _wl_block8);

if ( !(start <= 1) ) {
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf((start-28)));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf((end-28)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(URLEncoder.encode(sql)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(ExistingFoodItem));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(NewFoodItem));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(DietType));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(MealType));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
}if ( !( (start+28) > maxRecord ) ) {
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf((start+28)));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf((end+28)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(URLEncoder.encode(sql)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(ExistingFoodItem));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(NewFoodItem));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(DietType));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(MealType));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
}
            _bw.write(_wl_block19Bytes, _wl_block19);
 if(maxRecord > 0)
{

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(start));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf((end-14)));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

}
	String classValue="";

	if ( start!= 1 ) 
		rst.absolute(start-1);
		int i=start;
		int count=1;
	while(rst != null && rst.next() && i<=end){
		if ( i % 2 == 0 )
			classValue = "QRYODD" ;
		else
			classValue = "QRYEVEN" ;

	if(count<=14)
	{
		menu_code = rst.getString(1);
		menu_desc = rst.getString(2);				

            _bw.write(_wl_block25Bytes, _wl_block25);
if(maxRecord >= (end-14)) { 
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(menu_code));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(menu_code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(menu_code));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(start));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(end-14));
            _bw.write(_wl_block32Bytes, _wl_block32);
 } else { 
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(menu_code));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(menu_code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(menu_code));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(start));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(maxRecord));
            _bw.write(_wl_block32Bytes, _wl_block32);
 }  
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(menu_code));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(menu_code));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(menu_desc));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(menu_desc));
            _bw.write(_wl_block39Bytes, _wl_block39);

			i++;
			count++;
			}
			}

            _bw.write(_wl_block40Bytes, _wl_block40);

	if(((start+14) <= end) && maxRecord >0 && (maxRecord>= (start+14)))
	{

            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(start+14));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf((end)));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

	}
		classValue="";	
		rst.absolute(start+13);//ICN-64263
		i=start+14;
		count=15;
		while(rst != null && rst.next() && i<=end){
				
		if ( i % 2 == 0 )
			classValue = "QRYODD" ;
		else
			classValue = "QRYEVEN" ;

		if(count >14)
		{
			menu_code = rst.getString(1);
			menu_desc = rst.getString(2);				

            _bw.write(_wl_block25Bytes, _wl_block25);
if(maxRecord >= (end)) { 
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(menu_code));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(menu_code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(menu_code));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(start+14));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(end));
            _bw.write(_wl_block32Bytes, _wl_block32);
} else {
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(menu_code));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(menu_code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(menu_code));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(start+14));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(maxRecord));
            _bw.write(_wl_block32Bytes, _wl_block32);
}
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(menu_code));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(menu_code));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(menu_desc));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(menu_desc));
            _bw.write(_wl_block44Bytes, _wl_block44);

				i++;
				count++;
				}
				}
		     	}
		     	catch(Exception e){
		     		e.printStackTrace();
		     	}
		     	finally{
					if(pstmt!=null)	pstmt.close();
					if(rst!=null)	rst.close();
					if(pstmt1!=null)	pstmt1.close();
					if(rst1!=null)	rst1.close();					
					if(conn != null){
						ConnectionManager.returnConnection(conn,request);
					}
				}
		 
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(start));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(end));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(maxRecord));
            _bw.write(_wl_block48Bytes, _wl_block48);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.Menu.Label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.MenuDescription.Label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.Menu.Label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.MenuDescription.Label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
