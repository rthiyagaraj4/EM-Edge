package jsp_servlet._emm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eMM.*;
import eMM.Common.*;
import eCommon.Common.*;
import java.util.*;
import webbeans.eCommon.*;
import java.sql.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __itemmastervalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emm/jsp/ItemMasterValidate.jsp", 1732511402000L ,"10.3.6.0","Asia/Calcutta")) return true;
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);
            eMM.ItemMasterQueryBean obj7= null;{
                obj7=(eMM.ItemMasterQueryBean)pageContext.getAttribute("obj7");
                if(obj7==null){
                    obj7=new eMM.ItemMasterQueryBean();
                    pageContext.setAttribute("obj7",obj7);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);

request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
//String primary_lang		= (String)session.getAttribute("PRIMARY_LANG");


	int functionType = Integer.parseInt(request.getParameter("function_type"));
	String bean_id = "ItemMasterQueryBean";
	String bean_name = "eMM.ItemMasterQueryBean";
	ItemMasterQueryBean bean = (ItemMasterQueryBean) getBeanObject( bean_id,bean_name,request);  
	bean.clear();
	bean.setLanguageId(locale);
	Hashtable hash = (Hashtable) XMLobj.parseXMLString(request);
    hash = (Hashtable) hash.get ("SEARCH"); 
	switch (functionType) {
	case 1:
		{
//				String facility_id = (String) session.getAttribute("facility_id");
				String category=CommonBean.checkForNull(request.getParameter("category"),"%");
				String ps_item=CommonBean.checkForNull(request.getParameter("ps_item"),"%");
				String eff_status=CommonBean.checkForNull(request.getParameter("eff_status"),"%");
				String spl_item=CommonBean.checkForNull(request.getParameter("spl_item"),"%");
				String sole_source=CommonBean.checkForNull(request.getParameter("sole_source"),"%");
				String Cons_item=CommonBean.checkForNull(request.getParameter("Cons_item"),"%");
				String searchby=CommonBean.checkForNull(request.getParameter("searchby"),"%");
				String item_class=CommonBean.checkForNull(request.getParameter("item_class"),"%");
				String item_code=CommonBean.checkForNull(request.getParameter("item_code"),"%");
				String search_str=CommonBean.checkForNull(request.getParameter("search"),"true");
				String pur_uom_code=CommonBean.checkForNull(request.getParameter("pur_uom_code"),"true");
				boolean	search = true;
				if (search_str.equals("true")) {
					search = true;
				}
				else
					search = false;

				String short_desc=CommonBean.checkForNull(request.getParameter("short_desc"),"%");
				String alpha_code=CommonBean.checkForNull(request.getParameter("alpha_code"),"%");
				String trade_id=CommonBean.checkForNull(request.getParameter("trade_id"),"%");
				String trade_name=CommonBean.checkForNull(request.getParameter("trade_name"),"%");
				String item_remarks=CommonBean.checkForNull(request.getParameter("item_remarks"),"%");
				String item_analysis_1=CommonBean.checkForNull(request.getParameter("item_analysis_1"),"%");
				String item_analysis_2=CommonBean.checkForNull(request.getParameter("item_analysis_2"),"%");
				String item_analysis_3=CommonBean.checkForNull(request.getParameter("item_analysis_3"),"%");
				String manufacturer=CommonBean.checkForNull(request.getParameter("manufacturer"),"%");
				String search_criteria=CommonBean.checkForNull(request.getParameter("search_criteria"),"%");
				String search_string=CommonBean.checkForNull(request.getParameter("search_string"),"%");
//				String from			= request.getParameter( "from" )==null?"":request.getParameter( "from" ) ;
//				String to			= request.getParameter( "to" )==null?"":request.getParameter( "to" ) ;
				bean.setCategory(category) ;
				bean.setPs_item(ps_item) ;
				bean.setEff_status(eff_status) ;
				bean.setSpl_item(spl_item) ;
				bean.setsole_source(sole_source) ;
				bean.setCons_item(Cons_item) ;
				bean.setsearchby(searchby) ;
				bean.setItem_code(item_code) ;
				bean.setItem_class(item_class) ;
				bean.setAlpha_code(alpha_code) ;
				bean.setItem_remarks(item_remarks) ;
				bean.setTrade_id(trade_id) ;
				bean.setTrade_name(trade_name) ;
				bean.setShort_desc(short_desc);
				bean.setItem_analysis_1(item_analysis_1) ;
				bean.setItem_analysis_2(item_analysis_2) ;
				bean.setItem_analysis_3(item_analysis_3) ;
				bean.setManufacturer(manufacturer) ;
				bean.setsearch_criteria(search_criteria) ;
				bean.setSearch_string(search_string) ;
				bean.setSearch(search) ;
				bean.setUOM(pur_uom_code) ;
				bean.loadResultPage();
	

		}
		break;
		default :
		out.println("alert(\'Invalid Function\');");
		return;
	}

            _bw.write(_wl_block0Bytes, _wl_block0);

putObjectInBean(bean_id,bean,request);

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
