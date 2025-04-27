<!DOCTYPE html>
<!-- Last Modified Date Time :9/23/2005 11:34 AM -->
<%@ page contentType="text/html;charset=UTF-8"  import="java.io.*, java.sql.*,java.util.*, java.net.*, java.text.*, webbeans.eCommon.*, javax.naming.*,javax.ejb.*, java.rmi.*,javax.rmi.*,com.ehis.util.*" %>	
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% 
	request.setCharacterEncoding("UTF-8");
	%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
String locale =((String)session.getAttribute("LOCALE"));%>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script>
	function callDummy(){}
	function openReg(obj)
	{
		parent.window.returnValue =obj;
		retval=parent.window.close();
		return obj;
	}
	</script>
</head>

<%	
	Connection conn = null; 
	ResultSet rs = null;
//	ResultSet rs1 = null;
	java.sql.Statement stmt=null;
	java.sql.Statement stmt1=null;
	// added by N Munisekhar on 13-Mar-2013 against ML-BRU-SCF-0749 [IN:038571] 
	PreparedStatement pstmt = null;
	String valid_patient_id="";
	StringBuffer whereClause= new StringBuffer("where");
	String whereClauseOld="";
	
	int TotalRecord = 0;
	String PID="";
	int start;
	int end;
	int tableSize=20;
	StringBuffer sql=new StringBuffer();;
