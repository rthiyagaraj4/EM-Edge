<!DOCTYPE html>
<html>
<%@ page import ="webbeans.eCommon.*,java.sql.*, java.text.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %> 
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/messages.js' language='javascript'></script>
<!-- <script src='../../eCommon/js/MstCodeCommon.js' language='javascript'></script> -->
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eMR/js/ReportCodeSetup.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function execQuery()
{
//	var Report   = document.forms[0].Report_id.value
	var p_census_date       = document.forms[0].p_census_date.value
	var main_group = document.forms[0].main_group.value
	var sub_group        = document.forms[0].sub_group.value	
	var bed_class_group        = document.forms[0].bed_class_group.value
	var concatvalues="";
	for (i=0; i< document.forms[0].OrderbyColumns.options.length; i++)
	{ 
		concatvalues=concatvalues+document.forms[0].OrderbyColumns.options[i].value+"|";
	}
       parent.frames[1].location.href="../../eMR/jsp/AnnualCensusofBedQueryResult.jsp?p_census_date="+p_census_date+"&main_group="+main_group+"&sub_group="+sub_group+"&bed_class_group="+bed_class_group+"&concatvalues="+concatvalues;
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
			if(from && from.options && from.selectedIndex !== undefined){
				element.text = from.options[from.selectedIndex].text; 
			}
			
			element.value = from.options[from.selectedIndex].value; to.add(element);			
			from.remove(from.selectedIndex); 
		} 
	}	
	
 
	function focusObj()
	{
			document.forms[0].p_census_date.focus();
	}	
	
	
</script>
<form name="Report_Group_form11" id="Report_Group_form11" action="../../eMR/jsp/ReportGroupQueryResult.jsp" method="post">
<%

	String fid=(String)session.getValue("facility_id") ;
	String facilityId = request.getParameter("facilityId");
		if(facilityId == null || facilityId.equals("")) facilityId=fid;
	String p_report_id		= "MRIPCSBD" ;
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

	<body onLoad='focusObj();' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
		<form name='report_form_query' id='report_form_query'>
		
			<table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
	         <th colspan=2 align='left'>Query Criteria</th>			
	         <tr>
					<td colspan='2'>&nbsp;</td>
			</tr>					
					 <tr><td colspan='2'></td></tr>
					 <tr><td colspan='2'></td></tr>
					 <tr><td colspan='2'></td></tr>
						
					<tr>
   				        <td align='right' class='label' nowrap>Census Year</td>
    				     <td align='left' nowrap>&nbsp;<input type='text' name='p_census_date' id='p_census_date' size='4'  maxlength='4'>    	 		  		
    				     </td>
    				</tr>
				<tr><td colspan='2'></td></tr>
					 <tr><td colspan='2'></td></tr>
					 <tr><td colspan='2'></td></tr>
					 <tr><td colspan='2'></td></tr>
					 <tr><td colspan='2'></td></tr>
				<tr>
							 <td align='right' class='label' nowrap>Level1 Group</td>
					<td  align='left'>&nbsp;<input type="text" name="main_group" id="main_group" size='20' maxlength='20'></td>
					
				</tr>
					 
				
				 <tr><td colspan='2'></td></tr>
					 <tr><td colspan='2'></td></tr>
					 <tr><td colspan='2'></td></tr>
					 <tr><td colspan='2'></td></tr>
					 <tr><td colspan='2'></td></tr>
					 <tr>
					<td align='right' class='label' nowrap>Level2 Group</td>
					<td  align='left'>&nbsp;<input type="text" name="sub_group" id="sub_group" size='20' maxlength='40'></td>
				</tr>

				 <tr><td colspan='2'></td></tr>
					 <tr><td colspan='2'></td></tr>
					 <tr><td colspan='2'></td></tr>
					 <tr><td colspan='2'></td></tr>
					 <tr><td colspan='2'></td></tr>	
					 
				 <td align='right' class='label' nowrap>Bed Class Group</td>
					<td  align='left'>&nbsp;<input type="text" name="bed_class_group" id="bed_class_group" size='20' maxlength='40'></td>
				</tr>

				 <tr><td colspan='2'></td></tr>
					 <tr><td colspan='2'></td></tr>
					 <tr><td colspan='2'></td></tr>
					 <tr><td colspan='2'></td></tr>
					 <tr><td colspan='2'></td></tr>	
							  
	
  			</table>
			<table width='100%' align='center'>
			 <th width='20%' align='left'>Sort Order</th>
			 <tr>
				<td nowrap  width='60%' >
				<p  title='Sort Order'>
		 <table width='100%'><td nowrap  align='center'><b>Select</td><td>&nbsp;</td><td nowrap align='center'><b>Order by</td><tr><td nowrap width='45%'  >
				<tr>
				    <td width="45%" align="center">
						<Select name="OrderbyCols" id="OrderbyCols" size="5">
						   
						   <Option value="CENSUS_YEAR">Census Year
						   <Option value="GROUP_CODE">Level1 Group
				           <Option value="SUB_GROUP_CODE">Level2 Group
						   <Option value="BED_CLASS_GROUP_CODE">Bed Class Group			  
						</Select>
				    </td>
					<td align='center' width='3%' >
				       <input type='button' name='add' id='add' class='button' onclick='addOrderByCol()' value='---->'> 
					   <input type='button' name='add' id='add' class='button'  value='<----' onclick='removeOrderByCol()'></img>
				   </td>
					<td width="45%" align="center"><Select name="OrderbyColumns" id="OrderbyColumns" size="4" multiple="true"><Option value="CENSUS_YEAR">Census Year </Select></td>
				</tr>
			</table><br><br></div>
			<table border='0' width='100%' align='center'>
						<tr>
							 <td nowrap width='100%' align='center'  ><input type='button' name='ExecuteQuery' id='ExecuteQuery' class='Button'  onclick='execQuery()' Value='Execute'>
							</td>
					  </tr>
		 </table> 
								

		
		<input type='hidden' value="" name="concatvalues" id="concatvalues">
		<input type="hidden" name="Report_id" id="Report_id" 	value="<%= p_report_id %>">
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

