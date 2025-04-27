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

public final class __purchaseordervalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ePO/jsp/PurchaseOrderValidate.jsp", 1741325895414L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 =" \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );
	
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);

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
	String eff_from  = "";
	String deptDesc_effFrom = request.getParameter("dept_desc");
	int	index = 0;

	if ((bean_id == null) || (bean_id.equals("")))
		return;

	PurchaseOrderBean bean		=		(PurchaseOrderBean) getBeanObject(bean_id, bean_name, request  );
	bean.setLanguageId(locale);

	Hashtable hash			=		(Hashtable) XMLobj.parseXMLString(request);
    hash					=		(Hashtable) hash.get ("SEARCH");
	boolean result			=		false;
	boolean result1			=		false;
	String message			=		"";
	String flag				=		"";
	
	if(functionType.equals("LOADCURRENCY")){
		
		String local_currency = request.getParameter("localCurrency");
		
		
		HashMap hmRecord = bean.getCurrencyDesc(supplier);
			if(hmRecord.size()>0){
				dflt_currency = (String)hmRecord.get("CURRENCY_CODE");
			}
		
		
		
		
		out.println("clearListItems('formPurchaseOrderHeader.currency_code'); ");
		ArrayList currency_code = bean.getCurrencyLists();
		HashMap record = new HashMap();
			for(int i=0; i< currency_code.size(); i++) {
				record = (HashMap)currency_code.get(i);
				out.println("addListItem(\"formPurchaseOrderHeader.currency_code\", \"" + record.get("CURRENCY_CODE") + "\",\"" + record.get("SHORT_DESC") + "\",\"" +dflt_currency+ "\");");
			}
		out.println("parent.PODetailFrame.document.getElementById('currency_label_1').innerHTML = '" +  dflt_currency +"'; ");
		out.println("parent.PODetailFrame.document.getElementById('currency_label_2').innerHTML = '" +  dflt_currency +"'; ");
		out.println("parent.PODetailFrame.document.getElementById('currency_label_3').innerHTML = '" +  dflt_currency +"'; ");
		out.println("parent.PODetailFrame.document.getElementById('currency_label_4').innerHTML = '" +  dflt_currency +"'; ");
		  out.println("parent.POListFrame.document.getElementById('currency_label_5').innerHTML = '" +  dflt_currency +"'; ");
		  out.println("parent.POListFrame.document.getElementById('currency_label_6').innerHTML = '" +  dflt_currency +"'; ");
		  out.println("parent.POListFrame.document.getElementById('currency_label_7').innerHTML = '" +  dflt_currency +"'; ");
		out.println("parent.PODetailFrame.document.getElementById('currency_label_8').innerHTML = '" +  dflt_currency +"'; ");
		if(dflt_currency.equals(local_currency)){
			out.println("document.getElementById('exc_rate').value = '" +  1 +"'; ");
			out.println("document.getElementById('exc_rate').disabled = true; ");
		}else{
				out.println("document.getElementById('exc_rate').value = '" +  "" +"'; ");
				out.println("document.getElementById('exc_rate').disabled = false; ");
		}
		
		
	}
	else if(functionType.equals("LOADDEPTID1")){
		
		out.println("clearListItems('formPurchaseOrderDetail.dept_id'); ");
		ArrayList dept_id = bean.getDept_no(commit_code);
		HashMap record = new HashMap();
		
			for(int i=0; i< dept_id.size(); i++) {
				record = (HashMap)dept_id.get(i);
				String concat_code = record.get("DEPT_CODE") + "-" + record.get("EFF_DATE_FROM") ;
				String concat_desc = record.get("SHORT_DESC") + "-" + record.get("EFF_DATE_FROM") ;
				if(concat_desc.equals(department_id)){
					out.println("addListItem(\"formPurchaseOrderDetail.dept_id\", \"" + record.get("DEPT_CODE") + "\",\"" + concat_desc + "\",\"" + record.get("DEPT_CODE") +"\");");
				}else{
					out.println("addListItem(\"formPurchaseOrderDetail.dept_id\", \"" + record.get("DEPT_CODE") + "\",\"" + concat_desc + "\");");
				}
			}
	}
	else if(functionType.equals("LOADDEPTID")){
				
		out.println("clearListItems('formPurchaseOrderDetail.dept_id'); ");
		ArrayList dept_id = bean.getDept_no(commit_code);
		HashMap record = new HashMap();
		
			for(int i=0; i< dept_id.size(); i++) {
				record = (HashMap)dept_id.get(i);
				String concat_code = record.get("DEPT_CODE") + "-" + record.get("EFF_DATE_FROM") ;
				String concat_desc = record.get("SHORT_DESC") + "-" + record.get("EFF_DATE_FROM") ;
			/*	if(dept_id.size()==1){
				out.println("addListItem(\"formPurchaseOrderDetail.dept_id\", \"" + record.get("DEPT_CODE") + "\",\"" + record.get("SHORT_DESC")  + "\",\"" +record.get("DEPT_CODE") +"\");");
				}else{
			*/	
			//	out.println("addListItem(\"formPurchaseOrderDetail.dept_id\", \"" + record.get("DEPT_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
				out.println("addListItem(\"formPurchaseOrderDetail.dept_id\", \"" + record.get("DEPT_CODE") + "\",\"" + concat_desc + "\");");
			//	}
			}
	}
	
	else if(functionType.equals("LOADACCNO")){
		
		eff_from = deptDesc_effFrom.substring(deptDesc_effFrom.lastIndexOf("-")+1) ;
		String st = "";
		out.println("document.getElementById('acc_desc_label').innerHTML = '" + st  +"'; ");
		out.println("document.getElementById('eff_from').value = '" +  eff_from +"'; ");	
		out.println("clearListItems('formPurchaseOrderDetail.acc_no'); ");
	//	ArrayList acc_no = bean.getAccount_no(department_id,commit_code);
		ArrayList acc_no = bean.getAccount_no(department_id,commit_code,eff_from);
		System.out.println("acc_no = "+acc_no);
		HashMap record = new HashMap();
			for(int i=0; i< acc_no.size(); i++) {
				record = (HashMap)acc_no.get(i);
				out.println("addListItem(\"formPurchaseOrderDetail.acc_no\", \"" + record.get("ACCOUNT_NO") + "\",\"" + record.get("ACCOUNT_NO") + "\");");
			}
	}
	
	else if(functionType.equals("LOADACCDESC")){
		
		eff_from = deptDesc_effFrom.substring(deptDesc_effFrom.lastIndexOf("-")+1) ;
		
	//	HashMap hmRecord = bean.getAcctDesc(acc_number,commit_code,department_id);
		HashMap hmRecord = bean.getAcctDesc(acc_number,commit_code,department_id,eff_from);
			if(hmRecord.size()>0){
				acc_desc = (String)hmRecord.get("ACCOUNT_NAME");
				if(!acc_desc.equals("")){
					acc_desc = acc_desc.replaceAll(" ","%20");
					acc_desc = java.net.URLEncoder.encode(acc_desc,"UTF-8");
					acc_desc = acc_desc.replaceAll("%2520","%20");
				}
			}
			
	//	out.println("document.getElementById("acc_desc_label").innerHTML = '" +  acc_desc +"'; ");
		out.println("document.getElementById('acc_desc').value = '" +  acc_desc +"'; ");	
	}
	
