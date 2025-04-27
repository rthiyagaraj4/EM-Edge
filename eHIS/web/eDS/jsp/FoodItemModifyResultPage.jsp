<!DOCTYPE html>
<!-- Newly Created for KDAH-CRF-0359.1-->
<%@ page import="webbeans.eCommon.ConnectionManager,java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.net.URLEncoder,java.sql.Timestamp,java.text.DateFormat,java.text.SimpleDateFormat"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<head>

<%
	String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "")) ?
	(String) session.getAttribute("PREFERRED_STYLE"):"IeStyle.css" ;
	if(sStyle==null)sStyle="IeStyle.css";
	session.removeAttribute("ALLMENUITEMSMAP"); 
	String param = request.getQueryString();
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="Javascript" src="../../eDS/js/json.js"></script>
	<script language='javascript' src='../../eDS/js/FooditemModify.js'></script>	

<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	String whereClause = checkForNull(request.getParameter("whereclause"));
	if(whereClause==null) whereClause="";
	String sql = "";
	int maxRecord = 0;

	PreparedStatement pstmt=null,pstmt1 = null,pstmt2=null,pstmt3=null,pstmt4=null,pstmt5=null,pstmt6=null,pstmt7=null,pstmt_KitchenCode = null,pstmt8=null,pstmt9=null;
	ResultSet rst=null,rst1 = null,rst2=null,rst3=null,rst4=null,rst5=null,rst6=null,rst7=null,rst_KitchenCode=null,rst8=null,rst9=null;

	Connection conn = null;
	conn = ConnectionManager.getConnection(request);

	String ExistingFoodItem = request.getParameter("ExistingFoodItem");
	String NewFoodItem = request.getParameter("NewFoodItem"); //Added against ICN-64263
	String DietType = request.getParameter("DietType");
	String MealType = request.getParameter("MealType");
	String from = checkForNull(request.getParameter("from"));
	String to = checkForNull(request.getParameter( "to" ));
	int start = (from.equals(""))?1:Integer.parseInt(from);
	int end = (to.equals(""))?28:Integer.parseInt(to);	
	int wherecheck=0;

	//Modified against ICN-64263
	String strsql = "SELECT DISTINCT menu_code, short_desc menu_desc FROM ds_menu WHERE menu_code IN (SELECT menu_code       FROM ds_menu_item WHERE item_code = '"+ExistingFoodItem+"') AND menu_code NOT IN (SELECT menu_code FROM ds_menu_item WHERE item_code = '"+NewFoodItem+"') AND diet_type IS NOT NULL AND meal_type IS NOT NULL ";

	if ( !(DietType == null || DietType.equals("")) ){    				
		sql = sql + "AND diet_type IN ("+DietType+") ";
		wherecheck=1;
	}

	if ( !(MealType == null || MealType.equals("")) ){    				
		sql = sql + "AND meal_type IN ("+MealType+")";
		wherecheck=1;
	}

	if(wherecheck==1) strsql=strsql+sql;

	try{
		String menu_code = "";
		String menu_desc = "";
		String language_id = (String)session.getAttribute("LOCALE");

		pstmt = conn.prepareStatement(strsql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE) ;
		rst	= pstmt.executeQuery();
		//getting maximum record
		rst.last();	maxRecord = rst.getRow();
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
		}
		//again move the resultset pointer to initial position
		rst.beforeFirst();			
%>
<form name='QueryResult' id='QueryResult'>

<table align='right'>
<tr><td>

