<!DOCTYPE html>
<!--
	Developed by 	:	Prakash.S
	Created on 		:	10/06/2002
	Module			:	FM - Assign File Store Location
	Function		:	This function is used for Search Result.
-->
<%@ page contentType="text/html; charset=UTF-8" import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="recordSet" scope="session" class="webbeans.eCommon.RecordSet"/>

<%! int row_count=0; %>
<%
	
	
	Connection con				=	null;
	java.sql.Statement stmt		=	null;
	java.sql.Statement stmt1	=	null;
	java.sql.Statement stmt2	=	null;
	java.sql.Statement stmt3	=	null;
	java.sql.Statement stmt4	=	null;
	java.sql.Statement stmt5	=	null;
	
	ResultSet rs				=	null;
	ResultSet rs1				=	null;
	ResultSet rs3				=	null;
    ResultSet rs4				=	null;
	ResultSet rs5				=	null;
	HashMap		htRecord		=	null;
    HashMap		keepRecord		=	null;
	HashMap		pat_file_code		=	null;
	pat_file_code	= new HashMap();
	keepRecord	= new HashMap();
	 HashMap		keepRecord1		=	null;
	keepRecord1= new HashMap();
	String file_no				= "", patient_id = "", patient_name = "";
	String str = "";
	String associate_yn_prop = ""; 
	String tblrow_id			= "", classValue="",fs_locn_code="",fs_desc="",fn_locn_code="";
	String locn_identity		= "", narration_code="", holder_name="",fs_locn_disp="",pat_details="";
