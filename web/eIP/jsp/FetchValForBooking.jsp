<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.text.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'>
<script src='../../eCommon/js/common.js' language='javascript'></script>
</link>
<%
	request.setCharacterEncoding("UTF-8");
	String locale					= (String)session.getAttribute("LOCALE");
	String			facilityid	= (String)session.getValue("facility_id");
	Connection		con			= null;
	Statement		stmt		= null;
	ResultSet		rs			= null;
	try
	{
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();

		String source_type  = checkForNull(request.getParameter("source_type"));
		String pract_name   = checkForNull(request.getParameter("pract_name"));
		String pract		= checkForNull(request.getParameter("pract"));
		String param		= checkForNull(request.getParameter("param"));
		String isOTFunc		= checkForNull(request.getParameter("isOTFunc"));
		String facility_name	= "";
		String facility_id		= "";
		String short_desc		= "";
		String clinic_code		= "";
		String short_name		= "";
		String referral_code	= "";
		String practitioner_name= "";
		String practitioner_id	= "";
		String pract_type_desc	= "";
	

%>
</head>

<body class='message' onKeyDown='lockKey()'>
<% 
	if(param.equals("msg"))
	{
	%>
		<script>
		var len=parent.document.frames[1].document.frames[2].document.forms[0].source.length;
			var i=1;
			while(i<len)
			{
				len=parent.document.frames[1].document.frames[2].document.forms[0].source.length;
				parent.document.frames[1].document.frames[2].document.forms[0].source.remove(i);
			}
		</script>
<%
	}
	
if(source_type.equals("ZF"))
{	stmt = con.createStatement() ;
	String sql=" Select facility_name,facility_id from SM_FACILITY_PARAM_LANG_VW where language_id = '"+locale+"' and facility_id !='"+facilityid+"'  order by 1 ";
	rs = stmt.executeQuery(sql);
	out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body onMouseDown='CodeArrest()' onKeyDown='lockKey()' CLASS='MESSAGE'><form name='nam1' id='nam1'>");
	
	while(rs.next()){
	facility_name=rs.getString("facility_name");
	facility_id=rs.getString("facility_id");
	if(param.equals("msg"))
	{
	%>
		<script>
			var temp ="<%=facility_id%>";
			var temp1="<%=facility_name%>";
			var opt=parent.document.frames[1].document.frames[2].document.createElement("OPTION");
			opt.text=temp1;
			opt.value=temp;
			var comp=parent.document.frames[1].document.frames[2].document.forms[0].source;
			comp.add(opt)
		</script>
     <%
	}
	else
	{
	%>
		<script>
			var temp ="<%=facility_id%>";
			var temp1="<%=facility_name%>";
			var opt=parent.document.frames[1].document.createElement("OPTION");
			opt.text=temp1;
			opt.value=temp;
			var comp=parent.document.frames[1].document.forms[0].source;
			comp.add(opt)
			</script>
<%
	}
}
if(rs!=null)rs.close();
if(stmt!=null)stmt.close();

} // end of source_type.equals("ZF")
if(source_type.equals("OP"))
{
	stmt = con.createStatement() ;
	String sql=" select short_desc, clinic_code from OP_CLINIC where facility_id='"+facilityid+"'  and clinic_type='C' order by 1 ";
	rs = stmt.executeQuery(sql);
	out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body onMouseDown='CodeArrest()' onKeyDown='lockKey()' CLASS='MESSAGE'><form name='nam1' id='nam1'>");
	
	while(rs.next()){
	short_desc=rs.getString("short_desc");
	clinic_code=rs.getString("clinic_code");
	if(param.equals("msg"))
	{
	%>
		<script>
			var temp ="<%=clinic_code%>";
			var temp1="<%=short_desc%>";
			var opt=parent.document.frames[1].document.frames[2].document.createElement("OPTION");
			opt.text=temp1;
			opt.value=temp;
			var comp=parent.document.frames[1].document.frames[2].document.forms[0].source;
			comp.add(opt)
		</script>
	
	<%
	}
		else
		{
	%>
		<script>
			var temp ="<%=clinic_code%>";
			var temp1="<%=short_desc%>";
			var opt=parent.document.frames[1].document.createElement("OPTION");
			opt.text=temp1;
			opt.value=temp;
			var comp=parent.document.frames[1].document.forms[0].source;
			comp.add(opt)
		</script>
<%
		}
	}
	if(rs!=null)rs.close();
	if(stmt!=null)stmt.close();
	
} // end of source_type.equals("OP")
if(source_type.equals("XF"))
{stmt = con.createStatement() ;
	String sql="Select short_desc, referral_code from AM_REFERRAL_LANG_VW where language_id = '"+locale+"' and eff_status ='E' order by 1 ";
	rs = stmt.executeQuery(sql);
	out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body onMouseDown='CodeArrest()' onKeyDown='lockKey()' CLASS='MESSAGE'><form name='nam1' id='nam1'>");
	
	while(rs.next()){
	short_name=rs.getString("short_desc");
	referral_code=rs.getString("referral_code");
	if(param.equals("msg"))
	{
	%>
	<script>
				var temp1 ="<%=short_name%>";
				var temp="<%=referral_code%>";
				var opt=parent.document.frames[1].document.frames[2].document.createElement("OPTION");
				opt.text=temp1;
				opt.value=temp;
				var comp=parent.document.frames[1].document.frames[2].document.forms[0].source;
				comp.add(opt)
	</script>
	<%
	}else
	{
	%>
		<script>
			var temp1 ="<%=short_name%>";
			var temp="<%=referral_code%>";
			var opt=parent.document.frames[1].document.createElement("OPTION");
			opt.text=temp1;
			opt.value=temp;
			var comp=parent.document.frames[1].document.forms[0].source;
			comp.add(opt)
			</script>
<%
	}

}
if(rs!=null)rs.close();
if(stmt!=null)stmt.close();

}


if(pract_name.length() > 1)
{
		if(param.equals("msg"))
		{
		%>
		<script>
		var len=parent.document.frames[1].document.frames[2].document.forms[0].practitioner.length;
			var i=1;
			while(i<len)
			{
				len=parent.document.frames[1].document.frames[2].document.forms[0].practitioner.length;
				parent.document.frames[1].document.frames[2].document.forms[0].practitioner.remove(i);
			}
		</script>
	<%
		}
		else
		{
	%>
	<script>
	
	var len=parent.document.frames[1].document.forms[0].practitioner.length;
		var i=1;
		while(i<len)
		{
			len=parent.document.frames[1].document.forms[0].practitioner.length;
			parent.document.frames[1].document.forms[0].practitioner.remove(i);
		}
	</script>
	
	<% }

	
	String source	 = checkForNull(request.getParameter("source"));
		
	if(source.equals("ZF"))
	{stmt = con.createStatement() ;
	String sql=" Select AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1') practitioner_name, practitioner_id from AM_PRACT_FOR_FACILITY where FACILITY_ID='"+pract_name+"' and eff_status ='E' order by 1 ";
	rs = stmt.executeQuery(sql);
	out.println("<html><HEAD><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body onMouseDown='CodeArrest()' onKeyDown='lockKey()' CLASS='MESSAGE'><form name='nam1' id='nam1'>");
	
	while(rs.next()){
	practitioner_name=rs.getString("practitioner_name");
	practitioner_id=rs.getString("practitioner_id");
	if(param.equals("msg"))
	{
		%>
		<script>
				var temp1 ="<%=practitioner_name%>";
				var temp="<%=practitioner_id%>";
				var opt=parent.document.frames[1].document.frames[2].document.createElement("OPTION");
				opt.text=temp1;
				opt.value=temp;
				var comp=parent.document.frames[1].document.frames[2].document.forms[0].practitioner;
				comp.add(opt)
			</script>
	<%
	}
	else
	{
	%>
		<script>
			var temp1 ="<%=practitioner_name%>";
			var temp="<%=practitioner_id%>";
			var opt=parent.document.frames[1].document.createElement("OPTION");
			opt.text=temp1;
			opt.value=temp;
			var comp=parent.document.frames[1].document.forms[0].practitioner;
			comp.add(opt)
			</script>
<%
	}
	}
	if(rs!=null)rs.close();
	if(stmt!=null)stmt.close();
	
}

	if(source.equals("OP"))
	{stmt = con.createStatement() ;
	String sql=" select AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1') practitioner_name, practitioner_id from AM_PRACT_FOR_FACILITY where facility_id='"+facilityid+"' and eff_status ='E' order by 1 ";
	rs = stmt.executeQuery(sql);
	out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE' onKeyDown='lockKey()'><form name='nam1' id='nam1'>");
	
	while(rs.next()){
	practitioner_name=rs.getString("practitioner_name");
	practitioner_id=rs.getString("practitioner_id");
	if(param.equals("msg"))
	{
		%>
		<script>
				var temp1 ="<%=practitioner_name%>";
				var temp="<%=practitioner_id%>";
				var opt=parent.document.frames[1].document.frames[2].document.createElement("OPTION");
				opt.text=temp1;
				opt.value=temp;
				var comp=parent.document.frames[1].document.frames[2].document.forms[0].practitioner;
				comp.add(opt)
			</script>
	<%
	}
	else
	{
	%>
		<script>
			var temp1 ="<%=practitioner_name%>";
			var temp="<%=practitioner_id%>";
			var opt=parent.document.frames[1].document.createElement("OPTION");
			opt.text=temp1;
			opt.value=temp;
			var comp=parent.document.frames[1].document.forms[0].practitioner;
			comp.add(opt)
			</script>
<%
	}
	}
		if(rs!=null)rs.close();
	if(stmt!=null)stmt.close();

}


}

	if(pract.length()>1)
	{stmt = con.createStatement() ;
	String sql=" Select AM_GET_DESC.AM_PRACT_TYPE(PRACT_TYPE,'"+locale+"','1') pract_type_desc from AM_PRACT_FOR_FACILITY_VW where practitioner_id='"+pract+"' ";
	rs = stmt.executeQuery(sql);
	out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE' onKeyDown='lockKey()'><form name='nam1' id='nam1'>");
	
	while(rs.next()){
	pract_type_desc=rs.getString("pract_type_desc");
	}
		if(rs!=null)rs.close();
	if(stmt!=null)stmt.close();

		if(param.equals("msg"))
		{
		%>
		<script>
			parent.document.frames[1].document.frames[2].document.getElementById('pract_type').innerText='<%=pract_type_desc%>';
		</script>
<%
}
else
{
%>
		<script>
		parent.document.frames[1].document.getElementById('pract_type').innerText='<%=pract_type_desc%>';
		</script>
<% }
}
 /*** Disabling the Bed Ref number ***/
 if(source_type.equals("VAL_MED_GRP"))
 { 
   String med_service_grp = request.getParameter("med_service_grp");
   String pref_adm_date = request.getParameter("pref_adm_date").trim();
  
  if(med_service_grp != null && pref_adm_date != null && pref_adm_date.length()>0)
   {   
	   
	    int tot_daily = 99999;
		int tot_monthly = 99999;
		int max_daily = 99999;
		int max_monthly = 99999;
		StringBuffer cntSql = new StringBuffer();
		cntSql.append(" SELECT COUNT(*) tot_daily FROM IP_BOOKING_LIST WHERE ");
		/*Tuesday, April 20, 2010 , modified for Create Booking query tuining*/
		//cntSql.append(" TRUNC(preferred_date) = TRUNC(to_date(?,'dd/mm/rrrr hh24:mi')) ");
		cntSql.append(" preferred_date BETWEEN TRUNC(TO_DATE(?, 'dd/mm/rrrr hh24:mi')) AND TRUNC(TO_DATE(?, 'dd/mm/rrrr hh24:mi')) +0.9999");
		cntSql.append(" and facility_id=?  and med_ser_grp_code=?");
		cntSql.append(" and booking_status != '9'");
		PreparedStatement pstmt = con.prepareStatement(cntSql.toString());
		pstmt.setString(1,pref_adm_date);
		pstmt.setString(2,pref_adm_date);
		pstmt.setString(3,facilityid);
		pstmt.setString(4,med_service_grp);
		rs = pstmt.executeQuery();
		if(rs.next())
	    {
			tot_daily = rs.getInt("tot_daily");
	    }
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();

		StringBuffer monCount = new StringBuffer();
		monCount.append(" SELECT COUNT(*) tot_monthly FROM IP_BOOKING_LIST ");
		monCount.append(" WHERE TO_CHAR(to_date(?,'dd/mm/rrrr hh24:mi'),'mm/rrrr') = TO_CHAR(PREFERRED_DATE,'mm/rrrr')");
		monCount.append(" and facility_id=? and med_ser_grp_code=?  and booking_status != '9'");
	
		pstmt = con.prepareStatement(monCount.toString()); 
		pstmt.setString(1,pref_adm_date);
		pstmt.setString(2,facilityid);
		pstmt.setString(3,med_service_grp);
		rs = pstmt.executeQuery();
		if(rs.next())
		{
			tot_monthly = rs.getInt("tot_monthly");
		}
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();

		StringBuffer maxBook	= new StringBuffer();
		maxBook.append(" select generate_num_yn, max_no_of_dly_booking,");
		maxBook.append(" max_no_of_mthly_booking, next_seq_no,  max_seq_no ");
		maxBook.append(" from IP_MEDICAL_SERVICE_GROUP where facility_id='"+facilityid+"'");
		maxBook.append(" and med_ser_grp_code='"+med_service_grp+"'  order by 1");
	
		pstmt = con.prepareStatement(maxBook.toString());
        rs = pstmt.executeQuery();
        String str1 = "";
		long max_seq_no = 0;
		long next_seq_no = 0;
        if( rs != null )
        {
          while(rs.next())
          {
            str1		= rs.getString(1);
			max_daily	= rs.getInt("max_no_of_dly_booking");
			max_monthly = rs.getInt("max_no_of_mthly_booking");
			next_seq_no = rs.getLong("next_seq_no");
			max_seq_no	= rs.getLong("max_seq_no");

			if(str1.equals("Y") && next_seq_no > max_seq_no) 
			{	%>
			<script>
				alert(getMessage('CANNOT_EXCEED_MAX_SEQ_NO','IP'));
				/* parent.frames[1].document.forms[0].med_service_grp.value='';
				parent.frames[1].document.forms[0].med_service_grp.focus(); */
				parent.f_query_add_mod.document.getElementById("med_service_grp").value='';
				parent.f_query_add_mod.document.getElementById("med_service_grp").focus();
			</script>
		<%	}
			else if(max_daily!=0 && tot_daily!=0 &&  tot_daily>=max_daily)
		    {	%>
				<script>
				alert(getMessage('CANNOT_EXCEED_MAX_DLY_BKG','IP'));
				/* parent.frames[1].document.forms[0].med_service_grp.value='';
				parent.frames[1].document.forms[0].med_service_grp.focus(); */
				parent.f_query_add_mod.document.getElementById("med_service_grp").value='';
				parent.f_query_add_mod.document.getElementById("med_service_grp").focus();
				</script>
		 <%   }
			else if(max_monthly!=0 && tot_monthly!=0 && tot_monthly>=max_monthly )
			{	%>
				<script>alert(getMessage('CANNOT_EXCEED_MAX_MONTHLY_BKG','IP'));
				/* parent.frames[1].document.forms[0].med_service_grp.value='';
				parent.frames[1].document.forms[0].med_service_grp.focus(); */
				parent.f_query_add_mod.document.getElementById("med_service_grp").value='';
				parent.f_query_add_mod.document.getElementById("med_service_grp").focus();
				</script>
		<%	}

            if (str1.equals("Y"))
            {           
%>              <script>
            		/* parent.document.frames[1].document.forms[0].booking_ref_no.value="";
            		parent.document.frames[1].document.forms[0].booking_ref_no.disabled=true; */
					parent.f_query_add_mod.document.getElementById("booking_ref_no").value="";
					parent.f_query_add_mod.document.getElementById("booking_ref_no").disabled=true;
            	</script>
<%           	
            }
            else
            {
%>				<script>
					/* parent.document.frames[1].document.forms[0].booking_ref_no.value="";
					parent.document.frames[1].document.forms[0].booking_ref_no.disabled=false; */	
					
					parent.f_query_add_mod.document.getElementById("booking_ref_no").value="";
					parent.f_query_add_mod.document.getElementById("booking_ref_no").disabled=false;
				</script>
<%			}
		}
	}
        pstmt.close();   
		rs.close();
	}
}
   
/*** Pref Admission Date, AM/PM Validation ***/
if(source_type.equals("VAL_DATE"))
{
	
   String pref_adm_date = request.getParameter("pref_adm_date").trim();
  
   if(pref_adm_date != null && pref_adm_date.length()>0)
   {     
		StringBuffer sql1 = new StringBuffer();
		sql1.append(" SELECT sign(( sysdate+nvl(adv_bed_book_period_bkg,0)-(trunc(to_date('"+pref_adm_date+"','dd/mm/rrrr hh24:mi'))))) as valid_flag from IP_PARAM where facility_id = '"+facilityid+"' ");



        PreparedStatement pstmt = con.prepareStatement(sql1.toString());        
        rs = pstmt.executeQuery();
        int str1=0;       
 	if( rs != null )
	{
	  while(rs.next())
	  {	
	    str1 = rs.getInt(1);       
	   
	    if (str1 < 0)
	     {           
%>              <script>						

			alert(getMessage("PREFER_DATE_LT_EXCEEDED",'IP'));

			if('<%=isOTFunc%>'=='Y')
			 {
				parent.document.frames[1].document.forms[0].pref_adm_date.value = "";
				parent.document.frames[1].document.getElementById('DayVal').innerHTML = "";
				parent.document.frames[1].setDateValuesForOTFUnc();
			 }
			 else
			 {
				parent.document.frames[1].document.forms[0].pref_adm_date.focus();	
				parent.document.frames[1].document.forms[0].pref_adm_date.value = "";
				parent.document.frames[1].document.getElementById('DayVal').innerHTML = "";
			 }
		</script>
<%           }
	  }
	}
	pstmt.close(); 
	rs.close();
   }

}
/**Population of Room Number based on the value of Bed number **/
if(source_type.equals("VAL_ROOM_NO"))
{

   String bed_no = request.getParameter("bed_no");   
   String nursingunitcode = request.getParameter("nursunitcode");   
      
   if(bed_no != null)
   {      
		StringBuffer sql1 = new StringBuffer();
		sql1.append( " select room_no, specialty_code, AM_GET_DESC.AM_SPECIALITY(specialty_code,'"+locale+"','2') short_desc from IP_NURSING_UNIT_BED where facility_id = '"+facilityid+"' AND NURSING_UNIT_CODE='"+nursingunitcode+"' AND BED_NO= '"+bed_no+"' and PSEUDO_BED_YN='N' ");
        PreparedStatement pstmt = con.prepareStatement(sql1.toString());
        rs = pstmt.executeQuery();
        String roomVal= "";

	  if(rs!=null && rs.next())
	  {
	    roomVal = rs.getString(1);  
	    String splty_code = checkForNull(rs.getString(2));
		String splty_desc = checkForNull(rs.getString(3));
	
%>              <script>                       
			var spl = "<%=splty_code%>";
			
			parent.document.frames[1].document.forms[0].room_no.value = '';			
			parent.document.frames[1].document.forms[0].room_no.value = '<%=roomVal%>';	
			if(spl != parent.document.frames[1].document.forms[0].Splcode.value)
			{
			parent.document.frames[1].document.forms[0].Splcode_desc.value = "<%=splty_desc%>";
			parent.document.frames[1].document.forms[0].Splcode.value = "<%=splty_code%>";
			parent.document.frames[1].document.forms[0].practid_desc.value = "";
			parent.document.frames[1].document.forms[0].practid.value = "";
			}
			
		</script>
<%           

	}
	 else
	 {	
%>
	<script>			
	alert(getMessage("INVALID_BED","Common"));
	parent.document.frames[1].document.forms[0].bed_no.value = '';
	parent.document.frames[1].document.forms[0].room_no.value = '';
	
	</script>
<%			
	 }
	pstmt.close();
	rs.close();
   }
}
/**From Revise Booking**/
if(source_type.equals("REVISE_VAL_ROOM_NO"))
{
 

   String bed_no = request.getParameter("bed_no");   
   String nursingunitcode = request.getParameter("nursunitcode");   
      
   if(bed_no != null)
   {      
		
	StringBuffer sql1 = new StringBuffer();
	sql1.append(" select room_no,bed_class_code,nursing_unit_code, IP_GET_DESC.IP_NURSING_UNIT(FACILITY_ID, nursing_unit_code,'"+locale+"','2') nursing_unit_short_desc from IP_NURSING_UNIT_BED where facility_id = '"+facilityid+"' AND NURSING_UNIT_CODE like '"+nursingunitcode+"%' AND BED_NO= '"+bed_no+"'  and PSEUDO_BED_YN='N' ");

        PreparedStatement pstmt = con.prepareStatement(sql1.toString());
		rs = pstmt.executeQuery();
        String roomVal= "";
	    String bed_class = "";
		String nursing_unit_code = "";
		String nursing_unit_desc = "";
	  if(rs!=null && rs.next())
	  {
	    roomVal				= rs.getString(1); 
		bed_class			= rs.getString(2); 
		nursing_unit_code	= rs.getString(3); 
		nursing_unit_desc	= rs.getString(4); 
	    
%>              
	<script>                       
            parent.parent.document.frames[1].document.forms[0].room_no.value = '';			
			parent.document.frames[1].document.forms[0].room_no.value = '<%=roomVal%>';	
			parent.document.frames[1].document.forms[0].bed_class_code.value = '<%=bed_class%>';
			parent.document.frames[1].document.forms[0].nursing_unit.value = '<%=nursing_unit_code%>';
			parent.document.frames[1].document.forms[0].nursing_unit_desc.value = "<%=nursing_unit_desc%>";
			parent.document.frames[1].document.forms[0].override.disabled = false;
			//parent.frames[1].document.forms[0].pract_img.style.visibility="visible";
		</script>
<%           
	  }
	 else
	 {	
%>
	<script>
	alert(getMessage("INVALID_BED","IP"));
	parent.document.frames[1].document.forms[0].bed_no.value = '';
	parent.document.frames[1].document.forms[0].room_no.value = '';
	parent.document.frames[1].document.forms[0].bed_class_code.value = '';
	parent.document.frames[1].document.forms[0].nursing_unit.value = '';
	parent.document.frames[1].document.forms[0].nursing_unit_desc.value = '';
	parent.document.frames[1].document.forms[0].bed_no.focus();
	</script>
<%			
	 }
	pstmt.close();  
	rs.close();
   }
   else
{
	}
}

/**From Confirm Booking**/
if(source_type.equals("CONFIRM_VAL_ROOM_NO"))
{
 

   String bed_no = request.getParameter("bed_no");   
   String nursingunitcode = request.getParameter("nursunitcode");   
      
   if(bed_no != null)
   {      
		
	StringBuffer sql1 = new StringBuffer();
	sql1.append(" select room_no,bed_class_code,nursing_unit_code, IP_GET_DESC.IP_NURSING_UNIT(FACILITY_ID, nursing_unit_code,'"+locale+"','2') nursing_unit_short_desc from IP_NURSING_UNIT_BED where facility_id = '"+facilityid+"' AND NURSING_UNIT_CODE like '"+nursingunitcode+"%' AND BED_NO= '"+bed_no+"'  and PSEUDO_BED_YN='N' ");

        PreparedStatement pstmt = con.prepareStatement(sql1.toString());
		rs = pstmt.executeQuery();
        String roomVal= "";
	    String bed_class = "";
		String nursing_unit_code = "";
		String nursing_unit_desc = "";
	  if(rs!=null && rs.next())
	  {
	    roomVal				= rs.getString(1); 
		bed_class			= rs.getString(2); 
		nursing_unit_code	= rs.getString(3); 
		nursing_unit_desc	= rs.getString(4); 
	    
%>              
	<script>                       
            parent.parent.document.frames[1].document.forms[0].room_no.value = '';			
			parent.document.frames[1].document.forms[0].room_no.value = '<%=roomVal%>';	
			parent.document.frames[1].document.forms[0].Bedcode.value = '<%=bed_class%>';
			parent.document.frames[1].document.forms[0].nursing_unit.value = '<%=nursing_unit_code%>';
			parent.document.frames[1].document.forms[0].nursing_unit_desc.value = "<%=nursing_unit_desc%>";
			parent.document.frames[1].document.forms[0].override.disabled = false;
			parent.frames[1].document.forms[0].pract_img.style.visibility="visible";
		</script>
<%           
	  }
	 else
	 {	
%>
	<script>
	alert(getMessage("INVALID_BED","IP"));
	parent.document.frames[1].document.forms[0].bed_no.value = '';
	parent.document.frames[1].document.forms[0].room_no.value = '';
	parent.document.frames[1].document.forms[0].Bedcode.value = '';
	parent.document.frames[1].document.forms[0].nursing_unit.value = '';
	parent.document.frames[1].document.forms[0].nursing_unit_desc.value = '';
	parent.document.frames[1].document.forms[0].bed_no.focus();
	</script>
<%			
	 }
	pstmt.close();  
	rs.close();
   }
   else
{
	}
}

/** Confirm Button for Warnings **/

String error=request.getParameter( "err_num" );
	if ( error != null ) {
%>	
	
	<script>
	       
	    var errval = '<%=error%>';	        
		var confVal = window.confirm(errval);
		if (confVal) 
			window.alert(getMessage("WELCOME",'Common'));
		else  
			window.alert("Bye for now!");
	</script>
<%
	}
	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
}catch(Exception e){out.println(e); 
	e.printStackTrace(System.out) ;			

}
finally
{
	ConnectionManager.returnConnection(con,request);
}	
%>
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

