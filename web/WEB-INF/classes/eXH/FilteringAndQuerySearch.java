/*
-----------------------------------------------------------------------------------------------
Date       		Edit History   Name        		Description
-----------------------------------------------------------------------------------------------
11/11/2016        	1        Prithivirajan       created

This file is for get the values for filter select box values for query operation
-----------------------------------------------------------------------------------------------
*/
package eXH;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;


import webbeans.eCommon.ConnectionManager;

public class FilteringAndQuerySearch implements java.io.Serializable

{
    
    public HashMap<String,TreeMap> getSelectBoxValues(String filterGroupCode)
	{
	     //System.out.println("get select box values method is calling...."+filterGroupCode);
         int levelCount=0;
	     ArrayList arrRowList = new ArrayList();
		 HashMap filterQueriesMap = new HashMap<String,String[]>();
		 HashMap<String, TreeMap> resultMap = null;

		 try{      
            levelCount = getLevelCount(filterGroupCode);
            arrRowList = getMainResults(filterGroupCode);
            filterQueriesMap = getFilterQueries(levelCount,filterGroupCode);
			resultMap = getFinalValues(levelCount,arrRowList,filterQueriesMap);
			arrRowList.clear();
			filterQueriesMap.clear();
		   
		 }
		 catch(Exception e)
		{
           e.printStackTrace();
		}
		return resultMap;
	}


	public int getLevelCount(String filterGroupCode) throws Exception
	{
       Connection dbConn = null;
	   PreparedStatement pstmt = null;
	   ResultSet rs = null;

	   String levelCountQuery = "select count(*) AS rowcount from XH_FILTER_LEVEL_CONFIG where filter_group_code='"+filterGroupCode+"'";

	   int levelCount = 0;

	   try{

	   dbConn = ConnectionManager.getConnection();
	   pstmt = dbConn.prepareCall(levelCountQuery);
	   rs = pstmt.executeQuery();

	   rs.next();
       levelCount = rs.getInt("rowcount") ;
	   }
	   catch(Exception e)
		{
           e.printStackTrace();
		}
		finally{
		   XHUtil.closeDBResources(rs, pstmt, dbConn);

		}
       
       System.out.println("FilteringAndQuerySearch.jsp:::level count value..."+levelCount);
	   return levelCount;
	}




	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList getMainResults(String filterGroupCode) throws Exception
	{
       String qry_id = "VIEWXHFILTERANDSCDHULINGLEVEL";
	   int numOfColumns=38;
	   //int i=0;
	   
	   String whereClause =" where FILTER_GROUP_CODE='"+filterGroupCode+"'  ";
	   String mainQuery = XHSQLSet.getSQL(qry_id)+whereClause;
       
	   Connection dbConn = null;
	   PreparedStatement pstmt = null;
	   ResultSet rs = null;
	   ArrayList arrRow = new ArrayList();
	   ArrayList arrColumns = new ArrayList();
       
	   try{
	   dbConn = ConnectionManager.getConnection();
	   pstmt = dbConn.prepareCall(mainQuery);
	   rs = pstmt.executeQuery();

		while(rs.next())
		{
			for (int i = 0; i < numOfColumns; i++)
			{
			   arrColumns.add(rs.getString(i+1)+"");
			}
            arrRow.add(arrColumns);
			arrColumns = new ArrayList();
		    arrColumns.clear();
				
		}
	   }catch(Exception e)
		{
           e.printStackTrace();
		}
		finally {
           XHUtil.closeDBResources(rs, pstmt, dbConn);
		}
       // System.out.println("filer and shedule values...."+arrRow);
		return arrRow;
	}


