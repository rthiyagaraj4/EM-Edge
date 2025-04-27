<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.ConnectionManager"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<head>
<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script language='javascript' src='../js/EmailRepBodyTxt.js'></script>
</head>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;
Connection con=null ;
try{
	con  =  ConnectionManager.getConnection(request);
	ArrayList finAr = new ArrayList();
	
	ArrayList firstItem = new ArrayList();
	firstItem.add("List");  	 //Type of item
	String moduleIDs = getModuleIds(con);	
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Module.label","common_labels"));	  // label
	firstItem.add("module_id");	//name of field
	firstItem.add("'',---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---,"+moduleIDs);	// Include the values and description
	firstItem.add("30");	//LENGTH
	finAr.add(firstItem);   
	ArrayList secondItem = new ArrayList();
	secondItem.add("Text");          //Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReportID.label","common_labels"));    // label
	secondItem.add("report_id");  //name of field
	secondItem.add("30");   // SIZE
	secondItem.add("30");   //LENGTH
	finAr.add(secondItem);    //add to ArrayList obj finAr
	
	ArrayList thirdItem = new ArrayList();
	thirdItem.add("Text");          //Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReportDesc.label","common_labels"));    // label
	thirdItem.add("report_desc");  //name of field
	thirdItem.add("30");   // SIZE
	thirdItem.add("30");   //LENGTH
	finAr.add(thirdItem);    //add to ArrayList obj finAr

	ArrayList fourthItem = new ArrayList();
	fourthItem.add("Text");           //Type of item
	fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ReportBodyTextID.label","ca_labels"));     // label
	fourthItem.add("body_text_ref");   //name of field
	fourthItem.add("4"); // SIZE
	fourthItem.add("4"); //LENGTH
	finAr.add(fourthItem);//add to ArrayList obj finAr
	
	ArrayList fifthItem = new ArrayList();
	fifthItem.add("Text");          //Type of item
	fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ReportBodyTextDesc.label","ca_labels"));    // label
	fifthItem.add("body_text_desc");  //name of field
	fifthItem.add("30");   // SIZE
	fifthItem.add("30");   //LENGTH
	finAr.add(fifthItem);    //add to ArrayList obj finAr

	String[] orderByCols = null;
	String[] orderByColVals = null;
	orderByCols = new String[5];
	orderByColVals = new String[5];

	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Module.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReportID.label","common_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReportDesc.label","common_labels");
	orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ReportBodyTextID.label","ca_labels");
	orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ReportBodyTextDesc.label","ca_labels");
	orderByColVals[0] = "module_id";
	orderByColVals[1] = "report_id";
	orderByColVals[2] = "report_desc";
	orderByColVals[3] = "body_text_ref";
	orderByColVals[4] = "body_text_desc";
	strbuff = qrypg.getQueryPage(con,finAr,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.email.label","common_labels"),"../../eCA/jsp/EmailRepBodyTxtQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ,orderByCols, orderByColVals,"Execute Query");
	out.println(strbuff.toString());
	finAr.clear();
	firstItem.clear();
	secondItem.clear();
	thirdItem.clear();
	fourthItem.clear();
	fifthItem.clear();
}catch (Exception e) 
{
	
	e.printStackTrace();
}finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
<%!
public String getModuleIds(Connection con) throws Exception{
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String  description	="";
		String  value="";
		String str="";
		try{
			pstmt			= con.prepareStatement("select module_id,module_name from sm_module where install_yn='Y' and exists (select 1 from SM_REPORT_MAIL_INFO where module_id=sm_module.module_id)  order by 2");
			resultSet		= pstmt.executeQuery() ;
			StringBuffer sb	= new StringBuffer();
			while (resultSet!=null && resultSet.next())
			{
				value			= resultSet.getString(1);
				description		= resultSet.getString(2);
				sb.append(value+ "," + description + ",");
			}
			str =   sb.toString() ;
			sb.setLength(0);
			if(resultSet !=null) resultSet.close();
			if(pstmt !=null) pstmt.close();
		}
		catch(Exception e){
			
			e.printStackTrace();			
		}
		return str.substring(0, str.length()-1);	
	}
%>

