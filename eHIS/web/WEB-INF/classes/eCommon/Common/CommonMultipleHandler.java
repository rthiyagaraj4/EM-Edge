/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCommon.Common ;

import javax.servlet.http.* ;
import java.util.*;

public class CommonMultipleHandler implements java.io.Serializable {
    /**
    * This is holder for the user Beans
    */

    private Hashtable holder = null;
    private Hashtable mapper = null;

    /**
    * This is Maps the user Beans with Function ID
    */

    /**
    * Any Bean having this Charater in the Function ID would not be removed
    unless Explicity Removed called by the Special Method.
    */

    //private static final String SPECIAL_HOLDER =  "@" ;

    /**
    * Public Constructer
    */
    public CommonMultipleHandler() {
        holder =  new Hashtable();
        mapper =  new Hashtable();
    }

    /**
    * This method the Object Corresponding to the class and the name supplied by the user
    * it will create new if the Object is not already binded in the session .
    * It also sets all the request Parameters to  the corresponding beans Setter
    * methods ...This is to be Called in the  Servlet
    *
    * deprected
    */

    public synchronized Object getObjectSetParameter(String objectName, final HttpServletRequest params, String className) throws Exception {
        CommonAdapter userBean = null ;

        userBean = (CommonAdapter)getObject(objectName, params, className);

        return userBean ;
    }


/**
 *
 * This method only creates the instance of the object if not in
 * repositrory and set 's the values from the request object to the corresponding
 * Beans business variables
 * @param objectName    Name of the object requested
 * @param params          HTTPServletRequest object
 * @param className     Name of the Class
 * @return                    Object
 * @throws Exception
 */
    private synchronized Object getObject(String objectName, final HttpServletRequest params,  String className) throws Exception {
        CommonAdapter userBean =null ;

        if(params == null )
            throw new Exception("Request Object Passed is null");

        if(holder.containsKey(objectName.trim().toUpperCase()))
            userBean = (CommonAdapter)holder.get(objectName.trim().toUpperCase());
        else {
            //if not then Create and then set in the repository
            userBean = (CommonAdapter)getObject(objectName,className);
            setInRepository(objectName , className , params , userBean );
        }

        //Hashtable hm = getRequestAsHash(params) ;
        return userBean ;
    }

    /**
    *This Method is intended to only instaintiates the object of the given
    *class bUT IT DOES NOT PUT IT IN REPOSITORY
    */

    private synchronized Object getObject(String objectName, String className) throws Exception {
        if(objectName == null || objectName.trim().equals(""))
            throw new Exception("Object name is not specifed")  ;

        if(className == null || className.trim().equals(""))
            throw new Exception("Class name is not specifed")   ;

        Class UserClass = Class.forName(className);
        // Class UserClass = Class.forName(className, true, this.getClass().getClassLoader()) ;
        // Class UserClass = (this.getClass().getClassLoader()).loadClass(className) ;
         Object userBean = UserClass.newInstance();

        if(!(userBean instanceof CommonAdapter))
            throw new Exception("The Class Should be the  Object of the CommonAdapter Class");

        CommonAdapter userbean = (CommonAdapter)userBean ;

        return userbean ;
    }

/**
 *
 * This Method Creates the  Object and sets in the  Repository(session)
 * no setting of the Parameters.
  *@param objectName    Name of the object requested
  * @param params          HTTPServletRequest object
  * @param className     Name of the Class
  * @return                    Object
  * @throws Exception
 */
    public synchronized Object getBeanObject(String objectName,  final HttpServletRequest params ,String className) throws Exception {
        try {
            CommonAdapter userBean = null ;

            // System.err.println( "Is Available:"+(objectName.trim()).toUpperCase()+","+holder.get((objectName.trim()).toUpperCase()) ) ;
            if(holder.containsKey(objectName.trim().toUpperCase()))
            {
                userBean = (CommonAdapter)holder.get(objectName.trim().toUpperCase());
            }
            else {
                userBean = (CommonAdapter)getObject(objectName,className);
                    // System.err.println( params.getRemoteHost()+", Multiple Handler: New Object is Created:"+className ) ;
                setInRepository(objectName , className , params ,userBean);
            }

            HttpSession session = params.getSession(false);
            userBean.setProperties( (Properties) session.getValue( "jdbc" ) ) ;
            userBean.setLoginById( (String) session.getValue( "login_user" ) ) ;
            userBean.setLoginFacilityId( (String) session.getValue( "facility_id" ) ) ;
            userBean.setAccEntityID( (String) session.getValue( "ACC_ENTITY_ID" ) ) ;
			userBean.setLoginAtWsNo( userBean.getProperties().getProperty( "client_ip_address" ) ) ;

            //System.out.println(className+":"+userBean.mode) ;
            if(userBean.mode ==null)
            {
                //System.out.println("initializing values") ;
                userBean.setMode("") ;
               userBean.initialize() ;
           }
            return userBean ;
        } catch (Exception e) {
            System.out.println("From MultipleHanlder getBeanObject Method  :"+e);
			e.printStackTrace() ;
            throw e ;
        }
    }

