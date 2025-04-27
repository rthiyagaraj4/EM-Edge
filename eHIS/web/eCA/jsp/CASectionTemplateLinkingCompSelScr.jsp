<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
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
	String compType=request.getParameter("comp_type")==null?"":request.getParameter("comp_type");
	String compPrompt=request.getParameter("comp_prompt")==null?"":request.getParameter("comp_prompt");
	String sectionHdgCode= request.getParameter("section_hdg_code")==null?"":request.getParameter("section_hdg_code");	
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs = null;
	int rowNo=0;
	int countList=0,countOther=0;
	//get the dependent component from the bean for this component 
	Vector dependentComp  = templateBean.getAssociatedComponents(compId+srlNo);
%>
<html>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
	<%
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
    
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script>
		var maxNoListComponent = 25;
		var maxNoOtherComponent = 50;
		var countList=0;
		var countOther=0;
		function loadValues()
		{
			countList=eval(document.forms[0].countList.value);
			countOther=eval(document.forms[0].countOther.value);			
		}
		function checkDependency(obj,index)
		{
			if(obj.checked)
			{
				if((countOther+countList)==maxNoOtherComponent)
				{
					var msg =alert(getMessage("CANNOT_ASSIGN_ALL_COL","CA"));
					msg = msg.replace('$$',maxNoOtherComponent);
					alert(msg);
					//alert("Can't assign More than "+maxNoOtherComponent+" Components");
					obj.checked = false;
					return;
				}
				if(eval("document.forms[0].compType"+index+".value")=="L")
				{
					if(countList==maxNoListComponent)
					{   
						var msg =alert(getMessage("CANNOT_ASSIGN_ALL_LIST","CA")); 
						msg = msg.replace('$$',maxNoListComponent);
						alert(msg);

						//alert("Can't assign More than "+maxNoListComponent+" List Components");
						obj.checked = false;
						return;
					}
					countList++;
				}
				else
				{
					countOther++;
				}
				//**********************************************************/
				//code for checkng the already assiged dependency
				if(eval("document.forms[0].existing"+index+".value")!="Y")
				{
					var selectedCompIdSrlNo = eval("document.forms[0].selectedCompIdSrlNo"+index+".value");
					parent.dummyFrame.location.href= "CASectionTemplateLinkingCompSelScrCheckDependency.jsp?selectedCompIdSrlNo=C_"+selectedCompIdSrlNo+"&index="+index;
					
				}
				//********************************************************/
			}
			else
			{
				obj.value = "N";
				if(eval("document.forms[0].compType"+index+".value")=="L")
				{
					countList--;
				}
				else
				{
					countOther--;
				}
				eval("document.forms[0].existing"+index+".value='Y'");
			}
		}
	</script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
</head>
<body onload="loadValues()" onKeyDown="lockKey()">
<form name=compSelectionForm action="CASectionTemplateLinkingMain.jsp" method=post >
	<table width='100%' class='grid' >
	<tr>
		<td class='columnheadercenter' ><fmt:message key="Common.Component.label" bundle="${common_labels}"/></td>
		<td class='columnheadercenter' ><fmt:message key="Common.ComponentType.label" bundle="${common_labels}"/></td>
		<td class='columnheadercenter' >&nbsp;</td>
	</tr>
	<%
		try
		{
			String currentCompId = "";
			String currentCompPrompt = "";
			String currentCompType = "";
			String currentCompTypeDesc = "";
			String classValue = "";
			String currentCompIdSrlNo = "";
			int currentSrlNo = -1;
			String checked = "";
			con = ConnectionManager.getConnection(request);
			String sql = "select comp_id ,comp_prompt,decode(comp_type,'C','Yes/No','D','Date','T', 'Time','E','Date/Time','L','List Item','I','Integer Numeric','N', 'Decimal Numeric','F','Long Text','H','Short Text','B','Blank Line') comp_desc,comp_type, srl_no from CA_SECTION_DISCR_MSR_VW where sec_hdg_code=? and comp_id != ? and comp_type not in ('A','P','R','X','M') and accept_option in ('O','D') and nvl(LIST_PRESENTATION,'S')!='M' order by row_pos_no,column_pos_no";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sectionHdgCode);
			pstmt.setString(2, compId);
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
				currentCompTypeDesc  = rs.getString(3);
				currentCompType = rs.getString(4);
				currentSrlNo = rs.getInt(5);
				currentCompIdSrlNo = currentCompId+currentSrlNo;
				//verify the values in the bean with the values comming from the table for selection
				if(dependentComp!=null)
				{
					if(dependentComp.contains(currentCompIdSrlNo))
					{
						checked = "checked";
						//for getting the count o how many r already linked
						if(currentCompType.equals("L"))
							countList++;
						else
							countOther++;
					}
				}
							%>
				<tr>
					<td class="<%=classValue%>"> <%=currentCompPrompt%> </td>
					<td class="<%=classValue%>"> <%=currentCompTypeDesc%><input type=hidden name="compType<%=rowNo-1%>" id="compType<%=rowNo-1%>" value="<%=currentCompType%>"></td>
					<td class="<%=classValue%>"><input type=checkbox value="Y" name="check<%=rowNo-1%>" id="check<%=rowNo-1%>" onclick="checkDependency(this,<%=rowNo-1%>)" <%=checked%>><input type=hidden name="selectedCompIdSrlNo<%=rowNo-1%>" id="selectedCompIdSrlNo<%=rowNo-1%>" value="<%=currentCompIdSrlNo%>"><input type=hidden name="selectedCompId<%=rowNo-1%>" id="selectedCompId<%=rowNo-1%>" value="<%=currentCompId%>"><input type=hidden name="existing<%=rowNo-1%>" id="existing<%=rowNo-1%>" value=""></td>
				</tr>
			<%
				checked = "";
			 }
			
		}
		catch(Exception e)
		{
		//	out.println(e);//COMMON-ICN-0181
                        e.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
			if (rs!=null) rs.close();
			if (pstmt!=null) pstmt.close();
			if(con!=null) ConnectionManager.returnConnection(con,request);
			
		}
	%>
	</table>
	<input type=hidden name=count value="<%=rowNo%>">
	<input type=hidden name=comp_id value="<%=compId%>">
	<input type=hidden name=comp_type value="<%=compType%>">
	<input type=hidden name=section_hdg_code value="<%=sectionHdgCode%>">
	<input type=hidden name=comp_prompt value="<%=compPrompt%>">
	<input type=hidden name=srl_no value="<%=srlNo%>">
	<input type=hidden name=countList value="<%=countList%>">
	<input type=hidden name=countOther value="<%=countOther%>">
</form>
</body>

