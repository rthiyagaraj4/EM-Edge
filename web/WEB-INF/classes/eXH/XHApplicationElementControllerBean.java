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
  
public class XHApplicationElementControllerBean implements java.io.Serializable
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
public static  String Segment_id="";
  public static  String standard_code="";
public static  String element_code="";
public static  String element_desc="";

/**
   * Method  to accesss the data which returns string array
   */  public String[][] getDatabaseData()
  {
    String str[][] = null; 
    String key = "";
    Iterator iterator = null;
    XHApplicationElementsBean xhBean = null;
    String strItm[] = new String[9];
    String strNeeded[][] = null;
    try
    {
        str = new String[treemp.size()][9];
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
          strNeeded = new String[j][10];
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
   * Method  getCodeDesc return bean element XHApplicationElementsBean  depending ob the key 
   * @param  String key
   * @return returns object type  XHApplicationElementsBean
   */   
  public XHApplicationElementsBean getCodeDesc(String key)
  {
    return((XHApplicationElementsBean)treemp.get(key));
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
	  String elementattr1="";
	  	  String elementattr2="";
		
    Iterator iterator = enumerate();
    String strKey = "",strFormat = "",strInUse="",strElementValue="",strTranlateentity="",strehisentity="",strpkelementref="",strtranslatequery="",strehisentitydesc="",strAttname="",strAttname2="",strField="";
    XHApplicationElementsBean xhCode = null;
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
      strInUse = XHDBAdapter.checkNullForCheckBox(request.getParameter(strKey+"_check"));
      strFormat= XHDBAdapter.checkNull(request.getParameter(strKey+"_format"));
	  strehisentitydesc=XHDBAdapter.checkNull(request.getParameter(strKey+"ehis_entity"));
  strField = XHDBAdapter.checkNullForCheckBox(request.getParameter(strKey+"_field"));

if(strehisentitydesc.equals(""))
		{
strehisentity="";
strTranlateentity="";
elementattr1="";
elementattr2="";
strpkelementref="";
		}
		else
		{
strehisentity=XHDBAdapter.checkNull(request.getParameter(strKey+"ehis_id"));
strTranlateentity=XHDBAdapter.checkNull(request.getParameter(strKey+"_entity"));
elementattr1=XHDBAdapter.checkNull(request.getParameter(strKey+"element_id"));
elementattr2=XHDBAdapter.checkNull(request.getParameter(strKey+"element_ida2")); 
strAttname=XHDBAdapter.checkNull(request.getParameter(strKey+"element_name"));
strAttname2=XHDBAdapter.checkNull(request.getParameter(strKey+"element_namea2"));
strtranslatequery=XHDBAdapter.checkNull(java.net.URLDecoder.decode(request.getParameter(strKey+"Translation_query")));


	if(elementattr1.equals(""))
		{
elementattr1="";

		}
if(strAttname2.equals(""))
{

elementattr2="";
}



if(elementattr1.equals("") && strAttname2.equals(""))
		{
        strpkelementref="";

		}
else
		{
	       if(strAttname2.equals(""))
			{
              strpkelementref=elementattr1;
			}
			else
			{
				if(elementattr2.equals(""))
				{
					strpkelementref=elementattr1;
				}
				else
				{
					strpkelementref=elementattr2+"|"+elementattr1;
				}
			}

  
		}
		}

//strpkelementref=XHDBAdapter.checkNull(request.getParameter(strKey+"element_id"))+"|"+XHDBAdapter.checkNull(request.getParameter(strKey+"element_ida2"));

   xhCode = getCodeDesc(strKey);
 

if(strtranslatequery.equals(""))
		{

		}
		else
		{
           strpkelementref="";
		}

 xhCode.setTranslateEntity(strTranlateentity);
 xhCode.setehisEntity(strehisentity);
 xhCode.setconAttribute(strpkelementref);
 xhCode.setTranslateQuery(strtranslatequery);
      xhCode.setFormatType(strFormat);
     xhCode.setElementValue(strElementValue);
xhCode.setFieldchange(strField);

xhCode.setInuse(strInUse);
      xhCode.setChanged();
   
    }
  }
  /**
   * Method to add the values into the hashmap 
   */
 public HashMap getResultSet()
 {
   Iterator iterator = enumerate();
   ArrayList arrRow = null;
   String key = "";
   XHApplicationElementsBean xhCode = null;
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

 public static XHApplicationElementControllerBean getBean(String strBeanName,
														  HttpServletRequest request,
														  HttpSession session)
 {
     String action  = XHDBAdapter.checkNullZero(request.getParameter("action_type"));
     XHApplicationElementControllerBean xhBean = null;
     if(action.equals("S")||action.equals("0"))
     {
      
      session.removeAttribute(strBeanName); 
      xhBean = new XHApplicationElementControllerBean();
      session.setAttribute(strBeanName,xhBean); 
    }
    else
    {
      xhBean = (XHApplicationElementControllerBean) session.getAttribute(strBeanName);
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
	 HttpSession session=null;
	 try{
	 request.setCharacterEncoding("UTF-8");
	 session=request.getSession(false);
	 } catch(Exception ex){}
	 Properties p;		
	 p = (Properties) session.getValue("jdbc");	
     String locale  = p.getProperty("LOCALE");
    String action  = XHDBAdapter.checkNullZero(request.getParameter("action_type"));
    Segment_id=XHDBAdapter.checkNull((String)request.getAttribute("Sement_type"));
    standard_code=XHDBAdapter.checkNull((String)request.getAttribute("standard_code"));
	element_desc=XHDBAdapter.checkNull((String)request.getAttribute("element_desc"));
    element_code=XHDBAdapter.checkNull((String)request.getAttribute("element_id"));
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
   * Method to populate the  XHApplicationElementsBean Bean 
   * @param  Connection conn
   * @param  HttpServletRequest request
   * @param  String locale
  */
  public void populateXHCodeDesc(Connection conn,String locale)
  {

    String sql="SELECT A.ELEMENT_ID,A.ELEMENT_NAME,B.FORMAT_TYPE,B.IN_USE_YN,B.ELEMENT_VALUE,'N',B.TRANSLATION_TABLE,B.EHIS_ENTITY,B.PK_ELEMENT_REF,B.TRANS_QUERY,A.MEDICOM_MASTER_TABLE"+
    " FROM XH_APPL_ELEMENT B,XH_ELEMENT_CROSSREF  A "+
    " WHERE B.ELEMENT_ID = A.ELEMENT_ID "+
    " AND A.IN_USE_YN = 'Y' "+
//    " AND A.STANDARD_TYPE=NVL('"+standard_code+"',A.STANDARD_TYPE) AND A.SEGMENT_TYPE=NVL('"+Segment_id+"',A.SEGMENT_TYPE) "+
    " AND (B.APPLICATION_ID='"+this.application_id +"' OR B.APPLICATION_ID IS NULL) and A.ELEMENT_ID like('"+element_code+"%') and A.ELEMENT_NAME like ('"+element_desc+"%')"+
    " UNION "+
    " SELECT ELEMENT_ID,ELEMENT_NAME,'H','N',NULL,'C',NULL,null,null,null,MEDICOM_MASTER_TABLE"+
    " FROM  XH_ELEMENT_CROSSREF "+
    " WHERE IN_USE_YN='Y' "+
    //" AND STANDARD_TYPE=NVL('"+standard_code+"',STANDARD_TYPE) AND SEGMENT_TYPE=NVL('"+Segment_id+"',SEGMENT_TYPE) "+
    " AND ELEMENT_ID  NOT IN (SELECT ELEMENT_ID FROM XH_APPL_ELEMENT WHERE(APPLICATION_ID='"+this.application_id +"' OR APPLICATION_ID IS NULL) ) and ELEMENT_ID like('"+element_code+"%') and ELEMENT_NAME like ('"+element_desc+"%') ";    
	
//System.out.println("sql :"+sql);
	
	PreparedStatement pstmt = null;
    ResultSet rset = null; 
     try  
    {
      pstmt = conn.prepareStatement(sql);
      //pstmt.setString(1,this.application_id);
      rset = pstmt.executeQuery();
      while(rset.next())
      {
        treemp.put(rset.getString(1),new XHApplicationElementsBean(XHDBAdapter.checkNull(rset.getString(1)),XHDBAdapter.checkNull(rset.getString(2)),XHDBAdapter.checkNull(rset.getString(3)),XHDBAdapter.checkNull(rset.getString(4)),XHDBAdapter.checkNull(rset.getString(5)),XHDBAdapter.checkNull(rset.getString(6)),XHDBAdapter.checkNull(rset.getString(7)),XHDBAdapter.checkNull(rset.getString(8)),XHDBAdapter.checkNull(rset.getString(9)),XHDBAdapter.checkNull(rset.getString(10)),XHDBAdapter.checkNull(rset.getString(11)),"N")) ;
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
  
  
}//end of class
