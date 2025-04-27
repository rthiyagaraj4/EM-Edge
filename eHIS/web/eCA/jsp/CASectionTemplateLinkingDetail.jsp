<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
--------------------------------------------------------------------------------------------------------------------------------
?				?				?				Created
11/04/2017     	INC61905       	DineshT        	The Scoring functionality In Notes should work in the similar manner as in Charts 												i.e on selection of individual variable, the score gets automatically calculated
--------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*, java.util.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
	eCA.CASectionTemplateFieldsAssociationBean templateBean = (eCA.CASectionTemplateFieldsAssociationBean)getObjectFromBean("templateBean","eCA.CASectionTemplateFieldsAssociationBean",session);
	
%>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String compId=request.getParameter("comp_id")==null?"":request.getParameter("comp_id");
	String srlNo=request.getParameter("srl_no")==null?"":request.getParameter("srl_no");

	Vector dependent = templateBean.getAssociatedComponents(compId+srlNo);
	String compType=request.getParameter("comp_type")==null?"":request.getParameter("comp_type");
	String sectionHdgCode= request.getParameter("section_hdg_code")==null?"":request.getParameter("section_hdg_code");	
	String compItemId= request.getParameter("compItemId")==null?"":request.getParameter("compItemId");
	String selectedCompIds = request.getParameter("selectedCompIds")==null?"":request.getParameter("selectedCompIds");
	selectedCompIds = java.net.URLDecoder.decode(selectedCompIds);
	

	

   String selectedSrlno ="";
    if(dependent != null)
	{
		Enumeration enumeration = dependent.elements();
        while(enumeration.hasMoreElements())
		{
	  selectedSrlno=selectedSrlno+"'"+enumeration.nextElement()+"'";
      if(enumeration.hasMoreElements())
      selectedSrlno = selectedSrlno + ",";
		}
	}

	if(compItemId == null || compItemId.equals("") )
	{
		if(compType.equals("L"))
			compItemId = "";  			//compItemId = compId+srlNo;

		else
			compItemId = "Y";    		//compItemId = compId+srlNo+"Yes";
	}
	Connection con=null;
	PreparedStatement pstmt=null;
	PreparedStatement pstmt1=null;
	ResultSet rs = null;
	ResultSet rs1 = null;
	int rowNo=0;
%>
<html>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
	<%
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
    
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script>
		function callOnRestrict(currentCompIdSrlNo,compItemId,comp_id)
		{
			var retVal			=	"";
			var dialogHeight	=	"80vh";
			var dialogWidth		=	"50vw";
			var dialogTop		=	"0vh";
			var status			=	"no";
			var action_url		=	'../../eCA/jsp/CASectionTemplateLinkingListItmesMain.jsp';
			var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:" + dialogTop +" ; scroll=auto; status:" + status;
			var compIdSrlNo = document.forms[0].compIdSrlNo.value;
			action_url			+=	"?comp_id="+comp_id+"&currentCompIdSrlNo="+currentCompIdSrlNo+"&compItemId="+compItemId+"&compIdSrlNo="+compIdSrlNo;
			retVal = top.window.showModalDialog(action_url,arguments,features);
			//parent.templateLinkingDetailFrame.location.href = parent.templateLinkingDetailFrame.location.href;
		}
		function enableFields(obj,compId_srlNo)
		{
			if(obj.checked)
			{
				eval("document.compLinkingForm.status_"+compId_srlNo+".value='false'");
				eval("document.compLinkingForm.status_"+compId_srlNo+".disabled=false");
				if(eval(document.getElementById("anchor_"+compId_srlNo))!=null)
				{
					eval("document.compLinkingForm.statusItem_"+compId_srlNo+".disabled=false");
					//eval("document.compLinkingForm.statusItem_"+compId_srlNo+".style.display='inline'");
					document.getElementById("anchor_"+compId_srlNo).innerText="Restrict";
				}
			}
			else
			{
				eval("document.compLinkingForm.status_"+compId_srlNo+".disabled=true");
				if(eval(document.getElementById("anchor_"+compId_srlNo))!=null)
				{
					eval("document.compLinkingForm.statusItem_"+compId_srlNo+".disabled=true");
					//eval("document.compLinkingForm.statusItem_"+compId_srlNo+".style.display='none'");
					//eval(document.getElementById("anchor_"+compId_srlNo+".innerText=''"));
					document.getElementById("anchor_"+compId_srlNo).innerText="";
				}
			}
		}
	</script>
