package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.lang.String;
import java.util.ArrayList;
import eXH.*;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __interfacestandardprofilesearch extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/InterfacestandardprofileSearch.jsp", 1709122348773L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html> \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n<script language=\'JavaScript\' src=\'../../eCommon/js/common.js\'></script>\n<script Language=\"JavaScript\"  src=\"../../eCommon/js/ValidateControl.js\" ></script>\n<script Language=\"JavaScript\"  src=\"../../eXH/js/ProfiledervationRefrence.js\" ></script>\n<script Language=\"JavaScript\">\nfunction funSubmit2()\n{\n\t//var tabletextvalue=document.getElementById(k+\"_C/E\");\n\t\t//var tabletextvalue1=document.getElementById(k+\"_EV\");\n\t\t//\tvar tabletextvalue2=document.getElementById(k+\"_EO\");\n\t\t\t//\tvar tabletextvalue3=document.getElementById(k+\"_EV2\");\n\t\t\t\t//\tvar tabletextvalue4=document.getElementById(k+\"_PO\");\n\t//var elTableCells = this.document.ProfileRef.elTableRow.value;\n//alert(tabletextvalue.value+\"tabletextvalue1.value\"+tabletextvalue1.value+\"tabletextvalue.value\"+tabletextvalue2.value+\"tabletextvalue.value\"+tabletextvalue3.value+\"tabletextvalue.value\"+tabletextvalue4.value);\nvar value=\'U\';\nvar act=\"../../eXH/jsp/Protocollinkupdate.jsp?action_type=\"+value;\n\tthis.document.forms[0].action = act;\n  this.document.forms[0].action_type.value=\'U\';\n\tthis.document.forms[0].target=\'messageFrame\';\n\tthis.document.forms[0].submit();\n\t\n\t\n\t//var act=\"../../servlet/eXH.DataElementCrossRefSearchServlet?application_id=\"+application_id1+\"&element_id=\"+element_id1;\n\t//this.document.forms[0].action = act;\n  //this.document.forms[0].action_type.value=\'U\';\n\t//this.document.forms[0].target=\'messageFrame\';\n\t//this.document.forms[0].submit();\n}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown =\'lockKey()\'>\n<form name=\"ProfileRef\" id=\"ProfileRef\" method=\"POST\" action=\'../../eXH/jsp/ProfileDervationSelectMaster.jsp\' >\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<table name=elTableRow border=1 cellspacing=0 cellpadding=3 width=\'100%\' align=center>\n\t<tr>\n<td colspan=\"4\" align=\"right\" class=\"CAGROUP\" >\n\t</td>\n\t\n\t<td colspan=\"4\" align=\"right\" class=\"CAGROUP\" > \n<A class=\'label\' style=\'cursor:pointer\' onClick=\"funAction(\'P\')\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</A>\n\t<A class=\'label\'  onClick=\"funAction(\'N\')\" style=\'cursor:pointer\' >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</A>\n</td>\n\n\n</tr>\n<tr>\n<!--\n<td class=\'COLUMNHEADER\' width=\'35%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td> -->\n\t<td class=\'COLUMNHEADER\' width=\'5%\'>Profile ID</td>\n\t<td class=\'COLUMNHEADER\' width=\'5%\'>Short description</td>\n\t<td class=\'COLUMNHEADER\' width=\'5%\'>long description </td>\n\t<td class=\'COLUMNHEADER\' width=\'5%\'>Version description</td>\n\t\t<td class=\'COLUMNHEADER\' width=\'5%\'>Geography description</td>\n\t\t\t<td class=\'COLUMNHEADER\' width=\'5%\'>Application ID</td>\n\t<td class=\'COLUMNHEADER\' width=\'5%\'>Standard code</td>\n\n</tr>\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\n<td class=label >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n<td class=label >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\t\n\t</tr>\n\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t<tr>\n\n\t\t<td colspan=4 class=label><img src=\'../../eCommon/images/green_square.jpg\' width=40 height=15 >";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="<input type=\"hidden\" name=\"Num_colu\" id=\"Num_colu\" value=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="><input type=\'hidden\' name=\'action_type\' id=\'action_type\' value=\'U\' ></td> \n\t\t<td></td>\n\t\t<td class=label>\n\t\t</td>\n<td class=label>\n\t\t</td>\n\n\t\t</tr>\n\n\t</table> \n\n\n</form>\n</body>\n</html>\n\n\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

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
request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block5Bytes, _wl_block5);
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);



