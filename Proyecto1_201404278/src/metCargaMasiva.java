

public class metCargaMasiva {
    
    public metCargaMasiva(){
    
    }
    
    public static void LibrosPrincipal(){
        
           Usuarios.cadenaArea = Usuarios.txtarea.getText(); //captura el dato guardado en txtarea
            
        
            Usuarios.posicionn = Usuarios.cadenaArea.indexOf(";"); 
            //System.out.println(posicion);
            String frase1 =Usuarios.cadenaArea.substring(0, Usuarios.posicionn);
            //System.out.println(frase1);
            int cap=Usuarios.posicionn;
            
            Usuarios.posicionn = Usuarios.cadenaArea.indexOf(";",Usuarios.posicionn+1); 
            //System.out.println(posicion); 
            String frase2=Usuarios.cadenaArea.substring(cap+1, Usuarios.posicionn);
           // System.out.println(frase2);
            int cap2=Usuarios.posicionn;
             
            Usuarios.posicionn=Usuarios.cadenaArea.indexOf(";", Usuarios.posicionn+1);
            //System.out.println(posicion); 
            String frase3=Usuarios.cadenaArea.substring(cap2+1, Usuarios.posicionn);
            //System.out.println(frase3);
            int cap3=Usuarios.posicionn;
            
            Usuarios.posicionn=Usuarios.cadenaArea.indexOf(";", Usuarios.posicionn+1);
            //System.out.println(""+posicion); 
            String frase4=Usuarios.cadenaArea.substring(cap3+1, Usuarios.posicionn);
            //System.out.println(frase4);
            int cap4=Usuarios.posicionn;
            
            
            Usuarios.posicionn=Usuarios.cadenaArea.indexOf(";", Usuarios.posicionn+1);
            //System.out.println(posicion); 
            String frase5=Usuarios.cadenaArea.substring(cap4+1, Usuarios.posicionn);
            //System.out.println(frase5);
            int cap5=Usuarios.posicionn;
            
            Usuarios.posicionn=Usuarios.cadenaArea.indexOf(";", Usuarios.posicionn+1);
            //System.out.println(posicion); 
            String frase6=Usuarios.cadenaArea.substring(cap5+1, Usuarios.posicionn);
            //System.out.println(frase6);
            int cap6=Usuarios.posicionn;
            
            Usuarios.posicionn=Usuarios.cadenaArea.indexOf(";", Usuarios.posicionn+1);
            //System.out.println(posicion); 
            String frase7=Usuarios.cadenaArea.substring(cap6+1, Usuarios.posicionn);
            //System.out.println(frase7);
            int cap7=Usuarios.posicionn;
            
            Usuarios.posicionn=Usuarios.cadenaArea.indexOf(";", Usuarios.posicionn+1);
            //System.out.println(posicion); 
            String frase8=Usuarios.cadenaArea.substring(cap7+1, Usuarios.posicionn);
            //System.out.println(frase8);
            int cap8=Usuarios.posicionn;
            
            Usuarios.posicionn=Usuarios.cadenaArea.indexOf(";", Usuarios.posicionn+1);
            //System.out.println(posicion); 
            String frase9=Usuarios.cadenaArea.substring(cap8+1, Usuarios.posicionn);
            //System.out.println(frase9);
                        
            // System.out.println(" "+frase1+" "+frase2+" "+frase3+" "+frase4+" "+frase5+" "+frase6+" "+frase7+" "+frase8+" "+frase9);
            Usuarios.modelo2.addRow(new Object[]{frase1,frase2,frase3,frase4,frase5,"----","----",frase6,frase7,"----",frase8,frase9});
            Usuarios.modelo4.addRow(new Object[]{frase1,frase2,frase3,frase4,frase5,"----","----",frase6,frase7,"----",frase8,frase9,Usuarios.btn1});
            
            
            Usuarios.guardarPos1=Usuarios.posicionn; //aqui guarda el valor de la ultima posicion de la primera fila(libros)
                 System.out.println(Usuarios.guardarPos1+2);
                 
                 if(Usuarios.cadenaArea.charAt(Usuarios.guardarPos1+2)=='0'){ //el +2 es porque como hay salto de linea, 
                     Libros2();                           
                                                                
                  }else if(Usuarios.cadenaArea.charAt(Usuarios.guardarPos1+2)=='1'){
                     Revistas();
                     
                 }else if(Usuarios.cadenaArea.charAt(Usuarios.guardarPos1+2)=='2'){
                     Tesis();
                     
                 }else if(Usuarios.cadenaArea.charAt(Usuarios.guardarPos1+2)=='f'){
                     System.out.println("");
                 }
          
           
     }
    
