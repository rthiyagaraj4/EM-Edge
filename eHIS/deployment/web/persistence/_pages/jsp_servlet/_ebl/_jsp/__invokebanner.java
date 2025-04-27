package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eBL.InvokeBannerBean;
import eBL.Common.BlRepository;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __invokebanner extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/InvokeBanner.jsp", 1737917084573L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n \n<html>\n<head>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\' ></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<!--<script language=\"javascript\" src=\'../js/BLBanner.js\'></script> -->\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n <script>\n \t$(document).ready(function(){\n \t\tvar bannerSize = $(\'#bannerSize\').val();\n \t\tif(bannerSize>3){\n \t\t\t$(\'#miniBanner\').show();\n \t\t\t$(\'#maxiBanner\').hide();\n \t\t}\n \t\telse{\n \t\t\t$(\'#miniBanner\').hide();\n \t\t\t$(\'#maxiBanner\').show();\n \t\t}\n \t});\n\t   var headTop = -1;\n\t   var FloatHead1;\n\t   function processScroll()\n\t   \t{\n\t   \t\tif (headTop < 0)\n\t   \t\t{\n\t   \t\t\tsaveHeadPos();\n\t   \t\t\t\n\t   \t\t}\n\t   \t\tif (headTop>0)\n\t   \t\t{\n\t   \t\t\tif (document.documentElement && document.documentElement.scrollTop)\n\t   \t\t\t\ttheTop = document.documentElement.scrollTop;\n\t   \t\t\telse if (document.body)\n\t   \t\t\t\ttheTop = document.body.scrollTop;\n\t    \n\t   \t\t\tif (theTop>headTop)\n\t   \t\t\t\tFloatHead1.style.top = (theTop-headTop) + \'px\';\n\t   \t\t\telse\n\t   \t\t\t\tFloatHead1.style.top = \'0px\';\n\t   \t\t}\n\t   \t}\n\t    \n\t   \tfunction saveHeadPos()\n\t   \t{\n\t   \t\tparTable = document.getElementById(\"divHeadSep\");\n\t   \t\tif (parTable != null)\n\t   \t\t{\n\t   \t\t\theadTop = parTable.offsetTop + 3;\n\t   \t\t\tFloatHead1 = document.getElementById(\"heading\");\n\t   \t\t\tFloatHead1.style.position = \"relative\";\n\t   \t\t}\n\t   \t}\n\t   \t\n\t   \tfunction ShowMaximum(size)\n\t   \t{\n\t   \t\t/*if(size>2)\n\t   \t\t{\n\t   \t\t\tdocument.getElementById(\"miniBanner\").style.visibility=\'hidden\';\n\t\t   \t\tdocument.getElementById(\"maxiBanner\").style.visibility=\'visible\';\n\t   \t\t}*/\n\t   \t\t$(\'#miniBanner\').hide();\n \t\t\t$(\'#maxiBanner\').show();  \t\t\n\t   \t}\n\t  \n\t\tfunction ShowMinimize()\n\t   \t{\n\t\t\t/*document.getElementById(\"maxiBanner\").style.visibility=\'hidden\';\n\t   \t\tdocument.getElementById(\"miniBanner\").style.visibility=\'visible\';*/\n\t\t\t$(\'#miniBanner\').show();\n \t\t\t$(\'#maxiBanner\').hide();\t \n\t   \t}\n\t  \n</script>\n<style>\n\t   \t\tthead td, thead td.locked\t{\n\t   \t\tbackground-color: navy;\n\t   \t\tcolor: white;\n\t   \t\tposition:relative;}\t\n\t   \t\tthead td {\n\t   \t\ttop: expression(document.getElementById(\"tbl-container\").scrollTop-4); \n\t   \t\tz-index: 20;}\n\t   \t\tthead td.locked {z-index: 30;}\n\t   \t\ttd.locked,  th.locked{\n\t   \t\tleft: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);\n\t   \t\tposition: relative;\n\t   \t\tz-index: 10;}\n\t   \t\ttd.locked,  th.locked{\n\t   \t\tleft: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);\n\t   \t\tposition: relative;\n\t   \t\tz-index: 10;}\n\t   \t\t</style>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\t\n<div id=\"BannerHead\"  name=\"BannerHead\" style=\"visibility: visible;\">\n\n<div id=\"miniBanner\" name=\"miniBanner\" style=\"display: none;\">\t \n  \n<TABLE width=\"100%\" CELLSPACING=0 cellpadding=2 align=\'center\'>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t<tr >\n\t\t\t\t\t<td  class=\"columnheader\" >";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t\t\t\t<td  class=\"columnheader\" >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>    \n\t\t\t\t</tr>\t\t\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<tr>\n<td  class=\"columnheader\" ></td>\n<td  class=\"columnheader\" ></td>\n<td  class=\"columnheader\" ></td>\n<td  class=\"columnheader\" ></td>\n<td  class=\"columnheader\" ></td>\n   \n<td  class=\"columnheader\"  onclick=\"ShowMaximum(\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\')\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>    \n</tr>\n</TABLE>\n</div>\n\n\n\n<div id=\"maxiBanner\" name=\"maxiBanner\" style=\"display: none;\">\t \n  \n<TABLE width=\"100%\" CELLSPACING=0 cellpadding=2 align=\'center\'>\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n<tr>\n<td  class=\"columnheader\" ></td>\n<td  class=\"columnheader\" ></td>\n<td  class=\"columnheader\" ></td>\n<td  class=\"columnheader\" ></td>\n<td  class=\"columnheader\" ></td>\n   \n<td  class=\"columnheader\"  onclick=\"ShowMinimize()\">Minimize</td>    \n</tr>\n</TABLE>\n</div>\n\n\n</div>\t\t\n<input type=\'hidden\' name=\'bannerSize\' id=\'bannerSize\' id=\'bannerSize\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\n\t</body>\n\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n</html>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );
	
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


	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
	  
