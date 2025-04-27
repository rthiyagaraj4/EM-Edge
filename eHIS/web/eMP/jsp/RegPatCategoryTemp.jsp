<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8"  import="java.sql.*, webbeans.eCommon.*, java.util.*, java.text.*, java.net.*" %>
<jsp:useBean id="obj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<%
	/*Function called to Load Patient categories based on Membership Type, Org ID, Sub OrgID and Name Prefix*/
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	Hashtable hash = null;

	String family_org_membership = "";
	String family_org_id = "";
	String family_org_sub_id = "";
	String name_prefix =  "";
	String selected_sub = "";
	String relationship_to_head = "";
	String alt_id1_no = "";
	String patCatDB = "";
	String exp_val_appl_yn = "N";
	String visibility = "hidden";
	String code	= "";
	String desc	= "";
	
    StringBuffer sql = new StringBuffer("");   
	StringBuffer where_clause = new StringBuffer();
	String main_sql = "";
	String temp_sql = "";
	//String defaultSelect		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	int maxrecord = 0;
	try
	{
		request.setCharacterEncoding("UTF-8");
		con = ConnectionManager.getConnection(request);
		stmt = con.createStatement();

		hash = (Hashtable)obj.parseXMLString( request ) ;
		hash = (Hashtable)hash.get("SEARCH") ;
			
		family_org_membership		= (String) hash.get("family_org_membership");
		family_org_id					= (String) hash.get("org_id");
		family_org_sub_id				= (String) hash.get("sub_organization");
		name_prefix						= (String) hash.get("name_prefix");
		selected_sub					= (String) hash.get("selected_sub");
		relationship_to_head			= (String) hash.get("relationship_to_head");
		alt_id1_no						= (String) hash.get("alt_id1_no");
		patCatDB						= (String) hash.get("patCatDB");

		Statement stmt1 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		%>
		if (document.forms[0].pat_cat_code)
		{
			document.forms[0].pat_cat_code.value="";
		}
		if (document.forms[0].pat_cat_desc)
		{
			document.forms[0].pat_cat_desc.value="";
		}
		<%
			
		if (family_org_membership.equals("1"))
		{
		    main_sql = "select distinct a.pat_cat_code, b.short_desc patcategory, b.exp_val_appl_yn from  mp_pat_category_deriv_rule a,mp_pat_category b where a.pat_cat_code=b.pat_cat_code and a.membership_type='1' ";

			temp_sql = "select distinct a.pat_cat_code code, b.short_desc description from mp_pat_category_deriv_rule a,mp_pat_category b where a.pat_cat_code=b.pat_cat_code and a.membership_type='1' AND UPPER(a.PAT_CAT_CODE) LIKE UPPER(?) AND UPPER(b.short_desc) LIKE UPPER(?)"; 

			where_clause.append("and a.family_org_id = '"+family_org_id+"' and a.name_prefix='"+singleToDoubleQuotes(name_prefix)+"' and a.family_org_sub_id ='"+family_org_sub_id+"'  and a.relationship_code = '"+relationship_to_head+"'"); 			

		
			rs=stmt1.executeQuery((main_sql+where_clause.toString()));
			
			rs.last();
			maxrecord = rs.getRow();
			rs.beforeFirst();
			if(maxrecord<=0)
            {
				where_clause.delete(0,where_clause.length());
											
				if (!family_org_id.equals(""))
					where_clause.append(" and a.family_org_id = '"+family_org_id+"' ");
				if (!name_prefix.equals(""))
					where_clause.append(" and a.name_prefix='"+singleToDoubleQuotes(name_prefix)+"' ");
				 
				where_clause.append(" and a.family_org_sub_id ='"+family_org_sub_id+"'  ");
				 
				where_clause.append(" and a.relationship_code = '"+relationship_to_head+"'");
				if(rs != null) rs.close();
				rs=stmt1.executeQuery(main_sql+where_clause.toString());
				rs.last();
				maxrecord = rs.getRow();
				rs.beforeFirst();

						if(maxrecord<=0)
						{
							where_clause.delete(0,where_clause.length());
					 		if (!family_org_id.equals(""))
								where_clause.append(" and a.family_org_id = '"+family_org_id+"' ");
							if (!name_prefix.equals(""))
								where_clause.append(" and a.name_prefix='"+singleToDoubleQuotes(name_prefix)+"' ");
							 
							where_clause.append(" and a.family_org_sub_id ='"+family_org_sub_id+"'  ");
							 
							where_clause.append(" and a.relationship_code = '*ALL'");
							if(rs != null) rs.close();
							rs=stmt1.executeQuery(main_sql+where_clause.toString());
							rs.last();
							maxrecord = rs.getRow();
							rs.beforeFirst();
							if(maxrecord<=0)
							{
								where_clause.delete(0,where_clause.length());
								if (!family_org_id.equals(""))
									where_clause.append(" and a.family_org_id = '"+family_org_id+"' ");					 
								where_clause.append(" and a.family_org_sub_id ='"+family_org_sub_id+"'  ");
					 
 								where_clause.append(" and a.name_prefix = '*ALL' ");
								where_clause.append(" and a.relationship_code = '"+relationship_to_head+"' ");
								if(rs != null) rs.close();
								rs=stmt1.executeQuery((main_sql+where_clause.toString()));
							    rs.last();
							    maxrecord = rs.getRow();
							    rs.beforeFirst();
								if(maxrecord<=0)
								{
									where_clause.delete(0,where_clause.length());
									if (!family_org_id.equals(""))
										sql.append(" and a.family_org_id = '"+family_org_id+"' "); 				
									where_clause.append(" and a.family_org_sub_id ='"+family_org_sub_id+"'  ");			 
 									where_clause.append(" and a.name_prefix = '*ALL' ");
									where_clause.append(" and a.relationship_code = '*ALL'");
									if(rs != null) rs.close();
									rs=stmt1.executeQuery(main_sql+where_clause.toString());
									rs.last();
									maxrecord = rs.getRow();
									rs.beforeFirst();
									if(maxrecord<=0)
									{
										where_clause.delete(0,where_clause.length());
										if (!family_org_id.equals(""))
											where_clause.append(" and a.family_org_id = '"+family_org_id+"' ");
					 
										where_clause.append(" and a.family_org_sub_id = '*ALL'  ");
					
 										where_clause.append("and a.name_prefix='"+singleToDoubleQuotes(name_prefix)+"' ");
										where_clause.append(" and a.relationship_code = '"+relationship_to_head+"'");
										if(rs != null) rs.close();
										rs=stmt1.executeQuery(main_sql+where_clause.toString());
										rs.last();
										maxrecord = rs.getRow();
										rs.beforeFirst();
										if(maxrecord<=0)
										{
											where_clause.delete(0,where_clause.length());
						 
											if (!family_org_id.equals(""))
												where_clause.append(" and a.family_org_id = '"+family_org_id+"' ");
											 
											where_clause.append(" and a.family_org_sub_id = '*ALL'  ");
											 
											where_clause.append("and a.name_prefix='"+singleToDoubleQuotes(name_prefix)+"' ");
											where_clause.append(" and a.relationship_code = '*ALL'");

											if(rs != null) rs.close();
											rs=stmt1.executeQuery(main_sql+where_clause.toString());
											rs.last();
											maxrecord = rs.getRow();
											rs.beforeFirst();
											if(maxrecord<=0)
											{
												where_clause.delete(0,where_clause.length());
						
												 if (!family_org_id.equals(""))
													 where_clause.append("and a.family_org_id = '"+family_org_id+"'");
												
													 where_clause.append(" and a.family_org_sub_id = '*ALL'");
												
												 where_clause.append("and a.name_prefix = '*ALL' ");
												 where_clause.append(" and a.relationship_code = '"+relationship_to_head+"' ");
												 if(rs != null) rs.close();
												 rs=stmt1.executeQuery(main_sql+where_clause.toString());
												 rs.last();
												 maxrecord = rs.getRow();
												 rs.beforeFirst();
												 if(maxrecord<=0)
												 {
													 where_clause.delete(0,where_clause.length());

													 if (!family_org_id.equals(""))
														 where_clause.append(" and a.family_org_id = '"+family_org_id+"' ");
													 if (!family_org_sub_id.equals(""))
														 where_clause.append(" and a.family_org_sub_id = '*ALL'  ");
													
													 where_clause.append("and a.name_prefix = '*ALL' ");
													 where_clause.append(" and a.relationship_code = '*ALL' ");
													 if(rs != null) rs.close();
													 rs=stmt1.executeQuery(main_sql+where_clause.toString());
													 rs.last();
													 maxrecord = rs.getRow();
													 rs.beforeFirst();
													 if(maxrecord<=0)
													 {
														 where_clause.delete(0,where_clause.length());

														 if (!family_org_id.equals(""))
															 where_clause.append(" and a.family_org_id = '*ALL' ");
														 where_clause.append(" and a.family_org_sub_id ='"+family_org_sub_id+"' ");
														 where_clause.append(" and a.name_prefix='"+singleToDoubleQuotes(name_prefix)+"' ");
														 where_clause.append(" and a.relationship_code = '"+relationship_to_head+"' ");
														 if(rs != null) rs.close();
														 rs=stmt1.executeQuery(main_sql+where_clause.toString());
														 rs.last();
														 maxrecord = rs.getRow();
														 rs.beforeFirst();
													if(maxrecord<=0)
													{
														where_clause.delete(0,where_clause.length());
														if (!family_org_id.equals(""))
																where_clause.append(" and a.family_org_id = '*ALL' ");
														where_clause.append(" and a.family_org_sub_id ='"+family_org_sub_id+"' ");
														where_clause.append(" and a.name_prefix='"+singleToDoubleQuotes(name_prefix)+"' ");
														where_clause.append(" and a.relationship_code = '*ALL' ");
														if(rs != null) rs.close();
														rs=stmt1.executeQuery(main_sql+where_clause.toString());
														rs.last();
														maxrecord = rs.getRow();
														rs.beforeFirst();

														if(maxrecord<=0)
														{
															
															where_clause.delete(0,where_clause.length());
															if (!family_org_id.equals(""))
																where_clause.append(" and a.family_org_id = '*ALL' ");
															where_clause.append(" and a.family_org_sub_id ='"+family_org_sub_id+"' ");
															where_clause.append(" and a.name_prefix = '*ALL' ");
															where_clause.append(" and a.relationship_code = '"+relationship_to_head+"' ");
															if(rs != null) rs.close();
															rs=stmt1.executeQuery(main_sql+where_clause.toString());
															rs.last();
															maxrecord = rs.getRow();
															rs.beforeFirst();
															if(maxrecord<=0){
																
																where_clause.delete(0,where_clause.length());
							  
															if (!family_org_id.equals(""))
																 where_clause.append(" and a.family_org_id = '*ALL' ");
															where_clause.append(" and a.family_org_sub_id ='"+family_org_sub_id+"' ");
															where_clause.append(" and a.name_prefix = '*ALL' ");
															where_clause.append(" and a.relationship_code = '*ALL' ");
															if(rs != null) rs.close();
															rs=stmt1.executeQuery(main_sql+where_clause.toString());
															rs.last();
															maxrecord = rs.getRow();
															rs.beforeFirst();
                          if(maxrecord<=0)
						  {
							 where_clause.delete(0,where_clause.length()); 
						 if (!family_org_id.equals(""))
							 where_clause.append(" and a.family_org_id = '*ALL' ");
						 where_clause.append(" and a.family_org_sub_id = '*ALL' ");
						 where_clause.append(" and a.name_prefix='"+singleToDoubleQuotes(name_prefix)+"' ");
						 where_clause.append(" and a.relationship_code = '"+relationship_to_head+"' ");
						if(rs != null) rs.close();
						rs=stmt1.executeQuery(main_sql+where_clause.toString());
						rs.last();
						maxrecord = rs.getRow();
						rs.beforeFirst();
						if(maxrecord<=0){
							where_clause.delete(0,where_clause.length()); 	
						 if (!family_org_id.equals(""))
							 where_clause.append(" and a.family_org_id = '*ALL' ");
						 where_clause.append(" and a.family_org_sub_id = '*ALL' ");
						 where_clause.append(" and a.name_prefix='"+singleToDoubleQuotes(name_prefix)+"' ");
						 where_clause.append(" and a.relationship_code = '*ALL' ");
						 if(rs != null) rs.close();
						 rs=stmt1.executeQuery(main_sql+where_clause.toString());
						 rs.last();
						 maxrecord = rs.getRow();
						 rs.beforeFirst();
                         if(maxrecord<=0) 
						 {
							where_clause.delete(0,where_clause.length()); 		 
							if (!family_org_id.equals(""))
								 where_clause.append(" and a.family_org_id = '*ALL' ");
							where_clause.append(" and a.family_org_sub_id = '*ALL' ");
							where_clause.append(" and a.name_prefix = '*ALL' ");
							where_clause.append(" and a.relationship_code = '"+relationship_to_head+"' ");
							if(rs != null) rs.close();
							rs=stmt1.executeQuery(main_sql+where_clause.toString());
							rs.last();
							maxrecord = rs.getRow();
							rs.beforeFirst();

						 if(maxrecord<=0)
						 {
							 where_clause.delete(0,where_clause.length()); 							  
							  
							 where_clause.append("and a.family_org_id = '*ALL' and a.name_prefix = '*ALL' and a.family_org_sub_id = '*ALL'  and a.relationship_code = '*ALL' ");
							  
							 rs=stmt1.executeQuery(main_sql+where_clause.toString());
							 rs.last();
							 maxrecord = rs.getRow();
							 rs.beforeFirst();
					      }
					     }
					    }
					   }
					  }
					 }
				    }
				   }
				  }
				 }
				}
			   }
			  }
			 }
			}
		   }    

		    if(maxrecord == 1)
			{
				  rs.next();
				  desc = checkForNull(rs.getString("patcategory"));
				  code = checkForNull(rs.getString("PAT_CAT_CODE"));  
 				  if (!(patCatDB.equals("")) && (patCatDB.equals(code)) )
					  exp_val_appl_yn = 	 checkForNull(rs.getString("exp_val_appl_yn"));
				  %>
					   document.forms[0].pat_cat_code.value="<%=code%>";
					   document.forms[0].pat_cat_desc.value="<%=desc%>";
				<%
			}
				temp_sql = temp_sql+where_clause.toString();
				
			%>
				document.forms[0].pat_cat_sql.value="<%=temp_sql%>";
			<%

		}
		else
		if ( (family_org_membership.equals("2")) || (family_org_membership.equals("3")) )
		{
			String tsql1="select name_prefix,family_org_membership,family_org_sub_id,family_org_id,relationship_to_head from mp_patient where family_org_membership='1' and alt_id1_no='"+alt_id1_no+"'";
			rs=stmt.executeQuery(tsql1);
			if(rs.next())
			{
			  family_org_sub_id=checkForNull(rs.getString("family_org_sub_id"));
			  family_org_id=checkForNull(rs.getString("family_org_id"));
			}
			if(rs != null) rs.close();	

			main_sql = "select distinct a.pat_cat_code, b.short_desc patcategory, b.exp_val_appl_yn from  mp_pat_category_deriv_rule a,mp_pat_category b where a.pat_cat_code=b.pat_cat_code and (a.membership_type='2' or a.membership_type='3') ";

			temp_sql = "select distinct a.pat_cat_code code, b.short_desc description from mp_pat_category_deriv_rule a,mp_pat_category b where a.pat_cat_code=b.pat_cat_code and (a.membership_type='2' or a.membership_type='3') AND UPPER(a.PAT_CAT_CODE) LIKE UPPER(?) AND UPPER(b.short_desc) LIKE UPPER(?)"; 

			where_clause.append("and a.family_org_id = '"+family_org_id+"' and a.name_prefix='"+singleToDoubleQuotes(name_prefix)+"' and a.family_org_sub_id ='"+family_org_sub_id+"'  and a.relationship_code = '"+relationship_to_head+"'"); 			

			
			rs=stmt1.executeQuery(main_sql+where_clause.toString());
		
			rs.last();
			maxrecord = rs.getRow();
			rs.beforeFirst();
			if(maxrecord<=0)
            {
				where_clause.delete(0,where_clause.length());
											
				if (!family_org_id.equals(""))
					where_clause.append(" and a.family_org_id = '"+family_org_id+"' ");
				if (!name_prefix.equals(""))
					where_clause.append(" and a.name_prefix='"+singleToDoubleQuotes(name_prefix)+"' ");
				 
				where_clause.append(" and a.family_org_sub_id ='"+family_org_sub_id+"'  ");
				 
				where_clause.append(" and a.relationship_code = '"+relationship_to_head+"'");
				if(rs != null) rs.close();
				rs=stmt1.executeQuery(main_sql+where_clause.toString());
				rs.last();
				maxrecord = rs.getRow();
				rs.beforeFirst();

						if(maxrecord<=0)
						{
							where_clause.delete(0,where_clause.length());
					 		if (!family_org_id.equals(""))
								where_clause.append(" and a.family_org_id = '"+family_org_id+"' ");
							if (!name_prefix.equals(""))
								where_clause.append(" and a.name_prefix='"+singleToDoubleQuotes(name_prefix)+"' ");
							 
							where_clause.append(" and a.family_org_sub_id ='"+family_org_sub_id+"'  ");
							 
							where_clause.append(" and a.relationship_code = '*ALL'");
							if(rs != null) rs.close();
							rs=stmt1.executeQuery(main_sql+where_clause.toString());
							rs.last();
							maxrecord = rs.getRow();
							rs.beforeFirst();
							if(maxrecord<=0)
							{
								where_clause.delete(0,where_clause.length());
								if (!family_org_id.equals(""))
									where_clause.append(" and a.family_org_id = '"+family_org_id+"' ");					 
								where_clause.append(" and a.family_org_sub_id ='"+family_org_sub_id+"'  ");
					 
 								where_clause.append(" and a.name_prefix = '*ALL' ");
								where_clause.append(" and a.relationship_code = '"+relationship_to_head+"' ");
								if(rs != null) rs.close();
								rs=stmt1.executeQuery(main_sql+where_clause.toString());
							    rs.last();
							    maxrecord = rs.getRow();
							    rs.beforeFirst();
								if(maxrecord<=0)
								{
									where_clause.delete(0,where_clause.length());
									if (!family_org_id.equals(""))
										sql.append(" and a.family_org_id = '"+family_org_id+"' "); 				
									where_clause.append(" and a.family_org_sub_id ='"+family_org_sub_id+"'  ");			 
 									where_clause.append(" and a.name_prefix = '*ALL' ");
									where_clause.append(" and a.relationship_code = '*ALL'");
									if(rs != null) rs.close();
									rs=stmt1.executeQuery(main_sql+where_clause.toString());
									rs.last();
									maxrecord = rs.getRow();
									rs.beforeFirst();
									if(maxrecord<=0)
									{
										where_clause.delete(0,where_clause.length());
										if (!family_org_id.equals(""))
											where_clause.append(" and a.family_org_id = '"+family_org_id+"' ");
					 
										where_clause.append(" and a.family_org_sub_id = '*ALL'  ");
					
 										where_clause.append("and a.name_prefix='"+singleToDoubleQuotes(name_prefix)+"' ");
										where_clause.append(" and a.relationship_code = '"+relationship_to_head+"'");
										if(rs != null) rs.close();
										rs=stmt1.executeQuery(main_sql+where_clause.toString());
										rs.last();
										maxrecord = rs.getRow();
										rs.beforeFirst();
										if(maxrecord<=0)
										{
											where_clause.delete(0,where_clause.length());
						 
											if (!family_org_id.equals(""))
												where_clause.append(" and a.family_org_id = '"+family_org_id+"' ");
											 
											where_clause.append(" and a.family_org_sub_id = '*ALL'  ");
											 
											where_clause.append("and a.name_prefix='"+singleToDoubleQuotes(name_prefix)+"' ");
											where_clause.append(" and a.relationship_code = '*ALL'");

											if(rs != null) rs.close();
											rs=stmt1.executeQuery(main_sql+where_clause.toString());
											rs.last();
											maxrecord = rs.getRow();
											rs.beforeFirst();
											if(maxrecord<=0)
											{
												where_clause.delete(0,where_clause.length());
						
												 if (!family_org_id.equals(""))
													 where_clause.append("and a.family_org_id = '"+family_org_id+"'");
												
													 where_clause.append(" and a.family_org_sub_id = '*ALL'");
												
												 where_clause.append("and a.name_prefix = '*ALL' ");
												 where_clause.append(" and a.relationship_code = '"+relationship_to_head+"' ");
												 if(rs != null) rs.close();
												 rs=stmt1.executeQuery(main_sql+where_clause.toString());
												 rs.last();
												 maxrecord = rs.getRow();
												 rs.beforeFirst();
												 if(maxrecord<=0)
												 {
													 where_clause.delete(0,where_clause.length());

													 if (!family_org_id.equals(""))
														 where_clause.append(" and a.family_org_id = '"+family_org_id+"' ");
													 if (!family_org_sub_id.equals(""))
														 where_clause.append(" and a.family_org_sub_id = '*ALL'  ");
													
													 where_clause.append("and a.name_prefix = '*ALL' ");
													 where_clause.append(" and a.relationship_code = '*ALL' ");
													 if(rs != null) rs.close();
													 rs=stmt1.executeQuery(main_sql+where_clause.toString());
													 rs.last();
													 maxrecord = rs.getRow();
													 rs.beforeFirst();
													 if(maxrecord<=0)
													 {
														 where_clause.delete(0,where_clause.length());

														 if (!family_org_id.equals(""))
															 where_clause.append(" and a.family_org_id = '*ALL' ");
														 where_clause.append(" and a.family_org_sub_id ='"+family_org_sub_id+"' ");
														 where_clause.append(" and a.name_prefix='"+singleToDoubleQuotes(name_prefix)+"' ");
														 where_clause.append(" and a.relationship_code = '"+relationship_to_head+"' ");
														 if(rs != null) rs.close();
														 rs=stmt1.executeQuery(main_sql+where_clause.toString());
														 rs.last();
														 maxrecord = rs.getRow();
														 rs.beforeFirst();
													if(maxrecord<=0)
													{
														where_clause.delete(0,where_clause.length());
														if (!family_org_id.equals(""))
																where_clause.append(" and a.family_org_id = '*ALL' ");
														where_clause.append(" and a.family_org_sub_id ='"+family_org_sub_id+"' ");
														where_clause.append(" and a.name_prefix='"+singleToDoubleQuotes(name_prefix)+"' ");
														where_clause.append(" and a.relationship_code = '*ALL' ");
														if(rs != null) rs.close();
														rs=stmt1.executeQuery(main_sql+where_clause.toString());
														rs.last();
														maxrecord = rs.getRow();
														rs.beforeFirst();

														if(maxrecord<=0)
														{
															
															where_clause.delete(0,where_clause.length());
															if (!family_org_id.equals(""))
																where_clause.append(" and a.family_org_id = '*ALL' ");
															where_clause.append(" and a.family_org_sub_id ='"+family_org_sub_id+"' ");
															where_clause.append(" and a.name_prefix = '*ALL' ");
															where_clause.append(" and a.relationship_code = '"+relationship_to_head+"' ");
															if(rs != null) rs.close();
															rs=stmt1.executeQuery(main_sql+where_clause.toString());
															rs.last();
															maxrecord = rs.getRow();
															rs.beforeFirst();
															if(maxrecord<=0){
																
																where_clause.delete(0,where_clause.length());
							  
															if (!family_org_id.equals(""))
																 where_clause.append(" and a.family_org_id = '*ALL' ");
															where_clause.append(" and a.family_org_sub_id ='"+family_org_sub_id+"' ");
															where_clause.append(" and a.name_prefix = '*ALL' ");
															where_clause.append(" and a.relationship_code = '*ALL' ");
															if(rs != null) rs.close();
															rs=stmt1.executeQuery(main_sql+where_clause.toString());
															rs.last();
															maxrecord = rs.getRow();
															rs.beforeFirst();
                          if(maxrecord<=0)
						  {
							 where_clause.delete(0,where_clause.length()); 
						 if (!family_org_id.equals(""))
							 where_clause.append(" and a.family_org_id = '*ALL' ");
						 where_clause.append(" and a.family_org_sub_id = '*ALL' ");
						 where_clause.append(" and a.name_prefix='"+singleToDoubleQuotes(name_prefix)+"' ");
						 where_clause.append(" and a.relationship_code = '"+relationship_to_head+"' ");
						if(rs != null) rs.close();
						rs=stmt1.executeQuery(main_sql+where_clause.toString());
						rs.last();
						maxrecord = rs.getRow();
						rs.beforeFirst();
						if(maxrecord<=0){
							where_clause.delete(0,where_clause.length()); 	
						 if (!family_org_id.equals(""))
							 where_clause.append(" and a.family_org_id = '*ALL' ");
						 where_clause.append(" and a.family_org_sub_id = '*ALL' ");
						 where_clause.append(" and a.name_prefix='"+singleToDoubleQuotes(name_prefix)+"' ");
						 where_clause.append(" and a.relationship_code = '*ALL' ");
						 if(rs != null) rs.close();
						 rs=stmt1.executeQuery(main_sql+where_clause.toString());
						 rs.last();
						 maxrecord = rs.getRow();
						 rs.beforeFirst();
                         if(maxrecord<=0) 
						 {
							where_clause.delete(0,where_clause.length()); 		 
							if (!family_org_id.equals(""))
								 where_clause.append(" and a.family_org_id = '*ALL' ");
							where_clause.append(" and a.family_org_sub_id = '*ALL' ");
							where_clause.append(" and a.name_prefix = '*ALL' ");
							where_clause.append(" and a.relationship_code = '"+relationship_to_head+"' ");
							if(rs != null) rs.close();
							rs=stmt1.executeQuery(main_sql+where_clause.toString());
							rs.last();
							maxrecord = rs.getRow();
							rs.beforeFirst();

						 if(maxrecord<=0)
						 {
							 where_clause.delete(0,where_clause.length()); 							  
							  
							 where_clause.append("and a.family_org_id = '*ALL' and a.name_prefix = '*ALL' and a.family_org_sub_id = '*ALL'  and a.relationship_code = '*ALL' ");
							  
							 rs=stmt1.executeQuery(main_sql+where_clause.toString());
							 rs.last();
							 maxrecord = rs.getRow();
							 rs.beforeFirst();
					      }
					     }
					    }
					   }
					  }
					 }
				    }
				   }
				  }
				 }
				}
			   }
			  }
			 }
			}
		   }    

		    if(maxrecord == 1)
			{
				  rs.next();
				  desc = checkForNull(rs.getString("patcategory"));
				  code = checkForNull(rs.getString("PAT_CAT_CODE"));  
 				  if (!(patCatDB.equals("")) && (patCatDB.equals(code)) )
					  exp_val_appl_yn = 	 checkForNull(rs.getString("exp_val_appl_yn"));
				  %>
					   document.forms[0].pat_cat_code.value="<%=code%>";
					   document.forms[0].pat_cat_desc.value="<%=desc%>";
				<%
			}
				temp_sql = temp_sql+where_clause.toString();
				
			%>
				document.forms[0].pat_cat_sql.value="<%=temp_sql%>";
			<%
	  }
	  else
	  if ( family_org_membership.equals("4")) 
	   {
			 main_sql = "select distinct a.PAT_CAT_CODE,b.short_desc patcategory,b.exp_val_appl_yn from mp_pat_category_deriv_rule a,mp_pat_category b where a.pat_cat_code=b.pat_cat_code and a.MEMBERSHIP_TYPE='4' and a.FAMILY_ORG_ID = '*NA' and a.FAMILY_ORG_SUB_ID = '*NA'  and a.RELATIONSHIP_CODE = '*ALL'";

			 temp_sql = "SELECT distinct a.PAT_CAT_CODE code, b.short_desc description FROM mp_pat_category_deriv_rule a,mp_pat_category b WHERE a.pat_cat_code=b.pat_cat_code AND a.MEMBERSHIP_TYPE='4' and a.FAMILY_ORG_ID = '*NA' AND UPPER(a.PAT_CAT_CODE) LIKE UPPER(?) AND UPPER(b.short_desc) LIKE UPPER(?) AND a.FAMILY_ORG_SUB_ID = '*NA'  and a.RELATIONSHIP_CODE = '*ALL'";
		
			 rs=stmt1.executeQuery(main_sql);
			 int cnt = 0;
			 rs.last();
			 maxrecord = rs.getRow();			  
			 rs.beforeFirst();
			 if(maxrecord>0) {
				 if(maxrecord==1) {				
					while(rs.next()) {
						cnt++;
						desc = checkForNull(rs.getString("patcategory"));
						code = checkForNull(rs.getString("PAT_CAT_CODE"));				  
						if (!(patCatDB.equals("")) && (patCatDB.equals(code)) )
							exp_val_appl_yn = 	 checkForNull(rs.getString("exp_val_appl_yn"));
				  %>
					   document.forms[0].pat_cat_code.value="<%=code%>";
					   document.forms[0].pat_cat_desc.value="<%=desc%>"; 					 
				  <%
					}				  
				 }
			 } else {
				
				main_sql = "select a.PAT_CAT_CODE,b.short_desc patcategory,b.exp_val_appl_yn from mp_pat_category_deriv_rule a,mp_pat_category b where a.pat_cat_code=b.pat_cat_code and a.MEMBERSHIP_TYPE='4' and a.FAMILY_ORG_ID ='*NA' and a.FAMILY_ORG_SUB_ID = '*NA' and a.RELATIONSHIP_CODE = '*ALL' order by b.short_desc"; 
				
				temp_sql = "select distinct a.PAT_CAT_CODE code,b.short_desc description from mp_pat_category_deriv_rule a,mp_pat_category b where a.pat_cat_code=b.pat_cat_code and a.MEMBERSHIP_TYPE='4' and a.FAMILY_ORG_ID ='*NA' AND UPPER(a.PAT_CAT_CODE) LIKE UPPER(?) AND UPPER(b.short_desc) LIKE UPPER(?) and a.FAMILY_ORG_SUB_ID = '*NA' and a.RELATIONSHIP_CODE = '*ALL'"; 

				rs=stmt1.executeQuery(main_sql);
				rs.last();
				maxrecord = rs.getRow();
				rs.beforeFirst();

				if(maxrecord == 1)
				{
					  rs.next();
					  desc = checkForNull(rs.getString("patcategory"));
					  code = checkForNull(rs.getString("PAT_CAT_CODE"));
					  if (!(patCatDB.equals("")) && (patCatDB.equals(code)) )
						  exp_val_appl_yn = 	 checkForNull(rs.getString("exp_val_appl_yn"));
					  %>
						  document.forms[0].pat_cat_code.value="<%=code%>";
					      document.forms[0].pat_cat_desc.value="<%=desc%>";
					<%
				 }				
			}%>
				document.forms[0].pat_cat_sql.value="<%=temp_sql%>";
				<%
		}
		if (exp_val_appl_yn.equals("Y"))
			 visibility = "visible";
		else
			 visibility = "hidden";
		%>
		if ('<%=patCatDB%>'!='')
		{
			if (document.forms[0].pat_cat_code)
				document.forms[0].pat_cat_code.value='<%=patCatDB%>'	;
			if (document.forms[0].imgCatExpDateMan)
				document.forms[0].imgCatExpDateMan.style.visibility = '<%=visibility%>'	;
		}
		if ( (document.forms[0].pat_cat_code) && 
			 (document.forms[0].pat_cat_code.value=='') && 
			 (document.forms[0].pat_cat_code_exp_date)  )	
				document.forms[0].pat_cat_code_exp_date.value='';

	<%
	}catch (Exception e){
		//out.println(e);
		e.printStackTrace();
	}
	finally{
		if(stmt != null) stmt.close();
		if(rs!=null) rs.close();
		ConnectionManager.returnConnection(con,request);
	}
%>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
	public String singleToDoubleQuotes(String strDB)
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
