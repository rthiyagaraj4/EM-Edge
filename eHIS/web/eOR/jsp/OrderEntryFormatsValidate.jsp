
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*,eOR.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
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
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id = request.getParameter( "bean_id" ) ;
	String validate = request.getParameter( "validate" ) ;
	//String form = request.getParameter( "form" ) ==null?"":request.getParameter( "form" );
	String default_val = "";
	String SequenceNumber = "";
	String format_id = "";
	try{
		default_val  = request.getParameter( "default_val" ) ;
		if ( default_val == null || default_val.equals( "" ) )
			default_val = "" ;
		SequenceNumber  = request.getParameter( "SequenceNumber" ) ;
		format_id  = request.getParameter( "format_id" ) ;

		if ( SequenceNumber == null || SequenceNumber.equals( "" ) )
			SequenceNumber = "" ;

		if ( format_id == null || format_id.equals( "" ) )
			format_id = "" ;
	}catch(Exception e){
		e.printStackTrace();
	}
	if ( bean_id == null || bean_id.equals( "" ) )
		return ;

	if ( validate == null || validate.equals( "" ) )
		return ;


	OrderEntryFormats beanObj = (OrderEntryFormats)getBeanObject( bean_id , "eOR.OrderEntryFormats", request) ;
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" ) ;
	String order_category = (String)hash.get("order_category") ;
	String getdefaultValue		= (String)hash.get("default_val") ;
	
	if ( validate.equals( "ord_cat" ) ) 
	{
		//String order_category = (String)hash.get("order_category") ;
//		- to check whether the selected combinationalready exists..
//		- gets triggereed while clicking the "field mnemonic button" in the create screen
			 if(hash.containsKey("dupchk"))
			 {
				String ord_category	= (String)hash.get("order_category") ;
				String level			= (String)hash.get("level") ;
				String order_type		= (String)hash.get("order_type") ;
				String ord_catalog		= (String)hash.get("ord_catalog") ;
				
				int count=  0;
				beanObj.setLanguageId( (String) session.getAttribute("LOCALE") ) ;
				count = beanObj.checkForDuplicate(level, ord_category,order_type,ord_catalog );
				out.println( "recordCnt(\"" + count + "\") ; " ) ;
//		 - to populate the values of the defalut option in modal window in the case of LIST - Begin
			}
			else if(hash.containsKey("mnemonic"))
			{
				String mnemonic = (String)hash.get("mnemonic") ;
				if(mnemonic.equals("EXAM_VIEW_REQSTD") && order_category.equals("RD"))
				{
					ArrayList DefaultData = beanObj.getDefaultData() ;
					String[] record =null;
					for( int i=0 ; i< DefaultData.size() ; i++ ) 
					{

						record = (String[])DefaultData.get(i);
						out.println( "addListValues(\""+record[0]+"\",\""+record[1]+"\",\""+default_val+"\") ; " ) ;
					}
				}
				else
				{
					//ArrayList OrderTypeData = null;
					String OrderTypeDataCons ="";
					if((order_category!=""|| !order_category.equals("")) && (mnemonic!=""|| !mnemonic.equals(""))){
						if((SequenceNumber!=""|| !SequenceNumber.equals("")) && (format_id!=""|| !format_id.equals("")))
						{
							
							//OrderTypeData= beanObj.getListTypeData1(order_category,mnemonic,SequenceNumber,format_id) ;	
							OrderTypeDataCons = beanObj.getListTypeConstruct(order_category,mnemonic,SequenceNumber,format_id) ;
							//out.println("parent.list_bottom.document.getElementById("deflt_value2").innerHTML =\""+OrderTypeDataCons+"\"");
							out.println( "clearDefaultList('document') ; " ) ;
							out.println( "addList_Values(\" " +OrderTypeDataCons + "\") ; " ) ;
						}
						else
						{
							//OrderTypeData= beanObj.getListTypeData(order_category,mnemonic) ;
							OrderTypeDataCons = beanObj.getListTypeConstruct(order_category,mnemonic) ;
							out.println( "clearDefaultList('document') ; " ) ;
							out.println( "addList_Values(\" " +OrderTypeDataCons + "\") ; " ) ;
						}
						//String OrderTypeDataCons = beanObj.getListTypeConstruct(order_category,mnemonic) ;
						//if(order_category.equals("RX")&&mnemonic.equals("ABCD"))

						if(default_val!="" && default_val.equals("L"))
						{
							out.println( "clearDefaultList('document') ; " ) ;
							out.println( "addList_Values(\" " +OrderTypeDataCons + "\") ; " ) ;
						}
						/*else
						{
						for( int i=0 ; i< OrderTypeData.size() ; i++ ) {
							String[] record = (String[])OrderTypeData.get(i);
							out.println( "addListValues(\" " +record[0] + "\",\"" + record[0] + "\",\""+default_val+"\") ; " ) ;
						}
						}*/
					}
				}
				
//		 - to populate the values of the defalut option in modal window in the case of LIST - End
			}
			else
			{
				String level = (String)hash.get("level") ;
				if ((!order_category.equals("PH")) && (level != null && level.equals("H")))
					out.println("clearList1('document');");
				else
					out.println( "clearL2List('document') ; " ) ;

				ArrayList OrderTypeData = beanObj.getOrderTypeData(order_category) ;
				for( int i=0 ; i< OrderTypeData.size() ; i++ ) 
				{
					String[] record = (String[])OrderTypeData.get(i);
					out.println( "addOrderTypeList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
				}
			}
	}
	else if(validate.equals("Formatvalues"))
	{
				String key = beanObj.checkForNull(request.getParameter("key"),"") ;
				String value = beanObj.checkForNull(request.getParameter("value"),"") ;	
				beanObj.setFormatListValues(key,value);
	}
	else if ( validate.equals( "getdefValue" ) )
	{
				String defKeysValue=beanObj.getFormatListVal(getdefaultValue);
				out.println( defKeysValue) ;
				
	}
putObjectInBean(bean_id,beanObj,request);
	
}
catch(Exception e ) { e.printStackTrace(); }

%>
