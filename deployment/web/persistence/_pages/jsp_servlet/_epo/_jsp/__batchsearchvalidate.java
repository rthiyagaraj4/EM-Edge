package jsp_servlet._epo._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eST.BatchSearchBean;
import java.util.HashMap;
import java.util.ArrayList;
import java.lang.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __batchsearchvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ePO/jsp/BatchSearchValidate.jsp", 1732509898115L ,"10.3.6.0","Asia/Calcutta")) return true;
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            eST.BatchSearchBean obj7= null;{
                obj7=(eST.BatchSearchBean)pageContext.getAttribute("obj7");
                if(obj7==null){
                    obj7=new eST.BatchSearchBean();
                    pageContext.setAttribute("obj7",obj7);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

		request.setCharacterEncoding("UTF-8");
		String locale					=	 (String)session.getAttribute("LOCALE");
		int functionType				=	Integer.parseInt(request.getParameter("function_type"));

		String bean_id					=	"batchSearchBean";
		String bean_name				=	"eST.BatchSearchBean";

		BatchSearchBean bean			=	(BatchSearchBean) getBeanObject( bean_id,bean_name,request);  
		bean.setLanguageId(locale);

		Hashtable hash					=	(Hashtable) XMLobj.parseXMLString(request);
		hash							=	(Hashtable) hash.get ("SEARCH");
	switch (functionType) {
	case 1:
		{
				String item_code_from				=		CommonBean.checkForNull(request.getParameter("item_code_from"),"");
				String item_code_to					=		CommonBean.checkForNull(request.getParameter("item_code_to"),"");
				String store_code_from				=		CommonBean.checkForNull(request.getParameter("store_code_from"),"");
				String store_code_to				=		CommonBean.checkForNull(request.getParameter("store_code_to"),"");
				String manufacturer_code			=		CommonBean.checkForNull(request.getParameter("manufacturer_code"),"");
				String period_of_expiry				=		CommonBean.checkForNull(request.getParameter("period_of_expiry"),"");
				String includeZeroStockBatches		=		CommonBean.checkForNull(request.getParameter("includeZeroStockBatches"),"N");
				String includeExpiredBatches		=		CommonBean.checkForNull(request.getParameter("includeExpiredBatches"),"N");
				String includeSuspendedBatches		=		CommonBean.checkForNull(request.getParameter("includeSuspendedBatches"),"N");
				String batch_id						=		CommonBean.checkForNull(request.getParameter("batch_id"),"")+"%";
				String Trade_code					=		CommonBean.checkForNull(request.getParameter("Trade_code"),"")+"%";
				String doc_type_code				=		CommonBean.checkForNull(request.getParameter("doc_type_code"),"");
				String doc_no						=		request.getParameter("doc_no");
				String trn_type						=		request.getParameter("trn_type");
				String item_class_from				=		CommonBean.checkForNull(request.getParameter("item_class_from"),"");
				String item_class_to				=		CommonBean.checkForNull(request.getParameter("item_class_to"),"");
				String drug_type				=		CommonBean.checkForNull(request.getParameter("drug_type"),"%");
			   				
				out.println(includeZeroStockBatches+"/"+includeExpiredBatches+"/"+includeSuspendedBatches);
				bean.setIncludeSuspendedBatches(includeSuspendedBatches) ;
				bean.setIncludeZeroStockBatches(includeZeroStockBatches) ;
				bean.setIncludeExpiredBatches(includeExpiredBatches) ;
				bean.setItem_code_from(item_code_from) ;
				bean.setItem_code_to(item_code_to) ;
				bean.setStore_code_from(store_code_from) ;
				bean.setStore_code_to(store_code_to) ;
				bean.setManufacturer_code(manufacturer_code) ;
				bean.setPeriod_of_expiry(period_of_expiry) ;
				bean.setBatch_id(batch_id) ;
				bean.setTrade_Code(Trade_code) ;
				bean.setItemClassFrom(item_class_from) ;
				bean.setItemClassTo(item_class_to) ;
				bean.setDrugType(drug_type) ;
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
			bean.clear();
			String index					=		request.getParameter( "index" )==null?"":request.getParameter( "index" ) ;
			String noOfCheckedRecords		=		request.getParameter( "noOfCheckedRecords" )==null?"":request.getParameter( "noOfCheckedRecords" ) ;
			//Build an AL of selected batches
			bean.selectedBatches(index,noOfCheckedRecords);
			
		}
		case 5:
		{
		
		String item_code_from = request.getParameter("item_code_from");
		
		String item_code_to = bean.checkForNull(request.getParameter("item_code_to"),request.getParameter("item_code_from"));

		System.out.println("item_code_to===84===>"+item_code_to);

		String p_list_all_trades_yn = request.getParameter("p_list_all_trades_yn");
		
		 if(!(item_code_from.equals("")) || (!(item_code_to.equals("")))){
		
		out.println("clearListItems('document.BatchSearchCriteria_Form.Trade_code"+p_list_all_trades_yn+"'); ");
        
		 ArrayList TradeIdArraylist=new ArrayList();
		 
		 TradeIdArraylist=bean.getTradeList(item_code_from,item_code_to);
		 
		   if (TradeIdArraylist!=null && TradeIdArraylist.size()>0)
					{
						HashMap record			= null;
						for(int i=0; i< TradeIdArraylist.size(); i++) 
						{
							record			=		(HashMap)TradeIdArraylist.get(i);
							String listRecord1		=		bean.checkForNull((String)record.get("TRADE_ID"));
							String listRecord2		=		bean.checkForNull((String)record.get("SHORT_NAME"));
		     		out.println("addListItem(\"document.BatchSearchCriteria_Form.Trade_code\", \"" +listRecord1+ "\",\"" +listRecord2+ "\") ; ");
				
				    }//End Of For
     							
				}//End Of 2nd Condition
		 
		 }else      //It is if the user clears the Items in the Criteria 
			{
             ArrayList TradeIdArraylist=new ArrayList();
			TradeIdArraylist=bean.getTradeList("","");
			out.println("clearListItems('document.BatchSearchCriteria_Form.Trade_code"+p_list_all_trades_yn+"'); ");
			if (TradeIdArraylist!=null && TradeIdArraylist.size()>0)
					{
						HashMap record			= null;
						for(int i=0; i< TradeIdArraylist.size(); i++) 
						{
							record			=		(HashMap)TradeIdArraylist.get(i);
							String listRecord1		=		bean.checkForNull((String)record.get("TRADE_ID"));
							String listRecord2		=		bean.checkForNull((String)record.get("SHORT_NAME"));
		     		out.println("addListItem(\"document.BatchSearchCriteria_Form.Trade_code\", \"" +listRecord1+ "\",\"" +listRecord2+ "\") ; ");
				
				    }
     							
				}
				
			}

		}
		break;

		default :
		out.println("alert(\'Invalid Function\');");
		return;
	}

            _bw.write(_wl_block1Bytes, _wl_block1);

	putObjectInBean(bean_id,bean,request);

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
