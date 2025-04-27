<%@ page import="java.sql.*, java.util.*, java.text.*, java.net.*,webbeans.eCommon.*,eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%!  
	public String specialCharacter(String single)
	{
		if(single == null) single = "";
		return single.replaceAll("'","");
	}	
%>
<% 
request.setCharacterEncoding("UTF-8");
Connection con = null;
ResultSet rs=null;

try {
	
	String validate=request.getParameter("validate") == null ? "" :request.getParameter("validate") ;
	Properties p;
	p = (java.util.Properties) session.getValue( "jdbc" ) ;
	con = ConnectionManager.getConnection(request);
	//Below line added for this CRF GDOH-CRF-0082
	boolean diagnosisPmb=CommonBean.isSiteSpecific(con, "MR","DIAG_MAPPED_PMB"); 	
	
	Statement stmt = con.createStatement();
if(validate.equals("")||validate.equals("null")){
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

		
			sql=" Select a.long_desc long_desc,a.ADV_EVENT_TYPE_CODE ,b.ADV_EVENT_TYPE_IND from MR_ADV_EVENT_TYPE_lang_vw a , MR_ADV_EVENT_TYPE_DETAIL b where a.ADV_EVENT_TYPE_CODE=b.ADV_EVENT_TYPE_CODE and b.ADV_EVENT_TYPE_IND='"+adv_evnt_val+"' and a.language_id='"+locale+"' and a.eff_status='E'  ORDER BY LONG_DESC ASC";
		
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
			if(count >0 && !causative_code.equals("Oth")){//Modified by Thamizh selvi on 21st Dec 2017 against ML-MMOH-CRF-0751%>
			parent.frames[3].document.forms[0].flag_val.value='Y';
			<%} else {%>
			parent.frames[3].document.forms[0].flag_val.value='N';

			<%}
		if (rs!=null) rs.close();
		String sql_prev_onset_date="Select to_char(ONSET_DATE,'dd/mm/yyyy hh24:mi:ss') ONSET_DATE from PR_ALLERGY_SENSITIVITY where  patient_id='"+PatientId+"' and ALLERGEN_CODE='"+causative_code+"' and status='A'";
		rs=stmt.executeQuery(sql_prev_onset_date);

		if(rs !=null && rs.next())
		{
			on_set_date=rs.getString("ONSET_DATE");
			if(on_set_date==null) on_set_date="";
		}
		if(!on_set_date.equals("")){%>
		/* //modified for ICN 6935 
		parent.frames[3].document.forms[0].onset_date.value='<%--=on_set_date--%>';
		parent.frames[3].document.forms[0].onset_date.disabled=true;
			parent.frames[3].document.forms[0]..cal2.disabled=true;*/<%}else
		{%>/*parent.frames[3].document.forms[0].onset_date.disabled=false;
			parent.frames[3].document.forms[0].cal2.disabled=false;*/
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
		String onset_date=(String) hash.get("onset_date");
		

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
		sql_cnt = "SELECT Count (*) FROM pr_adverse_event_reaction a,pr_adverse_event b,pr_allergy_sensitivity c WHERE a.patient_id = b.patient_id AND a.adv_event_type_ind = b.adv_event_type_ind AND a.adv_event_type = b.adv_event_type AND a.allergen_code = b.allergen_code AND a.adv_event_srl_no = b.adv_event_srl_no AND a.adv_event_dtl_srl_no=b.adv_event_dtl_srl_no AND a.patient_id = c.patient_id AND a.allergen_code = c.allergen_code AND a.adv_event_type = c.adv_event_type AND a.adv_event_type_ind = c.adv_event_type_ind AND a.adv_event_srl_no = c.adv_event_srl_no AND c.status = '"+status+"' /*and a.status = '"+error_status+"'*/ AND a.patient_id = '"+PatientId+"' AND a.adv_event_type_ind = '"+adv_event_type_ind_code+"' AND a.adv_event_type = '"+adv_event_type_code+"' AND a.allergen_code = '"+causative_code+"' and c.onset_date = TO_DATE('"+onset_date+"','dd/mm/yyyy hh24:mi:ss') ";
					
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
		
		if(parent.frames[1].document.getElementById('third<%=j%>') != null	){
		parent.frames[1].document.getElementById('third<%=j%>').style='display';
		parent.frames[1].document.getElementById('third<%=j%>').style.visibility='visible';
		}
		<%}

			if(cnt > 0)
			{
				for(int i=cnt2;i<cnt3;i++)
				{

					%>
				if(parent.frames[1].document.getElementById('second<%=i%>') != null	){
				parent.frames[1].document.getElementById('second<%=i%>').style='display';
				parent.frames[1].document.getElementById('second<%=i%>').style.visibility='visible';
				}
				<%}
			}
		}else
		{
			for(int j=cnt2;j<cnt_head;j++)
		{
	
		
		%>
	if(parent.frames[1].document.getElementById('third<%=j%>') != null){
			parent.frames[1].document.getElementById('third<%=j%>').style.display='none';
			parent.frames[1].document.getElementById('third<%=j%>').style.visibility='hidden';
		}
		
		<%}
			if(cnt > 0)
			{
				for(int i=cnt2;i<cnt3;i++)
				{
				
				%>
				if(parent.frames[1].document.getElementById('second<%=i%>') != null){
				parent.frames[1].document.getElementById('second<%=i%>').style.display='none';
				parent.frames[1].document.getElementById('second<%=i%>').style.visibility='hidden';
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
		if(reac_code_val_prev.equals("undefined"))reac_code_val_prev="";   	 
     
	/* MR_SPR_6282 _1 11/6/2008*/	
		String final_total=(String)hash.get("final_total");
		if(final_total == null) final_total = "";
		/*String f_code = "";
		String f_date = "";
		String f_severity = "";
		String f_Site = "";
		 StringTokenizer st_final_total = new StringTokenizer(final_total,"^");
				while(st_final_total.hasMoreTokens()){
					f_code = st_final_total.nextToken();
					f_date = st_final_total.nextToken();
					//if(st_final_total.nextToken().equals("") ) st_final_total.nextToken() = "S";
					f_severity = st_final_total.nextToken();
					if(f_severity.equals("~"))
						f_severity = "";
					f_Site = st_final_total.nextToken();
					if(f_Site.equals("~"))
						f_Site = "";*/
			//}
			//parent.frames[4].document.forms[0].final_total.value
		%>
		
		<%
/* MR_SPR_6282 _1 11/6/2008*/	


		String reac_code_val_prev_one="";
		//String reac_code_val_final="";
		String adv_reac_code="";
		String adv_reac_code1="";
		StringBuffer reac_desc_final= new StringBuffer("");
		String reaction_desc_final= "";
		StringBuffer reac_code_final= new StringBuffer("");
		StringBuffer oth_desc_final= new StringBuffer("");
		String reac_desc="";
		String oth_reaction="";
		String oth_reaction2="";
		boolean chkvalue=false;
		//String reac_code_val_recent="";
		 HashSet tabdata1;	
		 HashSet tabdata2;
		 HashSet tabdata3;		
		//HashMap hashmap = new HashMap();
		tabdata1=new HashSet();
		tabdata2=new HashSet();
		tabdata3=new HashSet();
		
		
		StringTokenizer token=new StringTokenizer(retVal,"`");
		while(token.hasMoreTokens())
		{
			oth_reaction=token.nextToken();
			oth_reaction2=token.nextToken();
			//reac_desc_final.append(oth_reaction2 + ";");
			oth_desc_final.append(oth_reaction2 + ";");
			reac_code_final.append(oth_reaction2 +"`");

			StringTokenizer token1=new StringTokenizer(oth_reaction,"@");
			while(token1.hasMoreTokens())
			{
				adv_reac_code1=token1.nextToken();						    
				tabdata1.add(adv_reac_code1);    //selected actions from the lookup
			}
		}
		if(!reac_code_val_prev.equals("") && reac_code_val_prev!=null){
		StringTokenizer token1=new StringTokenizer(reac_code_val_prev,"`");
		while(token1.hasMoreTokens())
		{
			reac_code_val_prev_one=token1.nextToken();            			
			tabdata3.add(reac_code_val_prev_one);		//previous value from the table
		}
		}	
		//Changed "reac_caused" from string to StringBuffer by Thamizh selvi on 21st Dec 2017 against ML-MMOH-CRF-0751
		StringBuffer reac_caused = new StringBuffer();
		reac_caused.setLength(0);
		reac_caused.append("select REACTION_CODE,LONG_DESC from ( select a.REACTION_CODE REACTION_CODE,a.LONG_DESC LONG_DESC from  AM_REACTION_LANG_VW a, MR_ADV_REA_CAUSE_AGENT b where a.REACTION_CODE=b.ADV_REAC_CODE ");
		if(!allergen.equals("Oth"))//Added by Thamizh selvi on 21st Dec 2017 against ML-MMOH-CRF-0751
			reac_caused.append(" and b.ALLERGEN_CODE='"+allergen+"' ");
		reac_caused.append(" and a.language_id='"+locale+"' and a.eff_status = 'E' UNION Select REACTION_CODE,LONG_DESC from AM_REACTION_lang_vw where REACTION_CODE like 'UNKN%' and language_id='"+locale+"' and eff_status = 'E') ");
		rs=stmt.executeQuery(reac_caused.toString());
		if(rs !=null)
		{
			while(rs.next())
			{
				reac_desc=specialCharacter(rs.getString("LONG_DESC"));
				adv_reac_code=rs.getString("REACTION_CODE");
				tabdata2.add(adv_reac_code);
                 if(!tabdata3.contains(adv_reac_code) && tabdata1.contains(adv_reac_code)){					    
					tabdata3.add(adv_reac_code);
					reac_desc_final.append(adv_reac_code + ";");
					reac_desc_final.append(reac_desc + ";");
					reac_code_final.append(adv_reac_code +"`");
					//reaction_desc_final.append(final_total+"!"+reac_desc+"!");				
				}							
             
			}
			String no_reaction=reac_desc_final.toString();
			if(no_reaction.equals("")) no_reaction="$";
			String final_string=no_reaction+"`"+oth_desc_final.toString();
			String oth_rec=oth_desc_final.toString();
			if(oth_rec.equals("") && no_reaction.equals("$") )
			{
				final_string="";
			}
			//reaction_desc_final = final_total+"!"+final_string;
			
			%>			
			parent.frames[4].document.forms[0].final_total.value="<%=reaction_desc_final%>";			
			parent.frames[4].document.forms[0].reaction_value.value="<%=final_string%>";
			parent.frames[4].document.forms[0].react_code_final.value="<%=reac_code_final.toString()%>";
			parent.frames[4].document.forms[0].reac_desc1_val.value="<%=reac_desc_final.toString()%>";
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
			reac_code_val_last.append(c1+"`");
		}

		%>parent.frames[4].document.forms[0].react_code_final.value="<%=reac_code_val_last.toString()%>";<%


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

		String details=java.net.URLDecoder.decode((String)hash.get("details"));

	session.putValue("DETAILS_CODE",details);
	
	
	}else if(steps.equals("10")){
	String final_total=(String)hash.get("final_total");

	session.putValue("final_total",final_total);
	}
	/*
		Caluculate the diagnosis count
	*/
	else if(steps.equals("11")){
		String active_diag_cnt="";
		String patient_id=(String)hash.get("patient_id");

		//String sql_active_diag="SELECT count(*) FROM pr_problem WHERE patient_id='"+patient_id+"' AND problem_status='A'";
		String sql_active_diag="SELECT count(*) FROM pr_diagnosis WHERE patient_id='"+patient_id+"' AND curr_status='A'";
			if(rs!=null)rs.close();
			rs = stmt.executeQuery(sql_active_diag) ;	
			if(rs !=null && rs.next())
			{
				active_diag_cnt=rs.getString(1);
				
			}

			%>
			document.forms[0].active_diag_cnt.value='<%=active_diag_cnt%>';
			<%

			if(rs!=null)rs.close();

	}
	/*	
	End for logic for the Dignosis count
	*/
	//Added by Senthil
	else if(steps.equals("Injury")){
		
		String patient_id=(String)hash.get("patient_id");
		String facility_id=(String)hash.get("facility_id");
		String encounterID=(String)hash.get("encounterID");
		String injury_date=(String)hash.get("injury_date");
		String trmt_strt_date=(String)hash.get("trmt_strt_date");
		/*facility_id,patient_id,encounterID,injury_date,trmt_strt_date*/
		String statusFlag="";		
			String sqlQuery="select MR_PAT_INJURY_DATE_CHK(to_date('"+injury_date+"','dd/mm/yyyy'),to_date('"+trmt_strt_date+"','dd/mm/yyyy'),'"+patient_id+"','"+encounterID+"','"+facility_id+"') flag_status from dual"; 
					
			if(rs!=null)rs.close();
			rs = stmt.executeQuery(sqlQuery) ;	
			if(rs !=null && rs.next())
			{
			 statusFlag=rs.getString("flag_status")==null?"":rs.getString("flag_status");
			}
			
			%>
			document.forms[0].status_flag.value='<%=statusFlag%>'; 
			<%
			if(rs!=null)rs.close();
	}	
	//End Senthil	
	//Below line added for this CRF GDOH-CRF-0082
	else if(steps.equals("PMBCheck") && diagnosisPmb){		
		
		String code_set=request.getParameter("code_set")==null?"":request.getParameter("code_set");
		String diagprob_code=request.getParameter("diagprob_code")==null?"":request.getParameter("diagprob_code");
		String pmbsupportdiag=request.getParameter("pmbsupportdiag")==null?"":request.getParameter("pmbsupportdiag");
		String totsupportdiagCount=request.getParameter("totsupportdiagCount")==null?"":request.getParameter("totsupportdiagCount");
		if(totsupportdiagCount ==null || totsupportdiagCount.equals("null") || totsupportdiagCount.equals("")) totsupportdiagCount="0";	
		int totdigCount=Integer.parseInt(totsupportdiagCount);	
        int supportDigPmbCount=eMR.MRQueryPMBCode.getSupportDignosisWithPMB(con,diagprob_code,pmbsupportdiag);
		
		%>					
		if('<%=totdigCount%>'!=0 &&'<%=totdigCount%>' == '<%=supportDigPmbCount%>'){  
				var pmb=getLabel("eMR.ThisisPMB.label","MR");						
				parent.RecDiagnosisAddModify.document.getElementById('pmb_diagnosis').style.visibility='visible';		
				parent.RecDiagnosisAddModify.document.getElementById('pmb_diagnosis').innerHTML=pmb;
		}else{  
			var notpmb=getLabel("eMR.ThisisnotPMB.label","MR");						
			parent.RecDiagnosisAddModify.document.getElementById('pmb_diagnosis').style.visibility='visible';						
			parent.RecDiagnosisAddModify.document.getElementById('pmb_diagnosis').innerHTML=notpmb;
		}
	<%
			if(rs!=null)rs.close();
	}	
	//End GDOH-CRF-0082
	//Added for this CRF Bru-HIMS-CRF-024.2
	else if(steps.equals("SerialNo")){
		
		String code_set=(String)hash.get("code_set");
		String diagprob_code=(String)hash.get("diagprob_code");
		String Patient_Id=(String)hash.get("Patient_Id");
		String SerialNoQuery="select nvl(max(OCCUR_SRL_NO),0)+1 srl_no from pr_diagnosis where patient_id ='"+Patient_Id+"' and term_set_id='"+code_set+"' and term_code='"+diagprob_code+"'"; 
 		String srlnocontrol="";
			if(rs!=null)rs.close();
			rs = stmt.executeQuery(SerialNoQuery) ;	
			if(rs !=null && rs.next())
			{
			 srlnocontrol=rs.getString("srl_no")==null?"":rs.getString("srl_no");
			}
			
			%>
			
			parent.RecDiagnosisAddModify.document.forms[0].srl_no_control.value=<%=srlnocontrol%>;
			<%
			if(rs!=null)rs.close();
	}	
	//End Bru-CRF-HIMS-CRF-024.2
	
	//Added for this CRF ML-MMOH-CRF-0615
	else if(steps.equals("CheckEncounterId"))
	{
		
		String patient_id=(String)hash.get("patient_id");
		String encounter_id=(String)hash.get("p_encounter_id");
		StringBuffer msg = new StringBuffer();
		if(!encounter_id.equals("") )
		{
			StringBuffer SerialNoQuery = new StringBuffer();
		
		 SerialNoQuery.append("select count(*) cnt from pr_encounter where encounter_id = '"+encounter_id+"' "); 
		 
		
		 
		 
		
 		     int srlnocontrol=1;
			if(rs!=null)rs.close();
			rs = stmt.executeQuery(SerialNoQuery.toString()) ;	
			if(rs !=null && rs.next())
			{
			 srlnocontrol=rs.getInt("cnt");
			}
			
			
			if(srlnocontrol != 0)
			msg.append(srlnocontrol+"$$");
			else
			msg.append("0"+"$$");
		}
		if(!patient_id.equals("") && !encounter_id.equals(""))
			{
		
				StringBuffer SerialNoQuery = new StringBuffer();

				SerialNoQuery.append("select count(*) cnt from pr_encounter where encounter_id = '"+encounter_id+"' "); 

				if(!patient_id.equals(""))
				SerialNoQuery.append (" and patient_id ='"+patient_id+"' ");

				

				int srlnocontrol=1;
				if(rs!=null)rs.close();
				rs = stmt.executeQuery(SerialNoQuery.toString()) ;	
				if(rs !=null && rs.next())
				{
				srlnocontrol=rs.getInt("cnt");
				}
				

				if(srlnocontrol != 0)
				msg.append(srlnocontrol+"$$");
				else
				msg.append("0"+"$$");
			}	
			out.println(msg.toString());
			%>
		
			<%
			if(rs!=null)rs.close();
	}	
	
	
	else if(steps.equals("CheckPatientId")){
		
		String patient_id=(String)hash.get("patient_id");
		String encounter_id=(String)hash.get("p_encounter_id");
		StringBuffer msg = new StringBuffer();
	
		if(!patient_id.equals("") )
		{
			StringBuffer SerialNoQuery = new StringBuffer();
		
		 SerialNoQuery.append("select count(*) cnt from pr_encounter where patient_id = '"+patient_id+"' "); 
		 
		
		 
		 
		
 		     int srlnocontrol=1;
			if(rs!=null)rs.close();
			rs = stmt.executeQuery(SerialNoQuery.toString()) ;	
			if(rs !=null && rs.next())
			{
			 srlnocontrol=rs.getInt("cnt");
			}
			
			
			if(srlnocontrol != 0)
			msg.append(srlnocontrol+"$$");
			else
			msg.append("0"+"$$");
		}
		if(!patient_id.equals("") && !encounter_id.equals(""))
		{
		StringBuffer SerialNoQuery = new StringBuffer();
		
		 SerialNoQuery.append("select count(*) cnt from pr_encounter where patient_id = '"+patient_id+"' "); 
		 
		 if(!encounter_id.equals(""))
			 SerialNoQuery.append (" and encounter_id ='"+encounter_id+"' ");
		 
		 
		
 		     int srlnocontrol=1;
			if(rs!=null)rs.close();
			rs = stmt.executeQuery(SerialNoQuery.toString()) ;	
			if(rs !=null && rs.next())
			{
			 srlnocontrol=rs.getInt("cnt");
			}
			
			
			if(srlnocontrol != 0)
			msg.append(srlnocontrol+"$$");
			else
			msg.append("0"+"$$");
		}	
		
			out.println(msg.toString());
			
			%>
		
			<%
			if(rs!=null)rs.close();
	}
	
	else if(steps.equals("12"))
	{
		String link_Complaint = (String)hash.get("details");
		session.putValue("linkComplaint",link_Complaint);
	}
	else if(steps.equals("13"))
	{
		session.removeAttribute("linkComplaint");
	}
	else if(steps.equals("CLEAR_ALL_SESSION_VALUES")){

		session.removeAttribute("DETAILS_CODE");
		session.removeAttribute("final_total");
	}	
	if (hash !=null) hash.clear();
}
	/*Tuesday, December 29, 2009 code added to check free_text_applicable_yn for selected termset in MR Reports-> Patient List With Related Diagnosis */
	else if(validate.equals("FREE_TEXT_YN"))
	{
		String free_text_applicable_yn	= "";
		String termSetID = request.getParameter("termSetID");
		String sqlFreeText="select free_text_applicable_yn from mr_term_set where term_set_id = '"+termSetID+"' and diag_spec_yn='Y'   and EFF_STATUS='E'  order by term_set_desc ";
			if(rs!=null)rs.close();
			rs = stmt.executeQuery(sqlFreeText) ;	
			if(rs !=null && rs.next())
			{
				free_text_applicable_yn=rs.getString(1);
				
			}
			if(rs!=null)rs.close();
			out.write(free_text_applicable_yn);
	}
	if (stmt !=null) stmt.close();
	//if (hash !=null) hash.clear();
	}catch( Exception e ){
	out.println(e.toString());
	e.printStackTrace();

}finally{
	if(con !=null) ConnectionManager.returnConnection(con,request);
}
%>	