Connection conn = null;

String strPrevious = "";
String strNext="";

int columval=0;
try
{
	
	/*conn = ConnectionManager.getConnection(request);
	XHApplicationDerivationProfileSetupControllerBean	xhBean =
	XHApplicationDerivationProfileSetupControllerBean.getBean(strBeanName,request,session);
	xhBean.action(request,conn);
	
	boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
	boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
	strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Previous.Label","xh_labels");
	strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Next.Label","xh_labels");
	if (boolPrevious == true)
	{
		strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Previous.Label","xh_labels");
	}
	else
	{
		strPrevious = " ";
	}
	if (boolNext== true)
	{
		strNext  =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Next.Label","xh_labels");
	}
	else
	{
		strNext  = " ";
	}*/

	}	
catch(Exception exp)
    {
       System.out.println("Error in  InterfacestandardprofileSearch.jsp :"+exp.toString());
	   exp.printStackTrace(System.err);
    }
		
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(strPrevious));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(strNext));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

  ResultSet rset = null;
  PreparedStatement pstmt = null ;



  String standardcode=request.getParameter("standard_code");
String profileid=request.getParameter("profile_id");
 String sql="";
int i=0;
try
	{
if(conn==null) conn = ConnectionManager.getConnection();
 }
     catch(Exception exp)
    {
       System.out.println("Error in InterfacestandardprofileSearch.jsp :"+exp.toString());
	   exp.printStackTrace(System.err);
    }
  try
    {
 sql="select PROFILE_ID,SHORT_DESC,LONG_DESC,VERSION_DESC,GEOGRAPHY_DESC,APPLICATION_ID,STANDARD_CODE from XH_STANDARD_PROFILE where STANDARD_CODE=NVL('"+standardcode+"',STANDARD_CODE) and PROFILE_ID=NVL('"+profileid+"',PROFILE_ID) ";


 pstmt = conn.prepareStatement(sql);
 rset = pstmt.executeQuery();
 //strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Previous.Label","xh_labels");
// strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Next.Label","xh_labels");
	/*		if (boolPrevious == true)
	{
		strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Previous.Label","xh_labels");
	}
	else
	{
		strPrevious = " ";
	}
	if (boolNext== true)
	{
		strNext  =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Next.Label","xh_labels");
	}
	else
	{
		strNext  = " ";
	}*/

      while(rset.next())
      {

	//arrRow = (ArrayList)rset.getString(i);

//out.println("rset.next()"+rset.getString(s));

/*try
{
	conn = ConnectionManager.getConnection(request);
	//XHApplicationDerivationSetupControllerBean	xhBean =
	//XHApplicationDerivationSetupControllerBean.getBean(strBeanName,request,session);
	//xhBean.action(request,conn);

	
	resultsQry = xhBean.getResultSet();
	arrRow = (ArrayList)resultsQry.get("qry_result"); 
	boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
	boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
	strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Previous.Label","xh_labels");
	strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Next.Label","xh_labels");
	if (boolPrevious == true)
	{
		strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Previous.Label","xh_labels");
	}
	else
	{
		strPrevious = " ";
	}
	if (boolNext== true)
	{
		strNext  =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Next.Label","xh_labels");
	}
	else
	{
		strNext  = " ";
	}
	}*/
	
//catch(Exception e1)
//	{
	//	out.println("Error="+e1);
	//}



	
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(rset.getString(1)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(rset.getString(2)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(rset.getString(3)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(rset.getString(4)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(rset.getString(5)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(rset.getString(6)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(rset.getString(7)));
            _bw.write(_wl_block14Bytes, _wl_block14);


	i++;
   
      }
columval=i;
	  if(rset!=null) rset.close();
      if(pstmt!=null) pstmt.close();
    }
    catch(Exception exp)
    {
		 System.out.println(" InterfacestandardprofileSearch.jsp :sql "+sql);
       System.out.println("Error in  InterfacestandardprofileSearch.jsp :"+exp.toString());
	   exp.printStackTrace(System.err);
    }

finally
	{
		ConnectionManager.returnConnection(conn);
	}

            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(columval));
            _bw.write(_wl_block17Bytes, _wl_block17);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.ElementDesc.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.Recently.Label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
