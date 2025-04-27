<!DOCTYPE html>

<%// Page Added by Rajesh V. To Persist all the services in New Order %>

<%@page  contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.Hashtable,java.util.ArrayList, java.util.HashMap,java.util.Enumeration, eBL.Common.*, eBL.*, eCommon.Common.*, webbeans.eCommon.*" %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%!
	private String checkForNull(String input){
		if(input == null || "null".equals(input)){
			input = "";
		}
		return input;
	}
%>
<%! private String getMessageString(String messageId, Connection con) {
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	String output = "";
	String messageQuery = "select message_text_sysdef from sm_message where message_id = ?";
	try{
		pstmt = con.prepareStatement(messageQuery);
		pstmt.setString(1, messageId);
		rst = pstmt.executeQuery();
		if(rst != null && rst.next()){
			output = messageId+"-"+rst.getString("message_text_sysdef");
		}						
		
	}
	catch(Exception e){
		System.err.println("Exception in getting Message String ->"+e);
		output = messageId;
	}
	finally{
		pstmt = null;
		rst = null;
		
	}
	return output;
}	
%>

<%
	String params = request.getQueryString();
	String sqlCoverage = "";
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	String beanId = "BLChargePatientMessage" ;
	String beanName = "eBL.BLChargePatientMessage";
	Connection con = null;
	BLChargePatientMessage messageBean = (BLChargePatientMessage) getObjectFromBean(beanId, beanName, session);
	if(messageBean == null){
		messageBean = new BLChargePatientMessage();
	}
	ResourceBundle rb = null;
	Locale loc = null;
	String locale = (String) session.getAttribute("LOCALE");
	try 
	{
		loc = new Locale(locale);
		rb = ResourceBundle.getBundle("eBL.resources.Messages",loc);
		con = ConnectionManager.getConnection();
		String func_mode = request.getParameter("func_mode");
		System.err.println("func_mode"+func_mode);
		
		if(func_mode!= null && "storeErrWarn".equals(func_mode)){
			List<BLChargePatientMessage> warnList = new ArrayList<BLChargePatientMessage>();
			List<BLChargePatientMessage> errorList = new ArrayList<BLChargePatientMessage>();
					
			BLChargePatientMessage loopBean = null;
			int warningCount = 0;
			int errorCount = 0;
			try{
				warningCount = Integer.parseInt(request.getParameter("warningCount"));
			}
			catch(Exception e){
				warningCount = 0;
			}

			try{
				errorCount = Integer.parseInt(request.getParameter("errorCount"));
			}
			catch(Exception e){
				errorCount = 0;
			}
			System.err.println("warningCount"+warningCount);
			System.err.println("errorCount"+errorCount);
			if(warningCount > 0){
				String warnText = "";
				String warnServ = "";
				String warnTrx = "";
				for(int i=1;i<=warningCount;i++){
					loopBean = new BLChargePatientMessage();
					warnTrx = request.getParameter("warningTrx"+i);
					warnServ =  request.getParameter("warningServ"+i);
					warnText = request.getParameter("warningMess"+i);
					try{
						warnText = rb.getString(warnText);
					}
					catch(Exception rbException){
						warnText = getMessageString(warnText,con);
						System.err.println("Exceprion in RB ->"+rbException);
					}
					loopBean.setTrxDoc(warnTrx);
					loopBean.setBlngServ(warnServ);
					loopBean.setCode(warnText);
					warnList.add(loopBean);
				}
			}
			
			if(errorCount > 0){
				String errorText = "";
				String errorServ = "";
				String errorTrx = "";
				for(int i=1;i<=errorCount;i++){
					loopBean = new BLChargePatientMessage();
					errorTrx = request.getParameter("errorTrx"+i);
					errorServ =  request.getParameter("errorServ"+i);
					errorText = request.getParameter("errorMess"+i);
					try{
						errorText = rb.getString(errorText);
					}
					catch(Exception rbException){
						errorText = getMessageString(errorText,con);
						System.err.println("Exceprion in RB ->"+rbException);
					}
					loopBean.setTrxDoc(errorTrx);
					loopBean.setBlngServ(errorServ);
					loopBean.setCode(errorText);
					errorList.add(loopBean);
				}				
			}
			messageBean.setErrorList(errorList);
			messageBean.setWarningList(warnList);
		}
		
		
	}catch (Exception e) {
	
		e.printStackTrace() ;
		System.err.println("Exception from BL Message Persistence :" + e);
	}
	finally{
		if(con!=null) ConnectionManager.returnConnection(con);
	}
	

	putObjectInBean(beanId,messageBean,request);

%>