//	String header				= "";
	String fs_locn="",mr_pat_fs_locn_desc="", curr_fs_locn_desc="";
	String other_locn_code		= "", curr_fs_locn_identity = "";
	String curr_holder_name		= "", curr_mr_locn_yn = "",mr_locn_yn = "";
	String file_type_code		= "", volume_no = "",file_type_desc = "";
	String dissable_attribute	= "";
	String doc_folder_id		=	"", doc_type_code = "";
	String associate_yn			= "N";
	String sql_query			= "";
	String file_vol_fslocn="";
	int l=0;
	String sql1					= "";
	String destination			= "";
	String curr_facility_id1			= "";	
	String curr_file_status			= "";
	String file_creat_fac_id ="";
	String  sqlString ="";
	String curr_fs_locn_ident="";
	String curr_facility_id="";
	String str1 ="";
	StringBuffer result_query   = null;
	StringBuffer result_query1   = null;
	String old_fs_locn_code ="";
	String   old_fs_desc ="";
	String vol_no_key ="";
	String vol_no="";
	String fslocn_type_old="";
	//String sel=""; checkstyle changes - 35865
	String selected="";
	try
	{
		con		=	ConnectionManager.getConnection(request);
		stmt	=	con.createStatement();
		stmt1	=	con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

		int start		= 0 ;
		int end			= 0 ;
		int fm_disp		= 0, to_disp = 0;

		
		
		String facility_id			=   (String)session.getValue("facility_id");
		String from					=	request.getParameter( "from_1" ) ;
		String to					=	request.getParameter( "to_1" ) ;
		String mode					=	request.getParameter("mode") ;
		String file_type_appl_yn	=	request.getParameter("file_type_appl_yn") ;
		String fileno	=	request.getParameter("file_no") ;
		String volumeno	=	request.getParameter("volume_no") ;
		String volume_no1	=	request.getParameter("volume_no") ;
		String  fs_req_location    =	request.getParameter("file_type_code") ;
		String   patient_id1       =	request.getParameter("patient_id") ;
		String storage_locn=	request.getParameter("storage_locn") ;  	
	    String terminaldigit =	request.getParameter("terminaldigit") ;  
	    String fr =	request.getParameter("fr") ;  
	   String added_temp_code =	request.getParameter("added_temp_code") ;  
	 	String filevol_concat=""; 
		if(added_temp_code == null || added_temp_code.equals("null")) added_temp_code = "";
	  if(fr == null || fr.equals("null")) fr = "";
	 if(terminaldigit == null || terminaldigit.equals("null")) terminaldigit = "";
	  if(storage_locn == null || storage_locn.equals("null")) storage_locn = "";
		if(patient_id1 == null || patient_id1.equals("null")) patient_id1 = "";
		if(fs_req_location == null || fs_req_location.equals("null")) fs_req_location = "";
		if(fileno == null || fileno.equals("null")) fileno = "";

		if(volumeno == null || volumeno.equals("null")) volumeno = "";		
		if(file_type_appl_yn == null || file_type_appl_yn.equals("null")) file_type_appl_yn = "";
		if(mode == null || mode.equals("null")) mode="";
       if(volume_no1 == null || volume_no1.equals("null")) volume_no1 = "";
	
		if(!added_temp_code.equals("") && !patient_id1.equals(""))
		{
       StringTokenizer  	strToken	=  new StringTokenizer (added_temp_code,",");
      while(strToken.hasMoreTokens())
		{
	     if(strToken.hasMoreTokens())
		 file_vol_fslocn=strToken.nextToken() ;
		   StringTokenizer  	strToken1	=  new StringTokenizer (file_vol_fslocn,"`");
		while(strToken1.hasMoreTokens())
		{
		if(strToken1.hasMoreTokens())
		 vol_no_key    =strToken1.nextToken() ;
		  if(strToken1.hasMoreTokens())
		 vol_no	=strToken1.nextToken();
	       pat_file_code.put(vol_no_key ,vol_no);
		}
	}
		
		}
		
		if(from == null) start = 1 ;
		else start = Integer.parseInt(from) ;

		if(to == null) end = 11 ;
		else end = Integer.parseInt( to ) ;

		stmt3	=	con.createStatement();
	 
	  if(!patient_id1.equals(""))
		{
	  sqlString = "SELECT FACILITY_ID  FROM mr_pat_file_index WHERE  patient_id ='"+patient_id1+"' and file_no='"+fileno+"' and doc_folder_id is null ";
	
	  stmt4	=	con.createStatement();
	 rs4	=	stmt4.executeQuery(sqlString);
	  while(rs4 != null && rs4.next())
			{
			file_creat_fac_id=rs4.getString("FACILITY_ID");
			}
	    if(stmt4!=null) stmt4.close();
    	if(rs4!=null)	rs4.close(); 
	}
  
  if(!file_creat_fac_id.equals(""))
		{ 
        sql1 = "SELECT A.DEST_LOCN_IDENTITY || FM_GET_DESC.FM_STORAGE_LOCN(A.FACILITY_ID, A.DEST_FS_LOCN_CODE,'"+localeName+"','2') Destination FROM  fm_Transit_File a WHERE a.Facility_Id = '"+file_creat_fac_id+"'   AND a.File_No = '"+fileno+"'  AND a.Volume_No ='"+volumeno+"' ";
		rs3 = stmt3.executeQuery(sql1);				
			while(rs3 != null && rs3.next())
		{
			destination				=	rs3.getString("destination");
			}
			if(destination == null || destination.equals("null")) destination="";
		}
	
	    if(!destination.equals(""))
		  {
			switch(destination.charAt(0))
			{
				case 'D' : destination = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.department.label","common_labels"); break;

				case 'C' : destination = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels"); break;

				case 'N' : destination = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels"); break;

				case 'T' : destination = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels"); break;

				case 'X' : destination = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels"); break;

				case 'E' : destination = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels"); break;

				case 'Y' : destination = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels"); break;
		
			}
		}
			

			if(rs3 != null) rs3.close();
			if(stmt3 != null) stmt3.close();

			fs_locn	=	request.getParameter("fs_locn");
			if(fs_locn == null) fs_locn = "P";
		
		if(mode.equals(""))
		{	
			 result_query	= new StringBuffer();
			 result_query1	= new StringBuffer();

			str = request.getParameter("whereClause");
			str1 = request.getParameter("whereClause1");
			
			if(str == null) str = "";
			if(str1 == null) str1 = "";
			fs_locn	=	request.getParameter("fs_locn");
			if(fs_locn == null) fs_locn = "P";
			if(!(str.equals(""))) recordSet.clearAll();
			if(str == null)str="";
			else str = str.replace('~','%');
			
			if(!file_creat_fac_id.equals(""))
			{
			result_query1.append("SELECT curr_file_status,curr_facility_id FROM fm_curr_locn a WHERE facility_id='"+file_creat_fac_id+"' and file_no='"+fileno+"' and volume_no='"+volumeno+"'  ");
		
			rs = stmt.executeQuery(result_query1.toString());
			while(rs != null && rs.next()){
				curr_file_status					=	rs.getString("curr_file_status");				
			   curr_facility_id1                   =	rs.getString("curr_facility_id");		
			} if(rs != null) rs.close();			
	
			if(curr_facility_id1==null) curr_facility_id1="";
			}
			
			 if(!file_creat_fac_id.equals(curr_facility_id1))
			{
	      stmt5	=	con.createStatement();
		    String sqlqry=" SELECT curr_fs_locn_identity  FROM fm_curr_locn WHERE  patient_id ='"+patient_id1+"' and facility_id='"+file_creat_fac_id+"' and curr_file_status='I' and volume_no='"+volume_no1+"' ";
		rs5	=	stmt5.executeQuery(sqlqry);	
		 while(rs5 != null && rs5.next())
			{
			curr_fs_locn_ident = rs5.getString("curr_fs_locn_identity");
      	   		}
	 
	   
		 if(curr_fs_locn_ident==null)	 curr_fs_locn_ident="";		
		if(stmt5!=null) stmt5.close();
    	if(rs5!=null)	rs5.close(); 	

		} 
			
			if(fs_locn.equals("P"))
			{
			
				if(file_type_appl_yn.equals("N"))
				{
					result_query.append("SELECT file_no, patient_id, file_type_code,volume_no, doc_type_code,doc_folder_id, mr_pat_fs_locn_code fs_locn_code, curr_fs_locn_code other_locn, curr_facility_id, get_patient_line(patient_id,'"+localeName+"') pat_details, mr_pat_locn_short_desc mr_pat_fs_locn_desc, curr_fs_locn_short_desc curr_fs_locn_desc, curr_fs_locn_identity, curr_holder_name, mr_locn_yn FROM fm_curr_locn_vw a") ;
				  
						if(!file_creat_fac_id.equals(facility_id) && !file_creat_fac_id.equals(""))
					{
					 result_query.append(" WHERE a.curr_file_status NOT IN ('T','R','E','O','I','L') ");
					}else{
					 result_query.append(" WHERE a.curr_file_status NOT IN ('T','R','E','L') AND a.facility_id='"+facility_id+"' ");
						}
					//}
				/*	if(!fileno.equals("") && !fileno.equals("undefined"))
					{
					result_query.append(" and patient_id='"+patient_id1+"' ");
					} */
					if((curr_file_status.equals("T") || curr_file_status.equals("E") || curr_file_status.equals("R")) && !terminaldigit.equals(""))
					{
					 result_query.append(str1);
				}else{
                      result_query.append(str);
  				}
				}
				else if(file_type_appl_yn.equals("Y"))
				{
					result_query.append("select file_no, patient_id, file_type_code,file_type_desc,volume_no,doc_type_code,doc_folder_id, mr_pat_fs_locn_code fs_locn_code, curr_fs_locn_code other_locn, curr_facility_id, get_patient_line(patient_id,'"+localeName+"') pat_details, mr_pat_locn_short_desc mr_pat_fs_locn_desc, curr_fs_locn_short_desc curr_fs_locn_desc, curr_fs_locn_identity, curr_holder_name, mr_locn_yn from fm_curr_locn_vw a ");
					
									
					if(!file_creat_fac_id.equals(facility_id) && !file_creat_fac_id.equals(""))
					{
					 result_query.append(" WHERE a.curr_file_status NOT IN ('T','R','E','O','I','L') ");
					}else{
					 result_query.append(" WHERE a.curr_file_status NOT IN ('T','R','E','L') AND a.facility_id='"+facility_id+"' ");
					}
					//}
				//	}
				/*	if(!fileno.equals("") && !fileno.equals("undefined"))
					{
					result_query.append(" and patient_id='"+patient_id1+"' ");
					} */
							
					if((curr_file_status.equals("T") || curr_file_status.equals("E") || curr_file_status.equals("R")) && !terminaldigit.equals(""))
					{
					 result_query.append(str1);
				}else{
                      result_query.append(str);
  				}
				}
			}
			else
			{
				if(file_type_appl_yn.equals("N"))
				{
					result_query.append("select file_no, patient_id, file_type_code,volume_no,doc_type_code,doc_folder_id, curr_fs_locn_code fs_locn_code, curr_facility_id, mr_pat_fs_locn_code other_locn, get_patient_line(patient_id,'"+localeName+"') pat_details, mr_pat_locn_short_desc mr_pat_fs_locn_desc, curr_fs_locn_short_desc curr_fs_locn_desc, curr_fs_locn_identity, curr_holder_name, mr_locn_yn from fm_curr_locn_vw a ")  ;
					
					if(!file_creat_fac_id.equals(facility_id))
					{
					result_query.append(" WHERE     a.curr_file_status NOT IN ('T','R','E','L') and a.curr_facility_id='"+facility_id+"'");
									 
					}else{
					 
					 if(!file_creat_fac_id.equals(curr_facility_id1) && curr_fs_locn_ident.equals("D"))
	                {
					 result_query.append(" WHERE a.curr_file_status NOT IN ('T','R','E','I','L') and a.curr_facility_id='"+facility_id+"' ");
				 	}else if(!file_creat_fac_id.equals(curr_facility_id1)){

					 result_query.append(" WHERE a.curr_file_status NOT IN ('T','R','E','O','L') and a.curr_facility_id='"+facility_id+"' ");
					}else{
                     result_query.append(" WHERE a.curr_file_status NOT IN ('T','R','E','L') and a.curr_facility_id='"+facility_id+"' ");
					}
					}
				
					/*if(!fileno.equals("") && !fileno.equals("undefined"))
					{
					result_query.append(" and patient_id='"+patient_id1+"' ");
					} */
				
					if((curr_file_status.equals("T") || curr_file_status.equals("E") || curr_file_status.equals("R")) && !terminaldigit.equals(""))
					{
					 result_query.append(str1);
								
				}else{
                      if(!curr_facility_id1.equals(facility_id) && curr_file_status.equals("I") &&  !terminaldigit.equals(""))
					{
					result_query.append(str1);
					}else{
					
					  result_query.append(str);
					}
				}
				}
				else if(file_type_appl_yn.equals("Y"))
				{
					result_query.append("select file_no, patient_id, file_type_code,file_type_desc,volume_no,doc_type_code,doc_folder_id,curr_fs_locn_code fs_locn_code, curr_facility_id, mr_pat_fs_locn_code other_locn, get_patient_line(patient_id,'"+localeName+"') pat_details, mr_pat_locn_short_desc mr_pat_fs_locn_desc, curr_fs_locn_short_desc curr_fs_locn_desc, curr_fs_locn_identity, curr_holder_name, mr_locn_yn from fm_curr_locn_vw a  ");
					
					if(!file_creat_fac_id.equals(facility_id))
					{
					result_query.append(" WHERE a.curr_file_status NOT IN ('T','R','E','L') and a.curr_facility_id='"+facility_id+"'");
					}else{
					 
					 if(!file_creat_fac_id.equals(curr_facility_id1) && curr_fs_locn_ident.equals("D"))
	                {
					 result_query.append(" WHERE a.curr_file_status NOT IN ('T','R','E','I','L') and a.curr_facility_id='"+facility_id+"' ");
				 	}else if(!file_creat_fac_id.equals(curr_facility_id1)){
		
			 result_query.append("WHERE a.curr_file_status NOT IN ('T','R','E','O','L') and a.curr_facility_id='"+facility_id+"' ");
					}else{
       
			 result_query.append(" WHERE a.curr_file_status NOT IN ('T','R','E','L') and a.curr_facility_id='"+facility_id+"' ");
					}
					}
				
				/*	if(!fileno.equals("") && !fileno.equals("undefined"))
					{
					result_query.append(" and patient_id='"+patient_id1+"' ");
					} */
					if((curr_file_status.equals("T") || curr_file_status.equals("E") || curr_file_status.equals("R")) && !terminaldigit.equals(""))
					{
					 result_query.append(str1);
				     }else{
                       if(!curr_facility_id1.equals(facility_id) && curr_file_status.equals("I") &&  !terminaldigit.equals(""))
					{
					result_query.append(str1);
					}else{
					  result_query.append(str);
					}
					  result_query.append(str);
  				}
				}
			}
			
			result_query.append("order by file_no,volume_no");
				
			rs = stmt.executeQuery(result_query.toString());
						
			associate_yn = "N";
			
			while(rs != null && rs.next())
			{
				file_no					=	rs.getString("file_no");
				patient_id				=	rs.getString("patient_id");
				file_type_code			=	rs.getString("file_type_code");
				volume_no				=	rs.getString("volume_no");
				doc_folder_id			=   rs.getString("doc_folder_id");
				doc_type_code			=   rs.getString("doc_type_code");

				if(file_type_appl_yn.equals("Y"))
				{
					file_type_desc			=	rs.getString("file_type_desc");
					
					if(file_type_desc!=null)
					file_type_desc			=file_type_desc + " / ";
					else
					file_type_desc="";		
					if(file_type_desc == null || file_type_desc.equals("null"))
					{
						file_type_desc = "&nbsp;";
					}
				}				
				fs_locn_disp			=	rs.getString("fs_locn_code");
				curr_facility_id			=	rs.getString("curr_facility_id");
				pat_details				=	rs.getString("pat_details").substring(0,rs.getString("pat_details").length()-6);
				other_locn_code			=	rs.getString("other_locn");
				mr_pat_fs_locn_desc		=	rs.getString("mr_pat_fs_locn_desc");
				curr_fs_locn_desc		=	rs.getString("curr_fs_locn_desc");
				curr_fs_locn_identity	=	rs.getString("curr_fs_locn_identity");
				curr_holder_name		=	rs.getString("curr_holder_name");
				curr_mr_locn_yn			=	rs.getString("mr_locn_yn");

				if(file_no == null || file_no.equals("null"))file_no="";
				if(patient_id == null || patient_id.equals("null"))patient_id="";
				if(file_type_code == null || file_type_code.equals("null"))file_type_code="";
				if(volume_no == null || volume_no.equals("null"))volume_no="";
				if(patient_name == null || patient_name.equals("null"))patient_name="";
				if(fs_locn_disp == null || fs_locn_disp.equals("null"))fs_locn_disp="";
				if(curr_facility_id == null || curr_facility_id.equals("null"))curr_facility_id="";
				if(pat_details == null || pat_details.equals("null"))pat_details="";
				if(mr_pat_fs_locn_desc == null || mr_pat_fs_locn_desc.equals("null"))mr_pat_fs_locn_desc="";
				if(curr_fs_locn_desc == null || curr_fs_locn_desc.equals("null"))curr_fs_locn_desc="";
				if(other_locn_code == null || other_locn_code.equals("null"))other_locn_code="";
				if(doc_folder_id == null || doc_folder_id.equals("null"))doc_folder_id="";
				if(doc_type_code== null || doc_type_code.equals("null"))doc_type_code="";

				if(curr_fs_locn_identity == null || curr_fs_locn_identity.equals("null"))curr_fs_locn_identity="";
				if(curr_holder_name == null || curr_holder_name.equals("null"))curr_holder_name="";
				if(curr_mr_locn_yn == null || curr_mr_locn_yn.equals("null")) curr_mr_locn_yn="";

				htRecord	= new HashMap();

				htRecord.put("file_no"		        ,file_no);
				htRecord.put("patient_id"	        ,patient_id);
				htRecord.put("file_type_code"       ,file_type_code);
				htRecord.put("volume_no"		    ,volume_no);
				htRecord.put("doc_type_code"		,doc_type_code);
				htRecord.put("doc_folder_id"	    ,doc_folder_id);
				htRecord.put("patient_name"	        ,patient_name);				
				htRecord.put("associate_yn"	        ,associate_yn);
				htRecord.put("fn_locn_code"	        ,fn_locn_code);
				htRecord.put("locn_identity"	    ,locn_identity);
				htRecord.put("narration_code"	    ,narration_code);
				htRecord.put("holder_name"		    ,holder_name);
				htRecord.put("mr_locn_yn"		    ,mr_locn_yn);
				htRecord.put("fs_locn_disp"		    ,fs_locn_disp);
				htRecord.put("curr_facility_id"		,curr_facility_id);
				htRecord.put("pat_details"		    ,pat_details);
				htRecord.put("mr_pat_fs_locn_desc"  ,mr_pat_fs_locn_desc);
				htRecord.put("curr_fs_locn_desc"    ,curr_fs_locn_desc);
				htRecord.put("other_locn_code"      ,other_locn_code);
				htRecord.put("curr_fs_locn_identity",curr_fs_locn_identity);
				htRecord.put("curr_holder_name"     ,curr_holder_name);
				htRecord.put("curr_mr_locn_yn"      ,curr_mr_locn_yn);
				htRecord.put("file_type_desc"      ,file_type_desc);

				recordSet.putObject(htRecord);
			} if(rs != null) rs.close();

			if((result_query != null) && (result_query.length() > 0))
			{
				result_query.delete(0,result_query.length());
			}
			
			row_count	=	recordSet.getSize();
			fm_disp		=	0;
			to_disp		=	7;

			if(to_disp > (row_count-1)) to_disp = (row_count-1);
			
		
		}
		fm_disp =	start-1;
		to_disp	=	end-1;
		if(to_disp > (row_count-1)) to_disp=(row_count-1); 
		
%>
<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
		
	%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eFM/js/FMChangeStorageLocn.js'></script>
</head>
<body  onMouseDown='CodeArrest()' onLoad='checkAll(parent.frames[1].document.getElementById('locn_code'));' onKeyDown = 'lockKey();'>
<!-- <body  onLoad='dispRecord(); loadCurrPage();' onMouseDown='CodeArrest()' onKeyDown = 'lockKey();'> -->
<form name='FMChngStrLocnMainResultForm' id='FMChngStrLocnMainResultForm' action='../../eFM/jsp/FMChangeStorageLocnMainResult.jsp' method='post'>
<P>
<table align='right'>
<tr>
<td>
<%--
	Next
../jsp/FMChangeStorageLocnMainResult.jsp?from=<%=(start+11)%>&to=<%=(end+11)%>&mode=next&file_type_appl_yn=<%=file_type_appl_yn%>&fs_locn=<%=fs_locn%>

From

../jsp/FMChangeStorageLocnMainResult.jsp?from=<%=start-11%>&to=<%=end-11%>&mode=Previous&file_type_appl_yn=<%=file_type_appl_yn%>&fs_locn=<%=fs_locn%>

--%>
<%


if (!(start <= 1))
	{%>

	<A HREF='javascript:submitPrevNext("<%=start-11%>","<%=end-11%>","Previous","<%=file_type_appl_yn%>","<%=fs_locn%>");' text-decoration='none' ><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A>

<%	}
	if ( !( (start+11) > row_count ))
	{%>

	<A HREF='javascript:submitPrevNext("<%=(start+11)%>","<%=(end+11)%>","next","<%=file_type_appl_yn%>","<%=fs_locn%>");' text-decoration='none' ><fmt:message key="Common.next.label" bundle="${common_labels}"/></A>

	<%}
%>
</td>
</tr>
</table>
	<br><br>
</P>
<%	
	
if(curr_file_status.equals("L"))
		{ %>
 <script>
	var msg= "";
 var row_count="<%=row_count%>";   
	 if(row_count==0)
			{
   parent.frames[0].document.forms[0].status.value="true";
			}
	msg=getMessage('FILE_IS_LOST','FM');
	if(msg != "")
		{
	parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg+"&err_value=0";
			}	
	</script>

	<%	}else{

if(row_count==0 && (fileno.equals("") || fileno.equals("undefined")))
	{ %>
    <script>
	 parent.frames[0].document.forms[0].status.value="true";
	alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));
	</script>
	<%}else{
if((curr_file_status.equals("R") && file_creat_fac_id.equals(curr_facility_id1) ) || curr_file_status.equals("T"))
		{
	
	%>
	<script>			
			var destin= "<%=destination%>";
			var msg= "";
			var row_count="<%=row_count%>";
			msg=getMessage('FILE_IN_TRANSIT_CANNOT_PROCEED','FM');
			var msg1=" "+getLabel("Common.to.label","common") + " " + getLabel("Common.Location.label","common")+"-" + "<%=destination%>";
			msg=msg.replace('.',msg1);
			if(msg != "")
			{
			parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg+"&err_value=0";
			}			
		
		
		</script>
<%
	}else if(curr_file_status.equals("E") || curr_file_status.equals("O") || curr_file_status.equals("R"))	{

 if(!file_creat_fac_id.equals(facility_id))
			{
 %>
		<script>			
		var fs_locn="<%=fs_locn%>";
       var row_count="<%=row_count%>";
          var destin= "<%=destination%>";
			var fileno = "<%=fileno%>";
			var msg= "";
			var curr_file_status="<%=curr_file_status%>";
		
			 if(fs_locn=="P")
				{ 
			  
			   if(curr_file_status=="E" || curr_file_status=="R" )
					{
			    	
					 if(row_count==0)
					{
                  parent.frames[0].document.forms[0].status.value="true";
					}
					msg=getMessage('FILE_IN_TRANSIT_CANNOT_PROCEED','FM');
					var msg1=" "+getLabel("Common.to.label","common") + " " + getLabel("Common.Location.label","common")+"-" + "<%=destination%>"; 
			      msg=msg.replace('.',msg1);	
					}else{
			         if(row_count==0)
					{
                parent.frames[0].document.forms[0].status.value="true";
					}
					if(fileno=="undefined" || fileno=="" )
						{
                         msg="";
						}else{
					msg=getMessage('PERMANENT_F_SLOCN_CANNOT_CHANGE','FM');
					}
										
						}
				}
				
				 if(fs_locn=="C")
		        {
						
					if(curr_file_status=="E" || curr_file_status=="R" )
					{
			     					
					parent.frames[0].document.forms[0].status.value="true";
					msg=getMessage('FILE_IN_TRANSIT_CANNOT_PROCEED','FM');
					var msg1=" "+getLabel("Common.to.label","common") + " " + getLabel("Common.Location.label","common")+"-" + "<%=destination%>"; 
			      msg=msg.replace('.',msg1);	
					}else{

				if(row_count==0)
				{
				parent.frames[0].document.forms[0].status.value="true";
				alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));			
			}
				//parent.frames[1].document.location.href = "../../eCommon/html/blank.html"		
		
					}
					}
		//	var msg1=" "+getLabel("Common.to.label","common") + " " + getLabel("Common.Location.label","common")+"-" + "<%=destination%>";
		//	msg=msg.replace('.',msg1);
			if(msg != "")
			{
				parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg+"&err_value=0";
			}			
		</script>

<%   }else if(!file_creat_fac_id.equals(curr_facility_id1) && file_creat_fac_id.equals(facility_id)){
      %>
 <script>			
		var fs_locn="<%=fs_locn%>";
 
          var destin= "<%=destination%>";
			var msg= "";
			var curr_file_status="<%=curr_file_status%>";
		  var row_count ="<%=row_count%>";
			 if(fs_locn=="P")
				{ 
			   if(curr_file_status=="E" || curr_file_status=="R")
					{
				   					
					msg=getMessage('FILE_IN_TRANSIT_CANNOT_PROCEED','FM');
					var msg1=" "+getLabel("Common.to.label","common") + " " + getLabel("Common.Location.label","common")+"-" + "<%=destination%>"; 
			        msg=msg.replace('.',msg1);	
					}
				
				  }
				 if(fs_locn=="C")
		           {
				var fileno="<%=fileno%>"
				 
				 if(curr_file_status=="E" || curr_file_status=="R")
					{
								
					msg=getMessage('FILE_IN_TRANSIT_CANNOT_PROCEED','FM');
					var msg1=" "+getLabel("Common.to.label","common") + " " + getLabel("Common.Location.label","common")+"-" + "<%=destination%>"; 
			        msg=msg.replace('.',msg1);	
					}else{
                   
					  var added_temp1=((added_file_vol.Keys()).toArray()).toString();
					     if(row_count==0)
						{
                          parent.frames[0].document.forms[0].status.value="true";
						}else{
                         parent.frames[0].document.forms[0].status.value="remone";
						 parent.frames[0].document.forms[0].fileno.value="<%=fileno%>";
                         parent.frames[0].document.forms[0].volno.value="<%=volume_no1%>";
						}

					if(fileno=="undefined" || fileno=="" )
						{
                         msg="";
						}else{
					 msg=getMessage('CURRENT_FS_LOCN_CANNOT_CHANGE','FM');
					}
					
					
					}
			    }
				
				//	var msg1=" "+getLabel("Common.to.label","common") + " " + getLabel("Common.Location.label","common")+"-" + "<%=destination%>";
		//	msg=msg.replace('.',msg1);
			if(msg != "")
			{
				parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg+"&err_value=0";
			}			
		</script>
<%
}else {

if(row_count==0)
{
%>
<script>						
				
				parent.frames[0].document.forms[0].status.value="true";
				alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));			
				//parent.frames[1].document.location.href = "../../eCommon/html/blank.html"		
		     
		</script>
