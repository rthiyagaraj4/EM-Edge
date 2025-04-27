<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.io.*,java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,javax.naming.*,javax.ejb.*,java.rmi.*,javax.rmi.*" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
 <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
 <Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
 <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
 <Script src="../../eMP/js/PatientSearch.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
//String logged_facility = (String) session.getValue("facility_id");

String from 			= request.getParameter("from") ; 
String to 				= request.getParameter("to") ;
//String qrywhereclause	= request.getParameter("whereclause") ;
String endOfRes="1";
int cnt=0;
int rowcnt=0;
Connection conn =null;
java.sql.Statement stmt = null;
PreparedStatement pstmt = null;
ResultSet rSet = null;
ResultSet rstmt = null;
String patient_id="";
//String patient_name="";
//String patient_name_local="";
String nat_id="";
String altId1_no="";
String altId2_no="";
String altId3_no="";
String altId4_no="";
String otherAltId_no="";
String res_no="";
String other_no="";
//String classValue="";
String curr_pat_class="";
//String single_pat_id="";
String other_alt_id_type_desc="";
String prn_label="";
String orn_label="";
ArrayList patIdList=new ArrayList();
ArrayList patDtlsList=new ArrayList();
HashMap patIdMap=new HashMap();
HashMap patDtlsMap=new HashMap();

String ACCEPT_NATIONAL_ID_NO_YN="";
String Nat_ID_Prompt="";
String alt_id1_desc="";
String alt_id2_desc="";
String alt_id3_desc="";
String alt_id4_desc="";
String accept_oth_alt_id_yn="";
String NAMES_IN_OTH_LANG_YN="";
String ACTIVE_YN="";
String SUSPEND_YN="";
String DECEASED_YN="";
String gender="";
String date_of_birth="";
String first_name="";
String second_name="";
String third_name="";
String family_name="";
String first_name_loc_lang="";
String second_name_loc_lang="";
String third_name_loc_lang="";
String family_name_loc_lang="";

String first_name_accept_yn="";
String second_name_accept_yn="";
String third_name_accept_yn="";
String family_name_accept_yn="";
String names_in_oth_lang_yn="";
String first_name_prompt="";
String first_name_loc_lang_prompt="";
String second_name_prompt="";
String second_name_loc_lang_prompt="";
String third_name_prompt="";
String third_name_loc_lang_prompt="";
String family_name_prompt="";
String family_name_loc_lang_prompt="";
boolean flag=true;

String pat_id1			= request.getParameter("pat_id1") ; 
String national_id_no1	= request.getParameter("national_id_no1") ; 
String alt_id1_no1		= request.getParameter("alt_id1_no1") ; 
String alt_id2_no1		= request.getParameter("alt_id2_no1") ; 
String alt_id3_no1		= request.getParameter("alt_id3_no1") ; 
String alt_id4_no1		= request.getParameter("alt_id4_no1") ; 
String pr_resNo1		= request.getParameter("pr_resNo1") ; 
String oth_no1			= request.getParameter("oth_no1") ; 
String search_in		= request.getParameter("search_in") ; 
String func_act			= request.getParameter("func_act") ; 
String function_id		= request.getParameter("function_id") ; 
String act_yn			= request.getParameter("act_yn") ; 
String gender1			= checkForNull(request.getParameter("gender")) ; 
String First_Name1			= checkForNull(request.getParameter("First_Name1")) ; 
String Second_Name1			= checkForNull(request.getParameter("Second_Name1")) ; 
String Third_Name1			= checkForNull(request.getParameter("Third_Name1")) ; 
String Family_Name1			= checkForNull(request.getParameter("Family_Name1")) ;
String first_name_loc_lang1			= request.getParameter("first_name_loc_lang1") ; 
String order_by1			= request.getParameter("order_by1") ; 
String orederByClause="";
if(order_by1.equals("P"))
orederByClause=" order by PATIENT_ID";


if(first_name_loc_lang1!=null)
	first_name_loc_lang1	= java.net.URLDecoder.decode(request.getParameter("first_name_loc_lang1"),"UTF-8");
String second_name_loc_lang1			= request.getParameter("second_name_loc_lang1"); 
if(second_name_loc_lang1!=null)
	second_name_loc_lang1	= java.net.URLDecoder.decode(request.getParameter("second_name_loc_lang1"),"UTF-8");
String third_name_loc_lang1			= request.getParameter("third_name_loc_lang1") ; 
if(third_name_loc_lang1!=null)
	third_name_loc_lang1	= java.net.URLDecoder.decode(request.getParameter("third_name_loc_lang1"),"UTF-8");
String family_name_loc_lang1			= request.getParameter("family_name_loc_lang1"); 
if(family_name_loc_lang1!=null)
	family_name_loc_lang1	= java.net.URLDecoder.decode(request.getParameter("family_name_loc_lang1"),"UTF-8");


StringBuffer sql=new StringBuffer("select PATIENT_ID,CURR_PATIENT_CLASS,NATIONAL_ID_NO,ALT_ID1_NO,ALT_ID2_NO,ALT_ID3_NO,ALT_ID4_NO,OTH_ALT_ID_NO,CONTACT1_NO,CONTACT2_NO,ACTIVE_YN,SUSPEND_YN,DECEASED_YN,SEX,to_char(DATE_OF_BIRTH,'dd/mm/yyyy')DATE_OF_BIRTH,(case when oth_alt_id_no is not null then (select long_desc from mp_alternate_id_type_lang_vw where alt_id_type = oth_alt_id_type and language_id = '"+locale+"') end) OTHER_ALT_ID_TYPE_DESC,FIRST_NAME,SECOND_NAME,THIRD_NAME,FAMILY_NAME,FIRST_NAME_LOC_LANG,SECOND_NAME_LOC_LANG,THIRD_NAME_LOC_LANG,FAMILY_NAME_LOC_LANG from mp_patient");
StringBuffer whereclause=new StringBuffer();


if(pat_id1!=null && ! pat_id1.equals(""))
	whereclause.append("patient_id like('"+pat_id1+"%')");
