
package testconnrapidservice;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;


public class TestConnRapidService {
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
        
        
        //DataSource ds1 = DataSource.getInstance();
       // System.out.println(ds1);
//        reclamationService recservice = new reclamationService();
//        Reclamation rec1 = new Reclamation(1,"XX","YY","XXYY@gmail.com",22222222,"Jardinage","15-03-2022","ZZ","Mal fait");
//       // System.out.println(rec1);
//       // Reclamation rec2 = new Reclamation(2,"XX","YY","XXYY@gmail.com",22222222,"Jardinage","15-03-2022","ZZ","Mal fait");
//        //Reclamation rec3 = new Reclamation(3,"XX","YY","XXYY@gmail.com",22222222,"Jardinage","15-03-2022","ZZ","Mal fait");
//        
//        //recservice.saveReclamation(rec1);
//        //recservice.saveReclamation(rec2);
//        //recservice.saveReclamation(rec3);
////        boolean resSupp =recservice.deleteReclamation(2);
////        System.out.println(resSupp);
////        Reclamation rec3 = new Reclamation("XX","YY","XXYY@gmail.com",22222222,"Jardinage","15-03-2022","ZZ","Mal fait");
////        recservice.saveReclamation(rec3);
////        Reclamation rec4 = new Reclamation("XX","YY","XXYY@gmail.com",22222222,"Jardinage","15-03-2022","ZZ","Mal fait");
////        recservice.saveReclamation(rec4);
//          Reclamation rec5=recservice.getReclamation(3);
//        //  System.out.println(rec5);
//        
//          ArrayList<Reclamation> listReclamations =recservice.getAllReclamation();
//          
//          System.out.println(listReclamations.get(0));
//           System.out.println(listReclamations.get(1));
//            System.out.println(listReclamations.get(2));





////          
//             Reclamation R1 = new Reclamation("Ines","YY","XXYY@gmail.com",22222222,"Jardinage","15-03-2022","ZZ","Mal fait");
//            recservice.saveReclamation(R1);
//             Reclamation R2 = new Reclamation("Marwa","YY","XXYY@gmail.com",22222222,"Jardinage","15-03-2022","ZZ","Mal fait");
//              recservice.saveReclamation(R2);
//               Reclamation R3 = new Reclamation("Khaled","YY","XXYY@gmail.com",22222222,"Jardinage","15-03-2022","ZZ","Mal fait");
//            recservice.saveReclamation(R3);
//            
//            Reclamation R4 = new Reclamation("Ghassen","YY","XXYY@gmail.com",22222222,"Jardinage","15-03-2022","ZZ","Mal fait");
//            recservice.saveReclamation(R4);
//            
//            Reclamation R5 = new Reclamation("Jihen","YY","XXYY@gmail.com",22222222,"Jardinage","15-03-2022","ZZ","Mal fait");
//            recservice.saveReclamation(R5);
            
            
//            System.out.println(recservice.updateReclamation(new Reclamation(3,"Mourad","YY","XXYY@gmail.com",22222222,"Jardinage","15-03-2022","ZZ","Mal fait")));
//            
//            
//            ArrayList listReclamationsId= recservice.getReclamationIds();
//            
//            for(int i = 0; i< listReclamationsId.size(); i++) {
//    		
//    			System.out.println(listReclamationsId.get(i));
//    	}
//             
//             System.out.println(listReclamationsId.get(1));
//             System.out.println(listReclamationsId.get(2));
//             
//             System.out.println("Fin test des id de reclamations");
//             //Test pours les nom d
//             
//             ArrayList listPrestataireNames= recservice.getPrestataireNames();
//            
//            for(int i = 0; i< listPrestataireNames.size(); i++) {
//    		
//    			System.out.println(listPrestataireNames.get(i));
//    	}
//          
        reclamationService recservice = new reclamationService();  
//        boolean resAllDel =recservice.deleteALLReclamation();  


       
//             Reclamation R1 = new Reclamation("Ines","YY","XXYY@gmail.com",22222222,"Jardinage","15-03-2022","ZZ","Mal fait");
//            recservice.saveReclamation(R1);
//             Reclamation R2 = new Reclamation("Marwa","YY","XXYY@gmail.com",22222222,"Jardinage","15-03-2022","ZZ","Mal fait");
//              recservice.saveReclamation(R2);
//               Reclamation R3 = new Reclamation("Khaled","YY","XXYY@gmail.com",22222222,"Jardinage","15-03-2022","ZZ","Mal fait");
//            recservice.saveReclamation(R3);
//            
//            Reclamation R4 = new Reclamation("Ghassen","YY","XXYY@gmail.com",22222222,"Jardinage","15-03-2022","ZZ","Mal fait");
//            recservice.saveReclamation(R4);
//            
//            Reclamation R5 = new Reclamation("Jihen","YY","XXYY@gmail.com",22222222,"Jardinage","15-03-2022","ZZ","Mal fait");
//            recservice.saveReclamation(R5);

//            System.out.println(recservice.updateReclamation(new Reclamation(21,"Mourad","YY","XXYY@gmail.com",22222222,"Jardinage","15-03-2022","ZZ","Mal fait")));
//            
//          ArrayList<Reclamation> listReclamations =recservice.getAllReclamation();    
//            for(int i = 0; i< listReclamations.size(); i++) {
//    		
//    			System.out.println(listReclamations.get(i));
//    	}                                                                                                                                                                                                                                                                                                             }     

//   recservice.deleteReclamation(21);          
           // recservice.saveReclamation(new Reclamation("aouadi","ghassen","ghassenàesprit.tn",98712340,"dhina","14-05-2022","khaled","mal fait") );
           LocalDate today = LocalDate.now();
//
//System.out.println(today.toString());
//    
//    System.out.println(today.getYear());
//    System.out.println(today.getMonthValue());
//    System.out.println(today.getDayOfMonth());
//    String adate="ajourdh'huit c'est :"+today.getYear()+"/"+today.getMonthValue()+"/"+today.getDayOfMonth();
//    System.out.println(adate);
//    //recservice.saveReclamation(new Reclamation("aouadi","ghassen","ghassenàesprit.tn",98712340,"dhina",adate,"khaled","mal fait") );
//      ArrayList<String> listid=recservice.getReclamationIds();    
//      
//      for(int i = 0; i< listid.size(); i++) {
//    		
//    			System.out.println(listid.get(i));
//    	} 
//      
//      
//      Reclamation recann = new Reclamation("abidi","Jihen","abidi.jihen@gmail.com",22222222,"Jardinage","15-03-2022","ZZ","Mal fait");
//        
//      recservice.updateReclamation(recann,42);


 ArrayList<Reclamation> listReclamations =recservice.getAllReclamation();    
            for(int i = 0; i< listReclamations.size(); i++) {
    		
    			System.out.println(listReclamations.get(i));
    	}
    }
}