<%
}
}
	}else if(file_creat_fac_id.equals(facility_id) && curr_fs_locn_ident.equals("D"))
 	{
    if(curr_file_status.equals("I"))		
     {
   %>
		<script>			
			var fs_locn="<%=fs_locn%>";
            var destin= "<%=destination%>";
			 var fileno= "<%=fileno%>";
			var msg= "";
			//	var msg1=" "+getLabel("Common.to.label","common") + " " + getLabel("Common.Location.label","common")+"-" + "<%=destination%>";
		//	msg=msg.replace('.',msg1);
			if(fs_locn=="C")
				{ 
		if(fileno=="undefined" || fileno=="" )
						{
                         msg="";
						}else{
					 msg=getMessage('CURRENT_FS_LOCN_CANNOT_CHANGE','FM');
					}
					
			
				}
		
			if(msg != "")
			{
				parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg+"&err_value=0";
			}			
		</script>

<% }
		}else if(!file_creat_fac_id.equals(curr_facility_id1) && curr_fs_locn_ident.equals("D")){
    if(curr_file_status.equals("I"))		
     {
   %>
		<script>			
			var fs_locn="<%=fs_locn%>";
           var destin= "<%=destination%>";
			var fileno= "<%=fileno%>";
			var msg= "";
			if(fs_locn=="P")
				{ 
		      if(fileno=="undefined" || fileno=="")
						{
                         msg="";
						}else{
					msg=getMessage('PERMANENT_F_SLOCN_CANNOT_CHANGE','FM');
					}
							
				}
		
			if(msg != "")
			{
				parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg+"&err_value=0";
			}			
		</script>

<% }
		}else{

if(row_count == 0)
		{
    if(!file_creat_fac_id.equals(facility_id))
	 {  %>
     <script>		

	var fs_locn="<%=fs_locn%>";
	var row_count ="<%=row_count%>";
	 var fileno  ="<%=fileno %>";
	 if(fs_locn=="C")
				{ 
			 if(row_count==0)
			{
              parent.frames[0].document.forms[0].status.value="true";
			}
			if(fileno=="undefined" || fileno=="")
						{
                         msg="";
						}else{
					msg=getMessage('CURRENT_FS_LOCN_CANNOT_CHANGE','FM');
					}
							
			}else{
	         if(row_count==0)
			{
             parent.frames[0].document.forms[0].status.value="true";
		   }
	
	           if(fileno=="undefined" || fileno=="")
						{
                         msg="";
						}else{
					 msg=getMessage('PERMANENT_F_SLOCN_CANNOT_CHANGE','FM');
					}
	     
	}
		if(msg != "")
			{
				parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg+"&err_value=0";
			}	

</script>	
	<% }else{
	 
	 %>		
		<script>						
				
				parent.frames[0].document.forms[0].status.value="true";
				alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));			
				//parent.frames[1].document.location.href = "../../eCommon/html/blank.html"		
		        
		</script>
<%
			}
		}else
		{
    if(!file_creat_fac_id.equals(facility_id))
	 {  %>
     <script>		
   var fs_locn="<%=fs_locn%>";
	var row_count ="<%=row_count%>";
	 var fileno ="<%=fileno%>";
	 if(fs_locn=="C")
				{ 
			  if(row_count==0)
					{
                parent.frames[0].document.forms[0].status.value="true";
					}
			if(fileno=="undefined" || fileno=="")
						{
                         msg="";
						}else{
					msg=getMessage('CURRENT_FS_LOCN_CANNOT_CHANGE','FM');
					}
			
							
				}else{
	   if(row_count==0)
		{
         parent.frames[0].document.forms[0].status.value="true";
		}
	  
		if(fileno=="undefined" || fileno=="")
						{
                         msg="";
						}else{
					msg=getMessage('PERMANENT_F_SLOCN_CANNOT_CHANGE','FM');
					}
	 
	   
	}
		if(msg != "")
			{
				parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg+"&err_value=0";
			}	

</script>	
	<% }else{
	 if(row_count==0)
{
	 %>		
		<script>						
				parent.frames[0].document.forms[0].status.value="true";
				alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));			
				//parent.frames[1].document.location.href = "../../eCommon/html/blank.html"		
		        
		</script>
<%
			}
			}
		}
	}
}
		}
