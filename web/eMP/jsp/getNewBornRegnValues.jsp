
<%@ page import="java.sql.*, java.util.*,java.lang.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
%>

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");%>


<html>
<head>
    <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
     <Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
	  <Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body class='message' onKeyDown='lockKey();'>
<%  
        Connection con = null;
        PreparedStatement pstmt = null;
        PreparedStatement pstmt1 = null;
        ResultSet rset = null;
        ResultSet rset5 = null;
        ResultSet rset2 = null;
        java.sql.Statement stmt3 = null;
        ResultSet rset3 = null;
        java.sql.Statement stmt4 = null;
        ResultSet rset4 = null;

        String facilityId = (String) session.getValue("facility_id");
        String locale =((String)session.getAttribute("LOCALE"));
        String value1 = request.getParameter("field1")==null?"":request.getParameter("field1");
        String value2 = request.getParameter("field2")==null?"":request.getParameter("field2");
        String value3 = request.getParameter("field3")==null?"":request.getParameter("field3");
        String fatherDtlsIndex = request.getParameter("fatherDtlsIndex")==null?"0":request.getParameter("fatherDtlsIndex");
		
        if(value2 == null)  value2 = "";
		String born_at = request.getParameter("born_at_type")==null?"":request.getParameter("born_at_type");

        String sql ="";
		String sqlRelation = "";
        //String code = "";
        String desc = "";
        String fathername = "";
		String strOccupationCode = "";
		String strOccupationDesc = "";
    
        try
        {
			con = ConnectionManager.getConnection(request);
            if(value1.equals("new_born_sex"))
            {
                String selectedsex  = "";;
                String dftmalesuf       = "";
                String dftfemalesuf = "";
                String  defval              = "";
                StringTokenizer st  = new StringTokenizer(value2,"`");
                if(st.countTokens() == 3)
                {
                    while(st.hasMoreTokens())
                    {
                        selectedsex = st.nextToken();
                        dftmalesuf      = st.nextToken();
                        dftfemalesuf    = st.nextToken();
                    }
                }
                else if(st.countTokens() == 2)
                {
                    while(st.hasMoreTokens())
                    {
                        selectedsex = st.nextToken();
                        if(selectedsex.equals("M"))
                            dftmalesuf      = st.nextToken();
                        else if(selectedsex.equals("F"))
                            dftfemalesuf    = st.nextToken();
                    }
                }
				else if(st.countTokens() == 1)
				{
					selectedsex = st.nextToken();		
				}
                if(selectedsex.equals("M"))
                {
                    if(locale.toUpperCase().equals("EN"))
					{
					sql = " Select NAME_SUFFIX from MP_NAME_SUFFIX WHERE  BABY_SUFFIX_YN = 'Y' and BABY_SEX = 'M' and Eff_Status = 'E' " ;//        Default the value as MP_Param.NAME_SUFFIX_MALE_NB
                    defval = dftmalesuf;
					}else
					{
					sql = " Select (CASE WHEN NAME_SUFFIX_LOC_LANG IS NOT NULL THEN NAME_SUFFIX_LOC_LANG ELSE  NAME_SUFFIX END) NAME_SUFFIX from MP_NAME_SUFFIX WHERE  BABY_SUFFIX_YN = 'Y' and BABY_SEX = 'M' and Eff_Status = 'E' " ;//        Default the value as MP_Param.NAME_SUFFIX_MALE_NB
                    defval = dftmalesuf;
					
					}
                }
                else if(selectedsex.equals("F"))
                {    if(locale.toUpperCase().equals("EN"))
					{
                    sql = " Select NAME_SUFFIX from MP_NAME_SUFFIX WHERE  BABY_SUFFIX_YN = 'Y' and BABY_SEX = 'F' and Eff_Status = 'E' " ; //Default the value as MP_Param.NAME_SUFFIX_FEMALE_NB
                    defval = dftfemalesuf;
					}else
					{
					 sql = " Select (CASE WHEN NAME_SUFFIX_LOC_LANG IS NOT NULL THEN NAME_SUFFIX_LOC_LANG ELSE  NAME_SUFFIX END) NAME_SUFFIX from MP_NAME_SUFFIX WHERE  BABY_SUFFIX_YN = 'Y' and BABY_SEX = 'F' and Eff_Status = 'E' " ; //Default the value as MP_Param.NAME_SUFFIX_FEMALE_NB
                    defval = dftfemalesuf;
					}
                }

                if(!sql.equals(""))
                {
                    
                    pstmt=con.prepareStatement(sql);
                    rset = pstmt.executeQuery();
                    if(rset!=null)
                    {
                        while(rset.next())
                        {
                            desc = rset.getString("NAME_SUFFIX");
                            %>
                                        <script>
                                                var temp ="<%=desc%>";
                                                var opt=parent.frames[1].frames[2].document.createElement("OPTION");
                                                opt.text=temp;
                                                opt.value=temp;
                                                if(temp=='<%=defval%>')
                                                    opt.selected = true;
                                                var comp=parent.frames[1].frames[2].document.forms[0].name_suffix;
                                                comp.add(opt);
                                        </script>
                            <%
                        }
                    }
                }
            }
            else if(value1.equals("father_patient_id"))
            {
				sql ="select decode('"+locale+"', 'en',patient_name, nvl(patient_name_loc_lang, patient_name)) patient_name,sex from mp_patient where PATIENT_ID=?  ";
                
                if(pstmt != null)   pstmt.close();
				if(rset  != null)   rset.close();
                pstmt = con.prepareStatement(sql); 			
                
                pstmt.setString(1,value2);
                rset = pstmt.executeQuery();
                
                boolean flag=true; 			

                if(rset.next())
                {
                    if(rset.getString(2).equals("M"))

                    {
                        fathername = rset.getString(1);							
                        out.println("<script>parent.frames[1].frames[2].document.forms[0].father_patient_name.readOnly=true; parent.frames[1].frames[2].document.forms[0].father_patient_name.value=\" "+fathername+" \";</script>"); 						
                    }
                    else
                    {
                        flag=false;
                        out.println("<script>alert(getMessage('GENDER_MISMATCH','MP'));parent.frames[1].frames[2].document.forms[0].father_patient_id.value='';parent.frames[1].frames[2].document.forms[0].father_patient_name.value='';parent.frames[1].frames[2].document.forms[0].father_patient_id.focus();</script>");
                    }
                }
                else
                {
                    flag=false;
                    out.println("<script>alert(getMessage('FATHER_PATID_INVALID','MP')); parent.frames[1].frames[2].document.forms[0].father_patient_id.value='';parent.frames[1].frames[2].document.forms[0].father_patient_id.focus();parent.frames[1].frames[2].document.forms[0].father_patient_name.value='';</script>");
                }
                if(flag)
                {
                            String sql2=" select to_char(DATE_OF_BIRTH,'dd/mm/yyyy')  from mp_patient where patient_id=? ";
                            
                            if(pstmt != null)   pstmt.close();
							if(rset2!=null) rset2.close();
                            pstmt = con.prepareStatement(sql2);
                            pstmt.setString(1,value2) ;
                            
                            rset2 = pstmt.executeQuery();
                            String dob="";
                            while(rset2.next())
                            {
                            dob= rset2.getString(1);
                            }

                            String sql3=" select NB_FATHER_MIN_AGE from mp_param";
                            
                            stmt3 = con.createStatement();
                            rset3 = stmt3.executeQuery(sql3);
                            int father_min_age=0;
                            while(rset3.next())
                            {
                            father_min_age=rset3.getInt(1);
                            }
                            int pat_age=0;
                            String sql4="select calculate_age('"+dob+"',1) from dual ";
                            stmt4 = con.createStatement();
                            rset4 = stmt4.executeQuery(sql4);
                            while(rset4.next())
                            {
                            pat_age=rset4.getInt(1);
                            }
                            
                            if(pat_age < father_min_age)
                            {
                            out.println("<script>alert(getMessage('FATHER_AGE_PARAM'),'MP');parent.frames[1].frames[2].document.forms[0].father_patient_id.value='';parent.frames[1].frames[2].document.forms[0].father_patient_id.focus();parent.frames[1].frames[2].document.forms[0].father_patient_name.value='';</script>");
                            }
                    }
                
            }
			else if(value1.equals("Umb_cord_cut_by"))
            {
                sql ="select count(PRACTITIONER_ID) from AM_PRACTITIONER where PRACTITIONER_ID=?";
                
                if(pstmt != null)   pstmt.close();
				if(rset  != null)   rset.close();
                pstmt = con.prepareStatement(sql);
                
                pstmt.setString(1,value2);
                rset = pstmt.executeQuery();
                
                //boolean flag=true;
				if(rset != null){
					if(rset.next()){
						String sql4="select B.POSITION_DESC JOB_TITLE from AM_PRACTITIONER A, AM_POSITION_LANG_VW B WHERE a.PRACTITIONER_ID =? and a.position_code=b.position_code(+) and language_id='"+locale+"'";						

						if(pstmt != null)   pstmt.close();
						if(rset != null) rset.close();
						pstmt = con.prepareStatement(sql4);
						
						pstmt.setString(1,value2);
						rset = pstmt.executeQuery();
						String desig="";
						if(rset != null){
							if(rset.next()){
								desig=rset.getString("JOB_TITLE");						
							}
						}

						
						if(desig==null || desig.equals("null")){
						}else{				
							out.println("<script>parent.frames[1].frames[2].document.getElementById('nmdesig').innerHTML=\"<b>"+desig+"\";</script>");
							
						}

						
					}else{
						// message to be changed to practitioner id
						out.println("<script>alert(getMessage('FATHER_PATID_INVALID','MP')); parent.frames[1].frames[2].document.forms[0].Umb_cord_cut_by.value='';parent.frames[1].frames[2].document.getElementById('nmdesig').innerHTML='';</script>");
					}
				}
			}else if(value1.equals("cboOccupationClass")){
								
                sql ="select short_desc,ocpn_code from MP_occupation_lang_vw where ocpn_class_code=? and language_id='"+locale+ "'";
                
                if(pstmt != null)   pstmt.close();
				if(rset != null) rset.close();
                pstmt = con.prepareStatement(sql);
                
                pstmt.setString(1,value2);
                rset = pstmt.executeQuery();
                
                //boolean flag=true;
				String disp="";
				String hid="";
				//String cont="";
				
                if(rset != null){

				while (rset.next())
				{
					hid	= rset.getString("ocpn_code");
					disp	= rset.getString("short_desc");

				%>
					<script>
						var temp = "<%=hid%>";
						var temp1="<%=disp%>";
						var opt=parent.frames[1].frames[2].document.createElement("OPTION");
						opt.text=temp1;
						opt.value=temp;
						parent.frames[1].frames[2].document.forms[0].cboOccupation.add(opt);

						var errors = '' ;
						

					</script>
		
				<%
                
					}
				}
			}else if(value1.equals("DtTm")){

				

				String d1=value2.substring(0,value2.indexOf(" "));
				//String d2=value2.substring(value2.indexOf(" " )+1);
				String d3=value3.substring(0,value3.indexOf("*"));
				String d4=value3.substring(value3.indexOf("*" )+1);
			

				if(d3.equals("H")){

					sql="SELECT (TO_DATE(TO_CHAR(SYSDATE,'dd/mm/yyyy hh24:mi'),'dd/mm/yyyy hh24:mi')";
					sql=sql +" - ";
					sql=sql +"TO_DATE('"+value2+"','dd/mm/yyyy hh24:mi'))* 100 FROM dual";
				}else{				

					sql="SELECT (TO_DATE(TO_CHAR(SYSDATE,'dd/mm/yyyy'),'dd/mm/yyyy')";
					sql=sql +" - ";
					sql=sql +"TO_DATE('"+d1+"','dd/mm/yyyy')) FROM dual";
				}
								
                
                
                if(pstmt != null)   pstmt.close();
                if(rset !=null) rset.close();
				pstmt = con.prepareStatement(sql);
                                
                rset = pstmt.executeQuery();
				double diff=0;
                if(rset != null){

				while (rset.next())
				{
					diff	= rset.getDouble(1);                
					}
				}
				
				
				double d44=Double.parseDouble(d4);
				
				
				if(d3.equals("H")){
					// 4.1666667 represents 1 hour
					if(diff>(d44*4.1666667)){
					out.println("<script>alert(getMessage('REGN_RSTRD_NB_HRS','MP'))");
					out.println("parent.frames[1].frames[2].document.forms[0].date_of_birth.value='';");
					 out.println("parent.frames[1].frames[2].document.forms[0].date_of_birth.focus()</script>");
					}
				}else{
					if(diff>d44){
					out.println("<script>alert(getMessage('REGN_RESTRICTED_FOR_NB','MP'))");
					out.println("parent.frames[1].frames[2].document.forms[0].date_of_birth.value='';");
					out.println("parent.frames[1].frames[2].document.forms[0].date_of_birth.focus()</script>");
					}		
				}
				
				
            }

			else if(value1.equals("pat_id"))
            {
				String name_prefix = "";
				String first_name = "";
				String second_name = "";
				String third_name = "";
				String family_name = "";
				String name_suffix = "";
				String name_prefix_loc_lang = "";
				String first_name_loc_lang = "";
				String second_name_loc_lang = "";
				String third_name_loc_lang = "";
				String family_name_loc_lang = "";
				String name_suffix_loc_lang = "";
				
                sql ="select decode('"+locale+"', 'en',patient_name, nvl(patient_name_loc_lang, patient_name)) patient_name,SEX,name_prefix, first_name, second_name, third_name, family_name, name_suffix, name_prefix_loc_lang, first_name_loc_lang, second_name_loc_lang, third_name_loc_lang, family_name_loc_lang, name_suffix_loc_lang from mp_patient where PATIENT_ID=? ";
                
                if(pstmt != null)   pstmt.close();
				if(rset != null)   rset.close();
                pstmt = con.prepareStatement(sql);
                
                pstmt.setString(1,value2);
                rset = pstmt.executeQuery();
                
                boolean flag=true;

                if(rset.next())
                {
                    if(rset.getString(2).equals("M"))

                    {
                        fathername = rset.getString(1);

						name_prefix = rset.getString("name_prefix")==null?"":rset.getString("name_prefix");
						first_name = rset.getString("first_name")==null?"":rset.getString("first_name");
						second_name = rset.getString("second_name")==null?"":rset.getString("second_name");
						third_name = rset.getString("third_name")==null?"":rset.getString("third_name");
						family_name = rset.getString("family_name")==null?"":rset.getString("family_name");
						name_suffix = rset.getString("name_suffix")==null?"":rset.getString("name_suffix");
						name_prefix_loc_lang = rset.getString("name_prefix_loc_lang")==null?"":rset.getString("name_prefix_loc_lang");
						first_name_loc_lang = rset.getString("first_name_loc_lang")==null?"":rset.getString("first_name_loc_lang");
						second_name_loc_lang = rset.getString("second_name_loc_lang")==null?"":rset.getString("second_name_loc_lang");
						third_name_loc_lang = rset.getString("third_name_loc_lang")==null?"":rset.getString("third_name_loc_lang");
						family_name_loc_lang = rset.getString("family_name_loc_lang")==null?"":rset.getString("family_name_loc_lang");
						name_suffix_loc_lang = rset.getString("name_suffix_loc_lang")==null?"":rset.getString("name_suffix_loc_lang");
                        out.println("<script>parent.frames[1].frames[2].document.forms[0].father_patient_name.readOnly=true; parent.frames[1].frames[2].document.forms[0].father_patient_name.value=\" "+fathername+" \";</script>");

						%>
<script>
	var fatherDtlsIndex	= "<%=fatherDtlsIndex%>";
	if(parent.frames[1].frames[2].document.forms[0].name_prefix) {
		parent.frames[1].frames[2].document.forms[0].name_prefix[fatherDtlsIndex].value="<%=name_prefix%>";
		parent.frames[1].frames[2].document.forms[0].name_prefix[fatherDtlsIndex].disabled = true;
	}
	if(parent.frames[1].frames[2].document.forms[0].first_name) {
		parent.frames[1].frames[2].document.forms[0].first_name[fatherDtlsIndex].value="<%=first_name%>";
		parent.frames[1].frames[2].document.forms[0].first_name[fatherDtlsIndex].disabled = true;
	}
	if(parent.frames[1].frames[2].document.forms[0].second_name) {
		parent.frames[1].frames[2].document.forms[0].second_name[fatherDtlsIndex].value="<%=second_name%>";
		parent.frames[1].frames[2].document.forms[0].second_name[fatherDtlsIndex].disabled = true;
	} 	
	
	if(parent.frames[1].frames[2].document.forms[0].third_name) {
		parent.frames[1].frames[2].document.forms[0].third_name[fatherDtlsIndex].value="<%=third_name%>";
		parent.frames[1].frames[2].document.forms[0].third_name[fatherDtlsIndex].disabled = true;
	} 	

	if(parent.frames[1].frames[2].document.forms[0].family_name) {
		parent.frames[1].frames[2].document.forms[0].family_name[fatherDtlsIndex].value="<%=family_name%>";
		parent.frames[1].frames[2].document.forms[0].family_name[fatherDtlsIndex].disabled = true;
	}
	if(parent.frames[1].frames[2].document.forms[0].name_suffix) {
		parent.frames[1].frames[2].document.forms[0].name_suffix[fatherDtlsIndex].value="<%=name_suffix%>";
		parent.frames[1].frames[2].document.forms[0].name_suffix[fatherDtlsIndex].disabled = true;
	}
				
	if(parent.frames[1].frames[2].document.forms[0].name_prefix_oth_lang) {											parent.frames[1].frames[2].document.forms[0].name_prefix_oth_lang[fatherDtlsIndex].value="<%=name_prefix_loc_lang%>";
		parent.frames[1].frames[2].document.forms[0].name_prefix_oth_lang[fatherDtlsIndex].disabled = true;
	}
	if(parent.frames[1].frames[2].document.forms[0].first_name_oth_lang) {											parent.frames[1].frames[2].document.forms[0].first_name_oth_lang[fatherDtlsIndex].value="<%=first_name_loc_lang%>";
		parent.frames[1].frames[2].document.forms[0].first_name_oth_lang[fatherDtlsIndex].disabled = true;
	}
	if(parent.frames[1].frames[2].document.forms[0].second_name_oth_lang) {											parent.frames[1].frames[2].document.forms[0].second_name_oth_lang[fatherDtlsIndex].value="<%=second_name_loc_lang%>";
		parent.frames[1].frames[2].document.forms[0].second_name_oth_lang[fatherDtlsIndex].disabled = true;
	}
	if(parent.frames[1].frames[2].document.forms[0].third_name_oth_lang) {											parent.frames[1].frames[2].document.forms[0].third_name_oth_lang[fatherDtlsIndex].value="<%=third_name_loc_lang%>";
		parent.frames[1].frames[2].document.forms[0].third_name_oth_lang[fatherDtlsIndex].disabled = true;
	}
	if(parent.frames[1].frames[2].document.forms[0].family_name_oth_lang) {											parent.frames[1].frames[2].document.forms[0].family_name_oth_lang[fatherDtlsIndex].value="<%=family_name_loc_lang%>";
		parent.frames[1].frames[2].document.forms[0].family_name_oth_lang[fatherDtlsIndex].disabled = true;
	}
	if(parent.frames[1].frames[2].document.forms[0].name_suffix_oth_lang) {											parent.frames[1].frames[2].document.forms[0].name_suffix_oth_lang[fatherDtlsIndex].value="<%=name_suffix_loc_lang%>";
		parent.frames[1].frames[2].document.forms[0].name_suffix_oth_lang[fatherDtlsIndex].disabled = true;
	}

</script>
						<%
                    }
                    else
                    {
                        flag=false; %>
                        <script>
						alert(getMessage('GENDER_MISMATCH','MP'));
						parent.frames[1].frames[2].document.forms[0].father_patient_id.value='';
						parent.frames[1].frames[2].document.forms[0].father_patient_name.value='';
						parent.frames[1].frames[2].document.forms[0].father_patient_id.focus();
					 	
						if(parent.frames[1].frames[2].document.forms[0].National_id){									parent.frames[1].frames[2].document.forms[0].National_id.value='';		
							parent.frames[1].frames[2].document.forms[0].National_id.disabled=false;
						}
							
						if(parent.frames[1].frames[2].document.forms[0].cboOtherAltID){	                                  parent.frames[1].frames[2].document.forms[0].cboOtherAltID.options[0].selected=true;
							parent.frames[1].frames[2].document.forms[0].cboOtherAltID.disabled=false;		
						}

						if(parent.frames[1].frames[2].document.forms[0].txtOtherAltID){	                                  parent.frames[1].frames[2].document.forms[0].txtOtherAltID.value='';
							parent.frames[1].frames[2].document.forms[0].txtOtherAltID.disabled=false;	
						}

						parent.frames[1].frames[2].document.forms[0].cboNationality_desc.value='';
						parent.frames[1].frames[2].document.forms[0].cboNationality_desc.disabled=false;
						parent.frames[1].frames[2].document.forms[0].cboNationality.value='';
						parent.frames[1].frames[2].document.forms[0].cboNationality_button.disabled=false;	
						//parent.frames[1].frames[2].document.forms[0].cboEthnicGroup.options[0].selected=true;	
						//parent.frames[1].frames[2].document.forms[0].cboEthnicGroup.disabled=false;
						parent.frames[1].frames[2].document.forms[0].cboEthnicGroupDesc.value='';	
						parent.frames[1].frames[2].document.forms[0].cboEthnicGroupDesc.disabled=false;	
						parent.frames[1].frames[2].document.forms[0].cboEthnicGroupBtn.disabled=false;	
						parent.frames[1].frames[2].document.forms[0].cboReligion.options[0].selected=true;		
						parent.frames[1].frames[2].document.forms[0].cboReligion.disabled=false;						
						parent.frames[1].frames[2].document.forms[0].cboOccupationClass.options[0].selected=true;	
						parent.frames[1].frames[2].document.forms[0].cboOccupationClass.disabled=false;			
						parent.frames[1].frames[2].document.forms[0].cboOccupation.options[0].selected=true;	
						parent.frames[1].frames[2].document.forms[0].cboOccupation.disabled=false;				
						parent.frames[1].frames[2].document.forms[0].Occupation_Desc.value='';						
						parent.frames[1].frames[2].document.forms[0].Occupation_Desc.disabled=false;				
						parent.frames[1].frames[2].document.forms[0].fatherRemarks.value='';							
						parent.frames[1].frames[2].document.forms[0].fatherRemarks.disabled=false;
						
						if(parent.frames[1].frames[2].document.forms[0].natImg.style.visibility == 'visible')
							parent.frames[1].frames[2].document.forms[0].natImg.style.visibility = 'hidden';
						if(parent.frames[1].frames[2].document.forms[0].racImg.style.visibility == 'visible')
							parent.frames[1].frames[2].document.forms[0].racImg.style.visibility = 'hidden';
						</script>
<%
                    }
                }
                else
                {
                    flag=false;
                    %>
				<script>
				alert(getMessage('FATHER_PATID_INVALID','MP')); parent.frames[1].frames[2].document.forms[0].father_patient_id.value='';
				parent.frames[1].frames[2].document.forms[0].father_patient_id.focus();
				parent.frames[1].frames[2].document.forms[0].father_patient_name.value='';
			if(parent.frames[1].frames[2].document.forms[0].father_alt_id1_no)	parent.frames[1].frames[2].document.forms[0].father_alt_id1_no.value='';
			if(parent.frames[1].frames[2].document.forms[0].father_alt_id2_no)	parent.frames[1].frames[2].document.forms[0].father_alt_id2_no.value='';
			if(parent.frames[1].frames[2].document.forms[0].father_alt_id3_no)	parent.frames[1].frames[2].document.forms[0].father_alt_id3_no.value='';
			if(parent.frames[1].frames[2].document.forms[0].father_alt_id4_no)	parent.frames[1].frames[2].document.forms[0].father_alt_id4_no.value='';
				if(parent.frames[1].frames[2].document.forms[0].National_id){
				parent.frames[1].frames[2].document.forms[0].National_id.value='';							
				parent.frames[1].frames[2].document.forms[0].National_id.disabled=false;}	
			if(parent.frames[1].frames[2].document.forms[0].cboOtherAltID){	parent.frames[1].frames[2].document.forms[0].cboOtherAltID.options[0].selected=true;						
				parent.frames[1].frames[2].document.forms[0].cboOtherAltID.disabled=false;	
			}
			if(parent.frames[1].frames[2].document.forms[0].txtOtherAltID){
				
				parent.frames[1].frames[2].document.forms[0].txtOtherAltID.value='';							
				parent.frames[1].frames[2].document.forms[0].txtOtherAltID.disabled=false;	
			}
				
				parent.frames[1].frames[2].document.forms[0].cboNationality_desc.value='';										
				parent.frames[1].frames[2].document.forms[0].cboNationality_desc.disabled=false;
				parent.frames[1].frames[2].document.forms[0].cboNationality.value='';
				parent.frames[1].frames[2].document.forms[0].cboNationality_button.disabled=false;	

				/*
				parent.frames[1].frames[2].document.forms[0].cboEthnicGroup.options[0].selected=true;	
				parent.frames[1].frames[2].document.forms[0].cboEthnicGroup.disabled=false;						
				*/
				
				parent.frames[1].frames[2].document.forms[0].cboEthnicGroupDesc.value='';	
				parent.frames[1].frames[2].document.forms[0].cboEthnicGroupDesc.disabled=false;	
				parent.frames[1].frames[2].document.forms[0].cboEthnicGroupBtn.disabled=false;	

				parent.frames[1].frames[2].document.forms[0].cboReligion.options[0].selected=true;
				parent.frames[1].frames[2].document.forms[0].cboReligion.disabled=false;							
				parent.frames[1].frames[2].document.forms[0].cboOccupationClass.options[0].selected=true;	
				parent.frames[1].frames[2].document.forms[0].cboOccupationClass.disabled=false;							
				parent.frames[1].frames[2].document.forms[0].cboOccupation.options[0].selected=true;						
				parent.frames[1].frames[2].document.forms[0].cboOccupation.disabled=false;							
				parent.frames[1].frames[2].document.forms[0].Occupation_Desc.value='';							
				parent.frames[1].frames[2].document.forms[0].Occupation_Desc.disabled=false;					
				parent.frames[1].frames[2].document.forms[0].fatherRemarks.value='';						
				parent.frames[1].frames[2].document.forms[0].fatherRemarks.disabled=false;

				if(parent.frames[1].frames[2].document.forms[0].natImg.style.visibility == 'visible')
					parent.frames[1].frames[2].document.forms[0].natImg.style.visibility = 'hidden';
				if(parent.frames[1].frames[2].document.forms[0].racImg.style.visibility == 'visible')
					parent.frames[1].frames[2].document.forms[0].racImg.style.visibility = 'hidden';
				
				
			</script>
						<%					
                }
                if(flag)
                {
                            String sql2=" select to_char(DATE_OF_BIRTH,'dd/mm/yyyy')  from mp_patient where patient_id=? ";
                            
                            if(pstmt != null)   pstmt.close();
							if(rset2 != null)   rset2.close();
                            pstmt = con.prepareStatement(sql2);
                            pstmt.setString(1,value2) ;
                            
                            rset2 = pstmt.executeQuery();
                            String dob="";
                            while(rset2.next())
                            {
                            dob= rset2.getString(1);
                            }

                            String sql3=" select NB_FATHER_MIN_AGE from mp_param";
                            
							if(stmt3!=null) stmt3.close();
							if(rset3!=null) rset3.close();
                            stmt3 = con.createStatement();
                            rset3 = stmt3.executeQuery(sql3);
                            int father_min_age=0;
                            while(rset3.next())
                            {
                            father_min_age=rset3.getInt(1);
                            }
                            int pat_age=0;
                            String sql4="select calculate_age('"+dob+"',1) from dual ";
							if(stmt4!=null) stmt4.close();
							if(rset4!=null) rset4.close();
                            stmt4 = con.createStatement();
                            rset4 = stmt4.executeQuery(sql4);
                            while(rset4.next())
                            {
                            pat_age=rset4.getInt(1);
                            }
                            
                            if(pat_age < father_min_age)
                            {
                            out.println("<script>alert(getMessage('FATHER_AGE_PARAM','MP'));parent.frames[1].frames[2].document.forms[0].father_patient_id.value='';parent.frames[1].frames[2].document.forms[0].father_patient_id.focus();parent.frames[1].frames[2].document.forms[0].father_patient_name.value='';</script>");

							%>
						<script>
	var fatherDtlsIndex	= "<%=fatherDtlsIndex%>";

	if(parent.frames[1].frames[2].document.forms[0].name_prefix) {
		parent.frames[1].frames[2].document.forms[0].name_prefix[fatherDtlsIndex].value="";
		parent.frames[1].frames[2].document.forms[0].name_prefix[fatherDtlsIndex].disabled = false;
	}
	if(parent.frames[1].frames[2].document.forms[0].first_name) {
		parent.frames[1].frames[2].document.forms[0].first_name[fatherDtlsIndex].value="";
		parent.frames[1].frames[2].document.forms[0].first_name[fatherDtlsIndex].disabled = false;
	}
	if(parent.frames[1].frames[2].document.forms[0].second_name) {
		parent.frames[1].frames[2].document.forms[0].second_name[fatherDtlsIndex].value="";
		parent.frames[1].frames[2].document.forms[0].second_name[fatherDtlsIndex].disabled = false;
	} 	
	
	if(parent.frames[1].frames[2].document.forms[0].third_name) {
		parent.frames[1].frames[2].document.forms[0].third_name[fatherDtlsIndex].value="";
		parent.frames[1].frames[2].document.forms[0].third_name[fatherDtlsIndex].disabled = false;
	} 	

	if(parent.frames[1].frames[2].document.forms[0].family_name) {
		parent.frames[1].frames[2].document.forms[0].family_name[fatherDtlsIndex].value="";
		parent.frames[1].frames[2].document.forms[0].family_name[fatherDtlsIndex].disabled = false;
	}
	if(parent.frames[1].frames[2].document.forms[0].name_suffix) {
		parent.frames[1].frames[2].document.forms[0].name_suffix[fatherDtlsIndex].value="";
		parent.frames[1].frames[2].document.forms[0].name_suffix[fatherDtlsIndex].disabled = false;
	}
				
	if(parent.frames[1].frames[2].document.forms[0].name_prefix_oth_lang) {											parent.frames[1].frames[2].document.forms[0].name_prefix_oth_lang[fatherDtlsIndex].value="";
		parent.frames[1].frames[2].document.forms[0].name_prefix_oth_lang[fatherDtlsIndex].disabled = false;
	}
	if(parent.frames[1].frames[2].document.forms[0].first_name_oth_lang) {											parent.frames[1].frames[2].document.forms[0].first_name_oth_lang[fatherDtlsIndex].value="";
		parent.frames[1].frames[2].document.forms[0].first_name_oth_lang[fatherDtlsIndex].disabled = false;
	}
	if(parent.frames[1].frames[2].document.forms[0].second_name_oth_lang) {											parent.frames[1].frames[2].document.forms[0].second_name_oth_lang[fatherDtlsIndex].value="";
		parent.frames[1].frames[2].document.forms[0].second_name_oth_lang[fatherDtlsIndex].disabled = false;
	}
	if(parent.frames[1].frames[2].document.forms[0].third_name_oth_lang) {											parent.frames[1].frames[2].document.forms[0].third_name_oth_lang[fatherDtlsIndex].value="";
		parent.frames[1].frames[2].document.forms[0].third_name_oth_lang[fatherDtlsIndex].disabled = false;
	}
	if(parent.frames[1].frames[2].document.forms[0].family_name_oth_lang) {											parent.frames[1].frames[2].document.forms[0].family_name_oth_lang[fatherDtlsIndex].value="";
		parent.frames[1].frames[2].document.forms[0].family_name_oth_lang[fatherDtlsIndex].disabled = false;
	}
	if(parent.frames[1].frames[2].document.forms[0].name_suffix_oth_lang) {											parent.frames[1].frames[2].document.forms[0].name_suffix_oth_lang[fatherDtlsIndex].value="";
		parent.frames[1].frames[2].document.forms[0].name_suffix_oth_lang[fatherDtlsIndex].disabled = false;
	}
						if(parent.frames[1].frames[2].document.forms[0].National_id){	parent.frames[1].frames[2].document.forms[0].National_id.value='';
							parent.frames[1].frames[2].document.forms[0].National_id.disabled=false;	}	

							
						if(parent.frames[1].frames[2].document.forms[0].cboOtherAltID){	parent.frames[1].frames[2].document.forms[0].cboOtherAltID.options[0].selected=true;
							parent.frames[1].frames[2].document.forms[0].cboOtherAltID.disabled=false;
						}

						if(parent.frames[1].frames[2].document.forms[0].txtOtherAltID){	parent.frames[1].frames[2].document.forms[0].txtOtherAltID.value='';
							parent.frames[1].frames[2].document.forms[0].txtOtherAltID.disabled=false;
						}

							parent.frames[1].frames[2].document.forms[0].cboNationality_desc.value='';				
							parent.frames[1].frames[2].document.forms[0].cboNationality_desc.disabled=false;
							parent.frames[1].frames[2].document.forms[0].cboNationality.value='';
							parent.frames[1].frames[2].document.forms[0].cboNationality_button.disabled=false;	

							/*
							parent.frames[1].frames[2].document.forms[0].cboEthnicGroup.options[0].selected=true;
							parent.frames[1].frames[2].document.forms[0].cboEthnicGroup.disabled=false;
							*/

							parent.frames[1].frames[2].document.forms[0].cboEthnicGroupDesc.value='';
							parent.frames[1].frames[2].document.forms[0].cboEthnicGroupDesc.disabled=false;
							parent.frames[1].frames[2].document.forms[0].cboEthnicGroupBtn.disabled=false;

							parent.frames[1].frames[2].document.forms[0].cboReligion.options[0].selected=true;
							parent.frames[1].frames[2].document.forms[0].cboReligion.disabled=false;

							parent.frames[1].frames[2].document.forms[0].cboOccupationClass.options[0].selected=true;
							parent.frames[1].frames[2].document.forms[0].cboOccupationClass.disabled=false;

							parent.frames[1].frames[2].document.forms[0].cboOccupation.options[0].selected=true;
							parent.frames[1].frames[2].document.forms[0].cboOccupation.disabled=false;

							parent.frames[1].frames[2].document.forms[0].Occupation_Desc.value='';
							parent.frames[1].frames[2].document.forms[0].Occupation_Desc.disabled=false;

							parent.frames[1].frames[2].document.forms[0].fatherRemarks.value='';							parent.frames[1].frames[2].document.forms[0].fatherRemarks.disabled=false;


							if(parent.frames[1].frames[2].document.forms[0].natImg.style.visibility == 'visible')
								parent.frames[1].frames[2].document.forms[0].natImg.style.visibility = 'hidden';
							if(parent.frames[1].frames[2].document.forms[0].racImg.style.visibility == 'visible')
								parent.frames[1].frames[2].document.forms[0].racImg.style.visibility = 'hidden';

						</script>
						<%
                            }else{

								//String sql21="SELECT   a.alt_id1_no alt_id1_no,a.national_id_no AS nid, a.oth_alt_id_type oidtyp, a.oth_alt_id_no AS oidno,  a.nationality_code AS ncd,  a.race_code AS racecode,  a.relgn_code AS relgcd,  b.ocpn_class_code AS occlscd,  b.ocpn_code AS occd,  b.ocpn_desc AS ocpn_desc,  c.long_name   nationality_desc FROM   mp_patient a,  mp_pat_rel_contacts b,  mp_country_lang_vw c WHERE   a.patient_id=? AND  a.patient_id=b.patient_id AND  a.nationality_code=c.country_code  AND c.language_id='"+locale+"'";
								/*String sql21="SELECT   a.alt_id1_no alt_id1_no,a.national_id_no AS nid, a.oth_alt_id_type oidtyp, a.oth_alt_id_no AS oidno,  a.nationality_code AS ncd,  a.race_code AS racecode, d.long_desc race_desc, a.relgn_code AS relgcd,  b.ocpn_class_code AS occlscd,  b.ocpn_code AS occd,  b.ocpn_desc AS ocpn_desc,  c.long_desc   nationality_desc FROM   mp_patient a,  mp_pat_rel_contacts b,  mp_country_lang_vw c, mp_race_lang_vw d WHERE   a.patient_id=? AND  a.patient_id=b.patient_id AND  a.nationality_code=c.country_code  AND a.race_code = d.race_code and c.language_id='"+locale+"' and d.language_id='"+locale+"'";*/
								String sql21="SELECT   a.alt_id1_no alt_id1_no,a.alt_id2_no alt_id2_no,a.alt_id3_no alt_id3_no,a.alt_id4_no alt_id4_no,a.national_id_no AS nid, a.oth_alt_id_type oidtyp, a.oth_alt_id_no AS oidno,a.nationality_code AS ncd,  a.race_code AS racecode, mp_get_desc.mp_race(a.race_code,'"+locale+"',1) race_desc, a.relgn_code AS relgcd, b.ocpn_class_code AS occlscd,  b.ocpn_code AS occd,  b.ocpn_desc AS ocpn_desc,  mp_get_desc.mp_country(a.nationality_code,'"+locale+"',1) nationality_desc FROM mp_patient a,  mp_pat_rel_contacts b WHERE a.patient_id=? AND a.patient_id = b.patient_id ";
								
								if(pstmt != null)   pstmt.close();
								if(rset2 != null)   rset2.close();
								pstmt = con.prepareStatement(sql21);
								pstmt.setString(1,value2) ;
								
								rset2 = pstmt.executeQuery();
								
								String tmpnid="";
								String tmpoidtyp="";
								String tmpoidno="";
								String tmpncd="";								
								String tmpethgrp="";
								String tmprelgcd="";								
								String tmpocclscd="";
								String tmpoccd="";
								String tmpocpndesc="";
								String alt_id1_no="";
								String alt_id2_no="";
								String alt_id3_no="";
								String alt_id4_no="";
								String nationality_desc="";
								String race_desc="";

								if(rset2 != null){	
									
									if(rset2.next()){
										alt_id1_no=rset2.getString("alt_id1_no");
										alt_id2_no=rset2.getString("alt_id2_no");
										alt_id3_no=rset2.getString("alt_id3_no");
										alt_id4_no=rset2.getString("alt_id4_no");
										tmpnid=rset2.getString("nid");
										tmpoidtyp=rset2.getString("oidtyp");
										tmpoidno=rset2.getString("oidno");
										tmpncd=rset2.getString("ncd");
										tmpethgrp=rset2.getString("racecode");
										tmprelgcd=rset2.getString("relgcd");
										tmpocclscd=rset2.getString("occlscd");
										tmpoccd=rset2.getString("occd");
										tmpocpndesc=rset2.getString("ocpn_desc");
										nationality_desc=rset2.getString("nationality_desc");
										race_desc=rset2.getString("race_desc");
										if(nationality_desc ==null) nationality_desc="";
									}
								}								
								if(alt_id1_no==null || alt_id1_no.equals("null")){
									%>
									<script>
									if(parent.frames[1].frames[2].document.forms[0].father_alt_id1_no){
										parent.frames[1].frames[2].document.forms[0].father_alt_id1_no.value='';
									    parent.frames[1].frames[2].document.forms[0].father_alt_id1_no.disabled=true;
										}
									</script>
									<%
								}else{
								out.println("<script>if(parent.frames[1].frames[2].document.forms[0].father_alt_id1_no)parent.frames[1].frames[2].document.forms[0].father_alt_id1_no.value='"+alt_id1_no+"';</script>");
								%>
								<script>	if(parent.frames[1].frames[2].document.forms[0].father_alt_id1_no)parent.frames[1].frames[2].document.forms[0].father_alt_id1_no.disabled=true;
								</script>
								<%}if(alt_id2_no==null || alt_id2_no.equals("null")){%>
									<script>
									if(parent.frames[1].frames[2].document.forms[0].father_alt_id2_no){
										parent.frames[1].frames[2].document.forms[0].father_alt_id2_no.value='';
									parent.frames[1].frames[2].document.forms[0].father_alt_id2_no.disabled=true;
									}
									</script>
									<%
								}else{
								out.println("<script>if(parent.frames[1].frames[2].document.forms[0].father_alt_id2_no)parent.frames[1].frames[2].document.forms[0].father_alt_id2_no.value='"+alt_id2_no+"';</script>");
								%>
								<script>if(parent.frames[1].frames[2].document.forms[0].father_alt_id2_no)
								parent.frames[1].frames[2].document.forms[0].father_alt_id2_no.disabled=true;
								</script>
								
								<%}if(alt_id3_no==null || alt_id3_no.equals("null")){%>
									<script>
									if(parent.frames[1].frames[2].document.forms[0].father_alt_id3_no){
										parent.frames[1].frames[2].document.forms[0].father_alt_id3_no.value='';
									parent.frames[1].frames[2].document.forms[0].father_alt_id3_no.disabled=true;
									}
									</script>
									<%
								}else{
								out.println("<script>if(parent.frames[1].frames[2].document.forms[0].father_alt_id3_no)parent.frames[1].frames[2].document.forms[0].father_alt_id3_no.value='"+alt_id3_no+"';</script>");
								%>
								<script>	if(parent.frames[1].frames[2].document.forms[0].father_alt_id3_no) parent.frames[1].frames[2].document.forms[0].father_alt_id3_no.disabled=true;
								</script>
								<%}if(alt_id4_no==null || alt_id4_no.equals("null")){
									%>
									<script>
									if(parent.frames[1].frames[2].document.forms[0].father_alt_id4_no){
										parent.frames[1].frames[2].document.forms[0].father_alt_id4_no.value='';
									    parent.frames[1].frames[2].document.forms[0].father_alt_id4_no.disabled=true;
										}
									</script>
									<%
								}else{
								out.println("<script>if(parent.frames[1].frames[2].document.forms[0].father_alt_id4_no)parent.frames[1].frames[2].document.forms[0].father_alt_id4_no.value='"+alt_id4_no+"';</script>");
								%>
								<script>if(parent.frames[1].frames[2].document.forms[0].father_alt_id4_no)
								parent.frames[1].frames[2].document.forms[0].father_alt_id4_no.disabled=true;
								</script>
								<%
								}
								if(tmpnid==null || tmpnid.equals("null")){
								%>
								<script>
								if(parent.frames[1].frames[2].document.forms[0].National_id){				parent.frames[1].frames[2].document.forms[0].National_id.value='';
								parent.frames[1].frames[2].document.forms[0].National_id.disabled=true;}
								</script>
								<%
								}else{%>
								<script>
								if(parent.frames[1].frames[2].document.forms[0].National_id){	parent.frames[1].frames[2].document.forms[0].National_id.value="<%=tmpnid%>";
								parent.frames[1].frames[2].document.forms[0].National_id.disabled=true;
								}
								</script>
								<%
								}
								if(tmpoidtyp==null || tmpoidtyp.equals("null")){
								%>
								<script>
								if(parent.frames[1].frames[2].document.forms[0].txtOtherAltID){	parent.frames[1].frames[2].document.forms[0].cboOtherAltID.options[0].selected=true;
									parent.frames[1].frames[2].document.forms[0].cboOtherAltID.disabled=true;}
								</script>
								<%
								}else{
								
								%>
								<script>	
								
								var temp;
							if(parent.frames[1].frames[2].document.forms[0].txtOtherAltID){	for(i=0;i<parent.frames[1].frames[2].document.forms[0].cboOtherAltID.options.length;i++){
									
								temp=parent.frames[1].frames[2].document.forms[0].cboOtherAltID.options[i].value;
								
								if('<%=tmpoidtyp%>'==temp){
									parent.frames[1].frames[2].document.forms[0].cboOtherAltID.options[i].selected=true;
									//parent.frames[1].frames[1].document.forms[0].cboOtherAltID.disabled=true;
								}
								
								}
									parent.frames[1].frames[2].document.forms[0].cboOtherAltID.disabled=true;	
								}			
									</script>
									<%
										
									
								}
								
								
								if(tmpoidno==null || tmpoidno.equals("null")){
									%>
									<script>
									if(parent.frames[1].frames[2].document.forms[0].txtOtherAltID){	parent.frames[1].frames[2].document.forms[0].txtOtherAltID.value='';
										parent.frames[1].frames[2].document.forms[0].txtOtherAltID.disabled=true;
									}
									</script>
									<%
								}else{
									out.println("<script>if(parent.frames[1].frames[2].document.forms[0].txtOtherAltID){parent.frames[1].frames[2].document.forms[0].txtOtherAltID.value='"+tmpoidno+"';parent.frames[1].frames[2].document.forms[0].txtOtherAltID.disabled=true;}</script>");									
								}

								
								if(tmpncd==null || tmpncd.equals("null")){
									%>
									<script>
								parent.frames[1].frames[2].document.forms[0].cboNationality_desc.value='';
								parent.frames[1].frames[2].document.forms[0].cboNationality_desc.disabled=true;
								parent.frames[1].frames[2].document.forms[0].cboNationality.value='';
								parent.frames[1].frames[2].document.forms[0].cboNationality_button.disabled=true;	
									</script>
									<%
								} else {
									%>
									<script>
									/*	 var temp;
									for(i=0;i<parent.frames[1].frames[2].document.forms[0].cboNationality.options.length;i++){
									temp=parent.frames[1].frames[2].document.forms[0].cboNationality.options[i].value;
									if('<%=tmpncd%>'==temp){
										parent.frames[1].frames[2].document.forms[0].cboNationality.options[i].selected=true;  
										parent.frames[1].frames[1].document.forms[0].cboNationality.disabled=true;
									}}		 */								
										
								parent.frames[1].frames[2].document.forms[0].cboNationality.value='<%=tmpncd%>';
								parent.frames[1].frames[2].document.forms[0].cboNationality_desc.value="<%=nationality_desc%>";
					            parent.frames[1].frames[2].document.forms[0].cboNationality_button.disabled=true;
								parent.frames[1].frames[2].document.forms[0].cboNationality_desc.disabled=true;
									</script>
									<%
									
								}

								if(tmpethgrp==null || tmpethgrp.equals("null")){
									%>
									<script> 
										/*	parent.frames[1].frames[2].document.forms[0].cboEthnicGroup.options[0].selected=true;
										parent.frames[1].frames[2].document.forms[0].cboEthnicGroup.disabled=false;
										*/
								parent.frames[1].frames[2].document.forms[0].cboEthnicGroupDesc.value='';
								parent.frames[1].frames[2].document.forms[0].cboEthnicGroupDesc.disabled = true;
								parent.frames[1].frames[2].document.forms[0].cboEthnicGroupBtn.disabled = true;

									</script>
									<%
								} else {
									%>
									<script>
									/*
									var temp;
									for(i=0;i<parent.frames[1].frames[2].document.forms[0].cboEthnicGroup.options.length;i++){
									
									temp=parent.frames[1].frames[2].document.forms[0].cboEthnicGroup.options[i].value;
									
									if('<%=tmpethgrp%>'==temp){
										parent.frames[1].frames[2].document.forms[0].cboEthnicGroup.options[i].selected=true;
										//parent.frames[1].frames[1].document.forms[0].cboEthnicGroup.disabled=true;
									}
									
									}
									*/
									parent.frames[1].frames[2].document.forms[0].cboEthnicGroupDesc.value='<%=race_desc%>';									parent.frames[1].frames[2].document.forms[0].cboEthnicGroup.value='<%=tmpethgrp%>';
									parent.frames[1].frames[2].document.forms[0].cboEthnicGroupDesc.disabled=true;
									parent.frames[1].frames[2].document.forms[0].cboEthnicGroupBtn.disabled=true;										
									</script>
									<%
								}

								if(tmprelgcd==null || tmprelgcd.equals("null")){
									%>
									<script>
										parent.frames[1].frames[2].document.forms[0].cboReligion.options[0].selected=true;
										parent.frames[1].frames[2].document.forms[0].cboReligion.disabled=true;
									</script>
									<%
								}else{
									%>
									<script>
									var temp;
									for(i=0;i<parent.frames[1].frames[2].document.forms[0].cboReligion.options.length;i++){
									
									temp=parent.frames[1].frames[2].document.forms[0].cboReligion.options[i].value;
									
									if('<%=tmprelgcd%>'==temp){
										parent.frames[1].frames[2].document.forms[0].cboReligion.options[i].selected=true;
										//parent.frames[1].frames[1].document.forms[0].cboReligion.disabled=true;
									}
									
									}
									parent.frames[1].frames[2].document.forms[0].cboReligion.disabled=true;									
									</script>
									<%
								}

									if(tmpocclscd==null || tmpocclscd.equals("null")){
									%>
									<script>
										parent.frames[1].frames[2].document.forms[0].cboOccupationClass.options[0].selected=true;
										parent.frames[1].frames[2].document.forms[0].cboOccupationClass.disabled=true;
									</script>
									<%
								}else{
									%>
									<script>
									var temp;
									for(i=0;i<parent.frames[1].frames[2].document.forms[0].cboOccupationClass.options.length;i++){
									
									temp=parent.frames[1].frames[2].document.forms[0].cboOccupationClass.options[i].value;
									
									if('<%=tmpocclscd%>'==temp){
										parent.frames[1].frames[2].document.forms[0].cboOccupationClass.options[i].selected=true;
										//parent.frames[1].frames[1].document.forms[0].cboOccupationClass.disabled=true;
									}
									
									}
									parent.frames[1].frames[2].document.forms[0].cboOccupationClass.disabled=true;										
									</script>
									<%
								}

								if(tmpoccd==null || tmpoccd.equals("null")){
									%>
									<script>
										parent.frames[1].frames[2].document.forms[0].cboOccupation.options[0].selected=true;
										parent.frames[1].frames[2].document.forms[0].cboOccupation.disabled=true;
									</script>
									<%
								}else{
										try{
											sqlRelation = "SELECT ocpn_code, short_desc FROM mp_occupation_lang_vw where OCPN_CODE = ? and language_id='"+locale+"'";
											pstmt1 = con.prepareStatement(sqlRelation);
											pstmt1.setString(1,tmpoccd);
											rset5 = pstmt1.executeQuery();
											if(rset5 != null)
												{
											while(rset5.next())	
												{

											strOccupationCode = rset5.getString("ocpn_code");
											strOccupationDesc = rset5.getString("short_desc");
												}
												}
											
										}
										catch(Exception e)
										{out.println(e.toString());}
										finally {
										if(rset5 != null)rset5.close();
										if(pstmt1 != null)pstmt1.close();
										}
									
									%>	<script>
										var temp = "<%=strOccupationCode%>";
										var temp1="<%=strOccupationDesc%>";
										var n = parent.frames[1].frames[2].document.forms[0].cboOccupation.options.length;
										for(var i=0;i<n;i++)
										{				
										parent.frames[1].frames[2].document.forms[0].cboOccupation.remove("cboOccupation");				
										}
										
										var opt=parent.frames[1].frames[2].document.createElement("OPTION");									
				
											opt.text=temp1;
											opt.value=temp;
										
										parent.frames[1].frames[2].document.forms[0].cboOccupation.add(opt);																
																	
										parent.frames[1].frames[2].document.forms[0].cboOccupation.disabled=true;									
									</script>
									<%
								}

									if(tmpocpndesc==null || tmpocpndesc.equals("null")){
									%>
									<script>
										parent.frames[1].frames[2].document.forms[0].Occupation_Desc.value='';
										parent.frames[1].frames[2].document.forms[0].Occupation_Desc.disabled=true;
									</script>
									<%
								}else{
									out.println("<script>parent.frames[1].frames[2].document.forms[0].Occupation_Desc.value='"+tmpocpndesc+"';</script>");
									%>
									<script>
										parent.frames[1].frames[2].document.forms[0].Occupation_Desc.disabled=true;
									</script>
										<%
								}
		
							}
                    }
                
            }
			else if(value1.equals("born_at"))
			{
				String function_idborn=checkForNull(request.getParameter("function_idborn"));
				String ipatenatalfun=checkForNull(request.getParameter("ipatenatalfun"));
				%>
				<script>
				var tempval;
				//if('<%=function_idborn%>'=='REGISTER_NEWBORN')
				tempval=2;
			    //else 
				//tempval=2;

					var n=parent.frames[1].frames[tempval].document.forms[0].<%=ipatenatalfun%>.options.length;
							for(var i=0;i<n;i++)
							{				
							parent.frames[1].frames[tempval].document.forms[0].<%=ipatenatalfun%>.remove("born_at_locn_code");				
							}
				var temp = "";
				var temp1 = '---'+getLabel("Common.defaultSelect.label","Common")+'---';
				//var temp1="--- Select ---";
						
				var opt=parent.frames[1].frames[tempval].document.createElement("OPTION");
					opt.text=temp1;
					opt.value=temp;
				parent.frames[1].frames[tempval].document.forms[0].<%=ipatenatalfun%>.add(opt);
				</script>
				<%
				if(!born_at.equals(""))	
				{
				if(born_at.equals("C"))	
				{
				sql ="SELECT long_desc SHORT_DESC, CLINIC_CODE FROM OP_CLINIC_lang_vw WHERE FACILITY_ID ='"+facilityId+"'  AND EFF_STATUS = 'E' AND LEVEL_OF_CARE_IND = 'A' AND CARE_LOCN_TYPE_IND = 'C'  and language_id='"+locale+"' ORDER BY SHORT_DESC ";
				}
				else if(born_at.equals("E"))	
				{
					sql = " SELECT long_desc SHORT_DESC, CLINIC_CODE FROM OP_CLINIC_lang_vw WHERE FACILITY_ID = '"+facilityId+"' AND EFF_STATUS = 'E' AND LEVEL_OF_CARE_IND = 'E' AND CARE_LOCN_TYPE_IND = 'C' and language_id='"+locale+"' ORDER BY SHORT_DESC ";
				}
				else if(born_at.equals("D"))	
				{
					sql = " SELECT long_desc SHORT_DESC, CLINIC_CODE FROM OP_CLINIC_lang_vw WHERE FACILITY_ID = '"+facilityId+"' AND EFF_STATUS = 'E' AND LEVEL_OF_CARE_IND = 'A' AND CARE_LOCN_TYPE_IND = 'D' and language_id='"+locale+"' ORDER BY SHORT_DESC ";
				}
				else if(born_at.equals("N"))	
				{
					sql = " SELECT long_desc SHORT_DESC, NURSING_UNIT_CODE CLINIC_CODE FROM IP_NURSING_UNIT_lang_vw WHERE FACILITY_ID = '"+facilityId+"' AND EFF_STATUS = 'E' AND PATIENT_CLASS = 'IP' and language_id='"+locale+"'  ORDER BY SHORT_DESC ";
				}
				/*Added by Ashwini on 27-Jun-2018 for ML-MMOH-CRF-0833*/
				else if(born_at.equals("O"))	
				{
					sql = " SELECT oper_room_code CLINIC_CODE, SHORT_DESC FROM ot_oper_room_lang_vw WHERE language_id = '"+locale+"' AND NVL (status, 'E') = 'E' AND operating_facility_id = '"+facilityId+"' ORDER BY SHORT_DESC ";
				}
				else if(born_at.equals("P"))	
				{
					sql = " SELECT CLINIC_CODE, long_desc SHORT_DESC FROM op_clinic_lang_vw a WHERE facility_id = '"+facilityId+"' AND language_id = '"+locale+"' AND eff_status = 'E' AND clinic_type = 'E' ORDER BY SHORT_DESC ";
				}
				else if(born_at.equals("W"))	
				{
					sql = " SELECT CLINIC_CODE, SHORT_DESC FROM rd_clinic_lang_vw WHERE language_id = '"+locale+"' AND NVL (status, 'E') = 'E' AND operating_facility_id = '"+facilityId+"' ORDER BY SHORT_DESC ";
				}
				else if(born_at.equals("R"))	
				{
					sql = " SELECT room_num CLINIC_CODE, SHORT_DESC FROM am_facility_room_lang_vw WHERE language_id = '"+locale+"' AND eff_status = 'E' AND operating_facility_id = '"+facilityId+"' AND room_type = 'R' ORDER BY SHORT_DESC ";
				}
				/*End ML-MMOH-CRF-0833*/

                
                if(pstmt != null)   pstmt.close();
				if(rset != null)   rset.close();
                pstmt = con.prepareStatement(sql); 				
                
                rset = pstmt.executeQuery();               
            
				String disp="";
				String hid="";%>
				
			<%  if(rset != null){
		
				while (rset.next())
				{
					hid	= rset.getString("CLINIC_CODE");
					disp	= rset.getString("SHORT_DESC");

				%>
					<script>
						var temp = "<%=hid%>";
						var temp1="<%=disp%>";
						
						var opt=parent.frames[1].frames[tempval].document.createElement("OPTION");
						opt.text=temp1;
						opt.value=temp;
						parent.frames[1].frames[tempval].document.forms[0].<%=ipatenatalfun%>.add(opt);
					</script>
		
				<%
                
					}
				}
			}
	}
            
    }catch(Exception e) { out.println(e.toString());}
    finally
    {
		if(rset2!=null) rset2.close();
		if(rset3!=null) rset3.close();
		if(rset4!=null) rset4.close();
        if(pstmt != null) pstmt.close();
		if(stmt3!=null) stmt3.close();
		if(stmt4!=null) stmt4.close();	
        if (rset != null) rset.close();
        if(con != null) ConnectionManager.returnConnection(con,request);
    }

%>
</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