if(national_id_no1!=null && !national_id_no1.equals("")){
	if(!whereclause.toString().equals("")){
		whereclause.append(" and NATIONAL_ID_NO='"+national_id_no1+"'");
	}else{
		whereclause.append(" NATIONAL_ID_NO='"+national_id_no1+"'");
	}
}
if(alt_id1_no1!=null && !alt_id1_no1.equals("")){
	if(!whereclause.toString().equals("")){
		whereclause.append(" and ALT_ID1_NO='"+alt_id1_no1+"'");
	}else{
		whereclause.append(" ALT_ID1_NO='"+alt_id1_no1+"'");
	}
}
if(alt_id2_no1!=null && !alt_id2_no1.equals("")){
	if(!whereclause.toString().equals("")){
		whereclause.append(" and ALT_ID2_NO='"+alt_id2_no1+"'");
	}else{
		whereclause.append(" ALT_ID2_NO='"+alt_id2_no1+"'");
	}
}
if(alt_id3_no1!=null && !alt_id3_no1.equals("")){
	if(!whereclause.toString().equals("")){
		whereclause.append(" and ALT_ID3_NO='"+alt_id3_no1+"'");
	}else{
		whereclause.append(" ALT_ID3_NO='"+alt_id3_no1+"'");
	}
}
if(alt_id4_no1!=null && !alt_id4_no1.equals("")){
	if(!whereclause.toString().equals("")){
		whereclause.append(" and ALT_ID4_NO='"+alt_id4_no1+"'");
	}else{
		whereclause.append(" ALT_ID4_NO='"+alt_id4_no1+"'");
	}
}

if(First_Name1!=null && !First_Name1.equals("")){
	if(!whereclause.toString().equals("")){
		whereclause.append(" and upper(FIRST_NAME) like upper('"+First_Name1+"%')");
	}else{
		whereclause.append(" upper(FIRST_NAME) like upper('"+First_Name1+"%')");
	}
}
if(Second_Name1!=null && !Second_Name1.equals("")){
	if(!whereclause.toString().equals("")){
		whereclause.append(" and upper(SECOND_NAME) like upper('"+Second_Name1+"%')");
	}else{
		whereclause.append(" upper(SECOND_NAME) like upper('"+Second_Name1+"%')");
	}
}
if(Third_Name1!=null && !Third_Name1.equals("")){
	if(!whereclause.toString().equals("")){
		whereclause.append(" and upper(THIRD_NAME) like upper('"+Third_Name1+"%')");
	}else{
		whereclause.append(" upper(THIRD_NAME) like upper('"+Third_Name1+"%')");
	}
}
if(Family_Name1!=null && !Family_Name1.equals("")){
	if(!whereclause.toString().equals("")){
		whereclause.append(" and upper(FAMILY_NAME) like upper('"+Family_Name1+"%')");
	}else{
		whereclause.append(" upper(FAMILY_NAME) like upper('"+Family_Name1+"%')");
	}
}
if(first_name_loc_lang1!=null && !first_name_loc_lang1.equals("")){
	if(!whereclause.toString().equals("")){
		whereclause.append(" and upper(FIRST_NAME_LOC_LANG) like upper('"+first_name_loc_lang1+"%')");
	}else{
		whereclause.append(" upper(FIRST_NAME_LOC_LANG) like upper('"+first_name_loc_lang1+"%')");
	}
}
if(second_name_loc_lang1!=null && !second_name_loc_lang1.equals("")){
	if(!whereclause.toString().equals("")){
		whereclause.append(" and upper(SECOND_NAME_LOC_LANG) like upper('"+second_name_loc_lang1+"%')");
	}else{
		whereclause.append(" upper(SECOND_NAME_LOC_LANG) like upper('"+second_name_loc_lang1+"%')");
	}
}
if(third_name_loc_lang1!=null && !third_name_loc_lang1.equals("")){
	if(!whereclause.toString().equals("")){
		whereclause.append(" and upper(THIRD_NAME_LOC_LANG) like upper('"+third_name_loc_lang1+"%')");
	}else{
		whereclause.append(" upper(THIRD_NAME_LOC_LANG) like upper('"+third_name_loc_lang1+"%')");
	}
}
if(family_name_loc_lang1!=null && !family_name_loc_lang1.equals("")){
	if(!whereclause.toString().equals("")){
		whereclause.append(" and upper(FAMILY_NAME_LOC_LANG) like upper('"+family_name_loc_lang1+"%')");
	}else{
		whereclause.append(" upper(FAMILY_NAME_LOC_LANG) like upper('"+family_name_loc_lang1+"%')");
	}
}

if(pr_resNo1!=null && !pr_resNo1.equals("")){
	if(!whereclause.toString().equals("")){
		whereclause.append(" and CONTACT1_NO='"+pr_resNo1+"'");
	}else{
		whereclause.append(" CONTACT1_NO='"+pr_resNo1+"'");
	}
}
if(oth_no1!=null && !oth_no1.equals("")){
	if(!whereclause.toString().equals("")){
		whereclause.append(" and CONTACT2_NO='"+oth_no1+"'");
	}else{
		whereclause.append(" CONTACT2_NO='"+oth_no1+"'");
	}
}
StringBuffer sbr=new StringBuffer();

if(!(whereclause.toString().equals(""))){
	if(func_act!=null && func_act.equals("NEWBORN_REG")){
		//sbr.append(sql+" where "+whereclause+" and SEX='F' order by PATIENT_ID");
		sbr.append(sql+" where "+whereclause+" and SEX='"+gender1+"'"+orederByClause);
	}else{
		//sbr.append(sql+" where "+whereclause+" order by PATIENT_ID");
		sbr.append(sql+" where "+whereclause+orederByClause);
	}
}else{
	//sbr.append(sql+" order by PATIENT_ID");
	sbr.append(sql+orederByClause);
}
	int start = 0 ;
	int end = 0 ;
	int i=1;
	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 17 ;
	else
		end = Integer.parseInt( to ) ;

