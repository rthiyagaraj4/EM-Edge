<!DOCTYPE html>
<%@page contentType="text/html;" import="java.util.*,java.text.SimpleDateFormat, java.sql.*, webbeans.eCommon.*" %>



<html>
<head>

<link rel="stylesheet" type ="text/css" href="../../eAE/html/fonts-min.css"></link>
	<link rel="stylesheet" type ="text/css" href="../../eAE/html/button.css"></link>
	<link rel="stylesheet" type ="text/css" href="../../eAE/html/stdbutton.css"></link>
	<link rel="stylesheet" type ="text/css" href="../../eAE/html/menu.css"></link>
	<link rel="stylesheet" type ="text/css" href="../../eAE/html/datatable.css"></link>
	<link rel="stylesheet" type ="text/css" href="<%=request.getContextPath()%>/eAE/html/AmbulanceManagementSystem.css"></link>
	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<link rel="stylesheet" type ="text/css" href='../../eAE/html/autocomplete.css'></link>
 	<link rel="stylesheet" type ="text/css" href='../../eAE/html/container.css'></link>
	<link rel="stylesheet" type ="text/css" href='../../eAE/html/container-skin.css'></link> 
	<link rel="stylesheet" type ="text/css" href='../../eAE/html/skin.css'></link> 
	<link rel="stylesheet" type="text/css" href="../../eAE/html/keyboard.css"> </link> 
	<link rel="stylesheet" type="text/css" href="../../eAE/html/paginator.css"> </link> 
    <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script type="text/javascript" src="../../eAE/js/keyboard.js" charset="UTF-8"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>	
	<Script language="JavaScript" src="../../eCommon/js/CommonLookup.js" ></Script>
	<Script language="JavaScript" src="../../eCommon/js/common.js" ></Script>
	<Script language="JavaScript" src="../../eCommon/js/dchk.js" ></Script>
	<Script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js" ></Script>
	
	<script src='../../eAE/js/yahoo-dom-event.js' language='javascript'></script>
	<script src='../../eAE/js/connection-min.js' language='javascript'></script>
	<script src='../../eAE/js/element-min.js' language='javascript'></script>	
	<script src='../../eAE/js/container-min.js' language='javascript'></script>
    <script src='../../eAE/js/menu-min.js' language='javascript'></script>
	<script src='../../eAE/js/dragdrop-min.js' language='javascript'></script>
	<script src='../../eAE/js/datasource-min.js' language='javascript'></script> 
	<script src='../../eAE/js/datatable-min.js' language='javascript'></script>  
  	<script src='../../eAE/js/animation-min.js' language='javascript'></script>	
	<script src='../../eAE/js/autocomplete-min.js' language='javascript'></script>
	<script src='../../eAE/js/button-min.js' language='javascript'></script>	
	<script src='../../eAE/js/paginator-min.js' language='javascript'></script>	
	<script src='../../eAE/js/json-min.js' language='javascript'></script>	
	<script src='../../eAE/js/event-min.js' language='javascript'></script>	
	<script src='../../eAE/js/yahoo-min.js' language='javascript'></script>	
	<script src='../../eAE/js/get-min.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
	

	
 <style>
	.yui-simple-dialog .bd span.warnicon {
    background: url("../../eAE/images/warn16_1.gif") no-repeat;
	}
 </style>


 


</head>
<body  class="yui-skin-sam" OnMouseDown='CodeArrest()' onkeydown="lockKey()">
<div id="alert"></div>
</body>
</html>
<%
	PreparedStatement pstmt 	= null;
	Connection con				= null;
	ResultSet rs                = null;

	String facility_id				=	(String)session.getValue("facility_id");
	String from_date				=	"";
	String to_date					=	"";
	boolean flag					=	false;
	String	msg						=  "APP-AE5001 AMS Parameter not defined";
	
	String query="Select to_char((sysdate- nvl(AMB_DFLT_DYS_BEHIND,0)),'DD/MM/YYYY')  DYS_BEHIND ,to_char((sysdate+ nvl(AMB_DFLT_DYS_AHEAD,0)),'DD/MM/YYYY')  DYS_AHEAD    from AE_AMB_PARAM_FOR_FACILITY where facility_id = ? ";


	try{
        con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(query); 
		pstmt.setString(1,facility_id);
		rs=pstmt.executeQuery();
		if(rs.next()){

			from_date=rs.getString(1);
			to_date=rs.getString(2);
			flag=true;
			
		}
   }catch(Exception e){
		e.printStackTrace();
		throw e;
	}

	finally {
		try{
			if(rs!=null) rs.close();
			if( pstmt!=null ) pstmt.close(); 
			if( con!=null )
				ConnectionManager.returnConnection(con, request);
			rs=null;
			pstmt=null;
			con=null;
		}catch(Exception e){
			e.printStackTrace();			
		}
	}

    if(flag){
	
	%>
		<jsp:forward page="AmbulanceManagementSystem.jsp">
			<jsp:param name="from_date" value="<%=from_date%>"/>
			<jsp:param name="to_date" value="<%=to_date%>"/>
		</jsp:forward>
   <%}else{
   
	out.println("<script> var panel = new YAHOO.widget.SimpleDialog('alert',{fixedcenter: true, visible: true,modal: true,width: '400px',constraintoviewport: true, icon: YAHOO.widget.SimpleDialog.ICON_WARN,buttons: [{ text: 'OK', handler: function() {panel.hide();document.location.href='../../eCommon/jsp/CommonClearObjects.jsp';}, isDefault: true }]});panel.setHeader('Alert');panel.setBody('"+msg+"');panel.render('alert');</script>");
		//out.println("<script> var panel = new YAHOO.widget.SimpleDialog('alert',{fixedcenter: true, visible: true,modal: true,width: '400px',constraintoviewport: true, icon: YAHOO.widget.SimpleDialog.ICON_WARN,buttons: [{ text: 'OK', handler: function() {document.location.href='../../eCommon/jsp/CommonClearObjects.jsp';}, isDefault: true }]});panel.setHeader('Alert');panel.setBody('"+msg+"');panel.render('alert');</script>");
	}
	
%>