<%
if ( !(start <= 1) ) {%>
	<A HREF="../../eDS/jsp/FoodItemModifyResultPage.jsp?from=<%=(start-28)%>&to=<%=(end-28)%>&whereclause=<%=URLEncoder.encode(sql)%>&ExistingFoodItem=<%=ExistingFoodItem%>&NewFoodItem=<%=NewFoodItem%>&DietType=<%=DietType%>&MealType=<%=MealType%>"  onclick="" text-decoration='none'><fmt:message key="Common.previous.label" bundle='${common_labels}' /></A> 
<%}if ( !( (start+28) > maxRecord ) ) {%>
	<A HREF="../../eDS/jsp/FoodItemModifyResultPage.jsp?from=<%=(start+28)%>&to=<%=(end+28)%>&whereclause=<%=URLEncoder.encode(sql)%>&ExistingFoodItem=<%=ExistingFoodItem%>&NewFoodItem=<%=NewFoodItem%>&DietType=<%=DietType%>&MealType=<%=MealType%>"  onclick="" text-decoration='none'><fmt:message key="Common.next.label" bundle='${common_labels}' /></A>
<%}%>
</td></tr>
</table>
<br><br>
<!--<table border="1" cellpadding="1" cellspacing="0" width="100%" align="center" id="result" >-->
<table border="1" cellpadding="1" cellspacing="0" width="50%" align="left" id="result" >
<% if(maxRecord > 0)
{
%>
	<tr>
		<th>
			<input type="checkbox" id="chkAll" name="chkAll1" id="chkAll1" onClick="MenuSelectAll1(this,<%=start%>,<%=(end-14)%>)" />
		</th>
		<th>
			<fmt:message key="eDS.Menu.Label" bundle="${ds_labels}" />
		</th>
		<th>
			<fmt:message key="eDS.MenuDescription.Label" bundle="${ds_labels}" />						
		</th>				
	</tr>
<%
}
	String classValue="";

	if ( start!= 1 ) 
		rst.absolute(start-1);
		int i=start;
		int count=1;
	while(rst != null && rst.next() && i<=end){
		if ( i % 2 == 0 )
			classValue = "QRYODD" ;
		else
			classValue = "QRYEVEN" ;

	if(count<=14)
	{
		menu_code = rst.getString(1);
		menu_desc = rst.getString(2);				
%>
			
		<tr>
			<!--ICN-64263-->
			<%if(maxRecord >= (end-14)) { %>
			<td class='<%=classValue%>' width='12%' nowrap><input type="checkbox" name="check_<%=menu_code%>" id="check_<%=menu_code%>" id="chk_<%=i%>" onClick="addRemoveMenu1(this,'<%=menu_code%>','<%=start%>','<%=end-14%>')"/></td>
			<% } else { %>					
			<td class='<%=classValue%>' width='12%' nowrap><input type="checkbox" name="check_<%=menu_code%>" id="check_<%=menu_code%>" id="chk_<%=i%>" onClick="addRemoveMenu1(this,'<%=menu_code%>','<%=start%>','<%=maxRecord%>')"/></td>
			<% }  %>
			<td class='<%=classValue%>' width='12%' nowrap><input type="hidden" id="menu_code_<%=i%>" value="<%=menu_code%>"/> <%=menu_code%></td>
			<td class='<%=classValue%>' width='12%' nowrap><input type="hidden" id="menu_desc_<%=i%>" value="<%=menu_desc%>"/> <%=menu_desc%></td>		</tr>
<%
			i++;
			count++;
			}
			}
%>
</table>


