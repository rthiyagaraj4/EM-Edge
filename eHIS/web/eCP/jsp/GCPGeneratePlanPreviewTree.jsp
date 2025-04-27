<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*,eCommon.Common.*,java.sql.*, java.io.*, webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link><link rel="stylesheet" type="text/css" href="../../eCP/html/GCPGeneratePlanMenu.css"></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../js/GCPGeneratePlanMenu.js"></script>
<script language="JavaScript" src="../js/GCPGenerateCarePlan.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

  	
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%


//Initialize Function specific start 

 String Library = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.LibraryDetails.label","cp_labels");//"Library Details";
String lib_short_desc = request.getParameter("lib_short_desc") == null ? "" : request.getParameter("lib_short_desc");
String library_code = request.getParameter("library_code") == null ? "" : request.getParameter("library_code");
String version_no = request.getParameter("version_no") == null ? "" : request.getParameter("version_no");
String termcode_id = request.getParameter("termcode_id") == null ? "" : request.getParameter("termcode_id");
String libdetailvalue = request.getParameter("libdetailvalue") == null ? "" : request.getParameter("libdetailvalue");
String value_str = request.getParameter("value_str") == null ? "" : request.getParameter("value_str");
String record[] =null ;
String record1[] =null ;
int  i= 0,tmp=0;
//out.println("<script>alert('libdetailvalue:::"+libdetailvalue+"---')</script>");

if(libdetailvalue !="" || libdetailvalue!= null)
{
	StringTokenizer stk		= new StringTokenizer(libdetailvalue,"~");
	int cnt=stk.countTokens();int j=0;
	record = new String[cnt] ;
	while(stk.hasMoreTokens()){
		record[j]  = stk.nextToken();
		j++;
	}
}
if(value_str !="" || value_str!= null)
{
	StringTokenizer stk1		= new StringTokenizer(value_str,",");
	int cnt=stk1.countTokens();int j=0;
	record1 = new String[cnt] ;
	while(stk1.hasMoreTokens()){
		record1[j]  = stk1.nextToken();
		j++;
	}
}
//out.println("<script>alert('record1[]:::"+record1.length+"')</script>");

String executable_name		= "../../eCP/jsp/GCPGeneratePlanPreviewDtl.jsp?"+request.getQueryString();
String workAreaFrame		= "GeneratePlanPreviewRight";
String query_executable_name= "";

