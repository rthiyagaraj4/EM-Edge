<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8"
	import="java.sql.*,java.util.Hashtable,java.util.ArrayList,java.util.HashMap,java.util.Enumeration,eBL.Common.*,eBL.*,eCommon.Common.*,webbeans.eCommon.*"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser" />

<%
	String beanId = "bl_blinsuranceimagebean";
	String beanName = "eBL.BLInsuranceImageBean";
	BLInsuranceImageBean bean = (BLInsuranceImageBean) getBeanObject(beanId, beanName, request);
	
	try {
			request.setCharacterEncoding("UTF-8");
			Hashtable hash = (Hashtable) xmlObj.parseXMLString(request);
			hash = (Hashtable) hash.get("SEARCH");		
			String[] tempString = new String[4];
			int totalRecords= (hash.get("total_records")==null) ? 0:Integer.parseInt((String)hash.get("total_records"));

			/*Karthik added the below code to handle Session Record retain - starts */

			HashMap newInsuranceImageValues		= new HashMap();
			ArrayList<String> existingPayerList=new ArrayList<String>();
			ArrayList<String> newPayerList=new ArrayList<String>();
			ArrayList<String> tempPayerList=new ArrayList<String>();
			ArrayList<String> removalPayerList=new ArrayList<String>();		

			Set<String> kSet=bean.getInsuranceImageValues().keySet();
			Iterator<String> it=kSet.iterator();

			while(it.hasNext()){
				String key=it.next();
				existingPayerList.add(key);
			}

			for (int i = 0; i < totalRecords; i++) {	
				String payerGroupCode=(String)hash.get("ins_cust_group_code"	+ i);
				String payerCode=(String)hash.get("cust_3"	+ i);
				String policyCode=(String)hash.get("policy_type_code"	+ i);
				String policyNo=(String)hash.get("policy_no"	+ i);
				String startDate=(String)hash.get("policy_start_date"	+ i);
				String endDate=(String)hash.get("policy_exp_date"	+ i); 			
				newPayerList.add(payerGroupCode+payerCode+policyCode+policyNo+startDate+endDate);	
			}	

			/*This logic identifies session records which needs to be deleted */
			/*Omit Payers provided in Add Payer Page*/
			existingPayerList.removeAll(newPayerList);
			tempPayerList=existingPayerList;		
			/*Omit Records selected through Insurance window */		
			for(int d=0;d<tempPayerList.size();d++){
				if( !tempPayerList.get(d).contains("^^^")){
					removalPayerList.add(tempPayerList.get(d));
				}
			}		

			/*Getting Real Values from Hashmap for list */
			newInsuranceImageValues=bean.getInsuranceImageValues();
			for(int ret=0;ret<removalPayerList.size();ret++){
				newInsuranceImageValues.remove(removalPayerList.get(ret));
			}

			bean.setInsuranceImageValues(newInsuranceImageValues);

			/*Karthik added the below code to handle Session Record retain - ends */		
			for (int i = 0; i < totalRecords; i++) {	
				String payerGroupCode=(String)hash.get("ins_cust_group_code"	+ i);
				String payerCode=(String)hash.get("cust_3"	+ i);
				String policyCode=(String)hash.get("policy_type_code"	+ i);
				String policyNo=(String)hash.get("policy_no"	+ i);
				String startDate=(String)hash.get("policy_start_date"	+ i);
				String endDate=(String)hash.get("policy_exp_date"	+ i); 
				String replicationKey=payerGroupCode+payerCode+policyCode+policyNo+startDate+endDate+"^^^";
				if(!existingPayerList.contains(replicationKey)){
					bean.setInsuranceValues(payerGroupCode,payerCode,policyCode,policyNo,startDate,endDate);
				}
			}		
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("Exception from BLInsImageIntLoadValidation.jsp :"+ e);
	}
%>
