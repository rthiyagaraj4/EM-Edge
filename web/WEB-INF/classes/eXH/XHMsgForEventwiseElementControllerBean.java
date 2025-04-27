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
  
public class XHMsgForEventwiseElementControllerBean implements java.io.Serializable
{
  public static String strBeanName = "XH_APPL_ELEMENT_CROSS_REF";
																						    
  private String application_id = "";
  private int start = 0; 																    
  private int end = 0;
  private int totalData = 0;
  private int maxRec = 13;
  private TreeMap treemp = new TreeMap();
  private boolean boolNext = false;
  private boolean boolPrevious = false;
  public static List listA = new LinkedList();
  public static  String appl_id="";
  public static  String standard_code="";
  public static  String event_type="";
   public static  String selectall="N";
/**
   * Method  to accesss the data which returns string array
   */  public String[][] getDatabaseData()
  {
    String str[][] = null; 
    String key = "";
    Iterator iterator = null;
    XHMsgForEventwiseBean xhBean = null;
    String strItm[] = new String[8];
    String strNeeded[][] = null;
    try
    {														  
        str = new String[treemp.size()][8];
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
          strNeeded = new String[j][7];
          System.arraycopy(str,0,strNeeded,0,j);
    }
    catch(Exception exp)
    {
       System.out.println("Error in getdatabasedata method of xhapplicationcontrollerbean :"+exp.toString());
	   exp.printStackTrace(System.err);
    }
    return(strNeeded);
  }
/**
   * Method  getCodeDesc return bean element XHMsgForEventwiseBean  depending ob the key 
   * @param  String key
   * @return returns object type  XHMsgForEventwiseBean
   */   
  public XHMsgForEventwiseBean getCodeDesc(String key)
  {
    return((XHMsgForEventwiseBean)treemp.get(key));
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
  	String strKey = "",strInUse="",strProfileCode="",setProfileDesc="",stroption="",strField="",strRepeat="";
    XHMsgForEventwiseBean xhCode = null;
	try{
	request.setCharacterEncoding("UTF-8");
	}catch(Exception ex){ System.out.println("Error in getallparamtervalues method of xhapplicationcontrollerbean :"+ex.toString());
	   ex.printStackTrace(System.err);}
    for (int i=0;i<start;i++)
    {
      iterator.next();
    }
    for(int i=start;i<end;i++)
    {
      if (iterator.hasNext())  
      {
        strKey = iterator.next()+"";
      }
      else
      {
        break;
      }
		strInUse = XHDBAdapter.checkNullForCheckBox(request.getParameter(strKey+"_inuse"));
		stroption= XHDBAdapter.checkNullForCheckBox(request.getParameter(strKey+"_optional_yn"));
		strField = XHDBAdapter.checkNullForCheckBox(request.getParameter(strKey+"_field"));
		strProfileCode= XHDBAdapter.checkNull(request.getParameter(strKey+"_profile_id"));
		setProfileDesc=XHDBAdapter.checkNull(request.getParameter(strKey+"_profile_desc"));
		strRepeat=XHDBAdapter.checkNull(request.getParameter(strKey+"_repeat"));
		xhCode = getCodeDesc(strKey);
		xhCode.setFieldchange(strField);
		xhCode.setProfileCode(strProfileCode);		 
	    xhCode.setOptionYN(stroption);
        xhCode.setInuse(strInUse);
	    xhCode.setProfileDesc(setProfileDesc);
		xhCode.setRepeatYN(strRepeat);
	    xhCode.setChanged(); 
    }
  }
  /**
   * Method to add the values into the hashmap 
   */
 public HashMap getResultSet()
 {
	 ListIterator iterator = listA.listIterator();
   //Iterator iterator = enumerate();
   ArrayList arrRow = null;
   String key = "";
   XHMsgForEventwiseBean xhCode = null;
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
   hashmp.put("start",start+"");
   hashmp.put("end",end+"");
   hashmp.put("selectall",selectall);
   return(hashmp);
 } 
/**
   * Method to get single bean element 
   * @param  String strBeanName
   * @param  HttpServletRequest request
   * @param  HttpSession session
   */

