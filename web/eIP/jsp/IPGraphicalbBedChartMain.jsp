<!DOCTYPE html>
<!DOCTYPE>
<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*, java.lang.*,java.text.*,java.util.*,webbeans.eCommon.*" %>
	<%  
		//String nursingUnit=request.getParameter("nursingUnit")==null?"":request.getParameter("nursingUnit");
		//Below code was Added by N Munisekhar on 08-JAN-2013 against [IN037130]
		String function_id=request.getParameter("function_id");
        if(function_id == null) function_id = "";
	%>
<html>
	<head>
		<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
		<script src="../js/json2.js" language="JavaScript"></script>
		<!-- <script src="../../eIP/js/IPAdvBedMgmtTrns.js" language="JavaScript"></script> -->
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
		<!--<iframe name='commontoolbarFrame' id='commontoolbarFrame'    src='../../eCommon/jsp/commonToolbar.jsp' frameborder=0 scrolling='no' noresize style='height:0vh;width:0vw'></iframe> --> 
			<iframe name='TitleFrame' id='TitleFrame' src='IPAdvBedMgmtTitle.jsp' noresize  frameborder=no marginheight=0 marginwidth=0 SCROLLING='no' noresize style='height:3vh;width:100vw'></iframe>
			<iframe name='topcrumb' id='topcrumb' src='IPAdvBedMgmtTopCrumb.jsp' noresize  frameborder=no marginheight=0 marginwidth=0 SCROLLING='no' noresize style='height:6vh;width:100vw'></iframe>
			<iframe name='serachFrame' id='serachFrame' 		src='../../eIP/jsp/IPAdvBedMgmtCriteria.jsp?called_from=bed_mgmt_trns&function_id=<%=function_id%>' frameborder=0 scrolling='auto' style='height:4vh;width:100vw'></iframe>
			<!-- <iframe name='legendFrame' id='legendFrame' src='../jsp/IPAdvBedMgmtColorSchema.jsp' frameborder=0 noresize scrolling='auto'> -->
			<iframe name='legendFrame' id='legendFrame' src='../jsp/IPAdvBedMgmtLegendPanel.jsp' frameborder=0 noresize scrolling='auto' style='height:7vh;width:100vw'></iframe>
			<iframe name='adv_bed_mgmt' id='adv_bed_mgmt' 		src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' style='height:70vh;width:100vw'></iframe>
			<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' noresize  frameborder=0  marginheight=0 marginwidth=0 SCROLLING='auto' noresize style='height:5vh;width:100vw'></iframe>
		
</html>

