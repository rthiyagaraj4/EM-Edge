<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../js/DiscreteMeasurePanel.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
		function populateSections()
		{
				var indexSelected = document.forms[0].discr_msr_battery_id.selectedIndex ;
				var discr_msr_battery_value = document.forms[0].discr_msr_battery_id.value ;
				var service_code  = serviceCodeList[indexSelected];
				var result_type = resultType[indexSelected];

				if(indexSelected == 0){
					parent.frames[1].location.href="../../eCommon/html/blank.html";	
				}else{
					parent.frames[1].location.href="DiscreteMeasurePanelQueryCriteriaResult.jsp?discr_msr_battery_id="+discr_msr_battery_value;
				}
	
				var htmlVal = "<html><head></head><body onKeyDown = 'lockKey()'>"
				htmlVal += "<form name='frm_temp' id='frm_temp' method='post' action='../../eAM/jsp/DiscreteMeasurePanelPopulate.jsp' target='messageFrame'>"
				htmlVal += "<input type=hidden name=service_code value=" +service_code + ">"
				htmlVal += "<input type=hidden name='result_type' id='result_type' value=" +result_type + ">"
				htmlVal += "</form></body></html>"
				
				parent.messageFrame.document.write(htmlVal);
				parent.messageFrame.document.frm_temp.submit();
				

			//	parent.dummy.document.write(htmlVal);
			//	parent.dummy.document.frm_temp.submit();
			}
</script>

<%
request.setCharacterEncoding("UTF-8");
Connection con=null;
Statement stmt=null;
ResultSet rs=null;

String sql="";
String mode="";
String status="";
StringBuffer sb=  new  StringBuffer();        

String discr_msr_battery_id="";
String discr_msr_id="";
String discr_msr_battery_desc="";
String discr_msr_desc="";
String order_srl_no="";
String service_code="";
String result_type = "";
String mandatory_yn="";
String itemDescription = "" ;
String itemCOde		= "" ;
String enabled_checked="";
String discreteMeasureOption ="" ;

mode=(request.getParameter("mode")==null)?"":request.getParameter("mode");
String   discr_msr_battery_id1 =(request.getParameter("discr_msr_battery_id1")==null)?"":request.getParameter("discr_msr_battery_id1");
String   discr_msr_id1 =(request.getParameter("discr_msr_id1")==null)?"":request.getParameter("discr_msr_id1");

try
  {	
	  con			=ConnectionManager.getConnection(request);
	  stmt	    	=con.createStatement();
	if(mode.trim().equalsIgnoreCase("insert"))
	  {						
		sql="Select discr_msr_id, short_desc, service_code,result_type from am_discr_msr Where eff_status = 'E' and result_type in ('V','Z','G') Order by short_desc";

				rs= stmt.executeQuery(sql);

				int   count = 0;%>
				<script>
						 var serviceCodeList = new Array();
						var resultType = new Array();
				</script>
				<%while(rs.next())
				  {
					 count++;
					 service_code	 =(rs.getString("service_code")==null)?"":rs.getString("service_code");
					 result_type	 =(rs.getString("result_type")==null)?"":rs.getString("result_type");%>
					 <script>
						serviceCodeList['<%=count%>'] = '<%=service_code%>';
						resultType['<%=count%>'] = '<%=result_type%>';
					 </script>
					 <!--<input type=hidden name="<%=count%>" id="<%=count%>"  value="<%=service_code%>">-->
					 <%
					 itemCOde  =(rs.getString("discr_msr_id")==null)?"":rs.getString("discr_msr_id");
					 itemDescription=(rs.getString("short_desc")==null)?"":rs.getString("short_desc");
					 sb.append("<option value='"+itemCOde+"'>"+itemDescription+"</option>");
					 
				  }
				  if(rs!=null) 	rs.close();
                  if(stmt!=null) 	stmt.close();
	   	  }			  
    	
		if(mode.trim().equalsIgnoreCase("update")) 
		 {
				sql = "select * from am_discr_msr_battery_vw where DISCR_MSR_BATTERY_ID='" +
					   discr_msr_battery_id1 + "' and discr_msr_id='"  + discr_msr_id1+ "'" ;
				
				rs			= stmt.executeQuery(sql);

			if(rs.next())
			 {
				discr_msr_battery_id = (rs.getString("DISCR_MSR_BATTERY_ID")==null)?"":rs.getString("DISCR_MSR_BATTERY_ID");
				discr_msr_battery_desc =
				(rs.getString("DISCR_MSR_BATTERY_DESC")==null)?"":rs.getString("DISCR_MSR_BATTERY_DESC");
				
				sb.append("<option value='"+discr_msr_battery_id+"'  selected     disabled>"+discr_msr_battery_desc+"</option>");	
				
				discr_msr_id	= 
				(rs.getString("DISCR_MSR_ID")==null)?"":rs.getString("DISCR_MSR_ID");
				discr_msr_desc=(rs.getString("DISCR_MSR_DESC")==null)?"":rs.getString("DISCR_MSR_DESC");
				
				discreteMeasureOption	 =  "<option value='"+discr_msr_id+"' selected   disabled>"+discr_msr_desc+" </option>";

				order_srl_no=(rs.getString("ORDER_SRL_NO")==null)?"":rs.getString("ORDER_SRL_NO");
				mandatory_yn=(rs.getString("MANDATORY_YN")==null)?"":rs.getString("MANDATORY_YN");
				if(mandatory_yn.trim().equalsIgnoreCase("Y"))
				enabled_checked = "checked"  ;
				else
				enabled_checked = "";

			 }
		 }
  }		
 catch(Exception e)
	{
			out.println(e);
	}