%>
<table cellpadding='0' cellspacing='0' border='1' width='100%'>
	<%
	/*if(fs_locn.equals("C")) 
		header="Current FS Location";
	else
	{
		header="Permanent FS Location";
	}*/
	if(row_count!=0){
	if(file_type_appl_yn.equals("N"))
	{
		%>
		<th width='40%' class='columnheader' style="text-align:left;"><fmt:message key="eFM.FileNoPatientDetails.label" bundle="${fm_labels}"/></th>
		<th width='6%' class='columnheader' style="text-align:left;"><fmt:message key="eFM.VolumeNo.label" bundle="${fm_labels}"/></th>
		<%
	}
	else if(file_type_appl_yn.equals("Y"))
	{
		%>
		<th width='40%' class='columnheader' style="text-align:left;"><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></th>
		<th width='8%' class='columnheader' style="text-align:left;"><fmt:message key="eFM.FileTypeVolumeNo.label" bundle="${fm_labels}"/></th>
		<%
	}
	%>
	<th width='12%' nowrap class='columnheader' style="text-align:left;"><fmt:message key="eFM.PermanentFSLocation.label" bundle="${fm_labels}"/></th> 
	<th width='12%' nowrap class='columnheader' style="text-align:left;"><fmt:message key="eFM.CurrentFSLocation.label" bundle="${fm_labels}"/></th>
	<th width='12%' class='columnheader' style="text-align:left;"><fmt:message key="eFM.FSLocation.label" bundle="${fm_labels}"/></th>
	<th width='6%' class='columnheader' style="text-align:left;"><fmt:message key="Common.change.label" bundle="${common_labels}"/>?</th>
	<%
	}