String locale																				=	null;
String facilityId																			=	null;
String loggedInUser																			=	null;
String bean_id																				= 	null;
String bean_name																			= 	null;
ArrayList bannerList				 														=   null;
HashMap bannerListMap																		=   null;
HashMap	tabdata																				=	null;
String miniBannerVisibility																	=	"";
Iterator iterator																			=	null;
try
		{		
			locale																			= 	(String)session.getAttribute("LOCALE");
			facilityId																		= 	(String) session.getValue( "facility_id" ) ;
			loggedInUser																	=  	(String) session.getValue("login_user");	
			bannerList				 														=   new ArrayList();
			bannerListMap																	=   new HashMap();
			tabdata																			=	new HashMap();
			bean_id																			=	"InvokeBannerBean";
			bean_name																		=	"eBL.InvokeBannerBean";
			InvokeBannerBean	invokeBannerBean											=	(InvokeBannerBean)getBeanObject( bean_id, bean_name, request ) ;
			miniBannerVisibility															=	"hidden";
			
			tabdata.put("login_user",		loggedInUser);
			tabdata.put("facility_id"	, 	facilityId);
			tabdata.put("userid"		,  	checkForNull(request.getParameter("userid")));
			tabdata.put("userrespid"	, 	checkForNull(request.getParameter("userrespid")));
			tabdata.put("functionid"	, 	checkForNull(request.getParameter("functionid")));
			tabdata.put("patientid"		, 	checkForNull(request.getParameter("patientid")));
			tabdata.put("episodetype"	, 	checkForNull(request.getParameter("episodetype")));
			tabdata.put("episodeid"		, 	checkForNull(request.getParameter("episodeid")));
			tabdata.put("visitid"		, 	checkForNull(request.getParameter("visitid")));   
			tabdata.put("blnggrpid"		, 	checkForNull(request.getParameter("blnggrpid")));
			tabdata.put("custgroupcode"	, 	checkForNull(request.getParameter("custgroupcode")));
			tabdata.put("custcode"		, 	checkForNull(request.getParameter("custcode")));
			tabdata.put("locale"		, 	locale);    
				
			System.out.println("facilityId IN InvokeBanner.JSP::: "+facilityId);

            _bw.write(_wl_block7Bytes, _wl_block7);

bannerListMap = invokeBannerBean.invokeBanner(tabdata);
int bannerLimit = 3;
int bannerSize = bannerListMap.size();
iterator= bannerListMap.keySet().iterator(); 
System.out.println("In InvokeBanner.jsp bannerListMap:::::::"+bannerListMap);

for(int k=0;k<bannerLimit && iterator.hasNext();k++)
{

	
	int key =    (Integer)iterator.next();
		System.out.println("In InvokeBanner.jsp::miniBanner:::invokeBanner key:::::"+key);
		invokeBannerBean = (InvokeBannerBean) bannerListMap.get(key);
			System.out.println("INDEX::: "+key+" ::::COLUMN1::::::::::: 		"+invokeBannerBean.getCloumn1());
			System.out.println("INDEX::: "+key+" ::::COLUMN1VALUE:::::: 		"+invokeBannerBean.getCloumn1Value());
			System.out.println("INDEX::: "+key+" ::::COLUMN2::::::::::: 		"+invokeBannerBean.getCloumn2());
			System.out.println("INDEX::: "+key+" ::::COLUMN2VALUE:::::: 		"+invokeBannerBean.getCloumn2Value());
			System.out.println("INDEX::: "+key+" ::::COLUMN3::::::::::: 		"+invokeBannerBean.getCloumn3());
			System.out.println("INDEX::: "+key+" ::::COLUMN3VALUE:::::: 		"+invokeBannerBean.getCloumn3Value());
	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(invokeBannerBean.getCloumn1() ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(invokeBannerBean.getCloumn1Value()));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(invokeBannerBean.getCloumn2() ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(invokeBannerBean.getCloumn2Value() ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(invokeBannerBean.getCloumn3() ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(invokeBannerBean.getCloumn3Value() ));
            _bw.write(_wl_block10Bytes, _wl_block10);

}	

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(bannerListMap.size()));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( bannerListMap.size()>bannerLimit ? "Maximize" : "" ));
            _bw.write(_wl_block13Bytes, _wl_block13);



bannerListMap = invokeBannerBean.invokeBanner(tabdata);
iterator= bannerListMap.keySet().iterator(); 
while(iterator.hasNext())
{
	
	int key =    (Integer)iterator.next();
	
		System.out.println("In InvokeBanner.jsp:::::maxiBanner::::invokeBanner key:::::"+key);
		invokeBannerBean = (InvokeBannerBean) bannerListMap.get(key);
			System.out.println("INDEX::: "+key+" ::::COLUMN1::::::::::: 		"+invokeBannerBean.getCloumn1());
			System.out.println("INDEX::: "+key+" ::::COLUMN1VALUE:::::: 		"+invokeBannerBean.getCloumn1Value());
			System.out.println("INDEX::: "+key+" ::::COLUMN2::::::::::: 		"+invokeBannerBean.getCloumn2());
			System.out.println("INDEX::: "+key+" ::::COLUMN2VALUE:::::: 		"+invokeBannerBean.getCloumn2Value());
			System.out.println("INDEX::: "+key+" ::::COLUMN3::::::::::: 		"+invokeBannerBean.getCloumn3());
			System.out.println("INDEX::: "+key+" ::::COLUMN3VALUE:::::: 		"+invokeBannerBean.getCloumn3Value());
			
	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(invokeBannerBean.getCloumn1() ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(invokeBannerBean.getCloumn1() ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(invokeBannerBean.getCloumn2() ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(invokeBannerBean.getCloumn2Value() ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(invokeBannerBean.getCloumn3() ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(invokeBannerBean.getCloumn3Value() ));
            _bw.write(_wl_block10Bytes, _wl_block10);

		
}	

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(bannerSize));
            _bw.write(_wl_block15Bytes, _wl_block15);

	}catch(Exception e){out.println("EXCEPTION IN INVOKEBANNER.JSP::::"+e);}
	

            _bw.write(_wl_block16Bytes, _wl_block16);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
