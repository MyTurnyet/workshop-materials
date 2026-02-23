package com.workshop.order;

import java.util.*;

/**
 * LEGACY CODE - Needs refactoring in Challenge 5!
 *
 * This class violates many best practices:
 * - 300+ lines (too long)
 * - Multiple responsibilities
 * - Methods over 50 lines
 * - No separation of concerns
 * - Missing proper validation
 * - Poor naming
 */
public class OrderService {

    private Map<Long, Order> orders = new HashMap<>();
    private long nextOrderId = 1;
    private Map<Long, List<String>> orderHistory = new HashMap<>();
    private int totalOrdersCreated = 0;
    private int totalOrdersCancelled = 0;

    /**
     * Creates a new order.
     * BAD: This method is way too long and does too much!
     */
    public Order createOrder(Long customerId, String customerName, String customerEmail,
                            List<OrderItem> items) throws Exception {
        // Validation (should be separate)
        if (customerId == null || customerId <= 0) {
            System.out.println("ERROR: Invalid customer ID");
            throw new IllegalArgumentException("Customer ID must be positive");
        }

        if (customerName == null || customerName.trim().isEmpty()) {
            System.out.println("ERROR: Customer name is empty");
            throw new IllegalArgumentException("Customer name required");
        }

        if (customerEmail == null || !customerEmail.contains("@")) {
            System.out.println("ERROR: Invalid email");
            throw new IllegalArgumentException("Valid email required");
        }

        if (items == null || items.isEmpty()) {
            System.out.println("ERROR: No items in order");
            throw new IllegalArgumentException("Order must have items");
        }

        // Calculate total (should be separate method)
        double total = 0.0;
        for (OrderItem item : items) {
            if (item.getQuantity() <= 0) {
                throw new IllegalArgumentException("Item quantity must be positive");
            }
            if (item.getPrice() < 0) {
                throw new IllegalArgumentException("Item price cannot be negative");
            }
            total += item.getQuantity() * item.getPrice();
        }

        if (total < 0.01) {
            throw new IllegalArgumentException("Order total must be at least 0.01");
        }

        // Create order
        Order order = new Order();
        order.setOrderId(nextOrderId++);
        order.setCustomerId(customerId);
        order.setCustomerName(customerName);
        order.setCustomerEmail(customerEmail);
        order.setItems(new ArrayList<>(items));
        order.setTotal(total);
        order.setStatus("PENDING");
        order.setCreatedAt(new Date());

        orders.put(order.getOrderId(), order);

        // Add to history
        if (!orderHistory.containsKey(customerId)) {
            orderHistory.put(customerId, new ArrayList<>());
        }
        orderHistory.get(customerId).add("Order " + order.getOrderId() + " created");

        totalOrdersCreated++;

        System.out.println("Order created: " + order.getOrderId());
        System.out.println("Customer: " + customerName);
        System.out.println("Items: " + items.size());
        System.out.println("Total: $" + total);

        return order;
    }

    /**
     * Updates order status.
     * BAD: Method doing too much, poor validation
     */
    public void updateOrderStatus(Long orderId, String newStatus) throws Exception {
        if (orderId == null) {
            throw new IllegalArgumentException("Order ID required");
        }

        Order order = orders.get(orderId);
        if (order == null) {
            throw new IllegalArgumentException("Order not found: " + orderId);
        }

        String oldStatus = order.getStatus();

        // Validate status transition (should be separate)
        if ("CANCELLED".equals(oldStatus)) {
            throw new IllegalStateException("Cannot update cancelled order");
        }

        if ("COMPLETED".equals(oldStatus) && !"REFUNDED".equals(newStatus)) {
            throw new IllegalStateException("Completed orders can only be refunded");
        }

        order.setStatus(newStatus);
        order.setUpdatedAt(new Date());

        // Add to history
        Long customerId = order.getCustomerId();
        orderHistory.get(customerId).add("Order " + orderId + " status: " + oldStatus + " -> " + newStatus);

        if ("CANCELLED".equals(newStatus)) {
            totalOrdersCancelled++;
        }

        System.out.println("Order " + orderId + " status updated to: " + newStatus);
    }

    /**
     * Gets order by ID.
     */
    public Order getOrder(Long orderId) {
        return orders.get(orderId);
    }

    /**
     * Gets all orders for a customer.
     */
    public List<Order> getCustomerOrders(Long customerId) {
        List<Order> customerOrders = new ArrayList<>();
        for (Order order : orders.values()) {
            if (order.getCustomerId().equals(customerId)) {
                customerOrders.add(order);
            }
        }
        return customerOrders;
    }

    /**
     * Calculates customer total spending.
     * BAD: Unclear method name
     */
    public double calc(Long customerId) {
        double total = 0.0;
        for (Order order : orders.values()) {
            if (order.getCustomerId().equals(customerId) &&
                !"CANCELLED".equals(order.getStatus())) {
                total += order.getTotal();
            }
        }
        return total;
    }

    /**
     * Gets order history for customer.
     */
    public List<String> getHistory(Long customerId) {
        return orderHistory.getOrDefault(customerId, new ArrayList<>());
    }

    /**
     * Cancels an order.
     * BAD: Duplicate logic with updateOrderStatus
     */
    public void cancelOrder(Long orderId) throws Exception {
        if (orderId == null) {
            throw new IllegalArgumentException("Order ID required");
        }

        Order order = orders.get(orderId);
        if (order == null) {
            throw new IllegalArgumentException("Order not found: " + orderId);
        }

        if ("CANCELLED".equals(order.getStatus())) {
            throw new IllegalStateException("Order already cancelled");
        }

        if ("COMPLETED".equals(order.getStatus())) {
            throw new IllegalStateException("Cannot cancel completed order");
        }

        order.setStatus("CANCELLED");
        order.setUpdatedAt(new Date());

        Long customerId = order.getCustomerId();
        orderHistory.get(customerId).add("Order " + orderId + " cancelled");

        totalOrdersCancelled++;

        System.out.println("Order " + orderId + " cancelled");
    }

    // Statistics methods
    public int getTotalOrdersCreated() {
        return totalOrdersCreated;
    }

    public int getTotalOrdersCancelled() {
        return totalOrdersCancelled;
    }

    public int getActiveOrdersCount() {
        int count = 0;
        for (Order order : orders.values()) {
            if (!"CANCELLED".equals(order.getStatus()) &&
                !"COMPLETED".equals(order.getStatus())) {
                count++;
            }
        }
        return count;
    }
}

// Supporting classes
class Order {
    private Long orderId;
    private Long customerId;
    private String customerName;
    private String customerEmail;
    private List<OrderItem> items;
    private double total;
    private String status;
    private Date createdAt;
    private Date updatedAt;

    // Getters and setters
    public Long getOrderId() { return orderId; }
    public void setOrderId(Long orderId) { this.orderId = orderId; }
    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public String getCustomerEmail() { return customerEmail; }
    public void setCustomerEmail(String customerEmail) { this.customerEmail = customerEmail; }
    public List<OrderItem> getItems() { return items; }
    public void setItems(List<OrderItem> items) { this.items = items; }
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
    public Date getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }
}

class OrderItem {
    private String productId;
    private String productName;
    private int quantity;
    private double price;

    public OrderItem(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters
    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
}
