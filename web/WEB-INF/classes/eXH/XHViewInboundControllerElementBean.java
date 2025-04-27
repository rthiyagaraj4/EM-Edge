/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.*;
import javax.servlet.http.HttpSession;
import java.net.*;
/**
 * Bean Class used to represent the XH Application Elements Bean
 *
 */
  
public class XHViewInboundControllerElementBean implements java.io.Serializable
{
  public static String strBeanName = "XH_APPL_ELEMENT_CROSS_REF";
 
  private String application_id = "";
  private int start = 0;
  private int end = 0;
  private int totalData = 0;
  private static int maxRec = 0;
  private TreeMap treemp = new TreeMap();
  private static boolean boolNext = false;
  private static boolean boolPrevious = false;
public static  String actionval="";
  public static  String appl_id="";
  public static  String facility_id="";
 //public static  String msg_type="";
  public static List listA = new LinkedList();
  public static List listB = new LinkedList();
public static  String srlno="";
  /**
   * Method  to accesss the data which returns string array
   */  
   public String[][] getDatabaseData()
  {
    String str[][] = null; 
    String key = "";
    Iterator iterator = null;
    XHViewInboundElementBean xhBean = null;
    String strItm[] = new String[3];
    String strNeeded[][] = null;
    try
    {
        str = new String[treemp.size()][3];
        iterator = this.enumerate();
        int j=0;
        while(iterator.hasNext())
        {
          key = iterator.next()+"";
          
          xhBean = this.getCodeDesc(key);
          if (!(xhBean.isChanged()))
          {
            continue;
          }
          strItm = xhBean.getDatabaseData();
          strItm[0] = this.application_id;
          str[j] =strItm;
          j++;
          
        }
          strNeeded = new String[j][4];
          System.arraycopy(str,0,strNeeded,0,j);
    }
    catch(Exception exp)
    {       
	   exp.printStackTrace(System.err);
    }
    return(strNeeded);
  }
/**
   * Method  getCodeDesc return bean element XHViewInboundElementBean  depending ob the key 
   * @param  String key
   * @return returns object type  XHViewInboundElementBean
   */   
  public XHViewInboundElementBean getCodeDesc(String key)
  {
    return((XHViewInboundElementBean)treemp.get(key));
  }
/**
   * Method to enumerate the keys 
   */
  public Iterator enumerate()
  {
    Set set = treemp.keySet();
    Iterator iterator = set.iterator();
    return iterator;          
  }
/** 
   * Method defined to get all the parameter values 
   * @param  HttpServletRequest request
   * @param  Connection conn
   */
	public void getAllParameterValues(HttpServletRequest request,Connection conn)
	{

		ListIterator iterator = listA.listIterator();
	//  Iterator iterator = enumerate();

		String strKey = "";
		XHViewInboundElementBean xhCode = null;

		try
		{
			request.setCharacterEncoding("UTF-8");
		}
		catch(Exception ex)
		{			
			ex.printStackTrace(System.err);
		}

		for (int i=0;i<start;i++)
		{
			iterator.next();
		}
		for(int i = start; i < end ;i++)
		{
			if (iterator.hasNext())
			{
				strKey = iterator.next()+"";
			}
			else
			{
				break;
			}
			
	
				xhCode.setChanged();
	
		}
	}
  /**
   * Method to add the values into the hashmap 
   */
 public HashMap getResultSet()
 {
  // Iterator iterator = enumerate();
  ListIterator iterator = listA.listIterator();
   ArrayList arrRow = null;
   String key = "";
   XHViewInboundElementBean xhCode = null;
   arrRow = new ArrayList();
   HashMap hashmp = new HashMap();
   for(int i=0;i<start;i++)
   {
     iterator.next();
   }
   for(int i=start;i<end;i++)
   {
      if (iterator.hasNext())
      {
        key = iterator.next()+"";
      }
      else
      {
        break;
      }
     xhCode = getCodeDesc(key);
     arrRow.add(xhCode.getArrayData());
     
   }
   hashmp.put("qry_result",arrRow);

   
   hashmp.put("next",new Boolean(boolNext));
   hashmp.put("previous",new Boolean(boolPrevious));
   return(hashmp);
 }
	/**
	 * Method to get single bean element 
	 * @param  String strBeanName
	 * @param  HttpServletRequest request
	 * @param  HttpSession session
	 */
	public static XHViewInboundControllerElementBean getBean(String strBeanName,
															HttpServletRequest request,
															HttpSession session)
	{
		String action = XHDBAdapter.checkNullZero(request.getParameter("action_type"));
		
		XHViewInboundControllerElementBean xhBean = null;
            maxRec=Integer.parseInt(XHDBAdapter.checkNullZero((String)request.getAttribute("maxRec")));
		if(action.equals("S")||action.equals("0"))
		{
		
			session.removeAttribute(strBeanName); 
			xhBean = new XHViewInboundControllerElementBean();
			session.setAttribute(strBeanName,xhBean);  
		}
		else
		{
			xhBean = (XHViewInboundControllerElementBean) session.getAttribute(strBeanName);
		}
		return(xhBean);
	}

/**
   * Method to define whether need to access elements or not depending on the action
   * @param  String action
   */
 private boolean decideParameterValues(String action)
 {
   if ( action.equals("P")||
        action.equals("N")||
        action.equals("R"))
  {
    return(true);
  }
  return false;
 }

