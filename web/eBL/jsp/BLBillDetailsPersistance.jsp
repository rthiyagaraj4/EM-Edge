<!DOCTYPE html>
<%@page  contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.Hashtable,java.util.ArrayList, java.util.HashMap,java.util.Enumeration, eBL.Common.*, eBL.*, eCommon.Common.*, webbeans.eCommon.*" %>
<%-- Mandatory declarations start  --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
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
				bean.setDocTypeCode(request.getParameter("billdocType" + i));				

				bean.setDocNum(request.getParameter("billdocNum" + i));
				
				bean.setDocDate(request.getParameter("billdocDate" + i));

				bean.setBillTotAmt(request.getParameter("billTotalAmt" + i));

				bean.setTotOutStdAmt(request.getParameter("billtotOutStdAmt" + i));
				
				bean.setPatientId(request.getParameter("patient_id" + i));	
				
				bean.setEpisodeType(request.getParameter("episode_type" + i));	
				
				bean.setEpisodeId(request.getParameter("episode_id" + i));	
				
				bean.setVisitId(request.getParameter("visit_id" + i));	
				
				bean.setExcemptedAmt(request.getParameter("excempted_amt" + i));	
				bean.setRemSlmtAmt(request.getParameter("rem_slmt_amt" + i));
				bean.setBillPrintYn(request.getParameter("bill_print_yn" + i));
				System.err.println("bill_print_yn"+bean.getBillPrintYn());
				try{
					userSlmtAmt = userSlmtAmt+Double.parseDouble(bean.getRemSlmtAmt());
				}
				catch(Exception e){
					userSlmtAmt = userSlmtAmt+0.0;
				}
				
				
				
				System.out.println(bean);
				
				if(!("".equals(bean.getDocTypeCode()) && "".equals(bean.getDocNum()) && "".equals(bean.getDocDate()) && "".equals(bean.getBillTotAmt())&& "".equals(bean.getPatientId())&& "".equals(bean.getEpisodeType())&& "".equals(bean.getEpisodeId())&& "".equals(bean.getVisitId())&& "".equals(bean.getTotOutStdAmt())  )){
					billDetailsList.add(bean);
				}
				
			}
			
			billDtlMap.put("REPRINT", billDetailsList);			
			System.out.println(bean.getDocTypeCode());
			System.out.println(bean.getDocNum());
			System.out.println(bean.getBillTotAmt());
			System.out.println(bean.getDocDate());
			System.out.println(bean.getPatientId());
			System.out.println(bean.getEpisodeType());
			System.out.println(bean.getEpisodeId());
			System.out.println(bean.getVisitId());
			System.out.println(bean.getTotOutStdAmt());
			System.out.println(bean.getExcemptedAmt());
			out.println(userSlmtAmt);
			
	}catch (Exception e) {
	
		e.printStackTrace() ;
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

	
