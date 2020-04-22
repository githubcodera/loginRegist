package com.code.dao.impl;

import com.code.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author shhy
 * @create 2020-04-21 8:46
 **/
public abstract class BaseDao {
    private QueryRunner queryRunner = new QueryRunner();

    public int update(String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.update(connection, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            JdbcUtils.close(connection);
        }
        //返回-1表示执行失败，返回其他表示影响的行数
        return -1;
    }

    public <T> T queryForOne(Class<T> type, String sql, Object... args) {
        Connection con = JdbcUtils.getConnection();
        try {
          return queryRunner.query(con, sql, new BeanHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JdbcUtils.close(con);
        }
        return null;
    }

    public <T> List<T> queryForList(Class<T> type, String sql, Object... args){
        Connection con = JdbcUtils.getConnection();
        try {
            return queryRunner.query(con, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JdbcUtils.close(con);
        }
        return null;
    }

    public Object queryForSingleValue( String sql, Object... args){
        Connection con = JdbcUtils.getConnection();
        try {
            return queryRunner.query(con, sql, new ScalarHandler(), args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JdbcUtils.close(con);
        }
        return null;
    }
}
