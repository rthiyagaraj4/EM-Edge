
<%@ page import="eBL.*,java.sql.*,java.text.*,oracle.sql.*,oracle.jdbc.*,java.math.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, com.ehis.util.*,java.util.*" %>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="org.json.simple.JSONObject"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>

<%
try{		
			String beanId = "BillDetailsBean";
			String beanName = "eBL.BLBillDetailsBean";
			BLBillDetailsBean beanObj=(BLBillDetailsBean) getBeanObject(beanId, beanName, request);
			HashMap<String, ArrayList<BLBillDetailsBean>> billDtlMap=beanObj.getBillDtlMap();
			ArrayList<BLBillDetailsBean> billDetailList=billDtlMap.get("REPRINT");
			int count=0;

			for(BLBillDetailsBean bean :billDetailList){
				if(bean.getDocNum().equals(request.getParameter("docNum"+count))){
					bean.setReceiptTypeCode(request.getParameter("recType"+count));
				}
				count++;
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
