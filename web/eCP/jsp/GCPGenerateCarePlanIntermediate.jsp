<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- 
	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Jerome
*	Created On		:	19/01/2005
* --%>
<html>

<%@page import="java.sql.*, java.io.*,java.util.*,java.text.*, webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>

<jsp:useBean id="GCPGenerateBean"   scope="session"  class="eCP.GCPGeneratePlanBean"/>

<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String locale=(String)session.getAttribute("LOCALE");
//This file is saved on 18/10/2005.
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>	
<Script language ="JavaScript" src ='../../eCommon/js/common.js'></Script>
	<Script language ="JavaScript" src ='../../eCommon/js/ValidateControl.js'></Script>
	<script language="JavaScript" src="../../eCP/js/GCPGenerateCarePlan.js"></script>
<SCRIPT LANGUAGE="JavaScript">
<!--


//-->
</SCRIPT>
</head>

<body OnMouseDown="CodeArrest()"  onKeyDown="lockKey()" Onload='' onscroll='scrollTitle()'>
<form name="" id=""  method ='post' target='' action=''>
<%

String textName				= (String)request.getParameter("textName") == null ? "" : request.getParameter("textName");
try
{ 
	 eCP.GCPGeneratePlanBean bean	= (eCP.GCPGeneratePlanBean)session.getAttribute("GCPGenerateBean");	
	
	HashMap dcasecode=new HashMap();
	if(textName.equals("case_type_code"))
	{
		String case_type_code= (String)request.getParameter("casetype_code")==null ?"": request.getParameter("casetype_code");
		String casetype_value = (String)request.getParameter("casetype_value")==null ?"": request.getParameter("casetype_value");
		
	if(!case_type_code.equals("")){
		
			dcasecode = bean.getDgCaseCode();
			if(casetype_value.equals("Y"))
				dcasecode.put(case_type_code,"Y");
			else
				dcasecode.remove(case_type_code);

			bean.setDgCaseCode(dcasecode);	
		
	}
	
	}else if(textName.equals("setcase_status"))
	{
		String case_code= request.getParameter("case_code")==null ?"": (String)request.getParameter("case_code");
		String casetype_value= request.getParameter("casetype_value")==null ?"": (String)request.getParameter("casetype_value");	
		HashMap casecode= new HashMap();
	
		String remove_lib= request.getParameter("remove_lib")==null ?"":(String)request.getParameter("remove_lib");
		String case_cd= request.getParameter("case_cd")==null ?"":(String)request.getParameter("case_cd");
		if(!case_cd.equals("")){
			casecode.remove(case_cd);
			bean.setCaseCode(casecode);	
			
		}
		HashMap termcode= new HashMap();
		termcode = bean.getTermCode();
		if(!termcode.equals("")){
			String record1="";
			Set s=termcode.keySet();
			Object[] record =  s.toArray();
			//int c1=s.size();
			//String term_code2 = "";
			String library_id = "",library_id1 = "";	
			String version_no = "",version_no1 = "";	
			if(!termcode.equals("")){
				StringTokenizer stk=new StringTokenizer(remove_lib,"~");
				while(stk.hasMoreTokens()){
					library_id = (stk.nextToken().trim());	 
					version_no = (stk.nextToken().trim());
				}

			}
			for(int c=0;c<record.length;c++){
								
				record1 = record[c].toString();
				StringTokenizer stk=new StringTokenizer(record1,"~");
				library_id1 = (stk.nextToken().trim());	 
				version_no1 = (stk.nextToken().trim());
				//termset_id1 = (stk.nextToken().trim());
				//term_code2 = (stk.nextToken().trim());
				if(library_id.equals(library_id1) && version_no.equals(version_no1) ){
					termcode.remove(record1);
				}
			}
		}bean.setTermCode(termcode);
		casecode = bean.getCaseCode();
		if(casetype_value.equals("Y")){
			casecode.put(case_code,casetype_value);
		}else{
			casecode.remove(case_code);	
		}
		
		bean.setCaseCode(casecode);
		String selected_lib= request.getParameter("selected_lib")==null ?"":(String)request.getParameter("selected_lib");
		String select_lib_value = request.getParameter("selected_value")==null ?"":(String)request.getParameter("selected_value");
		if(!selected_lib.equals("")){
		//out.println("<script>alert('selected_lib::"+selected_lib+"')</script>");
			HashMap select_lib = new HashMap();
			select_lib = bean.getSelectedLib();
			if(select_lib_value.equals("Y"))
				select_lib.put(selected_lib,select_lib_value);
			else
				select_lib.remove(selected_lib);	
			bean.setSelectedLib(select_lib);
		}
	}else if(textName.equals("setLimited_lib"))
	{//out.println("<script>alert('setLimited_lib--"+textName+"---')</script>");
		String termset_id= request.getParameter("termset_id")==null ?"":(String)request.getParameter("termset_id");
		String term_code = request.getParameter("term_code")==null ?"":(String)request.getParameter("term_code");
		String sel_diags = request.getParameter("sel_diags")==null ?"":(String)request.getParameter("sel_diags");
	
		sel_diags = sel_diags.replace('~','\'');
		HashMap limit_lib = new HashMap();
		if(!termset_id.equals("")){
			//limit_lib = bean.getLimitLib();
			limit_lib.put(termset_id,term_code);
			bean.setLimitLib(limit_lib);
			
		}
		bean.setDiags(sel_diags);
		bean.setLimitLib(limit_lib);
	}else if(textName.equals("setterm_code"))
	{
		String term_code= request.getParameter("term_code")==null ?"":(String)request.getParameter("term_code");
		String termcode_value= request.getParameter("termcode_value")==null ?"": (String)request.getParameter("termcode_value");	
		String term_cd_value= request.getParameter("term_cd_value")==null ?"":(String)request.getParameter("term_cd_value");
		String remove_lib= request.getParameter("remove_lib")==null ?"":(String)request.getParameter("remove_lib");
		String case_code= request.getParameter("case_code")==null ?"":(String)request.getParameter("case_code");
		if(!case_code.equals("")){
			HashMap case_cd=new HashMap();
			case_cd.remove(case_code);
			bean.setCaseCode(case_cd);	
			
		}
		HashMap termcode= new HashMap();
		termcode = bean.getTermCode();
		if(!termcode.equals("")){
			String record1="";
			Set s=termcode.keySet();
			Object[] record =  s.toArray();
			//int c1=s.size();
			//String term_code2 = "";
			String library_id = "",library_id1 = "";	
			String version_no = "",version_no1 = "";	
			if(!termcode.equals("")){
				StringTokenizer stk=new StringTokenizer(remove_lib,"~");
				while(stk.hasMoreTokens()){
					library_id = (stk.nextToken().trim());	 
					version_no = (stk.nextToken().trim());
				}

			}
			for(int c=0;c<record.length;c++){
								
				record1 = record[c].toString();
				StringTokenizer stk=new StringTokenizer(record1,"~");
				library_id1 = (stk.nextToken().trim());	 
				version_no1 = (stk.nextToken().trim());
				//termset_id1 = (stk.nextToken().trim());
				//term_code2 = (stk.nextToken().trim());
				if(library_id.equals(library_id1) && version_no.equals(version_no1) ){
					termcode.remove(record1);
				}
			}
		}
		
				
			StringTokenizer stk=new StringTokenizer(term_cd_value,"|");
			String str[]=null;
			int cnt=stk.countTokens();
			str = new String[cnt];int j=0;
			while(stk.hasMoreTokens()){
			str[j] = stk.nextToken();
			j++;
			}
			if(str.length > 0)
				term_cd_value = str[0]+"~";
			if(str.length == 1)
				term_cd_value = str[0];
		if(termcode_value.equals("Y")){
			termcode.put(term_cd_value,termcode_value);
		}else{
			termcode.remove(term_cd_value);
			/*******************to remove the intervention for the unchecked diagnosis********/
			//String term_code1="";
			HashMap select_intvn = null;
			select_intvn = bean.getSelectedIntvn();
			//out.println("<script>alert('select_intvn::"+select_intvn+"--')</script>");
			stk=new StringTokenizer(term_code,"~");
			while(stk.hasMoreTokens()){
				 stk.nextToken();
				 //term_code1=stk.nextToken();
			}
			Set s= select_intvn.keySet();
			Object[] record =  s.toArray();
			String record1= "",record2= "";
			for(int c=0;c<record.length;c++){
				record1 = record[c].toString();
							
				if(term_cd_value!=null && !term_cd_value.equals("")){
					term_cd_value = term_cd_value.replace('~',',');
					//term_cd_value1 = term_cd_value.substring(0,term_cd_value.length()-1);
					str[0]= str[0].replace('~',',');
				}
				
				record2 = record1.substring(0,record1.length()-1);
				int indx = record2.lastIndexOf(",");
				record2 = record2.substring(0,indx);	
				int i=0;String tmp="";
				for(int tt=0;tt<str.length-1;tt++){tmp="";
				if(tt >0){
				i = str[0].lastIndexOf(",");
				tmp = str[0].substring(0,i);
				tmp =tmp + ","+str[tt];
				}else if(tt == 0)
					tmp = str[0];

				if(tmp.equals(record2)){
					select_intvn.remove(record1);
				}
				}
				//bean.setSelectedIntvn(null);
			//	bean.setInterCode("");
				bean.setSelectedIntvn(select_intvn);
				/*******************ends here********/
			}
		}bean.setTermCode(termcode);
		String selected_lib= request.getParameter("selected_lib")==null ?"":(String)request.getParameter("selected_lib");
		String select_lib_value = request.getParameter("selected_value")==null ?"":(String)request.getParameter("selected_value");
		
		if(!selected_lib.equals("")){
			HashMap select_lib = new HashMap();
			select_lib = bean.getSelectedLib();
			/***this to remove the unselected library within a group*****/
			if(!select_lib.equals("")){
				String records1="";
				Set ss=select_lib.keySet();
				Object[] records =  ss.toArray();
				//String termset_id2 = "",termset_id3 = "";
				//String term_code3 = "",term_code4 = "";
				String library_id2 = "",library_id3 = "";	
				String version_no2 = "",version_no3 = "";	
				//selected_lib1 = selected_lib.substring(0,selected_lib.length()-1);
				StringTokenizer stk_lib=new StringTokenizer(remove_lib,"~");
				while(stk_lib.hasMoreTokens()){
				library_id2 = (stk_lib.nextToken().trim());	 
				version_no2 = (stk_lib.nextToken().trim());
				
				}
				for(int c=0;c<records.length;c++){
								
				records1 = records[c].toString();
				StringTokenizer stk1=new StringTokenizer(records1,",");
				library_id3 = (stk1.nextToken().trim());	 
				version_no3 = (stk1.nextToken().trim());
				//termset_id3 = (stk1.nextToken().trim());
				//term_code4 = (stk1.nextToken().trim());

				if(library_id2.equals(library_id3) && version_no2.equals(version_no3) ){
					select_lib.remove(records1);
				}
			}
				
			}
			if(select_lib_value.equals("Y"))
				select_lib.put(selected_lib,select_lib_value);
			else
				select_lib.remove(selected_lib);	
			
			bean.setSelectedLib(select_lib);
		}
		
			
	}else if(textName.equals("setSelectedLib"))
	{
		String selected_lib= request.getParameter("selected_lib")==null ?"":(String)request.getParameter("selected_lib");
		String select_lib_value = request.getParameter("selected_value")==null ?"":(String)request.getParameter("selected_value");
		HashMap select_lib = new HashMap();
		select_lib = bean.getSelectedLib();
		if(select_lib_value.equals("Y"))
			select_lib.put(selected_lib,select_lib_value);
		else
			select_lib.remove(selected_lib);
		bean.setSelectedLib(select_lib);
		
	}else if(textName.equals("setSelectedIntvn")){
		String selected_diag= request.getParameter("selected_diag")==null ?"":(String)request.getParameter("selected_diag");
		String selected_diag_val = request.getParameter("selected_diag_val")==null ?"":(String)request.getParameter("selected_diag_val");
		String call_mode=request.getParameter("textMode")==null ?"":(String)request.getParameter("textMode");
		HashMap select_intvn = null;
		select_intvn = bean.getSelectedIntvn();
		if(!selected_diag_val.equals("")){
			select_intvn.put(selected_diag,selected_diag_val);
		}else{
		select_intvn.put(selected_diag,null);
		}
		bean.setSelectedIntvn(select_intvn);

		if(call_mode.equals("Goal")){
			selected_diag= "#"+selected_diag;
			selected_diag_val = "";
			//select_intvn = null;
			select_intvn = bean.getSelectedIntvn();
			if(!selected_diag_val.equals("")){
				select_intvn.put(selected_diag,selected_diag_val);
			}else{
				select_intvn.put(selected_diag,null);
			}
			bean.setSelectedIntvn(select_intvn);
		}
	}else if(textName.equals("setSelectedGenIntvn")){
		String selected_diag= request.getParameter("selected_diag")==null ?"":(String)request.getParameter("selected_diag");
		String selected_diag_val = request.getParameter("selected_diag_val")==null ?"":(String)request.getParameter("selected_diag_val");
		HashMap select_intvn = null;
		select_intvn = bean.getSelectedIntvn();
		if(!selected_diag_val.equals("")){
			select_intvn.put(selected_diag,selected_diag_val);
		}else{
		select_intvn.put(selected_diag,null);
		}
		bean.setSelectedIntvn(select_intvn);
	}else if(textName.equals("setInterDetails")){
		String select_code= request.getParameter("select_code")==null ?"":(String)request.getParameter("select_code");
		String tmp_value="";String d_inter_code="",d_inter_code_val ="";
		HashMap inter_details = new HashMap();
		if(!select_code.equals("")){
			StringTokenizer stk=new StringTokenizer(select_code,"`");
			while(stk.hasMoreTokens()){
				tmp_value = stk.nextToken();
				StringTokenizer stk1=new StringTokenizer(tmp_value,"~");
				while(stk1.hasMoreTokens()){
					d_inter_code = stk1.nextToken();
					d_inter_code_val =stk1.nextToken();
					inter_details.put(d_inter_code,d_inter_code_val);
				}
			}
			bean.setInterDetail(inter_details);
		}
	}else if(textName.equals("clear_bean")){

		bean.clearBean();
	}else if(textName.equals("setDiagCode")){

		String diag_code= request.getParameter("diag_code")==null ?"":(String)request.getParameter("diag_code");

		HashMap termcode= new HashMap();
		termcode = bean.getTermCode();
		if(!diag_code.equals(""))
		{
			String record1="";
			Set s=termcode.keySet();
			Object[] record =  s.toArray();
			//int c1=s.size();
			
			for(int c=0;c<record.length;c++){
								
				record1 = record[c].toString();
				int x = record1.indexOf(diag_code);
				if(x != -1){
					termcode.remove(record1);
				
				}bean.setTermCode(termcode);
			}
			//String term_code1="";
			HashMap select_intvn = null;//getSelectedLib
			select_intvn = bean.getSelectedIntvn();
			s= select_intvn.keySet();
			//out.println("<script>alert('equals::--"+s+"---')</script>");
			record =  s.toArray();
			for(int c=0;c<record.length;c++){
				record1 = record[c].toString();
							
				int x = record1.indexOf(diag_code);
				if(x != -1){
					select_intvn.remove(record1);
				}
				
			}bean.setSelectedIntvn(select_intvn);
			HashMap select_lib = new HashMap();
			select_lib = bean.getSelectedLib();
			
				s=select_lib.keySet();
				record =  s.toArray();
								
				for(int c=0;c<record.length;c++){
								
				record1 = record[c].toString();
				int x = record1.indexOf(diag_code);
				if(x != -1){
					select_lib.remove(record1);
				}

				
			}bean.setSelectedLib(select_lib);
			HashMap limit_lib = new HashMap();
			limit_lib = bean.getLimitLib();
			s=limit_lib.keySet();String tmp_code="";
			record =  s.toArray();
			for(int c=0;c<record.length;c++){
								
				record1 = record[c].toString();
				tmp_code = (String)limit_lib.get(record1);
				tmp_code = tmp_code.substring(0,tmp_code.length()-1);
				if(tmp_code.equals(diag_code))
				{
					limit_lib.remove(record1);
				}
			}bean.setLimitLib(limit_lib);
		}
	}else if(textName.equals("setInterCode")){
		
		String inter_code =  request.getParameter("tmp_inter_code")==null ?"":(String)request.getParameter("tmp_inter_code");
		//out.println("<script>alert('"+bean.getSelectedIntvn()+"');</script>");
		if(!inter_code.equals("")){
			inter_code =inter_code.replace('~','\'');
			inter_code = inter_code.substring(0,inter_code.length()-1);
			String bean_code=(String)bean.getInterCode();
			String bean_code1=bean_code;
			String temp_code="";

			ArrayList intvn_Code=new ArrayList();
			ArrayList bean_Code=new ArrayList();
			int index=0;
			if(bean_code != null){
				while(index<bean_code.length()){
					if(bean_code.indexOf(",")>0){
						temp_code=bean_code.substring(1, bean_code.indexOf(",")-1);
						if(!bean_Code.contains(temp_code))
							bean_Code.add(temp_code);
						bean_code=bean_code.substring(bean_code.indexOf(",")+1);
						index=bean_code.indexOf(",");
					}
					else{
						bean_code=bean_code.substring(1);
						temp_code=bean_code.substring(0, bean_code.indexOf("\'"));
						if(!bean_Code.contains(temp_code))
							bean_Code.add(temp_code);
						bean_code="";
						index=0;
					}
				}
			}

			String temp_intvn=inter_code;
			index=0;
			while(index<temp_intvn.length()){
				if(temp_intvn.indexOf(",")>0){
					temp_code=temp_intvn.substring(1, temp_intvn.indexOf(",")-1);
					if(!intvn_Code.contains(temp_code))
						intvn_Code.add(temp_code);
					temp_intvn=temp_intvn.substring(temp_intvn.indexOf(",")+1);
					index=temp_intvn.indexOf(",");
				}
				else{
					temp_intvn=temp_intvn.substring(1);
					temp_code=temp_intvn.substring(0, temp_intvn.indexOf("\'"));
						if(!intvn_Code.contains(temp_code))
							intvn_Code.add(temp_code);
						temp_intvn="";
						index=0;
				}
			}
			if(bean_Code.size()>0){
				for(int i=0;i<intvn_Code.size();i++){
					temp_code=(String)intvn_Code.get(i);
					index=-1;
					for(int j=0;j<bean_Code.size();j++){
						if(temp_code.equals(bean_Code.get(j))){
							index=j;
							break;
						}
					}
					if(index == -1){
						if(bean_Code.size()>0)
							bean_code1=bean_code1+",\'"+intvn_Code.get(i)+"\'";
					   else
						   bean_code1="\'"+intvn_Code.get(i)+"\'";
					}
				}
			}
			else
				bean_code1 = inter_code;
			bean.setInterCode(bean_code1);
		}		
	}else if(textName.equals("setGenInterCode")){
		
		String inter_code =  request.getParameter("tmp_inter_code")==null ?"":(String)request.getParameter("tmp_inter_code");
		if(!inter_code.equals("")){
			inter_code =inter_code.replace('~','\'');
			inter_code = inter_code.substring(0,inter_code.length()-1);
			String bean_code=(String)bean.getInterCode();
			String bean_code1=bean_code;
			String temp_code="";
			ArrayList intvn_Code=new ArrayList();
			ArrayList bean_Code=new ArrayList();
			int index=0;
			if(bean_code != null){
				while(index<bean_code.length()){
					if(bean_code.indexOf(",")>0){
						temp_code=bean_code.substring(1, bean_code.indexOf(",")-1);
						if(!bean_Code.contains(temp_code))
							bean_Code.add(temp_code);
						bean_code=bean_code.substring(bean_code.indexOf(",")+1);
						index=bean_code.indexOf(",");
					}
					else{
					bean_code=bean_code.substring(1);
					temp_code=bean_code.substring(0, bean_code.indexOf("\'"));
						if(!bean_Code.contains(temp_code))
							bean_Code.add(temp_code);
						bean_code="";
						index=0;
					}
				}
			}
			String temp_intvn=inter_code;
			index=0;
			while(index<temp_intvn.length()){
				if(temp_intvn.indexOf(",")>0){
					temp_code=temp_intvn.substring(1, temp_intvn.indexOf(",")-1);
					if(!intvn_Code.contains(temp_code))
						intvn_Code.add(temp_code);
					temp_intvn=temp_intvn.substring(temp_intvn.indexOf(",")+1);
					index=temp_intvn.indexOf(",");
				}
				else{
					temp_intvn=temp_intvn.substring(1);
					temp_code=temp_intvn.substring(0, temp_intvn.indexOf("\'"));
						if(!intvn_Code.contains(temp_code))
							intvn_Code.add(temp_code);
						temp_intvn="";
						index=0;
				}
			}
			if(bean_Code.size()>0){
				for(int i=0;i<intvn_Code.size();i++){
					temp_code=(String)intvn_Code.get(i);
					index=-1;
					for(int j=0;j<bean_Code.size();j++){
						if(temp_code.equals(bean_Code.get(j))){
							index=j;
							break;
						}
					}
					if(index == -1){
						if(bean_Code.size()>0)
							bean_code1=bean_code1+",\'"+intvn_Code.get(i)+"\'";
					   else
						   bean_code1="\'"+intvn_Code.get(i)+"\'";
					}
				}
			}
			else
				bean_code1 = inter_code;
			bean.setInterCode(bean_code1);
		}
		
	}else if(textName.equals("setDates")){
		String selected_key = request.getParameter("selected_key")==null ?"":(String)request.getParameter("selected_key");
		String selected_dates = request.getParameter("selected_dates")==null ?"":(String)request.getParameter("selected_dates");
		HashMap diag_dates= new HashMap();
		StringTokenizer stk= new StringTokenizer(selected_key,"||");
		int cnt = stk.countTokens();int j =0;
		String record[] =null ;
		record = new String[cnt] ;
		while(stk.hasMoreTokens()){
			record[j]= stk.nextToken();
			j++;
		}
		stk= new StringTokenizer(selected_dates,"||");
		int cnt1 = stk.countTokens();j =0;
		String record1[] =null ;
		record1 = new String[cnt1] ;
		while(stk.hasMoreTokens()){			
				record1[j]= stk.nextToken();
			System.err.println("record1[j]===>"+record1[j]);
			j++;
		}
		for(int tmp=0;tmp<record.length;tmp++){
			diag_dates.put(record[tmp],record1[tmp]);
		}
		bean.setDateValues(diag_dates);
		}else if(textName.equals("setPlanDate")){
		String pract_desc = request.getParameter("pract_desc")==null ?"":(String)request.getParameter("pract_desc");
		String plan_start_date = request.getParameter("plan_start_date")==null ?"":com.ehis.util.DateUtils.convertDate((String)request.getParameter("plan_start_date"),"DMYHM",locale,"en");
		String plan_targ_date = request.getParameter("plan_targ_date")==null ?"":com.ehis.util.DateUtils.convertDate((String)request.getParameter("plan_targ_date"),"DMYHM",locale,"en");
		bean.setCareManagerDesc(pract_desc);
		bean.setPlanStart(plan_start_date);
		bean.setPlanEnd(plan_targ_date);

	}else if(textName.equals("FinalizePlan")){
/***********************************************************************************************/
	String value_str = "";

SimpleDateFormat dtSystemFormat = new SimpleDateFormat("dd/MM/yyyy kk:mm");
java.util.Date date_time	 	= new java.util.Date();
String dateString 				= dtSystemFormat.format(date_time);
String patient_id=bean.getPatientId();
HashMap codeKeyValue = new HashMap();
if(value_str.equals("")){
	codeKeyValue =  bean.getSelectedLib();
	Set s=codeKeyValue.keySet();
	Object[] record =  s.toArray();
	for(int c=0;c<record.length;c++){
		value_str = value_str +record[c].toString();
	}
}
String sql= "",sql1= "",sql2= "",sql3= "";
int group_id=0;
//first_time = bean.getPageFirst();

Connection con = null;
PreparedStatement ps = null,ps1 = null,ps2 = null,ps3 = null;
ResultSet rs = null,rs1 = null,rs2 = null,rs3 = null;

try{

con =ConnectionManager.getConnection(request);
sql ="select A.TERM_SET_ID ,B.TERM_SET_DESC ,A.TERM_CODE ,C.SHORT_DESC TERM_CODE_SHORT_DESC ,A.GOAL_CODE ,D.SHORT_DESC GOAL_SHORT_DESC ,A.GOAL_TARGET_DURN ,A.GOAL_TARGET_DURN_UNIT ,Decode(A.GOAL_TARGET_DURN_UNIT,'D',TO_CHAR(SYSDATE+A.GOAL_TARGET_DURN,'DD/MM/YYYY HH24:MI'),'H',TO_CHAR(SYSDATE+A.GOAL_TARGET_DURN/24 , 'DD/MM/YYYY HH24:MI'),'M',TO_CHAR(SYSDATE+(A.GOAL_TARGET_DURN/(24*60)),'DD/MM/YYYY HH24:MI'),'L',TO_CHAR(ADD_MONTHS(SYSDATE,A.GOAL_TARGET_DURN) , 'DD/MM/YYYY HH24:MI'),'W',TO_CHAR(SYSDATE+A.GOAL_TARGET_DURN*7 , 'DD/MM/YYYY HH24:MI'),'')GOAL_TARGET_DATE,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI')GOAL_START_DATE, E.CURR_PRIORITY  FROM CP_LIBRARY_GOAL A ,MR_TERM_SET  B ,MR_TERM_CODE C ,CP_OUTCOME D,PR_DIAGNOSIS E  WHERE    A.LIBRARY_ID = ? AND A.VERSION_NO = ? AND A.TERM_SET_ID  = ? AND A.TERM_CODE  = ? AND  B.TERM_SET_ID=A.TERM_SET_ID AND C.TERM_SET_ID=A.TERM_SET_ID AND C.TERM_CODE=A.TERM_CODE AND D.OUTCOME_CODE=A.GOAL_CODE AND E.TERM_SET_ID=A.TERM_SET_ID AND E.TERM_CODE=A.TERM_CODE AND E.PATIENT_ID = ? AND E.CURR_STATUS = 'A' ORDER BY E.CURR_PRIORITY ";

sql1 = "SELECT A.INTERVENTION_CODE ,B.SHORT_DESC INTERVENTION_SHORT_DESC ,A.GROUP_ID FROM CP_LIBRARY_INTERVENTION A ,  CA_INTERVENTION B WHERE A.LIBRARY_ID     = ? AND A.VERSION_NO     =? AND A.TERM_SET_ID    =? AND A.TERM_CODE      =?  AND A.GOAL_CODE     = ? AND B.INTERVENTION_CODE= A.INTERVENTION_CODE AND A.GROUP_ID = ?" ;

sql2="SELECT A.OUTCOME_CODE ,B.SHORT_DESC OUTCOME_SHORT_DESC ,A.GROUP_ID FROM CP_LIBRARY_OUTCOME A , CP_OUTCOME B WHERE A.LIBRARY_ID     = ? AND A.VERSION_NO     = ? AND A.TERM_SET_ID    = ? AND A.TERM_CODE       = ? AND A.GOAL_CODE      = ?  AND B.OUTCOME_CODE= A.OUTCOME_CODE AND A.GROUP_ID = ?  " ;

sql3 = "SELECT DISTINCT GROUP_ID FROM CP_LIBRARY_INTERVENTION A WHERE A.LIBRARY_ID     = ? AND A.VERSION_NO     = ? AND A.TERM_SET_ID    = ? AND A.TERM_CODE       = ? AND A.GOAL_CODE      = ? ";

StringBuffer goal_stmt=new StringBuffer();

int i=0,ii=0;
ps = con.prepareStatement(sql);
ps1 = con.prepareStatement(sql1);
ps2 = con.prepareStatement(sql2);
ps3 = con.prepareStatement(sql3);

if(!value_str.equals("")){
	String Library_id="";
	int version_no=0;
	String term_set_id="";
	String term_code="";String goal_code="";
	String values= "";String intervention_code="";String inter_code="";
	String out_code="";String tmp_target_date="";
	String selected_intvn="";
	String selected_intvn_value="";
	String ex_selected_intvn="",ex_selected_intvn_value= "";
	String target_date="";

	//patient_class =bean.getPatientClass();
	HashMap select_intvn = null;
	HashMap select_intvn1 = new HashMap();
	select_intvn = bean.getSelectedIntvn();
	
	String record_termcd[]=null;
	StringTokenizer stk= new StringTokenizer(value_str,"~");
	//int cnt = stk.countTokens();
	while(stk.hasMoreTokens()){
		values= stk.nextToken();
		StringTokenizer stk1= new StringTokenizer(values,",");
		while(stk1.hasMoreTokens()){
			Library_id=stk1.nextToken();
			version_no=Integer.parseInt(stk1.nextToken());
			term_set_id=stk1.nextToken();
			term_code=stk1.nextToken();
			
			StringTokenizer s_tk= new StringTokenizer(term_code,"|");
			int cnt = s_tk.countTokens();
			record_termcd=new String[cnt];cnt=0;
			while(s_tk.hasMoreTokens()){
				record_termcd[cnt] = s_tk.nextToken();	
				cnt++;
			}

ps.setString(1,Library_id);
ps.setInt(2, version_no);
ps.setString(3, term_set_id);

for(int tmp=0;tmp<record_termcd.length;tmp++){
	term_code= record_termcd[tmp];
	ps.setString(4, term_code);
	ps.setString(5, patient_id);

	rs = ps.executeQuery();

	while(rs.next())
	{
		intervention_code = "";out_code = "";
		
		goal_code=rs.getString(5);
		goal_stmt.append(rs.getString(6));
		goal_stmt.append(" ");

		target_date=(rs.getString(9)==null?dateString:rs.getString(9));
		tmp_target_date=(tmp_target_date==""?target_date:tmp_target_date);

						
		ps3.setString(1,Library_id);
		ps3.setInt(2, version_no);
		ps3.setString(3, term_set_id);
		ps3.setString(4, term_code);
		ps3.setString(5, goal_code);
		rs3 = ps3.executeQuery();
		while(rs3.next())
		{	
			group_id = rs3.getInt(1);
										
			ps1.setString(1,Library_id);
			ps1.setInt(2, version_no);
			ps1.setString(3, term_set_id);
			ps1.setString(4, term_code);
			ps1.setString(5, goal_code);
			ps1.setInt(6, group_id);
			rs1 = ps1.executeQuery();
						
			while(rs1.next())
			{
				
						intervention_code =intervention_code + rs1.getString(1)+"*"+group_id+"|";	
				inter_code =inter_code + "'"+rs1.getString(1) +"',";	
			}
			ps2.setString(1,Library_id);
			ps2.setInt(2, version_no);
			ps2.setString(3, term_set_id);
			ps2.setString(4, term_code);
			ps2.setString(5, goal_code);
			ps2.setInt(6, group_id);
			rs2 = ps2.executeQuery();
				
			while(rs2.next())
			{	
			
				out_code = out_code +rs2.getString(1)+"*"+group_id+"|";	
			}
		}	
		i++;
		selected_intvn = Library_id+","+version_no+","+term_set_id+","+term_code+","+goal_code+",";
		if(intervention_code.equals(""))
			intervention_code = " ";
		if(out_code.equals(""))
			out_code = " ";
		selected_intvn_value = tmp_target_date+","+intervention_code+","+out_code+"~";

		if(select_intvn.containsKey(selected_intvn)){
			ex_selected_intvn=selected_intvn;
			ex_selected_intvn_value=(String)select_intvn.get(ex_selected_intvn);
					select_intvn1.put(ex_selected_intvn,ex_selected_intvn_value);
			
		}else{
			
			select_intvn1.put(selected_intvn,selected_intvn_value);
		}
	}
}
			

		}//end of while values
		ii = i;
		
		
	}//end of while value_str
String tmp_inter_code="";
tmp_inter_code = bean.getInterCode();

if(tmp_inter_code.equals("")){
	
	inter_code = inter_code.substring(0,inter_code.length()-1);
	bean.setInterCode(inter_code);
	
}
bean.setSelectedIntvn(select_intvn1);
bean.setPageFirst(ii);
bean.setGoalStmt(goal_stmt.toString());


}//end of values_str not equals null
	if(i ==0 || value_str.equals("")){
	//	out.println("<script>alert('APP-CP0020 No Libraries are selected');</script>");
	}
}
catch(Exception ee)
{
	//out.println("Exception while populating the values for summary "+ee.toString());//COMMON-ICN-0181
	System.out.println("Exception while populating the values for summary "+ee.toString());
	ee.printStackTrace();
}
finally
{
	try{
			if(rs != null) rs.close();if(rs1 != null) rs1.close();if(rs2 != null) rs2.close();
			if(rs3 != null) rs3.close();
			if(ps3 != null) ps3.close();
			if(ps1 != null) ps1.close();
			if(ps2 != null) ps2.close();
			if(ps != null) ps.close();
			if(con != null) ConnectionManager.returnConnection(con);
	}
	catch(Exception e){
		out.println(e);
		System.out.println("Exception while populating the values for summary "+e.toString());
		e.printStackTrace();
	}
}


/***********************************************************************************************/

	}else{
		String error_num=request.getParameter( "err_num" );
		String error_value = request.getParameter( "err_value" )==null ? "0" : request.getParameter( "err_value" ) ;

		out.println("<script language='javascript'>onSuccess('"+error_num+"','"+error_value+"');</script><Script src='../../eCommon/js/showModalDialog.js' language='JavaScript\'></Script>");
		

	}

}
catch(Exception ee)
{
	//out.println("Exception in intermediate Profile Case Type "+ee.toString());//common-icn-0181
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