finally
	{
		try{
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		ConnectionManager.returnConnection(con,request);
	} 
%>

</script>
</head>
<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onload=''>
<form name="DiscreteMeasurePanel_form" id="DiscreteMeasurePanel_form" action="../../servlet/eAM.DiscreteMeasurePanelServlet" method="post" target="messageFrame">


<table border=0 cellspacing=0 cellpadding=0 width='90%' align=center>
<BR>
<tr>
	<td width='40%'>&nbsp;</td>
	<td width='60%'>&nbsp;</td>
</tr>

<tr>
		<td class=label align=right><fmt:message key="Common.PanelID.label" bundle="${common_labels}"/>&nbsp;</td>
		<%if(mode.trim().equalsIgnoreCase("update")) {status="disabled" ;}else{status="";}%>
		<td align=left>&nbsp;<select name='discr_msr_battery_id' id='discr_msr_battery_id' onchange='populateSections()' <%=status%>>
		<option value="">&nbsp;---- ---- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--- ---&nbsp;</option>
		<%=sb.toString()%>					   
		</select>
		&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
</tr>

<tr>
	<td width='40%'>&nbsp;</td>
	<td width='60%'>&nbsp;</td>
</tr>


<tr>
	<td class=label align=right><fmt:message key="Common.OrderSrlNo.label" bundle="${common_labels}"/>&nbsp;</td>
	<td align=left>&nbsp;<input type="text" name="order_srl_no" id="order_srl_no" value="<%=order_srl_no%>"   size=3 maxlength=3  onkeyPress='return allowValidNumber(this,event,6,0)'  onBlur="makeValidString(this); CheckPositiveNumberLocal(this)">&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
	<%if( order_srl_no != null){%><input type=hidden name='old_order_srl_no' id='old_order_srl_no' value="<%=order_srl_no%>"><%}%>
</tr>

<tr>
	<td width='40%'>&nbsp;</td>
	<td width='60%'>&nbsp;</td>
</tr>

<tr>
		<td class=label align=right><fmt:message key="Common.DiscreteMeasure.label" bundle="${common_labels}"/>&nbsp;</td>
		<%if(mode.trim().equalsIgnoreCase("update")) {status="disabled" ;}else{status="";}%>
		<td align=left>&nbsp;<select name='discr_msr_id' id='discr_msr_id' <%=status%>>
		<option value="">&nbsp;--- --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---- ----&nbsp;</option>
		<%=discreteMeasureOption%>
		</select>
		&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
</tr>

<tr>
	<td width='40%'>&nbsp;</td>
	<td width='60%'>&nbsp;</td>
</tr>

<tr>
	<td class=label align=right><fmt:message key="Common.Mandatory.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td><td align=left class=label>
	<input type="checkbox" name="mandatory_yn" id="mandatory_yn" value="Y"  <%=enabled_checked%>></td>
</tr>


<tr>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
</tr>

</table>
<input type=hidden name="mode" id="mode"  value="<%=mode%>">
<input type=hidden name="discr_msr_battery_id_update" id="discr_msr_battery_id_update"  value="<%=discr_msr_battery_id1%>">
<input type=hidden name="discr_msr_id_update" id="discr_msr_id_update"  value="<%=discr_msr_id%>">
 </form>
</body>
</html>

