<%@ page import=" eSS.VendorLoanAckBean,java.sql.*, java.util.Hashtable,java.util.ArrayList, java.util.HashMap,java.util.Enumeration" contentType="text/html;charset=UTF-8"%>  
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
 
<%	
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	VendorLoanAckBean bean = (VendorLoanAckBean)getBeanObject("VendorLoanAckBean","eSS.VendorLoanAckBean",request);  
	bean.setLanguageId(locale);
	String validate			=	request.getParameter("validate");
	Hashtable htFormValues  = (Hashtable) XMLobj.parseXMLString(request);
    htFormValues			= (Hashtable) htFormValues.get ("SEARCH");
	String message			=	"";
	String flag				=	"";
	boolean	result			=	false;
	
	try {
		if(validate.equals("LOAD_DETAIL")){
			bean.clear();
			String doc_type_code		=	request.getParameter("doc_type_code");
			String doc_no				=	request.getParameter("doc_no");
			String req_from_date			=	request.getParameter("req_from_date");
			req_from_date					=	com.ehis.util.DateUtils.convertDate(req_from_date,"DMY",locale,"en");   
			String req_to_date			=	request.getParameter("req_to_date");
			req_to_date					=	com.ehis.util.DateUtils.convertDate(req_to_date,"DMY",locale,"en");
			String fm_vendor_code		=	CommonBean.checkForNull(request.getParameter("fm_vendor_code"),"%");
			String to_store_code		=	CommonBean.checkForNull(request.getParameter("to_store_code"),"%");
			String group_code			=	CommonBean.checkForNull(request.getParameter("group_code"),"%");
			String doc_ref				=	CommonBean.checkForNull(request.getParameter("doc_ref"),"%");
			
			bean.setDoc_type_code(doc_type_code);
			bean.setFm_vendor_code(fm_vendor_code); 
			bean.setToStore(to_store_code);
			bean.loadTFRDtlData(req_from_date,req_to_date,doc_no,group_code,doc_ref);
			result = true;
		}else if(validate.equals("LOAD_EXP_DETAIL")){
			result = true;
			String doc_no			=	request.getParameter("doc_no");
			ArrayList alExpRecords	=	new ArrayList();
			HashMap hmRecord		=	new HashMap();
			boolean resultTemp		=	false;
			String fm_vendor_code	=	request.getParameter("fm_vendor_code");
			String to_store_code	=	request.getParameter("to_store_code");
			int size = ((ArrayList)bean.getTFRExpRecords(doc_no)).size();
			
			if(!(size>0)){
				bean.loadTFRExpData(doc_no);
			}
	

		}else if(validate.equals("UPDATE_EXP_DETAIL")){
			String doc_no	=	request.getParameter("doc_no");
			HashMap hmTemp	=	new HashMap();
			ArrayList alExpRecords = new ArrayList();
			ArrayList alResult = (ArrayList)bean.getTFRExpRecords(doc_no);
			
			for(int i=0;i<alResult.size();i++){
				hmTemp = (HashMap)alResult.get(i);
				hmTemp.put("REMARKS",(String)htFormValues.get("remarks_"+i));
				alExpRecords.add(hmTemp);
				bean.setTFRExpRecords(doc_no,alExpRecords);
			}
			bean.setDoc_no(doc_no);
			result = true;
			flag="";
		}
		else if (validate.equals("ADD_TO_LIST")) {
			 try{	
					int total_rec	=	Integer.parseInt((String)htFormValues.get("total_records"));
					String checked_yn			=	"", remarks="";
					String doc_no					=	request.getParameter("doc_no");
				 	String doc_type_code			=	request.getParameter("doc_type_code");
					for(int i=0;i<total_rec;i++){
						checked_yn = (String)htFormValues.get("checkbox"+i);
						remarks = (String)htFormValues.get("remarks_"+i);
						if(checked_yn.equals("Y")){
							bean.setalGroupRecords(doc_no+"-"+(String)htFormValues.get("group_code_"+i),remarks);
						}
						else if(checked_yn.equals("N")){
							bean.removealGroupRecords(doc_no+"-"+(String)htFormValues.get("group_code_"+i));
						}
					}
					result = true;
					flag="";
				}catch(Exception e){
						result		=	false;
						message		=	e.getMessage();
						e.printStackTrace();
				}
		}
		else if (validate.equals("ADD_TO_LIST_DTL")) {
			 try{	
				String checked_yn		=	"", remarks="", group_code="";
				String doc_no			=	request.getParameter("doc_no");
				String doc_type_code	=	request.getParameter("doc_type_code");
				String i	=	request.getParameter("index");
				String groupCodes	=	request.getParameter("groupCodes");
				StringTokenizer stGroupCodes = new StringTokenizer(groupCodes.trim(),",");
				checked_yn = (String)htFormValues.get("checkbox"+i);
				while(stGroupCodes.hasMoreTokens()){
					group_code	=stGroupCodes.nextToken();
					remarks = (String)htFormValues.get("remarks_"+i);
					if(checked_yn.equals("Y")){
						bean.setalGroupRecords(doc_no+"-"+group_code,remarks);
					}
					else if(checked_yn.equals("N")){
						bean.removealGroupRecords(doc_no+"-"+group_code);
					}
				}
				result = true;
				flag="";
			}
			catch(Exception e){
				result		=	false;
				message		=	e.getMessage();
				e.printStackTrace();
			}
		}
		else if (validate.equals("CLEAR_GRP_SEL")) {
			bean.removealGroupRecords();
		}
	}catch (Exception exception) {
		result	=	false;
		message	=	exception.getMessage();
		exception.printStackTrace();
	}
	finally{
		out.println("assignResult(" + result + ",\"" + message + "\", \"" + flag + "\");") ;
	}
%>
<%
	putObjectInBean("VendorLoanAckBean",bean,request);
%>
