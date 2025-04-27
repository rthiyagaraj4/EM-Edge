<!DOCTYPE html>
<%@page import="webbeans.eOT.DisplayMappingBean"%>
<%@page import="webbeans.eOT.DisplayMappingDtlBean"%>
<%@page import="webbeans.eOT.StaffAssignmentBean"%>
<%@page import="webbeans.eOT.StaffAssignmentTimeBean"%>
<%@page  contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.Hashtable,java.util.ArrayList, java.util.HashMap,java.util.Enumeration" %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%!

	public String getRoleId(String roleID)
	{
		if(roleID != null && !roleID.equals("") && roleID.indexOf("~") > 0)
		{
			String [] roleIdArray = roleID.split("~");
			return roleIdArray[0];
		}
		
		return roleID;
	}
%>
<%

	String bean_id = "ot_DisplayMappingBean";
	String bean_name = "webbeans.eOT.DisplayMappingBean";
	DisplayMappingBean displayMappingBean = new DisplayMappingBean();



	try 
	{
		
		request.setCharacterEncoding("UTF-8");
		
		String locale = (String)session.getAttribute("LOCALE");
		String func_mode = request.getParameter("func_mode");
		String event = (request.getParameter("event")==null? "":request.getParameter("event"));
		
		
		Hashtable hash = (Hashtable)xmlObj.parseXMLString( request ) ;
	    hash = (Hashtable)hash.get( "SEARCH" ) ;
	
		
		String facilityId = (String)session.getValue( "facility_id" ) ;
		String loggedInUser = (String)session.getValue("login_user");	
		String mode = (String)hash.get("mode");	
		
		
		
		if(func_mode!= null && func_mode.equals("INSERT"))
		{
			String rowCount	= (String)hash.get("rowCount");
			List<DisplayMappingDtlBean> dtlBeanList = new ArrayList<DisplayMappingDtlBean>();
			DisplayMappingDtlBean dtlBean = null;
			
			int totalRec = Integer.parseInt(rowCount);
			int recFound = 0;
			String newRow = "";
			for(int i=1; recFound<totalRec; i++)
			{
				dtlBean = new DisplayMappingDtlBean();
				
				newRow = (String)hash.get("newRow_"+i);
				dtlBean.setDisplayStatus((String)hash.get("displayStatus_"+i));
				
				if(dtlBean.getDisplayStatus() != null && !dtlBean.getDisplayStatus().trim().equals(""))
				{
					recFound++;
				}
				else
				{
					continue;
				}
				if("Y".equals(newRow))
				{
					dtlBean.setColorCode((String)hash.get("colorCode_"+i));
					dtlBean.setStatusCodeList((String)hash.get("statusCode_"+i));
					dtlBeanList.add(dtlBean);
				}
			}
			
			displayMappingBean.setDtlbeanList(dtlBeanList);
			displayMappingBean.setAutoRefreshYN((String)hash.get("autoRefreshYN"));
			displayMappingBean.setRefreshInterval((String)hash.get("refreshInterval"));
			displayMappingBean.setRefreshIntervalTime((String)hash.get("refreshIntervalTime"));
			displayMappingBean.setOperatingFacilityId(facilityId);
			String deleteId = (String)hash.get("deleteId");
			if(deleteId != null && !deleteId.equals(""))
			{
				
				displayMappingBean.setDeleteList(deleteId);
			}
		}
		
	
	}catch (Exception e) {
	
		e.printStackTrace() ;
		System.out.println("Exception from StaffAssignmentBeanValidation :" + e);
	}

	putObjectInBean(bean_id,displayMappingBean,request);

%>

