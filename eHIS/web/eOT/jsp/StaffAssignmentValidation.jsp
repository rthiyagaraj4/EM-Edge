<!DOCTYPE html>
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

	String bean_id = "ot_StaffAssignmentBean";
	String bean_name = "eOT.StaffAssignmentBean";
	StaffAssignmentBean staffAssignmentBean = (StaffAssignmentBean)getBeanObject( bean_id, bean_name, request ) ;



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
			List<StaffAssignmentTimeBean> timeBeanList = new ArrayList<StaffAssignmentTimeBean>();
			List<String> operRoomCodeList = new ArrayList<String>();
			StaffAssignmentTimeBean timeBean = null;
			
			int totalRec = Integer.parseInt(rowCount);
			
			
			String operRoomCodeStr = (String)hash.get("operRoomCode");
			String [] operRoomCodeArray = operRoomCodeStr.split("~");
			
			for(String operRoomCode : operRoomCodeArray)
			{
				operRoomCodeList.add(operRoomCode);
				int recFound = 0;
				for(int i=1; recFound<totalRec; i++)
				{
					timeBean = new StaffAssignmentTimeBean();
					
					timeBean.setAssignmentDate((String)hash.get("assignmentDate"));
					timeBean.setOperRoomCode(operRoomCode);
					
					timeBean.setStaffId((String)hash.get("practitionerId_"+i));
					
					if(timeBean.getStaffId() != null && !timeBean.getStaffId().trim().equals(""))
					{
						recFound++;
					}
					else
					{
						continue;
					}
					timeBean.setRoleId(getRoleId((String)hash.get("roleType_"+i)));
					timeBean.setStaffId((String)hash.get("practitionerId_"+i));
					timeBean.setFromTime((String)hash.get("fromTime_"+i));
					timeBean.setToTime((String)hash.get("toTime_"+i));
					timeBean.setShowWidgetYN((String)hash.get("showWidgetYN_"+i));
					
					timeBeanList.add(timeBean);
				}
			}
			staffAssignmentBean.setOperRoomCodeList(operRoomCodeList);
			staffAssignmentBean.setTimeList(timeBeanList);
		}
		else if(func_mode!= null && func_mode.equals("UPDATE"))
		{
			String dateCount	= (String)hash.get("dateCount");
			String indexSuffix = null;
			List<StaffAssignmentTimeBean> timeBeanList = new ArrayList<StaffAssignmentTimeBean>();
			List<StaffAssignmentTimeBean> insertTimeBeanList = new ArrayList<StaffAssignmentTimeBean>();
			StaffAssignmentTimeBean timeBean = null;
			
			int totalRec = Integer.parseInt(dateCount);
			
			boolean insert = false;
			for(int dateIndex=1; dateIndex<=totalRec; dateIndex++)
			{
				
				int timeRec = Integer.parseInt((String)hash.get("rowCount" + dateIndex));
				int recFound = 0;
				
				for(int i=1; recFound<timeRec-1; i++)
				{
					insert = false;
					timeBean = new StaffAssignmentTimeBean();
					indexSuffix =  dateIndex + "_" + i;
					timeBean.setAssignmentDate((String)hash.get("assignmentDate" + dateIndex));
					timeBean.setOperRoomCode((String)hash.get("operRoomCode" + dateIndex));
					
					
					timeBean.setStaffId((String)hash.get("practitionerId" + indexSuffix));
					
					if(timeBean.getStaffId() != null && !timeBean.getStaffId().trim().equals(""))
					{
						recFound++;
					}
					else
					{
						continue;
					}
					
					String staffAssigmentId = (String)hash.get("staffAssignmentId" + indexSuffix);
					
					if(staffAssigmentId != null && !staffAssigmentId.equals(""))
					{
						String rowModified = (String)hash.get("rowModified" + indexSuffix);
						
						// If row is not modified ignore
						
						if(rowModified == null || !rowModified.equals("Y"))
						{
							continue;
						}
						timeBean.setStaffAssginmentId(Integer.parseInt(staffAssigmentId));	
						
					}
					else
					{
						insert = true;
					}
						
					timeBean.setRoleId(getRoleId((String)hash.get("roleType"+ indexSuffix)));
					timeBean.setFromTime((String)hash.get("fromTime"+ indexSuffix));
					timeBean.setToTime((String)hash.get("toTime"+ indexSuffix));
					timeBean.setShowWidgetYN((String)hash.get("showWidgetYN"+ indexSuffix));
					
					if(insert)
					{
						insertTimeBeanList.add(timeBean);
					}
					else
					{
						timeBeanList.add(timeBean);
					}
				}
			}
			staffAssignmentBean.setUpdateTimeBeanList(timeBeanList);
			staffAssignmentBean.setTimeList(insertTimeBeanList);
			
			
			//Code to check deleted record
			
			String deleteId = (String)hash.get("deleteId");
			if(deleteId != null && !deleteId.equals(""))
			{
				List<Integer> deleteIdList = new ArrayList<Integer>();
				String [] deleteIdArray = deleteId.split("~");
				
				for(String assignId :  deleteIdArray)
				{
					deleteIdList.add(Integer.parseInt(assignId));
				}
				staffAssignmentBean.setStaffAssignmentIdDeleteList(deleteIdList);
			}
		}
	
	}catch (Exception e) {
	
		e.printStackTrace() ;
		System.out.println("Exception from StaffAssignmentBeanValidation :" + e);
	}

	putObjectInBean(bean_id,staffAssignmentBean,request);

%>