    public static void RevistasPrincipal(){
        
        Usuarios.cadenaArea = Usuarios.txtarea.getText(); //captura el dato guardado en txtarea
        
         Usuarios.posicionn1 = Usuarios.cadenaArea.indexOf(";");  ///// y empieza a buscar el ; apartir de la posicion donde se quedo libros
            //System.out.println(posicion);
            String frase1 =Usuarios.cadenaArea.substring(0, Usuarios.posicionn1);
            //System.out.println(frase1);
            int cap=Usuarios.posicionn1;
            
            Usuarios.posicionn1 = Usuarios.cadenaArea.indexOf(";",Usuarios.posicionn1+1); 
            //System.out.println(posicion); 
            String frase2=Usuarios.cadenaArea.substring(cap+1, Usuarios.posicionn1);
            //System.out.println(frase2);
            int cap2=Usuarios.posicionn1;
             
            Usuarios.posicionn1=Usuarios.cadenaArea.indexOf(";", Usuarios.posicionn1+1);
            //System.out.println(posicion); 
            String frase3=Usuarios.cadenaArea.substring(cap2+1, Usuarios.posicionn1);
            //System.out.println(frase3);
            int cap3=Usuarios.posicionn1;
            
            Usuarios.posicionn1=Usuarios.cadenaArea.indexOf(";", Usuarios.posicionn1+1);
            //System.out.println(""+posicion); 
            String frase4=Usuarios.cadenaArea.substring(cap3+1, Usuarios.posicionn1);
            //System.out.println(frase4);
            int cap4=Usuarios.posicionn1;
            
            
            Usuarios.posicionn1=Usuarios.cadenaArea.indexOf(";", Usuarios.posicionn1+1);
            //System.out.println(posicion); 
            String frase5=Usuarios.cadenaArea.substring(cap4+1, Usuarios.posicionn1);
            //System.out.println(frase5);
            int cap5=Usuarios.posicionn1;
            
            Usuarios.posicionn1=Usuarios.cadenaArea.indexOf(";", Usuarios.posicionn1+1);
            //System.out.println(posicion); 
            String frase6=Usuarios.cadenaArea.substring(cap5+1, Usuarios.posicionn1);
            //System.out.println(frase6);
            int cap6=Usuarios.posicionn1;
            
            Usuarios.posicionn1=Usuarios.cadenaArea.indexOf(";", Usuarios.posicionn1+1);
            //System.out.println(posicion); 
            String frase7=Usuarios.cadenaArea.substring(cap6+1, Usuarios.posicionn1);
            //System.out.println(frase7);
            int cap7=Usuarios.posicionn1;
            
            Usuarios.posicionn1=Usuarios.cadenaArea.indexOf(";", Usuarios.posicionn1+1);
            //System.out.println(posicion); 
            String frase8=Usuarios.cadenaArea.substring(cap7+1, Usuarios.posicionn1);
            //System.out.println(frase8);
            int cap8=Usuarios.posicionn1;
            
            Usuarios.posicionn1=Usuarios.cadenaArea.indexOf(";", Usuarios.posicionn1+1);
            //System.out.println(posicion); 
            String frase9=Usuarios.cadenaArea.substring(cap8+1, Usuarios.posicionn1);
            //System.out.println(frase9);
            int cap9=Usuarios.posicionn1;
            
            Usuarios.posicionn1=Usuarios.cadenaArea.indexOf(";", Usuarios.posicionn1+1);
            //System.out.println(posicion); 
            String frase10=Usuarios.cadenaArea.substring(cap9+1, Usuarios.posicionn1);
            //System.out.println(frase10);
            int cap10=Usuarios.posicionn1;
            
            Usuarios.posicionn1=Usuarios.cadenaArea.indexOf(";", Usuarios.posicionn1+1);
            //System.out.println(posicion); 
            String frase11=Usuarios.cadenaArea.substring(cap10+1, Usuarios.posicionn1);
            //System.out.println(frase11);
            
           Usuarios.modelo2.addRow(new Object[]{"1",frase2,frase3,frase4,frase5,frase6,frase7,frase8,frase9,"----",frase10,frase11});
           Usuarios.modelo4.addRow(new Object[]{"1",frase2,frase3,frase4,frase5,frase6,frase7,frase8,frase9,"----",frase10,frase11,Usuarios.btn1});
           
            
            Usuarios.guardarPos1=Usuarios.posicionn1;
                // System.out.println(Usuarios.guardarPos2);
                 
                 if(Usuarios.cadenaArea.charAt(Usuarios.guardarPos1+2)=='0'){
                    Libros2();
                    }
                 else if(Usuarios.cadenaArea.charAt(Usuarios.guardarPos1+2)=='1'){
                     Revistas();

                 }
                 else if(Usuarios.cadenaArea.charAt(Usuarios.guardarPos1+2)=='2'){
                     //System.out.println(Usuarios.posicionn);
                      Tesis();
                 }else if(Usuarios.cadenaArea.charAt(Usuarios.guardarPos1)=='f'){
                      System.out.println("");
                  }
        
    }
    
