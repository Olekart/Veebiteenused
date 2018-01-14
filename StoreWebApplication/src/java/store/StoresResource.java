/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

import ee.ttu.idu0075._2017.ws.store.AddStoreProductRequest;
import ee.ttu.idu0075._2017.ws.store.AddStoreRequest;
import ee.ttu.idu0075._2017.ws.store.GetStoreListRequest;
import ee.ttu.idu0075._2017.ws.store.GetStoreListResponse;
import ee.ttu.idu0075._2017.ws.store.GetStoreProductListRequest;
import ee.ttu.idu0075._2017.ws.store.GetStoreRequest;
import ee.ttu.idu0075._2017.ws.store.Product;
import ee.ttu.idu0075._2017.ws.store.Store;
import ee.ttu.idu0075._2017.ws.store.StoreProductList;
import java.math.BigInteger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author olegkartasov
 */
@Path("stores")
public class StoresResource {
    
    @Context
    private UriInfo context;
    
    public StoresResource() {
        
    }

    @GET
    @Produces("application/json")
    public GetStoreListResponse getStoretList(@QueryParam("token") String token,
            @QueryParam("has_products") String hasRelatedProducts) {
        StoreWebService ws = new StoreWebService();
        GetStoreListRequest request = new GetStoreListRequest();
        request.setToken(token);
        request.setHasRelatedProducts(hasRelatedProducts);
        return ws.getStoreList(request);
    }

    @GET
    @Path("{id : \\d+}") //supports digits only
    @Produces("application/json")
    public Store getStore(@PathParam("id") String id,
                                @QueryParam("token") String token) {
        StoreWebService ws = new StoreWebService();
        GetStoreRequest request = new GetStoreRequest();
        request.setId(BigInteger.valueOf(Integer.parseInt(id)));
        request.setToken(token);
        return ws.getStore(request);
    }
    
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Store addStore(Store content,
                                @QueryParam("token") String token,
                                @QueryParam("request_id") String requestId) {
        StoreWebService ws = new StoreWebService();
        AddStoreRequest request = new AddStoreRequest();
        request.setToken(token);
        request.setStoreName(content.getStoreName());
        request.setCity(content.getCity());
        request.setAddress(content.getAddress());
        request.setRequestId(requestId);
        return ws.addStore(request);
    }
    
    @GET
    @Path("{id : \\d+}/products") //supports digits only
    @Produces("application/json")
    public StoreProductList getStoreProductList(@PathParam("id") String id,
                                @QueryParam("token") String token) {
        StoreWebService ws = new StoreWebService();
        GetStoreProductListRequest request = new GetStoreProductListRequest();
        request.setStoreId(BigInteger.valueOf(Integer.parseInt(id)));
        request.setToken(token);
        return ws.getStoreProductList(request);
    }  
    
    @POST
    @Path("{id : \\d+}/products")
    @Consumes("application/json")
    @Produces("application/json")
    public Product addStoreProduct(AddStoreProductRequest content,
            @QueryParam("token") String token,
                                @PathParam("id") String id,
                                @QueryParam("request_id") String requestId) {
        StoreWebService ws = new StoreWebService();
        AddStoreProductRequest request = new AddStoreProductRequest();
        request.setToken(token);
        request.setStoreId(BigInteger.valueOf(Integer.parseInt(id)));
        request.setProductId(content.getProductId());
        request.setRequestId(requestId);
        
        return ws.addStoreProduct(request);
    }
}
