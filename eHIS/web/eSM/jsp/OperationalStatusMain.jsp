<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
	<%
          String sStyle	=
          (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
        <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
        <script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		</head>


<script>
function showFacilities()
{
	parent.frames[2].location.href = "../../eSM/jsp/OperationalStatusGroup.jsp";
	parent.frames[3].location.href = "../../eCommon/html/blank.html";
	parent.frames[1].document.forms[0].byacentity.disabled = true;
	parent.frames[4].location.href='../../eCommon/jsp/error.jsp'

}

function showEntities()
{
	if(document.forms[0].entity_name.value != "")
	{
		parent.frames[2].location.href = "../../eSM/jsp/OperationalStatusEntity.jsp";
		parent.frames[3].location.href = "../../eCommon/html/blank.html";
		parent.frames[1].document.forms[0].byfacility.disabled = true;
		parent.frames[4].location.href='../../eCommon/jsp/error.jsp'

	}
	else
	{
		alert(getMessage("SET_ACCOUNTING_PARAMS",'SM'));
	}
}
</script>
<body onMouseDown="CodeArrest();" onLoad="FocusFirstElement()" onKeyDown = 'lockKey()'>
<form name="facility_oper_module_main" id="facility_oper_module_main">
<%
        request.setCharacterEncoding("UTF-8");
		Connection con = ConnectionManager.getConnection(request);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String entity_name = "";

		try
		{
			pstmt = con.prepareStatement("Select * from SM_ACC_ENTITY_PARAM ");
			rs = pstmt.executeQuery();

			if(rs != null)
			{
				while(rs.next())
				{
					entity_name= rs.getString("ACCOUNTING_NAME_SHORT");

					if(entity_name == null)	entity_name = "";
				}
			}
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			
		}
		catch(Exception e)
		{// out.println(e); 
			e.printStackTrace();
		}

		finally
		{
			
			if(con != null)
			ConnectionManager.returnConnection(con,request);
		}
%>
	<table border='0' cellpadding='0' cellspacing='0' width='99%' align='center'> 
		<tr>
			<td class="white"><input type="button" class="button" name="byfacility" id="byfacility" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ByFacility.label","common_labels")%>' onClick="showFacilities();">&nbsp;<input type="button" class="button" name="byacentity" id="byacentity" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.ByAccountEntity.label","sm_labels")%>' onClick="showEntities();"></td>
		</tr>
	</table>
<input type="hidden" name="entity_name" id="entity_name" value="<%=entity_name%>">
</form>
</body>
</html>

