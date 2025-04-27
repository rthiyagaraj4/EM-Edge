<!DOCTYPE html>
<%@ page import="eBL.*,java.sql.*,java.text.*,oracle.sql.*,oracle.jdbc.*,java.math.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, com.ehis.util.*,java.util.*" %>
  <%@page contentType="text/html; charset=UTF-8"%>
  <%@page import="org.json.simple.JSONObject"%>
  <%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%!
private String decodeParam(String input){
	String output = "";
	try{
		if(input!=null){
			input = input.replaceAll("%(?![0-9a-fA-F]{2})", "%25");
			input = input.replaceAll("\\+", "%2B");
			output = URLDecoder.decode(input,"UTF-8");
		}
	}
	catch(Exception e){
		System.err.println("Exception while Decoding BillHdrAjax->"+e);
	}
	return output;
}
%>
<%!

String toDateFormat(String date) throws ParseException{	
	
	if(date==null){
		return "";
	}
	
	String formattedDate;		
    String oldFormat = "dd/MM/yyyy HH:mm:ss";// 2013-10-08 17:15:33.0
    String newFormat = "yyyy-mm-dd hh:mm:ss";
    SimpleDateFormat sdfOld = new SimpleDateFormat(oldFormat);
    SimpleDateFormat sdfNew = new SimpleDateFormat(newFormat);    
	formattedDate=sdfNew.format(sdfOld.parse(date));		
	return formattedDate;	
} 
%>

<%

