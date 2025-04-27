<%@page  import=" eST.*,eST.Common.*,java.util.*,java.sql.*,webbeans.eCommon.*"
contentType="text/html;charset=UTF-8"%>  
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<jsp:useBean id="alSelectedRemarks" scope="session" class="java.util.ArrayList"/>
<%
	request.setCharacterEncoding("UTF-8");
	String locale					=		(String)session.getAttribute("LOCALE");
	String bean_id					=		request.getParameter("bean_id");
	String bean_name				=		request.getParameter("bean_name");
	int functionType				=		Integer.parseInt(request.getParameter("function_type"));

	if ((bean_id == null) || (bean_id.equals("")))
		return;
	TransactionRemarksBean bean		=		(TransactionRemarksBean)getBeanObject(bean_id,bean_name,request);
	bean.setLanguageId(locale);

	Hashtable hash					=		(Hashtable) XMLobj.parseXMLString(request);
    hash							=		(Hashtable) hash.get ("SEARCH");
	
	switch (functionType) {
		case 1: 
			{
					if (hash.size() > 0) {
						bean.updateSelectedRemarks(hash);
					}
			}
			break;
			case 2: 
			{	
					bean.clear();
					bean.setSelect_All("");
					String trans_type		=		request.getParameter("trans_type");
					bean.setTransaction_Type(trans_type);
				
			}
			break;
			case 3: 
			{	
					String select_all		=		(String)request.getParameter("select_all")==null?"":(String)request.getParameter("select_all");
					String totalRecords		=		request.getParameter("totalRecords");
					if(select_all.equals("Y"))bean.setSelect_All(select_all);
					bean.setTotalRemarks(Integer.parseInt(totalRecords));
					if (hash.size() > 0) {
						bean.updateSelectedRemarks(hash);
					}
								
			}
			break;
			case 4: 
			{	
					String total_records	= (String)hash.get("obj");
					bean.setTotalRemarks(Integer.parseInt(total_records));
					
				
			}
			break;
			//Added by Rabbani INC NO:34758(RUT-CRF-0082) on 07/02/2013 Starts
			case 5:
			{	   
					String hdrremarks_reqd	= (String)request.getParameter("hdrremarks_reqd")==null?"N":(String)request.getParameter("hdrremarks_reqd"); 
					bean.setHdrRemarks_Reqd(hdrremarks_reqd);	
			} 
			break;
			case 6:
			{	    
			        
					String trans_type		=		request.getParameter("trans_type");
					//bean.setTransaction_Type(trans_type);
					String  remarks_mandatory=bean.checkForNull((String)bean.fetchRecord("SELECT HDR_REMARKS_REQD FROM ST_TRN_TYPE_FOR_REMARKS WHERE TRN_TYPE= ?",trans_type).get("HDR_REMARKS_REQD"),"N");
					System.out.println("remarks_mandatory==validate==hdr=858==>" +remarks_mandatory);
					if(remarks_mandatory.equals("Y")){
					out.println("document.frmTransactionRemarksHeader.remarks_mandatory.checked=true");
					out.println("document.frmTransactionRemarksHeader.remarks_mandatory.value ='Y'");
					}
			}
			break;
			//ends
		default :
			out.println("alert(\'Invalid Function : "+functionType+"\');");
			return;
	}
%>
<%
	putObjectInBean(bean_id,bean,request);
%>
