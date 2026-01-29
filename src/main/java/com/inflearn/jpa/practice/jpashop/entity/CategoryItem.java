package com.inflearn.jpa.practice.jpashop.entity;

import com.inflearn.jpa.practice.jpashop.entity.item.Item;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class CategoryItem extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_item_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    // == 연관관계 매핑 ==
    public void setCategory(Category category) {
        if (this.category != null) {
            this.category.getCategoryItems().remove(this);
        }

        this.category = category;
    }

    public void setItem(Item item) {
        if (this.item != null) {
            this.item.getCategoryItems().remove(this);
        }

        this.item = item;
    }

}
