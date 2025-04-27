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

public final class __itemvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/ItemValidate.jsp", 1718712923418L ,"10.3.6.0","Asia/Calcutta")) return true;
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
            _bw.write(_wl_block0Bytes, _wl_block0);


request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
//response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
//response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	

	String locale					=		(String)session.getAttribute("LOCALE");
	String bean_id					=		request.getParameter("bean_id");
	String bean_name				=		request.getParameter("bean_name");
	String func_mode				=		(String)request.getParameter("func_mode");
	//String validate				=		request.getParameter("validate");
	String message					=		"";
	String flag						=		"";
	boolean	result					=		false;
	boolean	result1					=		false;
	String sole_source_yn			=		"";
	String ps_item_yn				=		"";
	String inventory_module_scope	=		"";
	//String supplier_desc			=		"";
	String sql1						=		"";
	String gen_uom_code				=		"";
	String eqvl_uom_code			=		"";
	boolean value					=		false;

	if ((bean_id == null) || (bean_id.equals("")))
		return;

	ItemBean bean					=		(ItemBean) getBeanObject(bean_id,bean_name,request);
	bean.setLanguageId(locale);

	Hashtable hash					=		(Hashtable) XMLobj.parseXMLString(request);
    hash							=		(Hashtable) hash.get ("SEARCH");
	String item_code				=		(String) hash.get("item_code");
	bean.setItemCode( item_code );
	if((bean.checkForNull(func_mode)).equals("toolBar")){
       String toolBarString = request.getQueryString() ;
	 //  out.println("alert(\"Before:"+toolBarString+"\")") ;
	   session.removeValue("queryString") ;
       session.putValue( "queryString", toolBarString ) ;

	}
	try {
				try{
						HashMap hmValues			=		bean.getMMInstallationParameter();
						if(hmValues==null) return;
						inventory_module_scope		=		bean.checkForNull((String)hmValues.get("INVENTORY_MODULE_SCOPE"),"");
					} catch( Exception e) {
					e.printStackTrace();}
				
				if(inventory_module_scope.equals("P")) {
				
						sql1						=		bean.getStRepositoryValue("SQL_ST_ITEM_SELECT_INV_P");
					//	SQL_ST_ITEM_SELECT_INV_P_1
					} else {
					
						sql1						=		bean.getStRepositoryValue("SQL_ST_ITEM_SELECT_SINGLE");
					}
						result1						=		bean.checkItemExist();
						out.println(result1);
					if(bean.checkItemExist())
						throw new ItemAlreadyExistsException("ITEM_CODE_ALREADY_EXIST");
					else
					{
						ArrayList arr_lang			=		new ArrayList();
						arr_lang.add(item_code);
						arr_lang.add(locale);
						HashMap hmDefaultValues		=		bean.fetchRecord(sql1,arr_lang);
					
						if(hmDefaultValues==null||hmDefaultValues.size()==0)
							throw new Exception("INVALID_ITEM_CODE");

						String short_desc			=		bean.checkForNull((String) hmDefaultValues.get("SHORT_DESC"),"");
						String long_desc			=		bean.checkForNull((String) hmDefaultValues.get("LONG_DESC"),"");
					
						String short_desc1			=		"";
						for(int k=0; k<short_desc.length(); k++){
							if (short_desc.charAt(k) == '\''){
								short_desc1			=		short_desc1+ "\\"+short_desc.charAt(k);
								}
								else if (short_desc.charAt(k) == '\"'){
								short_desc1			=		short_desc1+ "\\"+short_desc.charAt(k);
								}
								else if (short_desc.charAt(k) == '\\'){
								short_desc1			=		short_desc1+ "\\"+short_desc.charAt(k);
								}
								else
									short_desc1		=		short_desc1 + short_desc.charAt(k);
						}
						String long_desc1			=		"";
						for(int k=0; k<long_desc.length(); k++){
							if (long_desc.charAt(k) == '\''){
									long_desc1			=		long_desc1+ "\\"+long_desc.charAt(k);
								}
								else if (long_desc.charAt(k) == '\"'){
									long_desc1			=		long_desc1+ "\\"+long_desc.charAt(k);
								}
								else if (long_desc.charAt(k) == '\\'){
									long_desc1			=		long_desc1+ "\\"+long_desc.charAt(k);
								}
								else{
									long_desc1		=		long_desc1 + long_desc.charAt(k);
								}
						}
						
						out.println("document.getElementById('td_short_desc').innerText= '"+short_desc1+"';");
						
						out.println("document.getElementById('long_desc').value= '"+long_desc1+"';");
						short_desc					=		bean.checkForNull((String) hmDefaultValues.get("SUPP_SHORT_NAME"),"");
						short_desc1					=		"";
						for(int k=0; k<short_desc.length(); k++){
							if (short_desc.charAt(k) == '\''){
								short_desc1			=		short_desc1+ "\\"+short_desc.charAt(k);
								}else
									short_desc1		=		short_desc1 + short_desc.charAt(k);
						}
						out.println("document.getElementById('td_short_desc').title= '"+short_desc1+"';");
						String solesource_legend		=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SoleSource.label","common_labels");
						String trade_legend				=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Trade.label","common_labels");
						String manufaturer_legend		=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Manufacturer.label","common_labels");
						String stockuom_legend			=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.StockUOM.label","common_labels");
						String ConversionFactor_legend	=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ConversionFactor.label","common_labels");
						String PSItem_legend			=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMM.PharmacyStockItem.label","mm_labels");
						sole_source_yn					=		bean.checkForNull((String)hmDefaultValues.get("SOLE_SOURCE_YN"),"N");

						if (sole_source_yn.equals("Y")) {
							
							out.println("document.getElementById('td_sole_source_yn').innerHTML =\"&nbsp;"+solesource_legend+" <img align='center' src=\'../../eCommon/images/enabled.gif\'></img>\";");
							out.println("document.getElementById('td_trade_id_applicable_yn').innerHTML =\""+trade_legend+" <img align='center' src=\'../../eCommon/images/disabled.gif\'></img>\";");
							out.println("document.getElementById('td_manufacturer').innerHTML=\""+manufaturer_legend+"<b> "+hmDefaultValues.get("SHORT_NAME")+"</b>\";");
							out.println("document.formItemHeader.spare_part_id.disabled='false';");
							out.println("document.formItemHeader.machine_code.disabled='true';");
						} else {
							out.println("document.getElementById('td_sole_source_yn').innerHTML =\"&nbsp;"+solesource_legend+" <img align='center' src=\'../../eCommon/images/disabled.gif\'></img>\";");
							out.println("document.getElementById('td_trade_id_applicable_yn').innerHTML =\""+trade_legend+" <img align='center' src=\'../../eCommon/images/enabled.gif\'></img>\";");
							out.println("document.formItemHeader.trade_id_applicable_yn.value='Y';");
							out.println("document.formItemHeader.mfg_item_yn.disabled='true';");
						}
						ps_item_yn						=		bean.checkForNull((String)hmDefaultValues.get("PS_ITEM_YN"),"N");

						if(ps_item_yn.equals("Y")) {
							out.println("document.getElementById('td_ps_item_yn').innerHTML =\""+PSItem_legend+"<img align='center' src=\'../../eCommon/images/enabled.gif\'></img>\";");
							out.println("document.formItemHeader.machine_code.disabled=true;");
							out.println("document.formItemHeader.medical_item_yn.checked=true;");
							out.println("document.formItemHeader.medical_item_yn.disabled=true;");
							out.println("document.formItemHeader.drug_item_yn.disabled=false;");
							out.println("document.formItemHeader.spare_part_id.disabled=false;");	
							out.println("DrugCheck();");	   
						} else {
							out.println("document.formItemHeader.medical_item_yn.disabled=false;");
							out.println("document.getElementById('td_ps_item_yn').innerHTML =\""+PSItem_legend +"<img align='center' src=\'../../eCommon/images/disabled.gif\'></img>\";");
							out.println("document.formItemHeader.machine_code.disabled=false;");
							out.println("document.formItemHeader.spare_part_id.disabled='true';");
									}
						out.println("document.getElementById('td_gen_uom_code').innerHTML ='"+stockuom_legend +"<b > "+hmDefaultValues.get("UOM_DESC")+"</b>';");

						eqvl_uom_code					=		(String)hmDefaultValues.get("GEN_UOM_CODE");
						out.println("clearListItems('document.formItemHeader.repacking_uom');");

						String chkParameters[]			=		{eqvl_uom_code,locale,eqvl_uom_code,locale};
						ArrayList alRecords1			=		new ArrayList();
						try
						{
						 alRecords1						=		bean.fetchRecords(bean.getStRepositoryValue("SQL_ST_ITEM_UOM_SELECT_LIST"),chkParameters);
						}
						catch (Exception e1)
						{	
							System.err.println("Error occured in Item Validate = "+e1);
						}
							HashMap hmRecord			=	null;
							for (int i=0;i<alRecords1.size();i++){
							hmRecord					=	(HashMap)alRecords1.get(i);

							out.println("addListItem(\"document.formItemHeader.repacking_uom\",\""+hmRecord.get("EQVL_UOM_CODE")+"\",\""+hmRecord.get("SHORT_DESC")+"\",\""+eqvl_uom_code+"\");" );
							if(gen_uom_code.equals(hmRecord.get("eqvl_uom_code")))
								value					=			true;			
								}
							gen_uom_code				=			(String)hmDefaultValues.get("GEN_UOM_CODE");
							if(!(gen_uom_code==null || gen_uom_code.equals("")))
							{
								out.println("document.formItemHeader.item_gen_uom_code.value='"+gen_uom_code+"';");
								out.println("clearListItems('document.formItemHeader.sale_uom');");
								ArrayList arr_lang1		=			new ArrayList();
								arr_lang1.add(locale);
								ArrayList alRecords		=			bean.fetchRecords(bean.getStRepositoryValue("SQL_ST_AM_UOM_SELECT"),arr_lang1);
								for (int i=0;i<alRecords.size();i++){
								hmRecord		=			(HashMap)alRecords.get(i);
								if (gen_uom_code.equals("")){
								}
								out.println("addListItem(\"document.formItemHeader.sale_uom\",\""+hmRecord.get("UOM_CODE")+"\",\""+hmRecord.get("SHORT_DESC")+"\",\""+gen_uom_code+"\");" );
								if(gen_uom_code.equals(hmRecord.get("UOM_CODE")))
								value					=		true;			
							}
								if(value)
								out.println("document.getElementById('td_sale_stk_uom_conv').innerText='"+ConversionFactor_legend +" 1';");
						}
						result	=	true;
						message	=	"Done";
						return;
					}
			}
			catch (ItemAlreadyExistsException exception) {
				result	=	false;
				message	=	exception.getMessage();
				flag	=	exception.getMessage();
				out.println("document.formItemHeader.item_search.disabled='false';");
			}
			catch (Exception ex) {
				result	=	false;
				message	=	ex.getMessage();
				flag	=	ex.getMessage();
				//out.println("document.formItemHeader.item_search.disabled='false';");
				//out.println("document.formItemHeader.reset();");
				//out.println("document.getElementById("td_sale_stk_uom_conv").innerHTML='&nbsp';");
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
