function manEnable1(obj,hiddenvar)
{
if(document.getElementById("mode").value=="U")
	{
if(document.getElementById("age_range").value!="")
document.getElementById("gif").style.visibility="visible"
if(document.getElementById("gcsScore1").value!="")
document.getElementById("gcsscr").style.visibility="visible"
if(document.getElementById("post_op_los1").value!="")
document.getElementById("pstln").style.visibility="visible"
if(document.getElementById("re_admit_days1").value!="")
document.getElementById("readmdys").style.visibility="visible"
if(document.getElementById("re_admit_hours1").value!="")
document.getElementById("re_admit_hours1").style.visibility="visible"
if(document.getElementById("waterloo_score1").value!="")
document.getElementById("watersc").style.visibility="visible"
if(document.getElementById("gest_period_operator").value!="")
document.getElementById("gestprd").style.visibility="visible"
if(document.getElementById("post_op_los1").value!="")
document.getElementById("pstln").style.visibility="visible"
if(document.getElementById("tat_days_operator").value!="")
document.getElementById("trnman").style.visibility="visible"
	}
}
function manEnable(obj,hiddenvar,obj1)
{

if(obj.value!='')
	{
	 document.getElementById('hiddenvar').style.visibility='visible';
	//obj1.value="";
	}else
	{
	
	 document.getElementById('hiddenvar').style.visibility='hidden';
	}
	
}
function reset() 
  {
	  if(f_query_add_mod.document.forms[0]!=null)
     f_query_add_mod.document.location.reload() ;
  }

function create() {
	f_query_add_mod.location.href = "../../eQA/jsp/addModifyQAIndicator.jsp" ;
}

function query()
{
f_query_add_mod.location.href = "../../eQA/jsp/QAIndicatorQueryCriteria.jsp" ;

}