	/**
	 * Method action to retrive jsp values 
	 * @param  HttpServletRequest request
	 * @param  Connection conn
	 */
	public void action(HttpServletRequest request,Connection conn)
	{
		HttpSession session = null;
		try
		{
			request.setCharacterEncoding("UTF-8");
			session = request.getSession(false);
		} 
		catch(Exception ex){}

		Properties p = (Properties) session.getValue("jdbc");	
		String locale = p.getProperty("LOCALE");
		String action = XHDBAdapter.checkNullZero(request.getParameter("action_type"));	
		
		if ((action.equals("S")) || (action.equals("0")))
		{
			listA.clear();

			actionval=action;
			
			this.populateXHCodeDesc(conn,locale,request);
			end = maxRec; 
		}
		else if(action.equals("Q"))
		{
			actionval=action;
			listA.clear();
			treemp.clear();  
			this.populateXHCodeDescPosition(conn,locale,request);
		}
		if (decideParameterValues(action) == true)
		{
			//getAllParameterValues(request,conn) ;
			
		}

         if(action.equals("L"))
		{
			//int tData=(totalData-1);
			actionval=action;
             //String iterator = listA.get(tData).toString();
		}

		if(action.equals("F"))
		{
			actionval=action;
			//String iterator = listA.get(0).toString();
		}
         if(action.equals("A"))
		{
			// String keyQry=(String)request.getAttribute("qryid"); 
		actionval=action;
			 
             //  getPositionRecord(keyQry);
             //  getPositionPage();
		}
           
		if (action.equals("N"))
		{
			start = start + maxRec;
			end = end + maxRec;
			if(start >= totalData)
			{
				start = start - maxRec;
				end = end - maxRec;
			}
		}

		if (action.equals("P"))
		{
			start = start - maxRec;
			end = end - maxRec;
			if (start <= 0)
			{
				start = 0;
				end = maxRec;
			}
		}

		if (totalData > end)
		{
			boolNext = true;
		}
		else
		{
			boolNext =  false;      
		}
		 
		if (end > maxRec)
		{
			boolPrevious = true;
		}
		else
		{
			boolPrevious = false;
		} 
	}

/**
   * Method to populate the  XHViewInboundElementBean Bean 
   * @param  Connection conn
   * @param  HttpServletRequest request
   * @param  String locale
  */
  public void populateXHCodeDesc(Connection conn,String locale,HttpServletRequest request)
  {
                      
    

	String qry_id = (String)request.getAttribute("qry_id");
	String viewQueryProcesswherecaluse = (String)request.getAttribute("whereClause");
//	System.out.println("XHViewInboundControllerElementBean wherecaluse query "+viewQueryProcesswherecaluse);
	String query=XHSQLSet.getSQL(qry_id)+(String)request.getAttribute("tableName")+viewQueryProcesswherecaluse;

//	System.out.println("XHViewInboundControllerElementBean query "+query);
    PreparedStatement pstmt = null;
	ResultSet rset = null; 


   try  
    {
      pstmt = conn.prepareStatement(query);
      //pstmt.setString(1,this.application_id);
      rset = pstmt.executeQuery();
	  int position=0;
      while(rset.next()) 
      {



		   listA.add(XHDBAdapter.checkNull(rset.getString(4))+XHDBAdapter.checkNull(rset.getString(37))+XHDBAdapter.checkNull(rset.getString(2))+XHDBAdapter.checkNull(rset.getString(25)));
		   //listB.add(position+"",XHDBAdapter.checkNull(rset.getString(4).toString().trim()));   
   		   
           treemp.put(XHDBAdapter.checkNull(rset.getString(4))+XHDBAdapter.checkNull(rset.getString(37))+XHDBAdapter.checkNull(rset.getString(2))+XHDBAdapter.checkNull(rset.getString(25)),new XHViewInboundElementBean(XHDBAdapter.checkNull(rset.getString(1)),XHDBAdapter.checkNull(rset.getString(2)),XHDBAdapter.checkNull(rset.getString(3)),XHDBAdapter.checkNull(rset.getString(4)),XHDBAdapter.checkNull(rset.getString(5)),XHDBAdapter.checkNull(rset.getString(6)),XHDBAdapter.checkNull(rset.getString(7)),XHDBAdapter.checkNull(rset.getString(8)),XHDBAdapter.checkNull(rset.getString(9)),XHDBAdapter.checkNull(rset.getString(10)),XHDBAdapter.checkNull(rset.getString(11)),XHDBAdapter.checkNull(rset.getString(12)),XHDBAdapter.checkNull(rset.getString(13)),XHDBAdapter.checkNull(rset.getString(14)),XHDBAdapter.checkNull(rset.getString(15)),XHDBAdapter.checkNull(rset.getString(16)),XHDBAdapter.checkNull(rset.getString(17)),XHDBAdapter.checkNull(rset.getString(18)),XHDBAdapter.checkNull(rset.getString(19)),XHDBAdapter.checkNull(rset.getString(20)),XHDBAdapter.checkNull(rset.getString(21)),XHDBAdapter.checkNull(rset.getString(22)),XHDBAdapter.checkNull(rset.getString(23)),XHDBAdapter.checkNull(rset.getString(24)),XHDBAdapter.checkNull(rset.getString(25)),XHDBAdapter.checkNull(rset.getString(26)),XHDBAdapter.checkNull(rset.getString(27)),XHDBAdapter.checkNull(rset.getString(28)),XHDBAdapter.checkNull(rset.getString(29)),XHDBAdapter.checkNull(rset.getString(30)),XHDBAdapter.checkNull(rset.getString(31)),XHDBAdapter.checkNull(rset.getString(32)),XHDBAdapter.checkNull(rset.getString(33)),XHDBAdapter.checkNull(rset.getString(34)),XHDBAdapter.checkNull(rset.getString(35)),XHDBAdapter.checkNull(rset.getString(36)),XHDBAdapter.checkNull(rset.getString(37)),position,XHDBAdapter.checkNull(rset.getString(38))));
          position++;
      }
      this.totalData = treemp.size();    
	  if(rset!=null) rset.close();
      if(pstmt!=null) pstmt.close(); 
    }
    catch(Exception exp)
    {       
	   exp.printStackTrace(System.err);
    }
  }
   public HashMap getPositionMsgRecord(String key)
	{
	

	    ArrayList arrRow1=new ArrayList();
		HashMap hashmp1=new HashMap();
	  
	   if(actionval.equals("L"))
		{
            String iteratorlast = listA.get((totalData-1)).toString();
            	XHViewInboundElementBean xhBean = this.getCodeDesc(iteratorlast);
           
		  arrRow1.add(xhBean.getArrayData());
		int position=xhBean.getPosition();
		if (((totalData-1) > position))
		{
			boolNext = true;
		}
		else
		{
			boolNext =  false;      
		}
 
		if (start < position)
		{
			boolPrevious = true;
		}
		else
		{
			boolPrevious = false;
		}


		}
		else if(actionval.equals("F")) 
		{
			 String iteratorfirst = listA.get(0).toString();  
 
			 XHViewInboundElementBean xhBean = this.getCodeDesc(iteratorfirst);
          
		  arrRow1.add(xhBean.getArrayData());
		int position=xhBean.getPosition();
		if (((totalData-1) > position))
		{
			boolNext = true;
		}
		else
		{
			boolNext =  false;      
		}
 
		if (start < position)
		{
			boolPrevious = true;
		}
		else
		{
			boolPrevious = false;
		}
		}
		else
		{
		
		XHViewInboundElementBean xhBean = this.getCodeDesc(key);
       
		  arrRow1.add(xhBean.getArrayData());

 		  
		int position=xhBean.getPosition();

		
		if (((totalData-1) > position))
		{
			boolNext = true;
		}
		else
		{
			boolNext =  false;      
		}
 
		if (start < position)
		{
			boolPrevious = true;
		}
		else
		{
			boolPrevious = false;
		}
		} 
 
    hashmp1.put("qry_result",arrRow1);
    hashmp1.put("next",new Boolean(boolNext));
    hashmp1.put("previous",new Boolean(boolPrevious));
    return (hashmp1);
	}
  