<table border="1" cellpadding="1" cellspacing="0" width="50%" align="float:left" id="result" >
<%
	if(((start+14) <= end) && maxRecord >0 && (maxRecord>= (start+14)))
	{
%>
	<tr>
		<th>
			<input type="checkbox" name="chkAll2" id="chkAll2" onClick="MenuSelectAll2(this,<%=start+14%>,<%=(end)%>)" />
		</th>
		<th>
			<fmt:message key="eDS.Menu.Label" bundle="${ds_labels}" />
		</th>
		<th>
			<fmt:message key="eDS.MenuDescription.Label" bundle="${ds_labels}" />						
		</th>		
	</tr>
<%
	}
		classValue="";	
		rst.absolute(start+13);//ICN-64263
		i=start+14;
		count=15;
		while(rst != null && rst.next() && i<=end){
				
		if ( i % 2 == 0 )
			classValue = "QRYODD" ;
		else
			classValue = "QRYEVEN" ;

		if(count >14)
		{
			menu_code = rst.getString(1);
			menu_desc = rst.getString(2);				
%>
			
		<tr>
			<!--ICN-64263-->
			<%if(maxRecord >= (end)) { %>
			<td class='<%=classValue%>' width='12%' nowrap><input type="checkbox" name="check_<%=menu_code%>" id="check_<%=menu_code%>" id="chk_<%=i%>" onClick="addRemoveMenu2(this,'<%=menu_code%>','<%=start+14%>','<%=end%>')"/></td>
			<%} else {%>
			<td class='<%=classValue%>' width='12%' nowrap><input type="checkbox" name="check_<%=menu_code%>" id="check_<%=menu_code%>" id="chk_<%=i%>" onClick="addRemoveMenu2(this,'<%=menu_code%>','<%=start+14%>','<%=maxRecord%>')"/></td>
			<%}%>
			<td class='<%=classValue%>' width='12%' nowrap><input type="hidden" id="menu_code_<%=i%>" value="<%=menu_code%>"/> <%=menu_code%></td>
			<td class='<%=classValue%>' width='12%' nowrap><input type="hidden" id="menu_desc_<%=i%>" value="<%=menu_desc%>"/> <%=menu_desc%></td>	</tr>
		</tr>
			<%
				i++;
				count++;
				}
				}
		     	}
		     	catch(Exception e){
		     		e.printStackTrace();
		     	}
		     	finally{
					if(pstmt!=null)	pstmt.close();
					if(rst!=null)	rst.close();
					if(pstmt1!=null)	pstmt1.close();
					if(rst1!=null)	rst1.close();					
					if(conn != null){
						ConnectionManager.returnConnection(conn,request);
					}
				}
		 %>		
				
			
</table>
<input type="hidden" id="start" value="<%=start%>">
<input type="hidden" id="end" value="<%=end%>">
<input type="hidden" id="maxRecord" value="<%=maxRecord%>"><!--ICN-64263-->

 </form>
 <script>
		var selMenus = parent.parent.FoodItemModifyCriteria.document.getElementById('selectedMenus').value;
		var removedMenus = parent.parent.FoodItemModifyCriteria.document.getElementById('removedMenus').value;
		var start=document.getElementById("start").value;
		var end=document.getElementById("end").value;
		var maxRecord=document.getElementById("maxRecord").value;
		var mod=maxRecord%28;
		var diff=(28-mod)
		if((mod != 0))
			end=parseInt(maxRecord)+parseInt(diff);
		if(selMenus != undefined ||  selMenus != '')
		{
			var selMenus_Arr=selMenus.split(',');
		for(var i=0;i<selMenus_Arr.length;i++) 
		{
			for(var m=start;m<=end;m++)
			{
				if(document.getElementById("menu_code_"+m))
				{
				var menuCode=document.getElementById("menu_code_"+m).value;

				if(menuCode == selMenus_Arr[i])
				{
					if(document.getElementById("chk_"+m))
					{
						document.getElementById("chk_"+m).checked=true;
					}
				}
				}
			}
		}
		}
		if(removedMenus != undefined ||  removedMenus != '')
		{
			var removedMenus_Arr=removedMenus.split(',');	
		for(var h=0;i<removedMenus_Arr.length;h++)
		{	
			for(var n=start;n<=end;n++)
			{
				if(document.getElementById("menu_code_"+n))//Create Error
				{
					var menuCode1=document.getElementById("menu_code_"+n).value;
					if(menuCode1 == removedMenus_Arr[h])
					{
					if(document.getElementById("chk_"+n))
					{
						document.getElementById("chk_"+n).checked=false;
					}
					}
				}
			}
		}
		}
</script>
</body>