    public static void TesisPrincipal(){
        
        Usuarios.cadenaArea = Usuarios.txtarea.getText(); //captura el dato guardado en txtarea
        
            Usuarios.posicionn2 = Usuarios.cadenaArea.indexOf(";"); 
            //System.out.println(posicion);
            String frase1 =Usuarios.cadenaArea.substring(0, Usuarios.posicionn2);
            //System.out.println(frase1);
            int cap=Usuarios.posicionn2;
            
            Usuarios.posicionn2 = Usuarios.cadenaArea.indexOf(";",Usuarios.posicionn2+1); 
            //System.out.println(posicion); 
            String frase2=Usuarios.cadenaArea.substring(cap+1, Usuarios.posicionn2);
            //System.out.println(frase2);
            int cap2=Usuarios.posicionn2;
             
            Usuarios.posicionn2=Usuarios.cadenaArea.indexOf(";", Usuarios.posicionn2+1);
            //System.out.println(posicion); 
            String frase3=Usuarios.cadenaArea.substring(cap2+1, Usuarios.posicionn2);
            //System.out.println(frase3);
            int cap3=Usuarios.posicionn2;
            
            Usuarios.posicionn2=Usuarios.cadenaArea.indexOf(";", Usuarios.posicionn2+1);
            //System.out.println(""+posicion); 
            String frase4=Usuarios.cadenaArea.substring(cap3+1, Usuarios.posicionn2);
            //System.out.println(frase4);
            int cap4=Usuarios.posicionn2;
            
            
            Usuarios.posicionn2=Usuarios.cadenaArea.indexOf(";", Usuarios.posicionn2+1);
            //System.out.println(posicion); 
            String frase5=Usuarios.cadenaArea.substring(cap4+1, Usuarios.posicionn2);
            //System.out.println(frase5);
            int cap5=Usuarios.posicionn2;
            
            Usuarios.posicionn2=Usuarios.cadenaArea.indexOf(";", Usuarios.posicionn2+1);
            //System.out.println(posicion); 
            String frase6=Usuarios.cadenaArea.substring(cap5+1, Usuarios.posicionn2);
            //System.out.println(frase6);
            int cap6=Usuarios.posicionn2;
            
            Usuarios.posicionn2=Usuarios.cadenaArea.indexOf(";", Usuarios.posicionn2+1);
            //System.out.println(posicion); 
            String frase7=Usuarios.cadenaArea.substring(cap6+1, Usuarios.posicionn2);
            //System.out.println(frase7);
            int cap7=Usuarios.posicionn2;
            
            Usuarios.posicionn2=Usuarios.cadenaArea.indexOf(";", Usuarios.posicionn2+1);
            //System.out.println(posicion); 
            String frase8=Usuarios.cadenaArea.substring(cap7+1, Usuarios.posicionn2);
            //System.out.println(frase8);
            int cap8=Usuarios.posicionn2;
            
            Usuarios.posicionn2=Usuarios.cadenaArea.indexOf(";", Usuarios.posicionn2+1);
            //System.out.println(posicion); 
            String frase9=Usuarios.cadenaArea.substring(cap8+1, Usuarios.posicionn2);
            //System.out.println(frase9);
            int cap9=Usuarios.posicionn2;
            
            Usuarios.posicionn2=Usuarios.cadenaArea.indexOf(";", Usuarios.posicionn2+1);
            //System.out.println(posicion); 
            String frase10=Usuarios.cadenaArea.substring(cap9+1, Usuarios.posicionn2);
            //System.out.println(frase9);
           
            Usuarios.modelo2.addRow(new Object[]{"2",frase2,frase3,frase4,frase5,"----","----",frase6,frase7,frase8,frase9,frase10});
            Usuarios.modelo4.addRow(new Object[]{"2",frase2,frase3,frase4,frase5,"----","----",frase6,frase7,frase8,frase9,frase10,Usuarios.btn1});
            
            
            Usuarios.guardarPos1=Usuarios.posicionn2;
                // System.out.println(Usuarios.guardarPos2);
                 
                 if(Usuarios.cadenaArea.charAt(Usuarios.guardarPos1+2)=='0'){
                     Libros2();
                    
                 }else if(Usuarios.cadenaArea.charAt(Usuarios.guardarPos1+2)=='1'){
                     
                     Revistas();
                     
                 }else if(Usuarios.cadenaArea.charAt(Usuarios.guardarPos1+2)=='2'){
                     //System.out.println(Usuarios.posicionn);
                      Tesis();
                 }else if(Usuarios.cadenaArea.charAt(Usuarios.guardarPos1+2)=='f'){
                      System.out.println("");
                  }
        
    }
    
    
    public static void Revistas(){
        
        //Usuarios.cadenaArea = Usuarios.txtarea.getText(); //captura el dato guardado en txtarea
        
         ////// posicionn es donde termina libros
             if(Usuarios.cadenaArea.charAt(Usuarios.guardarPos1+2)=='1'){
                 
            Usuarios.posicionn1 = Usuarios.cadenaArea.indexOf(";",Usuarios.guardarPos1+2);  ///// y empieza a buscar el ; apartir de la posicion donde se quedo libros
            //System.out.println(posicion);
            String frase1 =Usuarios.cadenaArea.substring(0, Usuarios.posicionn1);
            //System.out.println(frase1);
            int cap=Usuarios.posicionn1;
            
            Usuarios.posicionn1 = Usuarios.cadenaArea.indexOf(";",Usuarios.posicionn1+1); 
            //System.out.println(posicion); 
            String frase2=Usuarios.cadenaArea.substring(cap+1, Usuarios.posicionn1);
            //System.out.println(frase2);
            int cap2=Usuarios.posicionn1;
             
            Usuarios.posicionn1=Usuarios.cadenaArea.indexOf(";", Usuarios.posicionn1+1);
            //System.out.println(posicion); 
            String frase3=Usuarios.cadenaArea.substring(cap2+1, Usuarios.posicionn1);
            //System.out.println(frase3);
            int cap3=Usuarios.posicionn1;
            
            Usuarios.posicionn1=Usuarios.cadenaArea.indexOf(";", Usuarios.posicionn1+1);
            //System.out.println(""+posicion); 
            String frase4=Usuarios.cadenaArea.substring(cap3+1, Usuarios.posicionn1);
            //System.out.println(frase4);
            int cap4=Usuarios.posicionn1;
            
            
            Usuarios.posicionn1=Usuarios.cadenaArea.indexOf(";", Usuarios.posicionn1+1);
            //System.out.println(posicion); 
            String frase5=Usuarios.cadenaArea.substring(cap4+1, Usuarios.posicionn1);
            //System.out.println(frase5);
            int cap5=Usuarios.posicionn1;
            
            Usuarios.posicionn1=Usuarios.cadenaArea.indexOf(";", Usuarios.posicionn1+1);
            //System.out.println(posicion); 
            String frase6=Usuarios.cadenaArea.substring(cap5+1, Usuarios.posicionn1);
            //System.out.println(frase6);
            int cap6=Usuarios.posicionn1;
            
            Usuarios.posicionn1=Usuarios.cadenaArea.indexOf(";", Usuarios.posicionn1+1);
            //System.out.println(posicion); 
            String frase7=Usuarios.cadenaArea.substring(cap6+1, Usuarios.posicionn1);
            //System.out.println(frase7);
            int cap7=Usuarios.posicionn1;
            
            Usuarios.posicionn1=Usuarios.cadenaArea.indexOf(";", Usuarios.posicionn1+1);
            //System.out.println(posicion); 
            String frase8=Usuarios.cadenaArea.substring(cap7+1, Usuarios.posicionn1);
            //System.out.println(frase8);
            int cap8=Usuarios.posicionn1;
            
            Usuarios.posicionn1=Usuarios.cadenaArea.indexOf(";", Usuarios.posicionn1+1);
            //System.out.println(posicion); 
            String frase9=Usuarios.cadenaArea.substring(cap8+1, Usuarios.posicionn1);
            //System.out.println(frase9);
            int cap9=Usuarios.posicionn1;
            
            Usuarios.posicionn1=Usuarios.cadenaArea.indexOf(";", Usuarios.posicionn1+1);
            //System.out.println(posicion); 
            String frase10=Usuarios.cadenaArea.substring(cap9+1, Usuarios.posicionn1);
            //System.out.println(frase10);
            int cap10=Usuarios.posicionn1;
            
            Usuarios.posicionn1=Usuarios.cadenaArea.indexOf(";", Usuarios.posicionn1+1);
            //System.out.println(posicion); 
            String frase11=Usuarios.cadenaArea.substring(cap10+1, Usuarios.posicionn1);
            //System.out.println(frase11);
            
           Usuarios.modelo2.addRow(new Object[]{"1",frase2,frase3,frase4,frase5,frase6,frase7,frase8,frase9,"----",frase10,frase11});
           Usuarios.modelo4.addRow(new Object[]{"1",frase2,frase3,frase4,frase5,frase6,frase7,frase8,frase9,"----",frase10,frase11,Usuarios.btn1});
            
           
            Usuarios.guardarPos1=Usuarios.posicionn1;
                // System.out.println(Usuarios.guardarPos2);
                 
                 if(Usuarios.cadenaArea.charAt(Usuarios.guardarPos1+2)=='0'){
                    Libros2();
                    }
                 else if(Usuarios.cadenaArea.charAt(Usuarios.guardarPos1+2)=='1'){
                     Revistas();

                 }
                 else if(Usuarios.cadenaArea.charAt(Usuarios.guardarPos1+2)=='2'){
                     //System.out.println(Usuarios.posicionn);
                      Tesis();
                 }else if(Usuarios.cadenaArea.charAt(Usuarios.guardarPos1)=='f'){
                      System.out.println("");
                  }
             }
             
             
        
    }
    
