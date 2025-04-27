<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
        
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script language="javascript" src="../js/SectionTemplate.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
		//on click of the component ID in the Formula construction screen
		var a = new Array(); // refered in next frame
		var i=0; // refered in next frame
		var ii=1; // referred in next frame
		var value,element;
		function loadForNextFrame(){  //this is function is refered for the next frame 
			if(i==0){
				formulaVal = parent.window.dialogArguments;
				if (formulaVal != null && formulaVal != "" && formulaVal != "undefined")
				{
					var spl=formulaVal.split('~');
					for(j=1;j<spl.length;j++){
						 element=spl[j-1];
						 value=j+"|"+element;
						 a[j]=value;
						 i=i+1;
					} 
				}
		    }
		}

		function onClickOfComp(comp_id)
		{
			comp_id = "$$$"+comp_id+"###";
			//parent.templateFormulaConstructionFrame.document.forms[0].formulaDefinition.insertAdjacentText("BeforeEnd",comp_id);
			parent.templateFormulaConstructionFrame.newTextVal(comp_id);
		}
		
		</script>
 	</head>
<body class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()" onload='loadForNextFrame()'>
<form name=formulaComponentListForm>
<table width='100%' class='grid'>
<tr>
	<td class='columnheader'><fmt:message key="Common.ComponentID.label" bundle="${common_labels}"/></td>
	<td class='columnheader'><fmt:message key="Common.ComponentType.label" bundle="${common_labels}"/></td>
	<td class='columnheader'><fmt:message key="Common.ComponentPrompt.label" bundle="${common_labels}"/></td>
</tr>
<%
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sectionHdgCode=request.getParameter("sec_hdg_code")==null?"":request.getParameter("sec_hdg_code");
	try 
	{

		con=ConnectionManager.getConnection(request);
		String sql = "SELECT COMP_ID,decode(COMP_TYPE,'I','Integer Numeric','N','Decimal Numeric','L','List Component') COMP_TYPE,COMP_PROMPT,SRL_NO FROM CA_SECTION_DISCR_MSR_VW WHERE SEC_HDG_CODE=? AND (COMP_TYPE IN ('I','N') OR (ASSOCIATE_SCORE_YN='Y' AND COMP_TYPE='L' AND LINK_TO_STD_VALUE_YN = 'N'))";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,sectionHdgCode);
		rs=pstmt.executeQuery();
		while(rs.next())
		{
			String compId = rs.getString("COMP_ID")==null?"":rs.getString("COMP_ID");
			String compType = rs.getString("COMP_TYPE")==null?"":rs.getString("COMP_TYPE");
			String compPrompt = rs.getString("COMP_PROMPT")==null?"":rs.getString("COMP_PROMPT");
			String srlNo = rs.getString("SRL_NO")==null?"":rs.getString("SRL_NO");
			String compIDSrlNo=compId+"!"+srlNo;
 			%>
				<tr>
					<td class='gridData'><a class='gridLink' href='javascript:onClickOfComp("<%=compIDSrlNo%>")'><%=compId%></a></td>
					<td class='gridData'><%=compType%></td>
					<td class='gridData'><%=compPrompt%></td>
				</tr>
			<%		
		}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	}
	catch(Exception e)
	{
		//out.println(e);//COMMON-ICN-0181
                e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		
		if(con!=null)	ConnectionManager.returnConnection(con,request);
	}
%>
</table>
</form>
</body>
</html>
<script>
setTimeout("dummy()",300);
</script>
<script>
function dummy()
{
	parent.templateFormulaConstructionFrame.location.href='../../eCA/jsp/CASectionTemplateFormulaConstruction.jsp';
}
</script>

