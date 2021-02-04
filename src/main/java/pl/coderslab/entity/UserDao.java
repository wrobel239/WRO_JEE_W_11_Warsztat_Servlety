package pl.coderslab.entity;

import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;
import java.util.Arrays;


public class UserDao {
    private static final String CREATE_USER_QUERY = "INSERT INTO users(email, username, password) values (?, ?, ?)";
    private static final String READ_USER_QUERY = "SELECT * FROM users where id=?";
    private static final String UPDATE_USER_QUERY = "UPDATE users SET email=?, username=?, password=? where id=?";
    private static final String UPDATE2_USER_QUERY = "UPDATE users SET id=?, email=?, username=?, password=?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM users";
    private static final String DELETE_USER_QUERY = "DELETE FROM users where id=?";

    public String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public User create (User user) throws SQLException{
        try (Connection conn = DBUtil.getConnection()) {
            PreparedStatement statement =conn.prepareStatement(CREATE_USER_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getUserName());
            statement.setString(3, hashPassword(user.getPassword()));
            statement.executeUpdate();
            ResultSet resultSet= statement.getGeneratedKeys();
            if (resultSet.next()){
                user.setId(resultSet.getInt(1));
            } return user;
        } catch (SQLException e){
            e.printStackTrace();
        } return null;
    }

    public void update (User user) throws SQLException{
        try (Connection conn = DBUtil.getConnection()){
            PreparedStatement statement =conn.prepareStatement(UPDATE_USER_QUERY);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getUserName());
            statement.setString(3, hashPassword(user.getPassword()));
            statement.setInt(4, user.getId());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public User read (int userId) throws SQLException{
        try (Connection conn = DBUtil.getConnection()){
            User user = new User(userId);
            PreparedStatement statement =conn.prepareStatement(READ_USER_QUERY);
            statement.setInt(1, userId);
            ResultSet rs =  statement.executeQuery();
            if (rs.next()){
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                return user;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public User[] findAll() throws SQLException{
        User[] users = new User[0];
        try (Connection conn = DBUtil.getConnection()){
            PreparedStatement statement =conn.prepareStatement(FIND_ALL_QUERY);
            ResultSet rs =  statement.executeQuery();
            while (rs.next()){
                User user = new User(0);
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                users=Arrays.copyOf(users, users.length +1);
                users[users.length-1]=user;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return users;
    }

    public void delete(int userId) throws SQLException{
        try (Connection conn = DBUtil.getConnection()){
            PreparedStatement statement =conn.prepareStatement(DELETE_USER_QUERY);
            statement.setInt(1, userId);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