	public HashMap<String,String[]> getFilterQueries(int levelCount, String filterGroupCode)
	{

       String[] filterTypeQuery;
	   String[] filterTypeElement;
	   String[] filterSubtypeQuery;
	   String[] elementQuery;

	   Connection conn = null;
	   PreparedStatement pstmt = null;
	   ResultSet rset = null;
	   int q=0;
	   HashMap<String, String[]> resultHashMap = new HashMap<String, String[]>();

       try{
           filterTypeQuery=new String[levelCount];
	       filterSubtypeQuery=new String[levelCount];
		   elementQuery=new String[levelCount];
		   filterTypeElement=new String[levelCount];


			String sql="select B.LEVEL_NUMBER,B.TYPE_QUERY,B.SUBTYPE_QUERY,B.LOOKUP_QUERY,B.FILTER_ELEMENT_TYPE_DESC,B.FILTER_SUBTYPE_DESC,B.ELEMENT_CODE_NAME,A.FACILITY_ID  from XH_FILTER_GROUP A,XH_FILTER_LEVEL_CONFIG B where B.FILTER_GROUP_CODE=A.FILTER_GROUP_CODE and B.FILTER_GROUP_CODE='"+filterGroupCode+"' ORDER BY 1 ";
			conn=ConnectionManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next())
			{
				if(rset.getString(2).toString().trim().indexOf(":FACILITY")!=-1)
				{
				  filterTypeQuery[q]=rset.getString(2).toString().trim().replaceAll(":FACILITY","'"+XHDBAdapter.checkNull(rset.getString(8).toString().trim())+"'");
				}
				else
				{
				  filterTypeQuery[q]=rset.getString(2);
				}
				//System.out.println("elementQuery valuae. ."+q+"..."+filterTypeQuery[q]);
				/*if(rset.getString(3).toString().trim().indexOf(":FACILITY")!=-1)
				{
				   filterSubtypeQuery[q]=rset.getString(3).toString().trim().replaceAll(":FACILITY","'"+XHDBAdapter.checkNull(rset.getString(8).toString().trim())+"'");
				}
				else
				{
				   filterSubtypeQuery[q]=rset.getString(3).toString();
				} */
				if(rset.getString(4).toString().trim().indexOf(":FACILITY")!=-1)
				{
				   elementQuery[q]=rset.getString(4).toString().trim().replaceAll(":FACILITY","'"+XHDBAdapter.checkNull(rset.getString(8).toString().trim())+"'");
				}
				else
				{
				   
				   elementQuery[q]=rset.getString(4).toString().trim();
				   //System.out.println("elementQuery valuae. ."+q+"..."+elementQuery[q]);
				}
				filterTypeElement[q]=rset.getString(7).trim();
				//System.out.println("filter type element name valuae. ."+q+"..."+filterTypeElement[q]);

				q++;

			}


         resultHashMap.put("TypeQueryArray",filterTypeQuery);
		 resultHashMap.put("SubTypeQueryArray",filterSubtypeQuery);
		 resultHashMap.put("ElementQueryArray",elementQuery);
		 resultHashMap.put("TypeElement",filterTypeElement);
          
	   }catch(Exception e)
		{
           e.printStackTrace();
		}
		finally{
		   XHUtil.closeDBResources(rset, pstmt, conn);

		}
		
