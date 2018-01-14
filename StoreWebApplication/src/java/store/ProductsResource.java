/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

import ee.ttu.idu0075._2017.ws.store.AddProductRequest;
import ee.ttu.idu0075._2017.ws.store.GetProductListRequest;
import ee.ttu.idu0075._2017.ws.store.GetProductListResponse;
import ee.ttu.idu0075._2017.ws.store.GetProductRequest;
import ee.ttu.idu0075._2017.ws.store.Product;
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
@Path("products")
public class ProductsResource {
    
    @Context
    private UriInfo context;
    
    public ProductsResource() {
        
    }

    @GET
    @Produces("application/json")
    public GetProductListResponse getProductList(@QueryParam("token") String token, 
            @QueryParam("category") String category) {
        StoreWebService ws = new StoreWebService();
        GetProductListRequest request = new GetProductListRequest();
        request.setToken(token);
        request.setCategory(category);
        return ws.getProductList(request);
    }

    @GET
    @Path("{id : \\d+}") //supports digits only
    @Produces("application/json")
    public Product getProduct(@PathParam("id") String id,
                                @QueryParam("token") String token) {
        StoreWebService ws = new StoreWebService();
        GetProductRequest request = new GetProductRequest();
        request.setId(BigInteger.valueOf(Integer.parseInt(id)));
        request.setToken(token);
        return ws.getProduct(request);
    }
    
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Product addProduct(Product content,
                                @QueryParam("token") String token,
                                @QueryParam("request_id") String requestId) {
        StoreWebService ws = new StoreWebService();
        AddProductRequest request = new AddProductRequest();
        request.setToken(token);
        request.setRequestId(requestId);
        request.setName(content.getName());
        request.setSerialNo(content.getSerialNo());
        request.setProducer(content.getProducer());
        request.setCategory(content.getCategory());
        request.setYear(content.getYear());
        request.setPrice(content.getPrice());
        return ws.addProduct(request);
    }
}
