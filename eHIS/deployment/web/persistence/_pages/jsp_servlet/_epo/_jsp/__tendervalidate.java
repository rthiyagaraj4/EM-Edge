package jsp_servlet._epo._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import ePO.*;
import ePO.Common.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __tendervalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ePO/jsp/TenderValidate.jsp", 1741325957862L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="  \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block3Bytes, _wl_block3);

	request.setCharacterEncoding("UTF-8");
	String locale			=		(String)session.getAttribute("LOCALE");
    String check_status		=		request.getParameter("check_status");
    String stitem_code		=		request.getParameter("item_code");
	String bean_id			=		request.getParameter("bean_id");
	String bean_name		=		request.getParameter("bean_name");
    String functionType		=		request.getParameter("function_type");
	String supplier 		=  		request.getParameter("supplier");
	String dflt_currency 	=       "";
	String commit_code 		=  		request.getParameter("commit_code");
	String department_id    =  		request.getParameter("dept_id");
	String acc_number 	    =  		request.getParameter("acc_no");
	String acc_desc     	=       "";
	String uom_code 	    =  		request.getParameter("uom_code");
	String commt_code 	    =  		request.getParameter("commt_code");
	String dept_code		=		request.getParameter("dept_code");
	String uom_desc			=		"";
	String commt_desc 		=		"";
	int	index = 0;
	String mode				=		request.getParameter("mode");

	if ((bean_id == null) || (bean_id.equals("")))
		return;

	TenderBean bean		=		(TenderBean) getBeanObject(bean_id, bean_name, request  );
	bean.setLanguageId(locale);

	Hashtable hash			=		(Hashtable) XMLobj.parseXMLString(request);
    hash					=		(Hashtable) hash.get ("SEARCH");
	boolean result			=		false;
	boolean result1			=		false;
	String message			=		"";
	String flag				=		"";
	
	if(functionType.equals("UPDATEREMARKS")){		   
			bean.updateRemarks(hash);
	}
	else if(functionType.equals("UPDATERECOMREMARKS")){		   
			bean.updateRecomRemarks(hash);
	}	
	else if(functionType.equals("UPDATECONTACTDETAILS")){
		try{
			String sp_code = request.getParameter("supp_code");
			String count = request.getParameter("count");
			ArrayList con_dtls = (ArrayList)bean.fetchRecords("SELECT CONTACT_NAME_PUR,TEL_NUM,EMAIL_ID FROM ap_supplier where SUPP_CODE = ?",new String[]{sp_code});
			for(int i=0;i<con_dtls.size();i++){
				HashMap hm = (HashMap)con_dtls.get(i);
				out.println("document.getElementById('contact_person_')" + count + ".value = '" +  bean.checkForNull((String)hm.get("CONTACT_NAME_PUR")) +"'; ");
				out.println("document.getElementById('contact_number_')" + count + ".value = '" +  bean.checkForNull((String)hm.get("TEL_NUM")) +"'; ");
				out.println("document.getElementById('email_id_')" + count + ".value = '" +  bean.checkForNull((String)hm.get("EMAIL_ID")) +"'; ");
			
			}
				result = true;
						
			}catch(Exception e){
				result		=	false;
				message		=	e.getMessage();
				e.printStackTrace();
		}finally {
			out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
		}
	
	}
	else if(functionType.equals("LOADTRADEID")){
		
		String item_code = request.getParameter("item_code");
		String trd_id 	 = bean.checkForNull((String)request.getParameter("trd_id"));			
		
		String trade_id_applicable_yn = bean.checkForNull((String)bean.fetchRecord("select TRADE_ID_APPLICABLE_YN from st_item where item_code = ?",item_code).get("TRADE_ID_APPLICABLE_YN"),"Y");
		
		out.println("clearListItems('formTenderDetail.trade_id'); ");
		
		if(trade_id_applicable_yn.equals("Y")){
			ArrayList chkParameters=new ArrayList();
				chkParameters.add(item_code);
				chkParameters.add(bean.getLanguageId());
			
			int cnt = Integer.parseInt(bean.checkForNull((String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_ST_TRADE_DETAILS_COUNT"),chkParameters).get("TRADE_ID"),"0"));
					
				if(cnt == 1 && mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))){// 41601 by Ganga					
					trd_id		=	(String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_ST_TRADE_DETAILS"),chkParameters).get("TRADE_ID");				
				}
			
			ArrayList trade_name = bean.getTrade_id_List(item_code);
			
			HashMap record = new HashMap();
			
			for(int i=0; i< trade_name.size(); i++) {
				record = (HashMap)trade_name.get(i);
				out.println("addListItem(\"formTenderDetail.trade_id\", \"" + record.get("TRADE_ID") + "\",\"" + record.get("SHORT_NAME") + "\",\"" +trd_id+ "\");");
			}
		}else{
			HashMap MMParameter = bean.MMParameters();
			String default_trade_id = (String)MMParameter.get("DFLT_TRADE_ID");			
			String default_trade_name = bean.getTradeName(default_trade_id);
			if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))){
				out.println("addListItem(\"formTenderDetail.trade_id\", \"" + default_trade_id + "\",\"" + default_trade_name + "\",\"" +default_trade_id+ "\");");
			}else{
				out.println("addListItem(\"formTenderDetail.trade_id\", \"" + default_trade_id + "\",\"" + default_trade_name + "\",\"" +trd_id+ "\");");
			}
		}	
	}
	else if(functionType.equals("GETUOMDESC")){
		HashMap hmRecord = bean.getUomDesc(uom_code);
			if(hmRecord.size()>0){
				uom_desc = (String)hmRecord.get("SHORT_DESC");
			}
		out.println("document.getElementById('temp_delv_uom_code').value = '" +  uom_code +"'; ");
		out.println("document.getElementById('temp_delv_uom_desc').value = '" +  uom_desc +"'; ");
			
	}
	else if(functionType.equals("SETADDITIONALDETAILS")){
			try{			
				String tender_remarks = request.getParameter("tender_remarks");
				String expiry_date = request.getParameter("expiry_date");
				String approval_date = request.getParameter("approval_date");
				String contract_date = request.getParameter("contract_date");
				
                bean.setTender_remarks(tender_remarks);
				bean.setExpiry_date(expiry_date);
				bean.setApproval_date(approval_date);
				bean.setContract_date(contract_date);
								 
				result = true;
		
			}catch(Exception e){
				result		=	false;
				message		=	e.getMessage();
				e.printStackTrace();
		}finally {
			out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
		}
	}	
	else if(functionType.equals("SETITEMVALUES")){
			try{
				
				String item_remarks = request.getParameter("item_remarks");
				//out.println("PODetailFrame.formPurchaseOrderDetail.item_remarks.value = '"+bean.checkForNull(item_remarks,"")+"';");
				out.println("document.forms[0].item_remarks.value = '"+bean.checkForNull(item_remarks,"")+"';");
                				 
				result = true;
		
			}catch(Exception e){
				result		=	false;
				message		=	e.getMessage();
				e.printStackTrace();
		}finally {
			out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
		}
	}
	else if(functionType.equals("SETDELIVERYVALUES")){
	 	try{
            bean.updateDeliveryRecords(stitem_code, hash);
 			result = true;
		
			}catch(Exception e){
				result		=	false;
				message		=	e.getMessage();
				e.printStackTrace();
		}finally {
			out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
		}
	}
	
	else if(functionType.equals("SETMOREITEMVALUES")){
	 	try{
			bean.updateItemRecords(stitem_code, hash);					
			result = true;		
			}catch(Exception e){
				result		=	false;
				message		=	e.getMessage();
				e.printStackTrace();
		}finally {
			out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
		}
	}
	
	else if(functionType.equals("SETSELECTIONCRITERIAVALUES")){
	 	try{
			bean.updateSelectionCriteriaRecords(stitem_code, hash);					
			result = true;		
			}catch(Exception e){
				result		=	false;
				message		=	e.getMessage();
				e.printStackTrace();
		}finally {
			out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
		}
	}
	else if(functionType.equals("SETSUPPLIERVALUES")){
	 	try{	 
			bean.updateSupplierRecords(hash);					
			result = true;
		
			}catch(Exception e){
				result		=	false;
				message		=	e.getMessage();
				e.printStackTrace();
		}finally {
			out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
		}
	}
	else if(functionType.equals("ADDITEMRECORD")){
			try {
				try {
			
					String item_code	= request.getParameter("item_code");
					String itm_cd	= request.getParameter("itm_cd");
					String po_no	= request.getParameter("po_no");
					String delv_date	= request.getParameter("delv_date");
					String request_no	= request.getParameter("request_no");
					
					String item_code1 = "";
					if(po_no!=""){
						item_code1 = item_code+po_no+delv_date+request_no;						
					}else{
						item_code1 = item_code;
					}
				result = false;	
				}catch (Exception exception) {
					exception.printStackTrace();

					if (exception.getMessage().equals("RECORD_ALREADY_EXISTS"))
						throw exception;
					if (exception.getMessage().equals("PHY_INV_PROCESS_INITIATED"))
						throw exception;

					throw new Exception("REQ_ON_ITEM_STORE_NOT_FOUND");
				}
			}
			catch (Exception exception) {
				result		=	false;
				message		=	exception.getMessage();
				exception.printStackTrace();
			}
			finally{
				out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
			}

		} 
		
		else if (functionType.equals("MODIFYMODE")){
				HashMap addResult = bean.addDetailRecordModifyMode(hash);				
				out.println("assignResult("+addResult.get("result")+",\""+addResult.get("message")+"\", \"0\");");
		}else if(functionType.equals("EDITING")){			
				HashMap addResult = bean.addDetailRecord(hash);
				out.println("assignResult("+addResult.get("result")+",\""+addResult.get("message")+"\", \"0\");");
				putObjectInBean(bean_id,bean,request);
		}
		
		else if(functionType.equals("UPDATECHECKSTATUS")){
                ArrayList alItemKeys = new ArrayList();

				for(int i=0;i<bean.getItemKeys().size();i++) {
			      alItemKeys.add(bean.getItemKeys().get(i));	
		         } 
				
				java.util.ArrayList newKeys = bean.getItemKeysAdded();

				if (newKeys != null && newKeys.size() >0) {
					alItemKeys.addAll(newKeys);
				}

				HashMap hmItemStore = (HashMap)bean.getHmItemDetail();
				
				String itemStoreKey = "";

				if (alItemKeys != null && (alItemKeys.size()>0)) {
					int totalSize = alItemKeys.size();
					TenderDetailBean detailBean;
					for (int i=0;	i<totalSize;	i++){
						itemStoreKey = (String) alItemKeys.get(i);
						detailBean = (TenderDetailBean)hmItemStore.get(itemStoreKey);
						if(itemStoreKey.equals(stitem_code)){
							
							detailBean.setCheck_box_status(check_status);
                            hmItemStore.remove(itemStoreKey);
                            hmItemStore.put(itemStoreKey,detailBean);
                            bean.setHmItemDetail(hmItemStore);
						
							break ;
						}

					}//end of For loop
				}//end of if condition
              
		} else if(functionType.equals("MM_UOM")){

			String def_uom_code = (String)bean.fetchRecord("select gen_uom_code from mm_item where item_code= ?" ,bean.checkForNull(stitem_code)).get("GEN_UOM_CODE");			
					
			HashMap hmRecord = bean.getUomDesc(def_uom_code);			
			
			if(hmRecord.size()>0){
				uom_desc = (String)hmRecord.get("SHORT_DESC");
			}
			
			if(!uom_desc.equals("")){
				out.println("document.formTenderDetail.tender_uom.value='"+bean.checkForNull(def_uom_code)+"'");			
				out.println("document.getElementById('temp_delv_uom_code').value='"+bean.checkForNull(def_uom_code)+"'");
				out.println("document.getElementById('temp_delv_uom_desc').value = '" +  uom_desc +"'; ");
			}
			
			
			out.println("checkUOMConvFactor();");

		} else if (functionType.equals("PRINTONLINEDOC")){
			try{
			
			ArrayList doc_no=bean.getPrintDocNo();
			
			String pdocno = "";
			for(int i=0;i<doc_no.size();i++){
				pdocno=(String)doc_no.get(i);
				bean.doOnlineReportPrinting(pdocno,request,response);	
			}
			}catch(Exception e){
					e.printStackTrace();
			}
			result =  true;
			message = request.getParameter("msg");
		}else if(functionType.equals("CHECKFORAUTHORIZE"))
		{
			String request_by_pu = (String) hash.get("request_by_pu");
			if (request_by_pu != null && request_by_pu.trim().equals("")) {
				out.println("errorDisplay();");
				return;
			}
			
			java.util.HashMap resultMap = bean.canAuthorize(request_by_pu);
			
			if (resultMap != null) {
				String authorize = (String)resultMap.get("TNDR_APPROVE_ALLOWED_YN");  
				
				if(authorize != null && authorize != ""){	
				if (authorize.equals("Y")) {
					authorize = "Yes";
				}
				else {
					authorize = "No";
				}
				}else{
					authorize = "No";
				}
				out.println("setAuthorize('"+authorize+"');");
				
			}
		}		
		else if(functionType.equals("CHECK_REQ_KEY")){
			
			try{				
				if(bean.getReqKeys().size() > 0){
					result=true;
			    }else{
					result = false;
				}
			}catch (Exception exception) {
			result		=	false;
			message		=	exception.getMessage();
			exception.printStackTrace();
		}finally{
		out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
		}
		}
	else  if(functionType.equals("CHECKUOMCONVFACTOR")) {

			
		try{
			try { 
				//String uom_code		= request.getParameter("uom");
				String pur_uom_code = request.getParameter("pur_uom_code");
				String item_code = request.getParameter("item_code");

				int am_count=Integer.parseInt((String)bean.fetchRecord("SELECT  count(*) count  FROM am_uom_eqvl WHERE uom_code = ? AND eqvl_uom_code = ?",new String[]{pur_uom_code,uom_code}).get("COUNT"));
				int item_uom_count=Integer.parseInt((String)bean.fetchRecord("SELECT count(*) count   FROM mm_item_uom_defn WHERE uom_code = ? AND eqvl_uom_code = ? AND item_code = ?",new String[]{pur_uom_code,uom_code,item_code}).get("COUNT"));
		
				if(item_uom_count!=0){
				HashMap  stEqvl_value1=bean.fetchRecord("SELECT eqvl_value,eqvl_uom_qty , (eqvl_value / eqvl_uom_qty) conv_factor FROM mm_item_uom_defn a, st_item b WHERE uom_code = ? AND eqvl_uom_code = ? AND a.item_code = ? AND a.item_code = b.item_code ",new String[]{pur_uom_code,uom_code,item_code});
				String conver=(String)stEqvl_value1.get("EQVL_VALUE")+" "+uom_code +" = "+(String)stEqvl_value1.get("EQVL_UOM_QTY")+" "+pur_uom_code;
				String stEqvl_value=(String)stEqvl_value1.get("CONV_FACTOR");
				out.println("setUOMConvFactor1('"+stEqvl_value+"','"+conver+"');");
				result=true;
				}
				else if(am_count!=0){				
				String stEqvl_value=(String)bean.fetchRecord("SELECT EQVL_VALUE  FROM am_uom_eqvl WHERE uom_code = ? AND eqvl_uom_code = ?",new String[]{ pur_uom_code,uom_code}).get("EQVL_VALUE");
				String conver=stEqvl_value+" "+pur_uom_code+" = 1 "+uom_code;
				out.println("setUOMConvFactor1('"+stEqvl_value+"','"+conver+"');");
				result=true;
				}
				else{
				String stEqvl_value="1";
				String conver="1"+" "+uom_code+" = 1 "+pur_uom_code;
				out.println("setUOMConvFactor1('"+stEqvl_value+"','"+conver+"');");
				result=true;
		
				}
			}catch (Exception exception) {
				exception.printStackTrace();
				
				throw new Exception("NO_CONV_FAC_FOR_REQ_UOM_CODE");
			}
		}catch (Exception exception) {
			result		=	false;
			message		=	exception.getMessage();
			exception.printStackTrace();
		}finally{
		out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
		}
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
