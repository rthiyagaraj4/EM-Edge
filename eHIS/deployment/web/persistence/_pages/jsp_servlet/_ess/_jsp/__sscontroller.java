package jsp_servlet._ess._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import eSS.Common.*;
import eSS.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __sscontroller extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ess/jsp/SsController.jsp", 1728910547543L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );
	
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


   public String replaceNewLineChar(String message) {

	StringBuffer sb= new StringBuffer();
    try
	{
        String spChar[]	=	{"\n","\""};
        String chChar[]	=	{"\\n","\\\""};

        sb				=	new StringBuffer(message);
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

		StringBuffer sbErrorMessage			=		 new StringBuffer();
		HashMap hmApply						=		 new HashMap();
try {
		Hashtable htXMLObj					=		(Hashtable) xmlObj.parseXMLString( request ) ;
		htXMLObj							=		(Hashtable) htXMLObj.get( "SEARCH" ) ;

		eSS.Common.SsAdapter beanObj		=		null;
		String bean_id						=		(String) htXMLObj.get( "bean_id" );
		String bean_name					=		(String) htXMLObj.get( "bean_name" );
		Object beanObject = null ;
		
		// System.out.println("MAP: " + htXMLObj.toString());
		
		// Added by marwan to solve the null session value in AutoclavingBean validate
		// Since checkedboxes are saved in session so the first if to handle it
		if("eSS.AutoclavingBean".equals(bean_name)){
			AutoclavingBean ACBean = (AutoclavingBean)getBeanObject( bean_id, bean_name, request ) ;
			if("updateAutoClave".equals((String) htXMLObj.get("function"))){
				ArrayList alAutoclavingList = (ArrayList)session.getAttribute("alAutoclavingList");
				HashMap hmAutoclavingRecord=new HashMap();
			    for(int i=0;i<alAutoclavingList.size();i++)
				{
					hmAutoclavingRecord	=	(HashMap)alAutoclavingList.get(i);
					if(((String) htXMLObj.get("tray_no")).equals(hmAutoclavingRecord.get("tray_no")))
					{
						hmAutoclavingRecord.put("SELECTED", (String) htXMLObj.get("val"));
					}
				}
				return ;
			} else {
				ACBean.setLanguageId((String) session.getAttribute("LOCALE"));
				ACBean.setLoginFacilityId((String) session.getAttribute("facility_id"));
				ACBean.setLoginById((String) session.getAttribute("login_user")) ;		
				ACBean.setSession(session);
			}
			beanObject = (eSS.Common.SsAdapter)ACBean;
		} else {
			beanObject					=		(eSS.Common.SsAdapter)getBeanObject( bean_id, bean_name, request ) ;		
		}
		if (beanObject  instanceof eSS.Common.SsAdapter) 	{
			beanObj							=		(eSS.Common.SsAdapter) beanObject;
		}
		else {
			return;
		}
		htXMLObj.remove( "bean_id" ) ;
		htXMLObj.remove( "bean_name" );

		beanObj.setMode((String) htXMLObj.get("mode"));

		beanObj.setAll(htXMLObj) ;

		HashMap hmValidate					=		beanObj.validate() ;

		boolean validated					=		((Boolean) hmValidate.get("result")).booleanValue() ;
		String validationMessage			=		(String) hmValidate.get("message");

		if (beanObject  instanceof eSS.PackingBean) 	{
			((eSS.PackingBean)beanObject).setReport_Server((String)session.getAttribute("report_server"));
			((eSS.PackingBean)beanObject).setReport_Connect_String((String)session.getAttribute("report_connect_string"));
		}

	if ( validated ) {
		hmApply								=		beanObj.apply() ;

		boolean result						=		((Boolean) hmApply.get("result")).booleanValue() ;

		String message						=		(String) hmApply.get("message");
		String flag							=		beanObj.checkForNull((String) hmApply.get("flag"));
		String invalidCode					=		"" ;

		if(hmApply.get( "invalidCode" ) != null) {
			Object object					=		hmApply.get("invalidCode");
			if (object instanceof String) {
				invalidCode					=		(String) hmApply.get( "invalidCode" ) ;
			}
			else if  (object instanceof java.util.ArrayList) {
				java.util.ArrayList tempCode = (java.util.ArrayList) hmApply.get( "invalidCode" ) ;
				for (int i=0;i<tempCode.size() -1;i++) {
					invalidCode				 =	invalidCode+ (((java.util.ArrayList)tempCode.get(i)).get(0) + ",");
				}
				if ((tempCode.size() == 1) || (tempCode.size() > 1)) {
					invalidCode				=	invalidCode+ ((java.util.ArrayList)tempCode.get(tempCode.size()-1)).get(0);
				}
			}
			out.println(" assignResult(" + result + ", \"" + beanObj.replaceNewLineChar(message) + "\", \"" + flag + "\" , \"" + invalidCode + "\" ) ; ") ;
		} 
		else if(message != null){
			out.println(" assignResult(" + result + ", \"" + message + "\", \"" + flag + "\" ) ; ") ;
		}
		else if(hmApply.get("msgid")!=null) {
			out.println("assignResult(" + result + ", getMessage(\"" + hmApply.get("msgid").toString()+ "\",'SS'), \""+flag+"\" ) ; ") ;
		}
		else {
			out.println(" assignResult(" + result + ", \"" + message + "\", \"" + flag + "\" ) ; ") ;
		}
	}
	else if(hmValidate.get("msgid")!=null) {
		out.println("assignResult(" + validated + ", getMessage(\"" + hmValidate.get("msgid").toString()+ "\",'SS'), \"\" ) ; ") ;
	}
	else {
		out.println("assignResult(" + validated + ", \"" + validationMessage + "\", \"\" ) ; ") ;
	}
 putObjectInBean(bean_id,beanObject,request);
}
catch (Exception e) {
	e.printStackTrace();
	sbErrorMessage.append(e.toString());
	//out.println("alert(\" 61 :"+hmApply.toString()+"\");");
	//out.println("alert(\" Exception@SsController : "+e.toString()+"\");");
	//out.println("alert(\" 61 :"+replaceNewLineChar(hmApply.toString())+"\");");
	out.println("assignResult(false, \"Exception@SsController : "+e.toString()+"\", \"0\" ) ; ") ;
}

            _bw.write(_wl_block1Bytes, _wl_block1);
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