 public static XHMsgForEventwiseElementControllerBean getBean(String strBeanName,
														  HttpServletRequest request,
														  HttpSession session)
 {
     String action  = XHDBAdapter.checkNullZero(request.getParameter("action_type"));
     XHMsgForEventwiseElementControllerBean xhBean = null;
     if(action.equals("S")||action.equals("0"))
     {
      listA.clear();
      session.removeAttribute(strBeanName); 
      xhBean = new XHMsgForEventwiseElementControllerBean();
      session.setAttribute(strBeanName,xhBean); 
    }
    else
    {
      xhBean = (XHMsgForEventwiseElementControllerBean) session.getAttribute(strBeanName);
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
        action.equals("R")||action.equals("A"))
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
	 HttpSession session=null;
	 try{
	 request.setCharacterEncoding("UTF-8");
	 session=request.getSession(false);
	 } catch(Exception ex){}
	 Properties p;		
	 p = (Properties) session.getValue("jdbc");	
     String locale  = p.getProperty("LOCALE");
        String action  = XHDBAdapter.checkNullZero(request.getParameter("action_type"));
      String strStart="";

  	 appl_id=XHDBAdapter.checkNull((String)request.getAttribute("application_Id"));
     
	  event_type=XHDBAdapter.checkNull((String)request.getAttribute("message_type"));
    
	 standard_code= XHDBAdapter.checkNull((String)request.getAttribute("standard_code"));
 

    if ((action.equals("S"))||(action.equals("0")))
    {
      this.application_id =  request.getParameter("applicationid");
      this.populateXHCodeDesc(conn,locale);
      end = maxRec;
    }
    if (decideParameterValues(action) == true)
    getAllParameterValues(request,conn) ;
    if (action.equals("N"))
    {
		
      start = start+maxRec;
			end = end+maxRec;
      if(start>=totalData)
      {
        start = start - maxRec;
        end = end-maxRec;
        
      }
    }
    if (action.equals("P"))
    {
      start = start - maxRec;
      end = end-maxRec;
      if (start<=0)
      {
        start = 0;
        end = maxRec;
        
      }
    }

if (action.equals("A"))
    {
	  
 	    Iterator iterator = null;
		XHMsgForEventwiseBean xhBean=null; 
	    iterator = this.enumerate();
   
   		String key="";
 		 while(iterator.hasNext())
		 {
		   key = iterator.next()+"";
		 }  
          xhBean = this.getCodeDesc(key);
    	  strStart= XHDBAdapter.checkNullZero(request.getParameter("select_all"+start));
          xhBean.setStart(strStart);
		  selectall=xhBean.getStart();
		
		  start = start ;
		  end = end;
	} 


     if (totalData>end)
    {
      boolNext =  true;
    }
    else
    {
      boolNext =  false;      
    }
    if (end>maxRec)
    {
      boolPrevious =  true;
    }
    else
    {
      boolPrevious =  false;
    }
}

/**
   * Method to populate the  XHMsgForEventwiseBean Bean 
   * @param  Connection conn
   * @param  HttpServletRequest request
   * @param  String locale
  */
  public void populateXHCodeDesc(Connection conn,String locale)
  {

    
	

	
	/*   	String sqlString="SELECT d.segment_type, c.segment_name, NVL (d.optional_yn, 'N'),NVL (d.in_use_yn, 'N'), NVL (c.optional_yn, 'N') master_optional_yn,d.profile_id, e.short_desc, c.standard_desc, c.event_type,c.standard_code, c.segment_seq, 'B' status,c.COMMUNICATION_TYPE,d.REPEATABLE_YN  FROM xh_appl_event_segment d,xh_standard_profile e,(SELECT z.event_type event_type,  '"+appl_id+"'  application_id,b.segment_type segment_type,a.segment_name segment_name,b.optional_yn optional_yn,a.standard_code standard_code,f.standard_desc standard_desc,l.segment_seq,z.COMMUNICATION_TYPE FROM xh_segment_lang_vw a,xh_appl_event_segment b,xh_application_event_type z,xh_standard f,xh_event_type_segment l WHERE l.IN_USE_YN='Y' and  b.segment_type != 'ALL' AND b.segment_type = a.segment_type AND z.event_type = b.event_type AND a.standard_code = f.standard_code(+) AND b.event_type = l.event_type AND l.segment_type = a.segment_type  AND b.application_id = '"+appl_id+"'  AND z.application_id = '"+appl_id+"' AND a.language_id = '"+locale+"' AND z.event_type IN (SELECT g.event_type FROM xh_application_event_type g,xh_event_type_lang_vw h WHERE g.in_use_yn = 'Y' AND g.event_type = h.event_type AND g.application_id = '"+appl_id+"' AND h.language_id = '"+locale+"' and f.STANDARD_CODE=nvl('"+standard_code+"',f.STANDARD_CODE) AND  g.event_type = NVL ('"+event_type+"', g.event_type))) c WHERE c.application_id = d.application_id AND c.segment_type = d.segment_type(+) AND c.event_type = d.event_type(+) AND d.profile_id = e.profile_id(+) UNION SELECT   b.segment_type, a.segment_name, b.optional_yn, b.in_use_yn,NVL (b.optional_yn, 'N') master_optional_yn, '' profile_id,'' short_desc, f.standard_desc standard_desc,b.event_type event_type, a.standard_code standard_code, b.segment_seq,'G' status,z.COMMUNICATION_TYPE  FROM xh_segment_lang_vw a,xh_event_type_segment b,xh_standard f,xh_application_event_type z WHERE b.IN_USE_YN='Y' and  b.segment_type = a.segment_type AND a.standard_code = f.standard_code(+) AND b.event_type = z.event_type AND a.language_id = '"+locale+"' AND (b.segment_type, z.event_type) NOT IN (SELECT segment_type, event_type FROM xh_appl_event_segment WHERE application_id = '"+appl_id+"' AND event_type = NVL ('"+event_type+"', event_type)) AND b.event_type = NVL ('"+event_type+"', b.event_type) AND z.application_id = '"+appl_id+"' and f.STANDARD_CODE=nvl('"+standard_code+"',f.STANDARD_CODE) AND z.in_use_yn = 'Y' ORDER BY 9, 11";	*/

	   	String sqlString="SELECT d.segment_type, c.segment_name, NVL (d.optional_yn, 'N'),NVL (d.in_use_yn, 'N'), NVL (c.optional_yn, 'N') master_optional_yn,d.profile_id, e.short_desc, c.standard_desc, c.event_type,c.standard_code, c.segment_seq, 'B' status,c.COMMUNICATION_TYPE,d.repeatable_yn  FROM xh_appl_event_segment d,xh_standard_profile e,(SELECT z.event_type event_type,  '"+appl_id+"'  application_id,b.segment_type segment_type,a.segment_name segment_name,b.optional_yn optional_yn,a.standard_code standard_code,f.standard_desc standard_desc,l.segment_seq,z.COMMUNICATION_TYPE FROM xh_segment_lang_vw a,xh_appl_event_segment b,xh_application_event_type z,xh_standard f,xh_event_type_segment l WHERE l.IN_USE_YN='Y' and  b.segment_type != 'ALL' AND b.segment_type = a.segment_type AND z.event_type = b.event_type AND a.standard_code = f.standard_code(+) AND b.event_type = l.event_type AND l.segment_type = a.segment_type  AND b.application_id = '"+appl_id+"'  AND z.application_id = '"+appl_id+"' AND a.language_id = '"+locale+"' AND z.event_type IN (SELECT g.event_type FROM xh_application_event_type g,xh_event_type_lang_vw h WHERE g.in_use_yn = 'Y' AND g.event_type = h.event_type AND g.application_id = '"+appl_id+"' AND h.language_id = '"+locale+"' and f.STANDARD_CODE=nvl('"+standard_code+"',f.STANDARD_CODE) AND  g.event_type = NVL ('"+event_type+"', g.event_type))) c WHERE c.application_id = d.application_id AND c.segment_type = d.segment_type(+) AND c.event_type = d.event_type(+) AND d.profile_id = e.profile_id(+) UNION SELECT   b.segment_type, a.segment_name, b.optional_yn, b.in_use_yn,NVL (b.optional_yn, 'N') master_optional_yn, '' profile_id,'' short_desc, f.standard_desc standard_desc,b.event_type event_type, a.standard_code standard_code, b.segment_seq,'G' status,z.COMMUNICATION_TYPE,''  FROM xh_segment_lang_vw a,xh_event_type_segment b,xh_standard f,xh_application_event_type z WHERE b.IN_USE_YN='Y' and  b.segment_type = a.segment_type AND a.standard_code = f.standard_code(+) AND b.event_type = z.event_type AND a.language_id = '"+locale+"' AND (b.segment_type, z.event_type) NOT IN (SELECT segment_type, event_type FROM xh_appl_event_segment WHERE application_id = '"+appl_id+"' AND event_type = NVL ('"+event_type+"', event_type)) AND b.event_type = NVL ('"+event_type+"', b.event_type) AND z.application_id = '"+appl_id+"' and f.STANDARD_CODE=nvl('"+standard_code+"',f.STANDARD_CODE) AND z.in_use_yn = 'Y' ORDER BY 9, 11";
 
 		  int countSize=countRows(conn,locale);
		 int lastrec=0;
     System.out.println("XHMsgForEventwiseElementControllerBean sql 346"+sqlString); 	
	 PreparedStatement pstmt = null;													 
    ResultSet rset = null;  
     try   																																 {
      pstmt = conn.prepareStatement(sqlString);
      //pstmt.setString(1,this.application_id);
      rset = pstmt.executeQuery(); 							 
	
	  System.out.println(" countSize :"+countSize);
	  while(rset.next())
      {																  
		  listA.add(rset.getString(1)+rset.getString(9));
          treemp.put(rset.getString(1)+rset.getString(9),new XHMsgForEventwiseBean(XHDBAdapter.checkNull(rset.getString(1)),XHDBAdapter.checkNull(rset.getString(2)),XHDBAdapter.checkNull(rset.getString(3)),XHDBAdapter.checkNull(rset.getString(4)),XHDBAdapter.checkNull(rset.getString(5)),XHDBAdapter.checkNull(rset.getString(6)),XHDBAdapter.checkNull(rset.getString(7)),XHDBAdapter.checkNull(rset.getString(8)),XHDBAdapter.checkNull(rset.getString(9)),XHDBAdapter.checkNull(rset.getString(10)),XHDBAdapter.checkNull(rset.getString(11)),XHDBAdapter.checkNull(rset.getString(12)),"N",countSize,lastrec,XHDBAdapter.checkNull(rset.getString(13)),XHDBAdapter.checkNull(rset.getString(14)))) ;	   
		  lastrec++; 
      }																						 
      this.totalData = treemp.size();
	  if(rset!=null) rset.close(); 								 					  
      if(pstmt!=null) pstmt.close();				 					 		     
    }
    catch(Exception exp)
    {
       System.out.println("Error in populatexhcodedesc method of xhapplicationcontrollerbean :"+exp.toString());
	   exp.printStackTrace(System.err);
    }
  }
  