//	String sql1 ="";
    String finalized_yn = "";
	String regnStatusStyle = "";
	String addlTableClause = "";
	String addlWhereClause = "";
	String addlTableClauseFath = "";
	String addlWhereClauseFath = "";
	int WhereClauseflag = 0;

	String from = request.getParameter("from");
	String view= request.getParameter("view");
	if(view == null) view ="";

	String to = request.getParameter("to");
    String PatientID= request.getParameter("Patient_Id");

    String MotherPatientID= request.getParameter("Mother_Patient_Id");
   // added code for PMG2014-HSA-CRF-0001 [IN:050020]	
	String AltId1No=request.getParameter("Alt_Id1_No");
	String AltId2No=request.getParameter("Alt_Id2_No");
	String AltId3No=request.getParameter("Alt_Id3_No");
	String AltId4No=request.getParameter("Alt_Id4_No");
	String other_alt_id=request.getParameter("other_alt_id");
	String other_alt_Id_no=request.getParameter("other_alt_Id_no");
	String nat_id_prompt=request.getParameter("nat_id_prompt");
	

	String Dob= request.getParameter("Dob");
	if(Dob != null)
	{
		if(locale.equals("th"))
		Dob=DateUtils.convertDate(Dob,"DMY","th","en");
	}
	else
	Dob="";
	String AltID1Order= request.getParameter("Alt_Id1_Order");
	String Sex= request.getParameter("Sex");
	//String altIDType= request.getParameter("altIDType");
	//added code for PMG2014-HSA-CRF-0001 [IN:050020]
	String alt_id1_type_deschd= request.getParameter("alt_id1_type_deschd");
	String alt_id2_type_deschd= request.getParameter("alt_id2_type_deschd");
	String alt_id3_type_deschd= request.getParameter("alt_id3_type_deschd");
	String alt_id4_type_deschd= request.getParameter("alt_id4_type_deschd");
	String nat_id_prompt_des= request.getParameter("nat_id_prompt_des");
	
	String DobTo= request.getParameter("DobTo");
	if(DobTo != null)
	{
		if(locale.equals("th"))
		DobTo=DateUtils.convertDate(DobTo,"DMY","th","en");
	}
	else
	DobTo="";
	//Added for Maintain birth Register and verification on 27/8/2002 by kumar
	String function_id = request.getParameter("function_id");
	if (function_id==null) function_id = "";
	// End of addition
	//Added for Names Search on 22/11/2002 by kumar
	String first_name = request.getParameter("first_name");	
	String second_name = request.getParameter("second_name");
	String third_name = request.getParameter("third_name");
	String family_name = request.getParameter("family_name");
	String fourth_name = request.getParameter("fourth_name");
	String fifth_name = request.getParameter("fifth_name");
	if (first_name==null) first_name="";
	if (second_name==null) second_name="";
	if (third_name==null) third_name="";
	if (family_name==null) family_name="";
	if (fourth_name==null) fourth_name="";
	if (fifth_name==null) fifth_name="";

	//Added by kumar on 17/03/2003 for Malaysia Enhancements
	String pat_name_as_multipart_yn = request.getParameter("pat_name_as_multipart_yn");
	if (pat_name_as_multipart_yn==null) pat_name_as_multipart_yn = "";
	String searchby = request.getParameter("searchby");		
	if (searchby==null) searchby = "";
	//End of Addition
	

	String soundex = request.getParameter("soundex");
	if (soundex==null) soundex="";

	String apply_oth_name = request.getParameter("apply_oth_name");
	if (apply_oth_name==null) apply_oth_name="N";
	String names_search_by = request.getParameter("names_search_by");
	if (names_search_by==null) names_search_by = "";


	////////////////////////////
	boolean fath_flag=false;
	if(names_search_by.equals("F"))
	{
		fath_flag=true;
		soundex="";
	}
	////////////////////////////


	InputStreamReader reader;
	String regn_type1 = request.getParameter("regn_type1");
	if (regn_type1==null) regn_type1="";
	String regn_type2 = request.getParameter("regn_type2");
	if (regn_type2==null) regn_type2="";
	
	reader = new InputStreamReader( new ByteArrayInputStream( regn_type1.getBytes()), "UTF-8" ) ;
	regn_type1 = (new BufferedReader(reader)).readLine() ;
	if (regn_type1==null) regn_type1 = "";
	reader = new InputStreamReader( new ByteArrayInputStream( regn_type2.getBytes()), "UTF-8" ) ;
	regn_type2 = (new BufferedReader(reader)).readLine() ;
	if (regn_type2==null) regn_type2 = "";

	/*if (apply_oth_name.equals("Y"))
	{
		reader = new InputStreamReader( new ByteArrayInputStream( first_name.getBytes()), "UTF-8" ) ;
		first_name = (new BufferedReader(reader)).readLine() ;
		if (first_name==null) first_name = "";
		reader = new InputStreamReader( new ByteArrayInputStream( second_name.getBytes()), "UTF-8" ) ;
		second_name = (new BufferedReader(reader)).readLine() ;
		if (second_name==null) second_name = "";
		reader = new InputStreamReader( new ByteArrayInputStream( third_name.getBytes()), "UTF-8" ) ;
		third_name = (new BufferedReader(reader)).readLine() ;
		if (third_name==null) third_name = "";
		reader = new InputStreamReader( new ByteArrayInputStream( family_name.getBytes()), "UTF-8" ) ;
		family_name = (new BufferedReader(reader)).readLine() ;
		if (family_name==null) family_name = "";
		reader = new InputStreamReader( new ByteArrayInputStream( fourth_name.getBytes()), "UTF-8" ) ;
		fourth_name = (new BufferedReader(reader)).readLine() ;
		if (fourth_name==null) fourth_name = "";
		reader = new InputStreamReader( new ByteArrayInputStream( fifth_name.getBytes()), "UTF-8" ) ;
		fifth_name = (new BufferedReader(reader)).readLine() ;
		if (fifth_name==null) fifth_name = "";
	}*/
	// End of addition
	//out.println("<script>alert('"+request.getParameter("first_name")+"');</script>");
	//out.println("<script>alert('apply_oth_name:"+apply_oth_name+"');</script>");
                
	whereClauseOld = request.getParameter("whereClauseOld");
	
    int strand =0; 


	if((PatientID != null) && !(PatientID.equals("")))
	{
		whereClause.append(" a.Patient_id like trim('");
		whereClause.append(PatientID);
		whereClause.append("%')");
		strand++;
	}

	if((MotherPatientID != null)  && !(MotherPatientID.equals("")))
	{
		if(strand > 0){
			whereClause.append(" And ");
		
		}
		strand++;
		whereClause.append(" A.Mother_Patient_id like trim('");
		whereClause.append(MotherPatientID);
		whereClause.append("%')");

	}

	if((AltId1No != null) && (!(AltId1No.equals("undefined"))) && (!(AltId1No.equals(""))))
	{
		if(strand > 0){

			whereClause.append(" And ");
		}
		strand++;
		whereClause.append(" b.Alt_id1_no like trim('" );
		whereClause.append(AltId1No);
		whereClause.append("%') ");
	}
	//added code for PMG2014-HSA-CRF-0001 [IN:050020]
	if((AltId2No != null) && (!(AltId2No.equals("undefined"))) && (!(AltId2No.equals(""))))
	{
		if(strand > 0){

			whereClause.append(" And ");
		}
		strand++;
		whereClause.append(" b.Alt_id2_no like trim('" );
		whereClause.append(AltId2No);
		whereClause.append("%') ");
	}
	if((AltId3No != null) && (!(AltId3No.equals("undefined"))) && (!(AltId3No.equals(""))))
	{
		if(strand > 0){

			whereClause.append(" And ");
		}
		strand++;
		whereClause.append(" b.Alt_id3_no like trim('" );
		whereClause.append(AltId3No);
		whereClause.append("%') ");
	}
	if((AltId4No != null) && (!(AltId4No.equals("undefined"))) && (!(AltId4No.equals(""))))
	{
		if(strand > 0){

			whereClause.append(" And ");
		}
		strand++;
		whereClause.append(" b.Alt_id4_no like trim('" );
		whereClause.append(AltId4No);
		whereClause.append("%') ");
	}
	if((other_alt_id != null) && (!(other_alt_id.equals("undefined"))) && (!(other_alt_id.equals(""))))
	{
		if(strand > 0){

			whereClause.append(" And ");
		}
		strand++;
		whereClause.append(" b.oth_alt_id_type like trim('" );
		whereClause.append(other_alt_id);
		whereClause.append("%') ");
	}
	
	if((other_alt_Id_no != null) && (!(other_alt_Id_no.equals("undefined"))) && (!(other_alt_Id_no.equals(""))))
	{
		if(strand > 0){

			whereClause.append(" And ");
		}
		strand++;
		whereClause.append("  b.oth_alt_Id_no like trim('" );
		whereClause.append(other_alt_Id_no);
		whereClause.append("%') ");
	}
	
	
	if((nat_id_prompt != null) && (!(nat_id_prompt.equals("undefined")))  && (!(nat_id_prompt.equals(""))))
	{
		if(strand > 0){

			whereClause.append(" And ");
		}
		strand++;
		whereClause.append(" b.NATIONAL_ID_NO like trim('" );
		whereClause.append(nat_id_prompt);
		whereClause.append("%') ");
	}

	if ((AltID1Order != null)  && (!(AltID1Order.equals(""))))
	{
		if(strand > 0){
			whereClause.append(" And ");
	
		}
		strand++;
		whereClause.append(" birth_order = '");
		whereClause.append(AltID1Order);
		whereClause.append("'");
	}

	if ((Dob != null) && (!(Dob.equals(""))) && ((DobTo == null) || (DobTo.equals(""))))
	{
		if(strand > 0){
			whereClause.append(" And ");

		}
		strand++;
		whereClause.append(" to_date(to_char(time_of_birth,'dd/mm/yyyy'),'dd/mm/yyyy') >= to_date('");
		whereClause.append(Dob);
		whereClause.append("','dd/mm/yyyy')");
	}

	if ((Dob != null) && (!(Dob.equals(""))) && (DobTo != null) && !(DobTo.equals("")))
	{
		if(strand > 0){
			whereClause.append(" And ");
		}
		strand++;
		whereClause.append(" to_date(to_char(time_of_birth,'dd/mm/yyyy'),'dd/mm/yyyy') between to_date('");
		whereClause.append(Dob);
		whereClause.append("','dd/mm/yyyy') and ");
		whereClause.append(" to_date('");
		whereClause.append(DobTo);
		whereClause.append("','dd/mm/yyyy')");

	}

	if ((Sex != null)  && (!(Sex.equals(""))))
	{
		if(strand > 0){
			whereClause.append(" And ");

		}
		strand++;
		whereClause.append(" a.NB_Sex like trim('");
		whereClause.append(Sex);
		whereClause.append("')");
	}
	
	
	StringBuffer namesWhereClause = new StringBuffer();
	
	String aliasName ="";
	
	if (names_search_by.equals("B")) aliasName = "b.";
	else if (names_search_by.equals("M")) aliasName = "moth.";
	else if (names_search_by.equals("F")) aliasName = "fath.";
	String andClause = " And ";
	if (function_id.equals("")|| function_id.equals("MP_VIEW_BIRTH_REG"))
	{
		if (apply_oth_name.equals("N"))
		{
			if (soundex.equals("E"))
			{
				if (!first_name.equals("") && !family_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(aliasName);
					namesWhereClause.append("ethnic_sndx_first_family=ethnic_soundex('");
					namesWhereClause.append(first_name);
					namesWhereClause.append(family_name);
					namesWhereClause.append("')");
				}
				if (!first_name.equals("") && !second_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(aliasName);
					namesWhereClause.append("ethnic_sndx_first_second=ethnic_soundex('");
					namesWhereClause.append(first_name);
					namesWhereClause.append(second_name);
					namesWhereClause.append("')");

				}
				if (!first_name.equals(""))
				{
					if (family_name.equals("") && second_name.equals("")){
						namesWhereClause.append(andClause);
						namesWhereClause.append(aliasName);
						namesWhereClause.append("ethnic_sndx_first =ethnic_soundex('");
						namesWhereClause.append(first_name);
						namesWhereClause.append("')");

					}
				}
				if (!second_name.equals(""))
				{
					if (first_name.equals("")){
						namesWhereClause.append(andClause);
						namesWhereClause.append(aliasName);
						namesWhereClause.append("ethnic_sndx_second =ethnic_soundex('");
						namesWhereClause.append(second_name);
						namesWhereClause.append("')");

					}
				}
				if (!third_name.equals(""))
				{
					namesWhereClause.append(andClause);
					namesWhereClause.append(aliasName);
					namesWhereClause.append("ethnic_sndx_third =ethnic_soundex('");
					namesWhereClause.append(third_name );
					namesWhereClause.append("')");

				}
				if (!family_name.equals(""))
				{
					if (first_name.equals("")){
						namesWhereClause.append(andClause);
						namesWhereClause.append(aliasName);		
						namesWhereClause.append("ethnic_sndx_second =ethnic_soundex('");
						namesWhereClause.append(family_name);
						namesWhereClause.append("')");

					}
				}
			}
			else if (soundex.equals("G"))
			{
				if (!first_name.equals("") && !family_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(aliasName);
					namesWhereClause.append("generic_sndx_first_family=soundex('");
					namesWhereClause.append(first_name );
					namesWhereClause.append(family_name);
					namesWhereClause.append("')");

				}
				if (!first_name.equals("") && !second_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(aliasName);
					namesWhereClause.append("generic_sndx_first_second=soundex('");
					namesWhereClause.append(first_name);
					namesWhereClause.append(second_name);
					namesWhereClause.append("')");

				}
				if (!first_name.equals(""))
				{
					if (family_name.equals("") && second_name.equals("")){			
						namesWhereClause.append(andClause);
						namesWhereClause.append(aliasName);
						namesWhereClause.append("generic_sndx_first =soundex('");
						namesWhereClause.append(first_name );
						namesWhereClause.append("')");

					}
				}
				if (!second_name.equals(""))
				{
					if (first_name.equals("")){
						namesWhereClause.append(andClause);
						namesWhereClause.append(aliasName);
						namesWhereClause.append("generic_sndx_second =soundex('");
						namesWhereClause.append(second_name);
						namesWhereClause.append("')");

					}
				}
				if (!third_name.equals(""))
				{
					namesWhereClause.append(andClause);
					namesWhereClause.append(aliasName);
					namesWhereClause.append("generic_sndx_third =soundex('");
					namesWhereClause.append(third_name);
					namesWhereClause.append("')");

				}
				if (!family_name.equals(""))
				{
					if (first_name.equals("")){
						namesWhereClause.append(andClause);
						namesWhereClause.append(aliasName);
						namesWhereClause.append("generic_sndx_second =soundex('");
						namesWhereClause.append(family_name);
						namesWhereClause.append("')");

					}
				}
			}
			else
			{
				if (pat_name_as_multipart_yn.equals("N"))
				{
					if (!family_name.equals(""))
					{						
						if(!fath_flag)
						{
							if (searchby.equals("C")){
								namesWhereClause.append(andClause);
								namesWhereClause.append(" upper(");
								namesWhereClause.append(aliasName);
								namesWhereClause.append("family_name) like upper('%");
								namesWhereClause.append(family_name);
								namesWhereClause.append("%') ");

							}
							else if (searchby.equals("E")){
								namesWhereClause.append(andClause);
								namesWhereClause.append(" upper(");
								namesWhereClause.append(aliasName);
								namesWhereClause.append("family_name) like upper('%");
								namesWhereClause.append(family_name);
								namesWhereClause.append("') ");

							}else{
								namesWhereClause.append(andClause);
								namesWhereClause.append(" upper(");
								namesWhereClause.append(aliasName);
								namesWhereClause.append("family_name) like upper('");
								namesWhereClause.append(family_name);
								namesWhereClause.append("%') ");
				
							}
							
						}
						else
						{
							String tempaliasName=aliasName;
							aliasName="a.";
							if (searchby.equals("C")){
								namesWhereClause.append(andClause);
								namesWhereClause.append(" upper(");
								namesWhereClause.append(aliasName);
								namesWhereClause.append("father_name) like upper('%");
								namesWhereClause.append(family_name);
								namesWhereClause.append("%') ");

							}else if (searchby.equals("E")){
								namesWhereClause.append(andClause);
								namesWhereClause.append(" upper(");
								namesWhereClause.append(aliasName);
								namesWhereClause.append("father_name) like upper('%");
								namesWhereClause.append(family_name);
								namesWhereClause.append("') ");

							}else{
								namesWhereClause.append(andClause);
								namesWhereClause.append(" upper(");
								namesWhereClause.append(aliasName);
								namesWhereClause.append("father_name) like upper('");
								namesWhereClause.append(family_name);
								namesWhereClause.append("%') ");
							
							}
							aliasName=tempaliasName;
						}
					}				
				}
				else
				{
					if (!first_name.equals("")){
						namesWhereClause.append(andClause);
						namesWhereClause.append(" upper(");
						namesWhereClause.append(aliasName);
						namesWhereClause.append("first_name) like upper('");
						namesWhereClause.append(first_name);
						namesWhereClause.append("%') ");

					}
					if (!second_name.equals("")){
						namesWhereClause.append(andClause);
						namesWhereClause.append(" upper(");
						namesWhereClause.append(aliasName);
						namesWhereClause.append("second_name) like upper('");
						namesWhereClause.append(second_name);
						namesWhereClause.append("%') ");

					}
					if (!third_name.equals("")){
						namesWhereClause.append(andClause);
						namesWhereClause.append(" upper(");
						namesWhereClause.append(aliasName);
						namesWhereClause.append("third_name) like upper('");
						namesWhereClause.append(third_name);
						namesWhereClause.append("%') ");

					}
					if (!family_name.equals("")){
						namesWhereClause.append(andClause);
						namesWhereClause.append(" upper(");
						namesWhereClause.append(aliasName);
						namesWhereClause.append("family_name) like upper('");
						namesWhereClause.append(family_name);
						namesWhereClause.append("%') ");

					}
				}
			}
		}
		else
		{
			if (!first_name.equals("")){
				namesWhereClause.append(andClause);
				namesWhereClause.append(aliasName);
				namesWhereClause.append("first_name_loc_lang like '");
				namesWhereClause.append(first_name);
				namesWhereClause.append("%' ");
			}
			if (!second_name.equals("")){
				namesWhereClause.append(andClause);
				namesWhereClause.append(aliasName);
				namesWhereClause.append("second_name_loc_lang like '");
				namesWhereClause.append(second_name);
				namesWhereClause.append("%' ");

			}
			if (!third_name.equals("")){
				namesWhereClause.append(andClause);
				namesWhereClause.append(aliasName);
				namesWhereClause.append("third_name_loc_lang like '");
				namesWhereClause.append(third_name);
				namesWhereClause.append("%' ");

			}
			if (!family_name.equals("")){
				namesWhereClause.append(andClause);
				namesWhereClause.append(aliasName);
				namesWhereClause.append("family_name_loc_lang like '");
				namesWhereClause.append(family_name);
				namesWhereClause.append("%' ");

			}
		}
	}
	else
	{
		if (apply_oth_name.equals("N"))
		{
			if (names_search_by.equals("B"))
			{
				if (!first_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(" upper(");
					namesWhereClause.append(aliasName);
					namesWhereClause.append("first_name) like upper('");
					namesWhereClause.append(first_name);
					namesWhereClause.append("%') ");

				}
				if (!second_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(" upper(");
					namesWhereClause.append(aliasName);
					namesWhereClause.append("second_name) like upper('");
					namesWhereClause.append(second_name);
					namesWhereClause.append("%') ");

				}
				if (!third_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(" upper(");
					namesWhereClause.append(aliasName);
					namesWhereClause.append("third_name) like upper('");
					namesWhereClause.append(third_name);
					namesWhereClause.append("%') ");

				}
				if (!family_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(" upper(");
					namesWhereClause.append(aliasName);
					namesWhereClause.append("family_name) like upper('");
					namesWhereClause.append(family_name);
					namesWhereClause.append("%') ");

				}
				if (!fourth_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(" upper(");
					namesWhereClause.append(aliasName);
					namesWhereClause.append("fourth_name) like upper('");
					namesWhereClause.append(fourth_name);
					namesWhereClause.append("%') ");

				}
				if (!fifth_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(" upper(");
					namesWhereClause.append(aliasName);
					namesWhereClause.append("fifth_name) like upper('");
					namesWhereClause.append(fifth_name);
					namesWhereClause.append("%') ");

				}
			}
			else if (names_search_by.equals("M"))
			{
				if (!first_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(" upper(mother_first_name) like upper('");
					namesWhereClause.append(first_name);
					namesWhereClause.append("%') ");

				}
				if (!second_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(" upper(mother_second_name) like upper('");
					namesWhereClause.append(second_name);
					namesWhereClause.append("%') ");

				}
				if (!third_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(" upper(mother_third_name) like upper('");
					namesWhereClause.append(third_name);
					namesWhereClause.append("%') ");

				}
				if (!family_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(" upper(mother_family_name) like upper('");
					namesWhereClause.append(family_name);
					namesWhereClause.append("%') ");
				}
			
			}
			else if (names_search_by.equals("F"))
			{	
				if (!first_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(" upper(father_first_name) like upper('");
					namesWhereClause.append(first_name);
					namesWhereClause.append("%') ");

				}
				if (!second_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(" upper(father_second_name) like upper('");
					namesWhereClause.append(second_name);
					namesWhereClause.append("%') ");

				}
				if (!third_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(" upper(father_third_name) like upper('");
					namesWhereClause.append(third_name);
					namesWhereClause.append("%') ");

				}
				if (!family_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(" upper(father_family_name) like upper('");
					namesWhereClause.append(family_name);
					namesWhereClause.append("%') ");

				}
			
			}
		}
		else
		{
			if (names_search_by.equals("B"))
			{
				if (!first_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(aliasName);
					namesWhereClause.append("first_name_loc_lang like '");
					namesWhereClause.append(first_name);
					namesWhereClause.append("%' ");

				}
				if (!second_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(aliasName);
					namesWhereClause.append("second_name_loc_lang like '");
					namesWhereClause.append(second_name);
					namesWhereClause.append("%' ");

				}
				if (!third_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(aliasName);
					namesWhereClause.append("third_name_loc_lang like '");
					namesWhereClause.append(third_name);
					namesWhereClause.append("%' ");

				}
				if (!family_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(aliasName);
					namesWhereClause.append("family_name_loc_lang like '");
					namesWhereClause.append(family_name);
					namesWhereClause.append("%' ");

				}
				
			}
			else if (names_search_by.equals("M"))
			{
				if (!first_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(" mother_first_name_loc_lang like '");
					namesWhereClause.append(first_name);
					namesWhereClause.append("%' ");

				}
				if (!second_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(" mother_second_name_loc_lang like '");
					namesWhereClause.append(second_name);
					namesWhereClause.append("%' ");

				}
				if (!third_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(" mother_third_name_loc_lang like '");
					namesWhereClause.append(third_name);
					namesWhereClause.append("%' ");

				}
				if (!family_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(" mother_family_name_loc_lang like '");
					namesWhereClause.append(family_name);
					namesWhereClause.append("%' ");

				}
			
			}
			else if (names_search_by.equals("F"))
			{
				if (!first_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(" father_first_name_loc_lang like '");
					namesWhereClause.append(first_name);
					namesWhereClause.append("%' ");

				}
				if (!second_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(" father_second_name_loc_lang like '");
					namesWhereClause.append(second_name);
					namesWhereClause.append("%' ");

				}
				if (!third_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(" father_third_name_loc_lang like '");
					namesWhereClause.append(third_name);
					namesWhereClause.append("%' ");

				}
				if (!family_name.equals("")){
					namesWhereClause.append(andClause);
					namesWhereClause.append(" father_family_name_loc_lang like '");
					namesWhereClause.append(family_name);
					namesWhereClause.append("%' ");

				}
			
			}
		}
	}


	try
	{
		
		if ( from == null )
		start = 1 ;
		else
		start = Integer.parseInt( from ) ;

		if ( to == null )
	  	end = tableSize ;
		else
		end = Integer.parseInt( to ) ;

		if (whereClause.toString().equals("where") && !namesWhereClause.toString().equals("") && whereClauseOld==null){
		//if (!namesWhereClause.toString().equals("") && whereClauseOld==null){
			whereClause.setLength(0);
			whereClause.append("where ");
			whereClause.append(namesWhereClause.substring(4));
			WhereClauseflag=1;

		}
		if (whereClauseOld != null){
			whereClause.setLength(0);
			whereClause.append(whereClauseOld);

		}

		if (!whereClause.toString().equals("where"))
		{			
			if (function_id.equals("")|| function_id.equals("MP_VIEW_BIRTH_REG"))
			{
				addlTableClause = request.getParameter("addlTableClause");
				if (addlTableClause==null) addlTableClause ="";
				addlWhereClause = request.getParameter("addlWhereClause");
				if (addlWhereClause==null) addlWhereClause ="";
				addlTableClauseFath = request.getParameter("addlTableClauseFath");
				if (addlTableClauseFath==null) addlTableClauseFath ="";
				addlWhereClauseFath = request.getParameter("addlWhereClauseFath");
				if (addlWhereClauseFath==null) addlWhereClauseFath ="";

				if (!first_name.equals("") || !second_name.equals("") || !third_name.equals("") || !family_name.equals(""))
				{
					if (names_search_by.equals("M"))
					{
						addlTableClause = ", mp_patient moth";
						addlWhereClause = " and moth.patient_id = a.mother_patient_id ";
				
					}
					else if (names_search_by.equals("F"))
					{
						
							addlTableClause = ", mp_patient fath ";	
							addlWhereClause = " and fath.patient_id = a.patient_id ";
							addlTableClauseFath = ", mp_patient fath ";	
							addlWhereClauseFath = " and fath.patient_id = a.father_patient_id ";
						
					}
				}
				// newly added still need to be checked..
				if(WhereClauseflag != 1)
			whereClause.append(namesWhereClause.toString());


			//sql1="select count(1) from mp_patient b"+addlTableClause+", mp_birth_register a "+whereClause+" and b.patient_id = a.patient_id "+addlWhereClause+" and b.patient_id like '%%'";
			} 			
		}
	/*	else
		{
			//if (function_id.equals(""))
			//	sql1="select count(1) from mp_birth_register a where a.patient_id like '%%'";
		}*/
		
		conn	= ConnectionManager.getConnection(request);
		stmt1	= conn.createStatement();	
		//rs1		= stmt1.executeQuery(sql1);

		/*if(rs1.next())
		{
			TotalRecord = rs1.getInt(1);
			
		}*/
		//if (TotalRecord > 0)
	//	{
	
			stmt = conn.createStatement();
			
			if(!(whereClause.toString().equals("where")))
			{
				if (function_id.equals("") || function_id.equals("MP_VIEW_BIRTH_REG"))
				{
					sql.append(" select a.patient_id, decode('"+localeName+"', 'en', b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) nb_patient_name, nb_sex, to_char(time_of_birth, 'dd/mm/yyyy hh24:mi') nb_birth_date,a.mother_patient_id, decode('"+localeName+"', 'en', moth.patient_name, nvl(moth.patient_name_loc_lang, moth.patient_name))  mother_patient_name, b.alt_id1_no alt_id1_no, birth_order newborn_id_no_suffix,a.finalized_yn from mp_patient b, mp_patient moth");
					sql.append(addlTableClauseFath);
					sql.append(", mp_birth_register a " );
					sql.append(whereClause.toString());
					sql.append(" and b.patient_id = a.patient_id and moth.patient_id = a.mother_patient_id ");
					sql.append(addlWhereClauseFath);
					sql.append("and b.patient_id like '%%' and moth.patient_id like '%%' order by a.patient_id");
				}
			}
			else
			{
				if (function_id.equals("") || function_id.equals("MP_VIEW_BIRTH_REG"))
				{
					sql.setLength(0);
					sql.append(" select a.patient_id, decode('"+localeName+"', 'en', b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) nb_patient_name, nb_sex, to_char(time_of_birth, 'dd/mm/yyyy hh24:mi') nb_birth_date, a.mother_patient_id,decode('"+localeName+"', 'en', moth.patient_name, nvl(moth.patient_name_loc_lang, moth.patient_name)) mother_patient_name, b.alt_id1_no alt_id1_no, birth_order newborn_id_no_suffix,a.finalized_yn from mp_patient b, mp_patient moth, mp_birth_register a where b.patient_id = a.patient_id and moth.patient_id = a.mother_patient_id and b.patient_id like '%%' and moth.patient_id like '%%' order by a.patient_id");
				}
			}	
			//out.println("<script>alert(\""+sql.toString()+"\");</script>");
			
			rs=stmt.executeQuery(sql.toString());
	/*	}
		else
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");
		}*/
		out.println("<script>");
		out.println("for (var i=0;i<parent.frames[1].document.forms[0].elements.length;i++) {				parent.frames[1].document.forms[0].elements[i].disabled=false;}");
		out.println("parent.frames[2].document.forms[0].Search.disabled = false;");
		out.println("if (parent.frames[1].document.forms[0].searchby) {");
		out.println("if (parent.frames[1].document.forms[0].soundex_val.value != '')");
		out.println("	parent.frames[1].document.forms[0].searchby.disabled=true; }");
		out.println("if (parent.frames[1].document.forms[0].accept_oth_alt_id_yn.value == 'Y'){");
		out.println("if (parent.frames[1].document.forms[0].other_alt_id.value == '')");
		out.println("parent.frames[1].document.forms[0].other_alt_Id_no.disabled=true; }");
		out.println("parent.frames[1].setFields();");
		out.println("</script>");
		if (!function_id.equals("") && !function_id.equals("MP_VIEW_BIRTH_REG")) 
			out.println("<script>parent.frames[1].document.forms[0].soundex_val.disabled=true;</script>");
		out.println("<script>parent.frames[0].location.href='../../eMP/jsp/BirthRegisterToolBar.jsp'</script>");
		int i=0;
%>
	<body onKeyDown = 'lockKey()'>
	<form name='birth_register_result' id='birth_register_result' >
	<P>
	<table align='right' >
	<tr >

<%
//if (TotalRecord > 0)
//{		
		if (start > 1)
		{
			out.println("<td colspan='6'align='right' id='prev'> <A HREF='../../eMP/jsp/ViewBirthRegisterResult.jsp?from="+(start-tableSize)+"&to="+(end-tableSize)+"&whereClauseOld="+URLEncoder.encode(whereClause.toString())+ "&addlTableClause="+URLEncoder.encode(addlTableClause)+"&addlWhereClause="+URLEncoder.encode(addlWhereClause)+"&addlTableClauseFath="+URLEncoder.encode(addlTableClauseFath)+"&addlWhereClauseFath="+URLEncoder.encode(addlWhereClauseFath)+"&alt_id1_type_deschd="+URLEncoder.encode(alt_id1_type_deschd)+"&function_id="+function_id+"'"
			+ " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
			
		}
				
		//if ( !( (start+tableSize) > TotalRecord ) )
		{

			out.println("<td colspan='6'align='right' id='next' style='visibility:hidden'><A HREF='../../eMP/jsp/ViewBirthRegisterResult.jsp?from="+(start+tableSize)+"&to="+(end+tableSize)+"&whereClauseOld="+URLEncoder.encode(whereClause.toString())+ "&addlTableClause="+URLEncoder.encode(addlTableClause)+"&addlWhereClause="+URLEncoder.encode(addlWhereClause)+"&addlTableClauseFath="+URLEncoder.encode(addlTableClauseFath)+"&addlWhereClauseFath="+URLEncoder.encode(addlWhereClauseFath)+"&alt_id1_type_deschd="+URLEncoder.encode(alt_id1_type_deschd)+"&function_id="+function_id+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");

		}
	
%>

</tr>
</table>
</P>
	<br><br>

<table border="1" cellpadding="0" cellspacing="0" width="100%" >
			
<%	
	 if ( start != 1 )
	 for( int j=1; j<start; i++,j++ )
	  rs.next() ;
	int cnt = 0;
	 while(rs.next() && i < end) 
     {
		 if(cnt==0)
		 {%>
			 <tr>
			<th nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>

			<% //naren 
			if (!function_id.equals("") && !function_id.equals("BIRTH_NOTIFICATION") && !function_id.equals("BIRTH_REGISTRATION") && !function_id.equals("MP_VIEW_BIRTH_REG")) {%>
				<th nowrap><fmt:message key="eMP.RegnType.label" bundle="${mp_labels}"/></th>
				<th nowrap><fmt:message key="Common.registrationno.label" bundle="${common_labels}"/></th>
			<%}%>
			<th nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th><th nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/> </th><th nowrap><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></th><th nowrap><fmt:message key="eMP.motherpatientid.label" bundle="${mp_labels}"/></th><th nowrap><fmt:message key="eMP.MotherPatientName.label" bundle="${mp_labels}"/></th><th nowrap><%=alt_id1_type_deschd%></th><th nowrap><fmt:message key="eMP.BirthOrder.label" bundle="${mp_labels}"/> </th>
			<tr>
		<% }
			cnt++;
			i++;
            finalized_yn = rs.getString("finalized_yn");
            if(finalized_yn.equals("Y")) {
					regnStatusStyle = "style='background-color:#00FFFF'";
			} else if(finalized_yn.equals("N")) {					
					regnStatusStyle = "style='background-color:#FECBFA'";
			} 		
           
			PID= rs.getString(1);
						
			String Regnno = "";
			String RegnType = "";
			//naren
			// function_id.equals("MP_VIEW_BIRTH_REG") condition added by Muthu against incident 17285 on 15/12/2009
			if (!function_id.equals("") && !function_id.equals("BIRTH_NOTIFICATION") && !function_id.equals("BIRTH_REGISTRATION") && !function_id.equals("MP_VIEW_BIRTH_REG")) 
			{
				Regnno = rs.getString("nb_medical_regn_no");
				RegnType = rs.getString("nb_medical_regn_type");				
				if(RegnType == null) RegnType="";
				if (RegnType.equals("01")) RegnType = regn_type1;
				if (RegnType.equals("02")) RegnType = regn_type2;
			}
			String PName = rs.getString("nb_patient_name");
			String SexDb=rs.getString(3);
			String dobDb=rs.getString(4);
			String MID=rs.getString(5);
			String MName=rs.getString(6);
			String qid=rs.getString(7);
			String suffix=rs.getString(8);
			
			if(Regnno == null)
				Regnno="";			
			if(PID == null)
				PID="";
			if(PName == null)
			    PName ="";
			if(SexDb == null)
				SexDb="";
			if(dobDb != null)
			{
				dobDb=DateUtils.convertDate(dobDb,"DMYHM","en",locale);
			}
			else
				dobDb="";
			if(MID == null)
				MID="";
			if(MName == null)
				MName="";
			if(qid == null)
				qid="";
			if(suffix == null)
				suffix="";
		
				
			
			if(TotalRecord == 1)
			{
		%>
			<script>self.location.href="javaScript:openReg(\"<%=URLEncoder.encode(PID)%>\")"
			</script>
		<%
			}
		

 out.println("<td "+regnStatusStyle+" onClick=openReg(\""+URLEncoder.encode(PID)+"\") nowrap>");
 %>
	
<a href="callDummy()"><%=PID %></a>
</td>

<td <%=regnStatusStyle%> nowrap><%=PName%>&nbsp;</td>
<td <%=regnStatusStyle%> nowrap>			
			<%if(SexDb.equals("M"))
			{%>
				<fmt:message key="Common.male.label" bundle="${common_labels}"/>
		   <%}else if(SexDb.equals("F")){%>
				<fmt:message key="Common.female.label" bundle="${common_labels}"/>
		   <%}else if(SexDb.equals("U")){%>
				<fmt:message key="Common.unknown.label" bundle="${common_labels}"/>
		   <%}%>&nbsp;</td>
<td <%=regnStatusStyle%> nowrap><%=dobDb%>&nbsp;</td>
<td <%=regnStatusStyle%> nowrap><%=MID%>&nbsp;</td>
<td <%=regnStatusStyle%> nowrap><%=MName%>&nbsp;</td>
<td <%=regnStatusStyle%> nowrap><%=qid%>&nbsp;</td>
<td <%=regnStatusStyle%> nowrap style='text-align=right'><%=suffix%>&nbsp;</td>
</tr>



<%
       
     }
//} 

if (cnt==0)
{
// added by N Munisekhar on 13-Mar-2013 against ML-BRU-SCF-0749 [IN:038571] 	
	pstmt = conn.prepareStatement("select valid_patient_id from dr_mp_patient where duplicate_patient_id = ?");
	pstmt.setString(1,PatientID);
	rs=pstmt.executeQuery();
	if (rs!=null && rs.next())
		valid_patient_id = rs.getString("valid_patient_id");
		if (valid_patient_id==null) valid_patient_id = "";
	if (!valid_patient_id.equals("")){
	out.println("<script> var msg = parent.criteria.getMessage('PAT_MERGED_VALID','MP');msg= msg.replace('#','"+valid_patient_id+"');alert(msg);</script>");out.println("<script>parent.criteria.document.forms[0].Patient_Id.value='"+valid_patient_id+"';parent.frames[2].document.forms[0].Search.disabled =false ;parent.frames[2].document.forms[0].Search.focus(); </script>");
	}
	if (valid_patient_id.equals("")){
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
}
}
//End of ML-BRU-SCF-0749 [IN:038571] 
boolean flag = false;
if ( cnt < 14 || (!rs.next()) ) {
%>
	<script >
	if (document.getElementById("next"))
		document.getElementById("next").style.visibility='hidden';
	</script>
<% flag = true;
		} else {%>
	<script >
	if (document.getElementById("next"))
		document.getElementById("next").style.visibility='visible';
	</script>
<Script src='../../eCommon/js/showModalDialog.js' language="JavaScript"></Script>



<%}%>


	</table>
	<%if (cnt!=0)
	{%>	
			<table border='1' cellpadding=0 cellspacing=0 width='100%'>
				<tr><td class="label" colspan='6'>&nbsp;</td></tr>
				<tr><td width = '5%' bordercolor='black' style='background-color:#FECBFA' >&nbsp;</td><td width = '25%'><fmt:message key="eMP.FirstStageRegistrationRecords.label" bundle="${mp_labels}"/>&nbsp;</td><td width = '5%' bordercolor='black' style='background-color:#00FFFF'>&nbsp;</td><td width = '25%'> &nbsp;<fmt:message key="eMP.FinalizedRecords.label" bundle="${mp_labels}"/></td><td width='40%'>&nbsp;</td></tr>
			</table>
	<%}%>
	</form>
	</body>
	</html>

<%
	if(function_id.equals("") || function_id.equals("MP_VIEW_BIRTH_REG")){
		if(cnt==1){
			out.println("<script>openReg('"+PID+"')</script>");
		}
	} 


 
	if(rs != null) rs.close();
	if(stmt != null) stmt.close();
	if(pstmt != null) pstmt.close();
	if(stmt1!=null) stmt1.close();
	}
	catch(Exception e)
	{
			out.println(e.toString());
	}
	finally
	{
		
		sql.setLength(0);
		whereClause.setLength(0);
		namesWhereClause.setLength(0);
		if(conn!=null) ConnectionManager.returnConnection(conn,request);                
	}            
%>

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