    public HashMap getQueryid(String key)
	{
   	 HashMap hashmp1=new HashMap();
	 
     hashmp1.put("next",new Boolean(boolNext));
     hashmp1.put("previous",new Boolean(boolPrevious));
     return (hashmp1);
	}
  public void populateXHCodeDescPosition(Connection conn,String locale,HttpServletRequest request)
  {
                      
    

	String qry_id = (String)request.getAttribute("qry_id");
	String viewQueryProcesswherecaluse = (String)request.getAttribute("whereClause");
	String query=XHSQLSet.getSQL(qry_id)+(String)request.getAttribute("tableName")+viewQueryProcesswherecaluse;

//	System.out.println("XHViewInboundControllerElementBean query "+query);
    PreparedStatement pstmt = null;
	ResultSet rset = null; 
   try  
    {
      pstmt = conn.prepareStatement(query);
      //pstmt.setString(1,this.application_id);
      rset = pstmt.executeQuery();
	  int position=0;
      while(rset.next()) 
      {
		   listA.add(position+"");
		   //listB.add(position+"",XHDBAdapter.checkNull(rset.getString(4).toString().trim()));   
   		
           treemp.put(position+"",new XHViewInboundElementBean(XHDBAdapter.checkNull(rset.getString(1)),XHDBAdapter.checkNull(rset.getString(2)),XHDBAdapter.checkNull(rset.getString(3)),XHDBAdapter.checkNull(rset.getString(4)),XHDBAdapter.checkNull(rset.getString(5)),XHDBAdapter.checkNull(rset.getString(6)),XHDBAdapter.checkNull(rset.getString(7)),XHDBAdapter.checkNull(rset.getString(8)),XHDBAdapter.checkNull(rset.getString(9)),XHDBAdapter.checkNull(rset.getString(10)),XHDBAdapter.checkNull(rset.getString(11)),XHDBAdapter.checkNull(rset.getString(12)),XHDBAdapter.checkNull(rset.getString(13)),XHDBAdapter.checkNull(rset.getString(14)),XHDBAdapter.checkNull(rset.getString(15)),XHDBAdapter.checkNull(rset.getString(16)),XHDBAdapter.checkNull(rset.getString(17)),XHDBAdapter.checkNull(rset.getString(18)),XHDBAdapter.checkNull(rset.getString(19)),XHDBAdapter.checkNull(rset.getString(20)),XHDBAdapter.checkNull(rset.getString(21)),XHDBAdapter.checkNull(rset.getString(22)),XHDBAdapter.checkNull(rset.getString(23)),XHDBAdapter.checkNull(rset.getString(24)),XHDBAdapter.checkNull(rset.getString(25)),XHDBAdapter.checkNull(rset.getString(26)),XHDBAdapter.checkNull(rset.getString(27)),XHDBAdapter.checkNull(rset.getString(28)),XHDBAdapter.checkNull(rset.getString(29)),XHDBAdapter.checkNull(rset.getString(30)),XHDBAdapter.checkNull(rset.getString(31)),XHDBAdapter.checkNull(rset.getString(32)),XHDBAdapter.checkNull(rset.getString(33)),XHDBAdapter.checkNull(rset.getString(34)),XHDBAdapter.checkNull(rset.getString(35)),XHDBAdapter.checkNull(rset.getString(36)),XHDBAdapter.checkNull(rset.getString(37)),position,XHDBAdapter.checkNull(rset.getString(38))));
          position++;
      }
      this.totalData = treemp.size();    
	  if(rset!=null) rset.close();
      if(pstmt!=null) pstmt.close();
    }
    catch(Exception exp)
    {       
	   exp.printStackTrace(System.err);
    }
  }
   public HashMap getPositionRecord(String key)
	{
	 

	    ArrayList arrRow1=new ArrayList();
		HashMap hashmp1=new HashMap();
	
	   if(actionval.equals("L"))
		{
            String iteratorlast = listA.get((totalData-1)).toString();
            	XHViewInboundElementBean xhBean = this.getCodeDesc(iteratorlast);
           
		  arrRow1.add(xhBean.getArrayData());
		int position=xhBean.getPosition();
		if (((totalData-1) > position))
		{
			boolNext = true;
		}
		else
		{
			boolNext =  false;      
		}
 
		if (start < position)
		{
			boolPrevious = true;
		}
		else
		{
			boolPrevious = false;
		}


		}
		else if(actionval.equals("F")) 
		{
			 String iteratorfirst = listA.get(0).toString();  
 
			 XHViewInboundElementBean xhBean = this.getCodeDesc(iteratorfirst);
          
		  arrRow1.add(xhBean.getArrayData());
		int position=xhBean.getPosition();
		if (((totalData-1) > position))
		{
			boolNext = true;
		}
		else
		{
			boolNext =  false;      
		}
 
		if (start < position)
		{
			boolPrevious = true;
		}
		else
		{
			boolPrevious = false;
		}
		}
		else
		{
		XHViewInboundElementBean xhBean = this.getCodeDesc(key);
       
		  arrRow1.add(xhBean.getArrayData());
		int position=xhBean.getPosition();

		
		if (((totalData-1) > position))
		{
			boolNext = true;
		}
		else
		{
			boolNext =  false;      
		}
 
		if (start < position)
		{
			boolPrevious = true;
		}
		else
		{
			boolPrevious = false;
		}
		}
 
    hashmp1.put("qry_result",arrRow1);
    hashmp1.put("next",new Boolean(boolNext));
    hashmp1.put("previous",new Boolean(boolPrevious));
    return (hashmp1);
	}
  






