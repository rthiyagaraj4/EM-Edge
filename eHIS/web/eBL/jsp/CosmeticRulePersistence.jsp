<!DOCTYPE html>
<%@page import="eBL.CosmeticRuleDAO"%>
<%@page import="eBL.CosmeticRuleDetailBean"%>
<%@page import="eBL.CosmeticRuleHeaderBean"%>
<%// Page Added by Rajesh V for KAUH-CRF-0318. To Persist all the data  %>

<%@page  contentType="text/html;charset=UTF-8" import="java.sql.*, " %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
	String beanId = "CosmeticRuleBean" ;
	String beanName = "eBL.CosmeticRuleHeaderBean";
	CosmeticRuleHeaderBean cosmeticBean = null;
	List<CosmeticRuleHeaderBean> cosmeticList = null;
	cosmeticBean = (CosmeticRuleHeaderBean) getBeanObject(beanId, beanName, request);
	String facility_id = (String)session.getAttribute("facility_id");
	String locale = (String)session.getAttribute("LOCALE");
	
	if(cosmeticBean.getCriteriaList() == null){
		cosmeticBean.setCriteriaList(new ArrayList<CosmeticRuleDetailBean>());
	}
	
	if(cosmeticBean.getExclList() == null){
		cosmeticBean.setExclList(new ArrayList<CosmeticRuleDetailBean>());
	}
	
	List<CosmeticRuleDetailBean> criteriaList = cosmeticBean.getCriteriaList();
	List<CosmeticRuleDetailBean> exclList = cosmeticBean.getExclList();
	
	try 
	{

		request.setCharacterEncoding("UTF-8");
		
		String func_mode = request.getParameter("func_mode");
		String event = (request.getParameter("event") == null ? "" : request.getParameter("event"));
		
		Hashtable hash = (Hashtable)xmlObj.parseXMLString( request ) ;
	    hash = (Hashtable)hash.get( "SEARCH" ) ;
	
		
		if(func_mode!= null && func_mode.equals("persistHeader"))
		{
			cosmeticBean.setPatientClass((String)hash.get("patientClass"));
			cosmeticBean.setBlngGroupCode((String)hash.get("blngGroupCode"));
			cosmeticBean.setCustGroupCode((String)hash.get("custGrpCode"));
			cosmeticBean.setCustCode((String)hash.get("custCode"));
			cosmeticBean.setRuleCode((String)hash.get("ruleCode"));
			cosmeticBean.setPolicyTypeCode((String)hash.get("policyCode"));
			cosmeticBean.setStatus((String)hash.get("ruleStatus"));
			
			if("".equals(cosmeticBean.getBlngGroupCode())){
				cosmeticBean.setBlngGroupCode("**");
			}
			if("".equals(cosmeticBean.getCustGroupCode())){
				cosmeticBean.setCustGroupCode("**");
			}
			if("".equals(cosmeticBean.getCustCode())){
				cosmeticBean.setCustCode("**");
			}
			if("".equals(cosmeticBean.getPolicyTypeCode())){
				cosmeticBean.setPolicyTypeCode("**");
			}
		}
		
		else if(func_mode!= null && func_mode.equals("persistExclusion"))
		{
			String chkServCode = "";
			CosmeticRuleDetailBean criteriaBean = null;
			exclList = new ArrayList<CosmeticRuleDetailBean>();
			int lastRowIndex = Integer.parseInt((String)hash.get("exclLastRow"));
			for(int i=0;i<=lastRowIndex;i++){
				chkServCode = (String)hash.get("blngServCode"+i);
				if(chkServCode != null && !"".equals(chkServCode)){
					criteriaBean = new CosmeticRuleDetailBean();
					criteriaBean.setServType((String)hash.get("inclServType"+i));
					criteriaBean.setServCode((String)hash.get("blngServCode"+i));
					criteriaBean.setInclExclYN((String)hash.get("inclExcl"+i));
					criteriaBean.setStatus((String)hash.get("inclExclStatus"+i));
					criteriaBean.setIsDelFlagYN((String)hash.get("inclExclRem"+i));
					exclList.add(criteriaBean);
				}
			}
			cosmeticBean.setExclList(exclList);
		}
		
		else if(func_mode!= null && func_mode.equals("persistCriteria"))
		{
			String chkServCode = "";
			CosmeticRuleDetailBean criteriaBean = null;
			criteriaList = new ArrayList<CosmeticRuleDetailBean>();
			int lastRowIndex = Integer.parseInt((String)hash.get("criteriaLastRow"));
			for(int i=0;i<=lastRowIndex;i++){
				chkServCode = (String)hash.get("servCode"+i);
				if(chkServCode != null && !"".equals(chkServCode)){
					criteriaBean = new CosmeticRuleDetailBean();
					criteriaBean.setServType((String)hash.get("servType"+i));
					criteriaBean.setServCode((String)hash.get("servCode"+i));
					criteriaBean.setStatus((String)hash.get("criteriaStatus"+i));
					criteriaBean.setIsDelFlagYN((String)hash.get("criteriaRem"+i));
					criteriaList.add(criteriaBean);
				}
			}
			cosmeticBean.setCriteriaList(criteriaList);
		}
		
		else if(func_mode!= null && func_mode.equals("getRuleDates")){
			String ruleCode = request.getParameter("ruleCode");
			CosmeticRuleDAO cosmeticDAO = new CosmeticRuleDAO();
			String effDates = cosmeticDAO.getEffDatesForRuleCode(ruleCode,facility_id);
			out.println(effDates);
		}
			
	}catch (Exception e) {
	
		e.printStackTrace() ;
		System.err.println("Exception in CosmeticRulePersistence ->" + e);
	}
	finally
	{
		
	}

	putObjectInBean(beanId,cosmeticBean,request);

%>

<%!
public String checkForNull(String inp){
	return (inp==null) ? "":inp;
}
%>