       return resultHashMap;
	}



	@SuppressWarnings("rawtypes")
	public HashMap<String, TreeMap> getFinalValues(int levelCount,ArrayList arrRow,HashMap filterQueriesMap)
	{
		Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rset = null;
		ArrayList arrColumns = new ArrayList();
		HashMap finalMap=new HashMap<String,TreeMap>();
        try{
            
			TreeMap tretype=new TreeMap();
			TreeMap treelement=new TreeMap();
			
			String[] filterTypeQueryArray = (String[]) filterQueriesMap.get("TypeQueryArray");
			String[] filterElementQueryArray = (String[]) filterQueriesMap.get("ElementQueryArray");
			//String[] elementNameArray = (String[]) filterQueriesMap.get("TypeElement");
			
			
			conn = ConnectionManager.getConnection(); 
			for(int i=0;i<arrRow.size();i++)
			{
				arrColumns = (ArrayList)arrRow.get(i);

                int p=1;
                
                for(int k=0; k<levelCount;k++)
                {
                	String sql1=filterTypeQueryArray[k].toString().trim(); 
                	//String sql2=filterSubTypeQueryArray[k].toString().trim();
                	String sql3=filterElementQueryArray[k].toString().trim();
                	                	
                	for(int a=1;a<arrColumns.size();a++)
		              {
		              		   int val=a%4;
				               String pastestr=":"+(a);
				     		
				     		   if(val==0)
					     		  {
				     			   
					     		  }
				     		  else if(val==1)
				     		  {				     		     
				                  sql1=sql1.replaceAll(pastestr,"'"+XHDBAdapter.checkNull((String)arrColumns.get(a))+"'");
				     			  //sql2=sql2.replaceAll(pastestr,"'"+XHDBAdapter.checkNull((String)arrColumns.get(a))+"'");
				     			  sql3=sql3.replaceAll(pastestr,"'"+XHDBAdapter.checkNull((String)arrColumns.get(a))+"'");
				
				     		  }
				     		  else if(val==2)
				     	     {				     			 
				     			   sql1=sql1.replaceAll(pastestr,"'"+XHDBAdapter.checkNull((String)arrColumns.get(a))+"'");
				     			  // sql2=sql2.replaceAll(pastestr,"'"+XHDBAdapter.checkNull((String)arrColumns.get(a))+"'");
				     			   sql3=sql3.replaceAll(pastestr,"'"+XHDBAdapter.checkNull((String)arrColumns.get(a))+"'");
				              }
				     		  else if(val==3)
				     	     {
				     			  sql1=sql1.replaceAll(pastestr,"'"+XHDBAdapter.checkNull((String)arrColumns.get(a))+"'");
				     			  //sql2=sql2.replaceAll(pastestr,"'"+XHDBAdapter.checkNull((String)arrColumns.get(a))+"'");
				     			  sql3=sql3.replaceAll(pastestr,"'"+XHDBAdapter.checkNull((String)arrColumns.get(a))+"'");
				              }
		
		     	    }   
                	
                	//System.out.println("sql query 1..."+sql1);
                	//System.out.println("sql query 2..."+sql2);
                	//System.out.println("sql query 3..."+sql3);
                	
                	    try
		               	  {
		                		 pstmt = conn.prepareStatement(sql1);
		                		 rset = pstmt.executeQuery();
		               	 while(rset.next())
		               	 {
		                        tretype.put(rset.getString(2).toString().trim(),rset.getString(1).toString().trim());
		               	 }
		               	 
		               	  }
		               	  catch(Exception e)
		               	  {
		                       System.out.println("(FilteringAndQuerySearch.jsp::::exception) :"+e);
		               	  }
		                   finally
		               	    {
		               			/**/
		               	    }
                	    
                	    
                	    
                	  /*  try
                		  {
                	    	 pstmt = conn.prepareStatement(sql2);
                	    	 rset = pstmt.executeQuery();
	                		 while(rset.next())
	                		 {
	                	         tresubtype.put(rset.getString(2).toString().trim(),rset.getString(1).toString().trim());
	                		 }
	                	          
	
	                		  }
	                		  catch(Exception e)
	                		  {
	                			  System.out.println("(FilteringAndSchedulingApplicationLevel.jsp:Exception-2) :"+e);	 
	                		  }
	                		   finally
	                		      {
	                				
	                		      }
                	    
                	    */
                	    
                	    try
                		  {

                	    	pstmt = conn.prepareStatement(sql3);
                	    	rset = pstmt.executeQuery();
                		 while(rset.next())
                		 {
                	         treelement.put(rset.getString(2).toString().trim(),rset.getString(1).toString().trim());
                		 }
                		
                		  }
                	      catch(Exception e)
                		  {
                			  System.out.println("(FilteringAndQuerySearch.jsp::::exception-3) :"+e);
                		  }
                		   finally
                		      {
                				/**/
                		      }
                	
                }

			}
			finalMap.put("TreeType", tretype);
			//finalMap.put("TreeSubType", tretype);
			finalMap.put("TreeElement", treelement);
			
			//System.out.println("Tree element values...."+treelement);
			//System.out.println("Tree sub type values...."+tresubtype);
			//System.out.println("Tree main type values...."+tretype);

		}
		catch(Exception e)
		{
          e.printStackTrace();
		}

		finally{
           XHUtil.closeDBResources(rset, pstmt, conn);

		}
		return finalMap;
	}

}