    public static void Tesis(){
        
       // Usuarios.cadenaArea = Usuarios.txtarea.getText(); //captura el dato guardado en txtarea
        
            if(Usuarios.cadenaArea.charAt(Usuarios.guardarPos1+2)=='2'){
            Usuarios.posicionn2 = Usuarios.cadenaArea.indexOf(";",Usuarios.guardarPos1+2); 
            //System.out.println(posicion);
            String frase1 =Usuarios.cadenaArea.substring(0, Usuarios.posicionn2);
            //System.out.println(frase1);
            int cap=Usuarios.posicionn2;
            
            Usuarios.posicionn2 = Usuarios.cadenaArea.indexOf(";",Usuarios.posicionn2+1); 
            //System.out.println(posicion); 
            String frase2=Usuarios.cadenaArea.substring(cap+1, Usuarios.posicionn2);
            //System.out.println(frase2);
            int cap2=Usuarios.posicionn2;
             
            Usuarios.posicionn2=Usuarios.cadenaArea.indexOf(";", Usuarios.posicionn2+1);
            //System.out.println(posicion); 
            String frase3=Usuarios.cadenaArea.substring(cap2+1, Usuarios.posicionn2);
            //System.out.println(frase3);
            int cap3=Usuarios.posicionn2;
            
            Usuarios.posicionn2=Usuarios.cadenaArea.indexOf(";", Usuarios.posicionn2+1);
            //System.out.println(""+posicion); 
            String frase4=Usuarios.cadenaArea.substring(cap3+1, Usuarios.posicionn2);
            //System.out.println(frase4);
            int cap4=Usuarios.posicionn2;
            
            
            Usuarios.posicionn2=Usuarios.cadenaArea.indexOf(";", Usuarios.posicionn2+1);
            //System.out.println(posicion); 
            String frase5=Usuarios.cadenaArea.substring(cap4+1, Usuarios.posicionn2);
            //System.out.println(frase5);
            int cap5=Usuarios.posicionn2;
            
            Usuarios.posicionn2=Usuarios.cadenaArea.indexOf(";", Usuarios.posicionn2+1);
            //System.out.println(posicion); 
            String frase6=Usuarios.cadenaArea.substring(cap5+1, Usuarios.posicionn2);
            //System.out.println(frase6);
            int cap6=Usuarios.posicionn2;
            
            Usuarios.posicionn2=Usuarios.cadenaArea.indexOf(";", Usuarios.posicionn2+1);
            //System.out.println(posicion); 
            String frase7=Usuarios.cadenaArea.substring(cap6+1, Usuarios.posicionn2);
            //System.out.println(frase7);
            int cap7=Usuarios.posicionn2;
            
            Usuarios.posicionn2=Usuarios.cadenaArea.indexOf(";", Usuarios.posicionn2+1);
            //System.out.println(posicion); 
            String frase8=Usuarios.cadenaArea.substring(cap7+1, Usuarios.posicionn2);
            //System.out.println(frase8);
            int cap8=Usuarios.posicionn2;
            
            Usuarios.posicionn2=Usuarios.cadenaArea.indexOf(";", Usuarios.posicionn2+1);
            //System.out.println(posicion); 
            String frase9=Usuarios.cadenaArea.substring(cap8+1, Usuarios.posicionn2);
            //System.out.println(frase9);
            int cap9=Usuarios.posicionn2;
            
            Usuarios.posicionn2=Usuarios.cadenaArea.indexOf(";", Usuarios.posicionn2+1);
            //System.out.println(posicion); 
            String frase10=Usuarios.cadenaArea.substring(cap9+1, Usuarios.posicionn2);
            //System.out.println(frase9);
           
            Usuarios.modelo2.addRow(new Object[]{"2",frase2,frase3,frase4,frase5,"----","----",frase6,frase7,frase8,frase9,frase10});
            Usuarios.modelo4.addRow(new Object[]{"2",frase2,frase3,frase4,frase5,"----","----",frase6,frase7,frase8,frase9,frase10,Usuarios.btn1});
            
            
            Usuarios.guardarPos1=Usuarios.posicionn2;
                // System.out.println(Usuarios.guardarPos2);
                 
                 if(Usuarios.cadenaArea.charAt(Usuarios.guardarPos1+2)=='0'){
                     Libros2();
                    
                 }else if(Usuarios.cadenaArea.charAt(Usuarios.guardarPos1+2)=='1'){
                     
                     Revistas();
                     
                 }else if(Usuarios.cadenaArea.charAt(Usuarios.guardarPos1+2)=='2'){
                     //System.out.println(Usuarios.posicionn);
                      Tesis();
                 }else if(Usuarios.cadenaArea.charAt(Usuarios.guardarPos1+2)=='f'){
                      System.out.println("");
                  }
          
            
            }
        
    }
    
