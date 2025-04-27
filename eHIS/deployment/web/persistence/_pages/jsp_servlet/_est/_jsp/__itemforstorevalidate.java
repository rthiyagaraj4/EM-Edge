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
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __itemforstorevalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/ItemForStoreValidate.jsp", 1719470707213L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n\n";
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

/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
24/05/2017		IN063603			Badmavathi B						GHL-CRF-0456
31/12/2020		TFS-8224           Prabha      31/12/2020		Manickam	  MMS-DM-CRF-0177
---------------------------------------------------------------------------------------------------------
*/

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

request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
		

	String bean_id = request.getParameter("bean_id");
	String bean_name = request.getParameter("bean_name");
	int functionType = Integer.parseInt(request.getParameter("function_type"));
	if ((bean_id == null) || (bean_id.equals("")))
		return;
	ItemForStoreBean bean = (ItemForStoreBean)getBeanObject(bean_id,  bean_name,request );
	bean.setLanguageId(locale);

	Hashtable hash = (Hashtable) XMLobj.parseXMLString(request);
    hash = (Hashtable) hash.get ("SEARCH");
		switch (functionType) {
		case 1: 
			{
				String temp_store_code = "";
				String store_code = (String) hash.get("store_code");
				//String item_code = (String) hash.get("item_code");
				String to_store_code = (String) hash.get("to_store_code");
				if ((store_code == null) && (to_store_code == null)) {
					out.println("errorDisplay();");
					return;
				}
				if (store_code == null) {
					temp_store_code = to_store_code;
					out.println("clearListItems('formItemForStoreMultipleDetail.m_bin_location_code'); ");
				}
				else {
					out.println("setMedicalItem(\"" + bean.getMedicalItem(store_code) + "\"); ");
					temp_store_code = store_code;
					out.println("clearListItems('formItemForStoreSingleDetail.bin_location_code'); ");
				}
				out.println("document.formItemForStoreSingleDetail.stock_item_yn.disabled= "+bean.isNonStockStore(temp_store_code)+";");
				out.println("document.formItemForStoreSingleDetail.stock_item_yn.checked = false;");
				out.println("document.formItemForStoreSingleDetail.bin_location_code.disabled = true;");
				
							ArrayList binLocation = bean.getBinLocations(store_code);
					for(int i=0; i< binLocation.size(); i++) {
						String[] record = (String[])binLocation.get(i);
						if (store_code == null) {
							out.println("addListItem(\"formItemForStoreMultipleDetail.m_bin_location_code\", \"" + record[0] + "\",\"" + record[1] + "\"); ");
						}
						else {
							out.println("addListItem(\"formItemForStoreSingleDetail.bin_location_code\", \"" + record[0] + "\",\"" + record[1] + "\"); ");
						}
					}
					}
			break;
		case 2: //Update single
			{					
				String store_code =(String) hash.get("store_code");
				String item_code = (String) hash.get("item_code");
				ArrayList alPhyInv = new ArrayList() ;
				alPhyInv   = bean.selectInvType(item_code) ;

                HashMap hmTemp = (HashMap)alPhyInv.get(0) ;
				
                ArrayList alTempPhyInv = new ArrayList() ;
				alTempPhyInv.add(bean.checkForNull( (String)hmTemp.get("PHY_INV_TYPE"),"" ));
				alTempPhyInv.add(bean.checkForNull( (String)hmTemp.get("PHY_INV_COUNT_PER_YEAR"),"" ));
			
				hash.put("phy_inv_type",alTempPhyInv.get(0));
				hash.put("phy_inv_count_per_year",alTempPhyInv.get(1));
		                				
				String editing = (String) hash.get("editing");
				if (editing.equals("1") && bean.recordAlreadyExists(store_code,item_code)) {
					out.println("assignResult(false ,getMessage(\"CODE_ALREADY_EXISTS\",'Common'), \"0\");");
					return;
				}
				if (editing.equals("1") && bean.recordsExists(store_code,item_code)) {
					out.println("assignResult(false ,getMessage(\"DUPLICATE_CODE_EXISTS\",'Common'), \"0\");");
					return;
				}
				bean.addSingleRecord(hash);
				out.println("assignResult(true,\"\", \"0\");");
			}
			break;
		case 3:  // Update Multiple
			{
				
				bean.addMultipleRecord(hash);
			}
			break;
		case 4:
		{			out.println("clearListItems('document.formItemForStoreSingleDetail.request_uom'); ");
					out.println("clearListItems('document.formItemForStoreSingleDetail.issue_uom'); ");
					String uom_code = request.getParameter("request_uom");
					String item_code = (String) hash.get("item_code");
			 		ArrayList alEncounterList = bean.getPur_uom_code_List(uom_code,item_code);
					HashMap record	= null;
					for(int i=0; i< alEncounterList.size(); i++) 
					{
					record	=	(HashMap)alEncounterList.get(i);
					String listRecord1	=	(String)record.get("EQVL_UOM_CODE");
					String listRecord2	=	(String)record.get("SHORT_DESC");
					out.println("addListItem(\"document.formItemForStoreSingleDetail.request_uom\", \"" +listRecord1+ "\",\"" +listRecord2+ "\") ; ");
					
					out.println("addListItem(\"document.formItemForStoreSingleDetail.issue_uom\", \"" +listRecord1+ "\",\"" +listRecord2+ "\") ; ");
										}
					//Added for GHL-CRF-0456 starts
					if(!bean.isSalesAllowed(item_code))
					{
						out.println("document.formItemForStoreSingleDetail.sales_allowed_yn.checked = true");
						out.println("document.formItemForStoreSingleDetail.sales_allowed_yn.disabled = false");
					}
					//Added for GHL-CRF-0456 ends
					
					//Added for MMS-DM-CRF-0177
					String pre_alloc_appl_yn = "N";
					String drug_yn = bean.getDrugSearchYN(item_code);
					ArrayList pre_alloc_check = null;
					pre_alloc_check	=	bean.getPreAllocCheck();
					if(pre_alloc_check!=null && pre_alloc_check.size() > 1) {
						pre_alloc_appl_yn	  = pre_alloc_check.get(0)==null?"N":pre_alloc_check.get(0).toString();
						}
					if(pre_alloc_appl_yn.equals("Y") && drug_yn.equals("Y"))
						{
						 	out.println("searchDrugYN();");
						}
					}	
					//Added for MMS-DM-CRF-0177
					
				break; 
		case 5:
		{		
			
			String store_code = (String) hash.get("store_code");
				HashMap hmRecord=bean.fetchRecord(" SELECT dflt_bin_location_code bin_loc_code   FROM		st_store  WHERE store_code = ?", store_code);
				String bin_loc_code=bean.checkForNull((String) hmRecord.get("BIN_LOC_CODE"),"");
				out.println("setBinLocCode('"+bin_loc_code+"');");
					}				
				break;
			default :
			out.println("alert(\'Invalid Function : "+functionType+"\');");
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
