<!DOCTYPE html>
<!-- @ The Page is from New Born Registration on change of gender field the relation is populated. -->
<%@ page import ="java.sql.*,webbeans.eCommon.*,java.util.*,eCommon.Common.CommonBean" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
	<HEAD>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'>
		 <Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
		 <Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
		</link>
		<script>
		function callchangeid(val,days,sysdate)
		{

		}
		</script>
	</HEAD>
<body CLASS='MESSAGE' onKeyDown='lockKey();'>
<!-- @ Get The Connection and declare the prepared stmt. -->
<%
	Connection con = null;
	PreparedStatement pstmt1 = null;
	ResultSet rset = null;
%>
<!-- @ Declare the Variables. -->
<%
	request.setCharacterEncoding("UTF-8");
	String locale =((String)session.getAttribute("LOCALE"));
	String facilityId  = (String) session.getValue("facility_id");
   	String strSex = request.getParameter("Sex");
	String strFrom = request.getParameter("from");
    Properties p		= (java.util.Properties) session.getValue("jdbc"); 
	String callfunction = checkForNull(request.getParameter("callfunction"));
	String expdate_from = checkForNull(request.getParameter("expdate_from"));
	String patient_id1 = checkForNull(request.getParameter("patient_id1"));
	String function_id_mg = checkForNull(request.getParameter("function_id_mg"));
	String function_id = checkForNull(request.getParameter("function_id"));
	String outcome = checkForNull(request.getParameter("outcome"));
	String callgetNewBornRegnFn = checkForNull(request.getParameter("callgetNewBornRegnFn"));

	String pat_ser_grp_code = checkForNull(request.getParameter("pat_ser_grp_code"));
	String encounter_id = checkForNull(request.getParameter("encounter_id"));
	String mother_nursing_unit = checkForNull(request.getParameter("mother_nursing_unit"));
	String sqlRelation = null;
	String strRelationShip = null;
	String strRelationShipCode = null;
	String pat_code_date="";
	String sysdate="";
	String sysadd="";
	int intFlag = 0;
	
	//newly added

	%>
	<script>
		var frame_ref = "";
		if('<%=function_id_mg%>'=='MAINTAIN_BIRTH')
			frame_ref="parent.frames[1].frames[2]";
		else
			frame_ref="parent.frames[1].frames[2]";

			//alert('from jsp'+eval(frame_ref).location.href);
			
	</script>
	<%


