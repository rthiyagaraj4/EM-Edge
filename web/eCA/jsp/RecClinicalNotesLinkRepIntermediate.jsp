<!DOCTYPE html>
<%
/*
------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------------------------------
10/05/2017    IN063865		 Raja S		11/05/2017		Ramesh Goli			ML-MMOH-CRF-0534.1
30/08/2017    IN065040		 Raja S		30/08/2017		Ramesh Goli			ML-MMOH-SCF-0787
------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%--	
	Created On	: 5/26/2010
	Created By	: Archana Dhal
	Purpose     : IN021332

--%>

<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*,java.net.URLEncoder,eCA.*" contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	try 
	{
		request.setCharacterEncoding("UTF-8");		
		Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
		hash = (Hashtable)hash.get( "SEARCH" );
		String calFrom =(String) hash.get("callFrom");

		RecClinicalNotesLinkRepBean recBean  = (RecClinicalNotesLinkRepBean)getObjectFromBean("RecClinicalNotesLinkRepBean","eCA.RecClinicalNotesLinkRepBean",session);

		if(calFrom.equals("PUTROWIDTOBEAN"))
		{
			
			String keyAction = hash.get("keyAction")== null?"":(String)hash.get("keyAction");
			String rowID = hash.get("rowID")== null?"":(String)hash.get("rowID");

			if(keyAction.equals("ADD"))
			{
				recBean.addSelectedRow(rowID);
				String rowNum = rowID.substring(4, rowID.length());
				recBean.setSelectedRowNum(rowNum);
			}
			else if(keyAction.equals("REMOVE"))
			{
				recBean.removeSelectedRow(rowID);
				String rowNum = rowID.substring(4, rowID.length());
				recBean.removeSelectedRowNum(rowNum);
			}
			/*
			//IN063865 starts
			else if(keyAction.equals("CLEAR")){
				recBean.clearBean();
			}
			//IN063865 Ends
			*/ 
			//commented for IN065040
			
		}
		else if(calFrom.equals("PUTROWNUMTOBEAN"))
		{
			List<String> rowNumLst = recBean.getSelectedRowNum();
			String rowNum = ",";
			if(rowNumLst != null)
			{
				for(String row : rowNumLst)
				{
					rowNum =  rowNum + row+",";
				}
			}			out.println("parent.RecClinicalNotesLinkHistRepCriteriaFramenew.document.RecClinicalNotesLinkHistRepCriteriaForm.selectitems.value = '"+rowNum+"';");
			putObjectInBean("RecClinicalNotesLinkRepBean", recBean, session);
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}

%>
