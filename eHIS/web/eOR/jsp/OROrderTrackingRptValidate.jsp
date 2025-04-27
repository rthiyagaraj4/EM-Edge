<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<jsp:useBean id="beanObj" scope="page" class="eOR.PatOrderByPrivRelQueryBean"/>


<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%		request.setCharacterEncoding("UTF-8");

		Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
		hash = (Hashtable)hash.get( "SEARCH" ) ;
		String callFrom =(String) hash.get("callFrom");
		String localeName =(String) hash.get("tmplocale");
		//String order_category =(String) hash.get("order_category");
		//String order_type = request.getParameter( "order_type" ) ;

		
		if(callFrom.equals("GETDATES"))
		{
			String fromDate =(String) hash.get("fromDate");
			String chkFucn =(String) hash.get("callFrom1");			
			String toDate =(String) hash.get("toDate");
			String from_date = "";
			String to_date = "";

			if(chkFucn.equals("TODATE"))
			{
				from_date = com.ehis.util.DateUtils.minusDate(toDate,"DMYHM",localeName,1,"d");
				to_date = toDate;
			}
			else
			{
				to_date	= com.ehis.util.DateUtils.plusDate(fromDate,"DMYHM",localeName,1,"d");
				from_date = fromDate;
			}
			
			out.println( "displayDate(\"" + from_date + "\",\"" + to_date + "\") ; " ) ;
		}else if(callFrom.equals("ORDERCAT"))
		{	
			   // String bean_id = request.getParameter( "bean_id" ) ;
				//String validate = request.getParameter( "validate" ) ;
				//String localeName=request.getParameter("localeName");
                 beanObj.setLanguageId(localeName);
				//if ( bean_id == null || bean_id.equals( "" ) )
						//return ;
					
				//if ( validate == null || validate.equals( "" ) ) 
					//	return ;

				Properties properties		= (Properties) session.getValue( "jdbc" ); 

				//Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
				//hash = (Hashtable)hash.get( "SEARCH" ) ;
				//if(validate.equals("ord_cat")){
					String ordercatvalue = (String)hash.get("ordercatvalue") ;
					//System.out.println("order_category="+ordercatvalue);
					if ( ordercatvalue.equals(null) || ordercatvalue.equals( "" ) )
						ordercatvalue="";

					out.println( "clearList1('document') ; " ) ;
					
					ArrayList OrderTypeData = beanObj.getOrderTypeSpecimen(properties, ordercatvalue) ;
					for( int i=0 ; i< OrderTypeData.size() ; i++ ) {
						String[] record = (String[])OrderTypeData.get(i);
						out.println( "addLocationList1(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
					
					}


				//}else if(validate.equals("activity_type"))//{

					
				//}
		}
		else if(callFrom.equals("ORDERTYPE")){

					
				}
//putObjectInBean(bean_id,beanObj,request);
%>
