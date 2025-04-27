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
	int count = Integer.parseInt(request.getParameter("count"));
	String selectedCompIdSrlNo= "";
	String selectedCompIdSrlNoCat= "";
	String selectedCompIds="";
//	String strEliminatedCompIds = "";
//	String strEliCompType = "";

	StringBuffer sbEliminatedCompIds = new StringBuffer();
	StringBuffer sbEliCompType		 = new StringBuffer();

	Vector dependentComponent = new Vector();	
	String comma = "','";

	for(int i=0;i<count;i++)
	{
		if(request.getParameter("check"+i)!=null && request.getParameter("check"+i).equals("Y") )
		{
			selectedCompIdSrlNo = request.getParameter("selectedCompIdSrlNo"+i);
			selectedCompIdSrlNoCat = selectedCompIdSrlNoCat+request.getParameter("selectedCompIdSrlNo"+i)+comma;
			selectedCompIds = selectedCompIds + request.getParameter("selectedCompId"+i)+comma;
			dependentComponent.add(selectedCompIdSrlNo);
		}

		if (request.getParameter("existing"+i).equals("Y"))
		{
			sbEliminatedCompIds.append(request.getParameter("selectedCompIdSrlNo"+i)+",");
			sbEliCompType.append(request.getParameter("compType"+i)+ ",");
//			strEliminatedCompIds +=request.getParameter("selectedCompIdSrlNo"+i)+ ",";
//			strEliCompType += request.getParameter("compType"+i)+ ",";
		}
	}

	templateBean.setAssociatedComponents((compId+srlNo),dependentComponent);

	dependentComponent = null;
	if(!selectedCompIds.equals(""))
		selectedCompIds = selectedCompIds.substring(0,selectedCompIds.length()-3);
	//-----------------------------------------------------
	String qs = "comp_id="+compId+"&srl_no="+srlNo+"&comp_type="+compType+"&comp_prompt="+compPrompt+"&section_hdg_code="+sectionHdgCode+"&selectedCompIds="+java.net.URLEncoder.encode(selectedCompIds);

	putObjectInBean("templateBean",templateBean,session);

%>	
<head>
	<title><fmt:message key="eCA.AssociateLinking.label" bundle="${ca_labels}"/></title>
	<script>
	function callOnLoad()
	{
		window.dialogWidth= "40";
		window.dialogHeight = "30";
		window.dialogTop = "150";
	}
	</script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
</head>
<iframe name='templateLinkingHeaderFrame' id='templateLinkingHeaderFrame' src='../../eCA/jsp/CASectionTemplateLinkingHeader.jsp?<%=qs%>' frameborder="no" scrolling="no" noresize style='height:7vh;width:98vw'></iframe>
	<iframe name='templateLinkingDetailFrame' id='templateLinkingDetailFrame' src='../../eCA/jsp/CASectionTemplateLinkingDetail.jsp?<%=qs%>' frameborder=0 scrolling=yes noresize style='height:75vh;width:98vw'></iframe>
	<iframe name='templateLinkingToolbarFrame' id='templateLinkingToolbarFrame' src='../../eCA/jsp/CASectionTemplateLinkingToolbar.jsp?<%=qs%>' frameborder="no" scrolling="no" noresize style='height:5vh;width:98vw'></iframe>
	<iframe name='dummyFrame' id='dummyFrame' frameborder="no"   style='height:0vh;width:98vw'></iframe>


