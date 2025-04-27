<!DOCTYPE html>
<%
     Connection con =null;
	 String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 
<%@ page contentType="text/html;charset=UTF-8" import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

 <%request.setCharacterEncoding("UTF-8");
    try{
	StringBuffer sql=new  StringBuffer();
    con = ConnectionManager.getConnection(request);
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String lang="";
	//String facilityId = (String) session.getValue("facility_id");
	String module_id=request.getParameter("module_id")==null?"":request.getParameter("module_id");
	String masterName=request.getParameter("masterName")==null?"":request.getParameter("masterName");
		//System.out.println("masterName : "+masterName);
	String language=request.getParameter("language")==null?"":request.getParameter("language");
	String language_direction=request.getParameter("language_direction")==null?"":request.getParameter("language_direction");

	String appl=request.getParameter("application")==null?"":request.getParameter("application");
			//System.out.println("application : "+appl);

	String display=request.getParameter("display")==null?"":request.getParameter("display");
	String searchText=request.getParameter("searchText")==null?"":request.getParameter("searchText");
    String searchText1=searchText; 
	String Searchbymod=request.getParameter("Searchbymod")==null?"":request.getParameter("Searchbymod");
	String SearchbyFunct=request.getParameter("SearchbyFunct")==null?"":request.getParameter("SearchbyFunct");
	String start_ends_contains=request.getParameter("start_ends_contains")==null?"":request.getParameter("start_ends_contains");

	
	if(start_ends_contains.equals("S"))
					{
						searchText=searchText+"%";
					
					}
				else if(start_ends_contains.equals("E"))
				{
						searchText="%"+searchText;
				
				}
				else if(start_ends_contains.equals("C"))
				{
						searchText="%"+searchText+"%";
				
				}
	String table_or_form="";

	String table_desc=""; 
	int startVal=0;
	String pk2="";
    int colCount=0;
	String classValue="";
	String trans_table_id="";
	String master_table_id=""; 
	String pk1="";
	String temppk2="";
	String from=request.getParameter("from");
	String to=request.getParameter("to");
	ArrayList pkval=new ArrayList();
	ArrayList pkValue=new ArrayList();
	
    ArrayList pkLen=new ArrayList();
	ArrayList pkPrompt=new ArrayList();
	ArrayList columnPrompt=new ArrayList();
	ArrayList columnVal=new ArrayList();

	ArrayList colValue=new ArrayList();
	ArrayList columnLen=new ArrayList();
	int start = 0 ;
	int end = 0 ;
	int maxRecord=0;
     
	if ( from == null )
	start = 1 ;
	else
	start = Integer.parseInt(from) ;

	if ( to == null )
  	end = 20 ;
	else
	end = Integer.parseInt(to) ;%>
<script>parent.messageFrame.location.href='../../eCommon/jsp/error.jsp' </script>
<%	sql.setLength(0);

	sql.append("select * from xh_mapping  where  MASTER_TABLE_ID='"+masterName+"' order by SRL_NO ");	

    pstmt= con.prepareStatement(sql.toString());
	rs = pstmt.executeQuery() ;
	int count=0;
	while(rs.next())
	{
	 table_desc                       =rs.getString("table_desc")==null?"":rs.getString("table_desc");
	 table_or_form   =rs.getString("table_or_form")==null?"":rs.getString("table_or_form");
     if(rs.getString("pk_yn").equals("Y"))
	{	
	
	pkval.add(rs.getString("COLUMN_ID")==null?"":rs.getString("COLUMN_ID"));
	pkLen.add(rs.getString("COLUMN_LENGTH")==null?"":rs.getString("COLUMN_LENGTH"));
	pkPrompt.add(rs.getString("COLUMN_PROMPT")==null?"":rs.getString("COLUMN_PROMPT"));
	pkValue.add(rs.getString("TRANS_COLUMN_ID")==null?"":rs.getString("TRANS_COLUMN_ID"));
	}else
	{
		
	columnLen.add(rs.getString("COLUMN_LENGTH")==null?"":rs.getString("COLUMN_LENGTH"));
	columnVal.add(rs.getString("COLUMN_ID")==null?"":rs.getString("COLUMN_ID"));
	columnPrompt.add(rs.getString("COLUMN_PROMPT")==null?"":rs.getString("COLUMN_PROMPT"));
	colValue.add(rs.getString("TRANS_COLUMN_ID")==null?"":rs.getString("TRANS_COLUMN_ID"));
	
	}
	 trans_table_id                  =rs.getString("trans_table_id")==null?"":rs.getString("trans_table_id");
	 		//System.out.println("XHTranslationManagerResult trans_table_id : "+trans_table_id);

	 master_table_id               =rs.getString("master_table_id")==null?"":rs.getString("master_table_id");
			//System.out.println("XHTranslationManagerResult master_table_id : "+master_table_id);

	count++;
	}
		//System.out.println("Count : "+count);

	 if(rs!=null)rs.close();
	 if(pstmt!=null)pstmt.close();

	%>

<html>
<head>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language='javascript' src='../js/XHTranslationManager.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
 <body onLoad='FocusFirstElement()' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="TranslationResult" id="TranslationResult" method=post  action= '../../servlet/eXH.XHTranslationManagerServlet'  target="messageFrame">

 <%
	 
      sql.setLength(0);
/*
		 if(display.equals("N") || display.equals("T"))
		  {
			  */
	  sql.append("Select count(*)  total from (Select 'en' APPLICATION_ID, 1 seq_no," ); 
/*	  
		  }else
	      {
	  sql.append("Select count(*)  total from (Select APPLICATION_ID," ); 
	     }
		 */
/*	 
    if(trans_table_id.equals("XH_OTH_APPL_DATA_SKEY") && (!display.equals("N")))
	 {
	 	 sql.append("pk_value,");
		 for(startVal=0;startVal<columnVal.size();startVal++)
	       {
	     	sql.append("desc"+(startVal+1)+"_Value");
		  if(startVal<columnVal.size()-1)
			  {
		  sql.append(",");
			  }
		   }
	 }// end of SKEY & ! N
	 else if(trans_table_id.equals("XH_OTH_APPL_DATA_DKEY") && (!display.equals("N")))
		{
		 
		 sql.append("pk1_value,pk2_value,");
		 
		  for(startVal=0;startVal<columnVal.size();startVal++)
	       {
	     	sql.append("desc"+(startVal+1)+"_Value");
		  if(startVal<columnVal.size()-1)
			  {
		  sql.append(",");
			  }
		   }
		
		
		}// end of DKEY and Not-Non 
		*/
	
//		else
//		{
	if(!masterName.equals("SM_MASTER_CODE"))
			{
	 
	 for( startVal=0;startVal<pkval.size();startVal++)
	  {		  
		  sql.append(pkval.get(startVal)+",");	  
	   }
		}else
			{
			sql.append("MODULE_ID,to_char(MASTER_CODE),");
			
			}
	  	
		for( startVal=0;startVal<columnVal.size();startVal++)
	   {
	               sql.append(columnVal.get(startVal));
				   
		  if(startVal<(columnVal.size()-1))
			  {
		      sql.append(",");
			  }
	  }
	//	} 

	  if(display.equals("N"))
	 {
	 
	 
	 sql.append("   FROM  "+masterName+"  WHERE (");
	 
	 for( startVal=0;startVal<pkval.size();startVal++)
	  {    sql.append(pkval.get(startVal));
			    if(startVal<pkval.size()-1)
			  {
		      sql.append(",");
			  }
	   }
	   sql.append(")   in (select ");
	 for( startVal=0;startVal<pkValue.size();startVal++)
	  {    sql.append(pkValue.get(startVal));
			    if(startVal<pkValue.size()-1)
			  {
		      sql.append(",");
			  }
	   }
	 
	 sql.append(" from  "+trans_table_id+"  where ");
     if(trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")||trans_table_id.equals("XH_OTH_APPL_DATA_DKEY"))
		 {
		sql.append("table_id='"+masterName+"' and APPLICATION_ID='"+appl+"' and desc1_value is null ) AND UPPER(NVL("+columnVal.get(0)+",'*')) like upper('"+searchText+"')");
		
			 
		if((masterName.equals("SM_FUNCTION")||masterName.equals("SM_REPORT")||masterName.equals("SM_FUNCTION_LEGEND")||masterName.equals("SM_LABEL_ITEM")||masterName.equals("SM_LIST_ITEM")||masterName.equals("SM_RECORD_TRANS"))&&(!Searchbymod.equals("")))
			 {
			sql.append(" and module_id='"+Searchbymod+"' ");
			 }
		 	if(masterName.equals("SM_FUNCTION_LEGEND"))
			 {
			   if(!SearchbyFunct.equals(""))
				  {
				   sql.append(" and function_id like upper('"+SearchbyFunct+"%')  "); 
			      }
			 }

		
		sql.append("  union	 SELECT  '"+appl+"' APPLICATION_ID,2 SEQ_NO, ");
	   
		 }else{
		  
		   
		   sql.append("APPLICATION_ID='"+appl+"'  and "+columnVal.get(0)+" is null)  AND UPPER(NVL("+columnVal.get(0)+",'*')) like upper('"+searchText+"' )"); 
		 
		  
		  if((masterName.equals("SM_FUNCTION")||masterName.equals("SM_REPORT")||masterName.equals("SM_FUNCTION_LEGEND")||masterName.equals("SM_LABEL_ITEM")||masterName.equals("SM_LIST_ITEM")||masterName.equals("SM_RECORD_TRANS"))&&(!Searchbymod.equals("")))
			 {
			sql.append(" and module_id='"+Searchbymod+"'");
			 }
		    if(masterName.equals("SM_FUNCTION_LEGEND"))
			 {
			   if(!SearchbyFunct.equals(""))
				  {
				   sql.append(" and function_id like upper('"+SearchbyFunct+"%')  "); 
			      }
			 }


		   sql.append(" union	 SELECT  '"+appl+"' APPLICATION_ID,2 SEQ_NO," );
		   
		 }
	 if(trans_table_id.equals("XH_OTH_APPL_DATA_SKEY"))
		 {
		 sql.append("pk_value,");
		 for(startVal=0;startVal<columnVal.size();startVal++)
	       {
	     	sql.append("desc"+(startVal+1)+"_Value");
		  if(startVal<columnVal.size()-1)
			  {
		  sql.append(",");
			  }

	  }
		 
		 }else if(trans_table_id.equals("XH_OTH_APPL_DATA_DKEY"))
		 {
			 sql.append("pk1_value,pk2_value,");
		  for(startVal=0;startVal<columnVal.size();startVal++)
	       {
	     	sql.append("desc"+(startVal+1)+"_Value");
		  if(startVal<columnVal.size()-1)
			  {
		  sql.append(",");
			  }
		   }
		 }else
		 {
	  for(startVal=0;startVal<pkval.size();startVal++)
	  {   sql.append(pkval.get(startVal)+",");
	   }

	   for(startVal=0;startVal<columnVal.size();startVal++)
	  {
	     		sql.append(columnVal.get(startVal));
		  if(startVal<columnVal.size()-1)
			  {
		  sql.append(",");
			  }

	  }
	  }


 if(trans_table_id.equals("XH_OTH_APPL_DATA_SKEY"))
		 {
		 sql.append("   FROM  "+trans_table_id+"  WHERE  DESC1_VALUE is null and APPLICATION_ID = '"+appl+"' and table_id='"+masterName+"'");
		 	if((masterName.equals("SM_FUNCTION")||masterName.equals("SM_REPORT")||masterName.equals("SM_FUNCTION_LEGEND")||masterName.equals("SM_LABEL_ITEM")||masterName.equals("SM_LIST_ITEM")||masterName.equals("SM_RECORD_TRANS")))
			{if(!Searchbymod.equals(""))
				{
			sql.append(" and pk_value='"+Searchbymod+"')");
				}else
				{
				sql.append(")");
				}
			}else{
			 
			 
			 sql.append(" AND pk_value IN (SELECT "+pkval.get(0)+"  from "+masterName+"  where UPPER(NVL("+columnVal.get(0)+",'*')) LIKE upper('"+searchText+"')))");			 
			
			}
		 
		 }// end of XH_OTH_APPL_DATA_SKEY 
		 else if(trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")){
		 sql.append("   FROM  "+trans_table_id+"  WHERE  DESC1_VALUE is null and APPLICATION_ID = '"+appl+"' and table_id='"+masterName+"'");
		 	if((masterName.equals("SM_FUNCTION")||masterName.equals("SM_REPORT")||masterName.equals("SM_FUNCTION_LEGEND")||masterName.equals("SM_LABEL_ITEM")||masterName.equals("SM_LIST_ITEM")||masterName.equals("SM_RECORD_TRANS")))
			{if(!Searchbymod.equals(""))
				{
			sql.append(" and pk1_value='"+Searchbymod+"'");
			}
			}
			 
			sql.append(" AND (pk1_value,pk2_value) IN (SELECT "+pkval.get(0)+",");
			 
			 
			 if(masterName.equals("SM_MASTER_CODE"))
			 {
		    sql.append("to_char("+pkval.get(1)+")  from "+masterName+"  where UPPER(NVL("+columnVal.get(0)+",'*')) LIKE upper('"+searchText+"')))");
			 }else
			 {
			sql.append(pkval.get(1)+"  from "+masterName+"  where UPPER(NVL("+columnVal.get(0)+",'*')) LIKE upper('"+searchText+"')))");
			 }		
			
		 
		 }		// end of  XH_OTH_APPL_DATA_DKEY
		 else{

 sql.append("   FROM  "+trans_table_id+"  WHERE  "+columnVal.get(0)+" is null and APPLICATION_ID = '"+appl+"' " ); 
		 
		 	if((masterName.equals("SM_FUNCTION")||masterName.equals("SM_REPORT")||masterName.equals("SM_FUNCTION_LEGEND")||masterName.equals("SM_LABEL_ITEM")||masterName.equals("SM_LIST_ITEM")||masterName.equals("SM_RECORD_TRANS"))&&(!Searchbymod.equals("")))
			 {
			sql.append(" and module_id='"+Searchbymod+"'");
			 }
             if(masterName.equals("SM_FUNCTION_LEGEND"))
			 {
			   if(!SearchbyFunct.equals(""))
				  {
				   sql.append(" and function_id like upper('"+SearchbyFunct+"%')  "); 
			      }
			 }


		 sql.append( " and  (");
		 for( startVal=0;startVal<pkValue.size();startVal++)
	    {    sql.append(pkValue.get(startVal));
			    if(startVal<pkValue.size()-1)
			  {
		      sql.append(",");
			  }
		}

		sql.append(" ) IN (SELECT ");

			for( startVal=0;startVal<pkValue.size();startVal++)
	    {    sql.append(pkValue.get(startVal));
			    if(startVal<pkValue.size()-1)
			  {
		      sql.append(",");
			  }
		}
     sql.append(" from "+masterName+ "  where UPPER(NVL("+columnVal.get(0)+",'*')) LIKE upper('"+searchText+"')))");
			 
			 
	
			
		 } // end of !(SKEY ,DKEY)
	

	 } // end of Non-Translated
	 
// 	 Translated
	 else  if(display.equals("T"))
	 {
	  
	 sql.append("   FROM  "+masterName+"  WHERE (");
	 
	 for( startVal=0;startVal<pkval.size();startVal++)
	  {    sql.append(pkval.get(startVal));
			    if(startVal<pkval.size()-1)
			  {
		      sql.append(",");
			  }
	   }
	   sql.append(")   in (select ");
	 for( startVal=0;startVal<pkValue.size();startVal++)
	  {    sql.append(pkValue.get(startVal));
			    if(startVal<pkValue.size()-1)
			  {
		      sql.append(",");
			  }
	   }
	 
	 sql.append(" from  "+trans_table_id+"  where ");
     if(trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")||trans_table_id.equals("XH_OTH_APPL_DATA_DKEY"))
		 {
		sql.append("table_id='"+masterName+"' and APPLICATION_ID='"+appl+"' and desc1_value is not null ) AND UPPER(NVL("+columnVal.get(0)+",'*')) like upper('"+searchText+"')");
		
			 
		if((masterName.equals("SM_FUNCTION")||masterName.equals("SM_REPORT")||masterName.equals("SM_FUNCTION_LEGEND")||masterName.equals("SM_LABEL_ITEM")||masterName.equals("SM_LIST_ITEM")||masterName.equals("SM_RECORD_TRANS"))&&(!Searchbymod.equals("")))
			 {
			sql.append(" and module_id='"+Searchbymod+"' ");
			 }
		 	if(masterName.equals("SM_FUNCTION_LEGEND"))
			 {
			   if(!SearchbyFunct.equals(""))
				  {
				   sql.append(" and function_id like upper('"+SearchbyFunct+"%')  "); 
			      }
			 }

		
		sql.append("  union	 SELECT  '"+appl+"' APPLICATION_ID,2 SEQ_NO, ");
	   
		 }else{
		  
		   
		   sql.append("APPLICATION_ID='"+appl+"'  and "+columnVal.get(0)+" is not null)  AND UPPER(NVL("+columnVal.get(0)+",'*')) like upper('"+searchText+"' )"); 
		 
		  
		  if((masterName.equals("SM_FUNCTION")||masterName.equals("SM_REPORT")||masterName.equals("SM_FUNCTION_LEGEND")||masterName.equals("SM_LABEL_ITEM")||masterName.equals("SM_LIST_ITEM")||masterName.equals("SM_RECORD_TRANS"))&&(!Searchbymod.equals("")))
			 {
			sql.append(" and module_id='"+Searchbymod+"'");
			 }
		    if(masterName.equals("SM_FUNCTION_LEGEND"))
			 {
			   if(!SearchbyFunct.equals(""))
				  {
				   sql.append(" and function_id like upper('"+SearchbyFunct+"%')  "); 
			      }
			 }


		   sql.append(" union	 SELECT  '"+appl+"' APPLICATION_ID,2 SEQ_NO," );
		   
		 }
	 if(trans_table_id.equals("XH_OTH_APPL_DATA_SKEY"))
		 {
		 sql.append("pk_value,");
		 for(startVal=0;startVal<columnVal.size();startVal++)
	       {
	     	sql.append("desc"+(startVal+1)+"_Value");
		  if(startVal<columnVal.size()-1)
			  {
		  sql.append(",");
			  }

	  }
		 
		 }else if(trans_table_id.equals("XH_OTH_APPL_DATA_DKEY"))
		 {
			 sql.append("pk1_value,pk2_value,");
		  for(startVal=0;startVal<columnVal.size();startVal++)
	       {
	     	sql.append("desc"+(startVal+1)+"_Value");
		  if(startVal<columnVal.size()-1)
			  {
		  sql.append(",");
			  }
		   }
		 }else
		 {
	  for(startVal=0;startVal<pkval.size();startVal++)
	  {   sql.append(pkval.get(startVal)+",");
	   }

	   for(startVal=0;startVal<columnVal.size();startVal++)
	  {
	     		sql.append(columnVal.get(startVal));
		  if(startVal<columnVal.size()-1)
			  {
		  sql.append(",");
			  }

	  }
	  }


 if(trans_table_id.equals("XH_OTH_APPL_DATA_SKEY"))
		 {
		 sql.append("   FROM  "+trans_table_id+"  WHERE  DESC1_VALUE is not null and APPLICATION_ID = '"+appl+"' and table_id='"+masterName+"'");
		 	if((masterName.equals("SM_FUNCTION")||masterName.equals("SM_REPORT")||masterName.equals("SM_FUNCTION_LEGEND")||masterName.equals("SM_LABEL_ITEM")||masterName.equals("SM_LIST_ITEM")||masterName.equals("SM_RECORD_TRANS")))
			{if(!Searchbymod.equals(""))
				{
			sql.append(" and pk_value='"+Searchbymod+"')");
				}else
				{
				sql.append(")");
				}
			}else{
			 
			 
			 sql.append(" AND pk_value IN (SELECT "+pkval.get(0)+"  from "+masterName+"  where UPPER(NVL("+columnVal.get(0)+",'*')) LIKE upper('"+searchText+"')))");			 
			
			}
		 
		 }// end of XH_OTH_APPL_DATA_SKEY 
		 else if(trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")){
		 sql.append("   FROM  "+trans_table_id+"  WHERE  DESC1_VALUE is not null and APPLICATION_ID = '"+appl+"' and table_id='"+masterName+"'");
		 	if((masterName.equals("SM_FUNCTION")||masterName.equals("SM_REPORT")||masterName.equals("SM_FUNCTION_LEGEND")||masterName.equals("SM_LABEL_ITEM")||masterName.equals("SM_LIST_ITEM")||masterName.equals("SM_RECORD_TRANS")))
			{if(!Searchbymod.equals(""))
				{
			sql.append(" and pk1_value='"+Searchbymod+"'");
			}
			}
			 
			sql.append(" AND (pk1_value,pk2_value) IN (SELECT "+pkval.get(0)+",");
			 
			 
			 if(masterName.equals("SM_MASTER_CODE"))
			 {
		    sql.append("to_char("+pkval.get(1)+")  from "+masterName+"  where UPPER(NVL("+columnVal.get(0)+",'*')) LIKE upper('"+searchText+"')))");
			 }else
			 {
			sql.append(pkval.get(1)+"  from "+masterName+"  where UPPER(NVL("+columnVal.get(0)+",'*')) LIKE upper('"+searchText+"')))");
			 }		
			
		 
		 }		// end of  XH_OTH_APPL_DATA_DKEY
		 else{

 sql.append("   FROM  "+trans_table_id+"  WHERE  "+columnVal.get(0)+" is not null and APPLICATION_ID = '"+appl+"' " ); 
		 
		 	if((masterName.equals("SM_FUNCTION")||masterName.equals("SM_REPORT")||masterName.equals("SM_FUNCTION_LEGEND")||masterName.equals("SM_LABEL_ITEM")||masterName.equals("SM_LIST_ITEM")||masterName.equals("SM_RECORD_TRANS"))&&(!Searchbymod.equals("")))
			 {
			sql.append(" and module_id='"+Searchbymod+"'");
			 }
             if(masterName.equals("SM_FUNCTION_LEGEND"))
			 {
			   if(!SearchbyFunct.equals(""))
				  {
				   sql.append(" and function_id like upper('"+SearchbyFunct+"%')  "); 
			      }
			 }


		 sql.append( " and  (");
		 for( startVal=0;startVal<pkValue.size();startVal++)
	    {    sql.append(pkValue.get(startVal));
			    if(startVal<pkValue.size()-1)
			  {
		      sql.append(",");
			  }
		}

		sql.append(" ) IN (SELECT ");

			for( startVal=0;startVal<pkValue.size();startVal++)
	    {    sql.append(pkValue.get(startVal));
			    if(startVal<pkValue.size()-1)
			  {
		      sql.append(",");
			  }
		}
     sql.append(" from "+masterName+ "  where UPPER(NVL("+columnVal.get(0)+",'*')) LIKE upper('"+searchText+"')))");
			 
			 
	
			
		 } // end of !(SKEY ,DKEY)
	

	 } // end of Translated
	else
	 {
	  
	 sql.append("   FROM  "+masterName+"  WHERE (");
	 
	 for( startVal=0;startVal<pkval.size();startVal++)
	  {    sql.append(pkval.get(startVal));
			    if(startVal<pkval.size()-1)
			  {
		      sql.append(",");
			  }
	   }
	   sql.append(")   in (select ");
	 for( startVal=0;startVal<pkValue.size();startVal++)
	  {    sql.append(pkValue.get(startVal));
			    if(startVal<pkValue.size()-1)
			  {
		      sql.append(",");
			  }
	   }
	 
	 sql.append(" from  "+trans_table_id+"  where ");
     if(trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")||trans_table_id.equals("XH_OTH_APPL_DATA_DKEY"))
		 {
		sql.append("table_id='"+masterName+"' and APPLICATION_ID='"+appl+"' ) AND UPPER(NVL("+columnVal.get(0)+",'*')) like upper('"+searchText+"')");
		
			 
		if((masterName.equals("SM_FUNCTION")||masterName.equals("SM_REPORT")||masterName.equals("SM_FUNCTION_LEGEND")||masterName.equals("SM_LABEL_ITEM")||masterName.equals("SM_LIST_ITEM")||masterName.equals("SM_RECORD_TRANS"))&&(!Searchbymod.equals("")))
			 {
			sql.append(" and module_id='"+Searchbymod+"' ");
			 }
		 	if(masterName.equals("SM_FUNCTION_LEGEND"))
			 {
			   if(!SearchbyFunct.equals(""))
				  {
				   sql.append(" and function_id like upper('"+SearchbyFunct+"%')  "); 
			      }
			 }

		
		sql.append("  union	 SELECT  '"+appl+"' APPLICATION_ID,2 SEQ_NO, ");
	   
		 }else{
		  
		   
		   sql.append("APPLICATION_ID='"+appl+"'  )  AND UPPER(NVL("+columnVal.get(0)+",'*')) like upper('"+searchText+"' )"); 
		 
		  
		  if((masterName.equals("SM_FUNCTION")||masterName.equals("SM_REPORT")||masterName.equals("SM_FUNCTION_LEGEND")||masterName.equals("SM_LABEL_ITEM")||masterName.equals("SM_LIST_ITEM")||masterName.equals("SM_RECORD_TRANS"))&&(!Searchbymod.equals("")))
			 {
			sql.append(" and module_id='"+Searchbymod+"'");
			 }
		    if(masterName.equals("SM_FUNCTION_LEGEND"))
			 {
			   if(!SearchbyFunct.equals(""))
				  {
				   sql.append(" and function_id like upper('"+SearchbyFunct+"%')  "); 
			      }
			 }


		   sql.append(" union	 SELECT  '"+appl+"' APPLICATION_ID,2 SEQ_NO," );
		   
		 }
	 if(trans_table_id.equals("XH_OTH_APPL_DATA_SKEY"))
		 {
		 sql.append("pk_value,");
		 for(startVal=0;startVal<columnVal.size();startVal++)
	       {
	     	sql.append("desc"+(startVal+1)+"_Value");
		  if(startVal<columnVal.size()-1)
			  {
		  sql.append(",");
			  }

	  }
		 
		 }else if(trans_table_id.equals("XH_OTH_APPL_DATA_DKEY"))
		 {
			 sql.append("pk1_value,pk2_value,");
		  for(startVal=0;startVal<columnVal.size();startVal++)
	       {
	     	sql.append("desc"+(startVal+1)+"_Value");
		  if(startVal<columnVal.size()-1)
			  {
		  sql.append(",");
			  }
		   }
		 }else
		 {
	  for(startVal=0;startVal<pkval.size();startVal++)
	  {   sql.append(pkval.get(startVal)+",");
	   }

	   for(startVal=0;startVal<columnVal.size();startVal++)
	  {
	     		sql.append(columnVal.get(startVal));
		  if(startVal<columnVal.size()-1)
			  {
		  sql.append(",");
			  }

	  }
	  }


 if(trans_table_id.equals("XH_OTH_APPL_DATA_SKEY"))
		 {
		 sql.append("   FROM  "+trans_table_id+"  WHERE  APPLICATION_ID = '"+appl+"' and table_id='"+masterName+"'");
		 	if((masterName.equals("SM_FUNCTION")||masterName.equals("SM_REPORT")||masterName.equals("SM_FUNCTION_LEGEND")||masterName.equals("SM_LABEL_ITEM")||masterName.equals("SM_LIST_ITEM")||masterName.equals("SM_RECORD_TRANS")))
			{if(!Searchbymod.equals(""))
				{
			sql.append(" and pk_value='"+Searchbymod+"')");
				}else
				{
				sql.append(")");
				}
			}else{
			 
			 
			 sql.append(" AND pk_value IN (SELECT "+pkval.get(0)+"  from "+masterName+"  where UPPER(NVL("+columnVal.get(0)+",'*')) LIKE upper('"+searchText+"')))");			 
			
			}
		 
		 }// end of XH_OTH_APPL_DATA_SKEY 
		 else if(trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")){
		 sql.append("   FROM  "+trans_table_id+"  WHERE  APPLICATION_ID = '"+appl+"' and table_id='"+masterName+"'");
		 	if((masterName.equals("SM_FUNCTION")||masterName.equals("SM_REPORT")||masterName.equals("SM_FUNCTION_LEGEND")||masterName.equals("SM_LABEL_ITEM")||masterName.equals("SM_LIST_ITEM")||masterName.equals("SM_RECORD_TRANS")))
			{if(!Searchbymod.equals(""))
				{
			sql.append(" and pk1_value='"+Searchbymod+"'");
			}
			}
			 
			sql.append(" AND (pk1_value,pk2_value) IN (SELECT "+pkval.get(0)+",");
			 
			 
			 if(masterName.equals("SM_MASTER_CODE"))
			 {
		    sql.append("to_char("+pkval.get(1)+")  from "+masterName+"  where UPPER(NVL("+columnVal.get(0)+",'*')) LIKE upper('"+searchText+"')))");
			 }else
			 {
			sql.append(pkval.get(1)+"  from "+masterName+"  where UPPER(NVL("+columnVal.get(0)+",'*')) LIKE upper('"+searchText+"')))");
			 }		
			
		 
		 }		// end of  XH_OTH_APPL_DATA_DKEY
		 else{

 sql.append("   FROM  "+trans_table_id+"  WHERE  APPLICATION_ID = '"+appl+"' " ); 
		 
		 	if((masterName.equals("SM_FUNCTION")||masterName.equals("SM_REPORT")||masterName.equals("SM_FUNCTION_LEGEND")||masterName.equals("SM_LABEL_ITEM")||masterName.equals("SM_LIST_ITEM")||masterName.equals("SM_RECORD_TRANS"))&&(!Searchbymod.equals("")))
			 {
			sql.append(" and module_id='"+Searchbymod+"'");
			 }
             if(masterName.equals("SM_FUNCTION_LEGEND"))
			 {
			   if(!SearchbyFunct.equals(""))
				  {
				   sql.append(" and function_id like upper('"+SearchbyFunct+"%')  "); 
			      }
			 }


		 sql.append( " and  (");
		 for( startVal=0;startVal<pkValue.size();startVal++)
	    {    sql.append(pkValue.get(startVal));
			    if(startVal<pkValue.size()-1)
			  {
		      sql.append(",");
			  }
		}

		sql.append(" ) IN (SELECT ");

			for( startVal=0;startVal<pkValue.size();startVal++)
	    {    sql.append(pkValue.get(startVal));
			    if(startVal<pkValue.size()-1)
			  {
		      sql.append(",");
			  }
		}
     sql.append(" from "+masterName+ "  where UPPER(NVL("+columnVal.get(0)+",'*')) LIKE upper('"+searchText+"')))");
			 
			 
	
			
		 } // end of !(SKEY ,DKEY)
	

	 } // end of ALL
	 //System.out.println("602 : "+sql.toString());
	pstmt= con.prepareStatement(sql.toString());
	rs = pstmt.executeQuery() ;
    
	
 
 rs.next()   ;
 maxRecord = rs.getInt("total");
 	 //System.out.println("maxRecord Int : "+maxRecord);

 if(rs!=null)rs.close();
 if(pstmt!=null)pstmt.close();
 

if(maxRecord==0)
 {
	 out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));parent.dummyFrame.location.href='../../eCommon/html/blank.html';</script>");
 }else{%>
 <p>
<table align='right' border=0 >
<tr>
<td >
 <%if ( !(start <= 1) )
	out.println("<A HREF='javascript:recordPrevData()'  text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
	
if ( !( (start+20) > maxRecord ) )
out.println("<A href='javascript:recordNextData()' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
	
 %>



</td>
</tr>
</table>
</p>
<br>
<br>

<table cellspacing=0 cellpadding=0 align="center" width="95%" border="0">
<tr ><td class=data	 align=center style="BACKGROUND-COLOR:white;font:12pt" ><B><%=table_desc%></b></td></td>
</table>
<table cellspacing=0 cellpadding=0 align="center" width="95%" border="0">
<tr> 
<%

if(!table_or_form.equals("F"))
	 {
for(int startval=0;startval<pkPrompt.size();startval++)
	 {%>
 <th align=left><%=pkPrompt.get(startval)%></th>
	 <%}

for(int startval=0;startval<columnPrompt.size();startval++)
	 {%>
 <th align=left>&nbsp;&nbsp;&nbsp;<%=columnPrompt.get(startval)%> </th>
	 <%}%>

	 <%}else
	 {%>
<!--	 <th align=left><fmt:message key="Common.Label.label" bundle="${common_labels}"/></th>
	 <th align=left><fmt:message key="Common.English.label" bundle="${common_labels}"/></th>
	 <th align=left><fmt:message key="eSM.TranslatedLanguage.label" bundle="${sm_labels}"/></th> -->
	 <th align=left><fmt:message key="Common.Label.label" bundle="${common_labels}"/></th>
     <th align=left><fmt:message key="eXH.eHISVal.Label" bundle="${xh_labels}"/></th>
     <th align=left><fmt:message key="eXH.TranslatedVal.Label" bundle="${xh_labels}"/></th>	 
<% }%>
 </tr>
	 <%
 	 
	 sql.setLength(0);
/*
	if(display.equals("N") || display.equals("T"))
	 {
		 */
	sql.append("Select 'en'  APPLICATION_ID,1 SEQ_NO," ); 
/*	
	 }else
	 {
	 sql.append("Select a.APPLICATION_ID,2 SEQ_NO," ); 
	 // cmnntd on J17 sql.append("Select a.APPLICATION_ID, b.SEQ_NO," ); 

	 }
	 */
	/*
	 if(trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")&& (!display.equals("N")))
	 {
		  sql.append("pk_value" +" "+pkval.get(0)+",");
		  for(startVal=0;startVal<columnVal.size();startVal++)
	       {
	     	sql.append("desc"+(startVal+1)+"_Value"+" "+columnVal.get(startVal));
		  if(startVal<columnVal.size()-1)
			  {
		  sql.append(",");
			  }
		   }
	 }else if(trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")&&(!display.equals("N")))
		{
		 
		  for( startVal=0;startVal<pkval.size();startVal++)
	  {
		  sql.append("pk"+(startVal+1)+"_Value" +" "+pkval.get(startVal)+",");
		 
		
	   }
		 
		
		  for(startVal=0;startVal<columnVal.size();startVal++)
	       {
	     	sql.append("desc"+(startVal+1)+"_Value"+" "+columnVal.get(startVal));
		  if(startVal<columnVal.size()-1)
			  {
		  sql.append(",");
			  }
		   }
		
		} // end of 709 
		*/
	//	else
//		{
	 if(!masterName.equals("SM_MASTER_CODE"))
			{
	 for( startVal=0;startVal<pkval.size();startVal++)
	  {
	    sql.append("a.");
		  sql.append(pkval.get(startVal)+",");
		 
		
	   }
	}else
	{
		 sql.append("a.MODULE_ID,to_char(a.MASTER_CODE)MASTER_CODE ,");
	//sql.append("MODULE_ID,to_char(MASTER_CODE)MASTER_CODE ,");
	}
		
	  	   for( startVal=0;startVal<columnVal.size();startVal++)
	   {
			   sql.append("a.");
	      sql.append(columnVal.get(startVal));
           	
		  if(startVal<(columnVal.size()-1))
			  {
		      sql.append(",");
			  }
	  }
//		} // end of 730 else

	 if(display.equals("N"))
	 {
	 
	 sql.append("   FROM  "+masterName+"  a WHERE (");
	 
	 for( startVal=0;startVal<pkval.size();startVal++)
	  {    sql.append(pkval.get(startVal));
			    if(startVal<pkval.size()-1)
			  {
		      sql.append(",");
			  }
	   }
	   sql.append(")   in (select ");
	 for( startVal=0;startVal<pkValue.size();startVal++)
	  {    sql.append(pkValue.get(startVal));
			    if(startVal<pkValue.size()-1)
			  {
		      sql.append(",");
			  }
	   }
	 sql.append(" from  "+trans_table_id+"  where ");
     if(trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")||trans_table_id.equals("XH_OTH_APPL_DATA_DKEY"))
		 {
		sql.append("table_id='"+masterName+"' and APPLICATION_ID='"+appl+"' and desc1_value is null ) AND UPPER(NVL("+columnVal.get(0)+",'*')) like upper('"+searchText+"')");
		
		if((masterName.equals("SM_FUNCTION")||masterName.equals("SM_REPORT")||masterName.equals("SM_FUNCTION_LEGEND")||masterName.equals("SM_LABEL_ITEM")||masterName.equals("SM_LIST_ITEM")||masterName.equals("SM_RECORD_TRANS"))&&(!Searchbymod.equals("")))
			 {
			sql.append(" and module_id='"+Searchbymod+"'");
			 }
		 
			if(masterName.equals("SM_FUNCTION_LEGEND"))
			 {
			   if(!SearchbyFunct.equals(""))
				  {
				   sql.append(" and function_id like upper('"+SearchbyFunct+"%')  "); 
			      }
			 }
		sql.append("  union	 SELECT  '"+appl+"' APPLICATION_ID,2 SEQ_NO, ");
	   
		 } // SKEY/DKEY
		 else{
		  
		   sql.append("APPLICATION_ID='"+appl+"'  and "+columnVal.get(0)+" is null)  AND UPPER(NVL("+columnVal.get(0)+",'*')) like upper('"+searchText+"' )"); 
		 
		  
		  if((masterName.equals("SM_FUNCTION")||masterName.equals("SM_REPORT")||masterName.equals("SM_FUNCTION_LEGEND")||masterName.equals("SM_LABEL_ITEM")||masterName.equals("SM_LIST_ITEM")||masterName.equals("SM_RECORD_TRANS"))&&(!Searchbymod.equals("")))
			 {

			sql.append(" and module_id='"+Searchbymod+"'");
			 }
		  if(masterName.equals("SM_FUNCTION_LEGEND"))
			 {
			   if(!SearchbyFunct.equals(""))
				  {

				   sql.append(" and function_id like upper('"+SearchbyFunct+"%')  "); 
			      }
			 }

		   sql.append(" union	 SELECT  '"+appl+"' APPLICATION_ID,2 SEQ_NO," );
		   
		 } // OTH !(SKEY,DKEY)
	 if(trans_table_id.equals("XH_OTH_APPL_DATA_SKEY"))
		 {

		 sql.append("pk_value,");
		 for(startVal=0;startVal<columnVal.size();startVal++)
	       {

	     	sql.append("desc"+(startVal+1)+"_Value");
		  if(startVal<columnVal.size()-1)
			  {
		  sql.append(",");
			  }

	  }

		 }// end of SKEY 
		 else if(trans_table_id.equals("XH_OTH_APPL_DATA_DKEY"))
		 {

		 sql.append("pk1_value,pk2_value,");
		  for(startVal=0;startVal<columnVal.size();startVal++)
	       {

	     	sql.append("desc"+(startVal+1)+"_Value");
		  if(startVal<columnVal.size()-1)
			  {
		  sql.append(",");
			  }
		   }
		 }// end of DKEY
		 else
		 {
	  for(startVal=0;startVal<pkval.size();startVal++)
	  {   sql.append(pkval.get(startVal)+",");
	   }

	   for(startVal=0;startVal<columnVal.size();startVal++)
	  {
	     		sql.append(columnVal.get(startVal));
		  if(startVal<columnVal.size()-1)
			  {
		  sql.append(",");
			  }

	  }
	  }// !(SKEY,DKEY)


 if(trans_table_id.equals("XH_OTH_APPL_DATA_SKEY"))
		 {

		 sql.append("   FROM  "+trans_table_id+"  WHERE  DESC1_VALUE is null and APPLICATION_ID = '"+appl+"' and table_id='"+masterName+"'");
		 	if((masterName.equals("SM_FUNCTION")||masterName.equals("SM_REPORT")||masterName.equals("SM_FUNCTION_LEGEND")||masterName.equals("SM_LABEL_ITEM")||masterName.equals("SM_LIST_ITEM")||masterName.equals("SM_RECORD_TRANS")))
			{if(!Searchbymod.equals(""))
				{

			sql.append(" and pk_value='"+Searchbymod+"'");
				}
			}else{

			sql.append(" AND pk_value IN (SELECT "+pkval.get(0)+"  from "+masterName+"  where UPPER(NVL("+columnVal.get(0)+",'*')) LIKE upper('"+searchText+"'))");
			}
			
	

		 }// SKEY
		 else if( trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")){

	sql.append("   FROM  "+trans_table_id+"  WHERE  DESC1_VALUE is null and APPLICATION_ID = '"+appl+"' and table_id='"+masterName+"'");
		 	if((masterName.equals("SM_FUNCTION")||masterName.equals("SM_REPORT")||masterName.equals("SM_FUNCTION_LEGEND")||masterName.equals("SM_LABEL_ITEM")||masterName.equals("SM_LIST_ITEM")||masterName.equals("SM_RECORD_TRANS")))
			{if(!Searchbymod.equals(""))
				{

			sql.append(" and pk1_value='"+Searchbymod+"'");
				}
			}

			
			sql.append("  AND (pk1_value,pk2_value) IN (SELECT "+pkval.get(0)+",");
			
			
			if(masterName.equals("SM_MASTER_CODE"))
			 {

		    sql.append("to_char("+pkval.get(1)+")  from "+masterName+"  where UPPER(NVL("+columnVal.get(0)+",'*')) LIKE upper('"+searchText+"'))");
			 }else
			 {

			sql.append(pkval.get(1)+"  from "+masterName+"  where UPPER(NVL("+columnVal.get(0)+",'*')) LIKE upper('"+searchText+"'))");
			 }
			
		 
		 
		 
		 } // DKEY
		 else{

 sql.append("   FROM  "+trans_table_id+"  WHERE  "+columnVal.get(0)+" is null and APPLICATION_ID = '"+appl+"' " ); 
		 
		 	if((masterName.equals("SM_FUNCTION")||masterName.equals("SM_REPORT")||masterName.equals("SM_FUNCTION_LEGEND")||masterName.equals("SM_LABEL_ITEM")||masterName.equals("SM_LIST_ITEM")||masterName.equals("SM_RECORD_TRANS")))
			 {if(!Searchbymod.equals(""))
				 {

			sql.append(" and module_id='"+Searchbymod+"'");
				 }
			if(masterName.equals("SM_FUNCTION_LEGEND"))
			 {
			   if(!SearchbyFunct.equals(""))
				  {
				   sql.append(" and function_id like upper('"+SearchbyFunct+"%')  "); 
			      }
			 }

			  sql.append( " and  (");
		 for( startVal=0;startVal<pkValue.size();startVal++)
	    {    sql.append(pkValue.get(startVal));
			    if(startVal<pkValue.size()-1)
			  {
		      sql.append(",");
			  }
		}
		sql.append(" ) IN (SELECT ");

			for( startVal=0;startVal<pkValue.size();startVal++)
	    {    sql.append(pkValue.get(startVal));
			    if(startVal<pkValue.size()-1)
			  {
		      sql.append(",");
			  }
		}
     sql.append(" from "+masterName+ "  where UPPER(NVL("+columnVal.get(0)+",'*')) LIKE upper('"+searchText+"'))");
			 
			 
			 }else{
			 sql.append(" AND "+pkval.get(0)+" IN (SELECT "+pkval.get(0)+"  from "+masterName+"  where UPPER(NVL("+columnVal.get(0)+",'*')) LIKE upper('"+searchText+"'))");
			 }
	
	
		 }

	 } // end of Non-Translated
	 
	 //Translated

 else if(display.equals("T"))
	 {
	 
	 sql.append("   FROM  "+masterName+"  a WHERE (");
	 
	 for( startVal=0;startVal<pkval.size();startVal++)
	  {    sql.append(pkval.get(startVal));
			    if(startVal<pkval.size()-1)
			  {
		      sql.append(",");
			  }
	   }
	   sql.append(")   in (select ");
	 for( startVal=0;startVal<pkValue.size();startVal++)
	  {    sql.append(pkValue.get(startVal));
			    if(startVal<pkValue.size()-1)
			  {
		      sql.append(",");
			  }
	   }
	 sql.append(" from  "+trans_table_id+"  where ");
     if(trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")||trans_table_id.equals("XH_OTH_APPL_DATA_DKEY"))
		 {
		sql.append("table_id='"+masterName+"' and APPLICATION_ID='"+appl+"' and desc1_value is not null ) AND UPPER(NVL("+columnVal.get(0)+",'*')) like upper('"+searchText+"')");
		
		if((masterName.equals("SM_FUNCTION")||masterName.equals("SM_REPORT")||masterName.equals("SM_FUNCTION_LEGEND")||masterName.equals("SM_LABEL_ITEM")||masterName.equals("SM_LIST_ITEM")||masterName.equals("SM_RECORD_TRANS"))&&(!Searchbymod.equals("")))
			 {
			sql.append(" and module_id='"+Searchbymod+"'");
			 }
		 
			if(masterName.equals("SM_FUNCTION_LEGEND"))
			 {
			   if(!SearchbyFunct.equals(""))
				  {
				   sql.append(" and function_id like upper('"+SearchbyFunct+"%')  "); 
			      }
			 }
		sql.append("  union	 SELECT  '"+appl+"' APPLICATION_ID,2 SEQ_NO, ");
	   
		 } // SKEY/DKEY
		 else{
		  
		   sql.append("APPLICATION_ID='"+appl+"'  and "+columnVal.get(0)+" is not null)  AND UPPER(NVL("+columnVal.get(0)+",'*')) like upper('"+searchText+"' )"); 
		 
		  
		  if((masterName.equals("SM_FUNCTION")||masterName.equals("SM_REPORT")||masterName.equals("SM_FUNCTION_LEGEND")||masterName.equals("SM_LABEL_ITEM")||masterName.equals("SM_LIST_ITEM")||masterName.equals("SM_RECORD_TRANS"))&&(!Searchbymod.equals("")))
			 {

			sql.append(" and module_id='"+Searchbymod+"'");
			 }
		  if(masterName.equals("SM_FUNCTION_LEGEND"))
			 {
			   if(!SearchbyFunct.equals(""))
				  {

				   sql.append(" and function_id like upper('"+SearchbyFunct+"%')  "); 
			      }
			 }

		   sql.append(" union	 SELECT  '"+appl+"' APPLICATION_ID,2 SEQ_NO," );
		   
		 } // OTH !(SKEY,DKEY)
	 if(trans_table_id.equals("XH_OTH_APPL_DATA_SKEY"))
		 {

		 sql.append("pk_value,");
		 for(startVal=0;startVal<columnVal.size();startVal++)
	       {

	     	sql.append("desc"+(startVal+1)+"_Value");
		  if(startVal<columnVal.size()-1)
			  {
		  sql.append(",");
			  }

	  }

		 }// end of SKEY 
		 else if(trans_table_id.equals("XH_OTH_APPL_DATA_DKEY"))
		 {

		 sql.append("pk1_value,pk2_value,");
		  for(startVal=0;startVal<columnVal.size();startVal++)
	       {

	     	sql.append("desc"+(startVal+1)+"_Value");
		  if(startVal<columnVal.size()-1)
			  {
		  sql.append(",");
			  }
		   }
		 }// end of DKEY
		 else
		 {
	  for(startVal=0;startVal<pkval.size();startVal++)
	  {   sql.append(pkval.get(startVal)+",");
	   }

	   for(startVal=0;startVal<columnVal.size();startVal++)
	  {
	     		sql.append(columnVal.get(startVal));
		  if(startVal<columnVal.size()-1)
			  {
		  sql.append(",");
			  }

	  }
	  }// !(SKEY,DKEY)


 if(trans_table_id.equals("XH_OTH_APPL_DATA_SKEY"))
		 {

		 sql.append("   FROM  "+trans_table_id+"  WHERE  DESC1_VALUE is not null and APPLICATION_ID = '"+appl+"' and table_id='"+masterName+"'");
		 	if((masterName.equals("SM_FUNCTION")||masterName.equals("SM_REPORT")||masterName.equals("SM_FUNCTION_LEGEND")||masterName.equals("SM_LABEL_ITEM")||masterName.equals("SM_LIST_ITEM")||masterName.equals("SM_RECORD_TRANS")))
			{if(!Searchbymod.equals(""))
				{

			sql.append(" and pk_value='"+Searchbymod+"'");
				}
			}else{

			sql.append(" AND pk_value IN (SELECT "+pkval.get(0)+"  from "+masterName+"  where UPPER(NVL("+columnVal.get(0)+",'*')) LIKE upper('"+searchText+"'))");
			}
			
	

		 }// SKEY
		 else if( trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")){

	sql.append("   FROM  "+trans_table_id+"  WHERE  DESC1_VALUE is not null and APPLICATION_ID = '"+appl+"' and table_id='"+masterName+"'");
		 	if((masterName.equals("SM_FUNCTION")||masterName.equals("SM_REPORT")||masterName.equals("SM_FUNCTION_LEGEND")||masterName.equals("SM_LABEL_ITEM")||masterName.equals("SM_LIST_ITEM")||masterName.equals("SM_RECORD_TRANS")))
			{if(!Searchbymod.equals(""))
				{

			sql.append(" and pk1_value='"+Searchbymod+"'");
				}
			}

			
			sql.append("  AND (pk1_value,pk2_value) IN (SELECT "+pkval.get(0)+",");
			
			
			if(masterName.equals("SM_MASTER_CODE"))
			 {

		    sql.append("to_char("+pkval.get(1)+")  from "+masterName+"  where UPPER(NVL("+columnVal.get(0)+",'*')) LIKE upper('"+searchText+"'))");
			 }else
			 {

			sql.append(pkval.get(1)+"  from "+masterName+"  where UPPER(NVL("+columnVal.get(0)+",'*')) LIKE upper('"+searchText+"'))");
			 }
			
		 
		 
		 
		 } // DKEY
		 else{

 sql.append("   FROM  "+trans_table_id+"  WHERE  "+columnVal.get(0)+" is not null and APPLICATION_ID = '"+appl+"' " ); 
		 
		 	if((masterName.equals("SM_FUNCTION")||masterName.equals("SM_REPORT")||masterName.equals("SM_FUNCTION_LEGEND")||masterName.equals("SM_LABEL_ITEM")||masterName.equals("SM_LIST_ITEM")||masterName.equals("SM_RECORD_TRANS")))
			 {if(!Searchbymod.equals(""))
				 {

			sql.append(" and module_id='"+Searchbymod+"'");
				 }
			if(masterName.equals("SM_FUNCTION_LEGEND"))
			 {
			   if(!SearchbyFunct.equals(""))
				  {
				   sql.append(" and function_id like upper('"+SearchbyFunct+"%')  "); 
			      }
			 }

			  sql.append( " and  (");
		 for( startVal=0;startVal<pkValue.size();startVal++)
	    {    sql.append(pkValue.get(startVal));
			    if(startVal<pkValue.size()-1)
			  {
		      sql.append(",");
			  }
		}
		sql.append(" ) IN (SELECT ");

			for( startVal=0;startVal<pkValue.size();startVal++)
	    {    sql.append(pkValue.get(startVal));
			    if(startVal<pkValue.size()-1)
			  {
		      sql.append(",");
			  }
		}
     sql.append(" from "+masterName+ "  where UPPER(NVL("+columnVal.get(0)+",'*')) LIKE upper('"+searchText+"'))");
			 
			 
			 }else{
			 sql.append(" AND "+pkval.get(0)+" IN (SELECT "+pkval.get(0)+"  from "+masterName+"  where UPPER(NVL("+columnVal.get(0)+",'*')) LIKE upper('"+searchText+"'))");
			 }
	
	
		 }

	 } // end of Translated
	 
 else 
	 {
	 
	 sql.append("   FROM  "+masterName+"  a WHERE (");
	 
	 for( startVal=0;startVal<pkval.size();startVal++)
	  {    sql.append(pkval.get(startVal));
			    if(startVal<pkval.size()-1)
			  {
		      sql.append(",");
			  }
	   }
	   sql.append(")   in (select ");
	 for( startVal=0;startVal<pkValue.size();startVal++)
	  {    sql.append(pkValue.get(startVal));
			    if(startVal<pkValue.size()-1)
			  {
		      sql.append(",");
			  }
	   }
	 sql.append(" from  "+trans_table_id+"  where ");
     if(trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")||trans_table_id.equals("XH_OTH_APPL_DATA_DKEY"))
		 {
		sql.append("table_id='"+masterName+"' and APPLICATION_ID='"+appl+"' ) AND UPPER(NVL("+columnVal.get(0)+",'*')) like upper('"+searchText+"')");
		
		if((masterName.equals("SM_FUNCTION")||masterName.equals("SM_REPORT")||masterName.equals("SM_FUNCTION_LEGEND")||masterName.equals("SM_LABEL_ITEM")||masterName.equals("SM_LIST_ITEM")||masterName.equals("SM_RECORD_TRANS"))&&(!Searchbymod.equals("")))
			 {
			sql.append(" and module_id='"+Searchbymod+"'");
			 }
		 
			if(masterName.equals("SM_FUNCTION_LEGEND"))
			 {
			   if(!SearchbyFunct.equals(""))
				  {
				   sql.append(" and function_id like upper('"+SearchbyFunct+"%')  "); 
			      }
			 }
		sql.append("  union	 SELECT  '"+appl+"' APPLICATION_ID,2 SEQ_NO, ");
	   
		 } // SKEY/DKEY
		 else{
		  
		   sql.append("APPLICATION_ID='"+appl+"' )  AND UPPER(NVL("+columnVal.get(0)+",'*')) like upper('"+searchText+"' )"); 
		 
		  
		  if((masterName.equals("SM_FUNCTION")||masterName.equals("SM_REPORT")||masterName.equals("SM_FUNCTION_LEGEND")||masterName.equals("SM_LABEL_ITEM")||masterName.equals("SM_LIST_ITEM")||masterName.equals("SM_RECORD_TRANS"))&&(!Searchbymod.equals("")))
			 {

			sql.append(" and module_id='"+Searchbymod+"'");
			 }
		  if(masterName.equals("SM_FUNCTION_LEGEND"))
			 {
			   if(!SearchbyFunct.equals(""))
				  {

				   sql.append(" and function_id like upper('"+SearchbyFunct+"%')  "); 
			      }
			 }

		   sql.append(" union	 SELECT  '"+appl+"' APPLICATION_ID,2 SEQ_NO," );
		   
		 } // OTH !(SKEY,DKEY)
	 if(trans_table_id.equals("XH_OTH_APPL_DATA_SKEY"))
		 {

		 sql.append("pk_value,");
		 for(startVal=0;startVal<columnVal.size();startVal++)
	       {

	     	sql.append("desc"+(startVal+1)+"_Value");
		  if(startVal<columnVal.size()-1)
			  {
		  sql.append(",");
			  }

	  }

		 }// end of SKEY 
		 else if(trans_table_id.equals("XH_OTH_APPL_DATA_DKEY"))
		 {

		 sql.append("pk1_value,pk2_value,");
		  for(startVal=0;startVal<columnVal.size();startVal++)
	       {

	     	sql.append("desc"+(startVal+1)+"_Value");
		  if(startVal<columnVal.size()-1)
			  {
		  sql.append(",");
			  }
		   }
		 }// end of DKEY
		 else
		 {
	  for(startVal=0;startVal<pkval.size();startVal++)
	  {   sql.append(pkval.get(startVal)+",");
	   }

	   for(startVal=0;startVal<columnVal.size();startVal++)
	  {
	     		sql.append(columnVal.get(startVal));
		  if(startVal<columnVal.size()-1)
			  {
		  sql.append(",");
			  }

	  }
	  }// !(SKEY,DKEY)


 if(trans_table_id.equals("XH_OTH_APPL_DATA_SKEY"))
		 {

		 sql.append("   FROM  "+trans_table_id+"  WHERE  APPLICATION_ID = '"+appl+"' and table_id='"+masterName+"'");
		 	if((masterName.equals("SM_FUNCTION")||masterName.equals("SM_REPORT")||masterName.equals("SM_FUNCTION_LEGEND")||masterName.equals("SM_LABEL_ITEM")||masterName.equals("SM_LIST_ITEM")||masterName.equals("SM_RECORD_TRANS")))
			{if(!Searchbymod.equals(""))
				{

			sql.append(" and pk_value='"+Searchbymod+"'");
				}
			}else{

			sql.append(" AND pk_value IN (SELECT "+pkval.get(0)+"  from "+masterName+"  where UPPER(NVL("+columnVal.get(0)+",'*')) LIKE upper('"+searchText+"'))");
			}
			
	

		 }// SKEY
		 else if( trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")){

	sql.append("   FROM  "+trans_table_id+"  WHERE  APPLICATION_ID = '"+appl+"' and table_id='"+masterName+"'");
		 	if((masterName.equals("SM_FUNCTION")||masterName.equals("SM_REPORT")||masterName.equals("SM_FUNCTION_LEGEND")||masterName.equals("SM_LABEL_ITEM")||masterName.equals("SM_LIST_ITEM")||masterName.equals("SM_RECORD_TRANS")))
			{if(!Searchbymod.equals(""))
				{

			sql.append(" and pk1_value='"+Searchbymod+"'");
				}
			}

			
			sql.append("  AND (pk1_value,pk2_value) IN (SELECT "+pkval.get(0)+",");
			
			
			if(masterName.equals("SM_MASTER_CODE"))
			 {

		    sql.append("to_char("+pkval.get(1)+")  from "+masterName+"  where UPPER(NVL("+columnVal.get(0)+",'*')) LIKE upper('"+searchText+"'))");
			 }else
			 {

			sql.append(pkval.get(1)+"  from "+masterName+"  where UPPER(NVL("+columnVal.get(0)+",'*')) LIKE upper('"+searchText+"'))");
			 }
			
		 
		 
		 
		 } // DKEY
		 else{

 sql.append("   FROM  "+trans_table_id+"  WHERE  APPLICATION_ID = '"+appl+"' " ); 
		 
		 	if((masterName.equals("SM_FUNCTION")||masterName.equals("SM_REPORT")||masterName.equals("SM_FUNCTION_LEGEND")||masterName.equals("SM_LABEL_ITEM")||masterName.equals("SM_LIST_ITEM")||masterName.equals("SM_RECORD_TRANS")))
			 {if(!Searchbymod.equals(""))
				 {

			sql.append(" and module_id='"+Searchbymod+"'");
				 }
			if(masterName.equals("SM_FUNCTION_LEGEND"))
			 {
			   if(!SearchbyFunct.equals(""))
				  {
				   sql.append(" and function_id like upper('"+SearchbyFunct+"%')  "); 
			      }
			 }

			  sql.append( " and  (");
		 for( startVal=0;startVal<pkValue.size();startVal++)
	    {    sql.append(pkValue.get(startVal));
			    if(startVal<pkValue.size()-1)
			  {
		      sql.append(",");
			  }
		}
		sql.append(" ) IN (SELECT ");

			for( startVal=0;startVal<pkValue.size();startVal++)
	    {    sql.append(pkValue.get(startVal));
			    if(startVal<pkValue.size()-1)
			  {
		      sql.append(",");
			  }
		}
     sql.append(" from "+masterName+ "  where UPPER(NVL("+columnVal.get(0)+",'*')) LIKE upper('"+searchText+"'))");
			 
			 
			 }else{
			 sql.append(" AND "+pkval.get(0)+" IN (SELECT "+pkval.get(0)+"  from "+masterName+"  where UPPER(NVL("+columnVal.get(0)+",'*')) LIKE upper('"+searchText+"'))");
			 }
	
	
		 }

	 } // end of ALL
	 
	 
 
	 
	 
	 sql.append(" order by  ");
/*	  
	   if(trans_table_id.equals("XH_OTH_APPL_DATA_SKEY")&&(!display.equals("N")))
	 {
	 	 sql.append(" RACE_CODE ");
		 
	 
	 }else if(trans_table_id.equals("XH_OTH_APPL_DATA_DKEY")&&(!display.equals("N")))
		{

		 sql.append("pk1_value,pk2_value");
		 
		}
*/
// else
//		 {

	  for( startVal=0;startVal<pkval.size();startVal++)
	  {    sql.append(pkval.get(startVal));
		      if(startVal<pkval.size()-1)
			  sql.append(",");
	   }
	 
//		 }

	 sql.append(",seq_no");	
/*	
	StringBuffer sqlN = new StringBuffer();
    sqlN.append("SELECT 'en'  APPLICATION_ID,1 SEQ_NO,a.RACE_CODE,a.LONG_DESC   FROM  MP_RACE  a WHERE (RACE_CODE)   IN (SELECT PK_VALUE FROM  XH_OTH_APPL_DATA_SKEY  WHERE table_id='MP_RACE' AND APPLICATION_ID='PACS'  AND desc1_value IS NOT NULL ) AND UPPER(NVL(LONG_DESC,'*')) LIKE UPPER('%') UNION ");

	sqlN.append(sql);

	 //System.out.println("1224 sql : "+sqlN.toString());
	*/

		 //System.out.println("1224 sql : "+sql.toString());

	pstmt= con.prepareStatement(sql.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	rs = pstmt.executeQuery() ;
    
	
 
 String temppk1="";
 int l=0;
 int m=0;
int i=0,j=0;
int colDispCount=0;
int pkDataCnt=pkval.size();
 
 if ( start != 1 )
	 for( m=1; m<start; l++, m++ ){
	  rs.next() ;
	  }
 String pkData[] =new String[pkval.size()];
 String pkData1[] =new String[pkval.size()];
 
 for( startVal=0;startVal<pkval.size();startVal++)
 {
pkData1[i]="";
 }
 boolean maxrecallow=false;
 
 if(!table_or_form.equals("F"))
  {
	maxrecallow=l<end;
	
  }else
   {
  maxrecallow=true;
 }
 
 while(rs.next() && maxrecallow)
 { 
	 
lang=rs.getString(1);
//System.out.println("lang @ 1263 : "+lang);

for( startVal=0;startVal<pkval.size();startVal++)
 {
pkData[startVal]=rs.getString((String)pkval.get(startVal));
 }

   
	 
	if ( i % 2 == 0 )
		classValue = "BACKGROUND-COLOR:#F0F0F2" ;
	else
		classValue = "BACKGROUND-COLOR:#E2E3F0;" ;

	 %>
 


 
 <tr> 
 

 
 <%
if(!table_or_form.equals("F"))	 {
for( startVal=0;startVal<pkval.size();startVal++)
 {
	boolean temp1=false;;
	if(startVal==0)
	 {
	temp1=(pkData[startVal].equals(pkData1[startVal]));
	 }else
	 {
	  temp1=(pkData[startVal].equals(pkData1[startVal])&&(pkData[startVal-1].equals(pkData1[startVal-1])));
	 
	 }
	if(!(temp1))
	 {
	%>
 <td class=data style='<%=classValue%>' >  <b>
<%=pkData[startVal]%> 
	</td>
 <%}else{%>
 <td class=data style='<%=classValue%>' >&nbsp;</td>
	<%}}
for( startVal=0;startVal<pkval.size();startVal++)
 {pkData1[startVal]=pkData[startVal] ;
	}} // end of !Form -  Table %>

<%int colCount1=0;
int engColCount=0;

if(table_or_form.equals("F"))
 { 
for( startVal=0;startVal<pkval.size();startVal++)
  {
  %>
<input type=hidden name=pk<%=colCount%><%=startVal%> value=<%=pkData[startVal]%>>  
<%
  
  }
	
	
	
	%>
<td class=data><b><%=columnPrompt.get(colDispCount)%></b></td>
<td class=data ><b><%=(rs.getString((String)columnVal.get(colDispCount))==null)? "":(rs.getString((String)columnVal.get(colDispCount)))%></b></td>
<%rs.next();%>	

			<td class=data><INPUT TYPE="text" name="desc<%=colDispCount%>0" id="desc<%=colDispCount%>0" onblur='return makeValidString(this);'	size=50 maxlength='<%=columnLen.get(colDispCount)%>' value='<%=rs.getString((String)columnVal.get(colDispCount))==null?"":rs.getString((String)columnVal.get(colDispCount))%>' >  </td>

</tr>
<%colDispCount=colDispCount+1; 

colCount=1;

} // end of Form
else{
	for(startVal=0;startVal<columnVal.size();startVal++) {
	
	%> 
 <%
		
	if(lang.equals("en"))
	 {
			//System.out.println(" 1379 lang.equals('en') ");	%>
		
			<td class=data style='<%=classValue%>' ><b><%=rs.getString((String)columnVal.get(startVal))==null?"":rs.getString((String)columnVal.get(startVal))%>  </td> 
			<input type="hidden" name="engLang<%=engColCount++%><%=colCount%>" id="engLang<%=engColCount++%><%=colCount%>" value='<%=rs.getString((String)columnVal.get(startVal))==null?"":rs.getString((String)columnVal.get(startVal))%>'> 
	 	 
	 <%}else {%>
				 <td class='fields' style='<%=classValue%>' ><INPUT TYPE="text" NAME=desc<%=colCount1++%><%=colCount%>  onblur='return makeValidString(this);'
				 maxlength='<%=columnLen.get(startVal)%>' value='<%=rs.getString((String)columnVal.get(startVal))==null?"":rs.getString((String)columnVal.get(startVal))%>' size=40 > </td> 
		<%
		}
	} // end of for 	 
%>

 </tr>
	 
 <% temppk1=pk1;
       temppk2=pk2; 
} // end of else Form
if(!lang.equals("en"))
	 {
		//System.out.println(" 1379 !lang.equals('en') ");

	for( startVal=0;startVal<pkval.size();startVal++)
    {
  %>
<input type=hidden name=pk<%=colCount%><%=startVal%> value=<%=pkData[startVal]%>>  
<%
  
  }i++;
 colCount++; }else{
 }
 j++;
 l++;

  if(!table_or_form.equals("F"))
  {
	maxrecallow=l<end;
	
  }
   
   if(colDispCount>=columnPrompt.size())
	 {
	 break;
	 }
   if(table_or_form.equals("F"))
	 {
      rs.beforeFirst();
	
	 }
 } // end of while 

 if(rs!=null)rs.close();
 if(pstmt!=null)pstmt.close();
 
 %>
<INPUT TYPE="hidden" name='language_direction' id='language_direction' value="<%=language_direction%>">
<INPUT TYPE="hidden" name='from' id='from' value="<%=start%>">
<INPUT TYPE="hidden" name='to' id='to' value="<%=end%>">
<INPUT TYPE="hidden" name='module_id' id='module_id' value="<%=module_id%>">
<INPUT TYPE="hidden" name='masterName' id='masterName' value="<%=masterName%>">
<INPUT TYPE="hidden" name='language' id='language' value="<%=language%>">
<INPUT TYPE="hidden" name='application' id='application' value="<%=appl%>">

<INPUT TYPE="hidden" name='display' id='display' value="<%=display%>">
<INPUT TYPE="hidden" name='Searchbymod' id='Searchbymod' value="<%=Searchbymod%>">
<INPUT TYPE="hidden" name='SearchbyFunct' id='SearchbyFunct' value="<%=SearchbyFunct%>">

<INPUT TYPE="hidden" name='start_ends_contains' id='start_ends_contains' value="<%=start_ends_contains%>">
<INPUT TYPE="hidden" name='searchText' id='searchText' value="<%=searchText1%>">
<INPUT TYPE="hidden" name='master_table_id' id='master_table_id' value="<%=master_table_id%>">
<INPUT TYPE="hidden" name='trans_tab_id' id='trans_tab_id' value="<%=trans_table_id%>">
<INPUT TYPE="hidden" name='cnt' id='cnt' value="<%=colCount%>">
<INPUT TYPE="hidden" name='pkDataCnt' id='pkDataCnt' value="<%=pkDataCnt%>">
<INPUT TYPE="hidden" name='flag' id='flag' value="">
<INPUT TYPE="hidden" name='table_or_from' id='table_or_from' value="<%=table_or_form%>">
	<INPUT TYPE="hidden" name='colsize' id='colsize' value="<%=columnVal.size()%>">
 
 </table>
 </form>
 </body>
 </html>
 <%
 } // end of max rec !=0
	 pkval.clear();
	 pkValue.clear();
     pkLen.clear();
	 pkPrompt.clear();
	 columnPrompt.clear();
	 columnVal.clear();
	 colValue.clear();
	 columnLen.clear();
 }catch(Exception e)
 {
 }finally{
	
   ConnectionManager.returnConnection(con,request);
}
 
 %>

