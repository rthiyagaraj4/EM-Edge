<!DOCTYPE html>
     
<%@ page import="java.sql.*, java.util.*, java.text.*, java.net.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<% 


Connection con = null;
ResultSet rs=null;

try {
	con = ConnectionManager.getConnection(request);
	Statement stmt = con.createStatement();

	Map hash = (Map)obj.parseXMLString( request ) ;
	hash = (Map)hash.get("SEARCH") ;

	String adv_evnt_val				=(String) hash.get("ADV_EVENT_TYPE_IND");
	if(adv_evnt_val ==null) adv_evnt_val="";

	String steps					=(String) hash.get("steps");
	if(steps ==null) steps="";

	String adv_evnt_code		=(String) hash.get("adv_evnt_code");
	if(adv_evnt_code==null)adv_evnt_code="";	
String locale = (String)session.getAttribute("LOCALE");
	if(steps.equals("1")){
	
		
		String sql="";
		String ADV_EVENT_TYPE_CODE="";
		String ADV_EVENT_TYPE_DESC="";

		
			sql=" Select a.long_desc long_desc,a.ADV_EVENT_TYPE_CODE ,b.ADV_EVENT_TYPE_IND from MR_ADV_EVENT_TYPE_lang_vw a , MR_ADV_EVENT_TYPE_DETAIL b where a.ADV_EVENT_TYPE_CODE=b.ADV_EVENT_TYPE_CODE and b.ADV_EVENT_TYPE_IND='"+adv_evnt_val+"' and a.language_id='"+locale+"' and a.eff_status='E'";
		
		if (rs!=null) rs.close();
		rs = stmt.executeQuery(sql) ;
			%>
			
			
			 var i=2;
			 var len=document.forms[0].adv_evnt_type.options.length;
			 var lBox=document.forms[0].adv_evnt_type; 
			 lBox.remove(lBox.options[0]);
			 var opt=document.createElement('OPTION');
			 opt.value='';
			 opt.text= '----'+getLabel("Common.defaultSelect.label","Common")+'----';
			 lBox.add(opt);

			 while(i<= len){
				 lBox.remove(lBox.options[i]);
				 i+=1;
			}   
			
			<%
			if (rs != null){
						
				while(rs.next()){

					ADV_EVENT_TYPE_DESC=rs.getString("long_desc");
					ADV_EVENT_TYPE_CODE=rs.getString("ADV_EVENT_TYPE_CODE");
					%>
					var element = document.createElement('OPTION');
					element.value="<%=ADV_EVENT_TYPE_CODE%>|<%=ADV_EVENT_TYPE_DESC%>";
					element.text = "<%=ADV_EVENT_TYPE_DESC%>";
					document.forms[0].adv_evnt_type.add(element);

					<%
				}
			}
		

	}else if(steps.equals("2")){
	
		
		String sql="";
		String ADV_EVENT_TYPE_CODE="";
		String ADV_EVENT_TYPE_DESC="";

		
			sql=" Select a.long_desc long_desc,a.ADV_EVENT_TYPE_CODE ,b.ADV_EVENT_TYPE_IND from MR_ADV_EVENT_TYPE_lang_vw a , MR_ADV_EVENT_TYPE_DETAIL b where a.ADV_EVENT_TYPE_CODE=b.ADV_EVENT_TYPE_CODE and b.ADV_EVENT_TYPE_IND='"+adv_evnt_val+"' and a.language_id='"+locale+"' and a.eff_status='E'";
		
		if (rs!=null) rs.close();
		rs = stmt.executeQuery(sql) ;
			%>
			
			
			 var i=2;
			 var len=document.forms[0].adv_event_type.options.length;
			 var lBox=document.forms[0].adv_event_type; 
			 lBox.remove(lBox.options[0]);
			 var opt=document.createElement('OPTION');
			 opt.value='';
			 opt.text= '----'+getLabel("Common.defaultSelect.label","Common")+'----';
			 lBox.add(opt);

			 while(i<= len){
				 lBox.remove(lBox.options[i]);
				 i+=1;
			}   
			
			<%
			if (rs != null){
						
				while(rs.next()){

					ADV_EVENT_TYPE_DESC=rs.getString("long_desc");
					ADV_EVENT_TYPE_CODE=rs.getString("ADV_EVENT_TYPE_CODE");
						
					%>
					var element = document.createElement('OPTION');
					element.value="<%=ADV_EVENT_TYPE_CODE%>|<%=ADV_EVENT_TYPE_DESC%>";
					element.text = "<%=ADV_EVENT_TYPE_DESC%>";
					document.forms[0].adv_event_type.add(element);

					<%
				}
			}
		

	}else if(steps.equals("3")){
	
		
		String sql="";
		String causitive_code="";
		String causitive_desc="";

		
			sql=" select b.ALLERGEN_CODE ,b.LONG_DESC longdesc  from MR_ADV_EVENT_TYPE_IND a ,MR_ALLERGEN_lang_vw b ,MR_ADV_EVENT_TYPE c where a.ADV_EVENT_TYPE_IND='"+adv_evnt_val+"' and b.language_id='"+locale+"'  and c.ADV_EVENT_TYPE_CODE='"+adv_evnt_code+"' AND a.ADV_EVENT_TYPE_IND = b.ADV_EVENT_TYPE_IND and b.ADV_EVENT_TYPE_CODE = c.ADV_EVENT_TYPE_CODE";
		
		if (rs!=null) rs.close();
		rs = stmt.executeQuery(sql) ;
			%>
			
			
			 var i=2;
			 var len=document.forms[0].allergen.options.length;
			 var lBox=document.forms[0].allergen; 
			 lBox.remove(lBox.options[0]);
			 var opt=document.createElement('OPTION');
			 opt.value='';
			 opt.text= '----'+getLabel("Common.defaultSelect.label","Common")+'----';
			 lBox.add(opt);

			 while(i<= len){
				 lBox.remove(lBox.options[i]);
				 i+=1;
			}   
			
			<%
			if (rs != null){
						
				while(rs.next()){

					causitive_desc=rs.getString("longdesc");
					causitive_code=rs.getString("ALLERGEN_CODE");
						
					%>
					var element = document.createElement('OPTION');
					element.value="<%=causitive_code%>|<%=causitive_desc%>";
					element.text = "<%=causitive_desc%>";
					document.forms[0].allergen.add(element);

					<%
				}
			}
		

	}else if(steps.equals("4")){

	String PatientId		=(String) hash.get("PatientId");
	if(PatientId==null)PatientId="";
	String reaction_date		=(String) hash.get("reaction_date");
	if(reaction_date==null)reaction_date="";	
	String allergen		=(String) hash.get("allergen");
	if(allergen==null)allergen="";

	String reaction_code	=(String) hash.get("reaction_code");
	if(reaction_code==null) reaction_code="";

	String reaction_date_old="";
	HashSet tabdata;	
	tabdata = new HashSet();
	int cnt=0;

	
	String sql_chk1="select count(*) FROM PR_ADVERSE_EVENT_REACTION where ALLERGEN_CODE = '"+allergen+"'   AND patient_id = '"+PatientId+"' and ADV_REAC_CODE = '"+reaction_code+"' order by reaction_date ";

		if (rs!=null) rs.close();
		rs = stmt.executeQuery(sql_chk1) ;
		if(rs !=null && rs.next())
		{
			cnt=rs.getInt(1);
		}

 if(cnt >0)
 {
	if (rs!=null) rs.close();
	
	String sql_chk="select TO_CHAR (reaction_date, 'dd/mm/yyyy hh24:mi') reaction_date FROM PR_ADVERSE_EVENT_REACTION where ALLERGEN_CODE = '"+allergen+"'   AND patient_id = '"+PatientId+"' and ADV_REAC_CODE = '"+reaction_code+"' order by reaction_date ";	
		rs = stmt.executeQuery(sql_chk) ;
		if(rs !=null )
		{
			while(rs.next())
			{
				reaction_date_old=rs.getString("reaction_date");
				if(reaction_date_old==null ) reaction_date_old="";
				
				tabdata.add(reaction_date_old);
				if(tabdata.contains(reaction_date))
				{	//parent.frames[4].document.forms[0].duplicate.value="Y";
				%>parent.frames[5].document.forms[0].duplicate.value="Y";<%
						
				}else
				{//parent.frames[4].document.forms[0].duplicate.value="N";
				%>parent.frames[5].document.forms[0].duplicate.value="N";<%
				}
				
			}

		}

 }else
{		//parent.frames[4].document.forms[0].duplicate.value="N";
		%>parent.frames[5].document.forms[0].duplicate.value="N";<%

 }
 if ( tabdata != null ) tabdata.clear();

	}else if(steps.equals("5")){

		String causative_code =(String) hash.get("causative_code");
		String PatientId =(String) hash.get("PatientId");
		String adv_type =(String) hash.get("adv_type");
		String adv_ind =(String) hash.get("adv_ind");
		String on_set_date="";
		int count=0;
		if (rs!=null) rs.close();
		String sql_prev_chk=" select count(*) from PR_ALLERGY_SENSITIVITY WHERE patient_id = '"+PatientId+"' AND ALLERGEN_CODE ='"+causative_code+"' AND ADV_EVENT_TYPE_IND='"+adv_ind+"'  AND ADV_EVENT_TYPE='"+adv_type+"' and status='A'";
		rs=stmt.executeQuery(sql_prev_chk);
		if(rs !=null && rs.next())
		{
			count=rs.getInt(1);
		}
			if(count >0){%>
			parent.frames[3].document.forms[0].flag_val.value='Y';
			<%} else {%>
			parent.frames[3].document.forms[0].flag_val.value='N';

			<%}
		if (rs!=null) rs.close();
		String sql_prev_onset_date="Select to_char(ONSET_DATE,'dd/mm/yyyy') ONSET_DATE from PR_ALLERGY_SENSITIVITY where  patient_id='"+PatientId+"' and ALLERGEN_CODE='"+causative_code+"' and status='A'";
		rs=stmt.executeQuery(sql_prev_onset_date);

		if(rs !=null && rs.next())
		{
			on_set_date=rs.getString("ONSET_DATE");
			if(on_set_date==null) on_set_date="";
		}
		if(!on_set_date.equals("")){%>
		parent.frames[3].document.forms[0].onset_date.value='<%=on_set_date%>';
		parent.frames[3].document.forms[0].onset_date.disabled=true;
			parent.frames[3].document.forms[0].cal2.disabled=true;<%}else
		{%>parent.frames[3].document.forms[0].onset_date.disabled=false;
			parent.frames[3].document.forms[0].cal2.disabled=false;
			<%}

	}else if(steps.equals("6")){

		
		String PatientId =(String) hash.get("PatientId");
		String adv_event_type_code=(String) hash.get("adv_event_type_code");
		String	adv_event_type_ind_code=(String) hash.get("adv_event_type_ind_code");
		String	causative_code=(String) hash.get("causative_code");
		String reaction_date1=(String) hash.get("reaction_date1");
		String cnt1 =(String) hash.get("cnt") ;
		String status =(String) hash.get("status") ;
		String error_status =(String) hash.get("error_status") ;
		String det=(String) hash.get("det");
if(status.equals("Active"))
	status="A";
else if(status.equals("Resolved"))
	status = "R";
else if(status.equals("In Error"))
	status = "E";

		if(reaction_date1!=null && !reaction_date1.equals(""))
			reaction_date1	=	reaction_date1.substring(0,10);

			if (rs!=null) rs.close();
			int cnt2=0;
			int cnt=0;
			String sql_cnt="";
		// sql_cnt="SELECT   COUNT (*) FROM pr_adverse_event_reaction a, pr_adverse_event b,pr_allergy_sensitivity c WHERE a.PATIENT_ID=b.PATIENT_ID and a.PATIENT_ID=c.PATIENT_ID and a.allergen_code = b.allergen_code and a.ADV_EVENT_TYPE_IND=b.ADV_EVENT_TYPE_IND and a.ADV_EVENT_TYPE=b.ADV_EVENT_TYPE and a.ADV_EVENT_SRL_NO=b.ADV_EVENT_SRL_NO AND a.allergen_code = c.allergen_code and a.ADV_EVENT_TYPE=c.ADV_EVENT_TYPE and a.ADV_EVENT_TYPE_IND=c.ADV_EVENT_TYPE_IND	and a.ADV_EVENT_SRL_NO=c.ADV_EVENT_SRL_NO  and c.STATUS='A' AND a.patient_id = '"+PatientId+"' AND a.adv_event_type_ind = '"+adv_event_type_ind_code+"' AND a.adv_event_type = '"+adv_event_type_code+"'  AND a.ALLERGEN_CODE = '"+causative_code+"' and a.REACTION_DATE=to_date('"+reaction_date1+"','dd/mm/yyyy hh24:mi') ";

		//sql_cnt="SELECT   COUNT (*) FROM pr_adverse_event_reaction a, pr_adverse_event b,pr_allergy_sensitivity c WHERE a.PATIENT_ID=b.PATIENT_ID and a.PATIENT_ID=c.PATIENT_ID and a.allergen_code = b.allergen_code and a.ADV_EVENT_TYPE_IND=b.ADV_EVENT_TYPE_IND and a.ADV_EVENT_TYPE=b.ADV_EVENT_TYPE and a.ADV_EVENT_SRL_NO=b.ADV_EVENT_SRL_NO AND a.allergen_code = c.allergen_code and a.ADV_EVENT_TYPE=c.ADV_EVENT_TYPE and a.ADV_EVENT_TYPE_IND=c.ADV_EVENT_TYPE_IND	and a.ADV_EVENT_SRL_NO=c.ADV_EVENT_SRL_NO  and c.STATUS='A' AND a.patient_id = '"+PatientId+"' AND a.adv_event_type_ind = '"+adv_event_type_ind_code+"' AND a.adv_event_type = '"+adv_event_type_code+"'  AND a.ALLERGEN_CODE = '"+causative_code+"' ";
		// modified on 23-07-2008 for SCR 4880
		sql_cnt = "SELECT Count (*) FROM pr_adverse_event_reaction a,pr_adverse_event b,pr_allergy_sensitivity c WHERE a.patient_id = b.patient_id AND a.adv_event_type_ind = b.adv_event_type_ind AND a.adv_event_type = b.adv_event_type AND a.allergen_code = b.allergen_code AND a.adv_event_srl_no = b.adv_event_srl_no AND a.adv_event_dtl_srl_no=b.adv_event_dtl_srl_no AND a.patient_id = c.patient_id AND a.allergen_code = c.allergen_code AND a.adv_event_type = c.adv_event_type AND a.adv_event_type_ind = c.adv_event_type_ind AND a.adv_event_srl_no = c.adv_event_srl_no AND c.status = '"+status+"' /*and a.status = '"+error_status+"'*/ AND a.patient_id = '"+PatientId+"' AND a.adv_event_type_ind = '"+adv_event_type_ind_code+"' AND a.adv_event_type = '"+adv_event_type_code+"' AND a.allergen_code = '"+causative_code+"' ";
					
	
						rs=stmt.executeQuery(sql_cnt);
						if(rs !=null && rs.next())
						{
							cnt=rs.getInt(1);
						}
						if(cnt >0)
						{%>
					parent.frames[1].document.forms[0].flag1.value='Y';
						<%}else
						{%>
					parent.frames[1].document.forms[0].flag1.value='N';
						<%}
			if(rs !=null) rs.close();	
			cnt2=Integer.parseInt(cnt1);
			//cnt2=cnt2+1;

			int cnt3=0;
			cnt3=cnt+cnt2;

			//cnt3=cnt3-1;
			int cnt_head=cnt2+1;

			if(det.equals("add"))
		{
		for(int j=cnt2;j<cnt_head;j++)
		{%>
		eval("parent.frames[1].document.forms[0].third"+<%=j%>).style.display='Inline';
		eval("parent.frames[1].document.forms[0].third"+<%=j%>).style.visibility='visible';
		<%}

			if(cnt > 0)
			{
				for(int i=cnt2;i<cnt3;i++)
				{%>
				if(eval("parent.frames[1].document.forms[0].second"+<%=i%>) != null	){
				eval("parent.frames[1].document.forms[0].second"+<%=i%>).style.display='Inline';
				eval("parent.frames[1].document.forms[0].second"+<%=i%>).style.visibility='visible';
				}
				<%}
			}
		}else
		{
			for(int j=cnt2;j<cnt_head;j++)
		{%>
		eval("parent.frames[1].document.forms[0].third"+<%=j%>).style.display='none';
		eval("parent.frames[1].document.forms[0].third"+<%=j%>).style.visibility='hidden';
		<%}
			if(cnt > 0)
			{
				for(int i=cnt2;i<cnt3;i++)
				{
				
				%>
				
				if(eval("parent.frames[1].document.forms[0].second"+<%=i%>) != null	){
				eval("parent.frames[1].document.forms[0].second"+<%=i%>).style.display='none';
				eval("parent.frames[1].document.forms[0].second"+<%=i%>).style.visibility='hidden';
				}
				<%}
			}
		}
		}else if(steps.equals("7")){

				String PatientId =(String) hash.get("PatientId");
				String	adv_event_dtl_srl_no=(String) hash.get("adv_event_dtl_srl_no");
				String	causative_code=(String) hash.get("causative_code");
				String reaction_date1=(String) hash.get("reaction_date1");
				String react_code_val="";
				String reac_desc="";
				StringBuffer reac_desc_final= new StringBuffer("");
				String react_code_prev="";
				int	i=0;
				
				String reac_val="select a.ADV_REAC_CODE ,c.long_desc reac_desc FROM pr_adverse_event_reaction a, pr_adverse_event b, AM_REACTION_lang_vw c where  a.PATIENT_ID='"+PatientId+"' and a.ALLERGEN_CODE='"+causative_code+"'  and b.reaction_date = TO_DATE('"+reaction_date1+"','dd/mm/yyyy hh24:mi') and a.ALLERGEN_CODE=b.ALLERGEN_CODE and c.language_id='"+locale+"' and b.ADV_EVENT_DTL_SRL_NO ='"+adv_event_dtl_srl_no+"'  and a.ADV_EVENT_DTL_SRL_NO=b.ADV_EVENT_DTL_SRL_NO and a.ADV_REAC_CODE=c.REACTION_CODE ";

				
				

			
			rs=stmt.executeQuery(reac_val);
			//out.println(reac_val);
			if(rs !=null)
			{
				while(rs.next())
				{
					react_code_val=rs.getString("ADV_REAC_CODE");
					reac_desc=rs.getString("reac_desc");

					if(!react_code_val.equals(react_code_prev))
					{
						
						reac_desc_final.append(reac_desc+";");
						
					}
					react_code_prev=rs.getString("ADV_REAC_CODE");
						i++;
				}
				%>	parent.frames[3].document.forms[0].reaction_value.value='<%=reac_desc_final.toString()%>';
					parent.frames[3].document.forms[0].reaction_value.disabled=true;<%
			}
	}else if(steps.equals("8")){
		//PreparedStatement pstmt=null;
		String retVal=(String)hash.get("retVal");
		
		String allergen=(String)hash.get("allergen");
		String reac_code_val_prev=(String)hash.get("reac_code_val_prev");
		
		String reac_code_val_prev_one="";
		//String reac_code_val_final="";
		String adv_reac_code="";
		String adv_reac_code1="";
		StringBuffer reac_desc_final= new StringBuffer("");
		StringBuffer reac_code_final= new StringBuffer("");
		StringBuffer oth_desc_final= new StringBuffer("");
		String reac_desc="";
		String oth_reaction="";
		String oth_reaction2="";
		//String reac_code_val_recent="";
		 HashSet tabdata1;	
		 HashSet tabdata2;
		 HashSet tabdata3;
		 
		//HashMap hashmap = new HashMap();
		tabdata1=new HashSet();
		tabdata2=new HashSet();
		tabdata3=new HashSet();
		
		StringTokenizer token=new StringTokenizer(retVal,"*");
		while(token.hasMoreTokens())
		{
			oth_reaction=token.nextToken();
			oth_reaction2=token.nextToken();
			//reac_desc_final.append(oth_reaction2 + ";");
			oth_desc_final.append(oth_reaction2 + ";");
			reac_code_final.append(oth_reaction2 +"*");

			


			StringTokenizer token1=new StringTokenizer(oth_reaction,"@");
			while(token1.hasMoreTokens())
			{
				adv_reac_code1=token1.nextToken();
				
				tabdata1.add(adv_reac_code1);
			}
		}
		StringTokenizer token1=new StringTokenizer(reac_code_val_prev,"*");
		while(token1.hasMoreTokens())
		{
			reac_code_val_prev_one=token1.nextToken();
			tabdata3.add(reac_code_val_prev_one);
			
		}

		String reac_caused="select REACTION_CODE,LONG_DESC from ( select a.REACTION_CODE REACTION_CODE,a.LONG_DESC LONG_DESC from  AM_REACTION_LANG_VW a, MR_ADV_REA_CAUSE_AGENT b where a.REACTION_CODE=b.ADV_REAC_CODE and b.ALLERGEN_CODE='"+allergen+"' and a.language_id='"+locale+"' UNION Select REACTION_CODE,LONG_DESC from AM_REACTION_lang_vw where REACTION_CODE like 'UNKN%' and language_id='"+locale+"')";

		

		rs=stmt.executeQuery(reac_caused);
		if(rs !=null)
		{
			while(rs.next())
			{
				reac_desc=rs.getString("LONG_DESC");
				adv_reac_code=rs.getString("REACTION_CODE");
				tabdata2.add(adv_reac_code);
				if(tabdata1.contains(adv_reac_code))
				{
					tabdata3.add(adv_reac_code);
					reac_desc_final.append(reac_desc + ";");
					reac_code_final.append(adv_reac_code +"*");

					
				}

			}
			String no_reaction=reac_desc_final.toString();
			if(no_reaction.equals("")) no_reaction="$";
			String final_string=no_reaction+"*"+oth_desc_final.toString();
			String oth_rec=oth_desc_final.toString();
			if(oth_rec.equals("") && no_reaction.equals("$") )
			{
				final_string="";
			}

			%>

			parent.frames[4].document.forms[0].reaction_value.value='<%=final_string%>';
			parent.frames[4].document.forms[0].react_code_final.value='<%=reac_code_final.toString()%>';
			parent.frames[4].document.forms[0].reac_desc1_val.value='<%=reac_desc_final.toString()%>';
			 parent.frames[4].document.forms[0].reaction_value.disabled=true;
			 <% if(tabdata2.contains("UNKN") && !reac_code_final.equals("")){%>
			 //parent.frames[4].document.forms[0].other_reaction.disabled=false;<%
			 }else{
			%>//parent.frames[4].document.forms[0].other_reaction.disabled=true;<%
			 }
		StringBuffer reac_code_val_last = new StringBuffer("");
		
		Iterator iter=tabdata3.iterator();
		while(iter.hasNext())
		{
			String c1=(String)iter.next();
			reac_code_val_last.append(c1+"*");
		}
		//10/24/2008 to put all reaction in session 
		//session.putValue("reac_code_val_last",reac_code_last);
		%>parent.frames[4].document.forms[0].react_code_final.value='<%=reac_code_val_last.toString()%>';<%


		}
		if ( tabdata1 != null )  tabdata1.clear();
		if ( tabdata2 != null )  tabdata2.clear();
		if ( tabdata3 != null )  tabdata3.clear();
}else if(steps.equals("9")) {
	
		//String PatientId = (String)hash.get("PatientId");
		/*String status=(String)hash.get("status_1");
		String since=(String)hash.get("since_date");
		String certainity=(String)hash.get("certainity");
		String diagnosis=(String)hash.get("diagnosis_code");
		String route_of_expo=(String)hash.get("route_of_expo");
		String source_of_info=(String)hash.get("source_of_info");
		String allergy_test_res=(String)hash.get("allergy_test_res");
		String treat_advice=(String)hash.get("treat_advice");
		String remarks=(String)hash.get("remarks");*/
		String details=(String)hash.get("details");

	session.putValue("DETAILS_CODE",details);
	
	
	}else if(steps.equals("CLEAR_ALL_SESSION_VALUES")){

		session.removeAttribute("DETAILS_CODE");
	}	


	if (stmt !=null) stmt.close();
	if (hash !=null) hash.clear();
	}catch( Exception e ){
	//out.println(e.toString());//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181

}finally{
	if(con !=null) ConnectionManager.returnConnection(con,request);
}
%>	
