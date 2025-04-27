#include <string.h>
#include <stdio.h>
#include <ctype.h>

	/* SPLITTING THE VARCHAR INTO CHARACTERS  of SPECIFIED LENGTH */
	/************************************************/

char string_var[200];

void main()
{

 
	char l_1[200];
	char l_2 = ' ';
	int l_3 = 20;

	char l_out_string1[200];
	char l_out_string2[200];
	char l_out_string3[200];
	char l_out_string4[200];

	strcpy(l_1, "12345 6789012345678 90 1234567");


	rl_split_text(l_1, l_2, l_3, l_out_string1, l_out_string2, l_out_string3, l_out_string4);

/*
printf(l_out_string1);
printf("\n");
printf(l_out_string2);
printf("\n");
printf(l_out_string3);
printf("\n");
printf(l_out_string4);
printf("\n");
*/

}



rl_split_text(char v_string[], char v_delimeter, int v_len, char v_out_string1[],
			char v_out_string2[], char v_out_string3[], char v_out_string4[])
{


	char l_string[200];
	char l_delimeter[5];

	int l_ascii_val = 0; 
	int l_asc_val = 0;
	int l_tot_length = 0;
	int l_num = 1;

	char word[2];
	char w_flag ;
	char word1[2];

	int l_len = 0;
	int i = 0, z = 0, clt = 0, qq = 0, cntr = 0, cmp = 0;


	l_tot_length = v_len + 1;
	l_ascii_val = __toascii(v_delimeter);
	sprintf(l_delimeter, "%c", v_delimeter);

	strcpy(word1,"F");

	strcpy(l_string, "");
	strcpy(v_out_string1, "");
	strcpy(v_out_string2, "");
	strcpy(v_out_string3, "");
	strcpy(v_out_string4, "");

	w_flag = 'T';

	l_len = strlen(v_string);

	 z = 0;
	 clt = 0;
	 strcpy(word1,"F"); 
	 cntr = 1;
	 qq = 0;

	 while(z<l_len)
	 {
		 		

		 word[0] = v_string[z];
 		 word[1] = '\0';


		 if (strcmp(word, "\n") == 0)
		 {
   		   cntr = 0;
		   strcpy(word1,"N");
		   qq = z ;
		  }


  		  if(cntr >= l_tot_length)
		  {
		
			 cmp = cntr;

			 while((v_string[z] != l_ascii_val) && (cmp > 1))
			 {

				 z--;
				 cmp--;
			  
			  }

			  qq = z;
				  		   
			  word[0] = v_string[z];
   			  word[1] = '\0';

			  if (cmp == 1)
				 strcpy(word1,"W");
			  else
				 strcpy(word1,"T");
		   

		   }


			if (((z == l_len) || (z == l_len - 1)) && (strcmp(word1,"F") == 0))
			{


			   for(i=clt;i < z + 1;i++)
			   {

					if ( (v_string[i] == l_ascii_val) )
					{

							w_flag = 'F';
 					 }


				sprintf(l_string, "%s%c", l_string, v_string[i]);

			   }

//sprintf(string_var, "111      %s\n", l_string);
//printf(string_var);
			   if (w_flag == 'T')
			   {
			   };


				if (l_num == 1)
					strcpy(v_out_string1, l_string);
				else if (l_num == 2)
					strcpy(v_out_string2, l_string);
				else if (l_num == 3)
					strcpy(v_out_string3, l_string);
				else if (l_num == 4)
					strcpy(v_out_string4, l_string);

			   l_num++;
			   strcpy(l_string, "");
			   cntr = 0 ;
			   clt = clt + v_len ;
			   z = clt ;
			   qq = 0;
			   strcpy(word1,"F");


			}

		
		   if (strcmp(word1,"N") == 0) 
		   {
			

			   for(i=clt;i <= qq;i++)
			  {
				 if ( (v_string[i] == l_ascii_val) )
				{
					  
					w_flag = 'F';

				}

				sprintf(l_string, "%s%c", l_string, v_string[i]);
				
			  }


			  if (w_flag == 'T')
			  {
			  };
//sprintf(string_var, "222      %s\n", l_string);
//printf(string_var);

				if (l_num == 1)
					strcpy(v_out_string1, l_string);
				else if (l_num == 2)
					strcpy(v_out_string2, l_string);
				else if (l_num == 3)
					strcpy(v_out_string3, l_string);
				else if (l_num == 4)
					strcpy(v_out_string4, l_string);
//			  strcpy(l_string, "");							  
//			   l_num++;

			  strcpy(word1,"F");
			  cntr = 0 ;
			  clt = qq + 1;
			  qq = 0;
		   }

		   if (strcmp(word1,"T") == 0)
		   {
		 									 
			  for(i=clt;i <= qq;i++)
			  {

				 if ( (v_string[i] == l_ascii_val) )
				 {
					 
							w_flag = 'F';

				  }

				 sprintf(l_string, "%s%c", l_string, v_string[i]);
			
			  }

			  if (w_flag == 'T')
			  {
			  };

//sprintf(string_var, "333      %s\n", l_string);
//printf(string_var);

				if (l_num == 1)
					strcpy(v_out_string1, l_string);
				else if (l_num == 2)
					strcpy(v_out_string2, l_string);
				else if (l_num == 3)
					strcpy(v_out_string3, l_string);
				else if (l_num == 4)
					strcpy(v_out_string4, l_string);
			   strcpy(l_string, "");
			   l_num++;

			   cntr = 0 ;
			   clt = qq + 1 ;
			   qq = 0;
			   strcpy(word1,"F");

			
			}


			if (strcmp(word1,"W") == 0)
			{
		 									 
			   for(i=clt;i < clt + v_len;i++)
			   {

				  if ( (v_string[i] == l_ascii_val) )
					{

							w_flag = 'F';
					}

					sprintf(l_string, "%s%c", l_string, v_string[i]);
			
			   }

			   if (w_flag = 'T')
			   {
			   };
//sprintf(string_var, "444      %s\n", l_string);
//printf(string_var);
				if (l_num == 1)
					strcpy(v_out_string1, l_string);
				else if (l_num == 2)
					strcpy(v_out_string2, l_string);
				else if (l_num == 3)
					strcpy(v_out_string3, l_string);
				else if (l_num == 4)
					strcpy(v_out_string4, l_string);

				strcpy(l_string, "");
			   l_num++;

			   cntr = 0 ;
			   clt = clt + v_len ;
			   z = clt ;
			   qq = 0;
			   strcpy(word1,"F");

			
			}


			

		w_flag = 'T';	  
		cntr += 1;
		z++ ;

	  }
	return(v_out_string1, v_out_string2, v_out_string3, v_out_string4);

}

