<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<title>Drawing Tool</title>

<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<!-- <script language="JavaScript" src="../../eCommon/js/messages.js"></script> -->
		<script language="JavaScript" src="../../eOR/js/DrawingTool.js"></script>
 	</head>

	<!--onload="loadDrawingTool()"-->
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="loadDrawingTool()">
 	<%
		String bean_id1				= request.getParameter("bean_id");
		String bean_name1			= request.getParameter("bean_name");
		
		// This File is called from Order Entry, Result Entry and View order
		// When called from Order Entry --> called_from parameter will be "" (null)
		// When called from Result Entry --> called_from parameter will be "RESULT"  
		// When called from View (Fully Resulted)--> called_from parameter will be "RESULT_VIEW"  
		// When called from View Order --> called_from parameter will be "VIEW" 
		String called_from			= request.getParameter("called_from");
		if(called_from==null) called_from="";
		String encounter_id			= request.getParameter("encounter_id");
		String patient_id			= request.getParameter("patient_id");
		/* Initialize Function specific start */
		if(called_from.equals("")) {
			//OrderEntryBean bean		= (OrderEntryBean)mh.getBeanObject( bean_id1, request,  bean_name1 );
			OrderEntryBean bean			= (OrderEntryBean)getBeanObject( bean_id1, bean_name1, request ) ;

			patient_id				= bean.getPatientId();
			encounter_id			= bean.getEncounterId();

			// no need to set it
			//putObjectInBean(bean_id1,bean,request);
		} else if(called_from.equals("VIEW") || called_from.equals("RESULT_VIEW") ) {
 			//ExistingOrder bean1		= (ExistingOrder)mh.getBeanObject( bean_id1, request,  bean_name1 );
			ExistingOrder bean1			= (ExistingOrder)getBeanObject( bean_id1, bean_name1, request ) ;

			patient_id				= bean1.getPatientId();
			encounter_id			= bean1.getEncntrId();
			
			// no need to set it	
			//putObjectInBean(bean_id1,bean1,request);
		}
		// From View or Result or Result View, this parameter will be passed
 		String order_id				= request.getParameter("order_id");
		// Till here
  		String bean_id				= "@OrderEntryDrawingToolBean"+patient_id+encounter_id;
		String bean_name			= "eOR.OrderEntryDrawingToolBean";
		//OrderEntryDrawingToolBean beanObj = (OrderEntryDrawingToolBean)mh.getBeanObject( bean_id, request,  bean_name );
		OrderEntryDrawingToolBean beanObj = (OrderEntryDrawingToolBean)getBeanObject( bean_id, bean_name , request) ;
		// clear the bean
		beanObj.clear();
		  
		// From Order Entry, this parameters will be passed
		String catalog_code			= request.getParameter("catalog_code") ;
		String image_id				= request.getParameter("image_id") ;
		// Till here
  		//String image_ref_desc		=	"";
		//String default_yn			=	"";
		String default_image_url	=	"";
		ArrayList DrawingTools		= null;
		String record[]				= null;
		StringBuffer result_data	= new StringBuffer();

		if(called_from.equals("VIEW"))		//Only for view,
		{	
			result_data = beanObj.getImageClob(order_id);
		} else if(called_from.equals("RESULT") || called_from.equals("RESULT_VIEW") )
		{
			result_data = beanObj.getResultImageClob(order_id);
		}
%>	
<html>
<head>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/DrawingTool.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 
</head>
 
 
<body class="message"  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<FORM name="editor" id="editor" METHOD="POST">  <!--ACTION="../servlet/SessJpgReader"-->
<INPUT TYPE="hidden" name="image" id="image" value="">
<table border="0" width="100%">
<% if(! (called_from.equals("VIEW") || called_from.equals("RESULT_VIEW")) ) { %>
<tr>
	<td >
		<table border="0" width="100%">
		<tr>
			<td width="4%"><applet code="Standard.class" codebase="../../eCA/MediPainter/" archive="medipainterapplet.jar" width="48" height="20" align="top" > </applet>
			</td>
			<td width="66%"><applet code="Formatting.class" codebase="../../eCA/MediPainter/" archive="medipainterapplet.jar" width="295" height="20" align="top" > </applet>
			</td>
<%	if(!called_from.equals("RESULT")) { %>
			<td class="label"><input type="button" class="button" name="zoom" id="zoom" value="ZOOM" onClick="zoomWindow()"></td>
			<td width = "30%" align = "right" class="Label">
				Available Images:
				<select name="image_ref" id="image_ref" onChange="changeImage(this)">

<%				DrawingTools	 =  beanObj.getImageRef(catalog_code, image_id);
 			    for(int i=0; i<DrawingTools.size(); i++)
			    {
					record	= (String[])DrawingTools.get(i);
 					out.println("<option value = '"+record[0]+"' > "+record[1]+" </option>");
					default_image_url = record[0];
					if(default_image_url==null) default_image_url="";
			    }
%>
				</select>
			</td>
<% } %>
		</tr>
		</table>
	</td>
</tr>
<tr>
	<td >
		<table border="0" width="100%">
		<tr>
			<td width="35%" align="centre">
				<!-- Tool Panel -->	
				<applet code="ToolBox.class" codebase="../../eCA/MediPainter/" archive="medipainterapplet.jar" width="275" height="20"> </applet>
			</td>
			<td width="65%" align="left">
				<!-- Pen Panel -->
				<applet code="Pens.class" codebase="../../eCA/MediPainter/" archive="medipainterapplet.jar" width="160" height="20" > </applet>
			</td>
		</tr>
		</table>
	</td>
</tr>
<% } %>
<tr>
	<td>
		<table border="0" cellpadding="1" width = "100%">
	    <tr>
<% if(! (called_from.equals("VIEW") || called_from.equals("RESULT_VIEW")) ) { %>
			<td valign="top">
				<!-- Color Pallet -->
				<applet code="Pallet.class" codebase="../../eCA/MediPainter/" archive="medipainterapplet.jar" width="75" height="200" > </applet>
			</td>
<% } %>
			<td bgcolor="#000000">
				<applet name="drawing" code="Drawing.class" codebase="../../eCA/MediPainter/"
					archive="medipainterapplet.jar" width="660" height="360" align="baseline" >
					<param name="loadImage" value="<%=(default_image_url.equals("")?"":"../../eCA/MediPainter/images/"+default_image_url)%>">	
					<param name="canDraw" value="<%=((called_from.equals("") || called_from.equals("RESULT"))?"1":"0")%>">	
				</applet>
			</td>
		</tr>
		</table>
	</td>
</tr>
</table>
<textarea name="load_values" style="visibility:hidden"><%=result_data.toString()%></textarea>
<input type="hidden" name="zoom_yn" id="zoom_yn" value="Y"> <!-- By Default --> 
<%
	//Nullifying the objects
	DrawingTools	= null;			record = null;
	result_data.setLength(0);		

	putObjectInBean(bean_id,beanObj,request);

%>
</FORM>
 
</body>
</html>

