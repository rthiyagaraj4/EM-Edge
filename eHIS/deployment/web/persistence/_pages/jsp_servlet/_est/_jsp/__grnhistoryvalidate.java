package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eST.*;
import eST.Common.*;
import eCommon.Common.*;
import java.util.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.lang.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __grnhistoryvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/GRNHistoryValidate.jsp", 1732511637044L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 =" ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );
	
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

/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
06/11/2019              IN0071695          B Haribabu                                  					Alpha incident
--------------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);
            eST.GRNHistoryBean obj7= null;{
                obj7=(eST.GRNHistoryBean)pageContext.getAttribute("obj7");
                if(obj7==null){
                    obj7=new eST.GRNHistoryBean();
                    pageContext.setAttribute("obj7",obj7);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);

 request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");

	int functionType = Integer.parseInt(request.getParameter("function_type"));
	String bean_id = "GRNHistoryBean";
	String bean_name = "eST.GRNHistoryBean";
	GRNHistoryBean bean = (GRNHistoryBean) getBeanObject( bean_id,bean_name, request);  
	bean.clear();
	bean.setLanguageId(locale);
	Hashtable hash = (Hashtable) XMLobj.parseXMLString(request);
    hash = (Hashtable) hash.get ("SEARCH");
	switch (functionType) {
	case 1:
		{
				String item_code=CommonBean.checkForNull(request.getParameter("item_code"),"%");
				
				String doc_no=(String)CommonBean.checkForNull(request.getParameter("doc_no"),"%");
				System.out.println("doc_no: 27/10" +doc_no);
				String ext_doc_no =(String)CommonBean.checkForNull(request.getParameter("ext_doc_no"));
				String supp_code=CommonBean.checkForNull(request.getParameter("supp_code"),"%");
				String fm_doc_date=CommonBean.checkForNull(request.getParameter("fm_doc_date"));
				String to_doc_date=CommonBean.checkForNull(request.getParameter("to_doc_date"));
				String finalized_yn=CommonBean.checkForNull(request.getParameter("finalized_yn"),"A");
				String store_code=CommonBean.checkForNull(request.getParameter("store_code"),"%");
				String replace_on_expiry_yn=CommonBean.checkForNull(request.getParameter("replace_on_expiry_yn"),"A");
				String po_no=(String)CommonBean.checkForNull(request.getParameter("po_no"));
			//System.err.println("VALIDATE"+fm_doc_date+to_doc_date);
				if(!locale.equals("en"))
			{
			 if((fm_doc_date!=""|| fm_doc_date!=null)||(to_doc_date!=""||to_doc_date!=null))
				{
				//Modified for IN0071695 start
				 fm_doc_date=com.ehis.util.DateUtils.convertDate(fm_doc_date,"DMY",locale,"en");
					to_doc_date=com.ehis.util.DateUtils.convertDate(to_doc_date,"DMY",locale,"en");
					bean.setFm_doc_date(fm_doc_date) ;
					bean.setTo_doc_date(to_doc_date) ;
			  //bean.setFm_doc_date(com.ehis.util.DateUtils.convertDate(fm_doc_date,"DMY","en",locale));	
			//bean.setTo_doc_date(com.ehis.util.DateUtils.convertDate(to_doc_date,"DMY","en",locale));
			//Modified for IN0071695 end
				}
			}else
			{
			fm_doc_date=fm_doc_date;
to_doc_date=to_doc_date;
			bean.setFm_doc_date(fm_doc_date) ;
				bean.setTo_doc_date(to_doc_date) ;
			}  
				bean.setItem_code(item_code) ;
				bean.setSupp_code(supp_code) ;
				
				bean.setFinalized_yn(finalized_yn) ;
				bean.setStore_code(store_code) ;
				bean.setReplace_on_expiry_yn(replace_on_expiry_yn) ;
				bean.setPo_no(po_no) ;
				bean.setDoc_no(doc_no) ;   //28/10/11
				bean.setExt_doc_no(ext_doc_no) ;//28/10/11
				bean.loadResultPage();
				bean.getDataList();
				
		}
		break;
		default :
		//out.println("alert(\'Invalid Function\');");	
		return;
	}

            _bw.write(_wl_block2Bytes, _wl_block2);

putObjectInBean(bean_id,bean,request);

            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