try{
    Connection con	=	ConnectionManager.getConnection(request);
    
    String record_count= (request.getParameter("total_records")==null) ?"0":request.getParameter("total_records") ;
    int total_records=Integer.parseInt(record_count);
    TreeSet<BLBillSlmtServiceBean> slmt_by_svc_parameter_array =null;
    
    String operation=request.getParameter("operation")==null ? "":request.getParameter("operation") ;
    
    if(operation.equals("DELETE")){
    	slmt_by_svc_parameter_array = (TreeSet<BLBillSlmtServiceBean>) session.getAttribute("slmt_by_svc_parameter_array_session");
        BLBillSlmtServiceBean removeBeanObj = new BLBillSlmtServiceBean();
    	for(BLBillSlmtServiceBean beanObj:slmt_by_svc_parameter_array){
    		System.out.println(beanObj.getTrxDocRef());
    		System.out.println(request.getParameter("trans_doc_ref"));
    		if(beanObj.getTrxDocRef().equals(request.getParameter("trans_doc_ref"))){
    		removeBeanObj=beanObj;  		
    		}
    	}
    	slmt_by_svc_parameter_array.remove(removeBeanObj);
    	System.out.println(slmt_by_svc_parameter_array);
        session.setAttribute("slmt_by_svc_parameter_array_session",slmt_by_svc_parameter_array);
		
    	
    }else if(operation.equals("INCLUDE")){
	   
	    String billDocType=request.getParameter("billdoctypecode");
	    String billNumber=request.getParameter("billdocnum");
		String serviceDate=request.getParameter("service_date");
		String trxDocRef=request.getParameter("trx_doc_ref");
		String trxDocRefLineNum=request.getParameter("trx_doc_ref_line_num");	
		String trxDocRefSeqNum=request.getParameter("trx_doc_ref_seq_num");
		String billingService=request.getParameter("billing_service");
		String updNetChargeAmt=request.getParameter("upd_net_charge_amt");
		String chargeAmt=request.getParameter("charge_amt");
		String settledAmt=request.getParameter("settled_amt");	
		
		String all_service_criteria=(String) session.getAttribute("all_services_included_excluded_slmt");
		
		String inclusionExclusionCriteria="";
		if(all_service_criteria.equals("I")){
			inclusionExclusionCriteria="E";
		}else if(all_service_criteria.equals("E")){
			inclusionExclusionCriteria="I";	
		}
	
		
		BLBillSlmtServiceBean serviceBean=new BLBillSlmtServiceBean();
		serviceBean.setBillDocType(billDocType);
		serviceBean.setBillNumber(billNumber);
		serviceBean.setServiceDate(serviceDate);
		serviceBean.setTrxDocRef(trxDocRef);
		serviceBean.setTrxDocRefLineNum(trxDocRefLineNum);
		serviceBean.setTrxDocRefSeqNum(trxDocRefSeqNum);
		serviceBean.setBillingService(billingService);
		serviceBean.setUpdNetChargeAmt(updNetChargeAmt);
		serviceBean.setChargeAmt(chargeAmt);
		serviceBean.setSettledAmt(settledAmt);
		serviceBean.setInclusionExclusionCriteria(inclusionExclusionCriteria);
	    
	    System.out.println(session.getAttribute("slmt_by_svc_parameter_array_session"));
	    slmt_by_svc_parameter_array = session.getAttribute("slmt_by_svc_parameter_array_session")==null? new TreeSet<BLBillSlmtServiceBean>():(TreeSet<BLBillSlmtServiceBean>) session.getAttribute("slmt_by_svc_parameter_array_session");
	    if(slmt_by_svc_parameter_array==null){
	    	slmt_by_svc_parameter_array=new TreeSet();
	    }    
	    slmt_by_svc_parameter_array.add(serviceBean);
	    
	    System.out.println(slmt_by_svc_parameter_array);
	    session.setAttribute("slmt_by_svc_parameter_array_session",slmt_by_svc_parameter_array);
    }else if(operation.equals("UPDATE")){ 
    	
    	slmt_by_svc_parameter_array= (TreeSet<BLBillSlmtServiceBean>) session.getAttribute("slmt_by_svc_parameter_array_session");
    	Iterator<BLBillSlmtServiceBean> it=slmt_by_svc_parameter_array.iterator();
    	BLBillSlmtServiceBean deleteBean=new BLBillSlmtServiceBean();
    	BLBillSlmtServiceBean modifiedBean=new BLBillSlmtServiceBean();
    	String trans_doc_ref=request.getParameter("trans_doc_ref");
    	String settlement_amount=request.getParameter("settled_amt");
    	String all_service_criteria=request.getParameter("all_service_criteria");
    	while(it.hasNext()){
    		BLBillSlmtServiceBean serviceBean=it.next();
    		if(serviceBean.getTrxDocRef().toString().equals(trans_doc_ref)){
    			deleteBean=serviceBean;
    			modifiedBean.setBillDocType(serviceBean.getBillDocType());
    			modifiedBean.setBillingService(serviceBean.getBillingService());
    			modifiedBean.setBillNumber(serviceBean.getBillNumber());
    			modifiedBean.setChargeAmt(serviceBean.getChargeAmt());    			
    			modifiedBean.setServiceDate(serviceBean.getServiceDate());
    			modifiedBean.setTrxDocRef(serviceBean.getTrxDocRef());
    			modifiedBean.setTrxDocRefLineNum(serviceBean.getTrxDocRefLineNum());
    			modifiedBean.setTrxDocRefSeqNum(serviceBean.getTrxDocRefSeqNum());
    			modifiedBean.setUpdNetChargeAmt(serviceBean.getUpdNetChargeAmt());
    			modifiedBean.setInclusionExclusionCriteria(all_service_criteria);
    			modifiedBean.setSettledAmt(settlement_amount);
    		}
    	}
    	slmt_by_svc_parameter_array.remove(deleteBean);
    	slmt_by_svc_parameter_array.add(modifiedBean);
    	System.out.println(slmt_by_svc_parameter_array);
    	
    	
    }else if(operation.equals("ALL_INCLUDE_EXCLUDE")){   	
    	String all_service_criteria=request.getParameter("all_service_criteria");
    	session.setAttribute("all_services_included_excluded_slmt",all_service_criteria);
	    session.setAttribute("slmt_by_svc_parameter_array_session",null);
    }else if(operation.equals("CACHE_CLEAR")){
		session.removeAttribute("all_services_included_excluded_slmt");
		session.removeAttribute("slmt_by_svc_parameter_array_session");
		session.removeAttribute("deposit_parameter_array_session"); 
	    session.removeAttribute("deposit_adjusted_payable_amount");
	    
		String beanId = "BillDetailsBean" ;
		String beanName = "eBL.BLBillDetailsBean";		
		BLBillDetailsBean billDetailsBean = (BLBillDetailsBean) getBeanObject(beanId, beanName, request);
		billDetailsBean.clear();
		
    }
    else if("ASYNCPRINT".equals(operation)){
    	int totalRecords = 0;
    	totalRecords = Integer.parseInt(request.getParameter("totalReport"));
    	HashMap<String,String> asyncPrinterAttrib=new HashMap<String,String> ();
    	String printVal = "";
    	String reportId = "";
    	for(int i=1;i<=totalRecords;i++){
    		printVal = decodeParam(request.getParameter("billPrintVal"+i));
    		reportId = decodeParam(request.getParameter("report"+i));
    		asyncPrinterAttrib.put(printVal+"/"+i,reportId);
    	}
    	session.setAttribute("ASYNC_PRINTER_ATTRIB", asyncPrinterAttrib);
    	System.err.println("Session set");
    }
    
	JSONObject obj=new JSONObject();
    obj.put("flag","SUCCESS");    
    out.print(obj);
    out.flush();
     
} catch(Exception e) {
    System.out.println(e);
	JSONObject obj=new JSONObject();
    obj.put("flag","FAILED");    
    out.print(obj);
    out.flush();
     
}
%>
