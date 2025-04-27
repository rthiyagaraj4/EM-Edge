
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------
?				  100            ?				created
8/1/2014	  LICN_1		  Karthi			MMS Internal Issue.
--------------------------------------------------------------------------------------------------------
*/
%> 

<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,webbeans.eCommon.*"      contentType="text/html; charset=UTF-8"%>

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");
	try
	{
			Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
			hash = (Hashtable)hash.get( "SEARCH" ) ;
			String callFrom	= (String)hash.get("callFrom");
			String bean_id		= (String)hash.get("BEAN_ID");
			String bean_name	= (String)hash.get("BEAN_NAME");
			//String success	= "APP-SM0070 Operation Completed Successfully ...."; //LICN_1
			String source	= (String) (session.getAttribute("MstCodeToolbar")==null?"":session.getAttribute("MstCodeToolbar"));
			//String mandMsg = "Please select atleast one Privilege Group..."; // LICN_1
			if (bean_id == null || bean_id.equals( "" ))
			return ;
			
			AssignPrevilegeGroup beanObj = (AssignPrevilegeGroup)getBeanObject( bean_id, bean_name, request ) ;
			
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) && (getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
			{
				beanObj.setLocalEJB(true);
			}			
			
			if(callFrom.equals("populatePrevgroup"))
			{
				String grp_by_code	= (String)hash.get("GROUP_BY_CODE");
				String group_by	= (String)hash.get("GROUP_BY");
				
				//String templocale=(String) session.getAttribute("LOCALE") ;	
			   //ExternalOrdersBean beanObj = (ExternalOrdersBean)mh.getBeanObject( bean_id, request , "eOR.ExternalOrdersBean") ;
					
				//beanObj.setLanguageId( (String) session.getAttribute("LOCALE") ) ;
					
				 ArrayList OrderTypeData = beanObj.getPrevcode(grp_by_code) ;
					if(OrderTypeData.size()==0)
						out.println("InvalidPrevcode(\""+group_by+"\");");
				 for( int i=0 ; i< OrderTypeData.size() ; i++ ) {
					String[] record = (String[])OrderTypeData.get(i);
			
					out.println("addPrevcode(\""+record[0]+"\",\""+record[1]+"\");") ;
					
				}
				putObjectInBean(bean_id,beanObj,request);
			}
			else if(callFrom.equals("addPrevilege"))
			{
				String privilegeId = (String)hash.get("privilegeId");
				String mode = (String)hash.get("mode");
				if(mode != null && !mode.equals(""))
				{
					if(mode.equals("ADD"))
					{
						beanObj.setPrivilegeList(privilegeId);
					}
					else if(mode.equals("REMOVE"))
					{
						beanObj.removePrivilege(privilegeId);
					}
				}
			}
			else if(callFrom.equals("savePRGroupsForPractitioner"))
			{
				String user = (String)hash.get("user");
				String appLevel = (String)hash.get("appLevel");
				String groupBy = (String)hash.get("groupBy");
				String grp_by_code = (String)hash.get("grp_by_code");
				String function_id = (String)hash.get("function_id");
				String result = "";
				//String localeName = (String)hash.get("localeName");
				if(grp_by_code != null && !grp_by_code.equals(""))
				{
					beanObj.setPrivilegeList(grp_by_code);
				}
				// LICN_1 - Start
				List privilegeList = beanObj.getPrivilegeList();
				if(privilegeList != null) {
					if(privilegeList.size() != 0){
						result = beanObj.savePrevilegeGrpsForUser(appLevel, user, groupBy);
					}
					else {
						result = "MAND_CHECK";
					}
				}
				else {
					result = "MAND_CHECK";
				}
				//LICN_1 - End
				
				if(result != null && result.equals("SUCCESS"))
				{
					out.println("f_query_add_mod.location.href = '../../eOR/jsp/AssignPrivilegeGroupMain.jsp?mode=1&function_id="+function_id+" '");
					out.println("messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num="+(MessageManager.getMessage("en","RECORD_INSERTED","SM")).get("message")+"'");  //LICN_1           
					out.println("commontoolbarFrame.location.href = '"+source+"'");
				}
				else if(result != null && result.equals("MAND_CHECK")){ // LICN_1 - START
					out.println("messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num="+(MessageManager.getMessage("en","MAND_CHECK","OR")).get("message")+"'");
					out.println("commontoolbarFrame.location.href = '"+source+"'");
				} // END
				else
				{
					
					out.println("f_query_add_mod.location.href = '../../eOR/jsp/AssignPrivilegeGroupMain.jsp?mode=1&function_id="+function_id+" '");
					out.println("messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num="+(MessageManager.getMessage("en","OPERATION_FAILED","OR")).get("message")+"'");
					out.println("commontoolbarFrame.location.href ='"+source+"'");
				}
			}
			else if(callFrom.equals("removePRGroupsForAllUsers"))
			{
				String appLevel = (String)hash.get("appLevel");
				//String groupBy = (String)hash.get("groupBy");
				String grp_by_code = (String)hash.get("grp_by_code");
				String function_id = (String)hash.get("function_id");
				String localeName = (String)hash.get("localeName");
				String result = beanObj.removePrivilegeForAllusers(grp_by_code, appLevel);
				if(result != null && result.equals("SUCCESS"))
				{
					out.println("f_query_add_mod.location.href = '../../eOR/jsp/AssignPrivilegeGroupMain.jsp?mode=1&function_id="+function_id+" '");
					out.println("messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num="+(MessageManager.getMessage("en","RECORD_INSERTED","SM")).get("message")+"'");
					out.println("commontoolbarFrame.location.href = '"+source+"'");
				}
				else
				{
					
					out.println("f_query_add_mod.location.href = '../../eOR/jsp/AssignPrivilegeGroupMain.jsp?mode=1&function_id="+function_id+"s '");
					out.println("messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num="+MessageManager.getMessage(localeName,"OPERATION_FAILED","OR")+"'");
					out.println("commontoolbarFrame.location.href ='"+source+"'");
				}
				
			}

			else if(callFrom.equals("setUser"))
			{
				String user = (String)hash.get("user");

				if(user != null && !user.equals(""))
				{
					if(user.equals("RALL") || user.equals("P"))
					{
						beanObj.setDelinkSetup(true);
					}
					else
					{
						beanObj.setDelinkSetup(false);
					}
				}
				else
				{
					beanObj.setDelinkSetup(false);
				}
			}
		}
		catch(Exception e)
		{
			System.err.println("eOR.AssingPrivilegeGroupValidate.jsp,163,message=>" +  e.getMessage());
			e.printStackTrace();
		}
%>
