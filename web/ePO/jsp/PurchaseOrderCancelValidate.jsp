<%@page import="java.util.*,ePO.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
	String bean_id				=	request.getParameter("bean_id");
	String bean_name			=	request.getParameter("bean_name");
	int functionType			=	Integer.parseInt(request.getParameter("function_type"));

	request.setCharacterEncoding("UTF-8");
	String locale				=	(String)session.getAttribute("LOCALE");
	boolean result			=		false;
	String message			=		"";
	String flag				=		"";
	
	
	if ((bean_id == null) || (bean_id.equals("")))
		return;
	PurchaseOrderCancelBean bean		=	(PurchaseOrderCancelBean) getBeanObject(bean_id,bean_name,request);
	bean.setLanguageId(locale);
	Hashtable hash				=	(Hashtable) XMLobj.parseXMLString(request);
    hash						=	(Hashtable) hash.get ("SEARCH");	
	
	switch (functionType) {
	case 1:
		{
		   bean.updateRemarks(hash);
		}
		break;
	case 2:
		{	
			bean.updateSelectedValues(hash);
		}
		break;
	case 3:
		{		
		String status = request.getParameter("status");
		out.println("clearListItems('formSTPOCancelOrderQueryCriteria.po_order_status'); ");
		
			if(status.equals("Close")){
				HashMap poClose = new HashMap();
			//	poClose.put("PD","Partially Delivered");
				poClose.put("PR","Partially Received");
				Iterator it = poClose.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry pairs = (Map.Entry)it.next();
					out.println("addListItem(\"formSTPOCancelOrderQueryCriteria.po_order_status\", \"" + (String)pairs.getKey() + "\",\"" + (String)pairs.getValue() + "\",\"" + "PR"+ "\");");
				}
			}else if(status.equals("Cancel")){
				HashMap poCancel = new HashMap();
				poCancel.put("FA","Fully Approved");
				poCancel.put("RA","Re Approved");
				poCancel.put("PA","Partially Approved");
				Iterator it = poCancel.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry pairs = (Map.Entry)it.next();
					out.println("addListItem(\"formSTPOCancelOrderQueryCriteria.po_order_status\", \"" + (String)pairs.getKey() + "\",\"" + (String)pairs.getValue() + "\");");
				}
			}			
		}	
		break;
	case 4:
		{	
			String key_code = request.getParameter("key");
			bean.setRemarks(key_code);
		}
		break;
	case 5:
		{	
			if(bean.getCheckItems().size() > 0)
				result = true;
			else
				result = false;
			out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;	
		}
		break;
//Added By Sakti not to allow close PO if grn_qty < delv_qty inc#40671
	case 6: 
		{	
				String po_no = request.getParameter("po_no");
				HashMap	hmRecord	=	new HashMap();
				hmRecord = bean.getPoDoQty(po_no);
				if(hmRecord.size() > 0){
				message	 = (String)hmRecord.get("message");
				if(message.equals("blocked qty exists")){
							result = true;
							flag = "blocked";
				}else
				if(message.equals("grn_qty and delv_qty not same")){
							result = true;	
							flag = "qty";
				}else
				if(message.equals("grn_unf_qty")){
							result = true;
							flag = "grn_unf_qty";
				}
				
			}

				out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
		}
		break;
		//Added ends
	default :
		//To be replaced with proper message
		out.println("alert(\'Invalid Function\');");
		return;
	}
%>
<%
putObjectInBean(bean_id,bean,request);
%>
