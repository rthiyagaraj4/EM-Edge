<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="webbeans.eCommon.*,java.sql.*, java.text.*"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %> 
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eMR/js/ReportCodeSetup.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function execQuery()
{
	var Report   = document.forms[0].Report_id.value
	var Master       = document.forms[0].Master.value
	var main_group = document.forms[0].main_group.value
	var sub_group        = document.forms[0].sub_group.value
	var level3_group        = document.forms[0].level3_group.value
	var catalog_desc        = document.forms[0].catalog_desc.value
	var concatvalues="";
	for (i=0; i< document.forms[0].OrderbyColumns.options.length; i++)
	{ 
		concatvalues=concatvalues+document.forms[0].OrderbyColumns.options[i].value+"|";
	}
//       alert()
		   parent.f_query_add_mod.location.href="../../eMR/jsp/TLLinkQueryResult.jsp?Report="+Report+"&Master="+Master+"&main_group="+main_group+"&sub_group="+sub_group+"&level3_group="+level3_group+"&concatvalues="+concatvalues+"&catalog_desc="+catalog_desc;
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
		document.forms[0].Master.value='';
		var obj_type = document.forms[0].Master;
			var length  = obj_type.length;
			for(i=0;i<length;i++) 
			{
				obj_type.remove(1);
			}
			if(obj.value=='IPBMIPCS')
			{
				var opt_type= document.createElement('Option');
				opt_type.text='Specialty'; 
				opt_type.value='SP';
				obj_type.add(opt_type)
				opt_type.selected = true;
			}
			else if(obj.value=='MRBSS203')
	        {
              var opt_type= document.createElement('Option');
			opt_type.text='Order Catalog'; 
			opt_type.value='OC';
			obj_type.add(opt_type)
			var opt_type= document.createElement('Option');
				opt_type.text='Specialty'; 
				opt_type.value='SP';
				obj_type.add(opt_type);
			}
			
		if(obj.value=='MROPCSMB' ||obj.value=='MRIPCSMB' ||obj.value=='MRDCCSMB' || obj.value=='MROPCSMS' || obj.value=='OPBMTMOR'|| obj.value=='IPBMRMOT'|| obj.value=='IPBEXCDT' || obj.value=='MRDCPROD' || obj.value=='MRDCPROS')
		{ //Above condtion modified for this CRF PER-RH-206
			var opt_type= document.createElement('Option');
			opt_type.text='Tabulation List'; 
			opt_type.value='TL';
			obj_type.add(opt_type)
			opt_type.selected = true;	
		}
		if(  obj.value=='MRBRADEX' ||obj.value=='MRBLABWL' || obj.value=='MRBLABRG')
		{
			var opt_type= document.createElement('Option');
			opt_type.text='Order Catalog'; 
			opt_type.value='OC';
			obj_type.add(opt_type)
			opt_type.selected = true;	
		}
			if(obj.value=='MRIPCSEG' ||obj.value=='MROPANPO' || obj.value=='MROPCSEG')
			{
				var opt_type= document.createElement('Option');
				opt_type.text='Race Group'; 
				opt_type.value='RC';
				obj_type.add(opt_type)
				opt_type.selected = true;	
			}
			else if(obj.value=='MRIPCSMH')
			{
				var opt_type= document.createElement('Option');
				opt_type.text='Delivery Type'; 
				opt_type.value='DT';
				obj_type.add(opt_type)
				var opt_type= document.createElement('Option');
				opt_type.text='ICD Code'; 
				opt_type.value='IC';
				obj_type.add(opt_type)
				var opt_type= document.createElement('Option');
				opt_type.text='Specialty'; 
				opt_type.value='SP';
				obj_type.add(opt_type)
				/*Added by Ashwini on 28-Jan-2021 for ML-MMOH-CRF-1341*/
				var opt_type= document.createElement('Option');
				opt_type.text='Race Group'; 
				opt_type.value='RC';
				obj_type.add(opt_type)
				var opt_type= document.createElement('Option');
				opt_type.text=getLabel("eMR.DelAttndBy.label","MR"); 
				opt_type.value='DA';
				obj_type.add(opt_type)
				/*End ML-MMOH-CRF-1341*/
				//opt_type.selected = true;	
			}
			else if(obj.value=='MROPCSAT' ||obj.value=='MRBRH203' || obj.value=='MROPRFLS' ||obj.value=='IPBMCSBU')
			{//MRBRH203 added by Rameswar on 09/11/2016 for HSA-CRF-0209.1				
				var opt_type= document.createElement('Option');
				opt_type.text='Specialty'; 
				opt_type.value='SP';
				obj_type.add(opt_type)
				if((obj.value!='MROPRFLS' && obj.value!='MRIPCSBD') || (obj.value!='MROPRFLS' && obj.value!='MRIPCSOBD'))
					opt_type.selected = true;	//Modified for this CRF PER-PD-209A
				if(obj.value=='MROPRFLS')
				{
					var opt_type= document.createElement('Option');
					opt_type.text='Healthcare Setting Type'; 
					opt_type.value='HC';
					obj_type.add(opt_type)
				}
			}
			else if(obj.value=='MRIPCSBD' || obj.value=='MRIPCSOBD')
			{ //Above line modified for PER-PD-209A
				var opt_type= document.createElement('Option');
				opt_type.text='Specialty'; 
				opt_type.value='SP';
				obj_type.add(opt_type)
				var opt_type= document.createElement('Option');
				opt_type.text='Bed Class'; 
				opt_type.value='BD';
				obj_type.add(opt_type)
			}
			else if(obj.value=='IPBMCREF')
			{ 
				var opt_type= document.createElement('Option');
				opt_type.text='Nursing Unit'; 
				opt_type.value='NU';
				obj_type.add(opt_type)
				var opt_type= document.createElement('Option');
				opt_type.text='Clinic/Procedure Unit'; 
				opt_type.value='CP';
				obj_type.add(opt_type)
				var opt_type= document.createElement('Option');
				opt_type.text='Healthcare Setting'; 
				opt_type.value='HC';
				obj_type.add(opt_type)
				var opt_type= document.createElement('Option');
				opt_type.text='Specialty'; 
				opt_type.value='SP';
				obj_type.add(opt_type)
				/*Added by Ashwini on 19-Jun-2019 for ML-MMOH-CRF-1340*/
				var opt_type= document.createElement('Option');
				opt_type.text=getLabel("Common.Staff.label","Common")+" "+getLabel("Common.clinic.label","Common"); 
				opt_type.value='SC';
				obj_type.add(opt_type)
				/*End ML-MMOH-CRF-1340*/
			}
			else if(obj.value=='MRBPD207' )
			{
				var opt_type= document.createElement('Option');
				opt_type.text='Specialty'; 
				opt_type.value='SP';
				obj_type.add(opt_type)
				var opt_type= document.createElement('Option');
				opt_type.text='Bed Service Classification'; 
				opt_type.value='BC';
				obj_type.add(opt_type)
			}
			else if(obj.value=='MRBBAT3A')
			{
				var opt_type= document.createElement('Option');
				opt_type.text='ICD Code'; 
				opt_type.value='IC';
				obj_type.add(opt_type)
				var opt_type= document.createElement('Option');
				opt_type.text='Name Suffix'; 
				opt_type.value='NS';
				obj_type.add(opt_type)				
				var opt_type= document.createElement('Option');
				opt_type.text='Disposal'; 
				opt_type.value='DP';
				obj_type.add(opt_type)
				var opt_type= document.createElement('Option');
				opt_type.text='Healthcare Setting'; 
				opt_type.value='HC';
				obj_type.add(opt_type)
			}
			else if(obj.value=='MRBBAT3B' || obj.value=='MRBBAT3C')
			{
				var opt_type= document.createElement('Option');
				opt_type.text='ICD Code'; 
				opt_type.value='IC';
				obj_type.add(opt_type)				
				var opt_type= document.createElement('Option');
				opt_type.text='Healthcare Setting'; 
				opt_type.value='HC';
				obj_type.add(opt_type)	
			}

	}
	