try
{
/*	Properties prop	=	new Properties();
	prop.put("fs_locn",fs_locn);
	prop.put("Statement",stmt1);
	prop.put("facility_id",facility_id);
	rs1	=	eFM.FMUtilities.getStorageLocn(prop);*/

	if(fs_locn.equals("P"))
	{
		dissable_attribute = "disabled";
	}
	  	
	for(int i=fm_disp; i<=to_disp; i++)
	{
		classValue			=	( (i%2)==0 )? "QRYODD" : "QRYEVEN";
		htRecord			=	(HashMap)	recordSet.getObject(i);
		file_no				=	(String)	htRecord.get("file_no");
		patient_id			=	(String)	htRecord.get("patient_id");
		file_type_code		=	(String)	htRecord.get("file_type_code");
		volume_no			=	(String)	htRecord.get("volume_no");		
		associate_yn		=	(String)	htRecord.get("associate_yn");
		fs_locn_disp		=	(String)	htRecord.get("fs_locn_disp");
		pat_details			=	(String)	htRecord.get("pat_details");
		mr_pat_fs_locn_desc	=	(String)	htRecord.get("mr_pat_fs_locn_desc");
		curr_fs_locn_desc	=	(String)	htRecord.get("curr_fs_locn_desc");
		other_locn_code		=	(String)	htRecord.get("other_locn_code");
         filevol_concat=file_no+volume_no;
		tblrow_id	=	"tblrow_id"+i;
   
        fslocn_type_old =(String)pat_file_code.get(filevol_concat);
		if(fslocn_type_old == null || fslocn_type_old.equals("null")) fslocn_type_old = "";		
						
		if(associate_yn.equals("Y"))
		{
			associate_yn_prop = "CHECKED";
		}
		else
		{
			associate_yn_prop = " ";
		}

		if (file_type_appl_yn.equals("N"))
		{
			%>
			<tr id='<%=tblrow_id%>'>
			<td class='<%=classValue%>' ><font size='1'><b><%=((file_no.equals(""))?"&nbsp;":file_no)%></b></font><br>&nbsp;&nbsp;<font size='1'><%=((pat_details.equals(""))?"&nbsp;":pat_details)%></font></td>

			<td class='<%=classValue%>' ><font 	size='1'><CENTER>
		<%
		}
		else if (file_type_appl_yn.equals("Y"))
		{
		%>
			<tr id='<%=tblrow_id%>'>
			<td class='<%=classValue%>' ><font size='1'>&nbsp;<font size='1'><%=((pat_details.equals(""))?"&nbsp;":pat_details)%></font></td>

			<td class='<%=classValue%>' ><font 	size='1'><CENTER>
			<%
			if(file_type_appl_yn.equals("Y"))
			{
				%>				
				<%=(String)	htRecord.get("file_type_desc")%>
				<%
			}
		}
		%>
			<%=((volume_no.equals(""))?"&nbsp;":volume_no)%></CENTER></font></td>

			<td class='<%=classValue%>' ><font size='1'><%=((mr_pat_fs_locn_desc.equals(""))?"&nbsp;":mr_pat_fs_locn_desc)%></font></td>
			<td class='<%=classValue%>' ><font size='1'><%=((curr_fs_locn_desc.equals(""))?"&nbsp;":curr_fs_locn_desc)%></font></td>
			<td class='<%=classValue%>' align='center'><select name='fs_locn_code<%=i%>' id='fs_locn_code<%=i%>' <%=dissable_attribute%> onChange='checkAssign(this, "<%=i%>");' onFocus='assignOnFocus(this);' ><option value=''>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option><%
		
		int len =keepRecord.size();
		if(len==0)
		{
			stmt2	=	con.createStatement();			
				
			if(fs_locn.equals("C"))
				{
					//sql_query="select fs_locn_code, short_desc from fm_storage_locn where facility_id='"+facility_id+"' and eff_status='E' order by short_desc";
					sql_query = "SELECT  fs_Locn_Code , Short_desc  FROM  FM_STORAGE_LOCN_LANG_VW WHERE Facility_Id = '"+facility_id+"'  AND LANGUAGE_ID='"+localeName+"'    AND eff_Status = 'E' ORDER BY  Short_desc ";

				}
				else
				{
					
					//sql_query="select fs_locn_code, short_desc from fm_storage_locn where facility_id='"+facility_id+"' and permanent_file_area_yn ='Y' and eff_status='E' order by short_desc";
					sql_query = "SELECT fs_Locn_Code  , Short_desc FROM FM_STORAGE_LOCN_LANG_VW WHERE Facility_Id = '"+facility_id+"' AND Permanent_File_Area_yn = 'Y'  AND LANGUAGE_ID='"+localeName+"'     AND eff_Status = 'E' ORDER BY	 Short_desc ";

				}

				rs1		=	stmt2.executeQuery(sql_query);
				while(rs1 != null && rs1.next())
				{
					fs_locn_code	=	rs1.getString("fs_locn_code");
					fs_desc			=	rs1.getString("short_desc");

					keepRecord.put(l,fs_locn_code);
					keepRecord1.put(l,fs_desc);
									
					if(!fs_locn_code.equals(fs_locn_disp))
					{
					if(fs_locn_code.equals(fslocn_type_old))
						{
					  selected="selected";
						out.println("<option value="+fs_locn_code+" "+selected+" >"+fs_desc+"</option>");
						associate_yn_prop = " CHECKED ";
						}else{
					out.println("<option value="+fs_locn_code+">"+fs_desc+"</option>");
						}
					}
				l++;
				}
		     }  else{  		
										
				for(int k=0 ;k<=len; k++)
			   {
				   old_fs_locn_code =(String) keepRecord.get(k);
			       old_fs_desc=(String)	keepRecord1.get(k);
			 			if(old_fs_locn_code==null)	old_fs_locn_code="";   
				       if(old_fs_desc==null)	old_fs_desc="";  
					 
				   
				   if(!old_fs_locn_code.equals(fs_locn_disp) && len>0)
					{
									
					if(old_fs_locn_code.equals(fslocn_type_old))
						{
						 selected="selected";
						out.println("<option value="+old_fs_locn_code+" "+selected+">"+old_fs_desc+"</option>");
						associate_yn_prop = " CHECKED ";
						}else{
					
					out.println("<option value="+old_fs_locn_code+">"+old_fs_desc+"</option>");	
				   }
					}
				}
	        		
	}			
				if(rs1 != null) rs1.close();
				if(stmt2  != null) stmt2.close();
				%>
			</select><input type='hidden' name='default_code<%=i%>' id='default_code<%=i%>' value='<%=fs_locn_disp%>'>
			<input type='hidden' name='other_code<%=i%>' id='other_code<%=i%>' value='<%=other_locn_code%>'>
				<input type='hidden' name='file_no<%=i%>' id='file_no<%=i%>' value='<%=file_no%>'>
				<input type='hidden' name='volume_no<%=i%>' id='volume_no<%=i%>' value='<%=volume_no%>'>
			</td>
		<td class='<%=classValue%>' align='center'><input type='checkbox'  name='associate_yn<%=i%>' id='associate_yn<%=i%>' <%=associate_yn_prop%> value='Y' <%=dissable_attribute%> onClick='CBValue(this,"<%=i%>");'></td>
		</tr>
	<!--	<script>			
				var val='<%=i%>';
			eval('document.forms[0].fs_locn_code'+val).value='<%=fslocn_type_old%>';
		eval('document.forms[0].associate_yn'+val).checked=true;
		</script>	 -->
		<%
		}
		%>
			<script>			
				parent.frames[0].document.forms[0].patient_id.disabled=false;
				parent.frames[0].document.forms[0].pat_search.disabled=false;	parent.frames[0].document.forms[0].terminal_digit.disabled=false;
				if(parent.frames[0].document.forms[0].file_no != null)
				parent.frames[0].document.forms[0].file_no.disabled=false;
				if(parent.frames[0].document.forms[0].file_type_code != null)
				parent.frames[0].document.forms[0].file_type_code.disabled=false;
				parent.frames[0].document.forms[0].fs_locn_code.disabled=false;
				parent.frames[0].document.forms[0].tdlocn.disabled=false;
				parent.frames[0].document.forms[0].file_date.disabled=false;
				parent.frames[0].document.forms[0].search_dtl.disabled=false;
				parent.frames[0].document.forms[0].reset1.disabled=false;
				parent.frames[0].document.forms[0].row_cnt.value='<%=row_count%>';
			</script>		
		<%
	}
	catch(Exception e)
	{
		out.println("Exception@2: "+e);
		e.printStackTrace();
	}
