<!DOCTYPE html>
<%@ page import ="webbeans.eCommon.ConnectionManager,java.sql.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
	/* Below line added by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
	String   locale = (String)session.getValue("LOCALE");
	/*end SS-CRF-0010 [IN034516]*/
    String getopt = request.getParameter("getoption");
    //String loctype = request.getParameter("locn_type");
	String loccode = request.getParameter("locn_code");

	
	String allow_walk_in_yn="";
	String allow_referral_yn="";
	String allow_appt_yn="";

	String queue_num_other_res_class="";
	String roomNo="";
	/* Below line added by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
	String room_desc="";
	/*CRF end SS-CRF-0010 [IN034516]*/
	String res_class="";
	String short_desc = "";
    String clinic_code = "";
					
	Connection con = null;
    PreparedStatement pstmt = null;
	PreparedStatement roomNoPopulateStatement=null;
    ResultSet rs = null;
	ResultSet roomNoPopulateResult=null;

	try
	{
		con = ConnectionManager.getConnection(request);
		String globalfacilityId  =  (String) session.getValue( "facility_id" ) ;

		String opentoallpractyn = "";

		//if(getopt.equals("one"))
		//{
	  %>
			<html><head>
		 
		  <%
			String sStyle	=
			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>

			<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
			<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
			<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	  
			<!--
				<script>
				var element = parent.f_query_add_mod.document.createElement('OPTION');
				element.text = "-----"+getLabel('Common.defaultSelect.label','Common')+"-----";
                element.value= '';
                parent.f_query_add_mod.document.opqueuenumbering_form.locn_code.add(element);			
				</script>
			-->

	<%
			/*try
			{
				pstmt= con.prepareStatement("select clinic_code,long_desc from op_clinic where facility_id = '"+globalfacilityId+"' and clinic_type='"+loctype+"' and eff_status = 'E' order by long_desc");

                rs = pstmt.executeQuery() ;
                String short_desc = "";
                String clinic_code = "";
                if( rs != null ) 
                {
                    while( rs.next() ) 
                    {
                        short_desc = rs.getString( "long_desc" ) ;
                        clinic_code = rs.getString( "clinic_code" );*/
		%>
				<!-- <script>
					var element = parent.f_query_add_mod.document.createElement('OPTION');
					element.text = "<%=short_desc%>"; 
		            element.value= "<%=clinic_code%>";
			        parent.f_query_add_mod.document.opqueuenumbering_form.locn_code.add(element);
				</script>
				-->
    		<%
                 /*   }
                }

				if(rs != null ) rs.close();
				if(pstmt != null ) pstmt.close();

			} catch(Exception e) { out.println(e.toString());}

		}*/
		if(getopt.equals("two"))
	    {   
	%>		 
	
	<!-- <html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
        try
		{
			pstmt=con.prepareStatement("select open_to_all_pract_yn,ident_at_checkin,allow_appt_yn,allow_walk_in_yn,allow_referral_yn,QUEUE_NUM_APPL_YN,QUEUE_NUM_OTHER_RES_CLASS,QUEUE_NUM_OTHER_RES_TYPE,primary_resource_class from op_clinic where clinic_code='"+loccode+"' and facility_id='"+globalfacilityId+"' ");
			
            rs = pstmt.executeQuery() ;

            
				while( rs.next() )
                {
					opentoallpractyn = rs.getString("open_to_all_pract_yn");
                    
			        allow_walk_in_yn= rs.getString("allow_walk_in_yn");
					allow_referral_yn= rs.getString("allow_referral_yn");
					allow_appt_yn= rs.getString("allow_appt_yn");
				   
						
					queue_num_other_res_class=rs.getString("queue_num_other_res_class");
					
					
				    res_class=rs.getString("primary_resource_class");
					
					}
			
			if(rs != null ) rs.close();
			if(pstmt != null ) pstmt.close();			
			
%>

<script>

	
	parent.f_query_add_mod.document.opqueuenumbering_form.open_to_all_pract_yn.value = "<%=opentoallpractyn%>";

	parent.f_query_add_mod.document.opqueuenumbering_form.res_class.value = "<%=res_class%>";

<%-- Added by Tushar .T. Bhat on 19-Feb-04 --%>


<%

		if(!allow_walk_in_yn.equals("Y"))
			 {%>			 
				parent.f_query_add_mod.document.opqueuenumbering_form.walk_in.disabled=true			
		<%}else
			{%>
				parent.f_query_add_mod.document.opqueuenumbering_form.walk_in.disabled=false;				
		<%}

		if(!allow_appt_yn.equals("Y"))
			{%>
				parent.f_query_add_mod.document.opqueuenumbering_form.appointment.disabled=true;
				
		<%}else 
			{%>
			parent.f_query_add_mod.document.opqueuenumbering_form.appointment.disabled=false;		    
		<%}

		if(!allow_referral_yn.equals("Y"))
	    	{%>
				parent.f_query_add_mod.document.opqueuenumbering_form.referral.disabled=true;				
	   <%}else
		   {%>
			parent.f_query_add_mod.document.opqueuenumbering_form.referral.disabled=false;
		    
	  <%}%>

				
				
			


		

	var obj = parent.f_query_add_mod.document.opqueuenumbering_form.room_no1;
    var length  = obj.length;
    for(i=0;i<length;i++) {obj.remove(0);}
	roomNoOption=parent.f_query_add_mod.document.createElement('OPTION');
    roomNoOption.text="----------------"+parent.getLabel('Common.defaultSelect.label','Common')+"------------------";
    roomNoOption.value="*ALL";
    parent.f_query_add_mod.document.opqueuenumbering_form.room_no1.add(roomNoOption);
	parent.f_query_add_mod.document.opqueuenumbering_form.room_no1.disabled = false;
	
	<% //venkat this query was commented by venkatsh
	 
	 //String roomNoPopulateSql="select practitioner_id Room_no from op_pract_for_clinic where facility_id='"+globalfacilityId+"' and clinic_code='"+loccode+"' and eff_status='E' and resource_class='R' order by practitioner_id";
        
		/* Below line query modified by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
        String roomNoPopulateSql="SELECT a.practitioner_id ROOM_NO,am_get_desc.am_facility_room (a.facility_id,a.practitioner_id, '"+locale+"', 2) room_desc FROM op_pract_for_clinic a,  am_facility_room b WHERE a.facility_id='"+globalfacilityId+"' AND a.clinic_code='"+loccode+"' AND  a.eff_status='E'  AND  a.resource_class='R' AND  a.practitioner_id=b.room_num  AND a.facility_id=b.OPERATING_FACILITY_ID ";
		/*CRF end SS-CRF-0010 [IN034516]*/
		roomNoPopulateStatement=con.prepareStatement(roomNoPopulateSql);
        roomNoPopulateResult=roomNoPopulateStatement.executeQuery();
        while(roomNoPopulateResult.next())
        {  
	   roomNo=roomNoPopulateResult.getString("ROOM_NO"); 
	   /* Below line added by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
	   room_desc=roomNoPopulateResult.getString("room_desc");
	   /*CRF end SS-CRF-0010 [IN034516]*/
	 %>
		 
	 /*   roomNoOption=parent.f_query_add_mod.document.createElement('OPTION');
	   roomNoOption.text="<%=roomNo%>"+' '+"<%=room_desc%>";
	   roomNoOption.value="<%=roomNo%>";
	  
	   parent.f_query_add_mod.document.opqueuenumbering_form.room_no1.add(roomNoOption); */
	   
	   /* Below line added by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
	            var temp = "<%=room_desc%>";
				var temp1="<%=roomNo%>"+" "+"<%=room_desc%>";
				var temp2="<%=roomNo%>";
				var opt=parent.f_query_add_mod.document.createElement('OPTION');
				opt.text=temp1;
				opt.value=temp2;
				parent.f_query_add_mod.document.opqueuenumbering_form.room_no1.add(opt);
	 /*CRF end SS-CRF-0010 [IN034516]*/
	
        <%}
		
 		if(roomNoPopulateResult != null) roomNoPopulateResult.close();
		if(roomNoPopulateStatement != null ) roomNoPopulateStatement.close();
	
		%>
		
	<%String other_res=request.getParameter("other_res")==null?queue_num_other_res_class:request.getParameter("other_res");
	String desc="";
	roomNoPopulateSql="select  a.PRACTITIONER_ID Room_no, b.short_desc description from op_pract_for_clinic a, am_resource b  where a.FACILITY_ID='"+globalfacilityId+"' and a.CLINIC_CODE='"+loccode+"' and a.RESOURCE_CLASS='"+other_res+"' and a.FACILITY_ID=b.FACILITY_ID and a.resource_class=b.resource_class and a.PRACTITIONER_ID=b.resource_id order by 2";
    roomNoPopulateStatement=con.prepareStatement(roomNoPopulateSql);
    roomNoPopulateResult=roomNoPopulateStatement.executeQuery();
     while(roomNoPopulateResult.next())
      {  
		   roomNo=roomNoPopulateResult.getString("Room_no")==null?"":roomNoPopulateResult.getString("Room_no"); 
		   desc=roomNoPopulateResult.getString("description")==null?"":roomNoPopulateResult.getString("description"); 
		 
		 %>
		 roomNoOption=parent.f_query_add_mod.document.createElement('OPTION');
	     roomNoOption.text="<%=desc%>";
	     roomNoOption.value="<%=roomNo%>";
	   //  parent.f_query_add_mod.document.opqueuenumbering_form.room_no.add(roomNoOption);
	
		
       <%}%>
		
			
</script>
	
<%-- Added by Tushar .T. Bhat on 29-Jan-04 ends --%>

<%
				
			} catch(Exception e) { out.println(e.toString());}
	
		}else if(getopt.equals("three"))
		{
		   String other_res=request.getParameter("other_res");
		   String desc="";
		   String roomNoPopulateSql="select  a.PRACTITIONER_ID Room_no, b.short_desc description from op_pract_for_clinic a, am_resource b  where a.FACILITY_ID='"+globalfacilityId+"' and a.CLINIC_CODE='"+loccode+"' and a.RESOURCE_CLASS='"+other_res+"' and a.FACILITY_ID=b. FACILITY_ID and a.resource_class=b.resource_class and a.PRACTITIONER_ID=b.resource_id order by 2";
	  

	   roomNoPopulateStatement=con.prepareStatement(roomNoPopulateSql);
       roomNoPopulateResult=roomNoPopulateStatement.executeQuery();
       while(roomNoPopulateResult.next())
      {  
	  roomNo=roomNoPopulateResult.getString("Room_no")==null?"":roomNoPopulateResult.getString("Room_no");
	  desc=roomNoPopulateResult.getString("description")==null?"":roomNoPopulateResult.getString("description");
		   %>
	<script>
	roomNoOption=parent.f_query_add_mod.document.createElement('OPTION');
	roomNoOption.text="<%=desc%>";
	roomNoOption.value="<%=roomNo%>";

	
//	parent.f_query_add_mod.document.opqueuenumbering_form.room_no.add(roomNoOption);
	
</script>
		
    <%  }
		
		if(roomNoPopulateResult != null) roomNoPopulateResult.close();
		if(roomNoPopulateStatement != null) roomNoPopulateStatement.close();

		}	
	
%>		
		</head><body CLASS='MESSAGE' onKeyDown = 'lockKey();'></body></html>
<%	
	}
	catch(Exception ec){ out.println("in exception :"+ec); }
	finally
	{
	      if (rs != null)       rs.close();
		  if (pstmt != null)    pstmt.close();
    
		  if(roomNoPopulateResult!=null)	roomNoPopulateResult.close();
		  if(roomNoPopulateStatement!=null)	roomNoPopulateStatement.close();

		  if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>
    