</script>
<form name="Report_Group_form11" id="Report_Group_form11" action="../../eMR/jsp/ReportGroupQueryResult.jsp" method="post">
<%

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

	<body onLoad='focusObj();changereport(document.forms[0].Report_id)' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
		<form name='report_form_query' id='report_form_query'>
		
			<table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
	         <th colspan=2 align='left'><fmt:message key="Common.QueryCriteria.label" bundle="${common_labels}"/></th>			
	         <tr>
					<td colspan='2'>&nbsp;</td>
				</tr>
				<tr>
				     <td align='right' class='label'><fmt:message key="Common.report.label" bundle="${common_labels}"/></td>
				     <td align='left'>&nbsp;<select name='Report_id' id='Report_id' onchange='changereport(this)'>
					<option value=''>&nbsp;&nbsp;&nbsp;----- Select -----&nbsp;&nbsp;&nbsp;</option>
					<%
		    //Below line modified for this CRF PER-RH-206 and PER-PD-209A        
          String populate="select report_id,report_desc from sm_report where report_id in ('MROPCSMB','MRIPCSMB','MROPCSMS','IPBMIPCS','MRBRADEX','MRBLABWL','MRBLABRG','MRBSS203','MROPRFLS','MROPCSAT','MRIPCSBD','MRIPCSMH','MRIPCSEG','MRBRH212','MROPANPO','MROPCSEG','IPBMCSBU','OPBMTMOR','IPBMRMOT','IPBEXCDT','MRBPD207','IPBMCREF','MRBBAT3A','MRBBAT3B','MRBBAT3C','MRDCCSMB','MRIPCSOBD','MRDCPROD','MRDCPROS','MRBRH203') order by report_desc" ;//MRBRH203 added by Rameswar on 09/11/2016 for HSA-CRF-0209.1
		
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
    				     <td align='left' nowrap>&nbsp;<select name='Master' id='Master'>
    				
					<option value=''>-------------Select---------------</option>
						 <!-- <option value='DT'>Delivery Type</option>
						 <option value='HC'>Healthcare Setting Type </option>
						 <option value='RC'>Race Group</option>
				         <option value='SP'>Specialty</option> -->
                       <!--  <option value='OC'>Order Catalog </option>
						 <option value='TL'>Tabulation List</option> -->
                        
                         </SELECT>
    	 		  		
    				     </td>
    				</tr>
				<tr><td colspan='2'></td></tr>
					 <tr><td colspan='2'></td></tr>
					 <tr><td colspan='2'></td></tr>
					 <tr><td colspan='2'></td></tr>
					 <tr><td colspan='2'></td></tr>
				<tr>
							 <td align='right' class='label' nowrap><fmt:message key="eMR.level1group.label" bundle="${mr_labels}"/></td>
					<td  align='left'>&nbsp;<input type="text" name="main_group" id="main_group" size='20' maxlength='20'></td>
					
				</tr>
					 
				
				 <tr><td colspan='2'></td></tr>
					 <tr><td colspan='2'></td></tr>
					 <tr><td colspan='2'></td></tr>
					 <tr><td colspan='2'></td></tr>
					 <tr><td colspan='2'></td></tr>
					 <tr>
					<td align='right' class='label' nowrap><fmt:message key="eMR.level2group.label" bundle="${mr_labels}"/></td>
					<td  align='left'>&nbsp;<input type="text" name="sub_group" id="sub_group" size='20' maxlength='40'></td>
				</tr>

				 <tr><td colspan='2'></td></tr>
					 <tr><td colspan='2'></td></tr>
					 <tr><td colspan='2'></td></tr>
					 <tr><td colspan='2'></td></tr>
					 <tr><td colspan='2'></td></tr>
				 <tr>
					<td align='right' class='label' nowrap><fmt:message key="eMR.level3group.label" bundle="${mr_labels}"/></td>
					<td  align='left'>&nbsp;<input type="text" name="level3_group" id="level3_group" size='20' maxlength='30'></td>
				 </tr>
					 <tr><td colspan='2'></td></tr>
					 <tr><td colspan='2'></td></tr>
					 <tr><td colspan='2'></td></tr>
					 <tr><td colspan='2'></td></tr>
					 <tr><td colspan='2'></td></tr>
				 <tr>
					<td align='right' class='label' nowrap><fmt:message key="eMR.MasterDescription.label" bundle="${mr_labels}"/></td>
					<td  align='left'>&nbsp;<input type="text" name="catalog_desc" id="catalog_desc" size='20' maxlength='30'></td>
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
						<Select name="OrderbyCols" id="OrderbyCols" size="5">
						   
						   <Option value="MAST_TABLE_NAME_REFERENCE"><fmt:message key="eMR.Master.label" bundle="${mr_labels}"/></option>
						   <Option value="GROUP_DESC"><fmt:message key="eMR.level1group.label" bundle="${mr_labels}"/></option>
				           <Option value="SUB_GROUP_DESC"><fmt:message key="eMR.level2group.label" bundle="${mr_labels}"/></option>
						   <!--order By corrected - Sangeetha on 14/Dec/2016-->
						   <Option value="LEVEL3_DESC"><fmt:message key="eMR.level3group.label" bundle="${mr_labels}"/></option>
						   <Option value="MAST_DESC"><fmt:message key="eMR.MasterDescription.label" bundle="${mr_labels}"/></option>
						</Select>
				    </td>
					<td align='center' width='3%' >
				       <input type='button' name='add' id='add' class='button' onclick='addOrderByCol()' value='---->'> 
					   <input type='button' name='add' id='add' class='button'  value='<----' onclick='removeOrderByCol()'></img>
				   </td>
					<td width="45%" align="center"><Select name="OrderbyColumns" id="OrderbyColumns" size="4" multiple="true"><Option value="REPORT_DESC"><fmt:message key="Common.report.label" bundle="${common_labels}"/>  </Select></td>
				</tr>
			</table><br><br></div>
			<table border='0' width='100%' align='center'>
						<tr>
							 <td nowrap width='100%' align='center'  ><input type='button' name='ExecuteQuery' id='ExecuteQuery' class='Button'  onclick='execQuery()' Value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Execute.label","common_labels")%>'>
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

