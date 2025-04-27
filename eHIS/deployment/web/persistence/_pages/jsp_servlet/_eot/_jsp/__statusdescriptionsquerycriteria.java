package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.util.ArrayList;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;

public final class __statusdescriptionsquerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/StatusDescriptionsQueryCriteria.jsp", 1709120366000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\">\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

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
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
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

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;
String code =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.StatusCode.Label","ot_labels")  ;
String systemDefinedDescription =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.SystemDefinedDescription.Label","ot_labels")  ;
String backGroundColor =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.BackGroundColor.Label","ot_labels")  ;

String textColor =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.TextColor.Label","ot_labels")  ;
String description  =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels")  ;

String statusCode  =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.StatusCode.Label","ot_labels")  ;
String color =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.BackGroundColor.Label","ot_labels")  ;

String sortorder =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels")  ;
String QueryCriteria =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels")  ;
String select   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ;
String executequery	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

String all	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");
String black	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Black.Label","ot_labels");
String white	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.White.Label","ot_labels");

String blue	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Blue.Label","ot_labels");
String lightblue =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.LightBlue.Label","ot_labels");
String darkblue	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.DarkBlue.Label","ot_labels");
String green	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Green.label","common_labels");
String lightgreen =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.LightGreen.Label","ot_labels");
String darkgreen =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.DarkGreen.Label","ot_labels");
String yellow	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Yellow.label","common_labels");
String red		=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Red.label","common_labels");
String darkred	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.DarkRed.Label","ot_labels");
String magenta	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Magenta.Label","ot_labels");
String brown	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Brown.Label","ot_labels");
String violet	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Violet.Label","ot_labels");
String indigo	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Indigo.Label","ot_labels");
String orange	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Orange.Label","ot_labels");
String pink		=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Pink.Label","ot_labels");
String grey		=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Gray.Label","ot_labels");
String cyan		=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Cyan.Label","ot_labels");
String darkcyan	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.DarkCyan.Label","ot_labels");
String purple	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Purple.Label","ot_labels");

Connection con=null ;
try {

 con  =  ConnectionManager.getConnection(request);
ArrayList finAr = new ArrayList();
ArrayList firstItem = new ArrayList();
		
firstItem.add("Text");           //Type of item
firstItem.add(code);     // label
firstItem.add("status_code");   //name of field
firstItem.add("2"); // SIZE
firstItem.add("2"); //LENGTH
finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");          //Type of item
secondItem.add(systemDefinedDescription);    // label
secondItem.add("status_desc_sysdef");  //name of field
secondItem.add("40");   // SIZE
secondItem.add("40");   //LENGTH
finAr.add(secondItem);    //add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();

thirdItem.add("Text");          //Type of item
thirdItem.add(description);    // label
thirdItem.add("status_desc");  //name of field
thirdItem.add("40");   // SIZE
thirdItem.add("40");   //LENGTH
finAr.add(thirdItem);    //add to ArrayList obj finAr

ArrayList fourthItem = new ArrayList();

fourthItem.add("List");   //Type of item
fourthItem.add(backGroundColor);  // label
fourthItem.add("color_ind");//name
fourthItem.add("all,"+all+",BLUE,"+blue+",LIGHTBLUE,"+lightblue+",DARKBLUE,"+darkblue+",GREEN,"+green+",LIGHTGREEN,"+lightgreen+",DARKGREEN,"+darkgreen+",YELLOW,"+yellow+",RED,"+red+",DARKRED,"+darkred+",MAGANTA,"+magenta+",BROWN,"+brown+",VIOLET,"+violet+",INDIGO,"+indigo+",ORANGE,"+orange+",PINK,"+pink+",GREY,"+grey+",CYAN,"+cyan+",DARKCYAN,"+darkcyan+",PURPLE,"+purple+"");//static values that need to be displayed as 
finAr.add(fourthItem); //add to ArrayList obj finAr

ArrayList fifthItem = new ArrayList();

fifthItem.add("List");   //Type of item
fifthItem.add(textColor);  // label
fifthItem.add("text_color");//name
fifthItem.add("all,"+all+",BLACK,"+black+",WHITE,"+white+"");//static values that need to be displayed as 
finAr.add(fifthItem);

String[] orderByCols=null;
String[] orderByColVals=null;

	orderByCols = new String[5];
	orderByColVals = new String[5];

	orderByCols[0] =statusCode;
	orderByCols[1] = systemDefinedDescription;
	orderByCols[2] = description;
    orderByCols[3] = color;
    orderByCols[4] = textColor;

	orderByColVals[0] = "status_code";
	orderByColVals[1] = "status_desc_sysdef";
	orderByColVals[2] = "status_desc";
	orderByColVals[3] = "color_ind";
    orderByColVals[4] = "text_color";

strbuff = qrypg.getQueryPage( con,finAr,"StatusDescriptions ","../../eOT/jsp/StatusDescriptionsQueryResult.jsp",sortorder,QueryCriteria,select,orderby,orderByCols, orderByColVals,executequery);
out.println(strbuff.toString());
} catch (Exception e) {e.printStackTrace();}

finally
{
    if(con!=null) ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block8Bytes, _wl_block8);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
