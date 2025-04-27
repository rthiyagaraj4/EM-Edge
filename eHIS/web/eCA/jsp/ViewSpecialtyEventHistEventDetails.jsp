<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
%>

<html>
<title><fmt:message key="eCA.ViewSpecialtyEventHistory.label" bundle="${ca_labels}"/></title>
<head> 
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link> 	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language='javascript' src='../../eCA/js/ViewSpecialtyEventHist.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<style>
 A:link
{
    COLOR: yellow
}
A:visited
{
    COLOR: yellow
} 
</style>

</head>
<BODY class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()"  onScroll='scrollFrame()' onResize='alignDivs()'>
<%
String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
String module_id = request.getParameter("module_id")==null?"":request.getParameter("module_id");
String cycle_no = request.getParameter("cycle_no")==null?"":request.getParameter("cycle_no");
String disc_desc="";
String result_num_uom="";
String disc_id="";
String strTempDt="";
String discr_msr_id="";
String result_type="";
String RESULT_NUM="";
String RESULT_STR="";
String RESULT_DATA="";
String EVENT_CODE="";
String ACCESSION_NUM="";
String tempOnMouseOver = "";
String toolTip = "";
String dateForGraph = "";
String hiddenDateForGraph = "";
boolean image=false;
String classValue="";
ArrayList dateList = new ArrayList();
String to_date=request.getParameter("to_date");
String from_date=request.getParameter("from_date");
LinkedHashMap temp_hashmap			= new LinkedHashMap();
StringBuffer displaydata = new StringBuffer();
StringBuffer datefields = new StringBuffer();
Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
try
	{
		con = ConnectionManager.getConnection(request);
//		pstmt = con.prepareStatement("SELECT DISTINCT TO_CHAR(trans_date,'dd/mm/yyyy hh24:mi') trans_date FROM CA_SPLTY_DISCR_MSR WHERE  patient_id="+"'"+patient_id+"'"+" AND module_id="+"'"+module_id+"'"+" AND cycle_no="+cycle_no+" AND trans_date>=TO_DATE("+"'"+from_date+"'"+",'dd/mm/yyyy HH24:MI') AND trans_date<=TO_DATE("+"'"+to_date+"'"+",'dd/mm/yyyy HH24:MI') ORDER BY TO_DATE(trans_date,'dd/mm/yyyy hh24:mi') desc");
		pstmt = con.prepareStatement("SELECT DISTINCT TO_CHAR(trans_date,'dd/mm/yyyy hh24:mi:ss') trans_date FROM CA_SPLTY_DISCR_MSR WHERE  patient_id=? AND module_id=? AND cycle_no=? and TASK_CODE=? AND trans_date between TO_DATE(?,'dd/mm/yyyy HH24:MI:ss') AND  TO_DATE(?,'dd/mm/yyyy HH24:MI:ss')  ORDER BY TO_DATE(trans_date,'dd/mm/yyyy hh24:mi:ss') desc");

		try
		{
			pstmt.setString(1,patient_id);
			pstmt.setString(2,module_id);
			pstmt.setString(3,cycle_no);
			pstmt.setString(4,"MCT002");
			pstmt.setString(5,from_date);
			pstmt.setString(6,to_date);

			rs = pstmt.executeQuery();
			while (rs.next())
			{
				strTempDt = rs.getString(1);


				datefields.append(com.ehis.util.DateUtils.convertDate(strTempDt,"DMYHMS","en",locale)+"$$");
				dateList.add(strTempDt);
			}
		}
		catch (Exception ee1)
		{
			//out.println(ee1);//COMMON-ICN-0181
			ee1.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
			//if(rs != null) rs.close();
			//if(pstmt != null) pstmt.close();
		}
	}
	catch(Exception e)
	{
		//out.println(e);//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
	}

	