function apply()
{
	
f_query_add_mod.document.qaindform.qind_clind_desc.disabled = false;
f_query_add_mod.document.qaindform.qind_group_id.disabled = false;
f_query_add_mod.document.qaindform.area_of_concern.disabled = false;
f_query_add_mod.document.qaindform.clind_type.disabled = false;
f_query_add_mod.document.qaindform.standard_desc.disabled = false;
f_query_add_mod.document.qaindform.standard_oper.disabled = false;
f_query_add_mod.document.qaindform.standard_value.disabled = false;
f_query_add_mod.document.qaindform.clind_class.disabled = false;
f_query_add_mod.document.qaindform.dflt_rep_periodicity.disabled = false;
f_query_add_mod.document.qaindform.dflt_bd_age_range_id.disabled = false;
f_query_add_mod.document.qaindform.dflt_bd_by_gender_yn.disabled = false;
f_query_add_mod.document.qaindform.gender.disabled = false;
f_query_add_mod.document.qaindform.age_range.disabled = false;
f_query_add_mod.document.qaindform.day.disabled = false;
f_query_add_mod.document.qaindform.month.disabled = false;
f_query_add_mod.document.qaindform.year.disabled = false;
f_query_add_mod.document.qaindform.IP.disabled = false;
f_query_add_mod.document.qaindform.OP.disabled = false;
f_query_add_mod.document.qaindform.DC.disabled = false;
f_query_add_mod.document.qaindform.EM.disabled = false;
f_query_add_mod.document.qaindform.XT.disabled = false;
f_query_add_mod.document.qaindform.gcs_event_code1.disabled = false;
f_query_add_mod.document.qaindform.gcs_event_code2.disabled = false;
f_query_add_mod.document.qaindform.gcsScore1.disabled = false;
f_query_add_mod.document.qaindform.gcsScore2.disabled = false;
f_query_add_mod.document.qaindform.post_op_los1.disabled = false;
f_query_add_mod.document.qaindform.post_op_los.disabled = false;
f_query_add_mod.document.qaindform.re_admit_days1.disabled = false;
f_query_add_mod.document.qaindform.re_admit_days.disabled = false;
f_query_add_mod.document.qaindform.re_admit_hours1.disabled = false;
f_query_add_mod.document.qaindform.re_admit_hours.disabled = false;
f_query_add_mod.document.qaindform.waterloo_event_type.disabled = false;
f_query_add_mod.document.qaindform.waterloo_event_code.disabled = false;
f_query_add_mod.document.qaindform.waterloo_score1.disabled = false;
f_query_add_mod.document.qaindform.waterloo_score.disabled = false;
f_query_add_mod.document.qaindform.gest_period_operator.disabled = false;
f_query_add_mod.document.qaindform.gest_period.disabled = false;
f_query_add_mod.document.qaindform.gest_period_in_dwmy.disabled = false;
f_query_add_mod.document.qaindform.post_delv_los_operator.disabled = false;
f_query_add_mod.document.qaindform.post_delv_los.disabled = false;
f_query_add_mod.document.qaindform.tat_days_operator.disabled = false;
f_query_add_mod.document.qaindform.tat_days.disabled = false;
f_query_add_mod.document.qaindform.term_preg_adm_type.disabled = false;
f_query_add_mod.document.qaindform.nod_type.disabled = false;
f_query_add_mod.document.qaindform.surg_type.disabled=false;
//f_query_add_mod.document.qaindform.lmt_rpt_trn_time.disabled=false;
f_query_add_mod.document.qaindform.num_event_type.disabled = false;
f_query_add_mod.document.qaindform.num_event_code.disabled = false;
f_query_add_mod.document.qaindform.num_operator1.disabled = false;
f_query_add_mod.document.qaindform.num_score.disabled = false;

var gender=f_query_add_mod.document.qaindform.gender.value
var age_range=f_query_add_mod.document.qaindform.age_range.value
var day=f_query_add_mod.document.qaindform.day.value;
var month=f_query_add_mod.document.qaindform.month.value;
var year=f_query_add_mod.document.qaindform.year.value;
var pcip=f_query_add_mod.document.qaindform.IP
var pcop=f_query_add_mod.document.qaindform.OP;
var pcdc=f_query_add_mod.document.qaindform.DC;
var pcem=f_query_add_mod.document.qaindform.EM;
var pcxt =f_query_add_mod.document.qaindform.XT;
var gcs_event_code2=f_query_add_mod.document.qaindform.gcs_event_code2.value
var gcsScore1 =f_query_add_mod.document.qaindform.gcsScore1.value;
var gcsScore2=f_query_add_mod.document.qaindform.gcsScore2.value;
var gcs_event_code1=f_query_add_mod.document.qaindform.gcs_event_code1.value
var num_event_type=f_query_add_mod.document.qaindform.num_event_type.value;
var num_event_code=f_query_add_mod.document.qaindform.num_event_code.value;
var num_operator1=f_query_add_mod.document.qaindform.num_operator1.value;
var num_score=f_query_add_mod.document.qaindform.num_score.value;
var post_op_los=f_query_add_mod.document.qaindform.post_op_los.value;
var post_op_los1=f_query_add_mod.document.qaindform.post_op_los1.value;
var re_admit_days=f_query_add_mod.document.qaindform.re_admit_days.value;
var re_admit_days1=f_query_add_mod.document.qaindform.re_admit_days1.value;
var re_admit_hours=f_query_add_mod.document.qaindform.re_admit_hours.value
var re_admit_hours1=f_query_add_mod.document.qaindform.re_admit_hours1.value
var waterloo_score=f_query_add_mod.document.qaindform.waterloo_score.value
var waterloo_score1=f_query_add_mod.document.qaindform.waterloo_score1.value
var standard_oper=f_query_add_mod.document.qaindform.standard_oper.value
var standard_value=f_query_add_mod.document.qaindform.standard_value.value
var post_delv_los_operator=f_query_add_mod.document.qaindform.post_delv_los_operator.value
var post_delv_los=f_query_add_mod.document.qaindform.post_delv_los.value

var gest_period_operator=f_query_add_mod.document.qaindform.gest_period_operator.value
var gest_period_in_dwmy=f_query_add_mod.document.qaindform.gest_period_in_dwmy.value;
var gest_period=f_query_add_mod.document.qaindform.gest_period.value;

var surg_type=f_query_add_mod.document.qaindform.surg_type.value;
//var lmt_rpt_trn_time=f_query_add_mod.document.qaindform.lmt_rpt_trn_time.value;

var i=0;
tat_days_operator=f_query_add_mod.document.qaindform.tat_days_operator.value
tat_days=f_query_add_mod.document.qaindform.tat_days.value

term_preg_adm_type=f_query_add_mod.document.qaindform.term_preg_adm_type.value
nod_type=f_query_add_mod.document.qaindform.nod_type.value

waterloo_event_type=f_query_add_mod.document.qaindform.waterloo_event_type.value
	waterloo_event_code=f_query_add_mod.document.qaindform.waterloo_event_code.value
deceased=f_query_add_mod.document.qaindform.deceased;
var concatValues="";
 re_admit_days1

	 if(eval(age_range)==5 && (day=="" || month=="" || year==""))
	  {	     
		 if(day!="" && (month=="" || year==""))
		  {
			   if(month!="" && year=="")
			    {
				  alert("Age Range cannot be Empty");
				  messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	              return false;
				}
			   else if(month=="" && year!="")
			   {
				  alert("Age Range cannot be Empty");
				   messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	               return false;
			   }
			   else 
				   {
				  alert("Age Range cannot be Empty");
				   messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	              return false
				   }
		  }
		else if(month!="" && (day=="" || year==""))
		{
			   if(day!="" && year=="")
			     {
				  alert("Age Range cannot be Empty");
				   messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	              return false
				 }
				else if(year!="" && day=="")
			    {
				  alert("Age Range cannot be Empty");
				   messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	              return false
				}
				else 
				{
				  alert("Age Range cannot be Empty");
				   messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	              return false
				}
		}
		else if(year!="" && (day=="" || month==""))
		{
			   if(day!="" && month=="")
			   {
				  alert("Age Range cannot be Empty");
				   messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	              return false
			   }
			   else if(month!="" && day=="")
			  {
				 alert("Age Range cannot be Empty");
				 messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	              return false
			   }
			   else 
			   {
			   alert("Age Range cannot be Empty");
			   messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	              return false
			   }
		}
		else if(day=="" && month=="" && year=="")
		{
	     alert("Age Range cannot be Empty");
		 messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	              return false
		}
	} 
	else
	{

      if((eval(age_range)>=1 && eval(age_range)<=4) && (day==""  || year==""))
	   {
	        if(day!="" &&  year=="" && i==0)
		    {
		     
			    alert("Age Range cannot be Empty");
				i++;
				messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	              return false
			}
		     else if(day=="" && year!="" && i==0)
		      {
				  alert("Age Range cannot be Empty");
				  i++;
				  messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	              return false
			  }
			
		     else if(day=="" && year=="")
		   {
	        alert("Age Range cannot be Empty");
			messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	              return false
		   }
	} 
     
     if(day!="" && ((eval(age_range))==0 || year==""))
	  {
	   
	      if((((eval(age_range))>=1) && ((eval(age_range))<=4)) &&  year=="" && i==0)
		  {
			   	  alert("Age Range cannot be Empty");
				  i++;
				  messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	              return false
		  }
		 else if(((eval(age_range))==0) && year!="" && i==0)
		  {
			     alert("Age Range cannot be Empty");
				 i++;
				 messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	              return false
		  }
		  else if(((eval(age_range))==0) && year=="")
		  {
			    alert("Age Range cannot be Empty");
				messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	              return false
		  }
		}
	
	if(year!="" && ((eval(age_range))==0 || day=="" ))
	{
	    if((((eval(age_range))>=1) && ((eval(age_range))<=4)) && day=="" && i==0)
		   {
			     alert("Age Range cannot be Empty");
				 i++;
				 messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	              return false
		   }
			   else if(day!="" && (eval(age_range))==0 && i==0)
		   {
				   alert("Age Range cannot be Empty");
				   i++;
				   messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	              return false
		   }
			   else if((eval(age_range))==0 && day=="")
		        {
					alert("Age Range cannot be Empty");
					messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	                return false
				}
		}
	}

if((gest_period_operator!="") && (gest_period_in_dwmy==""  || gest_period==""))
  {
	       if(gest_period_in_dwmy!="" &&  gest_period=="" && i==0)
		    {
		     
			    alert("Gestation Period cannot be Empty");
				i++;
				messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	              return false;
			}
		     else if(gest_period_in_dwmy=="" && gest_period!="" && i==0)
		      {
				  alert("Gestation Period cannot be Empty");
				  i++;
				  messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	              return false;
			  }
			
		     else if(gest_period_in_dwmy=="" && gest_period=="")
		   {
	        alert("Gestation Period cannot be Empty");
			messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	              return false;
		   }
	} 
	 
     if(gest_period_in_dwmy!="" && (gest_period_operator=="" || gest_period==""))
	  {
	   
	      if(gest_period_operator!="" &&  gest_period=="" && i==0)
		  {
			   	  alert("Gestation Period cannot be Empty");
				  i++;
				  messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	              return false;
		  }
		 else if(gest_period_operator=="" && gest_period!="" && i==0)
		  {
			     alert("Gestation Period cannot be Empty");
				 i++;
				 messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	              return false;
		  }
		  else if(gest_period_operator=="" && gest_period=="")
		  {
			    alert("Gestation Period cannot be Empty");
				messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	              return false;
		  }
		}

	if(gest_period!="" && (gest_period_operator=="" || gest_period_in_dwmy=="" ))
	{
	    if( gest_period_operator!="" && gest_period_in_dwmy=="" && i==0)
		   {
			     alert("Gestation Period cannot be Empty");
				 i++;
				 messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	              return false;
		   }
			   else if(gest_period_in_dwmy!="" && (gest_period_operator=="" && i==0))
		       {
				   alert("Gestation Period cannot be Empty");
				   i++;
				   messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	              return false;
		      }
			   else if(gest_period_operator=="" && gest_period_in_dwmy=="")
		        {
					alert("Gestation Period cannot be Empty");
					messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	                return false;
				}
		}
if(standard_oper==""&&standard_value!="")
	{
	alert("Standard Value cannot be empty");
	messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	return false

	}
	else if(standard_value==""&&standard_oper!="")
	{
	alert("Standard Value cannot be empty");
	 messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	return false
	}
    else if(standard_value=="" && standard_oper=="")
		f_query_add_mod.document.qaindform.standard_value.value='';
	//else
	//	f_query_add_mod.document.qaindform.standard_value.value=standard_oper+"!"+standard_value

if(tat_days_operator==""&&tat_days!="")
	{
	alert("Turn-around Time cannot be empty");
	 messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	return false

	}
	else if(tat_days==""&&tat_days_operator!="")
	{
	alert("Turn-around Time cannot be empty");
	 messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	return false
	}

if(f_query_add_mod.document.qaindform.eff_status.checked)
	{
	
f_query_add_mod.document.qaindform.eff_status.value="E"
	}
	else
	{
		f_query_add_mod.document.qaindform.eff_status.value="D"
	}
if(post_delv_los_operator==""&&post_delv_los!="")
	{
	alert("Post Delivery Length of Stay cannot be empty");
	 messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	return false

	}
	else if(post_delv_los==""&&post_delv_los_operator!="")
	{
	alert("Post Delivery Length of Stay cannot be empty");
	 messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	return false
	}

if(post_delv_los_operator==""&&post_delv_los!="")
	{
	alert("Post Delivery Length of Stay cannot be empty");
	 messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	return false

	}
	else if(post_delv_los==""&&post_delv_los_operator!="")
	{
	alert("Post Delivery Length of Stay cannot be empty");
	 messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	return false
	}

if(post_op_los1==""&&post_op_los!="")
	{
	alert("POST_OP_LOS cannot be empty");
	 messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	return false

	}
	else if(post_op_los==""&&post_op_los1!="")
	{
	alert("POST_OP_LOS cannot be empty");
	 messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	return false
	}

if(re_admit_days1==""&&re_admit_days1!="")
	{
	alert("Re_Admit_Days cannot be empty");
	 messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	return false

	}
	else if(re_admit_days1==""&&re_admit_days1!="")
	{
	alert("Re_Admit_Days cannot be empty");
	 messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	return false
	}

    if(re_admit_hours1==""&&re_admit_hours!="")
	{
	alert("Re_Admit_hours cannot be empty");
	 messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	return false

	}
	else if(re_admit_hours==""&&re_admit_hours1!="")
	{
	alert("Re_Admit_hours cannot be empty");
	 messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	return false
	}

    if(waterloo_score==""&&waterloo_score1!="")
	{
	alert("Waterloo Score cannot be empty");
	 messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	return false

	}
	else if(waterloo_score1==""&&waterloo_score!="")
	{
	alert("Waterloo Score cannot be empty");
	 messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	return false
	}

	if(gcsScore1==""&&gcsScore2!="")
	{
	alert("GCScore cannot be empty");
	 messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	return false

	}
	else if(gcsScore2==""&&gcsScore1!="")
	{
	alert("GCScore cannot be empty");
	 messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	return false
	}

	if(num_event_type==""&&num_event_code!="")
	{
	alert("Numerator Type/Code cannot be empty");
	 messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	return false

	}
	else if(num_event_code==""&&num_event_type!="")
	{
	 alert("Numerator Type/Code cannot be empty");
	 messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	 return false
	}

    if(num_operator1==""&&num_score!="")
	{
	alert("Numerator Score cannot be empty");
	 messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	return false

	}
	else if(num_score==""&&num_operator1!="")
	{
	 alert("Numerator Score cannot be empty");
	 messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	 return false
	}

 if(f_query_add_mod.document.qaindform.area_of_concern.value.length>200)
	{
	alert("Area Of Concern cannot exceed 200 characters");
	 messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	return false
	}

if(gcs_event_code1==""&&gcs_event_code2!="")
	{
	alert("GCSEvent Type/Code cannot be empty");
	 messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	return false
	}
	else if(gcs_event_code2==""&&gcs_event_code1!="")
	{
	alert("GCSEvent Type/Code cannot be empty");
	 messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	return false
	}

if(waterloo_event_code==""&&waterloo_event_type!="")
	{
	alert("Waterloo Event Type/Code cannot be empty");
	 messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	return false
	}
	else if(waterloo_event_type==""&&waterloo_event_code!="")
	{
	alert("Waterloo Event Type/Cod cannot be empty");
	 messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	return false
	}

if(eval(month)<1 ||eval(day)<1)
	{	
alert("Age Range Values should be greater than 0");
    messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	return false
	}

if(eval(age_range)==5)
	{

	if(eval(month)<eval(day))
		{
		alert("Age Range From should be less than To");
		messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
		return false
	}}

	if(term_preg_adm_type!="")
	{
    concatValues=concatValues+"TERM_PREG_ADM_TYPE!"+term_preg_adm_type+"#"      
	}

if(gest_period!="")
	{
   concatValues=concatValues+"GEST_PERIOD!"+gest_period_operator+"!"+gest_period+"!"+gest_period_in_dwmy+"#"      
	}

if(nod_type!="")
	{
    concatValues=concatValues+"NOD_TYPE!"+nod_type+"#"      
	}

  if(gender!="")
	{
    concatValues=concatValues+"GENDER!=!"+gender+"#"      
	}
if((age_range!="")&&((day!="")||(month!="")) )
	{
    if(age_range=='1')
		age_range1='GT'
	else if(age_range=='2')
		age_range1='GE'
	else if(age_range=='3')
		age_range1='LT'
	else if(age_range=='4')
		age_range1='LE'
	else if(age_range=='5')
		age_range1='BT'

	concatValues=concatValues+"AGE_RANGE!"+age_range1+"!"      
   if(day!="")
		{   
   if(age_range=='1'||age_range=='2'||age_range=='3'||age_range=='4')
			{
   concatValues=concatValues+day+"!"+year+"#";      
			}
	else
			{
				concatValues=concatValues+day+"!"+month+"!"+year+"#";  		
			}
		}
	
	}

	if((pcip.checked)||(pcop.checked)||(pcdc.checked)||(pcem.checked)||(pcxt.checked))
	{
	   concatValues=concatValues+"PAT_CLASS"
	    if(pcip.checked)
 			concatValues=concatValues+"!IP";
       if(pcop.checked)
			concatValues=concatValues+"!OP";
       if(pcdc.checked)
			concatValues=concatValues+"!DC";
       if(pcem.checked)
			concatValues=concatValues+"!EM";
       if(pcxt.checked)
			concatValues=concatValues+"!XT";

	     concatValues=concatValues+"#"
	}
	
	if(gcs_event_code1!="")
	{	
	concatValues=concatValues+"GCS_EVENT!"+gcs_event_code1+"!"+gcs_event_code2
	concatValues=concatValues+"#"
	}

	if(num_event_type!="")
	{	
	concatValues=concatValues+"NUM_EVENT!"+num_event_type+"!"+num_event_code
	concatValues=concatValues+"#"
	}


if(waterloo_event_type!="")
	{	
	concatValues=concatValues+"WATERLOO_EVENT_CODE!"+waterloo_event_type+"!"+waterloo_event_code
	concatValues=concatValues+"#"
	}
if((gcsScore1!=""))	
	{   concatValues=concatValues+"GCS_SCORE!"
	   concatValues=concatValues+gcsScore1+"!"
      concatValues=concatValues+gcsScore2
	   concatValues=concatValues+"#"
	}	
if((num_operator1!=""))	
	{  concatValues=concatValues+"NUM_SCORE!"
	   concatValues=concatValues+num_operator1+"!"
       concatValues=concatValues+num_score
	   concatValues=concatValues+"#"
	}	

if((post_delv_los!=""))	
	{	   concatValues=concatValues+"POST_DELV_LOS!"
	   concatValues=concatValues+post_delv_los_operator+"!"
      concatValues=concatValues+post_delv_los
	   concatValues=concatValues+"#"
	}

if((tat_days!=""))	
	{
	   concatValues=concatValues+"TAT_DAYS!"
	   concatValues=concatValues+tat_days_operator+"!"
      concatValues=concatValues+tat_days
	   concatValues=concatValues+"#"
	}

if((post_op_los!=""))	
	{
	   concatValues=concatValues+"POST_OP_LOS!"
	   concatValues=concatValues+post_op_los1+"!"
      concatValues=concatValues+post_op_los
	   concatValues=concatValues+"#"
	}

	if((re_admit_days!=""))	
	{
	   concatValues=concatValues+"RE_ADMIT_DAYS!"
	   concatValues=concatValues+re_admit_days1+"!"
      concatValues=concatValues+re_admit_days
	   concatValues=concatValues+"#"
	}

if((re_admit_hours!=""))	
	{
	   concatValues=concatValues+"RE_ADMIT_HOURS!"
	   concatValues=concatValues+re_admit_hours1+"!"
      concatValues=concatValues+re_admit_hours
	   concatValues=concatValues+"#"
	}

if((waterloo_score!=""))	
	{
	   concatValues=concatValues+"WATERLOO_SCORE!"
	   concatValues=concatValues+waterloo_score1+"!"
      concatValues=concatValues+waterloo_score
	   concatValues=concatValues+"#"
	}

// for surg_type and lmt_rpt_trn_time

if(surg_type!="")
	{
	concatValues=concatValues+"SURG_TYPE!"+surg_type
	concatValues=concatValues+"#"
	}
   
 /*  if(lmt_rpt_trn_time!="")
	{
	concatValues=concatValues+"LMT_RPT_TRM_TIME!"+lmt_rpt_trn_time
	concatValues=concatValues+"#"
	}*/
     
 f_query_add_mod.document.qaindform.concatValues.value=concatValues;

 if(f_query_add_mod.document.qaindform.dflt_bd_by_gender_yn.checked)
f_query_add_mod.document.qaindform.dflt_bd_by_gender_yn.value="Y";
 else
	 f_query_add_mod.document.qaindform.dflt_bd_by_gender_yn.value="N";

var fields = new Array (f_query_add_mod.document.qaindform.qind_clind_id,
						f_query_add_mod.document.qaindform.qind_clind_desc,
	f_query_add_mod.document.qaindform.qind_group_id,f_query_add_mod.document.qaindform.area_of_concern,f_query_add_mod.document.qaindform.clind_type);
	var names = new Array ( "Indicator ID","Indicator Description","Indicator Group","Area Of Concern","Indicator Type");

var numerator = f_query_add_mod.document.qaindform.numerator.value;
var denomenator = f_query_add_mod.document.qaindform.denomenator.value;

		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
	//		f_query_add_mod.document.qaindform.standard_value.value=standard_oper+"!"+standard_value
			f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
				 f_query_add_mod.document.forms[0].target="messageFrame";
  f_query_add_mod.document.qaindform.submit();
}
}

