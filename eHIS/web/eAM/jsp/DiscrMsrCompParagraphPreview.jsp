<%@ page contentType="application/xml;charset=UTF-8" import="java.sql.*,webbeans.eCommon.*"  %>
<?xml-stylesheet type="text/xsl" href="../../eCA/html/RecClinicalNotesTemplateRecordingView.xsl"?>
<DOCUMENT FORM-NAME="RecClinicalNotesTemplateForm" >
<%String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<CSS sStyle="<%=sStyle%>"/>
<SCRIPT LANGUAGE='javascript' SRC='../../eCommon/js/common.js'></SCRIPT>
<SCRIPT LANGUAGE='javascript' SRC='../../eCommon/js/ValidateControl.js'></SCRIPT>
<SCRIPT LANGUAGE='javascript' SRC='../../eCommon/js/dchk.js'></SCRIPT>
<SCRIPT LANGUAGE='javascript' SRC='../../eCA/js/RecClinicalNotesPart1.js'></SCRIPT>
<SCRIPT LANGUAGE='javascript' SRC='../../eCA/js/RecClinicalNotesPart2.js'></SCRIPT>
<SCRIPT type='text/javascript' SRC='../../eCommon/js/CommonCalendar.js'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<STYLE type="text/css">
	.READONLY
	{
		BACKGROUND-COLOR: #C0C0C0;
	}
</STYLE>

<%
request.setCharacterEncoding("UTF-8");
	Connection con=null;
	String detail=request.getParameter("paragraphDef");
	String calledFrom=request.getParameter("calledFrom");
	String comp_id=request.getParameter("comp_id");
	eAM.DiscrMsrCompParagraphComponentBean beanObject=null;
	try
	{
		con=ConnectionManager.getConnection(request);	
		beanObject=new eAM.DiscrMsrCompParagraphComponentBean();
		
		detail	=	beanObject.changeDefinitionToXML(con,detail,comp_id);		
		
	}
	catch(Exception e)
	{
		e.printStackTrace(System.err);
		out.println(e);
	}
	finally
	{
		if(con!=null)	ConnectionManager.returnConnection(con,request);
		if(beanObject!=null)   beanObject=null;
	}
%>

<USER-TEMPLATE><ROW><COL>
<%=detail%>
</COL></ROW></USER-TEMPLATE>
<%if(calledFrom!=null && calledFrom.equals("SAVE")){
	if(detail.indexOf("Component Tempered")!=-1){%>
		<SCRIPT>
				alert("APP-00099 Component Tempered- Definition cannot be saved");
				top.opener.window.document.TemplateComponent_form.paragraphDef.value="";
		</SCRIPT>
	<%}else{%>
		<SCRIPT>parent.window.close();</SCRIPT>
	<%}
}%>
</DOCUMENT>




