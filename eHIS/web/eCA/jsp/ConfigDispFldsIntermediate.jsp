<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCA.SectionConfigDispFldBean,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String key = request.getParameter("key")==null?"":request.getParameter("key");
	String fieldCount = request.getParameter("fieldCount")==null?"":request.getParameter("fieldCount");
	String mode = request.getParameter("mode")==null?"":request.getParameter("mode");
	String resCategory = request.getParameter("resCategory")==null?"":request.getParameter("resCategory");
	String resSubCategory = request.getParameter("resSubCategory")==null?"":request.getParameter("resSubCategory");
	String fillBean = request.getParameter("fillBean")==null?"":request.getParameter("fillBean");
	String configStrSql = request.getParameter("configStrSql")==null?"":request.getParameter("configStrSql");

	eCA.SectionConfigDispFldBean confBean = (eCA.SectionConfigDispFldBean)session.getAttribute("ConfigDispFldBean");
	if(confBean == null)
	{
		confBean	= new eCA.SectionConfigDispFldBean();
		session.setAttribute("ConfigDispFldBean", confBean);
	}

	if(fillBean != null && !fillBean.equals(""))
	{
		LinkedList<String> orderSeq = null;
		Connection con=null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try 
		{
			String qryString = "SELECT  FIELD_REF, ORDER_SEQ_NUM FROM  CA_LINK_CATEG_DEF WHERE RESULT_CATEGORY =? ORDER BY 2";
			if(resSubCategory != null && !resSubCategory.equals("") )
			{
				qryString = "SELECT  FIELD_REF, ORDER_SEQ_NUM FROM  CA_LINK_CATEG_DEF WHERE RESULT_CATEGORY =? AND RESULT_SUB_CATEGORY=?ORDER BY 2";
			}
			con = ConnectionManager.getConnection(request);
			pst = con.prepareStatement(qryString);
			pst.setString(1, resCategory);
			if(resSubCategory != null && !resSubCategory.equals("") )
			{
				pst.setString(2, resSubCategory);
			}
			rs = pst.executeQuery();
			orderSeq = new LinkedList<String>();

			while(rs.next())
			{
				orderSeq.add(rs.getString(1));
			}
		}
		catch(Exception e)
		{
			//out.println("Exception in ConfigDispFlds.jsp"+e.toString());//COMMON-ICN-0181
			e.printStackTrace();
		}
		finally
		{
			if(con != null)
			{
				ConnectionManager.returnConnection(con,request);
			}
			if(rs != null)
			{
				rs.close();
			}
			if(pst != null)
			{
				pst.close();
			}
		}
		
		if(configStrSql != null && !configStrSql.equals(""))
		{
			confBean.setSectionConfig(configStrSql, resCategory, resSubCategory, 0, 0);
		}
		else
		{
			confBean.setSectionConfig(resCategory, 0, 0);
		}

		if(orderSeq.size() > 0)
		{
			session.setAttribute("OrderSeq", orderSeq);
			confBean.setFieldOrder(orderSeq);		
		}
		else
		{
			session.setAttribute("OrderSeq", null);
		}
		if(resSubCategory == null || resSubCategory.equals(""))
			{
		%>
		<script>
			parent.ConfigDispCritList.location.href="../../eCA/jsp/ConfigDispCritList.jsp?resCategory=<%=resCategory%>&pos1=0&pos2=0";	
		</script>
			<%
			 }
			else
			{
			%>
		<script>
			parent.ConfigDispCritList.location.href="../../eCA/jsp/ConfigDispCritList.jsp?resCategory=<%=resCategory%>&pos1=0&pos2=0&configStrSql=<%=configStrSql%>&resSubCategory=<%=resSubCategory%>";
		</script>
		<%}
	}
	else if(confBean != null && fieldCount != null)
	{
		if(mode != null && mode.equals("ADD"))
		{
			confBean.addSelected(key, fieldCount);
		}
		else if(mode != null && mode.equals("REMOVE"))
		{
			confBean.removeSelected(key);
		}
	}
	%>
	

