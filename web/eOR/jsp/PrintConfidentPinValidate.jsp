
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Rev.Date	Rev.Name			Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           									created
17/11/2015		IN057113		Karthi											ML-MMOH-CRF-0335 - IN057113  								 
26/11/2015		IN058533		Karthi											System does not prompt for PIN in Record Charts Function	
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*, java.sql.*,webbeans.eCommon.*,java.io.* "%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
 <%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");
	
	String validate = request.getParameter( "p_validate" ) == null?"":request.getParameter( "p_validate" ) ;
	String localeName = request.getParameter( "p_localeName" ) == null?"":request.getParameter( "p_localeName" );
	String patient_id = request.getParameter("p_patient_id")==null?"":request.getParameter("p_patient_id");
	String encounter_id = request.getParameter("p_encounter_id")==null?"":request.getParameter("p_encounter_id");
	String order_id = request.getParameter("p_order_id")==null?"":request.getParameter("p_order_id"); 
	String accession_num = request.getParameter("p_accession_num")==null?"":request.getParameter("p_accession_num"); 
	String print_req_from =request.getParameter("p_print_req_from")==null?"":request.getParameter("p_print_req_from");
	String event_code = request.getParameter("p_chart_id")==null?"":request.getParameter("p_chart_id"); //IN058533
	
	try {
		
		Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
	    hash = (Hashtable)hash.get( "SEARCH" ) ;
	    Connection con = null;
	    PreparedStatement pStatement = null;
	    String selectQuery = null;
	    ResultSet resultSet = null;
	    int noOfRecsSelected = 1;
	    String multi_accession_nos = "";
	    if(print_req_from.equals("CEH_MULTI_PRINT")){
	    	eCA.PatientBannerGroupLine manageEmailBean = null;
	    	manageEmailBean = (eCA.PatientBannerGroupLine)getObjectFromBean("manageEmailBean"+patient_id+encounter_id,"eCA.PatientBannerGroupLine",session);
	    	ArrayList keyList = manageEmailBean.returnList2();
	    	if(keyList != null){
	    		noOfRecsSelected = keyList.size();	
	    		Iterator iterator = keyList.iterator();
	    		String itrValues = "";
	    		while(iterator.hasNext()) {
		    		itrValues = (String)iterator.next();
		    		
		    		StringTokenizer st = new StringTokenizer(itrValues);
		    		int i=0;
		    		String stTokens = "";
		    		while(st.hasMoreTokens()) {
		    			stTokens = st.nextToken("`");
		    			System.out.println(" MY VALUE " + stTokens);
		    			if(i==3){
		    				multi_accession_nos = stTokens+"|"+multi_accession_nos;
		    			}
		    			i++;
		    		}
		    	//	multi_accession_nos = multi_accession_nos+"|" ;
		    		
	    		}
	    		if(multi_accession_nos != "" && multi_accession_nos != null){
	    			multi_accession_nos = multi_accession_nos.substring(0,(multi_accession_nos.length()-1));
	    		}
	    		accession_num = multi_accession_nos;
	    	}
	    }
		if ("CONF_PIN_VALIDATE".equals(validate)) {
			String pinRequired =  "N";
			try {
				if(noOfRecsSelected > 0){
					selectQuery = "SELECT CA_CONF_EVENT_PIN_REQ(?, ?, ?)PINREQUIRED FROM DUAL";
					con = ConnectionManager.getConnection();
					pStatement = con.prepareStatement(selectQuery);
					pStatement.setString(1, accession_num);
					pStatement.setString(2, order_id);
					pStatement.setString(3, event_code); //IN058533
					resultSet = pStatement.executeQuery();
					while(resultSet.next()) {
						pinRequired = resultSet.getString("PINREQUIRED");
					}
				}
			} catch(Exception ex){
				System.out.println(" Exception in PrintConfidentPinValidate.jsp => " + ex.getMessage());
				ex.printStackTrace();
			} finally {
				
			}

			out.println( "isPinForPrintRequired(\"" + pinRequired  + "\") ; " ) ;
		} 
	} catch(Exception ex) {
		System.out.println("Exception in PrintConfidentPinValidate.jsp => " + ex.getMessage());
		ex.printStackTrace();
	}
	//putObjectInBean(bean_id,beanObj,request);
%>
