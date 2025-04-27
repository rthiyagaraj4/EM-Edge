<%-- 
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------------------
28/03/2019	IN068778		Selvin M		28/03/2019		Ramesh G		TBMC-CRF-0011
---------------------------------------------------------------------------------------------------------------------
--%>

<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*,eOR.*,eOR.ImageVideosMultiFileUploadBean.FileDoc" contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	try 
	{
		System.err.println("15,=============ImageVideosMultiFileUploadvalidate.jsp==============");
		request.setCharacterEncoding("UTF-8");		
		Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
		hash = (Hashtable)hash.get( "SEARCH" ) ;	
		
		ImageVideosMultiFileUploadBean fbean = (ImageVideosMultiFileUploadBean) getObjectFromBean("MULTIPLEFILEUPLOADBEAN", "eOR.ImageVideosMultiFileUploadBean", session);
		String callFrom =(String) hash.get("CallFrom");
		String fileName =(String) hash.get("fileName");
		//fileName = encode(fileName);
		String operation_mode =(String) hash.get("operation_mode");
		
		if(callFrom.equals("REMOVEDOC"))
		{	
			fbean.removeFile(fileName);	
			out.println("reLoadFrames('','')");
		}
		else if(callFrom.equals("REMOVE_SELECTED_VIDEO_LIST"))
		{	
			fbean.getUnlinkedVideoFiles().remove(fileName);
		}
		else if(callFrom.equals("CHECKANDRECORD"))
		{
			if(fbean.checkForNewDoc())
			{				
				out.println("recordFileUpload();");
			}
			else 
			{						
				out.println("alert(getMessage('RECORD_VALIDATE_ON_UPLOAD','CA'))");			
			}
		}		
		else if(callFrom.equals("CLEARBEAN"))
		{			
			fbean.clear();
		}
		putObjectInBean("MULTIPLEFILEUPLOADBEAN",fbean,session);
	}catch(Exception e){
		e.printStackTrace();	
	}
%>	 
