package jsp_servlet._emm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eMM.*;
import eMM.Common.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __tradenameforitemvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emm/jsp/TradeNameForItemValidate.jsp", 1727954232000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="  \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n\n";
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
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);
            java.util.ArrayList alTradeNameForItemList= null;synchronized(session){
                alTradeNameForItemList=(java.util.ArrayList)pageContext.getAttribute("alTradeNameForItemList",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(alTradeNameForItemList==null){
                    alTradeNameForItemList=new java.util.ArrayList();
                    pageContext.setAttribute("alTradeNameForItemList",alTradeNameForItemList,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block2Bytes, _wl_block2);

		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		//locale ="en";
//		String primary_lang		= (String)session.getAttribute("PRIMARY_LANG");
	TradeNameForItemBean bean = (TradeNameForItemBean)getBeanObject( "TradeNameForItemBean", "eMM.TradeNameForItemBean",request ) ;  
		bean.setLanguageId(locale);
	String item_code		=	request.getParameter("item_code");
	String item_desc		=	request.getParameter("item_desc");
	String trade_id			=	request.getParameter("trade_id");
	String trade_name		=	request.getParameter("trade_name");
	String manufacturer_id	=	request.getParameter("manufacturer_id");
	String manufacturer_name=	request.getParameter("manufacturer_name");
	String validate			=	request.getParameter("validate");
	String index			=	request.getParameter("index");
	String message			=	"";
	String flag				=	"";
	boolean	result			=	true;
	try{
		if (validate.equals("ITEM_DESC")) { 
			HashMap hmResult = null;
			try {
				//hmResult = 				bean.fetchRecord(bean.getMmRepositoryValue("SQL_MM_ITEM_LOOKUP"),item_code);	
				out.println("setItemDetails(\""+item_code+"\",\""+hmResult.get("description")+"\");");
			}
			catch (Exception exception) {
				//exception.printStackTrace();
				//throw new Exception("INVALID_MM_ITEM_CODE");
				throw new Exception("INVALID_MM_ITEM_CODE");
			}
		}
		else if (validate.equals("TRADE_NAME")) {
			HashMap hmResult=null;
			try { 
				ArrayList arr_lang=new ArrayList();
				arr_lang.add(trade_id);
				arr_lang.add(locale);
				hmResult= bean.fetchRecord(bean.getMmRepositoryValue("SQL_GET_AM_TRADE_NAME"),arr_lang);

				if(hmResult.get("DESCRIPTION") != null) {
					out.println("setTradeIdDetails(\""+trade_id+"\",\""+hmResult.get("DESCRIPTION")+"\");");
				}
				else {
					//throw new Exception("INVALID_AM_TRADE_ID");
				}
			}
			catch (Exception exception) {

				exception.printStackTrace();

				throw new Exception("INVALID_AM_TRADE_ID");
			}
		}
		else if (validate.equals("ASSIGN_FLAG")) {
			int flagIndex = Integer.parseInt(request.getParameter("flagIndex"));
			boolean flagValue = new Boolean(request.getParameter("flagValue")).booleanValue();	
			HashMap map = (HashMap)alTradeNameForItemList.get(flagIndex);
			if(map != null) {
				map.put("ADD",new Boolean(flagValue));
			}
		}
		else if (validate.equals("CLEAR_BEAN")) {
			bean.clear();
		}
		else if(validate.equals("MINIMUM_CHECK")) {	
			// To set the values in the bean
			bean.setTradeNameForItemList(alTradeNameForItemList);

			int sizeOfTheList = alTradeNameForItemList.size();
			int count = 0;
			for(int i=0;i<sizeOfTheList;i++) {
				HashMap map = (HashMap)alTradeNameForItemList.get(i);
				if(map.get("ADD") != null) {
					if(((Boolean)map.get("ADD")).booleanValue() != false) {
						count++;
					}
				}
			}
			if(count > 0) {
				result	=	true;
				message	=	"Done";			
			}
			else {
				result = false;				
			}
		}
		else if (validate.equals("ADD_TO_LIST")) {
//			boolean test = bean.isTradeIdInArrayList(alTradeNameForItemList,trade_id,Integer.parseInt(index));

			if(! bean.isTradeIdInArrayList(alTradeNameForItemList,trade_id,Integer.parseInt(index)) ) {
				HashMap hmTradeNameListItems=new HashMap();
				hmTradeNameListItems.put("ITEM_CODE",item_code);
				hmTradeNameListItems.put("ITEM_DESC",item_desc);			
				hmTradeNameListItems.put("TRADE_ID",trade_id);
				hmTradeNameListItems.put("TRADE_NAME",trade_name);
				hmTradeNameListItems.put("MANUFACTURER_ID",manufacturer_id);
				hmTradeNameListItems.put("MANUFACTURER_NAME",manufacturer_name);
				hmTradeNameListItems.put("MODE","1");
				hmTradeNameListItems.put("ADD",new Boolean(true));

				if (index.equals("-1")) {					hmTradeNameListItems.put("mode",eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"));
					alTradeNameForItemList.add(hmTradeNameListItems);
				}
				result	=	true;
				message	=	"Done";			
			}
			else {
				result = false;		
				throw new Exception("DUPLICATE_ENTRIES_NOT_ALLOWED");				
			}
		}
		else if (validate.equals("CLEAR")) {
			alTradeNameForItemList.clear();
		}
	}
	catch (Exception exception) {
		result	=	false;
		message	=	exception.getMessage();
	}
	finally {
		out.println(" assignValues(" + result + ", \"" + message + "\", \"" + flag + "\" ) ; ") ;
	}
putObjectInBean("TradeNameForItemBean",bean,request);

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