if(callfunction.equals("patcatprefix"))
{
	try{
		con = ConnectionManager.getConnection(request);
	%>
			<script>
		    if(eval(frame_ref).document.forms[0].relation_child11){
			var n = eval(frame_ref).document.forms[0].relation_child11.options.length;
			for(var i=0;i<n;i++)
			{
					eval(frame_ref).document.forms[0].relation_child11.remove("relation_child11");				
			
			}	
	}
			</script>
		<%
			ArrayList hash_category=new ArrayList();
			String patient_id=request.getParameter("patient_id11");
			String chkvalue=(request.getParameter("prefix"));
			String relvalue=request.getParameter("relation_child");
			hash_category   = eMP.NewbornDetails.getPatCatogery(con,patient_id,chkvalue,relvalue,p);
		if(hash_category.size()>0)
		{
				for(int i=0;i<hash_category.size();i+=2 )
				{
					%>
					<script>
						if(eval(frame_ref).document.forms[0].relation_child11){
						var temp = "<%=(String) hash_category.get(i+1)%>";
						var temp1="<%=(String) hash_category.get(i)%>";
					var opt=eval(frame_ref).document.createElement("OPTION");	
					opt.text=temp1;
					opt.value=temp;
					eval(frame_ref).document.forms[0].relation_child11.add(opt);
					}
					
					</script>
					<%
				}

		
		
				HashMap hasmap_expdate=new HashMap();
				hasmap_expdate=eMP.NewbornDetails.getExpcatdate(con,(String) hash_category.get(1),p);
				String EXP_VAL_APPL_YN=checkForNull((String)hasmap_expdate.get("EXP_VAL_APPL_YN"));
				String sysaddd=checkForNull((String)hasmap_expdate.get("sysadd"));
				if(EXP_VAL_APPL_YN.equals("Y"))
				{%>
					<script>
                     eval(frame_ref).document.forms[0].exp_cat_date.value="<%=sysaddd%>";
					 eval(frame_ref).document.forms[0].exp_cat_date.disabled=false
				eval(frame_ref).document.getElementById('callimag').disabled=false;
					</script>
				<%}
				else
				{%>
				  <script>	
			    eval(frame_ref).document.forms[0].exp_cat_date.value='';	eval(frame_ref).document.forms[0].exp_cat_date.disabled=true;				eval(frame_ref).document.getElementById('callimag').disabled=true;
				 </script>
				<%}
	}
	else{%>
        <script>   
	if(eval(frame_ref).document.forms[0].relation_child11){	
	eval(frame_ref).document.forms[0].relation_child11.selectedIndex=0;
	}
			</script>
		<%}
	}catch(Exception e)
	{		
		e.printStackTrace();
	}
	finally
	{	
	  if(con!=null) ConnectionManager.returnConnection(con,request);
	}

} else if(callfunction.equals("callOnlineReports")) {

	try
		{
			String sqlString = "";
			
			//sqlString = "select distinct A.report_id,B.report_desc, 1 no_of_copies, b.module_id from mp_online_reports A, sm_report_lang_vw B, sm_print_routing c where A.pat_ser_grp_code = '"+pat_ser_grp_code+"' and A.print_reqd_yn='Y' AND B.language_id='"+locale+"' and B.report_id=A.report_id and a.report_id = c.report_id (+) and NVL(c.facility_id,'"+facilityId+"')='"+facilityId+"' and A.report_id in ('MPBNBFRM', 'MPBWBLBL') order by 2";  		
			sqlString = "select distinct A.report_id,B.report_desc, 1 no_of_copies, b.module_id from mp_online_reports A, sm_report_lang_vw B, sm_print_routing c where A.pat_ser_grp_code = '"+pat_ser_grp_code+"' and A.print_reqd_yn='Y' AND B.language_id='"+locale+"' and B.report_id=A.report_id and a.report_id = c.report_id (+) and NVL(c.facility_id,'"+facilityId+"')='"+facilityId+"'";  		

			//Modified the below validations against HSA-SCF-0059  - Start
			if(outcome.equals("L")){
				//sqlString = sqlString + " and A.report_id in ('MPBNBFRM','MPBFRNST','MPBFLLBL','MPBIDLBL','MPBWBLBL','MPBPTLBL') order by 2";
				//sqlString = sqlString + " and A.report_id in ('MPBNBFRM','MPBFRNST','MPBIDLBL','MPBWBLBL','MPBPTLBL' ";
				sqlString = sqlString + " and A.report_id in ('MPBNBFRM','MPBWBLBL','MPBPTLBL' ";
			}else{
				//sqlString = sqlString + " and A.report_id in ('MPSTBCER') order by 2";
				sqlString = sqlString + " and A.report_id in ('MPSTBCER' ";
			}
			con 	= ConnectionManager.getConnection(request);
			boolean blocPatientFileExists = CommonBean.isPatientFileExists(con,patient_id1,facilityId);

			Boolean isRemoveReport = CommonBean.isSiteSpecific(con, "MP","REMOVE_REP_FROM_NEWBORN");	// Added By Dharma on May 26th 2015 against HSA-CRF-0228 [IN:050965]
			/*Added by Dharma on May 26th 2015 aginst against HSA-CRF-0228 [IN:050965] Start*/
			/*Removed MPBFRNST, MPBIDLBL report ids from above sqlString variable*/
			if(!isRemoveReport){
				sqlString	= sqlString + " , 'MPBFRNST' , 'MPBIDLBL' ";
			}

			/*Added by Dharma on May 26th 2015 aginst against HSA-CRF-0228 [IN:050965] End*/
			if(blocPatientFileExists)
				sqlString = sqlString + " ,'MPBFLLBL') order by 2";
			else
				sqlString = sqlString + ") order by 2";
			//Modified the validations against HSA-SCF-0059  - End
			
			
			String temp_encounter_id="";
			if(encounter_id.equals("")){
				temp_encounter_id="TEMP*12*";
			}
			String reportParamNames	 = "p_patient_id,p_facility_id,p_encounter_id,p_function_id";
		    String reportParamValues = ""+patient_id1+","+facilityId+","+temp_encounter_id+","+function_id+"";
			String htmlFor = "";
			
			htmlFor = htmlFor +" <html><head> <link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link>";
			htmlFor = htmlFor +"</head><body class='message'>";
			htmlFor = htmlFor +"<script language = 'JavaScript'>" ;
			htmlFor = htmlFor +"  var dialogHeight    = '30' ;";
			htmlFor = htmlFor + " var dialogWidth = '70' ;";
			htmlFor = htmlFor +"  var arguments =   ''; ";
			// modified the below line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the below Query String.
			htmlFor = htmlFor +"  var getUrl        =   '../../eCommon/jsp/InternalReportsPrint.jsp?P_function_id=NEWBORN_REG&step=1&sqlString="+java.net.URLEncoder.encode(sqlString)+"&Patient_ID="+patient_id1+"&dest_locn_type=N&dest_locn_code="+mother_nursing_unit+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"&P_function_id="+function_id+"';";
			htmlFor = htmlFor +" var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;' ;";
			htmlFor = htmlFor +"  retVal =   window.showModalDialog(getUrl,arguments,features); ";
			htmlFor = htmlFor +" </script>";
			out.println(htmlFor);			
	} catch(Exception e) {
		e.printStackTrace();
	} finally {
		if(rset!=null) rset.close();
		if(pstmt1!=null) pstmt1.close();
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}

} else if(callfunction.equals("Membership")) {
		if(strSex.equals("M"))
		{			
			sqlRelation = "SELECT relationship_code,SHORT_DESC  FROM MP_RELATIONSHIP_lang_vw  WHERE RELATIONSHIP_CODE = (SELECT NB_MALE_RELNSHIP FROM MP_PARAM) and language_id='"+locale+"'";			
		}
		else if(strSex.equals("F"))
		{			
			sqlRelation = "SELECT relationship_code,short_desc FROM MP_RELATIONSHIP_lang_vw WHERE RELATIONSHIP_CODE =	(SELECT NB_FEMALE_RELNSHIP FROM MP_PARAM) and language_id='"+locale+"'";
		}
		else if(strSex.equals("U"))
		{			
			sqlRelation = "SELECT relationship_code ,short_desc FROM MP_RELATIONSHIP_lang_vw WHERE RELATIONSHIP_CODE =	(SELECT NB_UNKNOWN_RELNSHIP FROM MP_PARAM) and language_id='"+locale+"'";			
		}
		else 
		{
			sqlRelation = "SELECT relationship_code ,short_desc FROM MP_RELATIONSHIP_lang_vw where language_id='"+locale+"'";
		}
%>
<script>
var varFrom = '<%=strFrom%>' ;
if(varFrom == 'Birth')
{
var n = eval(frame_ref).document.forms[0].sltRelationship.options.length;
}
else
{
	var n = eval(frame_ref).document.forms[0].sltRelationship.options.length;
}
		for(var i=0;i<n;i++)
		{
			if(varFrom == 'Birth')
			{
			eval(frame_ref).document.forms[0].sltRelationship.remove("sltRelationship");				
			}
			else
			{
			eval(frame_ref).document.forms[0].sltRelationship.remove("sltRelationship");		
			}
}					
	</script>	        
<%
try{
	con = ConnectionManager.getConnection(request);
	HashMap hash17=new HashMap();
	String patient_id2=request.getParameter("patient_id");	
	hash17=eMP.NewbornDetails.getNewBornInMaintain(con,patient_id2);
	String relationship_to_head=checkForNull((String) hash17.get("RELATIONSHIP_TO_HEAD"));
	

try{
		pstmt1 = con.prepareStatement(sqlRelation);
		rset = pstmt1.executeQuery();		
		if(rset != null)
			{
			
			while(rset.next())
			{
				intFlag = 1;
				strRelationShipCode = rset.getString("RELATIONSHIP_CODE");
				strRelationShip = rset.getString("short_desc");					
%>
			<script>
				var temp = "<%=strRelationShipCode%>";
				var temp1="<%=strRelationShip%>";
			//	alert(temp);
			//	alert(temp1);
				if(varFrom == 'Birth')
				{
			var opt=eval(frame_ref).document.createElement("OPTION");
				}
				else
				{
			var opt=eval(frame_ref).document.createElement("OPTION");
				}

				
				opt.text=temp1;
				opt.value=temp;
			
			if(varFrom == 'Birth')
				{
			eval(frame_ref).document.forms[0].sltRelationship.add(opt);
				}
				else
				{
			eval(frame_ref).document.forms[0].sltRelationship.add(opt);
				}	
				//alert(eval(frame_ref).document.forms[0].sltRelationship.value);
			</script>
<%
			}
		}

	}
	catch(Exception e)
	 {
		out.println(e.toString());
		e.printStackTrace();
	}
	finally
	{
		if(rset != null)rset.close();
		if(pstmt1 != null)pstmt1.close();
	}
	if(intFlag == 0)
	{
	%>
		<script>
		var tp = "--"+eval(frame_ref).getLabel("Common.defaultSelect.label","Common")+"---";
			var opt=parent.frames[1].document.createElement("OPTION");
			opt.text=tp;
			opt.value="";
			eval(frame_ref).document.forms[0].sltRelationship.add(opt);
		</script>
	<%
		try{
		sqlRelation = "SELECT RELATIONSHIP_CODE, SHORT_DESC FROM MP_RELATIONSHIP_lang_vw where EFF_STATUS = 'E' and language_id='"+locale+"'ORDER BY 2";
		pstmt1 = con.prepareStatement(sqlRelation);
		rset = pstmt1.executeQuery();
			if(rset != null)
			{
				while(rset.next())
				{
				intFlag = 1;
				strRelationShipCode = rset.getString("RELATIONSHIP_CODE");
				strRelationShip = rset.getString("short_desc");	
%>
			<script>
				var temp = "<%=strRelationShipCode%>";
				var temp1="<%=strRelationShip%>";

				if(varFrom == 'Birth')
				{
			var opt=eval(frame_ref).document.createElement("OPTION");
				}
				else
				{
			var opt=eval(frame_ref).document.createElement("OPTION");
				}	
				
				opt.text=temp1;
				opt.value=temp;
				if("<%=relationship_to_head%>"==temp){
				//ert('coming');
				    opt.selected=true; 
					}

			
				
				
			if(varFrom == 'Birth')
				{
			eval(frame_ref).document.forms[0].sltRelationship.add(opt);
				}
				else
				{
			eval(frame_ref).document.forms[0].sltRelationship.add(opt);
				}		
			</script>
<%
				}
			}
		}
		catch(Exception e)
		{
			out.println(e.toString());
			e.printStackTrace();
		}
		finally
		{
			if(rset != null)rset.close();
			if(pstmt1 != null)pstmt1.close();		
		}

	}
}
catch(Exception e)
		{
			out.println(e.toString());
			e.printStackTrace();
		}
		finally
		{	
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}


if(intFlag == 0)
	{
		out.println("For The Gender No Relationship found");
	}

	if(callgetNewBornRegnFn.equals("Y")) {
		%>
		<script>		
			parent.frames[1].frames[2].getNewBornRegnValues('pat_id');
		</script>
		<%
	}

}	///
else if(callfunction.equals("namechange"))
	{
       try
	    {
		  HashMap hashMap2=new HashMap();
		  String name="";
		  con = ConnectionManager.getConnection(request);
		  hashMap2 = eMP.NewbornDetails.getNBMotherDtls(patient_id1, con,p);
		  name=checkForNull((String)hashMap2.get("q_mother_patient_name"));
		  %>
			  <script>
			  eval(frame_ref).document.getElementById('name_moth').innerText="<%=name%>"
			  </script>
          <%
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}

	}
	else if(callfunction.equals("expcatdate"))
	{
		try{
			
			  pat_code_date=checkForNull(request.getParameter("cat_code"));
			 con = ConnectionManager.getConnection(request);
			 String sql="select to_char(sysdate,'dd/mm/yyyy') sysdate11,to_char(sysdate+EXP_PERIOD_IN_DAYS,'dd/mm/yyyy') sysadd, EXP_VAL_APPL_YN,EXP_PERIOD_IN_DAYS from mp_pat_category where PAT_CAT_CODE='"+pat_code_date+"'";
			 pstmt1 = con.prepareStatement(sql);
		     rset = pstmt1.executeQuery();
			 String exp_val_appl_yn="";
			 String exp_period_in_days="";
			 if(rset.next())
			 {
				 exp_val_appl_yn=rset.getString("EXP_VAL_APPL_YN");
				 exp_period_in_days=rset.getString("EXP_PERIOD_IN_DAYS");
				 sysdate=rset.getString("sysdate11");
				 sysadd=rset.getString("sysadd");

			 }
			  if(expdate_from.equals("maintain")){
				  if(exp_val_appl_yn.equals("Y"))
			 {%>
				 <script>
				 
				  eval(frame_ref).document.forms[0].exp_cat_date.value='<%=sysadd%>';
				  eval(frame_ref).document.getElementById('expcatdate').disabled=false;
				  eval(frame_ref).document.getElementById('callimag').disabled=false;
				 </script>
			 <%}else{%>
					 <script>
				
				  eval(frame_ref).document.forms[0].exp_cat_date.value='';
				  eval(frame_ref).document.getElementById('expcatdate').disabled=true;
				  eval(frame_ref).document.getElementById('callimag').disabled=true;

				 </script>
				 <%}
			  }
			  else
			  {
			 if(exp_val_appl_yn.equals("Y"))
			 {%>
				 <script>
				 
				  eval(frame_ref).document.forms[0].exp_cat_date.value='<%=sysadd%>';
				  eval(frame_ref).document.getElementById('expcatdate').disabled=false;
				  eval(frame_ref).document.getElementById('callimag').disabled=false;
				 </script>
			 <%}else{%>
					 <script>
				
				  eval(frame_ref).document.forms[0].exp_cat_date.value='';
				  eval(frame_ref).document.getElementById('expcatdate').disabled=true;
				  eval(frame_ref).document.getElementById('callimag').disabled=true;

				 </script>
				 <%}}

		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{	
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
	}
	else{
	
		if(strFrom.equals("NEWBORN")){
			String relvalue="";
			ArrayList hash_category=new ArrayList();

	try{
	      con = ConnectionManager.getConnection(request);
	  try{
       
	    ArrayList arraylist14	=  eMP.NewbornDetails.getRelationship(con,p);
	   HashMap hash	=  eMP.NewbornDetails.getNewBornRelation(con,p);
	   String nb_female_relnship=(String)hash.get("nb_female_relnship");
	  // String female_relation_desc=(String)hash.get("female_relation_desc");
	   String nb_male_relnship=(String)hash.get("nb_male_relnship");
	   //String male_relation_desc=(String)hash.get("male_relation_desc");
	   String nb_unknown_relnship=(String)hash.get("nb_unknown_relnship");
	  // String unknown_relation_desc=(String)hash.get("unknown_relation_desc");
	   String relation_desc="";
	   String relation_code="";
	   String chkvalue="";
	   if(strSex.equals("M")){
		   chkvalue=nb_male_relnship;
	   }
	  else  if(strSex.equals("F")){
		   chkvalue=nb_female_relnship;
	   }
	  else if(strSex.equals("U")){
		   chkvalue=nb_unknown_relnship;
	   }

       relvalue=chkvalue;
		    
	%>
		<script>
		var n = eval(frame_ref).document.forms[0].relation_child.options.length;
		for(var i=0;i<n;i++)
		{
			eval(frame_ref).document.forms[0].relation_child.remove("relation_child");		
		}	
			</script>
	<%
		for(int i=0;i<arraylist14.size();i+=2)
		{
			relation_desc=(String)arraylist14.get(i);
			relation_code=(String)arraylist14.get(i+1);

		%>
		<script>
				var temp1 = "<%=relation_desc%>";
				var temp="<%=relation_code%>";
				
			var opt=eval(frame_ref).document.createElement("OPTION");
			opt.text=temp1;
			opt.value=temp;
			//alert("temp1"+temp1+"chkval"+'<%=chkvalue%>')
			if('<%=chkvalue%>'==temp){
				//ert('coming');
				    opt.selected=true; 
			}
			eval(frame_ref).document.forms[0].relation_child.add(opt);
				
			</script>
			<%}%>					
           
		<%}catch(Exception e)
		{
			e.printStackTrace();
		}
	 intFlag = 0;
%>
<!-- @ Query For the Relation Ship. -->
<%
String name_prefix_male_nb="";       
String name_prefix_female_nb="";       
String sql="select  name_prefix_male_nb,name_prefix_female_nb from mp_param_lang_vw where language_id='"+localeName+"' and module_id='MP'";

		pstmt1 = con.prepareStatement(sql);
		rset = pstmt1.executeQuery();
		if(rset.next())
		{
               name_prefix_male_nb=rset.getString("name_prefix_male_nb");
               name_prefix_female_nb=rset.getString("NAME_PREFIX_FEMALE_NB");
		}
        if(pstmt1!=null) pstmt1.close();
        if(rset!=null) rset.close();
        String chkvalue="";
			if(strSex.equals("M"))
			   chkvalue=name_prefix_male_nb;
		     else if(strSex.equals("F"))
               chkvalue=name_prefix_female_nb;
        if(locale.toUpperCase().equals("EN"))
		 { 
		if(!strSex.equals("U"))
		sqlRelation="SELECT name_prefix, prefix_sex FROM mp_name_prefix WHERE eff_status = 'E' and PREFIX_SEX in('"+strSex+"','B') order by NAME_PREFIX";
		else
		sqlRelation="SELECT name_prefix, prefix_sex FROM mp_name_prefix WHERE eff_status = 'E'  order by NAME_PREFIX";
		 }else
		  {if(!strSex.equals("U"))
		sqlRelation="SELECT (CASE WHEN NAME_PREFIX_LOC_LANG IS NOT NULL THEN NAME_PREFIX_LOC_LANG ELSE  NAME_PREFIX END) NAME_PREFIX, prefix_sex FROM mp_name_prefix WHERE eff_status = 'E' and PREFIX_SEX in('"+strSex+"','B') order by NAME_PREFIX";
		else
		sqlRelation="SELECT (CASE WHEN NAME_PREFIX_LOC_LANG IS NOT NULL THEN NAME_PREFIX_LOC_LANG ELSE  NAME_PREFIX END) NAME_PREFIX, prefix_sex FROM mp_name_prefix WHERE eff_status = 'E'  order by NAME_PREFIX";
		  
		  }
%>
<script>
var varFrom = '<%=strFrom%>' ;
var n = eval(frame_ref).document.forms[0].sltRelationship.options.length;
		for(var i=0;i<n;i++)
		{
				eval(frame_ref).document.forms[0].sltRelationship.remove("sltRelationship");				
		
		}					
	</script>	        
<%

try{
		pstmt1 = con.prepareStatement(sqlRelation);
		rset = pstmt1.executeQuery();		
		if(rset != null)
			{
			
			while(rset.next())
			{
				intFlag = 1;
				strRelationShipCode = rset.getString("name_prefix");
				//strRelationShip = rset.getString("short_desc");		
%>
			<script>
				var temp = "<%=strRelationShipCode%>";
				var temp1="<%=strRelationShipCode%>";
				
			var opt=eval(frame_ref).document.createElement("OPTION");
			opt.text=temp1;
			opt.value=temp;
			if(temp=="<%=chkvalue%>")
			{
					 opt.selected = true;
			}
			eval(frame_ref).document.forms[0].sltRelationship.add(opt);
			
			</script>
<%
			}
		}
		//Newly added by Shyam
		String entitlement_by_pat_cat_ynhd=checkForNull(request.getParameter("entitlement_by_pat_cat_ynhd"));
		if(entitlement_by_pat_cat_ynhd.equals("Y")){%>
			<script>
			if(eval(frame_ref).document.forms[0].relation_child11){
			var n = eval(frame_ref).document.forms[0].relation_child11.options.length;
			for(var i=0;i<n;i++)
			{
					eval(frame_ref).document.forms[0].relation_child11.remove("relation_child11");				
			
			}	
		}
			</script>
		<%
		 String patient_id=request.getParameter("patient_id");
        hash_category   = eMP.NewbornDetails.getPatCatogery(con,patient_id,chkvalue,relvalue,p);
		
		if(hash_category.size()>0)
		{
				for(int i=0;i<hash_category.size();i+=2 )
				{
					%>
					<script>
						if(eval(frame_ref).document.forms[0].relation_child11){
						var temp = "<%=(String) hash_category.get(i+1)%>";
						var temp1="<%=(String) hash_category.get(i)%>";
					var opt=eval(frame_ref).document.createElement("OPTION");	
					opt.text=temp1;
					opt.value=temp;
					eval(frame_ref).document.forms[0].relation_child11.add(opt);
					}
					</script>
					<%

				}
		}else{%>
        <script> 
			if(eval(frame_ref).document.forms[0].relation_child11){
					var opt=eval(frame_ref).document.createElement("OPTION");	
					opt.text="---Select---";
					opt.value="";
					eval(frame_ref).document.forms[0].relation_child11.add(opt);
				//eval(frame_ref).document.forms[0].relation_child11.selectedIndex=0;
			}
			</script>
		<%}
		//end
		if(hash_category.size()>0){
				HashMap hasmap_expdate=new HashMap();
				hasmap_expdate=eMP.NewbornDetails.getExpcatdate(con,(String) hash_category.get(1),p);
				String EXP_VAL_APPL_YN=checkForNull((String)hasmap_expdate.get("EXP_VAL_APPL_YN"));
				String sysaddd=checkForNull((String)hasmap_expdate.get("sysadd"));
				if(EXP_VAL_APPL_YN.equals("Y"))
				{%>
					<script>
                     eval(frame_ref).document.forms[0].exp_cat_date.value="<%=sysaddd%>";
					 eval(frame_ref).document.forms[0].exp_cat_date.disabled=false;
				eval(frame_ref).document.getElementById('callimag').disabled=false;
					</script>
				<%}
				else
				{%>
				  <script>	
			    eval(frame_ref).document.forms[0].exp_cat_date.value='';	eval(frame_ref).document.forms[0].exp_cat_date.disabled=true;
				eval(frame_ref).document.getElementById('callimag').disabled=true;
				 </script>
				<%}
			}
				
		}

	}
	catch(Exception e)
	 {
		out.println(e.toString());
		e.printStackTrace();
	}
	finally
	{
		if(rset != null)rset.close();
		if(pstmt1 != null)pstmt1.close();
	}
	
	

	
}
catch(Exception e)
		{
			out.println(e.toString());
			e.printStackTrace();
		}
		finally
		{	
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}

%>
<!-- @ if No Records Found. -->
<%
if(intFlag == 0)
	{
		out.println("For The Gender No Relationship found");
	}
	
}

else{
	  String name_prefix="";
	try{
	      HashMap hash_mp_maintan=new HashMap();
		  String patient_id=request.getParameter("patient_id");
		  con = ConnectionManager.getConnection(request);
		  hash_mp_maintan=eMP.NewbornDetails.getNewBornInMaintain(con,patient_id);
		   name_prefix=checkForNull((String) hash_mp_maintan.get("name_prefix"));
		  String relationship_to_head=checkForNull((String) hash_mp_maintan.get("RELATIONSHIP_TO_HEAD"));
		  String pat_cat_code=checkForNull((String) hash_mp_maintan.get("pat_cat_code"));
		  
		  

	  try{
       
	  ArrayList arraylist14	=  eMP.NewbornDetails.getRelationship(con,p);
	   
	   String relation_desc="";
	   String relation_code="";
	    %>
		<script>
		var n = eval(frame_ref).document.forms[0].relation_child.options.length;
		for(var i=0;i<n;i++)
		{
			eval(frame_ref).document.forms[0].relation_child.remove("relation_child");		
		}	
			</script>
	<%
		for(int i=0;i<arraylist14.size();i+=2)
		{
			relation_desc=(String)arraylist14.get(i);
			relation_code=(String)arraylist14.get(i+1);

		%>
		<script>
				var temp1 = "<%=relation_desc%>";
				var temp="<%=relation_code%>";
				
			var opt=eval(frame_ref).document.createElement("OPTION");
			opt.text=temp1;
			opt.value=temp;
			if('<%=relationship_to_head%>'==temp){
				//ert('coming');
				    opt.selected=true; 
			}
			eval(frame_ref).document.forms[0].relation_child.add(opt);
				
			</script>
			<%
			}
			ArrayList hash_category=new ArrayList();
			String mother_patient_id1=request.getParameter("mother_patient_id1");
			hash_category   = eMP.NewbornDetails.getPatCatogery(con,mother_patient_id1,name_prefix,relationship_to_head,p);
		if(hash_category.size()>0)
		{
				for(int i=0;i<hash_category.size();i+=2 )
				{
					%>
					<script>
						if(eval(frame_ref).document.forms[0].relation_child11){
						var temp = "<%=(String) hash_category.get(i+1)%>";
						var temp1="<%=(String) hash_category.get(i)%>";
					var opt=eval(frame_ref).document.createElement("OPTION");	
					opt.text=temp1;
					opt.value=temp;
				   if("<%=pat_cat_code%>"==temp)
					  opt.selected=true; 
					eval(frame_ref).document.forms[0].relation_child11.add(opt);
					}
					
					</script>
					<%

				}
		}
		else{%>
        <script>   
			if(eval(frame_ref).document.forms[0].relation_child11)
		eval(frame_ref).document.forms[0].relation_child11.selectedIndex=0;
			</script>
		<%}
			if(hash_category.size()>0){
				HashMap hasmap_expdate=new HashMap();
				hasmap_expdate=eMP.NewbornDetails.getExpcatdate(con,(String) hash_category.get(1),p);
				String EXP_VAL_APPL_YN=checkForNull((String)hasmap_expdate.get("EXP_VAL_APPL_YN"));
				String sysaddd=checkForNull((String)hasmap_expdate.get("sysadd"));
				if(EXP_VAL_APPL_YN.equals("Y"))
				{%>
					<script>
                     eval(frame_ref).document.forms[0].exp_cat_date.value="<%=sysaddd%>";
					 eval(frame_ref).document.forms[0].exp_cat_date.disabled=false;
					 eval(frame_ref).document.getElementById('callimag').disabled=false;
					</script>
				<%}
				else
				{%>
				  <script>	
					eval(frame_ref).document.forms[0].exp_cat_date.value='';
					eval(frame_ref).document.forms[0].exp_cat_date.disabled=true;
					eval(frame_ref).document.getElementById('callimag').disabled=true;
				 </script>
				<%}
			}
						
           
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
     
	

	 intFlag = 0;
%>
<!-- @ Query For the Relation Ship. -->
<%
       if(locale.toUpperCase().equals("EN"))
		{
        if(!strSex.equals("U"))
		sqlRelation="SELECT name_prefix, prefix_sex FROM mp_name_prefix WHERE eff_status = 'E' and PREFIX_SEX in('"+strSex+"','B') order by NAME_PREFIX";
		else
		sqlRelation="SELECT name_prefix, prefix_sex FROM mp_name_prefix WHERE eff_status = 'E'  order by NAME_PREFIX";
		}else
		{
		if(!strSex.equals("U"))
		sqlRelation="SELECT (CASE WHEN NAME_PREFIX_LOC_LANG IS NOT NULL THEN NAME_PREFIX_LOC_LANG ELSE  NAME_PREFIX END) NAME_PREFIX , prefix_sex FROM mp_name_prefix WHERE eff_status = 'E' and PREFIX_SEX in('"+strSex+"','B') order by NAME_PREFIX";
		else
		sqlRelation="SELECT (CASE WHEN NAME_PREFIX_LOC_LANG IS NOT NULL THEN NAME_PREFIX_LOC_LANG ELSE  NAME_PREFIX END) MP_NAME_PREFIX, prefix_sex FROM mp_name_prefix WHERE eff_status = 'E'  order by NAME_PREFIX";
		}
%>
<script>
   
    var n = eval(frame_ref).document.forms[0].sltRelationship.options.length;
	for(var i=0;i<n;i++)
		{
			eval(frame_ref).document.forms[0].sltRelationship.remove("sltRelationship");		
		
		}					
	</script>	        
<%

try{
		pstmt1 = con.prepareStatement(sqlRelation);
		rset = pstmt1.executeQuery();		
		if(rset != null)
			{
			
			while(rset.next())
			{
				intFlag = 1;
				strRelationShipCode = rset.getString("name_prefix");
				//strRelationShip = rset.getString("short_desc");		
%>
			<script>
				var temp = "<%=strRelationShipCode%>";
				var temp1="<%=strRelationShipCode%>";
				var opt=eval(frame_ref).document.createElement("OPTION");
			
				opt.text=temp1;
				opt.value=temp;
				
				if("<%=name_prefix%>"==temp){
				//ert('coming');
				    opt.selected=true; 
			}
			
			
			eval(frame_ref).document.forms[0].sltRelationship.add(opt);
				
			</script>
<%
			}
		}

	}
	catch(Exception e)
	 {
		out.println(e.toString());
		e.printStackTrace();
	}
	finally
	{
		if(rset != null)rset.close();
		if(pstmt1 != null)pstmt1.close();
	}
	
	

	
}
catch(Exception e)
		{
			out.println(e.toString());
			e.printStackTrace();
		}
		finally
		{	
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}

%>
<!-- @ if No Records Found. -->
<%
if(intFlag == 0)
	{
		out.println("For The Gender No Relationship found");
	}
	
}
	if(callgetNewBornRegnFn.equals("Y")) {
		%>
		<script>		
			parent.frames[1].frames[2].getNewBornRegnValues('pat_id');
		</script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		<%
	}
	//Control comes here only when if called from MaintainBirthRegister function
 
}%>
</BODY>
</HTML>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
	public static String singleToDoubleQuotes(String strDB)
	{
		/*
		String strModified="";			
		try
		{
			if((strDB != null) ||(strDB !=""))
			{
				StringBuffer stringbuffer = new StringBuffer(strDB);
				int i = 0;
				for(int j = 0; strDB.indexOf('\'', i) != -1; j++)
				{
					i = strDB.indexOf('\'', i);
					stringbuffer.insert(i + j, "'");
					i++;
				}
				strModified=stringbuffer.toString();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		*/
		return strDB.replaceAll("'","''");
	}
%>