</head>
<body onKeyDown="lockKey()">
<form name=compLinkingForm action="CASectionTemplateUpdateBean.jsp" method=post target=dummyFrame>
	<table width='100%' class='grid'>
	<tr>
		<td class='columnheadercenter'><fmt:message key="Common.ComponentID.label" bundle="${common_labels}"/></td>
		<td class='columnheadercenter'><fmt:message key="Common.ComponentPrompt.label" bundle="${common_labels}"/></td>
		<td class='columnheadercenter'><fmt:message key="Common.ComponentType.label" bundle="${common_labels}"/></td>
		<td class='columnheadercenter' colspan = 2><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
	</tr>
	<%
		try
		{
			String currentCompId = "";
			String currentCompPrompt = "";
			String currentCompType = "",currentCompTypeDesc="";
			int currentSrlNo = -1;
			String listItemId = "",defaultItemId="";
			String listItemText = "";							
			String currentCompIdSrlNo = "";
			//String sql1 = "";
			String defaultYN= "";
			String classValue = "";
			String disabled = "disabled",display="display:none";
			String checked = "";
			String selectE="",selectD="",selected="",anchorText="",statusWhenList="";
			Object status = null;
			Hashtable itemHash = null;
			Enumeration enum1 = null;
			String currentCompTypeLinked = "";//INC61905
			con = ConnectionManager.getConnection(request);

			//String sql = "select comp_id ,comp_prompt, comp_type, srl_no,decode(comp_type,'C','Yes/No','D','Date','T', 'Time','E','Date/Time','L','List Item','I','Integer Numeric','N', 'Decimal Numeric','F','Long Text','H','Short Text','B','Blank Line') comp_type_desc from CA_SECTION_DISCR_MSR_VW where sec_hdg_code=? and comp_id in ('"+selectedCompIds+"')" ;
			String sql = "select comp_id ,comp_prompt, comp_type, srl_no,decode(comp_type,'C','Yes/No','D','Date','T', 'Time','E','Date/Time','L','List Item','I','Integer Numeric','N', 'Decimal Numeric','F','Long Text','H','Short Text','B','Blank Line') comp_type_desc,nvl(STD_COMP_ID,'') STD_COMP_ID from CA_SECTION_DISCR_MSR_VW where sec_hdg_code=? and comp_id in ('"+selectedCompIds+"')" ;
			if(!selectedSrlno.equals(""))
            sql = sql + " and comp_id||srl_no in ("+selectedSrlno+")";
			
			sql = sql + " order by row_pos_no,column_pos_no";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sectionHdgCode);
					
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				rowNo++;
				/*if(rowNo%2!=0)
					classValue = "QRYODD";
				else
					classValue = "QRYEVEN";*/

					classValue = "gridData";

				currentCompId  = rs.getString(1);
				currentCompPrompt  = rs.getString(2);
				currentCompType  = rs.getString(3);
				currentSrlNo = rs.getInt(4);
				currentCompTypeDesc = rs.getString(5);
				currentCompTypeLinked = rs.getString("STD_COMP_ID")==null||rs.getString("STD_COMP_ID").equals("null")?"":rs.getString("STD_COMP_ID");//INC61905
				currentCompIdSrlNo = currentCompId+currentSrlNo;
				//checking whether bean value exists
				//out.println(currentCompIdSrlNo+"    "+compItemId);
				//out.println(templateBean.getStatus(currentCompIdSrlNo,compItemId));
				//*****
				//status also contains the items in the list in case of List Items are restricted
				
				if (!currentCompType.equals("L") )
				{
					status=templateBean.getStatus(currentCompIdSrlNo,compItemId);
				}

				
				//*****

				if(currentCompType.equals("L"))
				{
					statusWhenList = (String)templateBean.getStatusEDWhenList(currentCompIdSrlNo,compItemId);
					//out.println("<script>alert('"+statusWhenList+"')</script>");
					if(statusWhenList!=null)
					{
						disabled = "";
						//display="display";
						checked = "checked";
					}
					else
					{
						disabled = "disabled";
						//display="display:none";
						checked = "";
					}

				}
				else if(status!=null) //for all the other components Enable/Disable 
				{
					
					disabled = "";
					checked = "checked";
				}
				else
				{
					disabled = "disabled";
					checked = "";
				}
				
			%>
				<tr>
					<td class="<%=classValue%>"> <%=currentCompId%> </td>		
					<td class="<%=classValue%>"> <%=currentCompPrompt%> </td>
					<td class="<%=classValue%>"> <%=currentCompTypeDesc%> </td>
					<%
					//checking the status if comming from bean
					if(currentCompType.equals("L")){
						if(statusWhenList!=null && statusWhenList.equals("false")){
							selectE= "selected";
							anchorText = "Restrict";
						}
						else if(statusWhenList!=null && statusWhenList.equals("true")){
							selectD = "selected";
							//display="display:none";
							anchorText = "";
						}
					}else{
						if(status!=null && status.equals("false"))
							selectE= "selected";
						else if(status!=null && status.equals("true"))
							selectD = "selected";
					}
					//------------
					%>
					<td class="<%=classValue%>"><select name ="status_<%=currentCompIdSrlNo%>" <%=disabled%> onclick="if(this.value=='true' && '<%=currentCompType%>'=='L'){  /*document.compLinkingForm.statusItem_<%=currentCompIdSrlNo%>.style.display='none';*/ document.getElementById("anchor_")<%=currentCompIdSrlNo%>.innerText='';}else if(this.value=='false' && '<%=currentCompType%>'=='L'){  /*document.compLinkingForm.statusItem_<%=currentCompIdSrlNo%>.style.display='inline'; */document.getElementById("anchor_")<%=currentCompIdSrlNo%>.innerText='Restrict';}">
						<option value = "false" <%=selectE%>>&nbsp;&nbsp;<fmt:message key="Common.Enable.label" bundle="${common_labels}"/>&nbsp;&nbsp;</option>
						<option value = "true" <%=selectD%>>&nbsp;&nbsp;<fmt:message key="eCA.Disable.label" bundle="${ca_labels}"/>&nbsp;&nbsp;</option>
					</select>
					
					<%	selectE = "";
						selectD = "";
					%>
		
					<%if(currentCompType.equals("L")){%>
						&nbsp;<select name ="statusItem_<%=currentCompIdSrlNo%>" <%=disabled%> style="<%=display%>">
						<%
						//check if the bean value exist ie already something is defined or not 
						if(status!=null)
						{
							//anchorText = "Restrict";
							itemHash = new Hashtable((HashMap)status);
							defaultItemId = (String)itemHash.get("DEFAULT_CODE");
							enum1 = itemHash.keys();
							while(enum1.hasMoreElements())
							{
								listItemId = (String)enum1.nextElement();
								if(!listItemId.equals("DEFAULT_CODE"))
								{
									listItemText = (String)itemHash.get(listItemId);
									if(defaultItemId.equals(listItemId))
										selected = "selected";
								%>
								<option value="<%=listItemId%>" <%=selected%>><%=listItemText%></option>
								<%
								}
								selected = "";
							}
						}
						else
						{
							%>
							<option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
							<%
							try
							{
								listItemId = "";
								listItemText = "";
								defaultYN = "";
								sql = "Select RESULT_VALUE, REF_RNG_DESC,DFLT_YN from AM_DISCR_MSR_REF_RNG_LIST where DISCR_MSR_ID = ?  order by REF_RANGE_SEQ ";
								pstmt1 = con.prepareStatement(sql);
								pstmt1.setString(1,currentCompId);
								rs1=pstmt1.executeQuery();							
								while(rs1.next())
								{
									listItemId = rs1.getString(1);	
									listItemText = rs1.getString(2);
									defaultYN = rs1.getString(3);
									if(defaultYN.equals("Y"))
									{
									%>
									<option value="<%=listItemId%>" selected><%=listItemText%></option>
									<%
									}
									else
									{
									%>
									<option value="<%=listItemId%>"><%=listItemText%></option>
									<%
									}
									
								}

							}
							catch(Exception e)
							{
								//out.println("From list:"+e);//common-icn-0181
							       e.printStackTrace();//COMMON-ICN-0181
							}
						}%>
						</select>&nbsp;&nbsp;<a id="anchor_<%=currentCompIdSrlNo%>"  href="javascript:callOnRestrict('<%=currentCompIdSrlNo%>','<%=compItemId%>','<%=currentCompId%>','<%=currentCompType%>')" ><%=anchorText%></a>
					
					<%}%>
					</td>
					<td class="<%=classValue%>"><input type=checkbox value="Y" name="check<%=rowNo-1%>" id="check<%=rowNo-1%>" onclick="enableFields(this,'<%=currentCompIdSrlNo%>')" <%=checked%>><input type=hidden name="currentCompIdSrlNo<%=rowNo-1%>" id="currentCompIdSrlNo<%=rowNo-1%>" value="<%=currentCompIdSrlNo%>"><input type=hidden name="currentCompType<%=rowNo-1%>" id="currentCompType<%=rowNo-1%>" value="<%=currentCompType%>">
					<input type=hidden name="currentCompTypeLinked<%=rowNo-1%>" id="currentCompTypeLinked<%=rowNo-1%>" value="<%=currentCompTypeLinked%>"><!--INC61905-->
					</td>
				</tr>
			<%
						
				status = null;
				}
			itemHash = null;
			enum1 = null;
			status = null;
			statusWhenList = null;
		}
		catch(Exception e)
		{
			//out.println(e);//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
			if (rs!=null) rs.close();
			if (pstmt!=null) pstmt.close();
			if (rs1!=null) rs1.close();
			if (pstmt1!=null) pstmt1.close();
			if(con!=null) ConnectionManager.returnConnection(con,request);
			
		}
	%>
	</table>
	<input type=hidden name=count value="<%=rowNo%>">
	<input type=hidden name=compItemId value="<%=compItemId%>">
	<input type=hidden name=compIdSrlNo value="<%=(compId+srlNo)%>">
	<input type=hidden name=calledFrom value="ONCHANGE">
</form>
</body>

