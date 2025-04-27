<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
--------------------------------------------------------------------------------------------------------------------------------
?				?				?				Created
11/04/2017     	INC61905       	DineshT        	The Scoring functionality In Notes should work in the similar manner as in Charts 												i.e on selection of individual variable, the score gets automatically calculated
--------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>

<%
	eCA.CASectionTemplateFieldsAssociationBean templateBean = (eCA.CASectionTemplateFieldsAssociationBean)getObjectFromBean("templateBean","eCA.CASectionTemplateFieldsAssociationBean",session);
%>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String compItemId= request.getParameter("compItemId");
	//String compIdSrlNo= request.getParameter("compIdSrlNo");
	String calledFrom= request.getParameter("calledFrom");
	int count = Integer.parseInt(request.getParameter("count"));
	String currentCompIdSrlNo = "";
	String currentCompType = "";
	String currentStatus = "";
	String currentCompTypeLinked = "";//INC61905
	//String strBeanFmtCompIdSrlNo = "";

	for(int i=0;i<count;i++)
	{
		currentCompIdSrlNo = request.getParameter("currentCompIdSrlNo"+i);
		currentCompType = request.getParameter("currentCompType"+i);
		currentCompTypeLinked = request.getParameter("currentCompTypeLinked"+i);//INC61905
		currentCompType = currentCompType.trim();		
					
		if(request.getParameter("check"+i)!=null && request.getParameter("check"+i).equals("Y"))
		{
//			strBeanFmtCompIdSrlNo = "C_"+currentCompIdSrlNo;
//			strBeanFmtCompIdSrlNo = strBeanFmtCompIdSrlNo.trim();

			//****
			//changes made to introduce the enable/disable functionality in case of list item also
			//commenting the list item related if block
			//****
			//out.println("inside bean"+currentCompIdSrlNo+" " +i);
			currentStatus = request.getParameter("status_"+currentCompIdSrlNo);
			if(currentCompType.equals("L"))
			{
			
				templateBean.setStatusEDWhenList(currentCompIdSrlNo,compItemId,currentStatus);
				//list items are taken care saparatly in CASectionTemplateUpdateListItemsBean.jsp
				templateBean.setCurrentCompTypeLinked(currentCompIdSrlNo,compItemId,currentCompTypeLinked);//INC61905
							
			}
			else
			{
				templateBean.setStatus(currentCompIdSrlNo,compItemId,currentStatus);
			}
		}
		else 
		{
			if(currentCompIdSrlNo!=null && currentCompType!=null)
				templateBean.removeStatus(currentCompIdSrlNo,compItemId);
		}
	}
	out.println(templateBean.getHashData());
	putObjectInBean("templateBean",templateBean,session);

	if(calledFrom.equals("OK"))
	{
		out.println("<script>parent.window.close();</script>");
	}

	
%>

