package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import eXH.*;
import webbeans.eCommon.ConnectionManager;
import eXH.XHDBAdapter;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __adminoraclejobeventlookupresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/AdminoraclejobEventLookupResult.jsp", 1742453175883L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n<head>\n  ";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n<script language=\'JavaScript\' src=\'../../eCommon/js/common.js\'></script>\n<script Language=\"JavaScript\"  src=\"../../eCommon/js/ValidateControl.js\" ></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown =\'lockKey()\'>\n<form name=\"DATAELEMENTCROSSREF\" id=\"DATAELEMENTCROSSREF\" method=\"POST\" action=\'../../eXH/jsp/\' >\n<table border=1 cellspacing=0 cellpadding=3 width=\'100%\' align=center>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \n\n<tr>\n \n\t<td class=\'COLUMNHEADER\' width=\'35%\'>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</td>\n\t<td class=\'COLUMNHEADER\' width=\'45%\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t<!---<td class=\'COLUMNHEADER\' width=\'45%\'>Enabled</td>---->\n</tr>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<script>\nalert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"));\n</script>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<tr>\n\t<td colspan=\"10\" align=\"right\" class=\"CAGROUP\" > \n\t<A class=\'label\' style=\'cursor:pointer\' onClick=\"funAction(\'P\')\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</A>\n\t<A class=\'label\'  onClick=\"funAction(\'N\')\" style=\'cursor:pointer\' >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</A>     \n\t</td>\n</tr>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n<tr>\n\n<td ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" align=\"left\" >";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n<td ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n </td>\n\n\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\n</td> \n\n</tr>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n</table>\n<table border=\'0\' width=\'100%\'>\n\t <tr>\n\t \t<td  align=\'right\'><input type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' width=\'25%\' onclick=\'funok()\'></td>\n\t </tr>\n</table>\n\t<input type=\'hidden\' name=\'action_type\' id=\'action_type\' value=\'U\' >\n</form>\n\n<script>\nfunction funSubmit()\n{\n\tvar act = \'../../eXH/jsp/AdminoraclejobEventLookupResult.jsp?\';\n\tthis.document.forms[0].action = act;\n\tthis.document.forms[0].submit();\n}\nfunction funAction(typ)\n{\n\tdocument.forms[0].action_type.value = typ;\n\tthis.document.forms[0].target=\'\'\n\tfunSubmit();\n}\nfunction getDescription(obj,cou)\n{\n\tif(document.getElementById(cou+\"_enable\").checked)\n\t{\n\t\tdocument.getElementById(cou+\"_enable\").value=\"Y\";\n\t}\n\telse\n\t{\n\t\tdocument.getElementById(cou+\"_enable\").value=\"N\";\n\t}\n\tfunAction(\"R\");\n}\nfunction funok() \n{\n\t/*var dialogHeight= \"250\" ;\n\tvar dialogWidth\t= \"250\" ;\n\tvar dialogTop = \"250\" ;\n\tvar center = \"250\" ;\n\tvar status=\"no\";\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\tvar arguments=\"\";\n\tvar str=window.showModalDialog(\"../../eXH/jsp/EventTypeValidate.jsp?action_type=R\",arguments,features);*/\n\n\n\n//window.returnValue=str;\n\n\twindow.close();\n}\n\n</script>\n</body>\n</html>\n\n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

	boolean boolToggle =  true;	
	String strTDClass = "";
	String strBeanName = XHEventControllerBean.strBeanName;

  
	//String from			= request.getParameter("from") ;
	//String to			= request.getParameter("to") ;  
	//String checkedOnes	= "";
	//String  req_start   =   "", req_end     =   "";
	String commode= XHDBAdapter.checkNull(request.getParameter("commmode"));
	String called_from = request.getParameter("called_from");
	if(called_from==null) called_from = "";
		//String sql_query=request.getParameter("sql_query");
 	String search_by=request.getParameter("search_by");
	if(search_by==null || search_by=="null") search_by = "C";
 	String description_code=(request.getParameter("description_code")==null||request.getParameter("description_code").equals("null"))?"":request.getParameter("description_code");
	String long_desc=request.getParameter("search_text");
	if(long_desc==null || long_desc=="null") long_desc = "";
 		  
 	//String facility_id = (String)session.getValue("facility_id");
	


 

	
 
  String protocol_link_id=XHDBAdapter.checkNull(request.getParameter("protocol_link_id"));
