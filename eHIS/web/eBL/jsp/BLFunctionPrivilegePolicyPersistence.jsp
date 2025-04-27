<%// Page Added by Rajesh V. To Persist all the data visible in User Privilege Screen %>

<%@page  contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.Hashtable,java.util.ArrayList, java.util.HashMap,java.util.Enumeration, eBL.Common.*, eBL.*, eCommon.Common.*, webbeans.eCommon.*" %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
	String params = request.getQueryString();
	String sqlCoverage = "";
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	String beanId = "FunctionPrivilegeBean" ;
	String beanName = "eBL.BLFunctionPrivilegeBean";

	BLFunctionPrivilegeBean functionPrivilegeBean = (BLFunctionPrivilegeBean) getBeanObject(beanId, beanName, request);
	String facility_id = (String)session.getAttribute("facility_id");
	
	if(functionPrivilegeBean.getPayerDtlMap() == null)
	{
		functionPrivilegeBean.setPayerDtlMap(new HashMap<String, ArrayList<BLFunctionPrivilegeBean>>());
	}
	
	if(functionPrivilegeBean.getRestrictionMap() == null){
		functionPrivilegeBean.setRestrictionMap(new HashMap<String,String>());
	}
	
	HashMap<String, ArrayList<BLFunctionPrivilegeBean> > payerDtlMap = functionPrivilegeBean.getPayerDtlMap();
	HashMap<String,String> restrictionMap = functionPrivilegeBean.getRestrictionMap();
	
	Connection 	connection = null;
	try 
	{
		connection = ConnectionManager.getConnection();
		request.setCharacterEncoding("UTF-8");
		
		String locale = (String)session.getAttribute("LOCALE");
		String func_mode = request.getParameter("func_mode");
		String event = (request.getParameter("event") == null ? "" : request.getParameter("event"));
		
		Hashtable hash = (Hashtable)xmlObj.parseXMLString( request ) ;
	    hash = (Hashtable)hash.get( "SEARCH" ) ;
	
		
		String facilityId = (String)session.getValue( "facility_id" ) ;
		String loggedInUser = (String)session.getValue("login_user");	
		String mode = (String)hash.get("mode");	
		
		if(func_mode!= null && func_mode.equals("PolicyPriv"))
		{
			
			String privilegeKey = (String) hash.get("privilegeKey");
			ArrayList<BLFunctionPrivilegeBean> payerList = new ArrayList<BLFunctionPrivilegeBean>();
			BLFunctionPrivilegeBean bean = null;
			int count = Integer.parseInt((String)hash.get("rowCount"));
			for(int i=1; i<=count;i++){
				bean = new BLFunctionPrivilegeBean();
				bean.setCustGrpCode((String)hash.get("custGrpCode_" + i));
				bean.setCustGrpDesc((String)hash.get("custGrpDesc_" + i));
				bean.setCustCode((String)hash.get("custCode_" + i));
				bean.setCustDesc((String)hash.get("custDesc_" + i));
				bean.setPolicyCode((String)hash.get("policyCode_" + i));
				bean.setPolicyDesc((String)hash.get("policyDesc_" + i));
				bean.setEffFromDate((String)hash.get("effFrom_" + i));
				bean.setEffToDate((String)hash.get("effTo_" + i));
				bean.setAllowable((String)hash.get("allowableYn_" + i));
				bean.setStatus((String)hash.get("status_" + i));
				if(!("".equals(bean.getCustGrpCode()) && "".equals(bean.getCustCode()) && "".equals(bean.getPolicyCode()) && "".equals(bean.getEffFromDate()))){
					payerList.add(bean);
				}
			}
			
			payerDtlMap.put(privilegeKey, payerList);
		}
		else if(func_mode!= null && func_mode.equals("restriction")){
			String userType = (String) request.getParameter("userType");
			String userCode = (String) request.getParameter("userCode");
			String functionId = (String) request.getParameter("functionId");
			String privilegeCode = (String) request.getParameter("privilegeCode");
			String payerGroupCode = (String) request.getParameter("payerGroupCode");
			String payerCode = (String) request.getParameter("payerCode");
			String policy = (String) request.getParameter("policy");
			String effFrom = (String) request.getParameter("effFrom");
			
			if(restrictionMap.containsKey(userType+"~"+userCode+"~"+functionId+"~"+privilegeCode+"~"+payerGroupCode+"~"+payerCode+"~"+policy+"~"+effFrom)){
				out.println("No");
			}
			else{
				restrictionMap.put(userType+"~"+userCode+"~"+functionId+"~"+privilegeCode+"~"+payerGroupCode+"~"+payerCode+"~"+policy+"~"+effFrom, "Y");
			}
		}
		else if(func_mode!= null && func_mode.equals("Privilege")){
			int rowCount = Integer.parseInt((String)hash.get("privilegeListSize"));
			ArrayList<BLFunctionPrivilegeBean> beanList = new ArrayList<BLFunctionPrivilegeBean>();
			BLFunctionPrivilegeBean bean = null;
			for(int i=0;i<rowCount;i++){
				bean = new BLFunctionPrivilegeBean();
				bean.setPrivilegeCode((String)hash.get("privilegeId"+i));
				bean.setEffStatus((String)hash.get("privilege"+i));
				bean.setEffFromDate((String)hash.get("dateFrom"+i));
				bean.setEffToDate((String)hash.get("dateTo"+i));
				bean.setAllowable((String)hash.get("allowedYn"+i));
				beanList.add(bean);
			}
			functionPrivilegeBean.setUserCode((String)hash.get("rightsCode"));
			functionPrivilegeBean.setUserType((String)hash.get("rightsType"));
			functionPrivilegeBean.setFunctionId((String)hash.get("function_type"));
			payerDtlMap.put("privilege", beanList);
		}
		
	}catch (Exception e) {
	
		e.printStackTrace() ;
		System.err.println("Exception from BL Function Privilege :" + e);
	}
	finally
	{
		if(connection!=null) ConnectionManager.returnConnection(connection);
	}

	putObjectInBean(beanId,functionPrivilegeBean,request);

%>

<%!
public String checkForNull(String inp){
	return (inp==null) ? "":inp;
}
%>

