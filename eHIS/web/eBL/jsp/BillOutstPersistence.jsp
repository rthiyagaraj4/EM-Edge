<%@page  contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.Hashtable,java.util.ArrayList, java.util.HashMap,java.util.Enumeration, eBL.Common.*, eBL.*, eCommon.Common.*, webbeans.eCommon.*" %>
<%-- Mandatory declarations start  --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%!
	private String replaceNull(String input){
	if(input == null || "null".equals(input)){
		input = "";
	}
	return input;
}
%>
<%
	//String params = request.getQueryString();
	String sqlCoverage = "";
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	String beanId = "BillDetailsBean" ;
	String beanName = "eBL.BLBillDetailsBean";   	
	
	BLBillDetailsBean billDetailsBean = (BLBillDetailsBean) getBeanObject(beanId, beanName, request);
	
	if(billDetailsBean.getBillDtlMap() == null)
	{
		billDetailsBean.setBillDtlMap(new HashMap<String, ArrayList<BLBillDetailsBean>>());
	}
	
	if(billDetailsBean.getRestrictionMap() == null){
		billDetailsBean.setRestrictionMap(new HashMap<String,String>());
	}
	
	HashMap<String, ArrayList<BLBillDetailsBean>> billDtlMap = billDetailsBean.getBillDtlMap();
	HashMap<String,String> restrictionMap = billDetailsBean.getRestrictionMap();
	Connection 	connection = null;
	try 
	{
		connection = ConnectionManager.getConnection();
		request.setCharacterEncoding("UTF-8");
		
		String locale = (String)session.getAttribute("LOCALE");
		String func_mode = request.getParameter("func_mode");
		//String event = (request.getParameter("event") == null ? "" : request.getParameter("event"));
		String docTypeCode = null;
		int docNum = 0;
		String docDate = null;
		String billTotAmt = null;
		String totOutStdAmt = null;
		String patientId=null;
		String episodeType=null;
		String episodeId=null;
		String visitId=null;
		String excemptedAmt=null;
	
	
		System.out.println("TOTAL ROWS"+request.getParameter("totalRows")+"<<<");
		    

		String strTotalRows = request.getParameter("totalRows");
		int count = Integer.parseInt(strTotalRows);
 	 
		Hashtable hash = (Hashtable)xmlObj.parseXMLString( request ) ;
		
		

		String billDtlKey = (String) hash.get("billDtlKey");
		ArrayList<BLBillDetailsBean> billDetailsList = new ArrayList<BLBillDetailsBean>();
		BLBillDetailsBean bean = null;
		//int count = Integer.parseInt((String)hash.get("totalRows"));
		System.err.println("totalRows :" + count);
		double userSlmtAmt = 0.0;
			
		for(int i=1; i<=count;i++)
		{
				
				
						
		bean = new BLBillDetailsBean();
		bean.setDocTypeCode(replaceNull(request.getParameter("billdocType" + i)));				

		bean.setDocNum(replaceNull(request.getParameter("billdocNum" + i)));
				
		bean.setDocDate(replaceNull(request.getParameter("billdocDate" + i)));

		bean.setBillTotAmt(replaceNull(request.getParameter("billTotalAmt" + i)));

		bean.setTotOutStdAmt(replaceNull(request.getParameter("billtotOutStdAmt" + i)));
				
		bean.setPatientId(replaceNull(request.getParameter("patient_id" + i)));	
				
		bean.setEpisodeType(replaceNull(request.getParameter("episode_type" + i)));	
				
		bean.setEpisodeId(replaceNull(request.getParameter("episode_id" + i)));	
				
		bean.setVisitId(replaceNull(request.getParameter("visit_id" + i)));	
				
		bean.setRefundAmt(replaceNull(request.getParameter("refundAmnt" + i)));
				
		bean.setCustCode(replaceNull(request.getParameter("custCode" + i)));
				
		bean.setExcemptedAmt(replaceNull(request.getParameter("excempted_amt" + i)));	
		bean.setRemSlmtAmt(replaceNull(request.getParameter("rem_slmt_amt" + i)));
		bean.setBillPrintYn(replaceNull(request.getParameter("bill_print_yn" + i)));
		System.err.println("bill_print_yn"+bean.getBillPrintYn());
		try{
			userSlmtAmt = userSlmtAmt+Double.parseDouble(bean.getRemSlmtAmt());
		}
		catch(Exception e){
			userSlmtAmt = userSlmtAmt+0.0;
		}				
				
		if(!("".equals(bean.getDocTypeCode()) && "".equals(bean.getDocNum()) && "".equals(bean.getDocDate()) && "".equals(bean.getBillTotAmt())&& "".equals(bean.getPatientId())&& "".equals(bean.getEpisodeType())&& "".equals(bean.getEpisodeId())&& "".equals(bean.getVisitId())&& "".equals(bean.getTotOutStdAmt())  )){
			billDetailsList.add(bean);
		}				
		}
			
		billDtlMap.put("REPRINT", billDetailsList);			
		out.println(userSlmtAmt);
			
	}catch (Exception e) {	
		e.printStackTrace();
		System.err.println("Exception :" + e);
	}
	finally
	{
		if(connection!=null) ConnectionManager.returnConnection(connection);
	}
	putObjectInBean(beanId,billDetailsBean,request);
%>

<%!
public String checkForNull(String inp){
	return (inp==null) ? "":inp;
}
%>

	
