<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="eSS.*, eSS.Common.* , eCommon.Common.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %> 
<jsp:useBean id="alWriteOffGroupList" scope="session" class="java.util.ArrayList"/>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%
	WriteOffGroupListBean bean			= (WriteOffGroupListBean)getBeanObject( "writeOffGroupListBean",  "eSS.WriteOffGroupListBean", request) ;  
	String doc_type_code				=	request.getParameter("doc_type_code");
	String validate						=	request.getParameter("validate");

	String group_type					=	request.getParameter("group_type");
	String group_code					=	request.getParameter("group_code");
	String description					=	request.getParameter("description"); ;
	String tray_no						=	request.getParameter("tray_no");
	String write_off_reason_code		=	request.getParameter("write_off_reason_code"); 
	String write_off_reason_desc		=	request.getParameter("write_off_reason_desc"); 

	String remarks						=	request.getParameter("remarks"); 
	String write_off_cost				=	request.getParameter("write_off_cost"); 

	String index						=	request.getParameter("index");

	String message						=	"";
	String flag							=	"INVALID_VALIDATE_FLAG";
	boolean	result						=	false;

	try{
		if (validate.equals("DOC_TYPE_CODE")){
			out.println("enableDocNo("+!bean.isDocNoAutoGenYN(doc_type_code)+");");
		}
		else if (validate.equals("CLEAR_LIST")){
			alWriteOffGroupList.clear();
		}
		else if (validate.equals("TRAY_DETAIL")){
			flag="";			
			try{
				ArrayList alParameters	=	new ArrayList(2);
				alParameters.add(new Long(tray_no));
				alParameters.add(group_code);
				
				HashMap hmRecord =	bean.fetchRecord(bean.getSsRepositoryValue("SQL_SS_TRAY_DTLS_SELECT_DETAIL_WRITE_OFF"),alParameters);
				
				out.println("setTrayDetail(\""+tray_no+"\",\""+hmRecord.get("SHORT_DESC")+"\",\""+hmRecord.get("EXPIRY_DATE")+"\");");
				String write_off_value = bean.getWriteOffCost(group_code, tray_no);
				out.println("setWriteOffCost(\""+write_off_value+"\");");
				result=true;
				
			}
			catch(Exception exception){
				flag			=	"INVALID_TRAY_NO";
				result			=	false;
				out.println("setTrayDetail(\""+tray_no+"\",\"\",\"\");");
			}
		}
		else if (validate.equals("ADD_TO_LIST")){
			HashMap hmListItems	=	new HashMap();
		

			if(bean.isTrayGroupInArrayList(alWriteOffGroupList,tray_no,group_code,Integer.parseInt(index)))
				throw new Exception("RECORD_ALREADY_EXISTS");
			hmListItems.put("group_type",		group_type		);
			hmListItems.put("group_code",		group_code	);
			hmListItems.put("description",		description		);
			hmListItems.put("tray_no",				tray_no		);
			hmListItems.put("write_off_reason_code",				write_off_reason_code		);
			hmListItems.put("write_off_reason_desc",				write_off_reason_desc		);
			hmListItems.put("remarks",				remarks		);
			hmListItems.put("write_off_cost", write_off_cost	);

			if(index.equals("-1")){
				hmListItems.put("mode",bean.getCommonRepositoryValue("MODE_INSERT"));
				alWriteOffGroupList.add(hmListItems);
			}
			else{
				hmListItems.put("mode",((HashMap)alWriteOffGroupList.get(Integer.parseInt(index))).get("mode"));
				alWriteOffGroupList.set(Integer.parseInt(index),hmListItems);
			}
			result	=	true;
			message	=	"Done";
		}
	}
	catch (Exception exception){
		result	=	false;
		message	=	exception.getMessage();
	}
	finally{
		out.println(" assignResult(" + result + ", \"" + message + "\", \"" + flag + "\" ) ; ") ;
	}

putObjectInBean( "writeOffGroupListBean",bean,request);

%>
