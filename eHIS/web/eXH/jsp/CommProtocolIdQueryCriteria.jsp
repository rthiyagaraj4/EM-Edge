<!DOCTYPE html>
<HTML>    
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% String locale = ((String)session.getAttribute("LOCALE"));	%>  
<HEAD>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
  
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
</HEAD>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;
Connection con=null ;
ResultSet rs=null;
Statement stmt=null;
try {
 
con  =  ConnectionManager.getConnection(request); 
ArrayList finAr = new ArrayList();
							    
ArrayList firstItem = new ArrayList();

firstItem.add("Text");          //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.identification.label","common_labels"));    // label
firstItem.add("protocol_id");  //name of field
firstItem.add("30");   // SIZE
firstItem.add("30");   //LENGTH
finAr.add(firstItem);    //add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");          //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.name.label","common_labels"));    // label
secondItem.add("protocol_name");  //name of field
secondItem.add("50");   // SIZE
secondItem.add("50");   //LENGTH
finAr.add(secondItem);    //add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList(); 
		
thirdItem.add("List");   //Type of item 
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.CommunicationType.Label","XH_labels"));  // label
thirdItem.add("protocol_type");//name
/*thirdItem.add("  ,--"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--,T,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.TCPIP.Label","XH_labels")+"");//static values that need to be displayed as  
thirdItem.add(",");*///static values that need to be displayed as 
//thirdItem.add(" ,--"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","xh_labels")+"--"+",");
String commStr=" ,--"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","xh_labels")+"--";
		
		try
		{  

			String queryApplication="select LIST_ELMT_VALUE, LIST_ELMT_LABEL from SM_LIST_ITEM where MODULE_ID='XH' and LIST_REF='XH_COMM_TYPE'";
			stmt=con.createStatement();
			rs=stmt.executeQuery(queryApplication);			
		

			while(rs.next())
			{
				commStr=commStr+","+rs.getString(1).toString().trim()+","+rs.getString(2).toString().trim();
				

			}
		}catch(Exception e1)
		{
			System.out.println("(CommProtocolIdQueryCriteria.jsp:Exception-1): "+e1.toString());
		}
	
if(rs!=null)rs.close();
if(stmt!=null)stmt.close();

thirdItem.add(commStr);
/*,T,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.TCPIP.Label","xh_labels")+",F,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.File.Label","xh_labels")+",R,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.RS232.Label","xh_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.ODBC.Label","xh_labels")+",OT,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.OracleTable.Label","xh_labels")+",RP,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.replication.Label","xh_labels")+""); */
finAr.add(thirdItem);
/* cmmntd on jan 15th  ",F,"+"File"+",R,"+"RS232"+",D,"+"ODBC"+",OT,"+"Oracle Table"+",RP,"+"Replication"  - remvd in 4.1 +",X,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fax.label","common_labels")+",M,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mail.label","common_labels")+",S,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.SMS.Label","xh_labels") */

ArrayList fourthItem = new ArrayList();
		
fourthItem.add("List");   //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mode.label","common_labels"));  // label
fourthItem.add("protocol_mode");//name 
fourthItem.add(" ,--"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--,I,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Inbound.Label","XH_labels")+",O,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Outbound.Label","XH_labels")+"");//static values that need to be displayed as 
fourthItem.add(",");//static values that need to be displayed as 
finAr.add(fourthItem);


ArrayList fifthItem = new ArrayList();

fifthItem.add("Hidden");   //Type of item
fifthItem.add("locale");  // label
fifthItem.add(locale);//name
fifthItem.add(locale);//static values that need to be displayed as 
finAr.add(fifthItem);


String[] orderByCols=null;
String[] orderByColVals=null;

	orderByCols = new String[4];
	orderByColVals = new String[4];

	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.identification.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.name.label","common_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.CommunicationType.Label","XH_labels");
	orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mode.label","common_labels");
		
	orderByColVals[0] = "1";
	orderByColVals[1] = "2";
	orderByColVals[2] = "3";
	orderByColVals[3] = "4";
	
 

strbuff = qrypg.getQueryPage( con,finAr,"InterfaceAPI","../../eXH/jsp/CommProtocolIdQueryResult.jsp",""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","xh_labels")+"",""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","xh_labels")+"",""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","xh_labels")+"" ,""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","xh_labels")+"",orderByCols, orderByColVals,""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","xh_labels")+"");
out.println(strbuff.toString());
firstItem.clear();
secondItem.clear();
thirdItem.clear();
fourthItem.clear();
fifthItem.clear();
finAr.clear();
} catch (Exception e) {}

finally
{
   if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
</HTML>
