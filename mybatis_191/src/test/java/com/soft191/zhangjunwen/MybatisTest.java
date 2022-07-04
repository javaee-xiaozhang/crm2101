package com.soft191.zhangjunwen;

import com.soft191.zhangjunwen.domain.SysUser;
import com.soft191.zhangjunwen.mapper.SysUserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    @Test
    public void test3() throws IOException {
        //加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapperConfig.xml");
        //获得sqlSession工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //创建sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //一对多查询
        SysUserMapper mapper = sqlSession.getMapper(SysUserMapper.class);
        List<SysUser> userAndRole = mapper.findUserAndRole();
        for (SysUser sysUser : userAndRole) {
            System.out.println(sysUser);
        }
    }
}
