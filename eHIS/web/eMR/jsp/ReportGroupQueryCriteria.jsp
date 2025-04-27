<!DOCTYPE html>
<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="webbeans.eCommon.*,java.sql.*, java.text.*"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %> 
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>



<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eMR/js/ReportCodeSetup.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function execQuery()
{
	var Report_id1   = document.forms[0].Report_id.value
	var group1       = document.forms[0].group.value
	var description1 = document.forms[0].description.value
	var type1        = document.forms[0].type.value
	var code1        = document.forms[0].code.value
		var concatvalues="";
	for (i=0; i< document.forms[0].OrderbyColumns.options.length; i++)
	{ 
		concatvalues=concatvalues+document.forms[0].OrderbyColumns.options(i).value+"|";
	}
       parent.parent.frames[1].frames[1].location.href="../../eMR/jsp/ReportGroupQueryResult.jsp?Report_id1="+Report_id1+"&group1="+group1+"&description1="+description1+"&type1="+type1+"&code1="+code1+"&concatvalues="+concatvalues;
}
function addOrderByCol() { 
		var from = document.getElementById("OrderbyCols"); 
		if (from.options.length > 0) { 
			var to = document.getElementById("OrderbyColumns"); 
			var element = document.createElement("OPTION"); 
			element.text = from.options[from.selectedIndex].text; 
			element.value= from.options[from.selectedIndex].value; 
			to.add(element); 			
			from.remove(from.selectedIndex); 
		}
	} 
	
	function removeOrderByCol()	{ 
		var from = document.getElementById("OrderbyColumns"); 
		if ( from.options.length > 0 ) { 
			var to = document.getElementById("OrderbyCols");
			var element = document.createElement("OPTION"); 
			element.text = from.options[from.selectedIndex].text; 
			element.value = from.options[from.selectedIndex].value; to.add(element);			
			from.remove(from.selectedIndex); 
		} 
	}	
	
 
	function focusObj()
	{
			document.forms[0].Report_id.focus();
	}
	
	function changereport(obj)
	{
		document.forms[0].type.value='';
		var obj_type = document.forms[0].type;
			var length  = obj_type.length;
			for(i=0;i<length;i++) 
			{
				obj_type.remove(1);
			}
			if(obj.value=='MRIPCSEG' ||obj.value=='MROPANPO' || obj.value=='MROPCSEG')
			{
				var opt_type= document.createElement('Option');
				opt_type.text=getLabel("eMP.RaceGroup.label","MP"); 
				opt_type.value='RC';
				obj_type.add(opt_type)
				opt_type.selected = true;	
			}
			else if(obj.value=='IPBMCSBU')
			{
				var opt_type= document.createElement('Option');
				opt_type.text=getLabel("Common.Speciality.label","Common"); 
				opt_type.value='SP';
				obj_type.add(opt_type)
				opt_type.selected = true;	
			}
			else if(obj.value=='MRIPCSMH')
			{
				var opt_type= document.createElement('Option');
				opt_type.text=getLabel("eMP.DeliveryType.label","MP"); 
				opt_type.value='DT';
				obj_type.add(opt_type)
				opt_type.selected = true;	
			}
			else if(obj.value=='MROPCSAT' ||obj.value=='MRIPCSBD' ||obj.value=='MROPRFLS' )
			{
				var opt_type= document.createElement('Option');
				opt_type.text=getLabel("Common.Speciality.label","Common"); 
				opt_type.value='SP';
				obj_type.add(opt_type)
				if(obj.value!='MROPRFLS')
					opt_type.selected = true;	
				if(obj.value=='MROPRFLS')
				{
					var opt_type= document.createElement('Option');
					opt_type.text=getLabel("Common.HealthcareSettingType.label","Common"); 
					opt_type.value='HC';
					obj_type.add(opt_type)
				}
			}
	}
	
