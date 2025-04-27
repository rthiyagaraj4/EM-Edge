<!DOCTYPE html>
<!--
	Developed by 	:	Suman
	Created on 	:	19/04/2006
	Module		:	OA
-->

<html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<jsp:useBean id="holidayvaldate" scope="session" class="webbeans.eCommon.RecordSet" /> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.text.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper " %>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
<script src='../../eOA/js/Holiday.js' language='javascript'></SCRIPT>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>

<%
request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
Connection con =null;
Statement stmt=null;
ResultSet rSet=null;
ResultSet rs=null;
PreparedStatement pstmt=null;
String holiday_date_to_create_disply="";
String fnval = "insert";
String locale			= (String)session.getAttribute("LOCALE");
String facilityId = (String) session.getValue( "facility_id" ) ;
String holiday_date=request.getParameter("holiday_date")==null?"":request.getParameter("holiday_date");
String holiday_end_date=request.getParameter("holiday_end_date")==null?"":request.getParameter("holiday_end_date");

if(holiday_end_date =="" ) holiday_end_date=holiday_date;

holiday_date=DateUtils.convertDate(holiday_date,"DMY",locale,"en");
holiday_end_date=DateUtils.convertDate(holiday_end_date,"DMY",locale,"en");

String location_type=request.getParameter("location_type")==null?"":request.getParameter("location_type");

String clinic_code=request.getParameter("clinic_code")==null?"":request.getParameter("clinic_code");

String from = request.getParameter( "from" ) ;
String to = request.getParameter( "to" ) ;
int start = 0 ;
int end = 0 ;
int totrec=0;/*Added By Dharma on 3rd March 2015 against HSA-CRF-0184 [IN:049544]*/
int maxrecord=0;
int s=0;
StringBuffer sql2 = new StringBuffer();
StringBuffer sql3 = new StringBuffer();
String sqlmain1="";
String req_start    =   "", req_end     =   "", reason_code="";
String checkedOnes="";

req_start       =   (request.getParameter("start")==null)   ?   "0" :   request.getParameter("start");
req_end         =   (request.getParameter("end")==null)     ?   "0" :   request.getParameter("end");
String removeCode		= "";

String flagSelect = request.getParameter("flagSelect");

String clinic_desc="";
String holiday_date_to_create="";
//String checked1="N";
String class_value	= "QRYEVEN";



	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 10 ;
	else
		end = Integer.parseInt( to ) ;



try
	{
		con = ConnectionManager.getConnection(request);
		stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);/*Added By Dharma on 3rd March 2015 against HSA-CRF-0184 [IN:049544]*/
		//stmt = con.createStatement();
		String  cp_type=location_type;//added  by Munisekhar for ML-BRU-SCF-1077 [IN:044018] 
		if(location_type.equals("D")){
				sql3.append(" AND A.CLINIC_TYPE = 'Y' ");
				cp_type="Y";//added  by Munisekhar for ML-BRU-SCF-1077 [IN:044018]
			}else{
				sql3.append(" AND A.CLINIC_TYPE = '"+location_type+"' ");
			}	

		if(!clinic_code.equals(""))
		{
			sql3.append(" AND A.CLINIC_CODE = '"+clinic_code+"'");
		}else
		{
			
				sql3.append(" AND A.EFF_STATUS = 'E' AND A.LEVEL_OF_CARE_IND = 'A' AND A.ALLOW_APPT_YN = 'Y' ");
			
		}

		sql3.append("AND A.CARE_LOCN_TYPE_IND = '"+location_type+"' ");
			
			

		if(flagSelect !=null)
		{
				holidayvaldate.clearAll();
			//holidayvaldate_reason.clearAll();
		}
		String checkedOnes1="";
		String reason_val="";
		String finalval="";
	//	String checkboxyn="";

		if(from != null && to != null)
		{
             
		 	 int j=0;
			 for( s=(Integer.parseInt(req_start)); s<=(Integer.parseInt(req_end)); s++)
			 {
				 if(request.getParameter("select_yn"+(s)) != null)
				 {
					 checkedOnes = request.getParameter("select_yn"+(s));
					 checkedOnes1 = request.getParameter("val"+(s));
				
                     reason_val=request.getParameter("reason_for_holiday"+(s));
								 
					 finalval=checkedOnes1+"|"+reason_val;
					// if(!(holidayvaldate.containsObject(checkedOnes1)))
					  if(!(holidayvaldate.containsObject(finalval)))
					 {
				    holidayvaldate.putObject(finalval);
					// holidayvaldate.putObject(checkedOnes1);
					// holidayvaldate_reason.putObject(finalval);
						 j++;
					 }
					 }
		/*	 if(select_yn1.equals("Y"))
                 checkboxyn="CHECKED";
                  else
                 checkboxyn="";*/

				
				removeCode = checkForNull(request.getParameter("removeCode"+(s)));
				if(removeCode.equals("Y"))
				{
					String Code = request.getParameter("Code"+(s));
					String str=null;
					for(int index=0;index<holidayvaldate.getSize();index++){
						str=(String)(holidayvaldate.getObject(index));
						if(str.contains(Code)){	
							holidayvaldate.removeObject(index);
						}
					}
					/*if((holidayvaldate.containsObject(Code)))
					{
						int removeCodeIndex = holidayvaldate.indexOfObject(Code);
							holidayvaldate.removeObject(removeCodeIndex);
							//holidayvaldate_reason.removeObject(removeCodeIndex);
					}*/
				}
			 }
			 

			 out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
			 out.println("<input type=hidden name='totChecked' id='totChecked' value='"+s+"'>");
		 }

		
		%><body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
		<form name='Holiday_result' id='Holiday_result' action='' method='post' target=''>
		<%
		
