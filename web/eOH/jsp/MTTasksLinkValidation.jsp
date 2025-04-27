<!DOCTYPE html>

<%@ page import ="eOH.*, eOH.Common.*,eCommon.Common.*,java.util.ArrayList,java.util.Hashtable,java.sql.*,webbeans.eCommon.ConnectionManager"  contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
<%
	try {
		String func_mode	= request.getParameter("func_mode");
		Hashtable hash		= (Hashtable)xmlObj.parseXMLString( request ) ;
		hash				= (Hashtable)hash.get( "SEARCH" ) ;
		String bean_id		= "@MTLinkBean";
		String bean_name	= "eOH.MTLinkBean";
		MTLinkBean bean= (MTLinkBean)mh.getBeanObject( bean_id, request, bean_name );

		java.util.Properties prop = null;
		prop = (java.util.Properties) session.getValue( "jdbc" ) ;

		if(func_mode!= null && func_mode.equals("setCheckedRow")){
			try{
				String taskCode	= (String) hash.get("task_code");
				String taskDesc		= (String) hash.get("task_desc");
				taskDesc=java.net.URLDecoder.decode(taskDesc,"UTF-8");
				String seqNo		= (String) hash.get("seq_no");
				String selAlphabet		= (String) hash.get("selAlphabet");
				String select_value		= (String) hash.get("select_value");
				
				bean.setCheckedRow(selAlphabet,taskCode,taskDesc,seqNo,select_value);
				
				bean.getCheckedRow();
				out.println(bean);
				
			}catch(Exception e1){
				System.err.println("Execpetion in MTTasksLinkValidation.jsp: line 33: "+e1);
			}
		}
		else if(func_mode!= null && func_mode.equals("clearBean")){
			bean.clear();
		}
        else if(func_mode!= null && func_mode.equals("removeCheckedRow")){
			String taskCode	= (String) hash.get("task_code");
			String taskDesc		= (String) hash.get("task_desc");
			taskDesc=java.net.URLDecoder.decode(taskDesc,"UTF-8");
			String seqNo		= (String) hash.get("seq_no");
			String select_value		= (String) hash.get("select_value");
			
			bean.removeCheckedRow(taskCode,taskDesc,seqNo,select_value);
		}
		else if(func_mode!= null && func_mode.equals("getCheckedArray")){
			ArrayList checkedArray = (ArrayList)bean.getCheckedArray();
			StringBuffer  sbr= new StringBuffer();
			for (int k=0;k<checkedArray.size();k=k+3)
			{
		    String task_code= (String)checkedArray.get(k);
            String task_desc=(String)checkedArray.get(k+1);
			task_desc=java.net.URLDecoder.decode(task_desc,"UTF-8");
		    String seq_no= (String)checkedArray.get(k+2);
		    sbr.append(task_code+"##"+task_desc+"##"+seq_no+"##");
			}
			out.println(sbr);
		}
		else if(func_mode!= null && func_mode.equals("chkDuplicate")){
			String  flag_dup=bean.chkDuplicate();
		    out.println(flag_dup);
		}

	}catch (Exception e) {
		out.println("alert(\"" + e + "\");") ;
		e.printStackTrace();
	}
%>
