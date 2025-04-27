<%
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
06/11/2019              IN0071696          B Haribabu                                  					Alpha incident
--------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,webbeans.eCommon.*,java.sql.*,java.lang.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<jsp:useBean id="obj7" scope="page" class="eST.RTVHistoryBean"/>
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");

	int functionType = Integer.parseInt(request.getParameter("function_type"));
 	String bean_id = "RTVHistoryBean";
	String bean_name = "eST.RTVHistoryBean";
	RTVHistoryBean bean = (RTVHistoryBean) getBeanObject( bean_id,bean_name, request );  
	bean.clear();
	bean.setLanguageId(locale);
	Hashtable hash = (Hashtable) XMLobj.parseXMLString(request);
    hash = (Hashtable) hash.get ("SEARCH");
	switch (functionType) {
	case 1:
		{
		
				
				String item_code=CommonBean.checkForNull(request.getParameter("item_code"),"%");
				String supp_code=CommonBean.checkForNull(request.getParameter("supp_code"),"%");
				String fm_doc_date=CommonBean.checkForNull(request.getParameter("fm_doc_date"));
				String to_doc_date=CommonBean.checkForNull(request.getParameter("to_doc_date"));
				String finalized_yn=CommonBean.checkForNull(request.getParameter("finalized_yn"),"A");
				String store_code=CommonBean.checkForNull(request.getParameter("store_code"),"%");
				String replace_on_expiry_yn=CommonBean.checkForNull(request.getParameter("replace_on_expiry_yn"),"A");
				
					if(!locale.equals("en"))
			{
			 if((fm_doc_date!=""|| fm_doc_date!=null)||(to_doc_date!=""||to_doc_date!=null))
				{
				//Modified for IN0071696 start
				 fm_doc_date=com.ehis.util.DateUtils.convertDate(fm_doc_date,"DMY",locale,"en");
					to_doc_date=com.ehis.util.DateUtils.convertDate(to_doc_date,"DMY",locale,"en");
					bean.setFm_doc_date(fm_doc_date) ;
					bean.setTo_doc_date(to_doc_date) ;
					//Modified for IN0071696 end
				}
			}else
			{
			fm_doc_date=fm_doc_date;
to_doc_date=to_doc_date;
			bean.setFm_doc_date(fm_doc_date) ;
				bean.setTo_doc_date(to_doc_date) ;
			}  
				bean.setItem_code(item_code) ;
				bean.setSupp_code(supp_code) ;
				//bean.setFm_doc_date(fm_doc_date) ;
			//	bean.setTo_doc_date(to_doc_date) ;
				bean.setFinalized_yn(finalized_yn) ;
				bean.setStore_code(store_code) ;
				bean.setReplace_on_expiry_yn(replace_on_expiry_yn) ;
				bean.loadResultPage();
				bean.getDataList();
			
		}
		break;
		default :
		out.println("alert(\'Invalid Function\');");
		return;
	}
%>
<%
putObjectInBean(bean_id,bean,request);
%>
