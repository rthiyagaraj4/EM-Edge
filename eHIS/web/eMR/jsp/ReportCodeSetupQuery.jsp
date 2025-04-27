<!DOCTYPE html>
<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="webbeans.eCommon.*,java.sql.*, java.text.*"   contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %> 
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>


<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eMR/js/ReportCodeSetup.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	function focusObj()
	{
			document.forms[0].Report_id.focus();
	}
	function chagetype()
	{
		parent.frames[1].location.href='../../eCommon/html/blank.html'
	}
	function changereport(obj)
	{
		document.forms[0].type.value='';
		parent.frames[1].location.href='../../eCommon/html/blank.html'
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
				opt_type.text=getLabel("Common.speciality.label","Common"); 
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
				opt_type.text=getLabel("Common.speciality.label","Common"); 
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
				
				//opt_type.selected = true;	
			}
	}
	function chkReport()
	{
		var Report_id=document.forms[0].Report_id.value;
		var type=document.forms[0].type.value;
		
		if(Report_id=='')
		{
			var error=getMessage("CAN_NOT_BE_BLANK","Common");
			error= error.replace('$',getLabel("Common.report.label","Common"));
			alert(error);
			document.forms[0].Report_id.focus();
			return false;	
		}
		else if(type=='')
		{
			var error=getMessage("CAN_NOT_BE_BLANK","Common");
			error= error.replace('$',getLabel("eMR.Master.label","MR"));
			alert(error);
			document.forms[0].type.focus();
			return false;
		}
		else if(Report_id !='' && type !='')
		{
		if(parent.frames[1].document.forms[0])
			parent.frames[1].document.forms[0].submit();
			parent.frames[1].location.href='../../eMR/jsp/ReportCodeSetupResult.jsp?Report_id='+Report_id+'&type='+type
			parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp'
		}	
	
	}

</script>
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
	//java.util.Properties ReportCodeSetupQuery.jsp=(java.util.Properties) session.getValue( "jdbc" );

	try
	{
		con = ConnectionManager.getConnection(request);
	
%>
	</head>

	<body onLoad='focusObj()' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
		<form name='report_form_query' id='report_form_query'>
			<br><br>
			<table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
				<tr>
					<td colspan='4'>&nbsp;</td>
				</tr>
				<tr>
				     <td align='right' class='label'><fmt:message key="Common.report.label" bundle="${common_labels}"/></td>
				     <td align='left'>&nbsp;<select name='Report_id' id='Report_id' onchange='changereport(this)'>
					<option value=''>&nbsp;&nbsp;&nbsp;---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------&nbsp;&nbsp;&nbsp;</option>
                     
					<%
		             
          String populate="Select Report_id,report_desc from sm_report where (module_id ='MR' or module_id ='IP')And report_id  IN('MROPRFLS','MROPCSAT','MRIPCSBD','MRIPCSMH','MRIPCSEG','MROPANPO','MROPCSEG','IPBMCSBU') order by report_desc" ;
		
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
					 <img src='../../eMP/images/mandatory.gif'>
				     </td>
   				     <td align='right' class='label' nowrap><fmt:message key="eMR.Master.label" bundle="${mr_labels}"/></td>
    				     <td align='left' nowrap>&nbsp;<select name='type' id='type' onChange='chagetype()'>
    				
					<option value=''>--------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------------</option>
						 <option value='DT'><fmt:message key="eMP.DeliveryType.label" bundle="${mp_labels}"/></option>
						<option value='HC'><fmt:message key="Common.HealthcareSettingType.label" bundle="${common_labels}"/> </option>
						 <option value='RC'><fmt:message key="eMP.RaceGroup.label" bundle="${mp_labels}"/></option>
				          <option value='SP'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></option>
                        
                        
                         </SELECT>
    	 		  		 <img src='../../eMP/images/mandatory.gif'>
    				     </td>
    				</tr>
				<tr>
					<td colspan='4'>&nbsp;</td>
				</tr>
    				<tr>
    					<td colspan='4' nowrap class='button'>&nbsp;<input type='button' name='Search' id='Search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='button' onClick='chkReport()' ></td>
							
   				</tr>
			
  			</table>
		</div>
		
	</form>
</body>
</html>
		<%	 }
			  catch(Exception e){/* out.print(e); */ e.printStackTrace();}
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

