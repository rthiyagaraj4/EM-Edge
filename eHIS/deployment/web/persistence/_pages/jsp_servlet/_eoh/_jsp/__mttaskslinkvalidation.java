package jsp_servlet._eoh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOH.*;
import eOH.Common.*;
import eCommon.Common.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.sql.*;
import webbeans.eCommon.ConnectionManager;

public final class __mttaskslinkvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoh/jsp/MTTasksLinkValidation.jsp", 1709117120341L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOH/jsp/StringUtil.jsp", 1724302706763L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return ( inputString == null || inputString.equals("") )    ?   defaultValue    :   inputString;
	}

public String format_decimal(Double gs_val, int no_of_decimal){
		 
		String gs_val_str = gs_val+"";
		String restrict_gs_val = gs_val_str;
		int index = gs_val_str.indexOf(".");
		int len = (gs_val_str.substring(index+1)).length();
		if(index != -1 && len>no_of_decimal){
			restrict_gs_val = gs_val_str.substring(0,index+no_of_decimal+1);
		}

		return restrict_gs_val;
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
 request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

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

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	try {
		String func_mode	= request.getParameter("func_mode");
		Hashtable hash		= (Hashtable)xmlObj.parseXMLString( request ) ;
		hash				= (Hashtable)hash.get( "SEARCH" ) ;
		String bean_id		= "@MTLinkBean";
		String bean_name	= "eOH.MTLinkBean";
		MTLinkBean bean= (MTLinkBean)mh.getBeanObject( bean_id, request, bean_name );

		java.util.Properties prop = null;
		prop = (java.util.Properties) session.getValue( "jdbc" ) ;

		if(func_mode!= null && func_mode.equals("setCheckedRow")){
			try{
				String taskCode	= (String) hash.get("task_code");
				String taskDesc		= (String) hash.get("task_desc");
				taskDesc=java.net.URLDecoder.decode(taskDesc,"UTF-8");
				String seqNo		= (String) hash.get("seq_no");
				String selAlphabet		= (String) hash.get("selAlphabet");
				String select_value		= (String) hash.get("select_value");
				
				bean.setCheckedRow(selAlphabet,taskCode,taskDesc,seqNo,select_value);
				
				bean.getCheckedRow();
				out.println(bean);
				
			}catch(Exception e1){
				System.err.println("Execpetion in MTTasksLinkValidation.jsp: line 33: "+e1);
			}
		}
		else if(func_mode!= null && func_mode.equals("clearBean")){
			bean.clear();
		}
        else if(func_mode!= null && func_mode.equals("removeCheckedRow")){
			String taskCode	= (String) hash.get("task_code");
			String taskDesc		= (String) hash.get("task_desc");
			taskDesc=java.net.URLDecoder.decode(taskDesc,"UTF-8");
			String seqNo		= (String) hash.get("seq_no");
			String select_value		= (String) hash.get("select_value");
			
			bean.removeCheckedRow(taskCode,taskDesc,seqNo,select_value);
		}
		else if(func_mode!= null && func_mode.equals("getCheckedArray")){
			ArrayList checkedArray = (ArrayList)bean.getCheckedArray();
			StringBuffer  sbr= new StringBuffer();
			for (int k=0;k<checkedArray.size();k=k+3)
			{
		    String task_code= (String)checkedArray.get(k);
            String task_desc=(String)checkedArray.get(k+1);
			task_desc=java.net.URLDecoder.decode(task_desc,"UTF-8");
		    String seq_no= (String)checkedArray.get(k+2);
		    sbr.append(task_code+"##"+task_desc+"##"+seq_no+"##");
			}
			out.println(sbr);
		}
		else if(func_mode!= null && func_mode.equals("chkDuplicate")){
			String  flag_dup=bean.chkDuplicate();
		    out.println(flag_dup);
		}

	}catch (Exception e) {
		out.println("alert(\"" + e + "\");") ;
		e.printStackTrace();
	}

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
