package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.Hashtable;
import java.util.HashMap;
import eOT.Common.*;
import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import eCommon.XSSRequestWrapper;
import org.w3c.dom.*;
import org.xml.sax.InputSource;

public final class __otcontroller extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/OTController.jsp", 1724928834000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

  public Hashtable parseXMLString1(HttpServletRequest httpservletrequest)
    {  
		//System.err.println("66===");
        Object obj = null;
        Hashtable hashtable = new Hashtable();
        try
        {
            java.io.BufferedReader bufferedreader = httpservletrequest.getReader();
            InputSource inputsource = new InputSource(bufferedreader);
            DocumentBuilderFactory documentbuilderfactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentbuilder = documentbuilderfactory.newDocumentBuilder();
            Document document = documentbuilder.parse(inputsource);
            Element element = document.getDocumentElement();
            NodeList nodelist = element.getChildNodes();
            for(int i = 0; i < nodelist.getLength(); i++)
            {
                Element element1 = (Element)nodelist.item(i);
                NamedNodeMap namednodemap = element1.getAttributes();
                Hashtable hashtable1 = new Hashtable();
                for(int j = 0; j < namednodemap.getLength(); j++)
                {
                    Node node = namednodemap.item(j);
                    String s = node.getNodeValue();
                    s = s.replace('"', '\n');
				    //System.err.println("s==="+s);
                    hashtable1.put(node.getNodeName(), s);
                }

                hashtable.put(element1.getTagName(), hashtable1);
            }

        }
        catch(Exception exception)
        {
            hashtable.put("error", exception.toString());
        }
        return hashtable;
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
//@ page  import="java.sql.*, java.util.*, java.io.*, eOT.Common.*" contentType="text/html;charset=" 
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
 request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends 

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

/*
	Developed by 	:	Bhavani Shankar 
	Created on 		:	20/02/2005
	Module			:	OT
	Function		:	OTController.jsp
*/

try {
    //Hashtable hash = (Hashtable)xmlObj.parseXMLString( request ) ; 
	Hashtable hash = (Hashtable)parseXMLString1( request ) ; 
	hash = (Hashtable)hash.get( "SEARCH" ) ;
	//System.err.println("hash====="+hash);
	String bean_id = (String) hash.get( "bean_id");
    String bean_name = (String) hash.get( "bean_name");
    System.out.println(" ************* OTController JSP bean_name : "+bean_name+" bean_id : "+bean_id);
    OTAdapter beanObj = (OTAdapter)mh.getBeanObject( bean_id, request, bean_name ) ;
    System.out.println("beanObj value in 32 :"+beanObj);
    hash.remove( "bean_id" );
    hash.remove( "bean_name" );
	beanObj.setAll(hash);
    HashMap map = beanObj.validate() ;
	//out.println("alert(\"map" + map + "\");"); 
    boolean validated = ((Boolean) map.get( "result" )).booleanValue() ;
    String validationMessage = (String) map.get( "message" ) ;
    System.out.println(" ************* OTController JSP validationMessage : "+validationMessage);
	//out.println("alert(\"validated value" + validated + "\");"); 
    if ( validated ) {
		map = beanObj.apply();
		//out.println("alert(\"" + map + "\");") ;
        boolean result = ((Boolean) map.get( "result" )).booleanValue() ;
      //String  result = ((String) map.get( "result" ));
        String message = (String) map.get( "message" ) ;

        String flag = (String) map.get( "flag" );

        String invalidCode = "" ;
        if(map.get("invalidCode") != null)
            invalidCode = (String) map.get( "invalidCode" ) ;

        out.println("assignResult(" + result + ", \"" + beanObj.replaceNewLineChar(message) + "\", \"" + flag + "\" , \"" + invalidCode + "\") ; ") ;
    } else {
        out.println("assignResult(" + validated + ", \"" + validationMessage + "\", \"0\", \"0\" ) ; ") ;
    }
	map=null;
}catch (Exception e) {
	e.printStackTrace();
    //out.println("alert(\"Exception in Controller.jsp : " +e+ "\")") ;
}

            _bw.write(_wl_block0Bytes, _wl_block0);
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
