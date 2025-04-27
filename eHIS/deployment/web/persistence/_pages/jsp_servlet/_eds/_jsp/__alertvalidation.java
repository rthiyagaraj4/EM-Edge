package jsp_servlet._eds._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eDS.*;
import eDS.Common.*;
import eCommon.Common.*;
import webbeans.eCommon.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.net.URLDecoder;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __alertvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eds/jsp/AlertValidation.jsp", 1730116868000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--Gomathi added against MMS-KH-CRF-0029.1 Starts Here-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n<script type=\"text/javascript\" src=\"../../eDS/js/PlaceDietOrder.js\"></script>\n<script type=\"text/javascript\" src=\"../../eDS/js/PlaceDietOrderPHIS.js\"></script>\n<script type=\"text/javascript\" src=\"../../eDS/js/DSCommon.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<head>\n<body>\n<form>\n\t<table>\n \t\t<tr>\n\t\t\t<td colspan=\"2\"> <img id=\"alertval\" src=\'../../eDS/css/alertVal.png\' width=\"100\" height=\"100\" style=\'visibility:visible\' ></img></td><td style=\"color:red;\">\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\t\n\t\t\t\t\t<br>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\t\t\t\t\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n</td>\n</tr>\n  \t\t<tr></tr><tr><td colspan=\"2\">\n\t\t<td align=\"right\">\n\t\t\t\t<input type=\"button\" name=\"\" id=\"\" value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'\n\t\t\t\tclass=\"button\" onClick=\"window.close();\" />\n\t\t\t</td>\n  \t\t</tr>\n\t</table>\t\n</form>\n</body>\n</head>\n</html>\n<!--Gomathi added for the MMS-KH-CRF-0029.1 Ends Here-->\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );
 
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
 request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);

