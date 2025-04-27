<!DOCTYPE html>
<html> 
<%@ page import ="java.util.HashMap,java.util.ArrayList,eXH.XHSQLSet,java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter,java.util.*,eXH.XHQueryRender,webbeans.eCommon.*,"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<head>
<%String sStyle	=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%> 
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<style>
	div {float: left}
	.testSty
	{   
	 	width:expression(document.getElementById("indicatorTable").clientWidth-document.getElementById("left_child").clientWidth);
		overflow: scroll;
	}
</style> 																	   
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script Language="JavaScript"  src="../../eXH/js/FilterAndSchduleReference.js" ></script>

<script Language="JavaScript">
function funAction(typ)
{
 
	if(typ=='N')
	{
		var act = '../../eXH/jsp/FilteringAndSchedulingApplicationLevel.jsp?action_type=N';
		this.document.forms[0].action = act;
		this.document.forms[0].target="";
		this.document.forms[0].submit();
	}  
	else
	{
		var act = '../../eXH/jsp/FilteringAndSchedulingApplicationLevel.jsp?action_type=P';
		this.document.forms[0].action = act;
		this.document.forms[0].target="";
		this.document.forms[0].submit();
	}
}  
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
  
</head>
<body onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<form name="ProfileRef" id="ProfileRef" method="POST" action='../../eXH/jsp/' >
<%
           ResultSet rsettype = null;
   		   ResultSet rsetsubtype = null;
   		   ResultSet rsetelement = null;
		   PreparedStatement pstmttype = null ;
		   PreparedStatement pstmtsubtype = null ;
		   PreparedStatement pstmtelement = null ;
		   ResultSet resultset = null;
		    String rule=XHDBAdapter.checkNull(request.getParameter("rule"));
			Connection conn = null;
			String[] filtertypequery;
			String[] filtertypeelement;
			String[] filtersubtypeauery;
			String[] elementquery;
			Statement stment=null;
			int columval=0;
		int levelcount=0; 
		String Fileter_group_code=XHDBAdapter.checkNull(request.getParameter("Filter_group_code"));
		System.out.println("FilteringandschedulingApplicationLevel Filter_group_code : "+Fileter_group_code);
	    try
	  {
        if(conn==null) conn = ConnectionManager.getConnection();
      }
    catch(Exception exp)
    {

		 System.out.println("Error in calling getconnection method of FilteringandschedulingApplicationLevel.jsp  :"+exp.toString());
		exp.printStackTrace(System.err);
		//exceptions=exceptions+"1"+"*"+exp.toString();			  
    }
