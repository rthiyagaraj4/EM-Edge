<!DOCTYPE html>
<html>
<%@ page import ="java.sql.*, java.text.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language='javascript' src='../../eAE/js/AssignSpareBaysToTreatmentArea.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<body onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name='result_form' id='result_form' action="AssignSpareBaysToTreatmentAreaResult.jsp" method="post">
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
	
	Connection con					=	null;
	PreparedStatement pstmt			=	null;
	PreparedStatement pstmt1		=	null;
	ResultSet rset					=	null ;
	ResultSet rset1					=	null ;
	String	facilityId 					= (String) session.getValue( "facility_id" ) ;
	String valid_values="";
	int n=0;
	String from = request.getParameter( "from" ) ;
	valid_values		=	request.getParameter("valid_values")==null?"":request.getParameter("valid_values");
	String to = request.getParameter( "to" ) ;
	StringTokenizer strToken		= null;
	int strCount					= 0;
	String check_attribute				=	"";
	String check_value	= "";
	String class_value				= "QRYEVEN";
	String bay_no					=	"";
	String bay_type="";
	String bay_type_desc="";
	String spare_bays_yn = "";
	int maxRecord=0;
	String clinic_code	= "";
	String treatment_area_code = "";
	String bay_mode="";
	String countBuffer = "";
	String sql="";
	String bayvalue="";
	int start = 0 ;
	int end = 0 ;
	int i=1;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt(from) ;

	if ( to == null )
	  	end = 10 ;
	else
		end = Integer.parseInt( to ) ;

%>