//System.out.println("protocol_link_id :"+protocol_link_id+"commode :"+commode); 
String event_id="";
String whereCaluse=" AND f.COMMUNICATION_TYPE in ('"+commode+"','*')"; 


if(long_desc.indexOf(",")!=-1)
{
	String[] splitstr=long_desc.split(",");
	String addComma="";
	for(int i=0;i<splitstr.length;i++)
	{
		if(i==(splitstr.length-1))
		{
		addComma=new String("'"+splitstr[i]+"'");
		}
		else
		{
		addComma=new String("'"+splitstr[i]+"',");
		}

	event_id=event_id+addComma;
    }
    whereCaluse=whereCaluse+"AND A.EVENT_TYPE in ("+event_id+") ORDER BY 1 ";
}
else
{




if(search_by.equals("C"))
{
	if(description_code.equals("S"))
	{
		whereCaluse=whereCaluse+" AND UPPER(a.EVENT_TYPE) LIKE UPPER('"+long_desc+"%') AND UPPER(f.event_name) LIKE UPPER('%') ORDER BY  a.event_type";
	}  
   else if(description_code.equals("E"))
	{
         whereCaluse=whereCaluse+" AND UPPER(a.EVENT_TYPE) LIKE UPPER('%"+long_desc+"') AND UPPER(f.event_name) LIKE UPPER('%') ORDER BY  a.event_type";
	}
	else
	{
	 whereCaluse=whereCaluse+" AND UPPER(a.EVENT_TYPE) LIKE UPPER('%"+long_desc+"%') AND UPPER(f.event_name) LIKE UPPER('%') ORDER BY  a.event_type";
	}
 }
 else
 {
   if(description_code.equals("S"))
	{
		whereCaluse=whereCaluse+" AND UPPER(a.EVENT_TYPE) LIKE UPPER('%') AND UPPER(f.event_name) LIKE UPPER('"+long_desc+"%') ORDER BY  a.event_type";
	} 
   else if(description_code.equals("E"))
	{
         whereCaluse=whereCaluse+" AND UPPER(a.EVENT_TYPE) LIKE UPPER('%') AND UPPER(f.event_name) LIKE UPPER('%"+long_desc+"') ORDER BY  a.event_type";
	}
	else
	{
	 whereCaluse=whereCaluse+" AND UPPER(a.EVENT_TYPE) LIKE UPPER('%') AND UPPER(f.event_name) LIKE UPPER('%"+long_desc+"%') ORDER BY  a.event_type";
	}
 }
}
Connection conn = null;


try 
{
		    
	conn = ConnectionManager.getConnection(request);

    request.setAttribute("whereCaluse",whereCaluse);
	request.setAttribute("protocol_link",protocol_link_id);
	XHEventControllerBean	xhBean = XHEventControllerBean.getBean(strBeanName,request,session);
	//XHDervationControllerBean xhBean = XHDervationControllerBean.getBean(strBeanName,request,session,response);
	xhBean.action(request,conn);
	HashMap resultsQry = xhBean.getResultSet();
	ArrayList arrRow = (ArrayList)resultsQry.get("qry_result"); 
	ArrayList arrCol = null;
	boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
	boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
    String strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
	String strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
	if (boolPrevious == true)
	{ 
		strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
	}
	else
	{ 
		strPrevious = " ";
	}
	if (boolNext== true)
	{
		strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
	}
	else
	{
		strNext  = " ";
	}



if(arrRow.size()==0)
{
	
            _bw.write(_wl_block10Bytes, _wl_block10);

}
else																							 
{
	
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf( strPrevious ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( strNext ));
            _bw.write(_wl_block13Bytes, _wl_block13);


for (int j=0; j<arrRow.size();j++)
{



	
	arrCol = (ArrayList)arrRow.get(j);
   if (boolToggle == true)
	{
		strTDClass = "class='QRYEVEN'";
		boolToggle =  false;
	}
	else
	{
		strTDClass = "class='QRYODD'";
		boolToggle =  true;
	}
	
	


            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(arrCol.get(0)+""));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(arrCol.get(1)+""));
            _bw.write(_wl_block17Bytes, _wl_block17);
            _bw.write(_wl_block18Bytes, _wl_block18);

}
}
if(arrRow!=null) arrRow.clear();
if(arrCol!=null) arrCol.clear();
if(resultsQry!=null) resultsQry.clear();

}
catch(Exception e1)
{
out.println("Error ings thana="+e1);
}
finally
{
	ConnectionManager.returnConnection(conn);
}

            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.code.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.close.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
