 <%@page import="java.util.*, ePH.Common.*, ePH.* " contentType="text/html;charset=UTF-8"%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%	
	request.setCharacterEncoding("UTF-8");
	//String locale			= (String)session.getAttribute("LOCALE");
	String bean_id = request.getParameter( "bean_id" ) ;
	String bean_name = request.getParameter( "bean_name" ) ;
	String validate = request.getParameter( "validate" ) ;	
	
	if ( bean_id == null || bean_id.equals( "" ) )
		return ;

	if ( validate == null || validate.equals( "" ) )
		return ;


	GenericNameByATCBean beanObj = (GenericNameByATCBean)getBeanObject( bean_id, bean_name,request ) ;

	Hashtable hash = ( Hashtable )XMLobj.parseXMLString( request ) ;
    hash = ( Hashtable )hash.get( "SEARCH" ) ;

	if ( validate.equals( "byATCUpdate" ) ) {
		int changedAtIndex = Integer.parseInt(hash.get("changedAtIndex").toString());
		String changedValue = (String) hash.get("changedValue");			
		ArrayList arrList = beanObj.getATCUpdatedValues();
		beanObj.setToATCUpdateMap(changedAtIndex,arrList.get(changedAtIndex).toString());
		for (int i=0;i<arrList.size();i+=15){
			if ((i+4) == changedAtIndex)
                 arrList.set(changedAtIndex,changedValue);							
		}
		beanObj.setATCUpdatedValues(arrList);			
	}

	if ( validate.equals( "resetUpdatedList" ) ) {				
		
		ArrayList arrList = beanObj.getATCUpdatedValues();
		HashMap  map = beanObj.getATCUpdateMap();		
		Set keys = map.keySet();		
		int changedAtIndex = 0;		
		for (Iterator i = keys.iterator(); i.hasNext();){
		 changedAtIndex =Integer.parseInt(i.next().toString());		 
		arrList.set(changedAtIndex,map.get(changedAtIndex).toString());
		}		
		beanObj.setATCUpdatedValues(arrList);	
		map.clear();
	}
	putObjectInBean(bean_id, beanObj, request);
%>
