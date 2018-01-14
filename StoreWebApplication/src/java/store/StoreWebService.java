/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

import ee.ttu.idu0075._2017.ws.store.AddProductRequest;
import ee.ttu.idu0075._2017.ws.store.AddStoreProductRequest;
import ee.ttu.idu0075._2017.ws.store.AddStoreRequest;
import ee.ttu.idu0075._2017.ws.store.GetProductListRequest;
import ee.ttu.idu0075._2017.ws.store.GetProductListResponse;
import ee.ttu.idu0075._2017.ws.store.GetProductRequest;
import ee.ttu.idu0075._2017.ws.store.GetStoreListRequest;
import ee.ttu.idu0075._2017.ws.store.GetStoreListResponse;
import ee.ttu.idu0075._2017.ws.store.GetStoreProductListRequest;
import ee.ttu.idu0075._2017.ws.store.GetStoreRequest;
import ee.ttu.idu0075._2017.ws.store.Product;
import ee.ttu.idu0075._2017.ws.store.Store;
import ee.ttu.idu0075._2017.ws.store.StoreProductList;
import javax.jws.WebService;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author olegkartasov
 */
@WebService(serviceName = "StoreService", portName = "StorePort", endpointInterface = "ee.ttu.idu0075._2017.ws.store.StorePortType", targetNamespace = "http://www.ttu.ee/idu0075/2017/ws/store", wsdlLocation = "WEB-INF/wsdl/StoreWebService/StoreService.wsdl")
public class StoreWebService {
    
    static int nextProductId = 1;
    static int nextElectronicsStoreId = 1;
    static List<Product> productList = new ArrayList<Product>();
    static List<Store> storeList = new ArrayList<Store>();

    public Product getProduct(GetProductRequest parameter) {
        
        Product product = null;
        if (parameter.getToken().equalsIgnoreCase("salajane")) {
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).getId().equals(parameter.getId())) {
                    product = productList.get(i);
                }
            }
        } 
        return product;
    }

    public Product addProduct(AddProductRequest parameter) {
        
        Product pt = new Product();
        if (parameter.getToken().equalsIgnoreCase("salajane") && parameter.getRequestId().equalsIgnoreCase("add")) {
   
            pt.setName(parameter.getName());
            pt.setSerialNo(parameter.getSerialNo());
            pt.setProducer(parameter.getProducer());
            pt.setCategory(parameter.getCategory());
            pt.setYear(parameter.getYear());
            pt.setPrice(parameter.getPrice());
            pt.setId(BigInteger.valueOf(nextProductId++));
            productList.add(pt);
        } 
        return pt;
    }

    public GetProductListResponse getProductList(GetProductListRequest parameter) {        
        
        GetProductListResponse response = new GetProductListResponse();
        if (parameter.getToken().equalsIgnoreCase("salajane")) {
            if (! parameter.getCategory().equals("?") 
                    && ! parameter.getCategory().equals("")
                    && ! parameter.getCategory().equals(" ")) {
                if (parameter.getCategory().equals("Tablets") 
                    || parameter.getCategory().equals("Acessories") 
                    || parameter.getCategory().equals("Phones")
                    || parameter.getCategory().equals("Computers")
                    || parameter.getCategory().equals("TVs")) {
                    
                    for (Product product : productList) {
                        if (parameter.getCategory() != null ? product.getCategory().equals(parameter.getCategory()) : true) {
                            response.getProduct().add(product);
                        }
                    } 
                } else {
                    throw new UnsupportedOperationException("Incorrect category parameter!");
                }
            } else {
                for (Product product : productList) {
                    response.getProduct().add(product);
                }
            }
        }
        return response;
    }

    public Store getStore(GetStoreRequest parameter) {
        
        Store store = null;
        
        if (parameter.getToken().equalsIgnoreCase("salajane")) {
            for (int i = 0; i < storeList.size(); i++) {
                if (storeList.get(i).getId().equals(parameter.getId())) {
                    store = storeList.get(i);
                }
            }
        }
        return store;
    }

    public Store addStore(AddStoreRequest parameter) {
        
        Store store = new Store();
        if (parameter.getToken().equalsIgnoreCase("salajane") && parameter.getRequestId().equalsIgnoreCase("add")) {
            
            
            store.setId(BigInteger.valueOf(nextElectronicsStoreId++));
            store.setStoreName(parameter.getStoreName());
            store.setCity(parameter.getCity());
            store.setAddress(parameter.getAddress());
            store.setStoreProductList(new StoreProductList());
            storeList.add(store);
        } 
        return store;
    }

    public GetStoreListResponse getStoreList(GetStoreListRequest parameter) {
        
        GetStoreListResponse response = new GetStoreListResponse();
        
        if (parameter.getToken().equalsIgnoreCase("salajane")) {
            if (! parameter.getHasRelatedProducts().equals("?") 
                    && ! parameter.getHasRelatedProducts().equals("")
                    && ! parameter.getHasRelatedProducts().equals(" ")) {
                storeList.forEach((electronicsStoreType) -> {
                    if (parameter.getHasRelatedProducts().equalsIgnoreCase("jah")) {
                        if (!storeEmpty(electronicsStoreType)) {
                            response.getStore().add(electronicsStoreType);
                        } 
                    } else if (parameter.getHasRelatedProducts().equalsIgnoreCase("ei")) {
                        if (storeEmpty(electronicsStoreType)) {
                            response.getStore().add(electronicsStoreType);
                        }
                    }
                });
            } else {
                for (Store electronicsStoreType : storeList) {
                    response.getStore().add(electronicsStoreType);
                }
            }
        } 
        return response;
    }
    
    private boolean storeEmpty(Store store) {
        return store.getStoreProductList().getProduct().isEmpty();
    }

    public StoreProductList getStoreProductList(GetStoreProductListRequest parameter) {
        
        StoreProductList storeProductList = null;
        
        if (parameter.getToken().equalsIgnoreCase("salajane")) {
            for (int i = 0; i < storeList.size(); i++) {
                if (storeList.get(i).getId().equals(parameter.getStoreId())) {
                    storeProductList = storeList.get(i).getStoreProductList();
                }
            }
        } 
        return storeProductList;
    }

    public Product addStoreProduct(AddStoreProductRequest parameter) {
        
        Product product = new Product();
        
        if (parameter.getToken().equalsIgnoreCase("salajane") && parameter.getRequestId().equalsIgnoreCase("add")) {
            GetProductRequest productRequest = new GetProductRequest();
            productRequest.setId(parameter.getProductId());
            productRequest.setToken(parameter.getToken());
            
            product = getProduct(productRequest);
            
            for (int i = 0; i < storeList.size(); i++) {
                if (storeList.get(i).getId().equals(parameter.getStoreId())) {
                    storeList.get(i).getStoreProductList().getProduct().add(product);
                    return product;
                }
            }
        }    
        return null;
    }
    
}
