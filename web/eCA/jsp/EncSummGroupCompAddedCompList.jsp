<!DOCTYPE html>
<!--
Created By: D. Sethuraman
-->
<%@ page language="java" import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.*, eCA.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%	
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	eCA.EncSummCompRecBean summRecCompBean = (eCA.EncSummCompRecBean)getObjectFromBean("summRecCompBean","eCA.EncSummCompRecBean",session);
%>
<html>
	<head>
		<title><fmt:message key="eCA.AddedComponents.label" bundle="${ca_labels}"/></title>
		<%
			String sStyle =
			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			
			EncSummGroup summGrpDetails = new EncSummGroup();			 	
			
			List<EncSummTemplateTypeBean> oTempTypeList = null;
			EncSummTemplateTypeBean sTempTypeBean = null;
			
			int ntypeListSize = 0;
			String oTempType = "";
			
			oTempTypeList = new ArrayList<EncSummTemplateTypeBean>();
			sTempTypeBean = new EncSummTemplateTypeBean();
			
			sTempTypeBean.setRequest(request);
			oTempTypeList = summGrpDetails.getTemplateType(sTempTypeBean);		
			
			ntypeListSize = oTempTypeList.size();
			if (ntypeListSize>0){
				for (int i=0;i<ntypeListSize;i++){
					sTempTypeBean = oTempTypeList.get(i);
					oTempType = oTempType + "<Option value="+sTempTypeBean.getsTemplateType()+">" +sTempTypeBean.getsTemplateDesc()+ "</option>";
				}
			}
			
			String mode = request.getParameter("mode") == null ? "" : request.getParameter("mode");
			
			String groupFlag = request.getParameter("groupFlag") == null ? "" : request.getParameter("groupFlag");
			String groupType = request.getParameter("groupType") == null ? "" : request.getParameter("groupType");
			String groupCode = request.getParameter("groupCode") == null ? "" : request.getParameter("groupCode");	
			
			String btnDisabled = "";			
			
			if (groupFlag.equalsIgnoreCase("0"))
				btnDisabled = "";
			else
				btnDisabled = "";
			
			String flag_for_list = request.getParameter("flag_for_list") == null ? "true" : request.getParameter("flag_for_list");
			String noOfRows = request.getParameter("noOfRows") == null ? "0" : request.getParameter("noOfRows");
			String firstPosition = request.getParameter("firstPosition") == null ? "0" : request.getParameter("firstPosition");
			String secondPosition = request.getParameter("secondPosition") == null ? "0" : request.getParameter("secondPosition");
			String classValue = "";
			int cnt = 0;
			String chk="";
			String disable="disabled";
			int count=0;
			
			int compFlag = 0, compTemplate = 0, compColumns = 0;
			String compSubGroup="", subGroupType="", compFlagDesc="", compCode="", compType="", compRemarks="", compTemplateDesc="",  compStatus="", compSubGroupDesc="";			
			
			int j = 0;
			int k = 0;
			int noOfRows1 = 0;
			int ctr=0;
			int sequenceNumber = 0;
			boolean subGroupFlag = false;
			
			String finalString = "", val = "", val1 = "", val2 = "",val3 = "", val4 = "", val5 = "";	
			StringTokenizer tokenizeTilde = null;
			StringTokenizer tokenizePipe = null;
			
			int index=0;
			
		%>
		
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script language='javascript' src='../../eCA/js/EncSummGroupComp.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>	        
	        function refreshParent() {	        	
	        	window.close();	        	
	        }	 
	        function insertComponents()
	        {	        	
	        	//modAllComponent();
	        	
	        	parent.selectedCompFrame.document.addedCompForm.action='../../servlet/eCA.EncSummGroupCompServlet';
	        	parent.selectedCompFrame.document.addedCompForm.target='messageFrame';
	        	parent.selectedCompFrame.document.addedCompForm.method='post';
	        	parent.selectedCompFrame.document.addedCompForm.submit();
	        	
	        	//document.addedCompForm.submit();
	        	//window.close();		        	
	        }
	    </script>
		
	</head>
	<body onscroll='scrollTitleTop()' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name='addedCompForm' id='addedCompForm' action='EncSummGroupCompAddedCompList.jsp' method='post'>		
				
			<table class='grid' cellpadding='3' cellspacing='0' border='1' width='100%'  align='center'>
				<tr id='trcoll'>
					<td class='columnHeader' colspan='3'><fmt:message key="eCA.AddedComponents.label" bundle="${ca_labels}"/></td>						
					<td class='columnHeader' align=left colspan='1'><input type='button' name='saveBtn' id='saveBtn' class='button' <%=btnDisabled%>
											value = '<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Save.label","common_labels")%>'
											onclick='insertComponents()'>
					</td>					 					
					<td class='columnHeader' align=left colspan='1'><input type='button' name='cancelBtn' id='cancelBtn' class='button' 
											value = '<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>'
											onclick='refreshParent()'>
					</td>				
				</tr>
			</table>
			<table class='grid' cellpadding='3' cellspacing='0' border='0' width='100%'  align='center'>
				<tr id='trcoll'>
					<td class='COLUMNHEADERCENTER' width="100" ><fmt:message key="Common.SubGroup.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADERCENTER'><fmt:message key="eCA.ComponentDescription.label" bundle="${ca_labels}"/></td>					
					<td class='COLUMNHEADERCENTER'><fmt:message key="eCA.TemplateType.label" bundle="${ca_labels}"/></td>
					<td class='COLUMNHEADERCENTER'><fmt:message key="eCA.ColumnNumbers.label" bundle="${ca_labels}"/></td>
					<td class='COLUMNHEADERCENTER'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>					
				</tr>	
				<%
				String keyVal = "";
				String mapVal = "";
				
				String comp_flag = "";
				String comp_type = "";
				String comp_id = "";
				String comp_desc = "";
				String comp_template = "";
				
				String rowno = "";
				
				StringTokenizer strCodeToken = null;
				String chief_complaint_sect_yn="";
				//StringTokenizer strSeqToken = null;
				int i=0;
				int tempInt = i +1;

				int positionOne = Integer.parseInt(firstPosition);
				positionOne = positionOne - 1;
				int positionTwo = Integer.parseInt(secondPosition);				
				positionTwo = positionTwo - 1;
				int totalRows = Integer.parseInt(noOfRows);
				String codeList = "";
				
				String comp_temp = "", comp_col_count = "", comp_column = "";	
				int comp_temp_int = 0;
				String selected_flag_value = "";
				String selected_flag = "";
				
				try
					{							
						String check="";						
						if(!flag_for_list.equals("false"))
						{							
							if(totalRows < positionTwo)
								positionTwo = positionTwo -1;
							else
								positionTwo = positionTwo;
							
							ArrayList list = summRecCompBean.retrieveArrayList();							
							for(k=0;k<list.size();k++)
							{								
								codeList = (String) list.get(k);
								if(positionOne == k)
								{
									summRecCompBean.addToList(positionTwo,codeList);
									
									if(positionTwo > positionOne)
									{
										k = list.size();
									}
								}						
							}
							if(positionTwo > positionOne)
							{							
								summRecCompBean.removeElement(positionOne);
							}
							else if(positionTwo < positionOne)
							{								
								summRecCompBean.removeElement(positionOne+1);
							}
							putObjectInBean("summRecCompBean",summRecCompBean,session);
						}						
						
						HashMap recValues = summRecCompBean.getHashValues();						
						ArrayList indexList = new ArrayList();		
						indexList = summRecCompBean.retrieveArrayList();
						
						for(i=0; i<indexList.size(); i++)
						{							
							tempInt = i +1;							
							keyVal = (String)indexList.get(i);
							mapVal = (String)recValues.get(keyVal);
							strCodeToken = new StringTokenizer(mapVal,"~");
							while(strCodeToken.hasMoreTokens())
							{
								comp_flag = strCodeToken.nextToken();
								rowno = strCodeToken.nextToken();
								comp_type = strCodeToken.nextToken();

								comp_id = strCodeToken.nextToken();
								comp_desc = strCodeToken.nextToken();

								comp_temp = strCodeToken.nextToken();

								if (comp_temp.equalsIgnoreCase("@"))
								{
									comp_temp = "";
									comp_temp_int = 0;
								}
								else
									comp_temp_int = Integer.parseInt(comp_temp);
								
								comp_col_count = strCodeToken.nextToken();
								if (comp_col_count.equalsIgnoreCase("@"))
									comp_col_count = "";
								
								comp_column = strCodeToken.nextToken();
								if (comp_column.equalsIgnoreCase("@"))
									comp_column = "";
								
								selected_flag_value = strCodeToken.nextToken();
								
								if (selected_flag_value.equalsIgnoreCase("0"))
									selected_flag = "";
								else
									selected_flag = "checked";
								
								if(i%2 ==0)
									classValue = "QRYEVEN";
								else
									classValue = "QRYODD";
						
								%>
								
								<tr id = 'numRows'<%=i%>>
								<td style='display:none'> <input type= hidden value="<%=keyVal%>" name='comp_key<%=i%>'> </td>	
								<td style='display:none'> <input type= hidden value="<%=comp_flag%>" name='es_comp_flag<%=i%>'> </td>
								<td style='display:none'> <input type= hidden value="<%=comp_type%>" name='es_comp_type<%=i%>'> </td>
								<td style='display:none'> <input type= hidden value="<%=comp_id%>" name='es_comp_code<%=i%>'> </td>
								<td style='display:none'> <input type= hidden value="<%=comp_desc%>" name='es_comp_desc<%=i%>'> </td>
								<td class='gridData'   > <%=comp_id%></td>								
								<td class='gridData'   > <%=comp_desc%></td>								
								<td class='fields' >&nbsp;<select name='es_comp_template<%=i%>' id='es_comp_template<%=i%>'  id='es_comp_template<%=i%>'>								
								<option value="">-----<fmt:message key='Common.defaultSelect.label' bundle='${common_labels}'/>-----</option>	
									<%=oTempType%>
								</select><img src='../../eCommon/images/mandatory.gif'></td>	
								
								<script>									
									var tempObjName = 'es_comp_template'+<%=i%>;									
									if ('<%=comp_temp_int%>' > 0 )
									{
										var selTempObj = document.getElementById(tempObjName);										
										for(var i=0;i<selTempObj.options.length;i++){											
								            if (selTempObj.options[i].value == '<%=comp_temp_int%>') {
								            	selTempObj.selectedIndex = i;
								                break;
								            }
								        }
									}
								</script>
															
								<td class='fields' align='center'> <input type='text' name='es_comp_colcount<%=i%>' id='es_comp_colcount<%=i%>'  id='es_comp_colcount<%=i%>' size=2 value="<%=comp_col_count%>" > </td>
								<td class='gridData'   align='center'> <input type='checkbox' name='es_comp_select<%=i %>' id='es_comp_select<%=i %>' <%=selected_flag %> onclick='modComponent(this,"<%=comp_flag%>","<%=comp_type%>","<%=comp_id%>","<%=comp_desc%>",<%=i%>)'> </td>
								</tr>
								<%								 
								
							}
						}
						tempInt++;						
						cnt = indexList.size(); 
						
					}
					catch(Exception e)
					{
						//out.println("Exception in try of EncSummGroupCompAddedComp " +e.toString());//COMMON-ICN-0181
						e.printStackTrace();
					}
				%>			
			</table>			
			<input type="hidden" name="conc_string" id="conc_string" value="">
			<input type="hidden" name="countOfRows" id="countOfRows" value="<%=cnt%>">
			<input type="hidden" name="firstPos" id="firstPos" value="">
			<input type="hidden" name="secPos" id="secPos" value="">
			<input type="hidden" name="flag" id="flag" value="true">
			<input type="hidden" name="count" id="count" value="<%=count%>">
			<input type="hidden" name="mode" id="mode" value="<%=mode%>">
			<input type="hidden" name="es_group_flag" id="es_group_flag" value="<%=groupFlag%>">
			<input type="hidden" name="es_group_type" id="es_group_type" value="<%=groupType%>">
			<input type="hidden" name="es_group_code" id="es_group_code" value="<%=groupCode%>">
			<input type ='hidden' name='finalString' id='finalString' value=''>     <!-- has the ConCatenated String to be Posted to Servlet File and also used for Posting ConCatenated String between JSP's -->
			<input type="hidden" name="groupFlag" id="groupFlag" value="">
			<input type="hidden" name="groupType" id="groupType" value="">
			<input type="hidden" name="groupCode" id="groupCode" value="">			
		</form>		
	</body>
</html>

