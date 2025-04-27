package jsp_servlet._emm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eMM.*;
import eMM.Common.*;
import eCommon.Common.*;
import java.sql.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __mmcontroller extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emm/jsp/MmController.jsp", 1720074000000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );
	
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


/*
Modified on 5/9/2006 as per TSG request
public String replaceNewLineChar(String message) {
	StringBuffer sb= new StringBuffer();
    try
	{
        String spChar[]={"\n","\""};
        String chChar[]={"\\n","\\\""};

        sb= new StringBuffer(message);
        upper:  for(int i=0;i<sb.length();i++)
                    for(int j=0;j<spChar.length;j++)
                    {
                        if(spChar[j].equals(String.valueOf(sb.charAt(i))))
                        {
                            sb.deleteCharAt(i);
                            sb.insert(i,chChar[j].toCharArray());
                            continue upper;
                        }
                    }
	}
	catch(Exception e)
	{
		sb.append("Exception@replaceNewLineChar : "+e.toString());
	}
        return sb.toString();
    } */


	public String replaceNewLineChar(String message) {
		
		String changed = "";

        changed = message.replaceAll("\n","\\n/");
		changed = changed.replaceAll("\"","\\\"");
		changed = changed.replaceAll("'","\\\\");	
        return changed;
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block3Bytes, _wl_block3);

request.setCharacterEncoding("UTF-8");
//String locale			= (String)session.getAttribute("LOCALE");
//locale ="en";
//String primary_lang		= (String)session.getAttribute("PRIMARY_LANG");
StringBuffer sbErrorMessage = new StringBuffer();
HashMap hmApply = new HashMap();
String message ="";
try {
	Hashtable htXMLObj = (Hashtable) xmlObj.parseXMLString( request ) ;
    htXMLObj = (Hashtable) htXMLObj.get( "SEARCH" ) ;

	eMM.Common.MmAdapter beanObj = null;
	String bean_id = (String) htXMLObj.get( "bean_id" );
	String bean_name = (String) htXMLObj.get( "bean_name" );
	//out.println("alert(\"bean_name: " +bean_name+"\");" );
	//out.println("alert(\"XMLObj: " +htXMLObj+"\");" );
	Object beanObject = (eMM.Common.MmAdapter)getBeanObject( bean_id,bean_name,request); 
	if (beanObject  instanceof eMM.Common.MmAdapter) 	{
		beanObj = (eMM.Common.MmAdapter) beanObject;
	}
	else {
		return;
	}
	htXMLObj.remove( "bean_id" ) ;
	htXMLObj.remove( "bean_name" );
	ServletContext context = getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		beanObj.setLocalEJB(false);

	beanObj.setMode((String) htXMLObj.get("mode"));
	beanObj.setAll(htXMLObj) ;

	HashMap hmValidate = beanObj.validate() ;

	boolean validated = ((Boolean) hmValidate.get("result")).booleanValue() ;
	//out.println("alert(\"hmvalidated  "+validated +"\");");
	String validationMessage = (String) hmValidate.get("message");

	if ( validated ) {
		hmApply = beanObj.apply() ;


		boolean result = ((Boolean) hmApply.get("result")).booleanValue() ;


		message = (String) hmApply.get("message");
		String flag = beanObj.checkForNull((String) hmApply.get("flag"));
		String invalidCode = "" ;
		
		if(hmApply.get( "invalidCode" ) != null) {
			Object object = hmApply.get("invalidCode");
			if (object instanceof String) {
				invalidCode = (String) hmApply.get( "invalidCode" ) ;
			}
			else if  (object instanceof java.util.ArrayList) {
				java.util.ArrayList tempCode = (java.util.ArrayList) hmApply.get( "invalidCode" ) ;
				for (int i=0;i<tempCode.size() -1;i++) {
					invalidCode =invalidCode+ (((java.util.ArrayList)tempCode.get(i)).get(0) + ",");
				}
				if ((tempCode.size() == 1) || (tempCode.size() > 1)) {
					invalidCode =invalidCode+ ((java.util.ArrayList)tempCode.get(tempCode.size()-1)).get(0);
				}
			}
			out.println(" assignResult(" + result + ", \"" + beanObj.replaceNewLineChar(message) + "\", \"" + flag + "\" , \"" + invalidCode + "\" ) ; ") ;
		} 
		else if(hmApply.get("msgid")!=null) {//out.println("alert(\"message2"+message+"\");");

		message=message+"<BR>";
			//out.println("assignResult(" + result + ", getMessage(\"" + hmApply.get("msgid").toString()+ "\"), \""+flag+"\" ) ; ") ;
			out.println(" assignResult(" + result + ", \"" + message + "\", \"" + flag + "\" ) ; ") ;
		}
		else {
			out.println(" assignResult(" + result + ", \"" + message + "\", \"" + flag + "\" ) ; ") ;
		}
	}
	else if(hmValidate.get("msgid")!=null) {
		//System.err.println("message----in hmvalidate---->"+message);
			String 	module_id="Common";
			//System.err.println("module_id----in hmvalidate---->"+module_id);
		out.println("alert(\"message4"+message+"\");");
		out.println("assignResult(" + validated + ", getMessage(\"" + hmValidate.get("msgid").toString()+ "\",\""+module_id+"\"), \"\" ) ; ") ;
	}
	else {
		out.println("assignResult(" + validated + ", \"" + validationMessage + "\", \"\" ) ; ") ;
	}
	putObjectInBean(bean_id,beanObj,request);

}
catch (Exception e) {
	e.printStackTrace();
	sbErrorMessage.append(e.toString());
	out.println("alert(\" 61 :"+hmApply.toString()+"\");");
	out.println("alert(\" Exception@MmController : "+e.toString()+"\");");
	out.println("alert(\" 61 :"+replaceNewLineChar(hmApply.toString())+"\");");
	out.println("assignResult(false, \"Exception@SsController : "+e.toString()+"\", \"0\" ) ; ") ;
}

            _bw.write(_wl_block4Bytes, _wl_block4);
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
