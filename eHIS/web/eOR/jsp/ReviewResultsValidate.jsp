<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");
	String bean_id = request.getParameter( "bean_id" ) ;
	String bean_name = request.getParameter( "bean_name" ) ;
	String func_mode = request.getParameter( "func_mode" ) ;

	if ( bean_id == null || bean_id.equals( "" ) || bean_name== null || bean_name.equals(""))
		return ;

	if ( func_mode == null || func_mode.equals( "" ) )
		return ;

	ReviewResults beanObj = (ReviewResults)getBeanObject( bean_id,bean_name,request) ;
	beanObj.setLanguageId( (String) session.getAttribute("LOCALE") ) ;
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" ) ;
	if ( func_mode.equals( "EVENT_CLASS" ) ) {
		String result_type = (String)hash.get("result_type") ;
		if(result_type==null) result_type= "";
		out.println( "clearList() ; " ) ;
		ArrayList EventClass = beanObj.getEventClass(result_type);
		for( int i=0 ; i< EventClass.size() ; i++ ) {
			String[] record = (String[])EventClass.get(i);
			out.println( "addEventClass(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
		}
	} else if (func_mode.equals("FORWARD_PRACT")) {
	   String total_recs = (String)hash.get("total_recs");
	   ArrayList forwardPractHash = new ArrayList();
	   int totalRecs = 0;
	   if (total_recs != null || (!total_recs.equals(""))) {
	       totalRecs = Integer.parseInt(total_recs);
	   }
	   if (totalRecs > 0) {
	       for (int i = 0;i < totalRecs;i++) {
	           HashMap tempMap = new HashMap();
	           tempMap.put("hist_rec_type",(String)hash.get("hist_rec_type"+i));
	           tempMap.put("contr_sys_id",(String)hash.get("contr_sys_id"+i));
	           tempMap.put("accession_num",(String)hash.get("accession_num"+i));
	           tempMap.put("review_type",(String)hash.get("review_type"+i));
	           tempMap.put("event_code",(String)hash.get("event_code"+i));
	           tempMap.put("normalcy_ind",(String)hash.get("normalcy_ind"+i));
	           forwardPractHash.add(tempMap);
	       }
	       beanObj.setForwardPractHash(forwardPractHash);
	   }
	}  else if (func_mode.equals("INSERT_FORWARD_PRACT")) {
	/*   String total_recs = (String)hash.get("total_recs");
	   ArrayList forwardPract_id = new ArrayList();
	   int totalRecs = 0;
	   if (total_recs != null || (!total_recs.equals(""))) {
	       totalRecs = Integer.parseInt(total_recs);
	   }
	   if (totalRecs > 0) {
	       for (int i = 0;i < totalRecs;i++) {
	           forwardPract_id.add((String)hash.get("pract_id"+i));
	       }
	       HashMap map = beanObj.insertForwardPract_id(forwardPract_id);
	      // Out.println("alert(getMessage('"+map.get("message")+"'))");
	      out.println("msg='"+map.get("message")+"'");
	      System.out.println("msg="+map.get("message")+"====");
	   }*/
	}
	putObjectInBean(bean_id,beanObj,request);
%>
