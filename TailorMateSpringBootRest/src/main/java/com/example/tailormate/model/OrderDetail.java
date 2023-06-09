package com.example.tailormate.model;

import jakarta.persistence.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "order_details")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_detail_id")
    private int orderDetailId;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "product_type_id")
    private ProductType productType;

    @Column(name = "design_details_text")
    private String designDetailsText;


    @Column(name = "sample_img")
    private String sampleImg;

    @Column(name = "garment_type_id")
    private int garmentTypeId;

    @Column(name = "color_id")
    private int colorId;

    @Column(name = "size_id")
    private int sizeId;

    @Column(name = "instructions_text")
    private String instructionsText;

    public int getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(int orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrderId(Order order) {
        this.order = order;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productTypeId) {
        this.productType = productTypeId;
    }

    public String getDesignDetailsText() {
        return designDetailsText;
    }

    public void setDesignDetailsText(String designDetailsText) {
        this.designDetailsText = designDetailsText;
    }

    public String getSampleImg() {
        return sampleImg;
    }

    public void setSampleImg(String sampleImg) {
        this.sampleImg = sampleImg;
    }

    public int getGarmentTypeId() {
        return garmentTypeId;
    }

    public void setGarmentTypeId(int garmentTypeId) {
        this.garmentTypeId = garmentTypeId;
    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    public String getInstructionsText() {
        return instructionsText;
    }

    public void setInstructionsText(String instructionsText) {
        this.instructionsText = instructionsText;
    }
}