function onSuccess() 
 {
   f_query_add_mod.document.location.reload();
 }
//Functions moved from addModifyQAIndicator.jsp

function disabletext()
{
	  //document.forms[0].month.disabled=false
    //  document.forms[0].day.disabled=false
	 // document.forms[0].year.disabled=false
	//alert(document.forms[0].age_range.value)

	if(document.forms[0].age_range.value==0)
	document.getElementById("gif").style.visibility="hidden";
	else
		document.getElementById("gif").style.visibility="visible";

  if(!(document.forms[0].age_range.value==5)){ 
	document.forms[0].month.value=""
	document.forms[0].month.readOnly=true
  }
  else   {
	document.forms[0].month.readOnly=false
  }
 	  
  if(document.forms[0].age_range.value==0){
	  document.forms[0].month.value=""
      document.forms[0].day.value=""
	  document.forms[0].year.value=""
	  document.forms[0].month.disabled=true
      document.forms[0].day.disabled=true
	  document.forms[0].year.disabled=true
  } 
//added by shashi on 12/10/2006 agst scr no 1036
  else if (document.forms[0].age_range.value!=0){
	  document.forms[0].month.disabled=false;
      document.forms[0].day.disabled=false;
	  document.forms[0].year.disabled=false;
  }

	 /*if(document.getElementById("qind_clind_id").value=='42' || document.getElementById("qind_clind_id").value=='')
		  document.getElementById("lmt_rpt_trn_time").disabled=false;
	  else
		  document.getElementById("lmt_rpt_trn_time").disabled=true;*/

		disablegestation('surg');
		disablegestation('ges');
}
/*function mandate()
{
	//alert(document.forms[0].gest_period_operator.value);
	if(document.forms[0].gest_period_operator.value=='')
	    document.getElementById("gif2").style.visibility="hidden";
	else
		document.getElementById("gif2").style.visibility="visible";
}*/

