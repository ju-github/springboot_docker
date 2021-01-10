package io.renren;

import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class renrenfastApplicationTest {

    @Autowired
    private SysUserService sysUserService;
    @Test
    public  void testData(){
        QueryChainWrapper<SysUserEntity> query = sysUserService.query();
        System.out.println(query);
    }
}