%>
</table>
<input type='hidden' name='row_count' id='row_count' value='<%=row_count%>'>
<input type='hidden' name='whereClause' id='whereClause' value="<%=str%>">
<input type='hidden' name='fm_disp' id='fm_disp' value='<%=fm_disp%>'>
<input type='hidden' name='to_disp' id='to_disp' value='<%=to_disp%>'>
<input type='hidden' name='from_1' id='from_1' value='<%=from%>'>
<input type='hidden' name='to_1' id='to_1' value='<%=to%>'>
<input type='hidden' name='fs_locn' id='fs_locn' value='<%=fs_locn%>'>
<input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id1%>'>
<input type='hidden' name='file_type_appl_yn' id='file_type_appl_yn' value='<%=file_type_appl_yn%>'>


</form>
<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script language="JavaScript">

parent.parent.frames[1].frames[0].document.forms[0].patient_id.value='';
parent.parent.frames[1].frames[0].document.getElementById('patientid1').onblur();
parent.parent.frames[1].frames[0].document.forms[0].patient_id.focus();
</script>
<%
	if(rs1 != null) rs1.close();
	if(rs != null) rs.close();
	if(stmt != null) stmt.close();
	if(stmt1 != null) stmt1 = null;
	if(stmt2 != null) stmt2.close();
}
catch(Exception e)
{
	out.println("Exception in fetching connection"+e.toString());
	e.printStackTrace();
}
finally
{	
	ConnectionManager.returnConnection(con,request);
//session.setAttribute("recordSet", recordSet);
}
%>
</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

