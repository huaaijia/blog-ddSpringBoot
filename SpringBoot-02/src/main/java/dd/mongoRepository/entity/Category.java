package dd.mongoRepository.entity;

import javax.persistence.Id;

/**
 * Created by huaaijia on 2016/10/24.
 */
public class Category {
    @Id
    private Long id;

    private String categoryName;

    private int categoryIndex;

    public Category(Long id, String categoryName, int categoryIndex) {
        this.id = id;
        this.categoryName = categoryName;
        this.categoryIndex = categoryIndex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryIndex() {
        return categoryIndex;
    }

    public void setCategoryIndex(int categoryIndex) {
        this.categoryIndex = categoryIndex;
    }
}
