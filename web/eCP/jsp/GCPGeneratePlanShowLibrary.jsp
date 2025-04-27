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
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%
/*
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------
05/06/2024   60772      Twinkle Shah    05/06/2024	    Ramesh Goli      MMS-JU-SCF-0267
--------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="com.itextpdf.text.log.SysoLogger"%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
 
<%@page import="java.sql.*, java.io.*,java.util.*,java.text.*, webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="GCPGenerateBean"   scope="session"  class="eCP.GCPGeneratePlanBean"/>
<html>
	<title>
	<fmt:message key="Common.Summary.label" bundle="${common_labels}"/>
	</title>
<head>
<%
	//This file is saved on 18/10/2005.
	 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String locale=(String)session.getAttribute("LOCALE");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>	
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<Script language ="JavaScript" src ='../../eCommon/js/common.js'></Script>
  	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCP/js/GCPGenerateCarePlan.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<SCRIPT LANGUAGE="JavaScript">
	<!--
	 
	 function scrollTitle()
	{
		  var scrollXY = document.body.scrollTop;
		  if(scrollXY == 0)
		  {
						document.getElementById('showLibrary').style.position = 'static';
						document.getElementById('showLibrary').style.posTop  = 0;
		  }
		  else
		  {
					document.getElementById('showLibrary').style.position = 'relative';
					document.getElementById('showLibrary').style.posTop  = scrollXY;
		  }
	}
	//-->

	</SCRIPT>	
	
</head>
<%
String obj				= request.getParameter("obj")==null?"":request.getParameter("obj"); //60772
String value_str				= request.getParameter("value_str")==null?"":request.getParameter("value_str");
String encounterId				= request.getParameter("encounterId")==null?"":request.getParameter("encounterId"); //60772
String[] encounterIds = encounterId.split(",");//60772
eCP.GCPGeneratePlanBean bean	= (eCP.GCPGeneratePlanBean)session.getAttribute("GCPGenerateBean");	
//String pract_desc				= bean.getCareManagerDesc();
SimpleDateFormat dtSystemFormat = new SimpleDateFormat("dd/MM/yyyy kk:mm");
java.util.Date date_time	 	= new java.util.Date();
String dateString 				= com.ehis.util.DateUtils.convertDate(dtSystemFormat.format(date_time),"DMYHM","en",locale);
String tmp_st_date				= dateString;
String patient_id				= bean.getPatientId();
String encounter_id			= (String)request.getParameter("encounter_id"); //60772
String sel_lib_ids				= "";
HashMap codeKeyValue			= new HashMap();	
if(value_str.equals(""))
{
	codeKeyValue		=	bean.getSelectedLib();			
	Set s				=	codeKeyValue.keySet();	
	Object[] record		=	s.toArray();
	for(int c=0;c<record.length;c++)
	{
		value_str		=	value_str +record[c].toString();
	}
	
}

//out.println("<script>alert('value_str::"+bean.getSelectedLib()+"')</script>");
String sql			= "";
String sql1			= "";
String sql2			= "";
String sql3			= "";
String classValue	="";
int first_time		= 0;
int group_id		= 0;
int dgroup_cnt		= 0;
int dgroup_count	= 0;
first_time			= bean.getPageFirst();
boolean chk_flag	= false;
//out.println("<script>alert('first_time::"+first_time+"')</script>");
Connection con		= null;
PreparedStatement ps= null,ps1 = null,ps2 = null,ps3 = null;
ResultSet rs		= null,rs1 = null,rs2 = null,rs3 = null;

%>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script language='javascript'>
	document.body.style.scrollbarBaseColor='#E2E3F0';
	document.body.style.scrollbarArrowColor='#000080';
	document.body.style.scrollbarDarkShadowColor='#E2E3F0';
	document.body.style.scrollbarFaceColor='#E2E3F0';
	document.body.style.scrollbarHighlightColor='white';
	document.body.style.scrollbarShadowColor='#E2E3F0';
	document.body.style.scrollbar3dlightColor='#E2E3F0';
</script>
<form name='generate_summary' id='generate_summary' target='messageFrame' >
<table cellpadding=0 cellspacing=0 border=0 width="100%" align=center >
<%
try{

con =ConnectionManager.getConnection(request);
//sql ="select A.TERM_SET_ID ,B.TERM_SET_DESC ,A.TERM_CODE ,C.SHORT_DESC TERM_CODE_SHORT_DESC ,A.GOAL_CODE ,D.SHORT_DESC GOAL_SHORT_DESC ,A.GOAL_TARGET_DURN ,A.GOAL_TARGET_DURN_UNIT ,Decode(A.GOAL_TARGET_DURN_UNIT,'D',TO_CHAR(SYSDATE+A.GOAL_TARGET_DURN,'DD/MM/YYYY HH24:MI'),'H',TO_CHAR(SYSDATE+A.GOAL_TARGET_DURN/24 , 'DD/MM/YYYY HH24:MI'),'M',TO_CHAR(SYSDATE+(A.GOAL_TARGET_DURN/(24*60)),'DD/MM/YYYY HH24:MI'),'L',TO_CHAR(ADD_MONTHS(SYSDATE,A.GOAL_TARGET_DURN) , 'DD/MM/YYYY HH24:MI'),'W',TO_CHAR(SYSDATE+A.GOAL_TARGET_DURN*7 , 'DD/MM/YYYY HH24:MI'),'')GOAL_TARGET_DATE,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI')GOAL_START_DATE, E.CURR_PRIORITY  FROM CP_LIBRARY_GOAL A ,MR_TERM_SET  B ,MR_TERM_CODE C ,CP_OUTCOME D,PR_DIAGNOSIS E  WHERE    A.LIBRARY_ID = ? AND A.VERSION_NO = ? AND A.TERM_SET_ID  = ? AND A.TERM_CODE  = ? AND  B.TERM_SET_ID=A.TERM_SET_ID AND C.TERM_SET_ID=A.TERM_SET_ID AND C.TERM_CODE=A.TERM_CODE AND D.OUTCOME_CODE=A.GOAL_CODE AND E.TERM_SET_ID=A.TERM_SET_ID AND E.TERM_CODE=A.TERM_CODE AND E.PATIENT_ID = ? AND E.CURR_STATUS = 'A' ORDER BY E.CURR_PRIORITY,3 ";
//sql ="SELECT A.TERM_SET_ID ,B.TERM_SET_DESC ,A.TERM_CODE ,C.SHORT_DESC TERM_CODE_SHORT_DESC ,A.GOAL_CODE ,D.SHORT_DESC GOAL_SHORT_DESC ,A.GOAL_TARGET_DURN ,A.GOAL_TARGET_DURN_UNIT ,DECODE(A.GOAL_TARGET_DURN_UNIT,'D',TO_CHAR(SYSDATE+A.GOAL_TARGET_DURN,'DD/MM/YYYY HH24:MI'),'H',TO_CHAR(SYSDATE+A.GOAL_TARGET_DURN/24 , 'DD/MM/YYYY HH24:MI'),'M',TO_CHAR(SYSDATE+(A.GOAL_TARGET_DURN/(24*60)),'DD/MM/YYYY HH24:MI'),'L',TO_CHAR(ADD_MONTHS(SYSDATE,A.GOAL_TARGET_DURN) , 'DD/MM/YYYY HH24:MI'),'W',TO_CHAR(SYSDATE+A.GOAL_TARGET_DURN*7 , 'DD/MM/YYYY HH24:MI'),'')GOAL_TARGET_DATE,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI')GOAL_START_DATE, E.CURR_PRIORITY  FROM CP_LIBRARY_GOAL A ,MR_TERM_SET  B ,MR_TERM_CODE C ,CP_OUTCOME_LANG_VW D,PR_DIAGNOSIS E  WHERE    A.LIBRARY_ID = ? AND A.VERSION_NO = ? AND A.TERM_SET_ID  = ? AND A.TERM_CODE  = ? AND  B.TERM_SET_ID=A.TERM_SET_ID AND C.TERM_SET_ID=A.TERM_SET_ID AND C.TERM_CODE=A.TERM_CODE AND D.OUTCOME_CODE=A.GOAL_CODE AND E.TERM_SET_ID=A.TERM_SET_ID AND E.TERM_CODE=A.TERM_CODE AND E.PATIENT_ID = ? AND E.CURR_STATUS = 'A' AND D.LANGUAGE_ID = ? ORDER BY E.CURR_PRIORITY,3 ";//60772

// start 60772
sql ="SELECT A.TERM_SET_ID ,B.TERM_SET_DESC ,A.TERM_CODE ,C.SHORT_DESC TERM_CODE_SHORT_DESC ,A.GOAL_CODE ,D.SHORT_DESC GOAL_SHORT_DESC ,A.GOAL_TARGET_DURN ,A.GOAL_TARGET_DURN_UNIT ,DECODE(A.GOAL_TARGET_DURN_UNIT,'D',TO_CHAR(SYSDATE+A.GOAL_TARGET_DURN,'DD/MM/YYYY HH24:MI'),'H',TO_CHAR(SYSDATE+A.GOAL_TARGET_DURN/24 , 'DD/MM/YYYY HH24:MI'),'M',TO_CHAR(SYSDATE+(A.GOAL_TARGET_DURN/(24*60)),'DD/MM/YYYY HH24:MI'),'L',TO_CHAR(ADD_MONTHS(SYSDATE,A.GOAL_TARGET_DURN) , 'DD/MM/YYYY HH24:MI'),'W',TO_CHAR(SYSDATE+A.GOAL_TARGET_DURN*7 , 'DD/MM/YYYY HH24:MI'),'')GOAL_TARGET_DATE,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI')GOAL_START_DATE, E.CURR_PRIORITY  FROM CP_LIBRARY_GOAL A ,MR_TERM_SET  B ,MR_TERM_CODE C ,CP_OUTCOME_LANG_VW D,PR_DIAGNOSIS E  WHERE    A.LIBRARY_ID = ? AND A.VERSION_NO = ? AND A.TERM_SET_ID  = ? AND A.TERM_CODE  = ? AND  B.TERM_SET_ID=A.TERM_SET_ID AND C.TERM_SET_ID=A.TERM_SET_ID AND C.TERM_CODE=A.TERM_CODE AND D.OUTCOME_CODE=A.GOAL_CODE AND E.TERM_SET_ID=A.TERM_SET_ID AND E.TERM_CODE=A.TERM_CODE AND E.PATIENT_ID = ? AND E.CURR_STATUS = 'A' AND D.LANGUAGE_ID = ? AND e.onset_encounter_id IN (";

	   for (int j = 0; j < encounterIds.length;j++)
	    {
		sql += "?, ";
		}
		sql = sql.substring(0, sql.length() - 2);
		sql += ") ORDER BY E.CURR_PRIORITY, 3";

		// end 60772	
		
//sql1 = "SELECT A.INTERVENTION_CODE ,B.SHORT_DESC INTERVENTION_SHORT_DESC ,A.GROUP_ID FROM CP_LIBRARY_INTERVENTION A ,  CA_INTERVENTION B WHERE A.LIBRARY_ID     = ? AND A.VERSION_NO     =? AND A.TERM_SET_ID    =? AND A.TERM_CODE      =?  AND A.GOAL_CODE     = ? AND B.INTERVENTION_CODE= A.INTERVENTION_CODE AND A.GROUP_ID = ?" ;
  sql1 = "SELECT A.INTERVENTION_CODE ,B.SHORT_DESC INTERVENTION_SHORT_DESC ,A.GROUP_ID FROM CP_LIBRARY_INTERVENTION A ,  CA_INTERVENTION_LANG_VW B WHERE A.LIBRARY_ID     = ? AND A.VERSION_NO     =? AND A.TERM_SET_ID    =? AND A.TERM_CODE      =?  AND A.GOAL_CODE     = ? AND B.INTERVENTION_CODE= A.INTERVENTION_CODE AND A.GROUP_ID = ? AND B.LANGUAGE_ID = ?" ;

//sql2="SELECT A.OUTCOME_CODE ,B.SHORT_DESC OUTCOME_SHORT_DESC ,A.GROUP_ID FROM CP_LIBRARY_OUTCOME A , CP_OUTCOME B WHERE A.LIBRARY_ID     = ? AND A.VERSION_NO     = ? AND A.TERM_SET_ID    = ? AND A.TERM_CODE       = ? AND A.GOAL_CODE      = ?  AND B.OUTCOME_CODE= A.OUTCOME_CODE AND A.GROUP_ID = ?  " ;
sql2="SELECT A.OUTCOME_CODE ,B.SHORT_DESC OUTCOME_SHORT_DESC ,A.GROUP_ID FROM CP_LIBRARY_OUTCOME A , CP_OUTCOME_LANG_VW B WHERE A.LIBRARY_ID     = ? AND A.VERSION_NO     = ? AND A.TERM_SET_ID    = ? AND A.TERM_CODE       = ? AND A.GOAL_CODE      = ?  AND B.OUTCOME_CODE= A.OUTCOME_CODE AND A.GROUP_ID = ? AND B.LANGUAGE_ID = ?  " ;

sql3 = "SELECT DISTINCT GROUP_ID FROM CP_LIBRARY_INTERVENTION A WHERE A.LIBRARY_ID     = ? AND A.VERSION_NO     = ? AND A.TERM_SET_ID    = ? AND A.TERM_CODE       = ? AND A.GOAL_CODE      = ? ";

StringBuffer goal_stmt		=	new StringBuffer();
String goal_st				=	"";
int i						=	0;
boolean goal_chk			=	false;
//boolean rep_flag			=	false;

if(!value_str.equals(""))
{
	String Library_id		=	"";
	int version_no			=	0;
	int i1					=   0;
	int	i2					=	0;
	String term_set_id		=	"";
	String term_code		=	"";
	String tmp_term_code	=	"";
	String tmp_term_code1	=	"";
	String goal_code		=	"";
	String checked			=	"checked";
	String checked1			=	"checked";
	String checked2			=	"checked";
	String values			=	"";
	String intervention_code=	"";
	String temp_code		=	"";
	String temp_intercode	=	"";
	String temp_outcode		=	"";
	String out_code			=	"";
	String selected_intvn	=	"";
	String tmp_target_date	=	"";
	String selected_intvn_value="";
	String temp_chk			=	"";
	String temp_inter_code	=	"";
	String tmp_hashval		=	"";
	String ex_selected_intvn=	"";
	String ex_selected_intvn_value= "";
	String patient_class	=	"";
	String target_date		=	"";
	String selected_dates	=	"";
/***********/
	String dstart_dt		=	"";
	String dtar_prd			=	"";
	String dtarget_dt		=	"";
	String gtarget_dt		=	"";
	String record4[]		=	null;
	String temp_prior		=	"";