function callFocus(tabno)
 {
	
 	if(tabno == 1)
	 {
	  tab1.scrollIntoView();
	 document.forms[0].qind_clind_id.focus();
	 }
	else if(tabno == 2)
	 {
	 tab2.scrollIntoView();
		if (document.forms[0].gender.disabled==true){
			document.forms[0].surg_type.focus(); 
		 }
		else
			document.forms[0].gender.focus(); 
	 }
    else if(tabno == 3)
	 {
	  tab3.scrollIntoView();
	  //modified  by munisekhar 
	  if(document.forms[0].clind_type.value!='S'){
	 document.forms[0].numerator.focus();
	 }
	 } 
	 
 }

/* disable's fields of gestation and pregnancy admission type for male and unknown 
8/9/2006 3:51 PM added by kiran kumar e
Modified by shashi on 13/10/2006 agst SCF 
*/
 function disablegestation(opt) 
 {
	if(opt=='ges')
	 {
		var gender=document.getElementById("gender").value;
gender=gender==""?"U":gender;

		if (gender=='M' || gender=='U')
		{
			document.getElementById("gest_period").value='';
			document.getElementById("gest_period_operator").value='';
			document.getElementById("gest_period_in_dwmy").value='';	
			document.getElementById("term_preg_adm_type").value='';

			document.getElementById("gest_period_operator").disabled=true;
			document.getElementById("gest_period").disabled=true;
			document.getElementById("gest_period_in_dwmy").disabled=true;
			document.getElementById("term_preg_adm_type").disabled=true;

			document.getElementById("waterloo_event_type").value='';
			document.getElementById("waterloo_event_code").value='';
			document.getElementById("waterloo_score1").value='';
			document.getElementById("waterloo_score").value='';
			document.getElementById("gest_period_operator").value='';
			document.getElementById("gest_period").value='';
			document.getElementById("gest_period_in_dwmy").value='';
			document.getElementById("post_delv_los_operator").value='';
			document.getElementById("post_delv_los").value='';
			document.getElementById("term_preg_adm_type").value='';
			document.getElementById("nod_type").value='';

			document.getElementById("waterloo_event_type").disabled=true;
			document.getElementById("waterloo_event_code").disabled=true;
			document.getElementById("waterloo_score1").disabled=true;
			document.getElementById("waterloo_score").disabled=true;
			document.getElementById("gest_period_operator").disabled=true;
			document.getElementById("gest_period").disabled=true;
			document.getElementById("gest_period_in_dwmy").disabled=true;
			document.getElementById("post_delv_los_operator").disabled=true;
			document.getElementById("post_delv_los").disabled=true;
			document.getElementById("term_preg_adm_type").disabled=true;
			document.getElementById("nod_type").disabled=true;
		}
		else
		 {
			document.getElementById("gest_period_operator").disabled=false;
			document.getElementById("gest_period").disabled=false;
			document.getElementById("gest_period_in_dwmy").disabled=false;
			document.getElementById("term_preg_adm_type").disabled=false;

			document.getElementById("waterloo_event_type").disabled=false;
			document.getElementById("waterloo_event_code").disabled=false;
			document.getElementById("waterloo_score1").disabled=false;
			document.getElementById("waterloo_score").disabled=false;
			document.getElementById("gest_period_operator").disabled=false;
			document.getElementById("gest_period").disabled=false;
			document.getElementById("gest_period_in_dwmy").disabled=false;
			document.getElementById("post_delv_los_operator").disabled=false;
			document.getElementById("post_delv_los").disabled=false;
			document.getElementById("term_preg_adm_type").disabled=false;
			document.getElementById("nod_type").disabled=false;
		 }
	 }
	if(opt=='surg')
	 {
		if(document.getElementById("clind_class").value=='P' || document.getElementById("clind_class").value=='Z' ||document.getElementById("clind_class").value=='')
			document.getElementById("surg_type").disabled=false;
		else
			document.getElementById("surg_type").disabled=true;
	 
	 }
 }