    public HashMap getPositionPage()
	{
		HashMap hashmp1=new HashMap();

    hashmp1.put("next",new Boolean(boolNext));
   hashmp1.put("previous",new Boolean(boolPrevious));
  return (hashmp1);
	}
  


 /*public HashMap getNextPositionRecord(String key)
	{
	

	    ArrayList arrRow1=new ArrayList();
		HashMap hashmp1=new HashMap();
	ArrayList arrcol=new ArrayList();

	   if(actionval.equals("L"))
		{
            String iteratorlast = listB.get((totalData-1)).toString();
		    XHViewInboundElementBean xhBean = this.getCodeDesc((totalData-1)+iteratorlast);
            arrRow1.add(xhBean.getArrayData());
			arrcol=arrRow1;
	 		boolNext = true;
			boolPrevious = true;
		
		}
		else if(actionval.equals("F")) 
		{
			 String iteratorfirst = listB.get(0).toString();  
 			 XHViewInboundElementBean xhBean = this.getCodeDesc("0"+iteratorfirst);
             arrRow1.add(xhBean.getArrayData());

			boolNext =  true;      
			boolPrevious = true;
		
		}
		else
		{
		 XHViewInboundElementBean xhBean = this.getCodeDesc(key);
		 String nextMsgId="";
 		 String preMsgid="";
		  arrRow1.add(xhBean.getArrayData());
			int position=xhBean.getPosition();
			int preposition=(position+1);
			int nextposition=(position+1);
				if(preposition>0)
			{
				preMsgid=listB.get(preposition+"");
				XHViewInboundElementBean xhBeanpre = this.getCodeDesc(preposition+preMsgid); 
				arrRow1.add(xhBeanpre.getPreviousArrayData()); 
			}
			if(nextposition<(totalData-1))
			{
				nextMsgId=listB.get(nextposition+"");
				XHViewInboundElementBean xhBeannext = this.getCodeDesc(nextposition+nextMsgId); 
				arrRow1.add(xhBeannext.etNextArrayData());
			}
	
		arrcol=arrRow1;
        
		if (((totalData-1) > nextposition))
		{
			boolNext = true;
		}
		else
		{
			boolNext =  false;      
		}
 
		if (start < nextposition)
		{
			boolPrevious = true;
		}
		else
		{
			boolPrevious = false;
		}
		}
 
    hashmp1.put("qry_result",arrcol);
    hashmp1.put("next",new Boolean(boolNext));
    hashmp1.put("previous",new Boolean(boolPrevious));
    return (hashmp1);
	}
*/


}//end of class
