package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import eST.*;
import eST.Common.*;
import eCommon.Common.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.lang.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __stcontroller extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/StController.jsp", 1735815204094L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );
	
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


public String replaceNewLineChar(String message) 
{
	String changed = "";
	changed = message.replaceAll("\n","\\n/");
	changed = changed.replaceAll("\"","\\\"");
	changed = changed.replaceAll("'","\\\\'");	
	return changed;
}
/*   public String replaceNewLineChar(String message) {
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
}*/


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
            _bw.write(_wl_block0Bytes, _wl_block0);

	StringBuffer sbErrorMessage = new StringBuffer();
	HashMap hmApply = new HashMap();
	request.setCharacterEncoding("UTF-8");
	//String locale			= (String)session.getAttribute("LOCALE");

	try 
	{
		Hashtable htXMLObj = (Hashtable) xmlObj.parseXMLString( request ) ;
System.err.println("==request"+request);	
System.err.println("==BEFORE htXMLObj"+htXMLObj);		
		htXMLObj = (Hashtable) htXMLObj.get( "SEARCH" ) ;
System.err.println("==AFTER htXMLObj"+htXMLObj);		
		eST.Common.StAdapter beanObj = null;
		String bean_id		= (String) htXMLObj.get( "bean_id" );
		String bean_name	= (String) htXMLObj.get( "bean_name" );
		//	String mode			= (String) htXMLObj.get( "mode" );	
		System.out.println("bean id = > "+bean_id+" bean_name = > "+bean_name);
		//Object beanObject = (eST.Common.StAdapter)mh.getBeanObject( bean_id,request,bean_name); 
		Object beanObject = (eST.Common.StAdapter)getBeanObject( bean_id,bean_name,request); 
		
		if (beanObject  instanceof eST.Common.StAdapter) 	
		{
			System.out.println("Instance of StAdapter");
			beanObj = (eST.Common.StAdapter) beanObject;
		}
		else 
		{
			return;
		}

		htXMLObj.remove( "bean_id" ) ;
		htXMLObj.remove( "bean_name" );
		ServletContext context = getServletConfig().getServletContext();
		
		if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
			beanObj.setLocalEJB(false);
		
		System.out.println("45,BeanObj = > "+beanObj.getClass().getName());
		beanObj.setMode((String) htXMLObj.get("mode"));
		System.out.println("htXMLObj = > "+htXMLObj);
		beanObj.setAll(htXMLObj);


		if (beanObject  instanceof eST.GoodsReceivedNoteBean) 	{
			((eST.GoodsReceivedNoteBean)beanObject).setReport_Server((String)session.getAttribute("report_server"));
			((eST.GoodsReceivedNoteBean)beanObject).setReport_Connect_String((String)session.getAttribute("report_connect_string"));
		}
		else if (beanObject  instanceof eST.AdjustStockBean) 	{
			((eST.AdjustStockBean)beanObject).setReport_Server((String)session.getAttribute("report_server"));
			((eST.AdjustStockBean)beanObject).setReport_Connect_String((String)session.getAttribute("report_connect_string"));
		}
		else if (beanObject  instanceof eST.IssueBean) 	{
			((eST.IssueBean)beanObject).setReport_Server((String)session.getAttribute("report_server"));
			((eST.IssueBean)beanObject).setReport_Connect_String((String)session.getAttribute("report_connect_string"));
		}
		else if (beanObject  instanceof eST.ManufacturingReceiptsBean) 	{
			((eST.ManufacturingReceiptsBean)beanObject).setReport_Server((String)session.getAttribute("report_server"));
			((eST.ManufacturingReceiptsBean)beanObject).setReport_Connect_String((String)session.getAttribute("report_connect_string"));
		}
		else if (beanObject  instanceof eST.RequestBean) 	{
			((eST.RequestBean)beanObject).setReport_Server((String)session.getAttribute("report_server"));
			((eST.RequestBean)beanObject).setReport_Connect_String((String)session.getAttribute("report_connect_string"));
		}
		else if (beanObject  instanceof eST.IssueReturnBean) 	{
			((eST.IssueReturnBean)beanObject).setReport_Server((String)session.getAttribute("report_server"));
			((eST.IssueReturnBean)beanObject).setReport_Connect_String((String)session.getAttribute("report_connect_string"));
		}
		else if (beanObject  instanceof eST.GoodsReturnToVendorBean) 	{
			((eST.GoodsReturnToVendorBean)beanObject).setReport_Server((String)session.getAttribute("report_server"));
			((eST.GoodsReturnToVendorBean)beanObject).setReport_Connect_String((String)session.getAttribute("report_connect_string"));
		}
		else if (beanObject  instanceof eST.SalesBean) 	{
			((eST.SalesBean)beanObject).setReport_Server((String)session.getAttribute("report_server"));
			((eST.SalesBean)beanObject).setReport_Connect_String((String)session.getAttribute("report_connect_string"));
		}
		else if (beanObject  instanceof eST.SalesReturnBean) 	{
			((eST.SalesReturnBean)beanObject).setReport_Server((String)session.getAttribute("report_server"));
			((eST.SalesReturnBean)beanObject).setReport_Connect_String((String)session.getAttribute("report_connect_string"));
		}
		else if (beanObject  instanceof eST.StockTransferBean) 	{
			((eST.StockTransferBean)beanObject).setReport_Server((String)session.getAttribute("report_server"));
			((eST.StockTransferBean)beanObject).setReport_Connect_String((String)session.getAttribute("report_connect_string"));
		}
		else if (beanObject  instanceof eST.GenerateRequestBean) 	{
			((eST.GenerateRequestBean)beanObject).setReport_Server((String)session.getAttribute("report_server"));
			((eST.GenerateRequestBean)beanObject).setReport_Connect_String((String)session.getAttribute("report_connect_string"));
		}
		else if (beanObject  instanceof eST.AuthorizeAtIssueStoreBean) 	{
			((eST.AuthorizeAtIssueStoreBean)beanObject).setReport_Server((String)session.getAttribute("report_server"));
			((eST.AuthorizeAtIssueStoreBean)beanObject).setReport_Connect_String((String)session.getAttribute("report_connect_string"));
		}
		else if (beanObject  instanceof eST.ReplacementGRNBean) 	{
			((eST.ReplacementGRNBean)beanObject).setReport_Server((String)session.getAttribute("report_server"));
			((eST.ReplacementGRNBean)beanObject).setReport_Connect_String((String)session.getAttribute("report_connect_string"));
		}
		else if (beanObject  instanceof eST.CondemnExpiredBatchesHeaderBean) 	{
			((eST.CondemnExpiredBatchesHeaderBean)beanObject).setReport_Server((String)session.getAttribute("report_server"));
			((eST.CondemnExpiredBatchesHeaderBean)beanObject).setReport_Connect_String((String)session.getAttribute("report_connect_string"));
		}
		else if (beanObject  instanceof eST.StockItemConsumptionBean) 	{
			((eST.StockItemConsumptionBean)beanObject).setReport_Server((String)session.getAttribute("report_server"));
			((eST.StockItemConsumptionBean)beanObject).setReport_Connect_String((String)session.getAttribute("report_connect_string"));
		}
		else if (beanObject  instanceof eST.ProductTransferBean) 	{
			((eST.ProductTransferBean)beanObject).setReport_Server((String)session.getAttribute("report_server"));
			((eST.ProductTransferBean)beanObject).setReport_Connect_String((String)session.getAttribute("report_connect_string"));
		}

		System.out.println("BeanObj = > "+beanObj.getClass().getName());
		HashMap hmValidate = beanObj.validate() ;
		boolean validated = ((Boolean) hmValidate.get("result")).booleanValue() ;
		String validationMessage = (String) hmValidate.get("message");
		System.out.println("validated = > "+validated+" validationMessage = > "+validationMessage);
		if ( validated ) 
		{
			hmApply = beanObj.apply() ;
			System.out.println("hmApply = > "+hmApply);
			boolean result = ((Boolean) hmApply.get("result")).booleanValue() ;
			String message = (String) hmApply.get("message");

			String flag = beanObj.checkForNull((String) hmApply.get("flag"));
			String itemDesc = (String) hmApply.get("itemDesc");
			System.out.println("ItemDesc from Controller = > "+itemDesc);
			System.out.println("result--------in st controller---"+result);
			System.out.println("message--------in st controller---"+message);
			System.out.println("msgid--------in st controller---"+(String) hmApply.get("msgid"));

			/*if(((String)hmApply.get("msgid")).contains("NEGATIVE_STOCK"))
			{
				StringTokenizer strTok = new StringTokenizer((String) hmApply.get("msgid"),"!~");
				if(strTok.hasMoreTokens())	{
					strTok.nextToken();
					message = message + " "+strTok.nextToken();
				}

			}  */

			if(itemDesc!=null)
			message = message +" - "+itemDesc; 
			System.out.println("message from Controller after assigning = > "+message);
			System.out.println("flag--------in st controller---"+flag);
			String invalidCode = "" ;
			/*if(!flag.equals(""))
			{
			StringTokenizer st = new StringTokenizer(flag,":");
			String doc_no_desc = st.nextToken().trim();
			System.err.println("doc_no_desc--########"+doc_no_desc);
			String doc_no_value = st.nextToken();
			System.err.println("doc_no_value--########"+doc_no_value);
			//String doc_desc="Quantity";
			String doc_no_desc_th_eng=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST."+doc_no_desc+".label","st_labels");
			flag=doc_no_desc_th_eng+doc_no_value;
			}*/
			//System.err.println("flag--"+flag);

			if(hmApply.get( "invalidCode" ) != null) 
			{
				Object object = hmApply.get("invalidCode");
				if (object instanceof String) 
				{
					invalidCode = (String) hmApply.get( "invalidCode" ) ;
				}
				else if  (object instanceof java.util.ArrayList) 
				{
					java.util.ArrayList tempCode = (java.util.ArrayList) hmApply.get( "invalidCode" ) ;
					for (int i=0;i<tempCode.size() -1;i++) 
					{
						invalidCode =invalidCode+ (((java.util.ArrayList)tempCode.get(i)).get(0) + ",");
					}
					if ((tempCode.size() == 1) || (tempCode.size() > 1)) 
					{
						invalidCode =invalidCode+ ((java.util.ArrayList)tempCode.get(tempCode.size()-1)).get(0);
					}
				}
				out.println(" assignResult('" + result + "', '" + beanObj.replaceNewLineChar(message) + "', '" + flag + "' , '" + invalidCode + "' ) ; ") ;
			} 
			else if(hmApply.get("msgid")!=null) 
			{
				//		String 	module_id="Common";
				//	out.println("assignResult(" + result + ", getMessage(\"" + hmApply.get("msgid").toString()+ "\",\""+module_id+"\"), \""+flag+"\" ) ; ") ;
				message=beanObj.replaceNewLineChar(message);
				message= message.replaceAll("'","\"");
				if(message.contains("key"))
				message = message.substring(message.indexOf("key")+3);
				if(message.contains("<br>"))					
				message = message.substring(0,message.indexOf("<br>"));
				message=message+"<BR>";
				//out.println(" assignResult(" + result + ", '" + message + "', '" + flag + "' ) ; ") ;
				out.println(" assignResult('" + result + "', '" + message + "', '" + flag + "' ) ; ") ;
				//out.println("assignResult('" + result + "', , '"+flag+"' ) ; ") ;
			}
			else 
			{	
				message=beanObj.replaceNewLineChar(beanObj.checkForNull(message));
				message= message.replaceAll("'","\"");
				if(message.contains("key"))
				message = message.substring(message.indexOf("key")+3);
				if(message.contains("<br>"))					
				message = message.substring(0,message.indexOf("<br>"));
				out.println(" assignResult('" + result +"', '" + message + "','" + flag + "' ) ; ") ;
			}
			// added on Monday, December 22, 2003 by manish		
			if (result) 
			{
				beanObj.clear();
			}
		//ends
			}
			else if(hmValidate.get("msgid")!=null) 
			{
				String 	module_id="Common";
				out.println("assignResult('" + validated + "', getMessage('" + hmValidate.get("msgid").toString()+ "','"+module_id+"'), '"+beanObj.checkForNull((String)hmValidate.get("flag"))+"' ) ; ") ;
			}
			else 
			{
				out.println("assignResult('" + validated + "', '" + validationMessage + "', '"+beanObj.checkForNull((String)hmValidate.get("flag"))+"' ) ; ") ;
			}
	putObjectInBean(bean_id,beanObj,request);
	}
	catch (Exception e) 
	{
		e.printStackTrace();
		sbErrorMessage.append(e.toString());
		out.println("alert(\" 61 :"+hmApply.toString()+"\");");
		out.println("alert(\" Exception@StController : "+e.toString()+"\");");
		out.println("alert(\" 61 :"+replaceNewLineChar(hmApply.toString())+"\");");
		out.println("assignResult(false, \"Exception@StController : "+e.toString()+"\", \"0\" ) ; ") ;
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
