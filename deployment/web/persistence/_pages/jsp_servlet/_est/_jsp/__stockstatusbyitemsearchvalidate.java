package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eST.StockStatusByItemBean;
import eCommon.Common.*;
import java.util.Hashtable;
import java.text.NumberFormat;
import java.util.Locale;
import java.text.DecimalFormat;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __stockstatusbyitemsearchvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/StockStatusByItemSearchValidate.jsp", 1720416216977L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n\n";
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
            eST.StockStatusByItemBean obj123= null;{
                obj123=(eST.StockStatusByItemBean)pageContext.getAttribute("obj123");
                if(obj123==null){
                    obj123=new eST.StockStatusByItemBean();
                    pageContext.setAttribute("obj123",obj123);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);

	request.setCharacterEncoding("UTF-8");
	String locale					=		(String)session.getAttribute("LOCALE");
	String bean_id					=		"StockStatusByItemBean";
	String bean_name				=		"eST.StockStatusByItemBean";
	StockStatusByItemBean bean		=		(StockStatusByItemBean) getBeanObject( bean_id, bean_name, request);
	bean.setLanguageId(locale);
	bean.clear();

	Hashtable hash					=		(Hashtable) XMLobj.parseXMLString(request);
    hash							=		(Hashtable) hash.get ("SEARCH");

	String item_code				=		CommonBean.checkForNull(request.getParameter("item_code"),"");
	String store_code				=		CommonBean.checkForNull(request.getParameter("store_code"),"");
	double size						=		Double.parseDouble(CommonBean.checkForNull(request.getParameter("unit_cost"),"0.0"));
	String id_minl					=		request.getParameter("id_minl");
	//Added by Rabbani #INC no : 39203 on  09/04/2013 
	String dflt_facility_id			=		CommonBean.checkForNull(request.getParameter("dflt_facility_id"),"%");
	bean.setLoginFacilityId(dflt_facility_id) ; 
	//ends
	bean.setItem_code(item_code) ;
	if(!store_code.equals(""))
	{
		bean.setStore_code(store_code) ;
	}
	bean.loadData();
	double baseItemUnitCost			=		bean.getBaseUnitCost(item_code);//Added by Sakti against TTM-SCF-0106 to get base uom 
	
	double qty						=		Double.parseDouble(CommonBean.checkForNull(bean.getStock_qty(),"0.0"));
	//double st_val_int				=		qty * size;
	double st_val_int				=		qty * baseItemUnitCost;//Added by Sakti against TTM-SCF-0106 to get base uom unit_cost
	String str_date					=		bean.checkForNull(bean.getLast_issue_date());
	str_date				=	com.ehis.util.DateUtils.convertDate(str_date,"DMY","en",locale);
	java.text.DecimalFormat		df	=		new java.text.DecimalFormat("0.00");
	java.text.DecimalFormat		dff	=		new java.text.DecimalFormat("0.000");
	String st_v						=		df.format(st_val_int);
	
	String baseItemUnitCostst		=		dff.format(baseItemUnitCost);

// Added By Rams 12/15/2009 For the Decimal CRF 537.1 Begins
	/* @Name - Rams
 * @Date - 12/15/2009
 * @Inc# - CRF 537.1
 * @Desc - For the Decimal related display
 */
  /** @Name - Priya
	* @Date - 01/02/2010
	* @Inc# - 15496 (SRR20056-CRF-0537.2)
	* @Desc - To use common method, the previous coding has been removed
	*/
		int no_of_decimals=bean.getNoOfDecimals(); 
	//END

	out.println("document.getElementById('id_stock').innerHTML=\""+(bean.setNumberFormat(bean.checkForNull(bean.getStock_qty(),"0"),no_of_decimals))+"\"");
	out.println("document.getElementById('id_class').innerHTML=\""+bean.checkForNull(bean.getClass_desc())+"\"");
	out.println("document.getElementById('id_recl').innerHTML=\""+NumberFormat.getInstance(new Locale(locale)).format(Double.parseDouble(bean.checkForNull(bean.getReorder_level(),"0")))+"\"");
	out.println("document.getElementById('id_store').innerHTML=\""+(bean.setNumberFormat(bean.checkForNull(bean.getReorder_store(),"0"),no_of_decimals))+"\"");
	out.println("document.getElementById('id_size').innerHTML=\""+NumberFormat.getInstance(new Locale(locale)).format(Double.parseDouble(bean.checkForNull(bean.getPack_size(),"0")))+"\"");
	out.println("document.getElementById('id_lestdate').innerHTML=\""+str_date+"\"");
	out.println("document.getElementById('id_leststore').innerHTML=\""+bean.checkForNull(bean.getLast_issue_store_desc())+"\"");
	out.println("document.getElementById('id_value').innerHTML=\""+NumberFormat.getInstance(new Locale(locale)).format(Double.parseDouble(st_v))+"\"");

	out.println("document.getElementById('id_cost').innerHTML=\""+(bean.setNumberFormat(baseItemUnitCostst,3))+"\""); //Added by Sakti against TTM-SCF-0106 to get base uom unit_cost
	out.println("document.getElementById('id_cost').title=\""+baseItemUnitCost+"\"");
	

	out.println("document.getElementById('id_pstock').innerHTML=\""+NumberFormat.getInstance(new Locale(locale)).format(Double.parseDouble(bean.checkForNull(bean.getQty_primary_store(),"0")))+"\"");
	out.println("document.getElementById('id_locfirst').innerHTML=\""+bean.checkForNull(bean.getBin_location())+"\"");
	out.println("document.getElementById('id_ytdIQty').innerHTML=\""+(bean.setNumberFormat(bean.checkForNull(bean.getYtd_issue_qty(),"0"),no_of_decimals))+"\"");
	out.println("document.getElementById('id_mtdIQty').innerHTML=\""+(bean.setNumberFormat(bean.checkForNull(bean.getMtd_iss_qty(),"0"),no_of_decimals))+"\"");
	out.println("document.getElementById('id_mtdRQty').innerHTML=\""+(bean.setNumberFormat(bean.checkForNull(bean.getMtd_rec_qty(),"0"),no_of_decimals))+"\"");
	out.println("document.getElementById('id_conQty').innerHTML=\""+(bean.setNumberFormat(bean.checkForNull(bean.getYtd_cons_qty(),"0"),no_of_decimals))+"\"");
	out.println("document.getElementById('id_MTDconQty').innerHTML=\""+(bean.setNumberFormat(bean.checkForNull(bean.getMtd_cons_qty(),"0"),no_of_decimals))+"\"");
      //Integer changed as Double for getReorder_store by Rabbani, Inc no :29544 on 16/11/11
	if ((Double.parseDouble(bean.checkForNull(bean.getReorder_store(),"0")) < Integer.parseInt(bean.checkForNull(id_minl,"0"))) || (Double.parseDouble(bean.checkForNull(bean.getReorder_store(),"0")) < Integer.parseInt(bean.checkForNull(bean.getReorder_level(),"0")))){
		if 
	(Double.parseDouble(bean.checkForNull(bean.getReorder_store(),"0")) < Integer.parseInt(bean.checkForNull(id_minl,"0"))) {
	 out.println("document.getElementById('id_Highlight').style.display=\"inline\"");
	 out.println("document.getElementById('id_Highlight').innerHTML=\""+"<img src='../../eST/images/MinStk.gif' >&nbsp;&nbsp;"+"\"");
	}
	if 
	(Double.parseDouble(bean.checkForNull(bean.getStock_qty(),"0")) < Integer.parseInt(bean.checkForNull(bean.getReorder_level(),"0")))
	{
		out.println("document.getElementById('id_Highlight').style.display=\"inline\"");
		out.println("document.getElementById('id_Highlight').innerHTML+=\""+"<img src='../../eST/images/ROL.gif'>"+"\"");
	}
	}else{
		out.println("document.getElementById('id_Highlight').style.display=\"none\"");
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
