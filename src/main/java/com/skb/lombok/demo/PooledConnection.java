package com.skb.lombok.demo;

import lombok.experimental.Delegate;
import lombok.experimental.FieldDefaults;

import java.io.Closeable;
import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
public class PooledConnection implements Connection {

    private interface Fg{
        PreparedStatement prepareStatement(String sql)
                throws SQLException;
    }

    @Delegate(excludes = {Closeable.class,Fg.class})
    Connection connection;

    @Override
    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return null;
    }

    @Override
    public void close() {

    }
}
