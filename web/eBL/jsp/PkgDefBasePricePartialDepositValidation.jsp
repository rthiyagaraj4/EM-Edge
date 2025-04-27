<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date     	  Edit History      Name     			Description
--------------------------------------------------------------------------------------------------------------
16-Nov-2013      100           	Karthikeyan.K          created for MMS-CRF-0023
---------------------------------------------------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<%@ page
	import="webbeans.eCommon.*,eBL.*,eBL.Common.*,com.ehis.util.*,java.util.*,java.sql.*,java.text.*"%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>

<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page"
	class="webbeans.eCommon.XMLStringParser" />
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	System.out.println("PkgDefBasePricePartialDepositValidation.jsp page called");

	String beanId = "bl_PkgDefBean";
	String beanName = "eBL.PkgDefBean";
	PkgDefBean bean=(PkgDefBean) getBeanObject(beanId, beanName, request);
	ArrayList<String> partialDepositList=new ArrayList<String>();
	
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<HTML>
<HEAD>
</HEAD>
<body>

<%
	try {
		request.setCharacterEncoding("UTF-8");
		Hashtable hash = (Hashtable) xmlObj.parseXMLString(request);
		hash = (Hashtable) hash.get("SEARCH");
		System.out.println(hash);

		String action=request.getParameter("action");
		System.out.println("action:"+action);
		
if(action.equals("submit")){

		String recordCountStr 		=	(String) hash.get( "recordCount");
		String blgClsCode=(String) hash.get("blgClsCode");
		int recordCount=Integer.parseInt(recordCountStr);
		
		for(int i=0;i<recordCount;i++){
			 
			String encSeqNo=	(String) hash.get( "encSeqNo"+i);			
			String partialDepositType=	(String) hash.get( "partialDepositType"+i);
			String partialDeposit=(String) hash.get( "partialDeposit"+i);
			String depositMandatoryYN=Boolean.parseBoolean((String) hash.get( "depositMandatoryYN"+i)) ?"Y":"N";
			if(partialDeposit!=null && !partialDeposit.equals("")){
			String partialDepositrecord=encSeqNo+"~"+partialDepositType+"~"+partialDeposit+"~"+depositMandatoryYN;
			System.out.println(partialDepositrecord);
			partialDepositList.add(partialDepositrecord);
			}
			HashMap<String,ArrayList<String>> partialDepositMap = bean.getPartialDepositList();
			if(partialDepositMap==null){
				partialDepositMap=new HashMap<String,ArrayList<String>>();
			}
			partialDepositMap.put(blgClsCode,partialDepositList);
			bean.setPartialDepositList(partialDepositMap);
			
			System.out.println("PkgDefBasePricePartialDepositValidation.jsp>>"+bean.getPartialDepositList());
		}
	}
else if(action.equals("delete")){

		String recordCountStr 		=	(String) hash.get( "recordCount");
		String blgClsCode=(String) hash.get("blgClsCode");
		String deletePartialRecord=(String) hash.get("deletePartialRecord");
		
		int recordCount=Integer.parseInt(recordCountStr);
		
		for(int i=0;i<recordCount;i++){
			 
			String encSeqNo=	(String) hash.get( "encSeqNo"+i);			
			String partialDepositType=	(String) hash.get( "partialDepositType"+i);
			String partialDeposit=(String) hash.get( "partialDeposit"+i);
			String depositMandatoryYN=Boolean.parseBoolean((String) hash.get( "depositMandatoryYN"+i)) ?"Y":"N";
			if(partialDeposit!=null && !partialDeposit.equals("") ){
			String partialDepositrecord=encSeqNo+"~"+partialDepositType+"~"+partialDeposit+"~"+depositMandatoryYN;
				if(!encSeqNo.equals(deletePartialRecord)){
				System.out.println(partialDepositrecord);
				partialDepositList.add(partialDepositrecord);
				}
			}
			HashMap<String,ArrayList<String>> partialDepositMap = bean.getPartialDepositList();
			if(partialDepositMap==null){
				partialDepositMap=new HashMap<String,ArrayList<String>>();
			}
			partialDepositMap.put(blgClsCode,partialDepositList);
			bean.setPartialDepositList(partialDepositMap);
			
			System.out.println("PkgDefBasePricePartialDepositValidation.jsp>>"+bean.getPartialDepositList());
		}
	}


	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("Exception from PkgDefBasePricePartialDepositValidation.jsp :"+ e);
	}
%>
</body>
</HTML>