try
{
 stment= conn.createStatement();
 resultset = stment.executeQuery("select count(*) AS rowcount from XH_FILTER_LEVEL_CONFIG where filter_group_code='"+Fileter_group_code+"'");

 resultset.next();
 levelcount = resultset.getInt("rowcount") ;
 if(levelcount!=0)
 {
	filtertypequery=new String[levelcount];
	filtersubtypeauery=new String[levelcount];
	elementquery=new String[levelcount];
	filtertypeelement=new String[levelcount];
 %>
<table name=elTableRow id=elTableRow border=1 cellspacing=0 cellpadding=3 width='100%' align=center>
	<%
		   int k=0;
		   ResultSet rset = null;
   		    PreparedStatement pstmt = null ;
		  
		   int i=0;
		  try  
		  {  
			ArrayList arrRow = null,arrCol = null;
			String qry_id = "VIEWXHFILTERANDSCDHULINGLEVEL";
			String strstyle="";
			String Wherecause="";
			
			  // Added by prithivi for enotification requirement on 11/05/2016
			      String searchFor = XHDBAdapter.checkNull(request.getParameter("searchFor"));
				  
				  if("QueryFilter".equals(searchFor) && "ENOTIFYFIL".equals(Fileter_group_code))
				  {
					  System.out.println("FilteringAndSchedulingApplicationLevle.jsp::::::::::searchfor value...."+searchFor);
					  String filterLevelType = XHDBAdapter.checkNull(request.getParameter("filter_level_type"));
					  String filterLevelSubtype = XHDBAdapter.checkNull(request.getParameter("filter_level_subtype"));
					  String filterLevelValue = XHDBAdapter.checkNull(request.getParameter("filter_level_value"));
					  String subTypeDesc = XHDBAdapter.checkNull(request.getParameter("filter_level_subtype_desc"));

					  if(subTypeDesc == null)
					     subTypeDesc="";

					  String subTypeDescQuery = XHSQLSet.getSQL(Fileter_group_code).replace("#subTypeDesc",subTypeDesc);  

					  Wherecause=" where FILTER_GROUP_CODE='"+Fileter_group_code+"' and UPPER (filter_level1_type) LIKE upper('%"+filterLevelType+"%') "+
					  " and UPPER (filter_level1_subtype) LIKE upper('%"+filterLevelSubtype+"%') AND UPPER (FILTER_LEVEL1_CODE) LIKE upper('%"+filterLevelValue+"%') "+
					  " AND EXISTS ("+subTypeDescQuery+")";
					  
				  }
				  else
				  {
                      Wherecause=" where FILTER_GROUP_CODE='"+Fileter_group_code+"'  ";
				  }
			 
			System.out.println("FilteringAndSchedulingApplicationLevle.jsp::::::::::where clause...."+Wherecause);
			request.setAttribute(XHQueryRender.strQueryId,qry_id);
			request.setAttribute(XHQueryRender.whereClause,Wherecause);
			request.setAttribute(XHQueryRender.col,"38");
			// Added by prithivi for enotification requirement on 11/05/2016
			if("ENOTIFYFIL".equals(Fileter_group_code))
			{
				request.setAttribute(XHQueryRender.maxRec,"10");
			}
			else{
				request.setAttribute(XHQueryRender.maxRec,"6");
			}
			
			//conn = ConnectionManager.getConnection(request); 
			HashMap resultsQry = XHQueryRender.getResults(request,session,conn,"");
			arrRow = (ArrayList)resultsQry.get("qry_result"); 
			boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
			boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
			String strPrevious =  "Previous";
			String strNext  =  "Next";
			if (boolPrevious == true)
			{
				strPrevious =  "Previous";
			}
			else
			{
				strPrevious = " ";
			}
			if (boolNext== true)
			{
				strNext  =   "Next";
			}
			else
			{
				strNext  = " ";
			}
			 
	%>

 <tr>
 <%int npfra=levelcount*3;%>
<%---<%
	 if(levelcount%2==0)
{
 
	 %>
	  <td colspan="6"  align="right" class="CAGROUP" > 
      <A class='label' style='cursor:pointer' onClick="funAction('P')"><%=strPrevious%></A>
	  <A class='label'  onClick="funAction('N')" style='cursor:pointer' ><%=strNext%></A>
      </td>
	  <%}else
	    {	 
	 %>--%>
 <td colspan='<%=npfra%>'  align="right" class="CAGROUP" > 
      <A class='label' style='cursor:pointer' onClick="funAction('P')"><%=strPrevious%></A>
	  <A class='label'  onClick="funAction('N')" style='cursor:pointer' ><%=strNext%></A>
      </td>

<%---<%}%>---%>
 </tr>
 <tr>
      
 <%
	 int q=0;
	 String sql="select B.LEVEL_NUMBER,B.TYPE_QUERY,B.SUBTYPE_QUERY,B.LOOKUP_QUERY,B.FILTER_ELEMENT_TYPE_DESC,B.FILTER_SUBTYPE_DESC,B.ELEMENT_CODE_NAME,A.FACILITY_ID  from XH_FILTER_GROUP A,XH_FILTER_LEVEL_CONFIG B where B.FILTER_GROUP_CODE=A.FILTER_GROUP_CODE and B.FILTER_GROUP_CODE='"+Fileter_group_code+"' ORDER BY 1 ";
	 pstmt = conn.prepareStatement(sql);
	 rset = pstmt.executeQuery();
	 while(rset.next())
	 {
			if(rset.getString(2).toString().trim().indexOf(":FACILITY")!=-1)
			{
              filtertypequery[q]=rset.getString(2).toString().trim().replaceAll(":FACILITY","'"+XHDBAdapter.checkNull(rset.getString(8).toString().trim())+"'");
			}
			else
			{
			filtertypequery[q]=rset.getString(2);
			}
			if(rset.getString(3).toString().trim().indexOf(":FACILITY")!=-1)
			{
			filtersubtypeauery[q]=rset.getString(3).toString().trim().replaceAll(":FACILITY","'"+XHDBAdapter.checkNull(rset.getString(8).toString().trim())+"'");
			}
			else
			{
			filtersubtypeauery[q]=rset.getString(3).toString();
			}
			if(rset.getString(4).toString().trim().indexOf(":FACILITY")!=-1)
			{
			elementquery[q]=rset.getString(4).toString().trim().replaceAll(":FACILITY","'"+XHDBAdapter.checkNull(rset.getString(8).toString().trim())+"'");
			}
			else
			{
			elementquery[q]=rset.getString(4).toString().trim();
			}
			filtertypeelement[q]=rset.getString(7).trim();

q++;

 %>

	<td class='COLUMNHEADER' nowrap ><%=rset.getString(5)%></td> 
	<td class='COLUMNHEADER' nowrap><%=rset.getString(6)%></td>
<%
	if((rset.getString(7).trim().indexOf("None")!=-1) || (rset.getString(7).trim().indexOf("none")!=-1))
	{
	}
	else
	{
	%>
	
	<td class='COLUMNHEADER' nowrap><%=rset.getString(7)%></td>
<%}
	%>
<%
     }
   if(pstmt!=null)pstmt.close();
   if(rset!=null)rset.close();
%> 

</tr>
<% 
	if(arrRow.size()==0)
	{
if(rule.equals("R"))
		{
%>
	<script>
//	alert("XH1021");
alert(getMessage('XH1021','XH'));
</script>

		
	<%   }
	}else{
	%>
<%
boolean boolToggle =  true;	
for(i=0;i<arrRow.size();i++)
{

	arrCol = (ArrayList)arrRow.get(i);

	if (boolToggle == true)
		{
			strstyle = "class='QRYEVEN'";
			boolToggle =  false;
		}
		else
		{
			strstyle = "class='QRYODD'";
			boolToggle =  true;
		}


		//filtertypequery[q].
%> 

		
<%

	int p=1;
  for(k=0;k<levelcount;k++)
  {
       String sql1=filtertypequery[k].toString().trim(); String sql2=filtersubtypeauery[k].toString().trim();String sql3=elementquery[k].toString().trim();

	   TreeMap tretype=new TreeMap();
	   TreeMap tresubtype=new TreeMap();
       TreeMap treelement=new TreeMap();
     for(int a=1;a<arrCol.size();a++)
	  {
         		   int val=a%4;
          String pastestr=":"+(a);
		
		   if(val==0)
		  {
		  }
		  else if(val==1)
		  {
		     
             sql1=sql1.replaceAll(pastestr,"'"+XHDBAdapter.checkNull((String)arrCol.get(a))+"'");
			 sql2=sql2.replaceAll(pastestr,"'"+XHDBAdapter.checkNull((String)arrCol.get(a))+"'");
			 sql3=sql3.replaceAll(pastestr,"'"+XHDBAdapter.checkNull((String)arrCol.get(a))+"'");

		  }
		  else if(val==2)
	     {
			 
			   sql1=sql1.replaceAll(pastestr,"'"+XHDBAdapter.checkNull((String)arrCol.get(a))+"'");
			   sql2=sql2.replaceAll(pastestr,"'"+XHDBAdapter.checkNull((String)arrCol.get(a))+"'");
			   sql3=sql3.replaceAll(pastestr,"'"+XHDBAdapter.checkNull((String)arrCol.get(a))+"'");
         }
		  else if(val==3)
	     {
			  sql1=sql1.replaceAll(pastestr,"'"+XHDBAdapter.checkNull((String)arrCol.get(a))+"'");
			  sql2=sql2.replaceAll(pastestr,"'"+XHDBAdapter.checkNull((String)arrCol.get(a))+"'");
			  sql3=sql3.replaceAll(pastestr,"'"+XHDBAdapter.checkNull((String)arrCol.get(a))+"'");
         }

	  }
  
  try
	  {
     pstmttype = conn.prepareStatement(sql1);
	 rsettype = pstmttype.executeQuery();
	 while(rsettype.next())
	 {
         tretype.put(rsettype.getString(2).toString().trim(),rsettype.getString(1).toString().trim());
	 }
	 
	  }
	  catch(Exception e)
	  {
        System.out.println("(FilteringAndSchedulingApplicationLevel.jsp:exception) :"+e);
	  }
           finally
	      {
			/**/
	      }
try
	  {
    pstmtsubtype = conn.prepareStatement(sql2);
	 rsetsubtype = pstmtsubtype.executeQuery();
	 while(rsetsubtype.next())
	 {
         tresubtype.put(rsetsubtype.getString(2).toString().trim(),rsetsubtype.getString(1).toString().trim());
	 }
          

	  }
	  catch(Exception e)
	  {
		  System.out.println("(FilteringAndSchedulingApplicationLevel.jsp:Exception-2) :"+e);	 
	  }
	   finally
	      {
			/**/
	      }

    try
	  {

     pstmtelement = conn.prepareStatement(sql3);
	 rsetelement = pstmtelement.executeQuery();
	 while(rsetelement.next())
	 {
         treelement.put(rsetelement.getString(2).toString().trim(),rsetelement.getString(1).toString().trim());
	 }
	
	  }
      catch(Exception e)
	  {
		  System.out.println("(FilteringAndSchedulingApplicationLevel.jsp:exception-3) :"+e);
	  }
	   finally
	      {
			/**/
	      }

%>
<td <%=strstyle%> nowrap>
<% if(k==0)
 {
	%>
	<a  href=" javascript:func1('<%= (String)arrCol.get(0)%>','<%= (String)arrCol.get(1)%>','<%= (String)arrCol.get(2)%>',
		  '<%= (String)arrCol.get(3)%>','<%= (String)arrCol.get(4)%>','<%= (String)arrCol.get(5)%>','<%= (String)arrCol.get(6)%>',
		  '<%= (String)arrCol.get(7)%>','<%= (String)arrCol.get(8)%>','<%= (String)arrCol.get(9)%>','<%= (String)arrCol.get(10)%>',
		  '<%= (String)arrCol.get(11)%>','<%= (String)arrCol.get(12)%>','<%= (String)arrCol.get(13)%>','<%= (String)arrCol.get(14)%>',
		  '<%= (String)arrCol.get(15)%>','<%= (String)arrCol.get(16)%>','<%= (String)arrCol.get(17)%>','<%= (String)arrCol.get(18)%>',
		  '<%= (String)arrCol.get(19)%>','<%= (String)arrCol.get(20)%>','<%= (String)arrCol.get(21)%>','<%=(String)arrCol.get(22)%>',
		  '<%= (String)arrCol.get(23)%>','<%= (String)arrCol.get(24)%>','<%= (String)arrCol.get(25)%>','<%= (String)arrCol.get(26)%>',
		  '<%= (String)arrCol.get(27)%>','<%= (String)arrCol.get(28)%>','<%= (String)arrCol.get(29)%>','<%= (String)arrCol.get(30)%>','<%= (String)arrCol.get(31)%>','<%= (String)arrCol.get(32)%>',
		  '<%= (String)arrCol.get(33)%>','<%= (String)arrCol.get(34)%>','<%= (String)arrCol.get(35)%>','<%= (String)arrCol.get(36)%>',
		  '<%= (String)arrCol.get(37)%>','<%=levelcount%>');">&nbsp;	<%=tretype.get(XHDBAdapter.checkNull((String)arrCol.get(p)))==null?"":tretype.get(XHDBAdapter.checkNull((String)arrCol.get(p)))%>
<%
 }
		  else
	  {
			  %>

&nbsp;<%=tretype.get(XHDBAdapter.checkNull((String)arrCol.get(p)))==null?"":tretype.get(XHDBAdapter.checkNull((String)arrCol.get(p)))%>
	  <%}
			 
	p++;
%>
			</td>
		<td <%=strstyle%> nowrap>&nbsp;<%=tresubtype.get(XHDBAdapter.checkNull((String)arrCol.get(p)))==null?"":tresubtype.get(XHDBAdapter.checkNull((String)arrCol.get(p)))%>	
<%
	p++; 
%>
        </td>
<%
      if((filtertypeelement[k].indexOf("None")!=-1)|| (filtertypeelement[k].indexOf("none")!=-1))
	  {
	  }
	  else
	  {
		  %>
		<td <%=strstyle%> nowrap>&nbsp;<%=treelement.get(XHDBAdapter.checkNull((String)arrCol.get(p)))==null?"":treelement.get(XHDBAdapter.checkNull((String)arrCol.get(p)))%>
<%
	  }
p++;
%>
		</td>

<%
	
p++;
%>	
    	</td>

<%
	 }	
		if(pstmtelement!=null )
		pstmtelement.close() ;
		if(rsetelement!=null)
		rsetelement.close() ;
		if(pstmtsubtype!=null )
		pstmtsubtype.close() ;
		if(rsetsubtype!=null)
		rsetsubtype.close() ;
		if(pstmttype!=null )
		pstmttype.close() ;
		if(rsettype!=null)
		rsettype.close() ;
			
%>
</tr>
<%
 }
      columval=i;
	  if(rset!=null) rset.close();
      if(pstmt!=null) pstmt.close();
	  
			
	} ///end if 
        }
		catch(Exception exp)
		{
		   System.out.println("Error in FilteringAndSchedulingApplicationLevel.jsp :"+exp.toString());
		   exp.printStackTrace(System.err);
		}
		finally
		{
			ConnectionManager.returnConnection(conn);
		}
%>
 <tr>
</table>
<table name=elTableRow id=elTableRow border=0 cellspacing=0 cellpadding=3 width='100%' >
<tr>
<%int npfra2=levelcount*3;%> 
<td colspan='<%=npfra2%>'>
</td>
<td align="right">
<input class='button' type='button'  name='Add' id='Add' value='<fmt:message key="Common.Add.label" bundle="${common_labels}"/>' onClick="searcheval();"> </td>
</tr> 
 
<%
	}

else
	{
	out.println("<script>parent.frames[1].document.forms[0].reset();parent.frames[2].document.location.href='../../eCommon/html/blank.html';parent.frames[3].document.location.href='../../eCommon/html/blank.html';</script>");
	}
resultset.close() ;
stment.close();

	}	
   catch(Exception exp)
    {
		  System.out.println("Error in calling getconnection method of FilteringandschedulingApplicationLevel.jsp  :"+exp.toString());
		exp.printStackTrace(System.err);
		//exceptions=exceptions+"1"+"*"+exp.toString();
    }

%>
</table> 
  <input type=hidden name=filter_group_id id=filter_group_id value='<%=Fileter_group_code%>'>
  <input type=hidden name=Filter_group_code id=Filter_group_code value='<%=Fileter_group_code%>'>
</form>
</body>
</html>

