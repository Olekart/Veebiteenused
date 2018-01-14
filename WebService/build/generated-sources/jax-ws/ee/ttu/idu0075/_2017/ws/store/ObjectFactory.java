
package ee.ttu.idu0075._2017.ws.store;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ee.ttu.idu0075._2017.ws.store package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddStoreResponse_QNAME = new QName("http://www.ttu.ee/idu0075/2017/ws/store", "addStoreResponse");
    private final static QName _GetStoreResponse_QNAME = new QName("http://www.ttu.ee/idu0075/2017/ws/store", "getStoreResponse");
    private final static QName _GetProductResponse_QNAME = new QName("http://www.ttu.ee/idu0075/2017/ws/store", "getProductResponse");
    private final static QName _AddStoreProductResponse_QNAME = new QName("http://www.ttu.ee/idu0075/2017/ws/store", "addStoreProductResponse");
    private final static QName _AddProductResponse_QNAME = new QName("http://www.ttu.ee/idu0075/2017/ws/store", "addProductResponse");
    private final static QName _GetStoreProductListResponse_QNAME = new QName("http://www.ttu.ee/idu0075/2017/ws/store", "getStoreProductListResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ee.ttu.idu0075._2017.ws.store
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Product }
     * 
     */
    public Product createProduct() {
        return new Product();
    }

    /**
     * Create an instance of {@link GetProductListResponse }
     * 
     */
    public GetProductListResponse createGetProductListResponse() {
        return new GetProductListResponse();
    }

    /**
     * Create an instance of {@link AddStoreProductRequest }
     * 
     */
    public AddStoreProductRequest createAddStoreProductRequest() {
        return new AddStoreProductRequest();
    }

    /**
     * Create an instance of {@link Store }
     * 
     */
    public Store createStore() {
        return new Store();
    }

    /**
     * Create an instance of {@link AddProductRequest }
     * 
     */
    public AddProductRequest createAddProductRequest() {
        return new AddProductRequest();
    }

    /**
     * Create an instance of {@link StoreProductList }
     * 
     */
    public StoreProductList createStoreProductList() {
        return new StoreProductList();
    }

    /**
     * Create an instance of {@link GetStoreProductListRequest }
     * 
     */
    public GetStoreProductListRequest createGetStoreProductListRequest() {
        return new GetStoreProductListRequest();
    }

    /**
     * Create an instance of {@link GetStoreListRequest }
     * 
     */
    public GetStoreListRequest createGetStoreListRequest() {
        return new GetStoreListRequest();
    }

    /**
     * Create an instance of {@link AddStoreRequest }
     * 
     */
    public AddStoreRequest createAddStoreRequest() {
        return new AddStoreRequest();
    }

    /**
     * Create an instance of {@link GetStoreRequest }
     * 
     */
    public GetStoreRequest createGetStoreRequest() {
        return new GetStoreRequest();
    }

    /**
     * Create an instance of {@link GetStoreListResponse }
     * 
     */
    public GetStoreListResponse createGetStoreListResponse() {
        return new GetStoreListResponse();
    }

    /**
     * Create an instance of {@link GetProductRequest }
     * 
     */
    public GetProductRequest createGetProductRequest() {
        return new GetProductRequest();
    }

    /**
     * Create an instance of {@link GetProductListRequest }
     * 
     */
    public GetProductListRequest createGetProductListRequest() {
        return new GetProductListRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Store }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ttu.ee/idu0075/2017/ws/store", name = "addStoreResponse")
    public JAXBElement<Store> createAddStoreResponse(Store value) {
        return new JAXBElement<Store>(_AddStoreResponse_QNAME, Store.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Store }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ttu.ee/idu0075/2017/ws/store", name = "getStoreResponse")
    public JAXBElement<Store> createGetStoreResponse(Store value) {
        return new JAXBElement<Store>(_GetStoreResponse_QNAME, Store.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Product }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ttu.ee/idu0075/2017/ws/store", name = "getProductResponse")
    public JAXBElement<Product> createGetProductResponse(Product value) {
        return new JAXBElement<Product>(_GetProductResponse_QNAME, Product.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Product }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ttu.ee/idu0075/2017/ws/store", name = "addStoreProductResponse")
    public JAXBElement<Product> createAddStoreProductResponse(Product value) {
        return new JAXBElement<Product>(_AddStoreProductResponse_QNAME, Product.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Product }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ttu.ee/idu0075/2017/ws/store", name = "addProductResponse")
    public JAXBElement<Product> createAddProductResponse(Product value) {
        return new JAXBElement<Product>(_AddProductResponse_QNAME, Product.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StoreProductList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ttu.ee/idu0075/2017/ws/store", name = "getStoreProductListResponse")
    public JAXBElement<StoreProductList> createGetStoreProductListResponse(StoreProductList value) {
        return new JAXBElement<StoreProductList>(_GetStoreProductListResponse_QNAME, StoreProductList.class, null, value);
    }

}