%>
<form name='dataForm' id='dataForm'>
		<div id='divDataTitle' style='postion:relative'>
			<table width='100%' id='dataTitleTable' class='grid' align='center' >
				<TR>
					<%
						String strConvDt = "";
						int dateListSize = dateList.size();
						for(int i=0;i<dateListSize;i++)
						{
							strConvDt = com.ehis.util.DateUtils.convertDate((String)dateList.get(i),"DMYHMS","en",locale);
					%>
						<TH nowrap id='visID<%=i%>'><a href="javascript:collapseColumn('<%=i%>')" title='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Clickheretocollapsethecolumn.label","ca_labels")%>'><%=strConvDt%>&nbsp;</a></TH>
					<%
						}
					%>
				</TR>
			</table>
		</div>
		<table class='grid' width='100%' id='dataTable' align='center'>
		<%
	try
	{
		
//		pstmt = con.prepareStatement("SELECT DISTINCT A.discr_msr_id discr_msr_id,B.short_desc short_desc,A.result_num_uom uom FROM CA_SPLTY_DISCR_MSR A,  AM_DISCR_MSR B WHERE  A.patient_id="+"'"+patient_id+"'"+" AND A.module_id="+"'"+module_id+"'"+" AND A.cycle_no="+"'"+cycle_no+"'"+" AND A.Discr_msr_id=B.Discr_msr_id AND A.trans_date>=TO_DATE("+"'"+from_date+"'"+",'dd/mm/yyyy HH24:MI') AND A.trans_date<=TO_DATE("+"'"+to_date+"'"+",'dd/mm/yyyy HH24:MI') ORDER BY 1");
		pstmt = con.prepareStatement("SELECT DISTINCT A.discr_msr_id discr_msr_id,B.short_desc short_desc,A.result_num_uom uom FROM CA_SPLTY_DISCR_MSR A,  AM_DISCR_MSR B WHERE  A.patient_id=? AND A.module_id=? AND A.cycle_no=?  and TASK_CODE=? AND A.Discr_msr_id=B.Discr_msr_id AND A.trans_date between TO_DATE(?,'dd/mm/yyyy HH24:MI:ss') AND TO_DATE(?,'dd/mm/yyyy HH24:MI:ss') ORDER BY 1");
		try
		{

			pstmt.setString(1,patient_id);
			pstmt.setString(2,module_id);
			pstmt.setString(3,cycle_no);
			pstmt.setString(4,"MCT002");
			pstmt.setString(5,from_date);
			pstmt.setString(6,to_date);

			rs = pstmt.executeQuery();
			while (rs.next())
			{
				disc_id = rs.getString(1);
				disc_desc = rs.getString(2);
				result_num_uom= rs.getString(3);
				if(temp_hashmap.containsKey(disc_id))
				disc_id=disc_id+" ";
				temp_hashmap.put(disc_id,disc_desc+"!!"+result_num_uom);
			}
		}
		catch (Exception ee1)
		{
			//out.println(ee1);//COMMON-ICN-0181
			ee1.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
			//if(rs != null) rs.close();
			//if(pstmt != null) pstmt.close();
		}
	}
	catch(Exception e)
	{
		//out.println(e);//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	int rowsCount=0;
	try{
	Set s;
	Iterator it;
	s = temp_hashmap.entrySet();
	it = s.iterator();
	int i=0;
	while (it.hasNext()){
	String temp_value=it.next().toString();
	String[] hashValues=temp_value.split("=");
	String key=hashValues[0];
	if(i % 2 == 0){
			classValue = "gridDataChart";
		}else{
			classValue = "gridDataChart";
	}

	out.println("<TR>");
	String[] Values=hashValues[1].split("!!");
	if(Values[1].equals("null"))
	Values[1]="";
	dateListSize = dateList.size();
	for(int j=0;j<dateListSize;j++)
	{
		strConvDt=(String)dateList.get(j);

		RESULT_NUM="";
		RESULT_STR="";
		discr_msr_id="";
		result_type="";
		try
		{
		//pstmt = con.prepareStatement("SELECT RESULT_NUM,RESULT_STR,TO_CHAR(trans_date,'dd/mm/yyyy hh24:mi') trans_date,RESULT_DATA,EVENT_CODE,ACCESSION_NUM,CA_GET_VISIT_HDR_NEW(FACILITY_ID,PATIENT_CLASS,ENCOUNTER_ID,PATIENT_ID, ADDED_BY_ID)||' , Normal Range  ('||NORMAL_LOW||'-'||NORMAL_HIGH ||')' GetTooltip FROM CA_SPLTY_DISCR_MSR WHERE  patient_id="+"'"+patient_id+"'"+" AND module_id="+"'"+module_id+"'"+" AND cycle_no="+cycle_no+" AND DISCR_MSR_ID="+"'"+key+"'"+" AND TO_CHAR(trans_date,'dd/mm/yyyy HH24:MI')=TO_CHAR(TO_DATE("+"'"+strConvDt+"'"+",'dd/mm/yyyy HH24:MI'),'dd/mm/yyyy HH24:MI')");	

		pstmt = con.prepareStatement("SELECT DISCR_MSR_ID,RESULT_TYPE,RESULT_NUM,RESULT_STR,TO_CHAR(trans_date,'dd/mm/yyyy hh24:mi:ss') trans_date,RESULT_DATA,EVENT_CODE,ACCESSION_NUM,CA_GET_VISIT_HDR_NEW(FACILITY_ID,PATIENT_CLASS,ENCOUNTER_ID,PATIENT_ID, ADDED_BY_ID)||' , Normal Range  ('||NORMAL_LOW||'-'||NORMAL_HIGH ||')' GetTooltip FROM CA_SPLTY_DISCR_MSR WHERE  patient_id=? AND module_id=? AND cycle_no=? AND DISCR_MSR_ID=? AND trans_date=TO_DATE(?,'dd/mm/yyyy HH24:MI:SS')");
		
			pstmt.setString(1,patient_id);
			pstmt.setString(2,module_id);
			pstmt.setString(3,cycle_no);
			pstmt.setString(4,key);
			pstmt.setString(5,strConvDt);
			rs = pstmt.executeQuery();
			while (rs.next())
			{
				discr_msr_id = rs.getString("DISCR_MSR_ID")==null?"":rs.getString("DISCR_MSR_ID");
				result_type = rs.getString("RESULT_TYPE")==null?"":rs.getString("RESULT_TYPE");
				RESULT_NUM = rs.getString("RESULT_NUM")==null?" ":rs.getString("RESULT_NUM");
				RESULT_STR = rs.getString("RESULT_STR")==null?" ":rs.getString("RESULT_STR");
				dateForGraph = rs.getString("trans_date")==null?" ":rs.getString("trans_date");
				Clob note=rs.getClob("RESULT_DATA");
				toolTip = rs.getString("GetTooltip") == null ? "" : rs.getString("GetTooltip");
				if(note==null)
					image=false;
				else
					image=true;
				displaydata = new StringBuffer();
				if(note!=null)
				{
					java.io.BufferedReader r = new java.io.BufferedReader(note.getCharacterStream());
					String line = null;
					while((line=r.readLine()) != null) displaydata.append(line+"\n");
				}

				if(displaydata.toString().equals("") || displaydata.toString().equals(" ") || displaydata.toString().equals("null") || displaydata.toString().equals(null) || displaydata.toString()==null || displaydata.toString()=="" || displaydata.toString()==" ")
					image=false;
				else
					image=true;
				EVENT_CODE=rs.getString(5);
				ACCESSION_NUM=rs.getString(6);

				if ((result_type.equals("D") || result_type.equals("A")) && !RESULT_STR.equals(" "))
				{					
					if(com.ehis.util.DateUtils.validDate(RESULT_STR, "DMY", locale))
						RESULT_STR = com.ehis.util.DateUtils.convertDate(RESULT_STR,"DMY","en",locale);
				}
				
			}
			if(RESULT_NUM==null || RESULT_NUM.equals(""))
			{
				RESULT_NUM=" ";
				hiddenDateForGraph = " ";
			}
			else
				hiddenDateForGraph = com.ehis.util.DateUtils.convertDate(dateForGraph,"DMYHMS","en",locale);

			if(RESULT_STR==null)
			RESULT_STR=" ";
			
			String tempToolTip = toolTip.replace('\'',' ');
			if(!image)
			{
			RESULT_DATA="&nbsp;";
			tempOnMouseOver="&nbsp;";
			}
			else
			{
			image=false;
			RESULT_DATA="<img id='imageFlowTextVis"+i+"ID"+j+"' src='../../eCA/images/flow_text.gif' onClick=\"return getText('"+key+"','"+strConvDt+"','"+ACCESSION_NUM+"','"+EVENT_CODE+"','"+image+"')\">";
			if(!tempToolTip.equals(""))
			{
			tempOnMouseOver="onMouseOver='displayToolTip(\""+tempToolTip+"\");' onMouseOut =hideToolTip(); ";
			}
			}
			out.println("<TD id='visibility"+i+"ID"+j+"' class='"+classValue+"' align='center' style='display' "+tempOnMouseOver+">"+RESULT_NUM+" "+RESULT_STR+" "+RESULT_DATA+" "+"</TD>");
			out.println("<input type='hidden' id='values"+rowsCount+"ForGraphs"+j+"' value='"+hiddenDateForGraph+"^%"+RESULT_NUM+"'>");
			//tempString="&nbsp;";
			out.println("<TD class='"+classValue+"' id='duplicate"+i+"ID"+j+"' style='display:none' width='10%' >&nbsp;</TD>");

		}
		catch(Exception e)
		{
		//out.println(e);//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
		}
		
	}
	out.println("</TR>");
	i++;
	rowsCount++;
	}
	}
	catch(Exception e)
		{
		//out.println(e);//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
		}
	finally
		{
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(con != null) ConnectionManager.returnConnection(con,request);
		}

%>
<TR height:5%;>
<%
for(int m=0;m<dateListSize;m++){%>
<TH nowrap id='visIDup<%=m%>' width='110px' style='visibility:hidden'>&nbsp;</TH>
<%}
%>
</TR>
<input type='hidden' name='totRows' id='totRows' value="<%=rowsCount+1%>">
<input type='hidden' name='totCols' id='totCols' value="<%=dateList.size()%>">
<input type='hidden' name='allDatesForGraph' id='allDatesForGraph' value='<%=datefields%>'>
</table>
</form>
<script>
	setTimeout("alignUnitsAndData()",300);
	setTimeout("alignHeight()",300);
</script>
</body>
</html>

