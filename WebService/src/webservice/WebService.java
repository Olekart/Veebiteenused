/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import ee.ttu.idu0075._2017.ws.store.AddStoreRequest;
import ee.ttu.idu0075._2017.ws.store.GetStoreRequest;
import ee.ttu.idu0075._2017.ws.store.Store;
import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author olegkartasov
 */
public class WebService {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        boolean isDone = true;
        boolean cityChose = true;
        
       String storeName;
       String storeCity;
       String storeAddress;
       String storeId;
        
        while (isDone) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Possible operations:");
            System.out.println(" 1 - addStore operation");
            System.out.println(" 2 - getStore operation");
            System.out.println("Your choice: ");
            String choice = scanner.next();
            
            if(choice.equalsIgnoreCase("1")){
                AddStoreRequest request = new AddStoreRequest();
                Store store = new Store();
                System.out.println("addStore operation selected!");
                request.setToken("salajane");
                request.setRequestId("add");            
                System.out.println("Enter store name: ");
                storeName = scanner.next();
                while (cityChose) {
                    System.out.println("Enter city: ");
                    storeCity = scanner.next();
                    if (storeCity.equals("Tallinn") || 
                        storeCity.equals("Tartu") ||
                        storeCity.equals("Narva") ||
                        storeCity.equals("Rakvere")) {
                        request.setCity(storeCity);
                        break;
                    } else {
                        System.out.println("Wrong city name!");
                        continue;
                    }
                }
    
                System.out.println("Enter location: ");
                storeAddress = scanner.next();
                request.setStoreName(storeName);
                request.setAddress(storeAddress);
                store = addStore(request);
                System.out.println(storeName + " is added!");
                System.out.println("");
                    
                
                
                System.out.println("Back to menu?:(yes/no) ");
                String answer = scanner.next();
                if (answer.equalsIgnoreCase("no")) {
                    break;
                } else {
                    continue;
                }
            }
            if(choice.equalsIgnoreCase("2")){
                Store store = new Store();
                System.out.println("getStore operation selected!");
                GetStoreRequest request = new GetStoreRequest();
                request.setToken("salajane");
                System.out.println("Enter store ID: ");
                storeId = scanner.next();
                request.setId(new BigInteger(storeId));
                store = getStore(request);
                System.out.println(" ");
                System.out.println("Name: " + store.getStoreName());
                System.out.println("City: " + store.getCity());
                System.out.println("Address: " + store.getAddress());
                System.out.println(" ");
                System.out.println("Back to menu?:(yes/no) ");
                String answer = scanner.next();
                if (answer.equalsIgnoreCase("no")) {
                    break;
                } else {
                    continue;
                }
            }
        }
    }
    

    private static Store addStore(ee.ttu.idu0075._2017.ws.store.AddStoreRequest parameter) {
        ee.ttu.idu0075._2017.ws.store.StoreService service = new ee.ttu.idu0075._2017.ws.store.StoreService();
        ee.ttu.idu0075._2017.ws.store.StorePortType port = service.getStorePort();
        return port.addStore(parameter);
    }

    private static Store getStore(ee.ttu.idu0075._2017.ws.store.GetStoreRequest parameter) {
        ee.ttu.idu0075._2017.ws.store.StoreService service = new ee.ttu.idu0075._2017.ws.store.StoreService();
        ee.ttu.idu0075._2017.ws.store.StorePortType port = service.getStorePort();
        return port.getStore(parameter);
    }
    
}
