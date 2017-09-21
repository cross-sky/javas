package sherry.happ.service; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sherry.Application;
import sherry.datapoint.mapper.DataPointMapper;
import sherry.datapoint.pojo.DataPoint;
import sherry.datapoint.pojo.DataPointExample;
import sherry.entity.PageTb;

import javax.annotation.Resource;
import java.util.List;

/**
 * DatapointRepositoryImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>07/19/2017</pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class DatapointRepositoryImplTest {

    @Autowired
    private DataPointMapper mapper;

    @Autowired
    private DatapointRepository datapointRepository;
    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: selectById(Long id, PageTb pageTb)
     */
    @Test
    public void testSelectById() throws Exception {
        Long count = mapper.countByExample(new DataPointExample());
        System.out.println("counts" + count);

        DataPoint dataP = mapper.selectByPrimaryKey(1);
        System.out.println(dataP);

//        DataPointExample example = new DataPointExample();
//        DataPointExample.Criteria criteria = example.createCriteria();
//        criteria.andDeviceIdEqualTo(1);
//        example.setLimit(4);
//        example.setOffset(0);
//        List<DataPoint> dataPoints = mapper.selectByExample(example);
//
//
//        System.out.println(" count=" + dataPoints.size());
//        for (DataPoint dataPoint : dataPoints) {
//            System.out.println("  |_" + dataPoint);
//        }

        PageTb pageTb = new PageTb();
        pageTb.setLimit(4);
        pageTb.setOffset(0);
        pageTb.setDid(1L);
        List<DataPoint> dataPoints1 = datapointRepository.selectById(1L, pageTb);
        System.out.println(" count=" + dataPoints1.size());
        for (DataPoint dataPoint : dataPoints1) {
            System.out.println("  |_" + dataPoint);
        }
    }

    /**
     * Method: saveData(DataPoint dataPoint)
     */
    @Test
    @Rollback(value = true)
    public void testSaveData() throws Exception {
        DataPoint dataPoint = new DataPoint();
        dataPoint.setDeviceId(1);
        dataPoint.setWaterInT(12.3f);
        dataPoint.setWaterOutT(22.3f);
        System.out.println("save" + this.datapointRepository.saveData(dataPoint));
    }

} 