<% try {
	con						=	ConnectionManager.getConnection(request);
	clinic_code				=	checkForNull(request.getParameter("clinic_code"));
	
	treatment_area_code		=	checkForNull(request.getParameter("treatment_area_code"));
	
    bay_mode =  checkForNull(request.getParameter("bay_mode"));
	
	if(bay_mode == null) bay_mode = "A";

	if(bay_mode.equals("P")) {
		//countBuffer	= "Select count(*) as count_value from AE_SPARE_BAYS where facility_id = ? and clinic_code = ? and current_status = 'A' and eff_Status ='E'";  
		countBuffer	= "Select count(*) as count_value from ae_spare_bays a,ae_bay_type b where a.facility_id=? and a.clinic_code=? and  a.spare_bay_yn = 'N' and a.eff_status ='E' and a.bay_type_code=b.bay_type_code and current_status = 'A' and a.bay_no not in(select bed_no from ae_bed_for_trmt_area where clinic_code=? and bed_no = a.bay_no and facility_id=?)";
	} else if(bay_mode.equals("S")) {
		countBuffer	= "Select count(*) as count_value  from ae_spare_bays a,ae_bay_type b where a.facility_id=? and a.clinic_code=? and a.spare_bay_yn = 'Y' and a.eff_status ='E' and a.bay_type_code=b.bay_type_code and current_status = 'A' and a.bay_no not in(select bed_no from ae_bed_for_trmt_area where clinic_code=? and bed_no = a.bay_no and facility_id=?)";
	} 	else 	{
		countBuffer	= "Select count(*) as count_value from ae_spare_bays a,ae_bay_type b where  a.facility_id=? and a.clinic_code=? and a.eff_status ='E' and a.bay_type_code=b.bay_type_code and current_status = 'A' and a.bay_no not in(select bed_no from ae_bed_for_trmt_area where  clinic_code=? and bed_no = a.bay_no and facility_id=?)";
	}
	int count_value=0;
	pstmt	=	con.prepareStatement(countBuffer);
	pstmt.setString(1,facilityId);
	pstmt.setString(2,clinic_code);
	pstmt.setString(3,clinic_code);
//	pstmt1.setString(4,treatment_area_code);
	pstmt.setString(4,facilityId);



	rset = pstmt.executeQuery();

  	if ((rset != null) && (rset.next())) 	{
		count_value= rset.getInt("count_value");
		maxRecord=count_value;
	}
 	if (count_value==0) {
%>
		<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common')); </script>
<%
		return;
	} else {
		if(bay_mode.equals("P")) {
			//countBuffer	= "Select count(*) as count_value from AE_SPARE_BAYS where facility_id = ? and clinic_code = ? and current_status = 'A' and eff_Status ='E'";  
			sql	= "Select a.bay_no bay_no,a.bay_type_code bay_type,b.short_desc bay_type_desc,a.spare_bay_yn spare_bay_yn from ae_spare_bays a,ae_bay_type b where a.facility_id=? and a.clinic_code=? and  a.spare_bay_yn ='N' and a.eff_status ='E' and a.bay_type_code=b.bay_type_code and current_status = 'A' and a.bay_no not in(select bed_no from ae_bed_for_trmt_area where clinic_code=? and bed_no = a.bay_no and facility_id=?)";
		} else if(bay_mode.equals("S")) 	{
			sql	= "Select a.bay_no bay_no,a.bay_type_code bay_type,b.short_desc bay_type_desc,a.spare_bay_yn spare_bay_yn from ae_spare_bays a,ae_bay_type b where a.facility_id=? and a.clinic_code=? and a.spare_bay_yn = 'Y' and a.eff_status ='E' and a.bay_type_code=b.bay_type_code and current_status = 'A' and a.bay_no not in(select bed_no from ae_bed_for_trmt_area where clinic_code=? and bed_no = a.bay_no and facility_id=?)";
		} 	else 	{
			sql	= "Select a.bay_no bay_no,a.bay_type_code bay_type,b.short_desc bay_type_desc,a.spare_bay_yn spare_bay_yn from ae_spare_bays a,ae_bay_type b where  a.facility_id=? and a.clinic_code=? and a.eff_status ='E' and a.bay_type_code=b.bay_type_code and current_status = 'A' and a.bay_no not in(select bed_no from ae_bed_for_trmt_area where clinic_code=? and bed_no = a.bay_no and facility_id=?)";
		}
		
		//String sql		=	" Select bay_no from AE_SPARE_BAYS where facility_id = ? and clinic_code = ? and current_status = 'A' and eff_Status ='E' ";

		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,facilityId);
		pstmt.setString(2,clinic_code);
		pstmt.setString(3,clinic_code);
	//	pstmt.setString(4,treatment_area_code);
		pstmt.setString(4,facilityId);
	
		rset = pstmt.executeQuery();
%>
<P>
<table  width='90%' align='center' >	
	<tr>
<%
		if (!(start <= 1) || !( (start+10) > maxRecord ))
		{
%>
		   <td class='white' width='95%'>&nbsp;</td>
    		<td  align='right' nowrap>
<%	}else{%>
			<td class='white'>
<%}%>

<%
		if ( !(start <= 1) ) {
%>
			<a HREF='javascript:submitPrevNext(<%=start-10%>, <%=end-10%>);' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>
<%
		}
		if ( !( (start+10) > maxRecord ) ) 	{
%>
			<a HREF='javascript:submitPrevNext(<%=start+10%>, <%=end+10%>);'  text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
<%
		}
%>
			</td>
	</tr>
</table>

<table cellpadding=0 cellspacing=0 border=1 width='90%' align='center'>
	<th nowrap><fmt:message key="eAE.BedBayNo.label" bundle="${ae_labels}"/></th>
	<th nowrap><fmt:message key="eAE.BedBayType.label" bundle="${ae_labels}"/></th>
	<th nowrap><fmt:message key="eAE.PseudoBedBays.label" bundle="${ae_labels}"/></th>
	<th nowrap><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
<%
	if (rset != null) 	{
		if( start != 1 )
			for( int j=1; j<start; i++,j++ ){
				rset.next() ;
			}
			while(rset.next() && i<=end) {
				bay_no	= checkForNull(rset.getString("bay_no"));
				bay_type=checkForNull(rset.getString("bay_type"));
				bay_type_desc= checkForNull(rset.getString("bay_type_desc"));
				spare_bays_yn= checkForNull(rset.getString("spare_bay_yn"));
				bayvalue=bay_no+"$"+bay_type+"$"+spare_bays_yn;
				if(class_value.equals("QRYEVEN"))
					class_value = "QRYODD";
				else
			 		class_value = "QRYEVEN";
			    if ((!valid_values.equals("")) && (!valid_values.equals(",")))   {	
					check_attribute = "";
			        strToken	=  new StringTokenizer(valid_values, ",");
                    strCount = strToken.countTokens();
					for (int s=0; s< strCount; s++) {
						check_value		=	checkForNull(strToken.nextToken());
					    if (check_value.equals(bayvalue))
							check_attribute = "Checked";
					}
				}
%>

			    <tr>
					<td class="<%=class_value%>" nowrap align=center><%=bay_no%></td>
					<td class="<%=class_value%>" nowrap align=center><%=bay_type_desc%></td>
					<td class="<%=class_value%>" nowrap align=center><%=spare_bays_yn%></td>
					<td class="<%=class_value%>" nowrap align=center>
						<input type=checkbox  onclick="chkValue(this,'<%=bayvalue%>')"  name=flag<%=n%>  value=<%=bay_no%> <%=check_attribute%>></td>
						<input type=hidden name=h<%=n%>>
			    </tr>
<%
				i++;
				n++;
			}
	}
%>
</table>
<%
	}
   } catch (Exception e){
		e.printStackTrace();
   } finally {
		if(pstmt!=null) pstmt.close();
		if(rset!=null) rset.close();
		if(pstmt1!=null) pstmt1.close();
		if(rset1!=null) rset1.close();
		ConnectionManager.returnConnection(con,request);
	}

%>
</div>
<input type=hidden name='count' id='count' value=<%=i%>>
<!-- <input type='hidden' name=bay_no value=<%=bay_no%>> -->
<input type='hidden' name=treatment_area_code value=<%=treatment_area_code%>>
<input type='hidden' name=clinic_code value=<%=clinic_code%>>
<input type='hidden' name='status' id='status' value='null'>
<input type='hidden' name='n' id='n' value=<%=n%>>
<input type='hidden' name='fnname' id='fnname' value="Insert">
<input type='hidden' name='insert_table' id='insert_table' value='Y'>
<input type='hidden' name='valid_values' id='valid_values' value="<%=valid_values%>">
<input type='hidden' name='temp' id='temp'>
<input type="Hidden" name="from" id="from" value="<%=from%>">
<input type="Hidden" name="to" id="to" value="<%=to%>">
<input type='hidden' name='bay_mode' id='bay_mode' value='<%=bay_mode%>' >

</form>
</body>
</html>

<%!
	
	public static String checkForNull(String inputString) 	{
		return( ((inputString==null) || (inputString.equals("null"))) ? "" : inputString );
	}

	public static String checkForNull(String inputString, String defaultValue) 	{
		return( ((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString );
	}

%>

