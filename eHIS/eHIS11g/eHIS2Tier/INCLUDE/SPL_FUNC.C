/*
   int l_st_no = 0;
   char l_long_out_str [ /# max_no  + 1#/ ];
   
   while (l_st_no < strlen(input_long_array))
   {
      split_text(input_long_array,80,l_long_out_str,&l_st_no); /# max no is 80#/
      printf("%s",l_long_out_str);
   }
*/

/*  Input str , No of chars , Output str, running ctr (address) */
split_text(in_str,max_no,l_long_out_str,l_st_no)
char *in_str,*l_long_out_str;
int max_no,*l_st_no;
{
   int j = 0,k = 0,splt = 0,last = 0,l = 0;
   char out_str[100],loc_str[100];
   in_str += (*l_st_no);
   k = last = 0;
   while (1)
   {
       for (j = k;j<k+max_no;j++)
       {
           if (in_str[j] == '\0')
           {
                last = 1;
                break;
           }
       }
       if (last == 1)
       {
           for (l=k;l<k+max_no;l++)
           {
              if (in_str[l] == '\0')
              {
                   if (in_str[l-1] != '\n')
                   {
                       *l_st_no += (strlen(l_long_out_str) + 1);
                       if (l_long_out_str[0] == ' ' && l_long_out_str[1] != ' ')
                              strcpy(l_long_out_str,l_long_out_str+1);
                       return(strlen(l_long_out_str));
                   }
                   break;
              }
              if (in_str[l] != '\n')
                    sprintf(l_long_out_str,"%s%c",l_long_out_str,in_str[l]);
              else
              {
                   *l_st_no += (strlen(l_long_out_str) + 1);
                   if (l_long_out_str[0] == ' ' && l_long_out_str[1] != ' ')
                         strcpy(l_long_out_str,l_long_out_str+1);
                   return(strlen(l_long_out_str));
              }
           }
           break;
       }
       strncpy(loc_str,in_str+k,max_no);
       loc_str[max_no] = '\0';
       splt = find_next_split(loc_str,max_no);
       strncpy(out_str,loc_str,splt);
       out_str[splt] = '\0';
       sprintf(l_long_out_str,"%s%s",l_long_out_str,out_str);
       *l_st_no += strlen(l_long_out_str);
       if (loc_str[splt] == '\n') (*l_st_no)++;
       if (l_long_out_str[0] == ' ' && l_long_out_str[1] != ' ')
            strcpy(l_long_out_str,l_long_out_str+1);
       return (strlen(l_long_out_str));
       k+=(splt+1);
   }
}


find_next_split(str,max_no)
char str[];
int max_no;
{
   int k = 0,spc = 0,j = 0;
   for (k=0;((k<max_no) && (str[k] != '\0'));k++)
   {
       if (str[k] == '\n')
            return (k);
       if (str[k] == ' ' && k >= (max_no/2))
             spc = 1;
   }
   if (spc)
   {
      for (j=k;j>=(max_no/2);j--)
           if (str[j] == ' ')
                 return (j);
   }
   return(max_no);
}