     public static void Libros2(){
        
            if(Usuarios.cadenaArea.charAt(Usuarios.guardarPos1+2)=='0'){
            
                Usuarios.posicionn = Usuarios.cadenaArea.indexOf(";",Usuarios.guardarPos1+2); 
            //System.out.println(posicion);
            String frase1 =Usuarios.cadenaArea.substring(0, Usuarios.posicionn);
            //System.out.println(frase1);
            int cap=Usuarios.posicionn;
            
            Usuarios.posicionn = Usuarios.cadenaArea.indexOf(";",Usuarios.posicionn+1); 
            //System.out.println(posicion); 
            String frase2=Usuarios.cadenaArea.substring(cap+1, Usuarios.posicionn);
           // System.out.println(frase2);
            int cap2=Usuarios.posicionn;
             
            Usuarios.posicionn=Usuarios.cadenaArea.indexOf(";", Usuarios.posicionn+1);
            //System.out.println(posicion); 
            String frase3=Usuarios.cadenaArea.substring(cap2+1, Usuarios.posicionn);
            //System.out.println(frase3);
            int cap3=Usuarios.posicionn;
            
            Usuarios.posicionn=Usuarios.cadenaArea.indexOf(";", Usuarios.posicionn+1);
            //System.out.println(""+posicion); 
            String frase4=Usuarios.cadenaArea.substring(cap3+1, Usuarios.posicionn);
            //System.out.println(frase4);
            int cap4=Usuarios.posicionn;
            
            
            Usuarios.posicionn=Usuarios.cadenaArea.indexOf(";", Usuarios.posicionn+1);
            //System.out.println(posicion); 
            String frase5=Usuarios.cadenaArea.substring(cap4+1, Usuarios.posicionn);
            //System.out.println(frase5);
            int cap5=Usuarios.posicionn;
            
            Usuarios.posicionn=Usuarios.cadenaArea.indexOf(";", Usuarios.posicionn+1);
            //System.out.println(posicion); 
            String frase6=Usuarios.cadenaArea.substring(cap5+1, Usuarios.posicionn);
            //System.out.println(frase6);
            int cap6=Usuarios.posicionn;
            
            Usuarios.posicionn=Usuarios.cadenaArea.indexOf(";", Usuarios.posicionn+1);
            //System.out.println(posicion); 
            String frase7=Usuarios.cadenaArea.substring(cap6+1, Usuarios.posicionn);
            //System.out.println(frase7);
            int cap7=Usuarios.posicionn;
            
            Usuarios.posicionn=Usuarios.cadenaArea.indexOf(";", Usuarios.posicionn+1);
            //System.out.println(posicion); 
            String frase8=Usuarios.cadenaArea.substring(cap7+1, Usuarios.posicionn);
            //System.out.println(frase8);
            int cap8=Usuarios.posicionn;
            
            Usuarios.posicionn=Usuarios.cadenaArea.indexOf(";", Usuarios.posicionn+1);
            //System.out.println(posicion); 
            String frase9=Usuarios.cadenaArea.substring(cap8+1, Usuarios.posicionn);
            //System.out.println(frase9);
                        
            Usuarios.modelo2.addRow(new Object[]{"0",frase2,frase3,frase4,frase5,"----","----",frase6,frase7,"----",frase8,frase9});
            Usuarios.modelo4.addRow(new Object[]{"0",frase2,frase3,frase4,frase5,"----","----",frase6,frase7,"----",frase8,frase9,Usuarios.btn1});
            
            
            Usuarios.guardarPos1=Usuarios.posicionn; //aqui guarda el valor de la ultima posicion de la primera fila(libros)
                 System.out.println(Usuarios.guardarPos1+2);
                 
                 if(Usuarios.cadenaArea.charAt(Usuarios.guardarPos1+2)=='0'){ //el +2 es porque como hay salto de linea, 
                                            //entonces a la ultima posicion de la fila(libros) le sumo el 
                     Libros2();                                               //salto de linea para que me identifique el valor
                  }else if(Usuarios.cadenaArea.charAt(Usuarios.guardarPos1+2)=='1'){
                     
                     Revistas();
                 }else if(Usuarios.cadenaArea.charAt(Usuarios.guardarPos1+2)=='2'){
                     Tesis();
                     
                 }else if(Usuarios.cadenaArea.charAt(Usuarios.guardarPos1+2)=='f'){
                     System.out.println("");
                 }
          //cierre if char'0'
           
     }
     }
    
}
