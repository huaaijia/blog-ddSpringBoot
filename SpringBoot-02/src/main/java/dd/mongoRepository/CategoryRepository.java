package dd.mongoRepository;

import dd.mongoRepository.entity.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by huaaijia on 2016/10/24.
 */
public interface CategoryRepository extends MongoRepository<Category, Long> {

    Category findByCategoryName(String categoryName);
}
