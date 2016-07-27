package name.az170.resmgr.dao.impl.h2;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import name.az170.resmgr.core.domain.Resource;
import name.az170.resmgr.dao.ResourceDao;

@Repository
public class ResourceDaoH2Impl implements ResourceDao {
    
    public static final String RESOURCES = "resources";
    public static final String RESOURCES_NAME = "name";
    
    @Autowired
    private JdbcTemplate jt;
    
    private String createSql;
    private String deleteSql;
    private String updateSql;
    private String selectSql;
    private String queryByIdSql;
    private ResourceRowMapper resourceRowMapper;

    @Override
    public int create(final Resource resource) {
        String sql = getCreateSql();
        int result = jt.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                int i = 0;
                ps.setString(i++, resource.getId());
                ps.setString(i++, resource.getName());
                ps.setDate(i++, new Date(resource.getCreateTime().getTime()));
                ps.setDate(i++, new Date(resource.getUpdateTime().getTime()));
                ps.setString(i++, resource.getComment());
            }
        });
        return result;
    }

    @Override
    public int delete(final String id) {
        String sql = getDeleteSql();
        int result = jt.update(sql, id);
        return result;
    }

    @Override
    public int update(final Resource resource) {
        String sql = getUpdateSql();
        int result = jt.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                int i = 0;
                ps.setString(i++, resource.getName());
                ps.setDate(i++, new Date(resource.getCreateTime().getTime()));
                ps.setDate(i++, new Date(resource.getUpdateTime().getTime()));
                ps.setString(i++, resource.getComment());
                ps.setString(i++, resource.getId());
            }
        });
        return result;
    }

    @Override
    public Resource read(final String id) {
        String sql = getQueryByIdSql();
        List<Resource> list = jt.query(sql, new Object[] {id}, getResourceRowMapper());
        Resource result = null;
        if (list.size() > 0) {
            result = list.get(0);
        }
        return result;
    }
    
    private String getCreateSql() {
        if (createSql == null) {
            createSql = MessageFormat.format("INSERT INTO {0} ({1}, {2}, {3}, {4}, {5}) WHERE VALUES (?, ?, ?, ?, ?)",
                    RESOURCES, BASE_ID, RESOURCES_NAME, BASE_CREATE_TIME, BASE_UPDATE_TIME, BASE_COMMENT);
        }
        return createSql;
    }
    
    private String getDeleteSql() {
        if (deleteSql == null) {
            deleteSql = MessageFormat.format("DELETE FROM {0} WHERE ID = ?", RESOURCES);
        }
        return deleteSql;
    }
    
    private String getUpdateSql() {
        if (updateSql == null) {
            updateSql = MessageFormat.format("UPDATE {0} SET {1} = ?, {2} = ?, {3} = ?, {4} = ? WHERE ID = ?",
                    RESOURCES, RESOURCES_NAME, BASE_CREATE_TIME, BASE_UPDATE_TIME, BASE_COMMENT);
        }
        return updateSql;
    }
    
    private String getSelectSql() {
        if (selectSql == null) {
            selectSql = MessageFormat.format("SELECT {0}, {1}, {2}, {3}, {4} FROM {5} WHERE 1 = 1",
                    BASE_ID, RESOURCES_NAME, BASE_CREATE_TIME, BASE_UPDATE_TIME, BASE_COMMENT, RESOURCES);
        }
        return selectSql;
    }
    
    private String getQueryByIdSql() {
        if (queryByIdSql == null) {
            StringBuilder sql = new StringBuilder(getSelectSql());
            sql.append(" AND id = ?");
            queryByIdSql = sql.toString();
        }
        return queryByIdSql;
    }
    
    private ResourceRowMapper getResourceRowMapper() {
        if (resourceRowMapper == null) {
            resourceRowMapper = new ResourceRowMapper();
        }
        return resourceRowMapper;
    }
    
    public static class ResourceRowMapper implements RowMapper<Resource> {
        @Override
        public Resource mapRow(ResultSet rs, int rowNum) throws SQLException {
            Resource resource = new Resource();
            resource.setId(rs.getString(BASE_ID));
            resource.setName(rs.getString(RESOURCES_NAME));
            resource.setCreateTime(rs.getDate(BASE_CREATE_TIME));
            resource.setUpdateTime(rs.getDate(BASE_UPDATE_TIME));
            resource.setComment(rs.getString(BASE_COMMENT));
            return resource;
        }
    }

}
