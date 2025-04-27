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
import java.sql.*;
import webbeans.eCommon.*;
import java.lang.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __batchsearchgoodsreturntovendorvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/BatchSearchGoodsReturnToVendorValidate.jsp", 1727953843897L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="  \n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\t\n";
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
            _bw.write(_wl_block3Bytes, _wl_block3);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);
            eST.BatchSearchGoodsReturnToVendorBean obj39= null;{
                obj39=(eST.BatchSearchGoodsReturnToVendorBean)pageContext.getAttribute("obj39");
                if(obj39==null){
                    obj39=new eST.BatchSearchGoodsReturnToVendorBean();
                    pageContext.setAttribute("obj39",obj39);

                }
            }
            _bw.write(_wl_block3Bytes, _wl_block3);

request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
	int functionType = Integer.parseInt(request.getParameter("function_type"));

	String bean_id = "BatchSearchGoodsReturnToVendorBean";
	String bean_name = "eST.BatchSearchGoodsReturnToVendorBean";
	BatchSearchGoodsReturnToVendorBean bean = (BatchSearchGoodsReturnToVendorBean)getBeanObject( bean_id,bean_name,request);  
	bean.setLanguageId(locale);
	Hashtable hash = (Hashtable) XMLobj.parseXMLString(request);
    hash = (Hashtable) hash.get ("SEARCH");
	switch (functionType) {

	case 1:
		{
				String item_code			=   CommonBean.checkForNull(request.getParameter("item_code"),"");
				String store_code			=	CommonBean.checkForNull(request.getParameter("store_code"),"");
				String supp_code			=	CommonBean.checkForNull(request.getParameter("supp_code"),"");
				String po_no			=	CommonBean.checkForNull(request.getParameter("po_no"),"%");
				String grn_doc_type_code			=	CommonBean.checkForNull(request.getParameter("grn_doc_type_code"),"%");
				String grn_doc_no			=	CommonBean.checkForNull(request.getParameter("grn_doc_no"),"%");
				String doc_type_code	=	CommonBean.checkForNull(request.getParameter("doc_type_code"),"");
				String doc_no			=	CommonBean.checkForNull(request.getParameter("doc_no"),"");
				String trn_type			=	CommonBean.checkForNull(request.getParameter("trn_type"),"");
				bean.setItem_code(item_code) ;
				bean.setStore_code(store_code) ;
				bean.setSupp_code(supp_code) ;
				bean.setPo_no(po_no) ;
				bean.setGrn_doc_type_code(grn_doc_type_code) ;
				bean.setGrn_doc_no(grn_doc_no) ;
				bean.loadResultPage(doc_type_code,doc_no,trn_type);
		}
		break;
		case 2:
		{
		}
		break;
		case 3:
		{
			out.println("document.forms[0].count.value=1;");
		}
		break;
		case 4:
		{
			String index= request.getParameter( "index" )==null?"":request.getParameter( "index" ) ;
			String noOfCheckedRecords= request.getParameter( "noOfCheckedRecords" )==null?"":request.getParameter( "noOfCheckedRecords" ) ;
			bean.selectedBatches(index,noOfCheckedRecords);
		}
		break;
		default :
		out.println("alert(\'Invalid Function\');");
		return;
	}

            _bw.write(_wl_block4Bytes, _wl_block4);

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
