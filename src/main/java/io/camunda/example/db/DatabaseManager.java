package io.camunda.example.db;

/*import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import io.camunda.example.dto.MyConnectorRequest;

 */

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseManager {
/*
  private final HikariDataSource dataSource;

  public DatabaseManager(MyConnectorRequest connectorRequest) {
    HikariConfig config = new HikariConfig();
    config.setJdbcUrl( connectorRequest.jdbc().jdbcUrl() );
    config.setUsername( connectorRequest.authentication().userName() );
    config.setPassword( connectorRequest.authentication().password() );
    config.addDataSourceProperty( "cachePrepStmts" , "true" );
    config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
    config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
    dataSource = new HikariDataSource( config );
  }

  private Map<String, Object> getRow(ResultSet rs) throws SQLException {
    final Map<String, Object> row = new HashMap<>();
    int colCount = rs.getMetaData().getColumnCount();
    for (int i = 0; i < colCount; i++) {
      row.put(rs.getMetaData().getColumnName(i+1), rs.getObject(i+1));
    }
    return row;
  }

  private Map<Object, List<Map<String, Object>>> getMap(ResultSet rs, String mapKey) throws SQLException {
    final Map<Object, List<Map<String, Object>>> result = new HashMap<>();

    // find the column name to use as map key
    int colCount = rs.getMetaData().getColumnCount();
    int colNumber = -1;
    for (int i = 0; i < colCount; i++) {
      String colName = rs.getMetaData().getColumnName(i+1);
      if(colName.equals(mapKey)) {
        colNumber = i+1;
      }
    }

    while (rs.next()) {
      Object mapKeyVal = rs.getObject(colNumber);
      List<Map<String, Object>> existing = result.get(mapKeyVal);
      if(existing == null) {
        existing = new ArrayList<>();
      }
      existing.add(getRow(rs));
      result.put(mapKeyVal, existing);
    }
    return result;
  }

  private List<Map<String, Object>> getList(ResultSet rs) throws SQLException {
    final List<Map<String, Object>> result = new ArrayList<>();
    while (rs.next()) {
      result.add(getRow(rs));
    }
    return result;
  }

  public PreparedStatement prepareStatement(String statement, Map<Integer, Object> params) throws SQLException {
    Connection con = dataSource.getConnection();
    PreparedStatement pst = con.prepareStatement( statement );
    for(Integer paramNumber : params.keySet()) {
      Object paramValue = params.get(paramNumber);
      if (paramValue != null) {
        if (paramValue instanceof Date) {
          pst.setTimestamp(paramNumber, new Timestamp(((Date) paramValue).getTime()));
        } else if (paramValue instanceof Integer) {
          pst.setInt(paramNumber, (Integer) paramValue);
        } else if (paramValue instanceof Long) {
          pst.setLong(paramNumber, (Long) paramValue);
        } else if (paramValue instanceof Double) {
          pst.setDouble(paramNumber, (Double) paramValue);
        } else if (paramValue instanceof Float) {
          pst.setFloat(paramNumber, (Float) paramValue);
        } else {
          pst.setString(paramNumber, (String) paramValue);
        }
      }
    }
    return pst;
  }
  public Map<String, Object> selectOne(String statement, Map<Integer, Object> params) {
    if(params == null) {
      params = new HashMap<>();
    }
    try (PreparedStatement pst = prepareStatement(statement, params)) {
      ResultSet rs = pst.executeQuery();
      rs.next();
      return getRow(rs);
    } catch (SQLException e) {
      throw new IllegalStateException(e);
    }
  }

  public List<Map<String, Object>> selectList(String statement, Map<Integer, Object> params) {
    if(params == null) {
      params = new HashMap<>();
    }
    try (PreparedStatement pst = prepareStatement(statement, params)) {
      ResultSet rs = pst.executeQuery();
      return getList(rs);
    } catch (SQLException e) {
      throw new IllegalStateException(e);
    }
  }

  public Map<Object, List<Map<String, Object>>> selectMap(String statement, Map<Integer, Object> params, String mapKey) {
    if(params == null) {
      params = new HashMap<>();
    }
    try (PreparedStatement pst = prepareStatement(statement, params)) {
      ResultSet rs = pst.executeQuery();
      return getMap(rs, mapKey);
    } catch (SQLException e) {
      throw new IllegalStateException(e);
    }
  }

  public int update(String statement, Map<Integer, Object> params) {
    if(params == null) {
      params = new HashMap<>();
    }
    try (PreparedStatement pst = prepareStatement(statement, params)) {
      return pst.executeUpdate();
    } catch (SQLException e) {
      throw new IllegalStateException(e);
    }
  }

 */
}