  public int countRows(Connection conn,String locale) {								 
	  ResultSet rs=null;
	  PreparedStatement pstmt = null;
	  String sqlString="SELECT d.segment_type, c.segment_name, NVL (d.optional_yn, 'N'),NVL (d.in_use_yn, 'N'), NVL (c.optional_yn, 'N') master_optional_yn,d.profile_id, e.short_desc, c.standard_desc, c.event_type,c.standard_code, c.segment_seq, 'B' status FROM xh_appl_event_segment d,xh_standard_profile e,(SELECT DISTINCT z.event_type event_type, '"+appl_id+"' application_id,b.segment_type segment_type,a.segment_name segment_name,b.optional_yn optional_yn,a.standard_code standard_code,f.standard_desc standard_desc,l.segment_seq FROM xh_segment_lang_vw a,xh_appl_event_segment b,xh_application_event_type z,xh_standard f,xh_event_type_segment l WHERE l.IN_USE_YN='Y' and  b.segment_type != 'ALL' AND b.segment_type = a.segment_type AND z.event_type = b.event_type AND a.standard_code = f.standard_code(+) AND b.event_type = l.event_type AND l.segment_type = a.segment_type  AND b.application_id = '"+appl_id+"'  AND a.language_id = '"+locale+"' AND z.event_type IN (SELECT g.event_type FROM xh_application_event_type g,xh_event_type_lang_vw h WHERE g.in_use_yn = 'Y' AND g.event_type = h.event_type AND g.application_id = '"+appl_id+"' AND h.language_id = '"+locale+"' and f.STANDARD_CODE=nvl('"+standard_code+"',f.STANDARD_CODE) AND  g.event_type = NVL ('"+event_type+"', g.event_type))) c WHERE c.application_id = d.application_id AND c.segment_type = d.segment_type(+) AND c.event_type = d.event_type(+) AND d.profile_id = e.profile_id(+) UNION SELECT   b.segment_type, a.segment_name, b.optional_yn, b.in_use_yn,NVL (b.optional_yn, 'N') master_optional_yn, '' profile_id,'' short_desc, f.standard_desc standard_desc,b.event_type event_type, a.standard_code standard_code, b.segment_seq,'G' status FROM xh_segment_lang_vw a,xh_event_type_segment b,xh_standard f,xh_application_event_type z WHERE b.IN_USE_YN='Y' and  b.segment_type = a.segment_type AND a.standard_code = f.standard_code(+) AND b.event_type = z.event_type AND a.language_id = '"+locale+"' AND (b.segment_type, z.event_type) NOT IN (SELECT segment_type, event_type FROM xh_appl_event_segment WHERE application_id = '"+appl_id+"' AND event_type = NVL ('"+event_type+"', event_type)) AND b.event_type = NVL ('"+event_type+"', b.event_type) AND z.application_id = '"+appl_id+"' AND z.in_use_yn = 'Y' and  f.STANDARD_CODE=nvl('"+standard_code+"',f.STANDARD_CODE) ORDER BY 9, 11";
	  int size=0;

	  try
	  {
		  pstmt = conn.prepareStatement(sqlString);
		  //pstmt.setString(1,this.application_id);
		rs = pstmt.executeQuery();
			while(rs.next())
		  {
			  size++;
		  }
		  if(rs!=null)rs.close();
		  if(pstmt!=null)pstmt.close();
	  }
	  catch(Exception e)
	  {
		  System.out.println("Errors in"+e);
	  }
	  finally
	  {
		  
	  }
return size; 
}

  
}//end of class
