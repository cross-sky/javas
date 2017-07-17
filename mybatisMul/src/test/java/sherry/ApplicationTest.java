package sherry; 

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sherry.data.dto.CategoryDto;
import sherry.data.mapper.CategoryDaoMapper;
import sherry.data.mapper.ProductDaoMapper;
import sherry.data.pojo.CategoryDao;
import sherry.data.pojo.CategoryDaoExample;
import sherry.data.pojo.ProductDao;
import sherry.data.pojo.ProductDaoExample;

import javax.annotation.Resource;
import java.util.List;

/**
 * Application Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>07/17/2017</pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {

    @Resource
    CategoryDaoMapper categoryDaoMapper;

    @Resource
    ProductDaoMapper productDaoMapper;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: main(String[] args)
     */
    @Test
    public void testSelectById() throws Exception {
        CategoryDao categoryDao = categoryDaoMapper.selectByPrimaryKey(1);
        System.out.println("lala");
        System.out.println(categoryDao.getName());
        System.out.println(categoryDao.getId());
    }

    @Test
    public void test_count() {
        CategoryDaoExample example = new CategoryDaoExample();
        long result = categoryDaoMapper.countByExample(example);
        System.out.println("count" + result);
    }

    @Test
    @Rollback(true)
    public void test_insert() {
        CategoryDao categoryDao = new CategoryDao();
        categoryDao.setName("sherry");
        categoryDaoMapper.insert(categoryDao);
        System.out.println("after" + categoryDaoMapper.countByExample(new CategoryDaoExample()));
    }

    @Test
    @Rollback(true)
    public void test_delete() {
        CategoryDaoExample example = new CategoryDaoExample();
        example.createCriteria().andNameEqualTo("sherry");
        int result = categoryDaoMapper.deleteByExample(example);
        System.out.println("delete" + result);
    }

    @Test
    public void test_getById() {
        int id=2;
        CategoryDto dto = categoryDaoMapper.getById(id);
        if (dto == null) {
            System.out.println("not exit");
        } else {
            System.out.println("category id = " + dto.getId() + " name=" + dto.getCategoryDao().getName());
            System.out.println("products: " + dto.getProductDaos().size());
            for (ProductDao productDao : dto.getProductDaos()) {
                System.out.println("     |_" + productDao.getName());
            }
        }
    }

    @Test
    public void test_example() {
        //selectByPrimaryKey
        ProductDao productDao = productDaoMapper.selectByPrimaryKey(2);
        System.out.println("test_example");
        System.out.println("  " + productDao.getName());

        ProductDaoExample example = new ProductDaoExample();
        ProductDaoExample.Criteria pCriteria = example.createCriteria();
        pCriteria.andCategoryIdEqualTo(2);
        example.setOrderByClause("name asc");
        List<ProductDao> pList = productDaoMapper.selectByExample(example);
        System.out.println("product count:" + pList.size());
        for (ProductDao productDao1 : pList) {
            System.out.println("  |_" + productDao1.getName());
        }

    }


} 
