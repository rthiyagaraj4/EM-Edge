<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,java.net.*,com.ehis.util.*,org.json.simple.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
     	request.setCharacterEncoding("UTF-8");
		String rno						  = checkForNull(request.getParameter("rno"));
		String pid						  = checkForNull(request.getParameter("pid"));
		String facilityId				  = checkForNull(request.getParameter("facilityId")); //this line Added for this CRF [Bru-HIMS-CRF-367]
		//out.println("facilityId==>"+facilityId);
		
	
 %>
 <html>
    <title><fmt:message key="eMO.BodyMovement.label" bundle="${mo_labels}"/></title>
	<head>
	    <%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

      <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
        <script language='javascript' src='../../eCommon/js/common.js' ></script>
		
		<script language='javascript' src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src='../../eMO/js/MORegDetailsQuery.js' ></script>
		<script language='javascript' src='../../eMO/js/MOAreaAvailabilityQueryCriteria.js' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



		
<%
		Connection	    con		= null;
		Statement		st		= null;
		ResultSet		rs		= null;			        
		String facility_id = (String)session.getValue("facility_id");
		String from = request.getParameter( "from" ) ;
	    String to = request.getParameter( "to" ) ;
		int start = 0 ;
	    int end = 0 ;
	    int l=1;
		
    	if ( from == null )
		start = 1 ;
	    else
		start = Integer.parseInt( from ) ;
    	if ( to == null )
	  	end = 13 ;
	    else
		end = Integer.parseInt( to ) ;
				
 %>
		</head>                         
	
		
		<body  onMouseDown='CodeArrest()' onKeyDown="lockKey()">
		
		
		<form name = 'MOBodyMovementResult'>
 
 
 
 <%
		String classValue	= "";
		int rowIndex		= 1;
		String area_desc    ="";
		String rfid_tag_num    ="";
		String  prevpat     ="";
		String dis_rno="";
		String dis_pid="";
		String dis_pname="";
        String bed_no="";
		String added_date="";
		String area_type = "";
		//String postmortem_status="";
		String area="";
		//String body_released_yn="";
		
		//Below line Added for this CRF [Bru-HIMS-CRF-367]
		String facility_name=""; String facility_name_chk="TEST"; String current_facility_id="";
		String locale = ((String)session.getAttribute("LOCALE"));
		int ccount          = 0;
        int j=0;
		try
			{
			con	= ConnectionManager.getConnection(request);
			
			StringBuffer getcount = new StringBuffer();
			//getcount.append("select count(*) from  MO_BODY_MOVEMENT_HIST_VW where upper(REGISTRATION_NO) like upper('"+rno+"%') and upper(NVL(PATIENT_ID,'*')) like upper('"+pid+"%')  and facility_id ='"+facility_id+"'");
			
			/*Above line commented and below line added for this CRF Bru-HIMS-CRF-367*/
			
			getcount.append("select count(*) from  MO_BODY_MOVEMENT_HIST_VW where upper(REGISTRATION_NO) like upper('"+rno+"%') and upper(NVL(PATIENT_ID,'*')) like upper('"+pid+"%')");
			
			if(!facilityId.equals(""))
			 getcount.append(" and facility_id ='"+facilityId+"'");			
			//End Bru-HIMS-CRF-367			
			
			//out.println("getcount.toString();==>"+getcount.toString());
			
			st=con.createStatement();
			rs = st.executeQuery(getcount.toString());
			while(rs!=null && rs.next())
			{
				ccount = rs.getInt(1);
				
			}
			if (rs!=null) rs.close();
			if (st!=null) st.close();
				JSONObject json = new JSONObject(); // added by mujafar for ML-MMOH-CRF-0996 start
				json			 = eMO.MOCommonBean.getMOParam(con, facilityId); 
				String enable_rfid_yn = (String)json.get("enable_rfid_yn"); // added by mujafar for ML-MMOH-CRF-0996 end
		    if(ccount > 0)
			{
		 %>
		 <p>
		<table align='right'>
		<tr>
		<td>
		<% //Below line modified for this CRF [Bru-HIMS-CRF-367]
		if ( !(start <= 1) )
		out.println("<A HREF='../jsp/MOBodyMovementResult.jsp?from="+(start-13)+"&to="+(end-13)+"&rno="+URLEncoder.encode(rno)+"&pid="+URLEncoder.encode(pid)+"&facilityId="+URLEncoder.encode(facilityId)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

		if ( !( (start+13) > ccount ) )
		out.println("<A HREF='../jsp/MOBodyMovementResult.jsp?from="+(start+13)+"&to="+(end+13)+"&rno="+URLEncoder.encode(rno)+"&pid="+URLEncoder.encode(pid)+"&facilityId="+URLEncoder.encode(facilityId)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

		//End this CRF [Bru-HIMS-CRF-367]
		%>
		</td>
		</tr>
		</table>
         </p>
<BR><BR>	
		 
		 
		 <table cellspacing=0 cellpadding=0 align='center' width='100%' border='1' cellpadding=0 cellspacing=0>
           <%if(j==0)
				{%> <!-- below line added for this CRF Bru-HIMS-CRF-367 -->
			
		    <th nowrap><fmt:message key="eMO.AreaType.label" bundle="${mo_labels}"/></th> 
			<th nowrap><fmt:message key="Common.area.label" bundle="${common_labels}"/> </th> 
			<th nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
			<%if(enable_rfid_yn.equals("Y")) // added by mujafar for ML-MMOH-CRF-0996
			{%>
			<th nowrap><fmt:message key="eMO.RFIDTag.label" bundle="${mo_labels}"/></th>
			<%}%>
			<th nowrap><fmt:message key="eMO.AssignedDate.label" bundle="${mo_labels}"/></th>
			  <tr><td colspan=6 height="1">&nbsp;</td></tr>
			
				
		 <%j=1;}%>

 <%
			StringBuffer operSql = new StringBuffer();
			//operSql.append("select  REGISTRATION_NO, PATIENT_ID, PATIENT_NAME,AREA_DESC, BED_NO,ADDED_DATE,area_type_desc from MO_BODY_MOVEMENT_HIST_VW"); 
			//operSql.append("select  REGISTRATION_NO, PATIENT_ID,decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name)) PATIENT_NAME,MO_GET_DESC.MO_AREA('"+facility_id+"',AREA_CODE,'"+localeName+"','2') AREA_DESC, BED_NO,ADDED_DATE,AREA_TYPE,area_type_desc,rfid_tag_num from MO_BODY_MOVEMENT_HIST_VW where upper(REGISTRATION_NO) like upper('"+rno+"%') and upper(NVL(PATIENT_ID,'*')) like upper('"+pid+"%') and facility_id ='"+facility_id+"' order by PATIENT_ID,registration_no,to_date(ADDED_DATE,'dd/mm/yyyy hh24:mi') desc ");
			
			/*Above line commented and below line added for this CRF Bru-HIMS-CRF-367*/
			
			operSql.append("select  facility_id, sm_get_desc.sm_facility_param(facility_id,'"+locale+"','1') facility_name ,REGISTRATION_NO, PATIENT_ID,decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name)) PATIENT_NAME,MO_GET_DESC.MO_AREA(facility_id,AREA_CODE,'"+localeName+"','2') AREA_DESC, BED_NO,ADDED_DATE,AREA_TYPE,area_type_desc,rfid_tag_num from MO_BODY_MOVEMENT_HIST_VW where upper(REGISTRATION_NO) like upper('"+rno+"%') and upper(NVL(PATIENT_ID,'*')) like upper('"+pid+"%')");			
			if(!facilityId.equals(""))
			 operSql.append(" and facility_id ='"+facilityId+"'");			 
			
			operSql.append(" order by facility_name,PATIENT_ID,registration_no,to_date(ADDED_DATE,'dd/mm/yyyy hh24:mi') desc");
			
			//End Bru-HIMS-CRF-367
			
			//out.println("operSql.toString()=>"+operSql.toString());
			
			st=con.createStatement();
			rs = st.executeQuery(operSql.toString());
			 if ( start != 1 )
	         for( int m=1; m<start; l++,m++ ){
	         rs.next() ;
            }
			while(rs.next()&&l<=end)
			{
			  classValue =	((rowIndex%2)==0)? "QRYEVEN" : "QRYODD";
			  rowIndex++;
			  
			   
			  current_facility_id= rs.getString("facility_id"); if(facility_id==null) facility_id ="";	
			  facility_name= rs.getString("facility_name"); if(facility_name==null) facility_name ="";			  
			  
			  
			  dis_rno  = rs.getString("REGISTRATION_NO");
			  if(dis_rno==null) dis_rno ="";
			  dis_pid = rs.getString("PATIENT_ID");
			  if(dis_pid==null) dis_pid ="";
			  dis_pname = rs.getString("PATIENT_NAME");
			  if(dis_pname==null) dis_pname ="";
			  bed_no = rs.getString("BED_NO");
			  if(bed_no==null) bed_no ="&nbsp;";
			  area_desc = rs.getString("AREA_DESC");
			  if(area_desc==null) area_desc ="";
			  rfid_tag_num = rs.getString("rfid_tag_num")==null?"&nbsp;":rs.getString("rfid_tag_num");
			  added_date = rs.getString("ADDED_DATE");
			  if(added_date==null) added_date ="";
			  if(added_date!=null && !added_date.equals(""))
				  added_date  = DateUtils.convertDate(added_date,"DMYHM","en",localeName); 	
		
			 // postmortem_status = rs.getString("POSTMORTEM_STATUS_DESC");
			  //if(postmortem_status==null) postmortem_status ="";
			  //area = rs.getString("AREA_TYPE_desc");
			  //if(area==null) area ="";
			  //body_released_yn = rs.getString("BODY_RELEASED_YN");
			  //if(body_released_yn==null) body_released_yn ="";
			  
			  area_type = rs.getString("AREA_TYPE");
			  if(area_type!=null && !area_type.equals("") && area_type.equals("R"))
				  area  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.ReleaseArea.label","mo_labels");
			  else if(area_type!=null && !area_type.equals("") && area_type.equals("S"))
				  area  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.StorageArea.label","mo_labels");
			  else if(area_type!=null && !area_type.equals("") && area_type.equals("P"))
				  area  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.PostmortemArea.label","mo_labels");
			  else if(area_type!=null && !area_type.equals("") && area_type.equals("O"))
				  area  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels");

			  if(prevpat.equals(dis_rno)) prevpat = "";
			  else prevpat =dis_rno;
			  
			 
		    //if(!facility_name_chk.equals(facility_name)){ facility_name_chk=facility_name;
			 if(!facility_name_chk.equals(current_facility_id)){
			   facility_name_chk=current_facility_id;%>
			  <tr><th colspan=6 align=left><B><%=facility_name%> </B></th></tr>
			 <% }
			  if(!(prevpat.equals("")))
		      {   
			%>
	            <tr><th colspan=6 align=left><B><fmt:message key="eMO.PatientIDRegNoName.label" bundle="${mo_labels}"/>:<%=dis_pid%>/<%=dis_rno%>/<%=dis_pname%></B></th></tr>
	         <% }prevpat =dis_rno; %>
	
    <tr> <!-- below line added for this CRF Bru-HIMS-CRF-367 -->
	   
		<td class='<%=classValue%>'> <font size=1><%=area%></td>
		<td class='<%=classValue%>'> <font size=1><%=area_desc%></td>
		<td class='<%=classValue%>' align='left'> <font size=1><%=bed_no%></td>
		<%
		if(enable_rfid_yn.equals("Y")) // added by mujafar for ML-MMOH-CRF-0996
			{
		%><td class='<%=classValue%>' align='left'> <font size=1><%=rfid_tag_num%></td>
			<%}%>
		<td class='<%=classValue%>' align='left'> <font size=1><%=added_date%></td>
		
		
    </tr>
 <%
	l++;
	}
  %>
   </table>
        <br>
			<%}
	    else
				{
		          //out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));window.close();</script>");
				  /*Above line commented and below line Added [IN:042233]*/
				  out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
				}
				if (rs != null) rs.close();
                if (st != null) st.close();

				}
    catch(Exception e) {out.println(e.toString());
	e.printStackTrace();}
    finally
    {
       	ConnectionManager.returnConnection(con,request);
		%>
		<%}
		
	%>
       </form>
    </body>
  </html>

<script>
	
	if(parent.name!="")
	parent.frames[1].document.forms[0].search.disabled=false
	
	</script>
<%!
public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}
	
%>

