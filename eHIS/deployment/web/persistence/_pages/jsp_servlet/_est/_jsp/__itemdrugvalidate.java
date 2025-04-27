package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eST.Common.*;
import eST.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __itemdrugvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/ItemDrugValidate.jsp", 1719300952469L ,"10.3.6.0","Asia/Calcutta")) return true;
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	
	String locale			= (String)session.getAttribute("LOCALE");

	
	String bean_id					= request.getParameter("bean_id");
	String bean_name				= request.getParameter("bean_name");
	String validate					= request.getParameter("validate");
	String message					= "";
	String flag						= "";
	boolean	result					= false;
	String total					= "";
	String p_ret_value				= "";
	if ((bean_id == null) || (bean_id.equals("")))
		return;
	ItemBean bean = (ItemBean) getBeanObject(bean_id,bean_name,request);
		bean.setLanguageId(locale);
	Hashtable hash = (Hashtable) XMLobj.parseXMLString(request);
    hash = (Hashtable) hash.get ("SEARCH");
	String item_code = (String) hash.get("item_code");
	bean.setItemCode( item_code );
		try {
			if (validate.equals("CHECK_DRUG")) 
			{
				try {
				HashMap addResult = new HashMap();
				addResult = bean.getValidDrug(hash);
				p_ret_value = (String)addResult.get("p_ret_value");
				if(!p_ret_value.equals("1"))
					{
					result	=	false;
					flag	=	"INVALID_DRUG_CODE";
					message	=	"Done";
				}
				}
				catch(Exception e)
				{e.printStackTrace();
				}
			}else if (validate.equals("ORDER_CATALOG")){
				try {
					//HashMap addResult = new HashMap();
					//addResult = bean.getOrderCount(item_code);
					String ord_cat_count = bean.getOrderCount(item_code);
					if(ord_cat_count.equals("0"))
						out.println("f_query_add_mod.document.formItemHeader.mode.value=1;");	
					else
						out.println("f_query_add_mod.document.formItemHeader.mode.value=2;");
					result = true;
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			else{
				try{
 						String sql = bean.getStRepositoryValue("SQL_SM_MODULES_FACILITY_COUNT_VALID");
						ArrayList sqlParam = new ArrayList (2);
						sqlParam.add(bean.getLoginFacilityId());
						sqlParam.add("PH");
						HashMap hmValues = bean.fetchRecord(sql,sqlParam);
						if(hmValues==null) return;
						total =bean.checkForNull((String)hmValues.get("TOTAL"),"");
					} catch( Exception e) {	
					e.printStackTrace();
					}
					boolean drugCanBeEnabled	=	false;
					if(total.equals("1")) {
						HashMap addResult = new HashMap();
						addResult = bean.DrugCheck(hash);
						p_ret_value = (String)addResult.get("p_ret_value");
						out.println("document.formItemHeader.drug_item_indicator.value= '"+p_ret_value+"';");
						if(p_ret_value.equals("S"))
						{
							out.println("document.formItemHeader.drug_desc.value= '"+bean.checkForNull((String) addResult.get("p_drug_desc"),"")+"';");
						out.println("document.formItemHeader.drug_code.value= '"+bean.checkForNull((String) addResult.get("p_drug_code"),"")+"';");
							out.println("document.formItemHeader.drug_desc.disabled='true';");
							out.println("document.formItemHeader.drug_search.disabled='true';");
							out.println("document.formItemHeader.drug_item_yn.checked='true';");
							out.println("document.formItemHeader.drug_item_yn.disabled='true';");
							out.println("document.formItemHeader.spare_part_id.disabled='false';");
										}
						else if(p_ret_value.equals("D"))
						{
							drugCanBeEnabled	=	true;
						}

						else if(p_ret_value.equals("A"))
						{
							out.println("ConfirmBox();");
						}
						else{
						}						
						result	=	true;
						message	=	"Done";
				out.println("document.formItemHeader.drug_code_can_be_enabled.value='"+drugCanBeEnabled+"';");
						return;
					} 
					else
					{	
						drugCanBeEnabled	=	false;
	out.println("document.formItemHeader.drug_code_can_be_enabled.value='"+drugCanBeEnabled+"';");
						return;
					}
			}
			}
			catch ( Exception e1) {
				result	=	false;
				flag	=	"INVALID_ITEM_CODE";
				message	=	e1.getMessage();
				out.println("document.formItemHeader.item_search.disabled='false';");
				out.println("document.formItemHeader.reset();");
				out.println("document.getElementById('td_sale_stk_uom_conv').innerHTML='&nbsp';");
			}
	finally{
		out.println(" assignResult(" + result + ", \"" + message + "\", \"" + flag + "\" ) ; ") ;
	}


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
