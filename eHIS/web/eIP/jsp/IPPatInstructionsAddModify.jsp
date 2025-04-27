<!DOCTYPE html>
<%--
	FileName		: IPPatInstructionsAddModify.jsp Included for the CRF - RUT-CRF-013 23396

--%>
<%@ page import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<jsp:useBean id="associateDiagBean" class="webbeans.eCommon.RecordSet" scope="session"/>
<html> 
<head>
	<%	
		request.setCharacterEncoding("UTF-8");	
	%>
	
</head>
<%  	
	String pos=(request.getParameter("position")==null)?"":request.getParameter("position"); 
	String default_yn=(request.getParameter("default_yn")==null)?"":request.getParameter("default_yn"); 
	String instruction_id="";
	String ins_dec="";
	String bkng_instrn=(request.getParameter("bkng_instrn")==null)?"":request.getParameter("bkng_instrn"); 
	String dflt_to_print="";		
	String description=(request.getParameter("description")==null)?"":request.getParameter("description"); 

	if (bkng_instrn != null && bkng_instrn.equals("")){
		int new_pos=(Integer.parseInt(pos)*4)+3;
		associateDiagBean.setObject(new_pos,default_yn);
	}
	else if (bkng_instrn != null && bkng_instrn.equals("true")){		
		try{
			TreeMap patInstructionsMap=(java.util.TreeMap)session.getAttribute("ipPatInstructionsMap");
			Integer dis_ord=new Integer(Integer.parseInt(pos));
			if (patInstructionsMap!=null){
				String instValue=(String)patInstructionsMap.remove(dis_ord);
				StringTokenizer tokenizer=new StringTokenizer(instValue,"||");
				while (tokenizer.hasMoreTokens()){
					instruction_id=tokenizer.nextToken();
					ins_dec=tokenizer.nextToken();	
					dflt_to_print=tokenizer.nextToken();
				}
				if (!description.equals("")){
					ins_dec=description;
				}
				instValue=instruction_id+"||"+ins_dec+"||"+default_yn;
				patInstructionsMap.put(dis_ord,instValue);
				session.setAttribute("ipPatInstructionsMap",patInstructionsMap);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
%>
</html>
