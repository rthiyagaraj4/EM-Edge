<%@page import="java.util.*, ePH.Common.*, ePH.* " contentType="text/html;charset=UTF-8"%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ page import="javax.servlet.http.HttpServletResponse" %>
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		

	String bean_id			= request.getParameter( "bean_id" ) ;
	String bean_name		= request.getParameter( "bean_name" ) ;
	String dcode				= request.getParameter( "dispense_code" ) ;
	String function			=request.getParameter("function");
	ecis.utils.OnlineReports onlineReports		=	null;
	ecis.utils.OnlineReport report1				=	null;
	
	String scheduleStartTime1= null;
	if ( bean_id == null || bean_id.equals( "" ) )
		return ;
	
	Hashtable hash				= (Hashtable)XMLobj.parseXMLString( request ) ;
    hash						= (Hashtable)hash.get( "SEARCH" ) ;

    PHPickListBean bean = (PHPickListBean)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(locale);
	if(!function.equals("GENERATEFILLLIST") && !function.equals("assignAltDrug") && !function.equals("assignBtchDtls") && !function.equals("GENERATEPICKlIST")){
		bean.clear();
	}
	  if(function.equals("GENERATEPICKlIST")){ // Added by Himanshu For PickList on 17/03/2024 Against GHL-CRF-0672.1
		  
		  String patient_id			= request.getParameter( "patient_id" ) ;
			String arr_of_orders[]		= request.getParameterValues( "arr_of_orders" ) ;
			String facility_id				= request.getParameter( "facility_id" ) ;
			String Nursing_Unit_From_Code				= request.getParameter( "Nursing_Unit_From_Code" ) ;
			String pick_int_start_date_time				= request.getParameter( "fill_int_start_date_time" ) ;
			String pick_int_end_date_time				= request.getParameter( "fill_int_end_date_time" ) ;
			String disp_locn_code				= request.getParameter( "disp_locn_code" ) ;
			System.out.println("Nursing_Unit_From_Code"+Nursing_Unit_From_Code);
			System.out.println("fill_int_start_date_time"+pick_int_start_date_time);
			System.out.println("fill_int_end_date_time"+pick_int_end_date_time);
			String patArray = (String) hash.get( "patArray" );
			String orderArray = (String) hash.get( "orderArray" );
			String patient_orderdetail = (String) hash.get( "patient_orderdetail" );
			String formattedOrderIds="";
			System.out.println("fill_int_end_date_time2 "+pick_int_end_date_time);
			String arrpatorder[];
			StringTokenizer st1	 = new StringTokenizer(orderArray, ",");
			ArrayList selectOrder=new ArrayList();
				while (st1.hasMoreTokens())
				{
					selectOrder.add(st1.nextToken());
				}
			HashMap map = (HashMap)bean.updatepicklistFlag("", selectOrder,facility_id); 
			boolean result	= ((Boolean)map.get("result")).booleanValue();
			String message	= (String)map.get("message");
			String flag		= (String)map.get("flag");
			if(message==null) message		=	"";
			if(flag==null) flag		=	"";
			System.out.println(result);
			boolean flag1=false;
			System.out.println("arr_of_orders[0].toString()===> "+patient_orderdetail);
			
			arrpatorder = patient_orderdetail.toString().split("#");
			for(String pat_ord:arrpatorder)
			{
				if(!pat_ord.equals("")){
				arr_of_orders=pat_ord.split("@@@");
				String[] orderIds = arr_of_orders[1].split(",");
				StringBuilder orderIdBuilder = new StringBuilder();
				for (String orderId : orderIds) {
                    orderId = orderId.replace("'", "").trim();
                    orderIdBuilder.append("'");
                    orderIdBuilder.append(orderId);
                    orderIdBuilder.append("',");
                }
				 formattedOrderIds = orderIdBuilder.toString();
				 formattedOrderIds = formattedOrderIds.replaceAll(",$", "");
				 formattedOrderIds = formattedOrderIds.substring(1, formattedOrderIds.length() - 1);
				 flag1=bean.doPrinting(request,response,arr_of_orders[0].toString(),formattedOrderIds,pick_int_start_date_time,pick_int_end_date_time,disp_locn_code,Nursing_Unit_From_Code);
				}
			}
			out.println("assignResult(" + result + ", \"" + bean.replaceNewLineChar(message) + "\", \"" + flag + "\");");
		}
	  
	  

putObjectInBean(bean_id,bean,request);
%>