String func_mode = request.getParameter("func_mode")== null?"":request.getParameter("func_mode");
try{
if(func_mode.equals("getretVal")){
			String ret_val = checkForNull(request.getParameter("ret_val"));
			String fromDate=checkForNull(request.getParameter("fromDate"));
			String dateTo=checkForNull(request.getParameter("dateTo"));
			System.err.println("ret_val===>"+ret_val);
			String Severity="";
			String warn="";
			String restrict="";
			String Documentation="";
			if(ret_val!="" || ret_val!="null")
			{
			String[] retVal = ret_val.split(",");
			int retValLen = retVal.length/9;
			int count =0;
			int countInc =8;
			ArrayList<String> ret = new ArrayList<String>();
			for(int i=1;i<=retValLen;i++){
				for(int j=count;j<=countInc;j++){
						 ret.add(retVal[j]);
					}
					String[] nameArray = ret.toArray(new String[ret.size()]);
					Severity = nameArray[4].trim();
					Documentation = nameArray[6].trim();
					if(Severity.equals("H"))
					{
						Severity="Major";
					}
					else if(Severity.equals("M"))
					{
						Severity="Moderate";
					}
					else
					{
						Severity="Minor";
					}
					if(Documentation.equals("E"))
					{
						Documentation="Established";
					}
					else if(Severity.equals("P"))
					{
						Documentation="Probabled";
					}else if(Severity.equals("S"))
					{
						Documentation="Suspected";
					}else if(Severity.equals("O"))
					{
						Documentation="Possible";
					}
					else
					{
						Documentation="Unlikely";
					}
					if(fromDate.equals(dateTo)){
					 warn = nameArray[1]+" interact with"+nameArray[2]+"("+nameArray[3].trim()+"). Drug with Food Interaction may occur with this order. (Severity Level - "+Severity+"), (Significant Level -" +nameArray[5]+")and (Documentation - "+Documentation+").";
					 restrict=nameArray[1]+" interact with"+nameArray[2]+"("+nameArray[3].trim()+"). Drug with Food Interaction may occur with this order. (Severity Level - "+Severity+"), (Significant Level - " +nameArray[5]+") and (Documentation - "+Documentation+"). Hence, the drug can not be prescribed.";
					}
					else
					{
					 warn = "On "+nameArray[0]+","+nameArray[1]+" interact with"+nameArray[2]+"("+nameArray[3].trim()+"). Drug with Food Interaction may occur with this order. (Severity Level - "+Severity+"), (Significant Level -" +nameArray[5]+") and (Documentation - "+Documentation+").";
					 restrict= "On "+nameArray[0]+","+nameArray[1]+" interact with"+nameArray[2]+"("+nameArray[3].trim()+"). Drug with Food Interaction may occur with this order. (Severity Level - "+Severity+"), (Significant Level - " +nameArray[5]+") and (Documentation - "+Documentation+"). Hence, the drug can not be prescribed.";
					}
					if(nameArray[7].equals(" Y"))
					{
					

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(restrict));
            _bw.write(_wl_block2Bytes, _wl_block2);

					}
					else
					{

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(warn));
            _bw.write(_wl_block8Bytes, _wl_block8);
						}
					ret.clear();
					count=count+9;
					countInc = countInc+9;	
				}
			}
		}
		if(func_mode.equals("groupOrder")){
			String ret_val = checkForNull(request.getParameter("ret_val"));
			String fromDate=checkForNull(request.getParameter("fromDate"));
			System.err.println("fromDate=jsp==>"+fromDate);
			String dateTo=checkForNull(request.getParameter("dateTo"));
			System.err.println("dateTo=jsp==>"+dateTo);
			System.err.println("ret_val===>"+ret_val);
			String Severity="";
			String warn="";
			String restrict="";
			String Documentation="";
			if(ret_val!="" || ret_val!="null")
			{
			String[] retVal = ret_val.split(",");
			int retValLen = retVal.length/10;
			int count =0;
			int countInc =9;
			ArrayList<String> ret = new ArrayList<String>();
			for(int i=1;i<=retValLen;i++){
				for(int j=count;j<=countInc;j++){
						 ret.add(retVal[j]);
					}
					String[] nameArray = ret.toArray(new String[ret.size()]);
					Severity = nameArray[4].trim();
					Documentation = nameArray[6].trim();
					if(Severity.equals("H"))
					{
						Severity="Major";
					}
					else if(Severity.equals("M"))
					{
						Severity="Moderate";
					}
					else
					{
						Severity="Minor";
					}
					if(Documentation.equals("E"))
					{
						Documentation="Established";
					}
					else if(Severity.equals("P"))
					{
						Documentation="Probabled";
					}else if(Severity.equals("S"))
					{
						Documentation="Suspected";
					}else if(Severity.equals("O"))
					{
						Documentation="Possible";
					}
					else
					{
						Documentation="Unlikely";
					}
					if(fromDate.equals(dateTo)){
					 warn = "<b>"+nameArray[9]+"</b>"+nameArray[1]+" interact with"+nameArray[2]+"("+nameArray[3].trim()+"). Drug with Food Interaction may occur with this order. (Severity Level - "+Severity+"), (Significant Level -" +nameArray[5]+")and (Documentation - "+Documentation+").";
					 restrict= "<b>"+nameArray[9]+"</b>"+nameArray[1]+" interact with"+nameArray[2]+"("+nameArray[3].trim()+"). Drug with Food Interaction may occur with this order. (Severity Level - "+Severity+"), (Significant Level - " +nameArray[5]+") and (Documentation - "+Documentation+"). Hence, the drug can not be prescribed.";
					}
					else
					{
					 warn = "On "+nameArray[0]+","+"<b>"+nameArray[9]+"</b>"+nameArray[1]+" interact with"+nameArray[2]+"("+nameArray[3].trim()+"). Drug with Food Interaction may occur with this order. (Severity Level - "+Severity+"), (Significant Level -" +nameArray[5]+") and (Documentation - "+Documentation+").";
					 restrict= "On "+nameArray[0]+","+"<b>"+nameArray[9]+"</b>"+nameArray[1]+" interact with"+nameArray[2]+"("+nameArray[3].trim()+"). Drug with Food Interaction may occur with this order. (Severity Level - "+Severity+"), (Significant Level - " +nameArray[5]+") and (Documentation - "+Documentation+"). Hence, the drug can not be prescribed.";
					}
					if(nameArray[7].equals(" Y"))
					{
					

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(restrict));
            _bw.write(_wl_block2Bytes, _wl_block2);

					}
					else
					{

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(warn));
            _bw.write(_wl_block8Bytes, _wl_block8);
						}
					ret.clear();
					count=count+10;
					countInc = countInc+10;	
				}
			}
		}
		
	}
	catch(Exception e)
		{
			System.err.println("AlertValidation.jsp====>>>"+e.toString());
			e.printStackTrace();
		}
	
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.Drug-Food.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Ok.label", java.lang.String .class,"key"));
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
