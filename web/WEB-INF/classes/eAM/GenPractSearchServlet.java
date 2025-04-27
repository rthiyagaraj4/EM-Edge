/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//created by Rajesh Kanna 
//21/4/2005 9:59 AM
package eAM;
import java.util.HashMap;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;
import org.xml.sax.InputSource;

public class GenPractSearchServlet
{

    public GenPractSearchServlet()
    {
    }

public HashMap parseXMLString(HttpServletRequest httpservletrequest)
{ 
	//Object obj = null;
	HashMap hash = new HashMap();
	HashMap hash1 = new HashMap();
	StringBuffer sql=new StringBuffer();   
	String function_id="";   
	try
    {
		java.io.BufferedReader bufferedreader = httpservletrequest.getReader();
		InputSource inputsource = new InputSource(bufferedreader);
		DocumentBuilderFactory documentbuilderfactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentbuilder = documentbuilderfactory.newDocumentBuilder();
		Document document = documentbuilder.parse(inputsource);
		Element element = document.getDocumentElement();
		NodeList nodelist = element.getChildNodes();
		for(int i = 0; i < nodelist.getLength(); i++)
            {
                Element element1 = (Element)nodelist.item(i);
                NamedNodeMap namednodemap = element1.getAttributes();
                
                for(int j = 0; j < namednodemap.getLength(); j++)
                {
                    Node node = namednodemap.item(j);
                    String nodeVal = node.getNodeValue() ;
                    nodeVal = nodeVal.replace('\"','\n') ;
                    hash.put(node.getNodeName(), nodeVal);
                
				}

                hash.put(element1.getTagName(), hash1);
                
			}hash1.clear();
           
			 function_id = "functionid";
		     function_id=(String)hash.get(function_id);
			 		 
	         function_id=function_id.trim();
			
			  if(function_id.equals("Pract_for_clinic"))
			 {
			// String res_type=(String)hash.get("res_type");
			 String facilityid=(String)hash.get("facilityid");
			 String clinic_code=(String)hash.get("clinic_code");
			  sql.append("Select a.practitioner_id practitioner_id,b.practitioner_name practitioner_name, b.pract_type_desc practitioner_type, decode(b.position_code, 'CC', 'Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr.Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR', 'Trainee',NULL,'',b.position_code) position_code, b.gender, primary_splty_short_desc primary_specialty from am_pract_for_facility a, am_practitioner_vw b , op_clinic c  where b.practitioner_id = a.practitioner_id and a.eff_status = 'E' and a.facility_id = '"+facilityid+"' and c.facility_id = a.facility_id and c.clinic_code = '"+clinic_code+"'");
			 
			 sql.append("  and (c.speciality_code = b.primary_speciality_code or c.speciality_code in (select speciality_code from am_pract_specialities where facility_id = '"+facilityid+"'  and practitioner_id = b.practitioner_id )) and upper(b.pract_type) like upper(nvl(?,b.pract_type)) and upper(b.primary_speciality_code) like upper(nvl(?,b.primary_speciality_code)) and (upper(b.practitioner_id) like upper(nvl(?,b.practitioner_id)) and upper(b.practitioner_name) like upper(nvl(?,b.practitioner_name))) and decode(upper(b.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(b.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(b.position_code,'123')) like upper(nvl(?,nvl(b.position_code,'123'))) ");		
			
		 }
		 else if(function_id.equals("VISIT_REGISTRATION"))
		{String open_to_all_pract_yn=(String)hash.get("open_to_all_pract_yn");
		
		 if (open_to_all_pract_yn == "Y")
	      { String facilityid=(String)hash.get("facilityid");
		      String locncode=(String)hash.get("locncode");
		
		sql.append("SELECT   d.practitioner_id  practitioner_id, d.practitioner_name practitioner_name ,b.desc_sysdef practitioner_type, c.short_desc primary_specialty, DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender, DECODE(a.job_title,'CC','Chief Consultant', 'CO', 'Consultant', 'RG','Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr. Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' ) job_title FROM OP_REGISTER_VISIT_PRACT_VW d,am_practitioner a, am_pract_type b,am_speciality c, op_clinic e WHERE a.pract_type=b.pract_type AND D.FACILITY_ID=E.FACILITY_ID AND d.clinic_code=e.clinic_code and c.speciality_code = e.speciality_code AND d.practitioner_id=a.practitioner_id AND a.pract_type LIKE (?)  AND e.speciality_code LIKE UPPER(?)  AND  (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) and  UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name))) AND  a.gender LIKE (?) AND (a.JOB_TITLE LIKE (?)  OR a.job_title IS NULL) AND d.facility_id='"+facilityid+"' AND  d.clinic_code= '"+locncode+"'");

     	 
		}else
	    {
			String facilityid=(String)hash.get("facilityid");
			String visitadmtype=(String)hash.get("visitadmtype");
	         String locncode=(String)hash.get("locncode");
			 String ptype=(String)hash.get("ptype");

		sql.append("SELECT b.practitioner_id practitioner_id, b.practitioner_name practitioner_name, d.desc_sysdef practitioner_type,e.short_desc primary_specialty, DECODE(b.gender,'M','Male','F','Female','U','Unknown') gender, DECODE(b.position_code,'CC','Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr. Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' ) position_code FROM op_pract_for_clinic a, am_practitioner b, op_clinic c,am_pract_type d,am_speciality e WHERE ");
		sql.append(" b.pract_type=d.pract_type AND b.pract_type LIKE (?) AND ");
		sql.append("  c.speciality_code=e.speciality_code AND c.speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))  and UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))) AND  b.gender LIKE (?) AND (b.position_code LIKE (?) OR b.position_code IS NULL) AND a.practitioner_id = b.practitioner_id AND a.clinic_code=c.clinic_code ");
		if(ptype.equals("P"))
		{
			sql.append(" AND b.pract_type=NVL(c.pract_type,b.pract_type) ");
		}
		sql.append(" AND DECODE((SELECT visit_type_ind FROM op_visit_type WHERE visit_type_code='"+visitadmtype+"' AND facility_id='"+facilityid+"'),'F',a.fi_visit_type_appl_yn,'L',a.fu_visit_type_appl_yn, 'R',a.rt_visit_type_appl_yn,'S',a.sr_visit_type_appl_yn, 'C',a.cs_visit_type_appl_yn,'E',a.em_visit_type_appl_yn)='Y' AND a.clinic_code='"+locncode+"'  AND c.facility_id = a.facility_id AND a.facility_id='"+facilityid+"' AND a.eff_status = 'E'  ");
	  }
 

		}else if(function_id.equals("ManPatQue"))
		{
			String facilityid=(String)hash.get("facilityid");
			String oper_station_id=(String)hash.get("oper_station_id");
	        String loginuser=(String)hash.get("loginuser");
			String check_out=(String)hash.get("check_out");

		
		sql.append("select distinct a.practitioner_id practitioner_id,a.practitioner_name practitioner_name, nvl(b.desc_sysdef,b.desc_userdef) practitioner_type, decode(a.position_code, 'CC', 'Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr.Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR', 'Trainee',NULL,'',a.job_title) position_code, decode(a.gender,'M','Male','F','Female','Unknown') gender,c.short_desc primary_specialty from am_practitioner a, am_pract_type b, am_speciality c,  op_patient_queue_vw d where d.facility_id='"+facilityid+"' and d.queue_status <'07' and (d.locn_type,d.locn_code) in (select locn_type,locn_code from am_locn_for_oper_stn where facility_id='"+facilityid+"' and oper_stn_id = '"+oper_station_id+"' ) and a.practitioner_id is not null and a.practitioner_id=d.practitioner_id and a.pract_type=b.pract_type and d.speciality_code=a.primary_speciality_code AND a.primary_speciality_code = c.speciality_code and upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(?) and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(a.practitioner_name) like upper(nvl(?,a.practitioner_name))) and upper(a.gender) like upper(nvl(?,a.gender)) and upper(nvl(a.position_code,'123')) like upper(nvl(?,nvl(a.position_code,'123')))");
			 
  	      if(check_out == "ChkOut")
				{
                    sql.append(" and (d.locn_type,d.locn_code) not in  (select locn_type, locn_code from am_restrn_for_oper_stn where facility_id = '"+facilityid+"' and Oper_stn_id='"+oper_station_id+"' and appl_user_id = '"+loginuser+"' and checkout_pat_yn = 'N')");

				}
                else
				{
                    sql.append(" and (d.locn_type,d.locn_code) not in  (select locn_type, locn_code from am_restrn_for_oper_stn where facility_id = '"+facilityid+"' and Oper_stn_id='"+oper_station_id+"' and appl_user_id = '"+loginuser+"' and manage_queue_yn = 'N')") ;

				}
					
			

		
		
		
		
		
		}	else if(function_id.equals("visitregistration1")||function_id.equals("revicevisit"))
		{	String open_to_all_pract_yn=(String)hash.get("open_to_all_pract_yn");
		   if(open_to_all_pract_yn=="Y")
			{String facilityid=(String)hash.get("facilityid");
			  String cur_locn_code=(String)hash.get("cur_locn_code");
			  
	       
							
				
				sql.append(" SELECT   distinct a.practitioner_id  practitioner_id, a.practitioner_name practitioner_name ,b.desc_sysdef practitioner_type, c.short_desc primary_specialty, DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender, DECODE(a.position_code,'CC','Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr. Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' ) position_code FROM am_practitioner a, am_pract_type b,am_speciality c,am_pract_for_facility d, op_clinic e WHERE a.pract_type=b.pract_type AND a.primary_speciality_code=c.speciality_code AND a.pract_type LIKE (?)  AND a.primary_speciality_code LIKE UPPER(?)  AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))  OR  UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name))) AND  a.gender LIKE (?) AND (a.position_code like (?) OR a.position_code IS NULL) and a.practitioner_id=d.practitioner_id and d.eff_status='E' and d.facility_id='"+facilityid+"' and e.facility_id=d.facility_id and e.clinic_code='"+cur_locn_code+"' and (e.speciality_code=a.primary_speciality_code or e.speciality_code in (select speciality_code from am_pract_specialities where facility_id='"+facilityid+"' and practitioner_id=a.practitioner_id)) and nvl(e.pract_type, a.pract_type) = a.pract_type ");
				
				
			}
			else
			{
					
				String facilityid=(String)hash.get("facilityid");
			  String cur_locn_code=(String)hash.get("cur_locn_code");
				sql.append(" SELECT   distinct a.practitioner_id  practitioner_id, a.practitioner_name practitioner_name ,b.desc_sysdef practitioner_type, c.short_desc primary_specialty, DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender, DECODE(a.position_code,'CC','Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr. Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' ) position_code FROM am_practitioner a, am_pract_type b,am_speciality c, op_pract_for_clinic_vw d WHERE a.pract_type=b.pract_type AND a.primary_speciality_code=c.speciality_code AND a.pract_type LIKE (?)  AND a.primary_speciality_code LIKE UPPER(?)  AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))  OR  UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name))) AND  a.gender LIKE (?) AND (a.position_code like (?) OR a.position_code IS NULL) and d.facility_id='"+facilityid+"' and d.clinic_code=nvl('"+cur_locn_code+"',d.clinic_code) and d.eff_status='E' and d.practitioner_id=a.practitioner_id"); 
				
				

			}
        

		}
		else if(function_id.equals("FollowuponLastVisits")||function_id.equals("QueryPatientVisits"))
		{String facilityid=(String)hash.get("facilityid");
		sql.append("select a.practitioner_id practitioner_id, a.practitioner_name practitioner_name, b.pract_type_desc practitioner_type, decode(a.position_code, 'CC', 'Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr.Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR', 'Trainee',NULL,'',a.position_code) position_code, decode(a.gender,'M','Male','F','Female','U','Unknown') gender, b.primary_speciality_desc primary_specialty from am_practitioner a,  AM_PRACT_FOR_FACILITY_VW b where b.OPERATING_FACILITY_ID = '"+facilityid+"' and b.EFF_STATUS = 'E' and a.practitioner_id=b.practitioner_id and upper(b.pract_type) like upper(nvl(?,b.pract_type)) and upper(b.primary_speciality_code) like upper(nvl(?,b.primary_speciality_code)) and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) or upper(a.practitioner_name) like upper(nvl(?,a.practitioner_name))) and upper(a.gender) like upper(nvl(?,a.gender)) and upper(nvl(a.position_code,'123')) like upper(nvl(?,nvl(a.position_code,'123'))) ");
		
		}else if(function_id.equals("repOPDListform")|| function_id.equals("repReferredVisits")||function_id.equals("repVisitByStatus")||function_id.equals("repPatRecallList")||function_id.equals("repMDSExForm"))
		{
		sql.append("select practitioner_id, practitioner_name, pract_type_desc practitioner_type, decode(position_code, 'CC', 'Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr.Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR', 'Trainee',NULL,'',position_code) position_code, gender, primary_splty_short_desc primary_specialty from am_practitioner_vw where upper(pract_type) like upper(nvl(?,pract_type)) and upper(primary_speciality_code) like upper(nvl(?,primary_speciality_code)) and (upper(practitioner_id) like upper(nvl(?,practitioner_id)) or upper(practitioner_name) like upper(nvl(?,practitioner_name))) and decode(upper(gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(position_code,'123')) like upper(nvl(?,nvl(position_code,'123'))) order by 2 ");
		
		}else if(function_id.equals("ReferralSearch"))
		{
			String facilityid=(String)hash.get("facilityid");
			String clinic_code=(String)hash.get("clinic_code");
			String referred_location_type=(String)hash.get("referred_location_type");
			String open_to_all_pract=(String)hash.get("open_to_all_pract");
		    String speciality_code=(String)hash.get("speciality_code");
		   
		
		if(clinic_code.equals(""))
		{
		  
		  sql.append("select b.practitioner_id practitioner_id, b.practitioner_name practitioner_name, nvl(c.desc_sysdef,c.desc_userdef) practitioner_type, decode(b.job_title, 'CC', 'Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr.Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR', 'Trainee',NULL,'',b.job_title) job_title, decode(b.gender,'M','Male','F','Female','U','Unknown') gender, d.short_desc primary_specialty  from am_pract_for_facility a, am_practitioner b, am_pract_type c, am_speciality d where a.practitioner_id = b.practitioner_id and a.facility_id = '"+facilityid+"' and d.speciality_code=b.primary_speciality_code and c.pract_type=b.pract_type and upper(c.pract_type) like upper(nvl(?,c.pract_type)) and upper(d.speciality_code) like upper(nvl(?,d.speciality_code)) and (upper(b.practitioner_id) like upper(nvl(?,b.practitioner_id)) or upper(b.practitioner_name) like upper(nvl(?,b.practitioner_name))) and upper(b.gender) like upper(nvl(?,b.gender)) and upper(nvl(b.job_title,'123')) like upper(nvl(?,nvl(b.job_title,'123'))) order by 2");
		  
		
		}
		else
		{
			if(referred_location_type.equals("C" ))
			{
		       if(open_to_all_pract.equals("Y"))
		          {
				      
			sql.append("Select b.practitioner_id practitioner_id,b.practitioner_name practitioner_name, nvl(d.desc_sysdef,d.desc_userdef) practitioner_type, decode(b.job_title, 'CC', 'Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr.Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR', 'Trainee',NULL,'', b.job_title) job_title, decode(b.gender,'M','Male','F','Female','U','Unknown') gender, e.short_desc primary_specialty from am_pract_for_facility a, am_practitioner b , op_clinic c, am_pract_type d, am_speciality e where b.eff_status = 'E' and c.eff_status = 'E' and b.practitioner_id = a.practitioner_id and a.eff_status = 'E' and a.facility_id = '"+facilityid+"' and c.facility_id = a.facility_id and c.clinic_code = '"+clinic_code+"' and (c.speciality_code = b.primary_speciality_code or c.speciality_code in (select speciality_code from am_pract_specialities where facility_id ='"+facilityid+"' and practitioner_id = b.practitioner_id  AND practitioner_id NOT IN (SELECT practitioner_id FROM AM_PRACTITIONER))) and nvl(c.pract_type, b.pract_type) = b.pract_type and e.speciality_code=b.primary_speciality_code and d.pract_type=b.pract_type and upper(d.pract_type) like upper(nvl(?,d.pract_type)) and upper(c.speciality_code) like upper(nvl(?,c.speciality_code)) and (upper(b.practitioner_id) like upper(nvl(?,b.practitioner_id)) or upper(b.practitioner_name) like upper(nvl(?,b.practitioner_name))) and upper(b.gender) like upper(nvl(?,b.gender)) and upper(nvl(b.job_title,'123')) like upper(nvl(?,nvl(b.job_title,'123'))) order by 2") ;	
			
		 
		  }
		else 
		{
		   	   
			sql.append("select a.PRACTITIONER_ID practitioner_id, a.PRACTITIONER_FULL_NAME practitioner_name, nvl(c.desc_sysdef,c.desc_userdef) practitioner_type, decode(b.job_title, 'CC', 'Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr.Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR', 'Trainee',NULL,'',b.job_title) job_title, decode(b.gender,'M','Male','F','Female','U','Unknown') gender, d.short_desc primary_specialty from op_pract_for_clinic_vw a, am_practitioner b, am_pract_type c, am_speciality d where a.FACILITY_ID ='"+facilityid+"' and a.practitioner_eff_status = 'E'  and a.eff_status = 'E' and a.CLINIC_CODE ='"+clinic_code+"' and  c.pract_type=b.pract_type and a.practitioner_id=b.practitioner_id and upper(c.pract_type) like upper(nvl(?,c.pract_type)) and upper(d.speciality_code) like upper(nvl(?,d.speciality_code)) and (upper(b.practitioner_id) like upper(nvl(?,b.practitioner_id)) or upper(b.practitioner_name) like upper(nvl(?,b.practitioner_name))) and upper(b.gender) like upper(nvl(?,b.gender)) and upper(nvl(b.job_title,'123')) like upper(nvl(?,nvl(b.job_title,'123'))) order by 2");
			
		 }
		}else if(referred_location_type .equals("E") || referred_location_type.equals("Y" ))
			{
         
			  sql.append("select a.PRACTITIONER_ID practitioner_id, a.PRACTITIONER_FULL_NAME practitioner_name, nvl(c.desc_sysdef,c.desc_userdef) practitioner_type, decode(b.job_title, 'CC', 'Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr.Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR', 'Trainee',NULL,'',b.job_title) job_title, decode(b.gender,'M','Male','F','Female','U','Unknown') gender, d.short_desc primary_specialty from op_pract_for_clinic_vw a, am_practitioner b, am_pract_type c, am_speciality d where a.FACILITY_ID ='"+facilityid+"' and a.practitioner_eff_status = 'E'  and a.eff_status = 'E' and a.CLINIC_CODE ='"+clinic_code+"' and d.speciality_code=b.primary_speciality_code and c.pract_type=b.pract_type and a.practitioner_id=b.practitioner_id and upper(c.pract_type) like upper(nvl(?,c.pract_type)) and upper(d.speciality_code) like upper(nvl(?,d.speciality_code)) and (upper(b.practitioner_id) like upper(nvl(?,b.practitioner_id)) or upper(b.practitioner_name) like upper(nvl(?,b.practitioner_name))) and upper(b.gender) like upper(nvl(?,b.gender)) and upper(nvl(b.job_title,'123')) like upper(nvl(?,nvl(b.job_title,'123'))) order by 2");
			
		    
			}
		 else if(referred_location_type.equals("N"))
			{
			
			sql.append( "SELECT a.facility_id, a.practitioner_id practitioner_id,b.practitioner_name practitioner_name, c.desc_sysdef practitioner_type,   a.specialty_code, d.short_desc primary_specialty, a.gender gender,a.job_title job_title FROM am_pract_all_splty_vw a,am_practitioner b,am_pract_type c,am_speciality d,ip_nursing_unit_for_pract e WHERE a.facility_id = '"+facilityid+"' AND a.specialty_code = '"+speciality_code+"' AND b.practitioner_id = a.practitioner_id AND c.pract_type = b.pract_type AND d.speciality_code = a.specialty_code AND e.facility_id = a.facility_id AND e.nursing_unit_code = '"+clinic_code+"' AND e.practitioner_id = a.practitioner_id AND b.pract_type LIKE (?) AND a.specialty_code LIKE UPPER (?)  AND (UPPER (a.practitioner_id) LIKE UPPER (NVL (?, a.practitioner_id)) OR UPPER (b.practitioner_name) LIKE UPPER (NVL (?, b.practitioner_name))) AND a.gender LIKE (?) AND (a.job_title LIKE (?) OR a.job_title IS NULL)");

	    	}

		}
		
		
		}



    

		
		hash.put("sql",sql);
		
		}
        catch(Exception exception)
        {
            hash.put("error", exception.toString());
        }
        
	
		
		
		return hash;
    }



}
