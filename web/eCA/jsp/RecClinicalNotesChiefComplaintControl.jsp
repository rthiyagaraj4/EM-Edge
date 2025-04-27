<!DOCTYPE html>
<%@page import="java.sql.*,java.util.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<% request.setCharacterEncoding("UTF-8"); %>
<%
	webbeans.eCA.RecClinicalNotesSectionBean sectionBean = (webbeans.eCA.RecClinicalNotesSectionBean)getObjectFromBean("sectionBean","webbeans.eCA.RecClinicalNotesSectionBean",session);
%>
<html>
<head>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
</head>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='CONTENT'>
<script>
	var text_blk_id = "", text_blk = "", block_id = "";

	var returnArray		= new Array();
	var arrTextBlockID	= new Array();
	var arrTextBlock	= new Array();

	/*if(parent.RecClinicalNotesCCSelectFrame.document.forms[0].select!=null)
	{
		var clipBoardVal=parent.RecClinicalNotesCCSelectFrame.document.forms[0].select.createTextRange();
		clipBoardVal.select();
		clipBoardVal.execCommand("copy","","");
	}*/
	if(parent.RecClinicalNotesCCSelectFrame.document.forms[0].select!=null)
	{
		var range = document.createRange(parent.RecClinicalNotesCCSelectFrame.document.forms[0].select);
	    //range.selectNode(obj);;
	    const clipBoardVal = range.extractContents();
		document.execCommand("copy");
	}
	
	var selectIndex = 0;
<%
	String totalBlocks			= request.getParameter("totalBlocks")==null?"0":request.getParameter("totalBlocks");
	String sec_hdg_code			= (request.getParameter("sec_hdg_code")==null) ?""	:request.getParameter("sec_hdg_code");
	String child_sec_hdg_code	= (request.getParameter("child_sec_hdg_code")==null) ?""	:request.getParameter("child_sec_hdg_code");	 
	String patient_id	= (request.getParameter("patient_id")==null) ?""	:request.getParameter("patient_id");	 
	String encounter_id	= (request.getParameter("encounter_id")==null) ?""	:request.getParameter("encounter_id");	 

	String strKey	= patient_id + "~"+encounter_id;
	strKey = strKey.trim();

	sectionBean.getPatientSection(strKey);

	int total = Integer.parseInt(totalBlocks);
	
	boolean flag=false;
	boolean selectFlag = true;
	
	HashSet preSet = (HashSet) sectionBean.getSectionChiefComplaint(sec_hdg_code,child_sec_hdg_code);
	
	if(preSet != null )
		flag=true;
	else
	{
		flag = true;
		preSet = new HashSet(); 
	}

	//-------------------
	String blockId = "";
	String textBlockId = "";

	for(int i=0; i<total; i++)
	{
		blockId		=	request.getParameter("block_id"+i)==null?"":request.getParameter("block_id"+i);
		textBlockId	=	request.getParameter("text_blk_id"+i)==null?"":request.getParameter("text_blk_id"+i);	
		
		if(blockId.equals("Y"))
		{
			if(flag && preSet.contains(textBlockId))
				selectFlag = true; //'selectFlag' is changed to 'true' instead of 'false' by Archana Dhal on 7/26/2010 related to IN022802.
			else if(flag && !preSet.contains(textBlockId))
				preSet.add(textBlockId);
			
			if(selectFlag)
			{
				%>
				text_block_id	=	eval("parent.RecClinicalNotesCCFrame.document.forms[0].text_blk_id<%=i%>").value;
				text_block		=	parent.RecClinicalNotesCCFrame.document.getElementById('text_blk<%=i%>').innerText;
				arrTextBlockID[selectIndex]	=	text_block_id; 
				arrTextBlock[selectIndex]	=	text_block; 
				selectIndex++;
				<%
			}
			
			selectFlag = true;
		}
		else
		{
			if(flag && preSet.contains(textBlockId))
				preSet.remove(textBlockId);
		}
	}
	
	if(flag)
	{
		sectionBean.setSectionChiefComplaint(sec_hdg_code,child_sec_hdg_code,preSet);
		putObjectInBean("sectionBean",sectionBean,session);
	}

%>
	returnArray[0] = arrTextBlockID;
	returnArray[1] = arrTextBlock;

	parent.window.returnValue = returnArray;
	parent.window.close();
</script>