/************/
	patient_class			=	bean.getPatientClass();
	HashMap select_intvn	=	null;
	HashMap selected_dts	=	null;
	String tmp_key			=	"";
	HashMap select_intvn1	=	new HashMap();
	HashMap select_intvn2	=	new HashMap();
	select_intvn			=	bean.getSelectedIntvn();
	selected_dts			=	bean.getDateValues();	
	int	ii					=	0;
	int gcnt				=	0;
	int incnt				=	0;
	int outcnt				=	0;
	//tmp_target_date = dateString;
	String record_termcd[]	=	null;
	StringTokenizer stk		=	new StringTokenizer(value_str,"~");
	//int cnt = stk.countTokens();
	while(stk.hasMoreTokens())
	{
		values					=	stk.nextToken();
		StringTokenizer stk1	=	new StringTokenizer(values,",");
		while(stk1.hasMoreTokens())
		{
			Library_id			=	stk1.nextToken();
			if(stk1.hasMoreTokens())
				version_no			=	Integer.parseInt(stk1.nextToken());
			if(sel_lib_ids.equals(""))
				sel_lib_ids="~"+Library_id+version_no+"~";
			else
				sel_lib_ids=sel_lib_ids+",~"+Library_id+version_no+"~";
			if(stk1.hasMoreTokens())
				term_set_id			=	stk1.nextToken();
			if(stk1.hasMoreTokens())
				term_code			=	stk1.nextToken();			
			StringTokenizer s_tk=	new StringTokenizer(term_code,"|");
			int cnt				=	s_tk.countTokens();
			record_termcd		=	new String[cnt];cnt=0;
			while(s_tk.hasMoreTokens())
			{
				record_termcd[cnt] = s_tk.nextToken();	
				cnt++;
			}
			/*term_code = replaceString(term_code,"|","','");
			int ind= term_code.lastIndexOf(",");
			term_code = term_code.substring(0,ind);
			term_code = "'"+term_code;
			//term_code = term_code.replace('|',',');*/
			
			ps = con.prepareStatement(sql);
			ps.setString(1,Library_id);
			ps.setInt(2, version_no);
			ps.setString(3, term_set_id);
			ps.setString(6, locale);
			// start 60772
		    for (int j = 0; j < encounterIds.length; j++) {
		        ps.setString(7 + j, encounterIds[j]);
		    }
		    // end 60772
		    
			ps1 = con.prepareStatement(sql1);
			ps2 = con.prepareStatement(sql2);
			ps3 = con.prepareStatement(sql3);

			for(int tmp=0;tmp<record_termcd.length;tmp++)
			{
				term_code= record_termcd[tmp];
				ps.setString(4, term_code);
				ps.setString(5, patient_id);
				//out.println("<script>alert('Library_id::"+Library_id+"-version_no::"+version_no+"-term_set_id-"+term_set_id+"--term_code--"+term_code+"-patient_id---"+patient_id+"---')</script>");
				try
				{
				rs = ps.executeQuery();
				}
				catch(Exception e)
				{
				 //out.println("sql    error here---------"+e.toString());//common-icn-0181
				e.printStackTrace();//COMMON-ICN-0181
				}

				while(rs.next())
				{
					intervention_code	=	"";
					out_code			=	"";
					//selected_intvn="";selected_intvn_value="";
					tmp_term_code		=	rs.getString(3);
					goal_code			=	rs.getString(5);
					//Set s=select_intvn.keySet();
					//Collection ccc = select_intvn.values();
					//	out.println("<script>alert('s::--"+s+"--ccc::"+ccc+"-')</script>");
					tmp_key				=	Library_id+","+version_no+","+term_set_id+","+term_code;					
					temp_inter_code		=	tmp_key+","+goal_code+",";
					temp_code			=	(String)select_intvn.get(temp_inter_code)== null?"":(String)select_intvn.get(temp_inter_code);
					//out.println("<script>alert('temp_code::"+temp_code+"-')</script>");	
					//out.println("<script>alert('temp_code::"+temp_code+"-ii-"+ii+"-i"+i+"-checked:-"+checked+"-')</script>");			
					if(select_intvn.containsKey(temp_inter_code))
					{
						//out.println("<script>alert('key exists-')</script>");
						chk_flag		=	true;
						tmp_hashval		=	(String)select_intvn.get(temp_inter_code);
						//out.println("<script>alert('tmp_hashval---"+tmp_hashval+"---')</script>");
						if(tmp_hashval!= null)
							goal_chk = false;	
						else
							goal_chk = true;

					}
					else
					{
						chk_flag = false;
						//out.println("<script>alert('key donot exists-')</script>");
					}
					//out.println("<script>alert('key goal_chk-"+goal_chk+"--')</script>");	
					if(chk_flag == false || goal_chk == false)
						checked = "checked";
					else
						checked = "";
					StringTokenizer stk2=	new StringTokenizer(temp_code,",");
					tmp_target_date		=	"";
					while(stk2.hasMoreTokens())
					{
						tmp_target_date		= com.ehis.util.DateUtils.convertDate(stk2.nextToken(),"DMYHM","en",locale);
						if(stk2.hasMoreTokens())
							temp_intercode		= stk2.nextToken();
						if(stk2.hasMoreTokens())
							temp_outcode		= stk2.nextToken();
						temp_outcode		= temp_outcode.substring(0,temp_outcode.length()-1);
						//out.println("<script>alert('temp_chk::"+tmp_target_date+"--')</script>");
					}
					StringTokenizer stk3	= new StringTokenizer(temp_intercode,"|");
					int cnt1				= stk3.countTokens();int j =0;
					//out.println("<script>alert('cnt::"+cnt1+"')</script>");
					String record1[]		= null ;
					record1					= new String[cnt1] ;
					while(stk3.hasMoreTokens())
					{
						record1[j]			= stk3.nextToken();
						record1[j]			= record1[j].substring(0,(record1[j].indexOf("*")));
						//out.println("<script>alert('record1::"+record1[j]+"-')</script>");
						j++;
					}	
					StringTokenizer stk4	= new StringTokenizer(temp_outcode,"|");
					int cnt2				= stk4.countTokens();
					int j1					= 0;
					//out.println("<script>alert('cnt::"+cnt1+"')</script>");
					String record2[]		= null;
					record2					= new String[cnt2];
					while(stk4.hasMoreTokens())
					{
						record2[j1]			= stk4.nextToken();
						record2[j1]			= record2[j1].substring(0,(record2[j1].indexOf("*")));
						j1++;
					}	
					//out.println("<script>alert('length::"+record2.length+"-')</script>");
						//out.println("<script>alert('goal_code::"+goal_code+"')</script>");	
					String record3[]		= null ;
					
					if(!tmp_term_code1.equals(tmp_term_code))
					{

						selected_dates		= (String)selected_dts.get(tmp_key);
					//out.println("<script>alert('s::--"+selected_dates+"---')</script>");
						if(selected_dates != null)
						{
							stk3			=	new StringTokenizer(selected_dates,",");
							int cnt3		=	stk3.countTokens();
							int k			=	0;
						//out.println("<script>alert('cnt::"+cnt3+"')</script>");
						
							record3			=	new String[cnt3] ;
							while(stk3.hasMoreTokens())
							{
								record3[k]	=	stk3.nextToken();
								//out.println("<script>alert('record3::"+record3[k]+"-')</script>");
								k++;
							}											
							dstart_dt	= com.ehis.util.DateUtils.convertDate(record3[0],"DMYHM","en",locale);
							dtar_prd	= record3[1];
							dtarget_dt	= com.ehis.util.DateUtils.convertDate(record3[2],"DMYHM","en",locale) ;

							stk3		= new StringTokenizer(record3[3],"$");
							cnt3		= stk3.countTokens();k =0;
							//out.println("<script>alert('cnt::"+cnt3+"')</script>");
						
							record4		= new String[cnt3] ;
							while(stk3.hasMoreTokens())
							{
								record4[k]= stk3.nextToken();
								//out.println("<script>alert('record3::"+record4[k]+"-')</script>");
								k++;
							}	
						}
						else
						{
							dstart_dt	= "";
							dtar_prd	= "";
							dtarget_dt	= "";
						}
						temp_prior		= rs.getString(11)==null?"":rs.getString(11);
						if(temp_prior.equals("C"))
						{
							classValue	= "PRIORCRIC";
							
						}
						else if(temp_prior.equals("H"))
						{
							classValue	= "PRIORHIGH";
							
						}
						else if(temp_prior.equals("N"))
						{
							classValue	= "PRIORNORM";
							
						}
						else if(temp_prior == "" )
						{
							classValue	= "";
							
						}
						//out.println("<script>alert('dtar_prd::"+dtar_prd+"-')</script>");	
				%>
						<tr>
							<td colspan='' class='CAGROUPHEADING' wrap width='2%' align='center'><font size="4" height='' class='<%=classValue%>'>&nbsp;&nbsp;</font></td>
							<td colspan='' class='CAGROUPHEADING' wrap width='35%'><!-- <font size="4" height='' class='<%=classValue%>'>&nbsp;&nbsp;</font>&nbsp;--> 
								<font size="1">
									<a href="#"  onClick='javascript:showDescription("<%=rs.getString(1)%>","<%=rs.getString(3)%>","<%=Library_id%>","<%=version_no%>","<%=patient_class%>")'><b><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/>:<%=rs.getString(4)%></b></a>
								</font>
							</td>
							<td class='CAGROUPHEADING' align='center'><font size="1"><b>&nbsp;<fmt:message key="Common.StartDate.label" bundle="${common_labels}"/>&nbsp;<input type="textbox" name='start_date<%=i%>' id='start_date<%=i%>' value='<%=dstart_dt==""?(rs.getString(10)==null?dateString:com.ehis.util.DateUtils.convertDate(rs.getString(10),"DMYHM","en",locale)):dstart_dt%>' size='14'onBlur='checkValidDateTime(this,locale);calcDiagTrgDate(<%=i%>,"");setDatesToBean();'><img src="../../eCommon/images/CommonCalendar.gif" onclick='return showCalendar("start_date<%=i%>",null,"hh:mm",true);' onBlur='callFocus("st_date","<%=i%>")' >&nbsp;
							<fmt:message key="Common.for.label" bundle="${common_labels}"/>&nbsp;<input type="textbox" name="target_pd<%=i%>" id="target_pd<%=i%>" value='<%=dtar_prd==""?rs.getString(7):dtar_prd%>' size='1'  maxlength='2' onBlur='CheckNum(this);calToDate(this,"<%=i%>","generate_summary");setDatesToBean()'><fmt:message key="Common.days.label" bundle="${common_labels}"/>&nbsp;
							<fmt:message key="eCP.TargetDate.label" bundle="${cp_labels}"/>&nbsp;<input type="textbox" name='target_date<%=i%>' id='target_date<%=i%>' value='<%=dtarget_dt%>' size='14' onBlur='checkValidDateTime(this);checkGRDate(start_date<%=i%>,this);setToDate("dtarget_date","<%=i%>","generate_summary");setDatesToBean()'><img src="../../eCommon/images/CommonCalendar.gif" onclick='return showCalendar("target_date<%=i%>",null,"hh:mm",true);'  onBlur='callFocus("trg_date","<%=i%>")'></font></td>
						</tr>
						
				<%	
						tmp_term_code1= tmp_term_code;
						if(!(dgroup_cnt ==0 && dgroup_count ==0))
						{	
							//out.println("<script>alert('dgroup_cnt::"+dgroup_cnt+"--i-"+i+"- dgroup_count-"+dgroup_count+"-')</script>");
				%>			
						<input type ='hidden' name='dgroup_cnt<%=dgroup_count%>' id='dgroup_cnt<%=dgroup_count%>' value='<%=dgroup_cnt%>'>	
				<%
						}
						dgroup_count=	i;
						//dgroup_count++;					
						dgroup_cnt	=	0;
					
					}
					tmp_st_date=com.ehis.util.DateUtils.convertDate(rs.getString(10),"DMYHM","en",locale);
					target_date=(rs.getString(9)==null?dateString:com.ehis.util.DateUtils.convertDate(rs.getString(9),"DMYHM","en",locale));
					tmp_target_date=(tmp_target_date==""?target_date:tmp_target_date);
					//out.println("<script>alert('dgroup_cnt::"+dgroup_cnt+"--i-"+i+"- dgroup_count-"+dgroup_count+"-')</script>");
					if(selected_dates !=null)
					{						
						gtarget_dt = com.ehis.util.DateUtils.convertDate(record4[dgroup_cnt],"DMYHM","en",locale);
						//out.println("<script>alert('gtarget_dt::"+gtarget_dt+"---')</script>");
					}
					//out.println("<script>alert('gtarget_dt::"+gtarget_dt+"--tmp_target_date-"+tmp_target_date+"---')</script>");
					%>

					<input type ='hidden' name='library_id<%=i%>' id='library_id<%=i%>' value='<%=Library_id%>'>
					<input type ='hidden' name='version_no<%=i%>' id='version_no<%=i%>' value='<%=version_no%>'>
					<input type ='hidden' name='term_set_id<%=i%>' id='term_set_id<%=i%>' value='<%=term_set_id%>'>
					<input type ='hidden' name='term_code<%=i%>' id='term_code<%=i%>' value='<%=tmp_term_code%>'>	
					<tr>
						<td class='GRPNONE' colspan='3'>
							<table cellpadding=0 cellspacing=0 border=0 width="95%" align=center >
							<tr><%goal_stmt.append(rs.getString(6));goal_stmt.append("\n");
							goal_st = goal_st +rs.getString(6)+" ";
							%>
								<td class='GRPNONE' align='left' width='60%'><input type="checkbox" name="chk_goal<%=i%>" id="chk_goal<%=i%>" onClick="chkValid(<%=i%>)" <%=checked%>><font size="1"><b><fmt:message key="eCP.Goal.label" bundle="${cp_labels}"/> :&nbsp;<%=rs.getString(6)%></b></font></td>
								<td class='GRPNONE' align='right' width='40%'><font size="1"><b>&nbsp;<fmt:message key="eCP.TargetDate.label" bundle="${cp_labels}"/>&nbsp;</b></font><input type="text" name="dtarget_date<%=i%>" id="dtarget_date<%=i%>" value='<%=gtarget_dt==""?tmp_target_date:gtarget_dt%>' size='15' onBlur='checkValidDateTime(this);CalDiagnosisTargDt(<%=i%>);'><img src="../../eCommon/images/CommonCalendar.gif" onclick='return showCalendar("dtarget_date<%=i%>",null,"hh:mm",true);' onBlur='callFocus("dtarget_date","<%=i%>")'></td>
							</tr>
							<input type ='hidden' name='goal<%=i%>' id='goal<%=i%>' value='<%=rs.getString(5)%>'>
							<input type ='hidden' name='tar_prd<%=i%>' id='tar_prd<%=i%>' value='<%=rs.getString(7)==null?"0":rs.getString(7)%>'>	
							<input type ='hidden' name='tar_prd_unt<%=i%>' id='tar_prd_unt<%=i%>' value='<%=rs.getString(8)==null?"":rs.getString(8)%>'>		
							<input type ='hidden' name='gl_tar_dt<%=i%>' id='gl_tar_dt<%=i%>' value='<%=gtarget_dt==""?tmp_target_date:gtarget_dt%>'>		
							</table>
						</td>
								
					</tr>
					<tr>
						<td colspan='3' class='GRPNONE' >
							<table cellpadding=0 cellspacing=0 border=0 width="85%" align=center bgcolor=''>
							<tr>
								<td width='50%' valign='top' >	
									<table cellpadding=0 cellspacing=0 border=0 width="100%" align=center >
									<tr>
										<td align='left'class='GRPINTERHEAD' width='50%'>
											<font size="1"><B><fmt:message key="eCP.Interventions.label" bundle="${cp_labels}"/></B> 
													<a href='#'  onclick='javascript:addInterventions("<%=rs.getString(3)%>","<%=rs.getString(5)%>","<%=Library_id%>","<%=version_no%>","<%=term_set_id%>","<%=term_code%>","<%=gtarget_dt==""?tmp_target_date:gtarget_dt%>");' ><fmt:message key="Common.Add.label" bundle="${common_labels}"/>
													</a>
											</font>
										</td>
										<td align='left'class='GRPINTERHEAD' width='50%'>
											<font size="1"><B><fmt:message key="eCP.ExpectedOutcome.label" bundle="${cp_labels}"/></B>
											</font>
										</td>
									</tr>
									<%i1=0;i2=0;gcnt=0;																				
									ps3.setString(1,Library_id);
									ps3.setInt(2, version_no);
									ps3.setString(3, term_set_id);
									ps3.setString(4, term_code);
									ps3.setString(5, goal_code);
									//out.println("<script>alert('Library_id::"+Library_id+"-version_no::"+version_no+"-term_set_id-"+term_set_id+"--term_code--"+term_code+"-goal_code---"+goal_code+"---')</script>");
									try
									{
										rs3 = ps3.executeQuery();
									}
									catch(Exception e)
									{
										//out.println("sql  111111  error here---------"+e.toString());//common-icn-0181
								               e.printStackTrace();//COMMON-ICN-0181
									}
									while(rs3.next())
									{	
										group_id = rs3.getInt(1);									
										//out.println("<script>alert('group_id::"+i+"--')</script>");
										if ( gcnt % 2 == 0 )
											classValue = "GRPEVEN" ;
										else
											classValue = "GRPOD" ;
									%>
									<tr>
										<td valign='top' class='<%=classValue%>'>
										<table cellpadding=0 cellspacing=0 border=0 width="100%" align=center >
										<%
									
											ps1.setString(1,Library_id);
											ps1.setInt(2, version_no);
											ps1.setString(3, term_set_id);
											ps1.setString(4, term_code);
											ps1.setString(5, goal_code);
											ps1.setInt(6, group_id);
											ps1.setString(7, locale);
											//out.println("<script>alert('Library_id::"+Library_id+"-version_no::"+version_no+"-term_set_id-"+term_set_id+"--term_code--"+term_code+"-goal_code---"+goal_code+"-group_id--"+group_id+"--')</script>");
											try
											{
												rs1 = ps1.executeQuery();}catch(Exception e){
												out.println("sql  3333333  error here---------"+e.toString());
											}
											incnt=0;
											//i1=0;
											temp_chk = "";	
											//out.println("<script>alert('first_time::"+first_time+"--')</script>");
											while(rs1.next())
											{
												/*if ( i1 % 2 == 0 )
													classValue = "QRYEVEN" ;
												else
													classValue = "QRYODD" ;*/
										
												if(chk_flag == false)
													checked1 = "checked";
												else
												{
													for(int c=0;c<record1.length;c++)
													{
														temp_chk = rs1.getString(1);
														if(temp_chk.equals(record1[c]))
														{
															checked1 = "checked";
															break;
														}
														else
															checked1 = "";
													}														
													if(record1.length == 0 || goal_chk == true)
															checked1 = "";
													/*if(temp_chk.equals(rs1.getString(1)) && !temp_chk.equals(""))
														checked1 = "checked";
													else
														checked1 = "";*/
												}
												//out.println("<script>alert('temp_chk::"+temp_chk+"-rs1.getString(1)--"+rs1.getString(1)+"-checked1-"+checked1+"-')</script>");						
									%>
												<tr>
													<td class='<%=classValue%>' align='center'  width='5%'>
													<input type="checkbox" name="chk_inter<%=i1%><%=i%>" id="chk_inter<%=i1%><%=i%>" onClick='chkValidate("Inter",<%=i1%>,<%=i%>)' <%=checked1%>>
													</td >
													<td class='<%=classValue%>' align='left' wrap>
													<font size="1"><%=rs1.getString(2)==null?"&nbsp;":rs1.getString(2)%></font>
													</td >
												</tr>	
												<input type ='hidden' name='inter_code<%=i1%><%=i%>' id='inter_code<%=i1%><%=i%>' value='<%=rs1.getString(1)%>'>	
												<input type ='hidden' name='int_group_id<%=i1%><%=i%>' id='int_group_id<%=i1%><%=i%>' value='<%=group_id%>'>	
									<%	
												i1++;incnt++;
												intervention_code =intervention_code +rs1.getString(1)+"*"+group_id+"|";	
										
											}
											//	out.println("<script>alert('"+gcnt+"-i-"+i+"-incnt-"+incnt+"-i1-"+i1+"--')</script>");
									%>					
											<input type ='hidden' name='gint_cnt<%=gcnt%><%=i%>' id='gint_cnt<%=gcnt%><%=i%>' value='<%=incnt%>'>	
											</table>
										</td>
										<td valign='top' class='<%=classValue%>'>
										<table cellpadding=0 cellspacing=0 border=0 width="100%" align=center>
									<%
									
										ps2.setString(1,Library_id);
										ps2.setInt(2, version_no);
										ps2.setString(3, term_set_id);
										ps2.setString(4, term_code);
										ps2.setString(5, goal_code);
										ps2.setInt(6, group_id);
										ps2.setString(7, locale);
										rs2		=	ps2.executeQuery();
										outcnt	=	0;
									//	i1		=	0;
									
										temp_chk =	"";	
										while(rs2.next())
										{	

												if(chk_flag == false)
													checked2 = "checked";
												else
												{
												//	if(goal_chk == false){
													for(int c=0;c<record2.length;c++)
													{
														temp_chk = rs2.getString(1);
														if(temp_chk.equals(record2[c]))
														{
															checked2 = "checked";
															break;
														}
														else
															checked2 = "";
													}
													//}else
													//	checked2 = "";
													if(record2.length == 0 || goal_chk == true)
														checked2 = "";
												}										
												//out.println("<script>alert('temp_chk::"+temp_chk+"-rs1.getString(1)--"+rs1.getString(1)+"-checked1-"+checked1+"-')</script>");						
											%>
											<tr>
												<td class='<%=classValue%>' align='center' width='5%'><input type="checkbox" name="chk_outcome<%=i2%><%=i%>" id="chk_outcome<%=i2%><%=i%>" onClick='chkValidate("Outer",<%=i2%>,<%=i%>)' <%=checked2%>>
												</td >
												<td class='<%=classValue%>' align='left' wrap><font size="1"><%=rs2.getString(2)==null?"&nbsp;":rs2.getString(2)%></font>
												</td >																								
											</tr>
											<input type ='hidden' name='outcome_code<%=i2%><%=i%>' id='outcome_code<%=i2%><%=i%>' value='<%=rs2.getString(1)%>'>	
											<input type ='hidden' name='out_group_id<%=i2%><%=i%>' id='out_group_id<%=i2%><%=i%>' value='<%=group_id%>'>	
											<%	
											i2++;outcnt++;
											out_code = out_code +rs2.getString(1)+"*"+group_id+"|";	
										 }
											%>
										<input type ='hidden' name='gout_cnt<%=gcnt%><%=i%>' id='gout_cnt<%=gcnt%><%=i%>' value='<%=outcnt%>'>	
										</table>
										</td>
										</tr>
											
							<%
										gcnt++;
									}	
							%>							
									<input type ='hidden' name='gcnt<%=i%>' id='gcnt<%=i%>' value='<%=gcnt%>'>	
									<input type ='hidden' name='inter_cnt<%=i%>' id='inter_cnt<%=i%>' value='<%=i1%>'>	
									<input type ='hidden' name='outcome_cnt<%=i%>' id='outcome_cnt<%=i%>' value='<%=i2%>'>	
									</table>
								</td>
							 </tr>	
							 </table>													
						</td>
					</tr>
					<tr>
						<td class='GRPNONE' align='center'>&nbsp;</td>
						<td class='GRPNONE'  align='center'>&nbsp;</td>
						<td class='GRPNONE'  align='center'>&nbsp;</td>
					</tr>

				<%
					i++;dgroup_cnt++;
					selected_intvn = Library_id+","+version_no+","+term_set_id+","+term_code+","+goal_code+",";
						//out.println("<script>alert('intervention_code---"+intervention_code+"---out_code--"+out_code+"--')</script>");
					if(intervention_code.equals(""))
						intervention_code = " *";
					if(out_code.equals(""))
						out_code = " *";
					selected_intvn_value = (gtarget_dt==""?tmp_target_date:gtarget_dt)+","+intervention_code+","+out_code+"~";

					if(select_intvn.containsKey(selected_intvn))
					{
							//out.println("<script>alert('key exists-')</script>");
						ex_selected_intvn=selected_intvn;
						ex_selected_intvn_value=(String)select_intvn.get(ex_selected_intvn);
				//out.println("<script>alert('ex_selected_intvn_value--"+ex_selected_intvn_value+"-ex_selected_intvn-"+ex_selected_intvn+"-')</script>");
						select_intvn2.put(ex_selected_intvn,ex_selected_intvn_value);
							
					}
					else
					{
						//rep_flag= true;
						//out.println("<script>alert('key doesnot exists-')</script>");
						select_intvn1.put(selected_intvn,selected_intvn_value);
					}
				}
			}
			//	out.println("<script>alert('dgroup_cnt::"+dgroup_cnt+"--i-"+i+"- dgroup_count-"+dgroup_count+"-')</script>");
			//out.println("<script>alert('"+bean.getSelectedIntvn()+"')</script>");			
		}
		//out.println("<script>alert('i::"+i+"')</script>");
		ii = i;
		//out.println("<script>alert('ii::"+ii+"')</script>");				
	}
	//	out.println("<script>alert(' bean.getSelectedIntvn()-----"+ bean.getSelectedIntvn()+"------')</script>");
	if(first_time != ii)
	{
		if(first_time > ii)
		{
			bean.setSelectedIntvn(select_intvn2);
		}
		else
		{
			select_intvn.putAll(select_intvn1);
			bean.setSelectedIntvn(select_intvn);
		}
		bean.setPageFirst(ii);
		//out.println("<script>alert(' bean.getSelectedIntvn()-----"+ bean.getSelectedIntvn()+"------')</script>");
		//	bean.setGoalStmt(goal_stmt.toString());
		bean.setGoalStmt(goal_st);
		//out.println("<script>alert(\"goal_stmt::escape("+bean.getGoalStmt()+")\")</script>");		
		//	out.println("<script>alert('iin the set fun')</script>");
		
	}
	
	//	if((first_time == ii || first_time < ii) && rep_flag== true){
	//	bean.setSelectedIntvn(select_intvn1);	out.println("<script>alert('first_time-"+first_time+"---ii::"+ii+"-rep_flag-"+rep_flag+"-')</script>");
	//	}

}
//if(i ==0 || value_str.equals(""))  //60772
	if((i ==0 || value_str.equals("")) && !obj.equals("summary"))  //60772
	out.println("<script>alert(getMessage('NO_RECORD_FOUND','CP'));</script>");

