<!DOCTYPE html>
<html> 
<%@ page import ="java.util.*,java.net.*,eXH.XHDBAdapter,eXH.ArrayAuditInfo,eXH.XHTYPE,java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.*"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<head>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
<script language='JavaScript' src='../../eCommon/js/common.js'></script>

<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script Language="JavaScript"  src="../../eXH/js/InterfaceStandardrefrancevalue.js" ></script>
<script Language="JavaScript">


</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<form name="ProfileRef" id="ProfileRef" method="POST" action='../../eXH/jsp/ProfileDervationSelectMaster.jsp' >
<%

Connection conn = null;

String strstyle="";
String strPrevious = "";
String strNext  = "";
int columval=0;
try
{
	
	/*conn = ConnectionManager.getConnection(request);
	XHApplicationDerivationProfileSetupControllerBean	xhBean =
	XHApplicationDerivationProfileSetupControllerBean.getBean(strBeanName,request,session);
	xhBean.action(request,conn);
	
	boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
	boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
	strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Previous.Label","xh_labels");
	strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Next.Label","xh_labels");
	if (boolPrevious == true)
	{
		strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Previous.Label","xh_labels");
	}
	else
	{
		strPrevious = " ";
	}
	if (boolNext== true)
	{
		strNext  =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Next.Label","xh_labels");
	}
	else
	{
		strNext  = " ";
	}*/

	}	
 catch(Exception exp)
    {
       System.out.println("Error in InterfacestandardctrlSearch.jsp :"+exp.toString());
	   exp.printStackTrace(System.err);
    }
		%>
	<table name=elTableRow id=elTableRow border=1 cellspacing=0 cellpadding=3 width='100%' align=center>
	<tr>
<td colspan="4" align="right" class="CAGROUP" >
	</td>
	
	<td colspan="4" align="right" class="CAGROUP" > 
<A class='label' style='cursor:pointer' onClick="funAction('P')"><%=strPrevious%></A>
	<A class='label'  onClick="funAction('N')" style='cursor:pointer' ><%=strNext%></A>
</td>
 

</tr>
<tr>
<!--
<td class='COLUMNHEADER' width='35%'><fmt:message key="eXH.ElementDesc.Label" bundle="${xh_labels}"/></td> -->
	<td class='COLUMNHEADER' width='10%'><fmt:message key="eXH.SegmentID.Label" bundle="${xh_labels}"/></td>
<!--<td class='COLUMNHEADER' width='5%'><fmt:message key="eXH.ElementID.Label" bundle="${xh_labels}"/></td>-->
	<td class='COLUMNHEADER' width='5%'><fmt:message key="eXH.ElementDesc.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER' width='5%'><fmt:message key="eXH.ElementSEQ.Label" bundle="${xh_labels}"/></td>	
	<td class='COLUMNHEADER' width='5%'><fmt:message key="eXH.DefaultVal.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER' width='5%'><fmt:message key="eXH.Standardcode.Label" bundle="${xh_labels}"/></td>

</tr>

<%
  ResultSet rset = null;
   ResultSet resultset = null;
   Statement stmt=null;
  PreparedStatement pstmt = null ;
  String sql="";
