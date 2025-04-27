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
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __pkgdeftab extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/PkgDefTab.jsp", 1737917439869L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<html>\n<head>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n \t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\t\n\t<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n\t<script language=\"javascript\" src=\'../../eBL/js/PkgDefCust.js\'></script>\n\t<script language=\"javascript\" src=\'../../eBL/js/PkgDef.js\'></script>\n    <Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>\n\n\n \n\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onLoad=\"chkMasterpack1()\">\n<form name=\"frmPkgDefTab\" id=\"frmPkgDefTab\" >\n\n<table cellpadding=3 cellspacing=0 border=0 width=\'100%\' align=\"center\">\n<tr width=\'100%\'>\n\t<td width=\"100%\" class=\"white\">\n\t\t<ul id=\'tablist\' class=\'tablist\'>\n\t\t\t <li class=\'tablistitem\' title=\'Package Base Price\'>\n\t\t\t\t<a onclick=\'showTabDetail(\"PACKAGE_PRICE\",\"1\",\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\")\' class=\"tabA\" id=\"PACKAGE_PRICE\">\n\t\t\t\t\t<span class=\"tabAspan\" id=\"PACKAGE_PRICEspan\">\n\t\t\t\t\t\tPackage Base Price\n\t\t\t\t\t\t</span></a>\n\t\t\t</li> \n\n\t\t\t<li class=\"tablistitem\" title=\'Package Services(Rate Based)\'>\n\t\t\t\t<a onclick=\"showTabDetail(\'RATE_BASED\',\'1\',\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\')\" class=\"tabA\" id=\"RATE_BASED\">\n\t\t\t\t\t<span class=\"tabAspan\" id=\"RATE_BASEDspan\">\n\t\t\t\t\t\t<!--";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="-->\n\t\t\t\t\t\tPackage Services(Rate Based)\n\t\t\t\t\t\t</span></a>\n\t\t\t</li>\n\n\t\t\t<li class=\"tablistitem\" title=\'Package Services(Charge Based)\'>\n\t\t\t\t<a onclick=\"showTabDetail(\'CHARGE_BASED\',\'1\',\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\')\" class=\"tabA\" id=\"CHARGE_BASED\">\n\t\t\t\t\t<span class=\"tabAspan\" id=\"CHARGE_BASEDspan\">\n\t\t\t\t\t\t<!--";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="-->\n\t\t\t\t\t\tPackage Services(Charge Based)\n\t\t\t\t\t\t</span></a>\n\t\t\t</li>\t\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t <li class=\'tablistitem\' title=\'Child Package\'>\n\t\t\t\t<a onclick=\'showTabDetail(\"CHILD_PACK\",\"1\",\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\")\' class=\"tabA\" id=\"CHILD_PACK\">\n\t\t\t\t\t<span class=\"tabAspan\" id=\"CHILD_PACKspan\">\n\t\t\t\t\t\tAssociate Child Package\n\t\t\t\t\t\t</span></a>\n\t\t\t</li> \t\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t</ul>\n\t</td>\t\n\t</tr>\n\t</table>\n\t<input type=\'hidden\' name=\'prevTabObj\' id=\'prevTabObj\' value=\"\" />\n\t<input type=\'hidden\' name=\'fromDate\' id=\'fromDate\' value=\"\" />\n\t<input type=\'hidden\' name=\'index\' id=\'index\' value=\"0\" />\n\t<input type=\'hidden\' name=\'allow_masterChild_package_map\' id=\'allow_masterChild_package_map\' value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" />\n\t<input type=\'hidden\' name=\'isMasterPackYN\' id=\'isMasterPackYN\' value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" />\n\t<!-- The below line is required to change the select state of Initial tab selected -->\n\t<!-- Added for MMS-QH-CRF-128.1 STARTS -->\n\t<input type=\'hidden\' name=\'siteAutoApplyPkgDiscYN\' id=\'siteAutoApplyPkgDiscYN\' value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" />\n\t<input type=\'hidden\' name=\'newPkg\' id=\'newPkg\' value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" />\n\t<!-- Added for MMS-QH-CRF-128.1  ENDS-->\n\t\n\t<script>//prevTabObj=\'PACKAGE_PRICE\'</script>\n\t<script>//showTabDetail(\'PACKAGE_PRICE\',\'0\')</script>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );
	
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block4Bytes, _wl_block4);

	String from	= request.getParameter("from")== null ? "PACKAGE": request.getParameter("from");
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	//Added V190325 Gayathri/KDAH-CRF-0503
	Connection con = null;	
	Boolean allow_masterChild_package=false;
	String allow_masterChild_package_map ="";
	String isMasterPackYN="N";
	PreparedStatement pstmt	= null;
	ResultSet rs = null;
	String packageCode =request.getParameter("packageCode")==null?"N":request.getParameter("packageCode");
	String facilityId = (String)session.getAttribute("facility_id");
	String  PkgByPolicy="";	//MMS-QH-CRF-128.1-US-2  PALANINARAYANAN 17/6/2020 
	String	newPkg="";		//MMS-QH-CRF-128.1-US-2  PALANINARAYANAN 17/6/2020 
	Boolean siteAutoApplyPkgDiscYN = false;
	try
	{
		con = ConnectionManager.getConnection();	
		allow_masterChild_package = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","ALLOW_MASTER_CHILD_PKG_MAPPING");	
		String sql="select IS_MASTER_PKG_YN from bl_package where PACKAGE_CODE=? ";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, packageCode);
		rs = pstmt.executeQuery();
		if( rs != null ) 
		{
			while( rs.next() )
			{			
				isMasterPackYN = rs.getString(1);
			}
		}	
		if(rs!=null) rs.close();
		if(pstmt != null) pstmt.close();	
	
		if(allow_masterChild_package){
			allow_masterChild_package_map="Y";
		}
		else{
			allow_masterChild_package_map="N";
		}
		//Added V190325 Gayathri/KDAH-CRF-0503/Ends
	
		//added by palani/MMS-QH-128.1/STARTS
		//HttpSession httpSession = request.getSession(false);
	
		siteAutoApplyPkgDiscYN = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_AUTO_APPLY_PKG_DISC_YN");
		//MMS-QH-CRF-128.1-US-2  PALANINARAYANAN 17/6/2020 STARTS-->
		String sqlStr="";
		sqlStr = "select  pkg_cust_disc_by_policy, pkg_cust_disc_new_pkg  from bl_parameters where OPERATING_FACILITY_ID=?" ;
		pstmt = con.prepareStatement(sqlStr);
		pstmt.setString(1, facilityId);
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			PkgByPolicy = rs.getString("pkg_cust_disc_by_policy");			
			newPkg = rs.getString("pkg_cust_disc_new_pkg");	
		}
	} catch (Exception ex) {
		ex.printStackTrace();
	}
	finally
	{
		if(rs!=null) rs.close();
		if(pstmt != null) pstmt.close();	
		if(con!=null) con.close();
		ConnectionManager.returnConnection(con);
		System.out.println("Conection closed");
	}
	//MMS-QH-CRF-128.1  PALANINARAYANAN 17/6/2020 ENDS-->

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(from));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(from));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(from));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
if(("Y").equals(allow_masterChild_package_map)){ 
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(from));
            _bw.write(_wl_block13Bytes, _wl_block13);
} 
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(allow_masterChild_package_map));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(isMasterPackYN));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(siteAutoApplyPkgDiscYN));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(newPkg));
            _bw.write(_wl_block18Bytes, _wl_block18);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Equipments.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Equipments.Label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
