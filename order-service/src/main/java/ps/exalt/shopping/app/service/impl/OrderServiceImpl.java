////////////////////////////////////////////////
//          author: Nour
//          filename: InventoryServiceImpl.java
//          2023
////////////////////////////////////////////////
package ps.exalt.shopping.app.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.util.UriComponentsBuilder;
import ps.exalt.shopping.app.common.error.exception.OperationFailedException;
import ps.exalt.shopping.app.common.service.impl.MongoBaseServiceImpl;
import ps.exalt.shopping.app.dto.OrderLineItemsRequest;
import ps.exalt.shopping.app.dto.OrderLineItemsResponse;
import ps.exalt.shopping.app.dto.OrderRequest;
import ps.exalt.shopping.app.dto.OrderResponse;
import ps.exalt.shopping.app.model.Order;
import ps.exalt.shopping.app.model.OrderLineItems;
import ps.exalt.shopping.app.repository.OrderRepository;
import ps.exalt.shopping.app.service.OrderService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl extends MongoBaseServiceImpl<OrderRequest,
        Order, OrderResponse, String> implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order requestToModel(OrderRequest request) {

        Order order = new Order();
        order.setOrderLineItemsList(requestToModel(request.getOrderLineItemsRequestList()));
        return order;
    }

    public OrderResponse modelToResponse(Order order) {

        OrderResponse response = new OrderResponse();
        response.setId(order.getId());
        response.setOrderLineItemsResponseList(modelToResponse(order.getOrderLineItemsList()));
        return response;
    }

    public OrderLineItems requestToModel(OrderLineItemsRequest orderLineItemsRequest) {

        OrderLineItems order = new OrderLineItems();
        order.setId(UUID.randomUUID().toString());
        order.setQuantity(orderLineItemsRequest.getQuantity());
        order.setSkuCode(orderLineItemsRequest.getSkuCode());
        return order;
    }

    public List<OrderLineItems> requestToModel(List<OrderLineItemsRequest> requestList) {
        return requestList.stream().map(this::requestToModel).collect(Collectors.toList());
    }

    public OrderLineItemsResponse modelToResponse(OrderLineItems orderLineItems) {
        OrderLineItemsResponse response = new OrderLineItemsResponse();
        response.setId(orderLineItems.getId());
        response.setSkuCode(orderLineItems.getSkuCode());
        response.setQuantity(orderLineItems.getQuantity());
        return response;
    }

    public List<OrderLineItemsResponse> modelToResponse(List<OrderLineItems> mList) {
        return mList.stream().map(this::modelToResponse).collect(Collectors.toList());
    }

    @Override
    public MongoRepository<Order, String> getMongoRepository() {
        return orderRepository;
    }

    @Override
    @SneakyThrows
    public OrderResponse create(OrderRequest orderRequest) {

        OrderRequest orderRequest1 = new OrderRequest();
        List<OrderLineItemsRequest> lineItems= new ArrayList<>();
        List<String> skuCodes = orderRequest.getOrderLineItemsRequestList()
                .stream()
                .map(OrderLineItemsRequest::getSkuCode)
                .collect(Collectors.toList());

        try {
            WebClient client = WebClient.create();
            UriComponentsBuilder uri = UriComponentsBuilder.newInstance();
            uri.scheme("http").host("localhost").port("8080").path("/api/v1" +
                    ".0/inventory").queryParam("skuCode", skuCodes).build();
            JsonNode responseBody =
                    client.get().uri(uri.toUriString()).retrieve()
                            .bodyToMono(JsonNode.class).block();


            int counter = 0;
            for (JsonNode item : responseBody) {

                ObjectMapper objectMapper = new ObjectMapper();
                Integer quantity =
                        objectMapper.readTree(item.toString()).
                                findValue("quantity").asInt();
                String skuCode =
                        objectMapper.readTree(item.toString()).
                                findValue("skuCode").asText();

                if (quantity >= orderRequest.getOrderLineItemsRequestList().get(counter).getQuantity()) {

                    try {

                        WebClient client2 = WebClient.create();
                        UriComponentsBuilder uri2 =
                                UriComponentsBuilder.newInstance();
                        uri2.scheme("http").host("localhost").port("8080").path("/api/v1" +
                                ".0/inventory").queryParam("skuCode",
                                skuCode).queryParam("quantity",
                                orderRequest.getOrderLineItemsRequestList().get(counter).getQuantity()).build();
                        client2.put().uri(uri2.toUriString()).retrieve()
                                .bodyToMono(JsonNode.class).block();

                        OrderLineItemsRequest orderLineItemsRequest =
                                new OrderLineItemsRequest(orderRequest.getOrderLineItemsRequestList().get(counter).getSkuCode(),
                                        orderRequest.getOrderLineItemsRequestList().get(counter).getQuantity());

                        lineItems.add(orderLineItemsRequest);

                        orderRequest1.setOrderLineItemsRequestList(lineItems);

                        counter++;

                    } catch (WebClientResponseException ex) {

                        throw OperationFailedException.createOperationFailedException(getResourceBundle(),
                                "COMMON_00003");
                    }
                } else {
                    counter++;
                }

            }
        } catch (WebClientResponseException ex) {

            throw OperationFailedException.createOperationFailedException(getResourceBundle(),
                    "COMMON_00003");

        }
        if (orderRequest1.getOrderLineItemsRequestList() != null) {
            return super.create(orderRequest1);
        }
        return null;
    }


    public boolean existByIdAndQuantity(String id, Integer quantity) {

        if (orderRepository.existsById(id) && quantity >= 1) {

            return true;

        }
        return false;
    }

}