//dgroup_count=i;
//out.println("<script>alert('dgroup_cnt:111:"+dgroup_cnt+"--i-"+i+"- dgroup_count-"+dgroup_count+"-')</script>");
//out.println("<script>alert(\"goal_stmt::escape("+goal_stmt.toString()+")\")</script>");		
%>
<input type ='hidden' name='dgroup_cnt<%=dgroup_count%>' id='dgroup_cnt<%=dgroup_count%>' value='<%=i%>'>	
<input type ='hidden' name='dgroup_count' id='dgroup_count' value='<%=dgroup_count%>'>
<input type ='hidden' name='i' id='i' value='<%=i%>'>	
<input type ='hidden' name='goal_st' id='goal_st' value='<%=goal_st%>'>	
<input type ='hidden' name='goal_stmt' id='goal_stmt' value='<%=goal_stmt%>'>
<input type ='hidden' name='value_str' id='value_str' value='<%=value_str%>'>
<input type ='hidden' name='finalStr' id='finalStr' value='<%=request.getQueryString()%>'>
<input type ='hidden' name='st_date' id='st_date' value='<%=tmp_st_date%>'>
<input type ='hidden' name='sel_lib_ids' id='sel_lib_ids' value="<%=sel_lib_ids%>">
<input type ='hidden' name='locale' id='locale' value="<%=locale%>">
</table>
<%
}
catch(Exception ee)
{
	//out.println("Exception while populating the values for summary------- "+ee.toString());//common-icn-0181
	System.out.println("Exception while populating the values for summary "+ee.toString());
	ee.printStackTrace();
}
finally
{
	try
	{
			if(rs != null) rs.close();if(rs1 != null) rs1.close();if(rs2 != null) rs2.close();
			if(rs3 != null) rs3.close();
			if(ps3 != null) ps3.close();
			if(ps1 != null) ps1.close();
			if(ps2 != null) ps2.close();
			if(ps != null) ps.close();
			if(con != null) ConnectionManager.returnConnection(con);
	}
	catch(Exception e)
	{
		out.println(e);
		System.out.println("Exception while populating the values for summary "+e.toString());
		e.printStackTrace();
	}
}
%>

