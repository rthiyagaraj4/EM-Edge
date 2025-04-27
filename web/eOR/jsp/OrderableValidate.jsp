<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
13/09/2013    IN030284.1 	Chowminya G 	CRF:To capture Pre-consultation orders in Appointment Scheduling - to handle $ issue (replace $$ with ~~)	
--------------------------------------------------------------------------------------------------------------------------
Date			Edit History	Name			Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------------------
14/04/2017		IN063655		Vijayakumar K											GHL-SCF-1162
06/07/2018	    IN067246		Raja S			06/07/2018		Ramesh G			GHL-CRF-0516
--------------------------------------------------------------------------------------------------------------------------
*/	
	request.setCharacterEncoding("UTF-8");
	String bean_id ="refusalOrdersBean";
	String validate = request.getParameter( "validate" ) ;
    String localeName=(String)session.getAttribute("LOCALE");
	if ( bean_id == null || bean_id.equals( "" ) )
		return ;
	if ( validate == null || validate.equals( "" ) )
		return ;	
	RefusalOrdersBean beanObj = (RefusalOrdersBean)getBeanObject( bean_id,"eOR.RefusalOrdersBean",request) ;
	beanObj.setLanguageId(localeName);
	if ( validate.equals( "ref_ord" ) ) 
	{
		Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
		hash = (Hashtable)hash.get( "SEARCH" ) ;
		String ordercat = (String)hash.get("ordercategory") ;
		String order_type = (String)hash.get("order_type") ;		
		out.println( "clearList(\"document\") ; " ) ;
		ArrayList OrderTypeData = beanObj.getLocation(ordercat) ;
		for( int i=0 ; i< OrderTypeData.size() ; i++ ) 
		{
			String[] record = (String[])OrderTypeData.get(i);
			out.println( "addLocationList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
		}
		out.println( "clearActivityList(\"document\") ; " ) ;
		ArrayList ActivityTypeData = beanObj.getActivityType(ordercat, order_type) ;
		for( int i=0 ; i< ActivityTypeData.size() ; i++ ) 
		{
			String[] record = (String[])ActivityTypeData.get(i);
			out.println( "addActivityTypeList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
		}
	} else if ( validate.equals( "ref_order_type" ) ) 
	{
		Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
		hash = (Hashtable)hash.get( "SEARCH" ) ;
	    String ordercat = (String)hash.get("ordercategory") ;
		String order_type = (String)hash.get("order_type") ;	
 		out.println( "clearActivityList(\"document\") ; " ) ;
		ArrayList ActivityTypeData = beanObj.getActivityType(ordercat, order_type) ;
		for( int i=0 ; i< ActivityTypeData.size() ; i++ ) 
		{
			String[] record = (String[])ActivityTypeData.get(i);
			out.println( "addActivityTypeList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;		
		}
	}//end of else loop
	else if(validate.equals("Remove_Temp_Order_Catalog"))
	{
		String key = beanObj.checkForNull(request.getParameter("key")) ;
		String value = beanObj.checkForNull(request.getParameter("value")) ;
		String order_type_code = beanObj.checkForNull(request.getParameter("order_type_code")) ;
		String order_category = beanObj.checkForNull(request.getParameter("order_category")) ;
		beanObj.removeTempOrderCatalogs(key+"~~"+value+"~~"+order_type_code+"~~"+order_category);
	}
	else if(validate.equals("Add_Temp_Order_Catalog"))
	{
		String key = beanObj.checkForNull(request.getParameter("key")) ;
		String value = beanObj.checkForNull(request.getParameter("value")) ;
		String order_type_code = beanObj.checkForNull(request.getParameter("order_type_code")) ;
		String order_category = beanObj.checkForNull(request.getParameter("order_category")) ;
		String nature = beanObj.getCatalogNature(key);
		int orderSetCount = beanObj.getorderSetCount();
		int dataRecordSetSize = beanObj.getTempObjectSize();//IN063655
		beanObj.setSiteSpecificYN("ORSET_IND_FOR_OPREG");//IN067246
		boolean orset_ind_flag = beanObj.isSiteSpecific("ORSET_IND_FOR_OPREG");//IN067246
		String called_from = request.getParameter( "called_from" ) ;//IN067246
		
		//if(!beanObj.containsObject(key+"~~"+value+"~~"+order_type_code+"~~"+order_category))//Commented for IN067246
		if(!beanObj.containsTempObject(key+"~~"+value+"~~"+order_type_code+"~~"+order_category))//Modified for IN067246
		{
		  //IN067246 starts	
		  if(orset_ind_flag && "OP".equals(called_from))
		  {
			if(orderSetCount>=1 && nature.equals("S"))
			{
						
				out.println("addCatalog(\"ORDER_SET_SELECTED\");");
			}else{
				beanObj.putTempObject(key+"~~"+value+"~~"+order_type_code+"~~"+order_category);
			}
		  }else 
		  {
		  //IN067246 ends
			if(nature.equals("S"))
			{
			
				//IN063655 starts
				if(dataRecordSetSize == 0)//IN063655
				{//IN063655
					if(orderSetCount>=1)
					{
						
						out.println("addCatalog(\"ORDER_SET_SELECTED\");");
					}
					else
					{
								
							beanObj.putTempObject(key+"~~"+value+"~~"+order_type_code+"~~"+order_category);
							
							out.println("addCatalog(\"SAVE\");");

					}
				}//IN063655 starts
				else
				{
					if(orderSetCount>=1)
					{
						
						out.println("addCatalog(\"ORDER_SET_SELECTED\");");
					}
					else					
					{
						out.println("addCatalog(\"BOTH_OR_CATALOG_SET_SELECTED\");");
					}
					
				}
				//IN063655 ends
			}
			else
			{
				if(orderSetCount == 0) //IN063655
				{//IN063655
					beanObj.putTempObject(key+"~~"+value+"~~"+order_type_code+"~~"+order_category);
					out.println("addCatalog(\"SAVE\");");
				}//IN063655 starts
				else
				{
					out.println("addCatalog(\"BOTH_OR_CATALOG_SET_SELECTED\");");
				}
				//IN063655 ends
			}
		  }
		}
	}
	else if(validate.equals("Remove_Order_Catalog"))
	{
		String key = beanObj.checkForNull(request.getParameter("key")) ;
		String value = beanObj.checkForNull(request.getParameter("value")) ;	
		String order_type_code = beanObj.checkForNull(request.getParameter("order_type_code")) ;
		String order_category = beanObj.checkForNull(request.getParameter("order_category")) ;
		beanObj.removeOrderCatalogs(key+"~~"+value+"~~"+order_type_code+"~~"+order_category);
	}
	else if(validate.equals("Add_Order_Catalog"))
	{
		String key = beanObj.checkForNull(request.getParameter("key")) ;
		String value = beanObj.checkForNull(request.getParameter("value")) ;	
		String order_type_code = beanObj.checkForNull(request.getParameter("order_type_code")) ;
		String order_category = beanObj.checkForNull(request.getParameter("order_category")) ;
		if(!beanObj.containsObject(key+"~~"+value+"~~"+order_type_code+"~~"+order_category))
		{
			beanObj.putObject(key+"~~"+value+"~~"+order_type_code+"~~"+order_category);
		}
	}
	else if(validate.equals("Reset_Order_Catalog"))
	{
		beanObj.clearObject();
	}
	else if(validate.equals("Submit_Order_Catalog"))
	{
		beanObj.finalOrderable();
	}
	/*Added by Uma on 1/12/2010 for IN018116*/
	else if(validate.equals("Clear_Order_Catalogs"))
	{
		beanObj.clearObject();
		beanObj.clearTempObject();
	}	
	/*Ends Here*/
	putObjectInBean(bean_id,beanObj,session);	
%>