try{

	conn = ConnectionManager.getConnection(request);

	String sql1="Select param.ACCEPT_NATIONAL_ID_NO_YN,nvl(param.Nat_Id_Prompt, 'National ID No') Nat_ID_Prompt, param.Alt_Id1_type, alt_id1.long_desc alt_id1_desc, param.Alt_Id2_type,alt_id2.long_desc alt_id2_desc, param.Alt_Id3_type,alt_id3.long_desc alt_id3_desc,param.Alt_Id4_type,(alt_id4.long_desc) alt_id4_desc, param.accept_oth_alt_id_yn,NAMES_IN_OTH_LANG_YN,FIRST_NAME_ACCEPT_YN,SECOND_NAME_ACCEPT_YN,THIRD_NAME_ACCEPT_YN,FAMILY_NAME_ACCEPT_YN,NAMES_IN_OTH_LANG_YN,FIRST_NAME_PROMPT,FIRST_NAME_LOC_LANG_PROMPT,SECOND_NAME_PROMPT,SECOND_NAME_LOC_LANG_PROMPT,THIRD_NAME_PROMPT,THIRD_NAME_LOC_LANG_PROMPT,FAMILY_NAME_PROMPT,FAMILY_NAME_LOC_LANG_PROMPT from MP_PARAM_LANG_VW param,MP_ALTERNATE_ID_TYPE_LANG_VW alt_id1,MP_ALTERNATE_ID_TYPE_LANG_VW alt_id2,MP_ALTERNATE_ID_TYPE_LANG_VW alt_id3,MP_ALTERNATE_ID_TYPE_LANG_VW alt_id4 where param.module_id='MP' and param.language_id ='"+locale+"' and  param.language_id=alt_id1.language_id and param.language_id=alt_id2.language_id(+) and param.language_id=alt_id3.language_id(+) and param.language_id=alt_id4.language_id(+) and param.alt_id1_type=alt_id1.alt_id_type and param.alt_id2_type=alt_id2.alt_id_type(+) and param.alt_id3_type=alt_id3.alt_id_type(+) and param.alt_id4_type=alt_id4.alt_id_type(+)";

	pstmt = conn.prepareStatement(sql1);
	if(rstmt!=null)rstmt.close();
	rstmt = pstmt.executeQuery();
	while(rstmt!=null && rstmt.next()){
	ACCEPT_NATIONAL_ID_NO_YN=checkForNull(rstmt.getString("ACCEPT_NATIONAL_ID_NO_YN"));
	Nat_ID_Prompt=checkForNull(rstmt.getString("Nat_ID_Prompt"));
	alt_id1_desc=checkForNull(rstmt.getString("alt_id1_desc"));
	alt_id2_desc=checkForNull(rstmt.getString("alt_id2_desc"));
	alt_id3_desc=checkForNull(rstmt.getString("alt_id3_desc"));
	alt_id4_desc=checkForNull(rstmt.getString("alt_id4_desc"));
	accept_oth_alt_id_yn=checkForNull(rstmt.getString("accept_oth_alt_id_yn"));
	NAMES_IN_OTH_LANG_YN=checkForNull(rstmt.getString("NAMES_IN_OTH_LANG_YN"));
	first_name_accept_yn=checkForNull(rstmt.getString("FIRST_NAME_ACCEPT_YN"));
	second_name_accept_yn=checkForNull(rstmt.getString("SECOND_NAME_ACCEPT_YN"));
	third_name_accept_yn=checkForNull(rstmt.getString("THIRD_NAME_ACCEPT_YN"));
	family_name_accept_yn=checkForNull(rstmt.getString("FAMILY_NAME_ACCEPT_YN"));
	names_in_oth_lang_yn=checkForNull(rstmt.getString("NAMES_IN_OTH_LANG_YN"));
	first_name_prompt=checkForNull(rstmt.getString("FIRST_NAME_PROMPT"));
	first_name_loc_lang_prompt=checkForNull(rstmt.getString("FIRST_NAME_LOC_LANG_PROMPT"));
	second_name_prompt=checkForNull(rstmt.getString("SECOND_NAME_PROMPT"));
	second_name_loc_lang_prompt=checkForNull(rstmt.getString("SECOND_NAME_LOC_LANG_PROMPT"));
	third_name_prompt=checkForNull(rstmt.getString("THIRD_NAME_PROMPT"));
	third_name_loc_lang_prompt=checkForNull(rstmt.getString("THIRD_NAME_LOC_LANG_PROMPT"));
	family_name_prompt=checkForNull(rstmt.getString("FAMILY_NAME_PROMPT"));
	family_name_loc_lang_prompt=checkForNull(rstmt.getString("FAMILY_NAME_LOC_LANG_PROMPT"));
	}
	if(rstmt!=null)rstmt.close();
	pstmt = conn.prepareStatement("select contact_mode, short_desc from mp_contact_mode_lang_vw where contact_mode in ('PRN', 'ORN') and language_id = '"+locale+"'");
	try{
		rstmt = pstmt.executeQuery();
		String cnt_mode="";
		while(rstmt!=null && rstmt.next()){
			cnt_mode=rstmt.getString("contact_mode");
			if(cnt_mode.equals("PRN"))
				prn_label=rstmt.getString("short_desc");
			if(cnt_mode.equals("ORN"))
				orn_label=rstmt.getString("short_desc");
		}
	  }catch(Exception ex){		  
		  ex.printStackTrace();
	  }finally{
		  if (pstmt != null) pstmt.close();
		  if (rstmt != null) rstmt.close();
	  }
	stmt = conn.createStatement();
	rSet = stmt.executeQuery(sbr.toString());
	
	sbr.setLength(0);
	  if ( start != 1 ){
		  if(rSet!=null){
		 for( int j=1; j<start; i++,j++ )
		  {
			rSet.next() ;
		  }
		 }
	  }
	while(i<=end && rSet.next()){
	
		patient_id=rSet.getString("PATIENT_ID");
		patient_id=checkForNull(patient_id);
		curr_pat_class=rSet.getString("CURR_PATIENT_CLASS");
		curr_pat_class=checkForNull(curr_pat_class);
		nat_id=rSet.getString("NATIONAL_ID_NO");
		nat_id=checkForNull(nat_id);
		altId1_no=rSet.getString("ALT_ID1_NO");
		altId1_no=checkForNull(altId1_no);
		altId2_no=rSet.getString("ALT_ID2_NO");
		altId2_no=checkForNull(altId2_no);
		altId3_no=rSet.getString("ALT_ID3_NO");
		altId3_no=checkForNull(altId3_no);
		altId4_no=rSet.getString("ALT_ID4_NO");
		altId4_no=checkForNull(altId4_no);
		otherAltId_no=rSet.getString("OTH_ALT_ID_NO");
		otherAltId_no=checkForNull(otherAltId_no);
		res_no=rSet.getString("CONTACT1_NO");
		res_no=checkForNull(res_no);
		other_no=rSet.getString("CONTACT2_NO");
		other_no=checkForNull(other_no);
		ACTIVE_YN=rSet.getString("ACTIVE_YN");
		ACTIVE_YN=checkForNull(ACTIVE_YN);
		SUSPEND_YN=rSet.getString("SUSPEND_YN");
		SUSPEND_YN=checkForNull(SUSPEND_YN);
		DECEASED_YN=rSet.getString("DECEASED_YN");
		DECEASED_YN=checkForNull(DECEASED_YN);
		gender=rSet.getString("SEX");
		if(gender.equals("M")){
			gender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
		}else if(gender.equals("F")){
			gender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
		}else if(gender.equals("U")){
			gender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
		}
		date_of_birth=rSet.getString("DATE_OF_BIRTH");
		date_of_birth=DateUtils.convertDate(date_of_birth,"DMY","en",locale);
		other_alt_id_type_desc=rSet.getString("OTHER_ALT_ID_TYPE_DESC");
		other_alt_id_type_desc=checkForNull(other_alt_id_type_desc);
		first_name=rSet.getString("FIRST_NAME");
		first_name=checkForNull(first_name);
		second_name=rSet.getString("SECOND_NAME");
		second_name=checkForNull(second_name);
		third_name=rSet.getString("THIRD_NAME");
		third_name=checkForNull(third_name);
		family_name=rSet.getString("FAMILY_NAME");
		family_name=checkForNull(family_name);
		first_name_loc_lang=rSet.getString("FIRST_NAME_LOC_LANG");
		first_name_loc_lang=checkForNull(first_name_loc_lang);
		second_name_loc_lang=rSet.getString("SECOND_NAME_LOC_LANG");
		second_name_loc_lang=checkForNull(second_name_loc_lang);
		third_name_loc_lang=rSet.getString("THIRD_NAME_LOC_LANG");
		third_name_loc_lang=checkForNull(third_name_loc_lang);
		family_name_loc_lang=rSet.getString("FAMILY_NAME_LOC_LANG");
		family_name_loc_lang=checkForNull(family_name_loc_lang); 
		patIdMap=new HashMap();
		patDtlsMap=new HashMap();
		patIdMap.put("patient_id",patient_id);
		patIdMap.put("curr_pat_class",curr_pat_class);
		patIdMap.put("ACTIVE_YN",ACTIVE_YN);
		patIdMap.put("SUSPEND_YN",SUSPEND_YN);
		patIdMap.put("DECEASED_YN",DECEASED_YN);
		patDtlsMap.put("nat_id",nat_id);
		patDtlsMap.put("altId1_no",altId1_no);
		patDtlsMap.put("altId2_no",altId2_no);
		patDtlsMap.put("altId3_no",altId3_no);
		patDtlsMap.put("altId4_no",altId4_no);
		patDtlsMap.put("otherAltId_no",otherAltId_no);
		patDtlsMap.put("res_no",res_no);
		patDtlsMap.put("other_no",other_no);
		patDtlsMap.put("gender",gender);
		patDtlsMap.put("date_of_birth",date_of_birth);
		patDtlsMap.put("other_alt_id_type_desc",other_alt_id_type_desc);
		patDtlsMap.put("first_name",first_name);
		patDtlsMap.put("second_name",second_name);
		patDtlsMap.put("third_name",third_name);
		patDtlsMap.put("family_name",family_name);
		patDtlsMap.put("first_name_loc_lang",first_name_loc_lang);
		patDtlsMap.put("second_name_loc_lang",second_name_loc_lang);
		patDtlsMap.put("third_name_loc_lang",third_name_loc_lang);
		patDtlsMap.put("family_name_loc_lang",family_name_loc_lang);
		patIdList.add(patIdMap);
		patDtlsList.add(patDtlsMap);
		cnt++;
		i++;
}
%>
<form name='result_form' id='result_form' action = "../../eMP/jsp/PatientResultMain.jsp" >
<input type="hidden" name="search_in" id="search_in" value="<%=search_in%>">
<input type="hidden" name="func_act" id="func_act" value="<%=func_act%>">
<input type="hidden" name="function_id" id="function_id" value="<%=function_id%>">
<input type="hidden" name="act_yn" id="act_yn" value="<%=act_yn%>">
<%
	if(start==1 && cnt==1){
		Iterator idDisplayItrSingle;
		idDisplayItrSingle=patIdList.iterator();
		HashMap	 idDisplayMapSingle;
		idDisplayMapSingle=(HashMap)idDisplayItrSingle.next();
		String active_yn_lcl=(String)idDisplayMapSingle.get("ACTIVE_YN");
		String deceased_yn_lcl=(String)idDisplayMapSingle.get("DECEASED_YN");
		String suspend_yn_lcl=(String)idDisplayMapSingle.get("SUSPEND_YN");
		String pat_local=(String)idDisplayMapSingle.get("patient_id");
		if(act_yn.equals("Y")){
			if(function_id.equals("DR_UNMERGED_PATIENT_IDS")||((function_id.equals("") ||  function_id.equals("NEWBORN_REG"))&&search_in.equals("B"))){
			}else if ((function_id.equals("") ||  function_id.equals("NEWBORN_REG"))&&search_in.equals("D")){
			}else{
				if(func_act !=null && func_act.equals("RECD")){
					flag=false;
					out.println("<script>displayToolTip('"+pat_local+"')</script>");
				}else if(func_act !=null && func_act.equals("SUSP")){
					if(deceased_yn_lcl.equals("N") && active_yn_lcl.equals("Y")){
						flag=false;
						out.println("<script>displayToolTip('"+pat_local+"')</script>");
					}
				}else if(func_act.equals("ACTV")){
					if(deceased_yn_lcl.equals("N") && suspend_yn_lcl.equals("N")){
					}else{
						flag=false;
						out.println("<script>displayToolTip('"+pat_local+"')</script>");
					}
				}else{
					flag=false;
					out.println("<script>displayToolTip('"+pat_local+"')</script>");
				}
			}
		}else{
			if(!func_act.equals("VIEW")){
				if(deceased_yn_lcl.equals("Y") && func_act.equals("CHG_PAT_DTLS")){
					flag=false;
					out.println("<script>displayToolTip('"+pat_local+"')</script>");
				}else if(deceased_yn_lcl.equals("Y")){
				}else if(suspend_yn_lcl.equals("Y")){
				}else if(active_yn_lcl.equals("N")){
				}else if (function_id.equals("") ||  function_id.equals("NEWBORN_REG")){
					if(search_in.equals("B")){
					}else if (search_in.equals("D")){
					}else if(func_act.equals("Patreg") ||func_act.equals("RPDRG") || func_act.equals("EMERG")){
					}else{
						flag=false;
						out.println("<script>displayToolTip('"+pat_local+"')</script>");
					}
				}else{
					flag=false;
					out.println("<script>displayToolTip('"+pat_local+"')</script>");
				}
			}else{
				flag=false;
				out.println("<script>displayToolTip('"+pat_local+"')</script>");
			}
		}
	}


%>


<%if(cnt!=0){
	String classval="";
	Iterator idDisplayItr;
	Iterator dtlsDisplayItr;
	HashMap	 idDisplayMap;
	HashMap	 dtlsDisplayMap;
	String active_yn_lcl="";
	String deceased_yn_lcl="";
	String suspend_yn_lcl="";
	idDisplayItr=patIdList.iterator();
	dtlsDisplayItr=patDtlsList.iterator();
	out.println("<script>parent.parent.commontoolbar.location.href='../jsp/PatientSearchToolBar.jsp'</script>");
	if(flag){
	out.println("<Table border='1' width='100%' cellpadding='0'>");
	if(!(cnt==1 && start==1)){
	out.println("<TR><TD></TD>");
	out.println("<TD><table align='left'><tr><td>");
	if ( !(start <= 1) ){
		out.println("<A id='prevvalue' HREF='../../eMP/jsp/PatientQuickSearchResult.jsp?from="+(start-17)+"&to="+(end-17)+"&pat_id1="+pat_id1+"&national_id_no1="+national_id_no1+"&alt_id1_no1="+alt_id1_no1+"&alt_id2_no1="+alt_id2_no1+"&alt_id3_no1="+alt_id3_no1+"&alt_id4_no1="+alt_id4_no1+"&First_Name1="+First_Name1+"&Second_Name1="+Second_Name1+"&Third_Name1="+Third_Name1+"&Family_Name1="+Family_Name1+"&first_name_loc_lang1="+java.net.URLEncoder.encode(first_name_loc_lang1,"UTF-8")+"&second_name_loc_lang1="+java.net.URLEncoder.encode(second_name_loc_lang1,"UTF-8")+"&third_name_loc_lang1="+java.net.URLEncoder.encode(third_name_loc_lang1,"UTF-8")+"&family_name_loc_lang1="+java.net.URLEncoder.encode(family_name_loc_lang1,"UTF-8")+"&pr_resNo1="+pr_resNo1+"&oth_no1="+oth_no1+"&search_in="+search_in+"&func_act="+func_act+"&function_id="+function_id+"&order_by1="+order_by1+"&gender="+gender1+"&act_yn="+act_yn+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
	}
	if (endOfRes.equals("1")){
		out.println("<A id='nextvalue' HREF='../../eMP/jsp/PatientQuickSearchResult.jsp?from="+(start+17)+"&to="+(end+17)+"&pat_id1="+pat_id1+"&national_id_no1="+national_id_no1+"&alt_id1_no1="+alt_id1_no1+"&alt_id2_no1="+alt_id2_no1+"&alt_id3_no1="+alt_id3_no1+"&alt_id4_no1="+alt_id4_no1+"&First_Name1="+First_Name1+"&Second_Name1="+Second_Name1+"&Third_Name1="+Third_Name1+"&Family_Name1="+Family_Name1+"&first_name_loc_lang1="+java.net.URLEncoder.encode(first_name_loc_lang1,"UTF-8")+"&second_name_loc_lang1="+java.net.URLEncoder.encode(second_name_loc_lang1,"UTF-8")+"&third_name_loc_lang1="+java.net.URLEncoder.encode(third_name_loc_lang1,"UTF-8")+"&family_name_loc_lang1="+java.net.URLEncoder.encode(family_name_loc_lang1,"UTF-8")+"&pr_resNo1="+pr_resNo1+"&oth_no1="+oth_no1+"&search_in="+search_in+"&func_act="+func_act+"&function_id="+function_id+"&order_by1="+order_by1+"&gender="+gender1+"&act_yn="+act_yn+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
	}
	out.println("</td></tr></table></TD></TR>");
	}
	out.println("<tr><td class='WHITE'><div id='patId'>");
	out.println("<table border='1' width='100%' height='100%' cellspacing='0' cellpadding='0'>");
	out.println("<th nowrap><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")+"</b></th><th><b>S</b></th><th><b>PC</b></th>");
	while(idDisplayItr.hasNext()){
		if(rowcnt%2==0)
			classval="AR_QRYEVEN";
		else
			classval="AR_QRYODD";
		String s_lable="";
		idDisplayMap=(HashMap)idDisplayItr.next();
		active_yn_lcl=(String)idDisplayMap.get("ACTIVE_YN");
		deceased_yn_lcl=(String)idDisplayMap.get("DECEASED_YN");
		suspend_yn_lcl=(String)idDisplayMap.get("SUSPEND_YN");
		String pat_local=(String)idDisplayMap.get("patient_id");
		if(deceased_yn_lcl.equals("Y")){
			s_lable="DECEASED";
		}else if(suspend_yn_lcl.equals("Y")){
			s_lable="SUSPENDED";
		}else if(active_yn_lcl.equals("N")){
			s_lable="INACTIVE";
		}
		out.println("<TR>");
		if(act_yn.equals("Y")){
			if(function_id.equals("DR_UNMERGED_PATIENT_IDS")||((function_id.equals("") ||  function_id.equals("NEWBORN_REG"))&&search_in.equals("B"))){
			}else if ((function_id.equals("") ||  function_id.equals("NEWBORN_REG"))&&search_in.equals("D")){
				out.println("<TD nowrap class="+classval+">"+pat_local+"</TD>");
			}else {
				if(func_act !=null && func_act.equals("RECD")){
					out.println("<TD nowrap class="+classval+" onClick=displayToolTip('"+pat_local+"') onMouseOver='hideToolTip()'><a href=\"javascript:\">"+pat_local+"</a></TD>");
				}else if(func_act !=null && func_act.equals("SUSP")){
						if(deceased_yn_lcl.equals("N") && active_yn_lcl.equals("Y")){
							out.println("<TD nowrap class="+classval+" onClick=displayToolTip('"+pat_local+"') onMouseOver='hideToolTip()'><a href=\"javascript:\">"+pat_local+"</a></TD>");
					}else{
							out.println("<TD nowrap class="+classval+">"+pat_local+"</TD>");
					}
				}else if(func_act.equals("ACTV")){
							if(!(deceased_yn_lcl.equals("N") && suspend_yn_lcl.equals("N"))){
								out.println("<TD nowrap class="+classval+">"+pat_local+"</TD>");
							}else{
								out.println("<TD nowrap class="+classval+" onClick=displayToolTip('"+pat_local+"') onMouseOver='hideToolTip()'><a href=\"javascript:\">"+pat_local+"</a></TD>");
								}		
					}else{
						out.println("<TD nowrap class="+classval+" onClick=displayToolTip('"+pat_local+"') onMouseOver='hideToolTip()'><a href=\"javascript:\">"+pat_local+"</a></TD>");
					}
				}
		}else{
			if(!func_act.equals("VIEW")){
				if(deceased_yn_lcl.equals("Y") && func_act.equals("CHG_PAT_DTLS")){
					out.println("<TD nowrap class="+classval+" onClick=displayToolTip('"+pat_local+"') onMouseOver='hideToolTip()'><a href=\"javascript:\">"+pat_local+"</a></TD>");
				}else if(deceased_yn_lcl.equals("Y")){
					out.println("<TD nowrap class="+classval+">"+pat_local+"</TD>");
				}else if(suspend_yn_lcl.equals("Y")){
					out.println("<TD nowrap class="+classval+">"+pat_local+"</TD>");
				}else if(active_yn_lcl.equals("N")){
					out.println("<TD nowrap class="+classval+">"+pat_local+"</TD>");
				}else if (function_id.equals("") ||  function_id.equals("NEWBORN_REG")){
					//have to check with lines 410 to 432
					if(search_in.equals("B")){
					}else if (search_in.equals("D")){
						out.println("<TD nowrap class="+classval+">"+pat_local+"</TD>");
					}else if(func_act.equals("Patreg") ||func_act.equals("RPDRG") || func_act.equals("EMERG")){
						out.println("<TD nowrap class="+classval+">"+pat_local+"</TD>");
					}else{
						out.println("<TD nowrap class="+classval+" onClick=displayToolTip('"+pat_local+"') onMouseOver='hideToolTip()'><a href=\"javascript:\">"+pat_local+"</a></TD>");
					}
				}else{
					out.println("<TD nowrap class="+classval+" onClick=displayToolTip('"+pat_local+"') onMouseOver='hideToolTip()'><a href=\"javascript:\">"+pat_local+"</a></TD>");
				}
			}else{
				out.println("<TD nowrap class="+classval+" onClick=displayToolTip('"+pat_local+"') onMouseOver='hideToolTip()'><a href=\"javascript:\">"+pat_local+"</a></TD>");
			}
		}
		if(s_lable.equals("")){
				out.println("<TD nowrap class="+classval+">&nbsp;</TD>");
			}else{
				out.println("<TD nowrap class="+s_lable+"></TD>");
		}
		if(idDisplayMap.get("curr_pat_class").toString().equals("")){
				out.println("<TD nowrap class="+classval+">&nbsp;</TD>");
			}else{
				out.println("<TD nowrap class="+classval+">"+idDisplayMap.get("curr_pat_class")+"</TD>");
		}
		out.println("</TR>");
		rowcnt++;
	}
	out.println("<TR><TD></TD><TD></TD><TD></TD></TR></table>");
	out.println("</div></td><td class='WHITE'><div id='patDtl' style='width:890;height:342;overflow-y:no;overflow-x: auto'>");
	out.println("<table border='1' width='100%' cellspacing='0' cellpadding='0'>");
	out.println("<th nowrap ><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Sex.label","common_labels")+"</b></th>");
	out.println("<th nowrap ><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DateofBirth.label","common_labels")+"</b></th>");
	if(first_name_accept_yn.equals("Y")){
		if(!first_name_prompt.equals("")){
			out.println("<th nowrap ><b>"+first_name_prompt+"</b></th>");
		}else{
			out.println("<th nowrap ><b>First Name</b></th>");
		}
	}
	if(second_name_accept_yn.equals("Y")){
		if(!second_name_prompt.equals("")){
			out.println("<th nowrap ><b>"+second_name_prompt+"</b></th>");
		}else{
			out.println("<th nowrap ><b>Second Name</b></th>");
		}
	}
	if(third_name_accept_yn.equals("Y")){
		if(!third_name_prompt.equals("")){
			out.println("<th nowrap ><b>"+third_name_prompt+"</b></th>");
		}else{
			out.println("<th nowrap ><b>Third Name</b></th>");
		}
	}
	if(family_name_accept_yn.equals("Y")){
		if(!family_name_prompt.equals("")){
			out.println("<th nowrap ><b>"+family_name_prompt+"</b></th>");
		}else{
			out.println("<th nowrap ><b>Family Name</b></th>");
		}
	}
	if(names_in_oth_lang_yn.equals("Y")){
		if(first_name_accept_yn.equals("Y")){
			if(!first_name_loc_lang_prompt.equals("")){
				out.println("<th nowrap ><b>"+first_name_loc_lang_prompt+"</b></th>");
			}else{
				out.println("<th nowrap ><b>First Name Loc Lang</b></th>");
			}
		}
		if(second_name_accept_yn.equals("Y")){
			if(!second_name_loc_lang_prompt.equals("")){
				out.println("<th nowrap ><b>"+second_name_loc_lang_prompt+"</b></th>");
			}else{
				out.println("<th nowrap ><b>Second Name Loc Lang</b></th>");
			}
		}
		if(third_name_accept_yn.equals("Y")){
			if(!third_name_loc_lang_prompt.equals("")){
				out.println("<th nowrap ><b>"+third_name_loc_lang_prompt+"</b></th>");
			}else{
				out.println("<th nowrap ><b>Third Name Loc Lang</b></th>");
			}
		}
		if(family_name_accept_yn.equals("Y")){
			if(!family_name_loc_lang_prompt.equals("")){
				out.println("<th nowrap ><b>"+family_name_loc_lang_prompt+"</b></th>");
			}else{
				out.println("<th nowrap ><b>Family Name Loc Lang</b></th>");
			}
		}
	}
	if(ACCEPT_NATIONAL_ID_NO_YN.equals("Y")){
	out.println("<th nowrap ><b>"+Nat_ID_Prompt+"</b></th>");
	}
	if(!alt_id1_desc.equals("")){
	out.println("<th nowrap ><b>"+alt_id1_desc+"</b></th>");
	}
	if(!alt_id2_desc.equals("")){
	out.println("<th nowrap ><b>"+alt_id2_desc+"</b></th>");
	}
	if(!alt_id3_desc.equals("")){
	out.println("<th nowrap ><b>"+alt_id3_desc+"</b></th>");
	}
	if(!alt_id4_desc.equals("")){
	out.println("<th nowrap ><b>"+alt_id4_desc+"</b></th>");
	}
	if(accept_oth_alt_id_yn.equals("Y")){
	out.println("<th nowrap ><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OtherAltType.label","common_labels")+"</b></th>");
	out.println("<th nowrap ><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.OtherAltNo.label","mp_labels")+"</b></th>");
	}
	out.println("<th nowrap ><b>"+prn_label+"</b></th>");
	out.println("<th nowrap ><b>"+orn_label+"</b></th>");

	rowcnt=0;
	while(dtlsDisplayItr.hasNext()){
		if(rowcnt%2==0)
			classval="AR_QRYEVEN";
		else
			classval="AR_QRYODD";
		dtlsDisplayMap=(HashMap)dtlsDisplayItr.next();
		out.println("<TR>");
		out.println("<TD nowrap class="+classval+">"+dtlsDisplayMap.get("gender")+"</TD>");
		out.println("<TD nowrap class="+classval+">"+dtlsDisplayMap.get("date_of_birth")+"</TD>");
		if(first_name_accept_yn.equals("Y")){
			if(dtlsDisplayMap.get("first_name").toString().equals("")){
				out.println("<TD nowrap class="+classval+">&nbsp;</TD>");
			}else{
				out.println("<TD nowrap class="+classval+">"+dtlsDisplayMap.get("first_name")+"</TD>");
			}
		}
		if(second_name_accept_yn.equals("Y")){
			if(dtlsDisplayMap.get("second_name").toString().equals("")){
				out.println("<TD nowrap class="+classval+">&nbsp;</TD>");
			}else{
				out.println("<TD nowrap class="+classval+">"+dtlsDisplayMap.get("second_name")+"</TD>");
			}
		}
		if(third_name_accept_yn.equals("Y")){
			if(dtlsDisplayMap.get("third_name").toString().equals("")){
				out.println("<TD nowrap class="+classval+">&nbsp;</TD>");
			}else{
				out.println("<TD nowrap class="+classval+">"+dtlsDisplayMap.get("third_name")+"</TD>");
			}
		}
		if(family_name_accept_yn.equals("Y")){
			if(dtlsDisplayMap.get("family_name").toString().equals("")){
				out.println("<TD nowrap class="+classval+">&nbsp;</TD>");
			}else{
				out.println("<TD nowrap class="+classval+">"+dtlsDisplayMap.get("family_name")+"</TD>");
			}
		}
		if(names_in_oth_lang_yn.equals("Y")){
			if(first_name_accept_yn.equals("Y")){
				if(dtlsDisplayMap.get("first_name_loc_lang").toString().equals("")){
					out.println("<TD nowrap class="+classval+">&nbsp;</TD>");
				}else{
					out.println("<TD nowrap class="+classval+">"+dtlsDisplayMap.get("first_name_loc_lang")+"</TD>");
				}
			}
			if(second_name_accept_yn.equals("Y")){
				if(dtlsDisplayMap.get("second_name_loc_lang").toString().equals("")){
					out.println("<TD nowrap class="+classval+">&nbsp;</TD>");
				}else{
					out.println("<TD nowrap class="+classval+">"+dtlsDisplayMap.get("second_name_loc_lang")+"</TD>");
				}
			}
			if(third_name_accept_yn.equals("Y")){
				if(dtlsDisplayMap.get("third_name_loc_lang").toString().equals("")){
					out.println("<TD nowrap class="+classval+">&nbsp;</TD>");
				}else{
					out.println("<TD nowrap class="+classval+">"+dtlsDisplayMap.get("third_name_loc_lang")+"</TD>");
				}
			}
			if(family_name_accept_yn.equals("Y")){
				if(dtlsDisplayMap.get("family_name_loc_lang").toString().equals("")){
					out.println("<TD nowrap class="+classval+">&nbsp;</TD>");
				}else{
					out.println("<TD nowrap class="+classval+">"+dtlsDisplayMap.get("family_name_loc_lang")+"</TD>");
				}
			}
		}
		if(ACCEPT_NATIONAL_ID_NO_YN.equals("Y")){
			if(dtlsDisplayMap.get("nat_id").toString().equals("")){
				out.println("<TD nowrap class="+classval+">&nbsp;</TD>");
			}else{
				out.println("<TD nowrap class="+classval+">"+dtlsDisplayMap.get("nat_id")+"</TD>");
			}
		}
		if(!alt_id1_desc.equals("")){
			if(dtlsDisplayMap.get("altId1_no").toString().equals("")){
				out.println("<TD nowrap class="+classval+">&nbsp;</TD>");
			}else{
				out.println("<TD nowrap class="+classval+">"+dtlsDisplayMap.get("altId1_no")+"</TD>");
			}
		}
		if(!alt_id2_desc.equals("")){
			if(dtlsDisplayMap.get("altId2_no").toString().equals("")){
				out.println("<TD nowrap class="+classval+">&nbsp;</TD>");
			}else{
				out.println("<TD nowrap class="+classval+">"+dtlsDisplayMap.get("altId2_no")+"</TD>");
			}
		}
		if(!alt_id3_desc.equals("")){
			if(dtlsDisplayMap.get("altId3_no").toString().equals("")){
				out.println("<TD nowrap class="+classval+">&nbsp;</TD>");
			}else{
				out.println("<TD nowrap class="+classval+">"+dtlsDisplayMap.get("altId3_no")+"</TD>");
			}
		}
		if(!alt_id4_desc.equals("")){
			if(dtlsDisplayMap.get("altId4_no").toString().equals("")){
				out.println("<TD nowrap class="+classval+">&nbsp;</TD>");
			}else{
				out.println("<TD nowrap class="+classval+">"+dtlsDisplayMap.get("altId4_no")+"</TD>");
			}
		}
		if(accept_oth_alt_id_yn.equals("Y")){
			if(dtlsDisplayMap.get("other_alt_id_type_desc").toString().equals("")){
				out.println("<TD nowrap class="+classval+">&nbsp;</TD>");
			}else{
				out.println("<TD nowrap class="+classval+">"+dtlsDisplayMap.get("other_alt_id_type_desc")+"</TD>");
			}
			if(dtlsDisplayMap.get("otherAltId_no").toString().equals("")){
				out.println("<TD nowrap class="+classval+">&nbsp;</TD>");
			}else{
				out.println("<TD nowrap class="+classval+">"+dtlsDisplayMap.get("otherAltId_no")+"</TD>");
			}
		}
		if(dtlsDisplayMap.get("res_no").toString().equals("")){
				out.println("<TD nowrap class="+classval+">&nbsp;</TD>");
			}else{
				out.println("<TD nowrap class="+classval+">"+dtlsDisplayMap.get("res_no")+"</TD>");
		}
		if(dtlsDisplayMap.get("other_no").toString().equals("")){
				out.println("<TD nowrap class="+classval+">&nbsp;</TD>");
			}else{
				out.println("<TD nowrap class="+classval+">"+dtlsDisplayMap.get("other_no")+"</TD>");
		}
		out.println("</TR>");
		rowcnt++;
	}
	out.println("</table>");
	out.println("</div></td></tr></Table>");
	out.println("<CENTER>");
    out.println("<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:20%; visibility:hidden;' bgcolor='red'><table id='tooltiptable' cellpadding=0 cellspacing=0 border='0' width='auto' height='100%' align='center'><tr><td width='100%' id='t'></td></tr></table></div>");
	%>
	<script>
		if(parent.parent.criteria.Patient_Search_Form.register_button_yn.value=='Y' && parent.parent.criteria.Patient_Search_Form.func_act.value=='AEreg'){
			parent.parent.search_toolbar.search_toolbar.register.disabled = false;
			parent.parent.search_toolbar.search_toolbar.register1.disabled = false;
	}else{
		if(parent.parent.criteria.Patient_Search_Form.register_button_yn.value=='Y' && ((parent.parent.criteria.Patient_Search_Form.func_act.value=='Visitreg') ||(parent.parent.criteria.Patient_Search_Form.func_act.value=='DuplicateRegistration')||(parent.parent.criteria.Patient_Search_Form.func_act.value=='AdmitPatient')||(parent.parent.criteria.Patient_Search_Form.func_act.value=='ProcdReg'))) {
			parent.parent.search_toolbar.search_toolbar.register.disabled = false;
		}else if(parent.parent.criteria.Patient_Search_Form.register_button_yn.value=='Y'){
			parent.parent.search_toolbar.search_toolbar.register.disabled = false;
		}else if(parent.parent.criteria.Patient_Search_Form.register_button_yn.value=='R'){
			parent.parent.search_toolbar.search_toolbar.register.disabled = false;
		}
	}
	</script>
	<%
	//out.println("<script>parent.parent.commontoolbar.location.href='../jsp/PatientSearchToolBar.jsp'</script>");
}
}else{
	out.println("<script>parent.parent.commontoolbar.location.href='../jsp/PatientSearchToolBar.jsp'</script>");
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");%>
	<script>
		if(parent.parent.criteria.Patient_Search_Form.register_button_yn.value=='Y' && parent.parent.criteria.Patient_Search_Form.func_act.value=='AEreg'){
			parent.parent.search_toolbar.search_toolbar.register.disabled = false;
			parent.parent.search_toolbar.search_toolbar.register1.disabled = false;
	}else{
		if(parent.parent.criteria.Patient_Search_Form.register_button_yn.value=='Y' && ((parent.parent.criteria.Patient_Search_Form.func_act.value=='Visitreg') ||(parent.parent.criteria.Patient_Search_Form.func_act.value=='DuplicateRegistration')||(parent.parent.criteria.Patient_Search_Form.func_act.value=='AdmitPatient')||(parent.parent.criteria.Patient_Search_Form.func_act.value=='ProcdReg'))) {
			parent.parent.search_toolbar.search_toolbar.register.disabled = false;
		}else if(parent.parent.criteria.Patient_Search_Form.register_button_yn.value=='Y'){
			parent.parent.search_toolbar.search_toolbar.register.disabled = false;
		}else if(parent.parent.criteria.Patient_Search_Form.register_button_yn.value=='R'){
			parent.parent.search_toolbar.search_toolbar.register.disabled = false;
		}
	}
	</script>
<%}
 if(!rSet.next() && cnt!=0 && !(cnt==1 && start==1)){
	endOfRes="0";%>
	<script>
		document.getElementById('nextvalue').innerHTML=" ";
	</script>
	<%}
}catch(Exception e){
	e.printStackTrace();	
}finally{
if(conn!=null)ConnectionManager.returnConnection(conn,request);
}
%>
</center>
</form>
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

