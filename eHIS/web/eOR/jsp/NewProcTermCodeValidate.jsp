<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<html>

<%@page import="java.sql.*, java.io.*,java.util.*,java.text.*, webbeans.eCommon.ConnectionManager"%>
<jsp:useBean id="TerminologyLookup" scope="session" class="webbeans.eCommon.RecordSet" />

<head>
<link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link>
	<Script language ="JavaScript" src ='../../eCommon/js/common.js'></Script>
	<Script language ="JavaScript" src ='../../eCommon/js/ValidateControl.js'></Script>
	<script language="JavaScript" src="../../eOR/js/NewProcedureTermCode.js"></script>
<SCRIPT LANGUAGE="JavaScript">
<!--


//-->
</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body OnMouseDown="CodeArrest()"  onKeyDown="lockKey()">
<form name="" id=""  method ='post' action=''>
<%


String textName				= (String)request.getParameter("textName") == null ? "" : request.getParameter("textName");
System.out.println("==========================textName====="+textName+"====");
//out.println("<script>alert('in textName:--"+textName+"--')</script>");

try
{ 
	//eCP.GCPGeneratePlanBean bean	= (eCP.GCPGeneratePlanBean)session.getAttribute("GCPGenerateBean");	
	//out.println("<script>alert('in the get bean:::"+bean+"')</script>");	
	//bean.clearBean();
	ArrayList Terminology = null;
	HashMap Termcode= null;
	if(TerminologyLookup.getSize()>0){
		
		Terminology = (ArrayList)TerminologyLookup.getObject(0);
		Termcode = (HashMap)Terminology.get(0);
		if(textName.equals("clear_values")){
			String clearValues = (String)request.getParameter("clear_values")==null?"":(String)request.getParameter("clear_values");
			//System.out.println("==============clear_values====="+clearValues+"====");
			if(clearValues.equals("clearValues")){
				Terminology = new ArrayList();
				Termcode = new HashMap();
				System.out.println("==============clear_values====="+clearValues+"====");
			}
		}
	}else{
		Terminology = new ArrayList();
		Termcode = new HashMap();
	}
	if(textName.equals("termgrp_code"))
	{
		String termgrp_code= request.getParameter("termgrp_code")==null ?"":(String)request.getParameter("termgrp_code");
		
		String tmp_grp_id="",chk_val="";
		StringTokenizer tokens = new StringTokenizer(termgrp_code,"::");
		StringTokenizer grp_tokens = null;
		//int cnt_tokens = tokens.countTokens() ;
		//if(Terminology !=null)
		//	Terminology.clear();
		//System.out.println("Termcode===="+Termcode+"====");
		//System.out.println("cnt_tokens===="+cnt_tokens+"====");
		while(tokens.hasMoreTokens()){
			grp_tokens = new StringTokenizer(tokens.nextToken(),"~");
			tmp_grp_id = grp_tokens.nextToken();
			chk_val = grp_tokens.nextToken();
			Termcode.put(tmp_grp_id,chk_val);
			//System.out.println("tmp_grp_id===="+tmp_grp_id+"====");
			//System.out.println("chk_val===="+chk_val+"====");
		}
		//TerminologyLookup.clearAll();
		if(Terminology != null & Terminology.size() > 0){
		Terminology.set(0,Termcode);
		System.out.println("Terminology=in if==="+Terminology+"====");
		}else{
			Terminology.add(0,Termcode);
			System.out.println("Terminology=in else==="+Terminology+"====");
		}
System.out.println("Terminology=after==="+Terminology+"===="+Terminology.size()+"---"+TerminologyLookup.getSize());
		if(TerminologyLookup.getSize()>0){
			TerminologyLookup.setObject(0,Terminology);
		}else
			TerminologyLookup.putObject(Terminology);
		System.out.println("--getSize-termgrp_code-"+TerminologyLookup.getSize()+"==");
	}else if(textName.equals("term_code")){
		String term_code= request.getParameter("term_code")==null ?"":(String)request.getParameter("term_code");
		
		String tmp_grp_id="",chk_val="";
		StringTokenizer tokens = new StringTokenizer(term_code,"::");
		StringTokenizer grp_tokens = null;
		//int cnt_tokens = tokens.countTokens() ;
		//if(Terminology !=null)
		//	Terminology.clear();
		//System.out.println("Termcode===="+Termcode+"====");
		//System.out.println("cnt_tokens===="+cnt_tokens+"====");
		while(tokens.hasMoreTokens()){
			grp_tokens = new StringTokenizer(tokens.nextToken(),"~");
			tmp_grp_id = grp_tokens.nextToken();
			chk_val = grp_tokens.nextToken();
			Termcode.put(tmp_grp_id,chk_val);
			//System.out.println("tmp_grp_id===="+tmp_grp_id+"====");
			//System.out.println("chk_val===="+chk_val+"====");
		}
		//System.out.println("getSize===="+TerminologyLookup.getSize()+"===="+Terminology.size());
		if(Terminology != null & Terminology.size() > 0){
			Terminology.set(0,Termcode);
		}else{
			Terminology.add(0,Termcode);
		}	System.out.println("Terminology=after=TC=="+Terminology+"===="+Terminology.size()+"---"+TerminologyLookup.getSize());	
		if(TerminologyLookup.getSize()>0){
			TerminologyLookup.setObject(0,Terminology);
		}else
			TerminologyLookup.putObject(Terminology);
System.out.println("getSize==term_code=="+TerminologyLookup.getSize()+"===="+Terminology.size());
	}else if(textName.equals("clear_values")){
		TerminologyLookup.clearAll();
	}else if(textName.equals("close_values")){
		if(TerminologyLookup.getSize()>0){
			TerminologyLookup.setObject(0,(ArrayList)TerminologyLookup.getObject(1));
			System.out.println("getSize==B4 Val=="+TerminologyLookup.getSize()+"===="+Terminology);
			TerminologyLookup.removeObject(1);
			System.out.println("getSize==after Val=="+TerminologyLookup.getSize()+"====");
		}
		
	}else if(textName.equals("pre_values")){
		System.out.println("getSize==Prev Val=="+TerminologyLookup.getSize()+"===="+Terminology.size());
		if(TerminologyLookup.getSize() == 1){
			ArrayList tmp_array = Terminology;
			//HashMap tmp_hash = (HashMap)Terminology.get(0);
			TerminologyLookup.clearAll();
			TerminologyLookup.putObject(Terminology);
			System.out.println("getSize==Prev Val=backup of prev ones="+TerminologyLookup.getSize()+"==val=="+TerminologyLookup.getObject(0)+"==="+TerminologyLookup.getRecordSetHandle()+"====");
			TerminologyLookup.putObject(tmp_array);
			System.out.println("getSize==Prev Val=backup of prev ones="+TerminologyLookup.getSize()+"==1=="+TerminologyLookup.getObject(1)+"=="+TerminologyLookup.getRecordSetHandle()+"====");
			//System.out.println("containsObject ones="+TerminologyLookup.containsObject(tmp_array)+"====");
			//System.out.println("getSize==Prev Val=backup of prev ones="+TerminologyLookup.getSize()+"==val=="+TerminologyLookup.getObject(0)+"=="+TerminologyLookup.getObject(1)+"==="+TerminologyLookup.getRecordSetHandle()+"===="+Terminology);
			//System.out.println("getSize==Prev Val=backup of prev ones="+tmp_array+"==val==");
			//TerminologyLookup.setObject(1,Terminology);
		}else{
			String clearValues = (String)request.getParameter("pre_values")==null?"":(String)request.getParameter("pre_values");
			System.out.println("==============pre_values clear====="+clearValues+"====");
			if(clearValues.equals("clearValues")){
				
				Termcode = new HashMap();
				if(Terminology != null & Terminology.size() > 0){
					Terminology.set(0,Termcode);
				}else
					Terminology.add(0,Termcode);
				System.out.println("Terminology=="+Terminology+"===");
				Terminology.add(0,Termcode);
				System.out.println("getSize=1=Prev Val=="+TerminologyLookup.getSize()+"==1=="+TerminologyLookup.getObject(0));
				TerminologyLookup.setObject(0,Terminology);
				System.out.println("getSize=2=Prev Val=="+TerminologyLookup.getSize()+"==2=="+TerminologyLookup.getObject(1));
				//System.out.println("getSize===0==="+(((TerminologyLookup.getObject(0)).get(0)).size()));
			}
			
		}
		
	}


}
catch(Exception ee)
{
	//out.println("Exception in validate terminology"+ee.toString());//COMMON-ICN-0181
	System.out.println("Exception in validate terminology"+ee.toString());
	ee.printStackTrace();
}

%>

</body>
</html>
<%!
	String replaceString(String sourceString,String str,String replaceWith)
	{
		int index=0;
		StringBuffer sourceBuffer = new StringBuffer(sourceString);
		while((index=sourceBuffer.toString().indexOf(str))!=-1)
		{
			sourceBuffer=sourceBuffer.replace(index,index+1,replaceWith);

		}
		return sourceBuffer.toString();
	}

	
%>