</script>
<form name="Report_Group_form11" id="Report_Group_form11" action="../../eMR/jsp/ReportGroupQueryResult.jsp" method="post">
<%

	request.setCharacterEncoding("UTF-8");
	String fid=(String)session.getValue("facility_id") ;
	String facilityId = request.getParameter("facilityId");
		if(facilityId == null || facilityId.equals("")) facilityId=fid;
	Connection con = null;
	PreparedStatement pstmt=null;
	PreparedStatement pstmt1=null;
	java.sql.Statement stmt=null;
	ResultSet rset=null ;
	ResultSet rset1=null ;
	String dat="";
	String id="";

	try
	{
		con = ConnectionManager.getConnection(request);
 	
%>
	</head>

	<body onLoad='focusObj()' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
		<form name='report_form_query' id='report_form_query'>
		
			<table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
	         <th colspan=2 align='left'><fmt:message key="Common.QueryCriteria.label" bundle="${common_labels}"/></th>			
	         <tr>
					<td colspan='2'>&nbsp;</td>
				</tr>
				<tr>
				     <td align='right' class='label'><fmt:message key="Common.report.label" bundle="${common_labels}"/></td>
				     <td align='left'>&nbsp;<select name='Report_id' id='Report_id' onchange='changereport(this)'>
					<option value=''>&nbsp;&nbsp;&nbsp;----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----&nbsp;&nbsp;&nbsp;</option>
					<%
		             
          String populate="Select Report_id,report_desc from sm_report where (module_id ='MR' or module_id ='IP') And report_id  IN('MROPRFLS','MROPCSAT','MRIPCSBD','MRIPCSMH','MRIPCSEG','MROPANPO','MROPCSEG','IPBMCSBU') order by report_desc" ;
		
					 pstmt1=con.prepareStatement(populate);
					 
						rset1=pstmt1.executeQuery();
                       
						if(rset1!=null)
						{
						   while(rset1.next())
						   {
						   dat=rset1.getString("report_desc");
						   id=rset1.getString("Report_id");
						   
						 out.println("<option value='"+id+"''>"+dat);

						   }
						}
						out.print("</select>");
						
					%>
					
				     </td>
				</tr>
						<tr><td colspan='2'></td></tr>
					 <tr><td colspan='2'></td></tr>
					 <tr><td colspan='2'></td></tr>
					 <tr><td colspan='2'></td></tr>
					 <tr><td colspan='2'></td></tr>
						
					<tr>
   				        <td align='right' class='label' nowrap><fmt:message key="eMR.Master.label" bundle="${mr_labels}"/></td>
    				     <td align='left' nowrap>&nbsp;<select name='type' id='type'>
    				
					<option value=''>-------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------------</option>
						 <option value='DT'><fmt:message key="eMP.DeliveryType.label" bundle="${mp_labels}"/></option>
						<option value='HC'><fmt:message key="Common.HealthcareSettingType.label" bundle="${common_labels}"/> </option>
						 <option value='RC'><fmt:message key="eMP.RaceGroup.label" bundle="${mp_labels}"/></option>
				          <option value='SP'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></option>
                        
                        
                         </SELECT>
    	 		  		
    				     </td>
    				</tr>
				<tr><td colspan='2'></td></tr>
					 <tr><td colspan='2'></td></tr>
					 <tr><td colspan='2'></td></tr>
					 <tr><td colspan='2'></td></tr>
					 <tr><td colspan='2'></td></tr>
				<tr>
							 <td align='right' class='label' nowrap><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
					<td  align='left'>&nbsp;<input type="text" name="code" id="code" size='20' maxlength='20'></td>
					
				</tr>
					 
				
				 <tr><td colspan='2'></td></tr>
					 <tr><td colspan='2'></td></tr>
					 <tr><td colspan='2'></td></tr>
					 <tr><td colspan='2'></td></tr>
					 <tr><td colspan='2'></td></tr>
					 <tr>
					<td align='right' class='label' nowrap><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
					<td  align='left'>&nbsp;<input type="text" name="description" id="description" size='20' maxlength='40'></td>
				</tr>

				 <tr><td colspan='2'></td></tr>
					 <tr><td colspan='2'></td></tr>
					 <tr><td colspan='2'></td></tr>
					 <tr><td colspan='2'></td></tr>
					 <tr><td colspan='2'></td></tr>
				 <tr>
					<td align='right' class='label' nowrap><fmt:message key="Common.Group.label" bundle="${common_labels}"/></td>
					<td  align='left'>&nbsp;<input type="text" name="group" id="group" size='20' maxlength='30'></td>
				 </tr>
				    <tr>
							 <td colspan=2>&nbsp;</td>
				    </tr>
							  
	
  			</table>
			<table width='100%' align='center'>
			 <th width='20%' align='left'><fmt:message key="Common.SortOrder.label" bundle="${common_labels}"/></th>
			 <tr>
				<td nowrap  width='60%' >
				<p  title='Sort Order'>
		 <table width='100%'><td nowrap  align='center'><b><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td><td>&nbsp;</td><td nowrap align='center'><b><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td><tr><td nowrap width='45%'  >
				<tr>
				    <td width="45%" align="center">
						<Select name="OrderbyCols" id="OrderbyCols" size="4">
						   
						   <Option value="MAST_TABLE_NAME_REFERENCE"><fmt:message key="eMR.Master.label" bundle="${mr_labels}"/>
						   <Option value="MAST_CODE"><fmt:message key="Common.code.label" bundle="${common_labels}"/>
				           <Option value="MAST_DESC"><fmt:message key="Common.description.label" bundle="${common_labels}"/>
						   <Option value="GROUP_DESC"><fmt:message key="Common.Group.label" bundle="${common_labels}"/>
						</Select>
				    </td>
					<td align='center' width='3%' class='button' >
				       <input type='button' name='add' id='add' class='button' onclick='addOrderByCol()' value='---->'> 
					   <input type='button' name='add' id='add' class='button'  value='<----' onclick='removeOrderByCol()'></img>
				   </td>
					<td width="45%" align="center"><Select name="OrderbyColumns" id="OrderbyColumns" size="4" multiple="true"><Option value="REPORT_DESC"><fmt:message key="Common.report.label" bundle="${common_labels}"/>  </Select></td>
				</tr>
			</table><br><br></div>
			<table border='0' width='100%' align='center'>
						<tr>
							 <td nowrap width='100%' align='center'  class='button'><input type='button' name='ExecuteQuery' id='ExecuteQuery' class='Button'  onclick='execQuery()'  Value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Execute.label","common_labels")%>'>
							</td>
					  </tr>
		 </table> 
		
		<input type='hidden' value="" name="concatvalues" id="concatvalues">
	</form>
</body>
</html>
<%	 }
	  catch(Exception e){/* out.print(e); */e.printStackTrace();}
	  finally
	  {
	  if(stmt!=null)	stmt.close();
	  if(pstmt!=null)	pstmt.close();
	  if(rset!=null)	rset.close();
		ConnectionManager.returnConnection(con,request);

	  }%>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

