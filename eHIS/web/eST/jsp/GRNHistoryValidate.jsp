 <%
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
06/11/2019              IN0071695          B Haribabu                                  					Alpha incident
--------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
 <%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,webbeans.eCommon.*,java.sql.*,java.lang.*"
contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<jsp:useBean id="obj7" scope="page" class="eST.GRNHistoryBean"/>
<%
 request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");

	int functionType = Integer.parseInt(request.getParameter("function_type"));
	String bean_id = "GRNHistoryBean";
	String bean_name = "eST.GRNHistoryBean";
	GRNHistoryBean bean = (GRNHistoryBean) getBeanObject( bean_id,bean_name, request);  
	bean.clear();
	bean.setLanguageId(locale);
	Hashtable hash = (Hashtable) XMLobj.parseXMLString(request);
    hash = (Hashtable) hash.get ("SEARCH");
	switch (functionType) {
	case 1:
		{
				String item_code=CommonBean.checkForNull(request.getParameter("item_code"),"%");
				
				String doc_no=(String)CommonBean.checkForNull(request.getParameter("doc_no"),"%");
				System.out.println("doc_no: 27/10" +doc_no);
				String ext_doc_no =(String)CommonBean.checkForNull(request.getParameter("ext_doc_no"));
				String supp_code=CommonBean.checkForNull(request.getParameter("supp_code"),"%");
				String fm_doc_date=CommonBean.checkForNull(request.getParameter("fm_doc_date"));
				String to_doc_date=CommonBean.checkForNull(request.getParameter("to_doc_date"));
				String finalized_yn=CommonBean.checkForNull(request.getParameter("finalized_yn"),"A");
				String store_code=CommonBean.checkForNull(request.getParameter("store_code"),"%");
				String replace_on_expiry_yn=CommonBean.checkForNull(request.getParameter("replace_on_expiry_yn"),"A");
				String po_no=(String)CommonBean.checkForNull(request.getParameter("po_no"));
			//System.err.println("VALIDATE"+fm_doc_date+to_doc_date);
				if(!locale.equals("en"))
			{
			 if((fm_doc_date!=""|| fm_doc_date!=null)||(to_doc_date!=""||to_doc_date!=null))
				{
				//Modified for IN0071695 start
				 fm_doc_date=com.ehis.util.DateUtils.convertDate(fm_doc_date,"DMY",locale,"en");
					to_doc_date=com.ehis.util.DateUtils.convertDate(to_doc_date,"DMY",locale,"en");
					bean.setFm_doc_date(fm_doc_date) ;
					bean.setTo_doc_date(to_doc_date) ;
			  //bean.setFm_doc_date(com.ehis.util.DateUtils.convertDate(fm_doc_date,"DMY","en",locale));	
			//bean.setTo_doc_date(com.ehis.util.DateUtils.convertDate(to_doc_date,"DMY","en",locale));
			//Modified for IN0071695 end
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
				
				bean.setFinalized_yn(finalized_yn) ;
				bean.setStore_code(store_code) ;
				bean.setReplace_on_expiry_yn(replace_on_expiry_yn) ;
				bean.setPo_no(po_no) ;
				bean.setDoc_no(doc_no) ;   //28/10/11
				bean.setExt_doc_no(ext_doc_no) ;//28/10/11
				bean.loadResultPage();
				bean.getDataList();
				
		}
		break;
		default :
		//out.println("alert(\'Invalid Function\');");	
		return;
	}
%>
<%
putObjectInBean(bean_id,bean,request);
%>
