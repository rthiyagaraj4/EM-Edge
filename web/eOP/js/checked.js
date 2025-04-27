function abc(Obj){

if (Obj.checked==true && Obj.name=="working_day_1")
   clinic_form.working_day_1.value="Y";
else if ( Obj.checked==false && Obj.name=="working_day_1" )
   {    
	clinic_form.working_day_1.value="N";
    if (parseInt(clinic_form.pract_future_appt_day1.value)>0)
	   {
		 alert(getMessage("FUTURE_APPT_EXIST_ON_THIS_DAY","OP"));
		 Obj.checked=true;
		 clinic_form.working_day_1.value="Y";
	   }
   }

else if  (Obj.checked==true && Obj.name=="working_day_2")
   clinic_form.working_day_2.value="Y";
else if (Obj.checked==false && Obj.name=="working_day_2")   
   {    
	clinic_form.working_day_2.value="N";
    if (parseInt(clinic_form.pract_future_appt_day2.value)>0)
	   {
		 alert(getMessage("FUTURE_APPT_EXIST_ON_THIS_DAY","OP"));
		 Obj.checked=true;
		 clinic_form.working_day_2.value="Y";
	   }
   }


 else if  (Obj.checked==true && Obj.name=="working_day_3")
   clinic_form.working_day_3.value="Y";

else if (Obj.checked==false && Obj.name=="working_day_3")   
   {    
	clinic_form.working_day_3.value="N";
    if (parseInt(clinic_form.pract_future_appt_day3.value)>0)
	   {
		 alert(getMessage("FUTURE_APPT_EXIST_ON_THIS_DAY","OP"));
		 Obj.checked=true;
		 clinic_form.working_day_3.value="Y";
	   }
   }


  else if  (Obj.checked==true && Obj.name=="working_day_4")
   clinic_form.working_day_4.value="Y";
else if (Obj.checked==false && Obj.name=="working_day_4")  
   {    
	clinic_form.working_day_4.value="N";
    if (parseInt(clinic_form.pract_future_appt_day4.value)>0)
	   {
		 alert(getMessage("FUTURE_APPT_EXIST_ON_THIS_DAY","OP"));
		 Obj.checked=true;
		 clinic_form.working_day_4.value="Y";
	   }
   }

   

else if (Obj.checked==true && Obj.name=="working_day_5")
   clinic_form.working_day_5.value="Y";
else if (Obj.checked==false && Obj.name=="working_day_5") 
   {    
	clinic_form.working_day_4.value="N";
    if (parseInt(clinic_form.pract_future_appt_day4.value)>0)
	   {
		 alert(getMessage("FUTURE_APPT_EXIST_ON_THIS_DAY","OP"));
		 Obj.checked=true;
		 clinic_form.working_day_4.value="Y";
	   }
   }   
  else if  (Obj.checked==true && Obj.name=="working_day_6")
      clinic_form.working_day_6.value="Y";
  else if (Obj.checked==false && Obj.name=="working_day_6")  
  {    
	clinic_form.working_day_6.value="N";
    if (parseInt(clinic_form.pract_future_appt_day6.value)>0)
	   {
		 alert(getMessage("FUTURE_APPT_EXIST_ON_THIS_DAY","OP"));
		 Obj.checked=true;
		 clinic_form.working_day_6.value="Y";
	   }
   }      
    else if  (Obj.checked==true && Obj.name=="working_day_7")
         clinic_form.working_day_7.value="Y";
   else if (Obj.checked==false && Obj.name=="working_day_7")
   {    
	clinic_form.working_day_7.value="N";
    if (parseInt(clinic_form.pract_future_appt_day7.value)>0)
	   {
		 alert(getMessage("FUTURE_APPT_EXIST_ON_THIS_DAY","OP"));
		 Obj.checked=true;
		 clinic_form.working_day_7.value="Y";
	   }
   }

else if  (Obj.checked==true && Obj.name=="active")
         clinic_form.active.value="E";
      else if (Obj.checked==false && Obj.name=="active")
		  {
	       clinic_form.active.value="D";     
		   if (parseInt(clinic_form.pract_future_appt.value)>0)
		   {
             alert(getMessage("PAT_FUTURE_APPT_EXISTS","OP"));
			 Obj.checked=true;
			 clinic_form.active.value="D"; 
		   }
		 }

          

}

function ed(obj){

}





