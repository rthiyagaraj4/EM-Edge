package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import ePH.Common.*;
import ePH.*;
import eST.*;
import eST.Common.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __formularyvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/FormularyValidation.jsp", 1742369660403L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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
        response.setHeader("Content-Type", "text/html;charset=ISO-8859-1 ");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=ISO-8859-1 ");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
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
		String called_from			= request.getParameter("called_from");
		Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
		hash						= (Hashtable)hash.get( "SEARCH" ) ;
		String bean_id				= (String) hash.get( "bean_id" );
		String bean_name			= (String) hash.get( "bean_name" );
		//System.err.println("FormularyValidation.jsp======================>");
		if(called_from != null && called_from.equals("getFormNames" ) ){
			String generic_id					= (String) hash.get("generic_id");
			String bean_id1					= (String) hash.get("bean_id");
			String bean_name1					= (String) hash.get("bean_name");
			FormularyBillingGroupBean bean = (FormularyBillingGroupBean)getBeanObject( bean_id1, bean_name1, request ) ;
			ArrayList formNames	= bean.getFormNames(generic_id);
				//System.err.println("formNames==>"+formNames+"==generic_id==>"+generic_id);
			if(formNames.size()>0){
				String form_code="";
				String form_desc="";
				for(int i=0;i<formNames.size();i=i+2){
				form_code = (String)formNames.get(i);
				form_desc = (String)formNames.get(i+1);
				//System.err.println("form_code==>"+form_code+"==form_desc==>"+form_desc);
				out.println("addFormNameList('"+form_code+"','"+form_desc+"')");
				}
				out.println("changeForm(document.formulary_drug_search.form_name)");
			}
		putObjectInBean(bean_id1,bean,request);			
		
		}else if(called_from != null && called_from.equals("getStrengthValues" ) ){
			String generic_id				= (String) hash.get("generic_id");
			String bean_id1					= (String) hash.get("bean_id");
			String bean_name1				= (String) hash.get("bean_name");
			String form_code				= (String) hash.get("form_code");
			FormularyBillingGroupBean bean = (FormularyBillingGroupBean)getBeanObject( bean_id1, bean_name1, request ) ;
			ArrayList stregthValues	= bean.getStrengthValues(generic_id,form_code);
			//System.err.println("stregthValues====>"+stregthValues);
			if(stregthValues.size()>0){

				String form_desc="";
				String strength_value = "";
				String strength_uom	  = "";
				String uom_desc		  = "";
				String strength_desc  = "";
				for(int i=0;i<stregthValues.size();i=i+3){
				strength_value = (String)stregthValues.get(i);
				strength_uom = strength_value+"~"+(String)stregthValues.get(i+1);
				uom_desc	 = (String)stregthValues.get(i+2);
				strength_desc = strength_value+" "+uom_desc ;
				out.println("addStrengthValueList('"+strength_uom+"','"+strength_desc+"')");
				}

			}
		putObjectInBean(bean_id1,bean,request);
		}else if(called_from != null && called_from.equals("saveBlgGroupID")){
			String blg_grp_id				= (String) hash.get("blg_grp_id");
			String bean_id1					= (String) hash.get("bean_id");
			String bean_name1				= (String) hash.get("bean_name");
			String checked_yn				= (String) hash.get("checked_yn");
			FormularyBillingGroupBean bean = (FormularyBillingGroupBean)getBeanObject( bean_id1, bean_name1, request ) ;
			 ArrayList slectedBlgGrpID = bean.getselectedFormularyBLGId();
			if(slectedBlgGrpID == null && slectedBlgGrpID.size()==0)
			 bean.setselectedFormularyBLGId(blg_grp_id,"Y");
			else{
				if(checked_yn.equals("Y")){
					if(!slectedBlgGrpID.contains(blg_grp_id))
						bean.setselectedFormularyBLGId(blg_grp_id,"Y");
				}else{
						bean.setselectedFormularyBLGId(blg_grp_id,"N");
				}

			}
			
 

		putObjectInBean(bean_id1,bean,request);
		}else if(called_from != null && called_from.equals("setBillingGrp")){
			String bean_id1					= (String) hash.get("bean_id");
			String bean_name1				= (String) hash.get("bean_name");
			String billing_type				= (String) hash.get("billing_type");
			FormularyBillingGroupBean bean = (FormularyBillingGroupBean)getBeanObject( bean_id1, bean_name1, request ) ;
			//System.err.println("billing_type=====>"+billing_type);
			bean.setBillingType(billing_type);			
 

		putObjectInBean(bean_id1,bean,request);
		}else if(called_from != null && called_from.equals("saveSelectedItem" ) ){
			String generic_id				= (String) hash.get("generic_id");
			String bean_id1					= (String) hash.get("bean_id");
			String bean_name1				= (String) hash.get("bean_name");
			String tot_rec					= (String) hash.get("total_rec");
			String generic_name				= (String) hash.get("generic_name");
			String item_type				= (String) hash.get("item_type");
			String generic_name_key			= (String) hash.get("generic_name_key");
			generic_name_key = java.net.URLDecoder.decode(generic_name_key,"UTF-8");//GHL-SCF-1533
			String form_code				= (String) hash.get("form_code");
			String save_type				= (String) hash.get("save_type");
			ArrayList preferenceItem  = new ArrayList();
			FormularyBillingGroupBean bean = (FormularyBillingGroupBean)getBeanObject( bean_id1, bean_name1, request ) ;
			if(save_type.equals("A")){
				for(int i=1; i<Integer.parseInt(tot_rec); i++) {
					preferenceItem.add(generic_id);
					preferenceItem.add(generic_name);
					preferenceItem.add(item_type);
					preferenceItem.add((String) hash.get("item_code_"+i));
					preferenceItem.add((String) hash.get("item_desc_"+i));
					preferenceItem.add(form_code);
					preferenceItem.add(java.net.URLDecoder.decode((String) hash.get("form_name_"+i),"UTF-8"));//GHL-SCF-1533
					preferenceItem.add((String) hash.get("strength_txt_"+i));
					preferenceItem.add((String) hash.get("route_code_"+i));
					preferenceItem.add((String) hash.get("route_"+i));
					preferenceItem.add((String) hash.get("preference_item_"+i));
					preferenceItem.add((String) hash.get("unit_price_"+i));
					preferenceItem.add((String) hash.get("strength_"+i));
					preferenceItem.add((String) hash.get("strength_uom_"+i));
					
				}
			bean.setSelectedGenericID(generic_name_key,preferenceItem);
			
			
//System.err.println("FormularyValidation.jsp===dssd===preferenceItem=====77==>"+preferenceItem+"===>"+item_type);
			if(item_type!=null && item_type.equals("D")){
				ArrayList genericNameForDrug = bean.getGenericNameForDrug();
				if(genericNameForDrug!=null && genericNameForDrug.size()>0)
				{
					if(!genericNameForDrug.contains(generic_name_key)){
						bean.setGenericNameForDrug(generic_name_key);
					}
				}else{
						bean.setGenericNameForDrug(generic_name_key);
				}
			}
			else{
					ArrayList genericNameForMedicalItem = bean.getGenericNameForMedicalItem();
					
					if(genericNameForMedicalItem!=null && genericNameForMedicalItem.size()>0)
					{
						if(!genericNameForMedicalItem.contains(generic_name_key)){
							bean.setGenericNameForMedicalItem(generic_name_key);
						}
					}else{
							bean.setGenericNameForMedicalItem(generic_name_key); 
					}
 				}
			}else{
				 if(bean.getSelectedGenericID().containsKey(generic_name_key)){
					bean.getSelectedGenericID().remove(generic_name_key);
				 }
				 if(bean.getGenericNameForMedicalItem().contains(generic_name_key)){
					bean.getGenericNameForMedicalItem().remove(generic_name_key);
				 }

				 if(bean.getGenericNameForDrug().contains(generic_name_key)){
					 bean.getGenericNameForDrug().remove(generic_name_key);
				 }
			}
			
			ArrayList itemGenericType = bean.getItemGenericType();
			
			if(itemGenericType!=null && itemGenericType.size()>0){
				if(!itemGenericType.contains(item_type))
					bean.setItemGenericType(item_type);
			}else{
				bean.setItemGenericType(item_type);
			}
				out.println("closeWindow('"+save_type+"','"+generic_id+"')");
			
		putObjectInBean(bean_id1,bean,request);
		}else if(called_from != null && called_from.equals("checkDuplicate")){
			String bean_id1					= (String) hash.get("bean_id");
			String bean_name1				= (String) hash.get("bean_name");
			String formulary_code			= (String) hash.get("formulary_code");
			FormularyBillingGroupBean bean = (FormularyBillingGroupBean)getBeanObject( bean_id1, bean_name1, request ) ;
			//System.err.println("billing_type=====>"+billing_type);
			boolean formular_dup_flag= bean.checkDuplicate(formulary_code);			

			if(formular_dup_flag){
			out.println("duplicateFormularyAlert()");
			}
 

		putObjectInBean(bean_id1,bean,request);
		} 

	}
	catch (Exception e) {
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
