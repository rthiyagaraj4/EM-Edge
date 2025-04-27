
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
-----------------------------------------------------------------------
Date       Edit History   Name        	Description
-----------------------------------------------------------------------
?             100         ?           	created
27/01/2012	IN030566	Ramesh G		Place a order of the same category>The Pin No is prompted>When we place another Order of the same category the Pin No. is prompted again even if the Patient chart is not closed.
--------------------------------------------------------------------------------
Date       	Edit History   	Name        Rev.Date		Rev.Name	Description
--------------------------------------------------------------------------------
24/12/2015	IN058704		Karthi L								MMOH-SCF-0323 - IN058704
--------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*"      contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");
	String bean_id = request.getParameter( "bean_id" ) ;
	//String bean_name = request.getParameter( "bean_name" ) ;
	String validate = request.getParameter( "validate" ) ;
	String templocale=(String) session.getAttribute("LOCALE") ;
	
	if ( bean_id == null || bean_id.equals( "" ) )
		return ;

	if ( validate == null || validate.equals( "" ) )
		return ;

		//ExternalOrdersBean beanObj = (ExternalOrdersBean)mh.getBeanObject( bean_id, request , "eOR.ExternalOrdersBean") ;
		ExternalOrdersBean beanObj = (ExternalOrdersBean)getBeanObject( bean_id, "eOR.ExternalOrdersBean", request ) ;
		beanObj.setLanguageId( (String) session.getAttribute("LOCALE") ) ;
		Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
		 hash = (Hashtable)hash.get( "SEARCH" ) ;
		 String patient_id = (String)hash.get("patientId") ;
		//[30566] Starts
		try{			
			if((session.getAttribute("TEMP_PASS")!=null) && (session.getAttribute("TEMP_PASS")!="")){
				HashMap mHash = new HashMap();
				mHash = (HashMap) session.getAttribute("TEMP_PASS");
				if(mHash.containsKey(patient_id)){
					mHash.remove(patient_id);
				}
				session.setAttribute("TEMP_PASS",mHash);
			}
		}catch(Exception ee)
		{	
			out.println("Exception in OpenChartWrapper.jsp for TEMP_PASS Session-- "+ee.toString()+"--");
			ee.printStackTrace();
		}
		//[30566] Ends
		 ArrayList OrderTypeData = beanObj.getPatientName(patient_id) ;
			if(OrderTypeData.size()==0)
				out.println("InvalidPatient();");
		 for( int i=0 ; i< OrderTypeData.size() ; i++ ) {
			String[] record = (String[])OrderTypeData.get(i);
	
			out.println("addpatient(\""+record[0]+"\",\""+templocale+"\",\""+record[3]+"\");") ; //MMOH-SCF-0323 - IN058704
			out.println("addsex(\""+record[1]+"\");") ;
			out.println("addage(\""+record[2]+"\");") ;
			out.println("adddob(\""+record[3]+"\");") ;
		}
		putObjectInBean(bean_id,beanObj,request);
%>