</form>
<script >
//alert(document.generate_summary.goal_stmt.value);
try
{
	parent.parent.GeneratePlanManager.document.care_planmanager.goal_statement.value = document.generate_summary.goal_stmt.value;
}
catch(e){}
if("<%=bean.getPlanStart()%>" != "")
{	
<%
		String tstdt=com.ehis.util.DateUtils.convertDate(bean.getPlanStart(),"DMYHM","en",locale);
		String teddt=com.ehis.util.DateUtils.convertDate(bean.getPlanEnd(),"DMYHM","en",locale);
%>
		parent.parent.GeneratePlanManager.document.care_planmanager.start_date.value = "<%=tstdt%>";
		parent.parent.GeneratePlanManager.document.care_planmanager.target_date.value = "<%=teddt%>";

		//parent.parent.GeneratePlanManager.document.care_planmanager.target_value.focus();
}
else
{
		parent.parent.GeneratePlanManager.document.care_planmanager.start_date.value = document.generate_summary.st_date.value;
}

parent.parent.GeneratePlanManager.document.care_planmanager.start_date.focus();
parent.parent.GeneratePlanManager.document.care_planmanager.goal_statement.focus();
//eval("document.generate_summary.chk_goal"+0).focus();
//alert("<%=bean.getPlanStart()%>")
//alert(document.generate_summary.i.value)
calculatePlanDiagTargetDate("generate_summary");
setDatesToBean();
</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>


		
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