/*	else if(functionType.equals("GETUOMDESC")){
		
		HashMap hmRecord = bean.getUomDesc(uom_code);
			if(hmRecord.size()>0){
				uom_desc = (String)hmRecord.get("SHORT_DESC");
			}
		out.println("document.getElementById("temp_uom_code").value = '" +  uom_code +"'; ");
		out.println("document.getElementById("temp_uom").value = '" +  uom_desc +"'; ");
			
	}
	
	else if(functionType.equals("GETCOMMNTDESC")){
		
		HashMap hmRecord = bean.getCommntDesc(commt_code);
			if(hmRecord.size()>0){
				commt_desc = (String)hmRecord.get("SHORT_DESC");
				if(!commt_desc.equals("")){
					commt_desc = commt_desc.replaceAll(" ","%20");
					commt_desc = java.net.URLEncoder.encode(commt_desc,"UTF-8");
					commt_desc = commt_desc.replaceAll("%2520","%20");
				}
			}
		
		out.println("document.getElementById("temp_commt").value = '" +  commt_desc +"'; ");
			
	}
*/	

	else if(functionType.equals("SETORDERVALUES")){
	

			try{
				String order_remarks = request.getParameter("order_remarks");
                 bean.setOrder_remarks(order_remarks);
				 
				result = true;
		
			}catch(Exception e){
				result		=	false;
				message		=	e.getMessage();
				e.printStackTrace();
		}finally {
			out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
		}
	}
	else if(functionType.equals("SETADDITIONALDETAILS")){
	

			try{
			
				String qnt_ref = request.getParameter("qnt_ref");
				String pmnt_term = request.getParameter("pmnt_term");
				String acc_no = request.getParameter("acc_no");
				String terms_conditions = request.getParameter("terms_conditions");
				//String supp_address_1 = request.getParameter("supp_address_1");
				String delivery_mode = request.getParameter("delivery_mode");
				//String supp_address_2 = request.getParameter("supp_address_2");
				String deliver_to_address = request.getParameter("deliver_to_address");
				//String supp_address_3 = request.getParameter("supp_address_3");
				String bill_to_address = request.getParameter("bill_to_address");
				
                bean.setQnt_ref(qnt_ref);
				bean.setPmnt_term(pmnt_term);
				bean.setAcc_no(acc_no);
				bean.setTerms_conditions(terms_conditions);
				//bean.setSupp_address_1(supp_address_1);
				bean.setDelivery_mode(delivery_mode);
				//bean.setSupp_address_2(supp_address_2);
				bean.setDeliver_to_address(deliver_to_address);
				//bean.setSupp_address_3(supp_address_3);
				bean.setBill_to_address(bill_to_address);
				
				 
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
	else if(functionType.equals("SETBILLTODELIVERTODETAILS")){
	 	try{
				
			//	String idx = request.getParameter("index");
				
              bean.updateBillToDeliveryRecords(hash);
              
		
			result = true;
		
			}catch(Exception e){
				result		=	false;
				message		=	e.getMessage();
				e.printStackTrace();
		}finally {
			out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
		}
	}
	
	else if(functionType.equals("OVERRIDEBUDGET")){
			
			try {
				try {
					String override_Budget = "";
					String balance_amt = "" ;
					HashMap amountHandler = (HashMap)bean.newOverride();
					
					Iterator it = amountHandler.entrySet().iterator();
					while (it.hasNext()) {
						ArrayList alCommtRecord = new ArrayList();
						ArrayList alBudgetRecord = new ArrayList();
						Map.Entry pairs = (Map.Entry)it.next();
						for (String retval: ((String)pairs.getKey()).split("-")){
							alBudgetRecord.add(retval); //COMMNT_CODE , DEPT_NO , ACCOUNT_NO , EFF_DATE_FROM
						}
						
						String override_amt = (String)pairs.getValue();
						
						 override_Budget = (String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_PO_COMMT_CODE_SELECT_OVERRIDE"),alBudgetRecord).get("OVERRIDE_BUDGET");
						 
						 balance_amt = (String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_PO_COMMT_CODE_SELECT_BALANCE"),alBudgetRecord).get("BALANCE_BDGT_AMT");
						
						System.out.println("alBudgetRecord in po validate = "+alBudgetRecord);
						// Start
						
					String com_desc = "";
					String com_code = "";
					String dept_desc = "";
					String dt_code = "";
					
					for(int i=0;i<alBudgetRecord.size();i++){
								com_code = (String) alBudgetRecord.get(i);
								dt_code = (String) alBudgetRecord.get(++i);
								
								String[] stParameters1 ={bean.getLanguageId(),com_code};	
								String[] stParameters2 ={bean.getLanguageId(),com_code,dt_code};	
								com_desc	=	(String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_PO_COMM_DESC_SELECT"),stParameters1).get("SHORT_DESC");
								dept_desc	=	(String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_PO_DEPT_DESC_SELECT"),stParameters2).get("SHORT_DESC");
							break;	
							
					}
					
					if(!com_desc.equals("")){
					com_desc = com_desc.replaceAll(" ","%20");
					com_desc = java.net.URLEncoder.encode(com_desc,"UTF-8");
					com_desc = com_desc.replaceAll("%2520","%20");
					}
					
					out.println("f_query_add_mod.POListFrame.document.formPurchaseOrderList.com_code.value = '" +  com_code +"'; ");
					out.println("f_query_add_mod.POListFrame.document.formPurchaseOrderList.com_desc.value = '" +  com_desc +"'; ");
					out.println("f_query_add_mod.POListFrame.document.formPurchaseOrderList.dt_code.value = '" +  dt_code +"'; ");
					out.println("f_query_add_mod.POListFrame.document.formPurchaseOrderList.dept_desc.value = '" +  dept_desc +"'; ");
					out.println("f_query_add_mod.POListFrame.document.formPurchaseOrderList.balance_amt.value = '" +  bean.checkForNull(balance_amt) +"'; ");
					out.println("f_query_add_mod.POListFrame.document.formPurchaseOrderList.override_amt.value = '" +  override_amt +"'; ");
						
						// End
				
						if(Double.parseDouble(override_amt) > Double.parseDouble(bean.checkForNull(balance_amt))){
							if(override_Budget.equals("W")){
								throw new Exception("OVERRIDE_WARNING");
							}else if(override_Budget.equals("E")){
								throw new Exception("OVERRIDE_ERROR");
							}else if(override_Budget.equals("N")){
								throw new Exception("OVERRIDE_NOTAPPLICABLE");
							}
						}
					}
					result = true;
					out.println(" assignResult(" + result + ",\"" + "" +"\", \"0\");") ;
				}
				catch (Exception exception) {
				//	exception.printStackTrace();
						
						if (exception.getMessage().equals("OVERRIDE_WARNING"))
							throw exception;
						else if (exception.getMessage().equals("OVERRIDE_ERROR"))
							throw exception;	
						else if (exception.getMessage().equals("OVERRIDE_NOTAPPLICABLE"))
							throw exception;	
							
				}
			}
			catch (Exception exception) {
				result		=	false;
				message		=	exception.getMessage();
				//exception.printStackTrace();
			}
			finally{
				out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
			}

		}
		
	else if(functionType.equals("COMMITCODE")){
			try {
				try {
				
					eff_from = deptDesc_effFrom.substring(deptDesc_effFrom.lastIndexOf("-")+1) ;
					
					out.println("document.getElementById('eff_from').value = '" +  eff_from +"'; ");	
					
				//	String eff_from_dt	= request.getParameter("eff_from");
					String override_Budget = "";
					ArrayList alBudgetRecord = new ArrayList();
					String dept_id	= request.getParameter("dept_id");					
					String net_amount	= request.getParameter("net_amount");
					String bal_budget   = "";
					alBudgetRecord.add(commit_code);
					alBudgetRecord.add(dept_id);
					alBudgetRecord.add(acc_number);
					alBudgetRecord.add(eff_from);
					
					override_Budget = (String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_PO_COMMT_CODE_SELECT_OVERRIDE"),alBudgetRecord).get("OVERRIDE_BUDGET");
					 
					bal_budget = (String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_PO_COMMT_CODE_SELECT_BALANCE"),alBudgetRecord).get("BALANCE_BDGT_AMT");
					  					  
					//bal_budget=(String)bean.fetchRecord(("select BALANCE_BDGT_AMT from PO_COMMTTMENT_ACCOUNT where MASTER_CODE = ? and DEPT_CODE = ? AND ACCOUNT_NO = ? AND EFF_DATE_FROM =  TO_DATE (?, 'dd/mm/yyyy')"),new String[]{commit_code,dept_id,acc_number,eff_from_dt}).get("BALANCE_BDGT_AMT");
					
					out.println("document.getElementById('bal_budget').value = '" +  bal_budget +"'; ");
					String[] stParameters2 ={bean.getLanguageId(),commit_code,dept_id};	
					String dept_desc	=	(String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_PO_DEPT_DESC_SELECT"),stParameters2).get("SHORT_DESC");
					out.println("document.getElementById('dept_desc').value = '" +  dept_desc +"'; ");
					if(override_Budget.equals("E")){
					if(Double.parseDouble(bean.checkForNull(bal_budget)) < Double.parseDouble(net_amount)){
						
						throw new Exception("BAL_BUD_LESS_THAN_ORDER_QTY");
					}
					}
					result = true;
					out.println(" assignResult(" + result + ",\"" + "" +"\", \"0\");") ;
				}
				catch (Exception exception) {
					//exception.printStackTrace();

						if (exception.getMessage().equals("BAL_BUD_LESS_THAN_ORDER_QTY"))
							throw exception;

				}
			}
			catch (Exception exception) {
				result		=	false;
				message		=	exception.getMessage();
				//exception.printStackTrace();
			}
			finally{
				out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
			}

		}
		else if(functionType.equals("CHECKITEMAPPROVAL")){
			try {
			
			/*		ArrayList checkApproval = bean.checkApprovedYN();
					ArrayList hashCheck = new ArrayList();
					for(int i=0; i< checkApproval.size(); i++){
						hashCheck = (ArrayList)checkApproval.get(i);
						 for(int j=0;j<hashCheck.size();j++){
									
							
							if(hashCheck.get(++j).equals("N")){
								result = true;
								message = (String) hashCheck.get(0);
								
							}
						}
					}
			*/		

				// Added by Padmapriya for INC # 34857 on 03/09/2012
				
				HashMap hashApp = new HashMap();
				String app_item = "";
			    hashApp=bean.fetchRecord(bean.getPoRepositoryValue("SQL_ST_PO_ITEM_APPROVAL_YN"));
				app_item=(String)hashApp.get("ITEM_LEVEL_ORDER_APPROVAL");
				
				if(app_item.equals("Y")){                               
					ArrayList checkApproval = bean.checkApprovedYN();
					ArrayList hashCheck = new ArrayList();
					for(int i=0; i< checkApproval.size(); i++){
						hashCheck = (ArrayList)checkApproval.get(i);
						 for(int j=0;j<hashCheck.size();j++){
									
							
							if(hashCheck.get(++j).equals("N")){
								result = true;
								message = (String) hashCheck.get(0);
								
								break;                
							}/*else{
								result=false;	
							}*/
							
						}
					}
					}else{
						result = false;
					}
					// End by Padmapriya for INC # 34857 on 03/09/2012
					
			}
			catch (Exception exception) {
				result		=	false;
				message		=	exception.getMessage();
				exception.printStackTrace();
			}
			finally{
				out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
			
			}


		}else if(functionType.equals("ADDITEMRECORD")){
			try {
				try {
					String item_code	= request.getParameter("item_code");
					String store_code	= request.getParameter("store_code");					
				//	String store_code_to	= request.getParameter("store_code_to");
					String phy_inv_id   = "";
					result1 = bean.isPhysicalInventoryProcessStartedForStore(item_code,store_code,store_code);
					if(result1){
						phy_inv_id=(String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_ST_PHY_INV_ID_SELECT"),new String[]{item_code,store_code}).get("PHY_INV_ID");
					if(bean.checkForNull(phy_inv_id,"").equals(""))
						phy_inv_id=(String)	bean.fetchRecord(bean.getPoRepositoryValue("SQL_ST_PHY_INV_ID_SELECT"),new String[]{item_code,store_code}).get("PHY_INV_ID");
					out.println("document.formPORequestDetail.phy_inv_id.value = '"+bean.checkForNull(phy_inv_id,"")+"';");
						throw new Exception("PHY_INV_PROCESS_INITIATED");
					} 
					result = true;
					out.println(" assignResult(" + result + ",\"" + "" +"\", \"0\");") ;
				}
				catch (Exception exception) {
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
				java.util.HashMap addResult = bean.addDetailRecordModifyMode(hash);
				out.println("clearListItems('formPurchaseOrderDetail.uom');  "); //Added by suresh.r on 04-12-2014 against ML-BRU-SCF-1457								
				out.println("assignResult("+addResult.get("result")+",\""+addResult.get("message")+"\", \"0\");");
		}else if(functionType.equals("EDITING")){
			// bean.updateBlockedAmount();
			java.util.HashMap addResult = bean.addDetailRecord(hash);
			out.println("clearListItems('formPurchaseOrderDetail.uom');  "); //Added by suresh.r on 04-12-2014 against ML-BRU-SCF-1457
			
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
					PurchaseOrderDetailBean detailBean;
					for (int i=0;	i<totalSize;	i++){
						itemStoreKey = (String) alItemKeys.get(i);
						detailBean = (PurchaseOrderDetailBean)hmItemStore.get(itemStoreKey);
						if(itemStoreKey.equals(stitem_code)){
							
							detailBean.setCheck_box_status(check_status);
                            hmItemStore.remove(itemStoreKey);
                            hmItemStore.put(itemStoreKey,detailBean);
                            bean.setHmItemDetail(hmItemStore);
						
							break ;
						}

					}//end of For loop
				}//end of if condition
              
		}
		else if(functionType.equals("LOAD_DETAILS_NEW")){	
			try{
			String loc_batch_string = (String)hash.get("loc_batch_string");

			

			loc_batch_string = loc_batch_string.substring(2,loc_batch_string.length());

			StringTokenizer stListItems=new StringTokenizer(loc_batch_string,"||");

			ArrayList podetails = null;
			HashMap podtl = null;

			 while (stListItems.hasMoreTokens()) {

			   StringTokenizer stListValueText=new StringTokenizer(stListItems.nextToken(),";");
			  
			   String req_no =  stListValueText.hasMoreTokens()?stListValueText.nextToken():"";
			   String item_code = stListValueText.hasMoreTokens()?stListValueText.nextToken():"";
			   String order_qty = stListValueText.hasMoreTokens()?stListValueText.nextToken():"";
			   String itemcode_reqno = item_code +""+ req_no;

			   podetails = bean.getPoItemDetails(req_no);

			   


				for(int i =0 ;i<podetails.size();i++){
					podtl = (HashMap)podetails.get(i);
					
					if((podtl.get("ITEM_CODE")).equals(item_code) &&  (podtl.get("REQ_NO")).equals(req_no)){					
					podtl.put("ORDER_QTY",order_qty);
					podtl.put("ITEMCODE_REQNO",itemcode_reqno);
					podtl.put("editing","1");					
					HashMap addResult =	bean.addDetailRecordNew(podtl);
					//out.println("clearListItems('formPurchaseOrderDetail.uom');  "); //Added by suresh.r on 04-12-2014 against ML-BRU-SCF-1457				

					out.println("assignResult("+addResult.get("result")+",\""+addResult.get("message")+"\", \"0\");");

					}
				}   
		   }			
			
			putObjectInBean(bean_id,bean,request);
			}
			catch(Exception e){
			throw e;
			}
		} else if(functionType.equals("MM_UOM")){

			String def_uom_code = (String)bean.fetchRecord("select gen_uom_code from mm_item where item_code= ?" ,bean.checkForNull(stitem_code)).get("GEN_UOM_CODE");

			out.println("document.formPurchaseOrderDetail.uom.value='"+bean.checkForNull(def_uom_code)+"'");
			
			out.println("document.getElementById('temp_uom_code').value='"+bean.checkForNull(def_uom_code)+"'");
			
			//Added by Padmapriya for INC # 34818 on 11/09/2012
			
			HashMap hmRecord = bean.getUomDesc(def_uom_code);
			if(hmRecord.size()>0){
				uom_desc = (String)hmRecord.get("SHORT_DESC");
			}
		
			out.println("document.getElementById('temp_uom').value = '" +  uom_desc +"'; ");
			
			//End by Padmapriya for INC # 34818 on 11/09/2012
			
		//	out.println("document.getElementById("temp_uom").value = '" +  bean.checkForNull(def_uom_code) +"'; ");  //Added by Padmapriya for INC # 34818 on 03/09/2012
			
			out.println("checkUOMConvFactor();");
			//Added by suresh.r on 12-11-2014 against ML-BRU-SCF-1457 beg
			try { 
				out.println("clearListItems('formPurchaseOrderDetail.uom');  "); 
	     		ArrayList alEncounterList = bean.getPur_uom_code_Lists(def_uom_code,stitem_code);
				HashMap record	=	new HashMap();
					for(int i=0; i< alEncounterList.size(); i++){
						record	=	(HashMap)alEncounterList.get(i);
						String listRecord1	=	(String)record.get("EQVL_UOM_CODE");
						String listRecord2	=	(String)record.get("SHORT_DESC");
						out.println("addListItem(\"document.formPurchaseOrderDetail.uom\", \"" +listRecord1+ "\",\"" +listRecord2+ "\",\"" +def_uom_code+"\") ; ");
					}
				}
				catch (Exception exception) {
				throw new Exception("ITEM_STORE_NOT_FOUND");
			}
			//Added by suresh.r on 12-11-2014 against ML-BRU-SCF-1457 end

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
				String authorize = (String)resultMap.get("PO_APPROVE_ALLOWED_YN");  
				if (authorize.equals("Y")) {
					authorize = "Yes";
				}
				else {
					authorize = "No";
				}
				out.println("setAuthorize('"+authorize+"');");
			}
		}
		else if(functionType.equals("DOCNO_ENABLE_YN")) {
			
			String purchase_unit				=		request.getParameter("purchase_unit");			
			
			HashMap hashRecord = bean.fetchRecord("SELECT PO_DOC_NO_GEN_METHOD FROM PO_DOCNO_CONTROL");

			String doc_no_md = bean.checkForNull((String) hashRecord.get("PO_DOC_NO_GEN_METHOD"));
			

			if(doc_no_md.equals("A")){
			out.println("document.formPurchaseOrderHeader.doc_no.disabled=true");
			out.println("document.formPurchaseOrderHeader.autono_yn.value='Yes'");
			}else{
			out.println("document.formPurchaseOrderHeader.doc_no.disabled=false");
			out.println("document.formPurchaseOrderHeader.autono_yn.value='No'");
			}	
				
		}
		else  if(functionType.equals("CHECKUOMCONVFACTOR"))
		{

			{
		try{
			try { 
				//String uom_code		= request.getParameter("uom");
				String pur_uom_code = request.getParameter("pur_uom_code");
				String item_code = request.getParameter("item_code");
				//Added and passed gen_uom_code instead of uom_code by suresh.r on 19-12-2014 against ML-BRU-SCF-1476(Inc 52684),ML-BRU-SCF-1385.1(Inc 52685)
				String gen_uom_code = bean.checkForNull((String)bean.fetchRecord("select gen_uom_code from mm_item where item_code= ?" ,bean.checkForNull(item_code)).get("GEN_UOM_CODE"));
				
				int am_count=Integer.parseInt((String)bean.fetchRecord("SELECT  count(*) count  FROM am_uom_eqvl WHERE uom_code = ? AND eqvl_uom_code = ?",new String[]{gen_uom_code,pur_uom_code}).get("COUNT"));
				int item_uom_count=Integer.parseInt((String)bean.fetchRecord("SELECT count(*) count   FROM mm_item_uom_defn WHERE uom_code = ? AND eqvl_uom_code = ? AND item_code = ?",new String[]{gen_uom_code,pur_uom_code,item_code}).get("COUNT"));
		
				if(item_uom_count!=0){
				HashMap  stEqvl_value1=bean.fetchRecord("SELECT eqvl_value,eqvl_uom_qty , (eqvl_value / eqvl_uom_qty) conv_factor FROM mm_item_uom_defn a, st_item b WHERE uom_code = ? AND eqvl_uom_code = ? AND a.item_code = ? AND a.item_code = b.item_code ",new String[]{gen_uom_code,pur_uom_code,item_code});
				String conver=(String)stEqvl_value1.get("EQVL_VALUE")+" "+gen_uom_code +" = "+(String)stEqvl_value1.get("EQVL_UOM_QTY")+" "+pur_uom_code;
				String stEqvl_value=(String)stEqvl_value1.get("CONV_FACTOR");
				out.println("setUOMConvFactor1('"+stEqvl_value+"','"+conver+"');");
				result=true;
				}
				else if(am_count!=0){				
				String stEqvl_value=(String)bean.fetchRecord("SELECT EQVL_VALUE  FROM am_uom_eqvl WHERE uom_code = ? AND eqvl_uom_code = ?",new String[]{gen_uom_code,pur_uom_code}).get("EQVL_VALUE");
				String conver=stEqvl_value+" "+pur_uom_code+" = 1 "+gen_uom_code;
				out.println("setUOMConvFactor1('"+stEqvl_value+"','"+conver+"');");
				result=true;
				}
				else{
				String stEqvl_value="1";
				String conver="1"+" "+gen_uom_code+" = 1 "+pur_uom_code;
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
