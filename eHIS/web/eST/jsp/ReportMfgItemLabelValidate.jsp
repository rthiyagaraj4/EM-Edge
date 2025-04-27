<%@page contentType="text/html;charset=UTF-8" import=" eST.*,eST.Common.*,java.util.*,java.sql.*,java.lang.*,webbeans.eCommon.*"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
	StockLevelReportBean bean = (StockLevelReportBean)getBeanObject( "StockLevelReportBean", "eST.StockLevelReportBean",request ) ;  
	
	String message			=	"";
	String flag					=	"";
	boolean	result			=	false;
	try{
			//String labelreqd		=request.getParameter("labelreqd")==null?"":request.getParameter("labelreqd");
			String nooflabels			=request.getParameter("nooflabels")==null?"":request.getParameter("nooflabels");
			String pdocno				=request.getParameter("docno")==null?"":request.getParameter("docno");
			String doc_type_code	=request.getParameter("doc_type_code")==null?"":request.getParameter("doc_type_code");
			String store_code		=request.getParameter("store_code")==null?"":request.getParameter("store_code");
			String report_id			=request.getParameter("report_id")==null?"":request.getParameter("report_id");
			if(!nooflabels.equals(""))
			{	
				for(int i=0;i<Integer.parseInt(nooflabels);i++)
				{
					bean.doOnlineReportPrintingOfLabel(pdocno,doc_type_code,store_code,report_id,session);
				}
			result =  true;
			message = request.getParameter("msg");

			}
		}
		catch (Exception exception) 
		{
			result		=	false;
			message	=	exception.getMessage();
			exception.printStackTrace();
		}
	finally{
		out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
	}
%>
<%
putObjectInBean("StockLevelReportBean",bean,request);
%>
