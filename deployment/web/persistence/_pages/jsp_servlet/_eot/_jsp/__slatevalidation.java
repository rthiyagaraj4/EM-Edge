package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOT.*;
import eOT.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.ArrayList;
import java.util.Hashtable;

public final class __slatevalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/SlateValidation.jsp", 1724763380000L ,"10.3.6.0","Asia/Calcutta")) return true;
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
//@page  import="java.sql.*, java.util.*, java.io.*, eOT.Common.*, eOT.*" contentType="text/html;charset=" 
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
            _bw.write(_wl_block0Bytes, _wl_block0);

	try {
		
		String func_mode	= request.getParameter("func_mode");
		Hashtable hash		= (Hashtable)xmlObj.parseXMLString( request ) ;
		hash				= (Hashtable)hash.get( "SEARCH" ) ;
		String bean_id		= "@SlateBean";
		String bean_name	= "eOT.SlateBean";
		SlateBean bean= (SlateBean)mh.getBeanObject( bean_id, request, bean_name );

		if(func_mode!= null && func_mode.equals("getMenuList")){
			try{
				String oper_status	= (String) hash.get("oper_status");
				String role_id		= (String) hash.get("user_role");
				String tab_name		= (String) hash.get("tab_name");
				String sch_type		= request.getParameter("sch_type");//newly added for removing function id 17 in unsch cases.,
				ArrayList menu_list_arr = (ArrayList)bean.getMenuList(oper_status,role_id,tab_name,sch_type);
				StringBuffer function_id_list	= new StringBuffer();
				StringBuffer function_name_list = new StringBuffer();
				StringBuffer url_desc_list		= new StringBuffer();
				for(int i=0;i<menu_list_arr.size();i+=3){
					function_id_list.append((String)menu_list_arr.get(i));
					function_id_list.append("##");

					function_name_list.append((String)menu_list_arr.get(i+1));
					function_name_list.append("##");

					url_desc_list.append((String)menu_list_arr.get(i+2));
					url_desc_list.append("##");
				}
				out.println("assignFunctionIDList(\"" + function_id_list + "\");") ;
				out.println("assignFunctionNameList(\"" + function_name_list + "\");") ;
				out.println("assignFunctionURLList(\"" + url_desc_list + "\");") ;
				function_id_list.setLength(0);
				function_name_list.setLength(0);
				url_desc_list.setLength(0);
			}catch(Exception e1){
				System.err.println("Execpetion in SlateValidation.jsp: line 43: "+e1);
			}
		}else if(func_mode!= null && func_mode.equals("clearBean")){
			bean.clear();
		}else if(func_mode!= null && func_mode.equals("validateUserPwd")){
			String user_id	= (String) hash.get("user_id");
			String password	= (String) hash.get("password");
			String function_id	= (String) hash.get("function_id");
			ArrayList valid_user_arr = bean.validateUserPwd(user_id,password,function_id);
			String valid_user_flag = (String)valid_user_arr.get(0)+"##"+(String)valid_user_arr.get(1);
			out.println(valid_user_flag);
		}else if(func_mode!= null && func_mode.equals("updateStatusAndCommit")){
			String function_id		= (String) hash.get("function_id");
			String oper_num			= (String) hash.get("oper_num");
			String booking_num		= (String) hash.get("booking_num");
			String order_id			= (String) hash.get("order_id");
			String slate_user_id	= (String) hash.get("slate_user_id");
			String tab_name			= (String) hash.get("tab_name");
			String waitlist_num		= (String) hash.get("waitlist_num");
			String theatre			= (String) hash.get("theatre");
			String waitlist_flag	= "";
			if(tab_name.equals("WAITLIST"))
				waitlist_flag = "Y";

			String error_text = bean.updateStatusAndCommit(function_id,booking_num,oper_num,slate_user_id,waitlist_flag,order_id,waitlist_num,theatre);
			if(error_text==null) error_text="";
			if(error_text!=null && error_text.equals("null")) error_text="";
			if(error_text!=null && error_text.equals("")) error_text="";
			if(!error_text.equals("") && !error_text.equals("RECORD_INSERTED"))
				out.println(error_text);
			else
				out.println("NO_ERROR_FOUND");
		}else if(func_mode!= null && func_mode.equals("getBarcodeMenuList")){
			ArrayList menu_list_arr = (ArrayList)bean.getBarcodeMenuList();
			StringBuffer function_id_list = new StringBuffer();
			StringBuffer function_name_list = new StringBuffer();
			StringBuffer url_desc_list		= new StringBuffer();
			for(int i=0;i<menu_list_arr.size();i+=3){
				function_id_list.append((String)menu_list_arr.get(i));
				function_id_list.append("##");

				function_name_list.append((String)menu_list_arr.get(i+1));
				function_name_list.append("##");

				url_desc_list.append((String)menu_list_arr.get(i+2));
				url_desc_list.append("##");
			}
			out.println("assignBarcodeFunctionIDList(\"" + function_id_list + "\");") ;
			out.println("assignBarcodeFunctionNameList(\"" + function_name_list + "\");") ;
			out.println("assignBarcodeFunctionURLList(\"" + url_desc_list + "\");") ;
			function_id_list.setLength(0);
			function_name_list.setLength(0);
			url_desc_list.setLength(0);
		}
	}catch (Exception e) {
		out.println("alert(\"" + e + "\");") ;
		e.printStackTrace();
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
