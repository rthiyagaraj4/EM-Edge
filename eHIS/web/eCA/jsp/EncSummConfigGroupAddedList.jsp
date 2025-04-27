<!DOCTYPE html>
<%
/* 
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
20/09/2013     		1   		Sethuraman      Created
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="webbeans.eCommon.*,eCA.*, java.util.*,java.sql.*, java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
 <%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script language='javascript' src='../js/EncSummConfig.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
</head>
<%			
	String summaryCode = request.getParameter("summaryCode") == null ? "" : request.getParameter("summaryCode");		
	String mode = request.getParameter("mode") == null ? "" : request.getParameter("mode");
	String operation = request.getParameter("operation") == null ? "" : request.getParameter("operation");
	

	List<EncSummConfigGroupBean> oSummGroupList = null;
	EncSummConfigGroupBean sConfigGroupBean = null;
	
	EncSummGroup summGrpDetails = new EncSummGroup();	
	
	int nGroupListSize = 0;
	String remove_value = "",add_value = "";
	String finalString = "",val = "", val1= "", val2= "",val3= "", val4="";	
	StringTokenizer tokenizeTilde = null;
	StringTokenizer tokenizePipe = null;
	String classValue="";
%>
<body   class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()" OnScroll="scrollTitle()" >
	 <form name="GroupAddedfrm" id="GroupAddedfrm" method="post"  action ='EncSummConfigGroupAddedList.jsp'>
	 <div id='divDataTitle' style='postion:relative'>
	 <table border='1' width='100%' id='dataTitleTable' cellpadding='3' cellspacing='0' align='center'>	
		<tr><td class='columnHeadercenter' colspan='3'><fmt:message key="eCA.SelectedGroups.label" bundle="${ca_labels}"/></td></tr>
		<tr>
			<td class='columnHeadercenter' width='50%'><fmt:message key="eCA.groupdesc.label" bundle="${ca_labels}"/></td>
			<td class='columnHeadercenter'width='15%'><fmt:message key="eCA.OrderSequenceNumber.label" bundle="${ca_labels}"/></td>
			<td class='columnHeadercenter' width='15%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
		</tr>	
	</table>
	 </div>
	<table class='grid' align='center' border="1" width="100%" id='dataTable' >
	<%	
	int index = 0;
	String text_name="", tblrow_id="", tdrow_id="";
	String chkSelBox = "";
	String group_code = "", group_desc = "", group_type = "", hiddenGroupCode = "", hiddenGroupType = "";	
	int seqNo = 0;
	try
		{	
			if (!operation.equals("addRows"))
			{					
				oSummGroupList = new ArrayList<EncSummConfigGroupBean>();
				sConfigGroupBean = new EncSummConfigGroupBean();
				
				sConfigGroupBean.setRequest(request);			
				sConfigGroupBean.setsSummaryCode(summaryCode);
				
				oSummGroupList = summGrpDetails.getSummaryConfigAddedGroups(sConfigGroupBean);		
				
				sConfigGroupBean = new EncSummConfigGroupBean();
				
				nGroupListSize = oSummGroupList.size();	
				
				for (int i=0;i<nGroupListSize;i++){
					index++;
					sConfigGroupBean = oSummGroupList.get(i);
					group_code = sConfigGroupBean.getsGroupCode();
					group_type = sConfigGroupBean.getsGroupType();
					group_desc = sConfigGroupBean.getsGroupDesc();	
					seqNo = sConfigGroupBean.getiSequence();
					
					text_name= "seq_num"+ index;
					tdrow_id = "tdrow_id"  + index;
					hiddenGroupCode = "GroupCode"+index;
					hiddenGroupType = "GroupType"+index;
					
					%>
					<tr  id='<%=tdrow_id%>'>
					 	<td width='50%' class='gridData'  ><%=group_desc%></td><!-- Displays the Description -->
						<td width='15%' align="center" class='gridData'>
							<input type="text" name="<%=text_name%>" id="<%=text_name%>" value="<%=seqNo%>" size="6" maxlength="6" onKeyPress='return allowValidNumber(this,event,6,0);' 
								OnBlur="checkSequence(this)"><!--Text Field to display the Sequence Number -->
						</td>
						<td width='15%' align="center" class='gridData'>
							<input type="checkbox" name="select_yn<%=index%>" id="select_yn<%=index%>" value='Y' <%out.println("checked");%> OnClick ="removeRow(<%=index%>)">
						</td>
					</tr>	
					<input type ='hidden' name='<%=hiddenGroupCode%>' id='<%=hiddenGroupCode%>' value='<%=group_code%>'>	<!-- Hidden Variable for Storing Code for the Corresponding Description -->
					<input type ='hidden' name='<%=hiddenGroupType%>' id='<%=hiddenGroupType%>' value='<%=group_type%>'>
					<%								
				}	
			}
			else
			{
				out.println("<script>parent.parent.HeaderFrame.document.HeaderForm.finalString.value=''</script>");
				finalString = request.getParameter("finalString");
				remove_value = request.getParameter("remove_value");
				add_value =  request.getParameter("add_value");
				
				if(summaryCode==null ||summaryCode.equals("")) summaryCode="";				
				if(remove_value==null ||remove_value.equals("")) remove_value="";				
				if(add_value==null ||add_value.equals("")) add_value="";
				
				if(finalString==null || finalString.equals(""))
				{
					finalString = "";
				}
				tokenizeTilde = new StringTokenizer(finalString,"~");
				index=0;
				while(tokenizeTilde.hasMoreTokens())
				{
					index++;
					classValue = ((index%2)==0 )? "QRYEVEN" : "QRYODD";
					val = tokenizeTilde.nextToken();
					tokenizePipe =  new StringTokenizer(val,"||");
					val1 =java.net.URLDecoder.decode(tokenizePipe.nextToken());
					val2 = tokenizePipe.nextToken();
					val3 = tokenizePipe.nextToken();
					val4 = tokenizePipe.nextToken();
					if(val2.equalsIgnoreCase("null"))
					{
						val2="";
					}
					text_name= "seq_num"+ index;
					tdrow_id = "tdrow_id"  + index;
					hiddenGroupCode = "GroupCode"+index;
					hiddenGroupType = "GroupType"+index;
					
					%>
					<tr id ="<%=tdrow_id%>">
						<td width='50%' class='gridData'  ><%=val1%></td><!-- Displays the Description -->
						<td width='15%' align ="center" class='gridData'  >
								<input type="text" name="<%=text_name%>" id="<%=text_name%>" value="<%=val2%>" size="6" maxlength="6" onKeyPress="return allowValidNumber(this,event,6,0)" 
									OnBlur="minOccur2(this);checkSequence(this);"><!--Text Field to display the Sequence Number -->
						</td>
						<td width='15%'  align ="center" class='gridData'  >
								<input type="checkbox" name="select_yn<%=index%>" id="select_yn<%=index%>" value='Y' <%out.println("checked");%> OnClick ="removeRow(<%=index%>)">
						</td>
					</tr>							
					<input type ='hidden' name='<%=hiddenGroupCode%>' id='<%=hiddenGroupCode%>' value='<%=val3%>'>
					<input type ='hidden' name='<%=hiddenGroupType%>' id='<%=hiddenGroupType%>' value='<%=val4%>'>					
					<%	
				}
					
			}
		}
		catch(Exception e)
		{
			//out.println("Exception in try of EncSummConfigGroupAddedList.jsp"+e.toString());//common-icn-0181
			e.printStackTrace();
		}
	%>	
	</table>
	<input type ='hidden' name='finalString' id='finalString' value=''>     <!-- has the ConCatenated String to be Posted to Servlet File and also used for Posting ConCatenated String between JSP's -->
	<input type ='hidden' name='summaryCode' id='summaryCode' value=''>  <!-- Section Code  Value of the Main Section  -->
	<input type ='hidden' name='array_length' id='array_length' value='<%=index%>'> <!-- has the value of  number of Dynamic Created Text Boxes -->
	<input type ='hidden' name='remove_value' id='remove_value' value=''> <!-- Has the Code Value to remove Entry from the Selected List -->
	<input type ='hidden' name='operation' id='operation' value=''> <!-- a flag  value used for performing default and posted Value  -->
	<input type ='hidden' name='add_value' id='add_value' value=''><!-- Has the Code Value to adding Entry into the Selected List -->
	<input type ='hidden' name='select_value' id='select_value' value=''> 
</form>
</body>
</html>



