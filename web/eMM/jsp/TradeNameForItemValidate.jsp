
<%@page import=" eMM.*,eMM.Common.*,java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>  
<jsp:useBean id="obj"   scope="page" class="webbeans.eCommon.XMLStringParser"/>
<jsp:useBean id="alTradeNameForItemList" scope="session" class="java.util.ArrayList"/>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 

<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		//locale ="en";
//		String primary_lang		= (String)session.getAttribute("PRIMARY_LANG");
	TradeNameForItemBean bean = (TradeNameForItemBean)getBeanObject( "TradeNameForItemBean", "eMM.TradeNameForItemBean",request ) ;  
		bean.setLanguageId(locale);
	String item_code		=	request.getParameter("item_code");
	String item_desc		=	request.getParameter("item_desc");
	String trade_id			=	request.getParameter("trade_id");
	String trade_name		=	request.getParameter("trade_name");
	String manufacturer_id	=	request.getParameter("manufacturer_id");
	String manufacturer_name=	request.getParameter("manufacturer_name");
	String validate			=	request.getParameter("validate");
	String index			=	request.getParameter("index");
	String message			=	"";
	String flag				=	"";
	boolean	result			=	true;
	try{
		if (validate.equals("ITEM_DESC")) { 
			HashMap hmResult = null;
			try {
				//hmResult = 				bean.fetchRecord(bean.getMmRepositoryValue("SQL_MM_ITEM_LOOKUP"),item_code);	
				out.println("setItemDetails(\""+item_code+"\",\""+hmResult.get("description")+"\");");
			}
			catch (Exception exception) {
				//exception.printStackTrace();
				//throw new Exception("INVALID_MM_ITEM_CODE");
				throw new Exception("INVALID_MM_ITEM_CODE");
			}
		}
		else if (validate.equals("TRADE_NAME")) {
			HashMap hmResult=null;
			try { 
				ArrayList arr_lang=new ArrayList();
				arr_lang.add(trade_id);
				arr_lang.add(locale);
				hmResult= bean.fetchRecord(bean.getMmRepositoryValue("SQL_GET_AM_TRADE_NAME"),arr_lang);

				if(hmResult.get("DESCRIPTION") != null) {
					out.println("setTradeIdDetails(\""+trade_id+"\",\""+hmResult.get("DESCRIPTION")+"\");");
				}
				else {
					//throw new Exception("INVALID_AM_TRADE_ID");
				}
			}
			catch (Exception exception) {

				exception.printStackTrace();

				throw new Exception("INVALID_AM_TRADE_ID");
			}
		}
		else if (validate.equals("ASSIGN_FLAG")) {
			int flagIndex = Integer.parseInt(request.getParameter("flagIndex"));
			boolean flagValue = new Boolean(request.getParameter("flagValue")).booleanValue();	
			HashMap map = (HashMap)alTradeNameForItemList.get(flagIndex);
			if(map != null) {
				map.put("ADD",new Boolean(flagValue));
			}
		}
		else if (validate.equals("CLEAR_BEAN")) {
			bean.clear();
		}
		else if(validate.equals("MINIMUM_CHECK")) {	
			// To set the values in the bean
			bean.setTradeNameForItemList(alTradeNameForItemList);

			int sizeOfTheList = alTradeNameForItemList.size();
			int count = 0;
			for(int i=0;i<sizeOfTheList;i++) {
				HashMap map = (HashMap)alTradeNameForItemList.get(i);
				if(map.get("ADD") != null) {
					if(((Boolean)map.get("ADD")).booleanValue() != false) {
						count++;
					}
				}
			}
			if(count > 0) {
				result	=	true;
				message	=	"Done";			
			}
			else {
				result = false;				
			}
		}
		else if (validate.equals("ADD_TO_LIST")) {
//			boolean test = bean.isTradeIdInArrayList(alTradeNameForItemList,trade_id,Integer.parseInt(index));

			if(! bean.isTradeIdInArrayList(alTradeNameForItemList,trade_id,Integer.parseInt(index)) ) {
				HashMap hmTradeNameListItems=new HashMap();
				hmTradeNameListItems.put("ITEM_CODE",item_code);
				hmTradeNameListItems.put("ITEM_DESC",item_desc);			
				hmTradeNameListItems.put("TRADE_ID",trade_id);
				hmTradeNameListItems.put("TRADE_NAME",trade_name);
				hmTradeNameListItems.put("MANUFACTURER_ID",manufacturer_id);
				hmTradeNameListItems.put("MANUFACTURER_NAME",manufacturer_name);
				hmTradeNameListItems.put("MODE","1");
				hmTradeNameListItems.put("ADD",new Boolean(true));

				if (index.equals("-1")) {					hmTradeNameListItems.put("mode",eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"));
					alTradeNameForItemList.add(hmTradeNameListItems);
				}
				result	=	true;
				message	=	"Done";			
			}
			else {
				result = false;		
				throw new Exception("DUPLICATE_ENTRIES_NOT_ALLOWED");				
			}
		}
		else if (validate.equals("CLEAR")) {
			alTradeNameForItemList.clear();
		}
	}
	catch (Exception exception) {
		result	=	false;
		message	=	exception.getMessage();
	}
	finally {
		out.println(" assignValues(" + result + ", \"" + message + "\", \"" + flag + "\" ) ; ") ;
	}
putObjectInBean("TradeNameForItemBean",bean,request);
%>
