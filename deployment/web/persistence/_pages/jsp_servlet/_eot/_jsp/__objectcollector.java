package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.Hashtable;
import java.util.HashMap;
import eOT.SetUpParamForFacilityBean;
import eCommon.XSSRequestWrapper;

public final class __objectcollector extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/ObjectCollector.jsp", 1722238900000L ,"10.3.6.0","Asia/Calcutta")) return true;
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
 request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
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
            _bw.write(_wl_block0Bytes, _wl_block0);

try 
{
	String bean_id ="SetUpParamForFacilityBean";
    String bean_name = "eOT.SetUpParamForFacilityBean";
    SetUpParamForFacilityBean beanObj = (SetUpParamForFacilityBean) mh.getBeanObject( bean_id, request, bean_name ) ;

	HashMap hmap = new HashMap();

    Hashtable hash = (Hashtable)xmlObj.parseXMLString( request ) ; 
    hash = (Hashtable)hash.get( "SEARCH" ) ;
	String tab_id =(String)hash.get("tab_id");
	
	boolean main_other_1=false;
	boolean main_bill_1=false;
	boolean other_main_1=false;
	boolean other_bill_1=false;
	boolean bill_main_1=false;
	boolean bill_other_1=false;

	if( ("MainPage").equals(tab_id) )
	{
		hmap.putAll(hash);

		if(session.getAttribute("OtherDetails")!=null)
		{
			main_other_1=true;
			hmap.putAll((HashMap)session.getAttribute("OtherDetails"));
			hmap.put("tab_id","Both12");
		}

		if(session.getAttribute("BillingSetup")!=null)
		{
			main_bill_1=true;
			hmap.putAll((HashMap)session.getAttribute("BillingSetup"));
			hmap.put("tab_id","Both13");
		}
		
		//Rajesh V
		if(session.getAttribute("AdditionalDetails")!=null)
		{
			main_bill_1=true;
			hmap.putAll((HashMap)session.getAttribute("AdditionalDetails"));
			hmap.put("tab_id","Both13");
		}
		//Rajesh V
		
		if(main_other_1==true && main_bill_1==true)
		{
			hmap.put("tab_id","All");
		}
	}
	else if( ("OtherDetails").equals(tab_id) )
	{
		hmap.putAll(hash);
	
		if(session.getAttribute("MainPage")!=null)
		{
			other_main_1=true;
			hmap.putAll((HashMap)session.getAttribute("MainPage"));
			hmap.put("tab_id","Both21");
		}

		if(session.getAttribute("BillingSetup")!=null)
		{
			other_bill_1=true;
			hmap.putAll((HashMap)session.getAttribute("BillingSetup"));
			hmap.put("tab_id","Both21");
		}
		//Rajesh V
		if(session.getAttribute("AdditionalDetails")!=null)
		{
			main_bill_1=true;
			hmap.putAll((HashMap)session.getAttribute("AdditionalDetails"));
			hmap.put("tab_id","Both13");
		}
		//Rajesh V
		
		if(other_main_1==true && other_bill_1==true)
			hmap.put("tab_id","All");
	}
	else if(("BillingSetup").equals(tab_id))
	{
		hmap.putAll(hash);
	
		if(session.getAttribute("MainPage")!=null)
		{
			bill_main_1=true;
			hmap.putAll((HashMap)session.getAttribute("MainPage"));
			hmap.put("tab_id","Both13");

		}
		
		if(session.getAttribute("OtherDetails")!=null)
		{
			bill_other_1=true;
			hmap.putAll(hash);
			hmap.putAll((HashMap)session.getAttribute("OtherDetails"));
			hmap.put("tab_id","Both23");
		}
		
		//Rajesh V
		if(session.getAttribute("AdditionalDetails")!=null)
		{
			main_bill_1=true;
			hmap.putAll((HashMap)session.getAttribute("AdditionalDetails"));
			hmap.put("tab_id","Both13");
		}
		//Rajesh V
		
		if(bill_main_1==true && bill_other_1==true)
			hmap.put("tab_id","All");
	}
	//Rajesh V
	else if(("AdditionalDetails").equals(tab_id))
	{
		hmap.putAll(hash);
	
		if(session.getAttribute("MainPage")!=null)
		{
			bill_main_1=true;
			hmap.putAll((HashMap)session.getAttribute("MainPage"));
			hmap.put("tab_id","Both13");

		}
		
		if(session.getAttribute("OtherDetails")!=null)
		{
			bill_other_1=true;
			hmap.putAll(hash);
			hmap.putAll((HashMap)session.getAttribute("OtherDetails"));
			hmap.put("tab_id","Both23");
		}
		
		
		if(session.getAttribute("BillingSetup")!=null)
		{
			other_bill_1=true;
			hmap.putAll((HashMap)session.getAttribute("BillingSetup"));
			hmap.put("tab_id","Both21");
		}
		
		if(bill_main_1==true && bill_other_1==true)
			hmap.put("tab_id","All");
	}
	//Rajesh V
	//Else Part closing

   
	beanObj.setAll(hmap);
    HashMap map = beanObj.validate() ;
    boolean validated = ((Boolean) map.get( "result" )).booleanValue() ;
    String validationMessage = (String) map.get( "message" ) ;
    
	if ( validated ) 
	{
		map = beanObj.apply();
        boolean result = ((Boolean) map.get( "result" )).booleanValue() ;
        String message = (String) map.get( "message" ) ;
        String flag = (String) map.get( "flag" );
        String invalidCode = "" ;
        if(map.get("invalidCode") != null)
            invalidCode = (String) map.get( "invalidCode" ) ;
        out.println("assignResult(" + result + ", \"" + beanObj.replaceNewLineChar(message) + "\", \"" + flag + "\" , \"" + invalidCode + "\") ; ") ;
    } 
	else 
	{
        out.println("assignResult(" + validated + ", \"" + validationMessage + "\", \"0\", \"0\" ) ; ") ;
    }
	
	map=null;
	hmap=null;
	session.removeAttribute("MainPage");
	session.removeAttribute("OtherDetails");
	session.removeAttribute("BillingSetup");
}
catch (Exception e) 
{
	e.printStackTrace();
    //out.println("alert(\"Exception in Controller test: " +e+ "\")") ;
}

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