//		sql2.append("select distinct a.clinic_code clinic_code, a.long_desc clinic_desc, to_char(b.holiday_date,'dd/mm/yyyy') holiday_val, b.holiday_date from op_clinic_lang_vw a, oa_holiday b where a.language_id='"+locale+"' and a.facility_id='"+facilityId+"' and a.facility_id=b.facility_id and b.holiday_date between to_date('"+holiday_date+"','dd/mm/yyyy') and to_date('"+holiday_end_date+"','dd/mm/yyyy') and a.EFF_STATUS='E'and (a.facility_id,a.clinic_code) not in (select facility_id,locn_code from oa_holiday where facility_id=a.facility_id and locn_code=a.clinic_code) ");
		
		// sql2.append("select distinct a.clinic_code clinic_code, a.long_desc clinic_desc, to_char(to_date('"+holiday_date+"','dd/mm/yyyy'),'dd/mm/yyyy') holiday_val, to_char(to_date('"+holiday_end_date+"','dd/mm/yyyy') ,'dd/mm/yyyy') holiday_date from op_clinic_lang_vw a where a.language_id='"+locale+"' and a.facility_id='"+facilityId+"' and a.EFF_STATUS='E'and (a.facility_id,a.clinic_code) not in (select facility_id, locn_code from oa_holiday where facility_id=a.facility_id and locn_code=a.clinic_code and holiday_date between to_date('"+holiday_date+"','dd/mm/yyyy') and to_date('"+holiday_end_date+"','dd/mm/yyyy')) ");
		
		/*Added By Dharma on 3rd March 2015 against HSA-CRF-0184 [IN:049544] Start*/
		sql2.append("select distinct a.clinic_code clinic_code, a.long_desc clinic_desc, to_char(b.holiday_date,'dd/mm/yyyy') holiday_val,b.holiday_date from op_clinic a, oa_holiday b where a.facility_id='"+facilityId+"' and a.facility_id=b.facility_id and b.holiday_date between to_date('"+holiday_date+"','dd/mm/yyyy') and to_date('"+holiday_end_date+"','dd/mm/yyyy') and a.EFF_STATUS='E'and (a.facility_id,a.clinic_code) not in (select facility_id,locn_code from oa_holiday where facility_id=a.facility_id and locn_code=a.clinic_code) ");
		
		sqlmain1=sql2.toString()+sql3.toString()+" order by holiday_date";
		rSet = stmt.executeQuery(sqlmain1);
		rSet.last();
		totrec = rSet.getRow();
		rSet.beforeFirst();
		if(totrec==0) {
			if(rSet!=null)rSet.close();
			sql2.setLength(0);
			/*Added By Dharma on 3rd March 2015 against HSA-CRF-0184 [IN:049544] End*/

			sql2.append(" SELECT L1.CLINIC_CODE, L1.CLINIC_DESC, TO_CHAR(L2.TRN_DATE,'DD/MM/YYYY') HOLIDAY_VAL,L2.TRN_DATE TRN_HOL_DATE FROM ( SELECT A.CLINIC_CODE CLINIC_CODE, A.LONG_DESC CLINIC_DESC FROM OP_CLINIC_LANG_VW A WHERE A.LANGUAGE_ID = '"+locale+"' AND A.FACILITY_ID = '"+facilityId+"'  ");
			sql2.append(sql3.toString());
			 //modified  by Munisekhar for ML-BRU-SCF-1077 [IN:044018]
			sql2.append(" AND A.EFF_STATUS = 'E' AND (A.FACILITY_ID,A.CLINIC_CODE) NOT IN (SELECT FACILITY_ID, LOCN_CODE FROM OA_HOLIDAY WHERE FACILITY_ID = A.FACILITY_ID AND LOCN_CODE = A.CLINIC_CODE AND  A.CLINIC_TYPE='"+cp_type+"' AND A.CARE_LOCN_TYPE_IND='"+location_type+"' ) )L1, (SELECT TO_DATE('"+holiday_date+"','dd/mm/rrrr') + ROWNUM - 1 TRN_DATE FROM SM_FUNCTION WHERE ROWNUM <= TO_DATE('"+holiday_end_date+"','dd/mm/rrrr')+1 - TO_DATE('"+holiday_date+"','dd/mm/rrrr')) L2 ORDER BY TRN_HOL_DATE asc ");

			//sqlmain1=sql2.toString()+sql3.toString();
			sqlmain1=sql2.toString();
			rSet = stmt.executeQuery(sqlmain1);
			// out.println(sqlmain1);
			//out.println("RESULTSET"+rSet.getRow());

		}/*Added By Dharma on 3rd March 2015 against HSA-CRF-0184 [IN:049544]*/
	%>
					
						<input type=hidden name='from' id='from' value='<%=start%>'>
						<input type=hidden name='to' id='to' value='<%=end%>'>
						<input type=hidden name='start' id='start' value='<%=start%>'>
						<input type=hidden name='end' id='end' value='<%=end%>'>
		<%
			
				s=1;
				if ( start != 1 )
				for( int j=1; j<start; s++,j++ )
				{
					rSet.next() ;
				}

				String clinic_code1="";
				String chkAttribute="";
				String val2="";
				
			if(rSet !=null)
			{
				while ( s<=end && rSet.next() )
				{
					if(maxrecord==0)
					{
			
			%>
				
	<table width='80%' border=0 align='center' >
		<tr>
		<td align='right' class='NONURGENT'>
		<%
		if ( !(start <= 1)) {
	%>
		<a href='javascript:submitPrevNext1(<%=(start-10)%>,<%=(end-10)%>)' id='prev' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>
		<input type=hidden name='whichPage' id='whichPage' value='prev'>
	<%
		}
//		if ( !((start+10) > maxrecord ))
			{
	%>
		<a href='javascript:submitPrevNext1(<%=(start+10)%>,<%=(end+10)%>)' id='next' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a><input type=hidden name='whichPage' id='whichPage' value='next'>
	<%
		}
	%>
		
	</td>
	 </tr>
						
		</table>


			<!-- <div id='header' style="visibility:visible;backgroundColor:white;overflow:scroll">
				<table border="1" width="80%" bgColor=white align='center' cellspacing='0' cellpadding='0' id='result_locn1'>
				<th align='center'  width='22%'><fmt:message key="Common.Location.label" bundle="${common_labels}"/><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
				<th align='center'  width='23%'><fmt:message key="Common.date.label" bundle="${common_labels}"/></th>
				<th align='center'  width='28%'><fmt:message key="Common.ReasonForHoliday.label" bundle="${common_labels}"/>&nbsp;<img id='image' align=center src='../../eCommon/images/mandatory.gif'></img></th>
				<th align='center'  width='18%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
				</table></div> -->
				<table border="1" width="80%" align='center' bgColor=white cellspacing='0' cellpadding='0' id='result_locn2'>
				<th align='center'  width='22%'><fmt:message key="Common.Location.label" bundle="${common_labels}"/><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
				<th align='center'  width='23%'><fmt:message key="Common.date.label" bundle="${common_labels}"/></th>
				<th align='center'  width='28%'><fmt:message key="Common.ReasonForHoliday.label" bundle="${common_labels}"/>&nbsp;<img id='image' align=center src='../../eCommon/images/mandatory.gif'></img></th>
				<th align='center'  width='18%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
		<% } 
					
					clinic_code1=rSet.getString("clinic_code");
					holiday_date_to_create=rSet.getString("holiday_val");
					clinic_desc=rSet.getString("clinic_desc");

					int sch_cnt = 0;
					String flag_val="";
					//String sqlstr = "select count(1) cnt from oa_clinic_schedule where facility_id = '"+facilityId+"' and clinic_date = to_date('"+holiday_date_to_create+"','dd/mm/yyyy') and care_locn_type_ind='"+location_type+"' and clinic_code = '"+clinic_code1+"'";
					String sqlstr = "select count(1) cnt from oa_clinic_schedule where facility_id = ? and clinic_date = to_date(?,'dd/mm/yyyy') and care_locn_type_ind=? and clinic_code = ?";
					pstmt=con.prepareStatement(sqlstr);
					pstmt.setString(1,facilityId);
					pstmt.setString(2,holiday_date_to_create);
					pstmt.setString(3,location_type);
					pstmt.setString(4,clinic_code1);
					//out.println("sqlstr ==>"+sqlstr);
					rs=pstmt.executeQuery();
					if (rs!=null && rs.next()){
						
						sch_cnt=rs.getInt("cnt");
						
					}
			if (sch_cnt >0) 
				{
				flag_val="S";
				}else
				{
				flag_val="N";
				}

					val2=clinic_code1+"|"+holiday_date_to_create+"|"+flag_val;

					if(holidayvaldate.containsObject(val2))  
		
						chkAttribute = "CHECKED";
				 	else
						chkAttribute="";


					int recordIndex = holidayvaldate.indexOfObject(val2);
					if(recordIndex!=-1)
					if(chkAttribute.equals("CHECKED")) 
					{
					holidayvaldate.removeObject(recordIndex);
					//holidayvaldate_reason.removeObject(recordIndex);

					}

					if(class_value.equals("QRYEVEN"))
					class_value = "QRYODD";
					else
					class_value = "QRYEVEN";

					holiday_date_to_create_disply=DateUtils.convertDate(holiday_date_to_create,"DMY","en",locale);

					%>


			<tr>
			<td class="<%=class_value%>" width='22%'  nowrap align='left' > &nbsp;<%=clinic_desc%>&nbsp;&nbsp;</td>
	     	<td class="<%=class_value%>" width='23%'  nowrap align='left' > &nbsp;<%=holiday_date_to_create_disply%>&nbsp;&nbsp;&nbsp;</td>
			<input type='hidden' name='holiday_date<%=s%>' id='holiday_date<%=s%>' <%=holiday_date_to_create%> value="<%=holiday_date_to_create%>">
				<%

				reason_code="";
					if(holidayvaldate.getSize() >0)
					{
						for(int m=0;m<holidayvaldate.getSize();m++)
						{
							String reason=(String)holidayvaldate.getObject(m);


							StringTokenizer token1=new StringTokenizer(reason,"|");
								while(token1.hasMoreTokens())
								{
											
								String clinic_code2=token1.nextToken();
								String date2=token1.nextToken();
								String chk2=token1.nextToken();
    							String fin_val=clinic_code2+"|"+date2+"|"+chk2;
								String reason2=token1.nextToken();
							
								if(val2.equals(fin_val))
								{
									reason_code=reason2;
									break;
								}

							}
						}
					}
				String chkAttribute1="";
				String reasonCode=reason_code;			
			  if(reasonCode!=null && !reasonCode.equals(""))
              chkAttribute1="CHECKED";
                 else
                chkAttribute1=""; 

										
			%>


			<td class="<%=class_value%>"  width='28%' nowrap >&nbsp;<input type='Text' name='reason_for_holiday<%=s%>' id='reason_for_holiday<%=s%>' size='32' maxlength='25' onblur="chk_value_reason(this,<%=s%>)" value="<%=reason_code%>">&nbsp;</td>
				<%reason_code="";%>
			<td class="<%=class_value%>" nowrap style
			='align:center'>
			<input type='checkbox'<%=chkAttribute%>  name='select_yn<%=s%>'  width='18%'	Onclick="change_val(this,<%=s%>,'<%=flag_val%>')"  value="<%=val2%> " <%=chkAttribute1%>
			><input type='hidden' name='removeCode<%=s%>' id='removeCode<%=s%>' value=""><input type='hidden' name='Code<%=s%>' id='Code<%=s%>' value="<%=val2%>" ><input type='hidden' name='val<%=s%>' id='val<%=s%>' <%=val2%> value="<%=val2%>">
			</td>
            </tr>
					<%
					s++;
					maxrecord++;
				}//end of while
			}

		if(maxrecord == 0)
		{%>
			<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>
		<%}

		if ( maxrecord < 10 || (!rSet.next()) ) {
		%>
			<script >
			if (document.getElementById("next"))
				document.getElementById("next").style.visibility='hidden';
			</script>
		<% 
				} else {%>
			<script >
			if (document.getElementById("next"))
				document.getElementById("next").style.visibility='visible';
			</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



		<%}

	%>
	</table>
	<input type='hidden' name='location_type' id='location_type' value='<%=location_type%>'>
	<input type='hidden' name='clinic_code' id='clinic_code'   value='<%=clinic_code%>'>
	<input type='hidden' name='b_clinic' id='b_clinic'   value='<%=clinic_code%>'>
	<input type='hidden' name='function_name' id='function_name' value='<%=fnval%>'>
	<input type='hidden' name='locationType' id='locationType' value='<%=location_type%>'>
	<input type='hidden' name='holiday_date' id='holiday_date' value='<%=holiday_date%>'>
	<input type='hidden' name='holiday_end_date' id='holiday_end_date' value='<%=holiday_end_date%>'>

	<%
		if(stmt !=null) stmt.close();
		if(rSet !=null) rSet.close();

	}catch(Exception e)
	{
		//out.print(e);
		e.printStackTrace();
	}finally
	{
		 ConnectionManager.returnConnection(con,request);
		 session.setAttribute("holidayvaldate", holidayvaldate);
		// session.setAttribute("holidayvaldate_reason",holidayvaldate_reason);

	}
%>
		</form>
	</body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