int i=0;
int levelcount1=0;
try
	{
if(conn==null) conn = ConnectionManager.getConnection();
 }
      catch(Exception exp)
    {
       System.out.println("Error in InterfacestandardctrlSearch.jsp :"+exp.toString());
	   exp.printStackTrace(System.err);
    }
  try
    {
String standardcode=request.getParameter("standard_code");
String segmentid=request.getParameter("segment_Id");

//System.out.println("select count(*) AS rowcount from xh_standard_control_seg where SEGMENT_ID=NVL('"+segmentid+"',SEGMENT_ID) and STANDARD_CODE=NVL('"+standardcode+"',STANDARD_CODE)");
stmt= conn.createStatement();
 resultset = stmt.executeQuery("select count(*) AS rowcount from xh_standard_control_seg where SEGMENT_ID=NVL('"+segmentid+"',SEGMENT_ID) and STANDARD_CODE=NVL('"+standardcode+"',STANDARD_CODE)");
 resultset.next();
 levelcount1 =  resultset.getInt("rowcount") ;

 //System.out.println("levelcount1"+levelcount1);
stmt.close();
resultset.close();
if(levelcount1>0)
{
sql="select A.SEGMENT_ID,A.ELEMENT_ID,A.ELEMENT_SEQUENCE,A.DEFAULT_VALUE,A.STANDARD_CODE,B.ELEMENT_NAME,A.CONTROL_ELEMENT_ID,C.ELEMENT_DESC from xh_standard_control_seg A,XH_ELEMENT_CROSSREF B ,XH_CONTROL_ELEMENT C where A.ELEMENT_ID=B.ELEMENT_ID and A.CONTROL_ELEMENT_ID=C.ELEMENT_ID and A.SEGMENT_ID=NVL('"+segmentid+"',A.SEGMENT_ID) and A.STANDARD_CODE=NVL('"+standardcode+"',A.STANDARD_CODE) ORDER BY ELEMENT_SEQUENCE "; 

 pstmt = conn.prepareStatement(sql);
 rset = pstmt.executeQuery();
 //strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Previous.Label","xh_labels");
// strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Next.Label","xh_labels");
	/*		if (boolPrevious == true)
	{
		strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Previous.Label","xh_labels");
	}
	else 
	{
		strPrevious = " ";
	}
	if (boolNext== true)
	{
		strNext  =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Next.Label","xh_labels");
	}
	else
	{
		strNext  = " ";
	}*/

	  String encodedVal = "";
      while(rset.next())
      {
if((i%2)==0)
		  {
	strstyle = "class='QRYEVEN'";
		  }
		  else
		  {
strstyle = "class='QRYODD'";

		  }
	//arrRow = (ArrayList)rset.getString(i);

//out.println("rset.next()"+rset.getString(s));

/*try
{
	conn = ConnectionManager.getConnection(request);
	//XHApplicationDerivationSetupControllerBean	xhBean =
	//XHApplicationDerivationSetupControllerBean.getBean(strBeanName,request,session);
	//xhBean.action(request,conn);

	
	resultsQry = xhBean.getResultSet();
	arrRow = (ArrayList)resultsQry.get("qry_result"); 
	boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
	boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
	strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Previous.Label","xh_labels");
	strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Next.Label","xh_labels");
	if (boolPrevious == true)
	{
		strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Previous.Label","xh_labels");
	}
	else
	{
		strPrevious = " ";
	}
	if (boolNext== true)
	{
		strNext  =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eXH.Next.Label","xh_labels");
	}
	else
	{
		strNext  = " ";
	}
	}*/
	
//catch(Exception e1)
//	{
	//	out.println("Error="+e1);
	//}



	%>


	<td <%=strstyle%>>

		<%
		//System.out.println("1---- "+rset.getString(1));	
		//System.out.println("1---- "+rset.getString(2));
		encodedVal = URLEncoder.encode(rset.getString(2),"utf-8");
		//System.out.println("encodedVal "+encodedVal);
		
		String url = "../../eXH/jsp/InterfacestandardctrlAdd.jsp?Segment_id="+rset.getString(1)+"&Standard_code="+rset.getString(5)+"&Element_id="+encodedVal+"&Element_Seq="+rset.getString(3)+"&Default_value="+rset.getString(4)+"&element_name="+URLEncoder.encode(rset.getString(6),"utf-8")+"&Mode=U&control_elementId="+rset.getString(7)+"&control_elementname="+rset.getString(8);
		
		%>
<!-- <a  href=" javascript:func1('<%= rset.getString(1)%>','<%=encodedVal%>',
  '<%= rset.getString(3)%>','<%= rset.getString(4)%>','<%= rset.getString(5)%>','<%= rset.getString(6)%>','<%= rset.getString(7)%>');">
  &nbsp;<%=rset.getString(1).equals("null")?"":rset.getString(1) %>
--> 

<a href="<%=url%>">
	<%=rset.getString(1).equals("null")?"":rset.getString(1) %>
</a>
  </td>

<td <%=strstyle%> ><%=XHDBAdapter.checkNull(rset.getString(6))%></td>
<td <%=strstyle%>><%=XHDBAdapter.checkNull(rset.getString(3))%></td>
<td <%=strstyle%> ><%=XHDBAdapter.checkNull(rset.getString(4))%></td>
<td <%=strstyle%> ><%=rset.getString(5)%></td>

	
	</tr>

<%

	i++;
   
      }
columval=i;
	  if(rset!=null) rset.close();
      if(pstmt!=null) pstmt.close();


	}
	else
	{
		out.println("<script>alert(getMessage('XH1021','XH'));</script>");

		out.println("<script>parent.frames[2].document.location.href='../../eCommon/html/blank.html';</script>");
	%>
	<%
	}

    }
    catch(Exception exp)
    {

		 
 System.out.println("( InterfacestandardctrlSearch.jsp:sql131) :"+sql);
       System.out.println("Error in InterfacestandardctrlSearch.jsp :"+exp.toString());
	   exp.printStackTrace(System.err);
    }


finally
	{
		ConnectionManager.returnConnection(conn);
	}
%>
	
	</table> 

 
</form>
</body>
</html>