Connection con = null;
PreparedStatement ps = null;
ResultSet rs = null;
String sql = ""  ;
String termset="",termset1="";
String termcode="",termcode1="",intervention="";
String icon = "";
String folopen="";
String folclose="";
%>
<input type='hidden' name='folopen' id='folopen' value='<%=folopen%>' >
<%
try
{    
	
	con = ConnectionManager.getConnection(request);
	sql = "SELECT a.LIBRARY_ID,a.VERSION_NO ,a.TERM_SET_ID ,b.Term_Set_Desc Term_Set_Description ,a.TERM_CODE ,c.Short_desc Term_Code_Description ,c.Short_desc Term_Code_Description,a.OUTCOME_CODE ,F.Short_desc Outcome_Description,a.INTERVENTION_CODE ,a.INTERVENTION_TYPE ,a.SEQ_NO  ,a.REL_START_PERIOD,a.REL_START_PERIOD_UNIT,a.FREQ_CODE ,a.FREQ_DURN,a.FREQ_DURN_UNIT ,a.DEPENDENCY_LEVEL ,a.ALT_INTERVENTION_CODE ,a.STAGE_CODE ,a.ACCURACY_INDICATOR,Decode(a.REL_START_PERIOD_UNIT,'D',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0),'dd/mm/yyyy hh24:mi'),'M',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)/1440,'dd/mm/yyyy hh24:mi'),'H',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)/24,'dd/mm/yyyy hh24:mi'),'W',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)*7,'dd/mm/yyyy hh24:mi'),'L',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)*30,'dd/mm/yyyy hh24:mi'),To_Char(SYSDATE,'DD/MM/YYYY HH24:MI'))  Start_Date_Time,to_char(to_date(Decode(a.REL_START_PERIOD_UNIT,'D',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0),'dd/mm/yyyy hh24:mi'),                               'M',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)/1440,'dd/mm/yyyy hh24:mi'),			       'H',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)/24,'dd/mm/yyyy hh24:mi'),			       'W',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)*7,'dd/mm/yyyy hh24:mi'),        			       'L',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)*30,'dd/mm/yyyy hh24:mi'),			       To_Char(SYSDATE,'DD/MM/YYYY HH24:MI')),'DD/MM/YYYY hh24:mi')  + (Decode(a.FREQ_DURN_UNIT,'D',a.FREQ_DURN,'H',a.FREQ_DURN/24,'M',a.FREQ_DURN/1440,'W',a.FREQ_DURN*7,'L',a.FREQ_DURN *30)),'DD/MM/YYYY HH24:MI') End_Date_Time ,'<font color=black><b>' || D.Short_Desc ||'</b></font>' || '  Frequency : ' || E.Freq_Desc || ' For '  || a.Freq_Durn || ' ' || g.durn_desc || ' Start Date : ' || Decode(a.REL_START_PERIOD_UNIT,'D',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0),'dd/mm/yyyy hh24:mi'),                               'M',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)/1440,'dd/mm/yyyy hh24:mi'),			       'H',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)/24,'dd/mm/yyyy hh24:mi'),			       'W',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)*7,'dd/mm/yyyy hh24:mi'),        			       'L',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)*30,'dd/mm/yyyy hh24:mi'),			       To_Char(SYSDATE,'DD/MM/YYYY HH24:MI'))   ||  ' End Date :' || to_char(to_date(Decode(a.REL_START_PERIOD_UNIT,'D',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0),'dd/mm/yyyy hh24:mi'),                               'M',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)/1440,'dd/mm/yyyy hh24:mi'),			       'H',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)/24,'dd/mm/yyyy hh24:mi'),			       'W',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)*7,'dd/mm/yyyy hh24:mi'),        			       'L',TO_CHAR(SYSDATE + NVL(a.REL_START_PERIOD,0)*30,'dd/mm/yyyy hh24:mi'),			       To_Char(SYSDATE,'DD/MM/YYYY HH24:MI')),'DD/MM/YYYY hh24:mi')  + 			       (Decode(a.FREQ_DURN_UNIT,'D',a.FREQ_DURN,'H',a.FREQ_DURN/24,'M',a.FREQ_DURN/1440,'W',a.FREQ_DURN*7,'L',a.FREQ_DURN *30)),'DD/MM/YYYY HH24:MI')     Build_Diagonis_Intervention,to_char(decode(OUTCOME_TARGET_DURN_UNIT,'D',sysdate+OUTCOME_TARGET_DURN,'H',sysdate+(OUTCOME_TARGET_DURN/24),				'M',sysdate+(OUTCOME_TARGET_DURN/1440),'W',sysdate+(OUTCOME_TARGET_DURN*7),				'L', sysdate+(OUTCOME_TARGET_DURN*30)),'dd/mm/yyyy hh24:mi') OutCome_Target_Date,Decode(a.FREQ_DURN_UNIT,'D','Days','H','Hours','M','Minutes','L','Months','W','Weeks','') Freq_legend,D.Short_Desc Intervention_Desc FROM	CP_INTERVENTION_FOR_OUTCOME A,MR_TERM_SET B,MR_TERM_CODE C,	CA_INTERVENTION D,AM_FREQUENCY E,CP_OUTCOME F,AM_DURATION_TYPE G, CP_OUTCOME_FOR_TERM_CODE H WHERE a.LIBRARY_ID = ? AND a.VERSION_NO = ? and   a.term_set_id = b.term_Set_id and   a.term_set_id = c.term_set_id and   a.term_code   = c.term_code and   a.term_set_id = h.term_set_id and   a.term_code   = h.term_code and   a.library_id = H.LIBRARY_ID and   a.version_no = h.VERSION_NO and   a.outcome_code = H.outcome_code and   a.intervention_code = d.intervention_Code and   a.intervention_type = 'I' and   a.freq_code = e.freq_Code (+) and   a.freq_durn_Unit = g.durn_type (+) and   a.outcome_Code = f.outcome_code  Order by a.TERM_SET_ID,a.TERM_CODE,a.outcome_code,a.SEQ_NO";
	
			
	ps = con.prepareStatement(sql);
	ps.setString(1,library_code.trim());
	ps.setString(2,version_no.trim());
//	ps.setString(1,"CAREPLAN_TEST");
//	ps.setString(2,"1");
	rs = ps.executeQuery();
				

	//out.println("<script>alert('z::"+z+",rs.getString(27)::"+rs.getString(27)+"')</script>");
		
%>
<FORM METHOD=POST ACTION="" name="previewTreeMenu" id="previewTreeMenu">
<script>
	var obj;
	obj = new dTree('obj');
	obj.add(0,-1,'<font size=1 style=font-weight:bold style=color:#333><a href="#" onClick="showHistoryResults()" ><%=Library%></a></font>');
	obj.config.useStatusText=true;
<%  	
	while(rs.next())
	{%>	 // 		alert("i--<%=i %>--rs.getString(27) -<%=rs.getString(27) %>");<%
		query_executable_name		= executable_name+"&lib_short_desc="+lib_short_desc+"&library_code="+library_code+"&version_no="+version_no;
%>	  		//alert("termcode--<%=rs.getString(5) %>-i----<%=i%>---termcode_id---<%=termcode_id%>--");
		obj.add("<%=lib_short_desc%>1","0","<%=lib_short_desc%>","<%=query_executable_name%>","<%=lib_short_desc%>","<%=workAreaFrame%>","","","","");
		
<%		termset = rs.getString(3);
		if(!termset.equals(termset1)){
%>	
			obj.add("<%=rs.getString(4)%>1","<%=lib_short_desc%>1","<%=rs.getString(4)%>","<%=query_executable_name%>","<%=rs.getString(4)%>","<%=workAreaFrame%>","","","","");
<%			
			termset1=termset;
		}
		termcode = rs.getString(5);
		if(tmp<record.length){
			termcode_id=record[tmp];
			if(!termcode_id.equals(termcode)){
				folopen		="../../eOR/images/Delete.GIF";
				icon		="../../eOR/images/Delete.GIF";
				folclose	="../../eOR/images/Delete.GIF";
			}else{
				folopen		="../../eCA/images/folderopen.gif";
				folclose	="../../eCA/images/folder.gif";
				//icon		="../../eOR/images/outcome.gif";
				icon		="../../eOR/images/accept.gif";
				tmp++;
			}
		}else{
			folopen		="../../eOR/images/Delete.GIF";
			icon		="../../eOR/images/Delete.GIF";
			folclose	="../../eOR/images/Delete.GIF";
		}
	/*	}else{
			folopen		="../../eOR/images/Delete.GIF";
			icon		="../../eOR/images/Delete.GIF";
			folclose	="../../eOR/images/Delete.GIF";
		}*/
			
		if(!termcode.equals(termcode1)){%>	
			
			obj.add("<%=rs.getString(6)%>1","<%=rs.getString(4)%>1","<%=rs.getString(6)%>","<%=query_executable_name%>","<%=rs.getString(6)%>","<%=workAreaFrame%>","<%=folclose%>","<%=folopen%>","<%=icon%>","");

<%			termcode1=termcode;	
			intervention=rs.getString(9)+i;
			
%>			
			//obj.add("<%=rs.getString(9)%>1","<%=rs.getString(6)%>1","<%=rs.getString(9)%>","<%=query_executable_name%>","<%=rs.getString(9)%>","<%=workAreaFrame%>","<%=icon%>","<%=folopen%>","","");
			obj.add("<%=intervention%>1","<%=rs.getString(6)%>1","<%=rs.getString(9)%>","<%=query_executable_name%>","<%=rs.getString(9)%>","<%=workAreaFrame%>","<%=folclose%>","<%=folopen%>","","");

<%		}		
		if(record1[i].equals("Y"))
			icon="../../eOR/images/accept.bmp";
		else
			icon="../../eOR/images/Delete.GIF";
%>
		obj.add("<%=rs.getString(27)%>1","<%=intervention%>1","<%=rs.getString(27)%>","<%=query_executable_name%>","<%=rs.getString(27)%>","<%=workAreaFrame%>","<%=icon%>","","",""); 
	
<%		i++;	
	}// End of (result set)

 %>
</script>
	<input type="hidden" name="txtNodePoistions" id="txtNodePoistions" value="<%=i%>">
 	<input type="hidden" name="txtCurrentPosition" id="txtCurrentPosition" value="">
	<input type="hidden" name="txtToolTips" id="txtToolTips" value="">
	<input type="hidden" name="query_string" id="query_string" value="<%=request.getQueryString()%>">
	<script>
		document.write(obj);
		obj.openAll();
   	//	parent.GeneratePlanPreviewRight.location.href="<%=executable_name%>";
  	</script>

 </form>
<%	
		
}
catch(Exception ee)
{
//	out.println("Exception in Generate Preview Tree "+ee.toString());//COMMON-ICN-0181
     ee.printStackTrace();//COMMON-ICN-0181
}
finally
{
	try{
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(con != null) ConnectionManager.returnConnection(con);
	}
	catch(Exception e){
		//out.println(e);//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
}

%>

</body>
</html>