    private synchronized void setInRepository(String objectName, String className , final HttpServletRequest params , Object userBean) throws Exception {
        holder.put(objectName.trim().toUpperCase(),userBean) ;

        String funId = (params.getParameter("function_Id")==null)? "":params.getParameter("function_Id");
		String tempClassName = className;
		tempClassName = null;

        if(objectName.indexOf("@")== -1 ) {
            if(!funId.trim().equals(""))
                mapper.put(funId.trim().toUpperCase(),objectName.trim().toUpperCase());
            else
                mapper.put(objectName.trim().toUpperCase(),objectName.trim().toUpperCase());
        } else {
            //IF the Object  is Special holder than put name in the Map
            mapper.put(objectName.trim().toUpperCase(),objectName.trim().toUpperCase());
        }

        return ;
    }

    /**
    * This method the takes request Object and returns a hashMap containing
    * key & value pairs of the request Parameters
    */
    private Hashtable getRequestAsHash(final javax.servlet.http.HttpServletRequest req) {
        java.util.Enumeration l_enum =  req.getParameterNames();
        String temp = "";
        Hashtable tempHash   =  new Hashtable();
        String tempValues  =  "";

        while(l_enum.hasMoreElements()) {
            temp                =(String)l_enum.nextElement() ;

            if((temp != null) && !(temp.trim().equals(""))) {
                tempValues      =(req.getParameter(temp)==null)?"":req.getParameter(temp);
                tempHash.put(temp.trim().toUpperCase(),tempValues);
            }
        }

        return tempHash ;
    }

    /**
    * This method removes all the Objects from the repository apart from the
    * supplied FuntionId Objects & tghe  Special Objects
    * funID     function id

    public void cleanRest(String funID) {
        if(funID == null )
            return ;

        if(funID.trim().equals(""))
            return ;

        String functionIDCurrent = funID.trim().toUpperCase();
        Enumeration functionIDS = mapper.keys() ;

        while(functionIDS.hasMoreElements()) {
            String funIDName =(String)functionIDS.nextElement();

            if(!(functionIDCurrent.trim().equalsIgnoreCase(funIDName)) && (funIDName.indexOf("@") == -1) ) {
                Object rmv = mapper.remove(funIDName);

                if(rmv != null )
                holder.remove(rmv);
            }
        }
    }//End of CleanRest Method
*/
    public void cleanAll() {
        holder.clear() ;
        mapper.clear() ;

        //System.out.println("holder size:"+holder.size() ) ;
        //System.out.println("mapper size:"+mapper.size() ) ;
    /*
      Enumeration objIDs = holder.keys() ;
	        while(objIDs.hasMoreElements()) {
            String objID = (String)objIDs.nextElement() ;
            holder.put(objID, null) ;
        }
       */
    }//End of CleanAll Method


    public void cleanAll(String funID)
    {
          Enumeration objIDs = holder.keys() ;

       //   System.out.println("\n\n\n starts here\nbefore:");
		//  System.out.println(holder+"-----"+mapper) ;

           while(objIDs.hasMoreElements()) {

				String objID = (String)objIDs.nextElement() ;

			//	System.out.println("Removed:"+holder.get(objID));
	      //      System.out.println("Removed:"+mapper.get(objID));

                if(objID.endsWith( funID.trim().toUpperCase()))
                {
                    holder.remove(objID) ;
                    mapper.remove(objID) ;
                }
            }
		//	System.out.println(holder+"-----"+mapper+"\n ends here \n\n\n") ;
    }
/**
 *
 * This method gives Hashtable of all the Objects Bind to the  holder
 * ID's are the name of the Objects and values are the className
 * @return  hashtable containing all the objects bound
 */

    public Hashtable displayObjectBind() {
        Hashtable displayHash =  new Hashtable();
        Enumeration objIDs    = holder.keys() ;

        while(objIDs.hasMoreElements()) {
            String objID = (String)objIDs.nextElement() ;
            displayHash.put(objID,((holder.get(objID)).getClass()).getName());
        }

        return displayHash ;
    }
}//End of Class
